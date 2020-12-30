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

import nirmalya.aatithya.restmodule.asset.model.AssignVehicleToDriverModel;
import nirmalya.aatithya.restmodule.asset.model.ItemAssetModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAssignVehicleDriverParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class AssignVehcicleToDriverDao {

	Logger logger = LoggerFactory.getLogger(AssignVehcicleToDriverDao.class);
	
	@Autowired
	ServerDao serverDao;
	
	@Autowired
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDriverAutoSearch(String id) {
		logger.info("Method : getDriverAutoSearch Dao starts");
		
		List<DropDownModel> asset = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		
		try {
			String value = "SET @p_searchValue='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignVehicleDriverRoutines")
					.setParameter("actionType", "getEmplDtls")
					.setParameter("actionValue", value)
					.getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				asset.add(dropDownModel);
			}
			
			resp.setBody(asset);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getDriverAutoSearch Dao ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ItemAssetModel>>> getVehicleAutoSearchList(String id) {
		logger.info("Method : getVehicleAutoSearchList Dao starts");
		
		List<ItemAssetModel> asset = new ArrayList<ItemAssetModel>();
		JsonResponse<List<ItemAssetModel>> resp = new JsonResponse<List<ItemAssetModel>>();
		
		try {
			String value = "SET @p_searchValue='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignVehicleDriverRoutines")
					.setParameter("actionType", "getVehicleDtls")
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
		
		logger.info("Method : getVehicleAutoSearchList Dao ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ItemAssetModel>>> getVehicleAutoSearchListForSearch(String id) {
		logger.info("Method : getVehicleAutoSearchListForSearch Dao starts");
		
		List<ItemAssetModel> asset = new ArrayList<ItemAssetModel>();
		JsonResponse<List<ItemAssetModel>> resp = new JsonResponse<List<ItemAssetModel>>();
		
		try {
			String value = "SET @p_searchValue='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignVehicleDriverRoutines")
					.setParameter("actionType", "getVehicleDtlsForSearch")
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
		System.out.println(response);
		logger.info("Method : getVehicleAutoSearchListForSearch Dao ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> assignAssetToVehicle(List<AssignVehicleToDriverModel> assignedDriver) {
		logger.info("Method : assignAssetToVehicle starts");
		
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (AssignVehicleToDriverModel l : assignedDriver) {
			
			if (l.getDriverId() == null || l.getDriverId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Driver Name Required");
				break;
			} else if (l.getVehicleNo() == null || l.getVehicleNo() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Vehicle Number Required");
				break;
			} else if (l.getvAssetId() == null || l.getvAssetId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Vehicle Asset ID Required");
				break;
			} else if (l.getAssignDate() == null || l.getAssignDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Assign Date Required");
				break;
			}
		}
		if (validity) {
			try {
				String values = GenerateAssignVehicleDriverParameter.assignVehicleToDriver(assignedDriver);
					em.createNamedStoredProcedureQuery("assignVehicleDriverRoutines")
					.setParameter("actionType", "assignVehicle")
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
		
		logger.info("Method : assignAssetToVehicle ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AssignVehicleToDriverModel>>> getAssignedVehicleDriverDetails(DataTableRequest request) {
		logger.info("Method : getAssignedVehicleDriverDetails starts");
		
		List<AssignVehicleToDriverModel> assignedDriver = new ArrayList<AssignVehicleToDriverModel>();
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

			List<Object[]> x = em.createNamedStoredProcedureQuery("assignVehicleDriverRoutines")
					.setParameter("actionType", "getAssignedDriver")
					.setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				Object assignDate = null;
				Object createdOnDate = null;
				Object createdOnTime = null;
				if(m[5]!=null) {
					assignDate = DateFormatter.returnStringDate(m[5]);
				}
				if(m[8]!=null) {
					createdOnDate = DateFormatter.returnStringDate(m[8]);
				}
				if(m[9]!=null) {
					createdOnTime = DateFormatter.returnStringTimeHMS(m[9]);
				}
				
				AssignVehicleToDriverModel gp = new AssignVehicleToDriverModel(m[0],m[1],m[2],m[3],m[4],assignDate,m[6],m[7],null,null,createdOnDate,createdOnTime,m[10],null);
				assignedDriver.add(gp);
			}
			if(x.size()>0) {
				if (x.get(0).length > 10) {
					BigInteger t = (BigInteger) x.get(0)[10];
					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<AssignVehicleToDriverModel>> resp = new JsonResponse<List<AssignVehicleToDriverModel>>();
		resp.setBody(assignedDriver);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AssignVehicleToDriverModel>>> response = new ResponseEntity<JsonResponse<List<AssignVehicleToDriverModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getAssignedVehicleDriverDetails ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> changeAssignedDriverStatus(AssignVehicleToDriverModel dd) {
		logger.info("Method : changeAssignedDriverStatus Dao starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String value = "SET @p_driverId='" + dd.getDriverId() + "', @p_vehicleAsset='" + dd.getvAssetId() 
							+ "', @p_removeDate='" + DateFormatter.getStringDate(dd.getRemoveDate()) 
							+ "', @p_createdTime='" + dd.getCreatedOnTime()
							+ "', @p_createdDate='" + DateFormatter.getStringDate(dd.getCreatedOnDate())  + "' ,@p_comment='" + dd.getComment() + "', @p_removedWt=" + dd.getRemovedWt() +";"; 
			System.out.println(value);
			em.createNamedStoredProcedureQuery("assignVehicleDriverRoutines")
			.setParameter("actionType", "changeStatus")
			.setParameter("actionValue", value)
			.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : changeAssignedDriverStatus Dao ends");
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
	public ResponseEntity<JsonResponse<List<AssignVehicleToDriverModel>>> getVehicleDriverReportForPreview(DataTableRequest request) {
		logger.info("Method : RESTMODULE getVehicleDriverReportForPreview starts");
		List<AssignVehicleToDriverModel> form = new ArrayList<AssignVehicleToDriverModel>();

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

			List<Object[]> x = em.createNamedStoredProcedureQuery("assignVehicleDriverRoutines")
					.setParameter("actionType", "getVehDriverReportForPreview").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				Object aDate = null;
				Object rDate = null;
				if(m[2]!=null) {
					aDate = DateFormatter.returnStringDate(m[2]);
				}
				if(m[4]!=null) {
					rDate = DateFormatter.returnStringDate(m[4]);
				}
				AssignVehicleToDriverModel foodOrderList = new AssignVehicleToDriverModel(null,m[0],null,m[1],null,aDate,m[3],null,rDate,m[5],null,null,m[6],m[7]);
				form.add(foodOrderList);
			}
			if (x.size() > 0) {
				if (x.get(0).length > 15) {
					BigInteger t = (BigInteger) x.get(0)[15];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<AssignVehicleToDriverModel>> resp = new JsonResponse<List<AssignVehicleToDriverModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AssignVehicleToDriverModel>>> response = new ResponseEntity<JsonResponse<List<AssignVehicleToDriverModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		System.out.println(response);
		logger.info("Method : RESTMODULE getVehicleDriverReportForPreview end");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AssignVehicleToDriverModel>>> getVehicleDriverReportPdf(DataTableRequest request) {
		logger.info("Method : RESTMODULE getVehicleDriverReportPdf starts");
		List<AssignVehicleToDriverModel> form = new ArrayList<AssignVehicleToDriverModel>();
		
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
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignVehicleDriverRoutines")
					.setParameter("actionType", "getVehDriverReportPdf").setParameter("actionValue", values)
					.getResultList();
			
			for (Object[] m : x) {
				Object aDate = null;
				Object rDate = null;
				if(m[2]!=null) {
					aDate = DateFormatter.returnStringDate(m[2]);
				}
				if(m[4]!=null) {
					rDate = DateFormatter.returnStringDate(m[4]);
				}
				AssignVehicleToDriverModel foodOrderList = new AssignVehicleToDriverModel(null,m[0],null,m[1],null,aDate,m[3],null,rDate,m[5],null,null,m[6],m[7]);
				form.add(foodOrderList);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JsonResponse<List<AssignVehicleToDriverModel>> resp = new JsonResponse<List<AssignVehicleToDriverModel>>();
		resp.setBody(form);
		resp.setTotal(total);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AssignVehicleToDriverModel>>> response = new ResponseEntity<JsonResponse<List<AssignVehicleToDriverModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		System.out.println(response);
		logger.info("Method : RESTMODULE getVehicleDriverReportPdf end");
		return response;
	}
}
