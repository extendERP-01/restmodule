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
import nirmalya.aatithya.restmodule.master.dao.RestFunctionMasterDao;
import nirmalya.aatithya.restmodule.master.model.RestFunctionMasterModel;

/**
 * @author NirmalyaLabs
 *
 */

@RestController
@RequestMapping(value = "master")
public class RestFunctionMasterController {

	@Autowired
	RestFunctionMasterDao functionDao;

	Logger logger = LoggerFactory.getLogger(RestModuleMasterController.class);

	/**
	 * returns all function
	 *
	 */
	@RequestMapping(value = "/getAllFunction", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestFunctionMasterModel>>> getAllModule(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllFunction starts");
		logger.info("Method : getAllFunction endss");
		return functionDao.getAllFunction(request);
	}

	/**
	 * returns particular function to view
	 *
	 */
	@RequestMapping(value = "/viewFunctionModal", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestFunctionMasterModel>> viewFunction(@RequestParam("id") String id) {
		logger.info("Method : viewFunction starts");
		logger.info("Method : viewFunction ends");
		return functionDao.viewFunction(id);
	}

	/**
	 * for edit function logo
	 *
	 */
	@RequestMapping(value = "/getUploadFunctionImage", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> getEditImage( @RequestParam("id") String id,@RequestParam("fileName") String fileName) {
		logger.info("Method : getUploadFunctionImage starts");
		logger.info("Method : getUploadFunctionImage ends");
		return functionDao.getUploadFunctionImage(id,fileName);
	}
	
}
