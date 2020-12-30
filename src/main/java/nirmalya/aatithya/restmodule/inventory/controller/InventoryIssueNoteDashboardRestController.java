package nirmalya.aatithya.restmodule.inventory.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.dao.InventoryIssueNoteDashboardDao;
import nirmalya.aatithya.restmodule.inventory.model.InventoryIssueNoteDashboardModel;

@RestController
@RequestMapping(value = "inventory/")
public class InventoryIssueNoteDashboardRestController {
	
	Logger logger = LoggerFactory.getLogger(InventoryIssueNoteDashboardRestController.class);
	
	@Autowired
	InventoryIssueNoteDashboardDao dashboardDao;
	
	/**
	 *  TODAY ISSUE NOTE
	 *
	 */
	@RequestMapping(value="rest-today-issue-note" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<InventoryIssueNoteDashboardModel>> countTodayIssueNote(){
		logger.info("Method :RESTMODULE InventoryIssueNoteDashboardRestController countTodayIssueNote starts");
		logger.info("Method :RESTMODULE InventoryIssueNoteDashboardRestController countTodayIssueNote end");
		return dashboardDao.todayIssueNote();
	}
	
	
	/**
	 *  TOTAL ISSUE NOTE
	 *
	 */
	@RequestMapping(value="rest-total-issue-note" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<InventoryIssueNoteDashboardModel>> countTotalIssueNote(){
		logger.info("Method :RESTMODULE InventoryIssueNoteDashboardRestController countTotalIssueNote starts");
		logger.info("Method :RESTMODULE InventoryIssueNoteDashboardRestController countTotalIssueNote end");
		return dashboardDao.totalIssueNote();
	}
	
	
	/**
	 *  TOTAL OPEN REQUISTION
	 *
	 */
	@RequestMapping(value="rest-total-open-requistion" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<InventoryIssueNoteDashboardModel>> countTotalOpenrequistion(){
		logger.info("Method :RESTMODULE InventoryIssueNoteDashboardRestController countTotalOpenrequistion starts");
		logger.info("Method :RESTMODULE InventoryIssueNoteDashboardRestController countTotalOpenrequistion end");
		return dashboardDao.totalOpenRequistion();
	}
	
	
	/**
	 *  TODAY CLOSED REQUISTION
	 *
	 */
	@RequestMapping(value="rest-today-closed-requistion" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<InventoryIssueNoteDashboardModel>> countTodayClosedRequistion(){
		logger.info("Method :RESTMODULE InventoryIssueNoteDashboardRestController countTodayClosedRequistion starts");
		logger.info("Method :RESTMODULE InventoryIssueNoteDashboardRestController countTodayClosedRequistion end");
		return dashboardDao.todayClosedRequistion();
	}
	
	
}