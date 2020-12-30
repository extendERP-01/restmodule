package nirmalya.aatithya.restmodule.employee.controller;

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
import nirmalya.aatithya.restmodule.employee.dao.ExitFinanceDao;
import nirmalya.aatithya.restmodule.employee.dao.ExitManagementDao;
import nirmalya.aatithya.restmodule.employee.model.ExitFinancialSettelmentModel;
import nirmalya.aatithya.restmodule.employee.model.ExitManagementModel;

@RestController
@RequestMapping("employee/")
public class ExitFinanceRestController {
	Logger logger = LoggerFactory.getLogger(ExitManagementRestController.class);

	@Autowired
	ExitFinanceDao exitFinanceDao;

	@RequestMapping(value = "restAddExitFinance", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddExitFinance(@RequestBody ExitFinancialSettelmentModel exitFinance) {
		logger.info("Method : restAddExitFinance starts");

		logger.info("Method : restAddExitFinance ends");

		return exitFinanceDao.restAddExitFinance(exitFinance);
	}
	
	@RequestMapping(value = "viewExitFinanceDtls", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<ExitFinancialSettelmentModel>>> viewExitFinanceDtls(
			@RequestBody DataTableRequest request) {
		logger.info("Method : viewExitFinanceDtls starts");

		logger.info("Method : viewExitFinanceDtls ends");

		return exitFinanceDao.viewExitFinanceDtls(request);
	}
	
	@RequestMapping(value = "getExitFinanceById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<ExitFinancialSettelmentModel>> getExitFinanceById(@RequestParam String id) {
		logger.info("Method : getExitFinanceById starts");

		logger.info("Method : getExitFinanceById ends");

		return exitFinanceDao.getExitFinanceById(id);
	}
	
}
