package nirmalya.aatithya.restmodule.employee.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateEmployeeAppraisalDetailsParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.RestHrmEmployeeReviewerDetailsModel;

@Repository
public class RestHrmEmployeeReviewerDetailsDao {
	Logger logger = LoggerFactory.getLogger(RestHrmEmployeeReviewerDetailsDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * DAO Function for Auto Complete for search param
	 * 
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmployeeListAutoComplete(String id) {

		logger.info("Method : getEmployeeListAutoComplete Dao starts");

		List<DropDownModel> form = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			String value = "SET @p_tEmp='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeAppraisalDetails")
					.setParameter("actionType", "getEmpAutoSearch").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel paramStaff = new DropDownModel(m[0], m[1]);

				form.add(paramStaff);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resp.setBody(form);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getEmployeeListAutoComplete Dao ends");

		return response;
	}

	/*
	 * for Employee role list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmployeeRoleList() {

		logger.info("Method : getEmployeeRoleList starts");

		List<DropDownModel> roleList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeAppraisalDetails")
					.setParameter("actionType", "getRoleList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				roleList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getEmployeeRoleList ends");

		return roleList;
	}

	/*
	 * DAO Function to view particular job title name in dropDown
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmployeeNameAJAX(String id) {
		logger.info("Method : getEmployeeNameAJAX starts");
		List<DropDownModel> nameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_tReviewer='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeAppraisalDetails")
					.setParameter("actionType", "getEmployeeName").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				nameList.add(dropDownModel);
			}

			resp.setBody(nameList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getEmployeeNameAJAX ends");
		return response;
	}

	/*
	 * DAO Function to Add KRAMeasure details
	 */
	public ResponseEntity<JsonResponse<Object>> addEmployeeAppraisalDetails(
			List<RestHrmEmployeeReviewerDetailsModel> reviewerAssign) {
		logger.info("Method : addEmployeeAppraisalDetails starts");
		@SuppressWarnings("unused")
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (RestHrmEmployeeReviewerDetailsModel l : reviewerAssign) {
			if (l.gettEmployee() == null || l.gettEmployee() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please select Job Title");
				break;

			} else if (l.gettSetAuthorityTAT() == null || l.gettSetAuthorityTAT() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter  TAT");
				break;
			} else if (l.gettSetAuthorityNFA() == null || l.gettSetAuthorityNFA() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter NFA");
				break;
			} else if (l.gettAppraisalFrequency() == null || l.gettAppraisalFrequency() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Frequency");
				break;

			} else if (l.gettAppraisalDueDate() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Due Date");
				break;

			}
		}

		if (validation) {

			try {
				String value = GenerateEmployeeAppraisalDetailsParameter.addAppraisalDetailsParam(reviewerAssign);

				if (reviewerAssign.get(0).getIsedit() != null && reviewerAssign.get(0).getIsedit() != "") {

					em.createNamedStoredProcedureQuery("EmployeeAppraisalDetails")
							.setParameter("actionType", "modifyDetails").setParameter("actionValue", value).execute();

				} else {
					em.createNamedStoredProcedureQuery("EmployeeAppraisalDetails")
							.setParameter("actionType", "addAppraisalDetails").setParameter("actionValue", value)
							.execute();

				}
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
		logger.info("Method : addEmployeeAppraisalDetails ends");
		return response;
	}

	/*
	 * for all employee details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrmEmployeeReviewerDetailsModel>>> getEmployeereviewDetails(
			DataTableRequest request) {

		logger.info("Method in Dao: getEmployeeReviewDetails starts");

		List<RestHrmEmployeeReviewerDetailsModel> reviewerAssign = new ArrayList<RestHrmEmployeeReviewerDetailsModel>();
		String values = GenerateParameter.getSearchParam(request);

		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeAppraisalDetails")
					.setParameter("actionType", "viewAppraisalDetails").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					RestHrmEmployeeReviewerDetailsModel jobTitle = new RestHrmEmployeeReviewerDetailsModel(null, null,
							null, null, m[0], m[1], null, null, null, m[2], null, null, null, null);
					reviewerAssign.add(jobTitle);

				}

				if (x.get(0).length > 3) {
					BigInteger t = (BigInteger) x.get(0)[3];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrmEmployeeReviewerDetailsModel>> resp = new JsonResponse<List<RestHrmEmployeeReviewerDetailsModel>>();
		resp.setBody(reviewerAssign);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestHrmEmployeeReviewerDetailsModel>>> response = new ResponseEntity<JsonResponse<List<RestHrmEmployeeReviewerDetailsModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getEmployeeReviewDetails ends");

		return response;
	}

	/*
	 * for delete job title assigned
	 */
	public ResponseEntity<JsonResponse<Object>> deleteAppraisalDetails(String id) {

		logger.info("Method in Dao: deleteAppraisalDetails ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_tNFA='" + id + "';";

			em.createNamedStoredProcedureQuery("EmployeeAppraisalDetails").setParameter("actionType", "deleteDetails")
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

		logger.info("Method in Dao: deleteAppraisalDetails ends");

		return response;
	}

	/*
	 * DAO Function to view particular Guest Detail in model
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestHrmEmployeeReviewerDetailsModel>> viewAppraisalDetailsModel(String id) {
		logger.info("Method : viewAppraisalDetailsModel starts");
		List<RestHrmEmployeeReviewerDetailsModel> form = new ArrayList<RestHrmEmployeeReviewerDetailsModel>();
		try {

			String value = "SET @p_tNFA='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeAppraisalDetails")
					.setParameter("actionType", "appraisalModel").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				RestHrmEmployeeReviewerDetailsModel jobTitle = new RestHrmEmployeeReviewerDetailsModel(m[0], m[1], null,
						null, m[2], m[3], null, null, null, null, null, null, null, null);
				form.add(jobTitle);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<RestHrmEmployeeReviewerDetailsModel> resp = new JsonResponse<RestHrmEmployeeReviewerDetailsModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestHrmEmployeeReviewerDetailsModel>> response = new ResponseEntity<JsonResponse<RestHrmEmployeeReviewerDetailsModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : viewAppraisalDetailsModel ends");

		return response;
	}

	/*
	 * Edit Appraisal Details
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestHrmEmployeeReviewerDetailsModel> editAppraisalDetails(String id) {
		logger.info("Method : editAppraisalDetails starts");

		List<RestHrmEmployeeReviewerDetailsModel> reviewerAssignList = new ArrayList<RestHrmEmployeeReviewerDetailsModel>();

		String value = "SET @p_tNFA='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeAppraisalDetails")
					.setParameter("actionType", "editDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestHrmEmployeeReviewerDetailsModel dropDownModel = new RestHrmEmployeeReviewerDetailsModel(m[0], m[1],
						null, m[2], m[3], m[4], "5", null, m[5], null, m[6], m[7], null, null);
				reviewerAssignList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editAppraisalDetails ends");

		return reviewerAssignList;
	}

	/*
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmployeeName(String id) {
		logger.info("Method : getEmployeeName starts");
		List<DropDownModel> nameList = new ArrayList<DropDownModel>();

		String value = "SET @p_tReviewer='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeAppraisalDetails")
					.setParameter("actionType", "getEmployeeName").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				nameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getEmployeeName ends");
		return nameList;
	}

	/*
	 *  
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSelectedList(String id, String role) {
		logger.info("Method : getSelectedList starts");
		List<DropDownModel> nameList = new ArrayList<DropDownModel>();

		String value = "SET @p_role='" + role + "',@p_emplId='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeAppraisalDetails")
					.setParameter("actionType", "getSelectedList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				nameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getSelectedList ends");
		return nameList;
	}

	/*
	 * for Employee role list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAppraisalPolicyList() {

		logger.info("Method : getAppraisalPolicyList starts");

		List<DropDownModel> policy = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeAppraisalDetails")
					.setParameter("actionType", "policyList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				policy.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAppraisalPolicyList ends");

		return policy;
	}

	/*
	 * for Employee Financial Year List
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAppraisalFinancialYear() {

		logger.info("Method : getAppraisalFinancialYear starts");

		List<DropDownModel> financialYear = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeAppraisalDetails")
					.setParameter("actionType", "yearList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				financialYear.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAppraisalFinancialYear ends");

		return financialYear;
	}

	/*
	 * DAO Function to view particular FinancialFrom Date name in dropDown
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getFinancialFromDate(String id) {
		logger.info("Method : getFinancialFromDate starts");
		List<DropDownModel> fromDate = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_fYear='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeAppraisalDetails")
					.setParameter("actionType", "getFromDate").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object fDate = null;
				if (m[1] != null) {
					fDate = DateFormatter.returnStringDate(m[1]);

				}
				DropDownModel dropDownModel = new DropDownModel(m[0], fDate);
				fromDate.add(dropDownModel);
			}

			resp.setBody(fromDate);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getFinancialFromDate ends");
		return response;
	}

}
