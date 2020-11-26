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
import nirmalya.aatithya.restmodule.master.dao.RestActivityMasterDao;
import nirmalya.aatithya.restmodule.master.model.RestActivityMasterModel;

/**
 * @author NirmalyaLabs
 *
 */

@RestController
@RequestMapping(value = "master")
public class RestActivityMasterController {

	@Autowired
	RestActivityMasterDao activityDao;

	Logger logger = LoggerFactory.getLogger(RestActivityMasterController.class);

	/**
	 * returns all function
	 *
	 */
	@RequestMapping(value = "/getAllActivity", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestActivityMasterModel>>> getAllActivity(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllActivity starts");
		logger.info("Method : getAllActivity endss");
		return activityDao.getAllActivity(request);
	}

	/**
	 * returns particular function to view
	 *
	 */
	@RequestMapping(value = "/viewActivityModal", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestActivityMasterModel>> viewActivity(@RequestParam("id") String id) {
		logger.info("Method : viewActivity starts");
		logger.info("Method : viewActivity ends");
		return activityDao.viewActivity(id);
	}

}
