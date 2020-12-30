
/**
 * Defines RestLeavePeriodDao DAO
 *
 */
package nirmalya.aatithya.restmodule.leave.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateLeavePeriodParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.leave.model.RestLeavePeriodModel;  
/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class RestLeavePeriodDao {
	
	Logger logger = LoggerFactory.getLogger(RestLeavePeriodDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	EntityManager em;
	 
	
	/*
	 * DAO Function to ADD/Edit Period data
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addLeavePeriod(RestLeavePeriodModel table) {
    
		logger.info("Method : addLeavePeriod starts");
		
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		 
		if (table.getlPeriodName() == null || table.getlPeriodName() == "") {
			resp.setMessage("*Period Name name required");
			validity = false;
		} else if (table.getlPeriodStartDate() == null || table.getlPeriodStartDate() == "") {
			resp.setMessage("*start Period Date required");
			validity = false;
	 
		}  else if (table.getlPeriodEndDate() == null || table.getlPeriodEndDate() == "") {
			resp.setMessage("*End Period Date required");
			validity = false;
	 
		} else if (table.getlPeriodStatus() == null) {
			resp.setMessage("*Leave status required");
			validity = false;
	 
	}

		if (validity)
			try {
				
				String values = GenerateLeavePeriodParameter.getAddLeavePeriodParam(table);

				if (table.getlPeriodId() != null && table.getlPeriodId() != "") {
					em.createNamedStoredProcedureQuery("leavePeriodRoutines")
					.setParameter("actionType", "modifyLeavePeriod")
					.setParameter("actionValue", values)
					.execute();
				} else {
					em.createNamedStoredProcedureQuery("leavePeriodRoutines")
					.setParameter("actionType", "addLeavePeriod")
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
		logger.info("Method : addLeavePeriod ends");	
		return response;
	}
	
	/*
	 * DAO Function to get LPerioddata Name
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPeriodName(String getPeriodName) {
		
		logger.info("Method : DAO getPeriodName starts");
		
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		
		try {
			String value = "SET @p_StateName=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("leavePeriodRoutines")
					.setParameter("actionType", getPeriodName)
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
		logger.info("Method : DAO getPeriodName ends");	
		return response;
	}

	/*
	 * DAO Function to View all Period data
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestLeavePeriodModel>>> getLPeriodDetails(
			DataTableRequest request) {
		logger.info("Method : getLPeriodDetails details starts");
		List<RestLeavePeriodModel> meal = new ArrayList<RestLeavePeriodModel>();
		String values = GenerateLeavePeriodParameter.getSearchParam(request);
		Integer total = 0;
		try {			 
			List<Object[]> x = em.createNamedStoredProcedureQuery("leavePeriodRoutines")
					.setParameter("actionType", "viewLPeriod")
					.setParameter("actionValue", values).getResultList();
			if(!x.isEmpty()) {
				for (Object[] m : x) {
					Object startDate = null;
					Object endDate = null;
					if (m[2] != null) {
						startDate = DateFormatter.returnStringDate(m[2]);
					}
					if (m[3] != null) {
						endDate = DateFormatter.returnStringDate(m[3]);
					}
					RestLeavePeriodModel user = new RestLeavePeriodModel(m[0], m[1], startDate, endDate, m[4]);
					meal.add(user);
				}
				if (x.get(0).length > 5) {
					BigInteger t = (BigInteger) x.get(0)[5];
					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestLeavePeriodModel>> resp = new JsonResponse<List<RestLeavePeriodModel>>();
		resp.setBody(meal);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestLeavePeriodModel>>> response = new ResponseEntity<JsonResponse<List<RestLeavePeriodModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getLPeriodDetails ends");
		return response;
	}
	

	/*
	 * DAO Function to  delete particular leave period record 
	 *
	 */
	 public ResponseEntity<JsonResponse<Object>> deleteLperiodById(String id) {
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_leaveId="+id +";";
			em.createNamedStoredProcedureQuery("leavePeriodRoutines")
				.setParameter("actionType", "deleteLperiod")
				.setParameter("actionValue", value)
				.execute();		
		} 
		catch (Exception e) {
			e.printStackTrace();
			String[] err = serverDao.errorProcedureCall(e);
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,responseHeaders,HttpStatus.CREATED);
		logger.info("Method : DAO deleteLperiodById ends");
		return response;
	} 

	/*
	 * DAO Function to get Leave period data by Id
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestLeavePeriodModel>> getLeavePeriodById(String id,String action) {
		logger.info("Method : getLeavePeriodById starts");
		List<RestLeavePeriodModel> mt = new ArrayList<RestLeavePeriodModel>();
		JsonResponse<RestLeavePeriodModel> resp = new JsonResponse<RestLeavePeriodModel>();
		try {
			String value = "SET @p_leaveId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("leavePeriodRoutines")
					.setParameter("actionType", action)
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object startDate = null;
				Object endDate = null;
				if (m[2] != null) {
					startDate = DateFormatter.returnStringDate(m[2]);
				}
				if (m[3] != null) {
					endDate = DateFormatter.returnStringDate(m[3]);
				}				
				RestLeavePeriodModel table = new RestLeavePeriodModel(m[0], m[1], startDate, endDate, m[4]);				 
				mt.add(table);
			}
			 resp.setBody(mt.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<RestLeavePeriodModel>> response = new ResponseEntity<JsonResponse<RestLeavePeriodModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : getLeavePeriodById ends");
		return response;
	}

}
