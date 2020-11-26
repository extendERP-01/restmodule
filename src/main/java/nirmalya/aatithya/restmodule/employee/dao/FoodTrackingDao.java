package nirmalya.aatithya.restmodule.employee.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateFoodTrackParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.EmployeeFoodTrackingRestModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class FoodTrackingDao {

	Logger logger = LoggerFactory.getLogger(FoodTrackingDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<EmployeeFoodTrackingRestModel>>> getEmployeeDetailsForFoodTracking(String id) {
		logger.info("Method : getEmployeeDetailsForFoodTracking Dao starts");

		List<EmployeeFoodTrackingRestModel> grnList = new ArrayList<EmployeeFoodTrackingRestModel>();
		JsonResponse<List<EmployeeFoodTrackingRestModel>> resp = new JsonResponse<List<EmployeeFoodTrackingRestModel>>();

		try {
			String value = "SET @p_searchValue='" + DateFormatter.getStringDate(id) + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("foodTracking")
					.setParameter("actionType", "getEmpFoodDtls").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				EmployeeFoodTrackingRestModel dropDownModel = new EmployeeFoodTrackingRestModel(m[0], m[1], null, m[2], m[3], null, null);
				grnList.add(dropDownModel);
			}
			resp.setBody(grnList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<EmployeeFoodTrackingRestModel>>> response = new ResponseEntity<JsonResponse<List<EmployeeFoodTrackingRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println(response);
		logger.info("Method : getEmployeeDetailsForFoodTracking Dao ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> saveFoodTrackIngData(List<EmployeeFoodTrackingRestModel> testData) {
		logger.info("Method : saveFoodTrackIngData starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (EmployeeFoodTrackingRestModel l : testData) {

			if (l.getEmployeeId() == null || l.getEmployeeId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Employee Required");
				break;
			} else if (l.getDate() == null || l.getDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Date Required");
				break;
			}
		}
		if (validity) {
			try {
				String values = GenerateFoodTrackParameter.addFoodTrackData(testData);
				
//				if (flakiness.get(0).getConformityId() != null && flakiness.get(0).getConformityId() != "") {
					
//					em.createNamedStoredProcedureQuery("compresiveRoutines").setParameter("actionType", "modifyData")
//							.setParameter("actionValue", values).execute();
//				} else {
					
					em.createNamedStoredProcedureQuery("foodTracking")
						.setParameter("actionType", "addTrackingData")
						.setParameter("actionValue", values)
						.execute();
//				}
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
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveFoodTrackIngData ends");
		return response;
	}
}
