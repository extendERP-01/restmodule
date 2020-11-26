package nirmalya.aatithya.restmodule.sales.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateSaleAdvanceAmountParam;
import nirmalya.aatithya.restmodule.common.utils.GenerateSalesQuotationParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.model.QuotationMasterModel;
import nirmalya.aatithya.restmodule.sales.model.SaleOrderAdvancePayDtlsParentModel;
import nirmalya.aatithya.restmodule.sales.model.SaleOrderAdvancePaymentModel;
import nirmalya.aatithya.restmodule.sales.model.SalesItemModel;
import nirmalya.aatithya.restmodule.sales.model.SalesOrdeReportModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class QuotationMasterDao {

	Logger logger = LoggerFactory.getLogger(QuotationMasterDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	/**
	 * DAO - Get Customer List By AutoSearch
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCustomerListAutoSearch(String id) {
		logger.info("Method : getCustomerListAutoSearch Dao starts");

		List<DropDownModel> customerList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_customer='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationRotines")
					.setParameter("actionType", "getCustomerList").setParameter("actionValue", value).getResultList();

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

		logger.info("Method : getCustomerListAutoSearch Dao ends");
		return response;
	}

	/**
	 * DAO - Get Item List By AutoSearch
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemListByAutoSearch(String id) {
		logger.info("Method : getItemListByAutoSearch Dao starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_searchValue='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationRotines")
					.setParameter("actionType", "getItemList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemList.add(dropDownModel);
			}

			resp.setBody(itemList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getItemListByAutoSearch Dao ends");
		return response;
	}

	/**
	 * DAO - Get Item List By AutoSearch
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SalesItemModel>>> getServetTypeByItem(String id) {
		logger.info("Method : getServetTypeByItem Dao starts");

		List<SalesItemModel> itemList = new ArrayList<SalesItemModel>();
		JsonResponse<List<SalesItemModel>> resp = new JsonResponse<List<SalesItemModel>>();

		try {
			String value = "SET @p_searchValue='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationRotines")
					.setParameter("actionType", "getServeType").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				SalesItemModel dropDownModel = new SalesItemModel(m[0], m[1], m[2], null, null);
				itemList.add(dropDownModel);
			}

			resp.setBody(itemList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<SalesItemModel>>> response = new ResponseEntity<JsonResponse<List<SalesItemModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getServetTypeByItem Dao ends");
		return response;
	}

	/**
	 * DAO - Get 'SERVE TYPE' DropDown List
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getServeType() {
		logger.info("Method : getServeType starts");

		List<DropDownModel> serveType = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationRotines")
					.setParameter("actionType", "editServeType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				serveType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getServeType ends");

		return serveType;
	}

	/**
	 * DAO - Add New Quotation
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addQuotationMaster(List<QuotationMasterModel> quotation) {
		logger.info("Method : reserveParking for addQuotationMaster starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (QuotationMasterModel l : quotation) {

			if (l.getQuotationName() == null || l.getQuotationName() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Quotation Name Required");
				break;
			} else if (l.getCustomerId() == null || l.getCustomerId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Customer Name Required");
				break;
			} else if (l.getqDescription() == null || l.getqDescription() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Quotation Description Required");
				break;
			} else if (l.getQuotationVDate() == null || l.getQuotationVDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Quotation Valid Date Required");
				break;
			} else if (l.getqStatus() == null) {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Quotation Status Required");
				break;
			} else if (l.getItemCode() == null || l.getItemCode() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Item Code Required");
				break;
			} else if (l.getUnitPrice() == null) {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Item Unit Price Required");
				break;
			} else if (l.getQuantity() == null) {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Item Quantity Required");
				break;
			} else if (l.getDiscount() == null) {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Item Discount Required");
				break;
			} else if (l.getqServeType() == null || l.getqServeType() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Item Serve Type Required");
				break;
			} else if (l.getItemGST() == null) {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("GST Rate Required");
				break;
			} else if (l.getqNote() == null || l.getqNote() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Quotation Note Required");
				break;
			}
		}
		if (validity) {
			try {
				String values = GenerateSalesQuotationParameter.addQuotationParam(quotation);

				if (quotation.get(0).getQuotationId() != null && quotation.get(0).getQuotationId() != "") {

					em.createNamedStoredProcedureQuery("quotationRotines").setParameter("actionType", "modifyQuotation")
							.setParameter("actionValue", values).execute();
				} else {

					em.createNamedStoredProcedureQuery("quotationRotines").setParameter("actionType", "addQuotation")
							.setParameter("actionValue", values).execute();
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
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : reserveParking for ReserveParkingLotsDao ends");
		return response;
	}

	/**
	 * DAO - Get Customer List By AutoSearch
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getQuotationListByAuotSearch(String id) {
		logger.info("Method : getQuotationListByAuotSearch Dao starts");

		List<DropDownModel> customerList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_quotation='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationRotines")
					.setParameter("actionType", "getQuotationList").setParameter("actionValue", value).getResultList();

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

		logger.info("Method : getQuotationListByAuotSearch Dao ends");
		return response;
	}

	/**
	 * DAO - Get Quotation
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<QuotationMasterModel>>> getQuotationDetails(DataTableRequest request) {
		logger.info("Method : getQuotationDetails starts");

		List<QuotationMasterModel> vehicleType = new ArrayList<QuotationMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationRotines")
					.setParameter("actionType", "getQuotation").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				Object vDate = DateFormatter.returnStringDate(m[4]);
				QuotationMasterModel quote = new QuotationMasterModel(m[0], m[1], m[2], m[3], null, vDate, null, m[5],
						null, null, null, null, null, null, null, null, null, null, null, null, null, m[6], null, null,
						null, null, m[7], null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null,null);
				vehicleType.add(quote);
			}
			if (x.size() > 0) {
				if (x.get(0).length > 8) {
					BigInteger t = (BigInteger) x.get(0)[8];

					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<QuotationMasterModel>> resp = new JsonResponse<List<QuotationMasterModel>>();
		resp.setBody(vehicleType);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<QuotationMasterModel>>> response = new ResponseEntity<JsonResponse<List<QuotationMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getQuotationDetails ends");

		return response;
	}

	/**
	 * DAO - Get Quotation For Modal
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<QuotationMasterModel>>> getQuotationById(String id) {
		logger.info("Method : getQuotationById starts");

		List<QuotationMasterModel> parkingLot = new ArrayList<QuotationMasterModel>();
		JsonResponse<List<QuotationMasterModel>> resp = new JsonResponse<List<QuotationMasterModel>>();
		try {

			String value = "SET @p_quotationId='" + id + "';";
			System.out.println("generate param data are " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationRotines")
					.setParameter("actionType", "ModalQuotation").setParameter("actionValue", value).getResultList();

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
						null, null, null, null, null, m[28], m[29], m[30], m[31], m[32], m[33], null, m[34], null, null,
						null, null, null, null, null, null, null,null);
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

		logger.info("Method : getQuotationById ends");

		return response;
	}

	/**
	 * DAO - Get Quotation For Modal
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<QuotationMasterModel>>> AdvancePaymentPdf(String id) {
		logger.info("Method : getQuotationById starts");

		List<QuotationMasterModel> salesOrder = new ArrayList<QuotationMasterModel>();
		JsonResponse<List<QuotationMasterModel>> resp = new JsonResponse<List<QuotationMasterModel>>();
		try {

			String value = "SET @p_salesOrder='" + id + "';";
			System.out.println("value: 440 " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationRotines")
					.setParameter("actionType", "AdvPaymentPdf").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object vdate = DateFormatter.returnStringDate(m[5]);
				Object pdate = null;
				Object sdate = null;
				if (m[24] != null) {
					pdate = DateFormatter.returnStringDate(m[24]);

				}
				if (m[27] != null) {
					sdate = DateFormatter.returnStringDate(m[27]);
				}
				QuotationMasterModel sales = new QuotationMasterModel(m[0], m[1], m[2], m[3], m[4], vdate, m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21],
						m[22], m[23], pdate, m[25], m[26], sdate, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, m[28], m[29], m[30], m[31], m[32], m[33], m[34], m[35], m[36],
						null, null, null, null, null, null, null, null,null);
				salesOrder.add(sales);
			}

			resp.setBody(salesOrder);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<QuotationMasterModel>>> response = new ResponseEntity<JsonResponse<List<QuotationMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : AdvancePaymentPdf ends");
		System.out.println(response);
		return response;
	}

	/**
	 * DAO - Get Quotation For PDF
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<QuotationMasterModel>>> QuotationPdf(String id) {
		logger.info("Method : QuotationPdf starts");

		List<QuotationMasterModel> parkingLot = new ArrayList<QuotationMasterModel>();
		JsonResponse<List<QuotationMasterModel>> resp = new JsonResponse<List<QuotationMasterModel>>();
		try {

			String value = "SET @p_quotationId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationRotines")
					.setParameter("actionType", "QuotationPdf").setParameter("actionValue", value).getResultList();

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
						null, null, null, null, null, m[28], m[29], m[30], m[31], m[32], m[33], null, null, m[34], null,
						null, null, null, null, null, null, null,null);
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

		logger.info("Method : QuotationPdf ends");

		return response;
	}

	/**
	 * DAO - Get Sales Order For PDF
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<SaleOrderAdvancePayDtlsParentModel>> SalesOrderPdf(String id) {
		logger.info("Method : SalesOrderPdf starts");

		List<QuotationMasterModel> parkingLot = new ArrayList<QuotationMasterModel>();
		 
		List<SaleOrderAdvancePaymentModel> saleOrderAdvancePaymentModelList = new ArrayList<SaleOrderAdvancePaymentModel>();
		JsonResponse<SaleOrderAdvancePayDtlsParentModel> resp = new JsonResponse<SaleOrderAdvancePayDtlsParentModel>();
		SaleOrderAdvancePayDtlsParentModel saleOrderAdvancePayDtlsParentModel;

		try {

			String value = "SET @p_quotationId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationRotines")
					.setParameter("actionType", "SalesOrderPdf").setParameter("actionValue", value).getResultList();

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
						null, null, null, null, null, m[28], m[29], m[30], m[31], m[32], m[33], null, null, m[34], null,
						null, null, null, null, null, null, null,null);
				parkingLot.add(parking);
			}

			 
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			String value = "SET @p_quotationId='" + id + "';";
			List<Object[]> x2 = em.createNamedStoredProcedureQuery("quotationRotines")
					.setParameter("actionType", "getAdvPayDetails").setParameter("actionValue", value).getResultList();
			if (!x2.isEmpty()) {
				for (Object[] m2 : x2) {
					SaleOrderAdvancePaymentModel saleOrderAdvancePaymentModel = new SaleOrderAdvancePaymentModel(m2[0],
							m2[1], m2[2], m2[3], m2[4], m2[5], m2[6] ,DateFormatter.returnStringDate(m2[7]));
					saleOrderAdvancePaymentModelList.add(saleOrderAdvancePaymentModel);
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		saleOrderAdvancePayDtlsParentModel = new SaleOrderAdvancePayDtlsParentModel(parkingLot,
				saleOrderAdvancePaymentModelList);
		resp.setBody(saleOrderAdvancePayDtlsParentModel);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<SaleOrderAdvancePayDtlsParentModel>> response = new ResponseEntity<JsonResponse<SaleOrderAdvancePayDtlsParentModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : SalesOrderPdf ends");

		return response;
	}

	/**
	 * DAO - Edit Quotation By Id
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<QuotationMasterModel> editQuotationById(String id) {
		logger.info("Method : editQuotationById starts");

		List<QuotationMasterModel> quotation = new ArrayList<QuotationMasterModel>();
		String value = "SET @p_quotationId='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationRotines")
					.setParameter("actionType", "EditQuotation").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object vdate = DateFormatter.returnStringDate(m[5]);
				QuotationMasterModel dropDownModel = new QuotationMasterModel(m[0], m[1], m[2], m[3], m[4], vdate, m[6],
						m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20],
						m[21], m[22], null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, m[23], null, null, null, null, null, null, null, m[24],
						m[25], m[26], m[27], null, null, null, null, null,null);
				quotation.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editQuotationById ends");

		return quotation;
	}

	/**
	 * DAO - Generate Sales Order
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> generateSalesDAO(QuotationMasterModel quotationMasterModel) {
		logger.info("Method : generateSalesDAO starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateSaleAdvanceAmountParam.getAdvanceParam(quotationMasterModel);
			System.out.println("adv sale order Payment " + values);
			em.createNamedStoredProcedureQuery("quotationRotines").setParameter("actionType", "generateSales")
					.setParameter("actionValue", values).execute();

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				System.out.println(resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : generateSalesDAO ends");
		return response;
	}

	/**
	 * DAO - Get Sales Order
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<QuotationMasterModel>>> getSalesOrderDetails(DataTableRequest request) {
		logger.info("Method : getSalesOrderDetails starts");

		List<QuotationMasterModel> vehicleType = new ArrayList<QuotationMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationRotines")
					.setParameter("actionType", "getSalesOrder").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				Object vDate = null;
				Object pDate = null;
				Object sDate = null;
				if (m[4] != null) {
					vDate = DateFormatter.returnStringDate(m[4]);
				}
				if (m[7] != null) {
					pDate = DateFormatter.returnStringDate(m[7]);
				}
				if (m[10] != null) {
					sDate = DateFormatter.returnStringDate(m[10]);
				}

				QuotationMasterModel quote = new QuotationMasterModel(m[0], m[1], m[2], m[3], null, vDate, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, m[5], null, m[6],
						pDate, m[8], m[9], sDate, null, null, null, null, null, null, null, null, null, null, null,
						null, null, m[11], null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null,null);
				vehicleType.add(quote);
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

		JsonResponse<List<QuotationMasterModel>> resp = new JsonResponse<List<QuotationMasterModel>>();
		resp.setBody(vehicleType);
		resp.setTotal(total);
		System.out.println("vehicleType" + vehicleType);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<QuotationMasterModel>>> response = new ResponseEntity<JsonResponse<List<QuotationMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getSalesOrderDetails ends");

		return response;
	}

	/**
	 * DAO - Get Customer List
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<QuotationMasterModel> getCustomer(String id) {
		logger.info("Method : getCustomer starts");

		List<QuotationMasterModel> custList = new ArrayList<QuotationMasterModel>();
		String value = "SET @p_quotation='" + id + "';";
		System.out.println("value " + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationRotines")
					.setParameter("actionType", "getCustomer").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				QuotationMasterModel dropDownModel = new QuotationMasterModel(null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null,null);
				custList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCustomer ends");

		return custList;
	}

	/**
	 * DAO - Get Hotel List
	 * 
	 * @param id
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<QuotationMasterModel> getHotel(String id) {
		logger.info("Method : getHotel starts");

		List<QuotationMasterModel> hotelList = new ArrayList<QuotationMasterModel>();
		String value = "SET @p_quotation='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationRotines")
					.setParameter("actionType", "getHotel").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				QuotationMasterModel dropDownModel = new QuotationMasterModel(null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, m[0], m[1], m[2], m[3], m[4], null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null,null);
				hotelList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getHotel ends");

		return hotelList;
	}

	/**
	 * DAO - Get SalesOrder List By AutoSearch
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesOrderAuotSearch(String id) {
		logger.info("Method : getSalesOrderAuotSearch Dao starts");

		List<DropDownModel> customerList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_serachValue='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationRotines")
					.setParameter("actionType", "getSOList").setParameter("actionValue", value).getResultList();

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

		logger.info("Method : getSalesOrderAuotSearch Dao ends");
		return response;
	}

	/**
	 * DAO - Get PURCHASE ORDER List By AutoSearch
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPurchaseOrderListAutoSearch(String id) {
		logger.info("Method : getPurchaseOrderListAutoSearch Dao starts");

		List<DropDownModel> customerList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_serachValue='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationRotines")
					.setParameter("actionType", "getPOList").setParameter("actionValue", value).getResultList();

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

		logger.info("Method : getPurchaseOrderListAutoSearch Dao ends");
		return response;
	}

	/**
	 * DAO - Sales Order Report
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SalesOrdeReportModel>>> getSalesOrderReport(DataTableRequest request) {
		logger.info("Method : DAO getListForReportMgr starts");

		List<SalesOrdeReportModel> salesOrder = new ArrayList<SalesOrdeReportModel>();
		JsonResponse<List<SalesOrdeReportModel>> resp = new JsonResponse<List<SalesOrdeReportModel>>();

		String param1 = request.getParam1();
		String param2 = request.getParam2();
		String param7 = request.getParam7();
		String param8 = request.getParam8();
		if (param1 != null && param1 != "") {
			String frmDate = DateFormatter.getStringDate(param1);
			request.setParam1(frmDate);
		}
		if (param2 != null && param2 != "") {
			String tDate = DateFormatter.getStringDate(param2);
			request.setParam2(tDate);
		}
		if (param7 != null && param7 != "") {
			String dFDate = DateFormatter.getStringDateTimeWithoutS(param7);
			request.setParam7(dFDate);
		}
		if (param8 != null && param8 != "") {
			String dTDate = DateFormatter.getStringDateTimeWithoutS(param8);
			request.setParam8(dTDate);
		}

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationRotines")
					.setParameter("actionType", "getSOListReport").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object sDate = null;
				Object rDate = null;
				Object rTime = null;
				if (m[1] != null) {
					sDate = DateFormatter.returnStringDate(m[1]);
				}
				if (m[3] != null) {
					rDate = DateFormatter.returnStringDate(m[3]);
				}
				if (m[4] != null) {
					rTime = DateFormatter.returnStringTime(m[4]);
				}
				SalesOrdeReportModel soList = new SalesOrdeReportModel(m[0], sDate, m[2], rDate, rTime, m[5]);
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

		ResponseEntity<JsonResponse<List<SalesOrdeReportModel>>> response = new ResponseEntity<JsonResponse<List<SalesOrdeReportModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println(response);
		logger.info("Method : DAO getListForReportMgr ends");
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

	/**
	 * DAO - Get Payment Mode For Advance Payment
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAdvPaymentMode() {
		logger.info("Method : getAdvPaymentMode starts");

		List<DropDownModel> payModeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationRotines")
					.setParameter("actionType", "getAdvPayMode").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				payModeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAdvPaymentMode ends");

		return payModeList;

	}

	/**
	 * DAO - Get POS Number List By AutoSearch
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPOSNumberDao(String id) {
		logger.info("Method : getPOSNumberDao Dao starts");

		List<DropDownModel> posNumber = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_serachValue='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationRotines")
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

		logger.info("Method : getPOSNumberDao Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> reportItemCategory() {
		logger.info("Method : reportItemCategory starts");

		List<DropDownModel> serveType = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationRotines")
					.setParameter("actionType", "getItemCategory").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				serveType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : reportItemCategory ends");
		return serveType;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> reportItemSubCategory() {
		logger.info("Method : reportItemSubCategory starts");

		List<DropDownModel> serveType = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationRotines")
					.setParameter("actionType", "getItemSubCategory").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				serveType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : reportItemSubCategory ends");
		return serveType;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> reportItemListByAutoSearch(String id) {
		logger.info("Method : reportItemListByAutoSearch Dao starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_searchValue='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationRotines")
					.setParameter("actionType", "getItemList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemList.add(dropDownModel);
			}

			resp.setBody(itemList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : reportItemListByAutoSearch Dao ends");
		return response;
	}

	/**
	 * DAO - Get Quotation For Modal
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<SaleOrderAdvancePayDtlsParentModel>> getQuotationByIdForAdvancePayDtls(
			String id) {
		logger.info("Method : getQuotationByIdForAdvancePayDtls starts");

		List<QuotationMasterModel> parkingLot = new ArrayList<QuotationMasterModel>();
		List<SaleOrderAdvancePaymentModel> saleOrderAdvancePaymentModelList = new ArrayList<SaleOrderAdvancePaymentModel>();
		JsonResponse<SaleOrderAdvancePayDtlsParentModel> resp = new JsonResponse<SaleOrderAdvancePayDtlsParentModel>();
		SaleOrderAdvancePayDtlsParentModel saleOrderAdvancePayDtlsParentModel;
		try {

			String value = "SET @p_quotationId='" + id + "';";
			System.out.println("generate param data are " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationRotines")
					.setParameter("actionType", "ModalQuotation").setParameter("actionValue", value).getResultList();

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
						null, null, null, null, null, m[28], m[29], m[30], m[31], m[32], m[33], null, m[34], null, null,
						null, null, null, null, null, null, null,null);
				parkingLot.add(parking);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			String value = "SET @p_quotationId='" + id + "';";
			List<Object[]> x2 = em.createNamedStoredProcedureQuery("quotationRotines")
					.setParameter("actionType", "getAdvPayDetails").setParameter("actionValue", value).getResultList();
			if (!x2.isEmpty()) {
				for (Object[] m2 : x2) {
					SaleOrderAdvancePaymentModel saleOrderAdvancePaymentModel = new SaleOrderAdvancePaymentModel(m2[0],
							m2[1], m2[2], m2[3], m2[4], m2[5], m2[6] ,null);
					saleOrderAdvancePaymentModelList.add(saleOrderAdvancePaymentModel);
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		System.out.println("saleOrderAdvancePaymentModelList " + saleOrderAdvancePaymentModelList);
		saleOrderAdvancePayDtlsParentModel = new SaleOrderAdvancePayDtlsParentModel(parkingLot,
				saleOrderAdvancePaymentModelList);
		resp.setBody(saleOrderAdvancePayDtlsParentModel);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<SaleOrderAdvancePayDtlsParentModel>> response = new ResponseEntity<JsonResponse<SaleOrderAdvancePayDtlsParentModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getQuotationByIdForAdvancePayDtls ends");

		return response;
	}

}
