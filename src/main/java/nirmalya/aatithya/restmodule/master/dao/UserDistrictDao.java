/**
 * Defines District DAO
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
import nirmalya.aatithya.restmodule.common.utils.GenerateDistrictParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.UserDistrictModel;
/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class UserDistrictDao {
	
	Logger logger = LoggerFactory.getLogger(UserDistrictDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	EntityManager em;
	
	
	/*
	 * DAO Function to get State drop down data
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateName(String getStateName) {
		
		logger.info("Method : DAO getStateName starts");
		
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		
		try {
			String value = "SET @p_StateName=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("districtRoutines")
					.setParameter("actionType", getStateName)
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
		
		logger.info("Method : DAO getStateName ends");	
		return response;
	}
	
	
	/*
	 * DAO Function to get District drop down data
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDistName(String getDistName) {
		
		logger.info("Method : DAO getDistName starts");
		
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		
		try {
			String value = "SET @p_DistrictName=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("districtRoutines")
					.setParameter("actionType", getDistName)
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
		
		logger.info("Method : DAO getDistName ends");	
		return response;
	}
	
	/*
	 * DAO Function to ADD/Edit District
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addDistrict(UserDistrictModel table) {
    
		logger.info("Method : addDistrict starts");
		
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		
		/* System.out.println("Data: " + meal); */
		
		if (table.getDistrictName() == null || table.getDistrictName() == "") {
			resp.setMessage("*District name required");
			validity = false;
		} else if (table.getStateName() == null || table.getStateName() == "") {
			resp.setMessage("*state name required");
			validity = false;
	 
		} else if (table.getDistrictStatus() == null) {
			resp.setMessage("*District status required");
			validity = false;
	 
	}

		if (validity)
			try {
				
				String values = GenerateDistrictParameter.getAddDistrictParam(table);

				if (table.getDistrictId() != null && table.getDistrictId() != "") {
					em.createNamedStoredProcedureQuery("districtRoutines")
					.setParameter("actionType", "modifyDistrict")
					.setParameter("actionValue", values)
					.execute();
				} else {
					em.createNamedStoredProcedureQuery("districtRoutines")
					.setParameter("actionType", "addDistrict")
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
		
		logger.info("Method : addDistrict ends");
		
		return response;
	}


	/*
	 * DAO Function to View all District data
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<UserDistrictModel>>> getDistrictDetails(
			DataTableRequest request) {
		logger.info("Method : getState details starts");
		List<UserDistrictModel> meal = new ArrayList<UserDistrictModel>();
		//System.out.println("value"+request.getParam1());
		String values = GenerateDistrictParameter.getSearchParam(request);
		Integer total = 0;
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("districtRoutines")
					.setParameter("actionType", "viewDistrict")
					.setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				UserDistrictModel user = new UserDistrictModel(m[0], m[1], m[2], m[3], m[4]);
				meal.add(user);
			}
			if (x.get(0).length > 5) {
				BigInteger t = (BigInteger) x.get(0)[5];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<UserDistrictModel>> resp = new JsonResponse<List<UserDistrictModel>>();
		resp.setBody(meal);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<UserDistrictModel>>> response = new ResponseEntity<JsonResponse<List<UserDistrictModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getDistrictDetails ends");
		
		return response;
	}
	

	/*
	 * DAO Function to  delete particular row from district
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteDistrictById(String id) {
		//logger.info("Method : DAO deleteTableMasterById starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		
		try 
		{
			
			String value = "SET @p_districtId="+id +";";
			/* System.out.println("value edit : " + value ); */
			
			em.createNamedStoredProcedureQuery("districtRoutines")
				.setParameter("actionType", "deleteDistrict")
				.setParameter("actionValue", value)
				.execute();
				
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			
			String[] err = serverDao.errorProcedureCall(e);
			
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}
		
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,responseHeaders,HttpStatus.CREATED);
		
		logger.info("Method : DAO deleteDistrictById ends");
		return response;
	}

	/*
	 * DAO Function to get District data by Id
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<UserDistrictModel>> getDistrictById(String id,String action) {
		
		logger.info("Method : getDistrictById starts");
		
		List<UserDistrictModel> mt = new ArrayList<UserDistrictModel>();
		JsonResponse<UserDistrictModel> resp = new JsonResponse<UserDistrictModel>();

		try {

			String value = "SET @p_districtId='" + id + "';";

		    System.out.println("value for pop up in dao set id is------------ : " + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("districtRoutines")
					.setParameter("actionType", action)
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				UserDistrictModel table = new UserDistrictModel(m[0], m[1], m[2], m[3], m[4]);
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

		ResponseEntity<JsonResponse<UserDistrictModel>> response = new ResponseEntity<JsonResponse<UserDistrictModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : getDistrictById ends");
		return response;
	}

}
