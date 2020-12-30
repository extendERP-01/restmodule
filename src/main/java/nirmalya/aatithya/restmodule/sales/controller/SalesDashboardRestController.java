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
import nirmalya.aatithya.restmodule.common.utils.MapModel1;
import nirmalya.aatithya.restmodule.sales.dao.SalesDashboardDao;
import nirmalya.aatithya.restmodule.sales.model.SalesDashboardModel;


/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "sales/")
public class SalesDashboardRestController {

	Logger logger = LoggerFactory.getLogger(SalesDashboardRestController.class);

	@Autowired
	SalesDashboardDao salesDashboardDao;
	
	@RequestMapping(value = "salesDashboardData", method = { RequestMethod.GET })
	public List<SalesDashboardModel> restSalesDashboardData() {
		logger.info("Method : restSalesDashboardData starts");
		logger.info("Method : restSalesDashboardData ends");
		return salesDashboardDao.salesDashboardDataDao();
	}
	
	@RequestMapping(value = "dbSalesReport", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<MapModel1>>> restDBSalesReport() {
		logger.info("Method : restDBSalesReport starts");
		logger.info("Method : restDBSalesReport ends");
		return salesDashboardDao.dbSalesReportDao();
	}
	
	@RequestMapping(value = "dbOrderReport", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<MapModel1>>> restDBOrderReport() {
		logger.info("Method : restDBOrderReport starts");
		logger.info("Method : restDBOrderReport ends");
		return salesDashboardDao.dbOrderReportDao();
	}
}
