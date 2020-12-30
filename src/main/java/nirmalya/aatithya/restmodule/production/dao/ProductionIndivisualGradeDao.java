package nirmalya.aatithya.restmodule.production.dao;

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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.production.model.ProductionGradeDetailsModel;
import nirmalya.aatithya.restmodule.sales.dao.DeliveryChallanDao;

@Repository
public class ProductionIndivisualGradeDao {

	Logger logger = LoggerFactory.getLogger(DeliveryChallanDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * Drop down for job type list
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductionGradeDetailsModel>>> getProductionGradeDetails(String fromDate,
			String toDate, String thickness) {

		logger.info("Method : getProductionGradeDetails starts");

		List<ProductionGradeDetailsModel> planningList = new ArrayList<ProductionGradeDetailsModel>();
		JsonResponse<List<ProductionGradeDetailsModel>> resp = new JsonResponse<List<ProductionGradeDetailsModel>>();

		try {
			String value = "SET @p_fromaDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "',@p_thickness='" + thickness + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("productionGrade")
					.setParameter("actionType", "getGradeData").setParameter("actionValue", value).getResultList();
			double totalSale = 0;
			for (Object[] m : x) {

				ProductionGradeDetailsModel data = new ProductionGradeDetailsModel(m[0], m[1], null, m[2], m[3], m[4],
						m[5], null, null, m[6], null, m[7], null);
				planningList.add(data);
				totalSale = totalSale + data.getSales();
			}
			if (totalSale != 0) {
				for (ProductionGradeDetailsModel a : planningList) {

					a.setRatio((a.getSales() / totalSale) * 100);
				}
			}

			resp.setBody(planningList);

		} catch (Exception e) {
			e.printStackTrace();
		} 
		ResponseEntity<JsonResponse<List<ProductionGradeDetailsModel>>> response = new ResponseEntity<JsonResponse<List<ProductionGradeDetailsModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getProductionGradeDetails ends");
		return response;
	}

	/**
	 * for dependent list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getGrade() {

		logger.info("Method : getGrade starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productionGrade")
					.setParameter("actionType", "getGrade").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getGrade ends");

		return employmentList;
	}

	/*
	 * DAO Function to view particular Property type in dropDown
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getThicknessByGrade(String id) {
		logger.info("Method : getThicknessByGrade starts");
		List<DropDownModel> propNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_grade='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productionGrade")
					.setParameter("actionType", "getThicknessByGrade").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				propNameList.add(dropDownModel);
			}

			resp.setBody(propNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getThicknessByGrade ends");
		return response;
	}
}
