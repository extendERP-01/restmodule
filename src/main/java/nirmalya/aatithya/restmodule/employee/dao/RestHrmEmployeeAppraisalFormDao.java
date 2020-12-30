package nirmalya.aatithya.restmodule.employee.dao;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import nirmalya.aatithya.restmodule.common.utils.GenerateAppraisalFormParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateKRAMeasureDetailsParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeAppraisalFormListModel;
import nirmalya.aatithya.restmodule.employee.model.RestHrmsEmployeeAppraisalFormModel;
import nirmalya.aatithya.restmodule.employee.model.RestHrmsEmployeeAppraisalFormModel;
import nirmalya.aatithya.restmodule.employee.model.RestHrmsEmployeeAppraisalFormModel;

@Repository
public class RestHrmEmployeeAppraisalFormDao {
	Logger logger = LoggerFactory.getLogger(RestHrmEmployeeAppraisalFormDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for all employee details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrmsEmployeeAppraisalFormModel>>> getEmployeeAppraisalForm(
			DataTableRequest request) {

		logger.info("Method in Dao: getEmployeeAppraisalForm starts");
		if (request.getParam1() != "") {
			String param1 = request.getParam1();
			String data = DateFormatter.getStringDate(param1);
			request.setParam1(data);
		}
		if (request.getParam2() != "") {
			String param2 = request.getParam2();
			String data = DateFormatter.getStringDate(param2);
			request.setParam2(data);
		}

		List<RestHrmsEmployeeAppraisalFormModel> appraisalForm = new ArrayList<RestHrmsEmployeeAppraisalFormModel>();

		String values = GenerateParameter.getSearchParam(request);

		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeAppraisalDetails")
					.setParameter("actionType", "viewAppraisalList").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					Object fromDate = null;
					if (m[3] != null) {
						fromDate = DateFormatter.returnStringDate(m[3]);

					}
					Object toDate = null;
					if (m[4] != null) {
						toDate = DateFormatter.returnStringDate(m[4]);

					}

					RestHrmsEmployeeAppraisalFormModel jobTitle = new RestHrmsEmployeeAppraisalFormModel(m[0], m[1],
							m[2], null, null, fromDate, toDate, null, null, null, null, m[5], null, null, null, null,
							null, null, null, null);
					appraisalForm.add(jobTitle);

				}

				if (x.get(0).length > 6) {
					BigInteger t = (BigInteger) x.get(0)[6];

					total = Integer.parseInt((t.toString()));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrmsEmployeeAppraisalFormModel>> resp = new JsonResponse<List<RestHrmsEmployeeAppraisalFormModel>>();
		resp.setBody(appraisalForm);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestHrmsEmployeeAppraisalFormModel>>> response = new ResponseEntity<JsonResponse<List<RestHrmsEmployeeAppraisalFormModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getEmployeeAppraisalForm ends");

		return response;
	}

	/**
	 * DAO Function to Add KRAMeasure details
	 */

	public ResponseEntity<JsonResponse<Object>> submitAppraisalForm(
			List<RestHrmsEmployeeAppraisalFormModel> appraisalForm) {

		logger.info("Method : submitAppraisalForm starts");
		@SuppressWarnings("unused")
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (RestHrmsEmployeeAppraisalFormModel l : appraisalForm) {

			if (l.getAppraisalList().get(0).getSelfMarked() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please fill rating feild");
				break;

			}

		}

		if (validation) {

			try {

				String value = GenerateAppraisalFormParameter.submitAppraisalParam(appraisalForm);

				em.createNamedStoredProcedureQuery("EmployeeAppraisalDetails")
						.setParameter("actionType", "fillAppraisal").setParameter("actionValue", value).execute();

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
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public RestHrmsEmployeeAppraisalFormModel fillAppraisalForm(String id) {
		logger.info("Method : getAllPolicyCheck starts");
		RestHrmsEmployeeAppraisalFormModel form = new RestHrmsEmployeeAppraisalFormModel();
		try {

			String value = "SET @p_appId ='" + id + "';";
			System.out.println("value: "+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeAppraisalDetails")
					.setParameter("actionType", "fillForm").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object fromDate = null;
				if (m[5] != null) {
					fromDate = DateFormatter.returnStringDate(m[5]);

				}
				Object ToDate = null;
				if (m[6] != null) {
					ToDate = DateFormatter.returnStringDate(m[6]);

				}
				form = new RestHrmsEmployeeAppraisalFormModel(m[0], m[1], m[2], m[3], m[4], fromDate, ToDate, m[7],
						null, null, null, null, null, null, null, null, null, m[8], m[9], null);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return form;
	}

	/*
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<HrmsEmployeeAppraisalFormListModel> getChildData(String dept) {
		logger.info("Method : getChildData starts");
		List<HrmsEmployeeAppraisalFormListModel> form = new ArrayList<HrmsEmployeeAppraisalFormListModel>();
		try {
			String value = "SET @p_dept ='" + dept + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeAppraisalDetails")
					.setParameter("actionType", "chkList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				HrmsEmployeeAppraisalFormListModel policy = new HrmsEmployeeAppraisalFormListModel(m[0], m[1], m[2],
						null, m[3]);
				form.add(policy);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getChildData ends");

		return form;
	}

	/*
	 * DAO - Get Appraisal details For Modal
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrmsEmployeeAppraisalFormModel>>> employeeAppraisalModalView(
			String id) {

		logger.info("Method : employeeAppraisalModalView starts");

		List<RestHrmsEmployeeAppraisalFormModel> form = new ArrayList<RestHrmsEmployeeAppraisalFormModel>();
		JsonResponse<List<RestHrmsEmployeeAppraisalFormModel>> resp = new JsonResponse<List<RestHrmsEmployeeAppraisalFormModel>>();
		try {

			String value = "SET @p_appId='" + id + "';";
			System.out.println("value: "+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeAppraisalDetails")
					.setParameter("actionType", "modelAppraisal").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object fromDate = null;
				if (m[4] != null) {
					fromDate = DateFormatter.returnStringDate(m[4]);

				}
				Object ToDate = null;
				if (m[5] != null) {
					ToDate = DateFormatter.returnStringDate(m[5]);

				}
				RestHrmsEmployeeAppraisalFormModel measure = new RestHrmsEmployeeAppraisalFormModel(m[0], null, m[1],
						m[2], m[3], fromDate, ToDate, null, null, null, null, null, m[6], m[7], m[8], m[9], null, null,
						null, null);
				form.add(measure);
			}

			resp.setBody(form);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestHrmsEmployeeAppraisalFormModel>>> response = new ResponseEntity<JsonResponse<List<RestHrmsEmployeeAppraisalFormModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : employeeAppraisalModalView ends");

		return response;
	}

}
