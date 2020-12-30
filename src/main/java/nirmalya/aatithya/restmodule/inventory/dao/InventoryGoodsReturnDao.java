package nirmalya.aatithya.restmodule.inventory.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateInventoryGoodsReturnParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.GRNReturnListModel;
import nirmalya.aatithya.restmodule.inventory.model.InventoryGoodsReturnsNoteModel;

/**
 * @author NirmalyaLabs
 *
 */

@Repository
public class InventoryGoodsReturnDao {
	Logger logger = LoggerFactory.getLogger(InventoryGoodsReturnDao.class);
	@Autowired
	private EntityManager entityManager;

	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to view particular itemCategory in dropDown for goods return
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getItemCategory(String id) {
		logger.info("Method : getItemCategorry starts");
		List<DropDownModel> itemCategoryList = new ArrayList<DropDownModel>();
		String value = "SET @p_itemCategory='" + id + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "getItemCategory").setParameter("actionValue", value).getResultList();

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

	/**
	 * DAO Function to view particular itemSubCategory in dropDown for goods return
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemSubCategory(String id, String gRNInvoiceId) {
		logger.info("Method : getItemSubCategory starts");
		List<DropDownModel> itemSubCategoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_itemCategory='" + id + "',@p_invoiceId='" + gRNInvoiceId + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "getItemSubCategory").setParameter("actionValue", value)
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
	 * DAO Function to view particular itemName in dropDown for goods return
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getsItemsNames(String id, String gRNInvoiceId) {
		logger.info("Method : getsItemsNames starts");
		List<DropDownModel> itemSubCategoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_itemSubCategory='" + id + "',@p_invoiceId='" + gRNInvoiceId + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "getItemName").setParameter("actionValue", value).getResultList();
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
		logger.info("Method : getsItemsNames ends");
		return response;
	}

	/**
	 * DAO Function to view purchase order in inventory drop down
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getpurchaseOrder() {
		logger.info("Method : getpurchaseOrder starts");
		List<DropDownModel> purchaseOrder = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
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
	 * DAO Function to get All GoodsReturn in inventory
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventoryGoodsReturnsNoteModel>>> getAllGoodsreturn(
			DataTableRequest request) {
		logger.info("Method : getAllGoodsreturn starts");
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
		List<InventoryGoodsReturnsNoteModel> inventoryGoodsReturnsNoteModel = new ArrayList<InventoryGoodsReturnsNoteModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "viewAllGoodsreturn").setParameter("actionValue", values)
					.getResultList();
			if(!x.isEmpty()) {
			for (Object[] m : x) {

				InventoryGoodsReturnsNoteModel goodsreturn = new InventoryGoodsReturnsNoteModel(m[0], m[1], m[2], null,
						m[3], null, null, null, null, null, null, null, null, null, null, null, null, null,null,null,null,null,null,null,null,null,null,null,null,null, null, null);
				inventoryGoodsReturnsNoteModel.add(goodsreturn);
			}

			if (x.get(0).length > 4) {
				BigInteger t = (BigInteger) x.get(0)[4];

				total = Integer.parseInt((t.toString()));
			}

		}}catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<InventoryGoodsReturnsNoteModel>> resp = new JsonResponse<List<InventoryGoodsReturnsNoteModel>>();
		resp.setBody(inventoryGoodsReturnsNoteModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<InventoryGoodsReturnsNoteModel>>> response = new ResponseEntity<JsonResponse<List<InventoryGoodsReturnsNoteModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllGoodsreturn ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventoryGoodsReturnsNoteModel>>> getAllGoodsreturnpdf(
			DataTableRequest request) {
		logger.info("Method : getAllGoodsreturnpdf starts");
		List<InventoryGoodsReturnsNoteModel> inventoryGoodsReturnNoteModel = new ArrayList<InventoryGoodsReturnsNoteModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
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

			List<Object[]> y = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "viewAllGoodspdf").setParameter("actionValue", values).getResultList();
			for (Object[] m : y) {
				Object fromDate = null;
				fromDate = DateFormatter.returnStringDate(m[5]);

				InventoryGoodsReturnsNoteModel goodsreturn = new InventoryGoodsReturnsNoteModel(m[0], m[1], m[2], null,
						m[3], null, null, null, null, null, null, m[4], fromDate, null, null, null, null, null,null,null,null,null,null,null,null,null,null,null,null,null, null, null);
				inventoryGoodsReturnNoteModel.add(goodsreturn);
			}

			if (y.get(0).length > 6) {
				BigInteger t = (BigInteger) y.get(0)[6];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<InventoryGoodsReturnsNoteModel>> resp = new JsonResponse<List<InventoryGoodsReturnsNoteModel>>();
		resp.setBody(inventoryGoodsReturnNoteModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<InventoryGoodsReturnsNoteModel>>> response = new ResponseEntity<JsonResponse<List<InventoryGoodsReturnsNoteModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllGoodsreturnpdf ends");
		return response;
	}

	/**
	 * DAO Function to delete Goods Return note inventory
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteGoodsreturn(String id, String createdBy) {
		logger.info("Method : deleteGoodsreturn starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_goodsReturnNote='" + id + "',@p_createdBy='" + createdBy + "';";
			entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "deleteGoodsreturn").setParameter("actionValue", value).execute();

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
		logger.info("Method : deleteGoodsreturn ends");
		return response;
	}

	/**
	 * DAO Function to edit Goods return note
	 *
	 */

	@SuppressWarnings("unchecked")
	public List<InventoryGoodsReturnsNoteModel> editGoodsReturnById(String id) {

		logger.info("Method : editGoodsReturnById starts");
		List<InventoryGoodsReturnsNoteModel> form = new ArrayList<InventoryGoodsReturnsNoteModel>();
		try {
			String value = "SET @p_goodsReturnNote='" + id + "';";
			
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "editGoodsreturn").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				InventoryGoodsReturnsNoteModel inventoryGoodsReturnNoteModel = new InventoryGoodsReturnsNoteModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10],null,null,null,
						m[11],null,null,null,null,null,null,m[12],m[13],m[14],m[15],m[16],m[17],m[18],m[19],m[20],m[21],m[22]);
				form.add(inventoryGoodsReturnNoteModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editGoodsReturnById ends");
		return form;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> editGetStoreListByInv(String id) {
		logger.info("Method : editGetStoreListByInv starts");
		
		List<DropDownModel> form = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_grnInvoice='" + id + "';";
			
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "getStoreByInvoice").setParameter("actionValue", value).getResultList();
			
			for (Object[] m : x) {
				DropDownModel inventoryGoodsReturnNoteModel = new DropDownModel(m[0], m[1]);
				form.add(inventoryGoodsReturnNoteModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : editGetStoreListByInv ends");
		return form;
	}

	/**
	 * DAO Function to get ItemSubCategoryList
	 *
	 */

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getGItemSubCategoryList(String id) {
		logger.info("Method : getGItemSubCategoryList starts");
		List<DropDownModel> itemSubCategoryList = new ArrayList<DropDownModel>();
		String value = "SET @p_itemCategory='" + id + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "getItemSubCategory").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemSubCategoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getGItemSubCategoryList ends");
		return itemSubCategoryList;
	}

	/**
	 * DAO Function to view particular itemName in dropDown for Goodsreturn note
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getRItemNameList(String id) {
		logger.info("Method : getItemName starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		String value = "SET @p_itemSubCategory='" + id + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "getItemName").setParameter("actionValue", value).getResultList();
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
	 * DAO Function to view particular invoice Number in dropDown for Goodsreturn
	 * note
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getInvoiceNumber() {
		logger.info("Method : getinvoiceNumber starts");
		List<DropDownModel> invoice = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "getIdInvoice").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				invoice.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getinvoiceNumber ends");

		return invoice;
	}

	/**
	 * DAO Function to view Goods return in model
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventoryGoodsReturnsNoteModel>>> getModalGoodsreturn(String id) {
		logger.info("Method : getModalGoodsreturn starts");
		List<InventoryGoodsReturnsNoteModel> form = new ArrayList<InventoryGoodsReturnsNoteModel>();
		try {
			String value = "SET @p_goodsReturnNote='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "viewOneGoods").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				InventoryGoodsReturnsNoteModel restItemModel = new InventoryGoodsReturnsNoteModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10],null,null,null,
						m[11],null,null,null,null,null,null,m[12],m[13],m[14],m[15],m[16],m[17],m[18],m[19],m[20],m[21],m[22]);
				form.add(restItemModel);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<InventoryGoodsReturnsNoteModel>> resp = new JsonResponse<List<InventoryGoodsReturnsNoteModel>>();
		resp.setBody(form);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<InventoryGoodsReturnsNoteModel>>> response = new ResponseEntity<JsonResponse<List<InventoryGoodsReturnsNoteModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getModalGoodsreturn ends");
		
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventoryGoodsReturnsNoteModel>>> getGoodsreturnByPdf(String id) {
		logger.info("Method : getGoodsreturnByPdf starts");
		List<InventoryGoodsReturnsNoteModel> form = new ArrayList<InventoryGoodsReturnsNoteModel>();
		try {
			String value = "SET @p_goodsReturnNote='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "viewOnesGoods").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object fromDate = null;
				fromDate = DateFormatter.returnStringDate(m[9]);

				InventoryGoodsReturnsNoteModel restItemModel = new InventoryGoodsReturnsNoteModel(m[0], m[1], m[2],
						null, m[3], null, null, m[4], m[5], m[6], m[7], m[8], fromDate, m[10], m[11], m[12], m[13],
						null,null,null,null,null,null,null,null,null,null,null,null,null, null, null);
				form.add(restItemModel);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<InventoryGoodsReturnsNoteModel>> resp = new JsonResponse<List<InventoryGoodsReturnsNoteModel>>();
		resp.setBody(form);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<InventoryGoodsReturnsNoteModel>>> response = new ResponseEntity<JsonResponse<List<InventoryGoodsReturnsNoteModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getGoodsreturnByPdf ends");
		return response;
	}

	/*
	 *
	 * DAO Function to view all list
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<GRNReturnListModel>>> getAllList(String id) {
		logger.info("Method : getAllList starts");
		List<GRNReturnListModel> form = new ArrayList<GRNReturnListModel>();
		try {
			String value = "SET @p_GRNInvoice='" + id + "';";
			System.out.println("GRN Data===="+id);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "viewAllList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				GRNReturnListModel restItemModel = new GRNReturnListModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10]);
				form.add(restItemModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<GRNReturnListModel>> resp = new JsonResponse<List<GRNReturnListModel>>();
		resp.setBody(form);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<GRNReturnListModel>>> response = new ResponseEntity<JsonResponse<List<GRNReturnListModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getAllList ends");
	
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addGoodsreturnsnote(
			List<InventoryGoodsReturnsNoteModel> inventoryGoodsReturnsNoteModel) {
		logger.info("Method : addGoodsreturnsnote starts");
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (InventoryGoodsReturnsNoteModel l : inventoryGoodsReturnsNoteModel) {

			if (l.getgRNInvoiceId() == null || l.getgRNInvoiceId() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please select invoice id.");
				break;

			} else if (l.getgRtNDescription() == null || l.getgRtNDescription() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Description.");
				break;

			} else if (l.getgRtNActive() == null) {
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
			} else if (l.getgRtNQty() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please Enter Quantity.");
				break;
			}
			 else if (l.getPrice() == null) {
					validation = false;
					resp.setCode("Field Validation Error");
					resp.setMessage("please Enter Price.");
					break;
				}

		}

		if (validation) {
			try {
				String value = GenerateInventoryGoodsReturnParameter
						.getGoodsreturnDtlParam(inventoryGoodsReturnsNoteModel);
				System.out.println(value);
				if (inventoryGoodsReturnsNoteModel.get(0).getGoodsReturnNote() != null
						&& inventoryGoodsReturnsNoteModel.get(0).getGoodsReturnNote() != "") {
					entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
							.setParameter("actionType", "modifygoodsreturns").setParameter("actionValue", value)
							.execute();
				} else {
					System.out.println("Add");
					entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
							.setParameter("actionType", "addNewGoodsReturns").setParameter("actionValue", value)
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
		logger.info("Method : addGoodsreturnsnote ends");
	
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemSubCat(String id) {
		logger.info("Method : getItemSubCat starts");
		List<DropDownModel> itemSubCategryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_subcat='" + id + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "getItemSubCategry").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemSubCategryList.add(dropDownModel);
			}

			resp.setBody(itemSubCategryList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemSubCat ends");
		
		return response;
	}

	// for item sub category in edit form
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSubcategoriess(String id) {
		logger.info("Method : getSubcategoriess starts");

		List<DropDownModel> itmsubList = new ArrayList<DropDownModel>();

		String value = "SET @p_subcates='" + id + "';";

	
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "getISCat").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itmsubList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getItemNames ends");
		return itmsubList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getItemNames(String id) {
		logger.info("Method : getItemNames starts");

		List<DropDownModel> itmsList = new ArrayList<DropDownModel>();

		String value = "SET @p_itms='" + id + "';";

		
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "getListItems").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itmsList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getItemNames ends");
		return itmsList;
	}

	@SuppressWarnings("unchecked")
	public List<InventoryGoodsReturnsNoteModel> listGoodsDetails(String id) {
	
		List<InventoryGoodsReturnsNoteModel> itemNameList = new ArrayList<InventoryGoodsReturnsNoteModel>();
		String value = "SET @p_gRNInvoiceId='" + id + "';";
		
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "getaAllList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				InventoryGoodsReturnsNoteModel dropDownModel = new InventoryGoodsReturnsNoteModel(null, null, m[0],
						null, null, m[1], m[2], m[3], m[4], m[5], null, null, null, null, null, null, null, null,null,null,null,null,null,null,null,null,null,null,null,null, null, null);
				itemNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getItemName ends");
		return itemNameList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemCategry(String id) {
		logger.info("Method : getItemCategry starts");
		List<DropDownModel> itemCategryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_itemCategory='" + id + "';";
		
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "getItemCategry").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemCategryList.add(dropDownModel);
			}

			resp.setBody(itemCategryList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemCategry ends");
	
		return response;
	}

	/**
	 * DAO Function to view particular invoice number in dropdown in dropDown
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getInvoiceId(String id,String gRNInvoiceId) {
		logger.info("Method : getInvoiceId starts");
		List<DropDownModel> invoiceIdList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_purchseId='" + id + "',@p_gRNInvoiceId='" + gRNInvoiceId + "';";
		
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "getInvoiceId").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				invoiceIdList.add(dropDownModel);
			}

			resp.setBody(invoiceIdList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getInvoiceId ends");
		return response;

	}
	
	@SuppressWarnings("unchecked")
	public List<GRNReturnListModel> getGRNDetailsForReturn(String id,String grn) {
		logger.info("Method : getGRNDetailsForReturn starts");
		
		List<GRNReturnListModel> form = new ArrayList<GRNReturnListModel>();
		
		try {
			String value = "SET @p_GRNInvoice='" + grn + "';";
			System.out.println("GRN Data===="+grn);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "viewAllList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				GRNReturnListModel restItemModel = new GRNReturnListModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10]);
				form.add(restItemModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getGRNDetailsForReturn ends");
		return form;
		
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getInv(String id) {
		logger.info("Method : getInv starts");

		List<DropDownModel> tableNameList = new ArrayList<DropDownModel>();
		String value = "SET @p_inv='" + id + "';";
		
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "getINV").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				tableNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getInv ends");

		return tableNameList;
	}

	// for price
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> calculateLItemPrice(Map<String, String> invService) {
		logger.info("Method : calculateLItemPrice starts");
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		if (invService.get("gRNInvoiceId") == "" || invService.get("gRNInvoiceId") == null) {
			resp.setMessage("Please Select invoice id.");
			validation = false;
		}
		if (invService.get("itemId") == "" || invService.get("itemId") == null) {
			resp.setMessage("Please Select item  Type.");
			validation = false;
		}

		if (validation) {
			try {
				String value = GenerateInventoryGoodsReturnParameter.getCalculateInventoryItemPriceParam(invService);
			System.out.println(value);
					List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
						.setParameter("actionType", "getItemPrice").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModelConstructor = new DropDownModel(m[0], m[1].toString());
					dropDownModel.add(dropDownModelConstructor);
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
		resp.setBody(dropDownModel);

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : calculateLItemPrice ends");
		System.out.println(response);
		return response;
	}

	/**
	 * DAO Function to view particular quantity for Goodsreturn
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAllQuantity(String id, String gRNInvoiceId) {
		logger.info("Method : getAllQuantity starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_itemName='" + id + "',@p_gRNInvoiceId='" + gRNInvoiceId + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "getQuantityList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				itemNameList.add(dropDownModel);
			}

			resp.setBody(itemNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllQuantity ends");
	
		return response;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventoryGoodsReturnsNoteModel>>> getAllGoodsreturnReport(
			DataTableRequest request) {
		logger.info("Method : getAllGoodsreturnReport starts");
		List<InventoryGoodsReturnsNoteModel> inventoryGoodsReturnNoteModel = new ArrayList<InventoryGoodsReturnsNoteModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
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

			List<Object[]> y = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "viewAllGoodspdf").setParameter("actionValue", values).getResultList();
			for (Object[] m : y) {
				Object fromDate = null;
				fromDate = DateFormatter.returnStringDate(m[5]);

				InventoryGoodsReturnsNoteModel goodsreturn = new InventoryGoodsReturnsNoteModel(m[0], m[1], m[2], null,
						m[3], null, null, null, null, null, null, m[4], fromDate, null, null, null, null, null,null,null,null,null,null,null,null,null,null,null,null,null, null, null);
				inventoryGoodsReturnNoteModel.add(goodsreturn);
			}

			if (y.get(0).length > 6) {
				BigInteger t = (BigInteger) y.get(0)[6];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<InventoryGoodsReturnsNoteModel>> resp = new JsonResponse<List<InventoryGoodsReturnsNoteModel>>();
		resp.setBody(inventoryGoodsReturnNoteModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<InventoryGoodsReturnsNoteModel>>> response = new ResponseEntity<JsonResponse<List<InventoryGoodsReturnsNoteModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllGoodsreturnReport ends");
		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPurchseOrderByAutosearch(String id) {
		logger.info("Method : getPurchseOrderByAutosearch Dao starts");

		List<DropDownModel> PurchaseList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_guest='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "getPOrders").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				PurchaseList.add(dropDownModel);
			}

			resp.setBody(PurchaseList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getPurchseOrderByAutosearch Dao ends");
	
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPurchaseOrderByAutosuggest(String id) {
		logger.info("Method : getPurchaseOrderByAutosuggest Dao starts");

		List<DropDownModel> PurchaseList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_guest='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "getPOrders").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				PurchaseList.add(dropDownModel);
			}

			resp.setBody(PurchaseList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getPurchaseOrderByAutosuggest Dao ends");
		
		return response;
	}

	/*
	 * method to auto fill purchase order no
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPurchaseOrderByPdfLists(String id) {
		logger.info("Method : getPurchaseOrderByPdfLists Dao starts");

		List<DropDownModel> PurchaseList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_guest='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "getPOrders").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				PurchaseList.add(dropDownModel);
			}

			resp.setBody(PurchaseList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getPurchaseOrderByPdfLists Dao ends");
		
		return response;
	}
	/*
	 * method to auto fill purchase for search
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPurchaseOrderSearch(String id) {
		logger.info("Method : getPurchaseOrderSearch Dao starts");

		List<DropDownModel> PurchaseList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_guest='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "getPOrders").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				PurchaseList.add(dropDownModel);
			}

			resp.setBody(PurchaseList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getPurchaseOrderSearch Dao ends");
		
		return response;
	}
	/*
	 * Get invoice number for auto complete	 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getInvoiceNumberSuggestLists(String id) {
		logger.info("Method : getInvoiceNumberSuggestLists Dao starts");

		List<DropDownModel> PurchaseList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_invc='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "getSuggestInvcs").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				PurchaseList.add(dropDownModel);
			}

			resp.setBody(PurchaseList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getInvoiceNumberSuggestLists Dao ends");
		
		
		return response;
	}
	/*
	 * 
	 * Get invoice   number for auto search
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getInvoiceNumberSearch(String id) {
		logger.info("Method : getInvoiceNumberSearch Dao starts");

		List<DropDownModel> PurchaseList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_invc='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "getSuggestInvcs").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				PurchaseList.add(dropDownModel);
			}

			resp.setBody(PurchaseList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getInvoiceNumberSearch Dao ends");
		
		
		return response;
	}
	
	/**
	 * DAO Function to view particular discounts
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDiscounts(String id,String gRNInvoiceId) {
		logger.info("Method : getDiscounts starts");
		List<DropDownModel> discountList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_itemId='" + id + "',@p_gRNInvoiceId='" + gRNInvoiceId + "';";
		
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "getDiscounts").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				discountList.add(dropDownModel);
			}

			resp.setBody(discountList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getDiscounts ends");
		
		return response;

	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getUnitGst(String id) {
		logger.info("Method : getUnitGst starts");
		List<DropDownModel> itemCategryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_itemCategory='" + id + "';";
		
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "getUnitGst").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				itemCategryList.add(dropDownModel);
			}

			resp.setBody(itemCategryList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getUnitGst ends");
	
		return response;
	}

	/**
	 * DAO - Get Hotel Logo
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getHotelLogoReturn(String logoType) {
		logger.info("Method : getHotelLogo starts");
		
		List<DropDownModel> logoList = new ArrayList<DropDownModel>();
		
		try {
			String value = "SET @p_logoType='" + logoType + "';";
			
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("logoImageRoutines")
					.setParameter("actionType", "getHotelLogo")
					.setParameter("actionValue", value)
					.getResultList();
			
			for(Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0],m[1]);
				logoList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getHotelLogo ends");
		return logoList;
	}
	
	/**
	 * DAO Function to view particular itemName in dropDown for ItemRequisition
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventoryGoodsReturnsNoteModel>>> getItemListByAutoSearchWithGRNINV(
			String id, String catId) {
		logger.info("Method : getItemListByAutoSearchWithGRNINV starts");
		List<InventoryGoodsReturnsNoteModel> itemNameList = new ArrayList<InventoryGoodsReturnsNoteModel>();
		JsonResponse<List<InventoryGoodsReturnsNoteModel>> resp = new JsonResponse<List<InventoryGoodsReturnsNoteModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_invId='" + catId + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryGoodsReturnRoutines")
					.setParameter("actionType", "getItemList1").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				InventoryGoodsReturnsNoteModel goodsReturnsNoteModel = new InventoryGoodsReturnsNoteModel(null, null,
						null,null,null, m[3], m[2], m[0], null, m[1], null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,null, null, null, null, null, null);
				itemNameList.add(goodsReturnsNoteModel);
			} 
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<InventoryGoodsReturnsNoteModel>>> response = new ResponseEntity<JsonResponse<List<InventoryGoodsReturnsNoteModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemListByAutoSearchWithGRNINV ends");
		return response;
	}

	
}
