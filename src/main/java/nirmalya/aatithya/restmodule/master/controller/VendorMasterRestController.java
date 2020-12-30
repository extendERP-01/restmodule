package nirmalya.aatithya.restmodule.master.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.VendorMasterDao;
import nirmalya.aatithya.restmodule.master.model.LocationMasterModel;
import nirmalya.aatithya.restmodule.master.model.VendorMasterModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "master")
public class VendorMasterRestController {
	
	Logger logger = LoggerFactory.getLogger(VendorMasterRestController.class);

	@Autowired
	VendorMasterDao vendorMasterDao;
	@RequestMapping(value = "saveVendorMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<VendorMasterModel>> saveVendorMaster(@RequestBody VendorMasterModel vendorMasterModel) {
		logger.info("Method : saveVendorMaster starts");
		
		logger.info("Method : saveVendorMaster ends");
		return vendorMasterDao.saveVendorMaster(vendorMasterModel);
	}

}
