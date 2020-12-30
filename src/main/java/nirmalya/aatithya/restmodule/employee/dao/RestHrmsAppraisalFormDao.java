package nirmalya.aatithya.restmodule.employee.dao;

import java.math.BigDecimal;
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
import nirmalya.aatithya.restmodule.common.utils.GenerateAppraisalApprovalParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateAppraisalFormParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

import nirmalya.aatithya.restmodule.employee.model.HrmsAppraisalFormModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeAppraisalFormListModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsAppraisalFormModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsAppraisalFormModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsAppraisalFormModel;

@Repository
public class RestHrmsAppraisalFormDao {
	Logger logger = LoggerFactory.getLogger(RestHrmsAppraisalFormDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*************************************************************************************************************************************************/
	/****************************************
	 * DAO FOR MANAGER
	 ****************************************/
	/*************************************************************************************************************************************************/
	/*
	 * DAO FOR APPRAISAL FORM FIRST STAGE
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>> getManagerAppraisalForm(
			DataTableRequest request) {

		logger.info("Method in Dao: getEmployeeAppraisalForm starts");

		List<HrmsAppraisalFormModel> managerAppraisalForm = new ArrayList<HrmsAppraisalFormModel>();

		String values = GenerateParameter.getSearchParam(request);

		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("AppraisalFormApproval")
					.setParameter("actionType", "managerForm").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					Object toDate = null;
					if (m[4] != null) {
						toDate = DateFormatter.returnStringDate(m[4]);

					}
					Object fromDate = null;
					if (m[3] != null) {
						fromDate = DateFormatter.returnStringDate(m[3]);

					}

					HrmsAppraisalFormModel jobTitle = new HrmsAppraisalFormModel(m[0], m[1], m[2], null, null, fromDate,
							toDate, null, null, null, null, null, null, null, null, m[5], null, null, null, null, null,
							null, null, null, null, null);
					managerAppraisalForm.add(jobTitle);

				}

				if (x.get(0).length > 6) {
					BigInteger t = (BigInteger) x.get(0)[6];

					total = Integer.parseInt((t.toString()));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsAppraisalFormModel>> resp = new JsonResponse<List<HrmsAppraisalFormModel>>();
		resp.setBody(managerAppraisalForm);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>> response = new ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getEmployeeAppraisalForm ends");
		return response;
	}

	/*
	 * First Stage Approval
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>> appraisalFormManagerApproval(String id,
			String fromDate) {

		logger.info("Method : appraisalFormManagerApproval starts");

		List<HrmsAppraisalFormModel> managerAppraisalForm = new ArrayList<HrmsAppraisalFormModel>();
		JsonResponse<List<HrmsAppraisalFormModel>> resp = new JsonResponse<List<HrmsAppraisalFormModel>>();
		String Date = DateFormatter.getStringDate(fromDate);
		try {

			String value = "SET @p_appId='" + id + "',@p_fId='" + Date + "' ;";

			List<Object[]> x = em.createNamedStoredProcedureQuery("AppraisalFormApproval")
					.setParameter("actionType", "approvalForm1").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object fDate = null;
				if (m[5] != null) {
					fDate = DateFormatter.returnStringDate(m[5]);

				}
				Object toDate = null;
				if (m[6] != null) {
					toDate = DateFormatter.returnStringDate(m[6]);

				}
				Object dueDate = null;
				if (m[7] != null) {
					dueDate = DateFormatter.returnStringDate(m[7]);

				}
				HrmsAppraisalFormModel HrmsAppraisalFormModel = new HrmsAppraisalFormModel(m[0], m[1], m[2], m[3], m[4],
						fDate, toDate, dueDate, m[8], m[9], m[10], m[11], null, null, null, null, null, null, null,
						null, null, null, m[12], m[13], m[14], null);

				managerAppraisalForm.add(HrmsAppraisalFormModel);

			}
			resp.setBody(managerAppraisalForm);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>> response = new ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : appraisalFormManagerApproval ends");

		return response;
	}

	/*
	 * for First Stage Approval - Submit
	 */

	public ResponseEntity<JsonResponse<Object>> appraisalFormSubmit(List<HrmsAppraisalFormModel> managerAppraisalForm) {
		logger.info("Method : submitAppraisalForm starts");
		@SuppressWarnings("unused")
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validation) {

			try {

				String value = GenerateAppraisalApprovalParameter.appraisalApprovalParam(managerAppraisalForm);

				em.createNamedStoredProcedureQuery("AppraisalFormApproval")
						.setParameter("actionType", "appraisalApproval1").setParameter("actionValue", value).execute();

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
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : submitAppraisalForm ends");
		return response;
	}

	/*
	 * change appraisal setup status
	 */
	public ResponseEntity<JsonResponse<Object>> changeAppraisalSetupStatus(String id, String fdate) {
		logger.info("Method : DAO changeAppraisalSetupStatus starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String Date = DateFormatter.getStringDate(fdate);
		try {
			String value = "SET @p_appId='" + id + "',@p_fId='" + Date + "' ;";

			em.createNamedStoredProcedureQuery("AppraisalFormApproval").setParameter("actionType", "changeSetupStatus")
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

		logger.info("Method : DAO changeAppraisalSetupStatus ends");

		return response;
	}

	/**
	 * DAO - Get Appraisal details For Modal
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>> appraisalModalViewManager(String id) {

		logger.info("Method : employeeAppraisalModalView starts");

		List<HrmsAppraisalFormModel> form = new ArrayList<HrmsAppraisalFormModel>();
		JsonResponse<List<HrmsAppraisalFormModel>> resp = new JsonResponse<List<HrmsAppraisalFormModel>>();
		try {

			String value = "SET @p_appId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("AppraisalFormApproval")
					.setParameter("actionType", "modalViewManager").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object fromDate = null;
				if (m[5] != null) {
					fromDate = DateFormatter.returnStringDate(m[5]);

				}
				Object ToDate = null;
				if (m[6] != null) {
					ToDate = DateFormatter.returnStringDate(m[6]);

				}
				HrmsAppraisalFormModel measure = new HrmsAppraisalFormModel(m[0], m[1], m[2], m[3], m[4], fromDate,
						ToDate, null, m[7], m[8], m[9], m[10], m[11], null, null, null, m[12], null, null, null, null,
						null, null, null, null, null);
				form.add(measure);
			}

			resp.setBody(form);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>> response = new ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : employeeAppraisalModalView ends");

		return response;
	}

	/*************************************************************************************************************************************************/
	/****************************************
	 * DAO CONTROLLER FOR SUPER ADMIN
	 ****************************************/
	/*************************************************************************************************************************************************/
	/*
	 * DAO FOR APPRAISAL FORM SECOND STAGE
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>> getSuperAdminAppraisalForm(
			DataTableRequest request) {

		logger.info("Method in Dao: getSuperAdminAppraisalForm starts");

		List<HrmsAppraisalFormModel> adminAppraisalForm = new ArrayList<HrmsAppraisalFormModel>();

		String values = GenerateParameter.getSearchParam(request);

		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("AppraisalFormApproval")
					.setParameter("actionType", "adminForm").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					Object toDate = null;
					if (m[4] != null) {
						toDate = DateFormatter.returnStringDate(m[4]);

					}
					Object fromDate = null;
					if (m[3] != null) {
						fromDate = DateFormatter.returnStringDate(m[3]);

					}

					HrmsAppraisalFormModel jobTitle = new HrmsAppraisalFormModel(m[0], m[1], m[2], null, null, fromDate,
							toDate, null, null, null, null, null, null, null, m[5], m[6], null, null, null, null, m[7],
							m[8], null, null, null, null);
					adminAppraisalForm.add(jobTitle);

				}

				if (x.get(0).length > 9) {
					BigDecimal t = (BigDecimal) x.get(0)[9];

					total = Integer.parseInt((t.toString()));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsAppraisalFormModel>> resp = new JsonResponse<List<HrmsAppraisalFormModel>>();
		resp.setBody(adminAppraisalForm);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>> response = new ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getSuperAdminAppraisalForm ends");

		return response;
	}

	/*
	 * for Second Stage Approval
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>> appraisalFormAdminApproval(String id,
			String fromDate) {
		logger.info("Method : appraisalFormAdminApproval starts");
		String Date = DateFormatter.getStringDate(fromDate);
		List<HrmsAppraisalFormModel> adminAppraisalForm = new ArrayList<HrmsAppraisalFormModel>();
		JsonResponse<List<HrmsAppraisalFormModel>> resp = new JsonResponse<List<HrmsAppraisalFormModel>>();

		try {

			String value = "SET @p_appId='" + id + "',@p_fId='" + Date + "' ;";

			List<Object[]> x = em.createNamedStoredProcedureQuery("AppraisalFormApproval")
					.setParameter("actionType", "approvalForm2").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object fDate = null;
				if (m[5] != null) {
					fDate = DateFormatter.returnStringDate(m[5]);

				}
				Object toDate = null;
				if (m[6] != null) {
					toDate = DateFormatter.returnStringDate(m[6]);

				}
				Object dueDate = null;
				if (m[7] != null) {
					dueDate = DateFormatter.returnStringDate(m[7]);

				}
				HrmsAppraisalFormModel HrmsAppraisalFormModel = new HrmsAppraisalFormModel(m[0], m[1], m[2], m[3], m[4],
						fDate, toDate, dueDate, m[8], m[9], m[10], m[11], m[12], null, null, null, m[13], null, null,
						null, null, null, m[14], m[15], m[16], null);

				adminAppraisalForm.add(HrmsAppraisalFormModel);

			}
			resp.setBody(adminAppraisalForm);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>> response = new ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : appraisalFormAdminApproval ends");

		return response;
	}

	/*
	 * for Second Stage Approval - Submit
	 */
	public ResponseEntity<JsonResponse<Object>> appraisalFormAdminSubmit(
			List<HrmsAppraisalFormModel> adminAppraisalForm) {

		logger.info("Method : appraisalFormAdminSubmit starts");
		@SuppressWarnings("unused")
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validation) {

			try {

				String value = GenerateAppraisalApprovalParameter.appraisalAdminApprovalParam(adminAppraisalForm);

				em.createNamedStoredProcedureQuery("AppraisalFormApproval")
						.setParameter("actionType", "appraisalApproval2").setParameter("actionValue", value).execute();

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
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : appraisalFormAdminSubmit ends");
		return response;
	}

	/*
	 * for change appraisal status
	 */
	public ResponseEntity<JsonResponse<Object>> changeAppraisalStatus(String id) {
		logger.info("Method : DAO changeReservStatusById starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_appId='" + id + "';";

			em.createNamedStoredProcedureQuery("AppraisalFormApproval").setParameter("actionType", "changeAppStatus")
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

		logger.info("Method : DAO changeReservStatusById ends");

		return response;
	}

	/*
	 * Reject Appraisal-Super Admin
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> rejectAppraisalToManager(String id, String fdate) {
		logger.info("Method : DAO rejectAppraisalToManager starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String Date = DateFormatter.getStringDate(fdate);
		try {
			String value = "SET @p_appId='" + id + "',@p_fId='" + Date + "' ;";

			em.createNamedStoredProcedureQuery("AppraisalFormApproval").setParameter("actionType", "rejectToManager")
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

		logger.info("Method : DAO rejectAppraisalToManager ends");

		return response;
	}

	/*
	 * Resubmit Appraisal-Super Admin
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> resubmitAppraisal(String id, String fdate) {
		logger.info("Method : DAO resubmitAppraisal starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String Date = DateFormatter.getStringDate(fdate);
		try {
			String value = "SET @p_appId='" + id + "',@p_fId='" + Date + "' ;";

			em.createNamedStoredProcedureQuery("AppraisalFormApproval").setParameter("actionType", "resubmitAppraisal")
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
		System.out.println("response: "+response);
		logger.info("Method : DAO resubmitAppraisal ends");

		return response;
	}

	/*************************************************************************************************************************************************/
	/****************************************
	 * DAO CONTROLLER FOR COMMON USE
	 ****************************************/
	/*************************************************************************************************************************************************/

	/*
	 * DAO FOR APPRAISAL FORM - COMMON
	 * 
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>> getCommonAppraisalForm(DataTableRequest request) {

		logger.info("Method in Dao: getCommonAppraisalForm starts");

		List<HrmsAppraisalFormModel> commonAppraisalForm = new ArrayList<HrmsAppraisalFormModel>();

		String values = GenerateParameter.getSearchParam(request);

		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("AppraisalFormApproval")
					.setParameter("actionType", "commonForm").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					Object toDate = null;
					if (m[4] != null) {
						toDate = DateFormatter.returnStringDate(m[4]);

					}
					Object fromDate = null;
					if (m[3] != null) {
						fromDate = DateFormatter.returnStringDate(m[3]);

					}

					HrmsAppraisalFormModel jobTitle = new HrmsAppraisalFormModel(m[0], m[1], m[2], null, null, fromDate,
							toDate, null, null, null, null, null, null, null, m[5], m[6], null, null, null, null, m[7],
							m[8], null, null, null, null);
					commonAppraisalForm.add(jobTitle);

				}

				if (x.get(0).length > 9) {
					BigInteger t = (BigInteger) x.get(0)[9];

					total = Integer.parseInt((t.toString()));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsAppraisalFormModel>> resp = new JsonResponse<List<HrmsAppraisalFormModel>>();
		resp.setBody(commonAppraisalForm);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>> response = new ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getCommonAppraisalForm ends");

		return response;
	}

	/*
	 * for Second Stage Approval
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>> appraisalCommonForm(String id, String fromDate) {

		logger.info("Method : appraisalCommonForm starts");
		String Date = DateFormatter.getStringDate(fromDate);
		List<HrmsAppraisalFormModel> commonAppraisalForm = new ArrayList<HrmsAppraisalFormModel>();
		JsonResponse<List<HrmsAppraisalFormModel>> resp = new JsonResponse<List<HrmsAppraisalFormModel>>();

		try {

			String value = "SET @p_appId='" + id + "',@p_fId='" + Date + "' ;";

			List<Object[]> x = em.createNamedStoredProcedureQuery("AppraisalFormApproval")
					.setParameter("actionType", "CommonApproval").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object fDate = null;
				if (m[5] != null) {
					fDate = DateFormatter.returnStringDate(m[5]);

				}
				Object toDate = null;
				if (m[6] != null) {
					toDate = DateFormatter.returnStringDate(m[6]);

				}
				HrmsAppraisalFormModel HrmsAppraisalFormModel = new HrmsAppraisalFormModel(m[0], m[1], m[2], m[3], m[4],
						fDate, toDate, null, m[7], m[8], m[9], m[10], m[11], m[12], null, null, m[13], m[14], null,
						null, m[15], null, null, null, null, null);

				commonAppraisalForm.add(HrmsAppraisalFormModel);

			}
			resp.setBody(commonAppraisalForm);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>> response = new ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : appraisalCommonForm ends");

		return response;
	}

	/*
	 * for Common Comments - Submit
	 */
	public ResponseEntity<JsonResponse<Object>> appraisalFormCommonSubmit(
			List<HrmsAppraisalFormModel> commonAppraisalForm) {

		logger.info("Method : appraisalFormCommonSubmit starts");
		@SuppressWarnings("unused")
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validation) {

			try {

				String value = GenerateAppraisalApprovalParameter.appraisalCommonParam(commonAppraisalForm);

				em.createNamedStoredProcedureQuery("AppraisalFormApproval").setParameter("actionType", "commonComment")
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
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : appraisalFormCommonSubmit ends");

		return response;
	}

		/**
		 * DAO - Get Appraisal details For Modal of Super admin
		 *
		 */
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>> appraisalModalViewSuperAdmin(String id) {

			logger.info("Method : appraisalModalViewSuperAdmin starts");

			List<HrmsAppraisalFormModel> form = new ArrayList<HrmsAppraisalFormModel>();
			JsonResponse<List<HrmsAppraisalFormModel>> resp = new JsonResponse<List<HrmsAppraisalFormModel>>();
			try {

				String value = "SET @p_appId='" + id + "';";

				List<Object[]> x = em.createNamedStoredProcedureQuery("AppraisalFormApproval")
						.setParameter("actionType", "modalViewSuperAdmin").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					Object fromDate = null;
					if (m[5] != null) {
						fromDate = DateFormatter.returnStringDate(m[5]);

					}
					Object ToDate = null;
					if (m[6] != null) {
						ToDate = DateFormatter.returnStringDate(m[6]);

					}
					HrmsAppraisalFormModel measure = new HrmsAppraisalFormModel(m[0], m[1], m[2], m[3], m[4], fromDate,
							ToDate, null, m[7], m[8], m[9], m[10], m[11], m[12], null, null, m[13], m[14], null, null, null,
							null, null, null, null, null);
					form.add(measure);
				}

				resp.setBody(form);
			} catch (Exception e) {
				e.printStackTrace();
			}

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");

			ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>> response = new ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>>(
					resp, responseHeaders, HttpStatus.CREATED);

			logger.info("Method : appraisalModalViewSuperAdmin ends");
System.out.println("response"+response);
			return response;
		}


}
