package nirmalya.aatithya.restmodule.asset.controller;

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

import nirmalya.aatithya.restmodule.asset.dao.AssetPolicyMasterDao;
import nirmalya.aatithya.restmodule.asset.model.AssetPolicyMaster;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.HrmsEmployeeSkillAssignRestController; 

@RestController
@RequestMapping("asset/")
public class AssetPolicyMasterController {
	
	@Autowired
	AssetPolicyMasterDao assetPolicyMasterDao;
	
	Logger logger = LoggerFactory.getLogger(HrmsEmployeeSkillAssignRestController.class);
	/**
	 * @return department list getDriverDetailsAutoSearch
	 */
	@RequestMapping(value = "getFreqList", method = { RequestMethod.GET })
	public List<DropDownModel> getFreqList() {

		logger.info("Method : getFreqList starts");
		logger.info("Method : getFreqList ends");

		return assetPolicyMasterDao.getFreqList();
	}
	
 
	/*
	 * for drop down for po details
	 */
	@RequestMapping(value = "/getItemDetailsAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemDetailsAutoSearch(
			@RequestParam String id) {
		logger.info("Method in rest: getItemDetailsAutoSearch starts");

		logger.info("Method in rest: getItemDetailsAutoSearch ends");
		return assetPolicyMasterDao.getItemDetailsAutoSearch(id);
	}
	
	/*
	 * for drop down for po details
	 */
	@RequestMapping(value = "/getOptionValue", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getOptionValue( ) {
		logger.info("Method in rest: getOptionValue starts");

		logger.info("Method in rest: getOptionValue ends");
		return assetPolicyMasterDao.getOptionValue();
	}
	/*
	 * for Add Other Service price getAssignEduDetails
	 */
	@RequestMapping(value = "restAddPolicy", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddPolicy(
			@RequestBody List<AssetPolicyMaster> hrmEmployeeEducationModel) {
		logger.info("Method in rest: restAddPolicy starts");

		logger.info("Method in rest: restAddPolicy ends");

		return assetPolicyMasterDao.restAddPolicy(hrmEmployeeEducationModel);
	}
	/*
	 * for drop down for trip details by sale order and rmcgrade
	 */
	@RequestMapping(value = "/getServiceDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AssetPolicyMaster>>> getServiceDetails(@RequestParam String itemId ) {
		logger.info("Method in rest: getServiceDetails starts");
		
		 

		logger.info("Method in rest: getServiceDetails ends");
		return assetPolicyMasterDao.getServiceDetails(itemId);
	}
	
	
}
