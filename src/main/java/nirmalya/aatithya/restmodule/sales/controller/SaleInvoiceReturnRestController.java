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
import nirmalya.aatithya.restmodule.sales.dao.SaleInvoiceReturnDao;
import nirmalya.aatithya.restmodule.sales.model.SaleInvoiceReturnModel;
import nirmalya.aatithya.restmodule.sales.model.SalesInvoiceModel;


/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "sales/")
public class SaleInvoiceReturnRestController {

	Logger logger = LoggerFactory.getLogger(SalesInvoiceRestController.class);

	@Autowired
	SaleInvoiceReturnDao saleInvoiceReturnDao;
	
	/**
	 * REST CONTROLLER - Get Sales Order List By AutoSearch
	 *
	 */
	@RequestMapping(value = "/getSalesOrderListForReturn", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesOrderListForReturn(@RequestParam String id) {
		logger.info("Method : getSalesOrderListForReturn starts");

		logger.info("Method : getSalesOrderListForReturn ends");
		return saleInvoiceReturnDao.getSalesOrderListForReturnDao(id);
	}
	
	/**
	 * REST CONTROLLER - Get Sales Invoice List By AutoSearch
	 *
	 */
	@RequestMapping(value = "/getSalesInvoiceListForReturn", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesInvoiceListForReturn(@RequestParam("id") String salesOrder,@RequestParam("searchValue") String searchValue) {
		logger.info("Method : getSalesInvoiceListForReturn starts");

		logger.info("Method : getSalesInvoiceListForReturn ends");
		return saleInvoiceReturnDao.getSalesInvoiceListForReturnDao(salesOrder,searchValue);
	}
	
	/**
	 * REST CONTROLLER - Get Sale Invoice List
	 *
	 */
	@RequestMapping(value = "/getSaleInvoiceList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> getSaleInvoiceList(@RequestParam("id")String id) {
		logger.info("Method : getSaleInvoiceList starts");

		logger.info("Method : getSaleInvoiceList ends");
		return saleInvoiceReturnDao.getSaleInvoiceList(id);
	}
	
	/**
	 * REST CONTROLLER - Check Sale Invoice Return
	 *
	 */
	@RequestMapping(value = "/checkSaleInvReturn", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> checkSaleInvReturn(@RequestParam("id") String salesOrder,@RequestParam("saleInvId") String saleInvId) {
		logger.info("Method : checkSaleInvReturn starts");

		logger.info("Method : checkSaleInvReturn ends");
		return saleInvoiceReturnDao.checkSaleInvReturnDao(salesOrder,saleInvId);
	}
	
	/**
	 * REST CONTROLLER - Get Item List
	 *
	 */
	@RequestMapping(value="/getItemListForReturn" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> getItemListForReturn(@RequestBody Map<String,String> saleInvoice) {
		logger.info("Method : getItemListForReturn for rest controller starts");
		
		logger.info("Method : getItemListForReturn for rest controller ends");
		return saleInvoiceReturnDao.getItemListForReturnDao(saleInvoice);
		
	}
	
	/**
	 * REST CONTROLLER - Add Sales Invoice Return
	 *
	 */
	@RequestMapping(value="addSalesInvoiceReturn" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addSalesInvoiceReturn(@RequestBody  List<SaleInvoiceReturnModel> salesInvoiceReturn) {
		logger.info("Method : addSalesInvoiceReturn for rest controller starts");
		
		logger.info("Method : addSalesInvoiceReturn for rest controller ends");
		return saleInvoiceReturnDao.addSalesInvoiceReturnDao(salesInvoiceReturn);
	}
	
	/**
	 * REST CONTROLLER - Get Sale Invoice Return
	 *
	 */
	@RequestMapping(value = "/getSaleInvReturn", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<SaleInvoiceReturnModel>>> getSaleInvReturn(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getSaleInvReturn starts");

		logger.info("Method : getSaleInvReturn ends");
		return saleInvoiceReturnDao.getSaleInvReturnDetails(request);
	}
	
	/**
	 * REST CONTROLLER - Get Sales Invoice Return By INVOICE NUMBER
	 *
	 */
	@RequestMapping(value = "/getSalesInvReturnById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SaleInvoiceReturnModel>>> getSalesInvReturnById(@RequestParam("id")String id) {
		logger.info("Method : getSalesInvReturnById starts");

		logger.info("Method : getSalesInvReturnById ends");
		return saleInvoiceReturnDao.getSalesInvReturnById(id);
	}
	
	/**
	 * REST CONTROLLER - Edit Sale Invoice Return By Id
	 *
	 */
	@RequestMapping(value = "/editSaleInvReturnById", method = { RequestMethod.GET })
	public List<SaleInvoiceReturnModel> editSaleInvReturnById(@RequestParam("id")String id) {
		logger.info("Method : editSaleInvReturnById for rest controller starts");
		
		logger.info("Method : editSaleInvReturnById for rest controller ends");
		return saleInvoiceReturnDao.editSaleInvReturnById(id);
	}
	
	/**
	 * REST CONTROLLER - Return Item Code List At Edit Time
	 *
	 */
	@RequestMapping(value="editItemList" , method={RequestMethod.GET})
	public List<DropDownModel> editItemList(@RequestParam("id") String id) {
		logger.info("Method : editItemList starts");

		logger.info("Method : editItemList ends");
		return saleInvoiceReturnDao.editItemListDao(id);
	}
	
	/**
	 * REST CONTROLLER - Get Sale Invoice List At Edit Time
	 *
	 */
	@RequestMapping(value="editSaleInvList" , method={RequestMethod.GET})
	public List<SalesInvoiceModel> editSaleInvList(@RequestParam("id") String id) {
		logger.info("Method : editSaleInvList starts");

		logger.info("Method : editSaleInvList ends");
		return saleInvoiceReturnDao.editSaleInvListDao(id);
	}
	
	/**
	 * REST CONTROLLER - Get Sale Invoice Return Id For Delete
	 *
	 */
	@RequestMapping(value="/deleteSaleInvReturnById" , method={RequestMethod.GET})
	 public ResponseEntity<JsonResponse<Object>> deleteSaleInvReturnById(@RequestParam String id, @RequestParam String createdBy) {
		logger.info("Method : deleteSaleInvReturnById starts");

		logger.info("Method : deleteSaleInvReturnById ends");
		return saleInvoiceReturnDao.deleteSaleInvReturnById(id,createdBy); 
	}
	
	/**
	 * REST CONTROLLER - Get Sales Invoice Return List By AutoSearch
	 *
	 */
	@RequestMapping(value = "/getSaleInvReturnList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesInvoiceReturnList(@RequestParam String id) {
		logger.info("Method : getSalesInvoiceReturnList starts");

		logger.info("Method : getSalesInvoiceReturnList ends");
		return saleInvoiceReturnDao.getSalesInvoiceReturnListDao(id);
	}
	
	/**
	 * REST CONTROLLER - Get Sales Invoice Return For PDF
	 *
	 */
	@RequestMapping(value = "/SaleInvReturnPdf", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SaleInvoiceReturnModel>>> getSalesInvReturnByIdForPdf(@RequestParam("id")String id) {
		logger.info("Method : getSalesInvReturnByIdForPdf starts");

		logger.info("Method : getSalesInvReturnByIdForPdf ends");
		return saleInvoiceReturnDao.getSalesInvReturnByIdForPdfDao(id);
	}
	
	/**
	 * REST CONTROLLER - Get Hotel Logo
	 *
	 */
	@RequestMapping(value="restLogoImage-SaleInvoiceReturn" , method={RequestMethod.GET})
	public List<DropDownModel> restHotelLogoImageForSaleInvReturn(@RequestParam("logoType") String logoType) {
		logger.info("Method : restHotelLogoImageForSaleInvReturn starts");

		logger.info("Method : restHotelLogoImageForSaleInvReturn ends");
		return saleInvoiceReturnDao.getHotelLogoImageForSaleInvReturn(logoType);
	}
	
	/**
	 * REST CONTROLLER - Get Customer List
	 *
	 */
	@RequestMapping(value="restGetCustomerSaleInvRtn" , method={RequestMethod.GET})
	public List<SaleInvoiceReturnModel> restGetCustomerSaleInvRtn(@RequestParam("id") String id) {
		logger.info("Method : restGetCustomerSaleInvRtn starts");

		logger.info("Method : restGetCustomerSaleInvRtn ends");
		return saleInvoiceReturnDao.getCustomerRtrnDao(id);
	}
	
	/**
	 * REST CONTROLLER - Get Hotel List
	 *
	 */
	@RequestMapping(value="restGetHotelRtrnDetails" , method={RequestMethod.GET})
	public List<SaleInvoiceReturnModel> restGetHotelRtrnDetails() {
		logger.info("Method : restGetHotelRtrnDetails starts");

		logger.info("Method : restGetHotelRtrnDetails ends");
		return saleInvoiceReturnDao.getHotelRtrnDao();
	}
	
	/**
	 * REST CONTROLLER - Get Sales Order List By AutoSearch For Report
	 *
	 */
	@RequestMapping(value = "/getSalesOrderReport", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesOrderListForReport(@RequestParam String id) {
		logger.info("Method : getSalesOrderListForReport starts");

		logger.info("Method : getSalesOrderListForReport ends");
		return saleInvoiceReturnDao.getSalesOrderListForReportDao(id);
	}
	
	/**
	 * REST CONTROLLER - Get Sales Invoice List By AutoSearch For Report
	 *
	 */
	@RequestMapping(value = "/getSalesInvReport", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesInvoiceListForReport(@RequestParam("id") String salesOrder,@RequestParam("searchValue") String searchValue) {
		logger.info("Method : getSalesInvoiceListForReport starts");

		logger.info("Method : getSalesInvoiceListForReport ends");
		return saleInvoiceReturnDao.getSalesInvoiceListForReportDao(salesOrder,searchValue);
	}
	
	/**
	 * REST CONTROLLER - Sales Invoice Report
	 *
	 */
	@RequestMapping(value="getSalesInvReturnReport" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<SaleInvoiceReturnModel>>>  getSalesInvReturnReport(@RequestBody DataTableRequest request) {
		logger.info("Method : getSalesInvReturnReport for rest controller starts");
		
		logger.info("Method : getSalesInvReturnReport for rest controller ends");
		return saleInvoiceReturnDao.getSalesInvReturnReport(request);
		
	}
}
