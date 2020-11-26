/**
 * DAO Function for Issue Note
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
import nirmalya.aatithya.restmodule.common.utils.GenerateInventoryRequisitionIssueNoteParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.RequisitionDetailsModel;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryRequisitionIssueNoteModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository 
public class InventoryRequisitionIssueNoteDao {
	Logger logger = LoggerFactory.getLogger(InventoryRequisitionIssueNoteDao.class);
	@Autowired
	private EntityManager entityManager;
	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to view particular RequisitionNumber in dropDown for search
	 * param
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRequisitionNumberForSearch(String id) {
		logger.info("Method : inventoryRequisitionIssueNoteDao Dao starts");

		List<DropDownModel> guestList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_itemRequisition='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "getItemRequisitionList").setParameter("actionValue", value)
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

		logger.info("Method : inventoryRequisitionIssueNoteDao Dao ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RequisitionDetailsModel>>> getRequisitionDetails(String id) {
		logger.info("Method : inventoryRequisitionIssueNoteDao Dao starts");
		
		List<RequisitionDetailsModel> guestList = new ArrayList<RequisitionDetailsModel>();
		JsonResponse<List<RequisitionDetailsModel>> resp = new JsonResponse<List<RequisitionDetailsModel>>();
		
		try {
			String value = "SET @p_itemRequisition='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "getRequisitionDetails").setParameter("actionValue", value)
					.getResultList(); 
			
			for (Object[] m : x) {
				RequisitionDetailsModel dropDownModel = new RequisitionDetailsModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6]);
				guestList.add(dropDownModel);
			}
			
			resp.setBody(guestList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<List<RequisitionDetailsModel>>> response = new ResponseEntity<JsonResponse<List<RequisitionDetailsModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getRequisitionDetails Dao ends");
		return response;
	}

	/**
	 * DAO Function to view particular Issue Number in dropDown for search param
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> generateIssueNoForPdf(String id) {
		logger.info("Method : generateIssueNoForPdf Dao starts");

		List<DropDownModel> guestList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_issueNo='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "getIssueNo").setParameter("actionValue", value).getResultList();

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

		logger.info("Method : generateIssueNoForPdf Dao ends");
		return response;
	}

	/**
	 * DAO Function to view particular Issue Number in dropDown for search param
	 * in generate pdf report
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> generateIssueNoForScrhPdf(String id) {
		logger.info("Method : generateIssueNoForScrh Dao starts");

		List<DropDownModel> guestList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_issueNo='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "getIssueNoPdf").setParameter("actionValue", value).getResultList();

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

		logger.info("Method : generateIssueNoForScrh Dao ends");
		return response;
	}

	/**
	 * DAO Function to view particular itemSubCategory in dropDown for Issue
	 * Note Order
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getIssueItemCategory(String id) {
		logger.info("Method : getIssueItemCategory starts");
		List<DropDownModel> itemSubCategoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_itemRequisition='" + id + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "getItemCategoryList").setParameter("actionValue", value)
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
		logger.info("Method : getIssueItemCategory ends");
		return response;
	}

	/**
	 * DAO Function to view particular itemSubCategory in dropDown for Issue
	 * Note Order
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getIssueItemSubCategory(String id, String reqNo) {
		logger.info("Method : getIssueItemSubCategory starts");
		List<DropDownModel> itemSubCategoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_itemCategory='" + id + "',@p_itemRequisition='" + reqNo + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
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
		logger.info("Method : getIssueItemSubCategory ends");
		return response;
	}

	/**
	 * DAO Function to view particular itemName in dropDown for Issue Note Order
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getIssueItemName(String id, String reqNo) {
		logger.info("Method : getIssueItemName starts");
		List<DropDownModel> itemSubCategoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_itemSubCategory='" + id + "',@p_itemRequisition='" + reqNo + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "getItemNameList").setParameter("actionValue", value).getResultList();
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
		logger.info("Method : getIssueItemName ends");
		return response;
	}

	/**
	 * DAO Function to Add Issue Note in inventory
	 */
	public ResponseEntity<JsonResponse<Object>> addIssueNote(
			List<RestInventoryRequisitionIssueNoteModel> restInventoryRequisitionIssueNoteModel) {
		logger.info("Method : addIssueNote starts");
		@SuppressWarnings("unused")
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (RestInventoryRequisitionIssueNoteModel l : restInventoryRequisitionIssueNoteModel) {
			if (l.getItemRequisition() == null || l.getItemRequisition() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Requisition.");
				break;
		
			} else if (l.gettGodown() == null || l.gettGodown() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Godown");
				break;
			} else if (l.getpINoteActive() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Status.");
				break;
			} else if (l.getItemCategory() == null || l.getItemCategory() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select  Category.");
				break;
			} else if (l.getItemSubCategory() == null || l.getItemSubCategory() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please select Sub Category.");
				break;
			} else if (l.getItem() == null || l.getItem() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please select ItemName.");
				break;
			} 
			/*
			 * else if (l.getBatchCode() == null || l.getBatchCode() == "") { validation =
			 * false; resp.setCode("Field Validation Error");
			 * resp.setMessage("please select Batch Code."); break; }
			 */
//			else if (l.getiNoteQty() == null) {
//				validation = false;
//				resp.setCode("Field Validation Error");
//				resp.setMessage("please Enter Quantity.");
//				break;
//			}
		}

		if (validation) {

			try {
				String value = GenerateInventoryRequisitionIssueNoteParameter
						.getIssueNoteDtlParam(restInventoryRequisitionIssueNoteModel);
System.out.println(value);
				if (restInventoryRequisitionIssueNoteModel.get(0).getReqstnIssueNote() != null
						&& restInventoryRequisitionIssueNoteModel.get(0).getReqstnIssueNote() != "") {
					entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
							.setParameter("actionType", "modifyIssueNote").setParameter("actionValue", value).execute();
				} else {
					entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
							.setParameter("actionType", "addIssueNotes").setParameter("actionValue", value).execute();
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
		logger.info("Method : addIssueNote ends");
		return response;
	}

	/**
	 * DAO Function for Auto Complete
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRequisitionNumberAutocompleteList(String id, String userId) {
		logger.info("Method : inventoryRequisitionIssueNoteDao Dao starts");

		List<DropDownModel> guestList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_itemRequisition='" + id + "', @p_userId='" + userId + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "getItemRequisition").setParameter("actionValue", value)
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

		logger.info("Method : inventoryRequisitionIssueNoteDao Dao ends");
		return response;
	}

	/**
	 * DAO Function for Auto complete of search param of requisition number for
	 * generate pdf report
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> generatereqNoForPdf(String id) {
		logger.info("Method : generatereqNoForPdf Dao starts");

		List<DropDownModel> guestList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_itemRequisition='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "getItemRequisitionPdf").setParameter("actionValue", value)
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

		logger.info("Method : generatereqNoForPdf Dao ends");
		return response;
	}

	/**
	 * DAO Function to get All Issue Note in inventory
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>> getAllIssueNote(
			DataTableRequest request) {
		logger.info("Method : dao getAllIssueNote starts");

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

		List<RestInventoryRequisitionIssueNoteModel> restInventoryRequisitionIssueNoteModel = new ArrayList<RestInventoryRequisitionIssueNoteModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "viewAllIssueNote").setParameter("actionValue", values).getResultList();
			if(!x.isEmpty()) {
				for (Object[] m : x) {
	
					RestInventoryRequisitionIssueNoteModel item = new RestInventoryRequisitionIssueNoteModel(m[0], m[1],
							null, m[2], null, null, null, null, null, null, null, null, null, null, null, null, null, null,m[3] ,null,null,null,null);
					restInventoryRequisitionIssueNoteModel.add(item);
				}
	
				if (x.get(0).length > 4) {
					BigInteger t = (BigInteger) x.get(0)[4];
	
					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestInventoryRequisitionIssueNoteModel>> resp = new JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>();
		resp.setBody(restInventoryRequisitionIssueNoteModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllIssueNote ends");
		return response;
	}

	/*
	 * DAO function to get all requisition Details
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>> getAllReqDetails(String id) {
		logger.info("Method : getAllReqDetails starts");
		List<RestInventoryRequisitionIssueNoteModel> form = new ArrayList<RestInventoryRequisitionIssueNoteModel>();
		try {
			String value = "SET @p_itemRequisition='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "viewAllRequisitionDetail").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				RestInventoryRequisitionIssueNoteModel restItemModel = new RestInventoryRequisitionIssueNoteModel(null,
						null, null, null, m[0], m[1], m[2], m[3], m[4], null, null, null, null, null, null, null, null,
						null,null ,null,null,null,null);
				form.add(restItemModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestInventoryRequisitionIssueNoteModel>> resp = new JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>();
		resp.setBody(form);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getAllReqDetails ends");
		return response;
	}

	/**
	 * DAO Function to view Issue Note in model
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>> getIssueNoteForModel(String id) {

		logger.info("Method : getIssueNoteForModal starts");

		List<RestInventoryRequisitionIssueNoteModel> mt = new ArrayList<RestInventoryRequisitionIssueNoteModel>();
		JsonResponse<List<RestInventoryRequisitionIssueNoteModel>> resp = new JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>();

		try {

			String value = "SET @p_reqstnIssueNote='" + id + "';";
			System.out.println(value);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "viewIssueForModel").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestInventoryRequisitionIssueNoteModel issue = new RestInventoryRequisitionIssueNoteModel(m[0], m[1],
						null, m[2],null ,m[3], m[4], m[5], m[6], null, null, null, null, null, null, null, null, null,null,null,m[7],m[8],m[9]);

				mt.add(issue);
			}
			resp.setBody(mt);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getIssueNoteForModal ends");

		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> changeRequestedItemStatus(String id) {
		logger.info("Method : changeRequestedItemStatus starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String value = "SET @p_reqstnIssueNote='" + id + "';";
			System.out.println(value);
				entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
						.setParameter("actionType", "changeReqStatus")
						.setParameter("actionValue", value)
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
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : changeRequestedItemStatus ends");
		return response;
	}

	
	/*
	 * 
	 * Get barcode
	 * 
	 * 
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getBarCode(String id) {
		logger.info("Method : getBarCode starts");
		List<DropDownModel> avilQuantityList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_item='" + id + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "getBarCode").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				avilQuantityList.add(dropDownModel);
			}

			resp.setBody(avilQuantityList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getBarCode ends");
		return response;
	}
	
	/*
	 * 
	 * Get Available Quantity
	 * 
	 * 
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAvailableQuantity(String id) {
		logger.info("Method : getAvailableQuantity starts");
		List<DropDownModel> avilQuantityList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_item='" + id + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "getAvailableQuantity").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				avilQuantityList.add(dropDownModel);
			}

			resp.setBody(avilQuantityList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAvailableQuantity ends");
		return response;
	}
	/*
	 * 
	 * Get Issued Quantity
	 * 
	 * 
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getIssuedQuantity(String id, String requistionNo) {
		logger.info("Method : getIssuedQuantity starts");
		List<DropDownModel> issueQuantityList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_item='" + id + "',@p_requistionNo='" + requistionNo + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "getIssuedQuantity").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				issueQuantityList.add(dropDownModel);
			}

			resp.setBody(issueQuantityList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getIssuedQuantity ends");
		return response;
	}

	/**
	 * DAO Function to delete Issue Note of inventory
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteIssueNote(String id, String createdBy) {
		logger.info("Method : deleteIssueNote starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_reqstnIssueNote='" + id + "',@p_createdBy='" + createdBy + "';";
			entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "deleteIssueNote").setParameter("actionValue", value).execute();

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
		logger.info("Method : deleteIssueNote ends");
		return response;
	}

	/**
	 * DAO Function to edit Issue Note
	 *
	 */

	@SuppressWarnings("unchecked")
	public List<RestInventoryRequisitionIssueNoteModel> editIssueNoteById(String id) {

		logger.info("Method : editIssueNoteById starts");
		List<RestInventoryRequisitionIssueNoteModel> issue = new ArrayList<RestInventoryRequisitionIssueNoteModel>();
		try {
			String value = "SET @p_reqstnIssueNote='" + id + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "editIssueNote").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestInventoryRequisitionIssueNoteModel restInventoryRequisitionIssueNoteModel = new RestInventoryRequisitionIssueNoteModel(
						m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], null, null, null, null, null, null, null,
						m[9], m[10],m[11],null,m[12],m[13],m[14]);
				issue.add(restInventoryRequisitionIssueNoteModel);
				System.out.println("issue"+issue);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editIssueNoteById ends");
		return issue;
	}

	/**
	 * DAO Function to view particular itemCategory in dropDown for Issue Note
	 * order
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> editIssueItemCategory(String id) {
		logger.info("Method : editIssueItemCategory starts");
		List<DropDownModel> categoryList = new ArrayList<DropDownModel>();
		String value = "SET @p_itemRequisition='" + id + "';";

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "getItemCategoryList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				categoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editIssueItemCategory ends");
		return categoryList;
	}

	/**
	 * DAO Function to view particular itemSubCategory in dropDown for Issue
	 * Note order
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> editIssueItemSubCategory(String id, String requistionNo) {
		logger.info("Method : editIssueItemSubCategory starts");
		List<DropDownModel> itemSubCategoryList = new ArrayList<DropDownModel>();
		String value = "SET @p_itemCategory='" + id + "',@p_itemRequisition='" + requistionNo + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "getItemSubCategoryList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemSubCategoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editIssueItemSubCategory ends");
		return itemSubCategoryList;
	}

	/**
	 * DAO Function to view particular itemSubCategory in dropDown for Issue
	 * Note order
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> editIssueItemName(String id, String requistionNo) {
		logger.info("Method : editIssueItemName starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		String value = "SET @p_itemSubCategory='" + id + "',@p_itemRequisition='" + requistionNo + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "getItemNameList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editIssueItemName ends");
		return itemNameList;
	}

	/**
	 * DAO Function to view Available Quantity in dropDown for Issue Note order
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> editIssueAvailableQuantity(String id, String issueNo) {
		logger.info("Method : editIssueAvailableQuantity starts");
		List<DropDownModel> availableQuantityList = new ArrayList<DropDownModel>();
		String value = "SET @p_item='" + id + "',@p_issueNo='" + issueNo + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "editAvailableQuantity").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				availableQuantityList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editIssueAvailableQuantity ends");
		return availableQuantityList;
	}
	
	/**
	 * DAO Function to view Available Quantity in dropDown for Issue Note order
	 *
	 */
//	@SuppressWarnings("unchecked")
//	public List<DropDownModel> editBatchCode(String id, String issueNo) {
//		logger.info("Method : editBatchCode starts");
//		List<DropDownModel> availableQuantityList = new ArrayList<DropDownModel>();
//		String value = "SET @p_item='" + id + "',@p_issueNo='" + issueNo + "';";
//		try {
//			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
//					.setParameter("actionType", "editBatchCode").setParameter("actionValue", value)
//					.getResultList();
//
//			for (Object[] m : x) {
//				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
//				availableQuantityList.add(dropDownModel);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		logger.info("Method : editBatchCode ends");
//		return availableQuantityList;
//	}
	
	

	/**
	 * DAO Function to view Available Quantity in dropDown for Issue Note order
	 *
	 */
//	@SuppressWarnings("unchecked")
//	public List<DropDownModel> editAvailBatchCode(String id ) {
//		logger.info("Method : editBatchCode starts");
//		List<DropDownModel> availableQuantityList = new ArrayList<DropDownModel>();
//		String value = "SET @p_item='" + id + "';";
//		System.out.println("value " + value);
//		try {
//			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
//					.setParameter("actionType", "getBarCode").setParameter("actionValue", value)
//					.getResultList();
//
//			for (Object[] m : x) {
//				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
//				availableQuantityList.add(dropDownModel);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		logger.info("Method : editBatchCode ends");
//		return availableQuantityList;
//	}

	
	/**
	 * DAO Function to view Issued Quantity in dropDown for Issue Note order
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> editIssuedQuantity(String id, String requistionNo) {
		logger.info("Method : editIssuedQuantity starts");
		List<DropDownModel> issuedQuantityList = new ArrayList<DropDownModel>();

		String value = "SET @p_item='" + id + "',@p_requistionNo='" + requistionNo + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "getIssuedQuantity").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				issuedQuantityList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editIssuedQuantity ends");
		return issuedQuantityList;
	}

	@SuppressWarnings("unchecked")
	public List<RestInventoryRequisitionIssueNoteModel> listrequisitionDetails(String id) {
		logger.info("Method : listrequisitionDetails starts");
		List<RestInventoryRequisitionIssueNoteModel> reqList = new ArrayList<RestInventoryRequisitionIssueNoteModel>();
		try {
			String value = "SET @p_itemRequisition='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "viewAllRequisitionDetail").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				RestInventoryRequisitionIssueNoteModel restItemModel = new RestInventoryRequisitionIssueNoteModel(null,
						null, null, null, m[0], m[1], m[2], m[3], m[4], null, null, null, null, null, null, null, null,
						null,null ,null,null,null,null);
				reqList.add(restItemModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : listrequisitionDetails ends");
		return reqList;
	}

	/**
	 * DAO Function to get All Issue Note in inventory
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>> getAllIssueNotePdf(
			DataTableRequest request) {
		logger.info("Method : dao getAllIssueNotePdf starts");

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

		List<RestInventoryRequisitionIssueNoteModel> restInventoryRequisitionIssueNoteModel = new ArrayList<RestInventoryRequisitionIssueNoteModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "viewAllIssueNotePdf").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {
				Object date1 = null;
				date1 = DateFormatter.returnStringDate(m[4]);
				Object date2 = null;
				date2 = DateFormatter.returnStringDate(m[5]);
				RestInventoryRequisitionIssueNoteModel item = new RestInventoryRequisitionIssueNoteModel(m[0], m[1],
						m[2], m[3], null, null, null, null, null, date1, date2, null, null, null, null, null, null,
						null,null ,null,null,null,null);
				restInventoryRequisitionIssueNoteModel.add(item);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestInventoryRequisitionIssueNoteModel>> resp = new JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>();
		resp.setBody(restInventoryRequisitionIssueNoteModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllIssueNotePdf ends");
		return response;
	}

	/**
	 * DAO Function to get All Issue Note in inventory for Report
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>> getAllIssueNoteReport(
			DataTableRequest request) {
		logger.info("Method : dao getAllIssueNoteReport starts");

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

		List<RestInventoryRequisitionIssueNoteModel> restInventoryRequisitionIssueNoteModel = new ArrayList<RestInventoryRequisitionIssueNoteModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "viewAllIssueNoteReport").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {
				Object date1 = null;
				date1 = DateFormatter.returnStringDate(m[4]);
				Object date2 = null;
				date2 = DateFormatter.returnStringDate(m[5]);
				RestInventoryRequisitionIssueNoteModel item = new RestInventoryRequisitionIssueNoteModel(m[0], m[1],
						m[2], m[3], null, null, null, null, null, date1, date2, null, null, null, null, null, null,
						null,null ,null,null,null,null);
				restInventoryRequisitionIssueNoteModel.add(item);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestInventoryRequisitionIssueNoteModel>> resp = new JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>();
		resp.setBody(restInventoryRequisitionIssueNoteModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllIssueNoteReport ends");
		return response;
	}

	/**
	 * DAO Function to View all Issue Note in excel
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>> getAllIssueNoteDownload(
			DataTableRequest request) {
		logger.info("Method : getAllIssueNoteDownload starts");
		List<RestInventoryRequisitionIssueNoteModel> restInventoryRequisitionIssueNoteModel = new ArrayList<RestInventoryRequisitionIssueNoteModel>();
		JsonResponse<List<RestInventoryRequisitionIssueNoteModel>> resp = new JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>();
		String values = GenerateParameter.getSearchParam(request);

		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "IssueNoteExcel").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				RestInventoryRequisitionIssueNoteModel issue = new RestInventoryRequisitionIssueNoteModel(m[0], m[1],
						null, m[2], null, m[3], m[4], m[5], m[6], null, null, null, null, null, null, null, null, null,null ,null,null,null,null);

				restInventoryRequisitionIssueNoteModel.add(issue);
 
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
		resp.setBody(restInventoryRequisitionIssueNoteModel);
		ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllIssueNoteDownload ends");

		return response;
	}

	/**
	 * DAO Function to view Issue Note in individual PDF
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>> getIssueNoteForPdf(String id) {

		logger.info("Method : getIssueNoteForPdf starts");

		List<RestInventoryRequisitionIssueNoteModel> mt = new ArrayList<RestInventoryRequisitionIssueNoteModel>();
		JsonResponse<List<RestInventoryRequisitionIssueNoteModel>> resp = new JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>();

		try {

			String value = "SET @p_reqstnIssueNote='" + id + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "viewIssueForPDF").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object date1 = null;
				date1 = DateFormatter.returnStringDate(m[4]);
				RestInventoryRequisitionIssueNoteModel issue = new RestInventoryRequisitionIssueNoteModel(m[0], m[1],
						m[2], m[3], null, null, null, null, null, date1, null, m[5], m[6], m[7], m[8], null, null,
						null,null ,null,null,null,null);

				mt.add(issue);
			}
			resp.setBody(mt);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getIssueNoteForPdf ends");
		return response;
	}

	/**
	 * DAO Function to view particular itemName in dropDown for ItemRequisition
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>> getItemListByAutoSearchWithItemReq(
			String id, String reqId) {
		logger.info("Method : getItemListByAutoSearchWithItemReq starts");
		List<RestInventoryRequisitionIssueNoteModel> itemNameList = new ArrayList<RestInventoryRequisitionIssueNoteModel>();
		JsonResponse<List<RestInventoryRequisitionIssueNoteModel>> resp = new JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_reqId='" + reqId + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
					.setParameter("actionType", "getItemListAuto").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				RestInventoryRequisitionIssueNoteModel dropDownModel = new RestInventoryRequisitionIssueNoteModel(null,
						null, null, null, m[0], m[1], m[2], m[3], null, null, null, null, null, null, null, null, null,
						null,null ,null,null,null,null);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemListByAutoSearchWithItemReq ends");
		return response;
	}

	
		/**
		 * DAO Function to view Godown in dropDown 
		 * 
		 *
		 */
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getGodown() {
			logger.info("Method : getGodown starts");
			List<DropDownModel> godownList = new ArrayList<DropDownModel>();
			try {
				List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
						.setParameter("actionType", "getGodown").setParameter("actionValue", "").getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					godownList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : getGodown ends");
			System.out.println("godownList"+godownList);
			return godownList;
		}

			/*
			 * DAO Function for Store Auto Complete
			 * 
			 *
			 */

			@SuppressWarnings("unchecked")
			public ResponseEntity<JsonResponse<List<DropDownModel>>> getStoreAutoCompleteList(String id) {

				logger.info("Method : getStoreAutoCompleteList Dao starts");

				List<DropDownModel> form = new ArrayList<DropDownModel>();
				JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
				try {
					String value = "SET @p_req='" + id + "';"; 
					List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryIssueNoteRoutines")
							.setParameter("actionType", "getStoreAutoSearch").setParameter("actionValue", value)
							.getResultList();

					for (Object[] m : x) {
						DropDownModel DropDownModel = new DropDownModel(m[0], m[1]);

						form.add(DropDownModel);

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				resp.setBody(form);

				HttpHeaders responseHeaders = new HttpHeaders();
				responseHeaders.set("MyResponseHeader", "MyValue");

				ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
						resp, responseHeaders, HttpStatus.CREATED);

				logger.info("Method : getStoreAutoCompleteList Dao ends");
				 
				return response;
			}



}
