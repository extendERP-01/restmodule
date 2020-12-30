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
import nirmalya.aatithya.restmodule.common.utils.GenerateAssignedItemToShelvesParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.AssignedItemModel;
import nirmalya.aatithya.restmodule.inventory.model.RackShelvesRestModel;

@Repository
public class RackShelvesDao {

	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;

	Logger logger = LoggerFactory.getLogger(RackShelvesDao.class);

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDropDownWarehouse(String id) {
		logger.info("Method : getDropDownWarehouse starts");

		List<DropDownModel> warehouseList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_subInventory='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("rackShelvesRoutines")
					.setParameter("actionType", "getWarehouse").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel warehouse = new DropDownModel(m[0], m[1]);
				warehouseList.add(warehouse);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		resp.setBody(warehouseList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getDropDownWarehouse ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDropDownRack(String id) {
		logger.info("Method : getDropDownRack starts");

		List<DropDownModel> warehouseList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_wareHouse='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("rackShelvesRoutines")
					.setParameter("actionType", "getDropDownRack").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel warehouse = new DropDownModel(m[0], m[1]);
				warehouseList.add(warehouse);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		resp.setBody(warehouseList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getDropDownRack ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDropDownShelfs(String id) {
		logger.info("Method : getDropDownShelfs starts");

		List<DropDownModel> warehouseList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_rack='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("rackShelvesRoutines")
					.setParameter("actionType", "getDropDownShelfs").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel warehouse = new DropDownModel(m[0], m[1]);
				warehouseList.add(warehouse);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		resp.setBody(warehouseList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getDropDownShelfs ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDropDownItem() {
		logger.info("Method : getDropDownItem starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("rackShelvesRoutines")
					.setParameter("actionType", "getItem").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel warehouse = new DropDownModel(m[0], m[1]);
				itemList.add(warehouse);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		resp.setBody(itemList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getDropDownItem ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RackShelvesRestModel>>> getPreviousDetails(String whId, String storeId,
			String subInvId) {
		logger.info("Method : getDropDownShelfs starts");

		List<RackShelvesRestModel> warehouseList = new ArrayList<RackShelvesRestModel>();

		try {
			String value = "SET @p_wh='" + whId + "',@p_storeId='" + storeId + "',@p_subInvId='" + subInvId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("rackShelvesRoutines")
					.setParameter("actionType", "getPreviousDetails").setParameter("actionValue", value)
					.getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					RackShelvesRestModel properties = new RackShelvesRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
							m[7], m[8], null, m[9].toString());
					warehouseList.add(properties);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RackShelvesRestModel>> resp = new JsonResponse<List<RackShelvesRestModel>>();

		resp.setBody(warehouseList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RackShelvesRestModel>>> response = new ResponseEntity<JsonResponse<List<RackShelvesRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getDropDownShelfs ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> assignItemToShelves(List<RackShelvesRestModel> assigneItem) {
		logger.info("Method : assignItemToShelves starts");

		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		for (RackShelvesRestModel l : assigneItem) {

			if (l.getStore() == null || l.getStore() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Store.");
				break;
			} else if (l.getSubInventory() == null || l.getSubInventory() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Sub-Inventory.");
				break;
			} else if (l.getWarehouse() == null || l.getWarehouse() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Warehouse.");
				break;
			} else if (l.getRackId() == null || l.getRackId() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Rack Name.");
				break;
			} else if (l.getShelf() == null || l.getShelf() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Shelf Name.");
				break;
			} /*
				 * else if (l.getShelvesCapacity() == null) { validation = false;
				 * resp.setCode("Field Validation Error");
				 * resp.setMessage("Please Enter Shelf Capacity."); break; }
				 */

		}

		if (validation) {
			try {
				String value = GenerateAssignedItemToShelvesParameter.assignItem(assigneItem);
				/*if (assigneItem.get(0).getId() != null && assigneItem.get(0).getId() != "") {

					em.createNamedStoredProcedureQuery("rackShelvesRoutines")
							.setParameter("actionType", "modifyAssignedItem").setParameter("actionValue", value)
							.execute();
				} else {*/

					em.createNamedStoredProcedureQuery("rackShelvesRoutines")
							.setParameter("actionType", "assignItemToShelves").setParameter("actionValue", value)
							.execute();
					/* } */

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

		logger.info("Method : assignItemToShelves ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RackShelvesRestModel>>> getAllRackDetails(DataTableRequest request) {
		logger.info("Method : getAllRackDetails starts");

		List<RackShelvesRestModel> rack = new ArrayList<RackShelvesRestModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("rackShelvesRoutines")
					.setParameter("actionType", "viewAllRack").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					RackShelvesRestModel properties = new RackShelvesRestModel(m[0], m[1], m[2], m[3], m[4], m[5], null,
							null, null, null, null);
					rack.add(properties);
				}

				if (x.get(0).length > 6) {
					BigInteger t = (BigInteger) x.get(0)[6];
					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RackShelvesRestModel>> resp = new JsonResponse<List<RackShelvesRestModel>>();
		resp.setBody(rack);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<RackShelvesRestModel>>> response = new ResponseEntity<JsonResponse<List<RackShelvesRestModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAllRackDetails ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RackShelvesRestModel>>> editRackDetails(String id) {
		logger.info("Method : getAllRackDetails starts");

		List<RackShelvesRestModel> rack = new ArrayList<RackShelvesRestModel>();

		try {
			String value = "SET @p_rackId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("rackShelvesRoutines")
					.setParameter("actionType", "editViewRack").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					RackShelvesRestModel properties = new RackShelvesRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
							m[7], m[8], null, null);
					rack.add(properties);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RackShelvesRestModel>> resp = new JsonResponse<List<RackShelvesRestModel>>();
		resp.setBody(rack);

		ResponseEntity<JsonResponse<List<RackShelvesRestModel>>> response = new ResponseEntity<JsonResponse<List<RackShelvesRestModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : editRackDetails ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> editWarehouseForRack(String id) {
		logger.info("Method : editWarehouseForRack starts");

		List<DropDownModel> warehouseList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_subInventory='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("rackShelvesRoutines")
					.setParameter("actionType", "getWarehouse").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel warehouse = new DropDownModel(m[0], m[1]);
				warehouseList.add(warehouse);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editWarehouseForRack ends");
		return warehouseList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> editRackByWareHouse(String id) {
		logger.info("Method : editRackByWareHouse starts");

		List<DropDownModel> warehouseList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_wareHouse='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("rackShelvesRoutines")
					.setParameter("actionType", "getDropDownRack").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel warehouse = new DropDownModel(m[0], m[1]);
				warehouseList.add(warehouse);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editRackByWareHouse ends");
		return warehouseList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> editShelvesByRack(String id) {
		logger.info("Method : editShelvesByRack starts");

		List<DropDownModel> warehouseList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_rack='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("rackShelvesRoutines")
					.setParameter("actionType", "getDropDownShelfs").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel warehouse = new DropDownModel(m[0], m[1]);
				warehouseList.add(warehouse);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editShelvesByRack ends");
		return warehouseList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> editShelves() {
		logger.info("Method : editShelves starts");

		List<DropDownModel> warehouseList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("rackShelvesRoutines")
					.setParameter("actionType", "getDropDownShelf").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel warehouse = new DropDownModel(m[0], m[1]);
				warehouseList.add(warehouse);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editShelves ends");
		return warehouseList;
	}

	@SuppressWarnings("unchecked")
	public List<AssignedItemModel> getSelectedItem(String id) {
		logger.info("Method : getSelectedItem starts");

		List<AssignedItemModel> itemList = new ArrayList<AssignedItemModel>();

		try {
			String value = "SET @p_shelf='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("rackShelvesRoutines")
					.setParameter("actionType", "getSelectedItem").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				AssignedItemModel warehouse = new AssignedItemModel(m[0], m[1], m[2]);
				itemList.add(warehouse);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getSelectedItem ends");
		return itemList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RackShelvesRestModel>>> editRackShelf(String id, String storeId,
			String subId, String whId) {
		logger.info("Method : editRackShelf starts");

		List<RackShelvesRestModel> rack = new ArrayList<RackShelvesRestModel>();

		try {
			String value = "SET @p_rackId='" + id + "',@p_storeId='" + storeId + "',@p_subId='" + subId + "',@p_whId='"
					+ whId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("rackShelvesRoutines")
					.setParameter("actionType", "editRackShelf").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					RackShelvesRestModel properties = new RackShelvesRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
							m[7], m[8], null, null);
					rack.add(properties);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RackShelvesRestModel>> resp = new JsonResponse<List<RackShelvesRestModel>>();
		resp.setBody(rack);

		ResponseEntity<JsonResponse<List<RackShelvesRestModel>>> response = new ResponseEntity<JsonResponse<List<RackShelvesRestModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : editRackShelf ends");
		return response;
	}

}
