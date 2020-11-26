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
import nirmalya.aatithya.restmodule.common.utils.GenerateProductReturnParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.production.model.ProductionGoCoolModel;
import nirmalya.aatithya.restmodule.production.model.ProductionReturnModel;

@Repository
public class ProductionReturnDao {

	Logger logger = LoggerFactory.getLogger(ProductionReturnDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	private static final String PROCEDURE_NAME = "production_return";
	private static final String ACTION_TYPE = "actionType";
	private static final String ACTION_VALUE = "actionValue";

	/*
	 * for get production item
	 */
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPlanningsDetails(String storeId) {
		logger.info("Method : getPlanningsDetails starts");
		List<DropDownModel> prodItemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_storeId='" + storeId + "';";
		try {
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "getPlanningsDetails").setParameter(ACTION_VALUE, value).getResultList();
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
	 * for add production planning
	 */
	public ResponseEntity<JsonResponse<Object>> addProductionReturn(List<ProductionReturnModel> productionReturnModel) {

		logger.info("Method in Dao: addProductionReturn starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String id = productionReturnModel.get(0).getReqnId();

		for (ProductionReturnModel a : productionReturnModel) {
			if (a.getStoreID() == null) {
				resp.setMessage("Store Is not selected");
				validity = false;
			} else if (a.getPlanId() == null) {
				resp.setMessage("Plan Id Is not selected");
				validity = false;
			}

		}
		if (Boolean.TRUE.equals(validity))
			try {
				String values = GenerateProductReturnParam.getAddReturnParam(productionReturnModel);
				System.out.println("values " + values);
				if (id != null && !id.isEmpty()) {

					em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, "modifyPlanning")
							.setParameter(ACTION_VALUE, values).execute();
				} else {

					em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, "addReturnDetails")
							.setParameter(ACTION_VALUE, values).execute();

				}
			} catch (Exception e) {
				e.printStackTrace();
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: addProductionReturn ends");

		return response;
	}

	/*
	 * for get production item
	 */
	public ResponseEntity<JsonResponse<List<ProductionGoCoolModel>>> getRawMaterialDetails(String planId,
			String storeId) {
		logger.info("Method : getRawMaterialDetails starts");
		List<ProductionGoCoolModel> prodItemList = new ArrayList<ProductionGoCoolModel>();
		JsonResponse<List<ProductionGoCoolModel>> resp = new JsonResponse<List<ProductionGoCoolModel>>();
		String value = "SET @p_planId='" + planId + "',@p_storeId='" + storeId + "';";
		System.out.println(value);
		try {
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "getRawMaterialDetails").setParameter(ACTION_VALUE, value)
					.getResultList();
			for (Object[] m : x) {
				ProductionGoCoolModel productionGoCoolModel = new ProductionGoCoolModel(null, null, null, null, null,
						null, m[0], m[1], m[2], null, null, null, null, null, null, null, m[3]);
				prodItemList.add(productionGoCoolModel);
			}

			resp.setBody(prodItemList);
			System.out.println("prodItemList " + prodItemList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<ProductionGoCoolModel>>> response = new ResponseEntity<JsonResponse<List<ProductionGoCoolModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getRawMaterialDetails ends");
		return response;
	}

	/*
	 * for all Mother Coil view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionReturnModel>>> viewProdctionsReturn(DataTableRequest request) {

		logger.info("Method in Dao: viewProdctionsReturn starts");

		List<ProductionReturnModel> getMCoil = new ArrayList<ProductionReturnModel>();
		try {
			if (!request.getParam2().isEmpty())
				request.setParam2(DateFormatter.getStringDate(request.getParam2()));
		} catch (Exception e) {
			logger.error("Can not Convert Date");
		}

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "viewProdctionsReturns").setParameter(ACTION_VALUE, values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[5] != null) {
						date = DateFormatter.returnStringDate(m[5]);
					}
					ProductionReturnModel motherCoil = new ProductionReturnModel(m[0], m[1], m[2], m[3], m[4], null,
							null, null, date);

					getMCoil.add(motherCoil);

				}

				if (x.get(0).length > 6) {
					BigInteger t = (BigInteger) x.get(0)[6];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ProductionReturnModel>> resp = new JsonResponse<List<ProductionReturnModel>>();
		resp.setBody(getMCoil);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ProductionReturnModel>>> response = new ResponseEntity<JsonResponse<List<ProductionReturnModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: viewProdctionsReturn ends");

		return response;
	}

	/*
	 * for modal view for production details
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionReturnModel>>> getProductionReturnModal(String id) {

		logger.info("Method : getProductionReturnModal starts");

		List<ProductionReturnModel> pipeList = new ArrayList<ProductionReturnModel>();
		JsonResponse<List<ProductionReturnModel>> resp = new JsonResponse<List<ProductionReturnModel>>();

		try {

			String value = "SET @p_returnId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "editProductionReturn").setParameter(ACTION_VALUE, value)
					.getResultList();

			for (Object[] m : x) {
				Object date = null;
				if (m[5] != null) {
					date = DateFormatter.returnStringDate(m[8]);
				}
				ProductionReturnModel pipe = new ProductionReturnModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						date);

				pipeList.add(pipe);

			}
			resp.setBody(pipeList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<ProductionReturnModel>>> response = new ResponseEntity<JsonResponse<List<ProductionReturnModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getProductionReturnModal ends");

		return response;
	}

}
