package nirmalya.aatithya.restmodule.recruitment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.recruitment.dao.SpecificTypeDao;
import nirmalya.aatithya.restmodule.recruitment.model.SpecificTypeModel;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(value = "recruitment")
public class SpecificTypeController {

	Logger logger = LoggerFactory.getLogger(SpecificTypeController.class);

	@Autowired
	SpecificTypeDao specificTypeDao;

	/**
	 * Rest Controller - Add specific Master
	 *
	 */
	

	@RequestMapping(value = "restAddSpecific", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddProgram(@RequestBody SpecificTypeModel specific) {
		logger.info("Method : restAddSpecific starts");

		logger.info("Method : restAddSpecific ends");
		return specificTypeDao.addSpecific(specific);
	}
	
	@RequestMapping(value = "/getSpecific", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SpecificTypeModel>>> getSpecific() {
		logger.info("Method : getSpecific starts");

		logger.info("Method : getSpecific ends");
		return specificTypeDao.getSpecificDetails();
	}

	/**
	 * Rest Controller - Get program Details For Edit
	 *
	 */

	@RequestMapping(value = "/getSpecificById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<SpecificTypeModel>> getSpecificById(@RequestParam String id) {
		logger.info("Method : getSpecificById starts");

		logger.info("Method : getSpecificById ends");
		return specificTypeDao.getSpecificById(id);
	}

	/**
	 * Rest Controller - Delete program
	 *
	 */
	@RequestMapping(value = "/deleteSpecificById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteSpecificById(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deleteSpecificById starts");

		logger.info("Method : deleteSpecificById ends");

		return specificTypeDao.deleteSpecificById(id, createdBy);
	}

}
