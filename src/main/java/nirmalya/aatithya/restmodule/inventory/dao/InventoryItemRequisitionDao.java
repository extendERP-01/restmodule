/* Defines inventory ItemRequisitionDAO
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
import nirmalya.aatithya.restmodule.common.utils.GenerateInventoryItemParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateInventoryItemRequisitionParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryItemModel;
import nirmalya.aatithya.restmodule.inventory.model.RestItemRequisitonModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class InventoryItemRequisitionDao {
	Logger logger = LoggerFactory.getLogger(InventoryItemRequisitionDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager entityManager;

	/**
	 * DAO Function to view particular itemName in dropDown for ItemRequisition
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>> getItemName(String id) {
		logger.info("Method : getItemName starts");
		List<RestItemRequisitonModel> itemNameList = new ArrayList<RestItemRequisitonModel>();
		JsonResponse<List<RestItemRequisitonModel>> resp = new JsonResponse<List<RestItemRequisitonModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
					.setParameter("actionType", "getItemList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				RestItemRequisitonModel dropDownModel = new RestItemRequisitonModel(null, null, null, null, null, null,
						null, null, m[2], m[3], m[1], m[0], null, null, null, null, null, null, null, null, null, null,
						null, null, null,null);
				itemNameList.add(dropDownModel);
			}

			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>> response = new ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemName ends");
		return response;
	}

	/**
	 * DAO Function to view particular getRequisitionType in dropDown for
	 * ItemRequisition
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getRequisitionType() {
		logger.info("Method : getRequisitionType starts");
		List<DropDownModel> getRequisitionTypeList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
					.setParameter("actionType", "getRequisitionTypeList").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getRequisitionTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getRequisitionType ends");
		return getRequisitionTypeList;
	}

	/**
	 * DAO Function to Add ItemRequisition in inventory
	 *
	 */
	@SuppressWarnings("unused")
	public ResponseEntity<JsonResponse<Object>> addItemRequisition(
			List<RestItemRequisitonModel> restItemRequisitonModel) {
		logger.info("Method : addItemRequisition starts");
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (RestItemRequisitonModel l : restItemRequisitonModel) {
			if (l.getCostCenter() == null || l.getCostCenter() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Cost Center.");
				break;
			} else if (l.gettStore() == null || l.gettStore() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Store Name.");
				break;
			} else if (l.getiRDescription() == null || l.getiRDescription() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Description.");
				break;
			} else if (l.getiRExpectedDate() == null || l.getiRExpectedDate() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Date.");
				break;
			} else if (l.getiRType() == null || l.getiRType() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Requisition Type.");
				break;
			} else if (l.getiRStatus() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Status.");
				break;
			} else if (l.getDlItemCategory() == null || l.getDlItemCategory() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Item Category.");
				break;
			} else if (l.getDlItemSubCategory() == null || l.getDlItemSubCategory() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Sub Category.");
				break;
			} else if (l.getDlItem() == null || l.getDlItem() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please select item name.");
				break;
			} else if (l.getDlQty() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please Enter Quantity.");
				break;
			}
		}

		if (validation) {

			try {
				String value = GenerateInventoryItemRequisitionParameter
						.getItemRequisitionDtlParam(restItemRequisitonModel);

				if (restItemRequisitonModel.get(0).getItemRequisition() != null
						&& restItemRequisitonModel.get(0).getItemRequisition() != "") {
					entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
							.setParameter("actionType", "modifyItemRequisition").setParameter("actionValue", value)
							.execute();
				} else {
					entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
							.setParameter("actionType", "addNewRequisitionItem").setParameter("actionValue", value)
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
		logger.info("Method : add item Requisition ends");
		return response;
	}

	/*
	 * 
	 * Method for Auto Search of Requisition Number
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRequisitionNumberAutocompleteList(String id) {
		logger.info("Method : getRequisitionNumberAutocompleteList Dao starts");

		List<DropDownModel> requisition = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_itemRequisition='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
					.setParameter("actionType", "getRequisitionNumber").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				requisition.add(dropDownModel);
			}

			resp.setBody(requisition);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getRequisitionNumberAutocompleteList Dao ends");
		return response;
	}

	/*
	 * 
	 * Method for Auto Search of Requisition Number
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> generateRequisitionNumber(String id) {
		logger.info("Method : generateRequisitionNumber Dao starts");

		List<DropDownModel> requisition = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_itemRequisition='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
					.setParameter("actionType", "getRequisitionNumberPdf").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				requisition.add(dropDownModel);
			}

			resp.setBody(requisition);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : generateRequisitionNumber Dao ends");
		return response;
	}

	/**
	 * DAO Function to view particular costCenter in dropDown for
	 * ItemRequisition
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCostCenter() {
		logger.info("Method : getCostCenter starts");
		List<DropDownModel> itemCategoryList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
					.setParameter("actionType", "getCostCenterList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemCategoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getCostCenter ends");
		return itemCategoryList;
	}

	/**
	 * DAO Function to get All ItemRequisition in inventory to be approve
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>> getAllRequisitionsApprove(
			DataTableRequest request) {
		logger.info("Method : getAllRequisitionsApprove starts");

		if (request.getParam4() != "" && request.getParam4() != null) {
			String param4 = request.getParam4();
			String data = DateFormatter.getStringDate(param4);
			request.setParam4(data);
		}

		if (request.getParam5() != "" && request.getParam5() != null) {
			String param5 = request.getParam5();
			String data2 = DateFormatter.getStringDate(param5);
			request.setParam5(data2);
		}
		
		List<RestItemRequisitonModel> restItemRequisitonModel = new ArrayList<RestItemRequisitonModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		
		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
					.setParameter("actionType", "viewAllRequisitionsToApprove").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;

					if(m[2]!=null)
						date = DateFormatter.returnStringDate(m[2]);
					if(m[6]!=null)
						m[6] = Integer.valueOf(((BigInteger) m[6]).toString());
					if(m[8]!=null)
						m[8] = Integer.valueOf(((BigInteger) m[8]).toString());

					RestItemRequisitonModel item = new RestItemRequisitonModel(m[0], m[1], null, null, date, m[3], m[4],
							null, null, null, null, null, null, null, null, null, null, null, null, null, m[5], m[6],
							m[7], m[8], m[9],null);
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

		JsonResponse<List<RestItemRequisitonModel>> resp = new JsonResponse<List<RestItemRequisitonModel>>();
		resp.setBody(restItemRequisitonModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>> response = new ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllRequisitionsApprove ends");
		return response;
	}

	/**
	 * DAO Function to save Requisition Approval Action
	 *
	 */
	
	public ResponseEntity<JsonResponse<Object>> saveRequisitionApprovalAction(String id, String createdBy) {
		logger.info("Method : saveRequisitionApprovalAction starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_itemRequisition='" + id + "',@p_createdBy='" + createdBy + "';";
			entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
					.setParameter("actionType", "forwardRequisition").setParameter("actionValue", value).execute();

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
		logger.info("Method : forwardRequisition ends");
		return response;
	}

	/**
	 * DAO Function to save Requisition Reject Action
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> saveRequisitionRejectAction(RestItemRequisitonModel reqobject) {
		logger.info("Method : saveRequisitionRejectActionDao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_itemRequisition='" + reqobject.getItemRequisition() + "',@p_rejectComment='"
					+ reqobject.getiRDescription() + "',@p_createdBy='" + reqobject.getCostCenter() + "';";

			String actionType = "";
			if (reqobject.getiRType().equals("1"))
				actionType = "rejectRequisition";
			else if (reqobject.getiRType().equals("2"))
				actionType = "returnRequisition";
			else
				actionType = "resubmitRequisition";

			entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
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
		logger.info("Method : saveRequisitionRejectActionDao ends");
		return response;
	}

	/**
	 * DAO Function to get All ItemRequisition in inventory
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>> getAllRequisitions(DataTableRequest request) {
		logger.info("Method : getAllRequisitions starts");

		if (request.getParam4() != "" && request.getParam4() != null) {
			String param4 = request.getParam4();
			String data = DateFormatter.getStringDate(param4);
			request.setParam4(data);
		}

		if (request.getParam5() != "" && request.getParam5() != null) {
			String param5 = request.getParam5();
			String data2 = DateFormatter.getStringDate(param5);
			request.setParam5(data2);
		}
		List<RestItemRequisitonModel> restItemRequisitonModel = new ArrayList<RestItemRequisitonModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
					.setParameter("actionType", "viewAllRequisitions").setParameter("actionValue", values)
					.getResultList();
			
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					date = DateFormatter.returnStringDate(m[2]);
					RestItemRequisitonModel item = new RestItemRequisitonModel(m[0], m[1], null, null, date, m[3], m[4],
							null, null, null, null, null, null, null, null, null, null, null, null, null, m[5], null,
							null, null, m[6],m[7]);
					restItemRequisitonModel.add(item);
				}

				if (x.get(0).length > 8) {
					BigInteger t = (BigInteger) x.get(0)[8];

					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestItemRequisitonModel>> resp = new JsonResponse<List<RestItemRequisitonModel>>();
		resp.setBody(restItemRequisitonModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>> response = new ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllRequisitions ends");
		return response;
	}

	/**
	 * DAO Function to view ItemRequisition in model
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>> getItemRequisitionById(String id) {

		logger.info("Method : getItemRequisitionById starts");
		List<RestItemRequisitonModel> mt = new ArrayList<RestItemRequisitonModel>();
		JsonResponse<List<RestItemRequisitonModel>> resp = new JsonResponse<List<RestItemRequisitonModel>>();
		try {
			String value = "SET @p_itemRequisition='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
					.setParameter("actionType", "viewOneRequisition").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object date = null;
				date = DateFormatter.returnStringDate(m[3]);
				RestItemRequisitonModel itemRequisition = new RestItemRequisitonModel(m[0], m[1], null, m[2], date,
						m[4], m[5], m[6], m[7], m[8], m[9], null, m[10], null, null, null, null, null, null, null,
						m[11], null, null, null, m[12],null);

				mt.add(itemRequisition);
			}
			resp.setBody(mt);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>> response = new ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getItemRequisitionById ends");

		return response;
	}

	/**
	 * DAO Function to delete ItemRequisition of inventory
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteRequisition(String id, String createdBy) {
		logger.info("Method : deleteRequisition starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_itemRequisition='" + id + "',@p_createdBy='" + createdBy + "';";
			entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
					.setParameter("actionType", "deleteRequisition").setParameter("actionValue", value).execute();

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
		logger.info("Method : deleteRequisition ends");
		return response;
	}

	/**
	 * DAO Function to edit ItemRequisition
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<RestItemRequisitonModel> editItemRequisitionById(String id) {

		logger.info("Method : getItemRequisitionById starts");

		List<RestItemRequisitonModel> restItemRequisitonModel = new ArrayList<RestItemRequisitonModel>();
		try {

			String value = "SET @p_itemRequisition='" + id + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
					.setParameter("actionType", "editItemRequisition").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object date = null;
				date = DateFormatter.returnStringDate(m[3]);
				RestItemRequisitonModel restItem = new RestItemRequisitonModel(m[0], m[1], null, m[2], date, m[4], m[5],
						null, m[6], m[7], m[8], m[9], m[10], null, null, null, null, null, null, null, null, null, null,
						null, null,m[11]);

				restItemRequisitonModel.add(restItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getItemRequisitionById ends");
		return restItemRequisitonModel;
	}

	/*
	 * 
	 * Dao Function to get Item Name
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEditItemName(String id) {
		logger.info("Method : getEditItemName starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		String value = "SET @p_itemSubCategory='" + id + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
					.setParameter("actionType", "getItemNameList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getEditItemName ends");
		return itemNameList;
	}

	/**
	 * DAO Function to view itemName in dropDown for search param
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getRrequisitionItemName() {
		logger.info("Method : getRrequisitionItemName starts");
		List<DropDownModel> itemCategoryList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
					.setParameter("actionType", "ItemNameList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemCategoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getRrequisitionItemName ends");
		return itemCategoryList;
	}

	/**
	 * DAO Function to get All ItemRequisition in inventory for PDF
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>> getAllRequisitionsPdf(DataTableRequest request) {
		logger.info("Method : getAllRequisitionsPdf starts");

		if (request.getParam4() != "") {
			String param4 = request.getParam4();
			String data = DateFormatter.getStringDate(param4);
			request.setParam4(data);
		}

		if (request.getParam5() != "") {
			String param5 = request.getParam5();
			String data2 = DateFormatter.getStringDate(param5);
			request.setParam5(data2);
		}
		List<RestItemRequisitonModel> restItemRequisitonModel = new ArrayList<RestItemRequisitonModel>();
		String values = GenerateParameter.getSearchParam(request);

		Integer total = 0;

		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
					.setParameter("actionType", "viewAllRequisitionsPdf").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					date = DateFormatter.returnStringDate(m[2]);
					Object date2 = null;
					date2 = DateFormatter.returnStringDate(m[5]);
					RestItemRequisitonModel item = new RestItemRequisitonModel(m[0], m[1], null, null, date, m[3], m[4],
							null, null, null, null, null, null, null, date2, null, null, null, null, null, null, null,
							null, null, null,null);
					restItemRequisitonModel.add(item);
				}
			}
			if (x.get(0).length > 5) {

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestItemRequisitonModel>> resp = new JsonResponse<List<RestItemRequisitonModel>>();
		resp.setBody(restItemRequisitonModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>> response = new ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllRequisitionsPdf ends");
		return response;
	}

	/**
	 * DAO Function to get All ItemRequisition in inventory for generate Report
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>> generateAllRequisitionsPdf(
			DataTableRequest request) {
		logger.info("Method : generateAllRequisitionsPdf starts");
		if (request.getParam4() != "") {
			String param4 = request.getParam4();
			String data = DateFormatter.getStringDate(param4);
			request.setParam4(data);
		}

		if (request.getParam5() != "") {
			String param5 = request.getParam5();
			String data2 = DateFormatter.getStringDate(param5);
			request.setParam5(data2);
		}
		List<RestItemRequisitonModel> restItemRequisitonModel = new ArrayList<RestItemRequisitonModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
					.setParameter("actionType", "viewAllRequisitionsReport").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					date = DateFormatter.returnStringDate(m[2]);
					Object date2 = null;
					date2 = DateFormatter.returnStringDate(m[5]);
					RestItemRequisitonModel item = new RestItemRequisitonModel(m[0], m[1], null, null, date, m[3], m[4],
							null, null, null, null, null, null, null, date2, null, null, null, null, null, null, null,
							null, null, null,null);
					restItemRequisitonModel.add(item);
				}
			}
			if (x.get(0).length > 5) {

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestItemRequisitonModel>> resp = new JsonResponse<List<RestItemRequisitonModel>>();
		resp.setBody(restItemRequisitonModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>> response = new ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : generateAllRequisitionsPdf ends");
		return response;
	}
	/*
	 * 
	 * 
	 * Dao function to get sub category
	 * 
	 */

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getItemSubCat(String id) {
		logger.info("Method : getItemSubCategory starts");

		List<DropDownModel> subcatList = new ArrayList<DropDownModel>();

		String value = "SET @p_itemCategory='" + id + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
					.setParameter("actionType", "getItemSubCategoryList").setParameter("actionValue", value)
					.getResultList();

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
	 * DAO Function to View all Item Requisition in excel
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>> getAllItemRequisitionDownload(
			DataTableRequest request) {
		logger.info("Method : getAllItemRequisitionDownload starts");

		List<RestItemRequisitonModel> restItemRequisitonModel = new ArrayList<RestItemRequisitonModel>();
		JsonResponse<List<RestItemRequisitonModel>> resp = new JsonResponse<List<RestItemRequisitonModel>>();
		String values = GenerateParameter.getSearchParam(request);

		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
					.setParameter("actionType", "requisitionExcel").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object date = null;
				if (m[2] != null) {
					date = DateFormatter.returnStringDate(m[2]);

				}

				RestItemRequisitonModel itemRequisition = new RestItemRequisitonModel(m[0], m[1], null, null, date,
						m[3], m[4], m[5], m[6], m[7], m[8], null, m[9], null, null, null, null, null, null, null, null,
						null, null, null, null,null);

				restItemRequisitonModel.add(itemRequisition);

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

		resp.setBody(restItemRequisitonModel);

		ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>> response = new ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllItemRequisitionDownload ends");
		return response;
	}

	/**
	 * DAO Function to view ItemRequisition in Pdf
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>> getItemRequisitionPdf(String id) {

		logger.info("Method : getItemRequisitionPdf starts");

		List<RestItemRequisitonModel> mt = new ArrayList<RestItemRequisitonModel>();
		JsonResponse<List<RestItemRequisitonModel>> resp = new JsonResponse<List<RestItemRequisitonModel>>();

		try {

			String value = "SET @p_itemRequisition='" + id + "';";
			System.out.println("value: "+value);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
					.setParameter("actionType", "viewOneRequisitionPdf").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object date = null;
				date = DateFormatter.returnStringDate(m[3]);
				Object date2 = null;
				date2 = DateFormatter.returnStringDate(m[11]);
				RestItemRequisitonModel itemRequisition = new RestItemRequisitonModel(m[0], m[1], null, m[2], date,
						m[4], m[5], m[6], m[7], m[8], m[9], null, m[10], null, date2, null, m[12], m[13], m[14], m[15],
						null, null, null, null, null,m[17]);

				mt.add(itemRequisition);
			}
			resp.setBody(mt);

		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>> response = new ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getItemRequisitionPdf ends");
		
		return response;
	}

	/*
	 * 
	 * DAO Function to view particular itemCategory in dropDown for Item
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getItemListType() {
		logger.info("Method : getItemType starts");
		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
					.setParameter("actionType", "getItemType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getItemType ends");
		return itemList;
	}

	/*
	 * DAO Function to view particular itemCategory in dropDown for Item
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> restGetItemCategory() {
		logger.info("Method : restGetItemCategory starts");
		List<DropDownModel> itemCategoryList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
					.setParameter("actionType", "restGetItemCategory").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemCategoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : restGetItemCategory ends");
		return itemCategoryList;
	}

	/*
	 * DAO Function to view particular itemSubCategory in dropDown for Item
	 * getSubAccountGroup
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> restGetSubItemCategory(String id) {
		logger.info("Method : restGetSubItemCategory starts");
		List<DropDownModel> itemSubCategoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_itemCategory='" + id + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
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
		logger.info("Method : restGetSubItemCategory ends");
		return response;
	}

	/*
	 * DAO Function to view particular Purchase Sub groups in dropDown for Item
	 * getSubAccountGroup
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")

	public ResponseEntity<JsonResponse<List<DropDownModel>>> restGetPurchaseSubGroup(String id) {
		logger.info("Method : restGetPurchaseSubGroup starts");
		List<DropDownModel> getPurchaseSubGroupList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_accountGroup='" + id + "';";

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
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
		logger.info("Method : restGetPurchaseSubGroup ends");

		return response;
	}

	/*
	 * DAO Function to view particular Sales Sub groups in dropDown for Item
	 * getSubAccountGroup
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")

	public ResponseEntity<JsonResponse<List<DropDownModel>>> restGetSalesSubGroup(String id) {
		logger.info("Method : restGetSalesSubGroup starts");
		List<DropDownModel> getsalesSubGroupList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_accountGroup='" + id + "';";

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
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
		logger.info("Method : restGetSalesSubGroup ends");

		return response;
	}

	/*
	 * DAO Function to view particular serveType in dropDown for Item
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> restGetServeType() {
		logger.info("Method : restGetServeType starts");
		List<DropDownModel> ServeTypeLIst = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
					.setParameter("actionType", "getItemServeTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				ServeTypeLIst.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : restGetServeType ends");
		return ServeTypeLIst;
	}

	/*
	 * DAO Function to view particular serviceType in dropDown for Item
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> restGetServiceType() {
		logger.info("Method : restGetServiceType starts");
		List<DropDownModel> ServiceTypeList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
					.setParameter("actionType", "getServiceTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				ServiceTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : restGetServiceType ends");
		return ServiceTypeList;
	}

	/*
	 * DAO Function to Add Item in inventory
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addNewItem(RestInventoryItemModel restItemModel) {
		logger.info("Method : addNewItem starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (restItemModel.getItemCategory() == null || restItemModel.getItemCategory() == "") {
			resp.setMessage("item Category required");
			validity = false;
		} else if (restItemModel.getItemSubCategory() == null || restItemModel.getItemSubCategory() == "") {
			resp.setMessage("itemSubCategory required");
			validity = false;

		} else if (restItemModel.getServeType() == null || restItemModel.getServeType() == "") {
			resp.setMessage("serveType required");
			validity = false;
		} else if (restItemModel.getItemName() == null || restItemModel.getItemName() == "") {
			resp.setMessage("itemName required");
			validity = false;
		} else if (restItemModel.getItemMinStock() == null) {
			resp.setMessage("itemMinStock required");
			validity = false;
		} else if (restItemModel.getItemMaxStock() == null) {
			resp.setMessage("itemMaxStock required");
			validity = false;
		} else if (restItemModel.getServiceType() == null || restItemModel.getServiceType() == "") {
			resp.setMessage("serviceType Required required");
			validity = false;
		} else if (restItemModel.getSacCode() == null || restItemModel.getSacCode() == "") {
			resp.setMessage("sacCode Required required");
			validity = false;
		} else if (restItemModel.getItemActive() == null) {
			resp.setMessage("status required");
			validity = false;
		}
		if (validity)
			try {
				String values = GenerateInventoryItemRequisitionParameter.addItem(restItemModel);
				System.out.println("values: "+values);
				entityManager.createNamedStoredProcedureQuery("inventoryItemRoutines")
						.setParameter("actionType", "addNewItem").setParameter("actionValue", values).execute();

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
		logger.info("Method : addNewItem ends");

		return response;
	}

		/*
		 * DAO Function to view particular serviceType in dropDown for Item
		 *
		 */
		@SuppressWarnings("unchecked")
		public List<DropDownModel> restGetSacCode() {
			logger.info("Method : restGetSacCode starts");
			List<DropDownModel> ServiceTypeList = new ArrayList<DropDownModel>();
			try {
				List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
						.setParameter("actionType", "restGetSacCode").setParameter("actionValue", "").getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					ServiceTypeList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : restGetSacCode ends");
			return ServiceTypeList;
		}

			/**
			 * DAO Function to view Store in dropDown for
			 * ItemRequisition
			 *
			 */
			@SuppressWarnings("unchecked")
			public List<DropDownModel> getStore(String id) {
				logger.info("Method : getStore starts");
				List<DropDownModel> itemCategoryList = new ArrayList<DropDownModel>();
				try {
					String value = "SET @p_userId='" + id + "';";
					List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemRequisitionRoutines")
							.setParameter("actionType", "getStore").setParameter("actionValue",value ).getResultList();

					for (Object[] m : x) {
						DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
						itemCategoryList.add(dropDownModel);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				logger.info("Method : getStore ends");
				return itemCategoryList;
			}

}
