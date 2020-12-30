package nirmalya.aatithya.restmodule.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.account.dao.AccountDefinePaymentTermsDao;
import nirmalya.aatithya.restmodule.account.model.DefinePaymentTermsModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping("account")
public class RestAccountDefinePaymentTermsController {

Logger logger = LoggerFactory.getLogger(RestAccountDefinePaymentTermsController.class);
	
	@Autowired
	AccountDefinePaymentTermsDao accountPaymentTermsDao;
	
	@RequestMapping(value = "/addTerms", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addTerms(@RequestBody DefinePaymentTermsModel job) {
		logger.info("Method : addTerms starts");
		logger.info("Method : addTerms ends");
		return accountPaymentTermsDao.addTerms(job);
	}
	
	@RequestMapping(value = "/edit-details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<DefinePaymentTermsModel>> getDetailsEdit() {
		logger.info("Method : getDetailsEdit starts");

		logger.info("Method : getDetailsEdit ends");
		return accountPaymentTermsDao.getDetailsEdit();
	}
}
