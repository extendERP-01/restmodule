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

import nirmalya.aatithya.restmodule.attendance.dao.RestHolidayMasterDao;
import nirmalya.aatithya.restmodule.attendance.model.RestHolidayMasterModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/*
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "attendance")
public class RestHolidayMasterController {

	@Autowired
	RestHolidayMasterDao holidayDao;

	Logger logger = LoggerFactory.getLogger(RestHolidayMasterController.class);

	/*
	 * 
	 * PostMapping for add get holiday name
	 * 
	 * 
	 */

	@RequestMapping(value = "get-holiday-status", method = { RequestMethod.GET })
	public List<DropDownModel> getHolidayStatus() {
		logger.info("Method : getHolidayStatus starts");
		logger.info("Method : getHolidayStatus ends");
		return holidayDao.getHolidayStatus();
	}

	/*
	 * Post Mapping to Add Holidays
	 *
	 */
	@RequestMapping(value = "/addHoliday", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddHoliday(@RequestBody RestHolidayMasterModel holidayListMaster) {
		logger.info("Method : restAddHoliday starts");
		logger.info("Method : restAddHoliday endss");
		return holidayDao.restAddHoliday(holidayListMaster);
	}

	/*
	 * returns all work week days
	 *
	 */
	@RequestMapping(value = "/getAllHoliday", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestHolidayMasterModel>>> getAllHoliday(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllHoliday starts");
		logger.info("Method : getAllHoliday endss");
		return holidayDao.getAllHoliday(request);
	}

	/*
	 * returns particularHoliday details to view/edit
	 *
	 */
	@RequestMapping(value = "/editHoliday", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestHolidayMasterModel>> editHoliday(@RequestParam("id") String id) {
		logger.info("Method : editHoliday starts");
		logger.info("Method : editHoliday ends");
		return holidayDao.editHoliday(id);
	}

	/*
	 * delete particular Holiday
	 *
	 */
	@RequestMapping(value = "/deleteHoliday", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteHouseTask(@RequestParam String id,
			@RequestParam String createdBy) {

		logger.info("Method : deleteHoliday starts");

		logger.info("Method : deleteHoliday end");

		return holidayDao.deleteHoliday(id, createdBy);
	}
}
