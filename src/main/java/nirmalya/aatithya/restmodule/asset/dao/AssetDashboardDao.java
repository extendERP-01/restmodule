package nirmalya.aatithya.restmodule.asset.dao;

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

import nirmalya.aatithya.restmodule.account.model.DataSetAccountTree;
import nirmalya.aatithya.restmodule.asset.model.AssetJobCardModel;
import nirmalya.aatithya.restmodule.asset.model.AssetMaintenanceHistoryModel;
import nirmalya.aatithya.restmodule.asset.model.AssetWithPOInventoryModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class AssetDashboardDao {

	Logger logger = LoggerFactory.getLogger(AssetDashboardDao.class);
	
	@Autowired
	ServerDao serverDao;
	
	@Autowired
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AssetJobCardModel>>> dashboardJobCard(DataTableRequest request) {
		logger.info("Method : dashboardJobCard starts");
		
		List<AssetJobCardModel> assignedAsset = new ArrayList<AssetJobCardModel>();
		
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetVehicleRoutines")
					.setParameter("actionType", "dashboardJobCard")
					.setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				Object date = null;
				Object time = null;
				if(m[2]!=null) {
					date = DateFormatter.returnStringDate(m[2]);
				}
				if(m[3]!=null) {
					time = DateFormatter.returnStringTime(m[3]);
				}
				
				AssetJobCardModel gp = new AssetJobCardModel(m[0],m[1],date,time,null,null,null,m[4],null,null,m[5],
						m[6],null,null,null,null,null,null,null,null,null,null);
				assignedAsset.add(gp);
			}
			if(x.size()>0) {
				if (x.get(0).length > 7) {
					BigInteger t = (BigInteger) x.get(0)[7];
					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<AssetJobCardModel>> resp = new JsonResponse<List<AssetJobCardModel>>();
		resp.setBody(assignedAsset);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AssetJobCardModel>>> response = new ResponseEntity<JsonResponse<List<AssetJobCardModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : dashboardJobCard ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AssetMaintenanceHistoryModel>>> dashboardMaintenance(DataTableRequest request) {
		logger.info("Method : dashboardMaintenance starts");
		
		List<AssetMaintenanceHistoryModel> assignedAsset = new ArrayList<AssetMaintenanceHistoryModel>();
		
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		
		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetVehicleRoutines")
					.setParameter("actionType", "dashboardMaintenance")
					.setParameter("actionValue", values)
					.getResultList();
			
			for (Object[] m : x) {
				Object date = null;
				if(m[4]!=null) {
					date = DateFormatter.returnStringDate(m[4]);
				}
				
				AssetMaintenanceHistoryModel gp = new AssetMaintenanceHistoryModel(m[0],null,m[1],null,null,null,null,m[2],m[3],date,m[5],m[6],null);
				assignedAsset.add(gp);
			}
			if(x.size()>0) {
				if (x.get(0).length > 7) {
					BigInteger t = (BigInteger) x.get(0)[7];
					total = Integer.parseInt((t.toString()));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonResponse<List<AssetMaintenanceHistoryModel>> resp = new JsonResponse<List<AssetMaintenanceHistoryModel>>();
		resp.setBody(assignedAsset);
		resp.setTotal(total);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AssetMaintenanceHistoryModel>>> response = new ResponseEntity<JsonResponse<List<AssetMaintenanceHistoryModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		System.out.println(response);
		logger.info("Method : dashboardMaintenance ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DataSetAccountTree>>> getAssetTreeDetails(String getAssetTreeDetails) {
		logger.info("Method : DAO getAssetTreeDetails starts");

		List<DataSetAccountTree> DataSetAccountTree = new ArrayList<DataSetAccountTree>();

		try {
			String value = "SET @p_activityName=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("AccountBankAccountRoutines")
					.setParameter("actionType", getAssetTreeDetails).setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DataSetAccountTree DataSetForActivityConstructor = new DataSetAccountTree(m[0], m[1], m[2], m[3], m[4]);
				DataSetAccountTree.add(DataSetForActivityConstructor);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<DataSetAccountTree>> resp = new JsonResponse<List<DataSetAccountTree>>();
		resp.setBody(DataSetAccountTree);

		ResponseEntity<JsonResponse<List<DataSetAccountTree>>> response = new ResponseEntity<JsonResponse<List<DataSetAccountTree>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : DAO getAssetTreeDetails ends");
		System.out.print(response);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AssetWithPOInventoryModel>>> getAllLinkedAssets(DataTableRequest request) {
		logger.info("Method : getAllLinkedAssets starts");
		
		List<AssetWithPOInventoryModel> assignedDriver = new ArrayList<AssetWithPOInventoryModel>();
		if(request.getParam4()!=null && request.getParam4()!="") {
			String param4 = DateFormatter.getStringDate(request.getParam4());
			request.setParam4(param4);
		}
		if(request.getParam3()!=null && request.getParam3()!="") {
			String param3 = DateFormatter.getStringDate(request.getParam3());
			request.setParam3(param3);
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetVehicleRoutines")
					.setParameter("actionType", "getAllLinkedAssets")
					.setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				Object assignDate = null;
				if(m[5]!=null) {
					assignDate = DateFormatter.returnStringDate(m[5]);
				}
				AssetWithPOInventoryModel gp = new AssetWithPOInventoryModel(m[0],m[1],m[2],m[3],m[4],assignDate,m[6],null,null,null,null,null);
				assignedDriver.add(gp);
			}
			if(x.size()>0) {
				if (x.get(0).length > 8) {
					BigInteger t = (BigInteger) x.get(0)[8];
					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<AssetWithPOInventoryModel>> resp = new JsonResponse<List<AssetWithPOInventoryModel>>();
		resp.setBody(assignedDriver);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AssetWithPOInventoryModel>>> response = new ResponseEntity<JsonResponse<List<AssetWithPOInventoryModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getAllLinkedAssets ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AssetWithPOInventoryModel>>> getAllAssetsWithVendor(DataTableRequest request) {
		logger.info("Method : getAllAssetsWithVendor starts");
		
		List<AssetWithPOInventoryModel> assignedDriver = new ArrayList<AssetWithPOInventoryModel>();
		if(request.getParam4()!=null && request.getParam4()!="") {
			String param4 = DateFormatter.getStringDate(request.getParam4());
			request.setParam4(param4);
		}
		if(request.getParam3()!=null && request.getParam3()!="") {
			String param3 = DateFormatter.getStringDate(request.getParam3());
			request.setParam3(param3);
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		
		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetVehicleRoutines")
					.setParameter("actionType", "getAllAssetsWithVendor")
					.setParameter("actionValue", values)
					.getResultList();
			
			for (Object[] m : x) {
				
				AssetWithPOInventoryModel gp = new AssetWithPOInventoryModel(m[0],m[1],m[2],m[3],null,null,null,null,m[4],m[5],null,m[6]);
				assignedDriver.add(gp);
			}
			if(x.size()>0) {
				if (x.get(0).length > 7) {
					BigInteger t = (BigInteger) x.get(0)[7];
					total = Integer.parseInt((t.toString()));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonResponse<List<AssetWithPOInventoryModel>> resp = new JsonResponse<List<AssetWithPOInventoryModel>>();
		resp.setBody(assignedDriver);
		resp.setTotal(total);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AssetWithPOInventoryModel>>> response = new ResponseEntity<JsonResponse<List<AssetWithPOInventoryModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getAllAssetsWithVendor ends");
		return response;
	}
}
