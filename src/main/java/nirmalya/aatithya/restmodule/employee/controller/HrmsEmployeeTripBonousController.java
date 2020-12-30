package nirmalya.aatithya.restmodule.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.HrmsEmployeeTripBonousDao;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeBonousModel; 

/**
 * 
 * @author Nirmalya
 *
 */
@RestController
@RequestMapping("employee/")
public class HrmsEmployeeTripBonousController {

	@Autowired
	HrmsEmployeeTripBonousDao tripDtlsDao;

	Logger logger = LoggerFactory.getLogger(HrmsEmployeeTripBonousController.class);

	/*
	 *
	 * PostMapping for add Mother Coil Slit details
	 *
	 *
	 */
	@PostMapping(value = "add-trip-bonous")
	public ResponseEntity<JsonResponse<Object>> addTripBonousPost(
			@RequestBody List<HrmsEmployeeBonousModel> motherCoil) {
		logger.info("Method : addTripBonousPost starts");
		logger.info("Method : addTripBonousPost ends");
		return tripDtlsDao.addTripBonousPost(motherCoil);

	}

	/*
	 * view production mix
	 */
	@PostMapping(value = "view-trip-bonous-details")
	public ResponseEntity<JsonResponse<List<HrmsEmployeeBonousModel>>> viewTripBonousMix(
			@RequestBody DataTableRequest request) {
		logger.info("Method : viewTripBonousMix starts");

		logger.info("Method : viewTripBonousMix ends");

		return tripDtlsDao.viewTripBonousMix(request);
	}

	@GetMapping(value = "view-production-details-by-id")
	public ResponseEntity<JsonResponse<List<HrmsEmployeeBonousModel>>> viewProductionDetailsById(
			@RequestParam("mplanId") String mplanId, @RequestParam String prodId) {
		logger.info("Method : viewProductionDetailsById starts");

		logger.info("Method : viewProductionDetailsById ends");

		return tripDtlsDao.viewProductionDetailsById(mplanId, prodId);
	}

	@GetMapping(value = "rest-get-trip-details")
	public ResponseEntity<JsonResponse<List<HrmsEmployeeBonousModel>>> getBonousDetails(@RequestParam String toDate,
			@RequestParam String fromDate) {
		logger.info("Method : getBonousDetails starts");

		logger.info("Method : getBonousDetails ends");

		return tripDtlsDao.getBonousDetails(toDate, fromDate);
	}

	/*
	 * for assignSkill Edit
	 */
	@RequestMapping(value = "getTripDetailsById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsEmployeeBonousModel>>> getTripDetailsById(@RequestParam String date ) {
		logger.info("Method : getTripDetailsById starts");

		logger.info("Method : getTripDetailsById ends");

		return tripDtlsDao.getTripDetailsById(date );
	}

}
