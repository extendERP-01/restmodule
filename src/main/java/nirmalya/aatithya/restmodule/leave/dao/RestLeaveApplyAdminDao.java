/**
 * Defines RestLeaveApplyAdminDao DAO
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
import nirmalya.aatithya.restmodule.common.utils.GenerateLeaveAdminApplyParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateLeaveApplyParameter; 
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.leave.model.RestLeaveApplyAdminModel; 
/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class RestLeaveApplyAdminDao {
	
	Logger logger = LoggerFactory.getLogger(RestLeaveApplyAdminDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	EntityManager em;
	
	/*
	 * DAO Function to get getLeaveTypeName
	 *
	 */
 	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAdminLeaveType(String getAdminLeaveType) {
		logger.info("Method : DAO getAdminLeaveType starts");
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_leavetype=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveApplyAdminRoutines")
					.setParameter("actionType", getAdminLeaveType)
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
		
		logger.info("Method : DAO getAdminLeaveType ends");	
		return response;
	}
 
 	/*
	 * DAO Function to get getStatusType
	 *
	 */
 	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStatusType(String getStatusType) {
	    logger.info("Method : DAO getStatusType starts");
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_leavetype=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveApplyAdminRoutines")
					.setParameter("actionType", getStatusType)
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
		
		logger.info("Method : DAO getStatusType ends");	
		return response;
	}

 	
 	/*
	 * DAO Function to View all Period data
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestLeaveApplyAdminModel>>> getAllLApplyData(
			DataTableRequest request) {
		logger.info("Method : getAllLApplyData details starts");
		List<RestLeaveApplyAdminModel> lapply = new ArrayList<RestLeaveApplyAdminModel>();
		String values = GenerateLeaveApplyParameter.getSearchParam(request);
		Integer total = 0;
		try {
			 
			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveApplyAdminRoutines")
					.setParameter("actionType", "viewAllLApplied")
					.setParameter("actionValue", values).getResultList();
			if(!x.isEmpty()) {
				for (Object[] m : x) {
					Object startDate = null;
					Object endDate = null;
					if (m[3] != null) {
						startDate = DateFormatter.returnStringDate(m[3]);
	
					}
					if (m[4] != null) {
						endDate = DateFormatter.returnStringDate(m[4]);
	
					}
					RestLeaveApplyAdminModel user = new RestLeaveApplyAdminModel(m[0], m[1],m[2], startDate, endDate, m[5]);
					lapply.add(user);
				}
				if (x.get(0).length > 6) {
					BigInteger t = (BigInteger) x.get(0)[6];
	
					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestLeaveApplyAdminModel>> resp = new JsonResponse<List<RestLeaveApplyAdminModel>>();
		resp.setBody(lapply);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestLeaveApplyAdminModel>>> response = new ResponseEntity<JsonResponse<List<RestLeaveApplyAdminModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getAllLApplyData ends");
		return response;
	}


	/*
	 * DAO Function to Change Status
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> restChangeStatus(RestLeaveApplyAdminModel table) {
		logger.info("Method : restChangeStatus starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {	
				String values = GenerateLeaveAdminApplyParameter.getChangeStatusParam(table);

				if (table.getApplyId() != null && table.getApplyId() != "") {
					 em.createNamedStoredProcedureQuery("leaveApplyAdminRoutines")
					.setParameter("actionType", "modifyLeaveStatus")
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
		logger.info("Method : restApplyLeave ends");
		return response;
	}
	
	/*
	 * DAO Function to get Model data for admin view all list page
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestLeaveApplyAdminModel>> getLeaveAdmById(String id,String action) {
		logger.info("Method : getLeaveAdmById starts");
		List<RestLeaveApplyAdminModel> mt = new ArrayList<RestLeaveApplyAdminModel>();
		JsonResponse<RestLeaveApplyAdminModel> resp = new JsonResponse<RestLeaveApplyAdminModel>();
		try {
			String value = "SET @p_leaveId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveApplyAdminRoutines")
					.setParameter("actionType", action)
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object startDate = null;
				Object endDate = null;
				if (m[3] != null) {
					startDate = DateFormatter.returnStringDate(m[3]);
				}
				if (m[4] != null) {
					endDate = DateFormatter.returnStringDate(m[4]);
				}
				RestLeaveApplyAdminModel table = new RestLeaveApplyAdminModel(m[0], m[1], m[2],startDate, endDate,m[5]);	 
				mt.add(table);
			}
			resp.setBody(mt.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<RestLeaveApplyAdminModel>> response = new ResponseEntity<JsonResponse<RestLeaveApplyAdminModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getLeaveApplyById ends");
		return response;
	}
	
	/*
	 * DAO Function to  Cancel  leave 
	 *
	 */
	/*public ResponseEntity<JsonResponse<Object>> cancelLeaveById(String id) {
		logger.info("Method : DAO cancelLeaveById starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		
		try 
		{
			
			String value = "SET @p_leaveId="+id +";";
			//System.out.println("value delete : " + value ); 
			
			em.createNamedStoredProcedureQuery("leaveApplyRoutines")
				.setParameter("actionType", "cancelLeaveById")
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
		
		logger.info("Method : DAO cancelLeaveById ends");
		return response;
	} 
	 */
	/*
	 * DAO Function to View all Period data
	 *
	 */
/*	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestLeavePeriodModel>>> getLPeriodDetails(
			DataTableRequest request) {
		logger.info("Method : getLPeriodDetails details starts");
		List<RestLeavePeriodModel> meal = new ArrayList<RestLeavePeriodModel>();
		//System.out.println("value"+request.getParam1());
		String values = GenerateLeaveParameter.getSearchParam(request);
		Integer total = 0;
		//System.out.println("param is Doa -----"+request.getParam1());
		try {
			 
			List<Object[]> x = em.createNamedStoredProcedureQuery("leavePeriodRoutines")
					.setParameter("actionType", "viewLPeriod")
					.setParameter("actionValue", values).getResultList();
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
		//System.out.println("Response in Leave Period Dao for View==============="+response);
		return response;
	}
	*/


	/*
	 * DAO Function to  delete particular leave period record 
	 *
	 */
	/* public ResponseEntity<JsonResponse<Object>> deleteLperiodById(String id) {
		//logger.info("Method : DAO deleteTableMasterById starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		
		try 
		{
			
			String value = "SET @p_leaveId="+id +";";
			//System.out.println("value delete : " + value ); 
			
			em.createNamedStoredProcedureQuery("leavePeriodRoutines")
				.setParameter("actionType", "deleteLperiod")
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
		
		logger.info("Method : DAO deleteLperiodById ends");
		return response;
	} */


	/*
	 * DAO Function to get Leave period data by Id
	 *
	 */
	/*@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestLeaveApplyModel>> getLeaveApplyById(String id,String action) {
		
		logger.info("Method : getLeaveApplyById starts");
		
		List<RestLeaveApplyModel> mt = new ArrayList<RestLeaveApplyModel>();
		JsonResponse<RestLeaveApplyModel> resp = new JsonResponse<RestLeaveApplyModel>();

		try {

			String value = "SET @p_leaveId='" + id + "';";

		   // System.out.println("value for pop up in dao set id is------------ : " + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveApplyRoutines")
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
				
				RestLeaveApplyModel table = new RestLeaveApplyModel(m[0], m[1], startDate, endDate, m[4]);
				 
				mt.add(table);
			}
			 //System.out.println("data printed"+mt); 
			resp.setBody(mt.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<RestLeaveApplyModel>> response = new ResponseEntity<JsonResponse<RestLeaveApplyModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : getLeaveApplyById ends");
		return response;
	}*/

}



