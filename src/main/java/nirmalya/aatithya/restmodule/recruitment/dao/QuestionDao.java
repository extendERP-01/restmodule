package nirmalya.aatithya.restmodule.recruitment.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateQuestionParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.recruitment.model.QuestionModel;

@Repository

public class QuestionDao {

	Logger logger = LoggerFactory.getLogger(QuestionDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	/**
	 * DAO - Add questionType
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addQuestion(QuestionModel question) {
		logger.info("Method : addQuestion starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (question.getQuestionName() == null || question.getQuestionName() == "") {
			resp.setMessage("Question Name Required");
			validity = false;
		} else if (question.getQuestionDesc() == null || question.getQuestionDesc() == "") {
			resp.setMessage("Description Required");
			validity = false;
		} else if (question.getQuestionActive() == null) {
			resp.setMessage("Question Status Required");
			validity = false;
		}

		if (validity)
			try {

				String values = GenerateQuestionParameter.getAddQuestionParam(question);

				if (question.getQuestionId() != null && question.getQuestionId() != "") {
					em.createNamedStoredProcedureQuery("questionRoutines").setParameter("actionType", "modifyQuestion")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("questionRoutines").setParameter("actionType", "addQuestion")
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

		logger.info("Method : addQuestion ends");
		return response;
	}

	/**
	 * DAO - Get Specific Details
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<QuestionModel>>> getQuestionDetails(DataTableRequest tableRequest) {
		logger.info("Method : getQuestionDetails starts");

		List<QuestionModel> question = new ArrayList<QuestionModel>();
		String values = GenerateParameter.getSearchParam(tableRequest);

		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("questionRoutines")
					.setParameter("actionType", "viewQuestionDetails").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				QuestionModel questionModel = new QuestionModel(m[0], m[1], m[2], m[3], m[4]);
				question.add(questionModel);
			}

			if (x.size() > 0) {
				if (x.get(0).length > 5) {
					BigInteger t = (BigInteger) x.get(0)[5];

					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<QuestionModel>> resp = new JsonResponse<List<QuestionModel>>();
		resp.setBody(question);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<QuestionModel>>> response = new ResponseEntity<JsonResponse<List<QuestionModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getQuestionDetails ends");
		return response;
	}

	/**
	 * DAO - Get Specific For Edit View
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<QuestionModel>> getQuestionById(String id) {
		logger.info("Method : getQuestionById starts");

		List<QuestionModel> QuestionMaster = new ArrayList<QuestionModel>();
		JsonResponse<QuestionModel> resp = new JsonResponse<QuestionModel>();

		try {

			String value = "SET @p_QuestionId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("questionRoutines")
					.setParameter("actionType", "viewEditQuestion").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					QuestionModel question = new QuestionModel(m[0], m[1], m[2], m[3], m[4]);
					QuestionMaster.add(question);
				}

				resp.setBody(QuestionMaster.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<QuestionModel>> response = new ResponseEntity<JsonResponse<QuestionModel>>(resp,
				responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getQuestionById ends");
		return response;
	}

	/**
	 * DAO - Delete
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteQuestionById(String id, String createdBy) {
		logger.info("Method : deleteQuestionById starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_questionId='" + id + "',@p_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("questionRoutines").setParameter("actionType", "deleteQuestion")
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

		logger.info("Method : deleteQuestionById ends");
		return response;
	}
}
