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
import nirmalya.aatithya.restmodule.master.dao.RsetModuleMasterDao;
import nirmalya.aatithya.restmodule.master.model.RestModuleMasterModel;

/**
 * @author NirmalyaLabs
 *
 */

@RestController
@RequestMapping(value = "master")
public class RestModuleMasterController {

	@Autowired
	RsetModuleMasterDao moduleDao;

	Logger logger = LoggerFactory.getLogger(RestModuleMasterController.class);

	/**
	 * returns all module
	 *
	 */
	@RequestMapping(value = "/getAllModule", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestModuleMasterModel>>> getAllModule(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllModule starts");
		logger.info("Method : getAllModule endss");
		return moduleDao.getAllModule(request);
	}

	/**
	 * returns particular Module to view
	 *
	 */
	@RequestMapping(value = "/viewModuleModal", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestModuleMasterModel>> viewModule(@RequestParam("id") String id) {
		logger.info("Method : viewModule starts");
		logger.info("Method : viewModule ends");
		return moduleDao.viewModule(id);
	}
	
	/**
	 * returns particular Module to view
	 *
	 */
	@RequestMapping(value = "/getEditImage", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> getEditImage( @RequestParam("id") String id,@RequestParam("fileName") String fileName) {
		logger.info("Method : viewModule starts");
		logger.info("Method : viewModule ends");
		return moduleDao.getEditImage(id,fileName);
	}

	

}
