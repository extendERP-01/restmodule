package nirmalya.aatithya.restmodule.master.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateGlobalMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.GlobalMasterRestModel;


@Repository
public class GlobalRestDao {
	Logger logger = LoggerFactory.getLogger(GlobalRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	
	public ResponseEntity<JsonResponse<Object>> addGlobalMaster(GlobalMasterRestModel globalMasterRestModel) {
		logger.info("Method : addGlobalMaster Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		resp.setMessage("");
		resp.setCode("");
		
		System.out.println(globalMasterRestModel);

		if (globalMasterRestModel.getCountryName() == null || globalMasterRestModel.getCountryName() == "") {
			resp.setMessage("Country Name Required");
			validity = false;
		} else if (globalMasterRestModel.getCountryCode() == null || globalMasterRestModel.getCountryCode() == "") {
			resp.setMessage("Country Code Required");
			validity = false;
		} else if (globalMasterRestModel.getCountryOrderId() == null
				|| globalMasterRestModel.getCountryOrderId() == "") {
			resp.setMessage("Country Order ID Required");
			validity = false;
		} else if (globalMasterRestModel.getCountryStatus() == null || globalMasterRestModel.getCountryStatus() == "") {
			resp.setMessage("Status Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateGlobalMasterParameter.Country(globalMasterRestModel);

				if (globalMasterRestModel.getGlobalId() != null && globalMasterRestModel.getGlobalId() != "") {
					em.createNamedStoredProcedureQuery("GlobalMasterRoutines")
							.setParameter("actionType", "modifyGlobal").setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("GlobalMasterRoutines").setParameter("actionType", "addGlobal")
							.setParameter("actionValue", values).execute();
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

		logger.info("Method :addGlobalMaster Dao ends");
		return response;
	}

	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> viewGlobalMaster() {
		logger.info("Method : viewGlobalMaster starts");

		List<GlobalMasterRestModel> countryList = new ArrayList<GlobalMasterRestModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("GlobalMasterRoutines").setParameter("actionType", "viewCountry")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				GlobalMasterRestModel dropDownModel = new GlobalMasterRestModel(null, m[0], m[1], m[2], null, null,
						null, null, null, null, null, null, null, m[3],null,null,null,null,null);
				countryList.add(dropDownModel);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonResponse<List<GlobalMasterRestModel>> resp = new JsonResponse<List<GlobalMasterRestModel>>();
		resp.setBody(countryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> response = new ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>>(
		resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewGlobalMaster ends");
		return response;
	}
	
	
	
	
	
	public ResponseEntity<JsonResponse<Object>> addStateMaster(GlobalMasterRestModel globalMasterRestModel) {
		logger.info("Method : addStateMaster Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		resp.setMessage("");
		resp.setCode("");
		
		System.out.println(globalMasterRestModel);

		if (globalMasterRestModel.getStateName() == null || globalMasterRestModel.getStateName() == "") {
			resp.setMessage("State Name Required");
			validity = false;
		} else if (globalMasterRestModel.getStateCode() == null || globalMasterRestModel.getStateCode() == "") {
			resp.setMessage("State Code Required");
			validity = false;
		} else if (globalMasterRestModel.getStateOrderId() == null
				|| globalMasterRestModel.getStateOrderId() == "") {
			resp.setMessage("State Order ID Required");
			validity = false;
		} else if (globalMasterRestModel.getStateStatus() == null || globalMasterRestModel.getStateStatus() == "") {
			resp.setMessage("Status Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateGlobalMasterParameter.State(globalMasterRestModel);

				if (globalMasterRestModel.getStateId() != null && globalMasterRestModel.getStateId() != "") {
					em.createNamedStoredProcedureQuery("GlobalMasterRoutines")
							.setParameter("actionType", "modifyState").setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("GlobalMasterRoutines").setParameter("actionType", "addState")
							.setParameter("actionValue", values).execute();
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

		logger.info("Method :addStateMaster Dao ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> viewStateMaster() {
		logger.info("Method : viewStateMaster starts");

		List<GlobalMasterRestModel> stateList = new ArrayList<GlobalMasterRestModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("GlobalMasterRoutines").setParameter("actionType", "viewState")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				GlobalMasterRestModel dropDownModel = new GlobalMasterRestModel(null,null, null,null,null, m[0],
						m[1],m[2], null, null, null,null,null, null,m[3],null,null,null,null);
				stateList.add(dropDownModel);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonResponse<List<GlobalMasterRestModel>> resp = new JsonResponse<List<GlobalMasterRestModel>>();
		resp.setBody(stateList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> response = new ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>>(
		resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewStateMaster ends");
		return response;
	}

	
	public ResponseEntity<JsonResponse<Object>> addCityMaster(GlobalMasterRestModel globalMasterRestModel) {
		logger.info("Method : addCityMaster Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		resp.setMessage("");
		resp.setCode("");
		
		System.out.println(globalMasterRestModel);

		if (globalMasterRestModel.getCityName() == null || globalMasterRestModel.getCityName() == "") {
			resp.setMessage("City Name Required");
			validity = false;
		} else if (globalMasterRestModel.getCityCode() == null || globalMasterRestModel.getCityCode() == "") {
			resp.setMessage("City Code Required");
			validity = false;
		} else if (globalMasterRestModel.getCityOrderId() == null
				|| globalMasterRestModel.getCityOrderId() == "") {
			resp.setMessage("City Order ID Required");
			validity = false;
		} else if (globalMasterRestModel.getCityStatus() == null || globalMasterRestModel.getCityStatus() == "") {
			resp.setMessage("Status Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateGlobalMasterParameter.City(globalMasterRestModel);

				if (globalMasterRestModel.getCityId() != null && globalMasterRestModel.getCityId() != "") {
					em.createNamedStoredProcedureQuery("GlobalMasterRoutines")
							.setParameter("actionType", "modifyCity").setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("GlobalMasterRoutines").setParameter("actionType", "addCity")
							.setParameter("actionValue", values).execute();
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

		logger.info("Method :addCityMaster Dao ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> viewCityMaster() {
		logger.info("Method : viewCityMaster starts");

		List<GlobalMasterRestModel> cityList = new ArrayList<GlobalMasterRestModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("GlobalMasterRoutines").setParameter("actionType", "viewCity")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				GlobalMasterRestModel dropDownModel = new GlobalMasterRestModel(null,null, null,null,null,null,
						null,null, null, m[0], m[1],m[2], null, null,null,m[3],null,null,null);
				cityList.add(dropDownModel);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonResponse<List<GlobalMasterRestModel>> resp = new JsonResponse<List<GlobalMasterRestModel>>();
		resp.setBody(cityList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> response = new ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>>(
		resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewCityMaster ends");
		return response;
	}

}
