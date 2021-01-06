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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.VendorMasterDao;
import nirmalya.aatithya.restmodule.master.model.LocationMasterModel;
import nirmalya.aatithya.restmodule.master.model.VendorLocationMasterModel;
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
	
	@RequestMapping(value = "getCategoryList", method = { RequestMethod.GET })
	public List<DropDownModel> getCategoryList() {
		logger.info("Method : getCategoryList starts");
		
		logger.info("Method : getCategoryList ends");
		return vendorMasterDao.getCategoryList();
	}
	
	@RequestMapping(value = "saveVendorLocationMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<VendorLocationMasterModel>> saveVendorLocationMaster(@RequestBody VendorLocationMasterModel vendorLocationMasterModel) {
		logger.info("Method : saveVendorLocationMaster starts");
		
		logger.info("Method : saveVendorLocationMaster ends");
		return vendorMasterDao.saveVendorLocationMaster(vendorLocationMasterModel);
	}
	
	@RequestMapping(value = "/get-vendor-location-list", method = {RequestMethod.GET})
	ResponseEntity<JsonResponse<List<VendorLocationMasterModel>>> getVendorLocationview(@RequestParam("id") String id)
	{
	logger.info("Method : getVendorLocationview start");


	logger.info("Method : getVendorLocationview ends");

	return vendorMasterDao.getVendorLocationview(id);
	}
	
	@RequestMapping(value = "/get-vendor-list", method = {RequestMethod.GET})
	ResponseEntity<JsonResponse<List<VendorMasterModel>>> getVendorList()
	{
	logger.info("Method : getVendorList start");


	logger.info("Method : getVendorList ends");

	return vendorMasterDao.getVendorList();
	}
	
	@RequestMapping(value = "editVendorLoactionById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<VendorLocationMasterModel>> editVendorLoactionById(@RequestParam String id) {
		logger.info("Method : editVendorLoactionById starts");
		
		logger.info("Method : editVendorLoactionById ends");
		return vendorMasterDao.editVendorLoactionById(id);
	}
	
	
	@RequestMapping(value = "deleteVendorLocation", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteVendorLocation(@RequestParam String id, @RequestParam String createdBy) {
		logger.info("Method : deleteVendorLocation starts");
		
		logger.info("Method : deleteVendorLocation ends");
		return vendorMasterDao.deleteVendorLocation(id,createdBy);
	}
	
}
