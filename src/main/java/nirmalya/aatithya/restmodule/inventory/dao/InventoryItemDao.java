/* Defines inventory ItemDAO
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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateInventoryItemParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryItemModel;

/*
 * @author NirmalyaLabs
 *
 */
@Repository
public class InventoryItemDao {
	Logger logger = LoggerFactory.getLogger(InventoryItemDao.class);
	@Autowired
	private EntityManager entityManager;
	@Autowired
	ServerDao serverDao;

	/*
	 * DAO Function to view particular itemSubCategory in dropDown for Item
	 * getSubAccountGroup
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSubAccountGroup(String id) {
		logger.info("Method : getSubAccountGroupList starts");
		List<DropDownModel> getSubAccountGroupList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_accountGroup='" + id + "';";

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "getSubAccountGroupList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getSubAccountGroupList.add(dropDownModel);
			}

			resp.setBody(getSubAccountGroupList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSubAccountGroupList ends");

		return response;
	}

	/*
	 * DAO Function to view particular itemCategory in dropDown for Item
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getItemCategory() {
		logger.info("Method : getItemCategory starts");
		List<DropDownModel> itemCategoryList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "getItemCategoryList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemCategoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getItemCategory ends");
		return itemCategoryList;
	}

	/*
	 * DAO Function to view particular itemCategory in dropDown for Item
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getProductiontype() {
		logger.info("Method : getProductiontype starts");
		List<DropDownModel> itemCategoryList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "getProductiontype").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemCategoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getProductiontype ends");
		return itemCategoryList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getItemType() {
		logger.info("Method : getItemType starts");
		List<DropDownModel> itemGroupList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "getItemType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemGroupList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getItemType ends");
		return itemGroupList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getItemGrade() {
		logger.info("Method : getItemGrade starts");
		List<DropDownModel> itemGroupList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "getItemGrade").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemGroupList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getItemGrade ends");
		return itemGroupList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getItemThickness() {
		logger.info("Method : getItemThickness starts");
		List<DropDownModel> itemGroupList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "getItemThickness").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemGroupList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getItemThickness ends");
		return itemGroupList;
	}

	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStore(String userId) {
		logger.info("Method : getStore starts");
		List<DropDownModel> itemGroupList = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_userId='" + userId + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "getStore").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemGroupList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getStore ends");
		return itemGroupList;
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
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
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
	 * DAO Function to view particular serveType in dropDown for Item
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getServeType() {
		logger.info("Method : getServeType starts");
		List<DropDownModel> ServeTypeLIst = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "getItemServeTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				ServeTypeLIst.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getServeType ends");
		return ServeTypeLIst;
	}

	/*
	 * DAO Function to view particular serviceType in dropDown for Item
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getServiceType() {
		logger.info("Method : getServiceType starts");
		List<DropDownModel> ServiceTypeList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "getServiceTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				ServiceTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getServiceType ends");
		return ServiceTypeList;
	}

	/*
	 * DAO Function to Add Item in inventory
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addItem(List<RestInventoryItemModel> restItemModel) {
		logger.info("Method : addItem starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (restItemModel.get(0).getItemCategory() == null || restItemModel.get(0).getItemCategory() == "") {
			resp.setMessage("item Category Required");
			validity = false;
		} else if (restItemModel.get(0).getItemSubCategory() == null
				|| restItemModel.get(0).getItemSubCategory() == "") {
			resp.setMessage("item SubCategory Required");
			validity = false;

		} else if (restItemModel.get(0).getServeType() == null || restItemModel.get(0).getServeType() == "") {
			resp.setMessage("serveType Required");
			validity = false;
		} else if (restItemModel.get(0).getItemName() == null || restItemModel.get(0).getItemName() == "") {
			resp.setMessage("itemName Required");
			validity = false;
		} else if (restItemModel.get(0).getItemMinStock() == null) {
			resp.setMessage("itemMinStock Required");
			validity = false;
		} else if (restItemModel.get(0).getItemMaxStock() == null) {
			resp.setMessage("itemMaxStock Required");
			validity = false;
		} /*
			 * else if (restItemModel.get(0).getServiceType() == null ||
			 * restItemModel.get(0).getServiceType() == "") {
			 * resp.setMessage("ServiceType Required"); validity = false; }
			 */ else if (restItemModel.get(0).getItemActive() == null) {
			resp.setMessage("status required");
			validity = false;
		}
		if (validity)
			try {
				String values = GenerateInventoryItemParameter.addItemParam(restItemModel);
				System.out.println("###"+values);
				if (restItemModel.get(0).getItem() != null && restItemModel.get(0).getItem() != "") {
					entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
							.setParameter("actionType", "modifyItem").setParameter("actionValue", values).execute();

				} else {
					entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
							.setParameter("actionType", "addNewItem").setParameter("actionValue", values).execute();

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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addItem ends");

		return response;
	}

	/*
	 * DAO Function to get All Item in inventory
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryItemModel>>> getAllItems(DataTableRequest request) {
		logger.info("Method : getAllItems starts");
		List<RestInventoryItemModel> restItemModel = new ArrayList<RestInventoryItemModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "viewAllItems").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				RestInventoryItemModel item = new RestInventoryItemModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], null, m[10], m[11], null, null, null, null, null, null, null, null, null ,null, null, null, null, null ,null,null,null);
				restItemModel.add(item);
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

		JsonResponse<List<RestInventoryItemModel>> resp = new JsonResponse<List<RestInventoryItemModel>>();
		resp.setBody(restItemModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestInventoryItemModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryItemModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllItems ends");
		return response;
	}

	/*
	 * DAO Function to delete Item of inventory
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteItem(String id, String createdBy) {
		logger.info("Method : deleteItem starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_item='" + id + "',@p_createdBy='" + createdBy + "';";
			entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "deleteItem").setParameter("actionValue", value).execute();

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
		logger.info("Method : deleteItem ends");
		return response;
	}

	/*
	 * DAO Function to view Item in model
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryItemModel>>> getItemForModelDao(String id) {
		logger.info("Method : getItemForModelDao starts");
		List<RestInventoryItemModel> form = new ArrayList<RestInventoryItemModel>();
		try {
			String value = "SET @p_item='" + id + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "viewOneItemForModel").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				RestInventoryItemModel restItemModel = new RestInventoryItemModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], null, m[10], m[11], null, null, null, null, m[12], m[13], m[14],null, m[15] ,m[16], m[17],m[18], m[19], m[20], m[21],null,null);
				form.add(restItemModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestInventoryItemModel>> resp = new JsonResponse<List<RestInventoryItemModel>>();
		resp.setBody(form);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestInventoryItemModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryItemModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getItemForModelDao ends");
		return response;
	}

	/*
	 * DAO Function to edit Item
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryItemModel>>> editItemByIdDao(String id) {

		logger.info("Method : editItemByIdDao starts");
		List<RestInventoryItemModel> form = new ArrayList<RestInventoryItemModel>();
		JsonResponse<List<RestInventoryItemModel>> resp = new JsonResponse<List<RestInventoryItemModel>>();
		try {
			String value = "SET @p_item='" + id + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "editItem").setParameter("actionValue", value).getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					RestInventoryItemModel restItemModel = new RestInventoryItemModel(m[0], m[1], m[2], m[3], m[4],
							m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], null, m[13], null, null, m[14], m[15],
							m[16],null, m[17] ,m[18], m[19], m[20], m[21], m[22], m[23],m[24],m[25]);
					form.add(restItemModel);
				}
				resp.setBody(form);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestInventoryItemModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryItemModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : editItemByIdDao ends");
		System.out.println("@@@@@@@"+response);
		return response;
	}

	/*
	 * DAO Function to get ItemSubCategoryList for edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getItemItemSubCategoryList(String id) {
		logger.info("Method : getItemItemSubCategoryList starts");
		List<DropDownModel> itemSubCategoryList = new ArrayList<DropDownModel>();
		String value = "SET @p_itemCategory='" + id + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "getItemSubCategoryList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemSubCategoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getItemItemSubCategoryList ends");
		return itemSubCategoryList;
	}

	/*
	 * DAO Function to view DropDown of itemName for Search Param1
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getParamItemName() {
		logger.info("Method : getParam1ItemName starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "getParamNameList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getParam1ItemName ends");
		return itemNameList;
	}

	/*
	 * DAO Function to view DropDown of Serve Type for Search Param2
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getParamServeType() {
		logger.info("Method : getParamServeType starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "getParamServeType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getParamServeType ends");
		return itemNameList;
	}

	/*
	 * DAO Function to get All Item in inventory Pdf
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryItemModel>>> getAllItemsPdf(DataTableRequest request) {
		logger.info("Method : getAllItemsPdf starts");
		List<RestInventoryItemModel> restItemModel = new ArrayList<RestInventoryItemModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "viewAllItemsPdf").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				RestInventoryItemModel item = new RestInventoryItemModel(m[0], null,null,m[1], m[2], m[3], m[4], m[5], m[6],null,
						null, m[9], null, null, null, null, null, null, null, null, null, null, m[10], null, null, null, null ,null,null,null);
				restItemModel.add(item);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestInventoryItemModel>> resp = new JsonResponse<List<RestInventoryItemModel>>();
		resp.setBody(restItemModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestInventoryItemModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryItemModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllItemsPdf ends");
		System.out.println("getAllItemsPdf"+response);
		return response;
	}

	/*
	 * DAO Function to get All Item in inventory Report
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryItemModel>>> getAllItemsReport(DataTableRequest request) {
		logger.info("Method : getAllItemsReport starts");
		List<RestInventoryItemModel> restItemModel = new ArrayList<RestInventoryItemModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "viewAllItemsReport").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					RestInventoryItemModel item = new RestInventoryItemModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
							m[7], m[8], m[9], m[10], m[11], m[12], m[13], null, null, null, null, null, null, null,
							null ,null, null, null, null, null ,null,null,null);
					restItemModel.add(item);
				}

				if (x.get(0).length > 9) {
					BigInteger t = (BigInteger) x.get(0)[9];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestInventoryItemModel>> resp = new JsonResponse<List<RestInventoryItemModel>>();
		resp.setBody(restItemModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestInventoryItemModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryItemModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllItemsReport ends");
		return response;
	}

	/*
	 * 
	 * Method for Auto Search
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemNameListByAutoSearch(String id) {
		logger.info("Method : getItemNameListByAutoSearch Dao starts");

		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_itemName='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
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

		logger.info("Method : getItemNameListByAutoSearch Dao ends");
		return response;
	}

	/*
	 * 
	 * Method for generate pdf report by searchi item Name
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> generateItemNameListByAutoSearch(String id ,String icat ) {
		logger.info("Method : generateItemNameListByAutoSearch Dao starts");

		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_itemName='" + id +"',@p_icat='"+icat+"';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "getItemNamePdf").setParameter("actionValue", value).getResultList();
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
		logger.info("Method : generateItemNameListByAutoSearch Dao ends");
		System.out.println(response);
		return response;
	}

	/*
	 * DAO Function to view particular Purchase Sub groups in dropDown for Item
	 * getSubAccountGroup
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")

	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPurchaseSubGroup(String id) {
		logger.info("Method : getPurchaseSubGroup starts");
		List<DropDownModel> getPurchaseSubGroupList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_accountGroup='" + id + "';";
		System.out.println("@@@@"+value);

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "getPurchaseGroupList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getPurchaseSubGroupList.add(dropDownModel);
			}

			resp.setBody(getPurchaseSubGroupList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getPurchaseSubGroup ends");
		System.out.println("######"+response);

		return response;
	}

	/*
	 * DAO Function to view particular Sales Sub groups in dropDown for Item
	 * getSubAccountGroup
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")

	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesSubGroup(String id) {
		logger.info("Method : getSalesSubGroup starts");
		List<DropDownModel> getsalesSubGroupList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_accountGroup='" + id + "';";
		System.out.println("$$$$$#####"+value);

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "getSalesGroupList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getsalesSubGroupList.add(dropDownModel);
			}

			resp.setBody(getsalesSubGroupList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSalesSubGroup ends");
		System.out.println("######"+response);

		return response;
	}

	/*
	 * 
	 * DAO Function to view particular itemCategory in dropDown for Item
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSacCodes() {
		logger.info("Method : getItemType starts");
		List<DropDownModel> sacCodeList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "getSaccodes").setParameter("actionValue", "").getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					String SacNameNService = "";
					if (m[2] != null) {
						SacNameNService = m[1] + "(" + m[2] + ")";
					} else {
						SacNameNService = (String) m[1];
					}
					DropDownModel sac = new DropDownModel(m[0], SacNameNService);
					sacCodeList.add(sac);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getItemType ends");
		return sacCodeList;
	}

	/*
	 * DAO - Get Hotel Logo
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getHotelLogoItem(String logoType) {
		logger.info("Method : getHotelLogo starts");

		List<DropDownModel> logoList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_logoType='" + logoType + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("logoImageRoutines")
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

	/*
	 * DAO Function to get Purchase sub group for edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEditPurchase(String id) {
		logger.info("Method : getEditPurchase starts");
		List<DropDownModel> getPurchaseSubGroupList = new ArrayList<DropDownModel>();
		String value = "SET @p_accountGroup='" + id + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "getPurchaseGroupList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getPurchaseSubGroupList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getEditPurchase ends");
		return getPurchaseSubGroupList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEditPipeSize() {
		logger.info("Method : getEditPipeSize starts");
		List<DropDownModel> pipeSizeList = new ArrayList<DropDownModel>();
		// String value = "SET @p_itemCategory='" + id + "',@p_itemSubCategory='" +
		// itemSubCategory + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "getItemPipeSizeList").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				pipeSizeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getEditPipeSize ends");
		return pipeSizeList;
	}

	/*
	 * DAO Function to get Sales sub group for edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEditSales(String id) {
		logger.info("Method : getEditSales starts");
		List<DropDownModel> getSalesSubGroupList = new ArrayList<DropDownModel>();

		String value = "SET @p_accountGroup='" + id + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "getSalesGroupList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getSalesSubGroupList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getEditSales ends");
		return getSalesSubGroupList;
	}

	/*
	 * DAO Function to view particular itemSubCategory in dropDown for Item
	 * getSubAccountGroup
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemPipeSize(String id, String itemSubCategory) {
		logger.info("Method : getItemPipeSize starts");
		List<DropDownModel> itemSubCategoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		// String value = "SET @p_itemCategory='" + id + "',@p_itemSubCategory='" +
		// itemSubCategory + "';";

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "getItemPipeSizeList").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				itemSubCategoryList.add(dropDownModel);
			}

			resp.setBody(itemSubCategoryList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemPipeSize ends");
		return response;
	}
	/*
	 * DAO Function to view DropDown of item category for Search Param1
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> paramItemCategory() {
		logger.info("Method : paramItemCategory starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "paramItemCategory").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : paramItemCategory ends");
		return itemNameList;
	}
	/*
	 * DAO Function to view DropDown of item category for Search Param1
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> paramstoreName() {
		logger.info("Method : paramstoreName starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
					.setParameter("actionType", "paramstoreName").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : paramstoreName ends");
		return itemNameList;
	}

}
