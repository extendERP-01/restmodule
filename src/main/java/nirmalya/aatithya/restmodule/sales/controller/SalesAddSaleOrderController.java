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
import nirmalya.aatithya.restmodule.sales.dao.SlaesAddSaleOrderDao;
import nirmalya.aatithya.restmodule.sales.model.CustomerGSTDataModel;
import nirmalya.aatithya.restmodule.sales.model.QuotationMasterModel;
import nirmalya.aatithya.restmodule.sales.model.SaleOrderDisCountDetailsModel;
import nirmalya.aatithya.restmodule.sales.model.SalesItemModel;
import nirmalya.aatithya.restmodule.sales.model.SalesSaleOrderModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "sales/")
public class SalesAddSaleOrderController {

	Logger logger = LoggerFactory.getLogger(SalesAddSaleOrderController.class);

	@Autowired
	SlaesAddSaleOrderDao slaesAddSaleOrderDao;

	/**
	 * REST CONTROLLER - Add New Quotation
	 *
	 */
	@RequestMapping(value = "addNewSaleOrder", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addNewSaleOrder(@RequestBody List<SalesSaleOrderModel> quotation) {
		logger.info("Method : addNewSaleOrder for rest controller starts");

		logger.info("Method : addNewSaleOrder for rest controller ends");
		return slaesAddSaleOrderDao.addNewSaleOrder(quotation);
	}

	/**
	 * REST CONTROLLER - Get Quotation List By AutoSearch
	 *
	 */
	@RequestMapping(value = "/getSaleOrderListByAuotSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSaleOrderListByAuotSearch(@RequestParam String id) {
		logger.info("Method : getSaleOrderListByAuotSearch starts");

		logger.info("Method : getSaleOrderListByAuotSearch ends");
		return slaesAddSaleOrderDao.getSaleOrderListByAuotSearch(id);
	}

	/**
	 * REST CONTROLLER - Get Quotation
	 *
	 */
	@RequestMapping(value = "/getSaleOrder", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<SalesSaleOrderModel>>> getQuotation(@RequestBody DataTableRequest request) {
		logger.info("Method : getQuotation starts");

		logger.info("Method : getQuotation ends");
		return slaesAddSaleOrderDao.getSaleOrder(request);
	}

	/**
	 * REST CONTROLLER - Get Quotation For Modal QuotationPdf
	 *
	 */
	@RequestMapping(value = "/getSaleOrderById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SalesSaleOrderModel>>> getSaleOrderById(@RequestParam("id") String id) {
		logger.info("Method : getSaleOrderById starts");

		logger.info("Method : getSaleOrderById ends");
		return slaesAddSaleOrderDao.getSaleOrderById(id);
	}

	/**
	 * REST CONTROLLER - Edit Quotation By Id
	 *
	 */
	@RequestMapping(value = "/editSaleOrderById", method = { RequestMethod.GET })
	public List<SalesSaleOrderModel> editSaleOrderById(@RequestParam("id") String id) {
		logger.info("Method : editSaleOrderById for rest controller starts");

		logger.info("Method : editSaleOrderById for rest controller ends");
		return slaesAddSaleOrderDao.editSaleOrderById(id);
	}
	
	/**
	 * REST CONTROLLER - Get Serve Type By Item
	 *
	 */
	@RequestMapping(value = "/restGetStoreList", method = { RequestMethod.GET })
	public  List<DropDownModel> restGetStoreList(@RequestParam String userId) {
		logger.info("Method : restGetStoreList starts");

		logger.info("Method : restGetStoreList ends");
		return slaesAddSaleOrderDao.restGetStoreList(userId);
	}
	
	
	/**
	 * REST CONTROLLER - Get Serve Type By Item
	 *
	 */
	@RequestMapping(value = "/getServetTypeByItemAndCust", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SalesItemModel>>> getServetTypeByItemAndCust(@RequestParam String id ,@RequestParam String custId) {
		logger.info("Method : getServetTypeByItemAndCust starts");

		logger.info("Method : getServetTypeByItemAndCust ends");
		return slaesAddSaleOrderDao.getServetTypeByItemAndCust(id ,custId);
	}
	/**
	 * REST CONTROLLER - Get Customer List By AutoSearch
	 *
	 */
	@RequestMapping(value = "/getSaleCustomerList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<CustomerGSTDataModel>>> getSaleCustomerList(@RequestParam String id) {
		logger.info("Method : getSaleCustomerList starts");

		logger.info("Method : getSaleCustomerList ends");
		return slaesAddSaleOrderDao.getSaleCustomerList(id);
	}
	
	/**
	 * REST CONTROLLER - Get discount details
	 *
	 */
	@RequestMapping(value = "/getDiscountDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SaleOrderDisCountDetailsModel>>> getDiscountDetails(@RequestParam String id) {
		logger.info("Method : getDiscountDetails starts");

		logger.info("Method : getDiscountDetails ends");
		return slaesAddSaleOrderDao.getDiscountDetails(id);
	}
}
