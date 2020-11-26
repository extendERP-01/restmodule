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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.production.model.PipeProductionDashboardModel;
import nirmalya.aatithya.restmodule.production.model.ProductionPipeProductionModel;

@Repository
public class ProductionPipeProductionDao {

	Logger logger = LoggerFactory.getLogger(ProductionPipeProductionDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for all Mother Coil view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionPipeProductionModel>>> productionDetails(
			DataTableRequest request) {

		logger.info("Method in Dao: productionDetails starts");

		try {
			if (!request.getParam3().isEmpty())
				request.setParam3(DateFormatter.getStringDate(request.getParam3()));

			if (!request.getParam4().isEmpty())
				request.setParam4(DateFormatter.getStringDate(request.getParam4()));
		} catch (Exception e) {
			logger.error("Can not Convert Date");
		}

		List<ProductionPipeProductionModel> getMCoil = new ArrayList<ProductionPipeProductionModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("pipeProductionRoutines")
					.setParameter("actionType", "productionDetails").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					ProductionPipeProductionModel motherCoil = new ProductionPipeProductionModel(m[0], m[1], m[2], m[3],
							m[4], DateFormatter.returnStringDate(m[5]), DateFormatter.returnStringDate(m[6]), null,
							null, null, null, null, null, null, null, null, null, m[7], m[8], m[9],null);

					getMCoil.add(motherCoil);

				}
				if (x.get(0).length > 10) {
					BigInteger t = (BigInteger) x.get(0)[10];

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
		logger.info("Method in Dao: productionDetails ends");

		return response;
	}

	/*
	 * for all Mother Coil view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionPipeProductionModel>>> getProductionDetails(
			DataTableRequest request) {

		logger.info("Method in Dao: getProductionDetails starts");

		try {
			if (!request.getParam3().isEmpty())
				request.setParam3(DateFormatter.getStringDate(request.getParam3()));

			if (!request.getParam4().isEmpty())
				request.setParam4(DateFormatter.getStringDate(request.getParam4()));
		} catch (Exception e) {
			logger.error("Can not Convert Date");
		}

		List<ProductionPipeProductionModel> getMCoil = new ArrayList<ProductionPipeProductionModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("pipeProductionRoutines")
					.setParameter("actionType", "getProductionDetails").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object startDate = null;
					Object endDate = null;
					if (m[7] != null)
						startDate = DateFormatter.returnStringDate(m[7]);
					if (m[8] != null)
						endDate = DateFormatter.returnStringDate(m[7]);
					ProductionPipeProductionModel motherCoil = new ProductionPipeProductionModel(m[0], m[1], m[2], m[3],
							m[4], DateFormatter.returnStringDate(m[5]), DateFormatter.returnStringDate(m[6]), null,
							null, null ,null ,null, startDate, endDate, m[9], m[10],  null,  m[11], m[12], m[13] ,null);

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

		JsonResponse<List<ProductionPipeProductionModel>> resp = new JsonResponse<List<ProductionPipeProductionModel>>();
		resp.setBody(getMCoil);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ProductionPipeProductionModel>>> response = new ResponseEntity<JsonResponse<List<ProductionPipeProductionModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getProductionDetails ends");

		return response;
	}

	/*
	 * for add production details
	 */
	public ResponseEntity<JsonResponse<Object>> addProductionDetails(
			List<ProductionPipeProductionModel> productionPipeProductionModelList) {

		logger.info("Method in Dao: addProductionDetails starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String values = "";
		for (ProductionPipeProductionModel a : productionPipeProductionModelList) {
			if (a.gettMotherCoilBatch() == null || a.gettMotherCoilBatch() == "") {
				resp.setMessage("Mother Coil Batch is required");
				validity = false;
			}

		}
		for (ProductionPipeProductionModel a : productionPipeProductionModelList) {
			values = "SET @p_tMotherCoilBatch='" + a.gettMotherCoilBatch() + "',@p_tMotherCoilThickness='"
					+ a.gettMotherCoilThickness() + "',@p_tPipeSlitBatch='" + a.gettPipeSlitBatch()
					+ "',@p_tPipeSlitWidth='" + a.gettPipeSlitWidth() + "',@p_tPipeSize='" + a.gettPipeSize()
					+ "',@p_productionStartDate='" + DateFormatter.getStringDate(a.getProductionStartDate())
					+ "',@p_productionEndDate='" + DateFormatter.getStringDate(a.getProductionEndDate())
					+ "',@p_productionQty='" + a.getProductionQty() + "',@p_productionWt='" + a.getProductionWt()
					+ "',@p_scrapWt1='" + a.getScrapWt1() + "',@p_scrapWt2='" + a.getScrapWt2() + "',@p_scrapWt3='"
					+ a.getScrapWt3() + "',@p_scrapQty1='" + a.getScrapQty1() + "',@p_scrapQty2='" + a.getScrapQty2()
					+ "',@p_scrapQty3='" + a.getScrapQty3() + "',@p_tPipeCreatedBy='" + a.gettPipeCreatedBy() + "';";
		}

		if (validity)
			try {

				em.createNamedStoredProcedureQuery("pipeProductionRoutines")
						.setParameter("actionType", "modifyPipeProduction").setParameter("actionValue", values)
						.execute();

			} catch (Exception e) {
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: addProductionDetails ends");

		return response;
	}

	/*
	 * for modal view for production details
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionPipeProductionModel>>> getProductionDetailsModal(String mBatchId,
			String mThickId, String slitBatchId, String slitWidth, String pipeSize) {

		logger.info("Method : getProductionDetailsModal starts");

		List<ProductionPipeProductionModel> productionPipeProductionModelList = new ArrayList<ProductionPipeProductionModel>();
		JsonResponse<List<ProductionPipeProductionModel>> resp = new JsonResponse<List<ProductionPipeProductionModel>>();

		try {

			String value = "SET @p_mBatchId='" + mBatchId + "',@p_mThickId='" + mThickId + "',@p_slitBatchId='"
					+ slitBatchId + "',@p_slitWidth='" + slitWidth + "',@p_pipeSize='" + pipeSize + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("pipeProductionRoutines")
					.setParameter("actionType", "getDetailsModal").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				ProductionPipeProductionModel productionPipeProductionModel = new ProductionPipeProductionModel(m[0],
						m[1], m[2], m[3], m[4], DateFormatter.returnStringDate(m[5]),
						DateFormatter.returnStringDate(m[6]), m[7], m[8], m[9], null, m[10],
						DateFormatter.returnStringDate(m[11]), DateFormatter.returnStringDate(m[12]), m[13], m[14],
						m[15], m[16], m[17], m[18], m[19]);

				productionPipeProductionModelList.add(productionPipeProductionModel);

			}
			resp.setBody(productionPipeProductionModelList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<ProductionPipeProductionModel>>> response = new ResponseEntity<JsonResponse<List<ProductionPipeProductionModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getProductionDetailsModal ends");

		return response;
	}

	/*
	 * for all pipe Production Report
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionPipeProductionModel>>> getAllProductionReports(String grade,
			String thickness, String startDate, String endDate, String slitWidth, String pipeSize) {

		logger.info("Method in Dao: getAllProductionReports  starts");

		List<ProductionPipeProductionModel> productuonList = new ArrayList<ProductionPipeProductionModel>();

		if (startDate != null && startDate != "") {
			startDate = DateFormatter.getStringDate(startDate);
		}
		if (endDate != null && endDate != "") {
			endDate = DateFormatter.getStringDate(endDate);
		}
		String values = "SET @P_grade='" + grade + "',@P_thickness='" + thickness + "',@P_startDate='" + startDate
				+ "',@P_endDate='" + endDate + "',@P_slitWidth='" + slitWidth + "',@P_pipeSize='" + pipeSize + "';";

		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("pipeProductionRoutines")
					.setParameter("actionType", "pipeProductionReport").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					ProductionPipeProductionModel productionPipeProductionModel = new ProductionPipeProductionModel(
							m[0], m[1], m[2], m[3], m[4], DateFormatter.returnStringDate(m[5]),
							DateFormatter.returnStringDate(m[6]), m[7], m[8], m[9], null, m[10],
							DateFormatter.returnStringDate(m[11]), DateFormatter.returnStringDate(m[12]), m[13], m[14],
							m[15], m[16], m[17], m[18] ,m[19]);

					productuonList.add(productionPipeProductionModel);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<ProductionPipeProductionModel>> resp = new JsonResponse<List<ProductionPipeProductionModel>>();
		resp.setBody(productuonList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ProductionPipeProductionModel>>> response = new ResponseEntity<JsonResponse<List<ProductionPipeProductionModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getAllProductionReports ends");

		return response;
	}

	/*
	 * DAO Function to get slit width from thickness
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSlitWidthByThickness(String id, String thickness) {
		logger.info("Method : getSlitWidthByThickness starts");
		List<DropDownModel> propNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_grade='" + id + "',@P_thickness='" + thickness + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("pipeProductionRoutines")
					.setParameter("actionType", "getSlitWidth").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1].toString());
				propNameList.add(dropDownModel);
			}

			resp.setBody(propNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSlitWidthByThickness ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<PipeProductionDashboardModel> viewTotalProductionDashBoard() {
		logger.info("Method : viewTotalProductionDashBoard Dao starts");

		List<PipeProductionDashboardModel> dashboardList = new ArrayList<PipeProductionDashboardModel>();
		JsonResponse<List<PipeProductionDashboardModel>> resp = new JsonResponse<List<PipeProductionDashboardModel>>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("pipeProductionRoutines")
					.setParameter("actionType", "viewTotalCount").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				PipeProductionDashboardModel pipeProductionDashboardModel = new PipeProductionDashboardModel(m[0], m[1],
						m[2], m[3], m[4]);

				dashboardList.add(pipeProductionDashboardModel);

			}
			resp.setBody(dashboardList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewTotalProductionDashBoard ends"); 
		return dashboardList;
	}
}
