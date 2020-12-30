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
//import nirmalya.aatithya.restmodule.asset.model.AssetFuelConsumptionModel;
//import nirmalya.aatithya.restmodule.common.ServerDao;
//import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
//import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
//import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
//import nirmalya.aatithya.restmodule.common.utils.GenerateAssetFuelConsumptionParam;
//import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
//import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
//import nirmalya.aatithya.restmodule.sales.model.DeliveryChallanInvoiceModel;
//import nirmalya.aatithya.restmodule.sales.model.PreviousDataModel;
//
//@Repository
//public class AssetFuelConsumptionDao {
//	Logger logger = LoggerFactory.getLogger(AssetFuelConsumptionDao.class);
//
//	@Autowired
//	EntityManager em;
//	@Autowired
//	ServerDao serverDao;
//
//	/*
//	 * drop down for sale orders
//	 */
//	@SuppressWarnings("unchecked")
//	public List<DropDownModel> getFuel() {
//		logger.info("Method in Dao: getFuel  starts");
//		List<DropDownModel> saleOdrerList = new ArrayList<DropDownModel>();
//
//		try {
//			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
//					.setParameter("actionType", "getFuel").setParameter("actionValue", "").getResultList();
//
//			for (Object[] m : x) {
//				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
//				saleOdrerList.add(dropDownModel);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		logger.info("Method in Dao: getFuel ends");
//
//		return saleOdrerList;
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<DropDownModel> getStoreForFuelConsmption() {
//		logger.info("Method in Dao: getStoreForFuelConsmption  starts");
//		List<DropDownModel> saleOdrerList = new ArrayList<DropDownModel>();
//		
//		try {
//			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
//					.setParameter("actionType", "getStore").setParameter("actionValue", "").getResultList();
//			
//			for (Object[] m : x) {
//				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
//				saleOdrerList.add(dropDownModel);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		logger.info("Method in Dao: getStoreForFuelConsmption ends");
//		return saleOdrerList;
//	}
//
//	/*
//	 * drop down for vechile List
//	 */
//	@SuppressWarnings("unchecked")
//	public List<DropDownModel> getVeichelList() {
//		logger.info("Method in Dao: getVeichelList  starts");
//		List<DropDownModel> vechileList = new ArrayList<DropDownModel>();
//
//		try {
//			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
//					.setParameter("actionType", "getVeichelList").setParameter("actionValue", "").getResultList();
//
//			for (Object[] m : x) {
//				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
//				vechileList.add(dropDownModel);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		logger.info("Method in Dao: getVeichelList ends");
//
//		return vechileList;
//	}
//
//	/*
//	 * Drop down for job type list
//	 */
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<JsonResponse<List<DropDownModel>>> driverDetailsVechileOnchange(String vechileNo) {
//
//		logger.info("Method : driverDetailsVechileOnchange starts");
//
//		List<DropDownModel> saleOrderList = new ArrayList<DropDownModel>();
//		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
//
//		try {
//			String value = "SET @p_vechileNo='" + vechileNo + "';";
//			System.out.println(value);
//			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
//					.setParameter("actionType", "getVechileChange").setParameter("actionValue", value).getResultList();
//
//			for (Object[] m : x) {
//				DropDownModel salesOrder = new DropDownModel(m[0], m[1]);
//				saleOrderList.add(salesOrder);
//			}
//			System.out.println(saleOrderList);
//			resp.setBody(saleOrderList);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
//				resp, HttpStatus.CREATED);
//
//		logger.info("Method : driverDetailsVechileOnchange ends");
//		return response;
//	}
//
//	/*
//	 * Drop down for po details
//	 */
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDriverDetailsAutoSearch(String soId) {
//
//		logger.info("Method : getDriverDetailsAutoSearch starts");
//
//		List<DropDownModel> saleOrderList = new ArrayList<DropDownModel>();
//		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
//
//		try {
//			String value = "SET @p_searchValue='" + soId + "';";
//
//			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
//					.setParameter("actionType", "getDriverDetails").setParameter("actionValue", value).getResultList();
//
//			for (Object[] m : x) {
//				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
//				saleOrderList.add(dropDownModel);
//			}
//
//			resp.setBody(saleOrderList);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
//				resp, HttpStatus.CREATED);
//
//		logger.info("Method : getDriverDetailsAutoSearch ends");
//		return response;
//	}
//	
//	@SuppressWarnings("unchecked")
//	//public ResponseEntity<JsonResponse<List<DropDownModel>>> getDieselRate() {
//	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDieselRate(String id) {
//		logger.info("Method : getDieselRate starts");
//		
//		List<DropDownModel> saleOrderList = new ArrayList<DropDownModel>();
//		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
//		
//		try {
//			String value = "SET @p_fuelname='" + id + "';";
//			System.out.println("value="+value);
//			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
//					.setParameter("actionType", "getDieselRate")
//					.setParameter("actionValue", value)
//					.getResultList();
//			
//			for (Object[] m : x) {
//				DropDownModel dropDownModel = new DropDownModel(m[0], m[1].toString());
//				saleOrderList.add(dropDownModel);
//			}
//			
//			resp.setBody(saleOrderList);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
//				resp, HttpStatus.CREATED);
//		
//		logger.info("Method : getDieselRate ends");
//		return response;
//	}
//
//	/*
//	 * for add new DeliveryChallan
//	 */
//	public ResponseEntity<JsonResponse<Object>> restAddFuelConsumption(
//			AssetFuelConsumptionModel assetFuelConsumptionModel) {
//
//		logger.info("Method in Dao: restAddFuelConsumption starts");
//
//		Boolean validity = true;
//		JsonResponse<Object> resp = new JsonResponse<Object>();
//		resp.setMessage("");
//		resp.setCode("");
//
//		if (assetFuelConsumptionModel.getBranch() == null || assetFuelConsumptionModel.getBranch() == "") {
//			resp.setMessage("Branch Name required");
//			validity = false;
//		} /*else if (assetFuelConsumptionModel.getVechileNo() == null || assetFuelConsumptionModel.getVechileNo() == "") {
//			resp.setMessage("Vechile  Number required");
//			validity = false;
//		}*/ else if (assetFuelConsumptionModel.getDriverId() == null || assetFuelConsumptionModel.getDriverId() == "") {
//			resp.setMessage("Driver Name required");
//			validity = false;
//		} else if (assetFuelConsumptionModel.getFuel() == null || assetFuelConsumptionModel.getFuel() == "") {
//			resp.setMessage("Fuel Name required");
//			validity = false;
//		} else if (assetFuelConsumptionModel.getCouponDate() == null
//				|| assetFuelConsumptionModel.getCouponDate() == "") {
//			resp.setMessage("Coupon Date required");
//			validity = false;
//		} else if (assetFuelConsumptionModel.getFuelSlipNumber() == null
//				|| assetFuelConsumptionModel.getFuelSlipNumber() == "") {
//			resp.setMessage("Fuel Slip Number Required.");
//			validity = false;
//		} /*else if (assetFuelConsumptionModel.getVehicleWt() == null) {
//			resp.setMessage("Vechile Weight  required");
//			validity = false;
//		}*/
//
//		if (validity)
//			try {
//				String values = GenerateAssetFuelConsumptionParam.getAddFuelConsumption(assetFuelConsumptionModel);
//
//				if (assetFuelConsumptionModel.getConsumptionId() != ""
//						&& assetFuelConsumptionModel.getConsumptionId() != null) {
//					em.createNamedStoredProcedureQuery("fuelConsumption")
//							.setParameter("actionType", "modifyFuelConsumption").setParameter("actionValue", values)
//							.execute();
//
//				} else {
//					logger.info("In   trh add ");
//					em.createNamedStoredProcedureQuery("fuelConsumption")
//							.setParameter("actionType", "addFuelConsumption").setParameter("actionValue", values)
//							.execute();
//
//				}
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
//
//		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
//				HttpStatus.CREATED);
//
//		logger.info("Method in Dao: restAddFuelConsumption ends");
//
//		return response;
//	}
//
//	/*
//	 * for all getAllFuelConsumption
//	 */
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>> getAllFuelConsumption(
//			DataTableRequest request) {
//
//		logger.info("Method in Dao: getAllFuelConsumption starts");
//
//		List<AssetFuelConsumptionModel> AssetFuelConsumptionModelList = new ArrayList<AssetFuelConsumptionModel>();
//		String values = GenerateParameter.getSearchParam(request);
//		Integer total = 0;
//
//		try {
//
//			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
//					.setParameter("actionType", "getAllFuelConsumption").setParameter("actionValue", values)
//					.getResultList();
//			if (!x.isEmpty()) {
//				for (Object[] m : x) {
//					Object entrydate = DateFormatter.returnStringDate(m[5]);
//					Object time = null;
//					if(m[11]!=null) {
//						time = DateFormatter.returnStringTime(m[11]);
//					}
//					AssetFuelConsumptionModel assetFuelConsumptionModel = new AssetFuelConsumptionModel(m[0], m[1],
//							m[2], m[3], m[4], entrydate, m[6], m[7], m[8], m[9], m[10], time, m[12], m[13], m[14],
//							m[15], m[16], m[17],null,null,null,null,m[18]);
//					AssetFuelConsumptionModelList.add(assetFuelConsumptionModel);
//
//				}
//
//				if (x.get(0).length > 19) {
//					BigInteger t = (BigInteger) x.get(0)[19];
//
//					total = Integer.parseInt((t.toString()));
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		JsonResponse<List<AssetFuelConsumptionModel>> resp = new JsonResponse<List<AssetFuelConsumptionModel>>();
//		resp.setBody(AssetFuelConsumptionModelList);
//		resp.setTotal(total);
//
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("MyResponseHeader", "MyValue");
//		ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>> response = new ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>>(
//				resp, responseHeaders, HttpStatus.CREATED);
//
//		logger.info("Method in Dao: getAllFuelConsumption ends");
//
//		return response;
//	}
//
//	/*
//	 * for edit DeliveryChallan
//	 */
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<JsonResponse<AssetFuelConsumptionModel>> getFuelConsumptionId(String id) {
//
//		logger.info("Method in Dao: getFuelConsumptionId ends");
//
//		List<AssetFuelConsumptionModel> assetFuelConsumptionModelList = new ArrayList<AssetFuelConsumptionModel>();
//
//		try {
//
//			String value = "SET @p_consumptionId='" + id + "';";
//
//			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
//					.setParameter("actionType", "editFuelConsume").setParameter("actionValue", value)
//					.getResultList();
//
//			for (Object[] m : x) {
//				Object entrydate = DateFormatter.returnStringDate(m[5]);
//				Object time = null;
//				if(m[11]!=null) {
//					time = DateFormatter.returnStringTime(m[11]);
//				}
//				AssetFuelConsumptionModel assetFuelConsumptionModel = new AssetFuelConsumptionModel(m[0], m[1], m[2],
//						m[3], m[4], entrydate, m[6], m[7], m[8], m[9], m[10], time, m[12], m[13], m[14], m[15], m[16], m[17],m[18],m[19],m[20],m[21],m[22]);
//
//				assetFuelConsumptionModelList.add(assetFuelConsumptionModel);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		JsonResponse<AssetFuelConsumptionModel> resp = new JsonResponse<AssetFuelConsumptionModel>();
//		resp.setBody(assetFuelConsumptionModelList.get(0));
//
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("MyResponseHeader", "MyValue");
//
//		ResponseEntity<JsonResponse<AssetFuelConsumptionModel>> response = new ResponseEntity<JsonResponse<AssetFuelConsumptionModel>>(
//				resp, responseHeaders, HttpStatus.CREATED);
//
//		logger.info("Method in Dao: getFuelConsumptionId ends");
//
//		return response;
//	}
//
//	/*
//	 * for modal view
//	 */
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<JsonResponse<AssetFuelConsumptionModel>> getfuelConsumptionModalById(String id) {
//
//		logger.info("Method : getfuelConsumptionModalById starts");
//
//		List<AssetFuelConsumptionModel> AssetFuelConsumptionModelList = new ArrayList<AssetFuelConsumptionModel>();
//		JsonResponse<AssetFuelConsumptionModel> resp = new JsonResponse<AssetFuelConsumptionModel>();
//
//		try {
//
//			String value = "SET @p_consumptionId='" + id + "';";
//			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
//					.setParameter("actionType", "modalFuelConsumption").setParameter("actionValue", value)
//					.getResultList();
//			for (Object[] m : x) {
//				Object entrydate = DateFormatter.returnStringDate(m[5]);
//				Object time = null;
//				if(m[11]!=null) {
//					time = DateFormatter.returnStringTime(m[11]);
//				}
//				AssetFuelConsumptionModel assetFuelConsumptionModel = new AssetFuelConsumptionModel(m[0], m[1], m[2],
//						m[3], m[4], entrydate, m[6], m[7], m[8], m[9], m[10], time, m[12], m[13], m[14], m[15], m[16], m[17],null,null,null,null,m[18]);
//
//				AssetFuelConsumptionModelList.add(assetFuelConsumptionModel);
//
//			}
//
//			resp.setBody(AssetFuelConsumptionModelList.get(0));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("MyResponseHeader", "MyValue");
//
//		ResponseEntity<JsonResponse<AssetFuelConsumptionModel>> response = new ResponseEntity<JsonResponse<AssetFuelConsumptionModel>>(
//				resp, responseHeaders, HttpStatus.CREATED);
//
//		logger.info("Method : getfuelConsumptionModalById ends");
//
//		return response;
//	}
//
//	/*
//	 * for modal view and edit also
//	 */
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<AssetFuelConsumptionModel> getfuelConsumptionModalByIdPdf(String id) {
//
//		logger.info("Method : getfuelConsumptionModalById starts");
//
//		List<AssetFuelConsumptionModel> AssetFuelConsumptionModelList = new ArrayList<AssetFuelConsumptionModel>();
//		JsonResponse<AssetFuelConsumptionModel> resp = new JsonResponse<AssetFuelConsumptionModel>();
//
//		try {
//
//			String value = "SET @p_consumptionId='" + id + "';";
//			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
//					.setParameter("actionType", "modalDeliveryChallan").setParameter("actionValue", value)
//					.getResultList();
//			for (Object[] m : x) {
//				Object entrydate = DateFormatter.returnStringDate(m[1]);
//				Object batchTime = DateFormatter.returnStringTime(m[11]);
//
//				AssetFuelConsumptionModel AssetFuelConsumptionModel = new AssetFuelConsumptionModel(m[0], entrydate,
//						m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], batchTime, m[12], m[13], m[14], m[15], m[16], m[17],null,null,null,null,null);
//
//				AssetFuelConsumptionModelList.add(AssetFuelConsumptionModel);
//
//			}
//
//			resp.setBody(AssetFuelConsumptionModelList.get(0));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("MyResponseHeader", "MyValue");
//
//		ResponseEntity<AssetFuelConsumptionModel> response = new ResponseEntity<AssetFuelConsumptionModel>(
//				responseHeaders, HttpStatus.CREATED);
//
//		logger.info("Method : getfuelConsumptionModalById ends");
//
//		return response;
//	}
//
//	/*
//	 * for delete DeliveryChallan
//	 */
//	public ResponseEntity<JsonResponse<Object>> deleteAssetFuelConsumptionModelById(String id, String createdBy) {
//
//		logger.info("Method in Dao: deleteAssetFuelConsumptionModelById ends");
//
//		JsonResponse<Object> resp = new JsonResponse<Object>();
//		resp.setMessage("");
//		resp.setCode("");
//
//		try {
//
//			String value = "SET @p_consumptionId='" + id + "',@P_createdBy='" + createdBy + "';";
//
//			em.createNamedStoredProcedureQuery("fuelConsumption").setParameter("actionType", "deleteFuelConsumption")
//					.setParameter("actionValue", value).execute();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			String[] err = serverDao.errorProcedureCall(e);
//			resp.setCode(err[0]);
//			resp.setMessage(err[1]);
//		}
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("MyResponseHeader", "MyValue");
//		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
//				HttpStatus.CREATED);
//
//		logger.info("Method in Dao: deleteAssetFuelConsumptionModelById ends");
//
//		return response;
//	}
//
//	/*
//	 * for invoice data
//	 */
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<JsonResponse<List<DeliveryChallanInvoiceModel>>> getInvoiceDataPreview(String id) {
//
//		logger.info("Method : getInvoiceDataPreview starts");
//
//		List<DeliveryChallanInvoiceModel> deliveryChallanList = new ArrayList<DeliveryChallanInvoiceModel>();
//		JsonResponse<List<DeliveryChallanInvoiceModel>> resp = new JsonResponse<List<DeliveryChallanInvoiceModel>>();
//
//		try {
//
//			String value = "SET @p_challanId='" + id + "';";
//			System.out.println(value);
//			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
//					.setParameter("actionType", "getInvoiceDataPreview").setParameter("actionValue", value)
//					.getResultList();
//			if (!x.isEmpty()) {
//				for (Object[] m : x) {
//					Object date = DateFormatter.returnStringDate(m[21]);
//					DeliveryChallanInvoiceModel challanData = new DeliveryChallanInvoiceModel(m[0], m[1], m[2], m[3],
//							m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17],
//							m[18], m[19], m[20], date, m[22]);
//					deliveryChallanList.add(challanData);
//
//				}
//			}
//
//			resp.setBody(deliveryChallanList);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("MyResponseHeader", "MyValue");
//
//		ResponseEntity<JsonResponse<List<DeliveryChallanInvoiceModel>>> response = new ResponseEntity<JsonResponse<List<DeliveryChallanInvoiceModel>>>(
//				resp, responseHeaders, HttpStatus.CREATED);
//
//		logger.info("Method : getInvoiceDataPreview ends");
//
//		return response;
//	}
//	
//	/**
//	 * DAO - Get Hotel Logo
//	 *
//	 */
//	@SuppressWarnings("unchecked")
//	public List<DropDownModel> getHotelLogoImage(String logoType) {
//		logger.info("Method : getHotelLogoImage starts");
//
//		List<DropDownModel> logoList = new ArrayList<DropDownModel>();
//
//		try {
//			String value = "SET @p_logoType='" + logoType + "';";
//
//			List<Object[]> x = em.createNamedStoredProcedureQuery("logoImageRoutines")
//					.setParameter("actionType", "getHotelLogo").setParameter("actionValue", value).getResultList();
//
//			for (Object[] m : x) {
//				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
//				logoList.add(dropDownModel);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		logger.info("Method : getHotelLogoImage ends");
//
//		return logoList;
//	}
//	
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>> getVehicleFuelConsmpReportForPreview(DataTableRequest request) {
//		logger.info("Method : RESTMODULE getVehicleFuelConsmpReportForPreview starts");
//		List<AssetFuelConsumptionModel> form = new ArrayList<AssetFuelConsumptionModel>();
//
//		String param3 = request.getParam3();
//		String param2 = request.getParam2();
//		if (param2 != null && param2 != "") {
//			String frmDate = DateFormatter.getStringDate(param2);
//			request.setParam2(frmDate);
//		}
//		if (param3 != null && param3 != "") {
//			String tDate = DateFormatter.getStringDate(param3);
//			request.setParam3(tDate);
//		}
//
//		String values = GenerateParameter.getSearchParam(request);
//		Integer total = 0;
//		try {
//
//			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
//					.setParameter("actionType", "getFuelConsmpReportForPreview")
//					.setParameter("actionValue", values)
//					.getResultList();
//
//			for (Object[] m : x) {
//
//				Object aDate = null;
//				Object aTime = null;
//				if (m[4] != null) {
//					aDate = DateFormatter.returnStringDate(m[4]);
//				}
//				if(m[10]!=null) {
//					aTime = DateFormatter.returnStringTime(m[10]);
//				}
//				AssetFuelConsumptionModel foodOrderList = new AssetFuelConsumptionModel(null, m[0], m[1], m[2], m[3], aDate, m[5], m[6], m[7], m[8], m[9], aTime,
//						m[11], m[12], m[13], null, m[14], m[15],null,null,null,null,null);
//				form.add(foodOrderList);
//			}
//			if (x.size() > 0) {
//				if (x.get(0).length > 16) {
//					BigInteger t = (BigInteger) x.get(0)[16];
//
//					total = Integer.parseInt((t.toString()));
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		JsonResponse<List<AssetFuelConsumptionModel>> resp = new JsonResponse<List<AssetFuelConsumptionModel>>();
//		resp.setBody(form);
//		resp.setTotal(total);
//
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("MyResponseHeader", "MyValue");
//		ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>> response = new ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>>(
//				resp, responseHeaders, HttpStatus.CREATED);
//
//		System.out.println(response);
//		logger.info("Method : RESTMODULE getVehicleFuelConsmpReportForPreview end");
//		return response;
//	}
//	
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>> getVehicleFuelConsmpReportPdf(DataTableRequest request) {
//		logger.info("Method : RESTMODULE getVehicleFuelConsmpReportPdf starts");
//		List<AssetFuelConsumptionModel> form = new ArrayList<AssetFuelConsumptionModel>();
//		
//		String param3 = request.getParam3();
//		String param2 = request.getParam2();
//		if (param2 != null && param2 != "") {
//			String frmDate = DateFormatter.getStringDate(param2);
//			request.setParam2(frmDate);
//		}
//		if (param3 != null && param3 != "") {
//			String tDate = DateFormatter.getStringDate(param3);
//			request.setParam3(tDate);
//		}
//		
//		String values = GenerateParameter.getSearchParam(request);
//		Integer total = 0;
//		try {
//			
//			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
//					.setParameter("actionType", "getFuelConsmpReportPdf").setParameter("actionValue", values)
//					.getResultList();
//			
//			for (Object[] m : x) {
//				
//				Object aDate = null;
//				Object aTime = null;
//				if (m[4] != null) {
//					aDate = DateFormatter.returnStringDate(m[4]);
//				}
//				if(m[10]!=null) {
//					aTime = DateFormatter.returnStringTime(m[10]);
//				}
//				AssetFuelConsumptionModel foodOrderList = new AssetFuelConsumptionModel(null, m[0], m[1], m[2], m[3], aDate, m[5], m[6], m[7], m[8], m[9], aTime,
//						m[11], m[12], m[13], null, m[14], m[15],null,null,null,null,null);
//				form.add(foodOrderList);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		JsonResponse<List<AssetFuelConsumptionModel>> resp = new JsonResponse<List<AssetFuelConsumptionModel>>();
//		resp.setBody(form);
//		resp.setTotal(total);
//		
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("MyResponseHeader", "MyValue");
//		ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>> response = new ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>>(
//				resp, responseHeaders, HttpStatus.CREATED);
//		
//		System.out.println(response);
//		logger.info("Method : RESTMODULE getVehicleFuelConsmpReportPdf end");
//		return response;
//	}
//	
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>> getGenerateFuelConsumptionVehicleReportForPreview(DataTableRequest request) {
//		logger.info("Method : RESTMODULE getGenerateFuelConsumptionVehicleReportForPreview starts");
//		List<AssetFuelConsumptionModel> form = new ArrayList<AssetFuelConsumptionModel>();
//
//		String param1 = request.getParam1();
//		String param2 = request.getParam2();
//		if (param1 != null && param1 != "") {
//			String frmDate = DateFormatter.getStringDate(param1);
//			request.setParam1(frmDate);
//		}
//		if (param2 != null && param2 != "") {
//			String tDate = DateFormatter.getStringDate(param2);
//			request.setParam2(tDate);
//		}
//
//		String values = GenerateParameter.getSearchParam(request);
//		Integer total = 0;
//		try {
//
//			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
//					.setParameter("actionType", "getFuelConsmpVclReprt").setParameter("actionValue", values)
//					.getResultList();
//
//			for (Object[] m : x) {
//
//				Object aDate = null;
//				
//				if (m[5] != null) {
//					aDate = DateFormatter.returnStringDate(m[5]);
//				}
//				
//				AssetFuelConsumptionModel vehicleFuelConsumption = new AssetFuelConsumptionModel(m[0], m[1], m[2], m[3],m[4],
//						aDate, m[6], m[7], null,null, null, null, null, null, null,null, null,m[8],null,null,null,null,null);
//						
//				form.add(vehicleFuelConsumption);
//			}
//			if (x.size() > 0) {
//				if (x.get(0).length > 9) {
//					BigInteger t = (BigInteger) x.get(0)[9];
//
//					total = Integer.parseInt((t.toString()));
//				}
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		JsonResponse<List<AssetFuelConsumptionModel>> resp = new JsonResponse<List<AssetFuelConsumptionModel>>();
//		resp.setBody(form);
//		resp.setTotal(total);
//
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("MyResponseHeader", "MyValue");
//		ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>> response = new ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>>(
//				resp, responseHeaders, HttpStatus.CREATED);
//
//		System.out.println(response);
//		logger.info("Method : RESTMODULE getVehicleFuelConsmpReportForPreview end");
//		return response;
//	}
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVehicleNoAutoCompleteForReport(String soId) {
//
//		logger.info("Method : getVehicleNoAutoCompleteForReport starts");
//
//		List<DropDownModel> vehicleList = new ArrayList<DropDownModel>();
//		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
//
//		try {
//			String value = "SET @p_searchValue='" + soId + "';";
//			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
//					.setParameter("actionType", "getVehicleAutoCmplt").setParameter("actionValue", value).getResultList();
//
//			for (Object[] m : x) {
//				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
//				vehicleList.add(dropDownModel);
//			}
//
//			resp.setBody(vehicleList);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
//				resp, HttpStatus.CREATED);
//
//		logger.info("Method : getVehicleNoAutoCompleteForReport ends");
//		return response;
//	}
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCouponNoAutoCompleteForReport(String soId) {
//
//		logger.info("Method : getCouponNoAutoCompleteForReport starts");
//
//		List<DropDownModel> coupnList = new ArrayList<DropDownModel>();
//		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
//
//		try {
//			String value = "SET @p_searchValue='" + soId + "';";
//
//			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
//					.setParameter("actionType", "getCouponAutoCmplt").setParameter("actionValue", value).getResultList();
//
//			for (Object[] m : x) {
//				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
//				coupnList.add(dropDownModel);
//			}
//
//			resp.setBody(coupnList);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
//				resp, HttpStatus.CREATED);
//
//		logger.info("Method : getVehicleNoAutoCompleteForReport ends");
//		return response;
//	}
//	
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>> getGenerateFuelConsumptionVehicleReportForPdf(DataTableRequest request) {
//		logger.info("Method : RESTMODULE getGenerateFuelConsumptionVehicleReportForPdf starts");
//		List<AssetFuelConsumptionModel> form = new ArrayList<AssetFuelConsumptionModel>();
//
//		String param1 = request.getParam1();
//		String param2 = request.getParam2();
//		if (param1 != null && param1 != "") {
//			String frmDate = DateFormatter.getStringDate(param1);
//			request.setParam1(frmDate);
//		}
//		if (param2 != null && param2 != "") {
//			String tDate = DateFormatter.getStringDate(param2);
//			request.setParam2(tDate);
//		}
//
//		String values = GenerateParameter.getSearchParam(request);
//		Integer total = 0;
//		try {
//
//			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
//					.setParameter("actionType", "getFuelConsmpVclPDF").setParameter("actionValue", values)
//					.getResultList();
//
//			for (Object[] m : x) {
//
//				Object aDate = null;
//				
//				if (m[5] != null) {
//					aDate = DateFormatter.returnStringDate(m[5]);
//				}
//				
//				AssetFuelConsumptionModel vehicleFuelConsumptionPDF = new AssetFuelConsumptionModel(m[0], m[1], m[2], m[3],m[4],
//						aDate, m[6], m[7], null,null, null, null, null, null, null,null, null,m[8],null,null,null,null,null);
//						
//				form.add(vehicleFuelConsumptionPDF);
//			}
//			if (x.size() > 0) {
//				if (x.get(0).length > 9) {
//					BigInteger t = (BigInteger) x.get(0)[9];
//
//					total = Integer.parseInt((t.toString()));
//				}
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		JsonResponse<List<AssetFuelConsumptionModel>> resp = new JsonResponse<List<AssetFuelConsumptionModel>>();
//		resp.setBody(form);
//		resp.setTotal(total);
//
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("MyResponseHeader", "MyValue");
//		ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>> response = new ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>>(
//				resp, responseHeaders, HttpStatus.CREATED);
//
//		System.out.println(response);
//		logger.info("Method : RESTMODULE getGenerateFuelConsumptionVehicleReportForPdf end");
//		return response;
//	}
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>> getGenerateFuelConsumptionVehicleMilageReportForPreview(DataTableRequest request) {
//		logger.info("Method : RESTMODULE getGenerateFuelConsumptionVehicleMilageReportForPreview starts");
//		List<AssetFuelConsumptionModel> form = new ArrayList<AssetFuelConsumptionModel>();
//
//		String param1 = request.getParam1();
//		String param2 = request.getParam2();
//		if (param1 != null && param1 != "") {
//			String frmDate = DateFormatter.getStringDate(param1);
//			request.setParam1(frmDate);
//		}
//		if (param2 != null && param2 != "") {
//			String tDate = DateFormatter.getStringDate(param2);
//			request.setParam2(tDate);
//		}
//
//		String values = GenerateParameter.getSearchParam(request);
//		Integer total = 0;
//		try {
//
//			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
//					.setParameter("actionType", "getFuelMilageVclReprt").setParameter("actionValue", values)
//					.getResultList();
//
//			for (Object[] m : x) {
//
//				Object aDate = null;
//				
//				if (m[5] != null) {
//					aDate = DateFormatter.returnStringDate(m[5]);
//				}
//				
//				AssetFuelConsumptionModel vehicleFuelConsumptionMilage = new AssetFuelConsumptionModel(m[0], m[1], m[2], m[3],m[4],
//						aDate,null, m[6], null,null, null, null, m[7], m[8], m[9],null, null,null,m[10],m[11],m[12],null,null);
//						
//				form.add(vehicleFuelConsumptionMilage);
//			}
//			if (x.size() > 0) {
//				if (x.get(0).length > 13) {
//					BigInteger t = (BigInteger) x.get(0)[13];
//
//					total = Integer.parseInt((t.toString()));
//				}
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		JsonResponse<List<AssetFuelConsumptionModel>> resp = new JsonResponse<List<AssetFuelConsumptionModel>>();
//		resp.setBody(form);
//		resp.setTotal(total);
//
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("MyResponseHeader", "MyValue");
//		ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>> response = new ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>>(
//				resp, responseHeaders, HttpStatus.CREATED);
//
//		System.out.println(response);
//		logger.info("Method : RESTMODULE getVehicleFuelConsmpReportForPreview end");
//		return response;
//	}
//	
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>> getGenerateFuelConsumptionVehicleMilageReportForPdf(DataTableRequest request) {
//		logger.info("Method : RESTMODULE getGenerateFuelConsumptionVehicleMilageReportForPdf starts");
//		List<AssetFuelConsumptionModel> form = new ArrayList<AssetFuelConsumptionModel>();
//
//		String param1 = request.getParam1();
//		String param2 = request.getParam2();
//		if (param1 != null && param1 != "") {
//			String frmDate = DateFormatter.getStringDate(param1);
//			request.setParam1(frmDate);
//		}
//		if (param2 != null && param2 != "") {
//			String tDate = DateFormatter.getStringDate(param2);
//			request.setParam2(tDate);
//		}
//
//		String values = GenerateParameter.getSearchParam(request);
//		Integer total = 0;
//		try {
//
//			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
//					.setParameter("actionType", "getFuelMilageVclPDF").setParameter("actionValue", values)
//					.getResultList();
//
//			for (Object[] m : x) {
//
//				Object aDate = null;
//				
//				if (m[5] != null) {
//					aDate = DateFormatter.returnStringDate(m[5]);
//				}
//				System.out.println(values);
//				AssetFuelConsumptionModel vehicleFuelConsumptionMilage = new AssetFuelConsumptionModel(m[0], m[1], m[2], m[3],m[4],
//						aDate,null, m[6], null,null, null, null, m[7], m[8], m[9],null, null,null,m[10],m[11],m[12],null,null);
//						System.out.println(vehicleFuelConsumptionMilage);
//				form.add(vehicleFuelConsumptionMilage);
//			}
//			if (x.size() > 0) {
//				if (x.get(0).length > 13) {
//					BigInteger t = (BigInteger) x.get(0)[13];
//
//					total = Integer.parseInt((t.toString()));
//				}
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		JsonResponse<List<AssetFuelConsumptionModel>> resp = new JsonResponse<List<AssetFuelConsumptionModel>>();
//		resp.setBody(form);
//		resp.setTotal(total);
//
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("MyResponseHeader", "MyValue");
//		ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>> response = new ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>>(
//				resp, responseHeaders, HttpStatus.CREATED);
//
//		System.out.println(response);
//		logger.info("Method : RESTMODULE getVehicleFuelConsmpReportForPreview end");
//		return response;
//	}
//	
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<JsonResponse<List<PreviousDataModel>>> getPreviousDataFuel(String id) {
//		logger.info("Method : getPreviousDataFuel Dao starts");
//
//		List<PreviousDataModel> vendorList = new ArrayList<PreviousDataModel>();
//		JsonResponse<List<PreviousDataModel>> resp = new JsonResponse<List<PreviousDataModel>>();
//
//		try {
//			String value = "SET @p_searchValue='" + id + "';";
//			System.out.println(value);
//			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
//					.setParameter("actionType", "getPreviousData").setParameter("actionValue", value).getResultList();
//
//			for (Object[] m : x) {
//				PreviousDataModel dropDownModel = new PreviousDataModel(m[0], m[1], m[2],null);
//				vendorList.add(dropDownModel);
//			}
//
//			resp.setBody(vendorList);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		ResponseEntity<JsonResponse<List<PreviousDataModel>>> response = new ResponseEntity<JsonResponse<List<PreviousDataModel>>>(
//				resp, HttpStatus.CREATED);
//		System.out.println(response);
//		logger.info("Method : getPreviousDataFuel Dao ends");
//		return response;
//	}
//	
//	
//	/*
//	 * Added for datewise slino for fuel consumption by subharam
//	 * */
//	
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRefSlipNo(String id) {
//		
//		logger.info("Method : getRefSlipNo starts");
//		
//		List<DropDownModel> saleOrderList = new ArrayList<DropDownModel>();
//		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
//		
//		try {
//			String entrydate = DateFormatter.getStringDate(id);
//			String value = "SET @p_entrydate='" + entrydate + "';";
//			System.out.println("value=="+value);
//			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
//					.setParameter("actionType", "getRefSlipNo")
//					.setParameter("actionValue", value)
//					.getResultList();
//			
//			for (Object[] m : x) {
//				DropDownModel salesOrder = new DropDownModel(m[0], m[1]);
//				saleOrderList.add(salesOrder);
//			}
//			
//			resp.setBody(saleOrderList);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
//				resp, HttpStatus.CREATED);
//		logger.info("Method : getRefSlipNo ends");
//		return response;
//	}
//}
