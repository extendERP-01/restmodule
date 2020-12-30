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

import nirmalya.aatithya.restmodule.account.model.RestIncomeTaxPayableModel;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestIncomeTaxPayableDao {
	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	Logger logger = LoggerFactory.getLogger(RestIncomeTaxPayableDao.class);

	
		/*
		 * DAO Function to View sales Ledger Reports in PDF
		 *
		 */
		@SuppressWarnings("unchecked")

		public ResponseEntity<JsonResponse<List<RestIncomeTaxPayableModel>>> getIncomeTaxPayableReportPdf(
				DataTableRequest request) {
			logger.info("Method : getIncomeTaxPayableReportPdf starts");
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
			List<RestIncomeTaxPayableModel> form = new ArrayList<RestIncomeTaxPayableModel>();
			String values = GenerateParameter.getSearchParam(request);

			try {

				List<Object[]> x = em.createNamedStoredProcedureQuery("incomeTaxRoutines")
						.setParameter("actionType", "getIncomeTaxPdf").setParameter("actionValue", values).getResultList();

				for (Object[] m : x) {

					Object tPymntTransactionDate = null;
					if (m[2] != null) {
						tPymntTransactionDate = DateFormatter.returnStringDate(m[2]);
					}

					RestIncomeTaxPayableModel properties = new RestIncomeTaxPayableModel( null, m[0], m[1], null,
							tPymntTransactionDate,null, null, null, null, m[3], null, null, null, null, m[4], m[5], null,
							null,null,	null, null,null,null);
					form.add(properties);
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

			JsonResponse<List<RestIncomeTaxPayableModel>> resp = new JsonResponse<List<RestIncomeTaxPayableModel>>();
			resp.setBody(form);

			ResponseEntity<JsonResponse<List<RestIncomeTaxPayableModel>>> response = new ResponseEntity<JsonResponse<List<RestIncomeTaxPayableModel>>>(
					resp, HttpStatus.CREATED);
			logger.info("Method : getIncomeTaxPayableReportPdf ends");

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
			 * DAO Function to View Income Tax Payable in excel
			 *
			 */

			@SuppressWarnings("unchecked")

			public ResponseEntity<JsonResponse<List<RestIncomeTaxPayableModel>>> getIncomeTaxReportDownload(
					DataTableRequest request) {

				logger.info("Method : getIncomeTaxReportDownload starts");

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
				List<RestIncomeTaxPayableModel> form = new ArrayList<RestIncomeTaxPayableModel>();
				JsonResponse<List<RestIncomeTaxPayableModel>> resp = new JsonResponse<List<RestIncomeTaxPayableModel>>();
				String values = GenerateParameter.getSearchParam(request);

				try {

					List<Object[]> x = em.createNamedStoredProcedureQuery("incomeTaxRoutines")
							.setParameter("actionType", "viewIncomeTaxXls").setParameter("actionValue", values).getResultList();

					for (Object[] m : x) {

						Object tPymntTransactionDate = null;
						if (m[2] != null) {
							tPymntTransactionDate = DateFormatter.returnStringDate(m[2]);
						}

						RestIncomeTaxPayableModel properties = new RestIncomeTaxPayableModel( null, m[0], m[1], null,
								tPymntTransactionDate,null, null, null, null, m[3], null, null, null, null, m[4], m[5], null,
								null,null,	null, null,null,null);
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

				ResponseEntity<JsonResponse<List<RestIncomeTaxPayableModel>>> response = new ResponseEntity<JsonResponse<List<RestIncomeTaxPayableModel>>>(
						resp, HttpStatus.CREATED);
				logger.info("Method : getIncomeTaxReportDownload ends");

				return response;
			}

		
				/*
				 * DAO Function to Purchase Ledger Report Preview
				 *
				 */
				@SuppressWarnings("unchecked")

				public ResponseEntity<JsonResponse<List<RestIncomeTaxPayableModel>>> getIncomeTaxPayablePreview(
						DataTableRequest request) {
					logger.info("Method : getIncomeTaxPayablePreview starts");

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
					List<RestIncomeTaxPayableModel> form = new ArrayList<RestIncomeTaxPayableModel>();
					String values = GenerateParameter.getSearchParam(request);

					Integer total = 0;

					try {

						List<Object[]> x = em.createNamedStoredProcedureQuery("incomeTaxRoutines")
								.setParameter("actionType", "getIncomeTaxPreview").setParameter("actionValue", values).getResultList();

						for (Object[] m : x) {

							Object tPymntTransactionDate = null;
							if (m[2] != null) {
								tPymntTransactionDate = DateFormatter.returnStringDate(m[2]);
							}

							RestIncomeTaxPayableModel properties = new RestIncomeTaxPayableModel( null, m[0], m[1], null,
									tPymntTransactionDate,null, null, null, null, m[3], null, null, null, null, m[4], m[5], null,
									null,null,	null, null,null,null);
							form.add(properties);
						}
						if (x.get(0).length > 6) {
							BigInteger t = (BigInteger) x.get(0)[6];

							total = Integer.parseInt((t.toString()));
						}

					} catch (Exception e) {

						e.printStackTrace();
					}

					JsonResponse<List<RestIncomeTaxPayableModel>> resp = new JsonResponse<List<RestIncomeTaxPayableModel>>();
					resp.setBody(form);
					resp.setTotal(total);

					ResponseEntity<JsonResponse<List<RestIncomeTaxPayableModel>>> response = new ResponseEntity<JsonResponse<List<RestIncomeTaxPayableModel>>>(
							resp, HttpStatus.CREATED);
					logger.info("Method : getIncomeTaxPayablePreview ends");

					return response;
				}

				


}
