package nirmalya.aatithya.restmodule.recruitment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse; 
import nirmalya.aatithya.restmodule.recruitment.dao.ResourceDao;
import nirmalya.aatithya.restmodule.recruitment.model.ResourceModel;

@RestController
@RequestMapping("recruitment")
public class ResourceRestController {

	Logger logger = LoggerFactory.getLogger(ResourceRestController.class);
	
	@Autowired
	ResourceDao resourceDao;
	
	@RequestMapping(value = "/getResource", method = {RequestMethod.GET})
	ResponseEntity<JsonResponse<List<ResourceModel>>> getResource()
	{
		logger.info("Method : getResource strats");
		
		
		logger.info("Method : getResource ends");
		
		return resourceDao.getResource();
	}
	
	@RequestMapping(value = "/getDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<ResourceModel>> getDetails(@RequestParam String id) {
		logger.info("Method : getDetails starts");

		logger.info("Method :getDetails ends");
		return resourceDao.getDetails(id);
	}
	
	@GetMapping(value = "getVendor")
	public List<DropDownModel> getvendor() {

		logger.info("Method : getvendor starts");
		logger.info("Method : getvendor ends");

		return resourceDao.getVendorList();
	}
	

	@GetMapping(value = "getVendorSelected")
	public List<DropDownModel> getVendorSelected(@RequestParam String id) {

		logger.info("Method : getVendorSelected starts");
		logger.info("Method : getVendorSelected ends");

		return resourceDao.getVendorSelected(id);
	}
	
	@RequestMapping(value = "setVendor", method = {RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> setVendor(
			@RequestBody ResourceModel index){
		
		logger.info("Method: setFoodOrder starts");
		logger.info("Method: setFoodOrder ends");
		
		return resourceDao.setVendor(index);
	}
	
	@RequestMapping(value = "/getShortList", method = {RequestMethod.GET})
	ResponseEntity<JsonResponse<List<ResourceModel>>> getShortList()
	{
		logger.info("Method : getShortList strats");
		logger.info("Method : getShortList ends");
		
		return resourceDao.getShortList();
	}
	
	@RequestMapping(value="/addShortListCandidate" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addShortListCandidate(@RequestBody  List<ResourceModel> candidate) {
		logger.info("Method : addShortListCandidate for rest controller starts");
		System.out.println(candidate);
		logger.info("Method : addShortListCandidate for rest controller ends");
		return resourceDao.addShortListCandidate(candidate);
	}
	
	@RequestMapping(value = "/getShortListCandidate", method = {RequestMethod.GET})
	ResponseEntity<JsonResponse<List<ResourceModel>>> gerList()
	{
		logger.info("Method : gerList strats");
		logger.info("Method : gerList ends");
		
		return resourceDao.getList();
	}
	
	@GetMapping(value = "getEmployee")
	public ResponseEntity<JsonResponse<List<ResourceModel>>> getEmpList() {

		logger.info("Method : getEmpList starts");
		logger.info("Method : getEmpList ends");

		return resourceDao.getEmpList();
	}
	
	@GetMapping(value = "getInterviewerDtls")
	public ResponseEntity<JsonResponse<List<ResourceModel>>> getInterviewerDtls(@RequestParam String id) {

		logger.info("Method : getInterviewerDtls starts");
		
		logger.info("Method : getInterviewerDtls ends");

		return resourceDao.getInterviewerDtls(id);
	}
	
	@RequestMapping(value = "addHold", method = {RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addHold(
			@RequestBody ResourceModel index){
		
		logger.info("Method: addHold starts");
		logger.info("Method: addHold ends");
		
		return resourceDao.addHold(index);
	}
	
	@RequestMapping(value = "addShortListInterview", method = {RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addShortListInterview(
			@RequestBody ResourceModel index){
		
		logger.info("Method: addShortListInterview starts");
		logger.info("Method: addShortListInterview ends");
		
		return resourceDao.addShortListInterview(index);
	}
	
	@GetMapping(value = "getJobTitleList")
	public List<DropDownModel> getJobTitleList() {

		logger.info("Method : getJobTitleList starts");
		logger.info("Method : getJobTitleList ends");

		return resourceDao.getJobTitleList();
	}
	
	@GetMapping(value = "getAllDetails")
	public ResponseEntity<JsonResponse<List<ResourceModel>>> getStruct(@RequestParam String id)
	{
		logger.info("Method : getStruct strats");
		
		logger.info("Method : getStruct ends");
		
		return resourceDao.getAllDetails(id);
	}
	

	@RequestMapping(value = "/editFeedbackDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ResourceModel>>> editFeedbackDetails(@RequestParam String id, @RequestParam String index) {
		logger.info("Method : editFeedbackDetails starts");

		logger.info("Method :editFeedbackDetails ends");
		return resourceDao.editFeedbackDetails(id,index);
	}
	
	@GetMapping(value = "getSpecificNameList")
	public List<DropDownModel> getSpecificNameList() {

		logger.info("Method : getSpecificNameList starts");
		logger.info("Method : getSpecificNameList ends");

		return resourceDao.getSpecificNameList();
	}
	
	@GetMapping(value = "getQuestion")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getQuestion(@RequestParam String id) {

		logger.info("Method : getQuestion starts");
		logger.info("Method : getQuestion ends");

		return resourceDao.getQuestion(id);
	}
	
	@RequestMapping(value = "addFeedback", method = {RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addFeedback(
			@RequestBody List<ResourceModel> index){
		
		logger.info("Method: addFeedback starts");
		logger.info("Method: addFeedback ends");
		
		return resourceDao.addFeedback(index);
	}
	
	@RequestMapping(value = "/addOfferLetter", method = {RequestMethod.GET})
	ResponseEntity<JsonResponse<List<ResourceModel>>> addOfferLetter()
	{
		logger.info("Method : addOfferLetter strats");
		logger.info("Method : addOfferLetter ends");
		
		return resourceDao.addOfferLetter();
	}
	
	@RequestMapping(value = "addFinalStatus", method = {RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addFinalStatus(
			@RequestBody ResourceModel index){
		
		logger.info("Method: addFinalStatus starts");
		logger.info("Method: addFinalStatus ends");
		
		return resourceDao.addFinalStatus(index);
	}
	
	@RequestMapping(value = "/generateOfferLetter", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<ResourceModel>> generateOfferLetter(@RequestParam String reqId, @RequestParam String candId) {
		logger.info("Method : generateOfferLetter starts");

		logger.info("Method :generateOfferLetter ends");
		return resourceDao.generateOfferLetter(reqId,candId);
	}
	
	@RequestMapping(value = "/getFeedbackDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ResourceModel>>> getFeedbackDetails(@RequestParam String empId, @RequestParam String candId) {
		logger.info("Method : getFeedbackDetails starts");

		logger.info("Method :getFeedbackDetails ends");
		return resourceDao.getFeedbackDetails(empId, candId);
	}
	
	@GetMapping(value = "viewDetails")
	public ResponseEntity<JsonResponse<List<ResourceModel>>> viewDetails(@RequestParam String reqId, @RequestParam String candId) {

		logger.info("Method : viewDetails starts");
		logger.info("Method : viewDetails ends");

		return resourceDao.viewDetails(reqId,candId);
	}
	
	
}
