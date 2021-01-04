package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.GlobalRestDao;
import nirmalya.aatithya.restmodule.master.model.GlobalMasterRestModel;
import nirmalya.aatithya.restmodule.master.model.LocationMasterModel;

@RestController
@RequestMapping(value = "master")
public class GlobalMasterRestController {

	Logger logger = LoggerFactory.getLogger(GlobalMasterRestController.class);

	@Autowired
	GlobalRestDao globalrestdao;
	@Autowired
	EntityManager em;

	/*
	 * @RequestMapping(value = "getGlobalList", method = { RequestMethod.GET })
	 * public List<GlobalMasterRestModel> getGlobalList() {
	 * logger.info("Method : getGlobalList starts");
	 * 
	 * logger.info("Method : getGlobalList ends"); return
	 * globalrestdao.getGlobalList(); }
	 */
	@RequestMapping(value = "viewGlobalMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> viewGlobalMaster() {
		logger.info("Method : viewGlobalMaster starts");

		logger.info("Method : viewGlobalMaster ends");
		return globalrestdao.viewGlobalMaster();
	}

	@RequestMapping(value = "addGlobalMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addGlobalMaster(@RequestBody GlobalMasterRestModel globalMasterRestModel) {
		logger.info("Method : addGlobalMaster starts");
System.out.println(globalMasterRestModel);
		logger.info("Method : addGlobalMaster ends");
		return globalrestdao.addGlobalMaster(globalMasterRestModel);
	}

	/*
	 * @RequestMapping(value = "rest-add-country-type", method = {
	 * RequestMethod.POST }) public ResponseEntity<JsonResponse<Object>>
	 * getCountryDetails(
	 * 
	 * @RequestBody GlobalMasterRestModel globalMasterRestModel) {
	 * logger.info("Method : getCountryDetails starts");
	 * logger.info("Method : getCountryDetails endss"); return
	 * globalrestdao.getCountryDetails(globalMasterRestModel); }
	 */
	/*
	 * @RequestMapping(value = "/viewCountry", method = { RequestMethod.GET })
	 * ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> getCountryview() {
	 * logger.info("Method : viewCountry start");
	 * 
	 * logger.info("Method : viewCountry ends");
	 * 
	 * return globalrestdao.viewCountry(); }
	 */

}
