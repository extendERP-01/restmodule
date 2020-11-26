/**
 * Process master rest controller
 *
 */

package nirmalya.aatithya.restmodule.user.controller;

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
import nirmalya.aatithya.restmodule.user.dao.RestProcessMasterDao;
import nirmalya.aatithya.restmodule.user.model.RestProcessMasterModel;

/**
 * @author NirmalyaLabs
 *
 */

@RestController
@RequestMapping(value = "user")
public class RestProcessMasterController {

	@Autowired
	RestProcessMasterDao processDao;

	Logger logger = LoggerFactory.getLogger(RestProcessMasterController.class);

	/*
	 * Post Mapping to Add new Process
	 *
	 */
	@RequestMapping(value = "/restAddNewProcess", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddProcess(@RequestBody RestProcessMasterModel processMaster) {
		logger.info("Method : restAddNewProcess starts");
		logger.info("Method : restAddNewProcess endss");
		return processDao.addProcess(processMaster);
	}

	/*
	 * returns all Process
	 *
	 */
	@RequestMapping(value = "/getAllProcess", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestProcessMasterModel>>> getAllProcess(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllProcess starts");
		logger.info("Method : getAllProcess endss");
		return processDao.getAllProcess(request);
	}

	/*
	 * returns particular Process to view
	 *
	 */
	@RequestMapping(value = "/viewThisProcess", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestProcessMasterModel>> viewProcess(@RequestParam("id") String id) {
		logger.info("Method : viewProcess starts");
		logger.info("Method : viewProcess ends");
		return processDao.viewProcess(id);
	}

	/*
	 * delete particular Process in model
	 *
	 */
	@RequestMapping(value = "/deleteProcess", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteProcess(@RequestParam String id, @RequestParam String createdBy) {

		logger.info("Method : deleteProcess starts");

		logger.info("Method : deleteProcess end");

		return processDao.deleteProcess(id, createdBy);
	}

	/*
	 * 
	 * PostMapping for add get Process List
	 * 
	 * 
	 */
	@RequestMapping(value = "restGetProcess", method = { RequestMethod.GET })
	public List<DropDownModel> restGetProcess() {
		logger.info("Method : restGetProcess starts");
		logger.info("Method : restGetProcess ends");
		return processDao.restGetProcess();
	}

}
