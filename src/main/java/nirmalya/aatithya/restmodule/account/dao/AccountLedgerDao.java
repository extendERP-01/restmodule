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

import nirmalya.aatithya.restmodule.account.model.AccountLedgerModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;

import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


/*
 * @author Nirmalya Labs
 *
 */

@Repository
public class AccountLedgerDao {

	/*
	 * DAO Function to data bases
	 *
	 */
	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	Logger logger = LoggerFactory.getLogger(AccountLedgerDao.class);

	/*
	 * DAO - Function to view Cost Center dropdown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCostCenterList() {
		logger.info("Method : getCostCenterList starts");

		List<DropDownModel> costCenterList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("accountLedgerRoutines")
					.setParameter("actionType", "getCostCenter").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				costCenterList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCostCenterList ends");
		return costCenterList;

	}

	/*
	 * DAO - Function to view Cost Center dropdown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAccountHeadList() {
		logger.info("Method : getCostCenterList starts");

		List<DropDownModel> costCenterList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("accountLedgerRoutines")
					.setParameter("actionType", "getAccountHead").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				costCenterList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCostCenterList ends");
		return costCenterList;

	}

	/*
	 * DAO Function to View all Ledger Reports in PDF
	 *
	 */
	@SuppressWarnings("unchecked")

	public ResponseEntity<JsonResponse<List<AccountLedgerModel>>> getLedgerReportPdf(DataTableRequest request) {
		logger.info("Method : getLedgerReportPdf starts");
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
		List<AccountLedgerModel> form = new ArrayList<AccountLedgerModel>();
		String values = GenerateParameter.getSearchParam(request);

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("accountLedgerRoutines")
					.setParameter("actionType", "getLedgerPdf").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				Object transactionDate = null;

				if (m[15] != null) {
					transactionDate = DateFormatter.returnStringDate(m[15]);
				}
				Object createdOn = null;
				if (m[18] != null) {
					createdOn = DateFormatter.returnStringDate(m[18]);
				}

				AccountLedgerModel properties = new AccountLedgerModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], transactionDate, m[16], m[17], createdOn);
				form.add(properties);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		JsonResponse<List<AccountLedgerModel>> resp = new JsonResponse<List<AccountLedgerModel>>();
		resp.setBody(form);

		ResponseEntity<JsonResponse<List<AccountLedgerModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getLedgerReportPdf ends");

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
	public ResponseEntity<JsonResponse<List<AccountLedgerModel>>> getLedgerReportDownload(DataTableRequest request) {

		logger.info("Method : getLedgerReportDownload starts");

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
		List<AccountLedgerModel> form = new ArrayList<AccountLedgerModel>();
		JsonResponse<List<AccountLedgerModel>> resp = new JsonResponse<List<AccountLedgerModel>>();
		String values = GenerateParameter.getSearchParam(request);

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("accountLedgerRoutines")
					.setParameter("actionType", "viewLedgerReportXls").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				Object transactionDate = null;

				if (m[15] != null) {
					transactionDate = DateFormatter.returnStringDate(m[15]);
				}
				Object createdOn = null;
				if (m[18] != null) {
					createdOn = DateFormatter.returnStringDate(m[18]);
				}

				AccountLedgerModel properties = new AccountLedgerModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], transactionDate, m[16], m[17], createdOn);
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

		ResponseEntity<JsonResponse<List<AccountLedgerModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getLedgerReportDownload ends");

		return response;
	}

	/*
	 * DAO Function to Ledger Report Preview
	 *
	 */
	@SuppressWarnings("unchecked")

	public ResponseEntity<JsonResponse<List<AccountLedgerModel>>> getLedgerPreview(DataTableRequest request) {
		logger.info("Method : getLedgerPreview starts");

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
		List<AccountLedgerModel> form = new ArrayList<AccountLedgerModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("accountLedgerRoutines")
					.setParameter("actionType", "getLedgerPreview").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				Object transactionDate = null;

				if (m[15] != null) {
					transactionDate = DateFormatter.returnStringDate(m[15]);
				}
				Object createdOn = null;
				if (m[18] != null) {
					createdOn = DateFormatter.returnStringDate(m[18]);
				}

				AccountLedgerModel properties = new AccountLedgerModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], transactionDate, m[16], m[17], createdOn);
				form.add(properties);
			}

			if (x.get(0).length > 19) {
				BigInteger t = (BigInteger) x.get(0)[19];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		JsonResponse<List<AccountLedgerModel>> resp = new JsonResponse<List<AccountLedgerModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<AccountLedgerModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getLedgerPreview ends");

		return response;
	}

	/*
	 * 
	 *   DAO Function to View all Ledger Report in excel
	*/
		 

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<AccountLedgerModel>>> getExcelForDownload(DataTableRequest request) {
			logger.info("Method : getExcelForDownload starts");
			List<AccountLedgerModel> form = new ArrayList<AccountLedgerModel>();
			JsonResponse<List<AccountLedgerModel>> resp = new JsonResponse<List<AccountLedgerModel>>();
			String values = GenerateParameter.getSearchParam(request);

			try {

				List<Object[]> x = em.createNamedStoredProcedureQuery("accountLedgerRoutines")
						.setParameter("actionType", "viewLedgerReportXls").setParameter("actionValue", values)
						.getResultList();

				for (Object[] m : x) {
					Object transactionDate = null;

					if (m[15] != null) {
						transactionDate = DateFormatter.returnStringDate(m[15]);
					}
					Object createdOn = null;
					if (m[18] != null) {
						createdOn = DateFormatter.returnStringDate(m[18]);
					}

					AccountLedgerModel properties = new AccountLedgerModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
							m[8], m[9], m[10], m[11], m[12], m[13], m[14], transactionDate, m[16], m[17], createdOn);
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

			ResponseEntity<JsonResponse<List<AccountLedgerModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerModel>>>(
					resp, HttpStatus.CREATED);
			logger.info("Method : getExcelForDownload ends");
		
			return response;
		}
}
