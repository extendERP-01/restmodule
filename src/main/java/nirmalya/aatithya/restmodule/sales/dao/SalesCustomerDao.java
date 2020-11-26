/**
 * 
 */
package nirmalya.aatithya.restmodule.sales.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateSalesCustomerParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.ServerValidation;
import nirmalya.aatithya.restmodule.sales.model.RestSalesCustomerModel;

/**
 * @author NirmalyaLabs
 *
 */

@Repository
public class SalesCustomerDao {
	Logger logger=LoggerFactory.getLogger(SalesCustomerDao.class);
	@Autowired
	private EntityManager entityManager;
	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to Add/edit Customer
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addCustomer(RestSalesCustomerModel salesCustomerModel) {
		logger.info("Method : addCustomer Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (salesCustomerModel.getCustomerName() == null || salesCustomerModel.getCustomerName() == "") {
			resp.setMessage("Customer Name required");
			validity = false;
		}else if(salesCustomerModel.getCustomerName().length()>200) {
			resp.setMessage("Customer Name should not be greater than 200 characters.");
			validity = false;
		} else if (salesCustomerModel.getCustomerEmail() == null || salesCustomerModel.getCustomerEmail() == "") {
			resp.setMessage("Customer Email required");
			validity = false;
		} else if (salesCustomerModel.getCustomerPhone() == null || salesCustomerModel.getCustomerPhone() == "") {
				resp.setMessage("Customer Phone required");
				validity = false;
		/*}else if (salesCustomerModel.getCustomerAddress() == null || salesCustomerModel.getCustomerAddress() == "") {
			resp.setMessage("Customer Address required");
			validity = false;
		}else if (salesCustomerModel.getCustomerCity() == null || salesCustomerModel.getCustomerCity() == "") {
			resp.setMessage("Customer City required");
			validity = false;*/
		}else if (salesCustomerModel.getCustomerDistrict() == null || salesCustomerModel.getCustomerDistrict() == "") {
			resp.setMessage("Customer District required");
			validity = false;
		}else if (salesCustomerModel.getCustomerState() == null || salesCustomerModel.getCustomerState() == "") {
			resp.setMessage("Customer State required");
			validity = false;
		}else if (salesCustomerModel.getCustomerCountry() == null || salesCustomerModel.getCustomerCountry() == "") {
			resp.setMessage("Customer Country required");
			validity = false;
		}else if (salesCustomerModel.getCustomerZipCode() == null || salesCustomerModel.getCustomerZipCode() == "") {
			resp.setMessage("Customer Zip Code required");
			validity = false;
		/*}else if (salesCustomerModel.getCustomerGSTNo() == null || salesCustomerModel.getCustomerGSTNo() == "") {
			resp.setMessage("Customer GST No required");
			validity = false;*/
		}else if (salesCustomerModel.getCustomerContactPerson() == null || salesCustomerModel.getCustomerContactPerson() == "") {
			resp.setMessage("Customer Contact Person required");
			validity = false;
		} else if (salesCustomerModel.getCustomerActive() == null) { 
			resp.setMessage("Status required");
			validity = false;
		}
		
		if (validity)
			try {
				String values = GenerateSalesCustomerParameter.addCustomerParam(salesCustomerModel);
//				System.out.println(values);
				if (salesCustomerModel.getCustomerId() != null && salesCustomerModel.getCustomerId() != "") {
					entityManager.createNamedStoredProcedureQuery("salesCustomerRoutines")
							.setParameter("actionType", "modifyCustomer")
							.setParameter("actionValue", values)
							.execute();
				} else {
					entityManager.createNamedStoredProcedureQuery("salesCustomerRoutines")
							.setParameter("actionType", "addNewCustomer")
							.setParameter("actionValue", values)
							.execute();
				}

			}catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
			

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addCustomer Dao ends");
		return response;
	}
	
	/**
	 * DAO Function to view Country in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAllCountry() {
		logger.info("Method : getAllCountry Dao starts");
		List<DropDownModel> countryList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("salesCustomerRoutines")
					.setParameter("actionType", "getCountryList")
					.setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAllCountry Dao ends");
		return countryList;
	}
	
	
	/**
	 * 
	 * 
	 * DAO Function to view State In dropDown
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAllStates(String id) {
		logger.info("Method : getAllStates Dao starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_CountryId='"+ id +"';";
//		System.out.println(value);
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("salesCustomerRoutines")
					.setParameter("actionType", "getState").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllStates Dao ends");
		return response;
	}
	
	/**
	 * 
	 * 
	 * DAO Function to view District In dropDown
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAllDistricts(String id) {
		logger.info("Method : getAllDistricts Dao starts");
		List<DropDownModel> districtList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_StateId='"+ id +"';";
//		System.out.println(value);
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("salesCustomerRoutines")
					.setParameter("actionType", "getDistrict").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				districtList.add(dropDownModel);
			}

			resp.setBody(districtList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllDistricts Dao ends");
		return response;
	}

	/**
	 * DAO Function to View all Customer in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSalesCustomerModel>>> getAllCustomerList(DataTableRequest request) {
		logger.info("Method : getAllCustomerList Dao starts");
		
		if (request.getParam4() != "" && request.getParam4() != null) {
			String param4 = request.getParam4();
			String data = DateFormatter.getStringDate(param4);
			request.setParam4(data);
		}

		if (request.getParam5() != "" && request.getParam5() != null) {
			String param5 = request.getParam5();
			String data2 = DateFormatter.getStringDate(param5);
			request.setParam5(data2);
		}
		
		List<RestSalesCustomerModel> salesCustomerModel = new ArrayList<RestSalesCustomerModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("salesCustomerRoutines")
					.setParameter("actionType", "viewAllCustomer").setParameter("actionValue", values)
					.getResultList();
			
			if(!x.isEmpty()) {
				for (Object[] m : x) {
					RestSalesCustomerModel SalesCust = new RestSalesCustomerModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], null, null, null, null, null);
					salesCustomerModel.add(SalesCust);
				}
			
				if (x.get(0).length > 13) {
					BigInteger t = (BigInteger) x.get(0)[13];
	
					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestSalesCustomerModel>> resp = new JsonResponse<List<RestSalesCustomerModel>>();
		resp.setBody(salesCustomerModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestSalesCustomerModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesCustomerModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllCustomerList Dao ends");
		
		return response;
	}
	
	
	/**
	 * DAO Function to get Customer for ModalView
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestSalesCustomerModel>> ViewModal(String id) {
		logger.info("Method : ViewModal Dao starts");
		List<RestSalesCustomerModel> form = new ArrayList<RestSalesCustomerModel>();
		try {
			String value = "SET @p_customer='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("salesCustomerRoutines")
					.setParameter("actionType", "viewModal").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestSalesCustomerModel restSalesCustomerModel = new RestSalesCustomerModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], null, null, m[13], m[14], m[15]);
				form.add(restSalesCustomerModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<RestSalesCustomerModel> resp = new JsonResponse<RestSalesCustomerModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestSalesCustomerModel>> response = new ResponseEntity<JsonResponse<RestSalesCustomerModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : ViewModal Dao ends");
//		System.out.println("Response :"+response);
		return response;
	}
	
	/**
	 * DAO Function to Editing Customer
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestSalesCustomerModel>> EditCustomer(String id) {
		logger.info("Method : EditCustomer Dao starts");
		List<RestSalesCustomerModel> form = new ArrayList<RestSalesCustomerModel>();
		try {
			String value = "SET @p_customer='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("salesCustomerRoutines")
					.setParameter("actionType", "EditCustomer").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestSalesCustomerModel restSalesCustomerModel = new RestSalesCustomerModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], null, null, m[13], m[14], m[15]);
				form.add(restSalesCustomerModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<RestSalesCustomerModel> resp = new JsonResponse<RestSalesCustomerModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestSalesCustomerModel>> response = new ResponseEntity<JsonResponse<RestSalesCustomerModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : EditCustomer Dao ends");
		return response;
	}

	/**
	 * DAO Function to delete customer
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteCustomer(String id,String createdBy) {
		logger.info("Method : deleteCustomer Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_customer='" + id + "',@p_createdBy='"+createdBy+"';";
			entityManager.createNamedStoredProcedureQuery("salesCustomerRoutines")
					.setParameter("actionType", "deleteCustomer").setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
			String[] err = ServerValidation.geterror(e);
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method : deleteCustomer Dao ends");
//		System.out.println("Response :"+ response);
		return response;
	}
	
	/*
	 *
	 * 
	 * state list for edit
	 * 
	 * 
	 */

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getState(String id) {
		logger.info("Method : getState starts");
		List<DropDownModel> getState = new ArrayList<DropDownModel>();
		String value = "SET @p_CountryId='" + id + "';";
//		System.out.println("Value :"+value);
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("salesCustomerRoutines")
					.setParameter("actionType", "getState")
					.setParameter("actionValue", value)
					.getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getState.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getState ends");
//		System.out.println("StateList: "+getState);
		return getState;
	}
	
	/*
	 *
	 * 
	 * District list for edit
	 * 
	 * 
	 */

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDistrict(String id) {
		logger.info("Method : getDistrict starts");
		List<DropDownModel> getDistrict = new ArrayList<DropDownModel>();
		String value = "SET @p_StateId='" + id + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("salesCustomerRoutines")
					.setParameter("actionType", "getDistrict")
					.setParameter("actionValue", value)
					.getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getDistrict.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDistrict ends");
		System.out.println("DistrictList: "+ getDistrict);
		return getDistrict;
	}


	/**
	 * DAO Function to view DropDown of State for Search Param2
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSearchParamState() {
		logger.info("Method : getSearchParamState Dao starts");
		List<DropDownModel> searchStateNameList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("salesCustomerRoutines")
					.setParameter("actionType", "getStateParamList").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				searchStateNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getSearchParamState Dao ends");
		return searchStateNameList;
	}
	
	/**
	 * DAO Function to view DropDown of District for Search Param3
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSearchParamDistrict() {
		logger.info("Method : getSearchParamDistrict Dao starts");
		List<DropDownModel> searchNameList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("salesCustomerRoutines")
					.setParameter("actionType", "getDistrictParamList").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				searchNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getSearchParamDistrict Dao ends");
		return searchNameList;
	}

	/**
	 * DAO Function to get All Customer in sales Pdf
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSalesCustomerModel>>> getAllCustomersPdf(DataTableRequest request) {
		logger.info("Method : getAllCustomersPdf starts");
		
		List<RestSalesCustomerModel> restCustomerModel = new ArrayList<RestSalesCustomerModel>();
		Integer total = 0;
		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("salesCustomerRoutines")
					.setParameter("actionType", "viewAllCustomersPdf").setParameter("actionValue", "").getResultList();
			if(!x.isEmpty()) {
				for (Object[] m : x) {
					RestSalesCustomerModel customer = new RestSalesCustomerModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], null, null, null, null, null);
					restCustomerModel.add(customer);
				}
	
				if (x.get(0).length > 13) {
					BigInteger t = (BigInteger) x.get(0)[13];
	
					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestSalesCustomerModel>> resp = new JsonResponse<List<RestSalesCustomerModel>>();
		resp.setBody(restCustomerModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestSalesCustomerModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesCustomerModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllCustomersPdf ends");
		return response;
	}
	
	/*
	 * 
	 * Method for auto complete 
	 * 
	 * 
	 */
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> generateCustomerNameListByAutoSearch(String id) {
		logger.info("Method : generateCustomerNameListByAutoSearch Dao starts");
	
		List<DropDownModel> customerNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
	
		try {
			
			String value = "SET @p_customerName='" + id + "';";
//			System.out.println("Value :"+value);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("salesCustomerRoutines")
			.setParameter("actionType", "getCustomerNamePdf")
			.setParameter("actionValue", value)
			.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				customerNameList.add(dropDownModel);
			}
			resp.setBody(customerNameList);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
		resp, HttpStatus.CREATED);
	
		logger.info("Method : generateCustomerNameListByAutoSearch Dao ends");
		return response;
	}

	/**
	 * DAO Function to get All Customer in sales Pdf
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSalesCustomerModel>>> getCustomersPdf(DataTableRequest request) {
		logger.info("Method : getCustomersPdf starts");
		
		if (request.getParam4() != "") {
			String param4 = request.getParam4();
			String data = DateFormatter.getStringDate(param4);
			request.setParam4(data);
		}

		if (request.getParam5() != "") {
			String param5 = request.getParam5();
			String data2 = DateFormatter.getStringDate(param5);
			request.setParam5(data2);
		}
		
		List<RestSalesCustomerModel> restCustomerModel = new ArrayList<RestSalesCustomerModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
//		System.out.println("VALUES :"+values);
		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("salesCustomerRoutines")
					.setParameter("actionType", "viewAllCustomersPdf")
					.setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {
				RestSalesCustomerModel customer = new RestSalesCustomerModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], null, null, null, null, null);
				restCustomerModel.add(customer);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestSalesCustomerModel>> resp = new JsonResponse<List<RestSalesCustomerModel>>();
		resp.setBody(restCustomerModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestSalesCustomerModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesCustomerModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getCustomersPdf ends");
		return response;
	}
	
	/**
	 * 
	 * 
	 * DAO Function to view District In dropDown
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDistricts(String id) {
		logger.info("Method : getDistricts Dao starts");
		List<DropDownModel> districtList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_StateId='"+ id +"';";
//		System.out.println(value);
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("salesCustomerRoutines")
					.setParameter("actionType", "getDistrict").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				districtList.add(dropDownModel);
			}

			resp.setBody(districtList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getDistricts Dao ends");
		return response;
	}


}