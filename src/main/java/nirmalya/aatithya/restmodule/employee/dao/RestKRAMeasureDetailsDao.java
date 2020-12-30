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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateKRAMeasureDetailsParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.RestKRAMeasureDetailsModel;
import nirmalya.aatithya.restmodule.employee.model.RestKRAMeasureDetailsModel;

@Repository
public class RestKRAMeasureDetailsDao {
	Logger logger = LoggerFactory.getLogger(RestKRAMeasureDetailsDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for department list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDeptNameList() {

		logger.info("Method : getDeptNameList starts");

		List<DropDownModel> deptName = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("KRAMeasureRoutine")
					.setParameter("actionType", "getDepartmentList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				deptName.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDeptNameList ends");

		return deptName;
	}

	/*
	 * for goal list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getGoalNameList() {

		logger.info("Method : getGoalNameList starts");

		List<DropDownModel> deptName = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("KRAMeasureRoutine")
					.setParameter("actionType", "getGoalNameList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				deptName.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getGoalNameList ends");

		return deptName;
	}

	/*
	 * DAO Function to view particular job title name in dropDown
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getJobTitleName(String id) {
		logger.info("Method : getJobTitleName starts");
		List<DropDownModel> jobTitleList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_kDept='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("KRAMeasureRoutine")
					.setParameter("actionType", "getJobTitleName").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				jobTitleList.add(dropDownModel);
			}

			resp.setBody(jobTitleList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getJobTitleName ends");
		return response;
	}

	/**
	 * DAO Function to Add KRAMeasure details
	 */
	public ResponseEntity<JsonResponse<Object>> addKRAMeasureDetails(List<RestKRAMeasureDetailsModel> measureDetails) {
		logger.info("Method : addKRAMeasureDetails starts");
		@SuppressWarnings("unused")
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (RestKRAMeasureDetailsModel l : measureDetails) {
			if (l.getkDepartment() == null || l.getkDepartment() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Department Name");
				break;

			} else if (l.getkJobTitle() == null || l.getkJobTitle() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please select Job Title");
				break;

			} else if (l.getkMeasure() == null || l.getkMeasure() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter  KRA Measure");
				break;
			} else if (l.getkTarget() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please Enter Target");
				break;

			}
		}

		if (validation) {

			try {
				String value = GenerateKRAMeasureDetailsParameter.addKraMrasureParam(measureDetails);

				if (measureDetails.get(0).getIsedit() != null && measureDetails.get(0).getIsedit() != "") {
					em.createNamedStoredProcedureQuery("KRAMeasureRoutine")
							.setParameter("actionType", "modifyKraMeasure").setParameter("actionValue", value)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("KRAMeasureRoutine").setParameter("actionType", "addKraMeasure")
							.setParameter("actionValue", value).execute();
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
		logger.info("Method : addKRAMeasureDetails ends");
		return response;
	}

	/*
	 * for all KRAMeasure details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestKRAMeasureDetailsModel>>> viewKRAMeasureDetails(
			DataTableRequest request) {

		logger.info("Method in Dao: getdepartmentDetails starts");

		List<RestKRAMeasureDetailsModel> measureDetails = new ArrayList<RestKRAMeasureDetailsModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("KRAMeasureRoutine")
					.setParameter("actionType", "viewKRAMeasure").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					RestKRAMeasureDetailsModel measure = new RestKRAMeasureDetailsModel(m[0], m[1], m[2], m[3], m[4],
							null, m[5], m[6]);
					measureDetails.add(measure);

				}

				if (x.get(0).length > 7) {
					BigInteger t = (BigInteger) x.get(0)[7];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestKRAMeasureDetailsModel>> resp = new JsonResponse<List<RestKRAMeasureDetailsModel>>();
		resp.setBody(measureDetails);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestKRAMeasureDetailsModel>>> response = new ResponseEntity<JsonResponse<List<RestKRAMeasureDetailsModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getdepartmentDetails ends");

		return response;
	}

	/*
	 * 
	 * Dao function for edit KRAMeasure details
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestKRAMeasureDetailsModel> editKRAMeasureDetails(String deptId, String jobId) {
		logger.info("Method : editKRAMeasureDetails starts");
		// String newdate = DateFormatter.getStringDate(assnDate);
		List<RestKRAMeasureDetailsModel> measureDetailsList = new ArrayList<RestKRAMeasureDetailsModel>();

		String value = "SET @p_deptId='" + deptId + "',@p_jobId='" + jobId + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("KRAMeasureRoutine")
					.setParameter("actionType", "editKRAMeasure").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestKRAMeasureDetailsModel dropDownModel = new RestKRAMeasureDetailsModel(m[0], m[1], m[2], m[3], m[4],
						"sonu", null, null);

				measureDetailsList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editKRAMeasureDetails ends");

		return measureDetailsList;
	}

	/**
	 * DAO Function to view particular job title in dropDown
	 *
	 */

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getJobTitle(String id) {
		logger.info("Method : getJobTitle starts");
		List<DropDownModel> getJobTitle = new ArrayList<DropDownModel>();
		String value = "SET @p_kDept='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("KRAMeasureRoutine")
					.setParameter("actionType", "getJobTitleName").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getJobTitle.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getJobTitle ends");
		return getJobTitle;
	}

	/**
	 * DAO - Get KRAMeasure details For Modal
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestKRAMeasureDetailsModel>>> modalKRAMeasureDetails(String deptId,
			String jobId) {

		logger.info("Method : getBeautyChairStaffAssignDao starts");

		List<RestKRAMeasureDetailsModel> form = new ArrayList<RestKRAMeasureDetailsModel>();
		JsonResponse<List<RestKRAMeasureDetailsModel>> resp = new JsonResponse<List<RestKRAMeasureDetailsModel>>();
		try {

			String value = "SET @p_deptId='" + deptId + "',@p_jobId='" + jobId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("KRAMeasureRoutine")
					.setParameter("actionType", "modelKRAMeasure").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestKRAMeasureDetailsModel measure = new RestKRAMeasureDetailsModel(m[0], m[1], m[2], m[3], m[4], null,
						null, null);
				form.add(measure);
			}

			resp.setBody(form);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestKRAMeasureDetailsModel>>> response = new ResponseEntity<JsonResponse<List<RestKRAMeasureDetailsModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getBeautyChairStaffAssignDao ends");

		return response;
	}

}
