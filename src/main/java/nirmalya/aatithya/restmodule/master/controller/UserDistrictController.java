/**Defines District master Rest Controller*/
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
import nirmalya.aatithya.restmodule.master.dao.UserDistrictDao;
import nirmalya.aatithya.restmodule.master.model.UserDistrictModel; 
/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "master")
public class UserDistrictController {

	Logger logger = LoggerFactory.getLogger(UserDistrictController.class);
	@Autowired
	UserDistrictDao districtDao;
	
	/*
	 * Get State master
	 *
	 */
	@RequestMapping(value = "getStateName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateName(String getStateName) {
        	logger.info("Method : getStateName starts");

			logger.info("Method : getStateName ends");
		return districtDao.getStateName("getStateName");
	}
	
	/*
	 * Post Mapping to Get District master
	 *
	 */
	@RequestMapping(value = "getDistName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDistName(String getDistName) {
		logger.info("Method : getDistName starts");

		logger.info("Method : getDistName ends");
		return districtDao.getDistName("getDistName");
	}

	/*
	 * Post Mapping to Add New District master
	 *
	 */
	@RequestMapping(value = "restAddDistrict", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddDistrict(@RequestBody UserDistrictModel table) {
		logger.info("Method : restAddDistrict starts");

		logger.info("Method : restAddDistrict ends");
		 System.out.println("District data : "+table);
		return districtDao.addDistrict(table);
	}
	
	/*
	 * returns  District Data
	 *
	 */
	
	 
	
	@RequestMapping(value = "getDistrictData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<UserDistrictModel>>> getTableMaster(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getDistrictData starts");;
		logger.info("Method : getDistrictData ends");
		return districtDao.getDistrictDetails(request);
	}
	
	/*
	 * returns particular District to delete  
	 *
	 */
	@RequestMapping(value="deleteDistrictById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> deleteDistrictById(@RequestParam("id") String id) 
	{
		logger.info("Method : deleteDistrictById starts");
		
		logger.info("Method : deleteDistrictById ends");
		return districtDao.deleteDistrictById(id);
	}
	
	/*
	 * returns particular District to view/edit
	 *
	 */
	@RequestMapping(value = "/getDistrictById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<UserDistrictModel>> getDistrictById(@RequestParam("id")String id,@RequestParam("Action") String action) {
		logger.info("Method : getDistrictById starts");

		logger.info("Method : getDistrictById ends");
		return districtDao.getDistrictById(id,action);
	}
	
}
