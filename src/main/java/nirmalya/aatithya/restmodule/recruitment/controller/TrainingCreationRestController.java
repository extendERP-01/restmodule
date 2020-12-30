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
import nirmalya.aatithya.restmodule.recruitment.dao.TrainingCreationDao;
import nirmalya.aatithya.restmodule.recruitment.model.TrainingCreationRestModel;

@RestController
@RequestMapping(value = "recruitment/")
public class TrainingCreationRestController {
	Logger logger = LoggerFactory.getLogger(TrainingCreationRestController.class);

	@Autowired
	TrainingCreationDao traininingdao;

	/*
	 * Rest Controller - Add training creation Master
	 */
	@RequestMapping(value = "/restAddTraining", method = { RequestMethod.POST })
	ResponseEntity<JsonResponse<Object>> addTrainingDetailsPost(@RequestBody TrainingCreationRestModel struct) {

		logger.info("Method : restAddStruct strats");

		logger.info("Method : restAddStruct ends");

		return traininingdao.addTrainingDetailsPost(struct);
	}

	/**
	 * Ajax call to view training creation
	 */
	@RequestMapping(value = "getTraining", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<TrainingCreationRestModel>>> getTrainingDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getJobDetails starts");

		logger.info("Method : getJobDetails ends");

		return traininingdao.getTrainingDetails(request);
	}

	/**
	 * delete particular Patient Details in model
	 *
	 */
	@RequestMapping(value = "/training-creation-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteTrainingDetail(@RequestParam String id,
			@RequestParam String createdBy) {

		logger.info("Method : deleteJobDetails starts");

		logger.info("Method : deleteJobDetails end");

		return traininingdao.deleteTrainingDetail(id, createdBy);
	}

	/**
	 * 
	 * view training For modal
	 * 
	 */
	@RequestMapping(value = "/view-training-modal-index", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<TrainingCreationRestModel>> getTrainingModel(@RequestBody String id) {
		logger.info("Method : getVendorForModel starts");

		logger.info("Method : getVendorForModel endss");
		return traininingdao.getTrainingModel(id);
	}
	
	/**
	 * for training Details Edit
	 */
	@RequestMapping(value = "/edit-training-details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<TrainingCreationRestModel>> getTrainingDetailsEdit(@RequestParam String id) {
		logger.info("Method : getJobDetailsEdit starts");

		logger.info("Method : getJobDetailsEdit ends");

		return traininingdao.getTrainingDetailsEdit(id);
	}
}
