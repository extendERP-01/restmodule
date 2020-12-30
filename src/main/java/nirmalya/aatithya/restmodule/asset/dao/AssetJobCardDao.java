//package nirmalya.aatithya.restmodule.asset.dao;
//
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Repository;
//
//import nirmalya.aatithya.restmodule.asset.model.AssetJobCardModel;
//import nirmalya.aatithya.restmodule.asset.model.ItemAssetModel;
//import nirmalya.aatithya.restmodule.common.ServerDao;
//import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
//import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
//import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
//import nirmalya.aatithya.restmodule.common.utils.GenerateJobCardParam;
//import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
//import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
//
//@Repository
//public class AssetJobCardDao {
//
//	Logger logger = LoggerFactory.getLogger(AssetJobCardDao.class);
//
//	@Autowired
//	ServerDao serverDao;
//
//	@Autowired
//	EntityManager em;
//
//	/**
//	 * 
//	 * @return service List
//	 */
//
//	public List<DropDownModel> getServices() {
//		logger.info("getServices start");
//		List<DropDownModel> ddlist = new ArrayList<DropDownModel>();
//		try {
//			@SuppressWarnings("unchecked")
//			List<Object[]> x = em.createNamedStoredProcedureQuery("jobCardRoutines")
//					.setParameter("actionType", "getServices").setParameter("actionValue", "").getResultList();
//			for (Object[] m : x) {
//				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
//				ddlist.add(dropDownModel);
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		System.out.println(ddlist);
//		logger.info("getServices ends");
//		return ddlist;
//	}
//	
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<JsonResponse<List<DropDownModel>>> getMechanicAutoSearchDao(String id) {
//		logger.info("Method : getMechanicAutoSearchDao Dao starts");
//		
//		List<DropDownModel> asset = new ArrayList<DropDownModel>();
//		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
//		
//		try {
//			String value = "SET @p_searchValue='" + id + "';";
//			List<Object[]> x = em.createNamedStoredProcedureQuery("jobCardRoutines")
//					.setParameter("actionType", "getMechanic")
//					.setParameter("actionValue", value)
//					.getResultList();
//			
//			for (Object[] m : x) {
//				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
//				asset.add(dropDownModel);
//			}
//			
//			resp.setBody(asset);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
//				resp, HttpStatus.CREATED);
//		
//		logger.info("Method : getMechanicAutoSearchDao Dao ends");
//		return response;
//	}
//	
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAsstMechanicAutoSearchDao(String id) {
//		logger.info("Method : getAsstMechanicAutoSearchDao Dao starts");
//		
//		List<DropDownModel> asset = new ArrayList<DropDownModel>();
//		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
//		
//		try {
//			String value = "SET @p_searchValue='" + id + "';";
//			List<Object[]> x = em.createNamedStoredProcedureQuery("jobCardRoutines")
//					.setParameter("actionType", "getAsstMechanic")
//					.setParameter("actionValue", value)
//					.getResultList();
//			
//			for (Object[] m : x) {
//				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
//				asset.add(dropDownModel);
//			}
//			
//			resp.setBody(asset);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
//				resp, HttpStatus.CREATED);
//		
//		logger.info("Method : getAsstMechanicAutoSearchDao Dao ends");
//		return response;
//	}
//
//	/**
//	 * for vehicle details
//	 * 
//	 * @param id
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<JsonResponse<List<ItemAssetModel>>> getVehicleDetailsForJobCard(String id) {
//		logger.info("Method : getVehicleDetailsForJobCard Dao starts");
//
//		List<ItemAssetModel> vehicle = new ArrayList<ItemAssetModel>();
//		JsonResponse<List<ItemAssetModel>> resp = new JsonResponse<List<ItemAssetModel>>();
//
//		try {
//			String value = "SET @p_searchValue='" + id + "';";
//			System.out.println(value);
//			List<Object[]> x = em.createNamedStoredProcedureQuery("jobCardRoutines")
//					.setParameter("actionType", "getVehicleDtls").setParameter("actionValue", value).getResultList();
//
//			for (Object[] m : x) {
//				ItemAssetModel dropDownModel = new ItemAssetModel(m[0], m[1], m[2]);
//				vehicle.add(dropDownModel);
//			}
//
//			resp.setBody(vehicle);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		ResponseEntity<JsonResponse<List<ItemAssetModel>>> response = new ResponseEntity<JsonResponse<List<ItemAssetModel>>>(
//				resp, HttpStatus.CREATED);
//
//		logger.info("Method : getVehicleDetailsForJobCard Dao ends");
//		return response;
//	}
//
//	public ResponseEntity<JsonResponse<Object>> addJobCard(List<AssetJobCardModel> assetJobCardModel) {
//		logger.info("Method : entryNewGatePass starts");
//
//		Boolean validity = true;
//		JsonResponse<Object> resp = new JsonResponse<Object>();
//		resp.setMessage("");
//		resp.setCode("");
//		for (AssetJobCardModel l : assetJobCardModel) {
//
//			if (l.getEntryDate() == null || l.getEntryDate() == "") {
//				validity = false;
//				resp.setCode("Field Validation Error");
//				resp.setMessage("Entry Date Required");
//				break;
//			} else if (l.getVehicleNo() == null || l.getVehicleNo() == "") {
//				validity = false;
//				resp.setCode("Field Validation Error");
//				resp.setMessage("Vehicle Number Required");
//				break;
//			} else if (l.getEntryTime() == null || l.getEntryTime() == "") {
//				validity = false;
//				resp.setCode("Field Validation Error");
//				resp.setMessage("Entry Time Required");
//				break;
//			} else if (l.getfHr() == null) {
//				validity = false;
//				resp.setCode("Field Validation Error");
//				resp.setMessage("Front Hour Required");
//				break;
//			} else if (l.getbHr() == null) {
//				validity = false;
//				resp.setCode("Field Validation Error");
//				resp.setMessage("Back Hour Required");
//				break;
//			} else if (l.getRunKm() == null) {
//				validity = false;
//				resp.setCode("Field Validation Error");
//				resp.setMessage("Running KM Required");
//				break;
//			}
//		}
//		if (validity) {
//			try {
//				String values = GenerateJobCardParam.getAddJobParam(assetJobCardModel);
//				if (assetJobCardModel.get(0).getJobbCardId() != null
//						&& assetJobCardModel.get(0).getJobbCardId() != "") {
//					em.createNamedStoredProcedureQuery("jobCardRoutines").setParameter("actionType", "modifyJobCard")
//							.setParameter("actionValue", values).execute();
//				} else {
//					em.createNamedStoredProcedureQuery("jobCardRoutines").setParameter("actionType", "addJobCard")
//							.setParameter("actionValue", values).execute();
//				}
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				try {
//					String[] err = serverDao.errorProcedureCall(e);
//					resp.setCode(err[0]);
//					resp.setMessage(err[1]);
//				} catch (Exception e1) {
//					e1.printStackTrace();
//				}
//			}
//		}
//		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
//				HttpStatus.CREATED);
//
//		logger.info("Method : entryNewGatePass ends");
//		return response;
//	}
//
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<JsonResponse<List<AssetJobCardModel>>> getJobCardDetails(DataTableRequest request) {
//		logger.info("Method : getJobCardDetails starts");
//
//		List<AssetJobCardModel> assetJobCardModel = new ArrayList<AssetJobCardModel>();
//		if (request.getParam4() != null && request.getParam4() != "") {
//			String param4 = DateFormatter.getStringDate(request.getParam4());
//			request.setParam4(param4);
//		}
//		if (request.getParam5() != null && request.getParam5() != "") {
//			String param5 = DateFormatter.getStringDate(request.getParam5());
//			request.setParam5(param5);
//		}
//		String values = GenerateParameter.getSearchParam(request);
//		Integer total = 0;
//
//		try {
//
//			List<Object[]> x = em.createNamedStoredProcedureQuery("jobCardRoutines")
//					.setParameter("actionType", "getJobCardDetails").setParameter("actionValue", values)
//					.getResultList();
//
//			for (Object[] m : x) {
//				Object assignDate = null;
//				Object removeDate = null;
//				if (m[2] != null) {
//					assignDate = DateFormatter.returnStringDate(m[2]);
//				}
//				if (m[3] != null) {
//					removeDate = DateFormatter.returnStringTime(m[3]);
//				}
//
//				AssetJobCardModel gp = new AssetJobCardModel(m[0], m[1], assignDate, removeDate, m[4], m[5], m[6], m[7],
//						null, null, m[8],m[9],null,null,null,null,null,null,null,null,null,null);
//				assetJobCardModel.add(gp);
//			}
//			if (x.size() > 0) {
//				if (x.get(0).length > 10) {
//					BigInteger t = (BigInteger) x.get(0)[10];
//
//					total = Integer.parseInt((t.toString()));
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		JsonResponse<List<AssetJobCardModel>> resp = new JsonResponse<List<AssetJobCardModel>>();
//		resp.setBody(assetJobCardModel);
//		resp.setTotal(total);
//
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("MyResponseHeader", "MyValue");
//		ResponseEntity<JsonResponse<List<AssetJobCardModel>>> response = new ResponseEntity<JsonResponse<List<AssetJobCardModel>>>(
//				resp, responseHeaders, HttpStatus.CREATED);
//
//		logger.info("Method : getJobCardDetails ends");
//		return response;
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<AssetJobCardModel> editJobCard(String id) {
//		logger.info("Method : editJobCard starts");
//
//		List<AssetJobCardModel> assetJobCardModel = new ArrayList<AssetJobCardModel>();
//		String value = "SET @p_jobId='" + id + "';";
//		System.out.println(value);
//		try {
//			List<Object[]> x = em.createNamedStoredProcedureQuery("jobCardRoutines")
//					.setParameter("actionType", "assetJobCardModelEdit").setParameter("actionValue", value)
//					.getResultList();
//
//			for (Object[] m : x) {
//				Object assignDate = null;
//				Object removeDate = null;
//				Object fromDateTime = null;
//				Object toDateTime = null;
//				if (m[2] != null) {
//					assignDate = DateFormatter.returnStringDate(m[2]);
//				}
//				if (m[3] != null) {
//					removeDate = DateFormatter.returnStringTime(m[3]);
//				}
//				if (m[18] != null) {
//					fromDateTime = DateFormatter.returnStringDateTime(m[18]);
//				}
//				
//				if (m[19] != null) {
//					toDateTime = DateFormatter.returnStringDateTime(m[19]);
//				}
//				
//				AssetJobCardModel gp = new AssetJobCardModel(m[0], m[1], assignDate, removeDate, m[4], m[5], m[6], m[7],
//						m[8], m[9], m[10],m[11],m[12],m[13],m[14],m[15],m[16],m[17],fromDateTime,toDateTime,m[20],m[21]);
//				assetJobCardModel.add(gp);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		logger.info("Method : editJobCard ends");
//		return assetJobCardModel;
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<ItemAssetModel> issueItemDetailsForJobCard(String id, String vehicle) {
//		logger.info("Method : issueItemDetailsForJobCard starts");
//		
//		List<ItemAssetModel> assetJobCardModel = new ArrayList<ItemAssetModel>();
//		String value = "SET @p_jobId='" + id + "', @p_vehicle='" + vehicle + "';";
//		System.out.println(value);
//		try {
//			List<Object[]> x = em.createNamedStoredProcedureQuery("jobCardRoutines")
//					.setParameter("actionType", "getIssuedItem").setParameter("actionValue", value)
//					.getResultList();
//			
//			for (Object[] m : x) {
//				Object assignDate = null;
//				if (m[2] != null) {
//					assignDate = DateFormatter.returnStringDate(m[2]);
//				}
//				
//				ItemAssetModel gp = new ItemAssetModel(m[0], m[1].toString(), assignDate);
//				assetJobCardModel.add(gp);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		logger.info("Method : issueItemDetailsForJobCard ends");
//		return assetJobCardModel;
//	}
//
//	public ResponseEntity<JsonResponse<Object>> changeJobCardStatus(AssetJobCardModel dd) {
//		logger.info("Method : changeAssignStatus Dao starts");
//
//		JsonResponse<Object> resp = new JsonResponse<Object>();
//
//		try {
//			String value = "SET @p_jobId='" + dd.getJobbCardId() + ",@p_status=" + dd.getStatus() + ";";
//			System.out.println(value);
//			em.createNamedStoredProcedureQuery("jobCardRoutines").setParameter("actionType", "changeStatus")
//					.setParameter("actionValue", value).execute();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
//				HttpStatus.CREATED);
//		logger.info("Method : changeAssignStatus Dao ends");
//		return response;
//	}
//
//	/*
//	 * for modal view
//	 */
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<JsonResponse<List<AssetJobCardModel>>> getJobCardModal(String id) {
//
//		logger.info("Method : getOtherServiceIdModal starts");
//
//		List<AssetJobCardModel> jobCardList = new ArrayList<AssetJobCardModel>();
//		JsonResponse<List<AssetJobCardModel>> resp = new JsonResponse<List<AssetJobCardModel>>();
//
//		try {
//			String value = "SET @p_jobId='" + id + "';";
//			System.out.println(value);
//
//			List<Object[]> x = em.createNamedStoredProcedureQuery("jobCardRoutines")
//					.setParameter("actionType", "assetJobCardModelModal").setParameter("actionValue", value)
//					.getResultList();
//			if (!x.isEmpty()) {
//				for (Object[] m : x) {
//					Object assignDate = null;
//					Object removeDate = null;
//					Object fromDateTime = null;
//					Object toDateTime = null;
//					if (m[2] != null) {
//						assignDate = DateFormatter.returnStringDate(m[2]);
//					}
//					if (m[3] != null) {
//						removeDate = DateFormatter.returnStringTime(m[3]);
//					}
//					if (m[18] != null) {
//						fromDateTime = DateFormatter.returnStringDateTime(m[18]);
//					}
//					
//					if (m[19] != null) {
//						toDateTime = DateFormatter.returnStringDateTime(m[19]);
//					}
//
//					AssetJobCardModel gp = new AssetJobCardModel(m[0], m[1], assignDate, removeDate, m[4], m[5], m[6],
//							m[7], m[8], m[9], m[10],m[11],m[12],m[13],m[14],m[15],m[16],m[17],fromDateTime,toDateTime,m[20],m[21]);
//					jobCardList.add(gp);
//
//				}
//			}
//
//			resp.setBody(jobCardList);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("MyResponseHeader", "MyValue");
//
//		ResponseEntity<JsonResponse<List<AssetJobCardModel>>> response = new ResponseEntity<JsonResponse<List<AssetJobCardModel>>>(
//				resp, responseHeaders, HttpStatus.CREATED);
//
//		logger.info("Method : getOtherServiceIdModal ends");
//
//		return response;
//	}
//	
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<JsonResponse<List<ItemAssetModel>>> getIssuedItemModalForJobCard(String id, String vehicle) {
//		logger.info("Method : getIssuedItemModalForJobCard starts");
//		
//		List<ItemAssetModel> jobCardList = new ArrayList<ItemAssetModel>();
//		JsonResponse<List<ItemAssetModel>> resp = new JsonResponse<List<ItemAssetModel>>();
//		
//		try {
//			String value = "SET @p_jobId='" + id + "', @p_vehicle='" + vehicle + "';";
//			System.out.println(value);
//			
//			List<Object[]> x = em.createNamedStoredProcedureQuery("jobCardRoutines")
//					.setParameter("actionType", "getIssuedItem").setParameter("actionValue", value)
//					.getResultList();
//			
//			for (Object[] m : x) {
//				Object assignDate = null;
//				if (m[2] != null) {
//					assignDate = DateFormatter.returnStringDate(m[2]);
//				}
//				
//				ItemAssetModel gp = new ItemAssetModel(m[0], m[1].toString(), assignDate);
//				jobCardList.add(gp);
//			}
//			
//			resp.setBody(jobCardList);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("MyResponseHeader", "MyValue");
//		
//		ResponseEntity<JsonResponse<List<ItemAssetModel>>> response = new ResponseEntity<JsonResponse<List<ItemAssetModel>>>(
//				resp, responseHeaders, HttpStatus.CREATED);
//		
//		logger.info("Method : getIssuedItemModalForJobCard ends");
//		return response;
//	}
//
//	/*
//	 * for delete assigned locker
//	 */
//	public ResponseEntity<JsonResponse<Object>> changeJobCardStatus(String id, Boolean status, String createdBy) {
//
//		logger.info("Method in Dao: changeJobCardStatus ends");
//
//		JsonResponse<Object> resp = new JsonResponse<Object>();
//		resp.setMessage("");
//		resp.setCode("");
//
//		try {
//
//			String value = "SET @p_jobId='" + id + "',@p_status=" + status + ",@P_createdBy='" + createdBy + "';";
//			System.out.println(value);
//			@SuppressWarnings("unchecked")
//			List<Object[]> x = em.createNamedStoredProcedureQuery("jobCardRoutines")
//					.setParameter("actionType", "changeJobCardStatus").setParameter("actionValue", value)
//					.getResultList();
//			System.out.println(x);
//			for (Object a : x) {
//				if (a != "notComplete") {
//					resp.setMessage(null);
//
//				} else {
//					resp.setMessage("All Service Status Are Not Completed.");
//
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			String[] err = serverDao.errorProcedureCall(e);
//			resp.setCode(err[0]);
//			resp.setMessage("All Service Status Are Not Completed.");
//		}
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("MyResponseHeader", "MyValue");
//		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
//				HttpStatus.CREATED);
//
//		logger.info("Method in Dao: changeJobCardStatus ends");
//
//		return response;
//	}
//
//}
