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
import nirmalya.aatithya.restmodule.common.utils.GenerateLeaveRuleParameter; 
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.leave.model.RestLeaveRuleModel; 
/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class RestLeaveRuleDao {
	
	Logger logger = LoggerFactory.getLogger(RestLeaveRuleDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	EntityManager em; 
	
	/*
	 * DAO Function to ADD/Edit Leave Type
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> restAddLeaveRule(RestLeaveRuleModel table) {
    
		logger.info("Method : restAddLeaveRule starts");
		
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		
		if (table.getLeaveType() == null || table.getLeaveType() == "") {
			resp.setMessage("*Please Select Leave Type Name");
			validity = false;
		}else if (table.getJobTitle() == null || table.getJobTitle() == "") {
			resp.setMessage("*Please Select Job Title");
			validity = false;
		}else if (table.getEmplmntStatus() == null || table.getEmplmntStatus() == "") {
			resp.setMessage("*Please Select Employment Status");
			validity = false;
		}else if (table.getEmpl() == null || table.getEmpl() == "") {
			resp.setMessage("*Please Select Employee");
			validity = false;
		}else if (table.getDepartment() == null || table.getDepartment() == "") {
			resp.setMessage("*Please Select  Department");
			validity = false;
		}else if (table.getLeavePerPeriod() == null) {
			resp.setMessage("*Leave Per Period Required");
			validity = false;
		}else if (table.getIsadminAssign() == null) {
			resp.setMessage("*Please Select Is Admin Assign");
			validity = false;
		}else if (table.getIsEmpApply() == null) {
			 resp.setMessage("*Please Select Employee can apply");
			 validity = false;
		}else if (table.getIsEmpAlyMoreThanALeave() == null) {
			resp.setMessage("*Please Select Employee can apply More than Available leave");
			validity = false;
	 
		}else if (table.getIsAccrueEnb() == null) {
			resp.setMessage("*Please Select Leave Accrue Enable required");
			validity = false;
	 
		}else if (table.getIsCarriedFwd() == null) {
			resp.setMessage("*Select Leave Carried Forward required");
			validity = false;
	 
		}else if (table.getCarriedFwdPercnt() == null) {
			resp.setMessage("*percentage of leave carried forward required");
			validity = false;
	 
		}else if (table.getMaxCaryFwdAmt() == null) {
			resp.setMessage("*max carried forward amount required");
			validity = false;
	 
		} else if (table.getProperLeaveJDate() == null) {
			resp.setMessage("*Select Propertionate Joining date required");
			validity = false;
	    }
		if (validity)
			try {			
				String values = GenerateLeaveRuleParameter.getAddLeaveRuleParam(table);

				if (table.getRuleId() != null && table.getRuleId() != "") {
					em.createNamedStoredProcedureQuery("leaveRuleRoutines")
					.setParameter("actionType", "modifyLeaveRule")
					.setParameter("actionValue", values)
					.execute();
				} else {
					em.createNamedStoredProcedureQuery("leaveRuleRoutines")//hrms_leaveRuleRoutines
					.setParameter("actionType", "addLeaveRule")
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
		logger.info("Method : restAddRuleType ends");	
		return response;
	}


	/*
	 * DAO Function to View all Leave Rule
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestLeaveRuleModel>>> getLRuleData(
			DataTableRequest request) {
		logger.info("Method : getLRuleData details starts");
		List<RestLeaveRuleModel> meal = new ArrayList<RestLeaveRuleModel>();
		String values = GenerateLeaveRuleParameter.getSearchParam(request);
		Integer total = 0;
		try {		 
			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveRuleRoutines")
					.setParameter("actionType", "viewLRule")
					.setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {			 
				RestLeaveRuleModel user = new RestLeaveRuleModel(m[0], m[1],m[2],m[3],m[4],m[5],m[6], m[7],null,null,null,null,null,m[8],null,null,null);
				meal.add(user);
			}
			if (x.get(0).length > 9) {
				BigInteger t = (BigInteger) x.get(0)[9];
				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestLeaveRuleModel>> resp = new JsonResponse<List<RestLeaveRuleModel>>();
		resp.setBody(meal);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestLeaveRuleModel>>> response = new ResponseEntity<JsonResponse<List<RestLeaveRuleModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getLRuleData ends");
		return response;
	}
	
	
	/*
	 * DAO Function to get getLeaveTypeName
	 *
	 */
 	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getLeaveTypeName(String getLeaveTypeName) {	
		logger.info("Method : DAO getLeaveTypeName starts");
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();	
		try {
			String value = "SET @p_leavetype=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveRuleRoutines")
					.setParameter("actionType", getLeaveTypeName)
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
		
		logger.info("Method : DAO getLeaveTypeName ends");	
		return response;
	}	

 	/*
	 * DAO Function to get getJobTitle
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getJobTitle(String getJobTitle ,String id) {	
		logger.info("Method : DAO getTypeName starts");
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_deptId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveRuleRoutines")
					.setParameter("actionType", "getJobTypeOnChange").setParameter("actionValue", value)
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
	 * DAO Function to get getEmplmtStatus
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmplmtStatus(String getEmplmtStatus , String id) {
		logger.info("Method : DAO getEmplmtStatus starts");
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_empId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveRuleRoutines")
					.setParameter("actionType", "getEmploymentList").setParameter("actionValue", value)
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
		
		logger.info("Method : DAO getEmplmtStatus ends");	
		return response;
	}
	 
	/*
	 * DAO Function to get Employee
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmpName(String getEmpName ,String id) {	
		logger.info("Method : DAO getEmpName starts");
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_jobTitleId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveRuleRoutines")
					.setParameter("actionType", "getEmployeeList").setParameter("actionValue", value)
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
		
		logger.info("Method : DAO getEmpName ends");	
		return response;
	}
	
	 
	/*
	 * DAO Function to get Department
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDeptName(String getDeptName) {
		logger.info("Method : DAO getDeptName starts");	
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_StateName=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveRuleRoutines")
					.setParameter("actionType", getDeptName)
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
		
		logger.info("Method : DAO getDeptName ends");	
		return response;
	}
	
	/*
	 * DAO Function to get LeavePeriod
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getLeavePeriod(String getLeavePeriod) {	
		logger.info("Method : DAO getLeavePeriod starts");
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_StateName=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveRuleRoutines")
					.setParameter("actionType", getLeavePeriod)
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
		
		logger.info("Method : DAO getLeavePeriod ends");	
		return response;
	}
	 
	/*
	 * DAO Function to get AvailPeriod
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRuleAvailPeriod(String getRuleAvailPeriod) {	
		logger.info("Method : DAO getRuleAvailPeriod starts");
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_StateName=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveRuleRoutines")
					.setParameter("actionType", getRuleAvailPeriod)
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
		
		logger.info("Method : DAO getRuleAvailPeriod ends");	
		return response;
	}
	
	

	/*
	 * DAO Function to  delete particular Leave Rule record 
	 *
	 */
	 public ResponseEntity<JsonResponse<Object>> deleteLRuleById(String id) {
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_leaveId="+id +";";
			 System.out.println("value delete : " + value ); 
			
			em.createNamedStoredProcedureQuery("leaveRuleRoutines")
				.setParameter("actionType", "deleteLRuleById")
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
	 * DAO Function to get Leave type data by Id
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestLeaveRuleModel>> getLeaveRuleById(String id,String action) {
		logger.info("Method : getLeaveRuleById starts");	
		List<RestLeaveRuleModel> mt = new ArrayList<RestLeaveRuleModel>();
		JsonResponse<RestLeaveRuleModel> resp = new JsonResponse<RestLeaveRuleModel>();
		try {
			String value = "SET @p_leaveId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveRuleRoutines")
					.setParameter("actionType", action)
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) { 
				RestLeaveRuleModel table = new RestLeaveRuleModel(m[0], m[1], m[2], m[3],m[4], m[5],m[6], m[7],m[8], m[9],m[10], m[11],m[12], m[13],m[14],m[15],m[16]);	 
				mt.add(table);
			} 
			resp.setBody(mt.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestLeaveRuleModel>> response = new ResponseEntity<JsonResponse<RestLeaveRuleModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : getLeaveTypeById ends");
		return response;
	}
	
	 
	/*
	 * DAO Function to get Leave type data by Id Model
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestLeaveRuleModel>> getLeaveRuleByIdModel(String id,String action) {
		logger.info("Method : getLeaveRuleById starts");
		List<RestLeaveRuleModel> mt = new ArrayList<RestLeaveRuleModel>();
		JsonResponse<RestLeaveRuleModel> resp = new JsonResponse<RestLeaveRuleModel>();
		try {
			String value = "SET @p_leaveId='" + id + "';";
			System.out.println(value + "   vvvvvvvvv"+action);
			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveRuleRoutines")
					.setParameter("actionType", action)
					.setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) { 
				RestLeaveRuleModel table = new RestLeaveRuleModel(m[0], m[1], m[2], m[3],m[4], m[5],m[6], m[7],m[8], m[9],m[10], m[11],m[12], m[13],m[14],m[15],m[16]);
				 
				mt.add(table);
			}
			resp.setBody(mt.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<RestLeaveRuleModel>> response = new ResponseEntity<JsonResponse<RestLeaveRuleModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : getLeaveRuleByIdModel ends");
		return response;
	}

	
	/*
	 * Drop down for job type list
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getJobTypeOnChange(String deptId) {

		logger.info("Method : getJobTypeOnChange starts");

		List<DropDownModel> UserRoleList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_deptId='" + deptId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveRuleRoutines")
					.setParameter("actionType", "getJobTypeOnChange").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				UserRoleList.add(dropDownModel);
			}

			resp.setBody(UserRoleList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getJobTypeOnChange ends");
		return response;
	}
	
	/*
	 * Drop down for employee list
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmployeeList(String jobTitleId) {

		logger.info("Method : getEmployeeList starts");

		List<DropDownModel> UserRoleList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_jobTitleId='" + jobTitleId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveRuleRoutines")
					.setParameter("actionType", "getEmployeeList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				UserRoleList.add(dropDownModel);
			}

			resp.setBody(UserRoleList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getEmployeeList ends");
		return response;
	}
	
	
	/*
	 * Drop down for employee list
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmploymentList(String empId) {

		logger.info("Method : getEmploymentList starts");

		List<DropDownModel> UserRoleList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_empId='" + empId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveRuleRoutines")
					.setParameter("actionType", "getEmploymentList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				UserRoleList.add(dropDownModel);
			}

			resp.setBody(UserRoleList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getEmploymentList ends");
		return response;
	}
	
}
