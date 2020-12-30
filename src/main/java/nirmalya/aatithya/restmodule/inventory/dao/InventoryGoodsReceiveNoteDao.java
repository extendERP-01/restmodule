/**
 * Inventory GoodsReceive Dao
 */
package nirmalya.aatithya.restmodule.inventory.dao;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import ch.qos.logback.classic.Logger;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateInventoryGoodsReceiveInvoiceParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateItemAssignToRackAndBCParam;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.AdditionalChargesModel;
import nirmalya.aatithya.restmodule.inventory.model.AllocateItemsToRackModel;
import nirmalya.aatithya.restmodule.inventory.model.BatchModel;
import nirmalya.aatithya.restmodule.inventory.model.InspectGoodsReceiveModel;
import nirmalya.aatithya.restmodule.inventory.model.InventoryCustomerMailModel;
import nirmalya.aatithya.restmodule.inventory.model.InventoryPoDetailsForGrnModel;
import nirmalya.aatithya.restmodule.inventory.model.InventorySearchPurchaseOrderModel;
import nirmalya.aatithya.restmodule.inventory.model.InventoryStoreDetailsModel;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryGoodsReceiveModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class InventoryGoodsReceiveNoteDao {
	Logger logger = (Logger) LoggerFactory.getLogger(InventoryGoodsReceiveNoteDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to view purchase order in inventory drop down
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPurchaseOrderNumber() {
		logger.info("Method : getpurchaseOrder starts");
		List<DropDownModel> purchaseOrder = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getPurchaseorder").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				purchaseOrder.add(dropDownModel);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getpurchaseOrder ends");
		return purchaseOrder;
	}

	/**
	 * DAO Function to view particular itemCategory in dropDown for GoodsReturn
	 *
	 */

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getsItemsCategoriess(String id) {
		logger.info("Method : getsItemsCategoriess starts");

		List<DropDownModel> itemCategoryList = new ArrayList<DropDownModel>();

		String value = "SET @p_itemCategory='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getItemCategoryList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemCategoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getsItemsCategoriess ends");

		return itemCategoryList;
	}

	/**
	 * DAO Function to get vendor name
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getsVendor(String id) {
		logger.info("Method : getsVendor starts");

		List<DropDownModel> vendorList = new ArrayList<DropDownModel>();

		String value = "SET @p_vendor='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getVendor").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				vendorList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getsVendor ends");

		return vendorList;
	}

	@SuppressWarnings("unchecked")
	public List<AdditionalChargesModel> editAdditionalCharges(String id) {
		logger.info("Method : editAdditionalCharges starts");

		List<AdditionalChargesModel> addChargesList = new ArrayList<AdditionalChargesModel>();

		String value = "SET @p_grnInvoice='" + id + "';";
		System.out.println(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "editAddCharges").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				AdditionalChargesModel dropDownModel = new AdditionalChargesModel(m[0], m[1]);
				addChargesList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(addChargesList);
		logger.info("Method : editAdditionalCharges ends");
		return addChargesList;
	}

	/**
	 * DAO Function to view particular itemSubCategory in dropDown for GoodsReturn
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemSubCategory(String id, String gRNPurchaseOrderId) {
		logger.info("Method : getItemSubCategory starts");
		List<DropDownModel> itemSubCategoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_itmCategory='" + id + "',@p_pOrder='" + gRNPurchaseOrderId + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getItemSubCatList").setParameter("actionValue", value).getResultList();
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
	 * DAO Function to view particular itemName in dropDown for GoodsReturn
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemName(String id, String gRNPurchaseOrderId) {
		logger.info("Method : getItemName starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_itmSubCategory='" + id + "',@p_pOrder='" + gRNPurchaseOrderId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
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
		logger.info("Method : getItemName ends");
		return response;
	}

	/**
	 * DAO Function to view particular quantity for GoodsReceive
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getQuantity(String id, String gRNPurchaseOrderId) {
		logger.info("Method : getQuantity starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_itemName='" + id + "',@p_pOrder='" + gRNPurchaseOrderId + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getQuantityList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				String qty = null;
				if (m[0] != null) {
					qty = m[0].toString();
				}
				DropDownModel dropDownModel = new DropDownModel(qty, m[1]);
				itemNameList.add(dropDownModel);
			}

			resp.setBody(itemNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getQuantity ends");

		return response;
	}

	/**
	 * DAO Function to Add GoodsReturn in inventory
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>> getAllGoodsReceive(
			DataTableRequest request) {

		logger.info("Method : getAllGoodsReceive starts");

		String param3 = request.getParam3();
		String param4 = request.getParam4();

		if (param3 != null && param3 != "") {
			String frmDate = DateFormatter.getStringDate(param3);
			request.setParam3(frmDate);
		} else {
			request.setParam3("");
		}
		if (param4 != null && param4 != "") {
			String tDate = DateFormatter.getStringDate(param4);
			request.setParam4(tDate);
		} else {
			request.setParam4("");
		}

		List<RestInventoryGoodsReceiveModel> invGoodsReceiveModel = new ArrayList<RestInventoryGoodsReceiveModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		Integer approveStageNo = 0;
		Integer approveLevelNo = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "viewGoodsReceive").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					BigInteger approveStageNoBigInt = (BigInteger) x.get(0)[6];
					approveStageNo = Integer.parseInt(approveStageNoBigInt.toString());
					BigInteger approveLevelNoBigInt = (BigInteger) x.get(0)[8];
					approveLevelNo = Integer.parseInt(approveLevelNoBigInt.toString());
					RestInventoryGoodsReceiveModel itmCat = new RestInventoryGoodsReceiveModel(m[0], m[1], null, m[2],
							null, null, m[3], null, null, null, null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, null, null, m[4], null, null, null, null, null, null,
							null, m[5], approveStageNo, m[7], approveLevelNo, m[9], null, null, null, null, null, null,
							m[10], null);
					invGoodsReceiveModel.add(itmCat);
				}
				if (x.get(0).length > 11) {
					BigInteger t = (BigInteger) x.get(0)[11];

					total = Integer.parseInt((t.toString()));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestInventoryGoodsReceiveModel>> resp = new JsonResponse<List<RestInventoryGoodsReceiveModel>>();
		resp.setBody(invGoodsReceiveModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllGoodsReceive ends");
		return response;
	}

	/**
	 * DAO Function to delete
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteGoodsReceive(String id, String createdBy) {
		logger.info("Method : deleteGoodsReceive starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_gRNInvoiceId='" + id + "',@p_createdBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "deleteGoodsReceive").setParameter("actionValue", value).execute();

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
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : deleteGoodsReceive ends");
		return response;
	}

	/**
	 * DAO Function to edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<RestInventoryGoodsReceiveModel> editGoodsReceiveById(String id) {
		logger.info("Method : editGoodsReceiveById starts");
		List<RestInventoryGoodsReceiveModel> form = new ArrayList<RestInventoryGoodsReceiveModel>();
		try {
			String value = "SET @p_gRNInvoiceId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "editGoodsReceive").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object date1 = null;
				Object date2 = null;
				if (m[21] != null) {
					date1 = DateFormatter.returnStringDate(m[21]);
				}
				if (m[22] != null) {
					date2 = DateFormatter.returnStringDate(m[22]);
				}

				RestInventoryGoodsReceiveModel invGoodsReceiveModel = new RestInventoryGoodsReceiveModel(m[0], m[1],
						null, m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], null, null, null, m[10], m[11], m[12],
						m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], date1, date2, m[23], null, m[24], m[25],
						m[26], m[27], m[28], m[29], null, null, null, null, null, m[30], m[31], m[32], m[33], m[34],
						null, m[35], m[36], m[37], m[38], m[39]);

				form.add(invGoodsReceiveModel);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(form);
		logger.info("Method : editGoodsReceiveById ends");
		return form;
	}

	/**
	 * DAO Function to get subCategory for edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getGodownList(String userId) {
		logger.info("Method : getGodownList starts");

		List<DropDownModel> itemSubCategoryList = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_userId='" + userId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getGodownList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemSubCategoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getGodownList ends");
		return itemSubCategoryList;
	}

	/**
	 * DAO Function to get item name for edit
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getItemNameList(String id) {
		logger.info("Method : getItemName starts");

		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		String value = "SET @p_itmSubCategory='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getItemNameList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getItemName ends");

		return itemNameList;
	}

	/**
	 * DAO Function to view Goods receive in model
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>> getGoodsReceiveById(String id) {
		logger.info("Method : getGoodsReceiveById starts");
		List<RestInventoryGoodsReceiveModel> form = new ArrayList<RestInventoryGoodsReceiveModel>();
		try {
			String value = "SET @p_gRNInvoiceId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "viewGoodsModal").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestInventoryGoodsReceiveModel restItemModel = new RestInventoryGoodsReceiveModel(m[0], m[1], null,
						m[2], m[3], null, m[4], m[5], m[6], m[7], m[8], null, null, null, null, m[9], m[10], m[11],
						m[12], m[13], m[14], m[15], m[16], m[17], null, null, null, null, null, null, m[18], m[19],
						m[20], m[21], null, null, null, null, null, m[22], m[23], null, m[24], m[25], null, null, m[26],
						null);
				form.add(restItemModel);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestInventoryGoodsReceiveModel>> resp = new JsonResponse<List<RestInventoryGoodsReceiveModel>>();
		resp.setBody(form);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getGoodsReceiveById ends");
		return response;

	}

	/**
	 * DAO Function to get inv Number for edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getInvoiceNumber() {
		logger.info("Method : getInvoiceNumber starts");
		List<DropDownModel> invoiceNumber = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getInvoiceNumber").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				invoiceNumber.add(dropDownModel);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getInvoiceNumber ends");
		return invoiceNumber;
	}

	/**
	 * DAO Function to get porder List
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>> listGoods(String id) {
		logger.info("Method : listGoods starts");
		List<RestInventoryGoodsReceiveModel> form = new ArrayList<RestInventoryGoodsReceiveModel>();
		String invid = "";
		try {
			String value = "SET @p_porderId='" + id + "',@p_invId='" + invid + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "listGoods").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestInventoryGoodsReceiveModel restItemModel = new RestInventoryGoodsReceiveModel(null, null, m[0],
						null, m[1], null, null, m[2], m[3], m[4], null, null, null, m[5], null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null);
				form.add(restItemModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestInventoryGoodsReceiveModel>> resp = new JsonResponse<List<RestInventoryGoodsReceiveModel>>();
		resp.setBody(form);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : listGoods ends");
		return response;
	}

	/**
	 * DAO Function to add invoice number
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> invGoodsReceive(
			List<RestInventoryGoodsReceiveModel> invGoodsReceiveModel) {
		logger.info("Method : invGoodsReceive starts");
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (RestInventoryGoodsReceiveModel l : invGoodsReceiveModel) {
			if (l.getgRNPurchaseOrderId() == null && l.getgRNPurchaseOrderId() == "") {
				if (l.getgRnInvoiceNumber() == null || l.getgRnInvoiceNumber() == "") {
					validation = false;
					resp.setCode("Field Validation Error");
					resp.setMessage("Please Select Invoice Number.");
					break;

				} else if (l.getgRnInvoiceActive() == null) {
					validation = false;
					resp.setCode("Field Validation Error");
					resp.setMessage("Please Select Status.");
					break;

				} else if (invGoodsReceiveModel.get(0).getVehicleNo() == null) {
					validation = false;
					resp.setCode("Field Validation Error");
					resp.setMessage("please Enter Vehicle no");
					break;
				} else if (invGoodsReceiveModel.get(0).getDriverName() == null) {
					validation = false;
					resp.setCode("Field Validation Error");
					resp.setMessage("please enter Driver Name.");
					break;
				} else if (invGoodsReceiveModel.get(0).getMobileNo() == null) {
					validation = false;
					resp.setCode("Field Validation Error");
					resp.setMessage("please enter mobile number.");
					break;
				}
			}
			if (l.getgRnInvoiceDescription() == null || l.getgRnInvoiceDescription() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Description.");
				break;

			} else if (l.getItmCategory() == null || l.getItmCategory() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Item Category.");
				break;
			} else if (l.getItmSubCategory() == null || l.getItmSubCategory() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Sub Category.");
				break;
			} else if (l.getgRnInvoiceItmName() == null || l.getgRnInvoiceItmName() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please select item name.");
				break;
			} else if (l.getgRnInvoiceQuantity() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please Enter Quantity.");
				break;
			} else if (invGoodsReceiveModel.get(0).getInvImg() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please select image.");
				break;
			}

		}

		if (validation) {
			try {
				String value = GenerateInventoryGoodsReceiveInvoiceParameter.getGoodsParam(invGoodsReceiveModel);
				if (invGoodsReceiveModel.get(0).getgRNInvoiceId() != null
						&& invGoodsReceiveModel.get(0).getgRNInvoiceId() != "") {
					em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
							.setParameter("actionType", "modifyGoodsReceive").setParameter("actionValue", value)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
							.setParameter("actionType", "addNewGoodsReceive").setParameter("actionValue", value)
							.execute();
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
		logger.info("Method : invGoodsReceive ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> saveBatchDetails(List<BatchModel> batch) {
		logger.info("Method : saveBatchDetails starts");
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		for (BatchModel l : batch) {

			if (l.getBatchNo() == null || l.getBatchNo() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Batch No.");
				break;
			}

		}

		if (validation) {

			try {
				String value = GenerateInventoryGoodsReceiveInvoiceParameter.saveBatchDetails(batch);

				em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
						.setParameter("actionType", "saveBatchDtls").setParameter("actionValue", value).execute();

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
		logger.info("Method : saveBatchDetails ends");
		System.out.println(response);
		return response;
	}

	/**
	 * DAO Function to get porderlist for edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<RestInventoryGoodsReceiveModel> listGoodsDetails(String id, String invId) {
		List<RestInventoryGoodsReceiveModel> itemNameList = new ArrayList<RestInventoryGoodsReceiveModel>();
		String value = "SET @p_porderId='" + id + "',@p_invoiceId='" + invId + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getAllList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				RestInventoryGoodsReceiveModel dropDownModel = new RestInventoryGoodsReceiveModel(null, m[0], m[1],
						null, m[2], null, null, m[3], m[4], m[5], null, null, null, m[6], null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null);
				itemNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getItemName ends");

		return itemNameList;
	}

	/**
	 * DAO Function to get subcategory for edit
	 *
	 */
	public List<DropDownModel> getItemSubCat(String id) {

		logger.info("Method : getItemSubCategory starts");

		List<DropDownModel> subcatList = new ArrayList<DropDownModel>();

		String value = "SET @p_subcat='" + id + "';";

		try {
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getISCat").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				subcatList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getItemSubCategory ends");
		return subcatList;
	}

	/**
	 * DAO Function to get item name for edit
	 *
	 */
	public List<DropDownModel> getItemNames(String id) {

		logger.info("Method : getItemNames starts");

		List<DropDownModel> itmsList = new ArrayList<DropDownModel>();

		String value = "SET @p_itms='" + id + "';";
		try {
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getListItems").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itmsList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getItemSubCategory ends");
		return itmsList;
	}

	/**
	 * DAO Function to get inv list for pdf
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>> getAllGoodsReceivePdf1(
			DataTableRequest request) {
		logger.info("Method : getAllGoodsReceivePdf1 starts");

		List<RestInventoryGoodsReceiveModel> invGoodsReceiveModel = new ArrayList<RestInventoryGoodsReceiveModel>();

		String param3 = request.getParam3();
		String param4 = request.getParam4();

		if (param3 != null && param3 != "") {
			String frmDate = DateFormatter.getStringDate(param3);
			request.setParam3(frmDate);

		} else {
			request.setParam3("");
		}
		if (param4 != null && param4 != "") {
			String tDate = DateFormatter.getStringDate(param4);
			request.setParam4(tDate);

		} else {
			request.setParam4("");
		}

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "viewGoodsReceivePdf").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object fromdate = null;
				fromdate = DateFormatter.returnStringDate(m[4]);

				RestInventoryGoodsReceiveModel itmCat = new RestInventoryGoodsReceiveModel(m[0], m[1], null, m[2], null,
						null, m[3], null, null, null, null, fromdate, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null);

				invGoodsReceiveModel.add(itmCat);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestInventoryGoodsReceiveModel>> resp = new JsonResponse<List<RestInventoryGoodsReceiveModel>>();
		resp.setBody(invGoodsReceiveModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAllGoodsReceivePdf1 ends");
		return response;
	}

	/**
	 * DAO Function to get All ItemRequisition in inventory to be approve
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>> getAllGoodsReceiveApprove(
			DataTableRequest request) {
		logger.info("Method : getAllGoodsReceiveApprove starts");

		if (request.getParam3() != "" && request.getParam3() != null) {
			String param3 = request.getParam3();
			String data = DateFormatter.getStringDate(param3);
			request.setParam3(data);
		}

		if (request.getParam4() != "" && request.getParam4() != null) {
			String param4 = request.getParam4();
			String data2 = DateFormatter.getStringDate(param4);
			request.setParam4(data2);
		}
		List<RestInventoryGoodsReceiveModel> restItemRequisitonModel = new ArrayList<RestInventoryGoodsReceiveModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "GoodsReceiveToApprove").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					m[6] = Integer.valueOf(((BigInteger) m[6]).toString());
					m[8] = Integer.valueOf(((BigInteger) m[8]).toString());
					RestInventoryGoodsReceiveModel item = new RestInventoryGoodsReceiveModel(m[0], m[1], null, m[2],
							null, null, m[3], null, null, null, null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, null, null, m[4], null, null, null, null, null, null,
							null, m[5], m[6], m[7], m[8], m[9], null, null, null, null, null, null, null, null);
					restItemRequisitonModel.add(item);
				}

				if (x.get(0).length > 10) {
					BigInteger t = (BigInteger) x.get(0)[10];

					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestInventoryGoodsReceiveModel>> resp = new JsonResponse<List<RestInventoryGoodsReceiveModel>>();
		resp.setBody(restItemRequisitonModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllGoodsReceiveApprove ends");
		return response;
	}

	/**
	 * DAO Function to get subcategory onchange of item name
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getOnchangeItemCategory(String id) {
		logger.info("Method : getOnchangeItemCategory starts");
		List<DropDownModel> itemCategoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_itmCategory='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getItemCat").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemCategoryList.add(dropDownModel);
			}

			resp.setBody(itemCategoryList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getOnchangeItemCategory ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getGSTAutoSerach(String id) {
		logger.info("Method : getGSTAutoSerach starts");
		List<DropDownModel> itemCategoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_item='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "GSTAutoSearch").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1].toString());
				itemCategoryList.add(dropDownModel);
			}

			resp.setBody(itemCategoryList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getGSTAutoSerach ends");
		return response;
	}

	/**
	 * DAO Function to get due date from po on change
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDueDate(String id, String invDate) {
		logger.info("Method : getDueDate starts");
		List<DropDownModel> itemCategoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_po='" + id + "',@p_invDate='" + invDate + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getDueDate").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Calendar c = Calendar.getInstance();
				try {
					c.setTime(sdf.parse(invDate));
				} catch (ParseException e) {
					e.printStackTrace();
				}

				// Number of Days to add
				c.add(Calendar.DAY_OF_MONTH, (Integer) m[1]);
				DropDownModel dropDownModel = new DropDownModel(m[0], sdf.format(c.getTime()));
				itemCategoryList.add(dropDownModel);
			}

			resp.setBody(itemCategoryList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getDueDate ends");

		return response;
	}

	/**
	 * DAO Function to get vendor onchange of porder no
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getOnchangeVendorName(String id) {
		logger.info("Method : getOnchangeVendorName starts");
		List<DropDownModel> vendorList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_vendor='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getVendor").setParameter("actionValue", value).getResultList();
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
		logger.info("Method : getOnchangeVendorName ends");

		return response;
	}

	/**
	 * DAO Function to get pdf list
	 *
	 */

	/**
	 * DAO Function to view ItemRequisition in Pdf
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>> getGoodsReceiveByIdPdf(String id) {

		logger.info("Method : getGoodsReceiveByIdPdf starts");

		List<RestInventoryGoodsReceiveModel> mt = new ArrayList<RestInventoryGoodsReceiveModel>();
		JsonResponse<List<RestInventoryGoodsReceiveModel>> resp = new JsonResponse<List<RestInventoryGoodsReceiveModel>>();

		try {
			String value = "SET @p_gRNInvoiceId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "viewGoodsNewPdf").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				Object grnDate = null;
				grnDate = DateFormatter.returnStringDate(m[2]);
				// Object poDate = null;

				// poDate = DateFormatter.returnStringDate(m[16]);
				RestInventoryGoodsReceiveModel restItemModel = new RestInventoryGoodsReceiveModel(m[0], m[1], grnDate,
						m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], null, null, null, null, m[11], m[12], m[13],
						m[14], m[15], m[16], m[17], m[18], m[19], null, null, null, null, null, null, m[20], m[21],
						m[22], m[23], null, null, null, null, null, null, m[24], null, null, null, null, null, null,
						null);
				mt.add(restItemModel);
			}
			resp.setBody(mt);

		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getGoodsReceiveByIdPdf ends");
		return response;
	}

	/**
	 * DAO Function to get quantity for edit
	 *
	 */
	public List<DropDownModel> getEditQuantities(String id, String gRNPurchaseOrderId, String gRNInvoiceId) {

		logger.info("Method : getEditQuantities starts");

		List<DropDownModel> qtyLists = new ArrayList<DropDownModel>();

		String value = "SET @p_itemName='" + id + "',@p_pOrder='" + gRNPurchaseOrderId + "',@p_inv='" + gRNInvoiceId
				+ "';";

		try {
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getQList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				qtyLists.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getEditQuantities ends");

		return qtyLists;
	}

	/**
	 * DAO Function to get porder by auto search
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPOrderByAutosearch(String id) {
		logger.info("Method : getPOrderByAutosearch Dao starts");

		List<DropDownModel> guestList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_guest='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getPOrder").setParameter("actionValue", value).getResultList();

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

	/**
	 * DAO Function to get all receive report
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>> getAllGoodsReceiveReport(
			DataTableRequest request) {
		logger.info("Method : getAllGoodsReceiveReport starts");

		List<RestInventoryGoodsReceiveModel> invGoodsReceiveModel = new ArrayList<RestInventoryGoodsReceiveModel>();

		String param3 = request.getParam3();
		String param4 = request.getParam4();

		if (param3 != null && param3 != "") {
			String frmDate = DateFormatter.getStringDate(param3);
			request.setParam3(frmDate);
		} else {
			request.setParam3("");
		}
		if (param4 != null && param4 != "") {
			String tDate = DateFormatter.getStringDate(param4);
			request.setParam4(tDate);
		} else {
			request.setParam4("");
		}

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "viewGoodsReceivePdf").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object fromdate = null;
				fromdate = DateFormatter.returnStringDate(m[4]);

				RestInventoryGoodsReceiveModel itmCat = new RestInventoryGoodsReceiveModel(m[0], m[1], null, m[2], null,
						null, m[3], null, null, null, null, fromdate, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null);
				invGoodsReceiveModel.add(itmCat);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestInventoryGoodsReceiveModel>> resp = new JsonResponse<List<RestInventoryGoodsReceiveModel>>();
		resp.setBody(invGoodsReceiveModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAllGoodsReceiveReport ends");

		return response;
	}

	/**
	 * DAO Function to get order by auto search
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPurchseOrderByAutosearch(String id) {
		logger.info("Method : getPurchseOrderByAutosearch Dao starts");

		List<DropDownModel> guestList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_guest='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getPOrder").setParameter("actionValue", value).getResultList();

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

		logger.info("Method : getPurchseOrderByAutosearch Dao ends");
		return response;
	}

	/**
	 * DAO Function to get order by auto search
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPurchseOrderBySuggests(String id) {
		logger.info("Method : getPurchseOrderBySuggests Dao starts");

		List<DropDownModel> guestList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_guest='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getPOrder").setParameter("actionValue", value).getResultList();

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

		logger.info("Method : getPurchseOrderBySuggests Dao ends");
		return response;
	}

	/**
	 * DAO Function to get inv no by auto search
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getInvoiceBySuggests(String id) {
		logger.info("Method : getInvoiceBySuggests Dao starts");

		List<DropDownModel> guestList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_invoics='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getInvoicesugst").setParameter("actionValue", value).getResultList();

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

		logger.info("Method : getInvoiceBySuggests Dao ends");
		return response;
	}

	/**
	 * DAO Function to get pending quantity
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPendingQty(String id, String gRNPurchaseOrderId) {
		logger.info("Method : getPendingQty starts");
		List<DropDownModel> pendingList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_pndg='" + id + "',@p_pOrder='" + gRNPurchaseOrderId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getPending").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				pendingList.add(dropDownModel);
			}

			resp.setBody(pendingList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getPendingQty ends");

		return response;
	}

	/**
	 * DAO Function to get pending quantity for edit
	 *
	 */
	public List<DropDownModel> getEditPendings(String id, String gRNPurchaseOrderId, String gRNInvoiceId) {

		logger.info("Method : getEditPendings starts");

		List<DropDownModel> qtyLists = new ArrayList<DropDownModel>();

		String value = "SET @p_pndg='" + id + "',@p_pOrder='" + gRNPurchaseOrderId + "',@p_inv='" + gRNInvoiceId + "';";

		try {
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getPList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				qtyLists.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getEditPendings ends");
		return qtyLists;
	}

	/**
	 * DAO Function to get price
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPriceCalculate(String id, String pOrder) {
		logger.info("Method : getPriceCalculate starts");
		List<DropDownModel> priceList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_itemName='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getPriceCal").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				priceList.add(dropDownModel);
			}

			resp.setBody(priceList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getPriceCalculate ends");
		return response;
	}
	/*
	 * 
	 * get Edit price list
	 * 
	 * 
	 */

	public List<DropDownModel> getEditPrices(String id) {

		logger.info("Method : getEditPrices starts");

		List<DropDownModel> priceLists = new ArrayList<DropDownModel>();

		String value = "SET @p_itemName='" + id + "';";

		try {
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "editPriceCal").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				priceLists.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getEditPrices ends");

		return priceLists;
	}

	/**
	 * DAO - Get Hotel Logo
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getHotelLogoForSpaService(String logoType) {
		logger.info("Method : getHotelLogoForSpaService starts");

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

		logger.info("Method : getHotelLogoForSpaService ends");
		return logoList;
	}

	/**
	 * DAO Function to view particular itemName in dropDown for ItemRequisition
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventorySearchPurchaseOrderModel>>> getItemListByAutoSearchWithPO(
			String id, String po) {
		logger.info("Method : getItemListByAutoSearchWithPO starts");
		List<InventorySearchPurchaseOrderModel> itemNameList = new ArrayList<InventorySearchPurchaseOrderModel>();
		JsonResponse<List<InventorySearchPurchaseOrderModel>> resp = new JsonResponse<List<InventorySearchPurchaseOrderModel>>();

		if (po != null && po != "") {
			String value = "SET @p_searchValue='" + id + "', @p_po='" + po + "';";
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
						.setParameter("actionType", "getItemListWithPO").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					InventorySearchPurchaseOrderModel dropDownModel = new InventorySearchPurchaseOrderModel(null, null,
							null, m[3], m[2], m[1], null, m[0]);
					itemNameList.add(dropDownModel);
				}
				resp.setBody(itemNameList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			String value = "SET @p_searchValue='" + id + "';";
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
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
		}

		ResponseEntity<JsonResponse<List<InventorySearchPurchaseOrderModel>>> response = new ResponseEntity<JsonResponse<List<InventorySearchPurchaseOrderModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemListByAutoSearchWithPO ends");
		return response;
	}

	/**
	 * DAO Function to save Requisition Approval Action
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> saveGoodsreceiveApprovalAction(String id, String createdBy) {
		logger.info("Method : forwardGoodsReceive starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_goodsReceive='" + id + "',@p_createdBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "forwardInvoice").setParameter("actionValue", value).execute();

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
		logger.info("Method : forwardGoodsReceive ends");
		return response;
	}

	/**
	 * DAO Function to save Requisition Reject Action
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> saveGoodsreceiveRejectAction(RestInventoryGoodsReceiveModel reqobject) {
		logger.info("Method : saveGoodsreceiveRejectAction starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_goodsReceive='" + reqobject.getgRNInvoiceId() + "',@p_rejectComment='"
					+ reqobject.getgRnInvoiceDescription() + "',@p_createdBy='" + reqobject.getCreatedBy() + "';";

			String actionType = "";
			if (reqobject.getApproverStageNo().equals(1))
				actionType = "rejectInvoice";
			else if (reqobject.getApproverStageNo().equals(2))
				actionType = "returnInvoice";
			else
				actionType = "resubmitInvoice";

			em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines").setParameter("actionType", actionType)
					.setParameter("actionValue", value).execute();

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
		logger.info("Method : saveGoodsreceiveRejectAction ends");
		return response;
	}

	/**
	 * DAO Function to view particular itemName in dropDown for ItemRequisition
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventoryPoDetailsForGrnModel>>> getPurchaseOrderDetails(String id) {
		logger.info("Method : getPurchaseOrderDetails starts");
		List<InventoryPoDetailsForGrnModel> itemNameList = new ArrayList<InventoryPoDetailsForGrnModel>();
		JsonResponse<List<InventoryPoDetailsForGrnModel>> resp = new JsonResponse<List<InventoryPoDetailsForGrnModel>>();

		String value = "SET @p_po='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getPOItemsDetails").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				InventoryPoDetailsForGrnModel dropDownModel = new InventoryPoDetailsForGrnModel(m[0], m[1], m[2], m[3],
						m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<InventoryPoDetailsForGrnModel>>> response = new ResponseEntity<JsonResponse<List<InventoryPoDetailsForGrnModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("Response Of PO============" + response);
		logger.info("Method : getPurchaseOrderDetails ends");
		return response;
	}

	/**
	 * DAO Function to get porderlist for edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStoreDetailsDao(String id) {
		logger.error("Method : getStoreDetailsDao starts");

		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		String value = "SET @p_storeId='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getStoreDtlsById1").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
//				 InventoryStoreDetailsModel inventoryStoreDetailsModel = new InventoryStoreDetailsModel(m[0], m[1],
//						  m[2], m[3] , m[4], m[5], m[6]); 

				DropDownModel inventoryStoreDetailsModel = new DropDownModel(m[0], m[1]);

				/*
				 * InventoryStoreDetailsModel inventoryStoreDetailsModel = new
				 * InventoryStoreDetailsModel(m[0], m[1], null, null , null, null, null);
				 */
				itemNameList.add(inventoryStoreDetailsModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getStoreDetailsDao ends");
		return itemNameList;
	}

	/*
	 * for getVenderDetails
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryStoreDetailsModel> getVenderDetails(String userId) {
		logger.info("Method in Dao: getVenderDetails starts");

		List<InventoryStoreDetailsModel> paymentVoucherModelList = new ArrayList<InventoryStoreDetailsModel>();

		try {
			String value = "SET @p_storeId='" + userId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentVoucher")
					.setParameter("actionType", "getStoreDtlsById1").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				InventoryStoreDetailsModel dropDownModel = new InventoryStoreDetailsModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6]);
				paymentVoucherModelList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getVenderDetails ends");
		return paymentVoucherModelList;
	}

	/**
	 * DAO Function to view Goods receive in model
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventoryCustomerMailModel>>> getDetailsForMail(String id) {
		logger.info("Method : getDetailsForMail starts");
		List<InventoryCustomerMailModel> form = new ArrayList<InventoryCustomerMailModel>();
		try {
			String value = "SET @p_gRNInvoiceId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "mailDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				InventoryCustomerMailModel restItemModel = new InventoryCustomerMailModel(m[0], m[1], m[2], m[3], m[4],
						m[5]);
				form.add(restItemModel);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<InventoryCustomerMailModel>> resp = new JsonResponse<List<InventoryCustomerMailModel>>();
		resp.setBody(form);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<InventoryCustomerMailModel>>> response = new ResponseEntity<JsonResponse<List<InventoryCustomerMailModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getDetailsForMail ends");
		return response;

	}

	/**
	 * DAO Function to view particular itemName in dropDown for ItemRequisition
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventoryCustomerMailModel>>> getPurchaseOrderDetails1(String id) {
		logger.info("Method : getPurchaseOrderDetails starts");
		List<InventoryCustomerMailModel> itemNameList = new ArrayList<InventoryCustomerMailModel>();
		JsonResponse<List<InventoryCustomerMailModel>> resp = new JsonResponse<List<InventoryCustomerMailModel>>();

		String value = "SET @p_grnId='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "mailDetails").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				InventoryCustomerMailModel dropDownModel = new InventoryCustomerMailModel(m[0], m[1], m[2], m[3], m[4],
						m[5]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<InventoryCustomerMailModel>>> response = new ResponseEntity<JsonResponse<List<InventoryCustomerMailModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getPurchaseOrderDetails ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<BatchModel>>> editViewBatchDetails(BatchModel id) {
		logger.info("Method : editViewBatchDetails starts");

		List<BatchModel> batch = new ArrayList<BatchModel>();
		JsonResponse<List<BatchModel>> resp = new JsonResponse<List<BatchModel>>();

		String value = "SET @p_grnInvoice='" + id.getGrn() + "', @p_grnItem='" + id.getItemId() + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "editViewBatch").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				BatchModel dropDownModel = new BatchModel(m[0], m[1], m[2], m[3], m[4], null, m[5], null);
				batch.add(dropDownModel);
			}

			resp.setBody(batch);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<BatchModel>>> response = new ResponseEntity<JsonResponse<List<BatchModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : editViewBatchDetails ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSequenceNumber(String id, String grn, String item) {
		logger.info("Method in Dao: getSequenceNumber starts");

		List<DropDownModel> seqList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_batch='" + id + "', @p_grnInvoice='" + grn + "', @p_grnItem='" + item + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getSequenceNumber").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				seqList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getSequenceNumber ends");
		return seqList;
	}

	public ResponseEntity<JsonResponse<Object>> saveInspectDetails(List<InspectGoodsReceiveModel> batch) {
		logger.info("Method : saveInspectDetails starts");
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		for (InspectGoodsReceiveModel l : batch) {

			if (l.getPo() == null || l.getPo() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter PO No.");
				break;
			}

		}

		if (validation) {
			List<InspectGoodsReceiveModel> inspectList = batch.stream()
					.filter(s -> s.getInspectStatus().contentEquals("1")).collect(Collectors.toList());
			List<InspectGoodsReceiveModel> returnList = batch.stream()
					.filter(s -> s.getInspectStatus().contentEquals("2")).collect(Collectors.toList());
			if (!inspectList.isEmpty()) {
				try {
					String value = GenerateInventoryGoodsReceiveInvoiceParameter.saveInspectDetails(inspectList);

					em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
							.setParameter("actionType", "updateInpectDtls").setParameter("actionValue", value)
							.execute();

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
			if (!returnList.isEmpty()) {
				for (InspectGoodsReceiveModel a : returnList) {
					try {
						String value = GenerateInventoryGoodsReceiveInvoiceParameter.updateReturn(a);

						em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
								.setParameter("actionType", "updateReturnDtls").setParameter("actionValue", value)
								.execute();

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

			}

		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : saveInspectDetails ends");
		return response;
	}

	/**
	 * DAO Function to get sub Inventory Name name
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSubInventoryByStore(String id) {
		logger.info("Method : getSubInventoryByStore starts");

		List<DropDownModel> subInventororyList = new ArrayList<DropDownModel>();

		String value = "SET @p_storeId='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getSubInventoryByStore").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				subInventororyList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getSubInventoryByStore ends");

		return subInventororyList;
	}

	/**
	 * DAO Function to get sub Inventory Name name
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSubInventoryByStorePost(List<DropDownModel> itemList) {
		logger.info("Method : getSubInventoryByStorePost starts");

		List<DropDownModel> subInventororyList = new ArrayList<DropDownModel>();

		String items = "";

		for (DropDownModel a : itemList) { 
			items = items + "\""+   a.getKey() + "\",";
		}
		items = items.substring(0, items.length() - 1);

		String value = "SET @p_storeId='" + itemList.get(0).getName() + "',@p_itemId='" + items + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getSubInventoryByStorePost").setParameter("actionValue", value)
					.getResultList();
			if (!x.isEmpty())
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					subInventororyList.add(dropDownModel);
				}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getSubInventoryByStorePost ends");

		return subInventororyList;
	}
	
	
	/**
	 * DAO Function to get sub Inventory Name name
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getWareHousePost(List<DropDownModel> itemList) {
		logger.info("Method : getWareHousePost starts");

		List<DropDownModel> subInventororyList = new ArrayList<DropDownModel>();

		String items = "";

		for (DropDownModel a : itemList) { 
			items = items + "\""+   a.getKey() + "\",";
		}
		items = items.substring(0, items.length() - 1);

		String value = "SET @p_storeId='" + itemList.get(0).getName() + "',@p_itemId='" + items + "';";
		System.out.println("value " + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getWareHousePost").setParameter("actionValue", value)
					.getResultList();
			if (!x.isEmpty())
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					subInventororyList.add(dropDownModel);
				}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("subInventororyList " + subInventororyList);
		logger.info("Method : getWareHousePost ends");

		return subInventororyList;
	}
	

	/**
	 * DAO Function to view shelf list
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AllocateItemsToRackModel>>> getShelfsList(String id, String itemId) {
		logger.info("Method : getShelfsList starts");
		List<AllocateItemsToRackModel> itemSubCategoryList = new ArrayList<AllocateItemsToRackModel>();
		JsonResponse<List<AllocateItemsToRackModel>> resp = new JsonResponse<List<AllocateItemsToRackModel>>();

		String value = "SET @p_wh_Id='" + id + "',@p_itemId='" + itemId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getShelfsList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				AllocateItemsToRackModel dropDownModel = new AllocateItemsToRackModel(m[0], null, m[1], m[2], m[3]);
				itemSubCategoryList.add(dropDownModel);
			}

			resp.setBody(itemSubCategoryList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<AllocateItemsToRackModel>>> response = new ResponseEntity<JsonResponse<List<AllocateItemsToRackModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getShelfsList ends");

		return response;

	}

	/**
	 * DAO Function to view ware house list
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getWareHouseList(String id) {
		logger.info("Method : getWareHouseList starts");
		List<DropDownModel> itemSubCategoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_sub_invId='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getWareHouseList").setParameter("actionValue", value).getResultList();
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
		logger.info("Method : getWareHouseList ends");

		return response;

	}

	/**
	 * DAO Function to add invoice number
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> saveAllocateDetails(
			List<AllocateItemsToRackModel> invGoodsReceiveModel) {
		logger.info("Method : saveAllocateDetails starts");
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (AllocateItemsToRackModel l : invGoodsReceiveModel) {
			if (l.getStoreId() == null || l.getStoreId() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Store.");
				break;

			} else if (l.getPoNo() == null || l.getPoNo() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select PO.");
				break;
			} else if (l.getSubInventoryId() == null || l.getSubInventoryId() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Sub Inventory.");
				break;
			} else if (l.getWareHouseId() == null || l.getWareHouseId() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please select Ware House.");
				break;
			} else if (l.getItemId() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please Select Item.");
				break;
			}

		}

		if (validation) {
			try {
				String value = GenerateItemAssignToRackAndBCParam.getSaveParam(invGoodsReceiveModel);

				/*
				 * em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
				 * .setParameter("actionType", "modifyGoodsReceive").setParameter("actionValue",
				 * value) .execute();
				 */

				em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
						.setParameter("actionType", "addAllocateShelf").setParameter("actionValue", value).execute();

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
		logger.info("Method : saveAllocateDetails ends");

		return response;
	}

	/**
	 * DAO Function to add invoice number
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> saveBarcodeDetails(List<AllocateItemsToRackModel> dataList) {
		logger.info("Method : saveBarcodeDetails starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = GenerateItemAssignToRackAndBCParam.getSaveBarcodeParam(dataList);

			em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "saveBarcodeDetails").setParameter("actionValue", value).execute();

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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : saveAllocateDetails ends");

		return response;
	}

	/**
	 * DAO Function to add invoice number
	 *
	 */
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getBarcodeDetails(
			List<AllocateItemsToRackModel> dataList) {
		logger.info("Method : saveBarcodeDetails starts");
		List<DropDownModel> itemSubCategoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = GenerateItemAssignToRackAndBCParam.getBarcodeParam(dataList);
		System.out.println("value " + value);
		try {
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("goodsReceiveInvoiceRoutines")
					.setParameter("actionType", "getBarcodesData").setParameter("actionValue", value).getResultList();
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
		logger.info("Method : getWareHouseList ends");
		System.out.println("resp " + resp);
		return response;
	}

}
