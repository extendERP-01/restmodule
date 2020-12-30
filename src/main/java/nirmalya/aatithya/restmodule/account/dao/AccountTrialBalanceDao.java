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

import nirmalya.aatithya.restmodule.account.model.AccountTrialBalanceModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class AccountTrialBalanceDao {
	Logger logger = LoggerFactory.getLogger(AccountTrialBalanceDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for all trial balance
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountTrialBalanceModel>>> getAllTrialBalanceReport(
			DataTableRequest request) {

		logger.info("Method in Dao: getAllTrialBalanceReport  starts");

		List<AccountTrialBalanceModel> trialBalanceModel = new ArrayList<AccountTrialBalanceModel>();
		String param1 = request.getParam1();
		String param2 = request.getParam2();
		if (param1 != null && param1 != "") {
			request.setParam1(DateFormatter.getStringDate(param1));
		}
		if (param2 != null && param2 != "") {
			request.setParam2(DateFormatter.getStringDate(param2));
		}
		String values = GenerateParameter.getSearchParam(request);
		System.out.println(" 53 values "+values);
		Integer total = 0;
		try { 

			List<Object[]> x = em.createNamedStoredProcedureQuery("trialBalanceRoutines")
					.setParameter("actionType", "getTrialBalance").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					AccountTrialBalanceModel voucher = new AccountTrialBalanceModel(m[0], m[1], m[2], m[3],null);
					trialBalanceModel.add(voucher);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<AccountTrialBalanceModel>> resp = new JsonResponse<List<AccountTrialBalanceModel>>();
		resp.setBody(trialBalanceModel);
		resp.setTotal(total);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AccountTrialBalanceModel>>> response = new ResponseEntity<JsonResponse<List<AccountTrialBalanceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getAllTrialBalanceReport ends");
		System.out.println(response);
		return response;
	}
	/*
	 * for cost center list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCostCenterTB() {

		logger.info("Method in Dao: getCostCenterTB starts");

		List<DropDownModel> payModeList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("trialBalanceRoutines")
					.setParameter("actionType", "getCostCenterTB").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				payModeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getCostCenterTB ends");

		return payModeList;
	}
	/*
	 * for cost center list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSubgrpTB() {
		
		logger.info("Method in Dao: getCostCenterTB starts");
		
		List<DropDownModel> payModeList = new ArrayList<DropDownModel>();
		
		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("trialBalanceRoutines")
					.setParameter("actionType", "getSubgrpTB").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				payModeList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method in Dao: getCostCenterTB ends");
		
		return payModeList;
	}
	
	/**
	 * DAO - Get Hotel Logo
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getHotelLogoForVoucher(String logoType) {
		logger.info("Method : getHotelLogoForVoucher starts");

		List<DropDownModel> logoList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_logoType='" + logoType + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("logoImageRoutines")
					.setParameter("actionType", "getHotelLogo").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				logoList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getHotelLogoForVoucher ends");

		return logoList;
	}

	/********************************************* R A J E S H ***********************************************/
	/*
	 * for all trial balance web view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountTrialBalanceModel>>> getAllTrialBalanceReportWebViewMode(
			DataTableRequest request) {

		logger.info("Method in Dao: getAllTrialBalanceReport  starts");

		List<AccountTrialBalanceModel> trialBalanceModel = new ArrayList<AccountTrialBalanceModel>();
		List<AccountTrialBalanceModel> trialBalanceList = new ArrayList<AccountTrialBalanceModel>(); 
		String param1 = request.getParam1();
		String param2 = request.getParam2();
		String param3 = request.getParam3();
		
		if (param1 != null && param1 != "") {
			request.setParam1(DateFormatter.getStringDate(request.getParam1()));
		}
		if (param2 != null && param2 != "") {
			request.setParam2(DateFormatter.getStringDate(request.getParam2()));
		}
		if (param3 == null || param3 == "") {
			request.setParam3("cc006");
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("trialBalanceRoutines")
					.setParameter("actionType", "getTrialBalanceViewMode")
					.setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					if(m[2]==null) {
						m[2]=0.0;
					}
					if( m[3]==null) {
						m[3]=0.0;
					}
					AccountTrialBalanceModel voucher = new AccountTrialBalanceModel(m[0], m[1], m[2], m[3],m[4]);
					voucher.setParentSeq((String) m[5]);
					trialBalanceModel.add(voucher);
				}
				if (x.get(0).length > 6) {
					BigInteger t = (BigInteger) x.get(0)[6];
					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("trialBalanceModel::"+trialBalanceModel);
		for(AccountTrialBalanceModel m: trialBalanceModel) {
			String value = "SET @P_ID= 'GN0128';";;
			if(m.getParentSeq().length() > 1 && m.getParentSeq()!=null) {
				String[] str = m.getParentSeq().split("\\,");
				value = "SET @P_ID='"+str[str.length-1]+"';";
			}else {
				value = "SET @P_ID='"+m.getDesc()+"';";
			}
			
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("trialBalanceRoutines")
					.setParameter("actionType", "getParentAcGr")
					.setParameter("actionValue", value)
					.getResultList();
			for(Object[] o: x) {
				DropDownModel mo = new DropDownModel(o[0],o[1]);
				m.setParent(mo);
			}
			
		}
		List<String> trialBalanceParentTypes  = new ArrayList<String>();
		String parent = "";
		for(AccountTrialBalanceModel m: trialBalanceModel) {
			parent = (String) m.getParent().getName();
			if(!trialBalanceParentTypes.contains(parent)) {
				trialBalanceParentTypes.add(parent);
			}
			
		}
		String rootString = "";
		for(String s : trialBalanceParentTypes) {
			AccountTrialBalanceModel acmodel = new AccountTrialBalanceModel();
			acmodel.setCreditVal(0.00);
			acmodel.setDebitBal(0.00);
			for(AccountTrialBalanceModel m: trialBalanceModel) {
				if(m.getParent().getName().equals(s)) {
					acmodel.setCreditVal(acmodel.getCreditVal()+m.getCreditVal());
					acmodel.setDebitBal(acmodel.getDebitBal()+m.getDebitBal());
					acmodel.setCostCenter(m.getCostCenter());
					acmodel.setDesc(m.getDesc());
					acmodel.setAccountHeadId(m.getAccountHeadId());
					if(m.getParentSeq().length() > 1) {
						acmodel.setParentSeqList(m.getParentSeq());
					}
					rootString += m.getDesc()+","; 
					//else {
						//acmodel.setParentSeqList(m.getDesc());
					//}
					acmodel.setParent(m.getParent());					
				}
			}
			acmodel.setDesc(rootString.substring(0,rootString.length()-1));
			rootString = "";
			trialBalanceList.add(acmodel);
		}
		
		JsonResponse<List<AccountTrialBalanceModel>> resp = new JsonResponse<List<AccountTrialBalanceModel>>();
		resp.setBody(trialBalanceList);
		//System.out.println("NewData:::"+resp.getBody());
		resp.setTotal(total);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AccountTrialBalanceModel>>> response = new ResponseEntity<JsonResponse<List<AccountTrialBalanceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getAllTrialBalanceReport ends");
		//System.out.println(response);
		return response;
	}
	/*****************************************************************************************************************************************/
	
	/*
	 * for all trial balance web view subgroup
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountTrialBalanceModel>>> allTrialBalanceReportviewSubgrp(
			DataTableRequest request) {
		
		logger.info("Method in Dao: getAllTrialBalanceReport  starts");
		
		List<AccountTrialBalanceModel> trialBalanceModel = new ArrayList<AccountTrialBalanceModel>();
		String param1 = request.getParam1();
		String param2 = request.getParam2();
		
		if (param1 != null && param1 != "") {
			request.setParam1(DateFormatter.getStringDate(request.getParam1()));
		}
		if (param2 != null && param2 != "") {
			request.setParam2(DateFormatter.getStringDate(request.getParam2()));
		}
		
		String values = GenerateParameter.getSearchParam(request);
		System.out.println("values "+values);
		Integer total = 0;
		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("trialBalanceRoutines")
					.setParameter("actionType", "getTrialBalanceSGroupView")
					.setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					System.out.println("m[2] "+m[2]);
					System.out.println("m[3] "+m[3]);
					if(m[2]==null) {
						m[2]=0.0;
					}
					if( m[3]==null) {
						m[3]=0.0;
					}
					
					AccountTrialBalanceModel voucher = new AccountTrialBalanceModel(m[0], m[1], m[2], m[3],null);
					trialBalanceModel.add(voucher);
					
				}
				if (x.get(0).length > 4) {
					BigInteger t = (BigInteger) x.get(0)[4];
					total = Integer.parseInt((t.toString()));
					System.out.println(total);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<AccountTrialBalanceModel>> resp = new JsonResponse<List<AccountTrialBalanceModel>>();
		resp.setBody(trialBalanceModel);
		resp.setTotal(total);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AccountTrialBalanceModel>>> response = new ResponseEntity<JsonResponse<List<AccountTrialBalanceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getAllTrialBalanceReport ends");
		System.out.println(response);
		return response;
	}
	public ResponseEntity<JsonResponse<List<AccountTrialBalanceModel>>> getAllTrialBalanceReportDetls(
			DataTableRequest request) {
	
		logger.info("Method in Dao: getAllTrialBalanceReportDetls  starts");

		List<AccountTrialBalanceModel> trialBalanceModel = new ArrayList<AccountTrialBalanceModel>();

		String param1 = request.getParam1();
		String param2 = request.getParam2();
		String param3 = request.getParam3();
		
		if (param1 != null && param1 != "") {
			request.setParam1(DateFormatter.getStringDate(request.getParam1()));
		}
		if (param2 != null && param2 != "") {
			request.setParam2(DateFormatter.getStringDate(request.getParam2()));
		}
		if (param3 == null || param3 == "") {
			request.setParam3("cc006");
		}
		String values = GenerateParameter.getSearchParam(request);
		
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("trialBalanceRoutines")
					.setParameter("actionType", "getTrialBalanceViewMode")
					.setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					if(m[2]==null) {
						m[2]=0.0;
					}
					if( m[3]==null) {
						m[3]=0.0;
					}
					AccountTrialBalanceModel voucher = new AccountTrialBalanceModel(m[0], m[1], m[2], m[3],m[4]);

					trialBalanceModel.add(voucher);
				}
				if (x.get(0).length > 6) {
					BigInteger t = (BigInteger) x.get(0)[6];
					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonResponse<List<AccountTrialBalanceModel>> resp = new JsonResponse<List<AccountTrialBalanceModel>>();
		resp.setBody(trialBalanceModel);
		resp.setTotal(total);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AccountTrialBalanceModel>>> response = new ResponseEntity<JsonResponse<List<AccountTrialBalanceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getAllTrialBalanceReportDetls ends");
		System.out.println(response);
		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAllAccHeads() {
		
		logger.info("Method in Dao: getAllAccHeads starts");
		
		List<DropDownModel> accHeads = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("trialBalanceRoutines")
					.setParameter("actionType", "getAllAccHeads")
					.setParameter("actionValue", "")
					.getResultList();
			for(Object[] m:x) {
				DropDownModel d = new DropDownModel(m[0],m[1]);
				accHeads.add(d);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method in Dao: getAllAccHeads end");
		return accHeads;
	}
	
}
