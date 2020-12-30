/**
 * Defines inventory vendor DAO
 */
package nirmalya.aatithya.restmodule.inventory.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateInventoryVendorParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryVendorModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class InventoryVendorDao {
	Logger logger = LoggerFactory.getLogger(InventoryVendorDao.class);
	@Autowired
	private EntityManager entityManager;
	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to view particular itemCategory in dropDown for vendor
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCategoryName() {
		logger.info("Method : getCategoryName starts");
		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryVendorRoutines")
					.setParameter("actionType", "getItemCategory").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getCategoryName ends");
		return itemList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCountryForVendor() {
		logger.info("Method : getCountryForVendor starts");
		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryVendorRoutines")
					.setParameter("actionType", "getCountry").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getCountryForVendor ends");
		return itemList;
	}

	/**
	 * DAO Function to view particular itemCategory in dropDown for vendor
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCategoryNameById(String Id) {
		logger.info("Method : getCategoryName by id starts");
		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_vendor='" + Id + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryVendorRoutines")
					.setParameter("actionType", "getItemCategoryById").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemList.add(dropDownModel);
			}
			System.out.println(itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getCategoryName by id ends");
		return itemList;
	}

	/**
	 * DAO Function to Add/edit Vendor in inventory
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addVendor(RestInventoryVendorModel restVendorModel) {
		logger.info("Method : addVendor starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (restVendorModel.getItemCategory().length <= 0) {
			resp.setMessage("item Category required");
			validity = false;
		} /*
			 * else if (restVendorModel.getVendorName() == null ||
			 * restVendorModel.getVendorName() == "") {
			 * resp.setMessage("vendorName required"); validity = false; }
			 */else if (restVendorModel.getVendorAddress() == null || restVendorModel.getVendorAddress() == "") {
			resp.setMessage("vendorAddress required");
			validity = false;
		} /*
			 * else if (restVendorModel.getVendorActive() == null) {
			 * resp.setMessage("status required"); validity = false; }
			 */
		if (validity)
			try {
				String values = GenerateInventoryVendorParameter.addVendorParam(restVendorModel);

				if (restVendorModel.getVendor() != null && restVendorModel.getVendor() != "") {
					entityManager.createNamedStoredProcedureQuery("inventoryVendorRoutines")
							.setParameter("actionType", "modifyVendors").setParameter("actionValue", values).execute();
				} else {
					entityManager.createNamedStoredProcedureQuery("inventoryVendorRoutines")
							.setParameter("actionType", "addNewVendors").setParameter("actionValue", values).execute();
				}

			} catch (Exception e) {
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
		logger.info("Method : addVendor ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> uploadVendorContract(RestInventoryVendorModel restVendorModel) {
		logger.info("Method : uploadVendorContract starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String values = GenerateInventoryVendorParameter.uploadVendorContract(restVendorModel);

			entityManager.createNamedStoredProcedureQuery("inventoryVendorRoutines")
					.setParameter("actionType", "uploadContract").setParameter("actionValue", values).execute();

		} catch (Exception e) {
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
		
		logger.info("Method : uploadVendorContract ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> blacklistVendor(RestInventoryVendorModel restVendorModel) {
		logger.info("Method : blacklistVendor starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		
		try {
			String values = GenerateInventoryVendorParameter.blacklistVendor(restVendorModel);
			
			entityManager.createNamedStoredProcedureQuery("inventoryVendorRoutines")
			.setParameter("actionType", "blacklistVendor").setParameter("actionValue", values).execute();
			
		} catch (Exception e) {
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
		
		logger.info("Method : blacklistVendor ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> submitVendorRate(RestInventoryVendorModel restVendorModel) {
		logger.info("Method : submitVendorRate starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		
		try {
			String values = GenerateInventoryVendorParameter.submitVendorRate(restVendorModel);
			
			entityManager.createNamedStoredProcedureQuery("inventoryVendorRoutines")
			.setParameter("actionType", "submitVendorRate").setParameter("actionValue", values).execute();
			
		} catch (Exception e) {
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
		
		logger.info("Method : submitVendorRate ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateForVendor(String id) {
		logger.info("Method : getStateForVendor starts");

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		String value = "SET @p_Country='" + id + "';";
		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryVendorRoutines")
					.setParameter("actionType", "getState").setParameter("actionValue", value).getResultList();

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
		logger.info("Method : getStateForVendor starts");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> editStateForVendor(String id) {
		logger.info("Method : editStateForVendor starts");

		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		String value = "SET @p_Country='" + id + "';";
		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryVendorRoutines")
					.setParameter("actionType", "getState").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("stateList====" + stateList);
		logger.info("Method : editStateForVendor starts");
		return stateList;
	}

	/**
	 * DAO Function to get All Vendor in inventory
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryVendorModel>>> getAllVendors(DataTableRequest request) {
		logger.info("Method : getAllVendors starts");
		List<RestInventoryVendorModel> restVendorModel = new ArrayList<RestInventoryVendorModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryVendorRoutines")
					.setParameter("actionType", "viewAllVendors").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				if (m[12] == null) {
					m[12] = true;
				}
				Object fromDate = null;
				if (m[15] != null) {
					fromDate = DateFormatter.returnStringDate(m[15]);
				} else {
					fromDate = "--";
				}
				Object toDate = null;
				if (m[16] != null) {
					toDate = DateFormatter.returnStringDate(m[16]);
				} else {
					toDate = "--";
				}
				RestInventoryVendorModel itmCat = new RestInventoryVendorModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], m[11], m[12], null, null, null, null, null, null, null, null, null,
						null, null, null, m[13], m[14], fromDate, toDate);
				restVendorModel.add(itmCat);
			}

			if (x.get(0).length > 17) {
				BigInteger t = (BigInteger) x.get(0)[17];
				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestInventoryVendorModel>> resp = new JsonResponse<List<RestInventoryVendorModel>>();
		resp.setBody(restVendorModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestInventoryVendorModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryVendorModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAllVendors ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryVendorModel>>> getAllBlacklistedVendors(DataTableRequest request) {
		logger.info("Method : getAllBlacklistedVendors starts");
		
		List<RestInventoryVendorModel> restVendorModel = new ArrayList<RestInventoryVendorModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		
		try {
			
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryVendorRoutines")
					.setParameter("actionType", "viewAllBLVendors").setParameter("actionValue", values).getResultList();
			
			for (Object[] m : x) {
				if (m[12] == null) {
					m[12] = true;
				}
				Object fromDate = null;
				if (m[15] != null) {
					fromDate = DateFormatter.returnStringDate(m[15]);
				} else {
					fromDate = "--";
				}
				Object toDate = null;
				if (m[16] != null) {
					toDate = DateFormatter.returnStringDate(m[16]);
				} else {
					toDate = "--";
				}
				RestInventoryVendorModel itmCat = new RestInventoryVendorModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], m[11], m[12], m[17], null, null, null, null, null, null, null, null,
						null, null, null, m[13], m[14], fromDate, toDate);
				restVendorModel.add(itmCat);
			}
			if(x.size()>0) {
				if (x.get(0).length > 18) {
					BigInteger t = (BigInteger) x.get(0)[18];
					total = Integer.parseInt((t.toString()));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonResponse<List<RestInventoryVendorModel>> resp = new JsonResponse<List<RestInventoryVendorModel>>();
		resp.setBody(restVendorModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestInventoryVendorModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryVendorModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getAllBlacklistedVendors ends");
		return response;
	}

	/**
	 * DAO Function to delete Vendor of inventory
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteVendor(String id, String createdBy) {
		logger.info("Method : deleteVendor starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_vendor='" + id + "',@p_createdBy='" + createdBy + "';";
			entityManager.createNamedStoredProcedureQuery("inventoryVendorRoutines")
					.setParameter("actionType", "deleteVendor").setParameter("actionValue", value).execute();

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method : deleteVendor ends");
		return response;
	}

	/**
	 * DAO Function to edit Vendor
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestInventoryVendorModel>> getVendorById(String id) {
		logger.info("Method : getVendorById starts");
		List<RestInventoryVendorModel> form = new ArrayList<RestInventoryVendorModel>();
		try {
			String value = "SET @p_vendor='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryVendorRoutines")
					.setParameter("actionType", "viewOneVendor").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestInventoryVendorModel restVendorModel = new RestInventoryVendorModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], null, m[14], m[15], m[16], m[17],
						m[18], m[19], m[20], m[21], m[22], m[23], m[24], null, null, null);
				form.add(restVendorModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<RestInventoryVendorModel> resp = new JsonResponse<RestInventoryVendorModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestInventoryVendorModel>> response = new ResponseEntity<JsonResponse<RestInventoryVendorModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getVendorById ends");
		return response;
	}

	/**
	 * DAO Function to view Vendor in Model
	 *
	 */
	public ResponseEntity<JsonResponse<RestInventoryVendorModel>> getVendorForModel(String id) {
		logger.info("Method : getVendorForModel starts");
		List<RestInventoryVendorModel> form = new ArrayList<RestInventoryVendorModel>();
		JsonResponse<RestInventoryVendorModel> resp = new JsonResponse<RestInventoryVendorModel>();
		try {
			String value = "SET @p_vendor='" + id + "';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryVendorRoutines")
					.setParameter("actionType", "viewVendorForModel").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object fromDate = null;
				Object toDate = null;
				
				if(m[26]!=null) {
					fromDate = DateFormatter.returnStringDate(m[26]);
				}
				if(m[27]!=null) {
					toDate = DateFormatter.returnStringDate(m[27]);
				}
				
				RestInventoryVendorModel restVendorModel = new RestInventoryVendorModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], null, m[14], m[15], m[16], m[17],
						m[18], m[19], m[20], m[21], m[22], m[23], m[24], m[25], fromDate, toDate);
				form.add(restVendorModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestInventoryVendorModel>> response = new ResponseEntity<JsonResponse<RestInventoryVendorModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getVendorForModel ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorListByAutoSearch(String id) {
		logger.info("Method : getVendorListByAutoSearch Dao starts");

		List<DropDownModel> vendor = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_searchValue='" + id + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryVendorRoutines")
					.setParameter("actionType", "getVendorList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				vendor.add(dropDownModel);
			}

			resp.setBody(vendor);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getVendorListByAutoSearch Dao ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> blacklisttVendorAutoSearch(String id) {
		logger.info("Method : blacklisttVendorAutoSearch Dao starts");
		
		List<DropDownModel> vendor = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		
		try {
			String value = "SET @p_searchValue='" + id + "';";
			
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryVendorRoutines")
					.setParameter("actionType", "getBLVendorList").setParameter("actionValue", value).getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				vendor.add(dropDownModel);
			}
			
			resp.setBody(vendor);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : blacklisttVendorAutoSearch Dao ends");
		return response;
	}
}
