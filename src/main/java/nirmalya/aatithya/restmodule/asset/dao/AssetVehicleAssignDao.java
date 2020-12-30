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

import nirmalya.aatithya.restmodule.asset.model.AssetVehicleModel;
import nirmalya.aatithya.restmodule.asset.model.ItemAssetModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAssignAssetVehicleParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class AssetVehicleAssignDao {
	
	Logger logger = LoggerFactory.getLogger(AssetVehicleAssignDao.class);
	
	@Autowired
	ServerDao serverDao;
	
	@Autowired
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStoreForAssign() {
		logger.info("Method : getStoreForAssign starts");
		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetVehicleRoutines")
					.setParameter("actionType", "getStore").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getStoreForAssign end");
		return itemList;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ItemAssetModel>>> getVehicleDetailsForAssign(DropDownModel id) {
		logger.info("Method : getVehicleDetailsForAssign Dao starts");

		List<ItemAssetModel> vehicle = new ArrayList<ItemAssetModel>();
		JsonResponse<List<ItemAssetModel>> resp = new JsonResponse<List<ItemAssetModel>>();

		try {
			String value = "SET @p_searchValue='" + id.getKey() + "' ,@p_store='" +id.getName() + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetVehicleRoutines")
					.setParameter("actionType", "getVehicleDtls")
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				ItemAssetModel dropDownModel = new ItemAssetModel(m[0], m[1], m[2]);
				vehicle.add(dropDownModel);
			}

			resp.setBody(vehicle);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<ItemAssetModel>>> response = new ResponseEntity<JsonResponse<List<ItemAssetModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getVehicleDetailsForAssign Dao ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVehicleForReport(String id) {
		logger.info("Method : getVehicleForReport Dao starts");

		List<DropDownModel> vehicle = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_searchValue='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetVehicleRoutines")
					.setParameter("actionType", "getVehicleForReport")
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				vehicle.add(dropDownModel);
			}

			resp.setBody(vehicle);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getVehicleForReport Dao ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ItemAssetModel>>> getAssetForAssign(String id) {
		logger.info("Method : getAssetForAssign Dao starts");
		
		List<ItemAssetModel> asset = new ArrayList<ItemAssetModel>();
		JsonResponse<List<ItemAssetModel>> resp = new JsonResponse<List<ItemAssetModel>>();
		
		try {
			String value = "SET @p_searchValue='" + id + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetVehicleRoutines")
					.setParameter("actionType", "getAssetDtls")
					.setParameter("actionValue", value)
					.getResultList();
			
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
		
		logger.info("Method : getAssetForAssign Dao ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> assignAssetToVehicle(List<AssetVehicleModel> assignedAsset) {
		logger.info("Method : entryNewGatePass starts");
		
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (AssetVehicleModel l : assignedAsset) {
			
			if (l.getStore() == null || l.getStore() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Store Required");
				break;
			} else if (l.getVehicleNo() == null || l.getVehicleNo() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Vehicle Number Required");
				break;
			} else if (l.getVehicleAssetId() == null || l.getVehicleAssetId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Vehicle Asset ID Required");
				break;
			} else if (l.getSerialNo() == null || l.getSerialNo() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Serial Number Required");
				break;
			} else if (l.getAssignKM() == null) {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Assign KM Required");
				break;
			} else if (l.getAssignDate() == null || l.getAssignDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Assign Date Required");
				break;
			} else if (l.getAssetId() == null || l.getAssetId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Asset ID Required");
				break;
			}
		}
		if (validity) {
			try {
				String values = GenerateAssignAssetVehicleParameter.assignAssetToVehicle(assignedAsset);
					em.createNamedStoredProcedureQuery("assignAssetVehicleRoutines")
					.setParameter("actionType", "assignAsset")
					.setParameter("actionValue", values)
					.execute();
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
		
		logger.info("Method : entryNewGatePass ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AssetVehicleModel>>> getAssignedAssetVehicleDetails(DataTableRequest request) {
		logger.info("Method : getAssignedAssetVehicleDetails starts");
		
		List<AssetVehicleModel> assignedAsset = new ArrayList<AssetVehicleModel>();
		if(request.getParam4()!=null && request.getParam4()!="") {
			String param4 = DateFormatter.getStringDate(request.getParam4());
			request.setParam4(param4);
		}
		if(request.getParam5()!=null && request.getParam5()!="") {
			String param5 = DateFormatter.getStringDate(request.getParam5());
			request.setParam5(param5);
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetVehicleRoutines")
					.setParameter("actionType", "getAssignedAsset")
					.setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				Object assignDate = null;
				Object removeDate = null;
				if(m[8]!=null) {
					assignDate = DateFormatter.returnStringDate(m[8]);
				}
				if(m[9]!=null) {
					removeDate = DateFormatter.returnStringDate(m[9]);
				}
				
				AssetVehicleModel gp = new AssetVehicleModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],assignDate,removeDate,
						m[10],m[11],m[12],null,m[13]);
				assignedAsset.add(gp);
			}
			if(x.size()>0) {
				if (x.get(0).length > 14) {
					BigInteger t = (BigInteger) x.get(0)[14];
	
					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<AssetVehicleModel>> resp = new JsonResponse<List<AssetVehicleModel>>();
		resp.setBody(assignedAsset);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AssetVehicleModel>>> response = new ResponseEntity<JsonResponse<List<AssetVehicleModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getAssignedAssetVehicleDetails ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public List<AssetVehicleModel> editAssignedAsset(String id, String vehicleAsset) {
		logger.info("Method : editAssignedAsset starts");
		
		List<AssetVehicleModel> assignedAsset = new ArrayList<AssetVehicleModel>();
		String value = "SET @p_assetId='" + id + "', @p_vehicleAsset='" + vehicleAsset + "';"; 
		System.out.println(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetVehicleRoutines")
					.setParameter("actionType", "AssignedAssetEdit")
					.setParameter("actionValue", value)
					.getResultList();
			
			for (Object[] m : x) {
				Object assignDate = null;
				Object removeDate = null;
				if(m[8]!=null) {
					assignDate = DateFormatter.returnStringDate(m[8]);
				}
				if(m[9]!=null) {
					removeDate = DateFormatter.returnStringDate(m[9]);
				}
				
				AssetVehicleModel gp = new AssetVehicleModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],assignDate,removeDate,
						m[10],m[11],m[12],"2",null);
				assignedAsset.add(gp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editAssignedAsset ends");
		return assignedAsset;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AssetVehicleModel>>> getAssignedAssetForView(String id) {
		logger.info("Method : getAssignedAssetForView Dao starts");
		
		List<AssetVehicleModel> assignedAsset = new ArrayList<AssetVehicleModel>();
		JsonResponse<List<AssetVehicleModel>> resp = new JsonResponse<List<AssetVehicleModel>>();
		
		try {
			String value = "SET @p_vehicleAsset='" + id + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetVehicleRoutines")
					.setParameter("actionType", "AssignedAssetEdit")
					.setParameter("actionValue", value)
					.getResultList();
			
			for (Object[] m : x) {
				Object assignDate = null;
				Object removeDate = null;
				if(m[8]!=null) {
					assignDate = DateFormatter.returnStringDate(m[8]);
				}
				if(m[9]!=null) {
					removeDate = DateFormatter.returnStringDate(m[9]);
				}
				
				AssetVehicleModel gp = new AssetVehicleModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],assignDate,removeDate,
						m[10],m[11],m[12],null,null);
				assignedAsset.add(gp);
			}
			
			resp.setBody(assignedAsset);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<List<AssetVehicleModel>>> response = new ResponseEntity<JsonResponse<List<AssetVehicleModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAssignedAssetForView Dao ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> changeAssignStatus(AssetVehicleModel dd) {
		logger.info("Method : changeAssignStatus Dao starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String value = "SET @p_assetId='" + dd.getAssetId() + "', @p_vehicleAsset='" + dd.getVehicleAssetId() 
							+ "', @p_removeDate='" + DateFormatter.getStringDate(dd.getRemoveDate()) 
							+ "', @p_removeKM=" + dd.getRemoveKM() + ",@p_comment='" + dd.getComment() +"';"; 
			System.out.println(value);
			em.createNamedStoredProcedureQuery("assignAssetVehicleRoutines")
			.setParameter("actionType", "changeStatus")
			.setParameter("actionValue", value)
			.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : changeAssignStatus Dao ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AssetVehicleModel>>> getVehicleAssetSummaryReportForPreview(DataTableRequest request) {
		logger.info("Method : RESTMODULE getVehicleAssetSummaryReportForPreview starts");
		List<AssetVehicleModel> form = new ArrayList<AssetVehicleModel>();

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

			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetVehicleRoutines")
					.setParameter("actionType", "getVehAssetSummReportForPreview").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object aDate = null;
				Object rDate = null;
				if (m[4] != null) {
					aDate = DateFormatter.returnStringDate(m[4]);
				}
				if (m[5] != null) {
					rDate = DateFormatter.returnStringDate(m[5]);
				}
				AssetVehicleModel foodOrderList = new AssetVehicleModel(null,null,null, null, m[0], m[1], m[2], m[3], aDate, rDate, m[6], m[7], null, m[8], m[9]);
				form.add(foodOrderList);
			}
			if (x.size() > 0) {
				if (x.get(0).length > 10) {
					BigInteger t = (BigInteger) x.get(0)[10];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<AssetVehicleModel>> resp = new JsonResponse<List<AssetVehicleModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AssetVehicleModel>>> response = new ResponseEntity<JsonResponse<List<AssetVehicleModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		System.out.println(response);
		logger.info("Method : RESTMODULE getVehicleAssetSummaryReportForPreview end");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AssetVehicleModel>>> getVehicleAssetSummaryReportPdf(DataTableRequest request) {
		logger.info("Method : RESTMODULE getVehicleAssetSummaryReportPdf starts");
		List<AssetVehicleModel> form = new ArrayList<AssetVehicleModel>();
		
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
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetVehicleRoutines")
					.setParameter("actionType", "getVAssetSummReportPdf").setParameter("actionValue", values)
					.getResultList();
			
			for (Object[] m : x) {

				Object aDate = null;
				Object rDate = null;
				if (m[4] != null) {
					aDate = DateFormatter.returnStringDate(m[4]);
				}
				if (m[5] != null) {
					rDate = DateFormatter.returnStringDate(m[5]);
				}
				AssetVehicleModel foodOrderList = new AssetVehicleModel(null,null,null, null, m[0], m[1], m[2], m[3], aDate, rDate, m[6], m[7], null, m[8], m[9]);
				form.add(foodOrderList);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JsonResponse<List<AssetVehicleModel>> resp = new JsonResponse<List<AssetVehicleModel>>();
		resp.setBody(form);
		resp.setTotal(total);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AssetVehicleModel>>> response = new ResponseEntity<JsonResponse<List<AssetVehicleModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		System.out.println(response);
		logger.info("Method : RESTMODULE getVehicleAssetSummaryReportPdf end");
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
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AssetVehicleModel>>> getVehicleCurrentAssetReportForPreview(DataTableRequest request) {
		logger.info("Method : RESTMODULE getVehicleCurrentAssetReportForPreview starts");
		List<AssetVehicleModel> form = new ArrayList<AssetVehicleModel>();

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

			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetVehicleRoutines")
					.setParameter("actionType", "getVehCurrAsstReportForPreview").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object aDate = null;
				Object rDate = null;
				if (m[4] != null) {
					aDate = DateFormatter.returnStringDate(m[4]);
				}
				if (m[5] != null) {
					rDate = DateFormatter.returnStringDate(m[5]);
				}
				AssetVehicleModel foodOrderList = new AssetVehicleModel(null,null,null, null, m[0], m[1], m[2], m[3], aDate, rDate, m[6], m[7], null, m[8], m[9]);
				form.add(foodOrderList);
			}
			if (x.size() > 0) {
				if (x.get(0).length > 10) {
					BigInteger t = (BigInteger) x.get(0)[10];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<AssetVehicleModel>> resp = new JsonResponse<List<AssetVehicleModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AssetVehicleModel>>> response = new ResponseEntity<JsonResponse<List<AssetVehicleModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		System.out.println(response);
		logger.info("Method : RESTMODULE getVehicleAssetSummaryReportForPreview end");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AssetVehicleModel>>> getVehicleCurrentAssetReportPdf(DataTableRequest request) {
		logger.info("Method : RESTMODULE getVehicleCurrentAssetReportPdf starts");
		List<AssetVehicleModel> form = new ArrayList<AssetVehicleModel>();
		
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
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetVehicleRoutines")
					.setParameter("actionType", "getVAssetCurrReportPdf").setParameter("actionValue", values)
					.getResultList();
			
			for (Object[] m : x) {

				Object aDate = null;
				Object rDate = null;
				if (m[4] != null) {
					aDate = DateFormatter.returnStringDate(m[4]);
				}
				if (m[5] != null) {
					rDate = DateFormatter.returnStringDate(m[5]);
				}
				AssetVehicleModel foodOrderList = new AssetVehicleModel(null,null,null, null, m[0], m[1], m[2], m[3], aDate, rDate, m[6], m[7], null, m[8], m[9]);
				form.add(foodOrderList);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JsonResponse<List<AssetVehicleModel>> resp = new JsonResponse<List<AssetVehicleModel>>();
		resp.setBody(form);
		resp.setTotal(total);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AssetVehicleModel>>> response = new ResponseEntity<JsonResponse<List<AssetVehicleModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		System.out.println(response);
		logger.info("Method : RESTMODULE getVehicleCurrentAssetReportPdf end");
		return response;
	}
}
