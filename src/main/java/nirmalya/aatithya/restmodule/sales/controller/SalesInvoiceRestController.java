package nirmalya.aatithya.restmodule.sales.controller;

import java.util.List;
import java.util.Map;

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
import nirmalya.aatithya.restmodule.sales.dao.SalesInvoiceDao;
import nirmalya.aatithya.restmodule.sales.model.QuotationMasterModel;
import nirmalya.aatithya.restmodule.sales.model.SaleInvoiceReturnModel;
import nirmalya.aatithya.restmodule.sales.model.SaleOrderPaymentPdfModel;
import nirmalya.aatithya.restmodule.sales.model.SalesInvoiceModel;
import nirmalya.aatithya.restmodule.sales.model.SalesPaymentModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "sales/")
public class SalesInvoiceRestController {

	Logger logger = LoggerFactory.getLogger(SalesInvoiceRestController.class);

	@Autowired
	SalesInvoiceDao salesInvoiceDao;
	
	/**
	 * REST CONTROLLER - Get Sales Order List By AutoSearch
	 *
	 */
	@RequestMapping(value = "/getSalesOrderListByAuotSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesOrderListByAuotSearch(@RequestParam String id , @RequestParam String storeId) {
		logger.info("Method : getSalesOrderListByAuotSearch starts");

		logger.info("Method : getSalesOrderListByAuotSearch ends");
		return salesInvoiceDao.getSalesOrderListByAuotSearch(id ,storeId);
	}
	
	/**
	 * REST CONTROLLER - Get Quotation List
	 *
	 */
	@RequestMapping(value = "/getQuotationList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<QuotationMasterModel>>> getQuotationList(@RequestParam("id")String id ,@RequestParam("storeId")String storeId) {
		logger.info("Method : getQuotationList starts");

		logger.info("Method : getQuotationList ends");
		return salesInvoiceDao.getQuotationList(id ,storeId);
	}
	
	/**
	 * REST CONTROLLER - Get Item List
	 *
	 */
	@RequestMapping(value="/getItemList" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<QuotationMasterModel>>> getItemList(@RequestBody Map<String,String> quotation) {
		logger.info("Method : getItemList for rest controller starts");
		
		logger.info("Method : getItemList for rest controller ends");
		return salesInvoiceDao.getItemList(quotation);
		
	}
	
	/**
	 * REST CONTROLLER - Add Sales Invoice
	 *
	 */
	@RequestMapping(value="addSalesInvoice" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addSalesInvoice(@RequestBody  List<SalesInvoiceModel> salesInvoice) {
		logger.info("Method : addSalesInvoice for rest controller starts");
		
		logger.info("Method : addSalesInvoice for rest controller ends");
		return salesInvoiceDao.addSalesInvoice(salesInvoice);
	}
	
	/**
	 * REST CONTROLLER - Get Sales Invoice By INVOICE NUMBER
	 *
	 */
	@RequestMapping(value = "/getSalesInvoiceById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> getSalesInvoiceById(@RequestParam("id")String id) {
		logger.info("Method : getSalesInvoiceById starts");

		logger.info("Method : getSalesInvoiceById ends");
		return salesInvoiceDao.getSalesInvoiceById(id);
	}
	
	/**
	 * REST CONTROLLER - Get Sales Payment Invoice By INVOICE NUMBER
	 *
	 */
	@RequestMapping(value = "/saleInvoicePayment", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<SaleOrderPaymentPdfModel>> saleInvoicePayment(@RequestParam("id")String id) {
		logger.info("Method : saleInvoicePayment starts");

		logger.info("Method : saleInvoicePayment ends");
		return salesInvoiceDao.saleOrderVoucherPDFDao(id);
	}
	
	/**
	 * REST CONTROLLER - Get Sales Invoice
	 *
	 */
	@RequestMapping(value = "/getSalesInvoice", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> getSalesInvoice(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getSalesInvoice starts");

		logger.info("Method : getSalesInvoice ends");
		return salesInvoiceDao.getSalesInvoiceDetails(request);
	}
	
	/**
	 * REST CONTROLLER - Get Payment Mode For Full Payment
	 *
	 */
	@RequestMapping(value="restGetPayMode" , method={RequestMethod.GET})
	public List<DropDownModel> restGetPayMode() {
		logger.info("Method : restGetPayMode starts");

		logger.info("Method : restGetPayMode ends");
		return salesInvoiceDao.getPayMode();
	}
	
	/**
	 * REST CONTROLLER - Get Payment Mode For Partial Payment
	 *
	 */
	@RequestMapping(value="restGetPaymentMode" , method={RequestMethod.GET})
	public List<DropDownModel> restGetPaymentMode() {
		logger.info("Method : restGetPaymentMode starts");

		logger.info("Method : restGetPaymentMode ends");
		return salesInvoiceDao.getPaymentMode();
	}
	
	/**
	 * Rest Controller - Make Payment
	 *
	 */
	@RequestMapping(value="/makePayment" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> makePayment(@RequestBody SalesInvoiceModel index) {
		logger.info("Method : makePayment starts");
		
		logger.info("Method : makePayment ends");
		return salesInvoiceDao.makePaymentDao(index);
	}
	
	/**
	 * REST CONTROLLER - Get Customer List
	 *
	 */
	@RequestMapping(value="restGetCustomerList" , method={RequestMethod.GET})
	public List<SalesInvoiceModel> restGetCustomerList(@RequestParam("id") String id) {
		logger.info("Method : restGetCustomerList starts");

		logger.info("Method : restGetCustomerList ends");
		return salesInvoiceDao.getCustomerList(id);
	}
	
	/**
	 * REST CONTROLLER - Get Hotel List
	 *
	 */
	@RequestMapping(value="restGetHotel" , method={RequestMethod.GET})
	public List<SalesInvoiceModel> restGetHotel(@RequestParam("id")String id) {
		logger.info("Method : restGetHotel starts");

		logger.info("Method : restGetHotel ends");
		return salesInvoiceDao.getHotelList(id);
	}
	
	/**
	 * REST CONTROLLER - Get Sales Invoice For PDF
	 *
	 */
	@RequestMapping(value = "/SaleInvoicePdf", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> SaleInvoicePdf(@RequestParam("id")String id) {
		logger.info("Method : SaleInvoicePdf starts");

		logger.info("Method : SaleInvoicePdf ends");
		return salesInvoiceDao.SaleInvoicePdfDao(id);
	}
	
	/**
	 * REST CONTROLLER - Get Sales Invoice For PDF
	 *
	 */
	@RequestMapping(value = "/SaleInvPaymentPdf", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> SaleInvPaymentPdf(@RequestParam("id")String id) {
		logger.info("Method : SaleInvPaymentPdf starts");

		logger.info("Method : SaleInvPaymentPdf ends");
		return salesInvoiceDao.SaleInvPaymentPdfDao(id);
	}
	
	/**
	 * REST CONTROLLER - Get Sales Invoice List By AutoSearch
	 *
	 */
	@RequestMapping(value = "/getSaleInvoiceListByAuotSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSaleInvoiceListByAuotSearch(@RequestParam String id) {
		logger.info("Method : getSaleInvoiceListByAuotSearch starts");

		logger.info("Method : getSaleInvoiceListByAuotSearch ends");
		return salesInvoiceDao.getSaleInvoiceListByAuotSearch(id);
	}
	
	/**
	 * REST CONTROLLER - Get Receipt Voucher List By AutoSearch
	 *
	 */
	@RequestMapping(value = "/voucherAutoComplete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> voucherAutoComplete(@RequestParam String id) {
		logger.info("Method : voucherAutoComplete starts");

		logger.info("Method : voucherAutoComplete ends");
		return salesInvoiceDao.voucherAutoCompleteDao(id);
	}
	
	/**
	 * REST CONTROLLER - Get Sales Order List By AutoSearch For Report
	 *
	 */
	@RequestMapping(value = "/getSalesOrderListByAuotSearchForReport", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesOrderListByAuotSearchForReport(@RequestParam String id) {
		logger.info("Method : getSalesOrderListByAuotSearchForReport starts");

		logger.info("Method : getSalesOrderListByAuotSearchForReport ends");
		return salesInvoiceDao.getSalesOrderListByAuotSearchForReportDao(id);
	}
	
	/**
	 * REST CONTROLLER - Sales Invoice Report
	 *
	 */
	@RequestMapping(value="getSalesInvoiceReport" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>>  getSalesInvoiceReport(@RequestBody DataTableRequest request) {
		logger.info("Method : getSalesInvoiceReport for rest controller starts");
		
		logger.info("Method : getSalesInvoiceReport for rest controller ends");
		return salesInvoiceDao.getSalesInvoiceReport(request);
		
	}
	
	/**
	 * REST CONTROLLER - Get Hotel Logo
	 *
	 */
	@RequestMapping(value="restLogoImage-SaleInvoice" , method={RequestMethod.GET})
	public List<DropDownModel> restHotelLogoImage(@RequestParam("logoType") String logoType) {
		logger.info("Method : restHotelLogoImage starts");

		logger.info("Method : restHotelLogoImage ends");
		return salesInvoiceDao.getHotelLogoImage(logoType);
	}
	
	/**
	 * REST CONTROLLER - Get Sale Invoice Return Details
	 *
	 */
	@RequestMapping(value="restGetSaleInvoiceReturn" , method={RequestMethod.GET})
	public List<SaleInvoiceReturnModel> restGetSaleInvoiceReturn(@RequestParam("id") String id) {
		logger.info("Method : restGetSaleInvoiceReturn starts");

		logger.info("Method : restGetSaleInvoiceReturn ends");
		return salesInvoiceDao.getSaleInvoiceReturnDao(id);
	}
	
	/**
	 * REST CONTROLLER - Get POS Number By AutoSearch
	 *
	 */
	@RequestMapping(value = "/posNumberByAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> posNumberByAutoSearch(@RequestParam String id) {
		logger.info("Method : posNumberByAutoSearch starts");

		logger.info("Method : posNumberByAutoSearch ends");
		return salesInvoiceDao.posNumberByAutoSearchDao(id);
	}
	
	/**
	 * REST CONTROLLER - Get Last Payment List
	 *
	 */
	@RequestMapping(value = "/getLastPaymentList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> getLastPaymentList(@RequestParam("id")String id) {
		logger.info("Method : getLastPaymentList starts");

		logger.info("Method : getLastPaymentList ends");
		return salesInvoiceDao.getLastPaymentList(id);
	}
	
	/**
	 * REST CONTROLLER - Payment Details Modal
	 *
	 */
	@RequestMapping(value = "/getInvoiceDtlsForPayment", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> getInvoiceDtlsForPayment(@RequestParam("id")String id) {
		logger.info("Method : getInvoiceDtlsForPayment starts");

		logger.info("Method : getInvoiceDtlsForPayment ends");
		return salesInvoiceDao.getInvoiceDtlsForPayment(id);
	}
	
	/**
	 * REST CONTROLLER - Get Sales Invoice Total Payment For PDF
	 *
	 */
	@RequestMapping(value = "/SaleInvTotalPdf", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> SaleInvTotalPdf(@RequestParam("id")String id) {
		logger.info("Method : SaleInvTotalPdf starts");

		logger.info("Method : SaleInvTotalPdf ends");
		return salesInvoiceDao.SaleInvTotalPdfDao(id);
	}
	
	/**
	 * REST CONTROLLER - Voucher List For PDF
	 *
	 */
	/*
	 * @RequestMapping(value = "/totalPaymentDetails", method = { RequestMethod.GET
	 * }) public ResponseEntity<JsonResponse<List<SalesPaymentModel>>>
	 * totalPaymentDetails(@RequestParam("id")String id) {
	 * logger.info("Method : totalPaymentDetails starts");
	 * 
	 * logger.info("Method : totalPaymentDetails ends"); return
	 * salesInvoiceDao.totalPaymentDetails(id); }
	 */
	@RequestMapping(value="totalPaymentDetails" , method={RequestMethod.GET})
	public List<SalesPaymentModel> totalPaymentDetails(@RequestParam("id") String id) {
		logger.info("Method : totalPaymentDetails starts");

		logger.info("Method : totalPaymentDetails ends");
		return salesInvoiceDao.totalPaymentDetailsDao(id);
	}
}
