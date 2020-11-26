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
import nirmalya.aatithya.restmodule.common.utils.GenerateEmployeeIncomeTaxParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.EmployeeIncomeTaxDetails;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class HrmsIncomeTaxDetailsDao {
	Logger logger = LoggerFactory.getLogger(HrmsIncomeTaxDetailsDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<EmployeeIncomeTaxDetails>>> getEmployeeDetailsForIncomeTax(String fromDate,
			String toDate) {
		logger.info("Method : getEmployeeDetailsForIncomeTax Dao starts");

		List<EmployeeIncomeTaxDetails> grnList = new ArrayList<EmployeeIncomeTaxDetails>();
		JsonResponse<List<EmployeeIncomeTaxDetails>> resp = new JsonResponse<List<EmployeeIncomeTaxDetails>>();

		try {
			String value = "SET @p_fromDate='" + DateFormatter.getStringDate(fromDate) + "'," + "@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("emplyeeIncomeTaxRoutines")
					.setParameter("actionType", "getEmpDtls").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object oa = null;
				if (m[2] != null) {
					oa = DateFormatter.returnStringDate(m[2]);
				}

				Object ob = null;
				if (m[3] != null) {
					ob = DateFormatter.returnStringDate(m[3]);
				}

				EmployeeIncomeTaxDetails dropDownModel = new EmployeeIncomeTaxDetails(null,m[0], m[1], oa, ob, m[4],null);
				if (dropDownModel.getTaxAmount() == null) {
					dropDownModel.setTaxAmount(0.00);
				}
				grnList.add(dropDownModel);
			}
			resp.setBody(grnList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<EmployeeIncomeTaxDetails>>> response = new ResponseEntity<JsonResponse<List<EmployeeIncomeTaxDetails>>>(
				resp, HttpStatus.CREATED);
		System.out.println(response);
		logger.info("Method : getEmployeeDetailsForIncomeTax Dao ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> saveIncomeTaxData(List<EmployeeIncomeTaxDetails> testData) {
		logger.info("Method : saveIncomeTaxData starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (EmployeeIncomeTaxDetails l : testData) {

			if (l.getEmployeeId() == null || l.getEmployeeId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Employee Required");
				break;
			} else if (l.getFromDate() == null || l.getFromDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("From Date Required");
			} else if (l.getToDate() == null || l.getToDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("To Date Required");
				break;
			}
			break;
		}

		if (validity) {
			try {
				String values = GenerateEmployeeIncomeTaxParam.addFoodTrackData(testData);

				em.createNamedStoredProcedureQuery("emplyeeIncomeTaxRoutines")
						.setParameter("actionType", "addIncomeTaxData").setParameter("actionValue", values).execute();

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

		logger.info("Method : saveIncomeTaxData ends");
		return response;
	}
}
