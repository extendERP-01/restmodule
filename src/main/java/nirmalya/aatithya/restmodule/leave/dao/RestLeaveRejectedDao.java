/**
 * Defines RestLeaveRejectedDao DAO
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
import nirmalya.aatithya.restmodule.common.utils.GenerateLeavePendingParameter; 
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.leave.model.RestLeaveApplyModel;  
/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class RestLeaveRejectedDao {
	
	Logger logger = LoggerFactory.getLogger(RestLeaveRejectedDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	EntityManager em;
 
	
	/*
	 * DAO Function to get getLeaveTypeName
	 *
	 */
 	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRLeaveType(String getRLeaveType) {		
		logger.info("Method : DAO getRLeaveType starts");
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_leavetype=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveRejectedRoutines")
					.setParameter("actionType", getRLeaveType)
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
		logger.info("Method : DAO getRLeaveType ends");	
		return response;
	}
 	
 	/*
	 * DAO Function to View all Period data
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestLeaveApplyModel>>> getRLApplyData(
			DataTableRequest request) {
		logger.info("Method : getALApplyData details starts");
		List<RestLeaveApplyModel> lapply = new ArrayList<RestLeaveApplyModel>();
		String values = GenerateLeavePendingParameter.getSearchParam(request);
		Integer total = 0;
		try {	 
			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveRejectedRoutines")
					.setParameter("actionType", "viewRLApplied")
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
				RestLeaveApplyModel user = new RestLeaveApplyModel(m[0], m[1], startDate, endDate, m[4],null,null,null,null,null,null ,null);
				lapply.add(user);
			}
			if (x.get(0).length > 5) {
				BigInteger t = (BigInteger) x.get(0)[5];
				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestLeaveApplyModel>> resp = new JsonResponse<List<RestLeaveApplyModel>>();
		resp.setBody(lapply);
		resp.setTotal(total);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestLeaveApplyModel>>> response = new ResponseEntity<JsonResponse<List<RestLeaveApplyModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getALApplyData ends");
	    return response;
	}
	 
	/*
	 * DAO Function to get Leave Pending data by Id
	 *
	 */
 	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestLeaveApplyModel>> getLeaveRejectedById(String id,String action) {
		logger.info("Method : getLeaveRejectedById starts");
		List<RestLeaveApplyModel> mt = new ArrayList<RestLeaveApplyModel>();
		JsonResponse<RestLeaveApplyModel> resp = new JsonResponse<RestLeaveApplyModel>();
		try {
			String value = "SET @p_leaveId='" + id + "';";
            List<Object[]> x = em.createNamedStoredProcedureQuery("leaveRejectedRoutines")
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
				RestLeaveApplyModel table = new RestLeaveApplyModel(m[0], m[1], startDate, endDate, m[4],m[5],null,null,null,null,null,null);		 
				mt.add(table);
			}
			resp.setBody(mt.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestLeaveApplyModel>> response = new ResponseEntity<JsonResponse<RestLeaveApplyModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getLeaveRejectedById ends");
		return response;
 	}
}

