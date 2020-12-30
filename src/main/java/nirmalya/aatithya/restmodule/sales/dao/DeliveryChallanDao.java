package nirmalya.aatithya.restmodule.sales.dao;

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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateDeliveryChallanParam;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.model.DeliveryChalanModel;
import nirmalya.aatithya.restmodule.sales.model.DeliveryChallanInvoiceModel;
import nirmalya.aatithya.restmodule.sales.model.SaleOrderPoDetailsModel;

@Repository
public class DeliveryChallanDao {

	Logger logger = LoggerFactory.getLogger(DeliveryChallanDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * drop down for sale orders
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSaleOrder() {
		logger.info("Method in Dao: getSaleOrder  starts");
		List<DropDownModel> saleOdrerList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("DeliverChallanRoutines")
					.setParameter("actionType", "getSaleOrder").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				saleOdrerList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getSaleOrder ends");

		return saleOdrerList;
	}

	/*
	 * drop down for cement brands
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCementList() {
		logger.info("Method in Dao: getCementList  starts");
		List<DropDownModel> cementList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("DeliverChallanRoutines")
					.setParameter("actionType", "getCementList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				cementList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getCementList ends");

		return cementList;
	}

	/*
	 * drop down for pump list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getpumpList() {
		logger.info("Method in Dao: getpumpList  starts");
		List<DropDownModel> pumpList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("DeliverChallanRoutines")
					.setParameter("actionType", "getpumpList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				pumpList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getpumpList ends");

		return pumpList;
	}
	
	/*
	 * drop down for plant list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPlantList() {
		logger.info("Method in Dao: getPlantList  starts");
		List<DropDownModel> plantList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("DeliverChallanRoutines")
					.setParameter("actionType", "getPlantList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				plantList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getPlantList ends");

		return plantList;
	}

	/*
	 * drop down for vechile List
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getVeichelList() {
		logger.info("Method in Dao: getVeichelList  starts");
		List<DropDownModel> vechileList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("DeliverChallanRoutines")
					.setParameter("actionType", "getVeichelList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				vechileList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getVeichelList ends");

		return vechileList;
	}

	/*
	 * drop down for rmc grade
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getpRmcGradeList() {
		logger.info("Method in Dao: getpRmcGradeList  starts");
		List<DropDownModel> rmcGradeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("DeliverChallanRoutines")
					.setParameter("actionType", "getpRmcGradeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				rmcGradeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getpRmcGradeList ends");

		return rmcGradeList;
	}

	/*
	 * Drop down for job type list
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SaleOrderPoDetailsModel>>> getPoDetails(String soId) {

		logger.info("Method : getPoDetails starts");

		List<SaleOrderPoDetailsModel> saleOrderList = new ArrayList<SaleOrderPoDetailsModel>();
		JsonResponse<List<SaleOrderPoDetailsModel>> resp = new JsonResponse<List<SaleOrderPoDetailsModel>>();

		try {
			String value = "SET @p_soId='" + soId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("DeliverChallanRoutines")
					.setParameter("actionType", "getPoDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				SaleOrderPoDetailsModel salesOrder = new SaleOrderPoDetailsModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6] ,m[7] ,null, null ,null);
				saleOrderList.add(salesOrder); 
			}

			resp.setBody(saleOrderList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<SaleOrderPoDetailsModel>>> response = new ResponseEntity<JsonResponse<List<SaleOrderPoDetailsModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getPoDetails ends");
		return response;
	}
	
	/*
	 * Drop down for job type list
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> driverDetailsVechileOnchange(String vechileNo) {

		logger.info("Method : driverDetailsVechileOnchange starts");

		List<DropDownModel> saleOrderList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_vechileNo='" + vechileNo + "';";
 
			List<Object[]> x = em.createNamedStoredProcedureQuery("DeliverChallanRoutines")
					.setParameter("actionType", "getVechileChange").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel salesOrder = new DropDownModel(m[0], m[1] );
				saleOrderList.add(salesOrder); 
			}

			resp.setBody(saleOrderList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : driverDetailsVechileOnchange ends");
		return response;
	}
	

	/*
	 * Drop down for trip details
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SaleOrderPoDetailsModel>>> getTripDetails(String rmcGrade , String soId) {

		logger.info("Method : getTripDetails starts");

		List<SaleOrderPoDetailsModel> saleOrderList = new ArrayList<SaleOrderPoDetailsModel>();
		JsonResponse<List<SaleOrderPoDetailsModel>> resp = new JsonResponse<List<SaleOrderPoDetailsModel>>();

		try {
			String value = "SET @p_soId='" + soId + "',@p_rmcGrade='" + rmcGrade + "';"; 

			List<Object[]> x = em.createNamedStoredProcedureQuery("DeliverChallanRoutines")
					.setParameter("actionType", "getTripDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				SaleOrderPoDetailsModel saleOder = new SaleOrderPoDetailsModel(null,null,null,null,null,null,null,null,m[0], m[1] ,null);
				saleOrderList.add(saleOder); 
			}

			resp.setBody(saleOrderList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<SaleOrderPoDetailsModel>>> response = new ResponseEntity<JsonResponse<List<SaleOrderPoDetailsModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getTripDetails ends");
		return response;
	}
	
	
	/*
	 * Drop down for trip details
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SaleOrderPoDetailsModel>>> getCementDetails(String customer , String cementBrand) {

		logger.info("Method : getCementDetails starts");

		List<SaleOrderPoDetailsModel> saleOrderList = new ArrayList<SaleOrderPoDetailsModel>();
		JsonResponse<List<SaleOrderPoDetailsModel>> resp = new JsonResponse<List<SaleOrderPoDetailsModel>>();

		try {
			String value = "SET @p_cementBrand='" + cementBrand + "',@p_customer='" + customer + "';"; 

			List<Object[]> x = em.createNamedStoredProcedureQuery("DeliverChallanRoutines")
					.setParameter("actionType", "getCementDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				SaleOrderPoDetailsModel saleOder = new SaleOrderPoDetailsModel(null,null,null,null,null,null,null,null,null,m[1],m[0]);
				saleOrderList.add(saleOder); 
			}

			resp.setBody(saleOrderList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<SaleOrderPoDetailsModel>>> response = new ResponseEntity<JsonResponse<List<SaleOrderPoDetailsModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getCementDetails ends");
		return response;
	}
	
	
	/*
	 * Drop down for po details
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SaleOrderPoDetailsModel>>> getDriverDetails(String soId) {

		logger.info("Method : getDriverDetails starts");

		List<SaleOrderPoDetailsModel> saleOrderList = new ArrayList<SaleOrderPoDetailsModel>();
		JsonResponse<List<SaleOrderPoDetailsModel>> resp = new JsonResponse<List<SaleOrderPoDetailsModel>>();

		try {
			String value = "SET @p_searchValue='" + soId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("DeliverChallanRoutines")
					.setParameter("actionType", "getDriverDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				SaleOrderPoDetailsModel dropDownModel = new SaleOrderPoDetailsModel(null, m[0], m[1], null, null, null,
						null ,null ,null ,null ,null);
				saleOrderList.add(dropDownModel);
			}

			resp.setBody(saleOrderList); 

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<SaleOrderPoDetailsModel>>> response = new ResponseEntity<JsonResponse<List<SaleOrderPoDetailsModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getDriverDetails ends");
		return response;
	}

	/*
	 * for add new DeliveryChallan
	 */
	public ResponseEntity<JsonResponse<Object>> restAddDeliveryChallanMaster(DeliveryChalanModel deliveryChalanModel) {

		logger.info("Method in Dao: add DeliveryChallan master starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if(deliveryChalanModel.getChallanNo() == null && deliveryChalanModel.getChallanNo() == "") {
			if (deliveryChalanModel.getSaleOrder() == null || deliveryChalanModel.getSaleOrder() == "") {
				resp.setMessage("Sale Order required");
				validity = false;
			} else if (deliveryChalanModel.getClientAccount() == null || deliveryChalanModel.getClientAccount() == "") {
				resp.setMessage("Client Account required");
				validity = false;
			} else if (deliveryChalanModel.getRefPoId() == null || deliveryChalanModel.getRefPoId() == "") {
				resp.setMessage("PO  required");
				validity = false;
			}
		}
		

		if (validity)
			try {
				String values = GenerateDeliveryChallanParam.getAddDeliveryChallanParam(deliveryChalanModel);
 
				if (deliveryChalanModel.getChallanNo() != "") { 
					em.createNamedStoredProcedureQuery("DeliverChallanRoutines")
							.setParameter("actionType", "modifyDeliveryChallan").setParameter("actionValue", values)
							.execute();

				} else { 
					em.createNamedStoredProcedureQuery("DeliverChallanRoutines")
							.setParameter("actionType", "addDeliveryChallan").setParameter("actionValue", values)
							.execute();

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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: add DeliveryChallan master ends");

		return response;
	}

	/*
	 * for all DeliveryChallan master
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DeliveryChalanModel>>> getAllDeliveryChallans(DataTableRequest request) {

		logger.info("Method in Dao: getDeliveryChallanDetails starts");

		List<DeliveryChalanModel> DeliveryChalanModelList = new ArrayList<DeliveryChalanModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("DeliverChallanRoutines")
					.setParameter("actionType", "deliveryChallans").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object entrydate = DateFormatter.returnStringDate(m[1]);

					DeliveryChalanModel deliveryChalanModel = new DeliveryChalanModel(m[0], entrydate, m[2], m[3], m[4],
							m[5], null, null, m[6], null, m[7], null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, null, m[8], m[9],null,null);
					DeliveryChalanModelList.add(deliveryChalanModel);

				}

				if (x.get(0).length > 10) {
					BigInteger t = (BigInteger) x.get(0)[10];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<DeliveryChalanModel>> resp = new JsonResponse<List<DeliveryChalanModel>>();
		resp.setBody(DeliveryChalanModelList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<DeliveryChalanModel>>> response = new ResponseEntity<JsonResponse<List<DeliveryChalanModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getDeliveryChallanDetails ends");

		return response;
	}

	/*
	 * for edit DeliveryChallan
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DeliveryChalanModel>> getDeliveryChallanById(String id) {

		logger.info("Method in Dao: getDeliveryChallanById ends");

		List<DeliveryChalanModel> DeliveryChalanModelList = new ArrayList<DeliveryChalanModel>();

		try {

			String value = "SET @p_DeliveryChallanId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("DeliverChallanRoutines")
					.setParameter("actionType", "editDeliveryChallan").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object entrydate = DateFormatter.returnStringDate(m[1]);
				Object batchTime = DateFormatter.returnStringTime(m[11]);
				Object outTime = DateFormatter.returnStringTime(m[40]);
				Object returntime = DateFormatter.returnStringTime(m[45]);
				/*
				 * Object siteInTime = DateFormatter.returnStringTime(m[49]); Object siteOutTime
				 * = DateFormatter.returnStringTime(m[50]);
				 */
				DeliveryChalanModel deliveryChalanModel = new DeliveryChalanModel(m[0], entrydate, m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], batchTime, m[12], m[13], m[14], m[15], m[16], m[17], m[18],
						m[19], m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30], m[31],
						m[32], m[33], m[34], m[35], m[36], m[37], m[38], m[39], outTime, m[41], m[42], m[43], m[44],
						returntime, m[46], m[47], m[48], m[49], m[50], m[51], m[52], m[53], m[54], m[55], m[56], null,
						null,null,null);

				DeliveryChalanModelList.add(deliveryChalanModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<DeliveryChalanModel> resp = new JsonResponse<DeliveryChalanModel>();
		resp.setBody(DeliveryChalanModelList.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<DeliveryChalanModel>> response = new ResponseEntity<JsonResponse<DeliveryChalanModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getDeliveryChallanById ends");

		return response;
	}

	/*
	 * for modal DeliveryChallan
	 * 
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<DeliveryChalanModel>>
	 * getdeliveryChalanModalById1(String id) {
	 * 
	 * logger.info("Method in Dao: getdeliveryChalanModalById ends");
	 * 
	 * List<DeliveryChalanModel> DeliveryChalanModelList = new
	 * ArrayList<DeliveryChalanModel>();
	 * 
	 * try {
	 * 
	 * String value = "SET @p_DeliveryChallanId='" + id + "';";
	 * 
	 * List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("DeliverChallanRoutines")
	 * .setParameter("actionType",
	 * "modalDeliveryChallan").setParameter("actionValue", value) .getResultList();
	 * 
	 * for (Object[] m : x) { Object entrydate =
	 * DateFormatter.returnStringDate(m[1]); Object batchTime =
	 * DateFormatter.returnStringTime(m[11]); Object outTime =
	 * DateFormatter.returnStringTime(m[40]); Object returntime =
	 * DateFormatter.returnStringTime(m[45]);
	 * 
	 * DeliveryChalanModel deliveryChalanModel = new DeliveryChalanModel(m[0],
	 * entrydate, m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], batchTime,
	 * m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21], m[22],
	 * m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30], m[31], m[32], m[33],
	 * m[34], m[35], m[36], m[37], m[38], m[39], outTime, m[41], m[42], m[43],
	 * m[44], returntime, m[46], m[47], m[48], m[49], m[50], m[51], m[52], m[53],
	 * m[54], m[55]);
	 * 
	 * DeliveryChalanModelList.add(deliveryChalanModel); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * JsonResponse<DeliveryChalanModel> resp = new
	 * JsonResponse<DeliveryChalanModel>();
	 * resp.setBody(DeliveryChalanModelList.get(0));
	 * 
	 * HttpHeaders responseHeaders = new HttpHeaders();
	 * responseHeaders.set("MyResponseHeader", "MyValue");
	 * 
	 * ResponseEntity<JsonResponse<DeliveryChalanModel>> response = new
	 * ResponseEntity<JsonResponse<DeliveryChalanModel>>( resp, responseHeaders,
	 * HttpStatus.CREATED);
	 * 
	 * logger.info("Method in Dao: getdeliveryChalanModalById ends");
	 * 
	 * return response; }
	 */

	/*
	 * for modal view and edit also
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DeliveryChalanModel>> getdeliveryChalanModalById(String id) {

		logger.info("Method : getdeliveryChalanModalById starts");

		List<DeliveryChalanModel> deliveryChalanModelList = new ArrayList<DeliveryChalanModel>();
		JsonResponse<DeliveryChalanModel> resp = new JsonResponse<DeliveryChalanModel>();

		try {

			String value = "SET @p_DeliveryChallanId='" + id + "';"; 
			List<Object[]> x = em.createNamedStoredProcedureQuery("DeliverChallanRoutines")
					.setParameter("actionType", "modalDeliveryChallan").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				Object entrydate = DateFormatter.returnStringDate(m[1]);
				Object batchTime = DateFormatter.returnStringTime(m[11]);
				Object outTime = DateFormatter.returnStringTime(m[40]);
				Object returntime = DateFormatter.returnStringTime(m[45]);

				DeliveryChalanModel deliveryChalanModel = new DeliveryChalanModel(m[0], entrydate, m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], batchTime, m[12], m[13], m[14], m[15], m[16], m[17], m[18],
						m[19], m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30], m[31],
						m[32], m[33], m[34], m[35], m[36], m[37], m[38], m[39], outTime, m[41], m[42], m[43], m[44],
						returntime, m[46], m[47], m[48], m[49], m[50], m[51], m[52], m[53], m[54], m[55], m[56], null,
						m[57],null,null);

				deliveryChalanModelList.add(deliveryChalanModel);

			}

			resp.setBody(deliveryChalanModelList.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<DeliveryChalanModel>> response = new ResponseEntity<JsonResponse<DeliveryChalanModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getdeliveryChalanModalById ends");

		return response;
	}

	/*
	 * for modal view and edit also
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<DeliveryChalanModel> getdeliveryChalanModalByIdPdf(String id) {

		logger.info("Method : getdeliveryChalanModalById starts");

		List<DeliveryChalanModel> deliveryChalanModelList = new ArrayList<DeliveryChalanModel>();
		JsonResponse<DeliveryChalanModel> resp = new JsonResponse<DeliveryChalanModel>();

		try { 
			String value = "SET @p_DeliveryChallanId='" + id + "';"; 
			List<Object[]> x = em.createNamedStoredProcedureQuery("DeliverChallanRoutines")
					.setParameter("actionType", "modalDeliveryChallan").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				Object entrydate = DateFormatter.returnStringDate(m[1]);
				Object batchTime = DateFormatter.returnStringTime(m[11]);
				Object outTime = DateFormatter.returnStringTime(m[40]);
				Object returntime = DateFormatter.returnStringTime(m[45]);

				DeliveryChalanModel deliveryChalanModel = new DeliveryChalanModel(m[0], entrydate, m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], batchTime, m[12], m[13], m[14], m[15], m[16], m[17], m[18],
						m[19], m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30], m[31],
						m[32], m[33], m[34], m[35], m[36], m[37], m[38], m[39], outTime, m[41], m[42], m[43], m[44],
						returntime, m[46], m[47], m[48], m[49], m[50], m[51], m[52], m[53], m[54], m[55], m[56], null,
						m[57],null,null);

				deliveryChalanModelList.add(deliveryChalanModel);

			}

			resp.setBody(deliveryChalanModelList.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<DeliveryChalanModel> response = new ResponseEntity<DeliveryChalanModel>(responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : getdeliveryChalanModalById ends");

		return response;
	}

	/*
	 * for delete DeliveryChallan
	 */
	public ResponseEntity<JsonResponse<Object>> deleteDeliveryChalanModelById(String id, String createdBy) {

		logger.info("Method in Dao: deleteDeliveryChalanModelById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_challanNo='" + id + "',@P_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("DeliverChallanRoutines")
					.setParameter("actionType", "deleteDeliveryChallan").setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
			String[] err = serverDao.errorProcedureCall(e);
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in Dao: deleteDeliveryChalanModelById ends");

		return response;
	}

	/*
	 * for invoice data
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DeliveryChallanInvoiceModel>>> getInvoiceData(String id) {

		logger.info("Method : getInvoiceData starts");

		List<DeliveryChallanInvoiceModel> deliveryChallanList = new ArrayList<DeliveryChallanInvoiceModel>();
		JsonResponse<List<DeliveryChallanInvoiceModel>> resp = new JsonResponse<List<DeliveryChallanInvoiceModel>>();

		try {

			String value = "SET @p_challanId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("DeliverChallanRoutines")
					.setParameter("actionType", "getinvoiceData").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					DeliveryChallanInvoiceModel challanData = new DeliveryChallanInvoiceModel(m[0], m[1], m[2], m[3],
							m[4], m[5], m[6], m[7], m[8], m[9], m[10], null, null, null, null, null, null, null, null,
							null, null, null, null);
					deliveryChallanList.add(challanData);

				}
			}

			resp.setBody(deliveryChallanList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<DeliveryChallanInvoiceModel>>> response = new ResponseEntity<JsonResponse<List<DeliveryChallanInvoiceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getInvoiceData ends");

		return response;
	}

	/*
	 * for update invoice
	 */
	public ResponseEntity<JsonResponse<Object>> addInvoiceDiscount(String id, String discount, Boolean taxType,
			String taxRate) {

		logger.info("Method in Dao: addInvoiceDiscount ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_challanId='" + id + "',@P_discount='" + discount + "',@P_taxRate='" + taxRate
					+ "',@P_taxType=" + taxType + ";";

			em.createNamedStoredProcedureQuery("DeliverChallanRoutines")
					.setParameter("actionType", "addInvoiceDiscount").setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
			String[] err = serverDao.errorProcedureCall(e);
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in Dao: addInvoiceDiscount ends");

		return response;
	}

	/*
	 * for invoice data
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DeliveryChallanInvoiceModel>>> getInvoiceDataPreview(String id) {

		logger.info("Method : getInvoiceDataPreview starts");

		List<DeliveryChallanInvoiceModel> deliveryChallanList = new ArrayList<DeliveryChallanInvoiceModel>();
		JsonResponse<List<DeliveryChallanInvoiceModel>> resp = new JsonResponse<List<DeliveryChallanInvoiceModel>>();

		try {

			String value = "SET @p_challanId='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("DeliverChallanRoutines")
					.setParameter("actionType", "getInvoiceDataPreview").setParameter("actionValue", value)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = DateFormatter.returnStringDate(m[21]);
					DeliveryChallanInvoiceModel challanData = new DeliveryChallanInvoiceModel(m[0], m[1], m[2], m[3],
							m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17],
							m[18], m[19], m[20], date, m[22]);
					deliveryChallanList.add(challanData);

				}
			}

			resp.setBody(deliveryChallanList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<DeliveryChallanInvoiceModel>>> response = new ResponseEntity<JsonResponse<List<DeliveryChallanInvoiceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getInvoiceDataPreview ends");

		return response;
	}

}
