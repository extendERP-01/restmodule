package nirmalya.aatithya.restmodule.recruitment.controller;

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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.recruitment.dao.ShiftSchedulingDao;
import nirmalya.aatithya.restmodule.recruitment.model.ShiftSchedulingModel;

@RestController
@RequestMapping("recruitment")
public class ShiftSchedulingRestController {

	Logger logger = LoggerFactory.getLogger(QuestionTypeRestController.class);

	@Autowired
	ShiftSchedulingDao shiftSchedulingDao;
	
	/**
	 * 
	 * @return Specific list
	 */
	@RequestMapping(value = "getScheduleList", method = { RequestMethod.GET })
	public List<DropDownModel> getQuestionList() {

		logger.info("Method : getScheduleList starts");
		logger.info("Method : getScheduleList ends");

		return shiftSchedulingDao.getSchedule();
	}
	
	
	/**
	 * 
	 * @return Specific list
	 */
	@RequestMapping(value = "getSectionList", method = { RequestMethod.GET })
	public List<DropDownModel> getSectionList() {

		logger.info("Method : getSectionList starts");
		logger.info("Method : getSectionList ends");

		return shiftSchedulingDao.getSection();
	}
	
	
	/**
	 * 
	 * @return Specific list
	 */
	@RequestMapping(value = "getDepartmentList", method = { RequestMethod.GET })
	public List<DropDownModel> getDepartmentList() {

		logger.info("Method : getDepartmentList starts");
		logger.info("Method : getDepartmentList ends");

		return shiftSchedulingDao.getDepartment();
	}
	
	
	/**
	 * 
	 * @return Specific list
	 */
	@RequestMapping(value = "getShiftList", method = { RequestMethod.GET })
	public List<DropDownModel> getShiftList() {

		logger.info("Method : getShiftList starts");
		logger.info("Method : getShiftList ends");

		return shiftSchedulingDao.getShift();
	}
	
	
	/**
	 * 
	 * @return Specific list
	 */
	@RequestMapping(value = "getEmpList", method = { RequestMethod.GET })
	public List<DropDownModel> getEmpList() {

		logger.info("Method : getEmpList starts");
		logger.info("Method : getEmpList ends");

		return shiftSchedulingDao.getEmployee();
	}
	
	/*
	 * for Add Other Service price getAssignEduDetails
	 */
	@RequestMapping(value = "restSchedule", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restSchedule(
			@RequestBody List<ShiftSchedulingModel> shiftSchedulingModel) {
		logger.info("Method in rest: restAddQuestion starts");

		logger.info("Method in rest: restAddQuestion ends");

		return shiftSchedulingDao.restAddSchedule(shiftSchedulingModel);
	}
	
	/*
	 * for view ShiiftSchedule
	 */
	@RequestMapping(value = "/getAssignShiftDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<ShiftSchedulingModel>>> getAssignShiftDetails(@RequestBody DataTableRequest tableRequest) {
		logger.info("Method : getAssignShiftDetails starts");

		logger.info("Method : getAssignShiftDetails ends");

		return shiftSchedulingDao.getAssignShiftedDetails(tableRequest);
	}
	
	/*
	 * for assign  Edit
	 */
	@RequestMapping(value = "/getShiftDepndById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ShiftSchedulingModel>>> getShiftDepndById(
			@RequestParam("sShiftId") String sShiftId) {
		logger.info("Method : getShiftDepndById starts");

		logger.info("Method : getShiftDepndById ends");

		return shiftSchedulingDao.getShiftListById(sShiftId);
	}

}
