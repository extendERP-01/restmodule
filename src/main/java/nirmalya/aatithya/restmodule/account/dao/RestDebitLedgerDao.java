package nirmalya.aatithya.restmodule.account.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.account.model.RestDebitCreditLedgerModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestDebitLedgerDao {
	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	Logger logger = LoggerFactory.getLogger(RestDebitLedgerDao.class);

	/*
	 * DAO - Function to view Cost Center dropdown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> debitLedgerCostCenter() {
		logger.info("Method : debitLedgerCostCenter starts");

		List<DropDownModel> costCenterList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("debitLedgerRoutines")
					.setParameter("actionType", "getCostCenter").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				costCenterList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : debitLedgerCostCenter ends");
		return costCenterList;

	}

	/*
	 * DAO - Function to view Cost Center dropdown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> debitLedgerAccountHead() {
		logger.info("Method : debitLedgerAccountHead starts");

		List<DropDownModel> accountHeadList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("debitLedgerRoutines")
					.setParameter("actionType", "getAccountHead").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				accountHeadList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : debitLedgerAccountHead ends");
		return accountHeadList;

	}

	/*
	 * DAO Function to View all Debit Ledger Reports in PDF
	 *
	 */
	@SuppressWarnings("unchecked")

	public ResponseEntity<JsonResponse<List<RestDebitCreditLedgerModel>>> getDebitLedgerReportPdf(
			DataTableRequest request) {
		logger.info("Method : getDebitLedgerReportPdf starts");
		if (request.getParam1() != "") {
			String param1 = request.getParam1();
			String data = DateFormatter.getStringDate(param1);
			request.setParam1(data);

		}

		if (request.getParam2() != "") {
			String param2 = request.getParam2();
			String data2 = DateFormatter.getStringDate(param2);
			request.setParam2(data2);

		}
		List<RestDebitCreditLedgerModel> form = new ArrayList<RestDebitCreditLedgerModel>();
		String values = GenerateParameter.getSearchParam(request);

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("debitLedgerRoutines")
					.setParameter("actionType", "getDebitLedgerPdf").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object tTransactionDate = null;
				if (m[2] != null) {
					tTransactionDate = DateFormatter.returnStringDate(m[2]);
				}

				RestDebitCreditLedgerModel properties = new RestDebitCreditLedgerModel(null, null, null, m[0], null,
						null, m[1], null, null, null, null, null, null, null, null, null, null, tTransactionDate, null,
						null, null, m[3], m[4]);
				form.add(properties);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		JsonResponse<List<RestDebitCreditLedgerModel>> resp = new JsonResponse<List<RestDebitCreditLedgerModel>>();
		resp.setBody(form);

		ResponseEntity<JsonResponse<List<RestDebitCreditLedgerModel>>> response = new ResponseEntity<JsonResponse<List<RestDebitCreditLedgerModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getDebitLedgerReportPdf ends");
		System.out.println("response" + response);
		return response;
	}

	/**
	 * DAO - Get Hotel Logo
	 *
	 */
	@SuppressWarnings("unchecked")

	public List<DropDownModel> getHotelLogo(String logoType) {

		logger.info("Method : getHotelLogo starts");

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

		logger.info("Method : getHotelLogo ends");

		return logoList;
	}

	/*
	 * DAO Function to View all Ledger Reports in excel
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestDebitCreditLedgerModel>>> getDebitLedgerReportDownload(
			DataTableRequest request) {

		logger.info("Method : getDebitLedgerReportDownload starts");

		if (request.getParam1() != "") {
			String param1 = request.getParam1();
			String data = DateFormatter.getStringDate(param1);
			request.setParam1(data);
		}

		if (request.getParam2() != "") {
			String param2 = request.getParam2();
			String data2 = DateFormatter.getStringDate(param2);
			request.setParam2(data2);
		}
		List<RestDebitCreditLedgerModel> form = new ArrayList<RestDebitCreditLedgerModel>();
		JsonResponse<List<RestDebitCreditLedgerModel>> resp = new JsonResponse<List<RestDebitCreditLedgerModel>>();
		String values = GenerateParameter.getSearchParam(request);

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("debitLedgerRoutines")
					.setParameter("actionType", "viewDebitLedgerXls").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object tTransactionDate = null;
				if (m[2] != null) {
					tTransactionDate = DateFormatter.returnStringDate(m[2]);
				}

				RestDebitCreditLedgerModel properties = new RestDebitCreditLedgerModel(null, null, null, m[0], null,
						null, m[1], null, m[4], null, m[3], null, null, null, null, null, null, tTransactionDate, null,
						null, null, null,null);
				form.add(properties);
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

		resp.setBody(form);

		ResponseEntity<JsonResponse<List<RestDebitCreditLedgerModel>>> response = new ResponseEntity<JsonResponse<List<RestDebitCreditLedgerModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getDebitLedgerReportDownload ends");

		return response;
	}

	/*
	 * DAO Function to Ledger Report Preview
	 *
	 */
	@SuppressWarnings("unchecked")

	public ResponseEntity<JsonResponse<List<RestDebitCreditLedgerModel>>> getDebitLedgerPreview(
			DataTableRequest request) {
		logger.info("Method : getDebitLedgerPreview starts");

		if (request.getParam1() != "") {
			String param1 = request.getParam1();
			String data = DateFormatter.getStringDate(param1);
			request.setParam1(data);
		}

		if (request.getParam2() != "") {
			String param2 = request.getParam2();
			String data2 = DateFormatter.getStringDate(param2);
			request.setParam2(data2);
		}
		List<RestDebitCreditLedgerModel> form = new ArrayList<RestDebitCreditLedgerModel>();
		String values = GenerateParameter.getSearchParam(request);
		System.out.println("value: "+values);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("debitLedgerRoutines")
					.setParameter("actionType", "getDebitPreview").setParameter("actionValue", values).getResultList();
			if(!x.isEmpty()) {
				for (Object[] m : x) {
		
					Object tTransactionDate = null;
					if (m[2] != null) {
						tTransactionDate = DateFormatter.returnStringDate(m[2]);
					}
		
					RestDebitCreditLedgerModel properties = new RestDebitCreditLedgerModel(null, null, null, m[0], null,
							null, m[1], null, null, null, null, null, null, null, null, null, null, tTransactionDate, null,
							null, null, m[3], m[4]);
					form.add(properties);
				}
		
				if (x.get(0).length > 5) {
					BigInteger t = (BigInteger) x.get(0)[5];
		
					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		JsonResponse<List<RestDebitCreditLedgerModel>> resp = new JsonResponse<List<RestDebitCreditLedgerModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<RestDebitCreditLedgerModel>>> response = new ResponseEntity<JsonResponse<List<RestDebitCreditLedgerModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getDebitLedgerPreview ends");

		return response;
	}

}
