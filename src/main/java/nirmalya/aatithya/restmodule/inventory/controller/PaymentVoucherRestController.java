package nirmalya.aatithya.restmodule.inventory.controller;

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
import nirmalya.aatithya.restmodule.inventory.dao.PaymentVoucherDao;
import nirmalya.aatithya.restmodule.inventory.model.InventoryGrnPaymentDetails;
import nirmalya.aatithya.restmodule.inventory.model.PaymentVoucherModel;

@RestController
@RequestMapping("inventory/")

public class PaymentVoucherRestController {

	Logger logger = LoggerFactory.getLogger(PaymentVoucherRestController.class);
	@Autowired
	PaymentVoucherDao paymentVoucherDao;

	/*
	 * get po list by auto search
	 */
	@RequestMapping(value = "getPOrderByAutosearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPOrderByAutosearch(@RequestParam String id) {
		logger.info("Method : getPOrderByAutosearch starts");

		logger.info("Method : getPOrderByAutosearch ends");
		return paymentVoucherDao.getPOrderByAutosearch(id);
	}

	/*
	 * get vendor list by auto search
	 */
	@RequestMapping(value = "getVendorByAutosearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorByAutosearch(@RequestParam String id) {
		logger.info("Method : getVendorByAutosearch starts");

		logger.info("Method : getVendorByAutosearch ends");
		return paymentVoucherDao.getVendorByAutosearch(id);
	}

	/*
	 * for getGRN list getVendorByAutosearch
	 */
	@RequestMapping(value = "getGRNList", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<PaymentVoucherModel>>> getGRNList(@RequestBody DataTableRequest request) {
		logger.info("Method : getGRNList starts");
		logger.info("Method : getGRNList ends");

		return paymentVoucherDao.getGRNList(request);
	}

	/*
	 * get payment values
	 */
	@RequestMapping(value = "getPaymentValues", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<PaymentVoucherModel>>> getPaymentValues(@RequestParam String id) {
		logger.info("Method : getPaymentValues starts");

		logger.info("Method : getPaymentValues ends");
		return paymentVoucherDao.getPaymentValues(id);
	}

	/*
	 * get payment values
	 */
	@RequestMapping(value = "getReturnValues", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<PaymentVoucherModel>>> getReturnValues(@RequestParam String id) {
		logger.info("Method : getReturnValues starts");

		logger.info("Method : getReturnValues ends");
		return paymentVoucherDao.getReturnValues(id);
	}

	/*
	 * for drop down for grt Pay Mode type
	 */
	@RequestMapping(value = "getPayMode", method = { RequestMethod.GET })
	public List<DropDownModel> getPayMode() {

		logger.info("Method in rest: getPayMode starts");

		logger.info("Method in rest: getPayMode ends");

		return paymentVoucherDao.getPayMode();
	}

	/*
	 * for drop down for grt Pay Mode type
	 */
	@RequestMapping(value = "getBankNames", method = { RequestMethod.GET })
	public List<DropDownModel> getBankNames() {

		logger.info("Method in rest: getBankNames starts");

		logger.info("Method in rest: getBankNames ends");

		return paymentVoucherDao.getBankNames();
	}

	/*
	 * for drop down of branch name list
	 */
	@RequestMapping(value = "/getBranchList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getBranchList(@RequestParam String id) {
		logger.info("Method in rest: getBranchList starts");

		logger.info("Method in rest: getBranchList ends");
		return paymentVoucherDao.getBranchList(id);
	}

	/*
	 * for drop down of account number list by branch name
	 */
	@RequestMapping(value = "/getAccountNoList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAccountNoList(@RequestParam String id) {
		logger.info("Method in rest: getAccountNoList starts");

		logger.info("Method in rest: getAccountNoList ends");
		return paymentVoucherDao.getAccountNoList(id);
	}

	/*
	 * for drop down of account number list by branch name
	 */
	@RequestMapping(value = "/getAccountNameList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAccountNameList(@RequestParam String id) {
		logger.info("Method in rest: getAccountNameList starts");

		logger.info("Method in rest: getAccountNameList ends");
		return paymentVoucherDao.getAccountNameList(id);
	}

	/*
	 * for Add payment voucher
	 */
	@RequestMapping(value = "restAddPaymentVoucher", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restPaymentOfMultipleGRN(
			@RequestBody List<PaymentVoucherModel> paymentVoucherModel) {
		logger.info("Method in rest: restAddPaymentVoucher starts");

		logger.info("Method in rest: restAddPaymentVoucher ends");

		return paymentVoucherDao.restAddPaymentVoucher(paymentVoucherModel);
	}

	/*
	 * for view all payment voucher
	 */
	@RequestMapping(value = "getAllPaymentVoucher", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<PaymentVoucherModel>>> getAllPaymentVoucher(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllPaymentVoucher starts");

		logger.info("Method : getAllPaymentVoucher ends");

		return paymentVoucherDao.getAllPaymentVoucher(request);
	}

	/*
	 * for view all payment voucher
	 */
	@RequestMapping(value = "getAllPaymentVoucherReport", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<PaymentVoucherModel>>> getAllPaymentVoucherReport(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllPaymentVoucherReport starts");

		logger.info("Method : getAllPaymentVoucherReport ends");

		return paymentVoucherDao.getAllPaymentVoucherReport(request);
	}

	/*
	 * for get return details by payment voucher
	 */
	@RequestMapping(value = "/getReturnData", method = { RequestMethod.GET })
	public List<PaymentVoucherModel> getDataForPaymentTotalPDF(@RequestParam String id) {
		logger.info("Method : getDataForPaymentTotalPDF for rest controller starts");

		logger.info("Method : getDataForPaymentTotalPDF for rest controller ends");
		return paymentVoucherDao.getReturnData(id);
	}

	/*
	 * for drop down of charge name
	 */
	@RequestMapping(value = "getVenderDetails", method = { RequestMethod.GET })
	public List<PaymentVoucherModel> getVenderDetails(@RequestParam String id) {

		logger.info("Method in rest: getVenderDetails starts");

		logger.info("Method in rest: getVenderDetails ends");

		return paymentVoucherDao.getVenderDetails(id);
	}

	/*
	 * for drop down of charge name
	 */
	@RequestMapping(value = "getHotelDetails", method = { RequestMethod.GET })
	public List<PaymentVoucherModel> getHotelDetails(@RequestParam String id) {

		logger.info("Method in rest: getHotelDetails starts");

		logger.info("Method in rest: getHotelDetails ends");

		return paymentVoucherDao.getHotelDetails(id);
	}

	/**
	 * REST CONTROLLER - Get Hotel Logo
	 *
	 */
	@RequestMapping(value = "restLogoImage-PaymentVoucher", method = { RequestMethod.GET })
	public List<DropDownModel> restGetLogoImageForPayVocher(@RequestParam("logoType") String logoType) {
		logger.info("Method : restGetLogoImage starts");

		logger.info("Method : restGetLogoImage ends");
		return paymentVoucherDao.getHotelLogoForVoucher(logoType);
	}

	/*
	 * for view all payment voucher unpaid
	 */
	@RequestMapping(value = "getAllPaymentVoucherAccountantUnpaid", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<PaymentVoucherModel>>> getAllPaymentVoucherAccountantUnpaid(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllPaymentVoucherAccountantUnpaid starts");

		logger.info("Method : getAllPaymentVoucherAccountantUnpaid ends");

		return paymentVoucherDao.getAllPaymentVoucherAccountantUnpaid(request);
	}

	/*
	 * for view all payment voucher unpaid
	 */
	@RequestMapping(value = "getAllPaymentVoucherAccountantUnpaidAprove", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<PaymentVoucherModel>>> getAllPaymentVoucherAccountantUnpaidAprove(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllPaymentVoucherAccountantUnpaidAprove starts");

		logger.info("Method : getAllPaymentVoucherAccountantUnpaidAprove ends");

		return paymentVoucherDao.getAllPaymentVoucherAccountantUnpaidAprove(request);
	}

	/*
	 * for Add payment voucher
	 */
	@RequestMapping(value = "getEditScheduleDate", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> getEditScheduleDate(
			@RequestBody List<PaymentVoucherModel> paymentVoucherModel) {
		logger.info("Method in rest: getEditScheduleDate starts");

		logger.info("Method in rest: getEditScheduleDate ends");

		return paymentVoucherDao.getEditScheduleDate(paymentVoucherModel);
	}
	/*
	 * for approve change status
	 */

	@RequestMapping(value = "getApproveScheduleDate", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> getApproveScheduleDate(
			@RequestBody List<PaymentVoucherModel> paymentVoucherModel) {
		logger.info("Method in rest: getApproveScheduleDate starts");

		logger.info("Method in rest: getApproveScheduleDate ends");

		return paymentVoucherDao.getApproveScheduleDate(paymentVoucherModel);
	}

	/*
	 * for getGRN list for payment
	 */
	@RequestMapping(value = "getGRNListPayment", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<PaymentVoucherModel>>> getGRNListPayment(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getGRNListPayment starts");
		logger.info("Method : getGRNListPayment ends");

		return paymentVoucherDao.getGRNListPayment(request);
	}

	/*
	 * for get grn by id
	 */
	@RequestMapping(value = "getGrnById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<PaymentVoucherModel>> getGrnById(@RequestParam("id") String id) {
		logger.info("Method : getGrnById starts");

		logger.info("Method : getGrnById ends");

		return paymentVoucherDao.getGrnById(id);
	}

	/*
	 * for get getPaymentVoucherById
	 */
	@RequestMapping(value = "getPaymentVoucherById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<PaymentVoucherModel>> getPaymentVoucherById(@RequestParam("id") String id) {
		logger.info("Method : getPaymentVoucherById starts");

		logger.info("Method : getPaymentVoucherById ends");

		return paymentVoucherDao.getPaymentVoucherById(id);
	}

	/*
	 * get partial payment Details
	 */
	@RequestMapping(value = "getPartialPaymentDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<InventoryGrnPaymentDetails>>> getPartialPaymentDetails(
			@RequestParam String id) {
		logger.info("Method : getPartialPaymentDetails starts");

		logger.info("Method : getPartialPaymentDetails ends");
		return paymentVoucherDao.getPartialPaymentDetails(id);
	}

	/*
	 * get partial credit Details
	 * 
	 * @RequestMapping(value = "getCreditDetails", method = { RequestMethod.GET })
	 * public ResponseEntity<JsonResponse<List<InventoryGrnPaymentDetails>>>
	 * getCreditDetails(@RequestParam String id) {
	 * logger.info("Method : getCreditDetails starts");
	 * 
	 * logger.info("Method : getCreditDetails ends"); return
	 * paymentVoucherDao.getCreditDetails(id); }
	 */
	/*
	 * get partial credit Details
	 */
	@RequestMapping(value = "getCreditDetailsForPdf", method = { RequestMethod.GET })
	public List<InventoryGrnPaymentDetails> getCreditDetailsForPdf(@RequestParam String id) {
		logger.info("Method : getCreditDetailsForPdf starts");

		logger.info("Method : getCreditDetailsForPdf ends");
		return paymentVoucherDao.getCreditDetailsForPdf(id);
	}

	/*
	 * for get previous payment details
	 */
	@RequestMapping(value = "getAllPreviousPayments", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<InventoryGrnPaymentDetails>> getAllPreviousPayments(
			@RequestParam("id") String id) {
		logger.info("Method : getAllPreviousPayments starts");

		logger.info("Method : getAllPreviousPayments ends");

		return paymentVoucherDao.getAllPreviousPayments(id);
	}

	/*
	 * for get payment details for pdf
	 */
	@RequestMapping(value = "/getPaymentDataPdf", method = { RequestMethod.GET })
	public List<PaymentVoucherModel> getPaymentDataPdf(@RequestParam String id) {
		logger.info("Method : getPaymentDataPdf for rest controller starts");

		logger.info("Method : getPaymentDataPdf for rest controller ends");
		return paymentVoucherDao.getPaymentDataPdf(id);
	}
}
