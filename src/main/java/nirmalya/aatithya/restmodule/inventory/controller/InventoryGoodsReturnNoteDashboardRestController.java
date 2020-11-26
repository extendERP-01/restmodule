package nirmalya.aatithya.restmodule.inventory.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.dao.InventoryGoodsReturnNoteDashboardDao;
import nirmalya.aatithya.restmodule.inventory.model.InventoryGoodsReturnNoteDashboardModel;

@RestController
@RequestMapping(value = "inventory/")
public class InventoryGoodsReturnNoteDashboardRestController {
	
	Logger logger = LoggerFactory.getLogger(InventoryGoodsReturnNoteDashboardRestController.class);
	
	@Autowired
	InventoryGoodsReturnNoteDashboardDao dashboardDao;
	
	/**
	 *  INVENTORY TODAY GOODS RETURN NOTE
	 *
	 */
	@RequestMapping(value="rest-today-goods-return-note" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<InventoryGoodsReturnNoteDashboardModel>> countTodayGoodsReturnNote(){
		logger.info("Method :RESTMODULE InventoryGoodsReturnNoteDashboardRestController countTodayGoodsReturnNote starts");
		logger.info("Method :RESTMODULE InventoryGoodsReturnNoteDashboardRestController countTodayGoodsReturnNote end");
		return dashboardDao.todayGoodsReturnNote();
	}
	
	
	/**
	 *  INVENTORY TOTAL GOODS RETURN NOTE
	 *
	 */
	@RequestMapping(value="rest-total-goods-return-note" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<InventoryGoodsReturnNoteDashboardModel>> countTotalGoodsReturnNote(){
		logger.info("Method :RESTMODULE InventoryGoodsReturnNoteDashboardRestController countTotalGoodsReturnNote starts");
		logger.info("Method :RESTMODULE InventoryGoodsReturnNoteDashboardRestController countTotalGoodsReturnNote end");
		return dashboardDao.totalGoodsReturnNote();
	}
	
	
	/**
	 *  INVENTORY TODAY GOODS RETURN NOTE PRICE
	 *
	 */
	@RequestMapping(value="rest-today-goods-return-note-price" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<InventoryGoodsReturnNoteDashboardModel>> countTodayGoodsReturnNotePrice(){
		logger.info("Method :RESTMODULE InventoryGoodsReturnNoteDashboardRestController countTodayGoodsReturnNotePrice starts");
		logger.info("Method :RESTMODULE InventoryGoodsReturnNoteDashboardRestController countTodayGoodsReturnNotePrice end");
		return dashboardDao.todayGoodsReturnNotePrice();
	}
	
	
	/**
	 *  INVENTORY TOTAL GOODS RETURN NOTE PRICE
	 *
	 */
	@RequestMapping(value="rest-total-goods-return-note-price" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<InventoryGoodsReturnNoteDashboardModel>> countTotalGoodsReturnNotePrice(){
		logger.info("Method :RESTMODULE InventoryGoodsReturnNoteDashboardRestController countTotalGoodsReturnNotePrice starts");
		logger.info("Method :RESTMODULE InventoryGoodsReturnNoteDashboardRestController countTotalGoodsReturnNotePrice end");
		return dashboardDao.totalGoodsReturnNotePrice();
	}
	
	
}