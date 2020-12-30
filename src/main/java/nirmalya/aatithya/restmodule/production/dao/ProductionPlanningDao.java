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
import nirmalya.aatithya.restmodule.common.utils.GeneratePlanningParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.production.model.ProductionGradePlanningModel;
import nirmalya.aatithya.restmodule.production.model.ProductionPlanningModel;
import nirmalya.aatithya.restmodule.production.model.ProductionSummaryDetailsModel;

@Repository
public class ProductionPlanningDao {

	Logger logger = LoggerFactory.getLogger(ProductionPlanningDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * drop down for sale orders
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPlanDetails() {
		logger.info("Method in Dao: getPlanDetails  starts");
		List<DropDownModel> saleOdrerList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productionPlanningRoutines")
					.setParameter("actionType", "getSizeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				saleOdrerList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getPlanDetails ends");

		return saleOdrerList;
	}

	/*
	 * drop down for sale orders
	 */
	@SuppressWarnings("unchecked")
	public List<ProductionPlanningModel> getProductionDetails() {
		logger.info("Method in Dao: getProductionDetails  starts");

		List<ProductionPlanningModel> planningList = new ArrayList<ProductionPlanningModel>();
		List<DropDownModel> saleOdrerList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productionPlanningRoutines")
					.setParameter("actionType", "getSizeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				saleOdrerList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getProductionDetails ends");

		return planningList;
	}

	/*
	 * Drop down for job type list
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionPlanningModel>>> getProductionPlannaingDetails(String fromDate,
			String userId, String storeId) {

		logger.info("Method : getProductionPlannaingDetails starts");

		List<ProductionPlanningModel> planningList = new ArrayList<ProductionPlanningModel>();
		JsonResponse<List<ProductionPlanningModel>> resp = new JsonResponse<List<ProductionPlanningModel>>();

		try {
			if (fromDate != null) {
				fromDate = DateFormatter.getStringDate(fromDate);
			}
			String value = "SET @p_date='" + fromDate + "',@p_userId='" + userId + "',@p_storeId='" + storeId + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("productionPlanningRoutines")
					.setParameter("actionType", "getProdPlanDtls").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				ProductionPlanningModel data = new ProductionPlanningModel(null, null, null, m[0], m[1], m[2], null,
						null, null, null, null, null, null, null, null, m[3], null, null, null, null, null, null);
				planningList.add(data);
			}
			resp.setBody(planningList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<ProductionPlanningModel>>> response = new ResponseEntity<JsonResponse<List<ProductionPlanningModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getProductionPlannaingDetails ends");
		return response;
	}

	/*
	 * Drop down for job type list
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DropDownModel>> getProductionPlannaingBatch(String batchQty, String prodQty) {

		logger.info("Method : getProductionPlannaingDetails starts");

		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();

		try {
			String value = "SET @p_batchQty='" + batchQty + "',@p_prodQty='" + prodQty + "';";
			System.out.println("param value are " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("productionPlanningRoutines")
					.setParameter("actionType", "getProdBatchQty").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					DropDownModel data = new DropDownModel(m[0], m[1].toString());
					System.out.println("data rave" + data);
					resp.setBody(data);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(resp);
		ResponseEntity<JsonResponse<DropDownModel>> response = new ResponseEntity<JsonResponse<DropDownModel>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : getProductionPlannaingDetails ends");
		return response;
	}

	/*
	 * for add production planning
	 */
	public ResponseEntity<JsonResponse<Object>> restAddPlanning(List<ProductionPlanningModel> productionPlanningModel) {

		logger.info("Method in Dao: restAddPlanning starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String id = productionPlanningModel.get(0).getPpId();

		for (ProductionPlanningModel a : productionPlanningModel) {
			if (a.getFromDate() == null) {
				resp.setMessage("Start Date Is not selected");
				validity = false;
			} else if (a.getStoreId() == null) {
				resp.setMessage("Store Id not selected");
				validity = false;
			}

		}
		if (Boolean.TRUE.equals(validity))
			try {
				String values = GeneratePlanningParameter.getAddPlanningParam(productionPlanningModel);
				System.out.println("values " + values);
				if (id != null && !id.isEmpty()) {

					em.createNamedStoredProcedureQuery("productionPlanningRoutines")
							.setParameter("actionType", "modifyPlanning").setParameter("actionValue", values).execute();
				} else {

					em.createNamedStoredProcedureQuery("productionPlanningRoutines")
							.setParameter("actionType", "addPlanning").setParameter("actionValue", values).execute();

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

		logger.info("Method in Dao: restAddPlanning ends");

		return response;
	}

	/*
	 * for all planning details
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionPlanningModel>>> getPlanningDetails(DataTableRequest request) {

		logger.info("Method in Dao: getPlanningDetails starts");

		List<ProductionPlanningModel> employementList = new ArrayList<ProductionPlanningModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("productionPlanningRoutines")
					.setParameter("actionType", "getPlanningDetails").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					ProductionPlanningModel productionPlanningModel = new ProductionPlanningModel(m[0],
							DateFormatter.returnStringDate(m[1]), null, null, null, null, null, null, m[3], m[4], null,
							null, null, null, null, null, null, null, null, null, null, m[5]);
					employementList.add(productionPlanningModel);

				}

				if (x.get(0).length > 6) {
					BigInteger t = (BigInteger) x.get(0)[6];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ProductionPlanningModel>> resp = new JsonResponse<List<ProductionPlanningModel>>();
		resp.setBody(employementList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ProductionPlanningModel>>> response = new ResponseEntity<JsonResponse<List<ProductionPlanningModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getPlanningDetails ends");

		return response;
	}

	/*
	 * for modal view and edit also
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionPlanningModel>>> getPlanningById(String pId, String fromDate,
			String toDate) {

		logger.info("Method : getPlanningById starts");

		List<ProductionPlanningModel> assignEduList = new ArrayList<ProductionPlanningModel>();
		JsonResponse<List<ProductionPlanningModel>> resp = new JsonResponse<List<ProductionPlanningModel>>();

		try {

			String value = "SET @P_pId='" + pId + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate)
					+ "',@p_toDate='" + DateFormatter.getStringDate(toDate) + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("productionPlanningRoutines")
					.setParameter("actionType", "getPlanningById").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				/*
				 * if (m[1] != null) { startDate = DateFormatter.returnStringDate(m[1]); } if
				 * (m[2] != null) { startDate = DateFormatter.returnStringDate(m[2]); }
				 */
				ProductionPlanningModel hrmEmployeeEducationModel = new ProductionPlanningModel(m[0], m[1], m[2], m[3],
						m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], null, null, null, null,
						null, null, null);

				assignEduList.add(hrmEmployeeEducationModel);

			}

			resp.setBody(assignEduList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<ProductionPlanningModel>>> response = new ResponseEntity<JsonResponse<List<ProductionPlanningModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getPlanningById ends");
		return response;
	}

	/*
	 * for modal view and edit also
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionGradePlanningModel>>> getPlanningByIdAndGrade(String pId,
			String grade, String fromDate, String toDate) {

		logger.info("Method : getPlanningById starts");

		List<ProductionGradePlanningModel> assignEduList = new ArrayList<ProductionGradePlanningModel>();
		JsonResponse<List<ProductionGradePlanningModel>> resp = new JsonResponse<List<ProductionGradePlanningModel>>();

		try {

			String value = "SET @P_pId='" + pId + "',@P_gradeId='" + grade + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("productionPlanningRoutines")
					.setParameter("actionType", "getPlanningByIdAndGrade").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object startDate = null;
				Object endDate = null;
				/*
				 * if (m[1] != null) { startDate = DateFormatter.returnStringDate(m[1]); } if
				 * (m[2] != null) { startDate = DateFormatter.returnStringDate(m[2]); }
				 */
				ProductionGradePlanningModel hrmEmployeeEducationModel = new ProductionGradePlanningModel(m[0], m[1],
						m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10]);

				assignEduList.add(hrmEmployeeEducationModel);

			}

			resp.setBody(assignEduList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<ProductionGradePlanningModel>>> response = new ResponseEntity<JsonResponse<List<ProductionGradePlanningModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getPlanningById ends");
		return response;
	}

	/*
	 * for all planning details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionPlanningModel>>> getProductionPlanningApprovalData(
			DataTableRequest request) {

		logger.info("Method in Dao: getProductionPlanningApprovalData starts");

		List<ProductionPlanningModel> employementList = new ArrayList<ProductionPlanningModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("productionPlanningRoutines")
					.setParameter("actionType", "viewPlanningApprove").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					ProductionPlanningModel employement = new ProductionPlanningModel(m[0],
							DateFormatter.returnStringDate(m[1]), DateFormatter.returnStringDate(m[2]), null, null,
							null, null, null, m[3], m[4], null, m[5], ((BigInteger) m[6]).intValue(), null, null, null,
							null, null, null, null, null, null);
					employementList.add(employement);

				}
				if (x.get(0).length > 7) {
					BigInteger t = (BigInteger) x.get(0)[7];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ProductionPlanningModel>> resp = new JsonResponse<List<ProductionPlanningModel>>();
		resp.setBody(employementList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ProductionPlanningModel>>> response = new ResponseEntity<JsonResponse<List<ProductionPlanningModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getProductionPlanningApprovalData ends");

		return response;
	}

	/**
	 * DAO Function to save planning Approval Action
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> saveplanningApprovalAction(String id, String createdBy) {
		logger.info("Method : saveplanningApprovalAction starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_planning='" + id + "',@p_createdBy='" + createdBy + "';";
			System.out.println("value " + value);
			em.createNamedStoredProcedureQuery("productionPlanningRoutines")
					.setParameter("actionType", "forwardplanning").setParameter("actionValue", value).execute();

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method : saveplanningApprovalAction ends");
		return response;
	}

	/**
	 * DAO Function to save planning Reject Action
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> saveplanningRejectAction(String id, String createdBy, String desc,
			String rejectType) {
		logger.info("Method : saveplanningRejectActionDao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_planning='" + id + "',@p_rejectComment='" + desc + "',@p_createdBy='" + createdBy
					+ "';";
			String actionType = "";
			if (rejectType.equals("1"))
				actionType = "rejectPlanning";
			else if (rejectType.equals("2"))
				actionType = "returnPlanning";
			else
				actionType = "resubmitPlanning";
			em.createNamedStoredProcedureQuery("productionPlanningRoutines").setParameter("actionType", actionType)
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method : saveplanningRejectActionDao ends");
		return response;
	}

	/*
	 * Drop down for raw material list
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionPlanningModel>>> getRawMaterialDetails(String id) {

		logger.info("Method : getRawMaterialDetails starts");

		List<ProductionPlanningModel> planningList = new ArrayList<ProductionPlanningModel>();
		JsonResponse<List<ProductionPlanningModel>> resp = new JsonResponse<List<ProductionPlanningModel>>();

		try {

			String value = "SET @p_storeId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("productionPlanningRoutines")
					.setParameter("actionType", "getRawMaterialDetails").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				ProductionPlanningModel data = new ProductionPlanningModel(null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, m[0], null, m[1], m[2], m[3], m[4], null);
				planningList.add(data);
			}
			resp.setBody(planningList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<ProductionPlanningModel>>> response = new ResponseEntity<JsonResponse<List<ProductionPlanningModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getRawMaterialDetails ends");
		return response;
	}

	/*
	 * for add temp raw material data
	 */
	public ResponseEntity<JsonResponse<Object>> addRawMaterialDetails(String batchCode, String quantity, String storeId,
			String fromDate) {

		logger.info("Method in addRawMaterialDetails starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String values = "SET @p_batchCode='" + batchCode + "',@p_qty='" + quantity + "',@p_storeId='" + storeId
					+ "',@p_date='" + DateFormatter.getStringDate(fromDate) + "';";
			System.out.println("values afe  " + values);
			em.createNamedStoredProcedureQuery("productionPlanningRoutines").setParameter("actionType", "saveTempData")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method in Dao: addRawMaterialDetails ends");

		return response;
	}

	/*
	 * for save raw data
	 */
	public ResponseEntity<JsonResponse<Object>> saveRawData(List<ProductionPlanningModel> productionPlanningModel) {

		logger.info("Method in Dao : saveRawData starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String values = GeneratePlanningParameter.getRawDataParam(productionPlanningModel);

			em.createNamedStoredProcedureQuery("productionPlanningRoutines")
					.setParameter("actionType", "updateRawItemDtls").setParameter("actionValue", values).execute();

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

		logger.info("Method in Dao: saveRawData ends");

		return response;
	}

	/*
	 * for all item requisition report
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionSummaryDetailsModel>>> getPlanningRawMaterialDetails(
			DataTableRequest request) {

		logger.info("Method in Dao: getPlanningRawMaterialDetails report starts");

		List<ProductionSummaryDetailsModel> itemWiseReqModelList = new ArrayList<ProductionSummaryDetailsModel>();
		String param2 = request.getParam2();
		if (param2 != null && param2 != "") {
			request.setParam2(DateFormatter.getStringDate(param2));
		}
		String values = GenerateParameter.getSearchParam(request);
		System.out.println("values" + values);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("productionPlanningRoutines")
					.setParameter("actionType", "getProdRawMat").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[2] != null)
						date = DateFormatter.returnStringDate(m[2]);
					ProductionSummaryDetailsModel itemWiseReqModel = new ProductionSummaryDetailsModel(m[0], m[1], date,
							m[3], m[4], null, null);

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
		logger.info("Method in Dao: getPlanningRawMaterialDetails reports ends");

		return response;
	}

}
