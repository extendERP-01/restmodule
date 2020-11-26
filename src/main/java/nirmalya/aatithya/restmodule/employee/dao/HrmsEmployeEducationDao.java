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
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateEmployeeEducationParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.HrmEmployeeEducationModel;



@Repository
public class HrmsEmployeEducationDao {
	Logger logger = LoggerFactory.getLogger(HrmsEmployeEducationDao.class);

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
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeEducationAssign")
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

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getQualifList() {

		logger.info("Method : getQualifList starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeEducationAssign")
					.setParameter("actionType", "getQualifList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getQualifList ends");

		return employmentList;
	}

	/*
	 * for add other service price
	 */
	public ResponseEntity<JsonResponse<Object>> restAddEmployeeEdu(
			List<HrmEmployeeEducationModel> hrmEmployeeEducationModel) {

		logger.info("Method in Dao:restAddEmployeeEdu starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String id = hrmEmployeeEducationModel.get(0).getEditId();

		for (HrmEmployeeEducationModel a : hrmEmployeeEducationModel) {
			if (a.getEmpId() == null || a.getEmpId() == "") {
				resp.setMessage("Employee Name not Selected");
				validity = false;
			} else if (a.getQualifId() == null || a.getQualifId() == "") {
				resp.setMessage(" Qualification id not Selected");
				validity = false;
			} else if (a.getStartDate() == null) {
				resp.setMessage("Start Date Is not selected");
				validity = false;
			} else if (a.getEndDate() == null) {
				resp.setMessage("End Date Is not selected");
				validity = false;
			}

		}
		if (validity)
			try {
				String values = GenerateEmployeeEducationParameter.getAddEmployeeEduParam(hrmEmployeeEducationModel);

				if (id != null && id != "") {

					em.createNamedStoredProcedureQuery("EmployeeEducationAssign")
							.setParameter("actionType", "modifyEmployeeEdu").setParameter("actionValue", values)
							.execute();
				} else {

					em.createNamedStoredProcedureQuery("EmployeeEducationAssign")
							.setParameter("actionType", "addEmployeeEdu").setParameter("actionValue", values).execute();

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
	 * for all employee education details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmEmployeeEducationModel>>> getAssignEduDetails(DataTableRequest request) {

		logger.info("Method in Dao: getAssignEduDetails starts");

		List<HrmEmployeeEducationModel> employementList = new ArrayList<HrmEmployeeEducationModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeEducationAssign")
					.setParameter("actionType", "getAssignEduDetails").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					HrmEmployeeEducationModel employement = new HrmEmployeeEducationModel(m[0], null, null, null, null,
							m[1], null, m[2]);
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

		JsonResponse<List<HrmEmployeeEducationModel>> resp = new JsonResponse<List<HrmEmployeeEducationModel>>();
		resp.setBody(employementList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmEmployeeEducationModel>>> response = new ResponseEntity<JsonResponse<List<HrmEmployeeEducationModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getAssignEduDetails ends");

		return response;
	}

	/*
	 * for modal view and edit also
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmEmployeeEducationModel>>> getAssignEducationById(String id) {

		logger.info("Method : getOtherServiceIdModal starts");

		List<HrmEmployeeEducationModel> assignEduList = new ArrayList<HrmEmployeeEducationModel>();
		JsonResponse<List<HrmEmployeeEducationModel>> resp = new JsonResponse<List<HrmEmployeeEducationModel>>();

		try {

			String value = "SET @P_empId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeEducationAssign")
					.setParameter("actionType", "getAssignEduById").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object oa = null;
				Object ob = null;
				oa = DateFormatter.returnStringDate(m[3]);
				ob = DateFormatter.returnStringDate(m[4]);
				HrmEmployeeEducationModel hrmEmployeeEducationModel = new HrmEmployeeEducationModel(m[0], m[1], m[2],
						oa, ob, m[5], m[6], null);

				assignEduList.add(hrmEmployeeEducationModel);

			}

			resp.setBody(assignEduList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<HrmEmployeeEducationModel>>> response = new ResponseEntity<JsonResponse<List<HrmEmployeeEducationModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getOtherServiceIdModal ends");

		return response;
	}
	

}
