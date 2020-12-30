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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.UserSacCodeDao;
import nirmalya.aatithya.restmodule.master.model.UserSacCodeModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "master")
public class UserSacCodeRestController {
	Logger logger = LoggerFactory.getLogger(UserSacCodeRestController.class);

	@Autowired
	UserSacCodeDao sacMasterDao;

	/*
	 * 
	 * post mapping for add rest SacCode
	 * 
	 * 
	 */
	@RequestMapping(value = "addNewSacMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restaddSacMaster(@RequestBody UserSacCodeModel restSacMasterModel) {

		return sacMasterDao.addSacMaster(restSacMasterModel);

	}

	/*
	 * 
	 * post Mapping for listing SacCode
	 * 
	 * 
	 */
	@RequestMapping(value = "getAllSacMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<UserSacCodeModel>>> getAllSacMaster(@RequestBody DataTableRequest request) {
		return sacMasterDao.getAllSacMaster(request);
	}

	/*
	 * 
	 * GetMapping for delete SacCode
	 * 
	 * 
	 */
	@RequestMapping(value = "/deleteSacMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteSacMaster(@RequestParam String id) {
		return sacMasterDao.deleteSacMaster(id);
	}

	/**
	 * returns particular SacCode to view/edit
	 *
	 */
	@RequestMapping(value = "getSacMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<UserSacCodeModel>> getSacMaster(@RequestParam String id) {
		return sacMasterDao.getSacMaster(id);
	}
	
	/*
	 * 
	 * PostMapping for add service  name
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-serviceName", method = { RequestMethod.GET })
	public List<DropDownModel> getServiceNameList() {
		logger.info("Method : getServiceNameList starts");
		logger.info("Method : getServiceNameList ends");
		return sacMasterDao.getServiceNameList();
	}
}
