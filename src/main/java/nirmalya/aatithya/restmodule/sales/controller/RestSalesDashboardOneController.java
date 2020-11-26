package nirmalya.aatithya.restmodule.sales.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.dao.SalesDashboardOneDao;
import nirmalya.aatithya.restmodule.sales.model.RestSalesDashboardoneModel;

/**
 * @author ashish
 *
 */
@RestController
@RequestMapping(value = { "sales/" })
public class RestSalesDashboardOneController {
	Logger logger = LoggerFactory.getLogger(RestSalesCustomerController.class);

	@Autowired
	SalesDashboardOneDao dashboardDao;
	
	/**
	 * REST CONTROLLER - Get Box counts for sale dashboard
	 *
	 */
	@RequestMapping(value = "rest-sales-dashboardone", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestSalesDashboardoneModel>> getSalesDashboardBoxCount() {
		logger.info("Method :RestSalesDashboardOneController getSalesDashboardBoxCount starts");

		logger.info("Method : RestSalesDashboardOneController getSalesDashboardBoxCount ends");
		return dashboardDao.getBoxCountForSales();
	}
	/**
	 * REST CONTROLLER - Get Top 5 sale inv items
	 *
	 */
	@RequestMapping(value = "rest-sales-top-items", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestSalesDashboardoneModel>>> getSalesDashboardTopItems() {
		logger.info("Method :RestSalesDashboardOneController getSalesDashboardBoxCount starts");

		logger.info("Method : RestSalesDashboardOneController getSalesDashboardBoxCount ends");
		return dashboardDao.getTopItems();
	}
	/**
	 * REST CONTROLLER - Get Top 5 sale inv items
	 *
	 */
	@RequestMapping(value = "rest-top-sale-invoices", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestSalesDashboardoneModel>>> getTopSaleInv() {
		logger.info("Method :RestSalesDashboardOneController getSalesDashboardBoxCount starts");
		
		logger.info("Method : RestSalesDashboardOneController getSalesDashboardBoxCount ends");
		return dashboardDao.getTopSaleInv();
	}
	
}
