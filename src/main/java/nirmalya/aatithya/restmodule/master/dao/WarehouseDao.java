package nirmalya.aatithya.restmodule.master.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateLocationMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateWareHouseMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.LocationMasterModel;
import nirmalya.aatithya.restmodule.master.model.LocationSectionModel;
import nirmalya.aatithya.restmodule.master.model.WareHouseModel;
import nirmalya.aatithya.restmodule.master.model.ZoneMasterModel;
import nirmalya.aatithya.restmodule.master.model.ZoneRackModel;
@Repository
public class WarehouseDao {

	Logger logger = LoggerFactory.getLogger(WarehouseDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<WareHouseModel>>> getLocationDetails(String id) {

		logger.info("Method : getLocationDetails starts");
		List<WareHouseModel> locationList = new ArrayList<WareHouseModel>();
		JsonResponse<List<WareHouseModel>> resp = new JsonResponse<List<WareHouseModel>>();

		String value = "SET @p_locationId='" + id + "';";
		System.out.println(value);
		try {
			
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
					.setParameter("actionType", "getWarehouseList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				WareHouseModel wareHouseModel = new WareHouseModel(m[0], m[1],m[2],m[3]);
				locationList.add(wareHouseModel);
			}

			resp.setBody(locationList);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<WareHouseModel>>> response = new ResponseEntity<JsonResponse<List<WareHouseModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getLocationDetails ends");
		System.out.println("response"+response);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getWarehouseLocationList() {
		logger.info("Method : getWarehouseLocationList starts");

		List<DropDownModel> locationList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
					.setParameter("actionType", "getWhLocationList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				locationList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getWarehouseLocationList ends");
		return locationList;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ZoneMasterModel>> saveZoneMaster(ZoneMasterModel zoneMasterModel) {
		logger.info("Method : saveZoneMaster starts");

		Boolean validity = true;
		JsonResponse<ZoneMasterModel> resp = new JsonResponse<ZoneMasterModel>();
		resp.setMessage("");
		resp.setCode("");
		
		List<ZoneMasterModel> zoneData = new ArrayList<ZoneMasterModel>();

		if (zoneMasterModel.getZoneCode() == null || zoneMasterModel.getZoneCode() == "") {
			resp.setMessage("Zone Code Required");
			validity = false;
		} else if (zoneMasterModel.getZoneName() == null || zoneMasterModel.getZoneName() == "") {
			resp.setMessage("Zone Name Required");
			validity = false;
		
		}
		if (validity)
			try {
				String values = GenerateWareHouseMasterParameter.saveZoneMaster(zoneMasterModel);
				if (zoneMasterModel.getZoneId() != null && zoneMasterModel.getZoneId() != "") {
			
					List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
							.setParameter("actionType", "modifyZone").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						ZoneMasterModel zoneMasterModelList = new ZoneMasterModel(m[0], m[1], m[2],m[3],m[4]);
						zoneData.add(zoneMasterModelList);
					}
				} else {
				
					List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
							.setParameter("actionType", "addZone").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						ZoneMasterModel zoneMasterModelList = new ZoneMasterModel(m[0], m[1], m[2],m[3],m[4]);
						zoneData.add(zoneMasterModelList);
					}

				}

				resp.setBody(zoneData.get(0));
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

		ResponseEntity<JsonResponse<ZoneMasterModel>> response = new ResponseEntity<JsonResponse<ZoneMasterModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveZoneMaster ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<List<ZoneMasterModel>>> getZoneDetails(String id) {

		logger.info("Method : getZoneDetails starts");
		List<ZoneMasterModel> locationList = new ArrayList<ZoneMasterModel>();
		JsonResponse<List<ZoneMasterModel>> resp = new JsonResponse<List<ZoneMasterModel>>();

		String value = "SET @p_locationId='" + id + "';";
		System.out.println(value);
		try {
			
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
					.setParameter("actionType", "getZoneList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				ZoneMasterModel zoneMasterModel = new ZoneMasterModel(m[0], m[1],m[2],m[3],m[4]);
				locationList.add(zoneMasterModel);
			}

			resp.setBody(locationList);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<ZoneMasterModel>>> response = new ResponseEntity<JsonResponse<List<ZoneMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getZoneDetails ends");
		System.out.println("response"+response);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ZoneMasterModel>> editZoneMaster(String id) {
		logger.info("Method : editZoneMaster starts");

		JsonResponse<ZoneMasterModel> resp = new JsonResponse<ZoneMasterModel>();
		List<ZoneMasterModel> newZone = new ArrayList<ZoneMasterModel>();

		try {

			String value = "SET @P_Zone='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
					.setParameter("actionType", "editZone").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				ZoneMasterModel zoneMasterModel = new ZoneMasterModel(m[0], m[1], m[2], m[3],m[4]);
				newZone.add(zoneMasterModel);
			}
			
			resp.setBody(newZone.get(0));
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

		ResponseEntity<JsonResponse<ZoneMasterModel>> response = new ResponseEntity<JsonResponse<ZoneMasterModel>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : editZoneMaster ends");
		return response;
	}
	public ResponseEntity<JsonResponse<Object>> deleteZoneMaster(String id, String createdBy) {
		logger.info("Method : deleteZoneMaster starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @P_ModifiedBy='" + createdBy + "', @p_zone='" + id + "';";
				System.out.println("delete data"+value);
				em.createNamedStoredProcedureQuery("warehouseRoutine").setParameter("actionType", "deleteZone")
						.setParameter("actionValue", value).execute();

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

		logger.info("Method : deleteFloorMaster ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public List<ZoneRackModel> viewRackListByZone(String id) {
		logger.info("Method : viewRackListByZone starts");
		
		List<ZoneRackModel> rackList = new ArrayList<ZoneRackModel>();
		
		String value = "SET @P_Zone='" + id + "';";
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
					.setParameter("actionType", "getRackList").setParameter("actionValue", value).getResultList();
			
			for (Object[] m : x) {
				ZoneRackModel dropDownModel = new ZoneRackModel(m[0], m[1], m[2], m[3], m[4], m[5]);
				rackList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : viewRackListByZone ends");
		return rackList;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ZoneRackModel>> saveRackMaster(ZoneRackModel zoneRackModel) {
		logger.info("Method : saveRackMaster starts");

		Boolean validity = true;
		JsonResponse<ZoneRackModel> resp = new JsonResponse<ZoneRackModel>();
		resp.setMessage("");
		resp.setCode("");
		
		List<ZoneRackModel> rackData = new ArrayList<ZoneRackModel>();

		if (zoneRackModel.getRackName() == null || zoneRackModel.getRackName() == "") {
			resp.setMessage("Rack Name Required");
			validity = false;
		} else if (zoneRackModel.getRackCode()== null || zoneRackModel.getRackCode() == "") {
			resp.setMessage("Rack Code Required");
			validity = false;
		
		}
		if (validity)
			try {
				String values = GenerateWareHouseMasterParameter.saveRackMaster(zoneRackModel);
				System.out.println(zoneRackModel);
				if (zoneRackModel.getZoneId() != null && zoneRackModel.getZoneId() != "") {
			
					List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
							.setParameter("actionType", "addRack").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						ZoneRackModel zoneRackModelList = new ZoneRackModel(m[0], m[1], m[2],m[3],m[4],m[5]);
						rackData.add(zoneRackModelList);
					}
				} else {
				
					List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
							.setParameter("actionType", "addRack").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						ZoneRackModel zoneRackModelList = new ZoneRackModel(m[0], m[1], m[2],m[3],m[4],m[5]);
						rackData.add(zoneRackModelList);
					}

				}

				resp.setBody(rackData.get(0));
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

		ResponseEntity<JsonResponse<ZoneRackModel>> response = new ResponseEntity<JsonResponse<ZoneRackModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveRackMaster ends");
		return response;
	}
	
}
