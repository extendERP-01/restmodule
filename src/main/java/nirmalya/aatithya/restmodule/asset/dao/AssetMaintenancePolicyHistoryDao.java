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

import nirmalya.aatithya.restmodule.asset.model.AssetMaintenanceHistoryModel;
import nirmalya.aatithya.restmodule.asset.model.AssetPolicyMaster;
import nirmalya.aatithya.restmodule.asset.model.ItemAssetModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateMainHistoryPolicyParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class AssetMaintenancePolicyHistoryDao {

	Logger logger = LoggerFactory.getLogger(AssetMaintenancePolicyHistoryDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ItemAssetModel>>> getAssetCodeAutoSearch(String id) {
		logger.info("Method : getAssetCodeAutoSearch Dao starts");

		List<ItemAssetModel> asset = new ArrayList<ItemAssetModel>();
		JsonResponse<List<ItemAssetModel>> resp = new JsonResponse<List<ItemAssetModel>>();

		try {
			String value = "SET @p_searchValue='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetMaintenanceHistory")
					.setParameter("actionType", "getAssetCodeDtls").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				ItemAssetModel dropDownModel = new ItemAssetModel(m[0], m[1], m[2]);
				asset.add(dropDownModel);
			}

			resp.setBody(asset);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<ItemAssetModel>>> response = new ResponseEntity<JsonResponse<List<ItemAssetModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println(response);
		logger.info("Method : getAssetCodeAutoSearch Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AssetPolicyMaster>>> getMaintenanceDetailsByAsset(String id) {
		logger.info("Method : getMaintenanceDetailsByAsset Dao starts");

		List<AssetPolicyMaster> asset = new ArrayList<AssetPolicyMaster>();
		JsonResponse<List<AssetPolicyMaster>> resp = new JsonResponse<List<AssetPolicyMaster>>();

		try {
			String value = "SET @p_searchValue='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetMaintenanceHistory")
					.setParameter("actionType", "getMaintenanceDtls").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				AssetPolicyMaster dropDownModel = new AssetPolicyMaster(m[0], null, null, m[1], m[2], m[3], m[4],m[5],m[6],m[7]);
				asset.add(dropDownModel);
			}

			resp.setBody(asset);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<AssetPolicyMaster>>> response = new ResponseEntity<JsonResponse<List<AssetPolicyMaster>>>(
				resp, HttpStatus.CREATED);
		System.out.println(response);
		logger.info("Method : getMaintenanceDetailsByAsset Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> addMaintenanceHistory(AssetMaintenanceHistoryModel mainHistory) {
		logger.info("Method : addMaintenanceHistory starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (mainHistory.getAssetCode() == null || mainHistory.getAssetCode() == "") {
			validity = false;
			resp.setCode("Field Validation Error");
			resp.setMessage("Asset Code Required");
		} else if (mainHistory.getDesc() == null || mainHistory.getDesc() == "") {
			validity = false;
			resp.setCode("Field Validation Error");
			resp.setMessage("Description Required");
		} else if (mainHistory.getPerformedDate() == null || mainHistory.getPerformedDate() == "") {
			validity = false;
			resp.setCode("Field Validation Error");
			resp.setMessage("Perform Date Required");
		} else if (mainHistory.getPrice() == null) {
			validity = false;
			resp.setCode("Field Validation Error");
			resp.setMessage("Price Required");
		}
		List<DropDownModel> ddList = new ArrayList<DropDownModel>();
		if (validity) {
			try {
				String values = GenerateMainHistoryPolicyParameter.addMainHistoryPolicy(mainHistory);
				List<Object[]> x = em.createNamedStoredProcedureQuery("assetMaintenanceHistory")
						.setParameter("actionType", "getHistoryDtls").setParameter("actionValue", values)
						.getResultList();
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					ddList.add(dropDownModel);
				}
				if(ddList.size()>0) {
					em.createNamedStoredProcedureQuery("assetMaintenanceHistory")
					.setParameter("actionType", "modifyHistory").setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("assetMaintenanceHistory")
					.setParameter("actionType", "addHistory").setParameter("actionValue", values).execute();
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

		logger.info("Method : addMaintenanceHistory ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AssetMaintenanceHistoryModel>>> getMaintenanceReportForPreview(DataTableRequest request) {
		logger.info("Method : RESTMODULE getMaintenanceReportForPreview starts");
		List<AssetMaintenanceHistoryModel> form = new ArrayList<AssetMaintenanceHistoryModel>();

		String param3 = request.getParam3();
		String param2 = request.getParam2();
		if (param2 != null && param2 != "") {
			String frmDate = DateFormatter.getStringDate(param2);
			request.setParam2(frmDate);
		}
		if (param3 != null && param3 != "") {
			String tDate = DateFormatter.getStringDate(param3);
			request.setParam3(tDate);
		}

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("assetMaintenanceHistory")
					.setParameter("actionType", "getMaintenanceReportForPreview").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object pDate = null;
				Object nPDate = null;
				if (m[4] != null) {
					pDate = DateFormatter.returnStringDate(m[4]);
				}
				if (m[7] != null) {
					nPDate = DateFormatter.returnStringDate(m[7]);
				}
				AssetMaintenanceHistoryModel foodOrderList = new AssetMaintenanceHistoryModel(m[0],null,m[1],m[2],m[3],pDate,null,m[5],m[6],nPDate,null,null,null);
				form.add(foodOrderList);
			}
			if (x.size() > 0) {
				if (x.get(0).length > 8) {
					BigInteger t = (BigInteger) x.get(0)[8];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<AssetMaintenanceHistoryModel>> resp = new JsonResponse<List<AssetMaintenanceHistoryModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AssetMaintenanceHistoryModel>>> response = new ResponseEntity<JsonResponse<List<AssetMaintenanceHistoryModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		System.out.println(response);
		logger.info("Method : RESTMODULE getMaintenanceReportForPreview end");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AssetMaintenanceHistoryModel>>> getMaintenanceReportPdf(DataTableRequest request) {
		logger.info("Method : RESTMODULE getMaintenanceReportPdf starts");
		List<AssetMaintenanceHistoryModel> form = new ArrayList<AssetMaintenanceHistoryModel>();
		
		String param3 = request.getParam3();
		String param2 = request.getParam2();
		if (param2 != null && param2 != "") {
			String frmDate = DateFormatter.getStringDate(param2);
			request.setParam2(frmDate);
		}
		if (param3 != null && param3 != "") {
			String tDate = DateFormatter.getStringDate(param3);
			request.setParam3(tDate);
		}
		
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetMaintenanceHistory")
					.setParameter("actionType", "getMaintenanceReportPdf").setParameter("actionValue", values)
					.getResultList();
			
			for (Object[] m : x) {
				
				Object pDate = null;
				Object nPDate = null;
				if (m[4] != null) {
					pDate = DateFormatter.returnStringDate(m[4]);
				}
				if (m[7] != null) {
					nPDate = DateFormatter.returnStringDate(m[7]);
				}
				AssetMaintenanceHistoryModel foodOrderList = new AssetMaintenanceHistoryModel(m[0],null,m[1],m[2],m[3],pDate,null,m[5],m[6],nPDate,null,null,null);
				form.add(foodOrderList);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JsonResponse<List<AssetMaintenanceHistoryModel>> resp = new JsonResponse<List<AssetMaintenanceHistoryModel>>();
		resp.setBody(form);
		resp.setTotal(total);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AssetMaintenanceHistoryModel>>> response = new ResponseEntity<JsonResponse<List<AssetMaintenanceHistoryModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		System.out.println(response);
		logger.info("Method : RESTMODULE getMaintenanceReportPdf end");
		return response;
	}
	
	/**
	 * DAO - Get Hotel Logo
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getHotelLogoImage(String logoType) {
		logger.info("Method : getHotelLogoImage starts");

		List<DropDownModel> logoList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_logoType='" + logoType + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("logoImageRoutines")
					.setParameter("actionType", "getHotelLogo").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				logoList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getHotelLogoImage ends");

		return logoList;
	}
}
