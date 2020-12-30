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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel; 
import nirmalya.aatithya.restmodule.common.utils.GenerateLeaveTypeParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.leave.model.RestLeaveTypeModel; 
/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class RestLeaveTypeDao {
	
	Logger logger = LoggerFactory.getLogger(RestLeaveTypeDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	EntityManager em;
	
	/*
	 * DAO Function to ADD/Edit Leave Type
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> restAddLeaveType(RestLeaveTypeModel table) {
    
		logger.info("Method : restAddLeaveType starts");
		
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		 
		if (table.getlTypeName() == null || table.getlTypeName() == "") {
			resp.setMessage("*Leave Type Name required");
			validity = false;
		} else if (table.getlTypePeriod() == null ) {
			resp.setMessage("*Leave Period required");
			validity = false;
		} else if (table.getIsadminAssign() == null) {
			resp.setMessage("*select admin can assigned");
			validity = false;
	 
		}else if (table.getIsEmpApply() == null) {
			resp.setMessage("*select Employee can apply");
			validity = false;
	 
		}else if (table.getIsEmpAlyMoreThanALeave() == null) {
			resp.setMessage("*select Employee can apply More than Available leave");
			validity = false;
	 
		}else if (table.getlAccrueEnb() == null) {
			resp.setMessage("*Select Leave Accrue Enable required");
			validity = false;
	 
		}else if (table.getlCarriedFwd() == null) {
			resp.setMessage("*Select Leave Carried Forward required");
			validity = false;
	 
		}else if (table.getlCarriedFwdPercnt() == null) {
			resp.setMessage("*percentage of leave carried forward required");
			validity = false;
	 
		}else if (table.getMaxCaryFwdAmt() == null) {
			resp.setMessage("*max carried forward amount required");
			validity = false;
	 
		} else if (table.getProperLeaveJDate() == null) {
			resp.setMessage("*Select Propertionate Joining date required");
			validity = false;
	 
	    }else if (table.getSentEmailNotify() == null) {
			resp.setMessage("*Select Sent Email required");
			validity = false;
	 
	    }else if (table.getlTypeStatus() == null) {
			resp.setMessage("*Leave  type status required");
			validity = false;
	 
	    }

		if (validity)
			try {
				String values = GenerateLeaveTypeParameter.getAddLeaveTypeParam(table);
                if (table.getlTypeId() != null && table.getlTypeId() != "") {
					em.createNamedStoredProcedureQuery("leaveTypeRoutines")
					.setParameter("actionType", "modifyLeaveType")
					.setParameter("actionValue", values)
					.execute();
				} else {
					em.createNamedStoredProcedureQuery("leaveTypeRoutines")
					.setParameter("actionType", "addLeaveType")
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
		logger.info("Method : restAddLeaveType ends");
		return response;
	} 

	/*
	 * DAO Function to View all Leave Type
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestLeaveTypeModel>>> getLtypeData(
			DataTableRequest request) {
		logger.info("Method : getLtypeData details starts");
		List<RestLeaveTypeModel> meal = new ArrayList<RestLeaveTypeModel>();
		String values = GenerateLeaveTypeParameter.getSearchParam(request);
		Integer total = 0;
		try {	 
			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveTypeRoutines")
					.setParameter("actionType", "viewLType")
					.setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				 
				RestLeaveTypeModel user = new RestLeaveTypeModel(m[0], m[1], m[2],null,null,null,m[3],m[4],null,null,null,null,null,m[5]);
				meal.add(user);
			}
			if (x.get(0).length > 6) {
				BigInteger t = (BigInteger) x.get(0)[6];

				total = Integer.parseInt((t.toString()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestLeaveTypeModel>> resp = new JsonResponse<List<RestLeaveTypeModel>>();
		resp.setBody(meal);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestLeaveTypeModel>>> response = new ResponseEntity<JsonResponse<List<RestLeaveTypeModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getLtypeData ends");
		return response;
	}
	

	/*
	 * DAO Function to  delete particular Leave type record 
	 *
	 */
	 public ResponseEntity<JsonResponse<Object>> deleteLtypeById(String id) {
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_leaveId="+id +";";
			em.createNamedStoredProcedureQuery("leaveTypeRoutines")
				.setParameter("actionType", "deleteLType")
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
		
		logger.info("Method : DAO deleteLType ends");
		return response;
	} 
	 
	 	/*
		 * DAO Function to get getTypeName
		 *
		 */
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getTypeName(String getTypeName) {
			
			logger.info("Method : DAO getTypeName starts");
			
			List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
			
			try {
				String value = "SET @p_StateName=" + 0 + ";";
				List<Object[]> x = em.createNamedStoredProcedureQuery("leaveTypeRoutines")
						.setParameter("actionType", getTypeName)
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
			
			logger.info("Method : DAO getTypeName ends");	
			return response;
		}
		

		
		

	 	/*
		 * DAO Function to get getAvailPeriod
		 *
		 */
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getAvailPeriod(String getAvailPeriod) {
			
			logger.info("Method : DAO getAvailPeriod starts");
			
			List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
			
			try {
				String value = "SET @p_StateName=" + 0 + ";";
				List<Object[]> x = em.createNamedStoredProcedureQuery("leaveTypeRoutines")
						.setParameter("actionType", getAvailPeriod)
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
			
			logger.info("Method : DAO getAvailPeriod ends");	
			return response;
		}

	/*
	 * DAO Function to get Leave type data by Id
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestLeaveTypeModel>> getLeaveTypeById(String id,String action) {
		
		logger.info("Method : getLeavePeriodById starts");
		
		List<RestLeaveTypeModel> mt = new ArrayList<RestLeaveTypeModel>();
		JsonResponse<RestLeaveTypeModel> resp = new JsonResponse<RestLeaveTypeModel>();

		try {
			String value = "SET @p_leaveId='" + id + "';";
            List<Object[]> x = em.createNamedStoredProcedureQuery("leaveTypeRoutines")
					.setParameter("actionType", action)
					.setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) { 
				RestLeaveTypeModel table = new RestLeaveTypeModel(m[0], m[1], m[2], m[3],m[4], m[5],m[6], m[7],m[8], m[9],m[10], m[11],m[12], m[13]);			 
				mt.add(table);
			}
			resp.setBody(mt.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<RestLeaveTypeModel>> response = new ResponseEntity<JsonResponse<RestLeaveTypeModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : getLeaveTypeById ends");
		return response;
	}

}
