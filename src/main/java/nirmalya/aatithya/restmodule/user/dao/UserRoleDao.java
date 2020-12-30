/**
 * Defines User Role DAO
 *
 */
package nirmalya.aatithya.restmodule.user.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DataSetForActivity;
import nirmalya.aatithya.restmodule.common.utils.DataSetForFunction;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateUserRoleParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.user.model.UserRoleModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class UserRoleDao {

	Logger logger = LoggerFactory.getLogger(UserRoleDao.class);

	@Autowired
	ServerDao serverDao;
	@Autowired
	EntityManager em;

	/*
	 * 
	 * 
	 * get CostCenter drop down data
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCostCenterName(String getCostCenterName) {

		logger.info("Method : DAO getCostCenterName starts");

		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_CostCenterName=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("userroleRoutines")
					.setParameter("actionType", getCostCenterName).setParameter("actionValue", value).getResultList();

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

		logger.info("Method : DAO getCostCenterName ends");
		return response;
	}

	/*
	 * 
	 * 
	 * getParentName drop down data
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getParentName(String getParentName) {

		logger.info("Method : DAO getParentName starts");

		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_ParentName=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("userroleRoutines")
					.setParameter("actionType", getParentName).setParameter("actionValue", value).getResultList();

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

		logger.info("Method : DAO getParentName ends");
		return response;
	}

	/*
	 * 
	 * 
	 * getModuleName data
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getModuleDetails(String getModuleDetails) {

		logger.info("Method : DAO getModuleDetails starts");

		List<DropDownModel> DropDownModel = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_moduleName=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("userroleRoutines")
					.setParameter("actionType", getModuleDetails).setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel DropDownModelConstructor = new DropDownModel(m[0], m[1]);
				DropDownModel.add(DropDownModelConstructor);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setBody(DropDownModel);

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : DAO getModuleName ends");
		return response;
	}

	/*
	 * 
	 * 
	 * getModuleName data for edit which is checked
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getModuleCheckDtls(String getModuleCheckDtls, String id) {

		logger.info("Method : DAO getModuleCheckDtls starts");
		List<DropDownModel> DropDownModel = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_userroleId=" + id + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("userroleRoutines")
					.setParameter("actionType", getModuleCheckDtls).setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel DropDownModelConstructor = new DropDownModel(m[0], m[1]);
				DropDownModel.add(DropDownModelConstructor);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setBody(DropDownModel);

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : DAO getModuleCheckDtls ends");
		return response;
	}

	/*
	 * 
	 * 
	 * getModuleFuncName data for edit which is checked
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getFunctionCheckDtls(String getFunctionCheckDtls,
			String id) {

		logger.info("Method : DAO getFunctionCheckDtls starts");
		List<DropDownModel> DropDownModel = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_userroleId=" + id + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("userroleRoutines")
					.setParameter("actionType", getFunctionCheckDtls).setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel DropDownModelConstructor = new DropDownModel(m[0], m[1]);
				DropDownModel.add(DropDownModelConstructor);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setBody(DropDownModel);

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : DAO getFunctionCheckDtls ends");
		return response;
	}

	/*
	 * 
	 * 
	 * getActivityCheckDtls data for edit which is checked
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getActivityCheckDtls(String getActivityCheckDtls,
			String id) {

		logger.info("Method : DAO getActivityCheckDtls starts");
		List<DropDownModel> DropDownModel = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_userroleId=" + id + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("userroleRoutines")
					.setParameter("actionType", getActivityCheckDtls).setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel DropDownModelConstructor = new DropDownModel(m[0], m[1]);
				DropDownModel.add(DropDownModelConstructor);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setBody(DropDownModel);

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : DAO getActivityCheckDtls ends");
		return response;
	}

	/*
	 * 
	 * 
	 * getActivityDetails
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DataSetForActivity>>> getActivityDetails(String getActivityDetails) {

		logger.info("Method : DAO getActivityDetails starts");

		List<DataSetForActivity> DataSetForActivity = new ArrayList<DataSetForActivity>();

		try {
			String value = "SET @p_activityName=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("userroleRoutines")
					.setParameter("actionType", getActivityDetails).setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DataSetForActivity DataSetForActivityConstructor = new DataSetForActivity(m[0], m[1], m[2], m[3]);
				DataSetForActivity.add(DataSetForActivityConstructor);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<DataSetForActivity>> resp = new JsonResponse<List<DataSetForActivity>>();
		resp.setBody(DataSetForActivity);

		ResponseEntity<JsonResponse<List<DataSetForActivity>>> response = new ResponseEntity<JsonResponse<List<DataSetForActivity>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : DAO getActivityDetails ends");
		return response;
	}

	/*
	 * 
	 * 
	 * getfunctionDetails
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DataSetForFunction>>> getfunctionDetails(String getfunctionDetails) {

		logger.info("Method : DAO getfunctionDetails starts");

		List<DataSetForFunction> DataSetForFunction = new ArrayList<DataSetForFunction>();

		try {
			String value = "SET @p_functionName=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("userroleRoutines")
					.setParameter("actionType", getfunctionDetails).setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DataSetForFunction DataSetForFunctionConstructor = new DataSetForFunction(m[0], m[1], m[2]);
				DataSetForFunction.add(DataSetForFunctionConstructor);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<DataSetForFunction>> resp = new JsonResponse<List<DataSetForFunction>>();
		resp.setBody(DataSetForFunction);

		ResponseEntity<JsonResponse<List<DataSetForFunction>>> response = new ResponseEntity<JsonResponse<List<DataSetForFunction>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : DAO getfunctionDetails ends");
		return response;
	}

	/*
	 * 
	 * 
	 * AddUserRole
	 * 
	 * 
	 */
	public ResponseEntity<JsonResponse<Object>> addUserRole(List<UserRoleModel> table) {

		logger.info("Method : AddUserRole starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String userRoleId = "";
		for (UserRoleModel m : table) {

			if (m.getUserRoleName() == null || m.getUserRoleName() == "") {
				resp.setMessage("*UserRole name required");
				validity = false;
			} else if (m.getUserParentUserRole() == null || m.getUserParentUserRole() == "") {
				resp.setMessage("*Select Parent Type");
				validity = false;
			} else if (m.getUserCostCenter() == null) {
				resp.setMessage("*Select CostCenter");
				validity = false;
			} else if (m.getUserRoleStatus() == null) {
				resp.setMessage("*Select Status");
				validity = false;
			} else if (m.getUserDescription() == null) {
				resp.setMessage("*Description Required");
				validity = false;
			}
		}

		if (validity)
			try {

				String values = GenerateUserRoleParameter.getAddUserRoleParam(table);

				for (UserRoleModel i : table) {
					userRoleId = i.getUserRoleId();

				}
				if (userRoleId != null && userRoleId != "") {
					em.createNamedStoredProcedureQuery("userroleRoutines").setParameter("actionType", "modifyUserRole")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("userroleRoutines").setParameter("actionType", "addUserRole")
							.setParameter("actionValue", values).execute();

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

		logger.info("Method : AddUserRole ends");

		return response;
	}

	/**
	 * DAO Function to View all District data
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<UserRoleModel>>> getUserRoleDetails(DataTableRequest request) {

		logger.info("Method : getUserRoleDetails details starts");

		List<UserRoleModel> meal = new ArrayList<UserRoleModel>();
		String values = GenerateUserRoleParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("userroleRoutines")
					.setParameter("actionType", "viewUserData").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				UserRoleModel user = new UserRoleModel(m[0], m[1], m[2], m[3], m[4], m[5]);
				meal.add(user);
			}

			if (x.get(0).length > 6) {
				BigInteger t = (BigInteger) x.get(0)[6];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<UserRoleModel>> resp = new JsonResponse<List<UserRoleModel>>();
		resp.setBody(meal);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<UserRoleModel>>> response = new ResponseEntity<JsonResponse<List<UserRoleModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getUserRoleDetails ends");

		return response;
	}

	/*
	 * DAO Function to delete particular row from UserRole
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> deleteUserRoleById(String id) {
		// logger.info("Method : DAO deleteTableMasterById starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_userroleId=" + id + ";";

			em.createNamedStoredProcedureQuery("userroleRoutines").setParameter("actionType", "deleteUserRole")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();

			String[] err = serverDao.errorProcedureCall(e);

			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : DAO deleteUserRoleById ends");
		return response;
	}

	/*
	 * DAO Function to get UserRole data by Id
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<UserRoleModel>> getUserRoleById(String id, String action) {

		logger.info("Method : getUserRoleById starts");

		List<UserRoleModel> mt = new ArrayList<UserRoleModel>();
		JsonResponse<UserRoleModel> resp = new JsonResponse<UserRoleModel>();

		try {

			String value = "SET @p_userroleId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("userroleRoutines").setParameter("actionType", action)
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				UserRoleModel table = new UserRoleModel(m[0], m[1], m[2], m[3], m[4], m[5]);

				mt.add(table);
			}
			resp.setBody(mt.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<UserRoleModel>> response = new ResponseEntity<JsonResponse<UserRoleModel>>(resp,
				responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getUserRoleById ends");
		return response;
	}

}
