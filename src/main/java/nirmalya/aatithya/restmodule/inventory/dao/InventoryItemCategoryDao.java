/*
*Defines inventory itemCategory DAO
 * 
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
import nirmalya.aatithya.restmodule.common.utils.GenerateInventoryItemCategoryParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryItemCategoryModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class InventoryItemCategoryDao {
	Logger logger=LoggerFactory.getLogger(InventoryItemCategoryDao.class);
	@Autowired
	private EntityManager entityManager;
	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to Add/edit ItemCategory in inventory
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addItemCategory(RestInventoryItemCategoryModel itemCategoryModel) {
		logger.info("Method : addItemCategory Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (itemCategoryModel.getItmCatName() == null || itemCategoryModel.getItmCatName() == "") {
			resp.setMessage("itemCategory required");
			validity = false;
		} else if (itemCategoryModel.getItmCatDescription() == null || itemCategoryModel.getItmCatDescription() == "") {
			resp.setMessage("description required");
			validity = false;
		} else if (itemCategoryModel.getItmCatActive() == null) {
			resp.setMessage("status required");
			validity = false;
		}
		if (validity)
			try {
				String values = GenerateInventoryItemCategoryParameter.addItemCategoryParam(itemCategoryModel);

				if (itemCategoryModel.getItmCategory() != null && itemCategoryModel.getItmCategory() != "") {
					entityManager.createNamedStoredProcedureQuery("inventoryItemCategoryRoutines")
							.setParameter("actionType", "modifyItemCategory").setParameter("actionValue", values)
							.execute();
				} else {
					entityManager.createNamedStoredProcedureQuery("inventoryItemCategoryRoutines")
							.setParameter("actionType", "addNewItemCategory").setParameter("actionValue", values)
							.execute();
				}

			}catch (Exception e) {
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
		logger.info("Method : addItemCategory Dao ends");
		return response;
	}

	/**
	 * DAO Function to View all itemCategories in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryItemCategoryModel>>> getAllItemList(DataTableRequest request) {
		logger.info("Method : getAllItemList Dao starts");
		List<RestInventoryItemCategoryModel> itemCategoryModel = new ArrayList<RestInventoryItemCategoryModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemCategoryRoutines")
					.setParameter("actionType", "viewAllItemCategory").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				RestInventoryItemCategoryModel itmCat = new RestInventoryItemCategoryModel(m[0], m[1], m[2], m[3],null);
				itemCategoryModel.add(itmCat);
			}

			if (x.get(0).length > 4) {
				BigInteger t = (BigInteger) x.get(0)[4];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestInventoryItemCategoryModel>> resp = new JsonResponse<List<RestInventoryItemCategoryModel>>();
		resp.setBody(itemCategoryModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestInventoryItemCategoryModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryItemCategoryModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllItemList Dao ends");
		return response;
	}

	/**
	 * DAO Function to delete itemCategory of inventory
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deletItemCategory(String id,String createdBy) {
		logger.info("Method : deletItemCategory Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_itmCategory='" + id + "',@p_createdBy='"+createdBy+"';";
			entityManager.createNamedStoredProcedureQuery("inventoryItemCategoryRoutines")
					.setParameter("actionType", "deleteItemCategory").setParameter("actionValue", value).execute();

		}catch (Exception e) {
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
		logger.info("Method : deletItemCategory Dao ends");
		return response;
	}

	/**
	 * DAO Function to edit itemCategory
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestInventoryItemCategoryModel>> getItemById(String id) {
		logger.info("Method : getItemById Dao starts");
		List<RestInventoryItemCategoryModel> form = new ArrayList<RestInventoryItemCategoryModel>();
		try {
			String value = "SET @p_itmCategory='" + id + "';";
			
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryItemCategoryRoutines")
					.setParameter("actionType", "viewItemCategory").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestInventoryItemCategoryModel restItemCategoryModel = new RestInventoryItemCategoryModel(m[0], m[1], m[2], m[3],null);
				form.add(restItemCategoryModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<RestInventoryItemCategoryModel> resp = new JsonResponse<RestInventoryItemCategoryModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestInventoryItemCategoryModel>> response = new ResponseEntity<JsonResponse<RestInventoryItemCategoryModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getItemById Dao ends");
		return response;
	}
}
