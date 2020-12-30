package nirmalya.aatithya.restmodule.account.dao;

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

import nirmalya.aatithya.restmodule.account.model.AccountCashBookCreditModel;
import nirmalya.aatithya.restmodule.account.model.AccountCashBookDebitModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class AccountCashBookDao {

	Logger logger = LoggerFactory.getLogger(AccountCashBookDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for all payment voucher getAll Debit balance
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountCashBookDebitModel>>> getAllDebitBalance(DataTableRequest request) {

		logger.info("Method in Dao: getAllDebitBalance  starts");

		List<AccountCashBookDebitModel> accountCashBookDebitModel = new ArrayList<AccountCashBookDebitModel>();
		String param1 = request.getParam1();
		String param2 = request.getParam2();
		if (param1 != null && param1 != "") {
			request.setParam1(DateFormatter.getStringDate(param1));
		}
		if (param2 != null && param2 != "") {
			request.setParam2(DateFormatter.getStringDate(param2));
		}
		String values = GenerateParameter.getSearchParam(request);

		Integer total = 0;
		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("cashBookRoutines")
					.setParameter("actionType", "getDebits").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object oa = DateFormatter.returnStringDate(m[0]);
					AccountCashBookDebitModel debit = new AccountCashBookDebitModel(oa, m[1], m[2], m[3]);
					accountCashBookDebitModel.add(debit);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<AccountCashBookDebitModel>> resp = new JsonResponse<List<AccountCashBookDebitModel>>();
		resp.setBody(accountCashBookDebitModel);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AccountCashBookDebitModel>>> response = new ResponseEntity<JsonResponse<List<AccountCashBookDebitModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getAllDebitBalance ends");
		return response;
	}

	/*
	 * for all payment voucher getAll Debit balance
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountCashBookCreditModel>>> getAllCreditBalance(
			DataTableRequest request) {

		logger.info("Method in Dao: getAllCreditBalance  starts");

		List<AccountCashBookCreditModel> accountCashBookCreditModel = new ArrayList<AccountCashBookCreditModel>();
		String param1 = request.getParam1();
		String param2 = request.getParam2();
		if (param1 != null && param1 != "") {
			request.setParam1(DateFormatter.getStringDate(param1));
		}
		if (param2 != null && param2 != "") {
			request.setParam2(DateFormatter.getStringDate(param2));
		}
		String values = GenerateParameter.getSearchParam(request);

		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("cashBookRoutines")
					.setParameter("actionType", "getCredits").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object oa = DateFormatter.returnStringDate(m[0]);
					AccountCashBookCreditModel debit = new AccountCashBookCreditModel(oa, m[1], m[2], m[3]);
					accountCashBookCreditModel.add(debit);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<AccountCashBookCreditModel>> resp = new JsonResponse<List<AccountCashBookCreditModel>>();
		resp.setBody(accountCashBookCreditModel);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AccountCashBookCreditModel>>> response = new ResponseEntity<JsonResponse<List<AccountCashBookCreditModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getAllCreditBalance ends");
		return response;
	}

	/*
	 * for cost center list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCostCenterCB() {

		logger.info("Method in Dao: getCostCenterCB starts");

		List<DropDownModel> payModeList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("cashBookRoutines")
					.setParameter("actionType", "getCostCenterCB").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				payModeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getCostCenterCB ends");

		return payModeList;
	}

	
	/**
	 * DAO - Get Hotel Logo
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getHotelLogoForCashBook(String logoType) {
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
}
