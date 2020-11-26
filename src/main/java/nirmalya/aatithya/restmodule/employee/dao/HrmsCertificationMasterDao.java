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
import nirmalya.aatithya.restmodule.common.utils.GenerateCertificationMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.HrmsCertificationMasterModel;


@Repository
public class HrmsCertificationMasterDao {
	Logger logger = LoggerFactory.getLogger(HrmsCertificationMasterDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for all certification details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsCertificationMasterModel>>> getcertificationDetails(DataTableRequest request) {

		logger.info("Method in Dao: getcertificationDetails starts");

		List<HrmsCertificationMasterModel> employementList = new ArrayList<HrmsCertificationMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("certificationMaster")
					.setParameter("actionType", "viewcertList").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					HrmsCertificationMasterModel employement = new HrmsCertificationMasterModel(m[0], m[1], m[2], m[3]);
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

		JsonResponse<List<HrmsCertificationMasterModel>> resp = new JsonResponse<List<HrmsCertificationMasterModel>>();
		resp.setBody(employementList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsCertificationMasterModel>>> response = new ResponseEntity<JsonResponse<List<HrmsCertificationMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getcertificationDetails ends");

		return response;
	}

	/*
	 * for add new certification
	 */
	public ResponseEntity<JsonResponse<Object>> addcertification(HrmsCertificationMasterModel certification) {

		logger.info("Method in Dao: addcertification starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (certification.getCertificationName() == null || certification.getCertificationName() == "") {
			resp.setMessage("certification Name required");
			validity = false;
		} else if (certification.getCertificationDesc() == null || certification.getCertificationDesc() == "") {
			resp.setMessage("certification description required");
			validity = false;
		} else if (certification.getCertificationStatus() == null) {
			resp.setMessage("certification active required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateCertificationMasterParameter.getAddCertificationParam(certification);
				if (certification.getCertificationId() != "") {
					em.createNamedStoredProcedureQuery("certificationMaster").setParameter("actionType", "modifycert")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("certificationMaster").setParameter("actionType", "addcert")
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

		logger.info("Method in Dao: addcertification ends");

		return response;
	}

	/*
	 * for edit certification
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<HrmsCertificationMasterModel>>getcertificationById(String id) {

		logger.info("Method in Dao: getcertificationById ends");

		List<HrmsCertificationMasterModel> pcertification = new ArrayList<HrmsCertificationMasterModel>();

		try {

			String value = "SET @P_certId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("certificationMaster")
					.setParameter("actionType", "viewEditcert").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				HrmsCertificationMasterModel certification = new HrmsCertificationMasterModel(m[0], m[1], m[2], m[3]);

				pcertification.add(certification);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<HrmsCertificationMasterModel> resp = new JsonResponse<HrmsCertificationMasterModel>();
		resp.setBody(pcertification.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<HrmsCertificationMasterModel>> response = new ResponseEntity<JsonResponse<HrmsCertificationMasterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getcertificationById ends");

		return response;
	}

	/*
	 * for delete certification
	 */
	public ResponseEntity<JsonResponse<Object>>deletecertificationById(String id, String createdBy) {

		logger.info("Method in Dao: deletecertificationById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @P_certId='" + id + "',@P_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("certificationMaster").setParameter("actionType", "deletecert")
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

		logger.info("Method in Dao: deletecertificationById ends");

		return response;
	}

}
