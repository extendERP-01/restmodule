package nirmalya.aatithya.restmodule.account.controller;

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

import nirmalya.aatithya.restmodule.account.dao.FinancialDao;
import nirmalya.aatithya.restmodule.account.dao.TdsMasterDao;
import nirmalya.aatithya.restmodule.account.model.FinancialModel;
import nirmalya.aatithya.restmodule.account.model.TdsMasterModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "account/")
public class TdsMasterRestController {
	Logger logger = LoggerFactory.getLogger(TdsMasterRestController.class);
	@Autowired
	TdsMasterDao tdsMasterDao;
	@RequestMapping(value = "/addTdsMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addTdsMaster(@RequestBody TdsMasterModel form) {

		logger.info("Method : addTdsMaster starts");

		logger.info("Method : addTdsMaster end");

		return tdsMasterDao.addTdsMaster(form);

	}
	@RequestMapping(value = "/getAllTdsMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<TdsMasterModel>>> getAllTdsMaster(@RequestBody DataTableRequest request) {

		logger.info("Method : getAllTdsMaster starts");

		logger.info("Method : getAllTdsMaster end");

		return tdsMasterDao.getAllTdsMaster(request);
	}
	
	
	@RequestMapping(value = "/getTdsById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<TdsMasterModel>> getTdsById(@RequestParam String id,
			@RequestParam("Action") String action) {
		logger.info("Method : getTdsById starts");

		logger.info("Method : getTdsById end");

		return tdsMasterDao.getTdsById(id, action);
	}
}
