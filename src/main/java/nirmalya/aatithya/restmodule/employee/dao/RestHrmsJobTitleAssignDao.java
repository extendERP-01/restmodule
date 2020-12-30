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
import nirmalya.aatithya.restmodule.common.utils.GenerateDepartmentJobTitleAssignParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.RestHrmsJobTitleAssignModel;

@Repository
public class RestHrmsJobTitleAssignDao {
	Logger logger = LoggerFactory.getLogger(RestHrmsJobTitleAssignDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * 
	 * @return Department list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepartmentList() {

		logger.info("Method : getDepartmentList starts");

		List<DropDownModel> deptList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("JobTitleAssign")
					.setParameter("actionType", "getDepartmentList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				deptList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDepartmentList ends");

		return deptList;
	}

	/*
	 * 
	 * @return job title list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDeptJobTitleList() {

		logger.info("Method : getDeptJobTitleList starts");

		List<DropDownModel> jobTitleList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("JobTitleAssign")
					.setParameter("actionType", "getJobTitleList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				jobTitleList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDeptJobTitleList ends");

		return jobTitleList;
	}

	/*
	 * for add new Department Job Title Assigned
	 */
	public ResponseEntity<JsonResponse<RestHrmsJobTitleAssignModel>> restAddDeptJobTitle(
			RestHrmsJobTitleAssignModel jobTitle) {

		logger.info("Method in Dao: restAddDeptJobTitle starts");

		Boolean validity = true;
		JsonResponse<RestHrmsJobTitleAssignModel> resp = new JsonResponse<RestHrmsJobTitleAssignModel>();
		resp.setMessage("");
		resp.setCode("");

		if (jobTitle.gettDeptAssignDesc() == null || jobTitle.gettDeptAssignDesc() == "") {
			resp.setMessage("Description required");
			validity = false;
		} else if (jobTitle.gettDeptAssignStatus() == null) {
			resp.setMessage("status required");
			validity = false;
		}

		if (validity) {
			try {

				String values = GenerateDepartmentJobTitleAssignParameter.getAddJobTitleParam(jobTitle);
				if (jobTitle.gettDepartment() == "" || jobTitle.gettDepartment() == null) {

					em.createNamedStoredProcedureQuery("JobTitleAssign").setParameter("actionType", "addJobTitleAssign")
							.setParameter("actionValue", values).execute();

				} else {

					em.createNamedStoredProcedureQuery("JobTitleAssign")
							.setParameter("actionType", "modifyJobTitleAssign").setParameter("actionValue", values)
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
		}
		ResponseEntity<JsonResponse<RestHrmsJobTitleAssignModel>> response = new ResponseEntity<JsonResponse<RestHrmsJobTitleAssignModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method in Dao: restAddDeptJobTitle ends");

		return response;
	}

	/*
	 * for all employee details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrmsJobTitleAssignModel>>> getDepartmentJobTitleAssignDetail(
			DataTableRequest request) {

		logger.info("Method in Dao: getDepartmentJobTitleAssignDetail starts");

		List<RestHrmsJobTitleAssignModel> jobTitleList = new ArrayList<RestHrmsJobTitleAssignModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("JobTitleAssign")
					.setParameter("actionType", "viewJobTitleList").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					RestHrmsJobTitleAssignModel jobTitle = new RestHrmsJobTitleAssignModel(m[0], m[1], m[2], m[3], null,
							m[4], m[5]);
					jobTitleList.add(jobTitle);

				}

				if (x.get(0).length > 6) {
					BigInteger t = (BigInteger) x.get(0)[6];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrmsJobTitleAssignModel>> resp = new JsonResponse<List<RestHrmsJobTitleAssignModel>>();
		resp.setBody(jobTitleList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestHrmsJobTitleAssignModel>>> response = new ResponseEntity<JsonResponse<List<RestHrmsJobTitleAssignModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getDepartmentJobTitleAssignDetail ends");

		return response;
	}

	/*
	 * for edit Department Job Title List Assigned
	 */

	@SuppressWarnings("unchecked")

	public ResponseEntity<JsonResponse<RestHrmsJobTitleAssignModel>> editJobTitle(String id) {

		logger.info("Method : editDetailsById starts");
		List<RestHrmsJobTitleAssignModel> form = new ArrayList<RestHrmsJobTitleAssignModel>();
		try {

			String value = "SET @p_tDept='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("JobTitleAssign")
					.setParameter("actionType", "editJobTitle").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestHrmsJobTitleAssignModel jobTitle = new RestHrmsJobTitleAssignModel(m[0], m[1], m[2], m[3], null,
						null, null);
				form.add(jobTitle);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<RestHrmsJobTitleAssignModel> resp = new JsonResponse<RestHrmsJobTitleAssignModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestHrmsJobTitleAssignModel>> response = new ResponseEntity<JsonResponse<RestHrmsJobTitleAssignModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : editDetailsById ends");

		return response;
	}

	/*
	 * for delete job title assigned
	 */
	public ResponseEntity<JsonResponse<Object>> deleteJobTitle(String id) {

		logger.info("Method in Dao: deleteJobTitle ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_tDept='" + id + "';";

			em.createNamedStoredProcedureQuery("JobTitleAssign").setParameter("actionType", "deleteJobTitle")
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

		logger.info("Method in Dao: deleteJobTitle ends");

		return response;
	}

	/*
	 * DAO Function to view particular Guest Detail in model
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestHrmsJobTitleAssignModel>> viewJobTitleModel(String id) {
		logger.info("Method : viewJobTitleModel starts");
		List<RestHrmsJobTitleAssignModel> form = new ArrayList<RestHrmsJobTitleAssignModel>();
		try {

			String value = "SET @p_tDept='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("JobTitleAssign")
					.setParameter("actionType", "viewJobTitleModel").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				RestHrmsJobTitleAssignModel jobTitle = new RestHrmsJobTitleAssignModel(m[0], m[1], m[2], m[3], null,
						null, null);
				form.add(jobTitle);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<RestHrmsJobTitleAssignModel> resp = new JsonResponse<RestHrmsJobTitleAssignModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestHrmsJobTitleAssignModel>> response = new ResponseEntity<JsonResponse<RestHrmsJobTitleAssignModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : viewJobTitleModel ends");

		return response;
	}

}
