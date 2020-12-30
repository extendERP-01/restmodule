/*
*Defines Inventory related method call for itemCategory
 * 
 */
package nirmalya.aatithya.restmodule.inventory.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.dao.RestInventoryDebitNoteDao;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryDebitNoteModel;
/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "inventory" })
public class RestInventoryDebitNoteController {
	Logger logger=LoggerFactory.getLogger(RestInventoryDebitNoteController.class);
	@Autowired
	RestInventoryDebitNoteDao restInventoryDebitNoteDao;
	
	@RequestMapping(value = "get-all-debit-note", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryDebitNoteModel>>> getAllDebitNote(@RequestBody DataTableRequest request) {
		logger.info("Method : getAllDebitNote starts");
		logger.info("Method : getAllDebitNote endss");
		return restInventoryDebitNoteDao.getAllDebitNote(request);
	}
}

