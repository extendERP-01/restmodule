package nirmalya.aatithya.restmodule.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.MapModel;
import nirmalya.aatithya.restmodule.common.utils.MapModel1;
import nirmalya.aatithya.restmodule.user.dao.RestSuperAdminDashboardDao;
import nirmalya.aatithya.restmodule.user.model.RestSuperAdminDashboardModel;

/**
 * @author NirmalyaLabs
 *
 */

@RestController
@RequestMapping(value = "user")
public class RestSuperAdminDashboardController {

	@Autowired
	RestSuperAdminDashboardDao dashboardDao;

	Logger logger = LoggerFactory.getLogger(RestSuperAdminDashboardController.class);

	/**
	 * SPA TOTAL INVOICE
	 *
	 */
	@RequestMapping(value = "rest-total-spa-invoice", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestSuperAdminDashboardModel>> spaTotalInvoice() {
		logger.info("Method :RESTMODULE RestSuperAdminDashboardController spaTotalInvoice starts");
		logger.info("Method :RESTMODULE RestSuperAdminDashboardController spaTotalInvoice end");
		return dashboardDao.spaTotalInvoice();
	}

	/**
	 * GYM TOTAL INVOICE
	 *
	 */
	@RequestMapping(value = "rest-total-gym-invoice", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestSuperAdminDashboardModel>> gymTotalInvoice() {
		logger.info("Method :RESTMODULE RestSuperAdminDashboardController gymTotalInvoice starts");
		logger.info("Method :RESTMODULE RestSuperAdminDashboardController gymTotalInvoice end");
		return dashboardDao.gymTotalInvoice();
	}

	/**
	 * BEAUTY PARLOUR TOTAL INVOICE
	 *
	 */
	@RequestMapping(value = "rest-total-beauty-invoice", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestSuperAdminDashboardModel>> beautyTotalInvoice() {
		logger.info("Method :RESTMODULE RestSuperAdminDashboardController beautyTotalInvoice starts");
		logger.info("Method :RESTMODULE RestSuperAdminDashboardController beautyTotalInvoice end");
		return dashboardDao.beautyTotalInvoice();
	}

	/**
	 * LAUNDRY TOTAL INVOICE
	 *
	 */
	@RequestMapping(value = "rest-total-laundry-invoice", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestSuperAdminDashboardModel>> laundryTotalInvoice() {
		logger.info("Method :RESTMODULE RestSuperAdminDashboardController laundryTotalInvoice starts");
		logger.info("Method :RESTMODULE RestSuperAdminDashboardController laundryTotalInvoice end");
		return dashboardDao.laundryTotalInvoice();
	}

	/**
	 * NIGHT CLUB TOTAL INVOICE
	 *
	 */
	@RequestMapping(value = "rest-total-night-club-invoice", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestSuperAdminDashboardModel>> nightClubTotalInvoice() {
		logger.info("Method :RESTMODULE RestSuperAdminDashboardController nightClubTotalInvoice starts");
		logger.info("Method :RESTMODULE RestSuperAdminDashboardController nightClubTotalInvoice end");
		return dashboardDao.nightClubTotalInvoice();
	}

	/**
	 * RESTAURANT TOTAL INVOICE
	 *
	 */
	@RequestMapping(value = "rest-total-restaurant-invoice", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestSuperAdminDashboardModel>> restaurantTotalInvoice() {
		logger.info("Method :RESTMODULE RestSuperAdminDashboardController restaurantTotalInvoice starts");
		logger.info("Method :RESTMODULE RestSuperAdminDashboardController restaurantTotalInvoice end");
		return dashboardDao.restaurantTotalInvoice();
	}
	/*
	 * OCCUPANCY REPORT GRAPH
	 * 
	 */

	@RequestMapping(value = "viewOccupancyReport", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<MapModel>>> viewOccupancyReport() {
		logger.info("Method : viewOccupancyReportGraph starts");
		logger.info("Method : viewOccupancyReportGraph ends");
		return dashboardDao.viewOccupancyReport();
	}
	/*
	 * REVENUE REPORT GRAPH
	 * 
	 */

	@RequestMapping(value = "viewRevenueReportGraph", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<MapModel1>>> viewRevenueReportGraph() {
		logger.info("Method : viewRevenueReportGraph starts");
		logger.info("Method : viewRevenueReportGraph ends");
		return dashboardDao.viewRevenueReportGraph();
	}
}
