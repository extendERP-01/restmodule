/*
 * package nirmalya.aatithya.restmodule.property.controller;
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
 * nirmalya.aatithya.restmodule.property.dao.AmenityDao; import
 * nirmalya.aatithya.restmodule.property.model.AmenityForm;
 * 
 *//**
	 * @author Nirmalya Labs
	 *
	 */
/*
 * 
 * @RestController
 * 
 * @RequestMapping("property/") public class AmenityRestController {
 * 
 *//**
	 * returns all properties
	 *
	 *//*
		 * 
		 * Logger logger = LoggerFactory.getLogger(AmenityRestController.class);
		 * 
		 * @Autowired AmenityDao amenityDao;
		 * 
		 * @RequestMapping(value = "getPropertyName03", method = { RequestMethod.GET })
		 * public List<DropDownModel> getModulename() {
		 * 
		 * logger.info("Method : getModulename starts");
		 * 
		 * logger.info("Method : getModulename ends"); return
		 * amenityDao.getPropertyName(); }
		 * 
		 * @RequestMapping(value = "/restAddAmenity01", method = { RequestMethod.POST })
		 * public ResponseEntity<JsonResponse<Object>> restAddUser(@RequestBody
		 * AmenityForm addAmenity) {
		 * 
		 * logger.info("Method : restAddUser starts");
		 * 
		 * logger.info("Method : restAddUser ends");
		 * 
		 * // System.out.println("add user : " + addAmenity); return
		 * amenityDao.addAmenity(addAmenity); }
		 * 
		 * @RequestMapping(value = "/getAllAmenities", method = { RequestMethod.POST })
		 * public ResponseEntity<JsonResponse<List<AmenityForm>>>
		 * getAllAmenity(@RequestBody DataTableRequest request) {
		 * 
		 * logger.info("Method : getAllAmenity starts");
		 * 
		 * logger.info("Method : getAllAmenity ends");
		 * 
		 * return amenityDao.getAllAmenityList(request); }
		 * 
		 * @RequestMapping(value = "/getAmenityById01", method = { RequestMethod.GET })
		 * public ResponseEntity<JsonResponse<AmenityForm>>
		 * getActivityById(@RequestParam String id) {
		 * 
		 * logger.info("Method : getActivityById starts");
		 * 
		 * logger.info("Method : getActivityById ends");
		 * 
		 * return amenityDao.getAmenitytById(id); }
		 * 
		 * @RequestMapping(value = "/deleteAmenityById", method = { RequestMethod.GET })
		 * public ResponseEntity<JsonResponse<Object>>
		 * deleteActivityManagementById(@RequestParam String id) {
		 * 
		 * logger.info("Method : deleteActivityManagementById starts");
		 * 
		 * logger.info("Method : deleteActivityManagementById ends");
		 * 
		 * return amenityDao.deleteAmenityById(id); } }
		 */