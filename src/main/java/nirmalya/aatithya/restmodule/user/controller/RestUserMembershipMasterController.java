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
import nirmalya.aatithya.restmodule.user.dao.RestUserMemberMstrDao;
import nirmalya.aatithya.restmodule.user.model.RestUserMembershipMstrModel;


@RestController
@RequestMapping(value = "user")
public class RestUserMembershipMasterController {

	
	Logger logger = LoggerFactory.getLogger(RestUserMembershipMasterController.class);
	@Autowired
	RestUserMemberMstrDao userMemberMstrDao;
	
	/*
	 * Get Validity Name
	 *
	 */
	@RequestMapping(value = "getValidityName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getValidityName(String getValidityName) {
        	logger.info("Method : getValidityName starts");
			logger.info("Method : getValidityName ends");
		return userMemberMstrDao.getValidityName("getValidityName");
	}
	
	
	
	/*
	 * Post Mapping to Add New membership mstr
	 *
	 */
	@RequestMapping(value = "restAddMemberMstr", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddMemberMstr(@RequestBody RestUserMembershipMstrModel table) {
		logger.info("Method : restAddMemberMstr starts");

		logger.info("Method : restAddMemberMstr ends");

		return userMemberMstrDao.addmemberMstr(table);
	}
	
	
	
	
	
	/*
	 * returns  Membership Data
	 *
	 */
	@RequestMapping(value = "getMembershipMstrData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestUserMembershipMstrModel>>> getTableMaster(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getMembershipMstrData starts");

		logger.info("Method : getMembershipMstrData ends");
		return userMemberMstrDao.getMembershipMstrDetails(request);
	}
	
	
	
	/*
	 * returns particular Membership Details to view/edit
	 *
	 */
	@RequestMapping(value = "/getMemberMstrById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestUserMembershipMstrModel>> getDistrictById(@RequestParam("id")String id,@RequestParam("Action") String action) {
		logger.info("Method : getMemberMstrById starts");
		logger.info("Method : getMemberMstrById ends");
		return userMemberMstrDao.getMemberMstrById(id,action);
	}
	
	
	/*
	 * returns particular  Membership Mstr to delete  
	 *
	 */
	@RequestMapping(value="deleteMmbrspById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> deleteMmbrspById(@RequestParam("id") String id,@RequestParam("createdBy") String createdBy) 
	{
		logger.info("Method : deleteMmbrspById starts");
		
		logger.info("Method : deleteMmbrspById ends");
		return userMemberMstrDao.deleteMmbrspById(id,createdBy);
	}
	
	/*
	 * 
	 * PostMapping for add get member type
	 * 
	 * 
	 */
	@RequestMapping(value = "restGetMemberType", method = { RequestMethod.GET })
	public List<DropDownModel> getMemberType() {
		logger.info("Method : getMemberType starts");
		logger.info("Method : getMemberType ends");
		return userMemberMstrDao.getMemberType();
	}
}
