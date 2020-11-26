package nirmalya.aatithya.restmodule.inventory.dao;

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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;

import nirmalya.aatithya.restmodule.common.utils.GenerateInventoryPaymentVoucherParam;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.InventoryGrnPaymentDetails;
import nirmalya.aatithya.restmodule.inventory.model.PaymentVoucherModel;

@Repository
public class PaymentVoucherDao {
	Logger logger = LoggerFactory.getLogger(PaymentVoucherDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * get all purchase order list by auto search
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPOrderByAutosearch(String id) {
		logger.info("Method : getPOrderByAutosearch Dao starts");

		List<DropDownModel> guestList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_guest='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "getPONumber").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				guestList.add(dropDownModel);
			}

			resp.setBody(guestList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getPOrderByAutosearch Dao ends");
		return response;
	}

	/*
	 * get all vendor list by auto search getVendorByAutosearch
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorByAutosearch(String id) {
		logger.info("Method : getVendorByAutosearch Dao starts");

		List<DropDownModel> guestList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_Vendor='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "getVendor").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				guestList.add(dropDownModel);
			}

			resp.setBody(guestList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getVendorByAutosearch Dao ends");
		return response;
	}

	/*
	 * for grn list for add schedule date
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PaymentVoucherModel>>> getGRNList(DataTableRequest request) {

		logger.info("Method in Dao: getGRNList starts");

		List<PaymentVoucherModel> paymentVoucherModel = new ArrayList<PaymentVoucherModel>();

		String param3 = request.getParam3();
		String param4 = request.getParam4();
		if (param3 != null && param3 != "") {
			String frmDate = DateFormatter.getStringDate(param3);

			request.setParam3(frmDate);
		}
		if (param4 != null && param4 != "") {
			String tDate = DateFormatter.getStringDate(param4);

			request.setParam4(tDate);
		}

		String values = GenerateParameter.getSearchParam(request);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "getGnsList").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object oa = null;
					if (m[13] != null) {
						oa = DateFormatter.returnStringDate(m[13]);
					} else {
						oa = "--";
					}
					PaymentVoucherModel gsnList = new PaymentVoucherModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
							m[7], m[8], m[9], m[10], m[11], m[12], null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, oa, null, null, null, null, null, null, null,null);
					paymentVoucherModel.add(gsnList);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<PaymentVoucherModel>> resp = new JsonResponse<List<PaymentVoucherModel>>();
		resp.setBody(paymentVoucherModel);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<PaymentVoucherModel>>> response = new ResponseEntity<JsonResponse<List<PaymentVoucherModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getGRNList ends");
		return response;
	}

	/*
	 * get payment voucher details by grn number
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PaymentVoucherModel>>> getPaymentValues(String id) {
		logger.info("Method : getPaymentValues Dao starts");

		List<PaymentVoucherModel> paymentVoucherModelList = new ArrayList<PaymentVoucherModel>();
		JsonResponse<List<PaymentVoucherModel>> resp = new JsonResponse<List<PaymentVoucherModel>>();

		try {
			String value = "SET @p_grnNO='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "getPaymentValues").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				PaymentVoucherModel voucher = new PaymentVoucherModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], null, m[13], m[14], null, m[15], m[16], m[17], m[18], m[19],
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, m[20], null, null, null, null, null, m[21], m[22], null,null);
				paymentVoucherModelList.add(voucher);
			}

			resp.setBody(paymentVoucherModelList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<PaymentVoucherModel>>> response = new ResponseEntity<JsonResponse<List<PaymentVoucherModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getPaymentValues Dao ends");
		return response;
	}
	/*
	 * get return values of grn list
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PaymentVoucherModel>>> getReturnValues(String id) {
		logger.info("Method : getReturnValues Dao starts");

		List<PaymentVoucherModel> paymentVoucherModelList = new ArrayList<PaymentVoucherModel>();
		JsonResponse<List<PaymentVoucherModel>> resp = new JsonResponse<List<PaymentVoucherModel>>();

		try {
			String value = "SET @p_grnNO='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "getReturnValues").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				PaymentVoucherModel dropDownModel = new PaymentVoucherModel(null, m[0], m[1], null, null, null, null,
						null, null, null, m[2], null, null, m[3], null, null, m[4], m[5], m[6], m[7], m[8], m[9], null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null,null);
				paymentVoucherModelList.add(dropDownModel);
			}
			resp.setBody(paymentVoucherModelList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<PaymentVoucherModel>>> response = new ResponseEntity<JsonResponse<List<PaymentVoucherModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getReturnValues Dao ends");
		return response;
	}

	/*
	 * drop down for payment Modes
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPayMode() {

		logger.info("Method in Dao: getPayMode starts");

		List<DropDownModel> payModeList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "getPayMode").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				payModeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getPayMode ends");

		return payModeList;
	}

	/*
	 * drop down for bank names
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getBankNames() {

		logger.info("Method in Dao: getBankNames starts");

		List<DropDownModel> bankList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "getBankNames").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				bankList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getBankNames ends");

		return bankList;
	}

	/*
	 * Drop down for branch list by bank name
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getBranchList(String id) {
		logger.info("Method in Dao: getBranchList starts");

		List<DropDownModel> branchList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_bankId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "getBranchList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				branchList.add(dropDownModel);
			}

			resp.setBody(branchList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getBranchList ends");
		return response;
	}

	/*
	 * Drop down for account no list by branch name
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAccountNoList(String id) {
		logger.info("Method in Dao: getAccountNoList starts");

		List<DropDownModel> accNoList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_branchId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "getAccountNoList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				accNoList.add(dropDownModel);
			}

			resp.setBody(accNoList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAccountNoList ends");
		return response;
	}

	/*
	 * Drop down for account holder name by account number
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAccountNameList(String id) {
		logger.info("Method in Dao: getAccountNameList starts");

		List<DropDownModel> accNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_accNo='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "getAccountNameList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				accNameList.add(dropDownModel);
			}

			resp.setBody(accNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAccountNameList ends");
		return response;
	}

	/*
	 * for add payment voucher
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> restAddPaymentVoucher(List<PaymentVoucherModel> paymentVoucherModel) {

		logger.info("Method in Dao:Add  restAddPaymentVoucher starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (PaymentVoucherModel a : paymentVoucherModel) {
			if (a.getVendorName() == null || a.getVendorName() == "") {
				validity = false;
			} else if (a.getPaymentMode() == null || a.getPaymentMode() == "") {
				resp.setMessage("Select Payment Mode");
				validity = false;
			}
		}
		List<PaymentVoucherModel> paymentVoucherModelList = new ArrayList<PaymentVoucherModel>();
		if (validity)
			try {
				String values = GenerateInventoryPaymentVoucherParam.getPaymentVoucherParam(paymentVoucherModel);
				List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
						.setParameter("actionType", "addPaymentVoucher").setParameter("actionValue", values)
						.getResultList();

				if (!x.isEmpty()) {
					for (Object[] m : x) {
						PaymentVoucherModel voucher = new PaymentVoucherModel(null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, m[0], m[1], null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null,null);
						paymentVoucherModelList.add(voucher);

					}
				}

				resp.setBody(paymentVoucherModelList);

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

		logger.info("Method in Dao: Add restAddPaymentVoucher ends");

		return response;
	}

	/*
	 * for all paid payment voucher view page
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PaymentVoucherModel>>> getAllPaymentVoucher(DataTableRequest request) {

		logger.info("Method in Dao: getAllPaymentVoucher starts");

		List<PaymentVoucherModel> paymentVoucherModelList = new ArrayList<PaymentVoucherModel>();
		String param3 = request.getParam3();
		String param4 = request.getParam4();
		if (param3 != null && param3 != "") {
			request.setParam3(DateFormatter.getStringDate(param3));
		}
		if (param4 != null && param4 != "") {
			request.setParam4(DateFormatter.getStringDate(param4));
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "allPaymentVoucher").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object oa = DateFormatter.returnStringDate(m[13]);
					PaymentVoucherModel voucher = new PaymentVoucherModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
							m[7], m[8], m[9], m[10], m[11], m[12], null, null, null, null, null, null, null, null, null,
							oa, m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21], null, null, null, null, null,
							null, null, null, null, null, null, null, null, null, null, null, null, null, m[22], m[23],null);
					paymentVoucherModelList.add(voucher);

				}

				if (x.get(0).length > 24) {
					BigInteger t = (BigInteger) x.get(0)[24];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<PaymentVoucherModel>> resp = new JsonResponse<List<PaymentVoucherModel>>();
		resp.setBody(paymentVoucherModelList);
		resp.setTotal(total);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<PaymentVoucherModel>>> response = new ResponseEntity<JsonResponse<List<PaymentVoucherModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getAllPaymentVoucher ends");
		return response;
	}

	/*
	 * for all payment voucher getAllPaymentVoucherReport
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PaymentVoucherModel>>> getAllPaymentVoucherReport(
			DataTableRequest request) {

		logger.info("Method in Dao: getAllPaymentVoucherReport  starts");

		List<PaymentVoucherModel> paymentVoucherModelList = new ArrayList<PaymentVoucherModel>();
		String param3 = request.getParam3();
		String param4 = request.getParam4();
		if (param3 != null && param3 != "") {
			request.setParam3(DateFormatter.getStringDate(param3));
		}
		if (param4 != null && param4 != "") {
			request.setParam4(DateFormatter.getStringDate(param4));
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "PaymentVoucherReport").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object oa = DateFormatter.returnStringDate(m[20]);
					PaymentVoucherModel voucher = new PaymentVoucherModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
							m[7], m[8], m[9], m[10], m[11], m[12], m[13], null, null, m[14], m[15], m[16], m[17], m[18],
							m[19], oa, m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28], null, null, null, null,
							null, null, null, null, null, m[29], m[30], m[31], null, null, null, null, null, null, null,
							null,null);
					paymentVoucherModelList.add(voucher);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<PaymentVoucherModel>> resp = new JsonResponse<List<PaymentVoucherModel>>();
		resp.setBody(paymentVoucherModelList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<PaymentVoucherModel>>> response = new ResponseEntity<JsonResponse<List<PaymentVoucherModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getAllPaymentVoucherReport ends");

		return response;
	}

	/*
	 * for get return details by payment voucher
	 */

	@SuppressWarnings("unchecked")
	public List<PaymentVoucherModel> getReturnData(String id) {
		logger.info("Method in Dao: getReturnData Starts");

		List<PaymentVoucherModel> paymentVoucherModelList = new ArrayList<PaymentVoucherModel>();
		try {

			String value = "SET @p_paymentVoucher='" + id + "';";
System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "getReturnData").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object oa = DateFormatter.returnStringDate(m[13]);
				PaymentVoucherModel voucher = new PaymentVoucherModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], null, null, null, null, null, null, null, null, null, oa,
						m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21], null, null, null, null, null, null,
						null, null, null, m[22], m[23], m[24], null, null, null, null, m[25], m[26], m[27], null,m[28]);
				paymentVoucherModelList.add(voucher);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(paymentVoucherModelList);
		
		logger.info("Method in Dao: getReturnData ends");
		return paymentVoucherModelList;
	}

	/*
	 * for getVenderDetails
	 */
	@SuppressWarnings("unchecked")
	public List<PaymentVoucherModel> getVenderDetails(String userId) {
		logger.info("Method in Dao: getVenderDetails starts");

		List<PaymentVoucherModel> paymentVoucherModelList = new ArrayList<PaymentVoucherModel>();

		try {
			String value = "SET @p_VenderId='" + userId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "getVenderDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				PaymentVoucherModel dropDownModel = new PaymentVoucherModel(m[0], m[1], null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, m[2], m[3], m[4], m[5], null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null,null);
				paymentVoucherModelList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getVenderDetails ends");
		return paymentVoucherModelList;
	}

	/*
	 * for getHotelDetails
	 */
	@SuppressWarnings("unchecked")
	public List<PaymentVoucherModel> getHotelDetails(String userId) {
		logger.info("Method in Dao: getHotelDetails starts");

		List<PaymentVoucherModel> paymentVoucherModelList = new ArrayList<PaymentVoucherModel>();

		try {
			String value = "SET @p_userId='" + userId + "';";
			System.out.println("value " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "getHotelDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				PaymentVoucherModel dropDownModel = new PaymentVoucherModel(null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, m[0], m[1], m[2], m[3],
						m[4], null, null, null, null, null, null, null, null, null, null, null,null);
				paymentVoucherModelList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getHotelDetails ends");
		return paymentVoucherModelList;
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

	/*
	 * for all payment voucher not approved or scheduled
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PaymentVoucherModel>>> getAllPaymentVoucherAccountantUnpaid(
			DataTableRequest request) {

		logger.info("Method in Dao: getAllPaymentVoucherAccountantUnpaid starts");

		List<PaymentVoucherModel> paymentVoucherUnpaid = new ArrayList<PaymentVoucherModel>();

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "allPVUnpaid").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object oa = DateFormatter.returnStringDate(m[6]);
					PaymentVoucherModel voucher = new PaymentVoucherModel(null, m[0], m[1], m[2], null, m[3], m[4],
							null, null, null, null, null, m[5], null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, oa, null, null, null, null, null, null, null,null);
					paymentVoucherUnpaid.add(voucher);

				}

				if (x.get(0).length > 7) {
					BigInteger t = (BigInteger) x.get(0)[7];

					total = Integer.parseInt((t.toString()));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<PaymentVoucherModel>> resp = new JsonResponse<List<PaymentVoucherModel>>();
		resp.setBody(paymentVoucherUnpaid);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<PaymentVoucherModel>>> response = new ResponseEntity<JsonResponse<List<PaymentVoucherModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getAllPaymentVoucherAccountantUnpaid ends");

		return response;
	}

	/*
	 * for all payment voucher unpaid but scheduled
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PaymentVoucherModel>>> getAllPaymentVoucherAccountantUnpaidAprove(
			DataTableRequest request) {

		logger.info("Method in Dao: getAllPaymentVoucherAccountantUnpaid starts");

		List<PaymentVoucherModel> paymentVoucherUnpaid = new ArrayList<PaymentVoucherModel>();

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "allPVUnpaidAprove").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object oa = DateFormatter.returnStringDate(m[6]);
					Object ob = DateFormatter.returnStringDate(m[7]);
					PaymentVoucherModel voucher = new PaymentVoucherModel(null, m[0], m[1], m[2], null, m[3], m[4],
							null, null, null, null, null, m[5], null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, ob, oa, m[8], null, null, null, null, null,null);
					paymentVoucherUnpaid.add(voucher);

				}

				if (x.get(0).length > 9) {
					BigInteger t = (BigInteger) x.get(0)[9];

					total = Integer.parseInt((t.toString()));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<PaymentVoucherModel>> resp = new JsonResponse<List<PaymentVoucherModel>>();
		resp.setBody(paymentVoucherUnpaid);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<PaymentVoucherModel>>> response = new ResponseEntity<JsonResponse<List<PaymentVoucherModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getAllPaymentVoucherAccountantUnpaid ends");

		return response;
	}

	/**
	 * DAO Function to add schedule date
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> getEditScheduleDate(List<PaymentVoucherModel> paymentVoucherModel) {
		logger.info("Method : getEditScheduleDate starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String s = "'(";
			String date1 = "";
			for (PaymentVoucherModel a : paymentVoucherModel) {
				date1 = DateFormatter.getStringDate(a.getDueDate());
				s = s + "\"" + a.getGrnNo() + "\",";
			}
			if (s != "") {
				s = s.substring(0, s.length() - 1);
			}
			s = s + ")'";
			String values = "SET @p_grnId=" + s + ",@p_date='" + date1 + "';";

			em.createNamedStoredProcedureQuery("paymentVoucher").setParameter("actionType", "addSchdlDate")
					.setParameter("actionValue", values).execute();

		} catch (Exception e) {
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

		logger.info("Method : getEditScheduleDate ends");
		return response;
	}

	/**
	 * DAO Function to approve schedule date
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> getApproveScheduleDate(List<PaymentVoucherModel> paymentVoucherModel) {
		logger.info("Method : getApproveScheduleDate starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String s = "'(";
			for (PaymentVoucherModel a : paymentVoucherModel) {
				s = s + "\"" + a.getGrnNo() + "\",";
			}
			if (s != "") {
				s = s.substring(0, s.length() - 1);
			}
			s = s + ")'";
			String values = "SET @p_grnId=" + s + ";";
			em.createNamedStoredProcedureQuery("paymentVoucher").setParameter("actionType", "approveSch")
					.setParameter("actionValue", values).execute();

		} catch (Exception e) {
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

		logger.info("Method : getApproveScheduleDate ends");
		return response;
	}

	/*
	 * for grn list payment for add payment voucher
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PaymentVoucherModel>>> getGRNListPayment(DataTableRequest request) {

		logger.info("Method in Dao: getGRNListPayment starts");

		List<PaymentVoucherModel> paymentVoucherModel = new ArrayList<PaymentVoucherModel>();

		String param3 = request.getParam3();
		String param4 = request.getParam4();
		if (param3 != null && param3 != "") {
			String frmDate = DateFormatter.getStringDate(param3);

			request.setParam3(frmDate);
		}
		if (param4 != null && param4 != "") {
			String tDate = DateFormatter.getStringDate(param4);

			request.setParam4(tDate);
		}

		String values = GenerateParameter.getSearchParam(request);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "getGRNListPayment").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object oa = null;
					if (m[13] != null) {
						oa = DateFormatter.returnStringDate(m[13]);
					} else {
						oa = "--";
					}

					PaymentVoucherModel gsnList = new PaymentVoucherModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
							m[7], m[8], m[9], m[10], m[11], m[12], null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, oa, null, null, m[14], null, m[15], m[16], null, m[17]);
					paymentVoucherModel.add(gsnList);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<PaymentVoucherModel>> resp = new JsonResponse<List<PaymentVoucherModel>>();
		resp.setBody(paymentVoucherModel);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<PaymentVoucherModel>>> response = new ResponseEntity<JsonResponse<List<PaymentVoucherModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getGRNListPayment ends");
		return response;
	}

	/*
	 * for get grn by payment voucher id
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<PaymentVoucherModel>> getGrnById(String id) {

		logger.info("Method in Dao: getGrnById ends");

		List<PaymentVoucherModel> paymentVoucherModelList = new ArrayList<PaymentVoucherModel>();

		try {

			String value = "SET @p_paymentVoucher='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "getGrnById").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				PaymentVoucherModel voucher = new PaymentVoucherModel(null, m[0], m[1], m[2], null, m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], null, null, m[12], m[13], m[14], m[15], m[16], m[17],
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null,null);
				paymentVoucherModelList.add(voucher);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<PaymentVoucherModel> resp = new JsonResponse<PaymentVoucherModel>();
		resp.setBody(paymentVoucherModelList.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<PaymentVoucherModel>> response = new ResponseEntity<JsonResponse<PaymentVoucherModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getGrnById ends");
		return response;
	}

	/*
	 * for get payment details by reference number
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<PaymentVoucherModel>> getPaymentVoucherById(String id) {

		logger.info("Method in Dao: getGrnById ends");

		List<PaymentVoucherModel> paymentVoucherModelList = new ArrayList<PaymentVoucherModel>();

		try {

			String value = "SET @p_refNo='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "getPVByRefId").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				Object oa = DateFormatter.returnStringDate(m[20]);
				PaymentVoucherModel voucher = new PaymentVoucherModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], null, null, m[14], m[15], m[16], m[17], m[18], m[19],
						oa, m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28], null, null, null, null, null, null,
						null, null, null, m[29], m[30], m[31], null, null, null, null, m[32], null, null, null,null);
				paymentVoucherModelList.add(voucher);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<PaymentVoucherModel> resp = new JsonResponse<PaymentVoucherModel>();
		resp.setBody(paymentVoucherModelList.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<PaymentVoucherModel>> response = new ResponseEntity<JsonResponse<PaymentVoucherModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getGrnById ends");

		return response;
	}

	/*
	 * get last payment details
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventoryGrnPaymentDetails>>> getPartialPaymentDetails(String id) {
		logger.info("Method : getPartialPaymentDetails Dao starts");

		List<InventoryGrnPaymentDetails> partialPaymentList = new ArrayList<InventoryGrnPaymentDetails>();
		JsonResponse<List<InventoryGrnPaymentDetails>> resp = new JsonResponse<List<InventoryGrnPaymentDetails>>();

		try {
			String value = "SET @p_grnNO='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "getPartialPayDtls").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object oa = DateFormatter.returnStringDate(m[6]);

				InventoryGrnPaymentDetails payments = new InventoryGrnPaymentDetails(m[0], m[1], m[2], m[3], m[4], m[5],
						oa, null, null, null);
				partialPaymentList.add(payments);
			}
			resp.setBody(partialPaymentList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<InventoryGrnPaymentDetails>>> response = new ResponseEntity<JsonResponse<List<InventoryGrnPaymentDetails>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getPartialPaymentDetails Dao ends");
		return response;
	}

	/*
	 * get return values of credit details
	 * 
	 * 
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<List<InventoryGrnPaymentDetails>>>
	 * getCreditDetails(String id) {
	 * logger.info("Method : getCreditDetails Dao starts");
	 * 
	 * List<InventoryGrnPaymentDetails> partialPaymentList = new
	 * ArrayList<InventoryGrnPaymentDetails>();
	 * JsonResponse<List<InventoryGrnPaymentDetails>> resp = new
	 * JsonResponse<List<InventoryGrnPaymentDetails>>();
	 * 
	 * try { String value = "SET @p_grnNO='" + id + "';"; List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("paymentVoucher")
	 * .setParameter("actionType", "getCreditDetails").setParameter("actionValue",
	 * value).getResultList();
	 * 
	 * for (Object[] m : x) {
	 * 
	 * Object creditDate = DateFormatter.returnStringDate(m[0]);
	 * InventoryGrnPaymentDetails payments = new InventoryGrnPaymentDetails(null,
	 * null, null, null, null, null, null, creditDate, m[1], m[2]);
	 * partialPaymentList.add(payments); } resp.setBody(partialPaymentList); } catch
	 * (Exception e) { e.printStackTrace(); }
	 * 
	 * ResponseEntity<JsonResponse<List<InventoryGrnPaymentDetails>>> response = new
	 * ResponseEntity<JsonResponse<List<InventoryGrnPaymentDetails>>>( resp,
	 * HttpStatus.CREATED);
	 * 
	 * logger.info("Method : getCreditDetails Dao ends"); return response; }
	 */

	/*
	 * for get all previous payment details
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryGrnPaymentDetails>> getAllPreviousPayments(String id) {

		logger.info("Method in Dao: getGrnById ends");

		List<InventoryGrnPaymentDetails> inventoryGrnPaymentDetailsList = new ArrayList<InventoryGrnPaymentDetails>();

		try {

			String value = "SET @p_refNo='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "getPartialPayDtls").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				Object oa = DateFormatter.returnStringDate(m[1]);
				InventoryGrnPaymentDetails voucher = new InventoryGrnPaymentDetails(m[0], oa, m[2], m[3], m[4], m[5],
						m[6], null, null, null);
				inventoryGrnPaymentDetailsList.add(voucher);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<InventoryGrnPaymentDetails> resp = new JsonResponse<InventoryGrnPaymentDetails>();
		resp.setBody(inventoryGrnPaymentDetailsList.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<InventoryGrnPaymentDetails>> response = new ResponseEntity<JsonResponse<InventoryGrnPaymentDetails>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getGrnById ends");

		return response;
	}

	/*
	 * for get return details by payment voucher
	 */

	@SuppressWarnings("unchecked")
	public List<PaymentVoucherModel> getPaymentDataPdf(String id) {
		logger.info("Method in Dao: getPaymentDataPdf Starts");

		List<PaymentVoucherModel> paymentVoucherModelList = new ArrayList<PaymentVoucherModel>();

		try {

			String value = "SET @p_refNo='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "getPVByRefId").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				Object oa = DateFormatter.returnStringDate(m[13]);
				PaymentVoucherModel voucher = new PaymentVoucherModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], null, null, null, null, null, null, null, null, null, oa,
						m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21], null, null, null, null, null, null,
						null, null, null, m[22], m[23], m[24], null, null, null, null, m[25], m[26], m[27], null,m[28]);
				paymentVoucherModelList.add(voucher);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(paymentVoucherModelList);
		logger.info("Method in Dao: getPaymentDataPdf ends");
		return paymentVoucherModelList;
	}

	/*
	 * get return values of credit details
	 */

	@SuppressWarnings("unchecked")
	public List<InventoryGrnPaymentDetails> getCreditDetailsForPdf(String id) {
		logger.info("Method : getCreditDetailsForPdf Dao starts");

		List<InventoryGrnPaymentDetails> inventoryGrnPaymentDetailsList = new ArrayList<InventoryGrnPaymentDetails>();
		try {
			String value = "SET @p_grnNO='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "getPartialPayDtls").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object oa = DateFormatter.returnStringDate(m[6]);

				InventoryGrnPaymentDetails payments = new InventoryGrnPaymentDetails(m[0], m[1], m[2], m[3], m[4], m[5],
						oa, null, null, null);
				inventoryGrnPaymentDetailsList.add(payments);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCreditDetailsForPdf Dao ends");
		return inventoryGrnPaymentDetailsList;
	}

}
