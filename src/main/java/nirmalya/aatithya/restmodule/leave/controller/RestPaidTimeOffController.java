package nirmalya.aatithya.restmodule.leave.controller;
/*
*//** Defines District master Rest Controller */
/*
 * package nirmalya.aatithya.restmodule.hrms.controller;
 * 
 * import java.util.List;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import nirmalya.aatithya.restmodule.common.utils.DataTableRequest; import
 * nirmalya.aatithya.restmodule.common.utils.DropDownModel; import
 * nirmalya.aatithya.restmodule.common.utils.JsonResponse; import
 * nirmalya.aatithya.restmodule.hrms.dao.RestLeaveRuleDao; import
 * nirmalya.aatithya.restmodule.hrms.model.RestLeaveRuleModel;
 *//**
	 * @author Nirmalya Labs
	 *
	 *//*
		 * @RestController
		 * 
		 * @RequestMapping(value = "hrms") public class RestPaidTimeOffController {
		 * 
		 * Logger logger = LoggerFactory.getLogger(RestPaidTimeOffController.class);
		 * 
		 * @Autowired RestLeaveRuleDao leaveRuleDao;
		 * 
		 * 
		 * 
		 * Post Mapping to Add restAddPaidTimeOff
		 *
		 * 
		 * @RequestMapping(value = "restAddPaidTimeOff", method = { RequestMethod.POST
		 * }) public ResponseEntity<JsonResponse<Object>> restAddLeaveRule(@RequestBody
		 * RestLeaveRuleModel table) { logger.info("Method : restAddLeaveRule starts");
		 * 
		 * logger.info("Method : restAddLeaveRule ends");
		 * System.out.println("restAddLeaveRule data : "+table); return
		 * leaveRuleDao.restAddLeaveRule(table); }
		 * 
		 * 
		 * returns getLRuleData
		 *
		 * 
		 * 
		 * 
		 * 
		 * @RequestMapping(value = "getLRuleData", method = { RequestMethod.POST })
		 * public ResponseEntity<JsonResponse<List<RestLeaveRuleModel>>> getLRuleData(
		 * 
		 * @RequestBody DataTableRequest request) {
		 * logger.info("Method : getLRuleData starts"); //
		 * System.out.println("param for search in rest controller-----------"+request.
		 * getParam1()); logger.info("Method : getLRuleData ends"); return
		 * leaveRuleDao.getLRuleData(request); }
		 * 
		 * 
		 * Get getLeaveTypeName
		 *
		 * 
		 * @RequestMapping(value = "getLeaveTypeName", method = { RequestMethod.GET })
		 * public ResponseEntity<JsonResponse<List<DropDownModel>>>
		 * getLeaveTypeName(String getLeaveTypeName) {
		 * logger.info("Method : getLeaveTypeName starts");
		 * 
		 * logger.info("Method : getLeaveTypeName ends"); return
		 * leaveRuleDao.getLeaveTypeName("getLeaveTypeName"); }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * Get getEmpName
		 *
		 * 
		 * @RequestMapping(value = "getEmpName", method = { RequestMethod.GET }) public
		 * ResponseEntity<JsonResponse<List<DropDownModel>>> getEmpName(String
		 * getEmpName) { logger.info("Method : getEmpName starts");
		 * 
		 * logger.info("Method : getEmpName ends"); return
		 * leaveRuleDao.getEmpName("getEmpName"); }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * Get getLeavePeriod
		 *
		 * 
		 * @RequestMapping(value = "getLeavePeriod", method = { RequestMethod.GET })
		 * public ResponseEntity<JsonResponse<List<DropDownModel>>>
		 * getLeavePeriod(String getLeavePeriod) {
		 * logger.info("Method : getLeavePeriod starts");
		 * 
		 * logger.info("Method : getLeavePeriod ends"); return
		 * leaveRuleDao.getLeavePeriod("getLeavePeriod"); }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * returns particular to delete Leave Rule
		 *
		 * 
		 * @RequestMapping(value="deleteLRuleById" , method={RequestMethod.GET}) public
		 * ResponseEntity<JsonResponse<Object>> deleteLRuleById(@RequestParam("id")
		 * String id) { logger.info("Method : deleteLRuleById starts");
		 * 
		 * logger.info("Method : deleteLRuleById ends"); return
		 * leaveRuleDao.deleteLRuleById(id); }
		 * 
		 * 
		 * returns particular leave Rule to view/edit
		 *
		 * 
		 * @RequestMapping(value = "/getLeaveRuleById", method = { RequestMethod.GET })
		 * public ResponseEntity<JsonResponse<RestLeaveRuleModel>>
		 * getLeaveRuleById(@RequestParam("id")String id,@RequestParam("Action") String
		 * action) { logger.info("Method : getLeaveRuleById starts");
		 * //System.out.println("in rest controller for model view id----"+id);
		 * //System.out.println("in rest controller for model view action----"+action);
		 * logger.info("Method : getLeaveRuleById ends"); return
		 * leaveRuleDao.getLeaveRuleById(id,action); }
		 * 
		 * 
		 * 
		 * 
		 * returns particular leave Rule to view Model
		 * 
		 * @RequestMapping(value = "/getLeaveRuleByIdModel", method = {
		 * RequestMethod.GET }) public ResponseEntity<JsonResponse<RestLeaveRuleModel>>
		 * getLeaveRuleByIdModel(@RequestParam("id")String id,@RequestParam("Action")
		 * String action) { logger.info("Method : getLeaveRuleByIdModel starts");
		 * //System.out.println("in rest controller for model view id----"+id);
		 * //System.out.println("in rest controller for model view action----"+action);
		 * logger.info("Method : getLeaveRuleByIdModel ends"); return
		 * leaveRuleDao.getLeaveRuleByIdModel(id,action); }
		 * 
		 * 
		 * 
		 * }
		 */