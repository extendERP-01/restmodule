package nirmalya.aatithya.restmodule.inventory.controller;

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
import nirmalya.aatithya.restmodule.inventory.dao.MultipleInvoiceDao;
import nirmalya.aatithya.restmodule.inventory.model.GRNListModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "inventory/")
public class MultipleInvoiceRestController {

	Logger logger = LoggerFactory.getLogger(MultipleInvoiceRestController.class);

	@Autowired
	MultipleInvoiceDao multipleInvoiceDao;
	
	@RequestMapping(value = "/getVendorSearchListForGRN", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorSearchListForGRN(@RequestParam String id) {
		logger.info("Method : getVendorSearchListForGRN starts");
		
		logger.info("Method : getVendorSearchListForGRN ends");
		return multipleInvoiceDao.getVendorSearchListForGRN(id);
	}
	
	@RequestMapping(value = "/getPOAutoSearchListForGRN", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPOAutoSearchListForGRN(@RequestParam String id,@RequestParam String value) {
		logger.info("Method : getPOAutoSearchListForGRN starts");
		
		logger.info("Method : getPOAutoSearchListForGRN ends");
		return multipleInvoiceDao.getPOAutoSearchListForGRN(id,value);
	}
	
	@RequestMapping(value = "/getGRNListByVendor", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getGRNListByVendor(@RequestParam String id) {
		logger.info("Method : getGRNListByVendor starts");
		
		logger.info("Method : getGRNListByVendor ends");
		return multipleInvoiceDao.getGRNListByVendor(id);
	}
	
//	@RequestMapping(value="grnReturnData" , method={RequestMethod.POST})
//	public List<GRNListModel> grnReturnData(@RequestBody DropDownModel searchValue) {
//		logger.info("Method : grnReturnData starts");
//		
//		logger.info("Method : grnReturnData ends");
//		return multipleInvoiceDao.grnReturnData(searchValue);
//	}
	
//	@RequestMapping(value="getGRNReturnListDetails" , method={RequestMethod.GET})
//	public List<GRNListModel> getGRNReturnListDetails(@RequestParam String id) {
//		logger.info("Method : getGRNReturnListDetails starts");
//		
//		logger.info("Method : getGRNReturnListDetails ends");
//		return multipleInvoiceDao.getGRNReturnListDetails(id);
//	}
	
	@RequestMapping(value="addMultipleGRN" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addMultipleGRN(@RequestBody GRNListModel grn) {
		logger.info("Method : addMultipleGRN for rest controller starts");
		
		logger.info("Method : addMultipleGRN for rest controller ends");
		return multipleInvoiceDao.addMultipleGRN(grn);
	}
	
	@RequestMapping(value="getGRNListDetails" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<GRNListModel>>> getGRNListDetails(@RequestBody List<DropDownModel> searchValue) {
		logger.info("Method : getGRNListDetails for rest controller starts");
		
		logger.info("Method : getGRNListDetails for rest controller ends");
		return multipleInvoiceDao.getGRNListDetails(searchValue);
	}
	
	@RequestMapping(value="grnReturnData" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<GRNListModel>>> grnReturnData(@RequestBody List<DropDownModel> searchValue) {
		logger.info("Method : grnReturnData for rest controller starts");
		
		logger.info("Method : grnReturnData for rest controller ends");
		return multipleInvoiceDao.grnReturnData(searchValue);
	}
}
