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
import nirmalya.aatithya.restmodule.recruitment.dao.RequistionDao;
import nirmalya.aatithya.restmodule.recruitment.model.RequistionRestModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping("recruitment/")
public class RequistionRestController {

	Logger logger = LoggerFactory.getLogger(RequistionRestController.class);

	@Autowired
	RequistionDao requistionDao;

	@RequestMapping(value = "getjobCodeList", method = { RequestMethod.GET })
	public List<DropDownModel> getjobCodeList() {
		logger.info("Method : getjobCode starts");

		logger.info("Method : getjobCode ends");
		return requistionDao.getjobCodeList();
	}

	/**
	 * Rest Controller - Get Circle Name For Drop Down
	 *
	 */
	@RequestMapping(value = "/getJobTitleForJobTitle", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<DropDownModel>> getJobTitleForJobTitl(@RequestParam String id) {
		logger.info("Method : dropDownCircle starts");

		logger.info("Method : dropDownCircle ends");
		return requistionDao.getJobTitleForJobTitl(id);
	}

	@RequestMapping(value = "/getDepartmentForDepa", method = { RequestMethod.GET })
	public List<DropDownModel> getDepartmentForDepa() {
		logger.info("Method : getDepartment starts");

		logger.info("Method : getDepartment end");
		return requistionDao.getDepartmentForDepa();
	}

	@RequestMapping(value = "/getHiringManagerForMang", method = { RequestMethod.GET })
	public List<DropDownModel> getHiringManagerForMang() {
		logger.info("Method : getHiringManager starts");

		logger.info("Method : getHiringManager end");
		return requistionDao.getHiringManagerForMang();
	}

	@RequestMapping(value = "restAddRequistion", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddRequistion(

			@RequestBody RequistionRestModel mixDesignModel) {
		logger.info("Method in rest: restAddMixDesign starts");

		logger.info("Method in rest: restAddMixDesign ends");
		return requistionDao.restAddRequistion(mixDesignModel);
	}

//get requition details
	@RequestMapping(value = "/getRequistionview", method = { RequestMethod.POST })
	ResponseEntity<JsonResponse<List<RequistionRestModel>>> getRequistionview(@RequestBody DataTableRequest request) {
		logger.info("Method : getRequistionview start");

		logger.info("Method : getRequistionview ends");

		return requistionDao.viewRequistion(request);
	}

	// get details for edit view

	@RequestMapping(value = "/getrequiById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RequistionRestModel>> restAddRequistionbyId(@RequestParam String id) {
		logger.info("Method : editRequistionbyId starts");

		logger.info("Method :editRequistionbyId ends");
		return requistionDao.restAddRequistionbyId(id);
	}

	// get details for delete view

	// Delete Structure
	@RequestMapping(value = "deleteRequistion", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteRequistionById(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deleteRequistionById starts");

		logger.info("Method : deleteRequistionById ends");
		return requistionDao.deleteRequistionById(id, createdBy);
	}

	@RequestMapping(value = "getreqmodalById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RequistionRestModel>>> getrequiBymodalId(@RequestParam String reqId) {
		logger.info("Method : getrequiById starts");
		System.out.println(reqId);
		logger.info("Method : getrequiById ends");

		return requistionDao.getrequiByIdl(reqId);
	}

}
