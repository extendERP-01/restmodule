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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.LocationMasterModel;
import nirmalya.aatithya.restmodule.master.model.LocationRoomModel;
import nirmalya.aatithya.restmodule.master.model.LocationSectionModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class LocationMasterDao {

	Logger logger = LoggerFactory.getLogger(LocationMasterDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getLocationTypeList() {
		logger.info("Method : getLocationTypeList starts");

		List<DropDownModel> locationTypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
					.setParameter("actionType", "getLocationTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				locationTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getLocationTypeList ends");
		return locationTypeList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getRoomTypeList() {
		logger.info("Method : getRoomTypeList starts");
		
		List<DropDownModel> roomTypeList = new ArrayList<DropDownModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
					.setParameter("actionType", "getRoomTypeList").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				roomTypeList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getRoomTypeList ends");
		return roomTypeList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCountryListForLocation() {
		logger.info("Method : getCountryListForLocation starts");

		List<DropDownModel> locationTypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
					.setParameter("actionType", "getCountryList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				locationTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryListForLocation ends");
		return locationTypeList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> viewStateLocListByCountry(String id) {
		logger.info("Method : viewStateLocListByCountry starts");

		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		String value = "SET @P_Country='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
					.setParameter("actionType", "getStateList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : viewStateLocListByCountry ends");
		return stateList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> viewCityLocListByState(String id) {
		logger.info("Method : viewCityLocListByState starts");

		List<DropDownModel> cityList = new ArrayList<DropDownModel>();

		String value = "SET @P_State='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
					.setParameter("actionType", "getCityList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				cityList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : viewCityLocListByState ends");
		return cityList;
	}
	
	@SuppressWarnings("unchecked")
	public List<LocationSectionModel> viewSectionListByFloor(String id) {
		logger.info("Method : viewSectionListByFloor starts");
		
		List<LocationSectionModel> cityList = new ArrayList<LocationSectionModel>();
		
		String value = "SET @P_Floor='" + id + "';";
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
					.setParameter("actionType", "getSectionList").setParameter("actionValue", value).getResultList();
			
			for (Object[] m : x) {
				LocationSectionModel dropDownModel = new LocationSectionModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9]);
				cityList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : viewSectionListByFloor ends");
		return cityList;
	}
	
	@SuppressWarnings("unchecked")
	public List<LocationRoomModel> viewRoomListBySection(String id) {
		logger.info("Method : viewRoomListBySection starts");
		
		List<LocationRoomModel> roomList = new ArrayList<LocationRoomModel>();
		
		String value = "SET @P_Section='" + id + "';";
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
					.setParameter("actionType", "getRoomList").setParameter("actionValue", value).getResultList();
			
			for (Object[] m : x) {
//				Integer floorSlNo = 0;
//				Integer secSlNo = 0;
//				Integer roomSlNo = 0;
//				
//				if(m[11]!=null) {
//					BigInteger f = (BigInteger) m[11];
//					floorSlNo = Integer.parseInt((f.toString()));
//				}
//				if(m[12]!=null) {
//					BigInteger s = (BigInteger) m[12];
//					secSlNo = Integer.parseInt((s.toString()));
//				}
//				if(m[13]!=null) {
//					BigInteger r = (BigInteger) m[13];
//					roomSlNo = Integer.parseInt((r.toString()));
//				}
				
				LocationRoomModel dropDownModel = new LocationRoomModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9],
						m[10], m[11], m[12], m[13], m[14], m[15]);
				roomList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : viewRoomListBySection ends");
		return roomList;
	}

	@SuppressWarnings("unchecked")
	public List<LocationMasterModel> getLocationList() {
		logger.info("Method : getLocationList starts");

		List<LocationMasterModel> locationList = new ArrayList<LocationMasterModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
					.setParameter("actionType", "getLocationList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				Object createDate = null;

				if (m[12] != null) {
					createDate = DateFormatter.returnStringDateMonth(m[12]);
				}

				LocationMasterModel dropDownModel = new LocationMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], m[11], createDate, null, null,null,null);
				locationList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getLocationList ends");
		return locationList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateListForLoc(String id) {
		logger.info("Method : getStateListForLoc starts");

		List<DropDownModel> stateList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @P_Country='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
					.setParameter("actionType", "getStateList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}
			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getStateListForLoc ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCityForLocation(String id) {
		logger.info("Method : getCityForLocation starts");

		List<DropDownModel> stateList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @P_State='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
					.setParameter("actionType", "getCityList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}
			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getCityForLocation ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<LocationMasterModel>> getLocationDetailsById(String id) {
		logger.info("Method : getLocationDetailsById starts");

		List<LocationMasterModel> locationList = new ArrayList<LocationMasterModel>();
		JsonResponse<LocationMasterModel> resp = new JsonResponse<LocationMasterModel>();

		String value = "SET @P_LocationId='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
					.setParameter("actionType", "getLocationDetailsById").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				Object createDate = null;

				if (m[12] != null) {
					createDate = DateFormatter.returnStringDateMonth(m[12]);
				}

				LocationMasterModel dropDownModel = new LocationMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], m[11], createDate, null, null, m[13],null);
				locationList.add(dropDownModel);
			}
			resp.setBody(locationList.get(0));

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<LocationMasterModel>> response = new ResponseEntity<JsonResponse<LocationMasterModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getLocationDetailsById ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<LocationMasterModel>>> getLocationFloorDetails(String id) {
		logger.info("Method : getLocationFloorDetails starts");

		List<LocationMasterModel> locationList = new ArrayList<LocationMasterModel>();
		JsonResponse<List<LocationMasterModel>> resp = new JsonResponse<List<LocationMasterModel>>();

		String value = "SET @P_LocationId='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
					.setParameter("actionType", "getLocationFloorDetails").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				LocationMasterModel dropDownModel = new LocationMasterModel(m[0], m[1], m[2], null, null, null, null,
						null, null, null, null, null, null, m[3], m[4],null,m[5]);
				locationList.add(dropDownModel);
			}
			resp.setBody(locationList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<LocationMasterModel>>> response = new ResponseEntity<JsonResponse<List<LocationMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getLocationFloorDetails ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<LocationRoomModel>>> getLocationRoomDetails(List<String> id) {
		logger.info("Method : getLocationRoomDetails starts");
		
		List<LocationRoomModel> locationList = new ArrayList<LocationRoomModel>();
		JsonResponse<List<LocationRoomModel>> resp = new JsonResponse<List<LocationRoomModel>>();
		
		String value = GenerateLocationMasterParameter.getSectionIdList(id);
		
		if(id.size() > 0) {
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
						.setParameter("actionType", "getLocationRoomDetails").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					
					LocationRoomModel dropDownModel = new LocationRoomModel(m[0], m[1], m[2], null, m[3], m[4], m[5], null, m[6], m[7], null,
							m[8], m[9], null, null, null);
					locationList.add(dropDownModel);
				}
				resp.setBody(locationList);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		ResponseEntity<JsonResponse<List<LocationRoomModel>>> response = new ResponseEntity<JsonResponse<List<LocationRoomModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getLocationRoomDetails ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> countFloorWiseRoom(List<String> id) {
		logger.info("Method : countFloorWiseRoom starts");
		
		List<DropDownModel> locationList = new ArrayList<DropDownModel>();
		
		String value = GenerateLocationMasterParameter.getSectionIdList(id);
		
		if(id.size() > 0) {
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
						.setParameter("actionType", "countFloorWiseRoom").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1].toString());
					locationList.add(dropDownModel);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		logger.info("Method : countFloorWiseRoom ends");
		return locationList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<LocationMasterModel>>> getLocationListing() {
		logger.info("Method : getLocationListing starts");

		List<LocationMasterModel> locationList = new ArrayList<LocationMasterModel>();
		JsonResponse<List<LocationMasterModel>> resp = new JsonResponse<List<LocationMasterModel>>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
					.setParameter("actionType", "getLocationList").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				Object createDate = null;

				if (m[12] != null) {
					createDate = DateFormatter.returnStringDateMonth(m[12]);
				}

				LocationMasterModel dropDownModel = new LocationMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], m[11], createDate, null, null,null,null);
				locationList.add(dropDownModel);
			}
			resp.setBody(locationList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<LocationMasterModel>>> response = new ResponseEntity<JsonResponse<List<LocationMasterModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getLocationListing ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<LocationMasterModel>> saveLocationMaster(LocationMasterModel location) {
		logger.info("Method : saveLocationMaster starts");

		Boolean validity = true;
		JsonResponse<LocationMasterModel> resp = new JsonResponse<LocationMasterModel>();
		resp.setMessage("");
		resp.setCode("");

		List<LocationMasterModel> newLoc = new ArrayList<LocationMasterModel>();

		if (location.getLocationName() == null || location.getLocationName() == "") {
			resp.setMessage("Location Name Required");
			validity = false;
		} else if (location.getLocationCode() == null || location.getLocationCode() == "") {
			resp.setMessage("Location Code Required");
			validity = false;
		} else if (location.getLocationType() == null || location.getLocationType() == "") {
			resp.setMessage("Location Type Required");
			validity = false;
		} else if (location.getLocCountry() == null || location.getLocCountry() == "") {
			resp.setMessage("Country Required");
			validity = false;
		} else if (location.getLocState() == null || location.getLocState() == "") {
			resp.setMessage("State Required");
			validity = false;
		} else if (location.getLocCity() == null || location.getLocCity() == "") {
			resp.setMessage("City Required");
			validity = false;
		} else if (location.getLocStreet() == null || location.getLocStreet() == "") {
			resp.setMessage("Street Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateLocationMasterParameter.saveLocation(location);

				if (location.getLocationId() != null && location.getLocationId() != "") {
//					em.createNamedStoredProcedureQuery("locationMasterRoutines")
//							.setParameter("actionType", "modifyLocation").setParameter("actionValue", values).execute();
					List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
							.setParameter("actionType", "modifyLocation").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						Object createDate = null;

						if (m[12] != null) {
							createDate = DateFormatter.returnStringDate(m[12]);
						}

						LocationMasterModel item = new LocationMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
								m[7], m[8], m[9], m[10], m[11], createDate, null, null,null,null);
						newLoc.add(item);
					}
				} else {

					List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
							.setParameter("actionType", "addLocation").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						Object createDate = null;

						if (m[12] != null) {
							createDate = DateFormatter.returnStringDate(m[12]);
						}

						LocationMasterModel item = new LocationMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
								m[7], m[8], m[9], m[10], m[11], createDate, null, null,null,null);
						newLoc.add(item);
					}

				}

				resp.setBody(newLoc.get(0));
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

		ResponseEntity<JsonResponse<LocationMasterModel>> response = new ResponseEntity<JsonResponse<LocationMasterModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveLocationMaster ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<LocationMasterModel>> saveFloorMaster(LocationMasterModel location) {
		logger.info("Method : saveFloorMaster starts");

		Boolean validity = true;
		JsonResponse<LocationMasterModel> resp = new JsonResponse<LocationMasterModel>();
		resp.setMessage("");
		resp.setCode("");

		List<LocationMasterModel> newLoc = new ArrayList<LocationMasterModel>();

		if (location.getLocationName() == null || location.getLocationName() == "") {
			resp.setMessage("Floor Name Required");
			validity = false;
		} else if (location.getLocationCode() == null || location.getLocationCode() == "") {
			resp.setMessage("Floor Id Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateLocationMasterParameter.saveLocation(location);

				if (location.getFloorId() != null && location.getFloorId() != "") {

					List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
							.setParameter("actionType", "modifyFloor").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						LocationMasterModel item = new LocationMasterModel(m[0], m[1], m[2], null, null, null, null,
								null, null, null, null, null, null, m[3], m[4],null,null);
						newLoc.add(item);
					}
				} else {

					List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
							.setParameter("actionType", "addFloor").setParameter("actionValue", values).getResultList();
					for (Object[] m : x) {

						LocationMasterModel item = new LocationMasterModel(m[0], m[1], m[2], null, null, null, null,
								null, null, null, null, null, null, m[3], m[4],null,null);
						newLoc.add(item);
					}

				}

				resp.setBody(newLoc.get(0));
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

		ResponseEntity<JsonResponse<LocationMasterModel>> response = new ResponseEntity<JsonResponse<LocationMasterModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveFloorMaster ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<LocationRoomModel>> saveRoomMaster(LocationRoomModel location) {
		logger.info("Method : saveRoomMaster starts");
		
		Boolean validity = true;
		JsonResponse<LocationRoomModel> resp = new JsonResponse<LocationRoomModel>();
		resp.setMessage("");
		resp.setCode("");
		
		List<LocationRoomModel> newLoc = new ArrayList<LocationRoomModel>();
		
		if (location.getRoomCode() == null || location.getRoomCode() == "") {
			resp.setMessage("Room Code Required");
			validity = false;
		} else if (location.getRoomName() == null || location.getRoomName() == "") {
			resp.setMessage("Room Name Required");
			validity = false;
		} else if (location.getRoomType() == null || location.getRoomType() == "") {
			resp.setMessage("Room Type Required");
			validity = false;
		} else if (location.getSectionId() == null || location.getSectionId() == "") {
			resp.setMessage("Section Id Required");
			validity = false;
		}
		
		if (validity)
			try {
				String values = GenerateLocationMasterParameter.saveRoom(location);
				
				if (location.getRoomId() != null && location.getRoomId() != "") {
					
					List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
							.setParameter("actionType", "modifyRoom").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						
//						Integer floorSlNo = 0;
//						Integer secSlNo = 0;
//						Integer roomSlNo = 0;
//						
//						if(m[11]!=null) {
//							BigInteger f = (BigInteger) m[11];
//							floorSlNo = Integer.parseInt((f.toString()));
//						}
//						if(m[12]!=null) {
//							BigInteger s = (BigInteger) m[12];
//							secSlNo = Integer.parseInt((s.toString()));
//						}
//						if(m[13]!=null) {
//							BigInteger s = (BigInteger) m[13];
//							roomSlNo = Integer.parseInt((s.toString()));
//						}
						
						LocationRoomModel item = new LocationRoomModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9],
								m[10], m[11], m[12], m[13], m[14], m[15]);
						newLoc.add(item);
					}
				} else {
					
					List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
							.setParameter("actionType", "addRoom").setParameter("actionValue", values).getResultList();
					for (Object[] m : x) {
						
//						Integer floorSlNo = 0;
//						Integer secSlNo = 0;
//						Integer roomSlNo = 0;
//						
//						if(m[11]!=null) {
//							BigInteger f = (BigInteger) m[11];
//							floorSlNo = Integer.parseInt((f.toString()));
//						}
//						if(m[12]!=null) {
//							BigInteger s = (BigInteger) m[12];
//							secSlNo = Integer.parseInt((s.toString()));
//						}
//						if(m[13]!=null) {
//							BigInteger s = (BigInteger) m[13];
//							roomSlNo = Integer.parseInt((s.toString()));
//						}
						
						LocationRoomModel item = new LocationRoomModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9],
								m[10], m[11], m[12], m[13], m[14], m[15]);
						newLoc.add(item);
					}
					
				}
				
				resp.setBody(newLoc.get(0));
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
		
		ResponseEntity<JsonResponse<LocationRoomModel>> response = new ResponseEntity<JsonResponse<LocationRoomModel>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : saveRoomMaster ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<LocationSectionModel>> saveSectionMaster(LocationSectionModel location) {
		logger.info("Method : saveSectionMaster starts");
		
		Boolean validity = true;
		JsonResponse<LocationSectionModel> resp = new JsonResponse<LocationSectionModel>();
		resp.setMessage("");
		resp.setCode("");
		
		List<LocationSectionModel> newLoc = new ArrayList<LocationSectionModel>();
		
		if (location.getSectionName() == null || location.getSectionName() == "") {
			resp.setMessage("Section Name Required");
			validity = false;
		} else if (location.getSectionCode() == null || location.getSectionCode() == "") {
			resp.setMessage("Section Code Required");
			validity = false;
		}
		
		if (validity)
			try {
				String values = GenerateLocationMasterParameter.saveSection(location);
				
				if (location.getSectionId() != null && location.getSectionId() != "") {
					
					List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
							.setParameter("actionType", "modifySection").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						
						LocationSectionModel item = new LocationSectionModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8],null);
						newLoc.add(item);
					}
				} else {
					
					List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
							.setParameter("actionType", "addSection").setParameter("actionValue", values).getResultList();
					for (Object[] m : x) {
						
						LocationSectionModel item = new LocationSectionModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8],null);
						newLoc.add(item);
					}
					
				}
				
				resp.setBody(newLoc.get(0));
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
		
		ResponseEntity<JsonResponse<LocationSectionModel>> response = new ResponseEntity<JsonResponse<LocationSectionModel>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : saveSectionMaster ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteFloorMaster(String id, String createdBy) {
		logger.info("Method : deleteFloorMaster starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @P_ModifiedBy='" + createdBy + "', @P_Floor='" + id + "';";

				em.createNamedStoredProcedureQuery("locationMasterRoutines").setParameter("actionType", "deleteFloor")
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
	
	public ResponseEntity<JsonResponse<Object>> deleteLocationFile(String id, String createdBy) {
		logger.info("Method : deleteLocationFile starts");
		
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		
		if (validity)
			try {
				 
				String value = "SET @P_ModifiedBy='" + createdBy + "', @P_Location='" + id + "';";
				
				em.createNamedStoredProcedureQuery("locationMasterRoutines").setParameter("actionType", "deleteLocationFile")
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
		
		logger.info("Method : deleteLocationFile ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteSectionMaster(String id, String createdBy) {
		logger.info("Method : deleteSectionMaster starts");
		
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		
		if (validity)
			try {
				
				String value = "SET @P_ModifiedBy='" + createdBy + "', @P_Section='" + id + "';";
				em.createNamedStoredProcedureQuery("locationMasterRoutines").setParameter("actionType", "deleteSection")
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
		
		logger.info("Method : deleteSectionMaster ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteRoomMaster(String id, String createdBy) {
		logger.info("Method : deleteRoomMaster starts");
		
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		
		if (validity)
			try {
				
				String value = "SET @P_ModifiedBy='" + createdBy + "', @P_Room='" + id + "';";
				em.createNamedStoredProcedureQuery("locationMasterRoutines").setParameter("actionType", "deleteRoom")
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
		
		logger.info("Method : deleteRoomMaster ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteLocationMaster(List<DropDownModel> id) {
		logger.info("Method : deleteLocationMaster starts");
		
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		
		if (validity)
			try {
				
				String value = GenerateLocationMasterParameter.getLocationIdList(id);
				em.createNamedStoredProcedureQuery("locationMasterRoutines").setParameter("actionType", "deleteLocation")
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
		
		logger.info("Method : deleteRoomMaster ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<LocationMasterModel>> editFloorMaster(String id) {
		logger.info("Method : editFloorMaster starts");

		JsonResponse<LocationMasterModel> resp = new JsonResponse<LocationMasterModel>();
		List<LocationMasterModel> newLoc = new ArrayList<LocationMasterModel>();

		try {

			String value = "SET @P_Floor='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
					.setParameter("actionType", "editFloor").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				LocationMasterModel item = new LocationMasterModel(m[0], m[1], m[2], null, null, null, null,
						null, null, null, null, null, null, m[3], m[4],null,null);
				newLoc.add(item);
			}
			
			resp.setBody(newLoc.get(0));
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

		ResponseEntity<JsonResponse<LocationMasterModel>> response = new ResponseEntity<JsonResponse<LocationMasterModel>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : editFloorMaster ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<LocationSectionModel>> editSectionMaster(String id) {
		logger.info("Method : editSectionMaster starts");
		
		JsonResponse<LocationSectionModel> resp = new JsonResponse<LocationSectionModel>();
		List<LocationSectionModel> newLoc = new ArrayList<LocationSectionModel>();
		
		try {
			
			String value = "SET @P_Section='" + id + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
					.setParameter("actionType", "editSection").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				
				LocationSectionModel item = new LocationSectionModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8],null);
				newLoc.add(item);
			}
			
			resp.setBody(newLoc.get(0));
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
		
		ResponseEntity<JsonResponse<LocationSectionModel>> response = new ResponseEntity<JsonResponse<LocationSectionModel>>(resp,
				HttpStatus.CREATED);
		
		logger.info("Method : editSectionMaster ends");
		return response;
	}
}
