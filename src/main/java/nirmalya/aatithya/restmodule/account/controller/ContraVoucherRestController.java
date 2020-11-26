package nirmalya.aatithya.restmodule.account.controller;

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

import nirmalya.aatithya.restmodule.account.dao.ContraVoucherDao;
import nirmalya.aatithya.restmodule.account.model.ContraVoucherModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value="account/")
public class ContraVoucherRestController {

	Logger logger = LoggerFactory.getLogger(ContraVoucherRestController.class);
	
	@Autowired
	ContraVoucherDao contraVoucherDao;
	
	/**
	 * REST CONTROLLER - GET CV TYPE
	 *
	 */
	@RequestMapping(value="restGetCVType" , method={RequestMethod.GET})
	public List<DropDownModel> restGetCVType() {
		logger.info("Method : restGetCVType starts");

		logger.info("Method : restGetCVType ends");
		return contraVoucherDao.getCVType();
	}
	
	/**
	 * REST CONTROLLER - GET COST CENTER
	 *
	 */
	@RequestMapping(value="restGetCostCenterList" , method={RequestMethod.GET})
	public List<DropDownModel> restGetCostCenterList() {
		logger.info("Method : restGetCVType starts");

		logger.info("Method : restGetCostCenterList ends");
		return contraVoucherDao.getCostCenterList();
	}
	
	
	@RequestMapping(value = "/restGetAccountAndBankList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ContraVoucherModel>>>restGetAccountAndBankList(@RequestParam String id) {
		logger.info("Method : restGetAccountAndBankList starts");
		logger.info("Method : restGetAccountAndBankList endss");
		return contraVoucherDao.restGetAccountAndBankList(id);
	}
	
	

	@RequestMapping(value = "/toAccountAndBankList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ContraVoucherModel>>>toAccountAndBankList(@RequestParam String id) {
		logger.info("Method : toAccountAndBankList starts");
		logger.info("Method : toAccountAndBankList endss");
		return contraVoucherDao.toAccountAndBankList(id);
	}
	/**
	 * REST CONTROLLER - GET ACCOUNT HEAD TYPE
	 *
	 */
	@RequestMapping(value="restGetAccountHead" , method={RequestMethod.GET})
	public List<DropDownModel> restGetAccountHead(@RequestParam("type") String type) {
		logger.info("Method : restGetAccountHead starts");

		logger.info("Method : restGetAccountHead ends");
		return contraVoucherDao.getAccountHeadTypeList(type);
	}
	
	/**
	 * REST CONTROLLER - GET BRANCH NAME
	 *
	 */
	@RequestMapping(value = "/restGetBranchName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> restGetBranchName(@RequestParam String id) {
		logger.info("Method : restGetBranchName starts");

		logger.info("Method : restGetBranchName ends");
		return contraVoucherDao.getBranchNameDao(id);
	}
	
	/**
	 * REST CONTROLLER - GET ACCOUNT
	 *
	 */
	@RequestMapping(value = "/restGetAccountNo", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> restGetAccountNo(@RequestParam String id) {
		logger.info("Method : restGetAccountNo starts");

		logger.info("Method : restGetAccountNo ends");
		return contraVoucherDao.getAccountNoDao(id);
	}
	
	/**
	 * REST CONTROLLER - ADD NEW CONTRA VOUCHER
	 *
	 */
	@RequestMapping(value = "/restAddContraVoucher", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddContraVoucher(@RequestBody ContraVoucherModel contraVoucher) {
		logger.info("Method : restAddContraVoucher starts");

		logger.info("Method : restAddContraVoucher ends");
		return contraVoucherDao.addContraVoucher(contraVoucher);
	}
	
	/**
	 * REST CONTROLLER - VIEW CONTRA VOUCHER DETAILS
	 *
	 */
	@RequestMapping(value = "/getContraVoucher", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<ContraVoucherModel>>> getContraVoucher(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getContraVoucher starts");

		logger.info("Method : getContraVoucher ends");
		return contraVoucherDao.getContraVoucherDetails(request);
	}
	
	/**
	 * REST CONTROLLER - VIEW CONTRA VOUCHER MODAL
	 *
	 */
	@RequestMapping(value = "/getContraVoucherById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<ContraVoucherModel>> getContraVoucherById(@RequestParam String id) {
		logger.info("Method : getContraVoucherById starts");

		logger.info("Method : getContraVoucherById ends");
		return contraVoucherDao.getContraVoucherById(id);
	}
	
	/**
	 * REST CONTROLLER - CONTRA VOUCHER REPORT
	 *
	 */
	@RequestMapping(value="getContraVoucherReport" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<ContraVoucherModel>>>  getContraVoucherReport(@RequestBody DataTableRequest request) {
		logger.info("Method : getContraVoucherReport for rest controller starts");
		
		logger.info("Method : getContraVoucherReport for rest controller ends");
		return contraVoucherDao.getContraVoucherReport(request);
		
	}
	
	/**
	 * REST CONTROLLER - Get Hotel Logo
	 *
	 */
	@RequestMapping(value="restLogoImage-ContraVoucher" , method={RequestMethod.GET})
	public List<DropDownModel> restHotelLogoImageForContraVoucher(@RequestParam("logoType") String logoType) {
		logger.info("Method : restHotelLogoImageForContraVoucher starts");

		logger.info("Method : restHotelLogoImageForContraVoucher ends");
		return contraVoucherDao.getHotelLogoImageForContraVoucher(logoType);
	}
}
