package nirmalya.aatithya.restmodule.production.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateProductionMixParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.production.model.ItemWiseReqModel;
import nirmalya.aatithya.restmodule.production.model.ProductionGoCoolModel;
import nirmalya.aatithya.restmodule.production.model.ProductionSummaryDetailsModel;

@Repository
public class ProductionDao {
	Logger logger = LoggerFactory.getLogger(ProductionDao.class);
	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	private static final String PROCEDURE_NAME = "gocool_production";
	private static final String ACTION_TYPE = "actionType";
	private static final String ACTION_VALUE = "actionValue";

	/*
	 * for add production Mix
	 */
	public ResponseEntity<JsonResponse<Object>> addProductionMixPost(
			List<ProductionGoCoolModel> productionGoCoolModelList) {

		logger.info("Method in Dao: addProductionMixPost starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		for (ProductionGoCoolModel a : productionGoCoolModelList) {
			if (a.getPlanId() == null || a.getPlanId().isEmpty()) {
				resp.setMessage("Production Plan is required");
				validity = false;
			}

		}
		if (Boolean.TRUE.equals(validity))
			try {
				String values = GenerateProductionMixParameter.addProductionMixParam(productionGoCoolModelList);
				System.out.println(values);
				em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, "addProduction")
						.setParameter(ACTION_VALUE, values).execute();

			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);

					resp.setCode(err[0]);

				} catch (Exception e1) {
					resp.setMessage(e.getMessage());
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: addProductionMixPost ends");

		return response;
	}

	/*
	 * for all Mother Coil view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionGoCoolModel>>> viewProdctionMix(DataTableRequest request) {

		logger.info("Method in Dao: viewProdctionMix starts");

		List<ProductionGoCoolModel> getMCoil = new ArrayList<ProductionGoCoolModel>();
		try {
			if (!request.getParam3().isEmpty())
				request.setParam3(DateFormatter.getStringDate(request.getParam3()));

		} catch (Exception e) {
			logger.error("Can not Convert Date");
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "viewProdctionDetails").setParameter(ACTION_VALUE, values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					ProductionGoCoolModel motherCoil = new ProductionGoCoolModel(m[0], null, null, null, null, null,
							null, null, null, null, m[1], m[2], DateFormatter.returnStringDate(m[3]), null, m[4], null);

					getMCoil.add(motherCoil);

				}

				if (x.get(0).length > 5) {
					BigInteger t = (BigInteger) x.get(0)[5];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ProductionGoCoolModel>> resp = new JsonResponse<List<ProductionGoCoolModel>>();
		resp.setBody(getMCoil);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ProductionGoCoolModel>>> response = new ResponseEntity<JsonResponse<List<ProductionGoCoolModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: viewProdctionMix ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionGoCoolModel>>> viewProductionDetailsById(String mplanId,
			String mBatchId) {

		logger.info("Method : viewProductionDetailsById starts");

		List<ProductionGoCoolModel> productionList = new ArrayList<ProductionGoCoolModel>();
		JsonResponse<List<ProductionGoCoolModel>> resp = new JsonResponse<List<ProductionGoCoolModel>>();

		try {

			String value = "SET @p_planId='" + mplanId + "',@p_prodId='" + mBatchId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "viewProductionById").setParameter(ACTION_VALUE, value).getResultList();

			for (Object[] m : x) {

				ProductionGoCoolModel productionGoCoolModel = new ProductionGoCoolModel(m[0], null, null, m[1], m[2],
						m[3], null, null, null, null, m[4], m[5], DateFormatter.returnStringDate(m[6]), null, m[7],
						null);

				productionList.add(productionGoCoolModel);

			}
			resp.setBody(productionList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<ProductionGoCoolModel>>> response = new ResponseEntity<JsonResponse<List<ProductionGoCoolModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewProductionDetailsById ends");

		return response;
	}

	/*
	 * for all item requisition report
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ItemWiseReqModel>>> getRequisitionItems(DataTableRequest request) {

		logger.info("Method in Dao: getRequisitionItems report starts");

		List<ItemWiseReqModel> itemWiseReqModelList = new ArrayList<ItemWiseReqModel>();
		String param2 = request.getParam2();
		if (param2 != null && param2 != "") {
			request.setParam2(DateFormatter.getStringDate(param2));
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "getRequisitionItems").setParameter(ACTION_VALUE, values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[1] != null)
						date = DateFormatter.returnStringDate(m[1]);
					ItemWiseReqModel itemWiseReqModel = new ItemWiseReqModel(m[0], date, m[2], m[3], m[4], m[5], m[6],
							m[7], m[8], m[9], m[10], m[11], null);

					itemWiseReqModelList.add(itemWiseReqModel);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<ItemWiseReqModel>> resp = new JsonResponse<List<ItemWiseReqModel>>();
		resp.setBody(itemWiseReqModelList);
		resp.setTotal(total);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ItemWiseReqModel>>> response = new ResponseEntity<JsonResponse<List<ItemWiseReqModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getRequisitionItems reports ends");

		return response;
	}

	/*
	 * for all item requisition report
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ItemWiseReqModel>>> getSaleOrderItems(DataTableRequest request) {

		logger.info("Method in Dao: getSaleOrderItems report starts");

		List<ItemWiseReqModel> itemWiseReqModelList = new ArrayList<ItemWiseReqModel>();
		String param2 = request.getParam2();
		if (param2 != null && param2 != "") {
			request.setParam2(DateFormatter.getStringDate(param2));
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "getSaleOrderItems").setParameter(ACTION_VALUE, values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[1] != null)
						date = DateFormatter.returnStringDate(m[1]);
					ItemWiseReqModel itemWiseReqModel = new ItemWiseReqModel(m[0], date, m[2], null, null, null, null,
							null, null, null, null, null, m[3]);

					itemWiseReqModelList.add(itemWiseReqModel);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<ItemWiseReqModel>> resp = new JsonResponse<List<ItemWiseReqModel>>();
		resp.setBody(itemWiseReqModelList);
		resp.setTotal(total);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ItemWiseReqModel>>> response = new ResponseEntity<JsonResponse<List<ItemWiseReqModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getSaleOrderItems reports ends");

		return response;
	}

	/*
	 * for all item requisition report
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionSummaryDetailsModel>>> getProductionSummaryDetails(
			DataTableRequest request) {

		logger.info("Method in Dao: getProductionSummaryDetails report starts");

		List<ProductionSummaryDetailsModel> itemWiseReqModelList = new ArrayList<ProductionSummaryDetailsModel>();
		String param2 = request.getParam2();
		if (param2 != null && param2 != "") {
			request.setParam2(DateFormatter.getStringDate(param2));
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "getProdSummary").setParameter(ACTION_VALUE, values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[2] != null)
						date = DateFormatter.returnStringDate(m[2]);
					ProductionSummaryDetailsModel itemWiseReqModel = new ProductionSummaryDetailsModel(m[0], m[1], date,
							m[3], m[4], m[5], m[6]);

					itemWiseReqModelList.add(itemWiseReqModel);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<ProductionSummaryDetailsModel>> resp = new JsonResponse<List<ProductionSummaryDetailsModel>>();
		resp.setBody(itemWiseReqModelList);
		resp.setTotal(total);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ProductionSummaryDetailsModel>>> response = new ResponseEntity<JsonResponse<List<ProductionSummaryDetailsModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getProductionSummaryDetails reports ends");

		return response;
	}

	/*
	 * for get production item
	 */
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPlanningsDetailsAll(String storeId) {
		logger.info("Method : getPlanningsDetails starts");
		List<DropDownModel> prodItemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_storeId='" + storeId + "';";
		System.out.println(value);
		try {
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "getPlanningsDetailsAll").setParameter(ACTION_VALUE, value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel productionGoCoolModel = new DropDownModel(m[0], m[1]);
				prodItemList.add(productionGoCoolModel);
			}

			resp.setBody(prodItemList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getPlanningsDetails ends");
		return response;
	}

	/*
	 * for all item requisition report
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionSummaryDetailsModel>>> getProductionRawMaterialDetails(
			DataTableRequest request) {

		logger.info("Method in Dao: getProductionSummaryDetails report starts");

		List<ProductionSummaryDetailsModel> itemWiseReqModelList = new ArrayList<ProductionSummaryDetailsModel>();
		String param2 = request.getParam2();
		if (param2 != null && param2 != "") {
			request.setParam2(DateFormatter.getStringDate(param2));
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "getRawMatSummary").setParameter(ACTION_VALUE, values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					Object qty = null;
					if (m[2] != null)
						date = DateFormatter.returnStringDate(m[2]);
					if (m[5] != null)
						qty = Double.parseDouble(m[5].toString());
					ProductionSummaryDetailsModel itemWiseReqModel = new ProductionSummaryDetailsModel(m[0], m[1], date,
							m[3], m[4], null, qty);

					itemWiseReqModelList.add(itemWiseReqModel);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<ProductionSummaryDetailsModel>> resp = new JsonResponse<List<ProductionSummaryDetailsModel>>();
		resp.setBody(itemWiseReqModelList);
		resp.setTotal(total);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ProductionSummaryDetailsModel>>> response = new ResponseEntity<JsonResponse<List<ProductionSummaryDetailsModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getProductionSummaryDetails reports ends");

		return response;
	}

}
