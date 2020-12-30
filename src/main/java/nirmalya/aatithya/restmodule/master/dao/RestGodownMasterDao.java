package nirmalya.aatithya.restmodule.master.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateGodownMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestGodownMasterModel;

@Repository
public class RestGodownMasterDao {
	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;

	Logger logger = LoggerFactory.getLogger(RestGodownMasterDao.class);

	/*
	 * DAO Function to view Country Name in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCountryList() {
		logger.info("Method : getCountryList starts");
		List<DropDownModel> countryList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("godownMasterRoutines")
					.setParameter("actionType", "countryName").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getCountryList ends");
		return countryList;
	}

	/*
	 * DAO Function to view particular State name in dropDown
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getGodownStateName(String id) {

		logger.info("Method : getGodownStateName starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_tCountry='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("godownMasterRoutines")
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
		logger.info("Method : getGodownStateName ends");
		return response;
	}

	/*
	 * DAO Function to view particular District name in dropDown
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getGodownDistrictName(String id) {
		logger.info("Method : getGodownDistrictName starts");
		List<DropDownModel> districtList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_tState='" + id + "';";
		System.out.println("value" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("godownMasterRoutines")
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
		logger.info("Method : getGodownDistrictName ends");
		return response;
	}

	/*
	 * 
	 * DAO Function to Add/edit New Godown
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> restAddNewGodown(RestGodownMasterModel godownMaster) {
		logger.info("Method : addNewChair starts");

		System.out.println("godownMaster" + godownMaster);
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (godownMaster.gettGodownName() == null || godownMaster.gettGodownName() == "") {
			resp.setMessage("Store Name required");
			validity = false;
		} else if (godownMaster.gettGodownDescription() == null || godownMaster.gettGodownDescription() == "") {
			resp.setMessage("Desc required");
			validity = false;

		} else if (godownMaster.gettAddress() == null || godownMaster.gettAddress() == "") {
			resp.setMessage("Address required");
			validity = false;
		} else if (godownMaster.gettCity() == null || godownMaster.gettCity() == "") {
			resp.setMessage("City required");
			validity = false;
		} else if (godownMaster.gettDistrict() == null || godownMaster.gettDistrict() == "") {
			resp.setMessage("District required");
			validity = false;
		} else if (godownMaster.gettState() == null || godownMaster.gettState() == "") {
			resp.setMessage("State required");
			validity = false;
		} else if (godownMaster.gettCountry() == null || godownMaster.gettCountry() == "") {
			resp.setMessage("Country required");
			validity = false;
		} else if (godownMaster.gettPinCode() == null || godownMaster.gettPinCode() == "") {
			resp.setMessage("Pin Code required");
			validity = false;
		} else if (godownMaster.gettPhoneNo() == null || godownMaster.gettPhoneNo() == "") {
			resp.setMessage("Phone No. required");
			validity = false;
	/*	} else if (godownMaster.gettGSTNo() == null || godownMaster.gettGSTNo() == "") {
			resp.setMessage("GSTNo. required");
			validity = false;*/
		} else if (godownMaster.gettEmailId() == null || godownMaster.gettEmailId() == "") {
			resp.setMessage("Email required");
			validity = false;
		/*} else if (godownMaster.gettTinNo() == null || godownMaster.gettTinNo() == "") {
			resp.setMessage("Tin No. required");
			validity = false;*/
		} else if (godownMaster.gettGodownLogo() == null || godownMaster.gettGodownLogo() == "") {
			resp.setMessage("Store Logo required");
			validity = false;
		} else if (godownMaster.gettGodownActive() == null) {
			resp.setMessage("Status required");
			validity = false;
		}
		if (validity) {
			try {
				String values = GenerateGodownMasterParameter.addGodownParam(godownMaster);

				if (godownMaster.gettGodown() == null || godownMaster.gettGodown() == "") {

					em.createNamedStoredProcedureQuery("godownMasterRoutines")
							.setParameter("actionType", "addNewGodown").setParameter("actionValue", values).execute();
				} else {

					em.createNamedStoredProcedureQuery("godownMasterRoutines")
							.setParameter("actionType", "modifyGodown").setParameter("actionValue", values).execute();
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
		logger.info("Method : addNewChair ends");
		return response;
	}

	/**
	 * DAO Function to View all Godown Details
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestGodownMasterModel>>> viewGodownMasterDetails(DataTableRequest request) {
		logger.info("Method : viewGodownMasterDetails starts");
		List<RestGodownMasterModel> form = new ArrayList<RestGodownMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("godownMasterRoutines")
					.setParameter("actionType", "viewAllGodown").setParameter("actionValue", values).getResultList();
			
			for (Object[] m : x) {
				RestGodownMasterModel properties = new RestGodownMasterModel(m[0], m[1], m[2], null, m[3], null, null,
						null, null, null, m[4], null, null, null, m[5], null);
				form.add(properties);
			}
			if (!x.isEmpty()) {
			if (x.get(0).length > 6) {
				BigInteger t = (BigInteger) x.get(0)[6];

				total = Integer.parseInt((t.toString()));
			}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		JsonResponse<List<RestGodownMasterModel>> resp = new JsonResponse<List<RestGodownMasterModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<RestGodownMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestGodownMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewGodownMasterDetails ends");
		return response;
	}

	/*
	 * DAO Function to view Godown Details in model
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestGodownMasterModel>> viewGodownDetailsModal(String id) {

		logger.info("Method : viewGodownDetailsModal starts");
		List<RestGodownMasterModel> form = new ArrayList<RestGodownMasterModel>();
		try {
			String value = "SET @p_godownId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("godownMasterRoutines")
					.setParameter("actionType", "godownModel").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestGodownMasterModel godownMaster = new RestGodownMasterModel(m[0], m[1], m[2], null, m[3], null, null,
						null, null, null, m[4], null, null, null, null, null);
				form.add(godownMaster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<RestGodownMasterModel> resp = new JsonResponse<RestGodownMasterModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestGodownMasterModel>> response = new ResponseEntity<JsonResponse<RestGodownMasterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : viewGodownDetailsModal ends");

		return response;
	}

	/*
	 * DAO Function to delete particular Godown Details
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> deleteGodownDetails(String id) {
		logger.info("Method : deleteGodownDetails starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_godownId='" + id + "';";

			em.createNamedStoredProcedureQuery("godownMasterRoutines").setParameter("actionType", "deleteGodown")
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

		logger.info("Method : deleteGodownDetails end");
		return response;
	}

	/*
	 * DAO Function to view Godown Details for edit
	 *
	 */

	@SuppressWarnings("unchecked")

	public ResponseEntity<JsonResponse<RestGodownMasterModel>> editGodownDetails(String id) {

		logger.info("Method : editGodownDetails starts");
		List<RestGodownMasterModel> form = new ArrayList<RestGodownMasterModel>();
		try {
			String value = "SET @p_godownId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("godownMasterRoutines")
					.setParameter("actionType", "editGodown").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestGodownMasterModel godownMaster = new RestGodownMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], null);
				form.add(godownMaster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<RestGodownMasterModel> resp = new JsonResponse<RestGodownMasterModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestGodownMasterModel>> response = new ResponseEntity<JsonResponse<RestGodownMasterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : editGodownDetails ends");

		return response;
	}

	/*
	 * DAO Function to get District Name List for edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStateNameListEdit(String id) {
		logger.info("Method : getStateNameListEdit starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();
		String value = "SET @p_tCountry='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("godownMasterRoutines")
					.setParameter("actionType", "getStateName").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getStateNameListEdit ends");
		return stateList;
	}

	/**
	 * DAO Function to get District Name List for edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDistNameListEdit(String id) {
		logger.info("Method : getDistNameListEdit starts");
		List<DropDownModel> districtList = new ArrayList<DropDownModel>();
		String value = "SET @p_tState='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("godownMasterRoutines")
					.setParameter("actionType", "getDistrictName").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				districtList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDistNameListEdit ends");
		return districtList;
	}

	/*
	 * DAO Function to view Godown Name in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getGodownList() {
		logger.info("Method : getGodownList starts");
		List<DropDownModel> godownList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("godownMasterRoutines")
					.setParameter("actionType", "godownName").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				godownList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getGodownList ends");
		return godownList;
	}


		/*
		 * DAO Function to view Godown Name in dropDown
		 *
		 */
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getStateListPram() {
			logger.info("Method : getStateListPram starts");
			List<DropDownModel> stateList = new ArrayList<DropDownModel>();
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("godownMasterRoutines")
						.setParameter("actionType", "stateName").setParameter("actionValue", "").getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					stateList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : getStateListPram ends");
			return stateList;
		}

}
