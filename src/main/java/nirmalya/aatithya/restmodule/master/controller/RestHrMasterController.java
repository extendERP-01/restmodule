package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.RestHrMasterDao;
import nirmalya.aatithya.restmodule.master.model.RestHrMasterModel;

@RestController
@RequestMapping(value = { "/master" })
public class RestHrMasterController {
	Logger logger = LoggerFactory.getLogger(RestHrMasterController.class);

	@Autowired
	RestHrMasterDao restHrMasterDao;

	/*
	 * 
	 * post mapping for add JOB TYPE
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-addnew-job-type", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddJobType(@RequestBody RestHrMasterModel restHrMasterModel) {
		logger.info("Method : restAddJobType starts");

		logger.info("Method : restAddJobType endss");
		return restHrMasterDao.addJobType(restHrMasterModel);
	}

	
	@RequestMapping(value = "rest-view-Job-Type", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewJobType() {
		logger.info("Method : rest view job type starts");

		logger.info("Method : rest view job type  ends");
		return restHrMasterDao.getAllJobs();
	}

}
