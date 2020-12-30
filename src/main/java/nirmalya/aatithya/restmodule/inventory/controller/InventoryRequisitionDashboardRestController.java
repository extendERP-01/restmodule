package nirmalya.aatithya.restmodule.inventory.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.dao.InventoryRequisitionDashboardDao;
import nirmalya.aatithya.restmodule.inventory.model.InventoryRequisitionDashboardModel;

@RestController
@RequestMapping(value = "inventory/")
public class InventoryRequisitionDashboardRestController {
	
	Logger logger = LoggerFactory.getLogger(InventoryRequisitionDashboardRestController.class);
	
	@Autowired
	InventoryRequisitionDashboardDao dashboardDao;
	
	/**
	 *  Today Requisition
	 *
	 */
	@RequestMapping(value="rest-today-requisition" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<InventoryRequisitionDashboardModel>> countTodayRequisition(){
		logger.info("Method :RESTMODULE InventoryRequisitionDashboardRestController countTodayRequisition starts");
		logger.info("Method :RESTMODULE InventoryRequisitionDashboardRestController countTodayRequisition end");
		return dashboardDao.todayRequisition();
	}
	
	
	/**
	 *  Past Due Requisition
	 *
	 */
	@RequestMapping(value="rest-past-due-requisition" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<InventoryRequisitionDashboardModel>> countPastDueRequisition(){
		logger.info("Method :RESTMODULE InventoryRequisitionDashboardRestController countPastDueRequisition starts");
		logger.info("Method :RESTMODULE InventoryRequisitionDashboardRestController countPastDueRequisition end");
		return dashboardDao.pastDueRequisition();
	}
	
	
	/**
	 *  Today Closed Requisition
	 *
	 */
	@RequestMapping(value="rest-today-closed-requisition" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<InventoryRequisitionDashboardModel>> countTodayClosedRequisition(){
		logger.info("Method :RESTMODULE InventoryRequisitionDashboardRestController countTodayClosedRequisition starts");
		logger.info("Method :RESTMODULE InventoryRequisitionDashboardRestController countTodayClosedRequisition end");
		return dashboardDao.todayClosedRequisition();
	}
	
	
	/**
	 * Total Closed Requisition
	 *
	 */
	@RequestMapping(value="rest-total-closed-requisition" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<InventoryRequisitionDashboardModel>> countTotalClosedRequisition(){
		logger.info("Method :RESTMODULE InventoryRequisitionDashboardRestController countTotalClosedRequisition starts");
		logger.info("Method :RESTMODULE InventoryRequisitionDashboardRestController countTotalClosedRequisition end");
		return dashboardDao.totalClosedRequisition();
	}
	
}