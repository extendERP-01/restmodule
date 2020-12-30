package nirmalya.aatithya.restmodule.account.dao;

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

import nirmalya.aatithya.restmodule.account.model.AccountHeadTypeModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.GenerateAccountHeadTypeParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
@Repository
public class AccountHeadTypeDao {

	Logger logger = LoggerFactory.getLogger(AccountHeadTypeDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for all account head details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountHeadTypeModel>>> getAllAccountHead(DataTableRequest request) {

		logger.info("Method in Dao: getAllAccountHead starts");

		List<AccountHeadTypeModel> listAccountHeadTypeModel = new ArrayList<AccountHeadTypeModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("accountHead")
					.setParameter("actionType", "viewAccountHead").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					AccountHeadTypeModel thame = new AccountHeadTypeModel(m[0], m[1], m[2], m[3]);
					listAccountHeadTypeModel.add(thame);

				}

				if (x.get(0).length > 4) {
					BigInteger t = (BigInteger) x.get(0)[4];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<AccountHeadTypeModel>> resp = new JsonResponse<List<AccountHeadTypeModel>>();
		resp.setBody(listAccountHeadTypeModel);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AccountHeadTypeModel>>> response = new ResponseEntity<JsonResponse<List<AccountHeadTypeModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getAllAccountHead ends");

		return response;
	}

	/*
	 * for add new account head
	 */
	public ResponseEntity<JsonResponse<Object>> restAddAccountHead(AccountHeadTypeModel accountHeadTypeModel) {

		logger.info("Method in Dao: restAddAccountHead starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (accountHeadTypeModel.getAccountHeadType() == null || accountHeadTypeModel.getAccountHeadType() == "") {
			resp.setMessage("Acccount Head Type required");
			validity = false;
		} else if (accountHeadTypeModel.getDesc() == null || accountHeadTypeModel.getDesc()== "") {
			resp.setMessage("Description required");
			validity = false;
		} else if (accountHeadTypeModel.getStatus() == null) {
			resp.setMessage("Account head Status  required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateAccountHeadTypeParameter.getAddAccountHeadParam(accountHeadTypeModel);
			
				if (accountHeadTypeModel.getAccountHeadTypeId().isEmpty()  || accountHeadTypeModel.getAccountHeadTypeId()==null) {
				
					em.createNamedStoredProcedureQuery("accountHead").setParameter("actionType", "addAccountHead")
							.setParameter("actionValue", values).execute();
				} else {
					
					em.createNamedStoredProcedureQuery("accountHead").setParameter("actionType", "modifyAccountHead")
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

		logger.info("Method in Dao: restAddAccountHead ends");

		return response;
	}

	/*
	 * for edit account head
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<AccountHeadTypeModel>> getAccountById(String id) {

		logger.info("Method in Dao: getAccountById ends");

		List<AccountHeadTypeModel> listAccountHeadTypeModel = new ArrayList<AccountHeadTypeModel>();

		try {

			String value = "SET @p_headId1R='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("accountHead")
					.setParameter("actionType", "viewAccountHeadById").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				AccountHeadTypeModel theme = new AccountHeadTypeModel(m[0], m[1], m[2], m[3]);

				listAccountHeadTypeModel.add(theme);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<AccountHeadTypeModel> resp = new JsonResponse<AccountHeadTypeModel>();
		resp.setBody(listAccountHeadTypeModel.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<AccountHeadTypeModel>> response = new ResponseEntity<JsonResponse<AccountHeadTypeModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getAccountById ends");

		return response;
	}

	/*
	 * for delete account head
	 */
	public ResponseEntity<JsonResponse<Object>> deleteAccountById(String id, String createdBy) {

		logger.info("Method in Dao: deleteAccountById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_headId='" + id + "',@P_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("accountHead").setParameter("actionType", "deleteAccountHead")
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

		logger.info("Method in Dao: deleteAccountById ends");

		return response;
	}
	

}
