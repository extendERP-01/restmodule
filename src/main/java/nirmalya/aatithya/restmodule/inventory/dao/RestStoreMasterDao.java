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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;

import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateStoreMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.RestStoreMasterModel;


@Repository
public class RestStoreMasterDao {
	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;

	Logger logger = LoggerFactory.getLogger(RestStoreMasterDao.class);

	/*
	 * DAO Function to view Country Name in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCountryNameList() {
		logger.info("Method : getCountryNameList starts");
		List<DropDownModel> countryList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("storeMasterRoutines")
					.setParameter("actionType", "countryName").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getCountryNameList ends");
		return countryList;
	}

	/*
	 * DAO Function to view particular State name in dropDown
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStoreStateName(String id) {

		logger.info("Method : getStateName starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_tCountry='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("storeMasterRoutines")
					.setParameter("actionType", "getStateName").setParameter("actionValue", value).getResultList();
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
		logger.info("Method : getStateName ends");
		return response;
	}

	/*
	 * DAO Function to view particular District name in dropDown
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStoreDistrictName(String id) {
		logger.info("Method : getStoreDistrictName starts");
		List<DropDownModel> districtList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_tState='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("storeMasterRoutines")
					.setParameter("actionType", "getDstrctName").setParameter("actionValue", value).getResultList();
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
		logger.info("Method : getStoreDistrictName ends");
		return response;
	}

	/*
	 * 
	 * DAO Function to Add/edit New Store
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> restAddNewStore(RestStoreMasterModel storeMaster) {
		logger.info("Method : restAddNewStore starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (storeMaster.gettStoreName() == null || storeMaster.gettStoreName() == "") {
			resp.setMessage("Store Name required");
			validity = false;
		} else if (storeMaster.gettStoreDescription() == null || storeMaster.gettStoreDescription() == "") {
			resp.setMessage("Desc required");
			validity = false;

		} else if (storeMaster.gettAddress() == null || storeMaster.gettAddress() == "") {
			resp.setMessage("Address required");
			validity = false;
		} else if (storeMaster.gettCity() == null || storeMaster.gettCity() == "") {
			resp.setMessage("City required");
			validity = false;
		} else if (storeMaster.gettDistrict() == null || storeMaster.gettDistrict() == "") {
			resp.setMessage("District required");
			validity = false;
		} else if (storeMaster.gettState() == null || storeMaster.gettState() == "") {
			resp.setMessage("State required");
			validity = false;
		} else if (storeMaster.gettCountry() == null || storeMaster.gettCountry() == "") {
			resp.setMessage("Country required");
			validity = false;
		} else if (storeMaster.gettPinCode() == null || storeMaster.gettPinCode() == "") {
			resp.setMessage("Pin Code required");
			validity = false;
		} else if (storeMaster.gettPhoneNo() == null || storeMaster.gettPhoneNo() == "") {
			resp.setMessage("Phone No. required");
			validity = false;
		/*} else if (storeMaster.gettGSTNo() == null || storeMaster.gettGSTNo() == "") {
			resp.setMessage("GSTNo. required");
			validity = false;*/
		} else if (storeMaster.gettEmailId() == null || storeMaster.gettEmailId() == "") {
			resp.setMessage("Email required");
			validity = false;
		/*} else if (storeMaster.gettTinNo() == null || storeMaster.gettTinNo() == "") {
			resp.setMessage("Tin No. required");
			validity = false;*/
		} else if (storeMaster.gettStoreLogo() == null || storeMaster.gettStoreLogo() == "") {
			resp.setMessage("Store Logo required");
			validity = false;
		} else if (storeMaster.gettStoreActive() == null) {
			resp.setMessage("Status required");
			validity = false;
		}
		if (validity) {
			try {
				String values = GenerateStoreMasterParameter.addBannerParam(storeMaster);

				if (storeMaster.gettStore() == null || storeMaster.gettStore() == "") {
					em.createNamedStoredProcedureQuery("storeMasterRoutines").setParameter("actionType", "addNewStore")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("storeMasterRoutines").setParameter("actionType", "modifyStore")
							.setParameter("actionValue", values).execute();
				}
				resp.setCode("Data Saved Successfully");
			} catch (Exception e) {
				e.printStackTrace();
				try {
					String[] err = serverDao.errorProcedureCall(e);

					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : restAddNewStore ends");
		return response;
	}

	/**
	 * DAO Function to View all Store Details
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestStoreMasterModel>>> viewStoreMasterDetails(DataTableRequest request) {

		logger.info("Method : viewStoreMasterDetails starts");
		List<RestStoreMasterModel> form = new ArrayList<RestStoreMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("storeMasterRoutines")
					.setParameter("actionType", "viewAllStore").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
			for (Object[] m : x) {
				RestStoreMasterModel properties = new RestStoreMasterModel(m[0], m[1], m[2], null, m[3], null, null,
						null, null, null, m[4], null, null, null, m[5], null);
				form.add(properties);
			}

			if (x.get(0).length > 6) {
				BigInteger t = (BigInteger) x.get(0)[6];

				total = Integer.parseInt((t.toString()));
			}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		JsonResponse<List<RestStoreMasterModel>> resp = new JsonResponse<List<RestStoreMasterModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<RestStoreMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestStoreMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewStoreMasterDetails ends");
		return response;
	}

	/*
	 * DAO Function to view Store Details in model
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestStoreMasterModel>> viewStoreDetailsModal(String id) {

		logger.info("Method : viewStoreDetailsModal starts");
		List<RestStoreMasterModel> form = new ArrayList<RestStoreMasterModel>();
		try {
			String value = "SET @p_storeId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("storeMasterRoutines")
					.setParameter("actionType", "storeModel").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestStoreMasterModel storeMaster = new RestStoreMasterModel(m[0], m[1], m[2], null, m[3], null, null,
						null, null, null, m[4], null, null, null, null, null);
				form.add(storeMaster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<RestStoreMasterModel> resp = new JsonResponse<RestStoreMasterModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestStoreMasterModel>> response = new ResponseEntity<JsonResponse<RestStoreMasterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : viewStoreDetailsModal ends");

		return response;
	}

	/*
	 * DAO Function to delete particular Store Details
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> deleteStoreDetails(String id) {
		logger.info("Method : deleteStoreDetails starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_storeId='" + id + "';";

			em.createNamedStoredProcedureQuery("storeMasterRoutines").setParameter("actionType", "deleteStore")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);

				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {

				e1.printStackTrace();
			}
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : deleteStoreDetails end");
		return response;
	}

	/*
	 * DAO Function to get State Name List for edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStateNameEditList(String id) {
		logger.info("Method : getStateNameEditList starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();
		String value = "SET @p_tCountry='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("storeMasterRoutines")
					.setParameter("actionType", "getStateName").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getStateNameEditList ends");
		return stateList;
	}

	/*
	 * DAO Function to get District Name List for edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDistNameEditList(String id) {
		logger.info("Method : getDistNameEditList starts");
		List<DropDownModel> districtList = new ArrayList<DropDownModel>();
		String value = "SET @p_tState='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("storeMasterRoutines")
					.setParameter("actionType", "getDistrictName").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				districtList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDistNameEditList ends");
		return districtList;
	}

	/*
	 * DAO Function to view Store Details for edit
	 *
	 */

	@SuppressWarnings("unchecked")

	public ResponseEntity<JsonResponse<RestStoreMasterModel>> editStoreDetails(String id) {

		logger.info("Method : editStoreDetails starts");
		List<RestStoreMasterModel> form = new ArrayList<RestStoreMasterModel>();
		try {
			String value = "SET @p_storeId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("storeMasterRoutines")
					.setParameter("actionType", "editStore").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestStoreMasterModel storeMaster = new RestStoreMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], null);
				form.add(storeMaster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<RestStoreMasterModel> resp = new JsonResponse<RestStoreMasterModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestStoreMasterModel>> response = new ResponseEntity<JsonResponse<RestStoreMasterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : editStoreDetails ends");

		return response;
	}

	/*
	 * DAO Function to view Store Name in dropDown search param
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStoreList() {
		logger.info("Method : getStoreList starts");
		List<DropDownModel> storeList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("storeMasterRoutines")
					.setParameter("actionType", "storeName").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				storeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getStoreList ends");
		return storeList;
	}

		/*
		 * DAO Function to view State Name in dropDown search param
		 *
		 */
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getStateListSearchParam() {
			logger.info("Method : getStateListSearchParam starts");
			List<DropDownModel> storeList = new ArrayList<DropDownModel>();
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("storeMasterRoutines")
						.setParameter("actionType", "stateName").setParameter("actionValue", "").getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					storeList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : getStateListSearchParam ends");
			return storeList;
		}

}
