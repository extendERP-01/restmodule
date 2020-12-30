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

import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel; 
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest; 
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAccountJournalVoucherParameter; 
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse; 

/**
 * @author USER
 *
 */
@Repository
public class AccountJournalVoucherDao {
	Logger logger = (Logger) LoggerFactory.getLogger(AccountJournalVoucherDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to view particular account sub group
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> getinvsubGroupPayment(String id) {
		logger.info("Method : getinvsubGroupPayment starts");
		List<AccountJournalVoucherModel> itemNameList = new ArrayList<AccountJournalVoucherModel>();
		JsonResponse<List<AccountJournalVoucherModel>> resp = new JsonResponse<List<AccountJournalVoucherModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("invjournalvoucherPaymentRoutines")
					.setParameter("actionType", "debitSubGroup").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				AccountJournalVoucherModel dropDownModel = new AccountJournalVoucherModel(m[0], m[1],
						m[2], m[3], null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> response = new ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getinvsubGroupPayment ends");
		System.out.println(response);
		return response;
	}

	/**
	 * DAO Function to Add Issue Note in inventory
	 */
	public ResponseEntity<JsonResponse<Object>> saveJournalVoucher(
			List<AccountJournalVoucherModel> journalVoucherModel) {
		logger.info("Method : saveJournalVoucher starts");
		@SuppressWarnings("unused")
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		for (AccountJournalVoucherModel l : journalVoucherModel) {
			if (l.getCostCenter()== null || l.getCostCenter() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Cost Center.");
				break;
			} else if (l.getDescription() == null || l.getDescription() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Description.");
				break;
			} 
		}

		if (validation) {

			try {
				String value = GenerateAccountJournalVoucherParameter.saveJournalVoucherParam(journalVoucherModel);

				/*
				 * if (journalVoucherModel.get(0).getJournalVoucher() != null &&
				 * journalVoucherModel.get(0).getJournalVoucher() != "") {
				 * em.createNamedStoredProcedureQuery("invjournalvoucherPaymentRoutines")
				 * .setParameter("actionType", "modifyIssueNote").setParameter("actionValue",
				 * value).execute(); } else {
				 */
				em.createNamedStoredProcedureQuery("invjournalvoucherPaymentRoutines")
						.setParameter("actionType", "addJournalVoucher").setParameter("actionValue", value).execute();
				// }
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
		logger.info("Method : saveJournalVoucher ends");
		return response;
	}

	/*
	 * for view all journal voucher
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> getAllJournalVoucher(
			DataTableRequest request) {

		logger.info("Method in Dao: getAllJournalVoucher starts");

		List<AccountJournalVoucherModel> listAccountJournalVoucherModel = new ArrayList<AccountJournalVoucherModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("invjournalvoucherPaymentRoutines")
					.setParameter("actionType", "viewJournalVoucher").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {

				for (Object[] m : x) {

					AccountJournalVoucherModel voucher = new AccountJournalVoucherModel(m[0], m[1], m[2],
							null, null, m[3], null, null, null, null, null, null, null, null, m[4], null, null, null,
							m[5]);
					listAccountJournalVoucherModel.add(voucher);

				}

				if (x.get(0).length > 6) {
					BigInteger t = (BigInteger) x.get(0)[6];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<AccountJournalVoucherModel>> resp = new JsonResponse<List<AccountJournalVoucherModel>>();
		resp.setBody(listAccountJournalVoucherModel);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> response = new ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getAllJournalVoucher ends");
		System.out.println(response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> modelView(String id) {

		logger.info("Method : modelView starts");
		List<AccountJournalVoucherModel> mt = new ArrayList<AccountJournalVoucherModel>();
		JsonResponse<List<AccountJournalVoucherModel>> resp = new JsonResponse<List<AccountJournalVoucherModel>>();
		try {
			String value = "SET @p_journalVoucher='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("invjournalvoucherPaymentRoutines")
					.setParameter("actionType", "viewJVById").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				AccountJournalVoucherModel itemRequisition = new AccountJournalVoucherModel(m[0], m[1],
						m[2], m[3], m[4], m[5], null, null, m[6], null, null, null, null, m[7], m[8], null, null, null,
						m[9]);

				mt.add(itemRequisition);
			}
			resp.setBody(mt);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> response = new ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : modelView ends");
		System.out.println(response);
		return response;
	}

	/**
	 * DAO Function to get All ItemRequisition in inventory to be approve
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> getAllJVApprove(
			DataTableRequest request) {
		logger.info("Method : getAllJVApprove starts");

		List<AccountJournalVoucherModel> restItemRequisitonModel = new ArrayList<AccountJournalVoucherModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		System.out.println(values);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("invjournalvoucherPaymentRoutines")
					.setParameter("actionType", "JVToApprove").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					m[5] = Integer.valueOf(((BigInteger) m[5]).toString());
					m[7] = Integer.valueOf(((BigInteger) m[7]).toString());
					AccountJournalVoucherModel voucher = new AccountJournalVoucherModel(m[0], m[1], m[2],
							null, null, m[3], null, null, null, null, null, null, null, null, m[4], m[5], m[6], m[7],
							m[8]);
					restItemRequisitonModel.add(voucher);
				}

				if (x.get(0).length > 9) {
					BigInteger t = (BigInteger) x.get(0)[9];

					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<AccountJournalVoucherModel>> resp = new JsonResponse<List<AccountJournalVoucherModel>>();
		resp.setBody(restItemRequisitonModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> response = new ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println(response);
		logger.info("Method : getAllJVApprove ends");
		return response;
	}

	/**
	 * DAO Function to save Requisition Approval Action
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> saveJVApprovalAction(String id, String createdBy) {
		logger.info("Method : saveJVApprovalAction starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_journalVoucher='" + id + "',@p_createdBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("invjournalvoucherPaymentRoutines")
					.setParameter("actionType", "forwardJournalVoucher").setParameter("actionValue", value).execute();

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
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method : saveJVApprovalAction ends");
		return response;
	}

	/**
	 * DAO Function to save Requisition Reject Action
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> saveJVRejectAction(AccountJournalVoucherModel reqobject) {
		logger.info("Method : saveJVRejectAction starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_journalVoucher='" + reqobject.getJournalVoucher() + "',@p_rejectComment='"
					+ reqobject.getDescription() + "',@p_createdBy='" + reqobject.getCreatedBy() + "';";

			String actionType = "";
			if (reqobject.getApproverStageNo().equals(1))
				actionType = "rejectJournalVoucher";
			else if (reqobject.getApproverStageNo().equals(2))
				actionType = "returnJournalVoucher";
			else
				actionType = "resubmitJournalVoucher";

			em.createNamedStoredProcedureQuery("invjournalvoucherPaymentRoutines").setParameter("actionType", actionType)
					.setParameter("actionValue", value).execute();

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
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method : saveJVRejectAction ends");
		return response;
	}

}
