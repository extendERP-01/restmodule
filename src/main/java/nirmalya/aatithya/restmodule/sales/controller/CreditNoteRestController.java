package nirmalya.aatithya.restmodule.sales.controller;

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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.dao.CreditNoteDao;
import nirmalya.aatithya.restmodule.sales.model.CreditNoteModel;


/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "sales/")
public class CreditNoteRestController {

	Logger logger = LoggerFactory.getLogger(CreditNoteRestController.class);

	@Autowired
	CreditNoteDao creditNoteDao;
	
	/**
	 * REST CONTROLLER - Get Credit Note
	 *
	 */
	@RequestMapping(value = "/getCreditNote", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<CreditNoteModel>>> getCreditNote(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getCreditNote starts");

		logger.info("Method : getCreditNote ends");
		return creditNoteDao.getCreditNoteDetails(request);
	}
	
	/**
	 * REST CONTROLLER - Get Credit Note For Modal
	 *
	 */
	@RequestMapping(value = "/getCreditNoteById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<CreditNoteModel>>> getCreditNoteById(@RequestParam("id")String id) {
		logger.info("Method : getCreditNoteById starts");

		logger.info("Method : getCreditNoteById ends");
		return creditNoteDao.getCreditNoteById(id);
	}
	
	/**
	 * REST CONTROLLER - Get Credit Note List By AutoSearch
	 *
	 */
	@RequestMapping(value = "/getCreditNoteAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCreditNoteAutoSearch(@RequestParam String id) {
		logger.info("Method : getCreditNoteAutoSearch starts");

		logger.info("Method : getCreditNoteAutoSearch ends");
		return creditNoteDao.getCreditNoteAutoSearchDao(id);
	}
	
	/**
	 * REST CONTROLLER - Get Sale Invoice Return List By AutoSearch
	 *
	 */
	@RequestMapping(value = "/getSaleInvReturnAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSaleInvReturnAutoSearch(@RequestParam String id) {
		logger.info("Method : getSaleInvReturnAutoSearch starts");

		logger.info("Method : getSaleInvReturnAutoSearch ends");
		return creditNoteDao.getSaleInvReturnAutoSearchDao(id);
	}
}
