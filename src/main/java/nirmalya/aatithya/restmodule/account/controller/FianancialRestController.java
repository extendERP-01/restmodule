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

import nirmalya.aatithya.restmodule.account.dao.FinancialDao;
import nirmalya.aatithya.restmodule.account.model.FinancialModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "account/")
public class FianancialRestController {
	Logger logger = LoggerFactory.getLogger(FianancialRestController.class);
	@Autowired
	FinancialDao financialDao;
	@RequestMapping(value = "/addFiancialYear", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addFiancialYear(@RequestBody FinancialModel form) {

		logger.info("Method : addFiancialYear starts");

		logger.info("Method : addFiancialYear end");

		return financialDao.addFiancialYear(form);

	}
	
	@RequestMapping(value = "/getAllFinance", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<FinancialModel>>> getAllFinance(@RequestBody DataTableRequest request) {

		logger.info("Method : getAllFinance starts");

		logger.info("Method : getAllFinance end");

		return financialDao.getAllFinance(request);
	}
	@RequestMapping(value = "/getFinanceYearById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<FinancialModel>> getFinanceYearById(@RequestParam String id,
			@RequestParam("Action") String action) {
		logger.info("Method : getFinanceYearById starts");

		logger.info("Method : getFinanceYearById end");

		return financialDao.getFinanceYearById(id, action);
	}
	
}
