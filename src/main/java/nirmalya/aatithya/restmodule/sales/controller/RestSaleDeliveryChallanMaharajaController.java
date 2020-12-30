package nirmalya.aatithya.restmodule.sales.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.dao.SaleDeliveryChallanMaharajaDao;
import nirmalya.aatithya.restmodule.sales.model.CustomerGSTDataModel;
import nirmalya.aatithya.restmodule.sales.model.RestSalesDeliveryChallanModel;
import nirmalya.aatithya.restmodule.sales.model.RestsalesDataSetPriceModel;
import nirmalya.aatithya.restmodule.sales.model.RestsalesDeliveryChallanDetailsModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "sales/")
public class RestSaleDeliveryChallanMaharajaController {
	Logger logger = LoggerFactory.getLogger(RestSaleDeliveryChallanMaharajaController.class);
	@Autowired
	SaleDeliveryChallanMaharajaDao saleDeliveryChallanDao;

	/**
	 * Rest Controller - Auto Search for Sales Order No
	 *
	 */

	@GetMapping(value = "getSaleOrderLByAutoSearch")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSaleOrderLByAutoSearch(@RequestParam String id,
			@RequestParam String storeId) {
		logger.info("Method : getSaleOrderLByAutoSearch starts");
		logger.info("Method : getSaleOrderLByAutoSearch ends");
		return saleDeliveryChallanDao.getSaleOrderLByAutoSearch(id, storeId);
	}

	/**
	 * Rest Controller - Customer for Sales Order No
	 *
	 */

	@GetMapping(value = "getCustomerBySaleid")
	public ResponseEntity<JsonResponse<List<CustomerGSTDataModel>>> getCustomerBySaleid(@RequestParam String id) {
		logger.info("Method : getCustomerBySaleid starts");
		logger.info("Method : getCustomerBySaleid ends");
		return saleDeliveryChallanDao.getCustomerBySaleid(id);
	}

	/**
	 * Rest Controller - Challan a/c to salesorderno
	 *
	 */

	@GetMapping(value = "getChallanItemList")
	public ResponseEntity<JsonResponse<List<RestsalesDataSetPriceModel>>> getChallanItemList(
			@RequestBody List<RestsalesDataSetPriceModel> table) {
		logger.info("Method : getChallanItemList starts");
		logger.info("Method : getChallanItemList ends");
		return saleDeliveryChallanDao.getChallanItemList(table);
	}

	/**
	 * PostMapping for add Delivery Challan
	 *
	 */

	@PostMapping(value = "restAddDelChallan")
	public ResponseEntity<JsonResponse<Object>> addDelChallanDtls(
			@RequestBody List<RestSalesDeliveryChallanModel> addDelChallanDtls) {
		logger.info("Method : addDelChallanDtls starts");
		logger.info("Method : addDelChallanDtls ends");
		return saleDeliveryChallanDao.addDelChallanDtls(addDelChallanDtls);
	}

	/**
	 * Get getDelChallanDetails
	 *
	 */

	@PostMapping(value = "getDelChallanDetails")
	public ResponseEntity<JsonResponse<List<RestSalesDeliveryChallanModel>>> getDelChallanDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getDelChallanDetails starts");
		logger.info("Method : getDelChallanDetails ends");
		return saleDeliveryChallanDao.getDelChallanDetails(request);
	}

	/**
	 * CHANGE STATUS DELIVERY
	 *
	 */

	@GetMapping(value = "restDeliveryStatus")
	public ResponseEntity<JsonResponse<Object>> restDeliveryStatus(@RequestParam String id, @RequestParam Byte status,
			@RequestParam String createdBy) {
		logger.info("Method : RestController restDeliveryStatus starts");
		logger.info("Method : RestController restDeliveryStatus ends");
		return saleDeliveryChallanDao.restDeliveryStatus(id, status, createdBy);
	}

	/**
	 * Post Mapping to Add New RFQ
	 *
	 */

	@PostMapping(value = "restAddDelStatus")
	public ResponseEntity<JsonResponse<Object>> restAddDelStatus(@RequestBody RestSalesDeliveryChallanModel table) {
		logger.info("Method : restAddDelStatus starts");
		logger.info("Method : restAddDelStatus ends");
		return saleDeliveryChallanDao.restAddDelStatus(table);
	}

	/**
	 * Rest Controller - Auto Search for Challan no.
	 *
	 */

	@GetMapping(value = "getChallanListByAutoSearch")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getChallanAutoSearch(@RequestParam String id) {
		logger.info("Method : getChallanAutoSearch starts");
		logger.info("Method : getChallanAutoSearch ends");
		return saleDeliveryChallanDao.getChallanAutoSearch(id);
	}

	/**
	 * Rest Controller - Auto Search for customer Name.
	 *
	 */

	@GetMapping(value = "getAutCusListBySearch")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAutCusListBySearch(@RequestParam String id) {
		logger.info("Method : getAutCusListBySearch starts");
		logger.info("Method : getAutCusListBySearch ends");
		return saleDeliveryChallanDao.getAutCusListBySearch(id);
	}

	/**
	 * 
	 * REST CONTROLLER FOR GET PO WITH RFQ DETAILS DATA
	 * 
	 */

	@GetMapping(value = "/getInvChallanDtls")
	public List<RestSalesDeliveryChallanModel> getInvChallanDtls(@RequestParam("id") String id) {
		logger.info("Method : getInvChallanDtls for rest controller starts");
		logger.info("Method : getInvChallanDtls for rest controller ends");
		return saleDeliveryChallanDao.getInvChallanDtls(id);
	}

	/**
	 * 
	 * PostMapping for add Invoice Sales
	 * 
	 */

	@GetMapping(value = "restAddSorderInv")
	public ResponseEntity<JsonResponse<Object>> restAddSorderInv(
			@RequestBody List<RestSalesDeliveryChallanModel> restAddSorderInv) {
		logger.info("Method : restAddSorderInv starts");
		logger.info("Method : restAddSorderInv ends");
		return saleDeliveryChallanDao.restAddSorderInv(restAddSorderInv);
	}

	/**
	 * returns particular ChallanId Model data
	 *
	 */

	@GetMapping(value = "getChallanDtlsById")
	public ResponseEntity<JsonResponse<List<RestSalesDeliveryChallanModel>>> getChallanDtlsById(
			@RequestParam("id") String id) {
		logger.info("Method : getChallanDtlsById starts");
		logger.info("Method : getChallanDtlsById endss");
		return saleDeliveryChallanDao.getChallanDtlsById(id);
	}

	/**
	 * FOOD ORDER INVOICE PDF0 voucher
	 *
	 */
	@GetMapping(value = "restDelChallan11")
	public ResponseEntity<JsonResponse<List<RestSalesDeliveryChallanModel>>> restDelChallan11(
			@RequestParam("id") String id, @RequestParam("Action") String action11) {
		logger.info("Method : RESTMODULE restDelChallan11 starts");
		logger.info("Method : RESTMODULE restDelChallan11 ends");
		return saleDeliveryChallanDao.restDelChallan11(id, action11);
	}

	/**
	 * Rest Controller - for item available qty
	 */

	@GetMapping(value = "rest-get-validQty")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAvailQty(@RequestParam String menuItemCat,
			@RequestParam String menuItemSubCat, @RequestParam String menuItemId) {
		logger.info("Method : getAvailQty starts");
		logger.info("Method : getAvailQty ends");
		return saleDeliveryChallanDao.getAvailQty(menuItemCat, menuItemSubCat, menuItemId);
	}

	/*
	 * 
	 * Get mapping for get ItemSubCategory
	 * 
	 * 
	 */

	@GetMapping(value = "/rest-get-itemSubCategory-challan")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSubItemCategory(@RequestParam String id) {
		logger.info("Method : getSubItemCategory starts");

		logger.info("Method : getSubItemCategory endss");
		return saleDeliveryChallanDao.getItemSubCategory(id);
	}

	/**
	 * Rest Controller - Auto Search for Challan no.
	 *
	 */

	@GetMapping(value = "getSaleOrderDetails")
	public ResponseEntity<JsonResponse<List<RestsalesDeliveryChallanDetailsModel>>> getSaleOrderDetails(
			@RequestParam String id, @RequestParam String storeId) {
		logger.info("Method : getSaleOrderDetails starts");
		logger.info("Method : getSaleOrderDetails ends");
		return saleDeliveryChallanDao.getSaleOrderDetails(id, storeId);
	}

	/**
	 * Rest Controller - for delivery form
	 *
	 */

	@GetMapping(value = "getDeliveryFrom")
	public ResponseEntity<JsonResponse<DropDownModel>> getDeliveryFrom(@RequestParam String id) {
		logger.info("Method : getDeliveryFrom starts");
		logger.info("Method : getDeliveryFrom ends");
		return saleDeliveryChallanDao.getDeliveryFrom(id);
	}

	/**
	 * Rest Controller - for delivery to
	 *
	 */

	@GetMapping(value = "getDeliveryTo")
	public ResponseEntity<JsonResponse<DropDownModel>> getDeliveryTo(@RequestParam String id) {
		logger.info("Method : getDeliveryTo starts");
		logger.info("Method : getDeliveryTo ends");
		return saleDeliveryChallanDao.getDeliveryTo(id);
	}

}
