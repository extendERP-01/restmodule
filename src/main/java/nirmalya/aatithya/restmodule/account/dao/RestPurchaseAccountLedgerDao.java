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

import nirmalya.aatithya.restmodule.account.model.RestPurchaseAccountLedgerModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestPurchaseAccountLedgerDao {
	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	Logger logger = LoggerFactory.getLogger(RestPurchaseAccountLedgerDao.class);

	
		/*
		 * DAO Function to View sales Ledger Reports in PDF
		 *
		 */
		@SuppressWarnings("unchecked")

		public ResponseEntity<JsonResponse<List<RestPurchaseAccountLedgerModel>>> getPurchaseLedgerReportPdf(
				DataTableRequest request) {
			logger.info("Method : getSalesLedgerReportPdf starts");
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
			List<RestPurchaseAccountLedgerModel> form = new ArrayList<RestPurchaseAccountLedgerModel>();
			String values = GenerateParameter.getSearchParam(request);

			try {

				List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseRoutines")
						.setParameter("actionType", "getPurchasePdf").setParameter("actionValue", values).getResultList();

				for (Object[] m : x) {

					Object tPymntTransactionDate = null;
					if (m[4] != null) {
						tPymntTransactionDate = DateFormatter.returnStringDate(m[4]);
					}

					RestPurchaseAccountLedgerModel properties = new RestPurchaseAccountLedgerModel( m[0], m[1], m[2], m[3],
							tPymntTransactionDate, m[5], null, null, null, m[6], null,null, null, null, m[7], null, m[8], m[9],
							m[10],m[11],null, null,null);
					form.add(properties);
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

			JsonResponse<List<RestPurchaseAccountLedgerModel>> resp = new JsonResponse<List<RestPurchaseAccountLedgerModel>>();
			resp.setBody(form);

			ResponseEntity<JsonResponse<List<RestPurchaseAccountLedgerModel>>> response = new ResponseEntity<JsonResponse<List<RestPurchaseAccountLedgerModel>>>(
					resp, HttpStatus.CREATED);
			logger.info("Method : getSalesLedgerReportPdf ends");
			System.out.println("response"+response);
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
			 * DAO Function to Purchase Ledger Report Preview
			 *
			 */
			@SuppressWarnings("unchecked")

			public ResponseEntity<JsonResponse<List<RestPurchaseAccountLedgerModel>>> getPurchaseLedgerPreview(
					DataTableRequest request) {
				logger.info("Method : getPurchaseLedgerPreview starts");

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
				List<RestPurchaseAccountLedgerModel> form = new ArrayList<RestPurchaseAccountLedgerModel>();
				String values = GenerateParameter.getSearchParam(request);

				Integer total = 0;

				try {

					List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseRoutines")
							.setParameter("actionType", "getPurchasePreview").setParameter("actionValue", values).getResultList();

					for (Object[] m : x) {


						Object tPymntTransactionDate = null;
						if (m[4] != null) {
							tPymntTransactionDate = DateFormatter.returnStringDate(m[4]);
						}

						RestPurchaseAccountLedgerModel properties = new RestPurchaseAccountLedgerModel( m[0], m[1], m[2], m[3],
								tPymntTransactionDate, m[5], null, null, null, m[6], null,null, null, null, m[7], null, m[8], m[9],
								m[10],m[11],null, null,null);
						form.add(properties);
					}
					if (x.get(0).length > 12) {
						BigInteger t = (BigInteger) x.get(0)[12];

						total = Integer.parseInt((t.toString()));
					}

				} catch (Exception e) {

					e.printStackTrace();
				}

				JsonResponse<List<RestPurchaseAccountLedgerModel>> resp = new JsonResponse<List<RestPurchaseAccountLedgerModel>>();
				resp.setBody(form);
				resp.setTotal(total);

				ResponseEntity<JsonResponse<List<RestPurchaseAccountLedgerModel>>> response = new ResponseEntity<JsonResponse<List<RestPurchaseAccountLedgerModel>>>(
						resp, HttpStatus.CREATED);
				logger.info("Method : getPurchaseLedgerPreview ends");

				return response;
			}

			
				/*
				 * DAO Function to View all Purchase Reports in excel
				 *
				 */

				@SuppressWarnings("unchecked")

				public ResponseEntity<JsonResponse<List<RestPurchaseAccountLedgerModel>>> getPurchaseLedgerReportDownload(
						DataTableRequest request) {

					logger.info("Method : getPurchaseLedgerReportDownload starts");

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
					List<RestPurchaseAccountLedgerModel> form = new ArrayList<RestPurchaseAccountLedgerModel>();
					JsonResponse<List<RestPurchaseAccountLedgerModel>> resp = new JsonResponse<List<RestPurchaseAccountLedgerModel>>();
					String values = GenerateParameter.getSearchParam(request);

					try {

						List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseRoutines")
								.setParameter("actionType", "viewPurchaseXls").setParameter("actionValue", values).getResultList();

						for (Object[] m : x) {


							Object tPymntTransactionDate = null;
							if (m[4] != null) {
								tPymntTransactionDate = DateFormatter.returnStringDate(m[4]);
							}

							RestPurchaseAccountLedgerModel properties = new RestPurchaseAccountLedgerModel( m[0], m[1], m[2], m[3],
									tPymntTransactionDate, m[5], null, null, null, m[6], null,null, null, null, m[7], null, m[8], m[9],
									m[10],m[11],null, null,null);
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

					ResponseEntity<JsonResponse<List<RestPurchaseAccountLedgerModel>>> response = new ResponseEntity<JsonResponse<List<RestPurchaseAccountLedgerModel>>>(
							resp, HttpStatus.CREATED);
					logger.info("Method : getPurchaseLedgerReportDownload ends");

					return response;
				}




}
