package nirmalya.aatithya.restmodule.recruitment.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateQuestionTypeParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.recruitment.model.QuestionTypeModel;
import org.springframework.http.HttpHeaders;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class QuestionTypeDao {

	Logger logger = LoggerFactory.getLogger(QuestionTypeDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/**
	 * for SpecificType list
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSpecificList() {

		logger.info("Method : getSpecificList starts");

		List<DropDownModel> specificList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("questionTypeRoutines")
					.setParameter("actionType", "getSpecificList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				specificList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getSpecificList ends");
		return specificList ;
	}
	
	/**
	 * for specific list
	 */
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getQuestion() {

			logger.info("Method : getQuestion starts");

			List<DropDownModel> specificList = new ArrayList<DropDownModel>();

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("questionTypeRoutines")
						.setParameter("actionType", "getQuestionList").setParameter("actionValue", "").getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					specificList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.info("Method : getQuestion ends");

			return specificList;
		}
		
		/*
		 * for add other service price
		 */
		public ResponseEntity<JsonResponse<Object>> restAddQuestion(
				List<QuestionTypeModel> questionTypeModel) {

			logger.info("Method in Dao: restAddQuestion starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");
			String id = questionTypeModel.get(0).getEditId();

			for (QuestionTypeModel a : questionTypeModel) {
				if (a.getSpeTypeId() == null || a.getSpeTypeId() == "") {
					resp.setMessage("Specific Name not Selected");
					validity = false;
				} /*
					 * else if (a.getQuestionType() == null || a.getQuestionType() == "") {
					 * resp.setMessage("Question Name is required"); validity = false; }
					 */
			}
			if (validity)
				try {
					String values = GenerateQuestionTypeParameter.getAddQuestionTypeParam(questionTypeModel);
					System.out.println(values);
					if (id != null && id != "") {

						em.createNamedStoredProcedureQuery("questionTypeRoutines")
								.setParameter("actionType", "modifyQuestionType").setParameter("actionValue", values)
								.execute();
					} else {

						em.createNamedStoredProcedureQuery("questionTypeRoutines")
								.setParameter("actionType", "addQuestionType").setParameter("actionValue", values).execute();

					}
				} catch (Exception e) {
					try {
						String[] err = serverDao.errorProcedureCall(e);
						if(err[0].matches("1062")){
							resp.setMessage("Question Already Added.");
						}else {
							resp.setMessage(err[1]);
						}
						resp.setCode(err[0]);
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
					HttpStatus.CREATED);

			logger.info("Method in Dao: restAddQuestion ends");

			return response;
		}
 
		/*
		 * for all assignSkill details view
		 */
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<QuestionTypeModel>>> getAssignQuedDetails(DataTableRequest tableRequest) {

			logger.info("Method in Dao: getAssignQueDetails starts");

			List<QuestionTypeModel> queList = new ArrayList<QuestionTypeModel>();
			String values = GenerateParameter.getSearchParam(tableRequest);
			Integer total = 0;

			try {

				List<Object[]> x = em.createNamedStoredProcedureQuery("questionTypeRoutines")
						.setParameter("actionType", "getQueDepnd").setParameter("actionValue",values )
						.getResultList();
				if (!x.isEmpty()) {
					for (Object[] m : x) {

						QuestionTypeModel question = new QuestionTypeModel(m[0],m[1],m[2],null,null);
						queList.add(question);

					}

					if (x.get(0).length > 3) {
						BigInteger t = (BigInteger) x.get(0)[3];

						total = Integer.parseInt((t.toString()));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
System.out.println(total);
			JsonResponse<List<QuestionTypeModel>> resp = new JsonResponse<List<QuestionTypeModel>>();
			resp.setBody(queList);
			resp.setTotal(total);

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");
			ResponseEntity<JsonResponse<List<QuestionTypeModel>>> response = new ResponseEntity<JsonResponse<List<QuestionTypeModel>>>(
					resp, responseHeaders, HttpStatus.CREATED);

			logger.info("Method in Dao: getAssignQueDetails ends");
          System.out.println(response);
			return response;
		}

		/*
		 * for modal view and edit also
		 */
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<QuestionTypeModel>>> getSpecificListById(String id) {

			logger.info("Method : getEditService starts");

			List<QuestionTypeModel> queList = new ArrayList<QuestionTypeModel>();
			JsonResponse<List<QuestionTypeModel>> resp = new JsonResponse<List<QuestionTypeModel>>();

			try {

				String value = "SET @p_speTypeId='" + id + "';";
				System.out.println(value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("questionTypeRoutines")
						.setParameter("actionType", "getQueDepndById").setParameter("actionValue", value).getResultList();
System.out.println(x);
				for (Object[] m : x) {
					
					QuestionTypeModel QuestionTypeModel = new QuestionTypeModel(m[0],m[1],m[2],"a",m[3]);

					queList.add(QuestionTypeModel);

				}
				resp.setBody(queList);
			} catch (Exception e) {
				e.printStackTrace();
			}

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");

			ResponseEntity<JsonResponse<List<QuestionTypeModel>>> response = new ResponseEntity<JsonResponse<List<QuestionTypeModel>>>(
					resp, responseHeaders, HttpStatus.CREATED);
System.out.println(response);
			logger.info("Method : getEditService ends");

			return response;
		}
		

}
