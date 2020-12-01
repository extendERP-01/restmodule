package nirmalya.aatithya.restmodule.recruitment.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.GenerateMasterSpecificTypeParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.recruitment.model.SpecificTypeModel;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;


@Repository

public class SpecificTypeDao {

	Logger logger = LoggerFactory.getLogger(SpecificTypeDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	
	/**
	 * DAO - Add specificType
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addSpecific(SpecificTypeModel specific) {
		logger.info("Method : addSpecific starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (specific.getSpecificName() == null || specific.getSpecificName() == "") {
			resp.setMessage("Type Name Required");
			validity = false;
		} else if (specific.getSpecificDesc() == null || specific.getSpecificDesc() == "") {
			resp.setMessage("Description Required");
			validity = false;
		} else if (specific.getSpecificActive() == null) {
			resp.setMessage("Specific Status Required");
			validity = false;
		}

		if (validity)
			try {

				String values = GenerateMasterSpecificTypeParameter.getAddSpecificParam(specific);

				if (specific.getSpecificId() != null && specific.getSpecificId() != "") {
					em.createNamedStoredProcedureQuery("specficTypeRoutines")
							.setParameter("actionType", "modifySpecific").setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("specficTypeRoutines").setParameter("actionType", "addSpecific")
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

		logger.info("Method : addSpecific ends");
		return response;
	}
	
	
	/**
	 * DAO - Get Specific Details
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SpecificTypeModel>>> getSpecificDetails() {
		logger.info("Method : getSpecificDetails starts");

		List<SpecificTypeModel> specific = new ArrayList<SpecificTypeModel>();
		
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("specficTypeRoutines")
					.setParameter("actionType", "viewSpecificDetails").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				SpecificTypeModel specificTypeModel = new SpecificTypeModel(m[0], m[1], m[2], m[3], m[4]);
				specific.add(specificTypeModel);
			}

			if (x.size() > 0) 
			{
				if (x.get(0).length > 5) {
					BigInteger t = (BigInteger) x.get(0)[5];

					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<SpecificTypeModel>> resp = new JsonResponse<List<SpecificTypeModel>>();
		resp.setBody(specific);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<SpecificTypeModel>>> response = new ResponseEntity<JsonResponse<List<SpecificTypeModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getSpecificDetails ends");
		return response;
	}

	/**
	 * DAO - Get Specific For Edit View
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<SpecificTypeModel>> getSpecificById(String id) {
		logger.info("Method : getSpecificById starts");

		List<SpecificTypeModel> SpecificMaster = new ArrayList<SpecificTypeModel>();
		JsonResponse<SpecificTypeModel> resp = new JsonResponse<SpecificTypeModel>();

		try {

			String value = "SET @p_SpecificId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("specficTypeRoutines")
					.setParameter("actionType", "viewEditSpecific").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
			for (Object[] m : x) {
				SpecificTypeModel specific = new SpecificTypeModel(m[0],m[1], m[2], m[3], m[4]);
				SpecificMaster.add(specific);
			}
			

			resp.setBody(SpecificMaster.get(0));
		}} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<SpecificTypeModel>> response = new ResponseEntity<JsonResponse<SpecificTypeModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getSpecificById ends");
		return response;
	}

	/**
	 * DAO - Delete Specific
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteSpecificById(String id, String createdBy) {
		logger.info("Method : deleteSpecificById starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_specificId='" + id + "',@p_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("specficTypeRoutines").setParameter("actionType", "deleteSpecific")
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

		logger.info("Method : deleteSpecificById ends");
		return response;
	}
}
