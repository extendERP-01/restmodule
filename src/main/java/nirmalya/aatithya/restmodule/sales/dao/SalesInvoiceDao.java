package nirmalya.aatithya.restmodule.sales.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateSalesInvoiceParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.model.FoodOrderPaymentDetails;
import nirmalya.aatithya.restmodule.sales.model.QuotationMasterModel;
import nirmalya.aatithya.restmodule.sales.model.SaleInvoiceReturnModel;
import nirmalya.aatithya.restmodule.sales.model.SaleOrderPaymentPdfModel;
import nirmalya.aatithya.restmodule.sales.model.SalesInvoiceModel;
import nirmalya.aatithya.restmodule.sales.model.SalesPaymentModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class SalesInvoiceDao {

	Logger logger = LoggerFactory.getLogger(SalesInvoiceDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	/**
	 * DAO - Get SalesOrder List By AutoSearch
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesOrderListByAuotSearch(String id, String storeId) {
		logger.info("Method : getSalesOrderListByAuotSearch Dao starts");

		List<DropDownModel> customerList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_serachValue='" + id + "',@p_storeId='" + storeId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
					.setParameter("actionType", "getSaleOrderList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				customerList.add(dropDownModel);
			}

			resp.setBody(customerList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getSalesOrderListByAuotSearch Dao ends");
		return response;
	}

	/**
	 * DAO - Get Quotation List
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<QuotationMasterModel>>> getQuotationList(String id, String storeId) {
		logger.info("Method : getQuotationList starts");

		List<QuotationMasterModel> parkingLot = new ArrayList<QuotationMasterModel>();
		JsonResponse<List<QuotationMasterModel>> resp = new JsonResponse<List<QuotationMasterModel>>();
		try {

			String value = "SET @p_salesOrder='" + id + "',@p_storeId='" + storeId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
					.setParameter("actionType", "getQuotationList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object vdate = DateFormatter.returnStringDate(m[5]);
				Object pdate = null;
				Object sdate = null;
				if (m[24] != null && m[27] != null) {
					pdate = DateFormatter.returnStringDate(m[24]);
					sdate = DateFormatter.returnStringDate(m[27]);
				}
				QuotationMasterModel parking = new QuotationMasterModel(m[0], m[1], m[2], m[3], m[4], vdate, m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21],
						m[22], m[23], pdate, m[25], m[26], sdate, null, null, null, null, null, null, null, null, null,
						null, m[28], m[29], m[30], null, m[31], m[32], m[33], m[34], m[35], m[36], null, null, m[38],
						null, null, null, m[37], null, null, null, null,m[39]);
				parkingLot.add(parking);
			}

			resp.setBody(parkingLot);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<QuotationMasterModel>>> response = new ResponseEntity<JsonResponse<List<QuotationMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getQuotationList ends");
		System.out.println(response);
		return response;
	}

	/**
	 * DAO - Get Item List
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<QuotationMasterModel>>> getItemList(Map<String, String> quotation) {
		logger.info("Method : getItemList starts");
		List<QuotationMasterModel> sOrder = new ArrayList<QuotationMasterModel>();
		boolean validation = true;
		JsonResponse<List<QuotationMasterModel>> resp = new JsonResponse<List<QuotationMasterModel>>();

		String itemCode = quotation.get("itemCode");
		String salesOrder = quotation.get("salesOrder");

		if (validation) {
			try {
				String value = "SET @p_item='" + itemCode + "',@p_salesOrder='" + salesOrder + "';";

				List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
						.setParameter("actionType", "getItemList").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					QuotationMasterModel itemList = new QuotationMasterModel(null, null, null, null, null, null, null,
							null, m[0], m[1], m[2], m[3], m[4], null, null, null, null, null, null, null, null, null,
							m[5], null, null, null, null, null, null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, m[6], null, null, null, null, null, null, null, m[7], null,
							null, null, null, m[8], null, null, null, null);
					sOrder.add(itemList);
				}
			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}

		resp.setBody(sOrder);

		ResponseEntity<JsonResponse<List<QuotationMasterModel>>> response = new ResponseEntity<JsonResponse<List<QuotationMasterModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getItemList ends");
		return response;
	}

	/**
	 * DAO - Add Sales Invoice
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> addSalesInvoice(List<SalesInvoiceModel> salesInvoice) {
		logger.info("Method : addSalesInvoice starts");
		List<SalesInvoiceModel> sOrder = new ArrayList<SalesInvoiceModel>();
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (SalesInvoiceModel l : salesInvoice) {
			if (l.getSalesOrderId() == null || l.getSalesOrderId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Sales Order Required");
				break;
			} else if (l.getSaleItem() == null || l.getSaleItem() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Sale Item Name Required");
				break;
			} else if (l.getSaleQuantity() == null) {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Sale Quantity Required");
				break;
			} else if (l.getSaleInvNote() == null || l.getSaleInvNote() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Sale Invoice Note Required");
				break;
			}
		}
		if (validity) {
			try {
				String values = GenerateSalesInvoiceParameter.addSalesInvoiceParam(salesInvoice);

				List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
						.setParameter("actionType", "addSalesInvoice").setParameter("actionValue", values)
						.getResultList();
				for (Object[] m : x) {
					SalesInvoiceModel invoice = new SalesInvoiceModel(m[0], m[1], null, null, null, null, null, null,
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
							null,null,null);
					sOrder.add(invoice);
				}
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
		}
		resp.setBody(sOrder);
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addSalesInvoice ends");

		return response;

	}

	/**
	 * DAO - Get Sales Invoice By INVOICE NUMBER
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> getSalesInvoiceById(String id) {
		logger.info("Method : getSalesInvoiceById starts");

		List<SalesInvoiceModel> sales = new ArrayList<SalesInvoiceModel>();
		JsonResponse<List<SalesInvoiceModel>> resp = new JsonResponse<List<SalesInvoiceModel>>();
		try {

			String value = "SET @p_invoiceNo='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
					.setParameter("actionType", "ViewSaleInvoice").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object tDate = null;
				Object iDate = null;
				if (m[22] != null) {
					tDate = DateFormatter.returnStringDate(m[22]);
				}
				if (m[24] != null) {

					iDate = DateFormatter.returnStringDate(m[24]);
				}
				SalesInvoiceModel sale = new SalesInvoiceModel(m[0], m[1], null, m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21],
						tDate, m[23], null, null, null, null, null, null, null, null, null, null, null, null, iDate,
						m[25], null, m[26], m[27], m[28], m[29], m[30], m[31], m[32], m[33], null, null, null, null,
						null, m[34],m[35],m[36]);
				sales.add(sale);
			}

			resp.setBody(sales);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> response = new ResponseEntity<JsonResponse<List<SalesInvoiceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getSalesInvoiceById ends");

		return response;
	}

	/**
	 * DAO - Get Sales Invoice Payment By INVOICE NUMBER
	 *
	 */
	/*
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<List<SalesInvoiceModel>>>
	 * saleInvoicePaymentDao(String id) {
	 * logger.info("Method : saleInvoicePaymentDao starts");
	 * 
	 * List<SalesInvoiceModel> sales = new ArrayList<SalesInvoiceModel>();
	 * JsonResponse<List<SalesInvoiceModel>> resp = new
	 * JsonResponse<List<SalesInvoiceModel>>(); try {
	 * 
	 * String value = "SET @p_invoiceNo='" + id + "';";
	 * 
	 * List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
	 * .setParameter("actionType", "saleInvPayment").setParameter("actionValue",
	 * value).getResultList();
	 * 
	 * for (Object[] m : x) { Object tDate = null; Object iDate = null;
	 * 
	 * if (m[21] != null) { tDate = DateFormatter.returnStringDate(m[21]); } if
	 * (m[22] != null) { iDate = DateFormatter.returnStringDate(m[22]); }
	 * 
	 * SalesInvoiceModel sale = new SalesInvoiceModel(m[0], m[1], null, m[2], m[3],
	 * m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15],
	 * m[16], m[17], m[18], m[19], m[20], null, tDate, null, null, null, null, null,
	 * null, null, null, null, null, null, null, null, iDate, m[23], null, m[24],
	 * m[25], m[26], null, m[27], null, null, m[28], null,null,null,null,null);
	 * sales.add(sale);
	 * 
	 * }
	 * 
	 * resp.setBody(sales); } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * HttpHeaders responseHeaders = new HttpHeaders();
	 * responseHeaders.set("MyResponseHeader", "MyValue");
	 * 
	 * ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> response = new
	 * ResponseEntity<JsonResponse<List<SalesInvoiceModel>>>( resp, responseHeaders,
	 * HttpStatus.CREATED);
	 * 
	 * logger.info("Method : saleInvoicePaymentDao ends");
	 * 
	 * return response; }
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<SaleOrderPaymentPdfModel>> saleOrderVoucherPDFDao(String id) {
		logger.info("Method : saleOrderVoucherPDFDao starts");
		SaleOrderPaymentPdfModel pdfpay = new SaleOrderPaymentPdfModel();

		List<SalesInvoiceModel> sales = new ArrayList<SalesInvoiceModel>();
		List<FoodOrderPaymentDetails> payments = new ArrayList<FoodOrderPaymentDetails>();
		JsonResponse<SaleOrderPaymentPdfModel> resp = new JsonResponse<SaleOrderPaymentPdfModel>();
		
		try {

			String value = "SET @p_invoiceNo='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
					.setParameter("actionType", "saleInvPayment").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object tDate = null;
				Object iDate = null;

				if (m[21] != null) {
					tDate = DateFormatter.returnStringDate(m[21]);
				}
				if (m[22] != null) {
					iDate = DateFormatter.returnStringDate(m[22]);
				}

				SalesInvoiceModel sale = new SalesInvoiceModel(m[0], m[1], null, m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], null,
						tDate, null, null, null, null, null, null, null, null, null, null, null, null, null, iDate,
						m[23], null, m[24], m[25], m[26], null, m[27], null, null, m[28], null, null, null, null, null,
						m[29],m[30],m[31]);
				sales.add(sale);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			String value = "SET @p_saleInvoice='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesCounterInvoiceRoutines")
					.setParameter("actionType", "getPayDtlsForPDF").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object oDate = null;

				if (m[5] != null) {
					oDate = DateFormatter.returnStringDate(m[5]);
				}
				FoodOrderPaymentDetails pay = new FoodOrderPaymentDetails(m[0], m[1], m[2], m[3], m[4], oDate);
				payments.add(pay);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		pdfpay.setFoodOrderPaymentDetailsList(payments);
		pdfpay.setSalesInvoiceModelList(sales);
		resp.setBody(pdfpay);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<SaleOrderPaymentPdfModel>> response = new ResponseEntity<JsonResponse<SaleOrderPaymentPdfModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : saleOrderVoucherPDFDao ends");
		return response;
	}

	/**
	 * DAO - Get Sales Invoice
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> getSalesInvoiceDetails(DataTableRequest request) {
		logger.info("Method : getSalesInvoiceDetails starts");

		List<SalesInvoiceModel> sales = new ArrayList<SalesInvoiceModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
					.setParameter("actionType", "getSaleInvoice").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				SalesInvoiceModel salesInv = new SalesInvoiceModel(m[0], m[1], m[2], m[3], m[4], m[5], null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, m[6], null, null, m[7],
						null, null, null, null, null, null, null, null, null, null, null, null, null, m[8], null, null,
						null, null, null, null, null, m[9], m[10], null, null, null, null, null, m[11],null,null);
				sales.add(salesInv);
			}
			if (x.size() > 0) {
				if (x.get(0).length > 12) {
					BigInteger t = (BigInteger) x.get(0)[12];

					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<SalesInvoiceModel>> resp = new JsonResponse<List<SalesInvoiceModel>>();
		resp.setBody(sales);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> response = new ResponseEntity<JsonResponse<List<SalesInvoiceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getSalesInvoiceDetails ends");

		return response;
	}

	/**
	 * DAO - Get Pay Mode For Full Payment
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPayMode() {
		logger.info("Method : getPayMode starts");

		List<DropDownModel> payMode = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
					.setParameter("actionType", "getPaymentMode").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				payMode.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPayMode ends");

		return payMode;
	}

	/**
	 * DAO - Get Pay Mode For Partial Payment
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPaymentMode() {
		logger.info("Method : getPaymentMode starts");

		List<DropDownModel> payMode = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
					.setParameter("actionType", "PaymentMode").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				payMode.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPaymentMode ends");

		return payMode;
	}

	/**
	 * 
	 * DAO - Make Payment
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> makePaymentDao(SalesInvoiceModel index) {
		logger.info("Method : DAO makePaymentDao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		String salesInvoice = index.getSalesInvoice();
		String payMode1 = index.getPayMode1();
		String payMode2 = index.getPayMode2();
		String transcId = index.getTransactionId();
		String posNumber = index.getPosNumber();
		String quotationId = index.getQuotationId();
		String trnscDate = index.getTransactionDate();
		String salesOrder = index.getSalesOrderId();
		Double subTotal = index.getSubTotal();
		Double grandTotal = index.getGrandTotal();
		String createdBy = index.getCreatedBy();
		Double cardPayment = index.getCardAmount();
		double availAmount = 0;
		Double cashPayment = index.getCashAmount();
		Boolean paymentType = index.getPaymentType();
		if (cardPayment != 0 && cardPayment != null) {
			availAmount = cardPayment - cashPayment;
		} else {
			availAmount = cashPayment;
		}
		Double igst = index.getsIGST();
		Double cgst = index.getsCGST();
		Double sgst = index.getsSGST();
		Double totalPyament = cardPayment + cashPayment;
		try {
			String value = "SET @p_salesInvoice='" + salesInvoice + "',@p_paymentMode1='" + payMode1
					+ "',@p_paymentMode2='" + payMode2 + "',@p_transcId='" + transcId + "'," + "@p_posNumber='"
					+ posNumber + "',@p_trnscDate='" + DateFormatter.getStringDate(trnscDate) + "',@p_salesOrder='"
					+ salesOrder + "',@p_createdBy='" + createdBy + "'," + "@P_taxableAmt=" + subTotal + ",@P_igst="
					+ igst + ",@P_cgst=" + cgst + ",@P_sgst=" + sgst + ",@P_totalAmt=" + grandTotal + ",@P_paymentType="
					+ paymentType + ",@p_cardAmount=" + cardPayment + ",@cashAmount=" + cashPayment + ",@p_availAmount="
					+ availAmount + ",@totalPayment=" + totalPyament + ",@p_quotationId='" + quotationId + "';";
System.out.println(value);
			em.createNamedStoredProcedureQuery("salesCounterInvoiceRoutines").setParameter("actionType", "salePayment")
					.setParameter("actionValue", value).execute();
		} catch (Exception e) {
			e.printStackTrace();
			String[] err = serverDao.errorProcedureCall(e);
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : DAO makePaymentDao ends");
		return response;
	}

	/**
	 * DAO - Get Customer List
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<SalesInvoiceModel> getCustomerList(String id) {
		logger.info("Method : getCustomerList starts");

		List<SalesInvoiceModel> custList = new ArrayList<SalesInvoiceModel>();
		String value = "SET @p_salesOrder='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
					.setParameter("actionType", "getCustomerList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				SalesInvoiceModel dropDownModel = new SalesInvoiceModel(null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, m[0], m[1], m[2], m[3], m[4], m[5], m[6], null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null,null,null);
				custList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCustomerList ends");

		return custList;
	}

	/**
	 * DAO - Get Hotel List
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<SalesInvoiceModel> getHotelList(String id) {
		logger.info("Method : getHotelList starts");

		List<SalesInvoiceModel> hotelList = new ArrayList<SalesInvoiceModel>();
		String value = "SET @p_storeId='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
					.setParameter("actionType", "getHotelList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				SalesInvoiceModel dropDownModel = new SalesInvoiceModel(null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, m[0], m[1], m[2], m[3], m[4], null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null,null,null);
				hotelList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getHotelList ends");
		return hotelList;
	}

	/**
	 * DAO - Get Sales Invoice By INVOICE NUMBER
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> SaleInvoicePdfDao(String id) {
		logger.info("Method : SaleInvoicePdfDao starts");

		List<SalesInvoiceModel> sales = new ArrayList<SalesInvoiceModel>();
		JsonResponse<List<SalesInvoiceModel>> resp = new JsonResponse<List<SalesInvoiceModel>>();
		try {

			String value = "SET @p_invoiceNo='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
					.setParameter("actionType", "SaleInvoicePdf").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object tDate = null;
				Object iDate = null;
				if (m[22] != null) {
					tDate = DateFormatter.returnStringDate(m[22]);
				}
				if (m[24] != null) {

					iDate = DateFormatter.returnStringDate(m[24]);
				}
				SalesInvoiceModel sale = new SalesInvoiceModel(m[0], m[1], null, m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21],
						tDate, m[23], null, null, null, null, null, null, null, null, null, null, null, null, iDate,
						m[25], null, m[26], m[27], null, null, null, null, null, null, null, null, null, null, null,
						m[29],m[30],m[31]);
				sales.add(sale);
			}

			resp.setBody(sales);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> response = new ResponseEntity<JsonResponse<List<SalesInvoiceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : SaleInvoicePdfDao ends");

		return response;
	}

	/**
	 * DAO - Get Sales Invoice By INVOICE NUMBER
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> SaleInvPaymentPdfDao(String id) {
		logger.info("Method : SaleInvPaymentPdfDao starts");

		List<SalesInvoiceModel> sales = new ArrayList<SalesInvoiceModel>();
		JsonResponse<List<SalesInvoiceModel>> resp = new JsonResponse<List<SalesInvoiceModel>>();
		try {

			String value = "SET @p_invoiceNo='" + id + "' ;";

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
					.setParameter("actionType", "SaleInvPayPdf").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object tDate = null;
				Object iDate = null;

				if (m[21] != null) {
					tDate = DateFormatter.returnStringDate(m[21]);
				}
				if (m[22] != null) {
					iDate = DateFormatter.returnStringDate(m[22]);
				}

				SalesInvoiceModel sale = new SalesInvoiceModel(m[0], m[1], null, m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], null,
						tDate, null, null, null, null, null, null, null, null, null, null, null, null, null, iDate,
						m[23], null, m[24], m[25], m[26], null, m[27], null, null, m[28], null, null, null, null, null,
						m[29],null,null);
				sales.add(sale);

			}

			resp.setBody(sales);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> response = new ResponseEntity<JsonResponse<List<SalesInvoiceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : SaleInvPaymentPdfDao ends");
		return response;
	}

	/**
	 * DAO - Get Sale Invoice List By AutoSearch
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSaleInvoiceListByAuotSearch(String id) {
		logger.info("Method : getSaleInvoiceListByAuotSearch Dao starts");

		List<DropDownModel> customerList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_serachValue='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
					.setParameter("actionType", "getSaleInvoiceList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				customerList.add(dropDownModel);
			}

			resp.setBody(customerList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getSaleInvoiceListByAuotSearch Dao ends");
		return response;
	}

	/**
	 * DAO - Get Receipt Voucher List By AutoSearch
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> voucherAutoCompleteDao(String id) {
		logger.info("Method : voucherAutoCompleteDao Dao starts");

		List<DropDownModel> customerList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_serachValue='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
					.setParameter("actionType", "getVoucherList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				customerList.add(dropDownModel);
			}

			resp.setBody(customerList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : voucherAutoCompleteDao Dao ends");
		return response;
	}

	/**
	 * DAO - Get SalesOrder List By AutoSearch For Report
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesOrderListByAuotSearchForReportDao(String id) {
		logger.info("Method : getSalesOrderListByAuotSearchForReportDao Dao starts");

		List<DropDownModel> customerList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_serachValue='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
					.setParameter("actionType", "getSaleOrderReport").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				customerList.add(dropDownModel);
			}

			resp.setBody(customerList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getSalesOrderListByAuotSearchForReportDao Dao ends");
		return response;
	}

	/**
	 * DAO - Sales Invoice Report
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> getSalesInvoiceReport(DataTableRequest request) {
		logger.info("Method : DAO getSalesInvoiceReport starts");

		List<SalesInvoiceModel> salesOrder = new ArrayList<SalesInvoiceModel>();
		JsonResponse<List<SalesInvoiceModel>> resp = new JsonResponse<List<SalesInvoiceModel>>();

		String param1 = request.getParam1();
		String param2 = request.getParam2();
		if (param1 != null && param1 != "") {
			String frmDate = DateFormatter.getStringDate(param1);

			request.setParam1(frmDate);
		}
		if (param2 != null && param2 != "") {
			String tDate = DateFormatter.getStringDate(param2);

			request.setParam2(tDate);
		}

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
					.setParameter("actionType", "getSaleInvReport").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object sDate = null;
				if (m[5] != null) {
					sDate = DateFormatter.returnStringDate(m[5]);
				}
				SalesInvoiceModel soList = new SalesInvoiceModel(m[0], m[1], null, m[2], m[3], null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, m[4],
						null, null, null, null, null, null, null, null, null, null, null, null, sDate, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, m[6],null,null);

				salesOrder.add(soList);

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

		resp.setBody(salesOrder);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> response = new ResponseEntity<JsonResponse<List<SalesInvoiceModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : DAO getSalesInvoiceReport ends");
		return response;
	}

	/**
	 * DAO - Get Hotel Logo
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getHotelLogoImage(String logoType) {
		logger.info("Method : getHotelLogoImage starts");

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

		logger.info("Method : getHotelLogoImage ends");

		return logoList;
	}

	/**
	 * DAO - Get Sale Invoice Return Details
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<SaleInvoiceReturnModel> getSaleInvoiceReturnDao(String id) {
		logger.info("Method : getSaleInvoiceReturnDao starts");

		List<SaleInvoiceReturnModel> saleInvReturn = new ArrayList<SaleInvoiceReturnModel>();
		String value = "SET @p_saleInvoice='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
					.setParameter("actionType", "getSaleInvReturn").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				SaleInvoiceReturnModel sale = new SaleInvoiceReturnModel(m[0], m[1], null, m[2], null, m[3], m[4], m[5],
						m[6], m[7], m[8], null, m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, m[18],null,null,null,null);
				saleInvReturn.add(sale);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getSaleInvoiceReturnDao ends");
System.out.println(saleInvReturn);
		return saleInvReturn;
	}

	/**
	 * DAO - Get POS Number List By AutoSearch
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> posNumberByAutoSearchDao(String id) {
		logger.info("Method : posNumberByAutoSearchDao Dao starts");

		List<DropDownModel> posNumber = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_serachValue='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
					.setParameter("actionType", "getPOSNumber").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				posNumber.add(dropDownModel);
			}

			resp.setBody(posNumber);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : posNumberByAutoSearchDao Dao ends");
		return response;
	}

	/**
	 * DAO - Get Last Payment List
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> getLastPaymentList(String id) {
		logger.info("Method : getLastPaymentList starts");

		List<SalesInvoiceModel> lastPaymentList = new ArrayList<SalesInvoiceModel>();
		JsonResponse<List<SalesInvoiceModel>> resp = new JsonResponse<List<SalesInvoiceModel>>();
		try {

			String value = "SET @p_saleInvoice='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
					.setParameter("actionType", "getLastPaymentList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object tDate = DateFormatter.returnStringDate(m[3]);
				SalesInvoiceModel dropDownModel = new SalesInvoiceModel(null, null, null, null, null, null, null, null,
						null, null, null, null, m[0], null, null, null, null, null, null, null, m[1], m[2], null, tDate,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null,null,null);
				lastPaymentList.add(dropDownModel);
			}

			resp.setBody(lastPaymentList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> response = new ResponseEntity<JsonResponse<List<SalesInvoiceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getLastPaymentList ends");
		return response;
	}

	/**
	 * DAO - Payment Details Modal
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> getInvoiceDtlsForPayment(String id) {
		logger.info("Method : getInvoiceDtlsForPayment starts");

		List<SalesInvoiceModel> sales = new ArrayList<SalesInvoiceModel>();
		JsonResponse<List<SalesInvoiceModel>> resp = new JsonResponse<List<SalesInvoiceModel>>();
		try {

			String value = "SET @p_invoiceNo='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
					.setParameter("actionType", "PaymentDetailsModal").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object tDate = DateFormatter.returnStringDate(m[4]);
				SalesInvoiceModel dropDownModel = new SalesInvoiceModel(m[0], null, null, null, null, null, null, null,
						null, null, null, null, m[1], null, null, null, null, null, null, null, m[2], m[3], null, tDate,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, m[5], null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null,null,null);
				sales.add(dropDownModel);
			}

			resp.setBody(sales);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> response = new ResponseEntity<JsonResponse<List<SalesInvoiceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getInvoiceDtlsForPayment ends");

		return response;
	}

	/**
	 * DAO - Sale Invoice Total Payment PDF
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> SaleInvTotalPdfDao(String id) {
		logger.info("Method : SaleInvTotalPdfDao starts");

		List<SalesInvoiceModel> sales = new ArrayList<SalesInvoiceModel>();
		JsonResponse<List<SalesInvoiceModel>> resp = new JsonResponse<List<SalesInvoiceModel>>();
		try {

			String value = "SET @p_invoiceNo='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
					.setParameter("actionType", "TotalPaymentPDF").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object tDate = null;
				Object iDate = null;

				if (m[21] != null) {
					tDate = DateFormatter.returnStringDate(m[21]);
				}
				if (m[22] != null) {
					iDate = DateFormatter.returnStringDate(m[22]);
				}

				SalesInvoiceModel sale = new SalesInvoiceModel(m[0], m[1], null, m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], null,
						tDate, null, null, null, null, null, null, null, null, null, null, null, null, null, iDate,
						m[23], null, m[24], m[25], m[26], null, m[27], null, null, m[28], null, null, null, null, null,
						m[30],null,null);
				sales.add(sale);

			}

			resp.setBody(sales);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> response = new ResponseEntity<JsonResponse<List<SalesInvoiceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : SaleInvTotalPdfDao ends");
		return response;
	}

	/**
	 * DAO - Voucher List For PDF
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<SalesPaymentModel> totalPaymentDetailsDao(String id) {
		logger.info("Method : totalPaymentDetailsDao starts");

		List<SalesPaymentModel> sales = new ArrayList<SalesPaymentModel>();
		String value = "SET @p_saleInvoice='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
					.setParameter("actionType", "voucherList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object tDate = DateFormatter.returnStringDate(m[3]);
				SalesPaymentModel sale = new SalesPaymentModel(m[0], m[1], m[2], tDate);
				sales.add(sale);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : totalPaymentDetailsDao ends");

		return sales;
	}
}
