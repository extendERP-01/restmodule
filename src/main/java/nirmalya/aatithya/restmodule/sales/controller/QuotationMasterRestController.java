package nirmalya.aatithya.restmodule.sales.controller;

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
import nirmalya.aatithya.restmodule.sales.dao.QuotationMasterDao;
import nirmalya.aatithya.restmodule.sales.model.QuotationMasterModel;
import nirmalya.aatithya.restmodule.sales.model.SaleOrderAdvancePayDtlsParentModel;
import nirmalya.aatithya.restmodule.sales.model.SalesItemModel;
import nirmalya.aatithya.restmodule.sales.model.SalesOrdeReportModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "sales/")
public class QuotationMasterRestController {

	Logger logger = LoggerFactory.getLogger(QuotationMasterRestController.class);

	@Autowired
	QuotationMasterDao quotationMasterDao;

	/**
	 * REST CONTROLLER - Get Customer List By AutoSearch
	 *
	 */
	@RequestMapping(value = "/getCustomerListByAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCustomerListByAutoSearch(@RequestParam String id) {
		logger.info("Method : getCustomerListByAutoSearch starts");

		logger.info("Method : getCustomerListByAutoSearch ends");
		return quotationMasterDao.getCustomerListAutoSearch(id);
	}

	/**
	 * REST CONTROLLER - Get Item List By AutoSearch
	 *
	 */
	@RequestMapping(value = "/getItemListByAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemListByAutoSearch(@RequestParam String id) {
		logger.info("Method : getItemListByAutoSearch starts");

		logger.info("Method : getItemListByAutoSearch ends");
		return quotationMasterDao.getItemListByAutoSearch(id);
	}

	/**
	 * REST CONTROLLER - Get Serve Type By Item
	 *
	 */
	@RequestMapping(value = "/getServetTypeByItem", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SalesItemModel>>> getServetTypeByItem(@RequestParam String id) {
		logger.info("Method : getServetTypeByItem starts");

		logger.info("Method : getServetTypeByItem ends");
		return quotationMasterDao.getServetTypeByItem(id);
	}

	/**
	 * REST CONTROLLER - Get 'SERVE TYPE' DropDown List
	 *
	 */
	@RequestMapping(value = "restGetServeType", method = { RequestMethod.GET })
	public List<DropDownModel> restGetServeType() {
		logger.info("Method : restGetServeType starts");

		logger.info("Method : restGetServeType ends");
		return quotationMasterDao.getServeType();
	}

	/**
	 * REST CONTROLLER - Add New Quotation
	 *
	 */
	@RequestMapping(value = "addNewQuotation", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addNewQuotation(@RequestBody List<QuotationMasterModel> quotation) {
		logger.info("Method : addNewQuotation for rest controller starts");

		logger.info("Method : addNewQuotation for rest controller ends");
		return quotationMasterDao.addQuotationMaster(quotation);
	}

	/**
	 * REST CONTROLLER - Get Quotation List By AutoSearch
	 *
	 */
	@RequestMapping(value = "/getQuotationListByAuotSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getQuotationListByAuotSearch(@RequestParam String id) {
		logger.info("Method : getQuotationListByAuotSearch starts");

		logger.info("Method : getQuotationListByAuotSearch ends");
		return quotationMasterDao.getQuotationListByAuotSearch(id);
	}

	/**
	 * REST CONTROLLER - Get Quotation
	 *
	 */
	@RequestMapping(value = "/getQuotation", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<QuotationMasterModel>>> getQuotation(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getQuotation starts");

		logger.info("Method : getQuotation ends");
		return quotationMasterDao.getQuotationDetails(request);
	}

	/**
	 * REST CONTROLLER - Get Quotation For Modal QuotationPdf
	 *
	 */
	@RequestMapping(value = "/getQuotationById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<QuotationMasterModel>>> getQuotationById(@RequestParam("id") String id) {
		logger.info("Method : getQuotationById starts");

		logger.info("Method : getQuotationById ends");
		return quotationMasterDao.getQuotationById(id);
	}

	/**
	 * REST CONTROLLER - Advance Payment Pdf
	 *
	 */
	@RequestMapping(value = "/AdvancePaymentPdf", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<QuotationMasterModel>>> AdvancePaymentPdf(@RequestParam("id") String id) {
		logger.info("Method : AdvancePaymentPdf starts");

		logger.info("Method : AdvancePaymentPdf ends");
		return quotationMasterDao.AdvancePaymentPdf(id);
	}

	/**
	 * REST CONTROLLER - Get Quotation For PDF
	 *
	 */
	@RequestMapping(value = "/QuotationPdf", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<QuotationMasterModel>>> QuotationPdf(@RequestParam("id") String id) {
		logger.info("Method : QuotationPdf starts");

		logger.info("Method : QuotationPdf ends");
		return quotationMasterDao.QuotationPdf(id);
	}

	/**
	 * REST CONTROLLER - Get Sales Order For PDF
	 *
	 */
	@RequestMapping(value = "/SalesOrderPdf", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<SaleOrderAdvancePayDtlsParentModel>> SalesOrderPdf(
			@RequestParam("id") String id) {
		logger.info("Method : SalesOrderPdf starts");

		logger.info("Method : SalesOrderPdf ends");
		return quotationMasterDao.SalesOrderPdf(id);
	}

	/**
	 * REST CONTROLLER - Edit Quotation By Id
	 *
	 */
	@RequestMapping(value = "/editQuotationById", method = { RequestMethod.GET })
	public List<QuotationMasterModel> editQuotationById(@RequestParam("id") String id) {
		logger.info("Method : editQuotationById for rest controller starts");

		logger.info("Method : editQuotationById for rest controller ends");
		return quotationMasterDao.editQuotationById(id);
	}

	/**
	 * REST CONTROLLER - Generate Sales Order
	 *
	 */
	@RequestMapping(value = "/generateSales", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> generateSales(@RequestBody QuotationMasterModel index) {
		logger.info("Method : generateSales starts");

		logger.info("Method : generateSales ends");
		return quotationMasterDao.generateSalesDAO(index);
	}

	/**
	 * REST CONTROLLER - Get Sales Order
	 *
	 */
	@RequestMapping(value = "/getSalesOrder", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<QuotationMasterModel>>> getSalesOrder(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getSalesOrder starts");

		logger.info("Method : getSalesOrder ends");
		return quotationMasterDao.getSalesOrderDetails(request);
	}

	/**
	 * REST CONTROLLER - Get Customer List
	 *
	 */
	@RequestMapping(value = "restGetCustomer", method = { RequestMethod.GET })
	public List<QuotationMasterModel> restGetCustomer(@RequestParam("id") String id) {
		logger.info("Method : restGetCustomer starts");

		logger.info("Method : restGetCustomer ends");
		return quotationMasterDao.getCustomer(id);
	}

	/**
	 * REST CONTROLLER - Get Hotel List
	 *
	 */
	@RequestMapping(value = "restGetHotelList", method = { RequestMethod.GET })
	public List<QuotationMasterModel> restGetHotelList(@RequestParam("id") String id) {
		logger.info("Method : restGetHotel starts");

		logger.info("Method : restGetHotel ends");
		return quotationMasterDao.getHotel(id);
	}

	/**
	 * REST CONTROLLER - Get Sales Order List By AutoSearch
	 *
	 */
	@RequestMapping(value = "/getSalesOrderAuotSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesOrderAuotSearch(@RequestParam String id) {
		logger.info("Method : getSalesOrderAuotSearch starts");

		logger.info("Method : getSalesOrderAuotSearch ends");
		return quotationMasterDao.getSalesOrderAuotSearch(id);
	}

	/**
	 * REST CONTROLLER - Get Purchase Order List By AutoSearch
	 *
	 */
	@RequestMapping(value = "/getPurchaseOrderListAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPurchaseOrderListAutoSearch(@RequestParam String id) {
		logger.info("Method : getPurchaseOrderListAutoSearch starts");

		logger.info("Method : getPurchaseOrderListAutoSearch ends");
		return quotationMasterDao.getPurchaseOrderListAutoSearch(id);
	}

	/**
	 * REST CONTROLLER - Sales Order Report
	 *
	 */
	@RequestMapping(value = "getSalesOrderReport", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<SalesOrdeReportModel>>> getSalesOrderReport(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getSalesOrderReport for rest controller starts");

		logger.info("Method : getSalesOrderReport for rest controller ends");
		return quotationMasterDao.getSalesOrderReport(request);

	}

	/**
	 * REST CONTROLLER - Get Hotel Logo
	 *
	 */
	@RequestMapping(value = "restLogoImage-Quotation", method = { RequestMethod.GET })
	public List<DropDownModel> restGetLogoImage(@RequestParam("logoType") String logoType) {
		logger.info("Method : restGetLogoImage starts");

		logger.info("Method : restGetLogoImage ends");
		return quotationMasterDao.getHotelLogo(logoType);
	}

	/**
	 * REST CONTROLLER - Get Payment Mode For Advance Payment
	 *
	 */
	@RequestMapping(value = "restGetAdvPayMode", method = { RequestMethod.GET })
	public List<DropDownModel> restGetAdvPayMode() {
		logger.info("Method : restGetAdvPayMode starts");

		logger.info("Method : restGetAdvPayMode ends");
		return quotationMasterDao.getAdvPaymentMode();
	}

	/**
	 * REST CONTROLLER - Get POS Number By AutoSearch
	 *
	 */
	@RequestMapping(value = "/getPOSNumber", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPOSNumber(@RequestParam String id) {
		logger.info("Method : getPOSNumber starts");

		logger.info("Method : getPOSNumber ends");
		return quotationMasterDao.getPOSNumberDao(id);
	}

	@RequestMapping(value = "report-itemCategory", method = { RequestMethod.GET })
	public List<DropDownModel> reportItemCategory() {
		logger.info("Method : reportItemCategory starts");

		logger.info("Method : reportItemCategory ends");
		return quotationMasterDao.reportItemCategory();
	}

	@RequestMapping(value = "report-itemSubCategory", method = { RequestMethod.GET })
	public List<DropDownModel> reportItemSubCategory() {
		logger.info("Method : reportItemSubCategory starts");

		logger.info("Method : reportItemSubCategory ends");
		return quotationMasterDao.reportItemSubCategory();
	}

	@RequestMapping(value = "/report-getItemList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> reportItemListByAutoSearch(@RequestParam String id) {
		logger.info("Method : reportItemListByAutoSearch starts");

		logger.info("Method : reportItemListByAutoSearch ends");
		return quotationMasterDao.reportItemListByAutoSearch(id);
	}

	/**
	 * REST CONTROLLER - Get Quotation For Modal QuotationPdf
	 *
	 */
	@RequestMapping(value = "/getQuotationByIdForAdvancePayDtls", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<SaleOrderAdvancePayDtlsParentModel>> getQuotationByIdForAdvancePayDtls(
			@RequestParam("id") String id) {
		logger.info("Method : getQuotationByIdForAdvancePayDtls starts");

		logger.info("Method : getQuotationByIdForAdvancePayDtls ends");
		return quotationMasterDao.getQuotationByIdForAdvancePayDtls(id);
	}

}
