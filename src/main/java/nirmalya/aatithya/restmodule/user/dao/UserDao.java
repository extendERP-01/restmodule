/**
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
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateUserParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse; 
import nirmalya.aatithya.restmodule.user.model.UserModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class UserDao {

	Logger logger = LoggerFactory.getLogger(UserDao.class);
	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	
	
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("userManageRoutines")
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
		System.out.println("responsepdf>>>" + response);
		logger.info("Method : DAO getCountryName ends");	
		return response;
	}
	
	

	/**
	 * USER ROLE DATA
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getUserRoleData() {
		logger.info("Method : RESTMODULE UserDao getUserRoleData starts");

		List<DropDownModel> UserRole = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("userManageRoutines")
					.setParameter("actionType", "getUserRoleList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				UserRole.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : RESTMODULE UserDao getUserRoleData ends");
		System.out.println("responsepdf>>>" + UserRole);
		return UserRole;
	}

	/**
	 * USER type list
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> userTypeList() {
		logger.info("Method : RESTMODULE UserDao getUsertype starts");

		List<DropDownModel> UserRole = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("userManageRoutines")
					.setParameter("actionType", "getUserTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				UserRole.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : RESTMODULE UserDao getUserRoleData ends");

		return UserRole;
	}

	/**
	 * ADD UPDATE USER
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> addUserDataList(UserModel form) {
		logger.info("Method : RESTMODULE UserDao addUserDataList starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (form.getUserName() == null || form.getUserName() == "") {
			resp.setMessage("User First Name Required");
			validity = false;

		} else if (form.getUserLname() == null || form.getUserLname() == "") {
			resp.setMessage("User Last Name Required");
			validity = false;
		} else if (form.getUserPassword() == null || form.getUserPassword() == "") {
			resp.setMessage("User Password Required");
			validity = false;
		} else if (form.getUserPINno() == null || form.getUserPINno() == "") {
			resp.setMessage("User PIN No Required");
			validity = false;
		} else if (form.getUserIMEI() == null || form.getUserIMEI() == "") {
			resp.setMessage("IMEI Number Required");
			validity = false;
		} else if (form.getUserMobile() == null || form.getUserMobile() == "") {
			resp.setMessage("Mobile No Required");
			validity = false;
		} else if (form.getUserEmail() == null || form.getUserEmail() == "") {
			resp.setMessage("Email Required");
			validity = false;
		} else if (form.getUserCountry() == null || form.getUserCountry() == "") {
			resp.setMessage("Country Required");
			validity = false;
		} else if (form.getUserState() == null || form.getUserState() == "") {
			resp.setMessage("State Required");
			validity = false;
		} else if (form.getUserDist() == null || form.getUserDist() == "") {
			resp.setMessage("District Required");
			validity = false;
		} else if (form.getUserPin() == null || form.getUserPin() == "") {
			resp.setMessage("PIN Required");
			validity = false;
		} else if (form.getUserAddress() == null || form.getUserAddress() == "") {
			resp.setMessage("Address Required");
			validity = false;
		} else if (form.getUserStatus() == null) {
			resp.setMessage("Status Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateUserParameter.getAddUserParam(form);
			//	System.out.println("values>>>>>" + values);
				if (form.getUser() != "") {

					em.createNamedStoredProcedureQuery("userManageRoutines")
							.setParameter("actionType", "updateUserData").setParameter("actionValue", values).execute();
				} else {

					em.createNamedStoredProcedureQuery("userManageRoutines").setParameter("actionType", "saveAddUser")
							.setParameter("actionValue", values).execute();
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
				try {
					//String[] err = ServerValidation.geterror(e);
					String[] err = serverDao.errorProcedureCall(e);

					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : RESTMODULE UserDao addUserDataList end");
		System.out.println("responsepdf>>>" + response);
		return response;
	}

	/**
	 * VIEW USER
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<UserModel>>> getAllUserList(DataTableRequest request) {
		logger.info("Method : RESTMODULE UserDao getAllUserList starts");
		List<UserModel> form = new ArrayList<UserModel>();

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("userManageRoutines")
					.setParameter("actionType", "viewAllUserList").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				UserModel addUserList = new UserModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], null,
						null, null, m[10], m[11], m[12], m[13], null, m[14], null);
				form.add(addUserList);
			}

			if (x.get(0).length > 15) {
				BigInteger t = (BigInteger) x.get(0)[15];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<UserModel>> resp = new JsonResponse<List<UserModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<UserModel>>> response = new ResponseEntity<JsonResponse<List<UserModel>>>(resp,
				responseHeaders, HttpStatus.CREATED);
		logger.info("Method : RESTMODULE UserDao getAllUserList end");
		System.out.println("responsepdf>>>" + response);
		return response;
	}

	/**
	 * EDIT USER
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<UserModel>> getUserByIdData(String id) {
		logger.info("Method : RESTMODULE UserDao getUserByIdData starts");

		List<UserModel> form = new ArrayList<UserModel>();

		try {
			String value = "SET @p_user='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("userManageRoutines")
					.setParameter("actionType", "editUserData").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				UserModel addUserData = new UserModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10],
						m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], null);

				form.add(addUserData);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<UserModel> resp = new JsonResponse<UserModel>();
		resp.setBody(form.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<UserModel>> response = new ResponseEntity<JsonResponse<UserModel>>(resp,
				responseHeaders, HttpStatus.CREATED);
		logger.info("Method : RESTMODULE UserDao getUserByIdData end");
		System.out.println("qsdsadsadsad : "+response);
		return response;
		
	}
	
	
	
	/**
	 * Model view
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<UserModel>> restGetModelById(String id) {
		logger.info("Method : RESTMODULE UserDao restGetModelById starts");

		List<UserModel> form = new ArrayList<UserModel>();

		try {
			String value = "SET @p_user='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("userManageRoutines")
					.setParameter("actionType", "ModelView").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				UserModel addUserData = new UserModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10],
						m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], null);

				form.add(addUserData);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<UserModel> resp = new JsonResponse<UserModel>();
		resp.setBody(form.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<UserModel>> response = new ResponseEntity<JsonResponse<UserModel>>(resp,
				responseHeaders, HttpStatus.CREATED);
		logger.info("Method : RESTMODULE UserDao restGetModelById end");
		System.out.println("qsdsadsadsad : "+response);
		return response;
	}

	/**
	 * DELETE USER
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteUserData(String id) {
		logger.info("Method : RESTMODULE UserDao deleteUserData starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_user='" + id + "';";
			em.createNamedStoredProcedureQuery("userManageRoutines").setParameter("actionType", "deleteUserData")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			//String[] err = ServerValidation.geterror(e);
			String[] err = serverDao.errorProcedureCall(e);

			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method : RESTMODULE UserDao deleteUserData end");
		System.out.println("qsdsadsadsad : "+response);
		return response;
	}

	/**
	 * ONCHANGE DATA STATE TO DISTRICT
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDistListById(String proCatId) {
		logger.info("Method : UserDao getDistListById starts");

		List<DropDownModel> distNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_stateId='" + proCatId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("userManageRoutines")
					.setParameter("actionType", "getDistrictNameListData").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				distNameList.add(dropDownModel);
			}

			resp.setBody(distNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : UserDao getDistListById ends");
		return response;
	}

	
	/**
	 * ONCHANGE DATA STATE TO DISTRICT
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateName1(String id) {
		logger.info("Method : UserDao getStateName1 starts");

		List<DropDownModel> stateNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_cntId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("userManageRoutines")
					.setParameter("actionType", "getStateCIdData").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateNameList.add(dropDownModel);
			}

			resp.setBody(stateNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : UserDao getCountryName1 ends");
		return response;
	}
	
	
	/**
	 * ONCHANGE DATA STATE TO DISTRICT
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDistName1(String id) {
		logger.info("Method : UserDao getDistName1 starts");

		List<DropDownModel> distNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_stId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("userManageRoutines")
					.setParameter("actionType", "getdistStIdData").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				distNameList.add(dropDownModel);
			}

			resp.setBody(distNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : UserDao getDistName1 ends");
		return response;
	}

	
	/**
	 * ONCHANGE DATA STATE TO DISTRICT
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateListByCatId(String proCatId) {
		logger.info("Method : UserDao getStateListByCatId starts");

		List<DropDownModel> distNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_countId='" + proCatId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("userManageRoutines")
					.setParameter("actionType", "getStateListByCatId").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				distNameList.add(dropDownModel);
			}

			resp.setBody(distNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : UserDao getStateListByCatId ends");
		return response;
	}
	
	
	
	/**
	 * ONCHANGE DATA STATE TO DISTRICT
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateByCntId(String proCatId) {
		logger.info("Method : UserDao getStateByCntId starts");

		List<DropDownModel> distNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_countId='" + proCatId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("userManageRoutines")
					.setParameter("actionType", "getStateByCntId").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				distNameList.add(dropDownModel);
			}

			resp.setBody(distNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : UserDao getStateByCntId ends");
		return response;
	}
	/**
	 * VIEW STAFF USER PDF
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<UserModel>>> getAllFoodOrderDataPdf(DataTableRequest request) {
		logger.info("Method : RESTMODULE UserDao getAllFoodOrderDataPdf starts");
		List<UserModel> form = new ArrayList<UserModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("userManageRoutines")
					.setParameter("actionType", "viewAllUserListPdf").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				UserModel foodOrderList = new UserModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], null, null,
						null, null, null, m[8], m[9], null, m[10], null, null, null);
				form.add(foodOrderList);
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<UserModel>> resp = new JsonResponse<List<UserModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<UserModel>>> response = new ResponseEntity<JsonResponse<List<UserModel>>>(resp,
				responseHeaders, HttpStatus.CREATED);
		//System.out.println("responsepdf>>>" + response);
		logger.info("Method : RESTMODULE UserDao getAllFoodOrderDataPdf end");
		return response;
	}

}
