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
import nirmalya.aatithya.restmodule.recruitment.dao.ShiftManagementMaster;
import nirmalya.aatithya.restmodule.recruitment.model.ShiftMasterRestModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping("recruitment/")

public class ShiftMasterRestController {

	Logger logger = LoggerFactory.getLogger(ShiftMasterRestController.class);

	@Autowired
	ShiftManagementMaster shiftManagementMaster;

	@RequestMapping(value = "dropDownshift", method = { RequestMethod.GET })
	public List<DropDownModel> dropDownshift() {
		logger.info("Method : dropDownshift starts");

		logger.info("Method : dropDownshift ends");
		return shiftManagementMaster.dropDownshift();
	}

	@RequestMapping(value = "restAddShift", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddShift(

			@RequestBody ShiftMasterRestModel mixDesign) {
		logger.info("Method in rest: restAddShift starts");

		logger.info("Method in rest: restAddShift ends");
		return shiftManagementMaster.restAddShift(mixDesign);
	}

	// get requition details
	@RequestMapping(value = "/getshiftd", method = { RequestMethod.POST })
	ResponseEntity<JsonResponse<List<ShiftMasterRestModel>>> getshiftd(@RequestBody DataTableRequest request) {
		logger.info("Method : getRequistionview start");

		logger.info("Method : getRequistionview ends");

		return shiftManagementMaster.viewshift(request);
	}
	// get details for edit view

	@RequestMapping(value = "/getShifteditById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<ShiftMasterRestModel>> resteditShifbyId(@RequestParam String id) {
		logger.info("Method : editShiftbyId starts");

		logger.info("Method :editShiftbyId ends");
		return shiftManagementMaster.resteditShifbyId(id);
	}

	// Delete
	@RequestMapping(value = "deleteShift", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteShiftbyId(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deleteShiftbyId starts");

		logger.info("Method : deleteShiftbyId ends");
		return shiftManagementMaster.deleteShiftbyId(id, createdBy);
	}

	@RequestMapping(value = "getshiftmodalById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ShiftMasterRestModel>>> getshiftmodalByIdmodal(
			@RequestParam String shiftId) {
		logger.info("Method : getshiftmodalId starts");

		logger.info("Method : getshiftmodalId ends");

		return shiftManagementMaster.getshiftmodalByIdmodal(shiftId);
	}

}
