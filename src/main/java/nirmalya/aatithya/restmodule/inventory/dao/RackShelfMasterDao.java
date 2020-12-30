package nirmalya.aatithya.restmodule.inventory.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateRackShelfMasterParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.RackShelvesRestModel;
@Repository
public class RackShelfMasterDao {
	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;

	Logger logger = LoggerFactory.getLogger(RackShelfMasterDao.class);
	
	public ResponseEntity<JsonResponse<Object>> assignShelvesToRack(List<RackShelvesRestModel> assigneItem) {
		logger.info("Method : assignShelvesToRack starts");
		
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
			} else if (l.getRackName() == null || l.getRackName() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Rack Name.");
				break;
			} else if (l.getShelf() == null || l.getShelf() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Shelf Name.");
				break;
			} 

		}

		if (validation) {
			try {
				String value = GenerateRackShelfMasterParam.assignItem(assigneItem);
				if (assigneItem.get(0).getRackId() != null && assigneItem.get(0).getRackId() != "") {
					em.createNamedStoredProcedureQuery("rackShelvesRoutines")
							.setParameter("actionType", "modifySalveToRack").setParameter("actionValue", value)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("rackShelvesRoutines")
							.setParameter("actionType", "assignShelvesToRack").setParameter("actionValue", value)
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
		
		logger.info("Method : assignShelvesToRack ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RackShelvesRestModel>>> getAllRackDetails(
			DataTableRequest request) {
		logger.info("Method : getAllRackDetails starts");

		List<RackShelvesRestModel> rack = new ArrayList<RackShelvesRestModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("rackShelvesRoutines")
					.setParameter("actionType", "viewAllRackMaster").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) { 
					RackShelvesRestModel properties = new RackShelvesRestModel(m[0], m[1], m[2], m[3],
							m[4], m[5], null, null, null, null, null);
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
	public ResponseEntity<JsonResponse<List<RackShelvesRestModel>>> editRackDetails(
			String id) {
		logger.info("Method : getAllRackDetails starts");
		
		List<RackShelvesRestModel> rack = new ArrayList<RackShelvesRestModel>();
		
		try {
			String value = "SET @p_rackId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("rackShelvesRoutines")
					.setParameter("actionType", "editRackMaster").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) { 
					RackShelvesRestModel properties = new RackShelvesRestModel(m[0], m[1], m[2], m[3],
							m[4], m[5], m[6], null, null, null, null);
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
}
