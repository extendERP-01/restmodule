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

import nirmalya.aatithya.restmodule.account.model.AccountBankBranchModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAccountBankBranchParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class AccountBankBranchDao {
	
	Logger logger = LoggerFactory.getLogger(AccountBankBranchDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	EntityManager em;
	
	
	/**
	 * BANK LIST
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getBankList() {
		logger.info("Method : RESTMODULE AccountBankBranchDao getBankList starts");

		List<DropDownModel> UserStateList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("AccountBankBranchRoutines")
					.setParameter("actionType", "bankList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				UserStateList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : RESTMODULE AccountBankBranchDao getBankList ends");

		return UserStateList;
	}
	
	
	/**
	 * STATE LIST
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStateList() {
		logger.info("Method : RESTMODULE AccountBankBranchDao getStateList starts");

		List<DropDownModel> UserStateList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("AccountBankBranchRoutines")
					.setParameter("actionType", "stateList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				UserStateList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : RESTMODULE AccountBankBranchDao getStateList ends");

		return UserStateList;
	}

	/**
	 * DISTRICT LIST
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDistList() {
		logger.info("Method : RESTMODULE AccountBankBranchDao getDistList starts");

		List<DropDownModel> UserDistrictList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("AccountBankBranchRoutines")
					.setParameter("actionType", "districtList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				UserDistrictList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : RESTMODULE AccountBankBranchDao getDistList ends");

		return UserDistrictList;
	}
	
	
	/**
	 * Submit Add Bank Branch Details
	 */
		public ResponseEntity<JsonResponse<Object>> restSubmitBankBranchDetails(AccountBankBranchModel form) {
			logger.info("Method : AccountBankBranchDao restSubmitBankBranchDetails starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (form.getBank() == null || form.getBank() == "") {
				resp.setMessage("Bank Name Required");
				validity = false;
			} else if (form.getBranchName() == null || form.getBranchName() == "") {
				resp.setMessage("Branch Name Required");
				validity = false;
			} else if (form.getIfscCode() == null || form.getIfscCode() == "") {
				resp.setMessage("IFSC Code Required");
				validity = false;
			} else if (form.getContactNumber() == null || form.getContactNumber() == "") {
				resp.setMessage("Contact Number Required");
				validity = false;
			} else if (form.getEmail() == null || form.getEmail() == "") {
				resp.setMessage("Email Required");
				validity = false;
			} else if (form.getAddress() == null || form.getAddress() == "") {
				resp.setMessage("Address Required");
				validity = false;
			} else if (form.getCity() == null || form.getCity() == "") {
				resp.setMessage("City Required");
				validity = false;
			} else if (form.getDistrict() == null || form.getDistrict() == "") {
				resp.setMessage("District Required");
				validity = false;
			} else if (form.getState() == null || form.getState() == "") {
				resp.setMessage("State Required");
				validity = false;
			} else if (form.getBranchCountry() == null || form.getBranchCountry() == "") {
				resp.setMessage("Country Required");
				validity = false;
			} else if (form.getBranchActive() == null) {
				resp.setMessage("Status Required");
				validity = false;
			}

			if (validity)
				try {
					String values = GenerateAccountBankBranchParameter.getAddBankBranchParam(form);
					if (form.getBranch() != "") {
						em.createNamedStoredProcedureQuery("AccountBankBranchRoutines")
								.setParameter("actionType", "updateAccountBankBranch")
								.setParameter("actionValue", values)
								.execute();
					} else {
						em.createNamedStoredProcedureQuery("AccountBankBranchRoutines")
								.setParameter("actionType", "insertAccountBankBranch")
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
			logger.info("Method : AccountBankBranchDao restSubmitBankBranchDetails end");
			return response;
		}
		
		
		/**
		 * View Bank Branch Details Ajax
		 */

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<AccountBankBranchModel>>> restViewBankBranchThroughAjax(DataTableRequest request) {
			logger.info("Method : AccountBankBranchDao restViewBankBranchThroughAjax starts");
			List<AccountBankBranchModel> form = new ArrayList<AccountBankBranchModel>();

			String values = GenerateParameter.getSearchParam(request);
			Integer total = 0;

			try {

				List<Object[]> x = em.createNamedStoredProcedureQuery("AccountBankBranchRoutines")
						.setParameter("actionType", "viewAllBankBranchDetails").setParameter("actionValue", values).getResultList();

				for (Object[] m : x) {
					AccountBankBranchModel addUserType = new AccountBankBranchModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14]);
					form.add(addUserType);
				}

				if (x.get(0).length > 15) {
					BigInteger t = (BigInteger) x.get(0)[15];

					total = Integer.parseInt((t.toString()));
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			JsonResponse<List<AccountBankBranchModel>> resp = new JsonResponse<List<AccountBankBranchModel>>();
			resp.setBody(form);
			resp.setTotal(total);

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");
			ResponseEntity<JsonResponse<List<AccountBankBranchModel>>> response = new ResponseEntity<JsonResponse<List<AccountBankBranchModel>>>(
					resp, responseHeaders, HttpStatus.CREATED);
			logger.info("Method : AccountBankBranchDao restViewBankBranchThroughAjax end");
			return response;
		}

		/**
		 * Delete Bank Branch Record
		 */

		public ResponseEntity<JsonResponse<Object>> restDeleteBankBranchDeatils(String id) {
			logger.info("Method : AccountBankBranchDao restDeleteBankBranchDeatils starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			try {

				String value = "SET @p_branch='" + id + "';";
				em.createNamedStoredProcedureQuery("AccountBankBranchRoutines")
						.setParameter("actionType", "deleteBankBranchRecord").setParameter("actionValue", value).execute();

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
			logger.info("Method : AccountBankBranchDao restDeleteBankBranchDeatils end");
			return response;
		}

		/**
		 * Edit Account Bank Branch Details
		 */

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<AccountBankBranchModel>> restEditBankBranchDetails(String id) {
			logger.info("Method : AccountBankBranchDao restEditBankBranchDetails starts");
			List<AccountBankBranchModel> form = new ArrayList<AccountBankBranchModel>();

			try {
				String value = "SET @p_branch='" + id + "';";
				
				System.out.println("valuewdit>>>"+value);

				List<Object[]> x = em.createNamedStoredProcedureQuery("AccountBankBranchRoutines")
						.setParameter("actionType", "editBankBranchRecord").setParameter("actionValue", value)
						.getResultList();

				for (Object[] m : x) {
					AccountBankBranchModel addUserType = new AccountBankBranchModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14]);
					form.add(addUserType);
				}

			} catch (Exception e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}
			JsonResponse<AccountBankBranchModel> resp = new JsonResponse<AccountBankBranchModel>();
			resp.setBody(form.get(0));

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");

			ResponseEntity<JsonResponse<AccountBankBranchModel>> response = new ResponseEntity<JsonResponse<AccountBankBranchModel>>(resp,
					responseHeaders, HttpStatus.CREATED);
			logger.info("Method : AccountBankBranchDao restEditBankBranchDetails end");
			return response;
		}
		
		/**
		 * ONCHANGE DATA STATE TO DISTRICT
		 *
		 */

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getDistListById(String proCatId) {
			logger.info("Method : AccountBankBranchDao getDistListById starts");

			List<DropDownModel> distNameList = new ArrayList<DropDownModel>();
			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

			try {
				String value = "SET @p_stateId='" + proCatId + "';";

				List<Object[]> x = em.createNamedStoredProcedureQuery("AccountBankBranchRoutines")
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

			logger.info("Method : AccountBankBranchDao getDistListById ends");
			return response;
		}

}
