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
import nirmalya.aatithya.restmodule.common.utils.GenerateProductionPackagingParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.production.model.ProductionPipePackagingModel;
import nirmalya.aatithya.restmodule.production.model.ProductionPipeProductionModel;

@Repository
public class ProductionPipePackagingDao {
	Logger logger = LoggerFactory.getLogger(ProductionPipePackagingDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for all Mother Coil view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionPipeProductionModel>>> viewMotherCoilForPackaging(
			DataTableRequest request) {

		logger.info("Method in Dao: viewMotherCoilForPackaging starts");

		List<ProductionPipeProductionModel> getMCoil = new ArrayList<ProductionPipeProductionModel>();
		if (!request.getParam3().isEmpty()) {
			request.setParam3(DateFormatter.getStringDate(request.getParam3()));
		}
		if (!request.getParam4().isEmpty()) {
			request.setParam4(DateFormatter.getStringDate(request.getParam4()));
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("pipePackagingRoutines")
					.setParameter("actionType", "mcForPackaging").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					ProductionPipeProductionModel motherCoil = new ProductionPipeProductionModel(m[0], m[1], m[2], m[3],
							m[4], DateFormatter.returnStringDate(m[5]), DateFormatter.returnStringDate(m[6]), null,
							null, null, null, null, null, null, null, null, null, m[7], m[8], null, null);

					getMCoil.add(motherCoil);

				}
				if (x.get(0).length > 9) {
					BigInteger t = (BigInteger) x.get(0)[9];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ProductionPipeProductionModel>> resp = new JsonResponse<List<ProductionPipeProductionModel>>();
		resp.setBody(getMCoil);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ProductionPipeProductionModel>>> response = new ResponseEntity<JsonResponse<List<ProductionPipeProductionModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: viewMotherCoilForPackaging ends");

		return response;
	}

	/*
	 * for add packaging details
	 */
	public ResponseEntity<JsonResponse<Object>> addpackagingDetails(List<ProductionPipePackagingModel> packaging) {

		logger.info("Method in Dao: addpackagingDetails starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String values = "";
		for (ProductionPipePackagingModel a : packaging) {
			if (a.gettMotherCoilBatch() == null || a.gettMotherCoilBatch() == "") {
				resp.setMessage("Mother Coil Batch is required");
				validity = false;
			}
			if (a.getPackagingEndDate() == null || a.getPackagingEndDate() == "") {
				resp.setMessage("Start Date  is required");
				validity = false;
			}
			if (a.getPackagingStartDate() == null || a.getPackagingStartDate() == "") {
				resp.setMessage("End Date is required");
				validity = false;
			}
			if (a.getPackagingQty() == null) {
				resp.setMessage("Packaging Quantity is required");
				validity = false;
			}
			if (a.getPackagingWt() == null) {
				resp.setMessage("Packaging Weight is required");
				validity = false;
			}

		}

		values = GenerateProductionPackagingParam.addPackageingParam(packaging);
		if (validity)
			try {

				em.createNamedStoredProcedureQuery("pipePackagingRoutines")
						.setParameter("actionType", "modifyPipePacking").setParameter("actionValue", values).execute();

			} catch (Exception e) {
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: addpackagingDetails ends");

		return response;
	}

	/*
	 * 
	 * Dao function for edit packaging details
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<ProductionPipePackagingModel> editpackaging(String mBatchId, String mThickId, String slitBatchId) {
		logger.info("Method : editpolishing starts");
		List<ProductionPipePackagingModel> mCoilList = new ArrayList<ProductionPipePackagingModel>();

		String value = "SET @p_mBatchId='" + mBatchId + "',@p_mThickId='" + mThickId + "',@p_slitBatchId='"
				+ slitBatchId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("pipePackagingRoutines")
					.setParameter("actionType", "editpackaging").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				ProductionPipePackagingModel packaging = new ProductionPipePackagingModel(m[0], m[1], m[2], m[3], m[4],
						DateFormatter.returnStringDate(m[5]), DateFormatter.returnStringDate(m[6]), m[7], m[8], m[9],
						m[10], m[11], m[12], null, null, null, null, null, null, m[13], null, null, m[14], m[15], m[16],
						m[17]);

				mCoilList.add(packaging);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editpackaging ends");

		return mCoilList;
	}

	/*
	 * for modal view for production details
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionPipePackagingModel>>> getPackagingDetailsModal(String mBatchId,
			String mThickId, String slitBatchId, String slitWidth, String pipeSize) {

		logger.info("Method : getPolishingDetailsModal starts");

		List<ProductionPipePackagingModel> pipeList = new ArrayList<ProductionPipePackagingModel>();
		JsonResponse<List<ProductionPipePackagingModel>> resp = new JsonResponse<List<ProductionPipePackagingModel>>();

		try {

			String value = "SET @p_mBatchId='" + mBatchId + "',@p_mThickId='" + mThickId + "',@p_slitBatchId='"
					+ slitBatchId + "',@p_slitWidth='" + slitWidth + "',@p_pipeSize='" + pipeSize + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("pipePackagingRoutines")
					.setParameter("actionType", "getDetailsModal").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				ProductionPipePackagingModel pipe = new ProductionPipePackagingModel(m[0], m[1], m[2], m[3], m[4],
						DateFormatter.returnStringDate(m[5]), DateFormatter.returnStringDate(m[6]), m[7], m[8], m[9],
						m[10], m[11], m[12], DateFormatter.returnStringDate(m[13]),
						DateFormatter.returnStringDate(m[14]), m[15], m[16], m[17], m[18], m[19], m[20], m[21], m[22],
						m[23], m[24], m[25]);

				pipeList.add(pipe);

			}
			resp.setBody(pipeList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<ProductionPipePackagingModel>>> response = new ResponseEntity<JsonResponse<List<ProductionPipePackagingModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getPolishingDetailsModal ends");

		return response;
	}

	/*
	 * for draft packing details
	 */
	public ResponseEntity<JsonResponse<Object>> draftPackagingDetails(List<ProductionPipePackagingModel> draftObj) {

		logger.info("Method in Dao: draftPackagingDetails starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String values = "";
		for (ProductionPipePackagingModel a : draftObj) {
			if (a.gettMotherCoilBatch() == null || a.gettMotherCoilBatch() == "") {
				resp.setMessage("Mother Coil Batch is required");
				validity = false;
			}

		}
		values = GenerateProductionPackagingParam.addPackageingParam(draftObj);
		if (validity)
			try {

				em.createNamedStoredProcedureQuery("pipePackagingRoutines")
						.setParameter("actionType", "draftPipePacking").setParameter("actionValue", values).execute();

			} catch (Exception e) {
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: draftPackagingDetails ends");

		return response;
	}

	/*
	 * 
	 * Dao function for packaging details
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<ProductionPipePackagingModel> getPackaingDetails(String mBatchId, String mThickId, String slitBatchId,
			String slitWidth, String pipeSize, String subBatch) {
		logger.info("Method : getPackaingDetails starts");
		List<ProductionPipePackagingModel> packagingList = new ArrayList<ProductionPipePackagingModel>();

		String value = "SET @p_mBatchId='" + mBatchId + "',@p_mThickId='" + mThickId + "',@p_slitBatchId='"
				+ slitBatchId + "',@p_slitWidth='" + slitWidth + "',@p_pipeSize='" + pipeSize + "',@p_subBatch='"
				+ subBatch + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("pipePackagingRoutines")
					.setParameter("actionType", "getPackaingDetails").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				ProductionPipePackagingModel pipePackaging = new ProductionPipePackagingModel(null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, m[0], m[1], null, m[2], null,
						m[3], m[4], null, null, null, null);

				packagingList.add(pipePackaging);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPackaingDetails ends");

		return packagingList;
	}

	public ResponseEntity<JsonResponse<List<ProductionPipePackagingModel>>> getAllpackagingReports(String grade,
			String thickness, String startDate, String endDate, String slitWidth, String pipeSize) {
		logger.info("Method in Dao: getAllpackagingReports starts");

		List<ProductionPipePackagingModel> NonPolishList = new ArrayList<ProductionPipePackagingModel>();

		String values = "SET @p_grade='" + grade + "',@p_thickness='" + thickness + "',@p_slitWidth='" + slitWidth
				+ "';";
		Integer total = 0;
		try {
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("pipePackagingRoutines")
					.setParameter("actionType", "pipePackagingReport").setParameter("actionValue", values)
					.getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					ProductionPipePackagingModel packaging = new ProductionPipePackagingModel(m[0], m[1], m[2], m[3],
							m[4], DateFormatter.returnStringDate(m[5]), DateFormatter.returnStringDate(m[6]), m[7],
							m[8], m[9], m[10], m[11], m[12], DateFormatter.returnStringDate(m[13]),
							DateFormatter.returnStringDate(m[14]), m[15], m[16], m[17], m[18], m[19], m[20], m[21],
							m[22], m[23], m[24], m[25]);

					NonPolishList.add(packaging);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ProductionPipePackagingModel>> resp = new JsonResponse<List<ProductionPipePackagingModel>>();
		resp.setBody(NonPolishList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ProductionPipePackagingModel>>> response = new ResponseEntity<JsonResponse<List<ProductionPipePackagingModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getAllpackagingReports ends");

		return response;
	}

	/*
	 * for view packaging details
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionPipePackagingModel>>> getPackagingDetails(
			DataTableRequest request) {

		logger.info("Method in Dao: getPackagingDetails starts");

		List<ProductionPipePackagingModel> getMCoil = new ArrayList<ProductionPipePackagingModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("pipePackagingRoutines")
					.setParameter("actionType", "getPackagingDetails").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object startDate = null;
					Object endDate = null;
					if (m[7] != null) {
						startDate = DateFormatter.returnStringDate(m[7]);
					}
					if (m[8] != null) {
						endDate = DateFormatter.returnStringDate(m[8]);
					}
					ProductionPipePackagingModel motherCoil = new ProductionPipePackagingModel(m[0], m[1], m[2], m[3],
							m[4], DateFormatter.returnStringDate(m[5]), DateFormatter.returnStringDate(m[6]), null,
							null, null, null, null, null, startDate, endDate, null, null, m[9], m[10], null, null, null,
							m[11], m[12], m[13], null);

					getMCoil.add(motherCoil);

				}
				if (x.get(0).length > 14) {
					BigInteger t = (BigInteger) x.get(0)[14];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ProductionPipePackagingModel>> resp = new JsonResponse<List<ProductionPipePackagingModel>>();
		resp.setBody(getMCoil);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ProductionPipePackagingModel>>> response = new ResponseEntity<JsonResponse<List<ProductionPipePackagingModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getPackagingDetails ends");

		return response;
	}

}
