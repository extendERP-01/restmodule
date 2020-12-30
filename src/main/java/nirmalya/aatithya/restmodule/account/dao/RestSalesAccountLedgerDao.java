package nirmalya.aatithya.restmodule.account.dao;
/*
 * @author Nirmalya Labs
 *
 */

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

import nirmalya.aatithya.restmodule.account.model.RestSalesAccountLedgerModel;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestSalesAccountLedgerDao {

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	Logger logger = LoggerFactory.getLogger(RestSalesAccountLedgerDao.class);

	/*
	 * DAO Function to View sales Ledger Reports in PDF
	 *
	 */
	@SuppressWarnings("unchecked")

	public ResponseEntity<JsonResponse<List<RestSalesAccountLedgerModel>>> getSalesLedgerReportPdf(
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
		List<RestSalesAccountLedgerModel> form = new ArrayList<RestSalesAccountLedgerModel>();
		String values = GenerateParameter.getSearchParam(request);

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesRoutines")
					.setParameter("actionType", "getSalesPdf").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object createdOn = null;
				if (m[9] != null) {
					createdOn = DateFormatter.returnStringDate(m[9]);
				}

				RestSalesAccountLedgerModel properties = new RestSalesAccountLedgerModel(null, m[0], m[1], m[2], m[3],
						null, null, m[4], m[5], m[6], m[7], null, null, null, null, null, null, m[8], null, createdOn,
						null);
				form.add(properties);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		JsonResponse<List<RestSalesAccountLedgerModel>> resp = new JsonResponse<List<RestSalesAccountLedgerModel>>();
		resp.setBody(form);

		ResponseEntity<JsonResponse<List<RestSalesAccountLedgerModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesAccountLedgerModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSalesLedgerReportPdf ends");

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
	 * DAO Function to Sales Ledger Report Preview
	 *
	 */
	@SuppressWarnings("unchecked")

	public ResponseEntity<JsonResponse<List<RestSalesAccountLedgerModel>>> getSalesLedgerPreview(
			DataTableRequest request) {
		logger.info("Method : getSalesLedgerPreview starts");

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
		List<RestSalesAccountLedgerModel> form = new ArrayList<RestSalesAccountLedgerModel>();
		String values = GenerateParameter.getSearchParam(request);

		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesRoutines")
					.setParameter("actionType", "getSalesPreview").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object createdOn = null;
				if (m[9] != null) {
					createdOn = DateFormatter.returnStringDate(m[9]);
				}

				RestSalesAccountLedgerModel properties = new RestSalesAccountLedgerModel(null, m[0], m[1], m[2], m[3],
						null, null, m[4], m[5], m[6], m[7], null, null, null, null, null, null, m[8], null, createdOn,
						null);
				form.add(properties);
			}
			if(x.size()>0) {
				if (x.get(0).length > 10) {
					BigInteger t = (BigInteger) x.get(0)[10];
	
					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		JsonResponse<List<RestSalesAccountLedgerModel>> resp = new JsonResponse<List<RestSalesAccountLedgerModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<RestSalesAccountLedgerModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesAccountLedgerModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSalesLedgerPreview ends");

		return response;
	}

	/*
	 * DAO Function to View all Ledger Reports in excel
	 *
	 */

	@SuppressWarnings("unchecked")

	public ResponseEntity<JsonResponse<List<RestSalesAccountLedgerModel>>> getSalesLedgerReportDownload(
			DataTableRequest request) {

		logger.info("Method : getSalesLedgerReportDownload starts");

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
		List<RestSalesAccountLedgerModel> form = new ArrayList<RestSalesAccountLedgerModel>();
		JsonResponse<List<RestSalesAccountLedgerModel>> resp = new JsonResponse<List<RestSalesAccountLedgerModel>>();
		String values = GenerateParameter.getSearchParam(request);

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesRoutines")
					.setParameter("actionType", "viewSalesXls").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object createdOn = null;
				if (m[10] != null) {
					createdOn = DateFormatter.returnStringDate(m[10]);
				}

				RestSalesAccountLedgerModel properties = new RestSalesAccountLedgerModel(m[0], m[1], m[2], m[3], m[4],
						null, null, m[5], m[6], m[7], m[8], null, null, null, null, null, null, m[9], null, createdOn,
						null);
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

		ResponseEntity<JsonResponse<List<RestSalesAccountLedgerModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesAccountLedgerModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSalesLedgerReportDownload ends");

		return response;
	}

}
