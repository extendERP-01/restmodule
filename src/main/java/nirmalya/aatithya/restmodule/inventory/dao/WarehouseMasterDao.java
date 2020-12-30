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
import nirmalya.aatithya.restmodule.common.utils.GenerateWarehouseParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.WarehouseMasterRestModel;

@Repository
public class WarehouseMasterDao {

	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;

	Logger logger = LoggerFactory.getLogger(WarehouseMasterDao.class);
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDropDownSubInventory(String id) {
		logger.info("Method : getDropDownSubInventory starts");
		
		List<DropDownModel> subInvList = new ArrayList<DropDownModel>();
		
		try {
			String value = "SET @p_store='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutines")
					.setParameter("actionType", "getSubInventory").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel subInv = new DropDownModel(m[0], m[1]);
				subInvList.add(subInv);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		
		resp.setBody(subInvList);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : getDropDownSubInventory ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> saveWarehouse(WarehouseMasterRestModel warehouse) {
		logger.info("Method : saveWarehouse starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (warehouse.getWarehouseName() == null || warehouse.getWarehouseName() == "") {
			resp.setMessage("Warehouse Name Required");
			validity = false;
		} else if (warehouse.getStore() == null || warehouse.getStore() == "") {
			resp.setMessage("Store Required");
			validity = false;
		} else if (warehouse.getSubInventory() == null || warehouse.getSubInventory() == "") {
			resp.setMessage("Sub-Inventory Required");
			validity = false;
		}

		if (validity) {
			try {
				String values = GenerateWarehouseParameter.addWarehouse(warehouse);

				if (warehouse.getWarehouseId() == null || warehouse.getWarehouseId() == "") {
					em.createNamedStoredProcedureQuery("warehouseRoutines")
							.setParameter("actionType", "addNewWarehouse").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("warehouseRoutines")
							.setParameter("actionType", "modifyWarehouse").setParameter("actionValue", values)
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

		logger.info("Method : saveWarehouse ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<WarehouseMasterRestModel>>> getAllWarehouseDetails(
			DataTableRequest request) {
		logger.info("Method : getAllWarehouseDetails starts");

		List<WarehouseMasterRestModel> warehouse = new ArrayList<WarehouseMasterRestModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutines")
					.setParameter("actionType", "viewWarehouse").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					WarehouseMasterRestModel properties = new WarehouseMasterRestModel(m[0], m[1], m[2], m[3],
							m[4], m[5], m[6]);
					warehouse.add(properties);
				}

				if (x.get(0).length > 7) {
					BigInteger t = (BigInteger) x.get(0)[7];
					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<WarehouseMasterRestModel>> resp = new JsonResponse<List<WarehouseMasterRestModel>>();
		resp.setBody(warehouse);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<WarehouseMasterRestModel>>> response = new ResponseEntity<JsonResponse<List<WarehouseMasterRestModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getAllWarehouseDetails ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<WarehouseMasterRestModel>> viewWarehouseData(String id, String action) {
		logger.info("Method : viewWarehouseData starts");
		
		List<WarehouseMasterRestModel> warehouseList = new ArrayList<WarehouseMasterRestModel>();
		try {
			String value = "SET @p_warehouse='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutines")
					.setParameter("actionType", action).setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				WarehouseMasterRestModel subInv = new WarehouseMasterRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6]);
				warehouseList.add(subInv);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonResponse<WarehouseMasterRestModel> resp = new JsonResponse<WarehouseMasterRestModel>();
		
		resp.setBody(warehouseList.get(0));
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<WarehouseMasterRestModel>> response = new ResponseEntity<JsonResponse<WarehouseMasterRestModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : viewWarehouseData ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteWarehouse(String id, String deletedBy) {
		logger.info("Method : deleteWarehouse starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_warehouse='" + id + "', @p_deletedBy='" + deletedBy + "';";

			em.createNamedStoredProcedureQuery("warehouseRoutines").setParameter("actionType", "deleteWarehouse")
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

		logger.info("Method : deleteWarehouse end");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> editSubInvForWarehouse(String id) {
		logger.info("Method : editSubInvForWarehouse starts");
		
		List<DropDownModel> subInvList = new ArrayList<DropDownModel>();
		
		try {
			String value = "SET @p_store='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutines")
					.setParameter("actionType", "getSubInventory").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel subInv = new DropDownModel(m[0], m[1]);
				subInvList.add(subInv);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : editSubInvForWarehouse end");
		return subInvList;
	}
}
