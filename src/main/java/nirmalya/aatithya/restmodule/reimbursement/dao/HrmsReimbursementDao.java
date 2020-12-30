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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateReimbursementParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.reimbursement.model.HrmsReimbursementModel;
import nirmalya.aatithya.restmodule.reimbursement.model.HrmsTravelingReqHistoryModel;
import nirmalya.aatithya.restmodule.reimbursement.model.HrmsTravelingRequisituionModel;

@Repository
public class HrmsReimbursementDao {
	Logger logger = LoggerFactory.getLogger(HrmsReimbursementDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/**
	 * for reimbursement list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getReqList(String id) {

		logger.info("Method : getReqList starts");

		List<DropDownModel> requisitionList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_userId='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutines")
					.setParameter("actionType", "getReqList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				requisitionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getReqList ends");

		return requisitionList;
	}

	/**
	 * for reimbursement type list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getReimbTypeList() {

		logger.info("Method : getReimbTypeList starts");

		List<DropDownModel> reimTypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutines")
					.setParameter("actionType", "getReimbTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				reimTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getReimbTypeList ends");

		return reimTypeList;
	}

	/*
	 * for travel reimbursement list
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsTravelingRequisituionModel>>> getRrequisitionDtls(String travelReq) {

		logger.info("Method : getRrequisitionDtls starts");

		List<HrmsTravelingRequisituionModel> travelReqList = new ArrayList<HrmsTravelingRequisituionModel>();
		JsonResponse<List<HrmsTravelingRequisituionModel>> resp = new JsonResponse<List<HrmsTravelingRequisituionModel>>();

		try {
			String value = "SET @p_travelReqId='" + travelReq + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutines")
					.setParameter("actionType", "getRrequisitionDtls").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object oa = null;
				oa = DateFormatter.returnStringDate(m[1]);
				Object ob = null;
				ob = DateFormatter.returnStringDate(m[2]);
				HrmsTravelingRequisituionModel travelReqs = new HrmsTravelingRequisituionModel(m[0], oa, ob, m[3], m[4],
						m[5], m[6], m[7], m[8], null);
				travelReqList.add(travelReqs);
			}

			resp.setBody(travelReqList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<HrmsTravelingRequisituionModel>>> response = new ResponseEntity<JsonResponse<List<HrmsTravelingRequisituionModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getRrequisitionDtls ends");
		return response;
	}

	/*
	 * for add other service price
	 */
	public ResponseEntity<JsonResponse<Object>> restAddReimbursement(
			List<HrmsReimbursementModel> hrmsReimbursementModel) {

		logger.info("Method in Dao: restAddReimbursement starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String id = hrmsReimbursementModel.get(0).getEditId();

		for (HrmsReimbursementModel a : hrmsReimbursementModel) {
			if (a.getEmpId() == null || a.getEmpId() == "") {
				resp.setMessage("Employee Name not Selected");
				validity = false;
			} else if (a.getEmpId() == null || a.getEmpId() == "") {
				resp.setMessage(" Employee Id can not be left blank.");
				validity = false;
			} else if (a.getPlaceName() == null || a.getPlaceName() == "") {
				resp.setMessage("Place Name cann not be left blank");
				validity = false;
			} else if (a.getPurpose() == null || a.getPurpose() == "") {
				resp.setMessage("Perpose Can not be left blank");
				validity = false;
			} else if (a.getFromDate() == null || a.getFromDate() == "") {
				resp.setMessage("From Date Can not be left blank");
				validity = false;
			} else if (a.getToDate() == null || a.getToDate() == "") {
				resp.setMessage("To Date Can not be left blank");
				validity = false;
			}

		}
		if (validity)
			try {
				String values = GenerateReimbursementParameter.getAddReimbursementParam(hrmsReimbursementModel);
				
				System.out.println("####"+values);

				if (id != null && id != "") {

					em.createNamedStoredProcedureQuery("reimbursementRoutines")
							.setParameter("actionType", "modifyReimbursement").setParameter("actionValue", values)
							.execute();
				} else {

					em.createNamedStoredProcedureQuery("reimbursementRoutines")
							.setParameter("actionType", "addReimbursement").setParameter("actionValue", values)
							.execute();

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

		logger.info("Method in Dao: restAddReimbursement ends");

		return response;
	}

	/*
	 * for add other service price
	 */
	public ResponseEntity<JsonResponse<Object>> restAddOtherReimbursement(
			List<HrmsReimbursementModel> hrmsReimbursementModel) {

		logger.info("Method in Dao: restAddReimbursement starts");

		System.out.println("@@@@" + hrmsReimbursementModel);

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String id = hrmsReimbursementModel.get(0).getEditId();

		for (HrmsReimbursementModel a : hrmsReimbursementModel) {
			if (a.getEmpId() == null || a.getEmpId() == "") {
				resp.setMessage("Employee Name not Selected");
				validity = false;
			} else if (a.getEmpId() == null || a.getEmpId() == "") {
				resp.setMessage(" Employee Id can not be left blank.");
				validity = false;
			}
			/*
			 * else if (a.getPlaceName() == null || a.getPlaceName() == "") {
			 * resp.setMessage("Place Name cann not be left blank"); validity = false; }
			 */
			else if (a.getPurpose() == null || a.getPurpose() == "") {
				resp.setMessage("Perpose Can not be left blank");
				validity = false;
			} else if (a.getFromDate() == null || a.getFromDate() == "") {
				resp.setMessage("From Date Can not be left blank");
				validity = false;
			} else if (a.getToDate() == null || a.getToDate() == "") {
				resp.setMessage("To Date Can not be left blank");
				validity = false;
			}

		}
		if (validity)
			try {
				String values = GenerateReimbursementParameter.getAddReimbursementParam(hrmsReimbursementModel);

				if (id != null && id != "") {

					em.createNamedStoredProcedureQuery("reimbursementRoutines")
							.setParameter("actionType", "modifyReimbursement").setParameter("actionValue", values)
							.execute();
				} else {

					em.createNamedStoredProcedureQuery("reimbursementRoutines")
							.setParameter("actionType", "addReimbursement").setParameter("actionValue", values)
							.execute();

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

		logger.info("Method in Dao: restAddReimbursement ends");

		return response;
	}

	/*
	 * for all assignSkill details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsReimbursementModel>>> getReimbursementDetails(
			DataTableRequest request) {

		logger.info("Method in Dao: getAssignEduDetails starts");

		List<HrmsReimbursementModel> reimbursementList = new ArrayList<HrmsReimbursementModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			
			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutines")
					.setParameter("actionType", "getAllReimDetails").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object oa = null;
					oa = DateFormatter.returnStringDate(m[3]);
					Object ob = null;
					ob = DateFormatter.returnStringDate(m[4]);

					HrmsReimbursementModel employement = new HrmsReimbursementModel(m[0], m[1], null, null, null, null,
							null, null, m[2], oa, ob, m[5], m[6], null, m[7], m[8], m[9], m[10], m[11], null, null,
							null, m[12]);
					reimbursementList.add(employement);
				}

				if (x.get(0).length > 13) {
					BigInteger t = (BigInteger) x.get(0)[13];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsReimbursementModel>> resp = new JsonResponse<List<HrmsReimbursementModel>>();
		resp.setBody(reimbursementList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsReimbursementModel>>> response = new ResponseEntity<JsonResponse<List<HrmsReimbursementModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getAssignEduDetails ends");
		System.out.println("$$$"+response);

		return response;
	}

	/*
	 * for modal view and edit also
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsReimbursementModel>>> getReimbusementById(String reimId) {

		logger.info("Method : getReimbusementById starts");

		List<HrmsReimbursementModel> reimbursementList = new ArrayList<HrmsReimbursementModel>();
		JsonResponse<List<HrmsReimbursementModel>> resp = new JsonResponse<List<HrmsReimbursementModel>>();

		try {

			String value = "SET @p_reimId='" + reimId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutines")
					.setParameter("actionType", "getReimById").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object oa = null;
				Object ob = null;
				Object oc = null;
				oa = DateFormatter.returnStringDate(m[2]);
				ob = DateFormatter.returnStringDate(m[9]);
				oc = DateFormatter.returnStringDate(m[10]);
				HrmsReimbursementModel hrmEmployeeEducationModel = new HrmsReimbursementModel(m[0], m[1], oa, m[3],
						m[4], m[5], m[6], m[7], m[8], ob, oc, m[11], m[12], m[13], m[14], m[15], m[16], null, null,
						null, m[17], m[18], m[19]);

				reimbursementList.add(hrmEmployeeEducationModel);

			}

			resp.setBody(reimbursementList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<HrmsReimbursementModel>>> response = new ResponseEntity<JsonResponse<List<HrmsReimbursementModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getReimbusementById ends");

		return response;
	}

	/*
	 * for all Traveling reimbursement details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsReimbursementModel>>> getTravelingreimbursementDetailsFirst(
			DataTableRequest request) {

		logger.info("Method in Dao: getTravelingreimbursementDetailsFirst starts");

		List<HrmsReimbursementModel> employementList = new ArrayList<HrmsReimbursementModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutines")
					.setParameter("actionType", "viewReimApprove").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					Object ob = null;
					Object oc = null;

					ob = DateFormatter.returnStringDate(m[3]);
					oc = DateFormatter.returnStringDate(m[4]);
					HrmsReimbursementModel employement = new HrmsReimbursementModel(m[0], m[1], null, null, null, null,
							null, null, m[2], ob, oc, m[5], m[6], null, m[7], m[8], m[9], m[10], m[11], m[12], null,
							null, m[13]);
					employementList.add(employement);

				}
				if (x.get(0).length > 14) {
					BigInteger t = (BigInteger) x.get(0)[14];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsReimbursementModel>> resp = new JsonResponse<List<HrmsReimbursementModel>>();
		resp.setBody(employementList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsReimbursementModel>>> response = new ResponseEntity<JsonResponse<List<HrmsReimbursementModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getTravelingreimbursementDetailsFirst ends");

		return response;
	}

	/**
	 * DAO Function to save reimbursement Approval Action
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> savereimbursementApprovalAction(String id, String createdBy) {
		logger.info("Method : savereimbursementApprovalAction starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_travelreimbursement='" + id + "',@p_createdBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("reimbursementRoutines")
					.setParameter("actionType", "forwardreimbursement").setParameter("actionValue", value).execute();

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
		logger.info("Method : savereimbursementApprovalAction ends");
		return response;
	}

	/**
	 * DAO Function to save reimbursement Reject Action
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> savereimbursementRejectAction(String id, String createdBy, String desc,
			String rejectType) {
		logger.info("Method : savereimbursementRejectActionDao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_travelreimbursement='" + id + "',@p_rejectComment='" + desc + "',@p_createdBy='"
					+ createdBy + "';";
			String actionType = "";
			if (rejectType.equals("1"))
				actionType = "rejectreim";
			else if (rejectType.equals("2"))
				actionType = "returnreim";
			else
				actionType = "resubmitreim";

			em.createNamedStoredProcedureQuery("reimbursementRoutines").setParameter("actionType", actionType)
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
		logger.info("Method : savereimbursementRejectActionDao ends");
		return response;
	}

	/*
	 * for edit Traveling reimbursement
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsTravelingReqHistoryModel>>> getTravelingreimbursementHistoryById(
			String id) {

		logger.info("Method in Dao: getTravelingreimbursementHistoryById ends");

		List<HrmsTravelingReqHistoryModel> travelingreimbursementHistory = new ArrayList<HrmsTravelingReqHistoryModel>();

		try {

			String value = "SET @P_reimId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutines")
					.setParameter("actionType", "viewTRequiHistory").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object oa = null;
				oa = DateFormatter.returnStringDate(m[0]);

				HrmsTravelingReqHistoryModel Travelingreimbursement = new HrmsTravelingReqHistoryModel(oa, m[1], m[2],
						m[3], m[4], m[5]);

				travelingreimbursementHistory.add(Travelingreimbursement);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsTravelingReqHistoryModel>> resp = new JsonResponse<List<HrmsTravelingReqHistoryModel>>();
		resp.setBody(travelingreimbursementHistory);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<HrmsTravelingReqHistoryModel>>> response = new ResponseEntity<JsonResponse<List<HrmsTravelingReqHistoryModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getTravelingreimbursementHistoryById ends");

		return response;
	}

	/*
	 * for validate policy amount
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getValidPolicy(String policyId, String empId) {

		logger.info("Method : getValidPolicy starts");

		List<DropDownModel> validList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_policyId='" + policyId + "',@p_empId='" + empId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutines")
					.setParameter("actionType", "getValidPolicy").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				String amnt = m[0].toString();
				DropDownModel travelReqs = new DropDownModel(amnt, m[1]);
				validList.add(travelReqs);
			}
			resp.setBody(validList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getValidPolicy ends");
		return response;
	}

	/*
	 * for policy list on reimbursement on change
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPolicyReimbOnchange(String reimType, String empId) {

		logger.info("Method : getPolicyReimbOnchange starts");

		List<DropDownModel> travelReqList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_reimTypeId='" + reimType + "',@p_empId='" + empId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutines")
					.setParameter("actionType", "getPolicy").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel travelReqs = new DropDownModel(m[0], m[1]);
				travelReqList.add(travelReqs);
			}
			resp.setBody(travelReqList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getPolicyReimbOnchange ends");
		return response;
	}

	/**
	 * for policy list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPolicyList(String reimbType) {

		logger.info("Method : getPolicyList starts");

		List<DropDownModel> policyList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_reimTypeId='" + reimbType + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutines")
					.setParameter("actionType", "getPolicy").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				policyList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getPolicyList ends");

		return policyList;
	}

	/**
	 * for reimbursement list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmployeeList1() {

		logger.info("Method : getEmployeeList1 starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutines")
					.setParameter("actionType", "getEmployeeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getEmployeeList1 ends");

		return employmentList;
	}
}
