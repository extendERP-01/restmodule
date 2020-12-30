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
import nirmalya.aatithya.restmodule.reimbursement.dao.HrmsReimbursementTypeDao;
import nirmalya.aatithya.restmodule.reimbursement.model.HrmsReimbursementTypeModel;

@RestController
@RequestMapping("reimbursement/")
public class HrmsReimbursementTypeRestController {
	Logger logger = LoggerFactory.getLogger(HrmsReimbursementTypeRestController.class);

	@Autowired
	HrmsReimbursementTypeDao hrmsReimbursementTypeDao;

	/*
	 * for All reimbursementType
	 */
	@RequestMapping(value = "getreimbursementTypeDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsReimbursementTypeModel>>> getreimbursementTypeDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getreimbursementTypeDetails starts");

		logger.info("Method : getreimbursementTypeDetails ends");

		return hrmsReimbursementTypeDao.getreimbursementTypeDetails(request);
	}

	/*
	 * for All Add reimbursementType
	 */
	@RequestMapping(value = "restAddreimbursementTypes", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddreimbursementType(
			@RequestBody HrmsReimbursementTypeModel reimbursementType) {
		logger.info("Method : restAddreimbursementType starts");

		logger.info("Method : restAddreimbursementType ends");

		return hrmsReimbursementTypeDao.addreimbursementType(reimbursementType);
	}

	/*
	 * for reimbursementType Edit
	 */
	@RequestMapping(value = "getreimbursementTypeById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<HrmsReimbursementTypeModel>> getreimbursementTypeById(@RequestParam String id) {
		logger.info("Method : getreimbursementTypeById starts");

		logger.info("Method : getreimbursementTypeById ends");

		return hrmsReimbursementTypeDao.getreimbursementTypeById(id);
	}

	/*
	 * for All reimbursementType Delete
	 */
	@RequestMapping(value = "deletereimbursementTypeById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletereimbursementTypeById(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deletereimbursementTypeById starts");

		logger.info("Method : deletereimbursementTypeById ends");

		return hrmsReimbursementTypeDao.deletereimbursementTypeById(id, createdBy);
	}
}
