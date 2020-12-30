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

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.GenerateInventoryCostcenterManageParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.ServerValidation;
import nirmalya.aatithya.restmodule.inventory.model.InventoryManageCostcenterModel;



@Repository
public class InventoryCostCenterManageDao {
	Logger logger = LoggerFactory.getLogger(InventoryCostCenterManageDao.class);

	@Autowired
	EntityManager em;
	
	
	/*
	 * for add Assign Asset
	 */
	public ResponseEntity<JsonResponse<Object>> restAddCostcenterManage(InventoryManageCostcenterModel inventoryManageCostcenterModel) {

		logger.info("Method in Dao:Add restAddCostcenterManage starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		System.out.println(" "+inventoryManageCostcenterModel.getCostCenterName());
		System.out.println(" "+inventoryManageCostcenterModel.getDescription());
		System.out.println(" "+inventoryManageCostcenterModel.getPropertyCategory());
		
		if (inventoryManageCostcenterModel.getPropertyCategoryName() == null || inventoryManageCostcenterModel.getPropertyCategoryName() =="") {
			resp.setMessage("Property category Not Selected"); validity = false; 
		} 
		else if (inventoryManageCostcenterModel.getCostCenterName() == null || inventoryManageCostcenterModel.getCostCenterName() == "") {
			resp.setMessage("CostCenter Name Cannot be left blank");
			validity = false;
		}
		else if (inventoryManageCostcenterModel.getDescription() == null || inventoryManageCostcenterModel.getDescription() == "") {
			resp.setMessage("Description Cannot be left blank");
			validity = false;
		}

		if (validity)
			try {

				if(inventoryManageCostcenterModel.getCostcenterId()==null||inventoryManageCostcenterModel.getCostcenterId()==""){
					String values = GenerateInventoryCostcenterManageParameter.getAddManageCostCenter(inventoryManageCostcenterModel);
					System.out.println(values);
					em.createNamedStoredProcedureQuery("manageCostcenter")
						.setParameter("actionType", "addManageCostcenter1")
						.setParameter("actionValue", values)
						.execute();
				}
				else{
					String values = GenerateInventoryCostcenterManageParameter.getAddManageCostCenter(inventoryManageCostcenterModel);
					System.out.println(values);
					em.createNamedStoredProcedureQuery("manageCostcenter")
						.setParameter("actionType", "updateManageCC")
						.setParameter("actionValue", values)
						.execute();
				}

			} catch (Exception e) {
				e.printStackTrace();
				try {
					String[] err = ServerValidation.geterror(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: add restAddCostcenterManage ends");

		return response;
	}

	/*
	 * for  view all manage cost center
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventoryManageCostcenterModel>>> getAllManageCostcenter(DataTableRequest request) {

		logger.info("Method in Dao: getAllManageCostcenter starts");

		List<InventoryManageCostcenterModel> costCenter = new ArrayList<InventoryManageCostcenterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		System.out.println(values);

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("manageCostcenter")
					.setParameter("actionType", "viewAllManageCC").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					InventoryManageCostcenterModel costCenters = new InventoryManageCostcenterModel(m[0], m[1],null, m[2]);
					costCenter.add(costCenters);

				}
 
				 if (x.get(0).length > 3) {
					BigInteger t = (BigInteger) x.get(0)[3];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<InventoryManageCostcenterModel>> resp = new JsonResponse<List<InventoryManageCostcenterModel>>();
		resp.setBody(costCenter);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<InventoryManageCostcenterModel>>> response = new ResponseEntity<JsonResponse<List<InventoryManageCostcenterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getAllManageCostcenter ends");

		return response;
	}

	/*
	 * for edit manage cost center
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryManageCostcenterModel>> getManageCostcenter(String id) {

		logger.info("Method in Dao: getThemeById ends");

		List<InventoryManageCostcenterModel> inventoryManageCostcenterModel = new ArrayList<InventoryManageCostcenterModel>();

		try {

			String value = "SET @p_costcenterId='" + id + "';";
System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("manageCostcenter")
					.setParameter("actionType", "findById").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				InventoryManageCostcenterModel costcenter = new InventoryManageCostcenterModel(m[0], m[1], m[2], m[3]);

				inventoryManageCostcenterModel.add(costcenter);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<InventoryManageCostcenterModel> resp = new JsonResponse<InventoryManageCostcenterModel>();
		resp.setBody(inventoryManageCostcenterModel.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<InventoryManageCostcenterModel>> response = new ResponseEntity<JsonResponse<InventoryManageCostcenterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getThemeById ends");

		return response;
	}


	/*
	 * for delete manage Costcenter
	 */
	public ResponseEntity<JsonResponse<Object>> deleteManageCostcenter(String id) {

		logger.info("Method in DAO:manageCostcenter Starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_costcenterId='" + id + "';";
			System.out.println(value);
			em.createNamedStoredProcedureQuery("manageCostcenter").setParameter("actionType", "deleteManageCC")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();

			String[] err = ServerValidation.geterror(e);
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in DAO: manageCostcenter ends");

		return response;
	}
	
	/*
	 * for modal view of assign asset
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryManageCostcenterModel>> getManageCostcenterModal(String id) {

		logger.info("Method in Dao: getManageCostcenterModal Starts");

		List<InventoryManageCostcenterModel> inventoryManageCostcenterModelList = new ArrayList<InventoryManageCostcenterModel>();

		try {

			String value = "SET @p_costcenterId='" + id +  "';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("manageCostcenter")
					.setParameter("actionType", "ManageCCModal").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				InventoryManageCostcenterModel Costcenter = new InventoryManageCostcenterModel(m[0], m[1], m[2], m[3]);
				inventoryManageCostcenterModelList.add(Costcenter);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<InventoryManageCostcenterModel> resp = new JsonResponse<InventoryManageCostcenterModel>();
		resp.setBody(inventoryManageCostcenterModelList.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<InventoryManageCostcenterModel>> response = new ResponseEntity<JsonResponse<InventoryManageCostcenterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getManageCostcenterModal ends");

		return response;
	}


}
