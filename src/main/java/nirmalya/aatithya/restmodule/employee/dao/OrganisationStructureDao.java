package nirmalya.aatithya.restmodule.employee.dao;

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

import nirmalya.aatithya.restmodule.account.model.AccountBankAccountModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAccountBankAccountParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateDataforChildParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.OrganisationStructureModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class OrganisationStructureDao {

	Logger logger = LoggerFactory.getLogger(OrganisationStructureDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	EntityManager em;

	/*
	 * 
	 * 
	 * getAccountTreeDetails
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<OrganisationStructureModel>>> getAccountTreeDetails(String getAccountTreeDetails) {

		logger.info("Method : DAO getAccountTreeDetails starts");

		List<OrganisationStructureModel> DataSetAccountTree = new ArrayList<OrganisationStructureModel>();

		try {
			String value = "SET @p_activityName=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("orgStructure")
					.setParameter("actionType", getAccountTreeDetails).setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				OrganisationStructureModel DataSetForActivityConstructor = new OrganisationStructureModel(m[0], m[1], m[2], m[3], m[4]);
				DataSetAccountTree.add(DataSetForActivityConstructor);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<OrganisationStructureModel>> resp = new JsonResponse<List<OrganisationStructureModel>>();
		resp.setBody(DataSetAccountTree);

		ResponseEntity<JsonResponse<List<OrganisationStructureModel>>> response = new ResponseEntity<JsonResponse<List<OrganisationStructureModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : DAO getAccountTreeDetails ends");
		System.out.print(response);
		return response;
	}

	/*
	 * DAO Function to restAddChild
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> restAddChild(OrganisationStructureModel table) {

		logger.info("Method : restAddChild starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				//String values = GenerateDataforChildParameter.getAddChild(table);

				if (table.getParentId() != null && table.getParentId() != "") {
					// System.out.println("update required");
//					em.createNamedStoredProcedureQuery("orgStructure")
//							.setParameter("actionType", "addChild").setParameter("actionValue", values).execute();
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

		logger.info("Method : restAddChild ends");

		return response;
	}

	//////////////////////////////////////////////////////////////////////////////
	/*
	 * DAO Function to restAddParent
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> restAddParent(OrganisationStructureModel table) {

		logger.info("Method : restAddParent starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				//String values = GenerateDataforChildParameter.getAddParent(table);

				//System.out.println("values--------------------" + values);

				if (table.getParentName() != null && table.getParentName() != "") {
					// System.out.println("update required");
//					em.createNamedStoredProcedureQuery("orgStructure")
//							.setParameter("actionType", "addParent").setParameter("actionValue", values).execute();
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

		logger.info("Method : restAddParent ends");

		return response;
	}

	/**
	 * BANK LIST
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> bankAccountListData() {
		logger.info("Method : RESTMODULE AccountBankAccountDao bankAccountListData starts");

		List<DropDownModel> AccountBankList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("orgStructure")
					.setParameter("actionType", "bankList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				AccountBankList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : RESTMODULE AccountBankAccountDao bankAccountListData ends");

		return AccountBankList;
	}

	/**
	 * BRANCH LIST
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> branchAccountListData() {
		logger.info("Method : RESTMODULE AccountBankAccountDao branchAccountListData starts");

		List<DropDownModel> AccountBranchList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("orgStructure")
					.setParameter("actionType", "branchList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				AccountBranchList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : RESTMODULE AccountBankAccountDao branchAccountListData ends");

		return AccountBranchList;
	}

	/**
	 * Submit Add Bank Branch Details
	 */
	public ResponseEntity<JsonResponse<Object>> submitBankAccountDetails(AccountBankAccountModel form) {
		logger.info("Method : AccountBankAccountDao submitBankAccountDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (form.getBank() == null || form.getBank() == "") {
			resp.setMessage("Bank Name Required");
			validity = false;
		} else if (form.getBranch() == null || form.getBranch() == "") {
			resp.setMessage("Branch Name Required");
			validity = false;
		} else if (form.getAccountNumber() == null || form.getAccountNumber() == "") {
			resp.setMessage("Account Number Required");
			validity = false;
		} else if (form.getAccountHolder() == null || form.getAccountHolder() == "") {
			resp.setMessage("Account Holder Required");
			validity = false;
		} else if (form.getAccountType() == null || form.getAccountType() == "") {
			resp.setMessage("Account Type Required");
			validity = false;
		} else if (form.getAccountActive() == null) {
			resp.setMessage("Status Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateAccountBankAccountParameter.getAddBankAccountParam(form);
				if (form.getIsEdit() != "") {
					em.createNamedStoredProcedureQuery("orgStructure")
							.setParameter("actionType", "updateAccountBankAccount").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("orgStructure")
							.setParameter("actionType", "insertAccountBankAccount").setParameter("actionValue", values)
							.execute();
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
		logger.info("Method : AccountBankAccountDao submitBankAccountDetails end");
		return response;
	}

	/**
	 * View Bank Branch Details Ajax
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountBankAccountModel>>> viewBankAccountThroughAjax(
			DataTableRequest request) {
		logger.info("Method : AccountBankAccountDao viewBankAccountThroughAjax starts");
		List<AccountBankAccountModel> form = new ArrayList<AccountBankAccountModel>();

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("orgStructure")
					.setParameter("actionType", "viewAllBankAccountDetails").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				AccountBankAccountModel addUserType = new AccountBankAccountModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], null);
				form.add(addUserType);
			}

			if (x.get(0).length > 8) {
				BigInteger t = (BigInteger) x.get(0)[8];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<AccountBankAccountModel>> resp = new JsonResponse<List<AccountBankAccountModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AccountBankAccountModel>>> response = new ResponseEntity<JsonResponse<List<AccountBankAccountModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : AccountBankAccountDao viewBankAccountThroughAjax end");
		return response;
	}

	/**
	 * Delete Bank Branch Record
	 */

	public ResponseEntity<JsonResponse<Object>> deleteBankAccountDeatils(String br, String ac) {
		logger.info("Method : AccountBankAccountDao deleteBankAccountDeatils starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_branch='" + br + "',@p_accountNumber='" + ac + "' ;";
			em.createNamedStoredProcedureQuery("orgStructure")
					.setParameter("actionType", "deleteBankAccountRecord").setParameter("actionValue", value).execute();

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
		logger.info("Method : AccountBankAccountDao deleteBankAccountDeatils end");
		return response;
	}

	/**
	 * Edit Account Bank Branch Details
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<AccountBankAccountModel>> editBankAccountDetails(String br, String ac) {
		logger.info("Method : AccountBankAccountDao editBankAccountDetails starts");
		List<AccountBankAccountModel> form = new ArrayList<AccountBankAccountModel>();

		try {
			String value = "SET @p_branch='" + br + "',@p_accountNumber='" + ac + "' ;";

			System.out.println("valuewdit>>>" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("orgStructure")
					.setParameter("actionType", "editBankAccountRecord").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				AccountBankAccountModel addUserType = new AccountBankAccountModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], "2");
				form.add(addUserType);
			}

		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonResponse<AccountBankAccountModel> resp = new JsonResponse<AccountBankAccountModel>();
		resp.setBody(form.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<AccountBankAccountModel>> response = new ResponseEntity<JsonResponse<AccountBankAccountModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : AccountBankAccountDao editBankAccountDetails end");
		return response;
	}

	/**
	 * ONCHANGE DATA STATE TO DISTRICT
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getBranchList(String proCatId) {
		logger.info("Method : AccountBankAccountDao getBranchList starts");

		List<DropDownModel> distNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_bankId='" + proCatId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("orgStructure")
					.setParameter("actionType", "getBranchNameListData").setParameter("actionValue", value)
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

		logger.info("Method : AccountBankAccountDao getBranchList ends");
		return response;
	}

}
