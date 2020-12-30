package nirmalya.aatithya.restmodule.recruitment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.recruitment.dao.QuestionTypeDao;
import nirmalya.aatithya.restmodule.recruitment.model.QuestionTypeModel;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("recruitment")
public class QuestionTypeRestController {

	Logger logger = LoggerFactory.getLogger(QuestionTypeRestController.class);

	@Autowired
	QuestionTypeDao questionTypeDao;

	/**
	 * 
	 * @return Specific list
	 */
	@RequestMapping(value = "getQuestionList", method = { RequestMethod.GET })
	public List<DropDownModel> getQuestionList() {

		logger.info("Method : getQuestionList starts");
		logger.info("Method : getQuestionList ends");

		return questionTypeDao.getQuestion();
	}
	

	/**
	 * 
	 * @return Employee list
	 */
	@RequestMapping(value = "getSpecificList", method = { RequestMethod.GET })
	public List<DropDownModel> getSpecificList() {

		logger.info("Method : getSpecificList starts");
		logger.info("Method : getSpecificList ends");

		return questionTypeDao.getSpecificList();
	}
	
	/*
	 * for Add Other Service price getAssignEduDetails
	 */
	@RequestMapping(value = "restQuestionType", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restQuestionType(
			@RequestBody List<QuestionTypeModel> questionTypeModel) {
		logger.info("Method in rest: restAddQuestion starts");

		logger.info("Method in rest: restAddQuestion ends");

		return questionTypeDao.restAddQuestion(questionTypeModel);
	}
	
	/*
	 * for All assignSkill
	 */
	@RequestMapping(value = "/getAssignQueDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<QuestionTypeModel>>> getAssignQueDetails(@RequestBody DataTableRequest tableRequest) {
		logger.info("Method : getAssignQueDetails starts");

		logger.info("Method : getAssignQueDetails ends");

		return questionTypeDao.getAssignQuedDetails(tableRequest);
	}

	/*
	 * for assign  Edit
	 */
	@RequestMapping(value = "getQueDepndById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<QuestionTypeModel>>> getSpecificListById(
			@RequestParam("speTypeId") String speTypeId) {
		logger.info("Method : getQueDepndById starts");

		logger.info("Method : getQueDepndById ends");

		return questionTypeDao.getSpecificListById(speTypeId);
	}

	
}
