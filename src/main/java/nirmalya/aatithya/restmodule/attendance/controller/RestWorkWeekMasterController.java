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

import nirmalya.aatithya.restmodule.attendance.dao.RestWorkWeekMasterDao;
import nirmalya.aatithya.restmodule.attendance.model.RestWorkWeekMasterModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/*
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "attendance")
public class RestWorkWeekMasterController {
	@Autowired
	RestWorkWeekMasterDao workWeekDao;

	Logger logger = LoggerFactory.getLogger(RestWorkWeekMasterController.class);

	/*
	 * Post Mapping to Add Work Days
	 *
	 */
	@RequestMapping(value = "/addWorkWeek", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddWorkWeek(@RequestBody RestWorkWeekMasterModel workWeekMaster) {
		logger.info("Method : restAddWorkWeek starts");
		logger.info("Method : restAddWorkWeek endss");
		return workWeekDao.restAddWorkWeek(workWeekMaster);
	}

	/*
	 * PostMapping for add get weekday name
	 * 
	 */

	@RequestMapping(value = "rest-get-dayName", method = { RequestMethod.GET })
	public List<DropDownModel> getDayName() {
		logger.info("Method : getDayName starts");
		logger.info("Method : getDayName ends");
		return workWeekDao.getDayName();
	}

	/*
	 * 
	 * PostMapping for get working status
	 * 
	 * 
	 */

	@RequestMapping(value = "rest-get-workingStatus", method = { RequestMethod.GET })
	public List<DropDownModel> getWorkingStatus() {
		logger.info("Method : getWorkingStatus starts");
		logger.info("Method : getWorkingStatus ends");
		return workWeekDao.getWorkingStatus();
	}

	/*
	 * returns all work week days
	 *
	 */
	@RequestMapping(value = "/getAllWorWeek", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestWorkWeekMasterModel>>> getAllWorkWeek(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllWorkWeek starts");
		logger.info("Method : getAllWorkWeek endss");
		return workWeekDao.getAllWorkWeek(request);
	}

	/*
	 * returns particular work week details to view/edit
	 *
	 */
	@RequestMapping(value = "/editWorkWeek", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestWorkWeekMasterModel>> editWorkWeek(@RequestParam("id") String id) {
		logger.info("Method : editWorkWeek starts");
		logger.info("Method : editWorkWeek ends");
		return workWeekDao.editWorkWeek(id);
	}
}
