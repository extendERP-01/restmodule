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
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateQualificationMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.HrmsQualificationMasterModel;
@Repository
public class HrmsQualificationMasterDao {
	Logger logger = LoggerFactory.getLogger(HrmsQualificationMasterDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for all qualification details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsQualificationMasterModel>>> getqualificationDetails(DataTableRequest request) {

		logger.info("Method in Dao: getqualificationDetails starts");

		List<HrmsQualificationMasterModel> employementList = new ArrayList<HrmsQualificationMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("qualificationMaster")
					.setParameter("actionType", "viewQfcnList").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					HrmsQualificationMasterModel qualif = new HrmsQualificationMasterModel(m[0], m[1], m[2], m[3]);
					employementList.add(qualif);

				}

				if (x.get(0).length >4) {
					BigInteger t = (BigInteger) x.get(0)[4];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsQualificationMasterModel>> resp = new JsonResponse<List<HrmsQualificationMasterModel>>();
		resp.setBody(employementList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsQualificationMasterModel>>> response = new ResponseEntity<JsonResponse<List<HrmsQualificationMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getqualificationDetails ends");

		return response;
	}

	/*
	 * for add new qualification
	 */
	public ResponseEntity<JsonResponse<Object>> addqualification(HrmsQualificationMasterModel qualification) {

		logger.info("Method in Dao: addqualification starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (qualification.getQualificationName() == null || qualification.getQualificationName() == "") {
			resp.setMessage("qualification Name required");
			validity = false;
		} else if (qualification.getQualificationDesc() == null || qualification.getQualificationDesc() == "") {
			resp.setMessage("qualification description required");
			validity = false;
		} else if (qualification.getQualificationStatus() == null) {
			resp.setMessage("qualification active required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateQualificationMasterParameter.getAddQualificationParam(qualification);
				if (qualification.getQualificationId() != "") {
					em.createNamedStoredProcedureQuery("qualificationMaster").setParameter("actionType", "modifyQfcn")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("qualificationMaster").setParameter("actionType", "addQfcn")
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

		logger.info("Method in Dao: addqualification ends");

		return response;
	}

	/*
	 * for edit qualification
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<HrmsQualificationMasterModel>>getqualificationById(String id) {

		logger.info("Method in Dao: getqualificationById ends");

		List<HrmsQualificationMasterModel> pqualification = new ArrayList<HrmsQualificationMasterModel>();

		try {

			String value = "SET @P_QId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("qualificationMaster")
					.setParameter("actionType", "viewEditQfcn").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				HrmsQualificationMasterModel qualification = new HrmsQualificationMasterModel(m[0], m[1], m[2], m[3]);

				pqualification.add(qualification);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<HrmsQualificationMasterModel> resp = new JsonResponse<HrmsQualificationMasterModel>();
		resp.setBody(pqualification.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<HrmsQualificationMasterModel>> response = new ResponseEntity<JsonResponse<HrmsQualificationMasterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getqualificationById ends");

		return response;
	}

	/*
	 * for delete qualification
	 */
	public ResponseEntity<JsonResponse<Object>>deletequalificationById(String id, String createdBy) {

		logger.info("Method in Dao: deletequalificationById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @P_QId='" + id + "',@P_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("qualificationMaster").setParameter("actionType", "deleteQfcn")
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

		logger.info("Method in Dao: deletequalificationById ends");

		return response;
	}

}
