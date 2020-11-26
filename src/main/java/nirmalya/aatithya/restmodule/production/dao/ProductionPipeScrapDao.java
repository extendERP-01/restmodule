package nirmalya.aatithya.restmodule.production.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.production.model.ProductionPipeScrapModel;

@Repository
public class ProductionPipeScrapDao {

	Logger logger = LoggerFactory.getLogger(ProductionPipeScrapDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for all pipe Production Report
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionPipeScrapModel>>> getAllScrapReports(String grade,
			String thickness, String startDate, String endDate, String slitWidth, String pipeSize) {

		logger.info("Method in Dao: getAllScrapReports  starts");

		List<ProductionPipeScrapModel> productuonList = new ArrayList<ProductionPipeScrapModel>();

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

			List<Object[]> x = em.createNamedStoredProcedureQuery("pipeScrapRoutines")
					.setParameter("actionType", "pipeScrapReport").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					ProductionPipeScrapModel productionPipeProductionModel = new ProductionPipeScrapModel(m[0], m[1],
							m[2], m[3], m[4], DateFormatter.returnStringDate(m[5]),
							DateFormatter.returnStringDate(m[6]), m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14],
							m[15], m[16]);

					productuonList.add(productionPipeProductionModel);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<ProductionPipeScrapModel>> resp = new JsonResponse<List<ProductionPipeScrapModel>>();
		resp.setBody(productuonList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ProductionPipeScrapModel>>> response = new ResponseEntity<JsonResponse<List<ProductionPipeScrapModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getAllScrapReports ends");

		return response;
	}

}
