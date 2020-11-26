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
import nirmalya.aatithya.restmodule.production.model.ProductionGocoolProdModel;

@Repository
public class ProductionProdGocoolDao {

	Logger logger = LoggerFactory.getLogger(ProductionProdGocoolDao.class);
	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	private static final String PROCEDURE_NAME = "gocool-prod-planning";
	private static final String ACTION_TYPE = "actionType";
	private static final String ACTION_VALUE = "actionValue";

	/*
	 * for all Mother Coil view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionGocoolProdModel>>> viewProdctions(DataTableRequest request) {

		logger.info("Method in Dao: viewProdctionMix starts");

		List<ProductionGocoolProdModel> getMCoil = new ArrayList<ProductionGocoolProdModel>();
		try {
			if (!request.getParam3().isEmpty())
				request.setParam3(DateFormatter.getStringDate(request.getParam3()));

			if (!request.getParam4().isEmpty())
				request.setParam4(DateFormatter.getStringDate(request.getParam4()));
		} catch (Exception e) {
			logger.error("Can not Convert Date");
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "viewProdctions").setParameter(ACTION_VALUE, values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					ProductionGocoolProdModel motherCoil = new ProductionGocoolProdModel(m[0], m[1], m[2], m[3], m[4],
							m[5], m[6], null, null, null, m[7], null, null, null, null, null, null, m[8], m[9]);

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

		JsonResponse<List<ProductionGocoolProdModel>> resp = new JsonResponse<List<ProductionGocoolProdModel>>();
		resp.setBody(getMCoil);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ProductionGocoolProdModel>>> response = new ResponseEntity<JsonResponse<List<ProductionGocoolProdModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: viewProdctionMix ends");

		return response;
	}

	/*
	 * for add production details
	 */
	public ResponseEntity<JsonResponse<Object>> addProductionDetails(
			List<ProductionGocoolProdModel> productionPipeProductionModelList) {

		logger.info("Method in Dao: addProductionDetails starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String values = "";
		for (ProductionGocoolProdModel a : productionPipeProductionModelList) {
			if (a.getProdId() == null || a.getProdId().isEmpty()) {
				resp.setMessage("Production  is required");
				validity = false;
			}

		}
		for (ProductionGocoolProdModel a : productionPipeProductionModelList) {
			values = "SET @p_prodId='" + a.getProdId() + "',@p_productionStartDate='"
					+ DateFormatter.getStringDate(a.getProdStartDate()) + "',@p_productionEndDate='"
					+ DateFormatter.getStringDate(a.getProdEndtDate()) + "',@p_productionQty='" + a.getProdoductionQty()
					+ "',@p_productionWt='" + a.getProdoductionWt() + "',@p_scrapWt='" + a.getSrcapWt()
					+ "',@p_scrapQty='" + a.getScrapQty() + "',@p_tPipeCreatedBy='" + a.getCreatedBy() + "';";
		}
		if (Boolean.TRUE.equals(validity))
			try {

				em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, "addProductionDtls")
						.setParameter(ACTION_VALUE, values).execute();

			} catch (Exception e) {
				e.printStackTrace();
				resp.setMessage(e.getMessage());
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
	public ResponseEntity<JsonResponse<List<ProductionGocoolProdModel>>> getProductionDetailsModal(String prodId) {

		logger.info("Method : getProductionDetailsModal starts");

		List<ProductionGocoolProdModel> pipeList = new ArrayList<ProductionGocoolProdModel>();
		JsonResponse<List<ProductionGocoolProdModel>> resp = new JsonResponse<List<ProductionGocoolProdModel>>();

		try {

			String value = "SET @p_prodId='" + prodId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "getDetailsModal").setParameter(ACTION_VALUE, value).getResultList();

			for (Object[] m : x) {

				ProductionGocoolProdModel pipe = new ProductionGocoolProdModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						null, null, null, m[7], DateFormatter.returnStringDate(m[8]),
						DateFormatter.returnStringDate(m[9]), m[10], m[11], m[12], m[13], m[14], null);

				pipeList.add(pipe);

			}
			resp.setBody(pipeList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<ProductionGocoolProdModel>>> response = new ResponseEntity<JsonResponse<List<ProductionGocoolProdModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getProductionDetailsModal ends");

		return response;
	}
}
