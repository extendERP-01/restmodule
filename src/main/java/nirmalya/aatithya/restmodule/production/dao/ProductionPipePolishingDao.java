package nirmalya.aatithya.restmodule.production.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.production.model.ProductionPipeNonpolishModel;
import nirmalya.aatithya.restmodule.production.model.ProductionPipePolishingModel;
import nirmalya.aatithya.restmodule.production.model.RestMotherCoilModel;

@Repository
public class ProductionPipePolishingDao {
	Logger logger = LoggerFactory.getLogger(RestMotherCoilDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for add pipe polishing Details
	 */
	public ResponseEntity<JsonResponse<Object>> addPolishingDetails(
			List<ProductionPipePolishingModel> productionPipePolishingModelList) {

		logger.info("Method in Dao: addPolishingDetails starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String values = "";
		for (ProductionPipePolishingModel a : productionPipePolishingModelList) {
			if (a.gettMotherCoilBatch() == null || a.gettMotherCoilBatch() == "") {
				resp.setMessage("Mother Coil Batch is required");
				validity = false;
			}

		}
		for (ProductionPipePolishingModel a : productionPipePolishingModelList) {
			values = "SET @p_tMotherCoilBatch='" + a.gettMotherCoilBatch() + "',@p_tMotherCoilThickness='"
					+ a.gettMotherCoilThickness() + "',@p_tPipeSlitBatch='" + a.gettPipeSlitBatch()
					+ "',@p_tPipeSlitWidth='" + a.gettPipeSlitWidth() + "',@p_tPipeSize='" + a.gettPipeSize()
					+ "',@p_polishingStartDate='" + DateFormatter.getStringDate(a.getPolishingStartDate())
					+ "',@p_polishingEndDate='" + DateFormatter.getStringDate(a.getPolishingEndDate())
					+ "',@p_polishingQty='" + a.getPolishingQty() + "',@p_polishingWt='" + a.getPolishingWt()
					+ "',@p_tPipeCreatedBy='" + a.gettPipeCreatedBy() + "';";
		}
		if (validity)
			try {

				em.createNamedStoredProcedureQuery("pipePolishingRoutines")
						.setParameter("actionType", "modifyPipePolishing").setParameter("actionValue", values)
						.execute();

			} catch (Exception e) {
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: addPolishingDetails ends");

		return response;
	}

	/*
	 * 
	 * Dao function for edit polishing details DateFormatter.returnStringDate(m[5]),
	 * DateFormatter.returnStringDate(m[6]),
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<ProductionPipePolishingModel> editpolishing(String mBatchId, String mThickId, String slitBatchId) {
		logger.info("Method : editpolishing starts");
		List<ProductionPipePolishingModel> polishingList = new ArrayList<ProductionPipePolishingModel>();

		String value = "SET @p_mBatchId='" + mBatchId + "',@p_mThickId='" + mThickId + "',@p_slitBatchId='"
				+ slitBatchId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("pipePolishingRoutines")
					.setParameter("actionType", "editpipepolishing").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				ProductionPipePolishingModel polishing = new ProductionPipePolishingModel(m[0], m[1], m[2], m[3], m[4],
						DateFormatter.returnStringDate(m[5]), DateFormatter.returnStringDate(m[6]), m[7], m[8], m[9],
						m[10], m[11], m[12], null, null, null, null, m[13], m[14], m[15], m[16], m[17]);

				polishingList.add(polishing);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editpolishing ends");

		return polishingList;
	}

	/*
	 * for view polishing details
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestMotherCoilModel>>> viewPolishingDetails(DataTableRequest request) {
		// TODO Auto-generated method stub

		logger.info("Method in Dao: viewPolishingDetails starts");

		List<RestMotherCoilModel> getMCoil = new ArrayList<RestMotherCoilModel>();
		if (!request.getParam3().isEmpty()) {
			request.setParam3(DateFormatter.getStringDate(request.getParam3()));
		}

		if (!request.getParam4().isEmpty()) {
			request.setParam4(DateFormatter.getStringDate(request.getParam4()));
		}

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("pipePolishingRoutines")
					.setParameter("actionType", "viewPolishingDetails").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					RestMotherCoilModel motherCoil = new RestMotherCoilModel(m[0], m[1], m[2], m[3], m[4],
							DateFormatter.returnStringDate(m[5]), DateFormatter.returnStringDate(m[6]), null, null,
							null, null, null, m[7], m[8], m[9], m[10], null, null);

					getMCoil.add(motherCoil);

				}

				if (x.get(0).length > 11) {
					BigInteger t = (BigInteger) x.get(0)[11];
					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestMotherCoilModel>> resp = new JsonResponse<List<RestMotherCoilModel>>();
		resp.setBody(getMCoil);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestMotherCoilModel>>> response = new ResponseEntity<JsonResponse<List<RestMotherCoilModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: viewPolishingDetails ends");

		return response;
	}

	/*
	 * for modal view for production details
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionPipePolishingModel>>> getPolishingDetailsModal(String mBatchId,
			String mThickId, String slitBatchId, String slitWidth, String pipeSize) {

		logger.info("Method : getPolishingDetailsModal starts");

		List<ProductionPipePolishingModel> pipPolishingeList = new ArrayList<ProductionPipePolishingModel>();
		JsonResponse<List<ProductionPipePolishingModel>> resp = new JsonResponse<List<ProductionPipePolishingModel>>();

		try {

			String value = "SET @p_mBatchId='" + mBatchId + "',@p_mThickId='" + mThickId + "',@p_slitBatchId='"
					+ slitBatchId + "',@p_slitWidth='" + slitWidth + "',@p_pipeSize='" + pipeSize + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("pipePolishingRoutines")
					.setParameter("actionType", "getDetailsModal").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				ProductionPipePolishingModel pipe = new ProductionPipePolishingModel(m[0], m[1], m[2], m[3], m[4],
						DateFormatter.returnStringDate(m[5]), DateFormatter.returnStringDate(m[6]), m[7], m[8], m[9],
						m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21]);

				pipPolishingeList.add(pipe);

			}
			resp.setBody(pipPolishingeList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<ProductionPipePolishingModel>>> response = new ResponseEntity<JsonResponse<List<ProductionPipePolishingModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getPolishingDetailsModal ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionPipeNonpolishModel>>> getNonPolishReport(
			DataTableRequest request) {
		// TODO Auto-generated method stub

		logger.info("Method in Dao: getNonPolishReport starts");

		List<ProductionPipeNonpolishModel> NonPolishList = new ArrayList<ProductionPipeNonpolishModel>();
		String param1 = request.getParam1();
		String param2 = request.getParam2();
		if (param1 != null && param1 != "") {
			String frmDate = DateFormatter.getStringDate(param1);
			request.setParam1(frmDate);
		}
		if (param2 != null && param2 != "") {
			String tDate = DateFormatter.getStringDate(param2);
			request.setParam2(tDate);
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("pipePolishingRoutines")
					.setParameter("actionType", "viewNonPolishingData").setParameter("actionValue", values)
					.getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					ProductionPipeNonpolishModel productionPipeNonpolishModel = new ProductionPipeNonpolishModel(m[0],
							m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13]);

					NonPolishList.add(productionPipeNonpolishModel);

				}

				if (x.get(0).length > 14) {
					BigInteger t = (BigInteger) x.get(0)[14];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ProductionPipeNonpolishModel>> resp = new JsonResponse<List<ProductionPipeNonpolishModel>>();
		resp.setBody(NonPolishList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ProductionPipeNonpolishModel>>> response = new ResponseEntity<JsonResponse<List<ProductionPipeNonpolishModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getNonPolishReport ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionPipeNonpolishModel>>> getNonPolishReportPDF(
			DataTableRequest request) {
		// TODO Auto-generated method stub

		logger.info("Method in Dao: getNonPolishReport starts");

		List<ProductionPipeNonpolishModel> NonPolishList = new ArrayList<ProductionPipeNonpolishModel>();
		String param1 = request.getParam1();
		String param2 = request.getParam2();
		if (param1 != null && param1 != "") {
			String frmDate = DateFormatter.getStringDate(param1);
			request.setParam1(frmDate);
		}
		if (param2 != null && param2 != "") {
			String tDate = DateFormatter.getStringDate(param2);
			request.setParam2(tDate);
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("pipePolishingRoutines")
					.setParameter("actionType", "viewNonPolishingPDF").setParameter("actionValue", values)
					.getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					ProductionPipeNonpolishModel productionPipeNonpolishModel = new ProductionPipeNonpolishModel(m[0],
							m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13]);

					NonPolishList.add(productionPipeNonpolishModel);
				}

				if (x.get(0).length > 14) {
					BigInteger t = (BigInteger) x.get(0)[14];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ProductionPipeNonpolishModel>> resp = new JsonResponse<List<ProductionPipeNonpolishModel>>();
		resp.setBody(NonPolishList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ProductionPipeNonpolishModel>>> response = new ResponseEntity<JsonResponse<List<ProductionPipeNonpolishModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getNonPolishReportPDF ends");

		return response;
	}

	public ResponseEntity<JsonResponse<List<ProductionPipePolishingModel>>> getAllpolishingReports(String grade,
			String thickness, String startDate, String endDate, String slitWidth, String pipeSize) {
		logger.info("Method in Dao: getAllpolishingReports starts");

		List<ProductionPipePolishingModel> NonPolishList = new ArrayList<ProductionPipePolishingModel>();

		String values = "SET @p_grade='" + grade + "',@p_thickness='" + thickness + "',@p_slitWidth='" + slitWidth
				+ "';";
		Integer total = 0;
		try {
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("pipePolishingRoutines")
					.setParameter("actionType", "pipePolishingReport").setParameter("actionValue", values)
					.getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					ProductionPipePolishingModel pipe = new ProductionPipePolishingModel(m[0], m[1], m[2], m[3], m[4],
							DateFormatter.returnStringDate(m[5]), DateFormatter.returnStringDate(m[6]), m[7], m[8],
							m[9], m[10], m[11], m[12], DateFormatter.returnStringDate(m[13]),
							DateFormatter.returnStringDate(m[14]), m[15], m[16], m[17], m[18], m[19], m[20], m[21]);

					NonPolishList.add(pipe);
				}

				if (x.get(0).length > 22) {
					BigInteger t = (BigInteger) x.get(0)[22];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ProductionPipePolishingModel>> resp = new JsonResponse<List<ProductionPipePolishingModel>>();
		resp.setBody(NonPolishList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ProductionPipePolishingModel>>> response = new ResponseEntity<JsonResponse<List<ProductionPipePolishingModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getAllpolishingReports ends");

		return response;
	}

	/*
	 * for view polishing details
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionPipePolishingModel>>> getPolishingDetails(
			DataTableRequest request) {
		// TODO Auto-generated method stub

		logger.info("Method in Dao: getPolishingDetails starts");

		List<ProductionPipePolishingModel> getMCoil = new ArrayList<ProductionPipePolishingModel>();
		if (!request.getParam3().isEmpty()) {
			request.setParam3(DateFormatter.getStringDate(request.getParam3()));
		}
		if (!request.getParam4().isEmpty()) {
			request.setParam4(DateFormatter.getStringDate(request.getParam4()));
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("pipePolishingRoutines")
					.setParameter("actionType", "getAllPolishingDetails").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object polishStartDate = null;
					Object polishEndDate = null;
					if (m[7] != null) {
						polishStartDate = DateFormatter.returnStringDate(m[7]);
					}
					if (m[8] != null) {
						polishEndDate = DateFormatter.returnStringDate(m[8]);
					}
					ProductionPipePolishingModel motherCoil = new ProductionPipePolishingModel(m[0], m[1], m[2], m[3],
							m[4], DateFormatter.returnStringDate(m[5]), DateFormatter.returnStringDate(m[6]), null,
							null, null, null, null, null, polishStartDate, polishEndDate, m[9], m[10], m[11], m[12],
							m[13], m[14], null);

					getMCoil.add(motherCoil);

				}

				if (x.get(0).length > 15) {
					BigInteger t = (BigInteger) x.get(0)[15];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ProductionPipePolishingModel>> resp = new JsonResponse<List<ProductionPipePolishingModel>>();
		resp.setBody(getMCoil);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ProductionPipePolishingModel>>> response = new ResponseEntity<JsonResponse<List<ProductionPipePolishingModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getPolishingDetails ends");

		return response;
	}

}
