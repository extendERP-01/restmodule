/**
 * Defines inventory itemServeType DAO
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
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateInventoryServeTypeParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.InventoryItemServeTypeModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class InventoryItemServeTypeDao {

	Logger logger = (Logger) LoggerFactory.getLogger(InventoryItemServeTypeDao.class);
	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to Add/edit ItemServeType in inventory
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> addItemServeType(InventoryItemServeTypeModel itemServeTypeModel) {

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (itemServeTypeModel.getItmServeTypeName() == null || itemServeTypeModel.getItmServeTypeName() == "") {
			resp.setMessage("ServeType  Name required");
			validity = false;
		} else if (itemServeTypeModel.getItmServeTypeDescription() == null
				|| itemServeTypeModel.getItmServeTypeDescription() == "") {
			resp.setMessage("ServeDescription required");
			validity = false;
		} else if (itemServeTypeModel.getItmServeTypeActive() == null) {
			resp.setMessage("status required");
			validity = false;
		}
		if (validity)
			try {
				String values = GenerateInventoryServeTypeParameter.addItemServeParam(itemServeTypeModel);

				if (itemServeTypeModel.getItmServeTypeId() != null && itemServeTypeModel.getItmServeTypeId() != "") {
					em.createNamedStoredProcedureQuery("itemServeTypeRoutines")
							.setParameter("actionType", "modifyItemServe").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("itemServeTypeRoutines")
							.setParameter("actionType", "addNewItemServe").setParameter("actionValue", values)
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventoryItemServeTypeModel>>> getAllItemServeTypeList(
			DataTableRequest request) {
		List<InventoryItemServeTypeModel> itemServeTypeModel = new ArrayList<InventoryItemServeTypeModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("itemServeTypeRoutines")
					.setParameter("actionType", "viewAllItemServeType").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				InventoryItemServeTypeModel itmCat = new InventoryItemServeTypeModel(m[0], m[1], m[2], m[3], m[4], m[5],
						null);
				itemServeTypeModel.add(itmCat);
			}

			if (x.get(0).length > 6) {
				BigInteger t = (BigInteger) x.get(0)[6];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<InventoryItemServeTypeModel>> resp = new JsonResponse<List<InventoryItemServeTypeModel>>();
		resp.setBody(itemServeTypeModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<InventoryItemServeTypeModel>>> response = new ResponseEntity<JsonResponse<List<InventoryItemServeTypeModel>>>(
				resp, HttpStatus.CREATED);
		return response;
	}

	/**
	 * For Deleting Item SubCategory
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> deleteItemServeType(String id, String createdBy) {

		logger.info("Method : deleteItemServeType starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_itmServeTypeId='" + id + "',@p_createdBy='" + createdBy + "';";
			System.out.println("delete serve" + value);
			em.createNamedStoredProcedureQuery("itemServeTypeRoutines")
					.setParameter("actionType", "deleteItemServeType").setParameter("actionValue", value).execute();

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

		logger.info("Method : deleteItemServeType ends");
		return response;

	}

	/**
	 * For Editing Item ServeType
	 *
	 */

	public ResponseEntity<JsonResponse<InventoryItemServeTypeModel>> getItemServeTypeById(String id) {
		logger.info("Method : getItemServeTypeById starts");

		List<InventoryItemServeTypeModel> form = new ArrayList<InventoryItemServeTypeModel>();
		try {
			String value = "SET @p_itmServeTypeId='" + id + "';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("itemServeTypeRoutines")
					.setParameter("actionType", "editItemServeType").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				InventoryItemServeTypeModel restItemServeTypeModel = new InventoryItemServeTypeModel(m[0], m[1], m[2],
						m[3], m[4], m[5], null);
				form.add(restItemServeTypeModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<InventoryItemServeTypeModel> resp = new JsonResponse<InventoryItemServeTypeModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<InventoryItemServeTypeModel>> response = new ResponseEntity<JsonResponse<InventoryItemServeTypeModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getItemServeTypeById ends");
		return response;
	}

}
