package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.GlobalRestDao;
import nirmalya.aatithya.restmodule.master.model.GlobalMasterRestModel;
import nirmalya.aatithya.restmodule.master.model.LocationMasterModel;

@RestController
@RequestMapping(value = "master")
public class GlobalMasterRestController {

	Logger logger = LoggerFactory.getLogger(GlobalMasterRestController.class);

	@Autowired
	GlobalRestDao globalrestdao;
	@Autowired
	EntityManager em;

	@RequestMapping(value = "viewGlobalMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> viewGlobalMaster() {
		logger.info("Method : viewGlobalMaster starts");

		logger.info("Method : viewGlobalMaster ends");
		return globalrestdao.viewGlobalMaster();
	}

	@RequestMapping(value = "addGlobalMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addGlobalMaster(@RequestBody GlobalMasterRestModel globalMasterRestModel) {
		logger.info("Method : addGlobalMaster starts");
System.out.println(globalMasterRestModel);
		logger.info("Method : addGlobalMaster ends");
		return globalrestdao.addGlobalMaster(globalMasterRestModel);
	}
	
	@RequestMapping(value = "addStateMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addStateMaster(@RequestBody GlobalMasterRestModel globalMasterRestModel) {
		logger.info("Method : addStateMaster starts");
System.out.println(globalMasterRestModel);
		logger.info("Method : addStateMaster ends");
		return globalrestdao.addStateMaster(globalMasterRestModel);
	}

	@RequestMapping(value = "viewStateMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> viewStateMaster() {
		logger.info("Method : viewStateMaster starts");

		logger.info("Method : viewStateMaster ends");
		return globalrestdao.viewStateMaster();
	}
	
	@RequestMapping(value = "addCityMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addCityMaster(@RequestBody GlobalMasterRestModel globalMasterRestModel) {
		logger.info("Method : addCityMaster starts");
		logger.info("Method : addCityMaster ends");
		return globalrestdao.addCityMaster(globalMasterRestModel);
	}

	@RequestMapping(value = "viewCityMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> viewCityMaster() {
		logger.info("Method : viewCityMaster starts");

		logger.info("Method : viewCityMaster ends");
		return globalrestdao.viewCityMaster();
	}
	
}
