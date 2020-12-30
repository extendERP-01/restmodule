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
import nirmalya.aatithya.restmodule.common.utils.GenerateInventoryDamagedItemParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

import nirmalya.aatithya.restmodule.inventory.model.RestInventoryDamagedItemModel;

/*
 * @author NirmalyaLabs
 *
 */
@Repository
public class RestInventoryDamagedItemDao {
	Logger logger = LoggerFactory.getLogger(RestInventoryDamagedItemDao.class);
	@Autowired
	private EntityManager entityManager;
	@Autowired
	ServerDao serverDao;

	/*
	 * DAO Function to view vendor name in dropDown for Item
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDamagedItemVendorName() {
		logger.info("Method : getDamagedItemVendorName starts");
		List<DropDownModel> ServeTypeLIst = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("damagedItemRoutines")
					.setParameter("actionType", "getVendor").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				ServeTypeLIst.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDamagedItemVendorName ends");
		return ServeTypeLIst;
	}

	/*
	 * DAO Function for Auto Complete for Item
	 * 
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getInventoryItemAutoSearchList(String id) {

		logger.info("Method : getInventoryItemAutoSearchList Dao starts");

		List<DropDownModel> form = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			String value = "SET @p_tItem='" + id + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("damagedItemRoutines")
					.setParameter("actionType", "getItemAutoSearch").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel ItemAutoComplete = new DropDownModel(m[0], m[1]);

				form.add(ItemAutoComplete);

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

		logger.info("Method : getInventoryItemAutoSearchList Dao ends");

		return response;
	}

	/*
	 * DAO Function to Add Damaged Item Details
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addNewDamagedItems(List<RestInventoryDamagedItemModel> damagedItem) {
		logger.info("Method in Dao:addNewDamagedItems starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			if (damagedItem.get(0).gettDamagedItemId() != null) {

				String values = GenerateInventoryDamagedItemParameter.modifyDamagedItemsParam(damagedItem);
				entityManager.createNamedStoredProcedureQuery("damagedItemRoutines")
						.setParameter("actionType", "modifyDamagedItem").setParameter("actionValue", values).execute();
			} else {

				String values = GenerateInventoryDamagedItemParameter.addNewDamagedItemsParam(damagedItem);
				entityManager.createNamedStoredProcedureQuery("damagedItemRoutines")
						.setParameter("actionType", "addDamagedItem").setParameter("actionValue", values).execute();
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

		logger.info("Method in Dao: addNewDamagedItems ends");

		return response;

	}

	/*
	 * DAO Function to get All Damaged Item
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryDamagedItemModel>>> getAllDamagedItemsList(
			DataTableRequest request) {
		logger.info("Method : getAllItems starts");
		List<RestInventoryDamagedItemModel> damagedItem = new ArrayList<RestInventoryDamagedItemModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("damagedItemRoutines")
					.setParameter("actionType", "viewDamagedItems").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					RestInventoryDamagedItemModel item = new RestInventoryDamagedItemModel(m[0], m[1], m[2], m[3], m[4],
							m[5], m[6], null);
					damagedItem.add(item);
				}

				if (x.get(0).length > 7) {
					BigInteger t = (BigInteger) x.get(0)[7];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestInventoryDamagedItemModel>> resp = new JsonResponse<List<RestInventoryDamagedItemModel>>();
		resp.setBody(damagedItem);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestInventoryDamagedItemModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryDamagedItemModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllItems ends");
		return response;
	}

	/*
	 * DAO Function to edit Damaged Item
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestInventoryDamagedItemModel>> editDamagedItem(String id) {

		logger.info("Method : editDamagedItem starts");
		List<RestInventoryDamagedItemModel> form = new ArrayList<RestInventoryDamagedItemModel>();
		try {
			String value = "SET @p_itemId='" + id + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("damagedItemRoutines")
					.setParameter("actionType", "editDamagedItem").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestInventoryDamagedItemModel damagedItem = new RestInventoryDamagedItemModel(m[0], m[1], m[2], m[3],
						m[4], m[5], m[6], null);
				form.add(damagedItem);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<RestInventoryDamagedItemModel> resp = new JsonResponse<RestInventoryDamagedItemModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestInventoryDamagedItemModel>> response = new ResponseEntity<JsonResponse<RestInventoryDamagedItemModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : editDamagedItem ends");

		return response;
	}

	/*
	 * DAO Function to view Item in model
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestInventoryDamagedItemModel>> getDamagedItemForModel(String id) {
		logger.info("Method : getDamagedItemForModel starts");
		List<RestInventoryDamagedItemModel> form = new ArrayList<RestInventoryDamagedItemModel>();
		try {
			String value = "SET @p_itemId='" + id + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("damagedItemRoutines")
					.setParameter("actionType", "viewItemForModel").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				RestInventoryDamagedItemModel damagedItem = new RestInventoryDamagedItemModel(m[0], m[1], m[2], m[3],
						m[4], m[5], m[6], null);
				form.add(damagedItem);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<RestInventoryDamagedItemModel> resp = new JsonResponse<RestInventoryDamagedItemModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestInventoryDamagedItemModel>> response = new ResponseEntity<JsonResponse<RestInventoryDamagedItemModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getDamagedItemForModel ends");

		return response;
	}

	/*
	 * DAO Function to delete Damaged Item
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteDamagedItem(String id, String createdBy) {
		logger.info("Method : deleteDamagedItem starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_itemId='" + id + "',@p_createdBy='" + createdBy + "';";
			entityManager.createNamedStoredProcedureQuery("damagedItemRoutines")
					.setParameter("actionType", "deleteDamagedItem").setParameter("actionValue", value).execute();

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
		logger.info("Method : deleteDamagedItem ends");

		return response;
	}

	/*
	 * DAO Function to change status of Damaged Item
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> changeStatusToReSale(String id, String createdBy) {
		logger.info("Method : changeStatusToReSale starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_itemId='" + id + "',@p_createdBy='" + createdBy + "';";
			entityManager.createNamedStoredProcedureQuery("damagedItemRoutines")
					.setParameter("actionType", "changeStatusReSale").setParameter("actionValue", value).execute();

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
		logger.info("Method : changeStatusToReSale ends");
		return response;
	}

	/*
	 * DAO Function to change status of Damaged Item to Scrapped
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> changeStatusToScrapped(String id, String createdBy) {
		logger.info("Method : changeStatusToScrapped starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_itemId='" + id + "',@p_createdBy='" + createdBy + "';";
			entityManager.createNamedStoredProcedureQuery("damagedItemRoutines")
					.setParameter("actionType", "changeStatusScrapped").setParameter("actionValue", value).execute();

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
		logger.info("Method : changeStatusToScrapped ends");
		return response;
	}

	/*
	 * DAO Function for Auto Complete for search param for Item
	 * 
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getParamItemListByAutoSearch(String id) {

		logger.info("Method : getParamItemListByAutoSearch Dao starts");

		List<DropDownModel> form = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			String value = "SET @p_tItem='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("damagedItemRoutines")
					.setParameter("actionType", "getItemAutoSearch").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel paramStaff = new DropDownModel(m[0], m[1]);

				form.add(paramStaff);

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

		logger.info("Method : getParamItemListByAutoSearch Dao ends");
		return response;
	}

}
