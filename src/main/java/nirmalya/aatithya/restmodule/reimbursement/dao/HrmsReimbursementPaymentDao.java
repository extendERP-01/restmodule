package nirmalya.aatithya.restmodule.reimbursement.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateReimbursementPaymentParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.reimbursement.model.HrmsEmployeeCompanyDetailsModel;
import nirmalya.aatithya.restmodule.reimbursement.model.HrmsReimbursementModel;
import nirmalya.aatithya.restmodule.reimbursement.model.HrmsReimbursementPaymentModal;

@Repository
public class HrmsReimbursementPaymentDao {
	Logger logger = LoggerFactory.getLogger(HrmsReimbursementPaymentDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/**
	 * for reimbursement list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getReqListPayment() {

		logger.info("Method : getReqListPayment starts");

		List<DropDownModel> reqisitionList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementPaymentRoutines")
					.setParameter("actionType", "getReqListPayment").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				reqisitionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getReqListPayment ends");

		return reqisitionList;
	}

	/**
	 * for employee list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmpListPayment() {

		logger.info("Method : getEmpListPayment starts");

		List<DropDownModel> empList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementPaymentRoutines")
					.setParameter("actionType", "getEmpListPayment").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				empList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getEmpListPayment ends");

		return empList;
	}

	/*
	 * for grn list payment for add payment voucher
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsReimbursementPaymentModal>>> getReimbursementListPayment(
			DataTableRequest request) {

		logger.info("Method in Dao: getReimbursementListPayment starts");

		List<HrmsReimbursementPaymentModal> paymentVoucherModel = new ArrayList<HrmsReimbursementPaymentModal>();

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

			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementPaymentRoutines")
					.setParameter("actionType", "getReimListPayment").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					HrmsReimbursementPaymentModal reimList = new HrmsReimbursementPaymentModal(m[0], m[1], m[2], null,
							null, null, null, null, m[3], m[4], m[5], null, m[6], null, null, null, null, null);
					paymentVoucherModel.add(reimList);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsReimbursementPaymentModal>> resp = new JsonResponse<List<HrmsReimbursementPaymentModal>>();
		resp.setBody(paymentVoucherModel); 
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<HrmsReimbursementPaymentModal>>> response = new ResponseEntity<JsonResponse<List<HrmsReimbursementPaymentModal>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getReimbursementListPayment ends");
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

			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementPaymentRoutines")
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

			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementPaymentRoutines")
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

			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementPaymentRoutines")
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

			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementPaymentRoutines")
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

			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementPaymentRoutines")
					.setParameter("actionType", "getAccountNameList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				if (m[0] != null) {
					DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
					accNameList.add(dropDownModel);

				}else {
					Object oa = 0.00;
					DropDownModel dropDownModel = new DropDownModel(oa, m[1]);
					accNameList.add(dropDownModel);
				}

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
	public ResponseEntity<JsonResponse<Object>> addReimbursementVoucher(
			List<HrmsReimbursementPaymentModal> paymentVoucherModel) {

		logger.info("Method in Dao:Add  addReimbursementVoucher starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (HrmsReimbursementPaymentModal a : paymentVoucherModel) {
			if (a.getEmployeeId() == null || a.getEmployeeId() == "") {
				validity = false;
			} else if (a.getPaymentMode() == null || a.getPaymentMode() == "") {
				resp.setMessage("Select Payment Mode");
				validity = false;
			}
		}
		List<HrmsReimbursementPaymentModal> paymentVoucherModelList = new ArrayList<HrmsReimbursementPaymentModal>();
		if (validity)
			try {
				String values = GenerateReimbursementPaymentParam.getReimPaymentParam(paymentVoucherModel);
System.out.println(values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementPaymentRoutines")
						.setParameter("actionType", "addPaymentVoucher").setParameter("actionValue", values)
						.getResultList();

				if (!x.isEmpty()) {
					for (Object[] m : x) {
						HrmsReimbursementPaymentModal voucher = new HrmsReimbursementPaymentModal(null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, m[0],
								m[1]);
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

		logger.info("Method in Dao: Add addReimbursementVoucher ends");

		return response;
	}

	/*
	 * for get return details by payment voucher
	 */

	@SuppressWarnings("unchecked")
	public List<HrmsReimbursementPaymentModal> getReimbPayData(String id) {
		logger.info("Method in Dao: getReimbPayData Starts");

		List<HrmsReimbursementPaymentModal> paymentVoucherModelList = new ArrayList<HrmsReimbursementPaymentModal>();
		try {

			String value = "SET @p_paymentVoucher='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementPaymentRoutines")
					.setParameter("actionType", "getReimbPayData").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object oa = DateFormatter.returnStringDate(m[12]);
				HrmsReimbursementPaymentModal voucher = new HrmsReimbursementPaymentModal(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], null, m[7], m[8], m[9], m[10], m[11], oa, m[13], m[14], m[15], m[16]);
				paymentVoucherModelList.add(voucher);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method in Dao: getReimbPayData ends");
		return paymentVoucherModelList;
	}

	/*
	 * for getVenderDetails
	 */
	@SuppressWarnings("unchecked")
	public List<HrmsEmployeeCompanyDetailsModel> getVenderDetails(String userId) {
		logger.info("Method in Dao: getVenderDetails starts");

		List<HrmsEmployeeCompanyDetailsModel> paymentVoucherModelList = new ArrayList<HrmsEmployeeCompanyDetailsModel>();

		try {
			String value = "SET @p_empId='" + userId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementPaymentRoutines")
					.setParameter("actionType", "getEmplDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				HrmsEmployeeCompanyDetailsModel dropDownModel = new HrmsEmployeeCompanyDetailsModel(m[0], m[1], m[2],
						m[3], m[4], null, null, null, null, null);
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
	public List<HrmsEmployeeCompanyDetailsModel> getHotelDetails(String userId) {
		logger.info("Method in Dao: getHotelDetails starts");

		List<HrmsEmployeeCompanyDetailsModel> paymentVoucherModelList = new ArrayList<HrmsEmployeeCompanyDetailsModel>();

		try {
			String value = "SET @p_userId='" + userId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementPaymentRoutines")
					.setParameter("actionType", "getHotelDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				HrmsEmployeeCompanyDetailsModel dropDownModel = new HrmsEmployeeCompanyDetailsModel(null, null, null,
						null, null, m[0], m[1], m[2], m[3], m[4]);
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
	 * for all paid payment voucher view page
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsReimbursementPaymentModal>>> getAllReimbursementPaymentVoucher(
			DataTableRequest request) {

		logger.info("Method in Dao: getAllReimbursementPaymentVoucher starts");

		List<HrmsReimbursementPaymentModal> paymentVoucherModelList = new ArrayList<HrmsReimbursementPaymentModal>();
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

			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementPaymentRoutines")
					.setParameter("actionType", "allReimbVoucher").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object oa = DateFormatter.returnStringDate(m[12]);
					HrmsReimbursementPaymentModal voucher = new HrmsReimbursementPaymentModal(m[0], m[1], m[2], m[3],
							m[4], m[5], m[6], null, m[7], m[8], m[9], m[10], m[11], oa, m[13], m[14], m[15], m[16]);
					paymentVoucherModelList.add(voucher);

				}

				if (x.get(0).length > 17) {
					BigInteger t = (BigInteger) x.get(0)[17];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<HrmsReimbursementPaymentModal>> resp = new JsonResponse<List<HrmsReimbursementPaymentModal>>();
		resp.setBody(paymentVoucherModelList);
		resp.setTotal(total);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsReimbursementPaymentModal>>> response = new ResponseEntity<JsonResponse<List<HrmsReimbursementPaymentModal>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getAllReimbursementPaymentVoucher ends");

		return response;
	}

	/*
	 * for get return details by payment voucher
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<HrmsReimbursementPaymentModal>> getReimbursementModal(String id) {
		logger.info("Method in Dao: getReimbursementModal Starts");

		List<HrmsReimbursementPaymentModal> paymentVoucherModelList = new ArrayList<HrmsReimbursementPaymentModal>();
		try {

			String value = "SET @p_paymentVoucher='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementPaymentRoutines")
					.setParameter("actionType", "getReimbPayData").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object oa = DateFormatter.returnStringDate(m[12]);
				HrmsReimbursementPaymentModal voucher = new HrmsReimbursementPaymentModal(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], null, m[7], m[8], m[9], m[10], m[11], oa, m[13], m[14], m[15], m[16]);
				paymentVoucherModelList.add(voucher);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method in Dao: getReimbPayData ends");

		JsonResponse<HrmsReimbursementPaymentModal> resp = new JsonResponse<HrmsReimbursementPaymentModal>();
		resp.setBody(paymentVoucherModelList.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<HrmsReimbursementPaymentModal>> response = new ResponseEntity<JsonResponse<HrmsReimbursementPaymentModal>>(
				resp, responseHeaders, HttpStatus.CREATED);
		return response;
	}
	/*
	 * for modal view and edit also
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsReimbursementModel>>> getReimbusementByIdModal(String reimId) {

		logger.info("Method : getReimbusementByIdModal starts");

		List<HrmsReimbursementModel> assignEduList = new ArrayList<HrmsReimbursementModel>();
		JsonResponse<List<HrmsReimbursementModel>> resp = new JsonResponse<List<HrmsReimbursementModel>>();

		try {

			String value = "SET @p_reimId='" + reimId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementPaymentRoutines")
					.setParameter("actionType", "getReimById").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object oa = null;
				Object ob = null;
				Object oc = null;
				oa = DateFormatter.returnStringDate(m[2]);
				ob = DateFormatter.returnStringDate(m[9]);
				oc = DateFormatter.returnStringDate(m[10]);
				HrmsReimbursementModel hrmEmployeeEducationModel = new HrmsReimbursementModel(m[0], m[1], oa, m[3],
						m[4], m[5], m[6], m[7], m[8], ob, oc, m[11], m[12], m[13], m[14], m[15], m[16], null, null,
						null,null,null,null);

				assignEduList.add(hrmEmployeeEducationModel);

			}

			resp.setBody(assignEduList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<HrmsReimbursementModel>>> response = new ResponseEntity<JsonResponse<List<HrmsReimbursementModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getReimbusementByIdModal ends");

		return response;
	}

}
