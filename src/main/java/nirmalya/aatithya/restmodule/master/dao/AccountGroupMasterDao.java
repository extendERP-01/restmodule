package nirmalya.aatithya.restmodule.master.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateAccountGroupMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter; 
import nirmalya.aatithya.restmodule.common.utils.JsonResponse; 
import nirmalya.aatithya.restmodule.master.model.AccountGroupMasterModel; 

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class AccountGroupMasterDao {
	Logger logger = LoggerFactory.getLogger(AccountGroupMasterDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	/**
	 * DAO Function to add account group master and edit
	 *
	 */ 
	public ResponseEntity<JsonResponse<Object>> addAccountGroup(AccountGroupMasterModel form) {
		logger.info("Method : addAccountGroup starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		/*if (form.getAccGroup() == null || form.getAccGroup() == "") {
			//resp.setMessage("Account Group Name required");
			validity = false;*/
		if (form.getAccGroupName() == null || form.getAccGroupName() == "") {
			resp.setMessage("Account Group Name required");
			validity = false;
		} else if (form.getAccGroupCode() == null || form.getAccGroupCode() == "") {
			resp.setMessage("Account group code required");
			validity = false;
		} else if (form.getAccGrupDescription() == null || form.getAccGrupDescription() == "") {
			resp.setMessage("Account group desciption required");
			validity = false;
		} else if (form.getAccGrupCreatedBy() == null || form.getAccGrupCreatedBy() == "") {
			//resp.setMessage("description required");
			validity = false;
		} else if (form.getAccGrupActive() == null) {
			resp.setMessage("status required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateAccountGroupMasterParameter.getAddAccountGroupParam(form);
				//System.out.println("+++++++++++++" + values);
				if (form.getAccGroup() != null && form.getAccGroup() != "") {
					em.createNamedStoredProcedureQuery("accountGroupRoutines")
							.setParameter("actionType", "modifyGrpAccount")
							.setParameter("actionValue", values).execute();
				} else {

					em.createNamedStoredProcedureQuery("accountGroupRoutines")
					.setParameter("actionType", "addGroupAcc")
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

		logger.info("Method : addPayment end");
		return response;
	}
	/**
	 * DAO Function to view payment mode
	 *
	 */
	public ResponseEntity<JsonResponse<List<AccountGroupMasterModel>>> getAllGroup(DataTableRequest request) {
		logger.info("Method : getAllGroup starts");
		List<AccountGroupMasterModel> form = new ArrayList<AccountGroupMasterModel>();

		String values = GenerateParameter.getSearchParam(request);
		//System.out.println("values are"+values);
		Integer total = 0;
		try {

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("accountGroupRoutines")
					.setParameter("actionType", "viewAllGroup").setParameter("actionValue", values).getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					AccountGroupMasterModel accountGroup = new AccountGroupMasterModel(m[0], m[1], m[2], m[3],m[4]);
					form.add(accountGroup);
				}

				if (x.get(0).length > 5) {
					BigInteger t = (BigInteger) x.get(0)[5];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonResponse<List<AccountGroupMasterModel>> resp = new JsonResponse<List<AccountGroupMasterModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AccountGroupMasterModel>>> response = new ResponseEntity<JsonResponse<List<AccountGroupMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getAllGroup end");
		//System.out.println("response in dao"+response);
		return response;
		
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<AccountGroupMasterModel>> getAccountGroupById(String id, String action) {
		logger.info("Method : getAccountGroupById starts");

		List<AccountGroupMasterModel> form = new ArrayList<AccountGroupMasterModel>();

		try {
			String value = "SET @p_accgroupId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("accountGroupRoutines").setParameter("actionType", action)
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				AccountGroupMasterModel accountGroup = new AccountGroupMasterModel(m[0], m[1], m[2], m[3],m[4]);
				form.add(accountGroup);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<AccountGroupMasterModel> resp = new JsonResponse<AccountGroupMasterModel>();
		resp.setBody(form.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<AccountGroupMasterModel>> response = new ResponseEntity<JsonResponse<AccountGroupMasterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getAccountGroupById end");
		return response;

	}
	/**
	 * DAO Function to delete account group master
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteAccountGroup(String id,String createdBy) {
		logger.info("Method : deleteAccountGroup dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_accgroupId='" + id + "',@p_accCreatedBy='" + createdBy +"';";
			//System.out.println(value);
			em.createNamedStoredProcedureQuery("accountGroupRoutines")
			.setParameter("actionType", "deleteGroup")
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

		logger.info("Method : deleteAccountGroup dao end");
		return response;
	}
}
