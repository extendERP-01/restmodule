package nirmalya.aatithya.restmodule.account.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.account.dao.PayableDao;
import nirmalya.aatithya.restmodule.account.model.DataModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.model.SalesInvoiceModel;

@RestController
@RequestMapping(value = "account/")
public class RestPayableController {

	Logger logger = LoggerFactory.getLogger(RestReceivableController.class);

	@Autowired
	PayableDao payableDao;
	
	@RequestMapping(value = "/getVendorBills", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<DataModel>>> getVendorBills(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getVendorBills starts");
		
		logger.info("Method : getVendorBills ends");
		return payableDao.getVendorBills(request);
	}
	
	@RequestMapping(value = "/getOtherBills", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<DataModel>>> getOtherBills(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getOtherBills starts");
		
		logger.info("Method : getOtherBills ends");
		return payableDao.getOtherBills(request);
	}
}
