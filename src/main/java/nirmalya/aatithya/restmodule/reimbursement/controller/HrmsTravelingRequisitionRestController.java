package nirmalya.aatithya.restmodule.reimbursement.controller;

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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.reimbursement.dao.HrmsTravelingRequisitionDao;
import nirmalya.aatithya.restmodule.reimbursement.model.HrmsTravelingReqHistoryModel;
import nirmalya.aatithya.restmodule.reimbursement.model.HrmsTravelingRequisituionModel;

@RestController
@RequestMapping("reimbursement/")
public class HrmsTravelingRequisitionRestController {
	Logger logger = LoggerFactory.getLogger(HrmsTravelingRequisitionRestController.class);

	@Autowired
	HrmsTravelingRequisitionDao hrmsTravelingRequisitionDao;

	/*
	 * for All TravelingRequisition
	 */
	@RequestMapping(value = "getTravelingRequisitionDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsTravelingRequisituionModel>>> getTravelingRequisitionDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getTravelingRequisitionDetails starts");

		logger.info("Method : getTravelingRequisitionDetails ends");

		return hrmsTravelingRequisitionDao.getTravelingRequisitionDetails(request);
	}

	/*
	 * for All Add TravelingRequisition
	 */
	@RequestMapping(value = "restAddTravelingRequisitions", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddTravelingRequisition(
			@RequestBody HrmsTravelingRequisituionModel TravelingRequisition) {
		logger.info("Method : restAddTravelingRequisition starts");

		logger.info("Method : restAddTravelingRequisition ends");

		return hrmsTravelingRequisitionDao.addTravelingRequisition(TravelingRequisition);
	}

	/*
	 * for TravelingRequisition Edit
	 */
	@RequestMapping(value = "getTravelingRequisitionById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<HrmsTravelingRequisituionModel>> getTravelingRequisitionById(@RequestParam String id) {
		logger.info("Method : getTravelingRequisitionById starts");

		logger.info("Method : getTravelingRequisitionById ends");

		return hrmsTravelingRequisitionDao.getTravelingRequisitionById(id);
	}

	/*
	 * for All TravelingRequisition Delete
	 */
	@RequestMapping(value = "deleteTravelingRequisitionById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteTravelingRequisitionById(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deleteTravelingRequisitionById starts");

		logger.info("Method : deleteTravelingRequisitionById ends");

		return hrmsTravelingRequisitionDao.deleteTravelingRequisitionById(id, createdBy);
	}
	
	/*
	 * for All TravelingRequisition
	 */
	@RequestMapping(value = "getTravelingRequisitionDetailsFirst", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsTravelingRequisituionModel>>> getTravelingRequisitionDetailsFirst(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getTravelingRequisitionDetailsFirst starts");

		logger.info("Method : getTravelingRequisitionDetailsFirst ends");

		return hrmsTravelingRequisitionDao.getTravelingRequisitionDetailsFirst(request);
	}
	/*
	 * 
	 * GetMapping for save-requisition-approval-action
	 * 
	 * 
	 */
	@RequestMapping(value = "save-requisition-approval-action", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> saveRequisitionApprovalAction(@RequestParam String id,@RequestParam String createdBy) {
		logger.info("Method : saveRequisitionApprovalAction starts");
		logger.info("Method : saveRequisitionApprovalAction endss");
		return hrmsTravelingRequisitionDao.saveRequisitionApprovalAction(id,createdBy);
	}
	
	/*
	 * 
	 * GetMapping for save-requisition-reject-action
	 * 
	 * 
	 */
	@RequestMapping(value = "save-requisition-reject-action", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveRequisitionRejectAction(@RequestBody HrmsTravelingRequisituionModel reqobject) {
		logger.info("Method : saveRequisitionRejectAction starts");
		logger.info("Method : saveRequisitionRejectAction endss");
		return hrmsTravelingRequisitionDao.saveRequisitionRejectAction(reqobject);
	}
	
	/*
	 * for TravelingRequisition Edit
	 */
	@RequestMapping(value = "getTravelingRequisitionHistoryById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsTravelingReqHistoryModel>>> getTravelingRequisitionHistoryById(@RequestParam String id) {
		logger.info("Method : getTravelingRequisitionHistoryById starts");

		logger.info("Method : getTravelingRequisitionHistoryById ends");

		return hrmsTravelingRequisitionDao.getTravelingRequisitionHistoryById(id);
	}
	
}
