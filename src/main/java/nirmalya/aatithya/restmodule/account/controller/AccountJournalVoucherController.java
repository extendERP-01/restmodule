/**
 * 
 */
package nirmalya.aatithya.restmodule.account.controller;

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

import nirmalya.aatithya.restmodule.account.dao.AccountJournalVoucherDao;
import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "account")
public class AccountJournalVoucherController {

	Logger logger = LoggerFactory.getLogger(AccountJournalVoucherController.class);

	@Autowired
	AccountJournalVoucherDao restInvJournalVoucherPaymentDao;
	
	/*
	 * 
	 * Get mapping for get porder by auto search
	 * 
	 * 
	 */
	@RequestMapping(value = "/getinvsubGroupPayment", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> getinvsubGroupPayment(@RequestParam String id) {
		logger.info("Method : getinvsubGroupPayment starts");

		logger.info("Method : getinvsubGroupPayment ends");
		return restInvJournalVoucherPaymentDao.getinvsubGroupPayment(id);
	}
	/*
	 * 
	 * PostMapping for add Issue Note
	 * 
	 * 
	 */
	@RequestMapping(value = "saveJournalVoucher", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveJournalVoucher(@RequestBody List<AccountJournalVoucherModel> journalVoucherModel) {
		logger.info("Method : saveJournalVoucher starts");
		logger.info("Method : saveJournalVoucher ends");
		return restInvJournalVoucherPaymentDao.saveJournalVoucher(journalVoucherModel);
	}
	/*
	 * for All journal voucher view
	 */
	@RequestMapping(value="getAllJournalVoucher" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> getAllJournalVoucher(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : getAllJournalVoucher starts");
		
		logger.info("Method : getAllJournalVoucher ends");
		
		return restInvJournalVoucherPaymentDao.getAllJournalVoucher(request);
	}
	/*
	 * for All journal voucher view
	 */
	@RequestMapping(value="view-journal-voucher-inModel" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> modelView(@RequestParam("id") String id) 
	{
		logger.info("Method : modelView starts");
		
		logger.info("Method : modelView ends");
		
		return restInvJournalVoucherPaymentDao.modelView(id);
	}
	/*
	 * 
	 * PostMapping for get All JV to be Approve
	 * 
	 * 
	 */
	@RequestMapping(value = "/get-all-JV-approve", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> getAllJVApprove(
			@RequestBody DataTableRequest request) {
		logger.info("Method :  getAllJVApprove starts");
		logger.info("Method :  getAllJVApprove endss");
		return restInvJournalVoucherPaymentDao.getAllJVApprove(request);
		
	}
	

	/*
	 * 
	 * GetMapping for save-requisition-approval-action
	 * 
	 * 
	 */
	@RequestMapping(value = "save-JV-approval-action", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> saveJVApprovalAction(@RequestParam String id,@RequestParam String createdBy) {
		logger.info("Method : saveJVApprovalAction starts");
		logger.info("Method : saveJVApprovalAction endss");
		return restInvJournalVoucherPaymentDao.saveJVApprovalAction(id,createdBy);
	}
	
	/*
	 * 
	 * GetMapping for save-requisition-reject-action
	 * 
	 * 
	 */
	@RequestMapping(value = "save-JV-reject-action", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveJVRejectAction(@RequestBody AccountJournalVoucherModel reqobject) {
		logger.info("Method : saveJVRejectAction starts");
		logger.info("Method : saveJVRejectAction endss");
		return restInvJournalVoucherPaymentDao.saveJVRejectAction(reqobject);
	}
	
}
