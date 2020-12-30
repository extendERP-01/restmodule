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
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateSubInventoryParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.RestSubInventoryMasterModel;

@Repository
public class SubInventoryMasterDao {

	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;

	Logger logger = LoggerFactory.getLogger(SubInventoryMasterDao.class);

	/**
	 * DAO - STORE MASTER LIST
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStoreForSubInv() {
		logger.info("Method : getStoreForSubInv starts");

		List<DropDownModel> storeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("subInventoryRoutines")
					.setParameter("actionType", "getStore").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				storeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getStoreForSubInv ends");
		return storeList;
	}

	public ResponseEntity<JsonResponse<Object>> saveSubInventory(RestSubInventoryMasterModel subInventory) {
		logger.info("Method : saveSubInventory starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (subInventory.getSubInventoryName() == null || subInventory.getSubInventoryName() == "") {
			resp.setMessage("Sub-Inventory Name Required");
			validity = false;
		} else if (subInventory.getStore() == null || subInventory.getStore() == "") {
			resp.setMessage("Store Required");
			validity = false;
		}

		if (validity) {
			try {
				String values = GenerateSubInventoryParameter.addSubInventory(subInventory);

				if (subInventory.getSubInventoryId() == null || subInventory.getSubInventoryId() == "") {
					em.createNamedStoredProcedureQuery("subInventoryRoutines")
							.setParameter("actionType", "addNewSubInventory").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("subInventoryRoutines")
							.setParameter("actionType", "modifySubInventory").setParameter("actionValue", values)
							.execute();
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
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveSubInventory ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSubInventoryMasterModel>>> getAllSubInventoryDetails(
			DataTableRequest request) {
		logger.info("Method : getAllSubInventoryDetails starts");

		List<RestSubInventoryMasterModel> store = new ArrayList<RestSubInventoryMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("subInventoryRoutines")
					.setParameter("actionType", "viewSubInventory").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					RestSubInventoryMasterModel properties = new RestSubInventoryMasterModel(m[0], m[1], m[2], m[3],
							m[4], m[5]);
					store.add(properties);
				}

				if (x.get(0).length > 6) {
					BigInteger t = (BigInteger) x.get(0)[6];
					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestSubInventoryMasterModel>> resp = new JsonResponse<List<RestSubInventoryMasterModel>>();
		resp.setBody(store);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<RestSubInventoryMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestSubInventoryMasterModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getAllSubInventoryDetails ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestSubInventoryMasterModel>> viewSubInventoryData(String id, String action) {
		logger.info("Method : viewSubInventoryData starts");
		
		List<RestSubInventoryMasterModel> subInvList = new ArrayList<RestSubInventoryMasterModel>();
		try {
			String value = "SET @p_subInv='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("subInventoryRoutines")
					.setParameter("actionType", action).setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestSubInventoryMasterModel subInv = new RestSubInventoryMasterModel(m[0], m[1], m[2], m[3], m[4], m[5]);
				subInvList.add(subInv);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonResponse<RestSubInventoryMasterModel> resp = new JsonResponse<RestSubInventoryMasterModel>();
		
		resp.setBody(subInvList.get(0));
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestSubInventoryMasterModel>> response = new ResponseEntity<JsonResponse<RestSubInventoryMasterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : viewSubInventoryData ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteSubInventory(String id, String deletedBy) {
		logger.info("Method : deleteStoreDetails starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_subInv='" + id + "', @p_deletedBy='" + deletedBy + "';";

			em.createNamedStoredProcedureQuery("subInventoryRoutines").setParameter("actionType", "deleteSubInventory")
					.setParameter("actionValue", value).execute();

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

		logger.info("Method : deleteStoreDetails end");
		return response;
	}
}
