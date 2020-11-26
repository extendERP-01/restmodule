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
import nirmalya.aatithya.restmodule.common.utils.GenerateGradeSalaryMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.RestGradeSalaryMasterModel;

@Repository
public class RestGradeSalaryMasterDao {
	Logger logger = LoggerFactory.getLogger(RestGradeSalaryMasterDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * Dropdown for grade name list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getGradeNameList() {

		logger.info("Method : getGradeNameList starts");

		List<DropDownModel> gradeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("gradeSalaryRoutines")
					.setParameter("actionType", "getGradeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				gradeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getGradeNameList ends");

		return gradeList;
	}

	/*
	 * Dropdown for components list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getComponentList() {

		logger.info("Method : getComponentList starts");

		List<DropDownModel> getComponentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("gradeSalaryRoutines")
					.setParameter("actionType", "getComponentList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getComponentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getComponentList ends");

		return getComponentList;
	}

	/*
	 * DAO Function to view particular Description for Grade
	 *
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getGradeDesc(String id) {
		logger.info("Method : getGradeDesc starts");
		List<DropDownModel> gradeDesc = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_grade='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("gradeSalaryRoutines")
					.setParameter("actionType", "getGradeDesc").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				gradeDesc.add(dropDownModel);
			}

			resp.setBody(gradeDesc);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getGradeDesc ends");

		return response;
	}

	/*
	 * DAO Function to view particular Component type for Selected Salary Component
	 *
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestGradeSalaryMasterModel>>> getComponentType(String id) {
		logger.info("Method : getComponentType starts");
		List<RestGradeSalaryMasterModel> componentType = new ArrayList<RestGradeSalaryMasterModel>();
		JsonResponse<List<RestGradeSalaryMasterModel>> resp = new JsonResponse<List<RestGradeSalaryMasterModel>>();
		String value = "SET @p_component='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("gradeSalaryRoutines")
					.setParameter("actionType", "componentType").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				RestGradeSalaryMasterModel dropDownModel = new RestGradeSalaryMasterModel(null, null, null, m[0], m[1],
						null, null, null, null, null, null, null);
				componentType.add(dropDownModel);
			}

			resp.setBody(componentType);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestGradeSalaryMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestGradeSalaryMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getComponentType ends");

		return response;
	}

	/**
	 * DAO Function to Add Grade Salary Master details
	 */
	public ResponseEntity<JsonResponse<Object>> addGradeSalaryMasterPost(
			List<RestGradeSalaryMasterModel> gradeSalaryMaster) {
		logger.info("Method : addKRAMeasureDetails starts");
		@SuppressWarnings("unused")
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (RestGradeSalaryMasterModel l : gradeSalaryMaster) {
			if (l.gettGradeId() == null || l.gettGradeId() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select a Pay Grade");
				break;

			} else if (l.gettSalaryComponent() == null || l.gettSalaryComponent() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please select Salary Component");
				break;

			} else if (l.gettCalculationType() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Calculation Type");
				break;
			} else if (l.gettAmount() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please Enter Amount");
				break;

			}
		}

		if (validation) {

			try {
				String value = GenerateGradeSalaryMasterParameter.addGradeSalaryParam(gradeSalaryMaster);

				if (gradeSalaryMaster.get(0).gettGrade() != "") {
					em.createNamedStoredProcedureQuery("gradeSalaryRoutines")
							.setParameter("actionType", "modifyGradeSalary").setParameter("actionValue", value)
							.execute();
					System.out.println("@@@" + gradeSalaryMaster.get(0).gettGradeId());
				} else {
					em.createNamedStoredProcedureQuery("gradeSalaryRoutines")
							.setParameter("actionType", "addGradeSalary").setParameter("actionValue", value).execute();

					System.out.println("###" + gradeSalaryMaster.get(0).gettGradeId());
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
	 * for all Grade Salary Master details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestGradeSalaryMasterModel>>> getGradeSalaryMasterDetails(
			DataTableRequest request) {

		logger.info("Method in Dao: getdepartmentDetails starts");

		List<RestGradeSalaryMasterModel> measureDetails = new ArrayList<RestGradeSalaryMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("gradeSalaryRoutines")
					.setParameter("actionType", "viewGradeSalary").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					RestGradeSalaryMasterModel measure = new RestGradeSalaryMasterModel(m[0], m[1], m[2], m[3], m[4],
							m[5], m[6], null, null, null, null, m[7]);
					measureDetails.add(measure);

				}

				if (x.get(0).length > 8) {
					BigInteger t = (BigInteger) x.get(0)[8];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestGradeSalaryMasterModel>> resp = new JsonResponse<List<RestGradeSalaryMasterModel>>();
		resp.setBody(measureDetails);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestGradeSalaryMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestGradeSalaryMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getdepartmentDetails ends");

		return response;
	}

	/*
	 * 
	 * Dao function for edit Grade Salary Master details
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestGradeSalaryMasterModel> editGradeSalaryMaster(String id) {
		logger.info("Method : editGradeSalaryMaster starts");

		List<RestGradeSalaryMasterModel> gradeSalaryMasterList = new ArrayList<RestGradeSalaryMasterModel>();

		String value = "SET @p_gradeId='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("gradeSalaryRoutines")
					.setParameter("actionType", "editGradeSalary").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestGradeSalaryMasterModel dropDownModel = new RestGradeSalaryMasterModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], null, null, m[7], m[8], m[9]);

				gradeSalaryMasterList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("gradeSalaryMasterList " + gradeSalaryMasterList);
		logger.info("Method : editGradeSalaryMaster ends");

		return gradeSalaryMasterList;
	}

	/**
	 * DAO - Get Grade Salary Master details For Modal
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestGradeSalaryMasterModel>>> modalGradeSalaryMaster(String id) {

		logger.info("Method in Dao: modalGradeSalaryMaster ends");

		List<RestGradeSalaryMasterModel> goalMasterList = new ArrayList<RestGradeSalaryMasterModel>();

		try {

			String value = "SET @p_gradeId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("gradeSalaryRoutines")
					.setParameter("actionType", "modelGradeSalaray").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestGradeSalaryMasterModel gradeSalaryMaster = new RestGradeSalaryMasterModel(m[0], m[1], m[2], m[3],
						m[4], m[5], m[6], null, null, m[7], m[8], null);

				goalMasterList.add(gradeSalaryMaster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestGradeSalaryMasterModel>> resp = new JsonResponse<List<RestGradeSalaryMasterModel>>();
		resp.setBody(goalMasterList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestGradeSalaryMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestGradeSalaryMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: modalGradeSalaryMaster ends");

		return response;
	}

}
