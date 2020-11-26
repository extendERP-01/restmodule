/**
 * Defines State DAO
 *
 */
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
import nirmalya.aatithya.restmodule.common.utils.GenerateStateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.UserStateModel;
/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class UserStateDao {
	Logger logger = LoggerFactory.getLogger(UserStateDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	EntityManager em;
	
	/*
	 * DAO Function to Add/edit New State
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addState(UserStateModel table) {
		
		logger.info("Method : addState starts");
		
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		
		/* System.out.println("Data: " + meal); */
		
		if (table.getStateName() == null || table.getStateName() == "") {
			resp.setMessage("*State name required");
			validity = false;
		  
		} else if (table.getStateStatus() == null) {
			resp.setMessage("*State status required");
			validity = false;
	 
	}

		if (validity)
			try {
				
				String values = GenerateStateParameter.getAddStateParam(table);

				if (table.getStateId() != null && table.getStateId() != "") {
					em.createNamedStoredProcedureQuery("stateRoutines")
					.setParameter("actionType", "modifyState")
					.setParameter("actionValue", values)
					.execute();
				} else {
					em.createNamedStoredProcedureQuery("stateRoutines")
					.setParameter("actionType", "addState")
					.setParameter("actionValue", values)
					.execute();
				}
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		
		logger.info("Method : addState ends");
		
		return response;
	}
	
	/*
	 * DAO Function to View all State data
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<UserStateModel>>> getStateDetails(
			DataTableRequest request) {


		logger.info("Method : getState details starts");
		
		List<UserStateModel> meal = new ArrayList<UserStateModel>();
		String values = GenerateStateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("stateRoutines")
					.setParameter("actionType", "viewState")
					.setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				UserStateModel user = new UserStateModel(m[0], m[1], m[2], null, null);
				meal.add(user);
			}

			if (x.get(0).length > 3) {
				BigInteger t = (BigInteger) x.get(0)[3];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<UserStateModel>> resp = new JsonResponse<List<UserStateModel>>();
		resp.setBody(meal);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<UserStateModel>>> response = new ResponseEntity<JsonResponse<List<UserStateModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getStateDetails ends");
		
		return response;
	}
	
	/*
	 * DAO Function to get CountryName drop down data
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCountryName(String getCountryName) {
		
		logger.info("Method : DAO getCountryName starts");
		
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		
		try {
			String value = "SET @p_CountryName=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("stateRoutines")
					.setParameter("actionType", getCountryName)
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModelConstructor = new DropDownModel(m[0], m[1]);
				dropDownModel.add(dropDownModelConstructor);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setBody(dropDownModel);

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : DAO getCountryName ends");	
		return response;
	}
	
	

	/*
	 * DAO Function to view particular State to delete 
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteStateById(String id) {
		//logger.info("Method : DAO deleteTableMasterById starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		
		try 
		{
			
			String value = "SET @p_stateId="+id +";";
			// System.out.println("value edit : " + value ); 
			
			em.createNamedStoredProcedureQuery("stateRoutines")
				.setParameter("actionType", "deleteState")
				.setParameter("actionValue", value)
				.execute();
				
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			
			String[] err =serverDao.errorProcedureCall(e);
			
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}
		
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,responseHeaders,HttpStatus.CREATED);
		
		logger.info("Method : DAO deleteStateById ends");
		return response;
	}
	
	/*
	 * DAO Function to view particular State to Edit
	 *
	 */
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<UserStateModel>> getStateById(String id,String action) {
		
		logger.info("Method : getStateById starts");
		
		List<UserStateModel> mt = new ArrayList<UserStateModel>();
		JsonResponse<UserStateModel> resp = new JsonResponse<UserStateModel>();

		try {

			String value = "SET @p_stateId='" + id + "';";

			/* System.out.println("value edit : " + value); */

			List<Object[]> x = em.createNamedStoredProcedureQuery("stateRoutines")
					.setParameter("actionType", action)
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				UserStateModel table = new UserStateModel(m[0], m[1], m[2], m[3], m[4]);
				/* System.out.println(meal); */
				mt.add(table);
			}
			/* System.out.println("data printed"+mt); */
			resp.setBody(mt.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<UserStateModel>> response = new ResponseEntity<JsonResponse<UserStateModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : getStateById ends");
		System.out.println("response on edit time-----------"+response);
		return response;
	}
}
