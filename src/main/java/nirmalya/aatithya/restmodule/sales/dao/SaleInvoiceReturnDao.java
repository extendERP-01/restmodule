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
import nirmalya.aatithya.restmodule.common.utils.GenerateSalesInvoiceReturnParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.model.SaleInvoiceReturnModel;
import nirmalya.aatithya.restmodule.sales.model.SalesInvoiceModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class SaleInvoiceReturnDao {

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	Logger logger = LoggerFactory.getLogger(SaleInvoiceReturnDao.class);

	/**
	 * DAO - Get SalesOrder List By AutoSearch
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesOrderListForReturnDao(String id) {
		logger.info("Method : getSalesOrderListForReturnDao Dao starts");

		List<DropDownModel> salesOrder = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_serachValue='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvReturnRoutines")
					.setParameter("actionType", "getSaleOrderList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				salesOrder.add(dropDownModel);
			}

			resp.setBody(salesOrder);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getSalesOrderListForReturnDao Dao ends");
		return response;
	}

	/**
	 * DAO - Get Sales Invoice List By AutoSearch
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesInvoiceListForReturnDao(String salesOrder,
			String searchValue) {
		logger.info("Method : getSalesInvoiceListForReturnDao Dao starts");

		List<DropDownModel> saleInvoice = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_serachValue='" + searchValue + "',@p_salesOrder='" + salesOrder + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvReturnRoutines")
					.setParameter("actionType", "getInvoiceList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				saleInvoice.add(dropDownModel);
			}

			resp.setBody(saleInvoice);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getSalesInvoiceListForReturnDao Dao ends");
		return response;
	}

	/**
	 * DAO - Get Sale Invoice List
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> getSaleInvoiceList(String id) {
		logger.info("Method : getSaleInvoiceList starts");

		List<SalesInvoiceModel> saleInvoice = new ArrayList<SalesInvoiceModel>();
		JsonResponse<List<SalesInvoiceModel>> resp = new JsonResponse<List<SalesInvoiceModel>>();
		try {

			String value = "SET @p_saleInvoice='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvReturnRoutines")
					.setParameter("actionType", "getSaleInvoiceList").setParameter("actionValue", value)
					.getResultList();

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
						m[25], null, m[26], m[27], m[28], m[29], m[30], null, null, null, null, null, null, null, null,
						m[31],m[32],null);
				saleInvoice.add(sale);
			}

			resp.setBody(saleInvoice);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> response = new ResponseEntity<JsonResponse<List<SalesInvoiceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getSaleInvoiceList ends");
System.out.println(response);
		return response;
	}

	/**
	 * DAO - Check Sale Invoice Return
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> checkSaleInvReturnDao(String salesOrder,
			String saleInvId) {
		logger.info("Method : checkSaleInvReturnDao Dao starts");

		List<DropDownModel> saleInvoice = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_saleInvId='" + saleInvId + "',@p_salesOrder='" + salesOrder + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvReturnRoutines")
					.setParameter("actionType", "chkSaleInvReturn").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				saleInvoice.add(dropDownModel);
			}

			resp.setBody(saleInvoice);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : checkSaleInvReturnDao Dao ends");
		return response;
	}

	/**
	 * DAO - Get Item List
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> getItemListForReturnDao(
			Map<String, String> saleInvoice) {
		logger.info("Method : getItemList starts");
		List<SalesInvoiceModel> salesInv = new ArrayList<SalesInvoiceModel>();
		boolean validation = true;
		JsonResponse<List<SalesInvoiceModel>> resp = new JsonResponse<List<SalesInvoiceModel>>();

		String saleItemCode = saleInvoice.get("saleItemCode");
		String salesInvoice = saleInvoice.get("salesInvoice");

		if (validation) {
			try {
				String value = "SET @p_item='" + saleItemCode + "',@p_saleInvoice='" + salesInvoice + "';";

				List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvReturnRoutines")
						.setParameter("actionType", "getItemList").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					SalesInvoiceModel sale = new SalesInvoiceModel(null, null, null, null, null, null, null, null, null,
							null, null, null, null, m[0], m[1], m[2], m[3], m[4], null, m[5], null, null, null, null,
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
							null, m[6], null, null, null, null, null, null, null, null, null, null, null, null, null,null,null);
					salesInv.add(sale);
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

		resp.setBody(salesInv);

		ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> response = new ResponseEntity<JsonResponse<List<SalesInvoiceModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getItemList ends");
		return response;
	}

	/**
	 * DAO - Add Sales Invoice
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> addSalesInvoiceReturnDao(
			List<SaleInvoiceReturnModel> salesInvoiceReturn) {
		logger.info("Method : addSalesInvoiceReturnDao starts");
		List<SaleInvoiceReturnModel> saleInv = new ArrayList<SaleInvoiceReturnModel>();
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (SaleInvoiceReturnModel l : salesInvoiceReturn) {
			if (l.getSalesOrderId() == null || l.getSalesOrderId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Sales Order Required");
				break;
			} else if (l.getSaleInvId() == null || l.getSaleInvId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Sale Invoice Required");
				break;
			} else if (l.getSaleInvReturnDesc() == null || l.getSaleInvReturnDesc() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Sale Invoice Return Description Required");
				break;
			} else if (l.getsRItemCode() == null || l.getsRItemCode() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Sale Item Code Required");
				break;
			} else if (l.getsRItemQty() == null) {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Sale Item Quantity Required");
				break;
			}
		}
		if (validity) {
			try {

				String values = GenerateSalesInvoiceReturnParameter.addSalesInvoiceReturnParam(salesInvoiceReturn);

				if (salesInvoiceReturn.get(0).getSaleInvReturn() != null
						&& salesInvoiceReturn.get(0).getSaleInvReturn() != "") {
					em.createNamedStoredProcedureQuery("salesInvReturnRoutines")
							.setParameter("actionType", "modifySaleInvReturn").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("salesInvReturnRoutines")
							.setParameter("actionType", "addSaleInvReturn").setParameter("actionValue", values)
							.execute();
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
		resp.setBody(saleInv);
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addSalesInvoiceReturnDao ends");
		return response;

	}

	/**
	 * DAO - Get Sale Invoice Return
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SaleInvoiceReturnModel>>> getSaleInvReturnDetails(
			DataTableRequest request) {
		logger.info("Method : getSaleInvReturnDetails starts");

		List<SaleInvoiceReturnModel> saleInvReturn = new ArrayList<SaleInvoiceReturnModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvReturnRoutines")
					.setParameter("actionType", "getSaleInvReturn").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				SaleInvoiceReturnModel sale = new SaleInvoiceReturnModel(m[0], m[1], null, m[2], null, m[3], null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, m[4], null,null, null,null,null);
				saleInvReturn.add(sale);
			}
			if (x.size() > 0) {
				if (x.get(0).length > 5) {
					BigInteger t = (BigInteger) x.get(0)[5];

					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<SaleInvoiceReturnModel>> resp = new JsonResponse<List<SaleInvoiceReturnModel>>();
		resp.setBody(saleInvReturn);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<SaleInvoiceReturnModel>>> response = new ResponseEntity<JsonResponse<List<SaleInvoiceReturnModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getSaleInvReturnDetails ends");

		return response;
	}

	/**
	 * DAO - Get Sales Invoice Return By INVOICE NUMBER
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SaleInvoiceReturnModel>>> getSalesInvReturnById(String id) {
		logger.info("Method : getSalesInvReturnById starts");

		List<SaleInvoiceReturnModel> saleInvReturn = new ArrayList<SaleInvoiceReturnModel>();
		JsonResponse<List<SaleInvoiceReturnModel>> resp = new JsonResponse<List<SaleInvoiceReturnModel>>();
		try {

			String value = "SET @p_saleInvReturn='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvReturnRoutines")
					.setParameter("actionType", "ModalSaleInvReturn").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				SaleInvoiceReturnModel sale = new SaleInvoiceReturnModel(m[0], m[1], null, m[2], null, m[3], m[4], m[5],
						m[6], m[7], m[8], null, m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, m[18],null,m[19],m[20],null);
				saleInvReturn.add(sale);
			}

			resp.setBody(saleInvReturn);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<SaleInvoiceReturnModel>>> response = new ResponseEntity<JsonResponse<List<SaleInvoiceReturnModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getSalesInvReturnById ends");

		return response;
	}

	/**
	 * DAO - Edit Sale Invoice Return By Id
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<SaleInvoiceReturnModel> editSaleInvReturnById(String id) {
		logger.info("Method : editSaleInvReturnById starts");

		List<SaleInvoiceReturnModel> saleInvReturn = new ArrayList<SaleInvoiceReturnModel>();
		String value = "SET @p_saleInvReturn='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvReturnRoutines")
					.setParameter("actionType", "EditSaleInvReturn").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				SaleInvoiceReturnModel sale = new SaleInvoiceReturnModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, m[21],m[22],m[23],m[24],m[25]);
				saleInvReturn.add(sale);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editSaleInvReturnById ends");
		return saleInvReturn;
	}

	/**
	 * DAO - Get Item Code For Edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> editItemListDao(String id) {
		logger.info("Method : editItemListDao starts");

		List<DropDownModel> itemCode = new ArrayList<DropDownModel>();
		String value = "SET @p_saleInv='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvReturnRoutines")
					.setParameter("actionType", "getItemCode").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemCode.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editItemListDao ends");

		return itemCode;
	}

	/**
	 * DAO - Get Item Code For Edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<SalesInvoiceModel> editSaleInvListDao(String id) {
		logger.info("Method : editSaleInvListDao starts");

		List<SalesInvoiceModel> saleInvList = new ArrayList<SalesInvoiceModel>();
		String value = "SET @p_saleInvoice='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvReturnRoutines")
					.setParameter("actionType", "getSaleInvoiceList").setParameter("actionValue", value)
					.getResultList();

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
						m[25], null, m[26], m[27], m[28], m[29], m[30], null, null, null, null, null, null, null, null,
						null,null,null);
				saleInvList.add(sale);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editSaleInvListDao ends");

		return saleInvList;
	}

	/**
	 * DAO - Delete Sale Invoice Return
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteSaleInvReturnById(String id, String createdBy) {
		logger.info("Method : deleteSaleInvReturnById starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_saleInvReturn='" + id + "',@p_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("salesInvReturnRoutines")
					.setParameter("actionType", "deleteSaleInReturn").setParameter("actionValue", value).execute();
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
		logger.info("Method : deleteSaleInvReturnById ends");
		return response;
	}

	/**
	 * DAO - Get SalesOrder List By AutoSearch
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesInvoiceReturnListDao(String id) {
		logger.info("Method : getSalesInvoiceReturnListDao Dao starts");

		List<DropDownModel> saleInvReturn = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_serachValue='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvReturnRoutines")
					.setParameter("actionType", "getSaleInvReturnList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				saleInvReturn.add(dropDownModel);
			}

			resp.setBody(saleInvReturn);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getSalesInvoiceReturnListDao Dao ends");
		return response;
	}

	/**
	 * DAO - Get Sales Invoice Return By INVOICE NUMBER
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SaleInvoiceReturnModel>>> getSalesInvReturnByIdForPdfDao(String id) {
		logger.info("Method : getSalesInvReturnByIdForPdfDao starts");

		List<SaleInvoiceReturnModel> saleInvReturn = new ArrayList<SaleInvoiceReturnModel>();
		JsonResponse<List<SaleInvoiceReturnModel>> resp = new JsonResponse<List<SaleInvoiceReturnModel>>();
		try {

			String value = "SET @p_saleInvReturn='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvReturnRoutines")
					.setParameter("actionType", "SaleInvReturnPdf").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object cDate = null;
				if (m[18] != null) {
					cDate = DateFormatter.returnStringDate(m[18]);
				}
				SaleInvoiceReturnModel sale = new SaleInvoiceReturnModel(m[0], m[1], null, m[2], null, m[3], m[4], m[5],
						m[6], m[7], m[8], null, m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], null,
						null, null, null, null, null, null, null, null, null, null, null, cDate, null, null, m[19],null,null,null,null);
				saleInvReturn.add(sale);
			}
			resp.setBody(saleInvReturn);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<SaleInvoiceReturnModel>>> response = new ResponseEntity<JsonResponse<List<SaleInvoiceReturnModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getSalesInvReturnByIdForPdfDao ends");

		return response;
	}

	/**
	 * DAO - Get Hotel Logo
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getHotelLogoImageForSaleInvReturn(String logoType) {
		logger.info("Method : getHotelLogoImageForSaleInvReturn starts");

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

		logger.info("Method : getHotelLogoImageForSaleInvReturn ends");

		return logoList;
	}

	/**
	 * DAO - Get Customer List
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<SaleInvoiceReturnModel> getCustomerRtrnDao(String id) {
		logger.info("Method : getCustomerRtrnDao starts");

		List<SaleInvoiceReturnModel> custList = new ArrayList<SaleInvoiceReturnModel>();
		String value = "SET @p_salesOrder='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvReturnRoutines")
					.setParameter("actionType", "getCustomer").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				SaleInvoiceReturnModel dropDownModel = new SaleInvoiceReturnModel(null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, m[0], m[1], m[2], m[3], m[4], m[5], m[6], null, null, null, null,null,null,null,null);
				custList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCustomerRtrnDao ends");

		return custList;
	}

	/**
	 * DAO - Get Hotel List
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<SaleInvoiceReturnModel> getHotelRtrnDao() {
		logger.info("Method : getHotelRtrnDao starts");

		List<SaleInvoiceReturnModel> hotelList = new ArrayList<SaleInvoiceReturnModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvReturnRoutines")
					.setParameter("actionType", "getHotel").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				SaleInvoiceReturnModel dropDownModel = new SaleInvoiceReturnModel(null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, m[0],
						m[1], m[2], m[3], m[4], null, null, null, null, null, null, null, null, null, null, null,null, null,null,null);
				hotelList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getHotelRtrnDao ends");

		return hotelList;
	}

	/**
	 * DAO - Get SalesOrder List By AutoSearch
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesOrderListForReportDao(String id) {
		logger.info("Method : getSalesOrderListForReportDao Dao starts");

		List<DropDownModel> salesOrder = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_serachValue='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvReturnRoutines")
					.setParameter("actionType", "getSaleOrderReport").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				salesOrder.add(dropDownModel);
			}

			resp.setBody(salesOrder);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getSalesOrderListForReportDao Dao ends");
		return response;
	}

	/**
	 * DAO - Get Sales Invoice List By AutoSearch
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesInvoiceListForReportDao(String salesOrder,
			String searchValue) {
		logger.info("Method : getSalesInvoiceListForReportDao Dao starts");

		List<DropDownModel> saleInvoice = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_serachValue='" + searchValue + "',@p_salesOrder='" + salesOrder + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvReturnRoutines")
					.setParameter("actionType", "getInvoiceReport").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				saleInvoice.add(dropDownModel);
			}

			resp.setBody(saleInvoice);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getSalesInvoiceListForReportDao Dao ends");
		return response;
	}

	/**
	 * DAO - Sales Invoice Return Report
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SaleInvoiceReturnModel>>> getSalesInvReturnReport(
			DataTableRequest request) {
		logger.info("Method : DAO getSalesInvReturnReport starts");

		List<SaleInvoiceReturnModel> saleInvReturn = new ArrayList<SaleInvoiceReturnModel>();
		JsonResponse<List<SaleInvoiceReturnModel>> resp = new JsonResponse<List<SaleInvoiceReturnModel>>();

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
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvReturnRoutines")
					.setParameter("actionType", "getSaleInvReport").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				SaleInvoiceReturnModel sale = new SaleInvoiceReturnModel(m[0], m[1], null, m[2], null, m[3], null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null,null, null,null,null);

				saleInvReturn.add(sale);

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

		resp.setBody(saleInvReturn);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<SaleInvoiceReturnModel>>> response = new ResponseEntity<JsonResponse<List<SaleInvoiceReturnModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : DAO getSalesInvReturnReport ends");
		return response;
	}
}
