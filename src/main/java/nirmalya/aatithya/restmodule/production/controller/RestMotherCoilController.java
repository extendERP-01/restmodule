package nirmalya.aatithya.restmodule.production.controller;

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
import nirmalya.aatithya.restmodule.production.dao.RestMotherCoilDao;
import nirmalya.aatithya.restmodule.production.model.MotherCoilSlitReportModel;
import nirmalya.aatithya.restmodule.production.model.RestMotherCoilModel;

@RestController
@RequestMapping("production/")
public class RestMotherCoilController {

	@Autowired
	RestMotherCoilDao restMotherCoilDao;

	Logger logger = LoggerFactory.getLogger(RestMotherCoilController.class);

	/*
	 *
	 * PostMapping for add Mother Coil Slit details
	 *
	 *
	 */
	@RequestMapping(value = "add-mother-coil-slit", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addMasterCoilPost(@RequestBody List<RestMotherCoilModel> motherCoil) {
		logger.info("Method : addGradeSalaryMasterPost starts");
		logger.info("Method : addGradeSalaryMasterPost ends");
		return restMotherCoilDao.addMotherCoil(motherCoil);
	}

	/**
	 * GET mother coil grade
	 *
	 */

	@RequestMapping(value = "getMotherCoilGrade", method = { RequestMethod.GET })
	public List<DropDownModel> getGradeList() {
		logger.info("Method : RESTMODULE RestMotherCoilController getGradeList starts");
		logger.info("Method : RESTMODULE RestMotherCoilController getGradeList ends");
		return restMotherCoilDao.getGradeList();
	}

	/**
	 * GET mother coil Batch
	 *
	 */

	@RequestMapping(value = "getMotherCoilBatch", method = { RequestMethod.GET })
	public List<DropDownModel> getMotherCoilBatch() {
		logger.info("Method : RESTMODULE RestMotherCoilController getMotherCoilBatch starts");
		logger.info("Method : RESTMODULE RestMotherCoilController getMotherCoilBatch ends");
		return restMotherCoilDao.getMotherCoilBatch();
	}

	/**
	 * GET mother coil Batch ehited
	 *
	 */ 

	@RequestMapping(value = "getMotherCoilBatchEdit", method = { RequestMethod.GET })
	public List<DropDownModel> getMotherCoilBatchEdit() {
		logger.info("Method : RESTMODULE RestMotherCoilController getMotherCoilBatchEdit starts");
		logger.info("Method : RESTMODULE RestMotherCoilController getMotherCoilBatchEdit ends");
		return restMotherCoilDao.getMotherCoilBatchEdit();
	}

	/*
	 * view all mother coil
	 */
	@RequestMapping(value = "viewMotherCoil", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestMotherCoilModel>>> viewMotherCoil(
			@RequestBody DataTableRequest request) {
		logger.info("Method : viewMotherCoil starts");

		logger.info("Method : viewMotherCoil ends");

		return restMotherCoilDao.viewMotherCoil(request);
	}

	/*
	 * for viewmodel
	 */
	@RequestMapping(value = "viewMotherCoilById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestMotherCoilModel>>> viewMotherCoilId(
			@RequestParam("mBatchId") String mBatchId, @RequestParam("mThickId") String mThickId,
			@RequestParam("slitBatchId") String slitBatchId) {
		logger.info("Method : viewMotherCoilById starts");

		logger.info("Method : viewMotherCoilById ends");

		return restMotherCoilDao.viewMotherCoilId(mBatchId, mThickId, slitBatchId);
	}

	@RequestMapping(value = "/edit-MotherCoil-ById", method = { RequestMethod.GET })
	public List<RestMotherCoilModel> editMotherCoil(@RequestParam("mBatchId") String mBatchId,
			@RequestParam("mThickId") String mThickId, @RequestParam("slitBatchId") String slitBatchId) {
		logger.info("Method : editMotherCoil for rest controller starts");

		logger.info("Method : editMotherCoil for rest controller ends");
		return restMotherCoilDao.editMotherCoil(mBatchId, mThickId, slitBatchId);
	}

	/*
	 * Get mapping for get thickness on grade change
	 */

	@RequestMapping(value = "getThicknessByGradeMotherCoil", method = { RequestMethod.GET })

	public ResponseEntity<JsonResponse<List<DropDownModel>>> getThicknessByGrade(@RequestParam String id) {
		logger.info("Method : getThicknessByGradeMotherCoil starts");
		logger.info("Method : getThicknessByGradeMotherCoil ends");
		return restMotherCoilDao.getThicknessByGrade(id);
	}

	/*
	 * Get mapping for get Property Type
	 */

	@RequestMapping(value = "getSlitWidthByThickness", method = { RequestMethod.GET })

	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSlitWidthByThickness(@RequestParam String id,
			@RequestParam String thickness) {
		logger.info("Method : getSlitWidthByThickness starts");
		logger.info("Method : getSlitWidthByThickness ends");
		return restMotherCoilDao.getSlitWidthByThickness(id, thickness);
	}

	/*
	 * Get mapping for get Property Type
	 */

	@RequestMapping(value = "getPipeSizeBySlitWidth", method = { RequestMethod.GET })

	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPipeSizeBySlitWidth(@RequestParam String id,
			@RequestParam String thickness, @RequestParam String slitWidth) {
		logger.info("Method : getPipeSizeBySlitWidth starts");
		logger.info("Method : getPipeSizeBySlitWidth ends");
		return restMotherCoilDao.getPipeSizeBySlitWidth(id, thickness, slitWidth);
	}

	/**
	 * GET mother coil grade edited
	 *
	 */

	@RequestMapping(value = "getthicknessEdit", method = { RequestMethod.GET })
	public List<DropDownModel> getthicknessEdit(@RequestParam String grade) {
		logger.info("Method : RESTMODULE getthicknessEdit starts");
		logger.info("Method : RESTMODULE getthicknessEdit ends");
		return restMotherCoilDao.getthicknessEdit(grade);
	}

	@RequestMapping(value = "getSlitWidthEdit", method = { RequestMethod.GET })
	public List<DropDownModel> getSlitWidthEdit(@RequestParam String grade, @RequestParam String thickness) {
		logger.info("Method : RESTMODULE getSlitWidthEdit   starts");
		logger.info("Method : RESTMODULE getSlitWidthEdit   ends");
		return restMotherCoilDao.getSlitWidthEdit(grade, thickness);
	}

	@RequestMapping(value = "getPipeSizeit", method = { RequestMethod.GET })
	public List<DropDownModel> getPipeSizeit(@RequestParam String grade, @RequestParam String thickness) {
		logger.info("Method : RESTMODULE getPipeSizeit   starts");
		logger.info("Method : RESTMODULE getPipeSizeit   ends");
		return restMotherCoilDao.getPipeSizeit(grade, thickness);
	}

	/*
	 * for view all mother coil reports
	 */
	@RequestMapping(value = "getAllMotherCoilSlit", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestMotherCoilModel>>> getAllMotherCoilSlit(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllMotherCoilSlit starts");

		logger.info("Method : getAllMotherCoilSlit ends");

		return restMotherCoilDao.getAllMotherCoilSlit(request);
	}

	/**
	 * REST CONTROLLER - Get Hotel Logo
	 *
	 */
	@RequestMapping(value = "restLogoImage", method = { RequestMethod.GET })
	public List<DropDownModel> restGetLogoImageForPayVocher(@RequestParam("logoType") String logoType) {
		logger.info("Method : restGetLogoImage starts");

		logger.info("Method : restGetLogoImage ends");
		return restMotherCoilDao.getHotelLogoForVoucher(logoType);
	}

	/*
	 * for mother coil reports
	 */
	@RequestMapping(value = "getMotherCoilBatchReport", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<MotherCoilSlitReportModel>>> getMotherCoilBatchReport(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getMotherCoilBatchReport starts");

		logger.info("Method : getMotherCoilBatchReport ends");

		return restMotherCoilDao.getMotherCoilBatchReport(request);
	}

	@RequestMapping(value = "getMotherCoilBatchReportPDF", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<MotherCoilSlitReportModel>>> getMotherCoilBatchReportPDF(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getMotherCoilBatchReportPDF starts");

		logger.info("Method : getMotherCoilBatchReportPDF ends");

		return restMotherCoilDao.getMotherCoilBatchReportPDF(request);
	}

	/*
	 * Get details of batch code
	 */

	@RequestMapping(value = "getDetailsByBatchCode", method = { RequestMethod.GET })

	public ResponseEntity<JsonResponse<List<RestMotherCoilModel>>> getDetailsByBatchCode(@RequestParam String id ) {
		logger.info("Method : getDetailsByBatchCode starts");
		logger.info("Method : getDetailsByBatchCode ends");
		return restMotherCoilDao.getDetailsByBatchCode(id );
	}
	
}
