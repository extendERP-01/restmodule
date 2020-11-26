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
import nirmalya.aatithya.restmodule.common.utils.GenerateEmergencyContactParam;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmergencyContactModel;



@Repository
public class HrmsEmergencyContactDao {

	Logger logger = LoggerFactory.getLogger(HrmsEmergencyContactDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for all emergency details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEmergencyContactModel>>> getemergencyDetails(DataTableRequest request) {

		logger.info("Method in Dao: getemergencyDetails starts");

		List<HrmsEmergencyContactModel> employementList = new ArrayList<HrmsEmergencyContactModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("emergencyMaster")
					.setParameter("actionType", "viewEmgcyList").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					HrmsEmergencyContactModel qualif = new HrmsEmergencyContactModel(m[0], m[1], m[2], m[3], m[4],
							m[5]);
					employementList.add(qualif);

				}

				if (x.get(0).length > 6) {
					BigInteger t = (BigInteger) x.get(0)[6];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsEmergencyContactModel>> resp = new JsonResponse<List<HrmsEmergencyContactModel>>();
		resp.setBody(employementList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsEmergencyContactModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEmergencyContactModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getemergencyDetails ends");

		return response;
	}

	/*
	 * for add new emergency
	 */
	public ResponseEntity<JsonResponse<Object>> addemergency(HrmsEmergencyContactModel emergency) {

		logger.info("Method in Dao: addemergency starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (emergency.getEmpId() == null || emergency.getEmpId() == "") {
			resp.setMessage("Employee Name required");
			validity = false;
		} else if (emergency.getName() == null || emergency.getName() == "") {
			resp.setMessage("Contact Name required");
			validity = false;
		} else if (emergency.getMobileNo() == null || emergency.getMobileNo() == "") {
			resp.setMessage("Mobile Number Required");
			validity = false;
		} else if (emergency.getAdharNo() == null || emergency.getAdharNo() == "") {
			resp.setMessage("Adhar Number Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateEmergencyContactParam.getAddemergencyParam(emergency);
				if (emergency.getEditId() != "") {
					em.createNamedStoredProcedureQuery("emergencyMaster").setParameter("actionType", "modifyEmgcy")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("emergencyMaster").setParameter("actionType", "addEmgcy")
							.setParameter("actionValue", values).execute();
				}
			} catch (Exception e) {

				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					if (err[1].contentEquals("Duplicate entry 'x' for  'PRIMARY'") ) {
						resp.setMessage("Employee Emergency Contact Already Exsited.");
					} else {
						resp.setMessage(err[1]);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: addemergency ends");

		return response;
	}

	/*
	 * for edit emergency
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<HrmsEmergencyContactModel>> getemergencyById(String id) {

		logger.info("Method in Dao: getemergencyById ends");

		List<HrmsEmergencyContactModel> pemergency = new ArrayList<HrmsEmergencyContactModel>();

		try {

			String value = "SET @P_empId='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("emergencyMaster")
					.setParameter("actionType", "viewEditEmgcy").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				HrmsEmergencyContactModel emergency = new HrmsEmergencyContactModel(m[0], m[1], m[2], m[3], m[4], m[5]);

				pemergency.add(emergency);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<HrmsEmergencyContactModel> resp = new JsonResponse<HrmsEmergencyContactModel>();
		resp.setBody(pemergency.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<HrmsEmergencyContactModel>> response = new ResponseEntity<JsonResponse<HrmsEmergencyContactModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getemergencyById ends");
		System.out.println(response);
		return response;
	}

	/*
	 * for delete emergency
	 */
	public ResponseEntity<JsonResponse<Object>> deleteemergencyById(String id, String createdBy) {

		logger.info("Method in Dao: deleteemergencyById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @P_empId='" + id + "',@P_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("emergencyMaster").setParameter("actionType", "deleteEmgcy")
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

		logger.info("Method in Dao: deleteemergencyById ends");

		return response;
	}
}
