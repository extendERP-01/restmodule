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
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateUserTypeParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
//import nirmalya.aatithya.restmodule.common.utils.ServerValidation;
import nirmalya.aatithya.restmodule.user.model.UserTypeModel;

/**
 * @author Nirmalya Labs
 *
 */

@Repository
public class UserTypeDao {
	Logger logger = LoggerFactory.getLogger(UserTypeDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to add user type
	 *
	 */ 
	public ResponseEntity<JsonResponse<Object>> addUserType(UserTypeModel form) {
		logger.info("Method : addUserType starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (form.getUserTypeName() == null || form.getUserTypeName() == "") {
			resp.setMessage("UserTypeName  required");

			validity = false;

		} else if (form.getUserTypeDescrptn() == null || form.getUserTypeDescrptn() == "") {
			resp.setMessage("Description  required");
			validity = false;
		} else if (form.getCreatedBy() == null || form.getCreatedBy() == "") {
			// resp.setMessage("created by required");
			validity = false;

		} else if (form.getUserTypeActive() == null) {
			resp.setMessage("Status  required");
			validity = false;

		}

		if (validity)
			try {
				String values = GenerateUserTypeParameter.getAddUserTypeParam(form);

				if (form.getUserType() != null && form.getUserType() != "") {
					em.createNamedStoredProcedureQuery("UserType").setParameter("actionType", "modifyUserType")
							.setParameter("actionValue", values).execute();
				} else {

					em.createNamedStoredProcedureQuery("UserType").setParameter("actionType", "addUserType")
							.setParameter("actionValue", values).execute();
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
				try {
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

		logger.info("Method : addUserType end");
		return response;
	}

	/**
	 * DAO Function to view user type
	 *
	 */
	public ResponseEntity<JsonResponse<List<UserTypeModel>>> getAllUserTypes(DataTableRequest request) {
		logger.info("Method : getAllUserTypes starts");
		List<UserTypeModel> form = new ArrayList<UserTypeModel>();

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("UserType")
					.setParameter("actionType", "viewAlluserType").setParameter("actionValue", values).getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					UserTypeModel userType = new UserTypeModel(m[0], m[1], m[2], m[3]);
					form.add(userType);
				}

				if (x.get(0).length > 4) {
					BigInteger t = (BigInteger) x.get(0)[4];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonResponse<List<UserTypeModel>> resp = new JsonResponse<List<UserTypeModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<UserTypeModel>>> response = new ResponseEntity<JsonResponse<List<UserTypeModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getAllUserTypes end");
		return response;
	}

	/**
	 * DAO Function to delete user type
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteUserTypeById(String id, String createdBy) {
		logger.info("Method : deleteUserTypeById starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_userType='" + id + "',@p_createdBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("UserType").setParameter("actionType", "deleteUserType")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			String[] err = serverDao.errorProcedureCall(e);
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : deleteUserType end");
		return response;
	}

	/**
	 * DAO Function to edit user type
	 *
	 */
	public ResponseEntity<JsonResponse<UserTypeModel>> getUserTypeById(String id) {
		logger.info("Method : getUserTypeById starts");

		List<UserTypeModel> form = new ArrayList<UserTypeModel>();

		try {
			String value = "SET @p_userType='" + id + "';";

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("UserType").setParameter("actionType", "editUserType")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				UserTypeModel userType = new UserTypeModel(m[0], m[1], m[2], m[3]);
				form.add(userType);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<UserTypeModel> resp = new JsonResponse<UserTypeModel>();
		resp.setBody(form.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<UserTypeModel>> response = new ResponseEntity<JsonResponse<UserTypeModel>>(resp,
				responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getUserTypeById end");
		return response;

	}

}
