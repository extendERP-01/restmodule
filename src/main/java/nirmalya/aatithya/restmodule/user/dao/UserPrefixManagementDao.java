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

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateUserPrefixParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.ServerValidation;
import nirmalya.aatithya.restmodule.user.model.UserPrefixManagementModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class UserPrefixManagementDao {

	Logger logger = LoggerFactory.getLogger(UserPrefixManagementDao.class);
	@Autowired
	EntityManager em;

	/**
	 * VIEW USER PREFIX
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<UserPrefixManagementModel>>> getAllUserPrefixList(
			DataTableRequest request) {
		logger.info("Method : REST MODULE UserPrefixManagementDao getAllUserPrefixList starts");
		List<UserPrefixManagementModel> form = new ArrayList<UserPrefixManagementModel>();

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("userPrefixManagementRoutines")
					.setParameter("actionType", "viewAllPrefix").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				UserPrefixManagementModel addLaundryItem = new UserPrefixManagementModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6]);
				form.add(addLaundryItem);
			}

			if (x.get(0).length > 7) {
				BigInteger t = (BigInteger) x.get(0)[7];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<UserPrefixManagementModel>> resp = new JsonResponse<List<UserPrefixManagementModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<UserPrefixManagementModel>>> response = new ResponseEntity<JsonResponse<List<UserPrefixManagementModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : REST MODULE UserPrefixManagementDao getAllUserPrefixList end");
		return response;
	}

	/**
	 * EDIT LAUNDRY ITEM
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<UserPrefixManagementModel>> getUserPrefixByIdList(String id) {
		logger.info("Method : REST MODULE UserPrefixManagementDao getUserPrefixByIdList starts");
		List<UserPrefixManagementModel> form = new ArrayList<UserPrefixManagementModel>();
		try {
			String value = "SET @p_prefix='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("userPrefixManagementRoutines")
					.setParameter("actionType", "editUserPrefix").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				UserPrefixManagementModel addPrefix = new UserPrefixManagementModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6]);
				form.add(addPrefix);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonResponse<UserPrefixManagementModel> resp = new JsonResponse<UserPrefixManagementModel>();
		resp.setBody(form.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<UserPrefixManagementModel>> response = new ResponseEntity<JsonResponse<UserPrefixManagementModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : REST MODULE UserPrefixManagementDao getUserPrefixByIdList end");
		return response;
	}

	/**
	 * DELETE USER PREFIX
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteUserPrefixData(String id) {
		logger.info("Method : REST MODULE UserPrefixManagementDao deleteUserPrefixData starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_prefix='" + id + "';";
			em.createNamedStoredProcedureQuery("userPrefixManagementRoutines")
					.setParameter("actionType", "deleteUserPrefix").setParameter("actionValue", value).execute();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			String[] err = ServerValidation.geterror(e);

			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method : REST MODULE UserPrefixManagementDao deleteUserPrefixData end");
		return response;
	}

	/**
	 * UPDATE CODE USER PREFIX
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> updateUserPrefix(UserPrefixManagementModel form) {
		logger.info("Method : REST MODULE UserPrefixManagementDao updateUserPrefix starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (form.getPrfxCode() == null || form.getPrfxCode() == "") {
			resp.setMessage("Prefix Code Required");
			validity = false;
		} else if (form.getPrfxNumberLength() == null) {
			resp.setMessage("Number Length Required");
			validity = false;
		} else if (form.getPrfxStartNo() == null) {
			resp.setMessage("Start Number Required");
			validity = false;
		} else if (form.getPrfxFinYearStatus() == null) {
			resp.setMessage("Add Financial Year Required");
			validity = false;
		} else if (form.getPrfxActive() == null) {
			resp.setMessage("Status Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateUserPrefixParameter.getupdateUserPrefixParam(form);
				if (form.getPrefix()!=null ) {

					em.createNamedStoredProcedureQuery("userPrefixManagementRoutines")
							.setParameter("actionType", "updateUserPrefix")
							.setParameter("actionValue", values)
							.execute();
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
				try {
					String[] err = ServerValidation.geterror(e);

					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : REST MODULE UserPrefixManagementDao updateUserPrefix end");
		return response;
	}
}
