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
import nirmalya.aatithya.restmodule.common.utils.GenerateSaleOrderParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.model.CustomerGSTDataModel;
import nirmalya.aatithya.restmodule.sales.model.SaleOrderDisCountDetailsModel;
import nirmalya.aatithya.restmodule.sales.model.SalesItemModel;
import nirmalya.aatithya.restmodule.sales.model.SalesSaleOrderModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class SlaesAddSaleOrderDao {
	Logger logger = LoggerFactory.getLogger(SlaesAddSaleOrderDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	/**
	 * DAO - Add New Quotation
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addNewSaleOrder(List<SalesSaleOrderModel> quotation) {
		logger.info("Method :  addSaleOrder starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (SalesSaleOrderModel l : quotation) {
			if (l.getCustomerId() == null || l.getCustomerId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Customer Name Required");
				break;
			} else if (l.getqDescription() == null || l.getqDescription() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Sale Description Required");
				break;
			} else if (l.getQuotationVDate() == null || l.getQuotationVDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Sale Valid Date Required");
				break;
			} else if (l.getqStatus() == null) {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Sale Status Required");
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
				String values = GenerateSaleOrderParam.addSaleOrderParam(quotation);

				if (quotation.get(0).getSalesOrder() != null && quotation.get(0).getSalesOrder() != "") {
					em.createNamedStoredProcedureQuery("SaleOrderRotines").setParameter("actionType", "modifySaleOrder")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("SaleOrderRotines").setParameter("actionType", "addSaleOrder")
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

		logger.info("Method : addSaleOrder ends");
		return response;
	}

	/**
	 * DAO - Get Customer List By AutoSearch
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSaleOrderListByAuotSearch(String id) {
		logger.info("Method : getSaleOrderListByAuotSearch Dao starts");

		List<DropDownModel> customerList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_serachValue='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("SaleOrderRotines")
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

		logger.info("Method : getSaleOrderListByAuotSearch Dao ends");
		return response;
	}

	/**
	 * DAO - Get Quotation
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SalesSaleOrderModel>>> getSaleOrder(DataTableRequest request) {
		logger.info("Method : getSaleOrder starts");

		List<SalesSaleOrderModel> vehicleType = new ArrayList<SalesSaleOrderModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("SaleOrderRotines")
					.setParameter("actionType", "getSaleOrder").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				Object vDate = DateFormatter.returnStringDate(m[3]);
				Object orderRcvDate = "";
//				Object orderRcvTime = null;
				if (m[9] != null) {
					orderRcvDate = DateFormatter.returnStringDate(m[9]);
				}
//				if (m[10] != null) {
//					orderRcvTime = DateFormatter.returnStringTime(m[10]);
//				}

				SalesSaleOrderModel quote = new SalesSaleOrderModel(m[0], m[1], m[2], vDate, null, m[4], null, null,
						null, null, null, null, null, null, null, null, null, null, null, m[5], null, null, null, null,
						m[6], null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, m[7], m[8],
						orderRcvDate, m[10],null,null);
				vehicleType.add(quote);
			}
			if (x.size() > 0) {
				if (x.get(0).length > 11) {
					BigInteger t = (BigInteger) x.get(0)[11];

					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<SalesSaleOrderModel>> resp = new JsonResponse<List<SalesSaleOrderModel>>();
		resp.setBody(vehicleType);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<SalesSaleOrderModel>>> response = new ResponseEntity<JsonResponse<List<SalesSaleOrderModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getSaleOrder ends");
		return response;
	}

	/**
	 * DAO - Get Quotation For Modal
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SalesSaleOrderModel>>> getSaleOrderById(String id) {
		logger.info("Method : getSaleOrderById starts");

		List<SalesSaleOrderModel> quotation = new ArrayList<SalesSaleOrderModel>();
		JsonResponse<List<SalesSaleOrderModel>> resp = new JsonResponse<List<SalesSaleOrderModel>>();
		try {

			String value = "SET @p_saleOrderId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("SaleOrderRotines")
					.setParameter("actionType", "ModalSales").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object vdate = null;
				if(m[3]!=null) {
					vdate = DateFormatter.returnStringDate(m[3]);
				}
				Object orderRcvDate = "";
//				Object orderRcvTime = null;
				if (m[9] != null) {
					orderRcvDate = DateFormatter.returnStringDate(m[29]);
				}
//				if (m[10] != null) {
//					orderRcvTime = DateFormatter.returnStringTime(m[30]);
//				}
				SalesSaleOrderModel dropDownModel = new SalesSaleOrderModel(m[0], m[1], m[2], vdate, m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20],
						null, null, null, m[27], null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, m[21], null, null, null, null, null, null, null, m[22], m[23], m[24], m[25],
						m[26], m[28], orderRcvDate, m[30],m[31],m[32]);
				quotation.add(dropDownModel);
			}

			resp.setBody(quotation);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<SalesSaleOrderModel>>> response = new ResponseEntity<JsonResponse<List<SalesSaleOrderModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getQuotationById ends");
		return response;
	}

	/**
	 * DAO - Edit Quotation By Id
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<SalesSaleOrderModel> editSaleOrderById(String id) {
		logger.info("Method : editSaleOrderById starts");

		List<SalesSaleOrderModel> quotation = new ArrayList<SalesSaleOrderModel>();
		String value = "SET @p_saleOrderId='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("SaleOrderRotines")
					.setParameter("actionType", "EditSaleOrder").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object vdate = null;
				if(m[3]!=null) {
					vdate = DateFormatter.returnStringDate(m[3]);
				}
				Object orderRcvDate = "";
//				Object orderRcvTime = null;
				if (m[9] != null) {
					orderRcvDate = DateFormatter.returnStringDate(m[29]);
				}
//				if (m[10] != null) {
//					orderRcvTime = DateFormatter.returnStringTime(m[30]);
//				}
				SalesSaleOrderModel dropDownModel = new SalesSaleOrderModel(m[0], m[1], m[2], vdate, m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20],
						null, null, null, m[27], null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, m[21], null, null, null, null, null, null, null, m[22], m[23], m[24], m[25],
						m[26], m[28], orderRcvDate, m[30],m[31],m[32]);
				quotation.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editSaleOrderById ends");

		return quotation;
	}

	/**
	 * DAO - Get Item List By AutoSearch
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> restGetStoreList(String userId) {
		logger.info("Method : restGetStoreList Dao starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_userId='" + userId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("SaleOrderRotines")
					.setParameter("actionType", "restGetStoreList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : restGetStoreList Dao ends");
		return itemList;
	}

	/**
	 * DAO - Get Item List By AutoSearch
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SalesItemModel>>> getServetTypeByItemAndCust(String id, String custId) {
		logger.info("Method : getServetTypeByItemAndCust Dao starts");

		List<SalesItemModel> itemList = new ArrayList<SalesItemModel>();
		JsonResponse<List<SalesItemModel>> resp = new JsonResponse<List<SalesItemModel>>();

		try {
			String value = "SET @p_searchValue='" + id + "',@p_custId='" + custId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("SaleOrderRotines")
					.setParameter("actionType", "getServeTypeById").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				SalesItemModel dropDownModel = new SalesItemModel(m[0], m[1], m[2], m[3], m[4]);
				itemList.add(dropDownModel);
			}

			resp.setBody(itemList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<SalesItemModel>>> response = new ResponseEntity<JsonResponse<List<SalesItemModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getServetTypeByItemAndCust Dao ends");
		return response;
	}

	/**
	 * DAO - Get Customer List By AutoSearch
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<CustomerGSTDataModel>>> getSaleCustomerList(String id) {
		logger.info("Method : getSaleCustomerList Dao starts");

		List<CustomerGSTDataModel> customerList = new ArrayList<CustomerGSTDataModel>();
		JsonResponse<List<CustomerGSTDataModel>> resp = new JsonResponse<List<CustomerGSTDataModel>>();

		try {
			String value = "SET @p_customer='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("SaleOrderRotines")
					.setParameter("actionType", "getCustomerList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				CustomerGSTDataModel dropDownModel = new CustomerGSTDataModel(m[0], m[1], m[2]);
				customerList.add(dropDownModel);
			}

			resp.setBody(customerList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<CustomerGSTDataModel>>> response = new ResponseEntity<JsonResponse<List<CustomerGSTDataModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getSaleCustomerList Dao ends");
		return response;
	}

	/**
	 * DAO - Get discount details
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SaleOrderDisCountDetailsModel>>> getDiscountDetails(String id) {
		logger.info("Method : getDiscountDetails Dao starts");

		List<SaleOrderDisCountDetailsModel> itemList = new ArrayList<SaleOrderDisCountDetailsModel>();
		JsonResponse<List<SaleOrderDisCountDetailsModel>> resp = new JsonResponse<List<SaleOrderDisCountDetailsModel>>();

		try {
			String value = "SET @p_storeId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("SaleOrderRotines")
					.setParameter("actionType", "getDiscountDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				SaleOrderDisCountDetailsModel dropDownModel = new SaleOrderDisCountDetailsModel(m[0], m[1], m[2]);
				itemList.add(dropDownModel);
			}

			resp.setBody(itemList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<SaleOrderDisCountDetailsModel>>> response = new ResponseEntity<JsonResponse<List<SaleOrderDisCountDetailsModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getDiscountDetails Dao ends");
		return response;
	}

}
