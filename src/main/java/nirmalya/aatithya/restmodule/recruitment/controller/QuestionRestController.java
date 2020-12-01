package nirmalya.aatithya.restmodule.recruitment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.recruitment.dao.QuestionDao;
import nirmalya.aatithya.restmodule.recruitment.model.QuestionModel;

@RestController
@RequestMapping(value = "recruitment")
public class QuestionRestController {

	Logger logger = LoggerFactory.getLogger(QuestionRestController.class);

	@Autowired
	QuestionDao questionDao;

	/**
	 * Rest Controller - Add question Master
	 *
	 */

	@RequestMapping(value = "restAddQuestion", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddQuestion(@RequestBody QuestionModel question) {
		logger.info("Method : restAddQuestion starts");

		logger.info("Method : restAddQuestion ends");
		return questionDao.addQuestion(question);
	}

	@RequestMapping(value = "/getQuestion", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<QuestionModel>>> getQuestion(@RequestBody DataTableRequest tableRequest) {
		logger.info("Method : getQuestion starts");

		logger.info("Method : getQuestion ends");
		return questionDao.getQuestionDetails(tableRequest);
	}

	/**
	 * Rest Controller - Get program Details For Edit
	 *
	 */

	@RequestMapping(value = "/getQuestionById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<QuestionModel>> getQuestionById(@RequestParam String id) {
		logger.info("Method : getQuestionById starts");

		logger.info("Method : getQuestionById ends");
		return questionDao.getQuestionById(id);
	}

	/**
	 * Rest Controller - Delete program
	 *
	 */
	@RequestMapping(value = "/deleteQuestionById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteQuestionById(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deleteQuestionById starts");

		logger.info("Method : deleteQuestionById ends");

		return questionDao.deleteQuestionById(id, createdBy);
	}

}
