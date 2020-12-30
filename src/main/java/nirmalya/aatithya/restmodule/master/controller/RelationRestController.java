package nirmalya.aatithya.restmodule.master.controller;

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
import nirmalya.aatithya.restmodule.master.dao.Master; 
import nirmalya.aatithya.restmodule.master.model.RelationModel;   

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "master")
public class RelationRestController {
	Logger logger = LoggerFactory.getLogger(RelationRestController.class);

	@Autowired
	Master relationDao;
	/**
	 * returns add user type 
	 *
	 */
	@RequestMapping(value = "/addRelation", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addRelation(@RequestBody RelationModel form) {
		logger.info("Method : addRelation starts");

		logger.info("Method : addRelation end");

		return relationDao.addRelation(form);

	}
	/**
	 * returns all property floor
	 *
	 */
	@RequestMapping(value = "/getAllRelation", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RelationModel>>> getAllRelation(@RequestBody DataTableRequest request) {

		logger.info("Method : getAllRelation starts");

		logger.info("Method : getAllRelation end");

		return relationDao.getAllRelation(request);
	}
	@RequestMapping(value = "/geRelationById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RelationModel>> getPaymentById(@RequestParam String id,
			@RequestParam("Action") String action) {
		logger.info("Method : geRelationById starts");

		logger.info("Method : geRelationById end");

		return relationDao.geRelationById(id, action);
	}
	@RequestMapping(value = "/deleteRltnById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteRltnById(@RequestParam String id,@RequestParam String createdBy) {
		logger.info("Method : deleteRltnById starts");

		logger.info("Method : deleteRltnById end");

		return relationDao.deleteRltnById(id,createdBy);
	}
}
