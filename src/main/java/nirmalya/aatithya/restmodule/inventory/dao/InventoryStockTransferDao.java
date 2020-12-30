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
import nirmalya.aatithya.restmodule.common.utils.GenerateInventoryStockTransferParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryStockTransferModel;
import nirmalya.aatithya.restmodule.inventory.model.StockItemModel;

/*
 * @author NirmalyaLabs
 *
 */
@Repository
public class InventoryStockTransferDao {
	Logger logger = LoggerFactory.getLogger(InventoryStockTransferDao.class);
	@Autowired
	private EntityManager entityManager;
	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to view From Store in dropDown
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStockTransferFromStore(String id) {
		logger.info("Method : getStockTransferFromStore starts");
		List<DropDownModel> fromStoreList = new ArrayList<DropDownModel>();

		String value = "SET @p_userId='" + id + "';";

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryStockTransferRoutines")
					.setParameter("actionType", "getFromStore").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				fromStoreList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getStockTransferFromStore ends");

		return fromStoreList;
	}

	/**
	 * DAO Function to view To Store in dropDown
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStockTransferToStore() {
		logger.info("Method : getStockTransferToStore starts");
		List<DropDownModel> toStoreList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryStockTransferRoutines")
					.setParameter("actionType", "getToStore").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				toStoreList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getStockTransferToStore ends");

		return toStoreList;
	}

	/*
	 * DAO Function for Auto Complete for Item
	 * 
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<StockItemModel>>> getItemAutoCompleteList(String id) {

		logger.info("Method : getItemAutoCompleteList Dao starts");

		List<StockItemModel> form = new ArrayList<StockItemModel>();
		JsonResponse<List<StockItemModel>> resp = new JsonResponse<List<StockItemModel>>();
		try {
			String value = "SET @p_item='" + id + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryStockTransferRoutines")
					.setParameter("actionType", "getItemAutoSearch").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				StockItemModel itemList = new StockItemModel(m[0], m[1], m[2]);

				form.add(itemList);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resp.setBody(form);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<StockItemModel>>> response = new ResponseEntity<JsonResponse<List<StockItemModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getItemAutoCompleteList Dao ends");

		return response;
	}
	/*
	 * 
	 * Get Item Details
	 * 
	 * 
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryStockTransferModel>>> getItemDetail(String id) {
		logger.info("Method : getItemDetail starts");
		List<RestInventoryStockTransferModel> getItemDetail = new ArrayList<RestInventoryStockTransferModel>();
		JsonResponse<List<RestInventoryStockTransferModel>> resp = new JsonResponse<List<RestInventoryStockTransferModel>>();
		String value = "SET @p_item='" + id + "';";

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryStockTransferRoutines")
					.setParameter("actionType", "getItemDetail").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				RestInventoryStockTransferModel dropDownModel = new RestInventoryStockTransferModel(m[0], m[1], m[2],
						m[3], null, null, null, null, null, null, null, m[4], null, null, null, null, null, null, null,
						null);
				getItemDetail.add(dropDownModel);
			}

			resp.setBody(getItemDetail);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestInventoryStockTransferModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryStockTransferModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemDetail ends");

		return response;
	}

	/**
	 * DAO Function to add Stock transfer
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addStockTransfer(
			List<RestInventoryStockTransferModel> restInventoryStockTransferModel) {
		logger.info("Method : addStockTransfer starts");
		boolean validation = true;

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (RestInventoryStockTransferModel l : restInventoryStockTransferModel) {
			if (l.gettFromStore() == null || l.gettFromStore() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter PurchaseOrder.");
				break;

			} else if (l.gettToStore() == null || l.gettToStore() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Description.");
				break;

			}
			/*
			 * else if (l.gettSerialNo() == null || l.gettSerialNo() == "") { validation =
			 * false; resp.setCode("Field Validation Error");
			 * resp.setMessage("Please Select Item Category."); break; } else if
			 * (l.gettTransferNo() == null || l.gettTransferNo() == "") { validation =
			 * false; resp.setCode("Field Validation Error");
			 * resp.setMessage("Please Select Sub Category."); break; }
			 */
			else if (l.gettTransferDate() == null || l.gettTransferDate() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please select transfer Date");
				break;
			} else if (l.gettTransferStatus() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please Enter Quantity.");
				break;
			}

			else if (l.gettDescription() == null || l.gettDescription() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please select item description.");
				break;
			} else if (l.gettItem() == null || l.gettItem() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please select item name.");
				break;
			}

			else if (l.gettItemUnit() == null || l.gettItemUnit() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please select item Unit.");
				break;
			} else if (l.gettItemQuantity() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please select item Quanity.");
				break;
			}

		}

		if (validation) {

			try {

				String value = GenerateInventoryStockTransferParameter
						.addStockTransfer(restInventoryStockTransferModel);
				System.out.println(value);
				if (restInventoryStockTransferModel.get(0).gettStockTransferId() != null
						&& restInventoryStockTransferModel.get(0).gettStockTransferId() != "") {

					entityManager.createNamedStoredProcedureQuery("inventoryStockTransferRoutines")
							.setParameter("actionType", "modifyStockTransfer").setParameter("actionValue", value)
							.execute();
				} else {

					entityManager.createNamedStoredProcedureQuery("inventoryStockTransferRoutines")
							.setParameter("actionType", "addStockTransfer").setParameter("actionValue", value)
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
		logger.info("Method : addStockTransfer ends");
		return response;
	}

	/**
	 * DAO Function to Add GoodsReturn in inventory
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryStockTransferModel>>> getAllStockTransfer(
			DataTableRequest request) {

		logger.info("Method : getAllStockTransfer starts");

		String param3 = request.getParam3();

		if (param3 != null && param3 != "") {
			String frmDate = DateFormatter.getStringDate(param3);
			request.setParam3(frmDate);
		} else {
			request.setParam3("");
		}

		List<RestInventoryStockTransferModel> invGoodsReceiveModel = new ArrayList<RestInventoryStockTransferModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryStockTransferRoutines")
					.setParameter("actionType", "viewStockTransf").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					date = DateFormatter.returnStringDate(m[3]);
					RestInventoryStockTransferModel itmCat = new RestInventoryStockTransferModel(m[0], m[1], m[2], date,
							m[4], m[5], m[6], m[7], null, null, null, null, null, null, null, null, m[8], null, null,
							null);
					invGoodsReceiveModel.add(itmCat);
				}
				if (x.get(0).length > 9) {
					BigInteger t = (BigInteger) x.get(0)[9];

					total = Integer.parseInt((t.toString()));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestInventoryStockTransferModel>> resp = new JsonResponse<List<RestInventoryStockTransferModel>>();
		resp.setBody(invGoodsReceiveModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestInventoryStockTransferModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryStockTransferModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllStockTransfer ends");
		return response;
	}

	/**
	 * DAO Function to delete
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteStockTransfer(String id, String createdBy) {
		logger.info("Method : deleteStockTransfer starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_transferId='" + id + "',@p_createdBy='" + createdBy + "';";
			entityManager.createNamedStoredProcedureQuery("inventoryStockTransferRoutines")
					.setParameter("actionType", "deleteStock").setParameter("actionValue", value).execute();

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

		logger.info("Method : deleteStockTransfer ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> changeStockStatus(String id, String createdBy) {
		logger.info("Method : changeStockStatus starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_transferId='" + id + "',@p_createdBy='" + createdBy + "';";
			entityManager.createNamedStoredProcedureQuery("inventoryStockTransferRoutines")
					.setParameter("actionType", "changeStatus").setParameter("actionValue", value).execute();

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

		logger.info("Method : changeStockStatus ends");
		return response;
	}

	/**
	 * DAO Function to view Stock Transfer in model
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryStockTransferModel>>> modalView(String id) {
		logger.info("Method : modalView starts");
		List<RestInventoryStockTransferModel> form = new ArrayList<RestInventoryStockTransferModel>();
		try {

			String value = "SET @p_transferId='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryStockTransferRoutines")
					.setParameter("actionType", "viewStockModal").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object date = null;
				date = DateFormatter.returnStringDate(m[3]);
				RestInventoryStockTransferModel itmCat = new RestInventoryStockTransferModel(m[0], m[1], m[2], date,
						m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], null, m[12], m[13], m[14], m[15], null, null,
						null);
				form.add(itmCat);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestInventoryStockTransferModel>> resp = new JsonResponse<List<RestInventoryStockTransferModel>>();
		resp.setBody(form);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestInventoryStockTransferModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryStockTransferModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : modalView ends");
		return response;

	}

	/**
	 * DAO Function to edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<RestInventoryStockTransferModel> editStockById(String id) {
		logger.info("Method : editGoodsReceiveById starts");
		List<RestInventoryStockTransferModel> form = new ArrayList<RestInventoryStockTransferModel>();
		try {
			String value = "SET @p_transferId='" + id + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryStockTransferRoutines")
					.setParameter("actionType", "editStock").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object date = null;
				date = DateFormatter.returnStringDate(m[3]);
				RestInventoryStockTransferModel itmCat = new RestInventoryStockTransferModel(m[0], m[1], m[2], date,
						m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], null, m[12], m[13], m[14], m[15], m[16],
						m[17], m[18]);

				form.add(itmCat);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editGoodsReceiveById ends");
		return form;
	}

	/**
	 * DAO Function to view To Store in dropDown
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getTaxRate(String id) {
		logger.info("Method : getTaxRate starts");
		List<DropDownModel> toStoreList = new ArrayList<DropDownModel>();
		String value = "SET @p_item='" + id + "';";
		System.out.println(value);
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryStockTransferRoutines")
					.setParameter("actionType", "getTaxRate").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				toStoreList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTaxRate ends");
		System.out.println(toStoreList);
		return toStoreList;
	}

}
