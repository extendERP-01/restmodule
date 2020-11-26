package nirmalya.aatithya.restmodule.reimbursement.controller;

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
import nirmalya.aatithya.restmodule.reimbursement.dao.HrmsPolicyMasterDao;
import nirmalya.aatithya.restmodule.reimbursement.model.HrmsPolicyMasterModel;

@RestController
@RequestMapping("reimbursement/")
public class HrmsPolicyMasterRestController {
	Logger logger = LoggerFactory.getLogger(HrmsPolicyMasterRestController.class);

	@Autowired
	HrmsPolicyMasterDao hrmspolicyTypeDao;

	/*
	 * for All policyType
	 */
	@RequestMapping(value = "getpolicyTypeDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsPolicyMasterModel>>> getpolicyTypeDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getpolicyTypeDetails starts");

		logger.info("Method : getpolicyTypeDetails ends");

		return hrmspolicyTypeDao.getpolicyTypeDetails(request);
	}

	/*
	 * for All Add policyType
	 */
	@RequestMapping(value = "restAddpolicyTypes", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddpolicyType(@RequestBody HrmsPolicyMasterModel policyType) {
		logger.info("Method : restAddpolicyType starts");

		logger.info("Method : restAddpolicyType ends");

		return hrmspolicyTypeDao.addpolicyType(policyType);
	}

	/*
	 * for policyType Edit
	 */
	@RequestMapping(value = "getpolicyTypeById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<HrmsPolicyMasterModel>> getpolicyTypeById(@RequestParam String id) {
		logger.info("Method : getpolicyTypeById starts");

		logger.info("Method : getpolicyTypeById ends");

		return hrmspolicyTypeDao.getpolicyTypeById(id);
	}

	/*
	 * for All policyType Delete
	 */
	@RequestMapping(value = "deletepolicyTypeById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletepolicyTypeById(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deletepolicyTypeById starts");

		logger.info("Method : deletepolicyTypeById ends");

		return hrmspolicyTypeDao.deletepolicyTypeById(id, createdBy);
	}
	/**
	 * 
	 * @return requisition  list
	 */
	@RequestMapping(value = "/getReimbTypeListForPolicy", method = { RequestMethod.GET })
	public List<DropDownModel> getReqListPayment() {

		logger.info("Method : getReimbTypeListForPolicy starts");
		logger.info("Method : getReimbTypeListForPolicy ends");

		return hrmspolicyTypeDao.getReimbTypeListForPolicy();
	}
	/**
	 * 
	 * @return requisition  list
	 */
	@RequestMapping(value = "/getTimePeriod", method = { RequestMethod.GET })
	public List<DropDownModel> getTimePeriod() {

		logger.info("Method : getTimePeriod starts");
		logger.info("Method : getTimePeriod ends");

		return hrmspolicyTypeDao.getTimePeriod();
	}
	/**
	 * 
	 * @return user role  list
	 */
	@RequestMapping(value = "/getUserRole", method = { RequestMethod.GET })
	public List<DropDownModel> getUserRole() {

		logger.info("Method : getUserRole starts");
		logger.info("Method : getUserRole ends");

		return hrmspolicyTypeDao.getUserRole();
	}
}
