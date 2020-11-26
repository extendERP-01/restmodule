package nirmalya.aatithya.restmodule.user.controller;

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
import nirmalya.aatithya.restmodule.user.dao.UserMemRegistrationDao; 
import nirmalya.aatithya.restmodule.user.model.UserMembershipRegistrationModel; 
import nirmalya.aatithya.restmodule.user.model.UserMemberDataRegistrationModel;
import nirmalya.aatithya.restmodule.user.model.UserMemberDepCountModel; 

@RestController
@RequestMapping(value = "user")
public class UserMemberShipRegistrationController {
	

	Logger logger = LoggerFactory.getLogger(UserMemberShipRegistrationController.class);
	
	@Autowired
	UserMemRegistrationDao userMemRegistrationDao;
	
	
	/**
	 * Post Mapping to AddUserRole Record
	 *
	 */
	@RequestMapping(value = "restAddMemberReg", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddMemberReg(@RequestBody  List<UserMembershipRegistrationModel> table) {
		logger.info("Method : restAddMemberReg starts");
	    logger.info("Method : restAddMemberReg ends");
		return userMemRegistrationDao.AddMemberReg(table);
	}
	
	/**
	 * Post Mapping to AddUserRole Record for Edit page
	 *
	 */
	@RequestMapping(value = "restUpdateMemberReg", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restUpdateMemberReg(@RequestBody  List<UserMembershipRegistrationModel> table) {
		logger.info("Method : restUpdateMemberReg starts");
		logger.info("Method : restUpdateMemberReg ends");
		return userMemRegistrationDao.restUpdateMemberReg(table);
	}
	
	
	/*
	 * returns  Member Reg Data
	 *
	 */
	@RequestMapping(value = "getMemberRegData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<UserMembershipRegistrationModel>>> getTableMaster(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getMemberRegData starts");
		logger.info("Method : getMemberRegData ends");
		return userMemRegistrationDao.getMemberRegDetails(request);
	}
	

	/*
	 * returns particular Member to delete  
	 *
	 */
	@RequestMapping(value="deleteMembershipRegById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> deleteMembershipRegById(@RequestParam("id") String id,@RequestParam("deletedBy") String deletedBy) 
	{
		logger.info("Method : deleteMembershipRegById starts");
		logger.info("Method : deleteMembershipRegById ends");
		return userMemRegistrationDao.deleteMembershipRegById(id,deletedBy);
	}
	
	
	
	/*
	 * 
	 * Get mapping for get one Membership for model view
	 * 
	 * 
	 */
	
	
	@RequestMapping(value = "getMembershipRegistrationModel", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<UserMembershipRegistrationModel>>> getMembershipRegistrationModel(@RequestParam("id") String id) {
		logger.info("Method : getMembershipRegistrationModel starts");
		logger.info("Method : getMembershipRegistrationModel endss");
		return userMemRegistrationDao.getMembershipRegistrationModel(id);
	}
 
	
	/*
	 * 
	 * Get mapping for get one Membership for Edit view
	 * 
	 * 
	 */
	
	@RequestMapping(value = "/getMembershipRegistrationEdit", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<UserMemberDataRegistrationModel>>> getMembershipRegistrationEdit(@RequestParam("id")String id,@RequestParam("Action") String action) {
		logger.info("Method : getMembershipRegistrationEdit starts");
		logger.info("Method : getMembershipRegistrationEdit ends");
		return userMemRegistrationDao.getMembershipRegistrationEdit(id,action);
	}
	
	/* 
	 * 
	 * getMemberData dependent
	 *  
	 */
	
	 @RequestMapping(value = "/getMemberRegistEditdep", method = { RequestMethod.GET })
	 public ResponseEntity<JsonResponse<List<UserMemberDataRegistrationModel>>> getMemberRegistEditdep(@RequestParam("id")String id,@RequestParam("Action") String action) { 
		 logger.info("Method : getMemberRegistEditdep starts");
		 logger.info("Method : getMemberRegistEditdep ends"); return
		 userMemRegistrationDao.getMemberRegistEditdep(id,action); 
	 }
	 
	
	
	/* 
	 * 
	 * getMemberData 
	 *  
	 */
	@RequestMapping(value = "getMemberData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getMemberData(String getMemberName) {
		logger.info("Method : getMemberData starts");
		logger.info("Method : getMemberData ends");
		return userMemRegistrationDao.getMemberData("getMemberData");
	}
	
	
	/* 
	 * 
	 * getRelationData 
	 *  
	 */
	@RequestMapping(value = "getRelationData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRelationData(String getRelationData) {
		logger.info("Method : getRelationData starts");
		logger.info("Method : getRelationData ends");
		return userMemRegistrationDao.getRelationData("getRelationData");
	}
	
	/* 
	 * 
	 * getRelationSelfData 
	 *  
	 */
	@RequestMapping(value = "getRelationSelfData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRelationSelfData(String getRelationSelfData) {
		logger.info("Method : getRelationSelfData starts");
		logger.info("Method : getRelationSelfData ends");
		return userMemRegistrationDao.getRelationSelfData("getRelationSelfData");
	}
	
	
	/* 
	 * 
	 * getUTypeData 
	 *  
	 */
	@RequestMapping(value = "getUTypeData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getUTypeData(String getUTypeData) {
		logger.info("Method : getUTypeData starts");
		logger.info("Method : getUTypeData ends");
		return userMemRegistrationDao.getUTypeData("getUTypeData");
	}
	
	
	/* 
	 * 
	 * getRelationData 
	 *  
	 */
	@RequestMapping(value = "getDisData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDisData(String getDisData) {
		logger.info("Method : getDisData starts");
		logger.info("Method : getDisData ends");
		return userMemRegistrationDao.getDisData("getDisData");
	}
	
	/* 
	 * 
	 * getPaymentModeData 
	 *  
	 */
	@RequestMapping(value = "getPaymentModeData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPaymentModeData(String getPaymentModeData) {
		logger.info("Method : getPaymentModeData starts");
		logger.info("Method : getPaymentModeData ends");
		return userMemRegistrationDao.getPaymentModeData("getPaymentModeData");
	}
	
	/* 
	 * 
	 * getStateData 
	 *  
	 */
	@RequestMapping(value = "getStateData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateData(String getStateName) {
		logger.info("Method : getStateData starts");
		logger.info("Method : getStateData ends");
		return userMemRegistrationDao.getStateData("getStateData");
	}
	
	/*
	 * 
	 * Get mapping for  get District Name for state
	 * 
	 * 
	 */
	
	@RequestMapping(value = "getDistrictName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDistrictName(@RequestParam String id) {
		logger.info("Method : getDistrictName starts");
		logger.info("Method : getDistrictName endss");
		return userMemRegistrationDao.getDistrictName(id);
	}
	
	
	
	/*
	 * 
	 * Get mapping for  get total_dep_can_be_add
	 * 
	 * 
	 */
	
	@RequestMapping(value = "getTotalDepAdd", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<UserMemberDepCountModel>>> getTotalDepAdd(@RequestParam String id) {
		logger.info("Method : getTotalDepAdd starts");
		logger.info("Method : getTotalDepAdd endss");
		return userMemRegistrationDao.getTotalDepAdd(id);
	}
	

}
