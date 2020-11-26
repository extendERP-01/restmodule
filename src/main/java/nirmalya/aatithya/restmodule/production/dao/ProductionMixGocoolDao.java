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
import nirmalya.aatithya.restmodule.production.model.ProductionGoCoolModel;

@Repository
public class ProductionMixGocoolDao {

	Logger logger = LoggerFactory.getLogger(ProductionMixGocoolDao.class);
	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	private static final String PROCEDURE_NAME = "gocool-prod-add-mix";
	private static final String ACTION_TYPE = "actionType";
	private static final String ACTION_VALUE = "actionValue";

	/**
	 * for get production planning
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getProdPlanning() {
		logger.info("Method : DAO   getProdPlanning starts");

		List<DropDownModel> planList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "getProdPlanning").setParameter(ACTION_VALUE, "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[0]);
				planList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : DAO   getProdPlanning ends");
		return planList;
	}

	/**
	 * for get production planning
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPlant(String userId) {
		logger.info("Method : DAO   getPlant starts");

		List<DropDownModel> planList = new ArrayList<DropDownModel>();
		String value = "SET @p_userId='" + userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, "getPlant")
					.setParameter(ACTION_VALUE, value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				planList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : DAO   getPlant ends");
		return planList;
	}

	/*
	 * for get production item
	 */
	public ResponseEntity<JsonResponse<List<ProductionGoCoolModel>>> getProductionItem(String planId) {
		logger.info("Method : getProductionItem starts");
		List<ProductionGoCoolModel> prodItemList = new ArrayList<ProductionGoCoolModel>();
		JsonResponse<List<ProductionGoCoolModel>> resp = new JsonResponse<List<ProductionGoCoolModel>>();
		String value = "SET @p_planId='" + planId + "';";

		try {
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "getProductionItem").setParameter(ACTION_VALUE, value).getResultList();
			for (Object[] m : x) {
				ProductionGoCoolModel productionGoCoolModel = new ProductionGoCoolModel(null, null, null, m[0], m[1],
						null, null, null, null, null, null, null, null, null, null, null);
				prodItemList.add(productionGoCoolModel);
			}

			resp.setBody(prodItemList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<ProductionGoCoolModel>>> response = new ResponseEntity<JsonResponse<List<ProductionGoCoolModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getProductionItem ends");
		return response;
	}

	/*
	 * for get production item
	 */
	public ResponseEntity<JsonResponse<List<ProductionGoCoolModel>>> getBatchDetails(String planId, String storeId) {
		logger.info("Method : getBatchDetails starts");
		List<ProductionGoCoolModel> prodItemList = new ArrayList<ProductionGoCoolModel>();
		JsonResponse<List<ProductionGoCoolModel>> resp = new JsonResponse<List<ProductionGoCoolModel>>();
		String value = "SET @p_planId='" + planId + "',@p_storeId='" + storeId + "';";
		System.out.println(value);
		try {
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "getAllDetails").setParameter(ACTION_VALUE, value).getResultList();
			for (Object[] m : x) {
				ProductionGoCoolModel productionGoCoolModel = new ProductionGoCoolModel(null, m[0], m[1], m[2], m[3],
						m[4], null, null, null, null, null, null, null, null, null, null);
				prodItemList.add(productionGoCoolModel);
			}

			resp.setBody(prodItemList);
			System.out.println("prodItemList " + prodItemList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<ProductionGoCoolModel>>> response = new ResponseEntity<JsonResponse<List<ProductionGoCoolModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getBatchDetails ends");
		return response;
	}

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
				em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, "addProductionMix")
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
					.setParameter(ACTION_TYPE, "viewProdctionDetails").setParameter(ACTION_VALUE, values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					ProductionGoCoolModel motherCoil = new ProductionGoCoolModel(m[0], null, null, null, null, null,
							null,null,null,null,m[1], m[2], DateFormatter.returnStringDate(m[3]), null,m[4], null);

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
System.out.println(resp);
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getProdItemList() {
		logger.info("Method : DAO getProdItemList starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "getProdItem").setParameter(ACTION_VALUE, "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : DAO getProdPlanning ends");
		return itemList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionGoCoolModel>>> viewProductionMixId(String mplanId,
			String mBatchId) {

		logger.info("Method : viewProductionMixId starts");

		List<ProductionGoCoolModel> productionList = new ArrayList<ProductionGoCoolModel>();
		JsonResponse<List<ProductionGoCoolModel>> resp = new JsonResponse<List<ProductionGoCoolModel>>();

		try {

			String value = "SET @p_planId='" + mplanId + "',@p_prodId='" + mBatchId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "viewProductionById").setParameter(ACTION_VALUE, value)
					.getResultList();

			for (Object[] m : x) {

				ProductionGoCoolModel productionGoCoolModel = new ProductionGoCoolModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], null, m[9], m[10], DateFormatter.returnStringDate(m[11]),
						DateFormatter.returnStringDate(m[12]), m[13], m[14]);

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

		logger.info("Method : viewProductionMixId ends");

		return response;
	}

	/*
	 * for get production item
	 */
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPlanningsDetails(String storeId) {
		logger.info("Method : getPlanningsDetails starts");
		List<DropDownModel> prodItemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_storeId='" + storeId + "';";
		System.out.println(value);
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

}
