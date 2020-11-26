/**
 * Defines inventory itemSubCategory DAO
 */
package nirmalya.aatithya.restmodule.inventory.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateInventorySubCategoryParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.InventoryItemSubCategoryModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class InventoryItemSubCategoryDao {

	Logger logger = (Logger) LoggerFactory.getLogger(InventoryItemSubCategoryDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")

	public ResponseEntity<JsonResponse<Object>> addItemSubCategory(InventoryItemSubCategoryModel itemSubCategoryModel) {
		logger.info("Method : addItemSubCategory starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (itemSubCategoryModel.getItmSubCategoryName() == null
				|| itemSubCategoryModel.getItmSubCategoryName() == "") {
			resp.setMessage("ItemSubCategoryName required");
			validity = false;
		} else if (itemSubCategoryModel.getItmCategory() == null || itemSubCategoryModel.getItmCategory() == "") {
			resp.setMessage("ItemCategoryName  required");
			validity = false;
		} else if (itemSubCategoryModel.getItmSubActive() == null) {
			resp.setMessage("ItemSubCategoryActive required");
			validity = false;
		} else if (itemSubCategoryModel.getItmSubDescription() == null
				|| itemSubCategoryModel.getItmSubDescription() == "") {
			resp.setMessage("ItemSubCategoryDescription  required");
			validity = false;
		}
		if (validity)
			try {
				String values = GenerateInventorySubCategoryParameter.getAddItemSubCategory(itemSubCategoryModel);

				if (itemSubCategoryModel.getItmSubCategoryId() != null
						&& itemSubCategoryModel.getItmSubCategoryId() != "") {
					em.createNamedStoredProcedureQuery("itemSubCatRoutines")
							.setParameter("actionType", "modifyItemSubCat").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("itemSubCatRoutines")
							.setParameter("actionType", "addItemSubCategory").setParameter("actionValue", values)
							.execute();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addItemSubCategory ends");
		return response;

	}

	/**
	 * For Viewing Item Sub Category
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventoryItemSubCategoryModel>>> getAllItemSubCategoryList(
			DataTableRequest request) {

		logger.info("Method : getAllItemSubCategoryList starts");

		List<InventoryItemSubCategoryModel> itemSubCategoryModel = new ArrayList<InventoryItemSubCategoryModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("itemSubCatRoutines")
					.setParameter("actionType", "viewItemSubCat").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				InventoryItemSubCategoryModel itmCat = new InventoryItemSubCategoryModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], null);
				itemSubCategoryModel.add(itmCat);
			}
			if (x.get(0).length > 8) {
				BigInteger t = (BigInteger) x.get(0)[8];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<InventoryItemSubCategoryModel>> resp = new JsonResponse<List<InventoryItemSubCategoryModel>>();
		resp.setBody(itemSubCategoryModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<InventoryItemSubCategoryModel>>> response = new ResponseEntity<JsonResponse<List<InventoryItemSubCategoryModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAllItemSubCategoryList ends");
		return response;
	}

	/**
	 * For Editing Item SubCategory
	 *
	 */

	public ResponseEntity<JsonResponse<InventoryItemSubCategoryModel>> getItemSubCatById(String id) {
		logger.info("Method : getItemSubCatById starts");

		List<InventoryItemSubCategoryModel> form = new ArrayList<InventoryItemSubCategoryModel>();
		try {
			String value = "SET @p_itmSubCategoryId='" + id + "';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("itemSubCatRoutines")
					.setParameter("actionType", "viewDetailsItmSubCat").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				InventoryItemSubCategoryModel restItemCategoryModel = new InventoryItemSubCategoryModel(m[0], m[1],
						m[2], m[3], m[4], m[5], m[6], m[7], null);
				form.add(restItemCategoryModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<InventoryItemSubCategoryModel> resp = new JsonResponse<InventoryItemSubCategoryModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<InventoryItemSubCategoryModel>> response = new ResponseEntity<JsonResponse<InventoryItemSubCategoryModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getItemSubCatById ends");
		return response;
	}

	/**
	 * For Deleting Item SubCategory
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> deletItemSubCategory(String id, String createdBy) {
		logger.info("Method : deletItemSubCategory starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_itmSubCategoryId='" + id + "',@p_createdBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("itemSubCatRoutines").setParameter("actionType", "deleteItemSubCat")
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

		logger.info("Method : deletItemSubCategory ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getItemCategory() {
		logger.info("Method : getItemCategory starts");
		List<DropDownModel> itemCategoryList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("itemSubCatRoutines")
					.setParameter("actionType", "getCategoryName").setParameter("actionValue", "").getResultList();

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

}
