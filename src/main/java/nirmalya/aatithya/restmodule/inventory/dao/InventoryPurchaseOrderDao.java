/* Defines inventory Purchase Order DAO
 */
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
import nirmalya.aatithya.restmodule.common.utils.GenerateInventoryPurchaseOrderParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.ServerValidation;
import nirmalya.aatithya.restmodule.inventory.model.InventoryDataForDblValModel;
import nirmalya.aatithya.restmodule.inventory.model.InventorySearchPurchaseOrderModel;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryPurchaseOrderModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class InventoryPurchaseOrderDao {
	Logger logger = LoggerFactory.getLogger(InventoryPurchaseOrderDao.class);
	@Autowired
	private EntityManager entityManager;
	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to view particular itemCategory in dropDown for Purchase Order
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPItemCategory() {
		logger.info("Method : getPItemCategory starts");
		List<DropDownModel> itemCategoryList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", "getItemCategoryList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemCategoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getPItemCategory ends");
		return itemCategoryList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPOrderStoreList(String id) {
		logger.info("Method : getPOrderStoreList starts");

		List<DropDownModel> itemCategoryList = new ArrayList<DropDownModel>();

		String value = "SET @p_userId = '" + id + "';";

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", "getStore").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemCategoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getPOrderStoreList ends");
		return itemCategoryList;
	}

	/*
	 * 
	 * 
	 * get Category drop down data
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCategoryEdit(String getCategoryEdit) {

		logger.info("Method : DAO getCategoryEdit starts");

		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_CategoryId=" + 0 + ";";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", getCategoryEdit).setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModelConstructor = new DropDownModel(m[0], m[1]);
				dropDownModel.add(dropDownModelConstructor);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setBody(dropDownModel);

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : DAO getCategoryEdit ends");
		return response;
	}

	/*
	 * 
	 * 
	 * get Sub Category drop down data
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemList(String getItemList) {

		logger.info("Method : DAO getItemList starts");
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_itemNameId=" + 0 + ";";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", getItemList).setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModelConstructor = new DropDownModel(m[0], m[1]);
				dropDownModel.add(dropDownModelConstructor);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setBody(dropDownModel);

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : DAO getItemList ends");
		return response;
	}

	/**
	 * DAO Function to view dropDown of Purchase Order
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPurchaseOrder() {
		logger.info("Method : getPurchaseOrder starts");
		List<DropDownModel> purchaseOrder = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", "getpurchaseOrderList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				purchaseOrder.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getPurchaseOrder ends");

		return purchaseOrder;
	}

	/**
	 * DAO Function to view particular itemSubCategory in dropDown for Purchase
	 * Order
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPItemSubCategory(String id) {
		logger.info("Method : getItemSubCategory starts");
		List<DropDownModel> itemSubCategoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_itemCategory=" + id + ";";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
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

	/**
	 * DAO Function to view particular item name in dropDown for Purchase Order
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getpItemName(String id) {
		logger.info("Method : getpItemName starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_itemSubCategory=" + id + ";";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", "getItemNameList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
			}

			resp.setBody(itemNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getpItemName ends");
		return response;
	}

	/**
	 * DAO Function to view particular vendor in dropDown for Purchase Order
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getpVendorName(String id) {
		logger.info("Method : getpVendorName starts");
		List<DropDownModel> vendorList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_itemCategory=" + id + ";";

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", "getVendorList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				vendorList.add(dropDownModel);
			}

			resp.setBody(vendorList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getpVendorName ends");
		return response;
	}

	/**
	 * DAO Function to view particular getSelectedCat in dropDown for Purchase Order
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSelectedCat(String id) {
		logger.info("Method : getSelectedCat starts");
		List<DropDownModel> vendorList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_itemCategory=" + id + ";";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", "getSelectedCat").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				vendorList.add(dropDownModel);
			}

			resp.setBody(vendorList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSelectedCat ends");
		return response;
	}

	/**
	 * DAO Function to view particular minStock value for item category selecting
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventoryDataForDblValModel>>> getMinStock(String id, String store) {
		logger.info("Method : getMinStock starts");

		List<InventoryDataForDblValModel> minStockList = new ArrayList<InventoryDataForDblValModel>();
		JsonResponse<List<InventoryDataForDblValModel>> resp = new JsonResponse<List<InventoryDataForDblValModel>>();
		String value = "SET @p_itemId='" + id + "',@p_store='" +store +"';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", "getMinStock").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				InventoryDataForDblValModel inventoryDataForDblValModel = new InventoryDataForDblValModel(m[0], m[1],
						m[2], m[3], m[4], m[5]);
				minStockList.add(inventoryDataForDblValModel);
			}
			resp.setBody(minStockList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<InventoryDataForDblValModel>>> response = new ResponseEntity<JsonResponse<List<InventoryDataForDblValModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getMinStock ends");
		return response;
	}

	/**
	 * DAO Function to Add Purchase Order in inventory
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addPurchaseOrder(
			List<RestInventoryPurchaseOrderModel> restInventoryPurchaseOrderModel) {
		List<RestInventoryPurchaseOrderModel> vendorList = new ArrayList<RestInventoryPurchaseOrderModel>();
		logger.info("Method : addPurchaseOrder starts");
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (RestInventoryPurchaseOrderModel l : restInventoryPurchaseOrderModel) {

			if (l.getVendor() == null || l.getVendor() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Vendor Name.");
				break;
			} else if (l.getpODescription() == null || l.getpODescription() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Description.");
				break;
			} else if (l.getpOStatus() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Status.");
				break;
			} /*
				 * else if (l.getItemCategory() == null || l.getItemCategory() == "") {
				 * validation = false; resp.setCode("Field Validation Error");
				 * resp.setMessage("Please Select Item Category."); break; }
				 */else if (l.getItemSubCategory() == null || l.getItemSubCategory() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Sub Category.");
				break;
			} else if (l.getItemName() == null || l.getItemName() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please select item name.");
				break;
			} else if (l.getpOQty() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please Enter Quantity.");
				break;
			} else if (l.getPorderDate() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please Enter Order date.");
				break;
			} else if (l.getDeliveryPeriod() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please Enter Delivery period.");
				break;
			} else if (l.getTermsAndConditions() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please Enter Terms and Conditions.");
				break;
			}
		}

		if (validation)

			try {
				String values = GenerateInventoryPurchaseOrderParameter
						.getPurchaseOrderDtlParam(restInventoryPurchaseOrderModel);
				if (restInventoryPurchaseOrderModel.get(0).getPurchaseOrder() == ""
						|| restInventoryPurchaseOrderModel.get(0).getPurchaseOrder() == null) {

					@SuppressWarnings("unchecked")
					List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
							.setParameter("actionType", "addPurchaseOrder").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						RestInventoryPurchaseOrderModel employe = new RestInventoryPurchaseOrderModel(m[0], m[1], m[2],
								null, m[3], null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null);
						vendorList.add(employe);

					}

				} else {

					entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
							.setParameter("actionType", "modifyPurchaseOrder").setParameter("actionValue", values)
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
		resp.setBody(vendorList);
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: addemployee ends");
		return response;
	}

	/*
	 * DAO Function to Edit Purchase Order in inventory
	 *
	 */
	@SuppressWarnings("unused")
	public ResponseEntity<JsonResponse<Object>> updatePurchaseOrder(
			List<RestInventoryPurchaseOrderModel> restInventoryPurchaseOrderModel) {
		logger.info("Method : updatePurchaseOrder starts");
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (RestInventoryPurchaseOrderModel l : restInventoryPurchaseOrderModel) {
			if (l.getVendor() == null || l.getVendor() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Vendor Name.");
				break;
			} else if (l.getpODescription() == null || l.getpODescription() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Description.");
				break;
			} else if (l.getpOStatus() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Status.");
				break;
			} else if (l.getItemCategory() == null || l.getItemCategory() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Item Category.");
				break;
			} else if (l.getItemSubCategory() == null || l.getItemSubCategory() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Sub Category.");
				break;
			} else if (l.getItemName() == null || l.getItemName() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please select item name.");
				break;
			} else if (l.getpOQty() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please Enter Quantity.");
				break;
			}
		}

		if (validation) {

			try {
				String value = GenerateInventoryPurchaseOrderParameter
						.getPurchaseOrderDtlParam(restInventoryPurchaseOrderModel);
				if (restInventoryPurchaseOrderModel.get(0).getPurchaseOrder() != null
						&& restInventoryPurchaseOrderModel.get(0).getPurchaseOrder() != "") {
					entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
							.setParameter("actionType", "updatePurchaseOrder").setParameter("actionValue", value)
							.execute();
				}
			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage("Sucsess");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method :  updatePurchase Order ends");
		return response;
	}

	/*
	 * 
	 * DAO Function to get All Purchase Order
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryPurchaseOrderModel>>> getAllPurchaseOrder(
			DataTableRequest request) {
		logger.info("Method : getAllPurchaseOrder starts");
		if (request.getParam3() != "") {
			String param3 = request.getParam3();
			String data = DateFormatter.getStringDate(param3);
			request.setParam3(data);
		}

		if (request.getParam4() != "") {
			String param4 = request.getParam4();
			String data2 = DateFormatter.getStringDate(param4);
			request.setParam4(data2);
		}
		List<RestInventoryPurchaseOrderModel> restInventoryPurchaseOrderModel = new ArrayList<RestInventoryPurchaseOrderModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", "viewAllPurchaseOrder").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date1 = null;
					if(m[4]!=null) {
						date1 = DateFormatter.returnStringDate(m[4]);
					}
					
					Object date2 = null;
					if(m[5]!=null) {
						date2 = DateFormatter.returnStringDate(m[5]);
					}
					
					RestInventoryPurchaseOrderModel item = new RestInventoryPurchaseOrderModel(m[0], m[1], m[2], m[3],
							null, null, null, null, null, null, null, null, date1, date2, m[6], null, m[7], null, null,
							m[8], m[9], null);
					restInventoryPurchaseOrderModel.add(item);
				}

				if (x.get(0).length > 10) {
					BigInteger t = (BigInteger) x.get(0)[10];

					total = Integer.parseInt((t.toString()));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestInventoryPurchaseOrderModel>> resp = new JsonResponse<List<RestInventoryPurchaseOrderModel>>();
		resp.setBody(restInventoryPurchaseOrderModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestInventoryPurchaseOrderModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryPurchaseOrderModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllPurchaseOrder ends");
		return response;
	}

	/**
	 * DAO Function to view PurchaseOrder in model
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryPurchaseOrderModel>>> getPurchaseOrderForModel(String id) {

		logger.info("Method : getPurchaseOrderForModel starts");

		List<RestInventoryPurchaseOrderModel> mt = new ArrayList<RestInventoryPurchaseOrderModel>();
		JsonResponse<List<RestInventoryPurchaseOrderModel>> resp = new JsonResponse<List<RestInventoryPurchaseOrderModel>>();

		try {

			String value = "SET @p_purchaseOrder='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", "viewPurchaseForModel").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object date1 = null;
				date1 = DateFormatter.returnStringDate(m[8]);
				Object date2 = null;
				date2 = DateFormatter.returnStringDate(m[9]);
				RestInventoryPurchaseOrderModel purchaseOrder = new RestInventoryPurchaseOrderModel(m[0], m[1], null,
						m[2], m[3], m[4], m[5], m[6], m[7], null, null, null, date1, date2, m[10], null, null, null,
						null, null, m[11], null);

				mt.add(purchaseOrder);
			}
			resp.setBody(mt);
		} catch (Exception e) {
			e.printStackTrace();
		}
System.out.println("mt "+mt);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestInventoryPurchaseOrderModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryPurchaseOrderModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getPurchaseOrderForModel ends");
		return response;

	}

	/**
	 * DAO Function to delete Purchase Order of inventory
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deletePurchaseOrder(String id) {
		logger.info("Method : deletePurchaseOredr starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_purchaseOrder=" + id + ";";
			entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", "deletePurchaseOrder").setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
			String[] err = ServerValidation.geterror(e);
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method : deletePurchaseOrder ends");
		return response;
	}

	/**
	 * DAO Function to editPurchase Order
	 *
	 */

	@SuppressWarnings("unchecked")
	public List<RestInventoryPurchaseOrderModel> editPurchaseOrderById(String id) {

		logger.info("Method : editPurchaseOrderById starts");

		List<RestInventoryPurchaseOrderModel> restInventoryPurchaseOrderModel = new ArrayList<RestInventoryPurchaseOrderModel>();
		try {

			String value = "SET @p_purchaseOrder='" + id + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", "editPurchaseOrder").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object date1 = null;
				date1 = DateFormatter.returnStringDate(m[12]);
				Object date2 = null;
				date2 = DateFormatter.returnStringDate(m[13]);
				RestInventoryPurchaseOrderModel purchase = new RestInventoryPurchaseOrderModel(m[0], m[1], m[2], m[3],
						m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], date1, date2, m[14], null, null, null, null,
						null, m[15], m[16]);

				restInventoryPurchaseOrderModel.add(purchase);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("restInventoryPurchaseOrderModel" + restInventoryPurchaseOrderModel);
		logger.info("Method : editPurchaseOrderById ends");
		return restInventoryPurchaseOrderModel;

	}

	/**
	 * DAO Function to view particular itemSubCategory in dropDown for purchase
	 * order
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPurchaseItemSubCategory(String id) {
		logger.info("Method : getPurchaseItemSubCategory starts");
		List<DropDownModel> itemSubCategoryList = new ArrayList<DropDownModel>();
		String value = "SET @p_itemCategory='" + id + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", "getItemSubCategoryList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemSubCategoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getPurchaseItemSubCategory ends");
		return itemSubCategoryList;
	}

	/**
	 * DAO Function to view particular itemName in dropDown for purchase order
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPurchaseItemName(String id) {
		logger.info("Method : getPurchaseItemName starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		String value = "SET @p_itemCategory='" + id + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", "getItemNameList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getPurchaseItemName ends");
		return itemNameList;
	}

	/**
	 * DAO Function to view particular VendorName in dropDown for purchase order
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPurchaseVendorName(String id) {
		logger.info("Method : getPurchaseVendorName starts");
		List<DropDownModel> vendorNameList = new ArrayList<DropDownModel>();
		String value = "SET @p_itemName='" + id + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", "getVendorList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				vendorNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getPurchaseVendorName ends");
		return vendorNameList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> vendorList() {
		logger.info("Method : vendorList starts");
		List<DropDownModel> vendorList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", "vendorList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				vendorList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : vendorList ends");
		return vendorList;
	}

	/*
	 * 
	 * DAO Function to get All Purchase Order
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryPurchaseOrderModel>>> getAllPurchaseOrderPdf(
			DataTableRequest request) {
		logger.info("Method : getAllPurchaseOrderPdf starts");
		if (request.getParam3() != "") {
			String param3 = request.getParam3();
			String data = DateFormatter.getStringDate(param3);
			request.setParam3(data);
		}

		if (request.getParam4() != "") {
			String param4 = request.getParam4();
			String data2 = DateFormatter.getStringDate(param4);
			request.setParam4(data2);
		}
		List<RestInventoryPurchaseOrderModel> restInventoryPurchaseOrderModel = new ArrayList<RestInventoryPurchaseOrderModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", "viewAllPurchaseOrderPdf").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {
				Object date1 = null;
				date1 = DateFormatter.returnStringDate(m[4]);
				Object date2 = null;
				date2 = DateFormatter.returnStringDate(m[5]);
				RestInventoryPurchaseOrderModel item = new RestInventoryPurchaseOrderModel(m[0], m[1], null, m[3], null,
						null, null, null, null, null, null, null, date1, date2, null, null, null, null, null, null,
						m[6], null);
				restInventoryPurchaseOrderModel.add(item);
			}

			if (x.get(0).length > 6) {
				BigInteger t = (BigInteger) x.get(0)[6];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestInventoryPurchaseOrderModel>> resp = new JsonResponse<List<RestInventoryPurchaseOrderModel>>();
		resp.setBody(restInventoryPurchaseOrderModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestInventoryPurchaseOrderModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryPurchaseOrderModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllPurchaseOrderPdf ends");
		return response;
	}

	/*
	 * 
	 * DAO Function to get All Purchase Order
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryPurchaseOrderModel>>> getPurchaseOrderDetailsPdf(
			DataTableRequest request) {
		logger.info("Method : getPurchaseOrderDetailsPdf starts");

		if (request.getParam2() != "") {
			String param2 = request.getParam2();
			String data = DateFormatter.getStringDate(param2);
			request.setParam2(data);
		}

		if (request.getParam3() != "") {
			String param3 = request.getParam3();
			String data2 = DateFormatter.getStringDate(param3);
			request.setParam3(data2);
		}
		List<RestInventoryPurchaseOrderModel> restInventoryPurchaseOrderModel = new ArrayList<RestInventoryPurchaseOrderModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", "viewPurchaseOrderReportsPdf").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				RestInventoryPurchaseOrderModel item = new RestInventoryPurchaseOrderModel(m[0], m[7], null, m[6], m[1],
						m[2], m[3], m[4], m[5], null, null, null, null, null, null, null, null, null, null, null, m[8],
						null);
				restInventoryPurchaseOrderModel.add(item);
			}

			if (x.get(0).length > 8) {
				BigInteger t = (BigInteger) x.get(0)[8];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestInventoryPurchaseOrderModel>> resp = new JsonResponse<List<RestInventoryPurchaseOrderModel>>();
		resp.setBody(restInventoryPurchaseOrderModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestInventoryPurchaseOrderModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryPurchaseOrderModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getPurchaseOrderDetailsPdf ends");

		return response;
	}

	/**
	 * DAO Function to View all Purchase Order in excel
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryPurchaseOrderModel>>> getAllPurchaseOrderDownload(
			DataTableRequest request) {
		logger.info("Method : getAllPurchaseOrderDownload starts");
		List<RestInventoryPurchaseOrderModel> restInventoryPurchaseOrderModel = new ArrayList<RestInventoryPurchaseOrderModel>();
		JsonResponse<List<RestInventoryPurchaseOrderModel>> resp = new JsonResponse<List<RestInventoryPurchaseOrderModel>>();
		String values = GenerateParameter.getSearchParam(request);

		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", "PurchaseOrderExcel").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				RestInventoryPurchaseOrderModel purchaseOrder = new RestInventoryPurchaseOrderModel(m[0], m[1], null,
						m[2], m[3], m[4], m[5], m[6], m[7], null, null, null, null, null, null, null, null, null, null,
						null, m[8], null);

				restInventoryPurchaseOrderModel.add(purchaseOrder);

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

		resp.setBody(restInventoryPurchaseOrderModel);

		ResponseEntity<JsonResponse<List<RestInventoryPurchaseOrderModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryPurchaseOrderModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllPurchaseOrderDownload ends");
		return response;
	}

	/**
	 * DAO Function to view particular itemName in dropDown for ItemRequisition
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventorySearchPurchaseOrderModel>>> getItemListByAutoSearchWithCategory(
			String id, String vendorId) {
		logger.info("Method : getItemListByAutoSearchWithCategory starts");
		List<InventorySearchPurchaseOrderModel> itemNameList = new ArrayList<InventorySearchPurchaseOrderModel>();
		JsonResponse<List<InventorySearchPurchaseOrderModel>> resp = new JsonResponse<List<InventorySearchPurchaseOrderModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_vendorId='" + vendorId + "';";
		System.out.println("value" + value);
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", "getItemList1").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				InventorySearchPurchaseOrderModel dropDownModel = new InventorySearchPurchaseOrderModel(null, null,
						null, m[3], m[2], m[1], null, m[0]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<InventorySearchPurchaseOrderModel>>> response = new ResponseEntity<JsonResponse<List<InventorySearchPurchaseOrderModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemListByAutoSearchWithCategory ends");
		return response;
	}

	/**
	 * DAO Function to view particular minStock value for item category selecting
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryDataForDblValModel>> getTotalPrice(String itemId, String vendor) {
		logger.info("Method : getTotalPrice starts");

		List<InventoryDataForDblValModel> minStockList = new ArrayList<InventoryDataForDblValModel>();
		JsonResponse<InventoryDataForDblValModel> resp = new JsonResponse<InventoryDataForDblValModel>();
		
		String value = "SET @p_itemId='" + itemId + "',@vendor='" + vendor + "';";
		System.out.println(value);
		
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", "getTotalPrice").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				InventoryDataForDblValModel inventoryDataForDblValModel = new InventoryDataForDblValModel(null, m[0],
						m[1], null, m[2], m[3]);
				minStockList.add(inventoryDataForDblValModel);
			}
			resp.setBody(minStockList.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<InventoryDataForDblValModel>> response = new ResponseEntity<JsonResponse<InventoryDataForDblValModel>>(
				resp, HttpStatus.CREATED);

		System.out.println(response);
		logger.info("Method : getTotalPrice ends");
		return response;
	}

	/*
	 * 
	 * DAO Function to get All Purchase Order
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryPurchaseOrderModel>>> approvePurchaseOrder(
			DataTableRequest request) {
		logger.info("Method : approvePurchaseOrder starts");
		if (request.getParam3() != "") {
			String param3 = request.getParam3();
			String data = DateFormatter.getStringDate(param3);
			request.setParam3(data);
		}

		if (request.getParam4() != "") {
			String param4 = request.getParam4();
			String data2 = DateFormatter.getStringDate(param4);
			request.setParam4(data2);
		}
		List<RestInventoryPurchaseOrderModel> restInventoryPurchaseOrderModel = new ArrayList<RestInventoryPurchaseOrderModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", "approvePurchaseOrder").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date1 = null;
					if (m[4] != null) {
						date1 = DateFormatter.returnStringDate(m[4]);
					}
					Object date2 = null;
					if (m[5] != null) {
						date2 = DateFormatter.returnStringDate(m[5]);
					}
					if (m[2] != null)
						if (m[8] != null)
							m[8] = Integer.valueOf(((BigInteger) m[8]).toString());
					if (m[10] != null)
						m[10] = Integer.valueOf(((BigInteger) m[10]).toString());

					RestInventoryPurchaseOrderModel item = new RestInventoryPurchaseOrderModel(m[0], m[1], m[2], m[3],
							null, null, null, null, null, null, null, null, date1, date2, m[6], m[7], m[8], m[9], m[10],
							m[11], m[12], null);
					restInventoryPurchaseOrderModel.add(item);
				}

				if (x.get(0).length > 13) {
					BigInteger t = (BigInteger) x.get(0)[13];

					total = Integer.parseInt((t.toString()));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestInventoryPurchaseOrderModel>> resp = new JsonResponse<List<RestInventoryPurchaseOrderModel>>();
		resp.setBody(restInventoryPurchaseOrderModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestInventoryPurchaseOrderModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryPurchaseOrderModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : approvePurchaseOrder ends");
		return response;
	}

	/**
	 * DAO Function to save forward Purchase
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> forwardPurchase(String id, String createdBy) {
		logger.info("Method : forwardPurchase starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_purchase='" + id + "',@p_createdBy='" + createdBy + "';";
			entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", "forwardPurchase").setParameter("actionValue", value).execute();

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
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method : forwardPurchase ends");
		return response;
	}

	/**
	 * DAO Function to save Purchase Reject Action
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> rejectPurchase(RestInventoryPurchaseOrderModel reqobject) {
		logger.info("Method : rejectPurchase starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_purchase='" + reqobject.getPurchaseOrder() + "',@p_rejectComment='"
					+ reqobject.getpODescription() + "',@p_createdBy='" + reqobject.getCreatedBy() + "';";

			String actionType = "";
			if (reqobject.getVendor().equals("1"))
				actionType = "rejectPurchase";
			else if (reqobject.getVendor().equals("2"))
				actionType = "returnPurchase";
			else
				actionType = "resubmitPurchase";

			entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", actionType).setParameter("actionValue", value).execute();

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
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method : rejectPurchase ends");
		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorEMailIdByPO(String id) {
		logger.info("Method : getVendorEMailIdByPO starts");
		
		List<DropDownModel> minStockList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		
		String value = "SET @p_purchaseOrder='" + id + "';";
		
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryPurchaseOrderRoutines")
					.setParameter("actionType", "getVendorMail").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel inventoryDataForDblValModel = new DropDownModel(m[0], m[1]);
				minStockList.add(inventoryDataForDblValModel);
			}
			resp.setBody(minStockList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getVendorEMailIdByPO ends");
		return response;
	}
}
