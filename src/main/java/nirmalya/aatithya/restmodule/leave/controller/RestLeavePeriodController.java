/**Defines District master Rest Controller*/
package nirmalya.aatithya.restmodule.leave.controller;

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
import nirmalya.aatithya.restmodule.leave.dao.RestLeavePeriodDao;
import nirmalya.aatithya.restmodule.leave.model.RestLeavePeriodModel;  
/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "leave/")
public class RestLeavePeriodController {

	Logger logger = LoggerFactory.getLogger(RestLeavePeriodController.class);
	@Autowired
	RestLeavePeriodDao leavePeriodDao;
	
	 
	/*
	 * Post Mapping to Add New District master
	 *
	 */
	@RequestMapping(value = "restAddLeavePeriod", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddLeavePeriod(@RequestBody RestLeavePeriodModel table) {
		logger.info("Method : restAddLeavePeriod starts");

		logger.info("Method : restAddLeavePeriod ends");
		// System.out.println("restAddLeavePeriod data : "+table);
		return leavePeriodDao.addLeavePeriod(table);
	}
	
	/*
	 * Get 	getPeriodName
	 *
	 */
	@RequestMapping(value = "getPeriodName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateName(String getPeriodName) {
        	logger.info("Method : getPeriodName starts");

			logger.info("Method : getPeriodName ends");
		return leavePeriodDao.getPeriodName("getPeriodName");
	}
	
	/*
	 * Get 	lPeriodData
	 *
	 */ 
	@RequestMapping(value = "getLperiodData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestLeavePeriodModel>>> getTableMaster(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getLperiodData starts");
		logger.info("Method : getLperiodData ends");
		return leavePeriodDao.getLPeriodDetails(request);
	} 
	
	/*
	 * returns particular to delete  period data 
	 *
	 */
	@RequestMapping(value="deleteLperiodById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> deleteLperiodById(@RequestParam("id") String id) {
		logger.info("Method : deleteLperiodById starts");
		logger.info("Method : deleteLperiodById ends");
		return leavePeriodDao.deleteLperiodById(id);
	}
	
	/*
	 * returns particular  leave Period to view/edit
	 *
	 */
	 @RequestMapping(value = "getLeavePeriodById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestLeavePeriodModel>> getLeavePeriodById(@RequestParam("id")String id,@RequestParam("Action") String action) {
		logger.info("Method : getLeavePeriodById starts");
		logger.info("Method : getLeavePeriodById ends");
		return leavePeriodDao.getLeavePeriodById(id,action);
	} 
	
}
