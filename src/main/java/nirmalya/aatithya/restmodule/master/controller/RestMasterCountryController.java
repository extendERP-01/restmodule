/**
 * 
 */
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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.MasterCountryDao;
import nirmalya.aatithya.restmodule.master.model.RestMasterCountryModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "master/" })
public class RestMasterCountryController {
	Logger logger=LoggerFactory.getLogger(RestMasterCountryController.class);

	@Autowired
	MasterCountryDao masterCountryDao;
	@Autowired
	ServerDao serverDao;
	/*
	 * 
	 * post mapping for add rest MasterCountry
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-addnew-country", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddCountry(@RequestBody RestMasterCountryModel masterCountryModel) {
		logger.info("Method : restAddCountry starts");
		logger.info("Method : restAddCountry endss");
		return masterCountryDao.addCountry(masterCountryModel);
	}
	
	/*
	 * 
	 * post Mapping for listing Country
	 * 
	 * 
	 */
	@RequestMapping(value = "get-all-country", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestMasterCountryModel>>> getAllCountry(@RequestBody DataTableRequest request) {
		logger.info("Method : getAllCountry starts");
		logger.info("Method : getAllCountry ends");
		return masterCountryDao.getAllCountryList(request);
	}
	
	/**
	 * returns particular country to view/edit
	 *
	 */
	@RequestMapping(value = "get-country-byId", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestMasterCountryModel>> getCountryById(@RequestParam String id) {
		logger.info("Method : getCountryById starts");
		logger.info("Method : getCountryById endss");
		return masterCountryDao.getCountryById(id);
	}
		
	/*
	 * 
	 * GetMapping for delete Country
	 * 
	 * 
	 */
	@RequestMapping(value = "delete-country", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteCountry(@RequestParam String id,@RequestParam String createdBy) {
		logger.info("Method : deleteCountry starts");
		logger.info("Method : deleteCountry ends");
		return masterCountryDao.deleteCountry(id,createdBy);
	}

}
