package nirmalya.aatithya.restmodule.inventory.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.dao.InventoryGoodsReceiveNoteDashboardDao;
import nirmalya.aatithya.restmodule.inventory.model.InventoryGoodsReceiveNoteDashboardModel;

@RestController
@RequestMapping(value = "inventory/")
public class InventoryGoodsReceiveNoteDashboardRestController {
	
	Logger logger = LoggerFactory.getLogger(InventoryGoodsReceiveNoteDashboardRestController.class);
	
	@Autowired
	InventoryGoodsReceiveNoteDashboardDao dashboardDao;
	
	/**
	 *  TODAY INVENTORY GOODS RECEIVE NOTE
	 *
	 */
	@RequestMapping(value="rest-today-goods-receive-note" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<InventoryGoodsReceiveNoteDashboardModel>> countTodayGoodsReceiveNote(){
		logger.info("Method :RESTMODULE InventoryGoodsReceiveNoteDashboardRestController countTodayGoodsReceiveNote starts");
		logger.info("Method :RESTMODULE InventoryGoodsReceiveNoteDashboardRestController countTodayGoodsReceiveNote end");
		return dashboardDao.todayGoodsReceiveNote();
	}
	
	
	/**
	 *  TOTAL INVENTORY GOODS RECEIVE NOTE
	 *
	 */
	@RequestMapping(value="rest-total-goods-receive-note" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<InventoryGoodsReceiveNoteDashboardModel>> countTotalGoodsReceiveNote(){
		logger.info("Method :RESTMODULE InventoryGoodsReceiveNoteDashboardRestController countTotalGoodsReceiveNote starts");
		logger.info("Method :RESTMODULE InventoryGoodsReceiveNoteDashboardRestController countTotalGoodsReceiveNote end");
		return dashboardDao.totalGoodsReceiveNote();
	}
	
	
	/**
	 *  TODAY INVENTORY GRN PRICE
	 *
	 */
	@RequestMapping(value="rest-today-grn-price" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<InventoryGoodsReceiveNoteDashboardModel>> countTodayGrnPrice(){
		logger.info("Method :RESTMODULE InventoryGoodsReceiveNoteDashboardRestController countTodayGrnPrice starts");
		logger.info("Method :RESTMODULE InventoryGoodsReceiveNoteDashboardRestController countTodayGrnPrice end");
		return dashboardDao.todayGrnPrice();
	}
	
	
	/**
	 *  TOTAL INVENTORY GRN PRICE
	 *
	 */
	@RequestMapping(value="rest-total-grn-price" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<InventoryGoodsReceiveNoteDashboardModel>> countTotalGrnPrice(){
		logger.info("Method :RESTMODULE InventoryGoodsReceiveNoteDashboardRestController countTotalGrnPrice starts");
		logger.info("Method :RESTMODULE InventoryGoodsReceiveNoteDashboardRestController countTotalGrnPrice end");
		return dashboardDao.totalGrnPrice();
	}
	
	
}