/**Defines State master Rest Controller*/
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
import nirmalya.aatithya.restmodule.master.dao.UserStateDao;
import nirmalya.aatithya.restmodule.master.model.UserStateModel;
/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "master")
public class UserStateController {

	Logger logger = LoggerFactory.getLogger(UserStateController.class);
	@Autowired
	UserStateDao stateDao;
	
	/*
	 * Post Mapping to Add new state master
	 *
	 */
	@RequestMapping(value = "restAddState", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddTest(@RequestBody UserStateModel table) {
		logger.info("Method : getStateData starts");

		logger.info("Method : getStateData ends");
		 System.out.println("state data : "+table);
		return stateDao.addState(table);
	}
	
	/*
	 * returns  State to get Data 
	 *
	 */
	@RequestMapping(value = "/getStateData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<UserStateModel>>> getTableMaster(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getStateData starts");

		logger.info("Method : getStateData ends");
		return stateDao.getStateDetails(request);
	}
	
	
	
	/*
	 * Get Country master
	 *
	 */
	@RequestMapping(value = "getCountryName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCountryName(String getCountryName) {
    	logger.info("Method : getCountryName starts");

		logger.info("Method : getCountryName ends");
		return stateDao.getCountryName("getCountryName");
	}
	
	/*
	 * returns particular State to Delete  
	 *
	 */
	@RequestMapping(value="/deleteStateById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> deleteStateById(@RequestParam("id") String id) 
	{
		logger.info("Method : deleteStateById starts");
		System.out.println("Id to be deleted : "+id);
		logger.info("Method : deleteStateById ends");
		return stateDao.deleteStateById(id);
	}
	
	/*
	 * returns particular State to View/Edit
	 *
	 */
	 
	@RequestMapping(value = "/getStateById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<UserStateModel>> getTableMasterById(@RequestParam("id")String id,@RequestParam("Action") String action) {
		logger.info("Method : getStateById starts");

		logger.info("Method : getStateById ends");
		return stateDao.getStateById(id,action);
	}
	 
}
