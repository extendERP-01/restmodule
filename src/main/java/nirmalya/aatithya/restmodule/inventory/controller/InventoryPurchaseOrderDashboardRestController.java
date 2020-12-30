package nirmalya.aatithya.restmodule.inventory.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.dao.InventoryPurchaseOrderDashboardDao;
import nirmalya.aatithya.restmodule.inventory.model.InventoryPurchaseOrderDashboardModel;

@RestController
@RequestMapping(value = "inventory/")
public class InventoryPurchaseOrderDashboardRestController {
	
	Logger logger = LoggerFactory.getLogger(InventoryPurchaseOrderDashboardRestController.class);
	
	@Autowired
	InventoryPurchaseOrderDashboardDao dashboardDao;
	
	/**
	 *  TODAY OPEN PURCHASE ORDER
	 *
	 */
	@RequestMapping(value="rest-today-open-purchase-order" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<InventoryPurchaseOrderDashboardModel>> countTodayOpenPurchaseOrder(){
		logger.info("Method :RESTMODULE InventoryPurchaseOrderDashboardRestController countTodayOpenPurchaseOrder starts");
		logger.info("Method :RESTMODULE InventoryPurchaseOrderDashboardRestController countTodayOpenPurchaseOrder end");
		return dashboardDao.todayOpenPurchaseOrder();
	}
	
	
	/**
	 *  TOTAL OPEN PURCHASE ORDER
	 *
	 */
	@RequestMapping(value="rest-total-open-purchase-order" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<InventoryPurchaseOrderDashboardModel>> countTotalOpenPurchaseOrder(){
		logger.info("Method :RESTMODULE InventoryPurchaseOrderDashboardRestController countTotalOpenPurchaseOrder starts");
		logger.info("Method :RESTMODULE InventoryPurchaseOrderDashboardRestController countTotalOpenPurchaseOrder end");
		return dashboardDao.totalOpenPurchaseOrder();
	}
	
	
	/**
	 *  TODAY CLOSED PURCHASE ORDER
	 *
	 */
	@RequestMapping(value="rest-today-closed-purchase-order" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<InventoryPurchaseOrderDashboardModel>> countTodayClosedPurchaseOrder(){
		logger.info("Method :RESTMODULE InventoryPurchaseOrderDashboardRestController countTodayClosedPurchaseOrder starts");
		logger.info("Method :RESTMODULE InventoryPurchaseOrderDashboardRestController countTodayClosedPurchaseOrder end");
		return dashboardDao.todayClosedPurchaseOrder();
	}
	
	
	/**
	 *  TOTAL CLOSED PURCHASE ORDER
	 *
	 */
	@RequestMapping(value="rest-total-closed-purchase-order" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<InventoryPurchaseOrderDashboardModel>> countTotalClosedPurchaseOrder(){
		logger.info("Method :RESTMODULE InventoryPurchaseOrderDashboardRestController countTotalClosedPurchaseOrder starts");
		logger.info("Method :RESTMODULE InventoryPurchaseOrderDashboardRestController countTotalClosedPurchaseOrder end");
		return dashboardDao.totalClosedPurchaseOrder();
	}
	
	
}