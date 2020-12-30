package nirmalya.aatithya.restmodule.master.controller;

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
import nirmalya.aatithya.restmodule.master.dao.PaymentModeMasterDao;
import nirmalya.aatithya.restmodule.master.model.PaymentModeMasterModel;


/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping("master")
public class PaymentModeMasterRestController {
	Logger logger = LoggerFactory.getLogger(PaymentModeMasterRestController.class);
	@Autowired
	PaymentModeMasterDao paymentDao;
	/**
	 * Post Mapping to Add new payment mode
	 *
	 */
	@RequestMapping(value = "/addPaymentMode", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addPaymentMode(@RequestBody PaymentModeMasterModel form) {

		logger.info("Method : addPaymentMode starts");

		logger.info("Method : addPaymentMode end");

		return paymentDao.addPaymentMode(form);

	}
	/**
	 * returns all property payment mode
	 *
	 */
	@RequestMapping(value = "/getAllPayment", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<PaymentModeMasterModel>>> getAllPayment(@RequestBody DataTableRequest request) {

		logger.info("Method : getAllPayment starts");

		logger.info("Method : getAllPayment end");

		return paymentDao.getAllPayment(request);
	}
	/**
	 * returns edit property floor
	 *
	 */
	/*@RequestMapping(value = "/getPaymentById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<PaymentModeMasterModel>> getPaymentById(@RequestParam String id) {

		logger.info("Method : getPaymentById starts");

		logger.info("Method : getPaymentById end");

		return paymentDao.getPaymentById(id);
	}*/
	
	@RequestMapping(value = "/getPaymentById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<PaymentModeMasterModel>> getPaymentById(@RequestParam String id,
			@RequestParam("Action") String action) {
		logger.info("Method : getPaymentById starts");

		logger.info("Method : getPaymentById end");

		return paymentDao.getPaymentById(id, action);
	}
	@RequestMapping(value = "/deletePaymentById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletePaymentById(@RequestParam String id,@RequestParam String createdBy) {
		logger.info("Method : deletePaymentById starts");

		logger.info("Method : deletePaymentById end");

		return paymentDao.deletePaymentById(id,createdBy);
	}
}
