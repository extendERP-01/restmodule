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
import nirmalya.aatithya.restmodule.master.dao.RestServiceMasterDao; 
import nirmalya.aatithya.restmodule.master.model.RestServiceMasterModel;

/**
 * @author NirmalyaLabs
 *
 */

@RestController
@RequestMapping(value = "master")
public class RestServiceMasterController {
	@Autowired
	RestServiceMasterDao serviceDao;

	Logger logger = LoggerFactory.getLogger(RestServiceMasterController.class);
	
	
	/**
	 * Post Mapping to Add new Service 
	 *
	 */
	@RequestMapping(value = "/restAddNewService", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddNewService(
			@RequestBody RestServiceMasterModel serviceMaster) {
		logger.info("Method : restAddNewService starts");
		logger.info("Method : restAddNewService endss");
		return serviceDao.restAddNewService(serviceMaster);
	}
	
	/**
	 * returns all Service
	 *
	 */
	@RequestMapping(value = "/getAllService", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestServiceMasterModel>>> getAllService(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllService starts");
		logger.info("Method : getAllService endss");
		return serviceDao.getAllService(request);
	}
	/**
	 * returns particular HouseKeeping Task to view/edit
	 *
	 */
	@RequestMapping(value = "/viewServiceModal", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestServiceMasterModel>> viewServiceModal(@RequestParam("id") String id) {
		logger.info("Method : viewServiceModal starts");
		logger.info("Method : viewServiceModal ends");
		return serviceDao.viewServiceModal(id);
	}
	
	/**
	 * delete particular Service
	 *
	 */
	@RequestMapping(value = "/deleteService", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteService(@RequestParam String id,@RequestParam String createdBy) {

		logger.info("Method : deleteService starts");

		logger.info("Method : deleteService end");

		return serviceDao.deleteService(id,createdBy);
	}
}
