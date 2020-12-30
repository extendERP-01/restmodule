package nirmalya.aatithya.restmodule.recruitment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.recruitment.dao.RequistionDao;
import nirmalya.aatithya.restmodule.recruitment.model.AddRecruitentModel;
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

	@RequestMapping(value = "jobTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> jobTypeList() {
		logger.info("Method : jobTypeList starts");

		logger.info("Method : jobTypeList ends");
		return requistionDao.jobTypeList();
	}
	
	@RequestMapping(value = "jobLocationList", method = { RequestMethod.GET })
	public List<DropDownModel> jobLocationList() {
		logger.info("Method : jobLocationList starts");

		logger.info("Method : jobLocationList ends");
		return requistionDao.jobLocationList();
	}
	
	@RequestMapping(value = "DepartmentList", method = { RequestMethod.GET })
	public List<DropDownModel> DepartmentList() {
		logger.info("Method : DepartmentList starts");

		logger.info("Method : DepartmentList ends");
		return requistionDao.DepartmentList();
	}
	
	@RequestMapping(value = "managerList", method = { RequestMethod.GET })
	public List<DropDownModel> managerList() {
		logger.info("Method : managerList starts");

		logger.info("Method : managerList ends");
		return requistionDao.managerList();
	}
	
	@RequestMapping(value = "bandList", method = { RequestMethod.GET })
	public List<DropDownModel> bandList() {
		logger.info("Method : bandList starts");

		logger.info("Method : bandList ends");
		return requistionDao.bandList();
	}
	
	@RequestMapping(value = "educationList", method = { RequestMethod.GET })
	public List<DropDownModel> educationList() {
		logger.info("Method : educationList starts");

		logger.info("Method : educationList ends");
		return requistionDao.educationList();
	}
	
	@RequestMapping(value = "workHourList", method = { RequestMethod.GET })
	public List<DropDownModel> workHourList() {
		logger.info("Method : workHourList starts");

		logger.info("Method : workHourList ends");
		return requistionDao.workHourList();
	}
	
	@RequestMapping(value = "benefitsList", method = { RequestMethod.GET })
	public List<DropDownModel> benefitsList() {
		logger.info("Method : benefitsList starts");

		logger.info("Method : benefitsList ends");
		return requistionDao.benefitsList();
	}
	
	@RequestMapping(value = "aboutCompany", method = { RequestMethod.GET })
	public List<DropDownModel> aboutCompany() {
		logger.info("Method : aboutCompany starts");

		logger.info("Method : aboutCompany ends");
		return requistionDao.aboutCompany();
	}
	
	@PostMapping(value="addRequisition")
	public ResponseEntity<JsonResponse<Object>> addRequisition(@RequestBody AddRecruitentModel requisition){
		logger.info("Method : addRequisition starts");
		
		logger.info("Method : addRequisition ends");
		return requistionDao.addRequisition(requisition);
	}
	
	@RequestMapping(value = "/viewRequistion", method = {RequestMethod.GET})
	ResponseEntity<JsonResponse<List<AddRecruitentModel>>> getRequistionview()
	{
		logger.info("Method : getRequistionview start");
		
		
		logger.info("Method : getRequistionview ends");
		
		return requistionDao.viewRequistion();
	}
	
	@RequestMapping(value = "/deleteRequistion", method = { RequestMethod.GET})
	 public ResponseEntity<JsonResponse<Object>> deleteRequistionById(@RequestParam String id) {
		logger.info("Method : deleteRequistionById starts");

		logger.info("Method : deleteRequistionById ends");
		return requistionDao.deleteRequistionById(id); 
	}

	@RequestMapping(value = "/editRequisition", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AddRecruitentModel>>> editRequisition(@RequestParam String id) {
		logger.info("Method : editRequisition starts");

		logger.info("Method :editRequisition ends");
		return requistionDao.editRequisition(id);
	}

	
	
}
