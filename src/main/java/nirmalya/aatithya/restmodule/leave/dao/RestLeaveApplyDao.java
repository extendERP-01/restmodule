/**
 * Defines RestLeaveApplyDao DAO
 *
 */
package nirmalya.aatithya.restmodule.leave.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateLeaveApplyParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.leave.model.LeaveHistoryDetailsModel;
import nirmalya.aatithya.restmodule.leave.model.RestLeaveApplyModel;
import nirmalya.aatithya.restmodule.leave.model.RestLeaveEmpEntitleModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class RestLeaveApplyDao {

	Logger logger = LoggerFactory.getLogger(RestLeaveApplyDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	EntityManager em;

	/*
	 * for add other service price
	 */
	public ResponseEntity<JsonResponse<Object>> restAddLeave(List<RestLeaveApplyModel> restLeaveApplyModel) {

		logger.info("Method in Dao:restAddEmployeeEdu starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		for (RestLeaveApplyModel a : restLeaveApplyModel) {
			if (a.getEmpName() == null || a.getEmpName() == "") {
				resp.setMessage("Employee Name not Selected");
				validity = false;
			} else if (a.getlApplyDate() == null) {
				resp.setMessage("Apply Date Is not selected");
				validity = false;
			} else if (a.getLtypeName() == null || a.getLtypeName() == "") {
				resp.setMessage("Leave Type Is not selected");
				validity = false;
			} else if (a.getlApplyStartDate() == null || a.getlApplyStartDate() == "") {
				resp.setMessage("Select Leave Start Date.");
				validity = false;
			} else if (a.getlApplyEndDate() == null || a.getlApplyEndDate() == "") {
				resp.setMessage("Select Leave End Date.");
				validity = false;
			}

		}
		if (validity)
			try {

				String values = GenerateLeaveApplyParameter.getApplyLeaveParam(restLeaveApplyModel);

				if (restLeaveApplyModel.get(0).getApplyId() != null && restLeaveApplyModel.get(0).getApplyId() != "") {

					em.createNamedStoredProcedureQuery("leaveApplyRoutines")
							.setParameter("actionType", "modifyApplyLeave").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("leaveApplyRoutines")
							.setParameter("actionType", "addApplyLeaveM").setParameter("actionValue", values).execute();
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

		logger.info("Method in Dao:restAddEmployeeEdu ends");

		return response;
	}

	/*
	 * DAO Function to get getLeaveTypeName
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getLeaveType(String getLeaveType) {
		logger.info("Method : DAO getLeaveType starts");
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_leavetype=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveApplyRoutines")
					.setParameter("actionType", getLeaveType).setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModelConstructor = new DropDownModel(m[0], m[1]);
				dropDownModel.add(dropDownModelConstructor);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setBody(dropDownModel);

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : DAO getLeaveType ends");
		return response;
	}

	/*
	 * DAO Function to get getLeaveTypeName
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAvailLeave(String empId) {
		logger.info("Method : DAO getAvailLeave starts");
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_empId='" + empId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveApplyRoutines")
					.setParameter("actionType", "getAvailLeave").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModelConstructor = new DropDownModel(m[0], m[1].toString());
				dropDownModel.add(dropDownModelConstructor);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setBody(dropDownModel);

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : DAO getAvailLeave ends");
		return response;
	}

	/*
	 * DAO Function to View all Period data
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestLeaveApplyModel>>> getLApplyData(DataTableRequest request) {
		logger.info("Method : getLApplyData details starts");
		List<RestLeaveApplyModel> lapply = new ArrayList<RestLeaveApplyModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveApplyRoutines")
					.setParameter("actionType", "viewLApplied").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				Object startDate = null;
				if (m[2] != null) {
					startDate = DateFormatter.returnStringDate(m[2]);

				}

				RestLeaveApplyModel user = new RestLeaveApplyModel(m[0], m[1], startDate, m[3], m[4], null, null, null,
						null, null, m[5], m[6]);
				lapply.add(user);
			}
			if (x.get(0).length > 7) {
				BigInteger t = (BigInteger) x.get(0)[7];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestLeaveApplyModel>> resp = new JsonResponse<List<RestLeaveApplyModel>>();
		resp.setBody(lapply);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestLeaveApplyModel>>> response = new ResponseEntity<JsonResponse<List<RestLeaveApplyModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getLApplyData ends");
		return response;

	}

	/*
	 * DAO Function to View all leave data for approve
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestLeaveApplyModel>>> getLApplyDataApprove(DataTableRequest request) {
		logger.info("Method : getLApplyDataApprove details starts");
		List<RestLeaveApplyModel> lapply = new ArrayList<RestLeaveApplyModel>();
		String values = GenerateParameter.getSearchParam(request);
		System.out.println(values);
		Integer total = 0;
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveApplyRoutines")
					.setParameter("actionType", "viewLApprove").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				Object startDate = null;
				if (m[2] != null) {
					startDate = DateFormatter.returnStringDate(m[2]);

				}
				int newCurrentStageNo = 0;
				BigInteger currentStageNo = (BigInteger) x.get(0)[5];

				newCurrentStageNo = Integer.parseInt((currentStageNo.toString()));
				RestLeaveApplyModel user = new RestLeaveApplyModel(m[0], m[1], startDate, m[3], m[4], null, null, null,
						null, null, newCurrentStageNo, null);
				lapply.add(user);
			}
			if (x.get(0).length > 6) {
				BigInteger t = (BigInteger) x.get(0)[6];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestLeaveApplyModel>> resp = new JsonResponse<List<RestLeaveApplyModel>>();
		resp.setBody(lapply);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestLeaveApplyModel>>> response = new ResponseEntity<JsonResponse<List<RestLeaveApplyModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getLApplyDataApprove ends");
System.out.println(response);
		return response;

	}

	/*
	 * DAO Function to Cancel leave
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> cancelLeaveById(String id) {
		logger.info("Method : DAO cancelLeaveById starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_leaveId=" + id + ";";
			em.createNamedStoredProcedureQuery("leaveApplyRoutines").setParameter("actionType", "cancelLeaveById")
					.setParameter("actionValue", value).execute();
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
		logger.info("Method : DAO cancelLeaveById ends");
		return response;
	}

	/**
	 * Onchange Get Leave List
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestLeaveEmpEntitleModel>>> restGetLeaveList(
			List<RestLeaveEmpEntitleModel> table) {
		logger.info("Method :  RESTMODULE DAO  restGetLeaveList starts");
		List<RestLeaveEmpEntitleModel> List1 = new ArrayList<RestLeaveEmpEntitleModel>();
		JsonResponse<List<RestLeaveEmpEntitleModel>> resp = new JsonResponse<List<RestLeaveEmpEntitleModel>>();
		try {
			String values = GenerateLeaveApplyParameter.getsendParam(table);

			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveApplyRoutines")
					.setParameter("actionType", "getLeaveListOnChange").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {
				RestLeaveEmpEntitleModel RestLeaveEmpEntitleModel = new RestLeaveEmpEntitleModel(m[0], m[1], m[2], m[3],
						m[4], m[5], m[6], m[7], m[8], m[9]);
				List1.add(RestLeaveEmpEntitleModel);
			}
			resp.setBody(List1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestLeaveEmpEntitleModel>>> response = new ResponseEntity<JsonResponse<List<RestLeaveEmpEntitleModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : RESTMODULE restGetLeaveList ends");
		System.out.println("@@@"+response);
		
		return response;
	}

	/*
	 * DAO Function to get Leave period data by Id
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestLeaveApplyModel>>> getLeaveApplyById(String id, String action) {
		logger.info("Method : getLeaveApplyById starts");
		List<RestLeaveApplyModel> mt = new ArrayList<RestLeaveApplyModel>();
		JsonResponse<List<RestLeaveApplyModel>> resp = new JsonResponse<List<RestLeaveApplyModel>>();
		try {
			String value = "SET @p_leaveId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveApplyRoutines")
					.setParameter("actionType", action).setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object startDate = null;
				Object endDate = null;
				Object lday = null;
				if (m[2] != null) {
					lday = DateFormatter.returnStringDate(m[2]);

				}
				if (m[2] != null) {
					startDate = DateFormatter.returnStringDate(m[6]);
				}
				if (m[3] != null) {
					endDate = DateFormatter.returnStringDate(m[7]);
				}
				RestLeaveApplyModel table = new RestLeaveApplyModel(m[0], m[1], lday, m[3], m[4], m[5], startDate,
						endDate, m[8], m[9], null, null);
				mt.add(table);
			}
			resp.setBody(mt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestLeaveApplyModel>>> response = new ResponseEntity<JsonResponse<List<RestLeaveApplyModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getLeaveApplyById ends");
		return response;
	}

	/**
	 * DAO Function to save reimbursement Approval Action
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> saveLeaveApprovalAction(String id, String createdBy) {
		logger.info("Method : saveLeaveApprovalAction starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_leaveId='" + id + "',@p_createdBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("leaveApplyRoutines").setParameter("actionType", "forwardLeave")
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
		logger.info("Method : saveLeaveApprovalAction ends");
		return response;
	}

	/**
	 * DAO Function to save reimbursement Reject Action
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> saveLeaveRejectAction(String id, String createdBy, String desc,
			String rejectType) {
		logger.info("Method : saveLeaveRejectAction Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_leaveId='" + id + "',@p_rejectComment='" + desc + "',@p_createdBy='" + createdBy
					+ "';";

			String actionType = "";
			if (rejectType.equals("1"))
				actionType = "rejectLeave";
			else if (rejectType.equals("2"))
				actionType = "returnLeave";
			else
				actionType = "resubmitLeave";
			
			System.out.println(actionType);

			em.createNamedStoredProcedureQuery("leaveApplyRoutines").setParameter("actionType", actionType)
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
		logger.info("Method : saveLeaveRejectAction ends");
		return response;
	}

	/*
	 * for edit Traveling reimbursement
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<LeaveHistoryDetailsModel>>> getLeaveHistoryById(String id) {

		logger.info("Method in Dao: getLeaveHistoryById ends");

		List<LeaveHistoryDetailsModel> leaveHistoryDetailsModel = new ArrayList<LeaveHistoryDetailsModel>();

		try {

			String value = "SET @P_leaveId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveApplyRoutines")
					.setParameter("actionType", "viewLeaveHistory").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object oa = null;
				oa = DateFormatter.returnStringDate(m[0]);

				LeaveHistoryDetailsModel leave = new LeaveHistoryDetailsModel(oa, m[1], m[2], m[3], m[4], m[5]);

				leaveHistoryDetailsModel.add(leave);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<LeaveHistoryDetailsModel>> resp = new JsonResponse<List<LeaveHistoryDetailsModel>>();
		resp.setBody(leaveHistoryDetailsModel);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<LeaveHistoryDetailsModel>>> response = new ResponseEntity<JsonResponse<List<LeaveHistoryDetailsModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getLeaveHistoryById ends");

		return response;
	}

}
