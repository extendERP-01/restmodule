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
import nirmalya.aatithya.restmodule.common.utils.GenerateDelChallanDtls;
import nirmalya.aatithya.restmodule.common.utils.GenerateInvChallanDls;
import nirmalya.aatithya.restmodule.common.utils.GenerateSalesSOParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.model.CustomerGSTDataModel;
import nirmalya.aatithya.restmodule.sales.model.RestSalesDeliveryChallanModel;
import nirmalya.aatithya.restmodule.sales.model.RestsalesDataSetPriceModel;
import nirmalya.aatithya.restmodule.sales.model.RestsalesDeliveryChallanDetailsModel;

/**
 * @author NirmalyaLabs
 *
 */

@Repository
public class SaleDeliveryChallanMaharajaDao {
	Logger logger = LoggerFactory.getLogger(SaleDeliveryChallanMaharajaDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	EntityManager em;

	/**
	 * AUTO COMPLETE RFQ NO
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSaleOrderLByAutoSearch(String id, String storeId) {
		logger.info("Method : getSaleOrderLByAutoSearch Dao starts");
		List<DropDownModel> guestList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			String value = "SET @p_saleorder='" + id + "',@p_storeId='" + storeId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("saleDelChallanRoutines")
					.setParameter("actionType", "getSaleOrdAutoSearch").setParameter("actionValue", value)
					.getResultList();
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
		logger.info("Method : getSaleOrderLByAutoSearch Dao ends");
		return response;
	}

	/**
	 * Customer Name
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<CustomerGSTDataModel>>> getCustomerBySaleid(String id) {
		logger.info("Method : getCustomerBySaleid Dao starts");
		List<CustomerGSTDataModel> guestList = new ArrayList<CustomerGSTDataModel>();
		JsonResponse<List<CustomerGSTDataModel>> resp = new JsonResponse<List<CustomerGSTDataModel>>();
		try {
			String value = "SET @p_saleOrderId=" + id + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("saleDelChallanRoutines")
					.setParameter("actionType", "getSaleOrdCus").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				CustomerGSTDataModel dropDownModel = new CustomerGSTDataModel(m[0], m[1], m[2]);
				guestList.add(dropDownModel);
			}
			resp.setBody(guestList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<CustomerGSTDataModel>>> response = new ResponseEntity<JsonResponse<List<CustomerGSTDataModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getCustomerBySaleid Dao ends");
		return response;
	}

	/**
	 * item Name with id auto search
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestsalesDataSetPriceModel>>> getChallanItemList(
			List<RestsalesDataSetPriceModel> table) {
		logger.info("Method :  RESTMODULE DAO  getChallanItemList starts");
		List<RestsalesDataSetPriceModel> List1 = new ArrayList<RestsalesDataSetPriceModel>();
		JsonResponse<List<RestsalesDataSetPriceModel>> resp = new JsonResponse<List<RestsalesDataSetPriceModel>>();
		try {
			String values = GenerateSalesSOParameter.getsendParam(table);
			System.out.println(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("saleDelChallanRoutines")
					.setParameter("actionType", "getChallanItemList").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {
				RestsalesDataSetPriceModel RestsalesDataSetPriceModel = new RestsalesDataSetPriceModel(m[0], m[1], m[2],
						m[3], m[4], m[5], m[6], m[7], m[8], m[9]);
				List1.add(RestsalesDataSetPriceModel);
			}
			resp.setBody(List1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestsalesDataSetPriceModel>>> response = new ResponseEntity<JsonResponse<List<RestsalesDataSetPriceModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : RESTMODULE getChallanItemList ends");
		return response;
	}

	/**
	 * DAO Function to Add Delivery Challan
	 *
	 */
	@SuppressWarnings("unused")
	public ResponseEntity<JsonResponse<Object>> addDelChallanDtls(
			List<RestSalesDeliveryChallanModel> restSalesDeliveryChallanModel) {
		logger.info("Method : addDelChallanDtls starts"); 
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		for(RestSalesDeliveryChallanModel l : restSalesDeliveryChallanModel) {
			if (l.getCustomerId() == null || l.getCustomerId() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Customer Name.");
				break;
			} else if (l.getStoreId() == null || l.getStoreId() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Store Name.");
				break;
			} else if (l.getSaleOrderNo() == null || l.getSaleOrderNo() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select SaleOrder.");
				break;
			} else if (l.getQuantity() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Quantity.");
				break;
			}
		}

		if (Boolean.TRUE.equals(validation)) {
			String value = "";
			try {
				value = GenerateDelChallanDtls.getSalesChallanDtlParam(restSalesDeliveryChallanModel);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {

				System.out.println(value);
				if (restSalesDeliveryChallanModel.get(0).getDelChallanId() == null || restSalesDeliveryChallanModel.get(0).getDelChallanId() == "") {
					System.out.println("ADD");
					em.createNamedStoredProcedureQuery("saleDelChallanRoutines")
							.setParameter("actionType", "addDelChallan").setParameter("actionValue", value).execute();
				} else {
					System.out.println("MODIFY");
					em.createNamedStoredProcedureQuery("saleDelChallanRoutines")
							.setParameter("actionType", "modDelChallan").setParameter("actionValue", value).execute();
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
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addDelChallanDtls Order ends");
		return response;
	}

	/*
	 * DAO Function to View all Sales Delivery Challan Details
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSalesDeliveryChallanModel>>> getDelChallanDetails(
			DataTableRequest request) {
		logger.info("Method : DAO getDelChallanDetails starts");
		List<RestSalesDeliveryChallanModel> saleInvReturn = new ArrayList<RestSalesDeliveryChallanModel>();
		JsonResponse<List<RestSalesDeliveryChallanModel>> resp = new JsonResponse<List<RestSalesDeliveryChallanModel>>();
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
		String values = GenerateInvChallanDls.getSearchParam(request);
		Integer total = 0;
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("saleDelChallanRoutines")
					.setParameter("actionType", "getDelChallanDetails").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {
				Object challandate = null;
				if (m[2] != null) {
					challandate = DateFormatter.returnStringDate(m[2]);
				}
				RestSalesDeliveryChallanModel sale = new RestSalesDeliveryChallanModel(m[0], null, null, m[1], m[4],
						m[5], challandate, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, m[3], null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
				saleInvReturn.add(sale);
			}
			if (x.get(0).length > 6) {
				BigInteger t = (BigInteger) x.get(0)[6];
				total = Integer.parseInt((t.toString()));
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
		ResponseEntity<JsonResponse<List<RestSalesDeliveryChallanModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesDeliveryChallanModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : DAO getDelChallanDetails ends");
		return response;
	}

	/**
	 * CHANGE DELIVERY STATUS BY ID
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> restDeliveryStatus(String id, Byte status, String createdBy) {
		logger.info("Method : RESTMODULE Dao restDeliveryStatus starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		createdBy = "abc001";
		try {
			Object ReturnvalId = "";
			String value = "SET @p_challanId='" + id + "',@p_active=" + status + ",@p_createdBy='" + createdBy + "';";
			ReturnvalId = em.createNamedStoredProcedureQuery("saleDelChallanRoutines")
					.setParameter("actionType", "changeDeliveryStatus").setParameter("actionValue", value)
					.getSingleResult();
			String total = (String) ReturnvalId;
			String FailString = "Fail";
			if (total.equalsIgnoreCase(FailString)) {
				try {
					// mandatory condition for always getting catch block
					// int[] myNumbers = { 1, 2, 3 };
				} catch (Exception e) {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				}
			}
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
		logger.info("Method : RESTMODULE  Dao restDeliveryStatus ends");
		return response;
	}

	/**
	 * DAO Function to ADD/Edit Request Quotation
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> restAddDelStatus(RestSalesDeliveryChallanModel table) {
		logger.info("Method : restAddDelStatus starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (table.getImageName() == null || table.getImageName() == "") {
			resp.setMessage("*image/pdf Required");
			validity = false;
		} else if (table.getDelChallanId() == null || table.getDelChallanId() == "") {
			resp.setMessage("*Delivery Challan Id is required");
			validity = false;
		}
		if (Boolean.TRUE.equals(validity))
			try {
				String values = "SET @p_challanId='" + table.getDelChallanId() + "', @p_imageName='"
						+ table.getImageName() + "';";
				if (table.getDelChallanId() != null && table.getDelChallanId() != "") {
					em.createNamedStoredProcedureQuery("saleDelChallanRoutines")
							.setParameter("actionType", "changeDelStatus").setParameter("actionValue", values)
							.execute();
					resp.setCode("Data Saved Successfully");
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
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : restAddDelStatus ends");
		return response;
	}

	/**
	 * AUTO COMPLETE CHALLAN NO
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getChallanAutoSearch(String id) {
		logger.info("Method : getChallanAutoSearch Dao starts");
		List<DropDownModel> guestList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			String value = "SET @p_challan='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("saleDelChallanRoutines")
					.setParameter("actionType", "ChallanAutoSearch").setParameter("actionValue", value).getResultList();
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
		logger.info("Method : getChallanAutoSearch Dao ends");
		return response;
	}

	/**
	 * AUTO COMPLETE CHALLAN NO
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAutCusListBySearch(String id) {
		logger.info("Method : getAutCusListBySearch Dao starts");
		List<DropDownModel> guestList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			String value = "SET @p_customerId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("saleDelChallanRoutines")
					.setParameter("actionType", "CustomerAutoSearch").setParameter("actionValue", value)
					.getResultList();
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
		logger.info("Method : getAutCusListBySearch Dao ends");
		return response;
	}

	/**
	 * to getInveChallanDtls
	 *
	 */

	@SuppressWarnings("unchecked")
	public List<RestSalesDeliveryChallanModel> getInvChallanDtls(String id) {
		logger.info("Method : getInvChallanDtls starts");
		List<RestSalesDeliveryChallanModel> quotation = new ArrayList<RestSalesDeliveryChallanModel>();
		String value = "SET @p_challanId='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("saleDelChallanRoutines")
					.setParameter("actionType", "viewEditSlInsDtls").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object challandate = null;
				if (m[6] != null) {
					challandate = DateFormatter.returnStringDate(m[6]);
				}
				RestSalesDeliveryChallanModel invoiceDtls = new RestSalesDeliveryChallanModel(m[0], m[1], m[2], m[3],
						m[4], m[5], challandate, m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],
						m[17], m[18], m[19], m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27], null, null, null,
						null, null, null, null, null,m[28], m[29]);
				quotation.add(invoiceDtls);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getInvChallanDtls ends");
		return quotation;
	}

	/**
	 * DAO Function to Add sales Order Invoice
	 *
	 */
	@SuppressWarnings("unused")
	public ResponseEntity<JsonResponse<Object>> restAddSorderInv(
			List<RestSalesDeliveryChallanModel> RestSalesDeliveryChallanModel) {
		logger.info("Method : restAddSorderInv starts");
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (Boolean.TRUE.equals(validation)) {
			try {
				String value = GenerateInvChallanDls.getChallnDtlParam(RestSalesDeliveryChallanModel);
				if (RestSalesDeliveryChallanModel.get(0).getDelChallanId() != null) {
					em.createNamedStoredProcedureQuery("saleDelChallanRoutines")
							.setParameter("actionType", "addInvSalesCln").setParameter("actionValue", value).execute();
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
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addPurOrRFQDtls Order ends");
		return response;
	}

	/**
	 * DAO Function to get Challan Detls
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSalesDeliveryChallanModel>>> getChallanDtlsById(String id) {
		logger.info("Method : getChallanDtlsById starts");
		List<RestSalesDeliveryChallanModel> mt = new ArrayList<RestSalesDeliveryChallanModel>();
		JsonResponse<List<RestSalesDeliveryChallanModel>> resp = new JsonResponse<List<RestSalesDeliveryChallanModel>>();
		try {
			String value = "SET @p_challanId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("saleDelChallanRoutines")
					.setParameter("actionType", "ChallanModelView").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object challandate = null;
				if (m[6] != null) {
					challandate = DateFormatter.returnStringDate(m[6]);
				}
				RestSalesDeliveryChallanModel memReg = new RestSalesDeliveryChallanModel(m[0], m[1], m[2], m[3], m[4],
						m[5], challandate, m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17],
						m[18], m[19], m[20], m[21], m[22], m[23], m[24], null, null, null, null, null, null, null, null,
						null, null, null,m[25],m[26]);
				mt.add(memReg);
			}
			resp.setBody(mt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestSalesDeliveryChallanModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesDeliveryChallanModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getChallanDtlsById ends");
		return response;
	}

	/**
	 * PDF FOR Challan
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSalesDeliveryChallanModel>>> restDelChallan11(String id,
			String action11) {
		logger.info("Method : RESTMODULE  restDelChallan11  starts");
		List<RestSalesDeliveryChallanModel> mt = new ArrayList<RestSalesDeliveryChallanModel>();
		JsonResponse<List<RestSalesDeliveryChallanModel>> resp = new JsonResponse<List<RestSalesDeliveryChallanModel>>();
		try {
			String value = "SET @p_challanId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("saleDelChallanRoutines")
					.setParameter("actionType", action11).setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object challandate = null;
				if (m[6] != null) {
					challandate = DateFormatter.returnStringDate(m[6]);
				}
				RestSalesDeliveryChallanModel foodModel = new RestSalesDeliveryChallanModel(m[0], m[1], m[2], m[3],
						m[4], m[5], challandate, m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],
						m[17], m[18], m[19], m[20], m[21], m[22], m[23], m[24], null, null, m[25], m[26], null, m[27],
						m[28], m[29], m[30], m[31], m[32],null,null);
				mt.add(foodModel);
			}
			resp.setBody(mt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestSalesDeliveryChallanModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesDeliveryChallanModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : RESTMODULE restDelChallan11 ends");
		return response;
	}

	/**
	 * AUTO COMPLETE RFQ NO
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAvailQty(String menuItemCat, String menuItemSubCat,
			String menuItemId) {
		logger.info("Method : getAvailQty Dao starts");
		List<DropDownModel> availList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			String value = "SET @p_storeId='" + menuItemCat + "',@p_subCat='" + menuItemSubCat + "',@p_item='"
					+ menuItemId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("saleDelChallanRoutines")
					.setParameter("actionType", "getAvailQtys").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				availList.add(dropDownModel);
			}
			resp.setBody(availList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAvailQty Dao ends");
		return response;
	}

	/*
	 * DAO Function to view particular itemSubCategory in dropDown for Item
	 * getSubAccountGroup
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemSubCategory(String id) {
		logger.info("Method : getItemSubCategory starts");
		List<DropDownModel> itemSubCategoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_itemCategory='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "getItemSubCategoryList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemSubCategoryList.add(dropDownModel);
			}

			resp.setBody(itemSubCategoryList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemSubCategory ends");
		return response;
	}

	/*
	 * DAO Function to view particular itemSubCategory in dropDown for Item
	 * getSubAccountGroup
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestsalesDeliveryChallanDetailsModel>>> getSaleOrderDetails(String id,
			String storeId) {
		logger.info("Method : get Details ItemWise starts");
		List<RestsalesDeliveryChallanDetailsModel> saleOrderList = new ArrayList<RestsalesDeliveryChallanDetailsModel>();
		JsonResponse<List<RestsalesDeliveryChallanDetailsModel>> resp = new JsonResponse<List<RestsalesDeliveryChallanDetailsModel>>();
		String value = "SET @p_saleOrder='" + id + "',@p_storeId='" + storeId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("saleDelChallanRoutines")
					.setParameter("actionType", "getSaleOrderDetails").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				/*
				 * RestSalesDeliveryChallanModel dropDownModel = new
				 * RestSalesDeliveryChallanModel(null, null, null, null, null, null, null, null,
				 * null, null, m[0], m[1], null, m[2], null, null, null, null, null, null, null,
				 * null, null, null, null, null, null, null, null, null, null, null, m[3], m[4],
				 * null, null);
				 */

				RestsalesDeliveryChallanDetailsModel restsalesDataSetPriceModel = new RestsalesDeliveryChallanDetailsModel(
						m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14]);
				saleOrderList.add(restsalesDataSetPriceModel);
			}

			resp.setBody(saleOrderList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestsalesDeliveryChallanDetailsModel>>> response = new ResponseEntity<JsonResponse<List<RestsalesDeliveryChallanDetailsModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemSubCategory ends");
		return response;
	}

	/**
	 * get delivery from
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DropDownModel>> getDeliveryFrom(String id) {
		logger.info("Method : getDeliveryFrom Dao starts");
		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {
			String value = "SET @p_storeId=" + id + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("saleDelChallanRoutines")
					.setParameter("actionType", "getDeliveryFrom").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				resp.setBody(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<DropDownModel>> response = new ResponseEntity<JsonResponse<DropDownModel>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : getDeliveryFrom Dao ends");
		return response;
	}

	/**
	 * get delivery to
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DropDownModel>> getDeliveryTo(String id) {
		logger.info("Method : getDeliveryTo Dao starts");
		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {
			String value = "SET @p_custId=" + id + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("saleDelChallanRoutines")
					.setParameter("actionType", "getDeliveryTo").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				resp.setBody(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<DropDownModel>> response = new ResponseEntity<JsonResponse<DropDownModel>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : getDeliveryTo Dao ends");
		return response;
	}
}
