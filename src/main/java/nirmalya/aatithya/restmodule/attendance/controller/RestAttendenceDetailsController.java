package nirmalya.aatithya.restmodule.attendance.controller;

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

import nirmalya.aatithya.restmodule.attendance.dao.RestAttendenceDetailsDao;
import nirmalya.aatithya.restmodule.attendance.model.RestAttendenceDetailsModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


/*
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "attendance")
public class RestAttendenceDetailsController {
	@Autowired
	RestAttendenceDetailsDao attendenceDao;

	Logger logger = LoggerFactory.getLogger(RestAttendenceDetailsController.class);

	/*
	 * Post Mapping to Add PunchIn Attendence
	 *
	 */
	@RequestMapping(value = "/addAttendencePunchIn", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addAttendencePunchIn(
			@RequestBody RestAttendenceDetailsModel attendenceDetails) {
		logger.info("Method : addAttendencePunchIn starts");
		logger.info("Method : addAttendencePunchIn endss");
		return attendenceDao.addAttendencePunchIn(attendenceDetails);
	}

	/*
	 * returns punchIn time
	 *
	 */
	@RequestMapping(value = "get-details", method = { RequestMethod.GET })
	public List<DropDownModel> getDetails(@RequestParam String empId, @RequestParam String date) {
		logger.info("Method : getDetails starts");
		logger.info("Method : getDetails ends");
		return attendenceDao.getDetails(empId, date);
	}

	/*
	 * returns all attendence details
	 *
	 */
	@RequestMapping(value = "/getAttendenceDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestAttendenceDetailsModel>>> getAllAttendence(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllAttendence starts");
		logger.info("Method : getAllAttendence endss");
		return attendenceDao.getAllAttendence(request);
	}

	/*
	 * Post Mapping to Add PunchOut Details
	 *
	 */
	@RequestMapping(value = "/addAttendencePunchOut", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addAttendencePunchOut(
			@RequestBody RestAttendenceDetailsModel attendenceDetails) {
		logger.info("Method : addAttendencePunchOut starts");
		logger.info("Method : addAttendencePunchOut endss");
		return attendenceDao.addAttendencePunchOut(attendenceDetails);
	}

}
