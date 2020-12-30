package nirmalya.aatithya.restmodule.reimbursement.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateTravelingRequisitionParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.reimbursement.model.HrmsTravelingReqHistoryModel;
import nirmalya.aatithya.restmodule.reimbursement.model.HrmsTravelingRequisituionModel;

@Repository
public class HrmsTravelingRequisitionDao {
	Logger logger = LoggerFactory.getLogger(HrmsTravelingRequisitionDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for all TravelingRequisition details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsTravelingRequisituionModel>>> getTravelingRequisitionDetails(
			DataTableRequest request) {

		logger.info("Method in Dao: getTravelingRequisitionDetails starts");

		List<HrmsTravelingRequisituionModel> employementList = new ArrayList<HrmsTravelingRequisituionModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("TravelingRequisitionMaster")
					.setParameter("actionType", "viewTRequiTypeList").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object oa = null;
					Object ob = null;
					oa = DateFormatter.returnStringDate(m[1]);
					ob = DateFormatter.returnStringDate(m[2]);
					HrmsTravelingRequisituionModel employement = new HrmsTravelingRequisituionModel(m[0], oa, ob, m[3],
							m[4], m[5], m[6], m[7], null, null);
					employementList.add(employement);

				}

				if (x.get(0).length > 8) {
					BigInteger t = (BigInteger) x.get(0)[8];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsTravelingRequisituionModel>> resp = new JsonResponse<List<HrmsTravelingRequisituionModel>>();
		resp.setBody(employementList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsTravelingRequisituionModel>>> response = new ResponseEntity<JsonResponse<List<HrmsTravelingRequisituionModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getTravelingRequisitionDetails ends");

		return response;
	}

	/*
	 * for add new TravelingRequisition
	 */
	public ResponseEntity<JsonResponse<Object>> addTravelingRequisition(
			HrmsTravelingRequisituionModel TravelingRequisition) {

		logger.info("Method in Dao: addTravelingRequisition starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (TravelingRequisition.getPlaceName() == null || TravelingRequisition.getPlaceName() == "") {
			resp.setMessage("Traveling Place Name required");
			validity = false;
		} else if (TravelingRequisition.getPurpose() == null || TravelingRequisition.getPurpose() == "") {
			resp.setMessage("Traveling Requisition Perpose required");
			validity = false;
		} else if (TravelingRequisition.getFromDate() == null) {
			resp.setMessage("Traveling Requisition From Date required");
			validity = false;
		} else if (TravelingRequisition.getToDate() == null) {
			resp.setMessage("Traveling Requisition To Date required");
			validity = false;
		} else if (TravelingRequisition.getAdvanceNeed() == null) {
			resp.setMessage("Traveling Requisition Is Advance Needed required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateTravelingRequisitionParam.getAddtravelingReqParam(TravelingRequisition);
				if (TravelingRequisition.getReqId() != "") {
					em.createNamedStoredProcedureQuery("TravelingRequisitionMaster")
							.setParameter("actionType", "modifyTRequiType").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("TravelingRequisitionMaster")
							.setParameter("actionType", "addTRequiType").setParameter("actionValue", values).execute();
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

		logger.info("Method in Dao: addTravelingRequisition ends");

		return response;
	}

	/*
	 * for edit TravelingRequisition
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<HrmsTravelingRequisituionModel>> getTravelingRequisitionById(String id) {

		logger.info("Method in Dao: getTravelingRequisitionById ends");

		List<HrmsTravelingRequisituionModel> pTravelingRequisition = new ArrayList<HrmsTravelingRequisituionModel>();

		try {

			String value = "SET @P_reqId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("TravelingRequisitionMaster")
					.setParameter("actionType", "viewEditTRequiType").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object oa = null;
				Object ob = null;
				oa = DateFormatter.returnStringDate(m[1]);
				ob = DateFormatter.returnStringDate(m[2]);
				HrmsTravelingRequisituionModel TravelingRequisition = new HrmsTravelingRequisituionModel(m[0], oa, ob,
						m[3], m[4], m[5], m[6], m[7], m[8], null);

				pTravelingRequisition.add(TravelingRequisition);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<HrmsTravelingRequisituionModel> resp = new JsonResponse<HrmsTravelingRequisituionModel>();
		resp.setBody(pTravelingRequisition.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<HrmsTravelingRequisituionModel>> response = new ResponseEntity<JsonResponse<HrmsTravelingRequisituionModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getTravelingRequisitionById ends");

		return response;
	}

	/*
	 * for delete TravelingRequisition
	 */
	public ResponseEntity<JsonResponse<Object>> deleteTravelingRequisitionById(String id, String createdBy) {

		logger.info("Method in Dao: deleteTravelingRequisitionById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @P_reqId='" + id + "',@P_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("TravelingRequisitionMaster")
					.setParameter("actionType", "deleteTRequiType").setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
			String[] err = serverDao.errorProcedureCall(e);
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in Dao: deleteTravelingRequisitionById ends");

		return response;
	}

	/*
	 * for all TravelingRequisition details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsTravelingRequisituionModel>>> getTravelingRequisitionDetailsFirst(
			DataTableRequest request) {

		logger.info("Method in Dao: getTravelingRequisitionDetailsFirst starts");

		List<HrmsTravelingRequisituionModel> employementList = new ArrayList<HrmsTravelingRequisituionModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("TravelingRequisitionMaster")
					.setParameter("actionType", "viewTRequiFirstStage").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object oa = null;
					Object ob = null;
					oa = DateFormatter.returnStringDate(m[1]);
					ob = DateFormatter.returnStringDate(m[2]);
					HrmsTravelingRequisituionModel employement = new HrmsTravelingRequisituionModel(m[0], oa, ob, m[3],
							m[4], m[5], m[6], m[7], m[8], m[9]);
					employementList.add(employement);

				}

				if (x.get(0).length > 10) {
					BigInteger t = (BigInteger) x.get(0)[10];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsTravelingRequisituionModel>> resp = new JsonResponse<List<HrmsTravelingRequisituionModel>>();
		resp.setBody(employementList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsTravelingRequisituionModel>>> response = new ResponseEntity<JsonResponse<List<HrmsTravelingRequisituionModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getTravelingRequisitionDetailsFirst ends");

		return response;
	}

	/**
	 * DAO Function to save Requisition Approval Action
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> saveRequisitionApprovalAction(String id, String createdBy) {
		logger.info("Method : saveRequisitionApprovalAction starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_travelRequisition='" + id + "',@p_createdBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("TravelingRequisitionMaster")
					.setParameter("actionType", "forwardRequisition").setParameter("actionValue", value).execute();

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
		logger.info("Method : saveRequisitionApprovalAction ends");
		return response;
	}

	/**
	 * DAO Function to save Requisition Reject Action
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> saveRequisitionRejectAction(HrmsTravelingRequisituionModel reqobject) {
		logger.info("Method : saveRequisitionRejectActionDao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_travelRequisition='" + reqobject.getReqId() + "',@p_rejectComment='"
					+ reqobject.getReturnDesc() + "',@p_createdBy='" + reqobject.getCreatedBy() + "';";

			String actionType = "";
			if (reqobject.getRejectionType().equals("1"))
				actionType = "rejectRequisition";
			else if (reqobject.getRejectionType().equals("2"))
				actionType = "returnRequisition";
			else
				actionType = "resubmitRequisition";

			em.createNamedStoredProcedureQuery("TravelingRequisitionMaster").setParameter("actionType", actionType)
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
		logger.info("Method : saveRequisitionRejectActionDao ends");
		return response;
	}

	/*
	 * for edit TravelingRequisition
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsTravelingReqHistoryModel>>> getTravelingRequisitionHistoryById(
			String id) {

		logger.info("Method in Dao: getTravelingRequisitionHistoryById ends");

		List<HrmsTravelingReqHistoryModel> travelingRequisitionHistory = new ArrayList<HrmsTravelingReqHistoryModel>();

		try {

			String value = "SET @P_reqId='" + id + "';"; 
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("TravelingRequisitionMaster")
					.setParameter("actionType", "viewTRequiHistory").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object oa = null;
				oa = DateFormatter.returnStringDate(m[0]);

				HrmsTravelingReqHistoryModel TravelingRequisition = new HrmsTravelingReqHistoryModel(oa, m[1], m[2],
						m[3], m[4], m[5]);

				travelingRequisitionHistory.add(TravelingRequisition);
			}
			System.out.println(travelingRequisitionHistory);

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsTravelingReqHistoryModel>> resp = new JsonResponse<List<HrmsTravelingReqHistoryModel>>();
		resp.setBody(travelingRequisitionHistory);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<HrmsTravelingReqHistoryModel>>> response = new ResponseEntity<JsonResponse<List<HrmsTravelingReqHistoryModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getTravelingRequisitionHistoryById ends");

		return response;
	}

}
