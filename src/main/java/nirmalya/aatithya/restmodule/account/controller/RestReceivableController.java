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

import nirmalya.aatithya.restmodule.account.dao.RestReceivableDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.model.SalesInvoiceModel;


/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "account/")
public class RestReceivableController {

	Logger logger = LoggerFactory.getLogger(RestReceivableController.class);

	@Autowired
	RestReceivableDao restReceivableDao;
	
	@RequestMapping(value = "/getReceivableInvoiceById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> getReceivableInvoiceById(@RequestParam("id")String id) {
		logger.info("Method : getReceivableInvoiceById starts");

		logger.info("Method : getReceivableInvoiceById ends");
		return restReceivableDao.getReceivableInvoiceById(id);
	}
	
	@RequestMapping(value = "/getReceivableInvoiceDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> getReceivableInvoiceDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getReceivableInvoiceDetails starts");

		logger.info("Method : getSalesInvoice ends");
		return restReceivableDao.getReceivableInvoiceDetails(request);
	}
	@RequestMapping(value = "/getAccountReceiptVoucher", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> getAccountReceiptVoucher(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getReceivableInvoiceDetails starts");
		
		logger.info("Method : getAccountReceiptVoucher ends");
		return restReceivableDao.getAccountReceiptVoucher(request);
	}
}
