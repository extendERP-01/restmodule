/**
 * 
 */
package nirmalya.aatithya.restmodule.sales.controller;

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
import nirmalya.aatithya.restmodule.sales.dao.SalesCustomerDao;
import nirmalya.aatithya.restmodule.sales.model.RestSalesCustomerModel;

/**
 * @author NirmalyaLabs
 *
 */

@RestController
@RequestMapping(value = { "sales/" })
public class RestSalesCustomerController {
	Logger logger=LoggerFactory.getLogger(RestSalesCustomerController.class);

	@Autowired
	SalesCustomerDao salesCustomerDao;
	
	/*
	 * 
	 * post mapping for add rest SalesCustomer
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-addnew-customer", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddCustomer(@RequestBody RestSalesCustomerModel salesCustomerModel) {
		logger.info("Method : restAddCustomer starts");
		logger.info("Method : restAddCustomer ends");
		return salesCustomerDao.addCustomer(salesCustomerModel);
	}
	
	@RequestMapping(value = "saveCustomerDiscount", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveCustomerDiscount(@RequestBody DropDownModel dd) {
		logger.info("Method : saveCustomerDiscount starts");
		logger.info("Method : saveCustomerDiscount ends");
		return salesCustomerDao.saveCustomerDiscount(dd);
	}
	
	
	/*
	 * 
	 * post mapping for getting restCountry List
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-country-list-master", method = { RequestMethod.GET })
	public List<DropDownModel> restgetCountryList() {
		logger.info("Method : restgetCountryList starts");
		logger.info("Method : restgetCountryList ends");
		return salesCustomerDao.getAllCountry();
	}
	
	/*
	 * 
	 * post mapping for getting restState List
	 * 
	 * 
	 */
	@RequestMapping(value = "get-state-list-master", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> restgetStateList(@RequestParam("id") String id) {
		logger.info("Method : restgetStateList starts");
		logger.info("Method : restgetStateList ends");
		return salesCustomerDao.getAllStates(id);
	}
	
	/*
	 * 
	 * post mapping for getting editState List
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-state-list-master", method = { RequestMethod.GET })
	public List<DropDownModel> restgetStateList1(@RequestParam("id") String id) {
		logger.info("Method : restgetStateList1 starts");
		logger.info("Method : restgetStateList1 ends");
		return salesCustomerDao.getState(id);
	}
	/*
	 * 
	 * post mapping for getting restDistrict List
	 * 
	 * 
	 */
	@RequestMapping(value = "get-district-list-master", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> restgetDistrictList(@RequestParam("id") String id) {
		logger.info("Method : restgetDistrictList starts");
		logger.info("Method : restgetDistrictList ends");
		return salesCustomerDao.getAllDistricts(id);
	}
	
	/*
	 * 
	 * post mapping for getting restDistrict List
	 * 
	 * 
	 */
	@RequestMapping(value = "get-district-list", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDistrict(@RequestParam("id") String id) {
		logger.info("Method : getDistrict starts");
		logger.info("Method : getDistrict ends");
		return salesCustomerDao.getDistricts(id);
	}
	/*
	 * 
	 * post mapping for getting editDistrict List
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-district-list-master", method = { RequestMethod.GET })
	public List<DropDownModel> restgetDistrictList1(@RequestParam("id") String id) {
		logger.info("Method : restgetDistrictList1 starts");
		logger.info("Method : restgetDistrictList1 ends");
		return salesCustomerDao.getDistrict(id);
	}
	                                                
	/*
	 * 
	 * post Mapping for listing Customer
	 * 
	 * 
	 */
		@RequestMapping(value = "get-all-customer", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<List<RestSalesCustomerModel>>> getAllCountry(@RequestBody DataTableRequest request) {
			logger.info("Method : getAllCountry starts");
			logger.info("Method : getAllCountry ends");
			return salesCustomerDao.getAllCustomerList(request);
		}
	
	
	/**
	 * returns particular customer to view modal
	 *
	 */
	@RequestMapping(value = "view-modal", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestSalesCustomerModel>> ViewModal(@RequestParam String id) {
		logger.info("Method : ViewModal starts");
		logger.info("Method : ViewModal ends");
		return salesCustomerDao.ViewModal(id);
	}
	
	@RequestMapping(value = "customerDiscountView", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<DropDownModel>> customerDiscountView(@RequestParam String id) {
		logger.info("Method : customerDiscountView starts");
		logger.info("Method : customerDiscountView ends");
		return salesCustomerDao.customerDiscountView(id);
	}
	
	/**
	 * returns particular customer to edit
	 *
	 */
	@RequestMapping(value = "edit-Customer", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestSalesCustomerModel>> getCustomerByIdEdit(@RequestParam String id) {
		logger.info("Method : getCustomerByIdEdit starts");
		logger.info("Method : getCustomerByIdEdit ends");
		return salesCustomerDao.EditCustomer(id);
	}
	
	/*
	 * 
	 * GetMapping for delete Customer
	 * 
	 * 
	 */
	@RequestMapping(value = "delete-customer", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteCustomer(@RequestParam String id,@RequestParam String createdBy) {
		logger.info("Method : deleteCustomer starts");
		logger.info("Method : deleteCustomer ends");
		return salesCustomerDao.deleteCustomer(id,createdBy);
	}
	
	
	/*
	 * 
	 * Get mapping of State for Search Param2
	 * 
	 * 
	 */
	@RequestMapping(value = "param-stateName", method = { RequestMethod.GET })
	public List<DropDownModel> getSearchParamState() {
		logger.info("Method : getSearchParamState starts");
		logger.info("Method : getSearchParamState ends");
		return salesCustomerDao.getSearchParamState();
	}
	
	/*
	 * 
	 * Get mapping of District for Search Param3
	 * 
	 * 
	 */
	@RequestMapping(value = "param-districtName", method = { RequestMethod.GET })
	public List<DropDownModel> getSearchParamDistrict() {
		logger.info("Method : getSearchParamState starts");
		logger.info("Method : getSearchParamState ends");
		return salesCustomerDao.getSearchParamDistrict();
	}
	
	/*
	 * 
	 * PostMapping for get All customers PDF
	 * 
	 * 
	 */
	@RequestMapping(value = "get-all-CustomersPdf", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestSalesCustomerModel>>> getAllCustomersPdf(@RequestBody DataTableRequest request) {
		logger.info("Method : getAllCustomersPdf starts");
		logger.info("Method : getAllCustomersPdf ends");
		return salesCustomerDao.getAllCustomersPdf(request);
	}
	
	/*
	 * 
	 * PostMapping for get customers PDF
	 * 
	 * 
	 */
	@RequestMapping(value = "get-CustomersPdf", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestSalesCustomerModel>>> getCustomersPdf(@RequestBody DataTableRequest request) {
		logger.info("Method : getCustomersPdf starts");
		logger.info("Method : getCustomersPdf ends");
		return salesCustomerDao.getCustomersPdf(request);
	}
	
	/*
	* 
	* method for Auto Complete of generate report of customer Name
	* 
	*/
	@RequestMapping(value = "/generateCustomerNameListByAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> generateCustomerNameListByAutoSearch(@RequestParam String id) {
	logger.info("Method : generateCustomerNameListByAutoSearch starts");
	logger.info("Method : generateCustomerNameListByAutoSearch ends");
	return salesCustomerDao.generateCustomerNameListByAutoSearch(id);
	}

}