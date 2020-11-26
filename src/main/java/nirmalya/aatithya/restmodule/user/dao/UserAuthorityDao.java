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
import nirmalya.aatithya.restmodule.common.utils.GenerateSetAuthorityParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.user.model.UserSetAuthority;

/**
 * @author Nirmalya Labs
 *
 */

@Repository
public class UserAuthorityDao {
	Logger logger = LoggerFactory.getLogger(UserAuthorityDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to Add set authority
	 */
	public ResponseEntity<JsonResponse<Object>> addSetAuthority(List<UserSetAuthority> setAuthority) {
		logger.info("Method : addSetAuthority starts");
		@SuppressWarnings("unused")
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (UserSetAuthority l : setAuthority) {
			if (l.getProcess() == null || l.getProcess() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please select process Name");
				break;
			} else if (l.getUserRole() == null || l.getUserRole() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter user Role.");
				break;
			} else if (l.getUser() == null || l.getUser() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select user.");
				break;
			} else if (l.getTat() == null || l.getTat() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please enter turn around time.");
				break;
			}
		}
		if (validation) {
			try {
				String values = GenerateSetAuthorityParameter.getAddSetAuthorityParam(setAuthority);
				System.out.println("value: "+values);
				if (setAuthority.get(0).getIsEdit() != null && setAuthority.get(0).getIsEdit() != "") {
					em.createNamedStoredProcedureQuery("UserSetAuthority")
							.setParameter("actionType", "modifySetAuthority").setParameter("actionValue", values)
							.execute();
				} else {
					//
					em.createNamedStoredProcedureQuery("UserSetAuthority").setParameter("actionType", "addSetAuthority")
							.setParameter("actionValue", values).execute();
				}
				resp.setCode("Data Saved Successfully");
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
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addSetAuthority ends");
		return response;
	}

	/**
	 * DAO Function for drop down models of user process
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getProcess() {
		logger.info("Method : getProcess starts");
		List<DropDownModel> processList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("userAuthoritydropdown")
					.setParameter("actionType", "getProcess").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				processList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getProcess end");
		return processList;
	}

	/**
	 * DAO Function for drop down models of user role
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getUserRole() {
		logger.info("Method : getUserRole starts");
		List<DropDownModel> userRoleList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("userAuthoritydropdown")
					.setParameter("actionType", "getUserRole").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				userRoleList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getUserRole end");
		return userRoleList;
	}

	/**
	 * onchange function for user name from user role
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getUserNameFromUserRole(String id) {
		logger.info("Method : getUserNameFromUserRole starts");
		List<DropDownModel> userListName = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_userRole='" + id + "';";
		System.out.println("value: "+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("userAuthoritydropdown")
					.setParameter("actionType", "userName").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				userListName.add(dropDownModel);
			}

			resp.setBody(userListName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getUserNameFromUserRole ends");

		return response;
	}

	/**
	 * DAO Function for drop down models of user
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getUserData() {
		logger.info("Method : getUserData starts");
		List<DropDownModel> userdataList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("userAuthoritydropdown")
					.setParameter("actionType", "getUserData").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				userdataList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getUserData end");
		return userdataList;
	}

	/**
	 * DAO Function for drop down models of approval action
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getApproval() {
		logger.info("Method : getApproval starts");
		List<DropDownModel> approvalList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("userAuthoritydropdown")
					.setParameter("actionType", "getApproval").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				approvalList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getApproval end");
		return approvalList;
	}

	/**
	 * DAO Function to view set authority
	 *
	 */
	public ResponseEntity<JsonResponse<List<UserSetAuthority>>> getAllSetAuthority(DataTableRequest request) {
		logger.info("Method : getAllSetAuthority starts");
		List<UserSetAuthority> form = new ArrayList<UserSetAuthority>();

		String values = GenerateParameter.getSearchParam(request);

		Integer total = 0;
		try {

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("UserSetAuthority")
					.setParameter("actionType", "viewAllAuthority").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				UserSetAuthority setAuthority = new UserSetAuthority(m[0], m[1], m[2], null, m[3], m[4], m[5], null);
				form.add(setAuthority);
			}

			if (x.get(0).length > 6) {
				BigInteger t = (BigInteger) x.get(0)[6];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonResponse<List<UserSetAuthority>> resp = new JsonResponse<List<UserSetAuthority>>();
		resp.setBody(form);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<UserSetAuthority>>> response = new ResponseEntity<JsonResponse<List<UserSetAuthority>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getAlluserAuthority end");

		return response;
	}

	/**
	 * Dao function for edit user set authority
	 */
	@SuppressWarnings("unchecked")
	public List<UserSetAuthority> getSetAuthorityById(String id) {
		logger.info("Method : getSetAuthorityById starts");

		List<UserSetAuthority> form = new ArrayList<UserSetAuthority>();
		String value = "SET @p_processId='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("UserSetAuthority")
					.setParameter("actionType", "editSetAuthority").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				UserSetAuthority setAuthority = new UserSetAuthority(m[0], m[1], m[2], null, m[3], m[4], null, "2");
				form.add(setAuthority);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getSetAuthorityById ends");

		return form;
	}

	/**
	 * Dao function for edit user list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getUserEditList(String id) {

		List<DropDownModel> userList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_userRole='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("userAuthoritydropdown")
					.setParameter("actionType", "userNameEdit").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				userList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;
	}

	/**
	 * Dao function for drop down of selected users
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> selectedUserList(String id, String catId) {

		List<DropDownModel> selectedList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_process='" + id + "',@p_userRole='" + catId + "';";
			System.out.println("value: "+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("userAuthoritydropdown")
					.setParameter("actionType", "selctUser").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				selectedList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return selectedList;
	}

	/**
	 * DAO Function to model view of set authority
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<UserSetAuthority>>> getSetAuthorityByIdModel(String id) {
		logger.info("Method : getSetAuthorityByIdModel starts");

		List<UserSetAuthority> form = new ArrayList<UserSetAuthority>();
		JsonResponse<List<UserSetAuthority>> resp = new JsonResponse<List<UserSetAuthority>>();
		try {

			String value = "SET @p_processId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("UserSetAuthority")
					.setParameter("actionType", "modelSetAuthority").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				UserSetAuthority setAuthority = new UserSetAuthority(m[0], m[1], m[2], null, m[3], m[4], m[5], "2");
				form.add(setAuthority);
			}

			resp.setBody(form);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<UserSetAuthority>>> response = new ResponseEntity<JsonResponse<List<UserSetAuthority>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getSetAuthorityByIdModel ends");

		return response;
	}
}
