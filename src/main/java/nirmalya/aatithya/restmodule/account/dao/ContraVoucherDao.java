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
import nirmalya.aatithya.restmodule.account.model.ContraVoucherModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAccountContraVoucherParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class ContraVoucherDao {

	/**
	 * DAO Function to View all dropdown
	 *
	 */
	@Autowired
	ServerDao serverDao;
	
	@Autowired
	EntityManager em;
	
	Logger logger = LoggerFactory.getLogger(ContraVoucherDao.class);
	
	/**
	 * DAO - Function to view Contra Voucher Type dropdown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCVType() {
		logger.info("Method : getCVType starts");
	
		List<DropDownModel> cvTypeList = new ArrayList<DropDownModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("contraVoucherRoutines")
					.setParameter("actionType", "getCVType")
					.setParameter("actionValue", "")
					.getResultList();
			
			for(Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0],m[1]);
				cvTypeList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getCVType ends");
		return cvTypeList;
		
	}
	
	/**
	 * DAO - Function to view Cost Center dropdown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCostCenterList() {
		logger.info("Method : getCostCenterList starts");
	
		List<DropDownModel> costCenterList = new ArrayList<DropDownModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("contraVoucherRoutines")
					.setParameter("actionType", "getCostCenter")
					.setParameter("actionValue", "")
					.getResultList();
			
			for(Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0],m[1]);
				costCenterList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getCostCenterList ends");
		return costCenterList;
		
	}
	
	/**
	 * DAO Function to view particular RequisitionNumber in dropDown for search
	 * param
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ContraVoucherModel>>> restGetAccountAndBankList(String id) {
		logger.info("Method : restGetAccountAndBankList Dao starts");

		List<ContraVoucherModel> guestList = new ArrayList<ContraVoucherModel>();
		JsonResponse<List<ContraVoucherModel>> resp = new JsonResponse<List<ContraVoucherModel>>();

		try {
			String value = "SET @p_fromAccount='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("contraVoucherRoutines")
					.setParameter("actionType", "getBankName").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				ContraVoucherModel dropDownModel = new ContraVoucherModel(m[0], m[1], m[2], m[3], m[4],null, null,null, null, null, null, null, null, null,null);
				guestList.add(dropDownModel);
			}

			resp.setBody(guestList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<ContraVoucherModel>>> response = new ResponseEntity<JsonResponse<List<ContraVoucherModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println(response);
		logger.info("Method : restGetAccountAndBankList Dao ends");
		return response;
	}

	/**
	 * DAO Function to view particular RequisitionNumber in dropDown for search
	 * param
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ContraVoucherModel>>> toAccountAndBankList(String id) {
		logger.info("Method : toAccountAndBankList Dao starts");

		List<ContraVoucherModel> guestList = new ArrayList<ContraVoucherModel>();
		JsonResponse<List<ContraVoucherModel>> resp = new JsonResponse<List<ContraVoucherModel>>();

		try {
			String value = "SET @p_fromAccount='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("contraVoucherRoutines")
					.setParameter("actionType", "getBankName").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				ContraVoucherModel dropDownModel = new ContraVoucherModel(m[0], m[1], m[2], m[3], m[4],null, null,null, null, null, null, null, null, null,null);
				guestList.add(dropDownModel);
			}

			resp.setBody(guestList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<ContraVoucherModel>>> response = new ResponseEntity<JsonResponse<List<ContraVoucherModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println(response);
		logger.info("Method : toAccountAndBankList Dao ends");
		return response;
	}
	/**
	 * DAO - Function For Account Head Type
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAccountHeadTypeList(String type) {
		logger.info("Method : getAccountHeadTypeList starts");
		
		List<DropDownModel> accountHeadList = new ArrayList<DropDownModel>();
		String value = "SET @p_accountHead='" + type + "';";
		System.out.println(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("contraVoucherRoutines")
					.setParameter("actionType", "getAccountHead")
					.setParameter("actionValue", value)
					.getResultList();
			
			for(Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0],m[1]);
				accountHeadList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getAccountHeadTypeList ends");
		return accountHeadList;
	}
	
	/**
	 * DAO - Function to view Branch Name dropdown
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getBranchNameDao(String id) {
		
		logger.info("Method : getBranchNameDao starts");
		
		List<DropDownModel> branchName = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_bankName='" + id + "';";
		System.out.println("value : "+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("contraVoucherRoutines")
					.setParameter("actionType", "getBranchName")
					.setParameter("actionValue",value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				branchName.add(dropDownModel);
			}
			
			resp.setBody(branchName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getBranchNameDao ends");
		return response;
	}
	
	/**
	 * DAO - Function to view Account No dropdown
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAccountNoDao(String id) {
		
		logger.info("Method : getAccountNoDao starts");
		
		List<DropDownModel> account = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_branchName='" + id + "';";
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("contraVoucherRoutines")
					.setParameter("actionType", "getAccountNo")
					.setParameter("actionValue",value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				account.add(dropDownModel);
			}
			
			resp.setBody(account);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getAccountNoDao ends");
		return response;
	}
	
	/**
	 * DAO - ADD NEW CONTRA VOUCHER
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addContraVoucher(ContraVoucherModel contraVoucher) {
		
		logger.info("Method : addContraVoucher starts");
		
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		
		if (contraVoucher.getContraVoucherType() == null || contraVoucher.getContraVoucherType() == ""){ 
			 resp.setCode("Field Validation Error");
			 resp.setMessage("Contra Voucher Type Required."); 
			 validity = false; 
		} else if (contraVoucher.getCostCenter() == null || contraVoucher.getCostCenter() == "") {
			resp.setCode("Field Validation Error");
			resp.setMessage("Cost Center Name Required.");
			validity = false;
		} else if (contraVoucher.getCvDescription() == null || contraVoucher.getCvDescription() == "") {
			resp.setCode("Field Validation Error");
			resp.setMessage("Contra Voucher Description Required.");
			validity = false;
		} else if (contraVoucher.getCvDate() == null || contraVoucher.getCvDate() == "") {
			resp.setCode("Field Validation Error");
			resp.setMessage("Contra Voucher Date Required.");
			validity = false;
		} else if (contraVoucher.getCvAmount() == null) {
			resp.setCode("Field Validation Error");
			resp.setMessage("Amount Required.");
			validity = false;
		}
		else if (contraVoucher.getFromAccount() == null) {
			resp.setCode("Field Validation Error");
			resp.setMessage(" From Account Required.");
			validity = false;
		}
		else if (contraVoucher.getToAccount() == null) {
			resp.setCode("Field Validation Error");
			resp.setMessage(" To Account Required.");
			validity = false;
			
		}
		if(contraVoucher.getContraVoucherType()=="dp048" || contraVoucher.getContraVoucherType()=="dp049") {
		String toAccount=contraVoucher.getToAccount();
		String fromAccount=contraVoucher.getFromAccount();
		if(fromAccount.equals(toAccount)) {
			resp.setCode("Field Validation Error");
			resp.setMessage(" Can't transfer money to the same account.");
			validity = false;	
		}
		}
		if (validity)
			try {
				
				String values = GenerateAccountContraVoucherParameter.getAddContraVoucherParam(contraVoucher);

					em.createNamedStoredProcedureQuery("contraVoucherRoutines")
					.setParameter("actionType", "addContraVoucher")
					.setParameter("actionValue", values)
					.execute();
				
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
		
		logger.info("Method : addContraVoucher ends");
		return response;
	}
	
	
	
	
	/**
	 * DAO Function to view particular account sub group
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> getAccountGroupForContra(String id) {
		logger.info("Method : getAccountGroupForContra starts");
		List<AccountJournalVoucherModel> itemNameList = new ArrayList<AccountJournalVoucherModel>();
		JsonResponse<List<AccountJournalVoucherModel>> resp = new JsonResponse<List<AccountJournalVoucherModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		
		System.out.println("value----------"+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("contraVoucherRoutines")
					.setParameter("actionType", "getAccountGroup").setParameter("actionValue", value).getResultList();
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
		logger.info("Method : getAccountGroupForContra ends");
		System.out.println(response);
		return response;
	}
	
	/**
	 * DAO - VIEW CONTRA VOUCHER DETAILS
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ContraVoucherModel>>> getContraVoucherDetails(
			DataTableRequest request) {
		
		logger.info("Method : getContraVoucherDetails starts");
		
		List<ContraVoucherModel> contraVoucher = new ArrayList<ContraVoucherModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("contraVoucherRoutines")
					.setParameter("actionType", "viewContraVoucher")
					.setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				
				Object cvDate = null;
				if(m[4]!=null) {
					cvDate = DateFormatter.returnStringDate(m[4]);
				}
				ContraVoucherModel cv = new ContraVoucherModel(m[0], m[1], m[2],null,null,null,null,null,null,null,null, m[3], cvDate,
						m[5],null);
				contraVoucher.add(cv);
			}
			if(x.size()>0) {
				if (x.get(0).length > 6) {
					BigInteger t = (BigInteger) x.get(0)[6];
	
					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ContraVoucherModel>> resp = new JsonResponse<List<ContraVoucherModel>>();
		resp.setBody(contraVoucher);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ContraVoucherModel>>> response = new ResponseEntity<JsonResponse<List<ContraVoucherModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getContraVoucherDetails ends");
		
		return response;
	}
	
	/**
	 * DAO - VIEW CONTRA VOUCHER MODAL
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ContraVoucherModel>> getContraVoucherById(String id) {
		
		logger.info("Method : getContraVoucherById starts");
		
		List<ContraVoucherModel> contraVoucher = new ArrayList<ContraVoucherModel>();
		JsonResponse<ContraVoucherModel> resp = new JsonResponse<ContraVoucherModel>();

		try {

			String value = "SET @p_contraVoucher='" + id + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("contraVoucherRoutines")
					.setParameter("actionType", "modalContraVoucher")
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object cvDate = null;
				if(m[12]!=null) {
					cvDate = DateFormatter.returnStringDate(m[12]);
				}
				ContraVoucherModel cv = new ContraVoucherModel(m[0], m[1], m[2], m[3], m[4],m[5],m[6],m[7],m[8],m[9],m[10],
						m[11],cvDate,m[13],m[14]);
				contraVoucher.add(cv);
			}
			resp.setBody(contraVoucher.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<ContraVoucherModel>> response = new ResponseEntity<JsonResponse<ContraVoucherModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : getContraVoucherById ends");
		
		return response;
	}
	
	/**
	 * DAO - CONTRA VOUCHER REPORT
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ContraVoucherModel>>> getContraVoucherReport(
			DataTableRequest request) {
		logger.info("Method : DAO getContraVoucherReport starts");	
		
		List<ContraVoucherModel> contraVoucher = new ArrayList<ContraVoucherModel>();
		JsonResponse<List<ContraVoucherModel>> resp = new JsonResponse<List<ContraVoucherModel>>();
		
		String param1 = request.getParam1();
		String param2 = request.getParam2();
		if (param1 != null && param1 != "") {
			String frmDate = DateFormatter.getStringDate(param1);
			
			request.setParam1(frmDate);
		}
		if (param2 != null && param2 != "") {
			String tDate = DateFormatter.getStringDate(param2);
			
			request.setParam2(tDate);
		}
		
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("contraVoucherRoutines")
					.setParameter("actionType", "contraVoucherReport")
					.setParameter("actionValue", values)
					.getResultList();
			
			for (Object[] m : x) {
				
				Object cvDate = null;
				if(m[4]!=null) {
					cvDate = DateFormatter.returnStringDate(m[4]);
				}
				ContraVoucherModel cv = new ContraVoucherModel(m[0], m[1], m[2],null,null,null,null,null,null,null,null, m[3], cvDate,
						m[5],null);
				
				contraVoucher.add(cv);
				
			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		
		resp.setBody(contraVoucher);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<ContraVoucherModel>>> response = new ResponseEntity<JsonResponse<List<ContraVoucherModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : DAO getContraVoucherReport ends");
		return response;
	}
	
	/**
	 * DAO - Get Hotel Logo
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getHotelLogoImageForContraVoucher(String logoType) {
		logger.info("Method : getHotelLogoImageForContraVoucher starts");
		
		List<DropDownModel> logoList = new ArrayList<DropDownModel>();
		
		try {
			String value = "SET @p_logoType='" + logoType + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("logoImageRoutines")
					.setParameter("actionType", "getHotelLogo")
					.setParameter("actionValue", value)
					.getResultList();
			
			for(Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0],m[1]);
				logoList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getHotelLogoImageForContraVoucher ends");
			
		return logoList;
	}
}
