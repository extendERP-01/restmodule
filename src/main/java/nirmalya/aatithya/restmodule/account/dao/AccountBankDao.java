/**
 * 
 */
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

import nirmalya.aatithya.restmodule.account.model.AccountBankModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.GenerateAccountBankParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class AccountBankDao {
	
	Logger logger = LoggerFactory.getLogger(AccountBankDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	EntityManager em;
	
	
	/**
	 * Submit Add Bank Details
	 */
		public ResponseEntity<JsonResponse<Object>> restSubmitBankDetails(AccountBankModel form) {
			logger.info("Method : AccountBankDao restSubmitBankDetails starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (form.getBankName() == null || form.getBankName() == "") {
				resp.setMessage("Bank Name Required");
				validity = false;
			} else if (form.getBankDescription() == null || form.getBankDescription() == "") {
				resp.setMessage("Description Required");
				validity = false;
			} else if (form.getBankActive() == null) {
				resp.setMessage("Status Required");
				validity = false;
			}

			if (validity)
				try {
					String values = GenerateAccountBankParameter.getAddBankParam(form);
					if (form.getBank() != "") {
						em.createNamedStoredProcedureQuery("AccountBankRoutines")
								.setParameter("actionType", "updateAccountBank")
								.setParameter("actionValue", values)
								.execute();
					} else {
						em.createNamedStoredProcedureQuery("AccountBankRoutines")
								.setParameter("actionType", "insertAccountBank")
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
			logger.info("Method : AccountBankDao restSubmitBankDetails end");
			return response;
		}
		
		
		/**
		 * View Bank Details Ajax
		 */

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<AccountBankModel>>> restViewBankThroughAjax(DataTableRequest request) {
			logger.info("Method : AccountBankDao restViewBankThroughAjax starts");
			List<AccountBankModel> form = new ArrayList<AccountBankModel>();

			String values = GenerateParameter.getSearchParam(request);
			Integer total = 0;

			try {

				List<Object[]> x = em.createNamedStoredProcedureQuery("AccountBankRoutines")
						.setParameter("actionType", "viewAllBankDetails").setParameter("actionValue", values).getResultList();

				for (Object[] m : x) {
					AccountBankModel addUserType = new AccountBankModel(m[0], m[1], m[2], m[3]);
					form.add(addUserType);
				}

				if (x.get(0).length > 4) {
					BigInteger t = (BigInteger) x.get(0)[4];

					total = Integer.parseInt((t.toString()));
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			JsonResponse<List<AccountBankModel>> resp = new JsonResponse<List<AccountBankModel>>();
			resp.setBody(form);
			resp.setTotal(total);

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");
			ResponseEntity<JsonResponse<List<AccountBankModel>>> response = new ResponseEntity<JsonResponse<List<AccountBankModel>>>(
					resp, responseHeaders, HttpStatus.CREATED);
			logger.info("Method : AccountBankDao restViewBankThroughAjax end");
			return response;
		}

		/**
		 * Delete Bank Record
		 */

		public ResponseEntity<JsonResponse<Object>> restDeleteBankDeatils(String id) {
			logger.info("Method : AccountBankDao restDeleteBankDeatils starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			try {

				String value = "SET @p_bank='" + id + "';";
				em.createNamedStoredProcedureQuery("AccountBankRoutines")
						.setParameter("actionType", "deleteBankRecord").setParameter("actionValue", value).execute();

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
			logger.info("Method : AccountBankDao restDeleteBankDeatils end");
			return response;
		}

		/**
		 * Edit Account Bank Details
		 */

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<AccountBankModel>> restEditBankDetails(String id) {
			logger.info("Method : AccountBankDao restEditBankDetails starts");
			List<AccountBankModel> form = new ArrayList<AccountBankModel>();

			try {
				String value = "SET @p_bank='" + id + "';";
				
				System.out.println("valuewdit>>>"+value);

				List<Object[]> x = em.createNamedStoredProcedureQuery("AccountBankRoutines")
						.setParameter("actionType", "editBankRecord").setParameter("actionValue", value)
						.getResultList();

				for (Object[] m : x) {
					AccountBankModel addUserType = new AccountBankModel(m[0], m[1], m[2], m[3]);
					form.add(addUserType);
				}

			} catch (Exception e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}
			JsonResponse<AccountBankModel> resp = new JsonResponse<AccountBankModel>();
			resp.setBody(form.get(0));

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");

			ResponseEntity<JsonResponse<AccountBankModel>> response = new ResponseEntity<JsonResponse<AccountBankModel>>(resp,
					responseHeaders, HttpStatus.CREATED);
			logger.info("Method : AccountBankDao restEditBankDetails end");
			return response;
		}


}
