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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.recruitment.dao.AddTrainingDao;

import nirmalya.aatithya.restmodule.recruitment.model.AddTrainingPlanningRestModel;
import nirmalya.aatithya.restmodule.recruitment.model.ShiftMasterRestModel;

@RestController
@RequestMapping("recruitment/")

public class TrainingPlanningRestController {

	Logger logger = LoggerFactory.getLogger(TrainingPlanningRestController.class);

	@Autowired
	AddTrainingDao addtrainingdao;

	
	  @RequestMapping(value = "/dropDowntranningType", method = { RequestMethod.GET })
	  public List<DropDownModel> dropDowntranningType() {
	  logger.info("Method : dropDowntranningType starts");
	  
	  logger.info("Method : dropDowntranningType ends"); return
	  addtrainingdao.dropDowntranningType(); }
	 

	@RequestMapping(value = "restaddplan", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restTrainingplanning(
			@RequestBody List<AddTrainingPlanningRestModel> restaddplan) {
		logger.info("Method in rest: restAddShift starts");

		logger.info("Method in rest: restAddShift ends");
		return addtrainingdao.restTrainingplanning(restaddplan);
	}

	// get planning
	@RequestMapping(value = "gettrainningplanning", method = { RequestMethod.POST })
	ResponseEntity<JsonResponse<List<AddTrainingPlanningRestModel>>> gettrainningplanning(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getRequistionview start");

		logger.info("Method : getRequistionview ends");

		return addtrainingdao.gettrainningplanning(request);
	}

//Delete 
	@RequestMapping(value = "deletetrainningbyId", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletetrainningbyId(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deletetrainningbyId starts");

		logger.info("Method : deletetrainningbyId ends");
		return addtrainingdao.deletetrainningbyId(id, createdBy);
	}

	/*
	 * for assign Edit
	 */
	@RequestMapping(value = "geteditplanning", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AddTrainingPlanningRestModel>>> geteditplanning(
			@RequestParam("trainningId") String trainningId) {
		logger.info("Method : geteditplanning starts");

		logger.info("Method : geteditplanning ends");

		return addtrainingdao.geteditplanning(trainningId);
	}
	
}
