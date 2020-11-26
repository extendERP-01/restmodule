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
import nirmalya.aatithya.restmodule.reimbursement.dao.HrmsReimbursementPaymentDao;
import nirmalya.aatithya.restmodule.reimbursement.model.HrmsEmployeeCompanyDetailsModel;
import nirmalya.aatithya.restmodule.reimbursement.model.HrmsReimbursementModel;
import nirmalya.aatithya.restmodule.reimbursement.model.HrmsReimbursementPaymentModal;

@RestController
@RequestMapping(value = "reimbursement")
public class HrmsReimbursementPaymentRestController {
	Logger logger = LoggerFactory.getLogger(HrmsReimbursementRestController.class);
	
	@Autowired
	HrmsReimbursementPaymentDao hrmsReimbursementPaymentDao ;
	
	/**
	 * 
	 * @return requisition  list
	 */
	@RequestMapping(value = "/getReqListPayment", method = { RequestMethod.GET })
	public List<DropDownModel> getReqListPayment() {

		logger.info("Method : getReqListPayment starts");
		logger.info("Method : getReqListPayment ends");

		return hrmsReimbursementPaymentDao.getReqListPayment();
	}
	/**
	 * 
	 * @return requisition  list
	 */
	@RequestMapping(value = "/getEmpListPayment", method = { RequestMethod.GET })
	public List<DropDownModel> getEmpListPayment() {

		logger.info("Method : getEmpListPayment starts");
		logger.info("Method : getEmpListPayment ends");

		return hrmsReimbursementPaymentDao.getEmpListPayment();
	}
	
	/*
	 * for getGRN list for payment
	 */
	@RequestMapping(value = "getReimbursementListPayment", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsReimbursementPaymentModal>>> getReimbursementListPayment(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getReimbursementListPayment starts");
		logger.info("Method : getReimbursementListPayment ends");

		return hrmsReimbursementPaymentDao.getReimbursementListPayment(request);
	}
	
	/*
	 * for drop down for grt Pay Mode type
	 */
	@RequestMapping(value = "getPayMode", method = { RequestMethod.GET })
	public List<DropDownModel> getPayMode() {

		logger.info("Method in rest: getPayMode starts");

		logger.info("Method in rest: getPayMode ends");

		return hrmsReimbursementPaymentDao.getPayMode();
	}

	/*
	 * for drop down for grt Pay Mode type
	 */
	@RequestMapping(value = "getBankNames", method = { RequestMethod.GET })
	public List<DropDownModel> getBankNames() {

		logger.info("Method in rest: getBankNames starts");

		logger.info("Method in rest: getBankNames ends");

		return hrmsReimbursementPaymentDao.getBankNames();
	}

	/*
	 * for drop down of branch name list
	 */
	@RequestMapping(value = "/getBranchList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getBranchList(@RequestParam String id) {
		logger.info("Method in rest: getBranchList starts");

		logger.info("Method in rest: getBranchList ends");
		return hrmsReimbursementPaymentDao.getBranchList(id);
	}

	/*
	 * for drop down of account number list by branch name
	 */
	@RequestMapping(value = "/getAccountNoList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAccountNoList(@RequestParam String id) {
		logger.info("Method in rest: getAccountNoList starts");

		logger.info("Method in rest: getAccountNoList ends");
		return hrmsReimbursementPaymentDao.getAccountNoList(id);
	}

	/*
	 * for drop down of account number list by branch name
	 */
	@RequestMapping(value = "/getAccountNameList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAccountNameList(@RequestParam String id) {
		logger.info("Method in rest: getAccountNameList starts");

		logger.info("Method in rest: getAccountNameList ends");
		return hrmsReimbursementPaymentDao.getAccountNameList(id);
	}
	/*
	 * for Add payment voucher
	 */
	@RequestMapping(value = "addReimbursementVoucher", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addReimbursementVoucher(
			@RequestBody List<HrmsReimbursementPaymentModal> paymentVoucherModel) {
		logger.info("Method in rest: restAddPaymentVoucher starts");

		logger.info("Method in rest: restAddPaymentVoucher ends");

		return hrmsReimbursementPaymentDao.addReimbursementVoucher(paymentVoucherModel);
	}

	/*
	 * for get return details by payment voucher
	 */
	@RequestMapping(value = "/getReimbPayData", method = { RequestMethod.GET })
	public List<HrmsReimbursementPaymentModal> getReturnData(@RequestParam String id) {
		logger.info("Method : getReimbPayData for rest controller starts");

		logger.info("Method : getReimbPayData for rest controller ends");
		return hrmsReimbursementPaymentDao.getReimbPayData(id);
	}

	/*
	 * for drop down of charge name
	 */
	@RequestMapping(value = "getVenderDetails", method = { RequestMethod.GET })
	public List<HrmsEmployeeCompanyDetailsModel> getVenderDetails(@RequestParam String id) {

		logger.info("Method in rest: getVenderDetails starts");

		logger.info("Method in rest: getVenderDetails ends");

		return hrmsReimbursementPaymentDao.getVenderDetails(id);
	}
	
	/*
	 * for drop down of charge name
	 */
	@RequestMapping(value = "getHotelDetails", method = { RequestMethod.GET })
	public List<HrmsEmployeeCompanyDetailsModel> getHotelDetails(@RequestParam String id) {

		logger.info("Method in rest: getHotelDetails starts");

		logger.info("Method in rest: getHotelDetails ends");

		return hrmsReimbursementPaymentDao.getHotelDetails(id);
	}

	/**
	 * REST CONTROLLER - Get Hotel Logo
	 *
	 */
	@RequestMapping(value = "restLogoImage-PaymentVoucher", method = { RequestMethod.GET })
	public List<DropDownModel> restGetLogoImageForPayVocher(@RequestParam("logoType") String logoType) {
		logger.info("Method : restGetLogoImage starts");

		logger.info("Method : restGetLogoImage ends");
		return hrmsReimbursementPaymentDao.getHotelLogoForVoucher(logoType);
	}
	/*
	 * for view all payment voucher
	 */
	@RequestMapping(value = "getAllReimbursementPaymentVoucher", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsReimbursementPaymentModal>>> getAllPaymentVoucher(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllReimbursementPaymentVoucher starts");

		logger.info("Method : getAllReimbursementPaymentVoucher ends");

		return hrmsReimbursementPaymentDao.getAllReimbursementPaymentVoucher(request);
	}
	/*
	 * for Add payment voucher
	 */
	@RequestMapping(value = "getReimbursementModal", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<HrmsReimbursementPaymentModal>> getReimbursementModal(
			@RequestParam String id) {
		logger.info("Method in rest: getReimbursementModal starts");

		logger.info("Method in rest: getReimbursementModal ends");

		return hrmsReimbursementPaymentDao.getReimbursementModal(id);
	}
	/*
	 * for get reimbursement by id
	 */
	@RequestMapping(value = "getReimbusementByIdModal", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsReimbursementModel>>> getReimbusementByIdModal(
			@RequestParam String reimId) {
		logger.info("Method : getReimbusementByIdModal starts");

		logger.info("Method : getReimbusementByIdModal ends");

		return hrmsReimbursementPaymentDao.getReimbusementByIdModal(reimId);
	}
}
