package nirmalya.aatithya.restmodule.gatepass.controller;

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
import nirmalya.aatithya.restmodule.gatepass.dao.GatePassOutDao;
import nirmalya.aatithya.restmodule.gatepass.model.GatePassOutModel;


/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "gatepass/")
public class GatePassOutRestController {

	Logger logger = LoggerFactory.getLogger(GatePassOutRestController.class);

	@Autowired
	GatePassOutDao gatePassOutDao;
	
	@RequestMapping(value = "/getCustomerForGateOut", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> restGetCustomerForGateOut(@RequestParam String id) {
		logger.info("Method : restGetCustomerForGateOut starts");
		
		logger.info("Method : restGetCustomerForGateOut ends");
		return gatePassOutDao.getCustomerForGateOutDao(id);
	}
	
	@RequestMapping(value = "/getChallanForGateOut", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> restGetChallanForGateOut(@RequestParam String id) {
		logger.info("Method : restGetChallanForGateOut starts");
		
		logger.info("Method : restGetChallanForGateOut ends");
		return gatePassOutDao.getChallanForGateOutDao(id);
	}
	
	@RequestMapping(value = "/getChallanDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<GatePassOutModel>>> restGetChallanDetails(@RequestParam String id) {
		logger.info("Method : restGetChallanDetails starts");
		
		logger.info("Method : restGetChallanDetails ends");
		return gatePassOutDao.getChallanDetailsDao(id);
	}
	
	@RequestMapping(value = "/getItemCategoryAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> restGetCategoryForGateOut(@RequestParam String id) {
		logger.info("Method : restGetCategoryForGateOut starts");
		
		logger.info("Method : restGetCategoryForGateOut ends");
		return gatePassOutDao.getCategoryForGateOutDao(id);
	}
	
	@RequestMapping(value = "/getItemSubCatAutoSearch", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> restGetSubCatForGateOut(@RequestBody DropDownModel id) {
		logger.info("Method : restGetSubCatForGateOut starts");

		logger.info("Method : restGetSubCatForGateOut ends");
		return gatePassOutDao.getSubCatForGateOutDao(id);
	}
	
	@RequestMapping(value = "/getItemAutoSearch", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> restGetItemForGateOut(@RequestBody DropDownModel id) {
		logger.info("Method : restGetItemForGateOut starts");
		
		logger.info("Method : restGetItemForGateOut ends");
		return gatePassOutDao.getItemForGateOutDao(id);
	}
	
	@RequestMapping(value="newGatePassOut" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> restNewGatePassOut(@RequestBody  List<GatePassOutModel> gatePass) {
		logger.info("Method : restNewGatePassOut for rest controller starts");
		
		logger.info("Method : restNewGatePassOut for rest controller ends");
		return gatePassOutDao.newGatePassOutDao(gatePass);
	}
	
	@RequestMapping(value = "/getGatePassOutDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<GatePassOutModel>>> restGetGatePassOutDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : restGetGatePassOutDetails starts");

		logger.info("Method : restGetGatePassOutDetails ends");
		return gatePassOutDao.getGatePassOutDetailsDao(request);
	}
	
	@RequestMapping(value = "/editGatePassOut", method = { RequestMethod.GET })
	public List<GatePassOutModel> restEditGatePassOut(@RequestParam("id")String id) {
		logger.info("Method : restEditGatePassOut for rest controller starts");
		
		logger.info("Method : restEditGatePassOut for rest controller ends");
		return gatePassOutDao.editGatePassOutDao(id);
	}
	
	@RequestMapping(value = "/modalGatePassOut", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<GatePassOutModel>>> restModalGatePassOut(@RequestParam("id")String id) {
		logger.info("Method : restModalGatePassOut starts");

		logger.info("Method : restModalGatePassOut ends");
		return gatePassOutDao.modalGatePassOutDao(id);
	}
}
