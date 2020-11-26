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
import nirmalya.aatithya.restmodule.common.utils.GenerateLanguageMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.HrmsLanguageMasterModel;
@Repository
public class HrmsLanguageMasterDao {

	Logger logger = LoggerFactory.getLogger(HrmsLanguageMasterDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for all language details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsLanguageMasterModel>>> getlanguageDetails(DataTableRequest request) {

		logger.info("Method in Dao: getlanguageDetails starts");

		List<HrmsLanguageMasterModel> employementList = new ArrayList<HrmsLanguageMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("languageMaster")
					.setParameter("actionType", "viewLangList").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					HrmsLanguageMasterModel employement = new HrmsLanguageMasterModel(m[0], m[1], m[2], m[3]);
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

		JsonResponse<List<HrmsLanguageMasterModel>> resp = new JsonResponse<List<HrmsLanguageMasterModel>>();
		resp.setBody(employementList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsLanguageMasterModel>>> response = new ResponseEntity<JsonResponse<List<HrmsLanguageMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getlanguageDetails ends");

		return response;
	}

	/*
	 * for add new language
	 */
	public ResponseEntity<JsonResponse<Object>> addlanguage(HrmsLanguageMasterModel language) {

		logger.info("Method in Dao: addlanguage starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (language.getLanguageName() == null || language.getLanguageName() == "") {
			resp.setMessage("language Name required");
			validity = false;
		} else if (language.getLanguageDesc() == null || language.getLanguageDesc() == "") {
			resp.setMessage("language description required");
			validity = false;
		} else if (language.getLanguageStatus() == null) {
			resp.setMessage("language active required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateLanguageMasterParameter.getAddLanguageParam(language);
				if (language.getLanguageId() != "") {
					em.createNamedStoredProcedureQuery("languageMaster").setParameter("actionType", "modifyLang")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("languageMaster").setParameter("actionType", "addLang")
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

		logger.info("Method in Dao: addlanguage ends");

		return response;
	}

	/*
	 * for edit language
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<HrmsLanguageMasterModel>>getlanguageById(String id) {

		logger.info("Method in Dao: getlanguageById ends");

		List<HrmsLanguageMasterModel> planguage = new ArrayList<HrmsLanguageMasterModel>();

		try {

			String value = "SET @P_langId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("languageMaster")
					.setParameter("actionType", "viewEditLang").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				HrmsLanguageMasterModel language = new HrmsLanguageMasterModel(m[0], m[1], m[2], m[3]);

				planguage.add(language);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<HrmsLanguageMasterModel> resp = new JsonResponse<HrmsLanguageMasterModel>();
		resp.setBody(planguage.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<HrmsLanguageMasterModel>> response = new ResponseEntity<JsonResponse<HrmsLanguageMasterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getlanguageById ends");

		return response;
	}

	/*
	 * for delete language
	 */
	public ResponseEntity<JsonResponse<Object>>deletelanguageById(String id, String createdBy) {

		logger.info("Method in Dao: deletelanguageById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @P_langId='" + id + "',@P_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("languageMaster").setParameter("actionType", "deleteLang")
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

		logger.info("Method in Dao: deletelanguageById ends");

		return response;
	}

}

