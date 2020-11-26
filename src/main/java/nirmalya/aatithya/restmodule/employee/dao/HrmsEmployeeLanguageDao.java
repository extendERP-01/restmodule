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
import nirmalya.aatithya.restmodule.common.utils.GenerateEmployeeLanguageParam;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeLanguageModel;

@Repository
public class HrmsEmployeeLanguageDao {

	Logger logger = LoggerFactory.getLogger(HrmsEmployeeLanguageDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/**
	 * for Employee list
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmployeeList() {

		logger.info("Method : getEmployeeList starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeLanguageAssign")
					.setParameter("actionType", "getEmployeeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getEmployeeList ends");

		return employmentList;
	}

	/**
	 * for language list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getLangList() {

		logger.info("Method : getLangList starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeLanguageAssign")
					.setParameter("actionType", "getLangList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getLangList ends");

		return employmentList;
	}

	/**
	 * for how much he can do
	 */
	@SuppressWarnings("unchecked")

	public List<DropDownModel> getCanDo() {

		logger.info("Method : getCanDo starts");

		List<DropDownModel> canDoList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeLanguageAssign")
					.setParameter("actionType", "getCanDo").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				canDoList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCanDo ends");

		return canDoList;
	}

	/*
	 * for add other service price
	 */
	public ResponseEntity<JsonResponse<Object>> restAddEmployeeLang(
			List<HrmsEmployeeLanguageModel> hrmsEmployeeLanguageModel) {

		logger.info("Method in Dao: restAddEmployeeLang starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String id = hrmsEmployeeLanguageModel.get(0).getEditId();

		for (HrmsEmployeeLanguageModel a : hrmsEmployeeLanguageModel) {
			if (a.getEmpId() == null || a.getEmpId() == "") {
				resp.setMessage("Employee Name not Selected");
				validity = false;
			} else if (a.getLangId() == null || a.getLangId() == "") {
				resp.setMessage(" Language is not Selected");
				validity = false;
			} else if (a.getReadId() == null || a.getReadId() == "") {
				resp.setMessage("Can Read Is not selected");
				validity = false;
			} else if (a.getWriteId() == null || a.getWriteId() == "") {
				resp.setMessage("Can Write Is not selected");
				validity = false;
			} else if (a.getSpaekId() == null || a.getSpaekId() == "") {
				resp.setMessage("Can Spaek Is not selected");
				validity = false;
			}

		}
		if (validity)
			try {
				String values = GenerateEmployeeLanguageParam.getAddEmployeeLangParam(hrmsEmployeeLanguageModel);

				if (id != null && id != "") {

					em.createNamedStoredProcedureQuery("EmployeeLanguageAssign")
							.setParameter("actionType", "modifyEmployeeLang").setParameter("actionValue", values)
							.execute();
				} else {

					em.createNamedStoredProcedureQuery("EmployeeLanguageAssign")
							.setParameter("actionType", "addEmployeeLang").setParameter("actionValue", values)
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

		logger.info("Method in Dao: restAddEmployeeLang ends");

		return response;
	}

	/*
	 * for all assignSkill details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEmployeeLanguageModel>>> getAssignLangDetails(
			DataTableRequest request) {

		logger.info("Method in Dao: getAssignLangDetails starts");

		List<HrmsEmployeeLanguageModel> employementList = new ArrayList<HrmsEmployeeLanguageModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeLanguageAssign")
					.setParameter("actionType", "getAssignLangDetails").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					HrmsEmployeeLanguageModel employement = new HrmsEmployeeLanguageModel(m[0], null, null, null, null,
							m[1], null, null, null, null, m[2]);
					employementList.add(employement);

				}

				if (x.get(0).length > 3) {
					BigInteger t = (BigInteger) x.get(0)[3];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsEmployeeLanguageModel>> resp = new JsonResponse<List<HrmsEmployeeLanguageModel>>();
		resp.setBody(employementList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsEmployeeLanguageModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEmployeeLanguageModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getAssignLangDetails ends");

		return response;
	}

	/*
	 * for modal view and edit also
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEmployeeLanguageModel>>> getAssignLanguageById(String id) {

		logger.info("Method : getOtherServiceIdModal starts");

		List<HrmsEmployeeLanguageModel> assignEduList = new ArrayList<HrmsEmployeeLanguageModel>();
		JsonResponse<List<HrmsEmployeeLanguageModel>> resp = new JsonResponse<List<HrmsEmployeeLanguageModel>>();

		try {

			String value = "SET @P_empId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeLanguageAssign")
					.setParameter("actionType", "getAssignLangById").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				HrmsEmployeeLanguageModel HrmsEmployeeLanguageModel = new HrmsEmployeeLanguageModel(m[0], m[1], m[2],
						m[3], m[4], m[5], m[6], m[7], m[8], m[9], null);

				assignEduList.add(HrmsEmployeeLanguageModel);

			}

			resp.setBody(assignEduList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<HrmsEmployeeLanguageModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEmployeeLanguageModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getOtherServiceIdModal ends");

		return response;
	}

}
