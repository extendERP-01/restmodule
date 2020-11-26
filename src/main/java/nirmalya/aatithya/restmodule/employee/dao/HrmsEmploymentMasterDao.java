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
import nirmalya.aatithya.restmodule.common.utils.GenerateEmploymentParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmploymentMasterModel;

@Repository
public class HrmsEmploymentMasterDao {
	Logger logger = LoggerFactory.getLogger(HrmsEmploymentMasterDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for all employment details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEmploymentMasterModel>>> getemploymentDetails(DataTableRequest request) {

		logger.info("Method in Dao: getemploymentDetails starts");

		List<HrmsEmploymentMasterModel> employementList = new ArrayList<HrmsEmploymentMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("EmploymentMaster")
					.setParameter("actionType", "viewEmploymentList").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					HrmsEmploymentMasterModel employement = new HrmsEmploymentMasterModel(m[0], m[1], m[2], m[3]);
					employementList.add(employement);

				}

				if (x.get(0).length >4) {
					BigInteger t = (BigInteger) x.get(0)[4];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsEmploymentMasterModel>> resp = new JsonResponse<List<HrmsEmploymentMasterModel>>();
		resp.setBody(employementList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsEmploymentMasterModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEmploymentMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getemploymentDetails ends");

		return response;
	}

	/*
	 * for add new employment
	 */
	public ResponseEntity<JsonResponse<Object>> addemployment(HrmsEmploymentMasterModel employment) {

		logger.info("Method in Dao: addemployment starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (employment.getEmploymentName() == null || employment.getEmploymentName() == "") {
			resp.setMessage("Employment Name required");
			validity = false;
		} else if (employment.getEmploymentDesc() == null || employment.getEmploymentDesc() == "") {
			resp.setMessage("Employment description required");
			validity = false;
		} else if (employment.getEmploymentStatus() == null) {
			resp.setMessage("Employment active required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateEmploymentParameter.getAddEmploymentParam(employment);
				if (employment.getEmploymentId() != "") {
					em.createNamedStoredProcedureQuery("EmploymentMaster").setParameter("actionType", "modifyemployment")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("EmploymentMaster").setParameter("actionType", "addEmployment")
							.setParameter("actionValue", values).execute();
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

		logger.info("Method in Dao: addemployment ends");

		return response;
	}

	/*
	 * for edit employment
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<HrmsEmploymentMasterModel>>getEmploymentById(String id) {

		logger.info("Method in Dao: getemploymentById ends");

		List<HrmsEmploymentMasterModel> pemployment = new ArrayList<HrmsEmploymentMasterModel>();

		try {

			String value = "SET @P_EMPLId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("EmploymentMaster")
					.setParameter("actionType", "viewEditemployment").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				HrmsEmploymentMasterModel employment = new HrmsEmploymentMasterModel(m[0], m[1], m[2], m[3]);

				pemployment.add(employment);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<HrmsEmploymentMasterModel> resp = new JsonResponse<HrmsEmploymentMasterModel>();
		resp.setBody(pemployment.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<HrmsEmploymentMasterModel>> response = new ResponseEntity<JsonResponse<HrmsEmploymentMasterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getemploymentById ends");

		return response;
	}

	/*
	 * for delete employment
	 */
	public ResponseEntity<JsonResponse<Object>>deleteEmploymentById(String id, String createdBy) {

		logger.info("Method in Dao: deleteEmploymentById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @P_EMPLId='" + id + "',@P_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("EmploymentMaster").setParameter("actionType", "deleteemployment")
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

		logger.info("Method in Dao: deleteEmploymentById ends");

		return response;
	}

}
