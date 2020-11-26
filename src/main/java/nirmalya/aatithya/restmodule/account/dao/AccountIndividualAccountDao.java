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

import nirmalya.aatithya.restmodule.account.model.AccountIndividualAccountDetailsModal;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class AccountIndividualAccountDao {

	Logger logger = LoggerFactory.getLogger(AccountTrialBalanceDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for Account head list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAccountHeads() {

		logger.info("Method in Dao: getAccountHeads starts");

		List<DropDownModel> accountHeadList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("individualRoutines")
					.setParameter("actionType", "getAccountHeads").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				accountHeadList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getAccountHeads ends");

		return accountHeadList;
	}

	/*
	 * for individual account details
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountIndividualAccountDetailsModal>>> getAIndividualAccountReportCr(
			DataTableRequest request) {

		logger.info("Method in Dao: getAIndividualAccountReportCr  starts");

		List<AccountIndividualAccountDetailsModal> trialBalanceModel = new ArrayList<AccountIndividualAccountDetailsModal>();
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

			List<Object[]> x = em.createNamedStoredProcedureQuery("individualRoutines")
					.setParameter("actionType", "getIndvDtlsCredit").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					
					 
					Object ob = DateFormatter.returnStringDateMMMFormat(m[3]);
					AccountIndividualAccountDetailsModal voucher = new AccountIndividualAccountDetailsModal(m[0], m[1],
							m[2], ob);
					trialBalanceModel.add(voucher);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<AccountIndividualAccountDetailsModal>> resp = new JsonResponse<List<AccountIndividualAccountDetailsModal>>();
		resp.setBody(trialBalanceModel);
		resp.setTotal(total);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AccountIndividualAccountDetailsModal>>> response = new ResponseEntity<JsonResponse<List<AccountIndividualAccountDetailsModal>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getAIndividualAccountReportCr ends");
		return response;
	}

	/*
	 * for individual account details
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountIndividualAccountDetailsModal>>> getAIndividualAccountReportDr(
			DataTableRequest request) {

		logger.info("Method in Dao: getAIndividualAccountReportDr  starts");

		List<AccountIndividualAccountDetailsModal> trialBalanceModel = new ArrayList<AccountIndividualAccountDetailsModal>();
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

			List<Object[]> x = em.createNamedStoredProcedureQuery("individualRoutines")
					.setParameter("actionType", "getIndvDtlsDebit").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object ob = DateFormatter.returnStringDateMMMFormat(m[3]);
					AccountIndividualAccountDetailsModal voucher = new AccountIndividualAccountDetailsModal(m[0], m[1],
							m[2], ob);
					trialBalanceModel.add(voucher);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<AccountIndividualAccountDetailsModal>> resp = new JsonResponse<List<AccountIndividualAccountDetailsModal>>();
		resp.setBody(trialBalanceModel);
		resp.setTotal(total);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AccountIndividualAccountDetailsModal>>> response = new ResponseEntity<JsonResponse<List<AccountIndividualAccountDetailsModal>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getAIndividualAccountReportDr ends");
		System.out.println(response);
		return response;
	}

	/**
	 * DAO - Get Hotel Logo
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getHotelLogoForIndvDtls(String logoType) {
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
