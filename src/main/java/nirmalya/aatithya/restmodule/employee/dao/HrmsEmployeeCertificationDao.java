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
import nirmalya.aatithya.restmodule.common.utils.GenerateEmployeeCertificationParam;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeCertificationModel;

@Repository
public class HrmsEmployeeCertificationDao {
	Logger logger = LoggerFactory.getLogger(HrmsEmployeeCertificationDao.class);

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
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeecertificationAssign")
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
	public List<DropDownModel> getCertifList() {

		logger.info("Method : getCertifList starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeecertificationAssign")
					.setParameter("actionType", "getCertifList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCertifList ends");

		return employmentList;
	}

	/*
	 * for add certification
	 */
	public ResponseEntity<JsonResponse<Object>> restAddEmployeeCert(
			List<HrmsEmployeeCertificationModel> hrmsEmployeeCertificationModel) {

		logger.info("Method in Dao: restAddEmployeeCert starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String id = hrmsEmployeeCertificationModel.get(0).getEditId();

		for (HrmsEmployeeCertificationModel a : hrmsEmployeeCertificationModel) {
			if (a.getEmpId() == null || a.getEmpId() == "") {
				resp.setMessage("Employee Name not Selected");
				validity = false;
			} else if (a.getCertifId() == null || a.getCertifId() == "") {
				resp.setMessage(" Certification id not Selected");
				validity = false;
			} else if (a.getInsti() == null || a.getInsti() == "") {
				resp.setMessage(" Institution Can not be left blank");
				validity = false;
			} else if (a.getGrantDate() == null) {
				resp.setMessage("Grant Date Is not selected");
				validity = false;
			} else if (a.getValidDate() == null) {
				resp.setMessage("Valid Date Is not selected");
				validity = false;
			}

		}
		if (validity)
			try {
				String values = GenerateEmployeeCertificationParam
						.getAddEmployeeCertiParam(hrmsEmployeeCertificationModel);

				if (id != null && id != "") {

					em.createNamedStoredProcedureQuery("EmployeecertificationAssign")
							.setParameter("actionType", "modifyEmployeeCert").setParameter("actionValue", values)
							.execute();
				} else {

					em.createNamedStoredProcedureQuery("EmployeecertificationAssign")
							.setParameter("actionType", "addEmployeeCert").setParameter("actionValue", values)
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

		logger.info("Method in Dao: restAddEmployeeCert ends");

		return response;
	}

	/*
	 * for all assignSkill details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEmployeeCertificationModel>>> getAssignCertDetails(
			DataTableRequest request) {

		logger.info("Method in Dao: getAssignEduDetails starts");

		List<HrmsEmployeeCertificationModel> employementList = new ArrayList<HrmsEmployeeCertificationModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeecertificationAssign")
					.setParameter("actionType", "getAssignCertDetails").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					HrmsEmployeeCertificationModel employement = new HrmsEmployeeCertificationModel(m[0], null, null,
							null, null, m[1], null, m[2]);
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

		JsonResponse<List<HrmsEmployeeCertificationModel>> resp = new JsonResponse<List<HrmsEmployeeCertificationModel>>();
		resp.setBody(employementList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsEmployeeCertificationModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEmployeeCertificationModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getAssignEduDetails ends");

		return response;
	}

	/*
	 * for modal view and edit also
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEmployeeCertificationModel>>> getAssigncertificationById(String id) {

		logger.info("Method : getAssigncertificationById starts");

		List<HrmsEmployeeCertificationModel> assignEduList = new ArrayList<HrmsEmployeeCertificationModel>();
		JsonResponse<List<HrmsEmployeeCertificationModel>> resp = new JsonResponse<List<HrmsEmployeeCertificationModel>>();

		try {

			String value = "SET @P_empId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeecertificationAssign")
					.setParameter("actionType", "getAssignCertById").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object oa = null;
				Object ob = null;
				oa = DateFormatter.returnStringDate(m[3]);
				ob = DateFormatter.returnStringDate(m[4]);
				HrmsEmployeeCertificationModel HrmsEmployeeCertificationModel = new HrmsEmployeeCertificationModel(m[0],
						m[1], m[2], oa, ob, m[5], m[6], null);

				assignEduList.add(HrmsEmployeeCertificationModel);

			}

			resp.setBody(assignEduList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<HrmsEmployeeCertificationModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEmployeeCertificationModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getAssigncertificationById ends");

		return response;
	}

}
