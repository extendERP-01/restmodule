package nirmalya.aatithya.restmodule.master.controller;

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
import nirmalya.aatithya.restmodule.master.dao.RestGodownMasterDao;

import nirmalya.aatithya.restmodule.master.model.RestGodownMasterModel;

/**
 * @author NirmalyaLabs
 *
 */

@RestController
@RequestMapping(value = "master")
public class RestGodownMasterController {
	@Autowired
	RestGodownMasterDao godownDao;

	Logger logger = LoggerFactory.getLogger(RestGodownMasterController.class);

	/*
	 * 
	 * PostMapping for add get country name
	 * 
	 * 
	 */

	@RequestMapping(value = "get-country-name-list", method = { RequestMethod.GET })
	public List<DropDownModel> getCountryList() {
		logger.info("Method : getCountryList starts");
		logger.info("Method : getCountryList ends");
		return godownDao.getCountryList();
	}

	/*
	 * 
	 * Get mapping for get State name
	 * 
	 */
	@RequestMapping(value = "get-state-name-list", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getGodownStateName(@RequestParam String id) {
		logger.info("Method : getGodownStateName starts");
		logger.info("Method : getGodownStateName ends");
		return godownDao.getGodownStateName(id);
	}

	/*
	 * 
	 * Get mapping for get District name
	 * 
	 */
	@RequestMapping(value = "get-district-name-list", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getGodownDistrictName(@RequestParam String id) {
		logger.info("Method : getGodownDistrictName starts");
		logger.info("Method : getGodownDistrictName ends");
		return godownDao.getGodownDistrictName(id);
	}

	/*
	 * Post Mapping to Add new Godown
	 *
	 */
	@RequestMapping(value = "/restAddNewGodown", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddNewGodown(@RequestBody RestGodownMasterModel godownMaster) {
		logger.info("Method : restAddNewGodown starts");
		logger.info("Method : restAddNewGodown endss");
		return godownDao.restAddNewGodown(godownMaster);
	}

	/*
	 * returns all Godown Details
	 *
	 */
	@RequestMapping(value = "/getAllGodownDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestGodownMasterModel>>> viewGodownMasterDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : viewGodownMasterDetails starts");
		logger.info("Method : viewGodownMasterDetails endss");
		return godownDao.viewGodownMasterDetails(request);
	}

	/*
	 * returns particular Godown Details in model
	 *
	 */
	@RequestMapping(value = "/viewGodownDetailsModal", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestGodownMasterModel>> viewGodownDetailsModal(@RequestParam("id") String id) {
		logger.info("Method : viewGodownDetailsModal starts");
		logger.info("Method : viewGodownDetailsModal ends");
		return godownDao.viewGodownDetailsModal(id);
	}

	/*
	 * delete particular Godown Details
	 *
	 */
	@RequestMapping(value = "/deleteGodownDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteGodownDetails(@RequestParam String id) {

		logger.info("Method : deleteGodownDetails starts");

		logger.info("Method : deleteGodownDetails end");

		return godownDao.deleteGodownDetails(id);
	}

	/*
	 * returns particular Godown for edit
	 *
	 */
	@RequestMapping(value = "/editGodownDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestGodownMasterModel>> editGodownDetails(@RequestParam("id") String id) {
		logger.info("Method : editGodownDetails starts");
		logger.info("Method : editGodownDetails ends");
		return godownDao.editGodownDetails(id);
	}

	/*
	 * 
	 * Get mapping for get State Name for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "get-state-name-edit", method = { RequestMethod.GET })
	public List<DropDownModel> getStateNameListEdit(@RequestParam String id) {
		logger.info("Method :  getStateNameListEdit starts");
		logger.info("Method :  getStateNameListEdit endss");
		return godownDao.getStateNameListEdit(id);
	}

	/*
	 * 
	 * Get mapping for get District Name for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-distName-edit", method = { RequestMethod.GET })
	public List<DropDownModel> getDistNameListEdit(@RequestParam String id) {
		logger.info("Method :  getDistNameListEdit starts");
		logger.info("Method :  getDistNameListEdit endss");
		return godownDao.getDistNameListEdit(id);
	}

	/*
	 * 
	 * PostMapping for add get godown name search param
	 * 
	 * 
	 */

	@RequestMapping(value = "get-godown-name", method = { RequestMethod.GET })
	public List<DropDownModel> getGodownList() {
		logger.info("Method : getGodownList starts");
		logger.info("Method : getGodownList ends");
		return godownDao.getGodownList();
	}
	/*
	 * 
	 * PostMapping for add get state  name search param
	 * 
	 * 
	 */

	@RequestMapping(value = "get-state-name-param", method = { RequestMethod.GET })
	public List<DropDownModel> getStateListPram() {
		logger.info("Method : getStateListPram starts");
		logger.info("Method : getStateListPram ends");
		return godownDao.getStateListPram();
	}
}
