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
import nirmalya.aatithya.restmodule.production.dao.AssignSlitPipeSizeDao;
import nirmalya.aatithya.restmodule.production.model.AssignSlitPipeSizeModel;
 
/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "production/")
public class AssignSlitPipeSizeRestController {

	Logger logger = LoggerFactory.getLogger(AssignSlitPipeSizeRestController.class);

	@Autowired
	AssignSlitPipeSizeDao assignSlitPipeSizeDao;
	
	@RequestMapping(value="getSlitWithForAssignment" , method={RequestMethod.GET})
	public List<DropDownModel> restGetSlitWithForAssignment() {
		logger.info("Method : restGetSlitWithForAssignment starts");

		logger.info("Method : restGetSlitWithForAssignment ends");
		return assignSlitPipeSizeDao.getSlitWithForAssignmentDao();
	}
	
	@RequestMapping(value = "/getGradeForAssignment", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> restGetGrade(@RequestParam String id) {
		logger.info("Method : restGetGrade starts");
		
		logger.info("Method : restGetGrade ends");
		return assignSlitPipeSizeDao.getGradeDao(id);
	}
	
	@RequestMapping(value = "/getThicknessForAssignment", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> restGetThickness(@RequestBody DropDownModel id) {
		logger.info("Method : restGetThickness starts");

		logger.info("Method : restGetThickness ends");
		return assignSlitPipeSizeDao.getThicknessDao(id);
	}
	
	@RequestMapping(value = "/getPipeSizeForAssignment", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> restGetPipeSize(@RequestBody DropDownModel id) {
		logger.info("Method : restGetPipeSize starts");
		
		logger.info("Method : restGetPipeSize ends");
		return assignSlitPipeSizeDao.getPipeSizeDao(id);
	}
	
	@RequestMapping(value="saveAssignedSlitPipeSize" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> restAssignedSlitPipeSize(@RequestBody  List<AssignSlitPipeSizeModel> assignment) {
		logger.info("Method : restAssignedSlitPipeSize for rest controller starts");
		
		logger.info("Method : restAssignedSlitPipeSize for rest controller ends");
		return assignSlitPipeSizeDao.saveAssignedSlitPipeSizeDao(assignment);
	}
	
	@RequestMapping(value = "/getAssignedSlitPipeSize", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AssignSlitPipeSizeModel>>> restGetAssignedSlitPipeSize(
			@RequestBody DataTableRequest request) {
		logger.info("Method : restGetAssignedSlitPipeSize starts");

		logger.info("Method : restGetAssignedSlitPipeSize ends");
		return assignSlitPipeSizeDao.getAssignedSlitPipeSizeDetails(request);
	}
	
	@RequestMapping(value = "/deleteAssignedSlitPipe", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restDeleteAssignedSlitPipe(@RequestBody AssignSlitPipeSizeModel id) {
		logger.info("Method : restDeleteAssignedSlitPipe starts");
		
		logger.info("Method : restDeleteAssignedSlitPipe ends");
		return assignSlitPipeSizeDao.deleteAssignedSlitPipeDao(id);
	}
}
