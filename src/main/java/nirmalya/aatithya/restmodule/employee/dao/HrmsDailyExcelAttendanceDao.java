package nirmalya.aatithya.restmodule.employee.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateDailyExcelAttendanceParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.HrmsDailyAttendanceExcelModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsSalaryModel;

@Repository
public class HrmsDailyExcelAttendanceDao {

	Logger logger = LoggerFactory.getLogger(HrmsDailyExcelAttendanceDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for add other service price
	 */
	public ResponseEntity<JsonResponse<Object>> saveAllExcelAttendanceData(
			List<HrmsDailyAttendanceExcelModel> hrmsEmployeeDependentModel) {

		logger.info("Method in Dao: saveAllExcelAttendanceData starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		for (HrmsDailyAttendanceExcelModel a : hrmsEmployeeDependentModel) {
			if (a.getBioMetricId() == null || a.getBioMetricId() == "") {
				resp.setMessage("Bio Metraic not Selected");
				validity = false;
			} else if (a.getDate() == null || a.getDate() == "") {
				resp.setMessage("Date is required");
				validity = false;
			}

		}
		if (validity)
			try {
				String values = GenerateDailyExcelAttendanceParam
						.getAddDailyAttendanceParam(hrmsEmployeeDependentModel);
				System.out.println(values);
				em.createNamedStoredProcedureQuery("dailyExcelUpload").setParameter("actionType", "addAttExcelData")
						.setParameter("actionValue", values).execute();

			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					if (err[0].matches("1062")) {
						resp.setMessage("Dependent Already Added.");
					} else {
						resp.setMessage(err[1]);
					}
					resp.setCode(err[0]);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: saveAllExcelAttendanceData ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsDailyAttendanceExcelModel>>> getDailyData(String date) {
		logger.info("Rest Controller : getDailyData Starts");
		List<HrmsDailyAttendanceExcelModel> salaryList = new ArrayList<HrmsDailyAttendanceExcelModel>();
		try {
			String values = "SET @p_date = '" + DateFormatter.getStringDate(date) + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("dailyExcelUpload")
					.setParameter("actionType", "getDailyData").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					HrmsDailyAttendanceExcelModel employe = new HrmsDailyAttendanceExcelModel(m[0], m[1], m[2], m[3],
							m[4], m[5]);
					if (employe.getBioMetricId() == null) {
						employe.setBioMetricId("--");
					}
					if (employe.getInTime() == null) {
						employe.setInTime("--");
					}

					if (employe.getOutTime() == null) {
						employe.setOutTime("--");
					}
					salaryList.add(employe);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsDailyAttendanceExcelModel>> resp = new JsonResponse<List<HrmsDailyAttendanceExcelModel>>();
		resp.setBody(salaryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsDailyAttendanceExcelModel>>> response = new ResponseEntity<JsonResponse<List<HrmsDailyAttendanceExcelModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getDailyData ends");
		return response;
	}
	
	/*
	 * for add other service price
	 */
	public ResponseEntity<JsonResponse<Object>> saveAllAttendanceData(
			List<HrmsDailyAttendanceExcelModel> hrmsEmployeeDependentModel) {

		logger.info("Method in Dao: saveAllAttendanceData starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		for (HrmsDailyAttendanceExcelModel a : hrmsEmployeeDependentModel) {
			if (a.getBioMetricId() == null || a.getBioMetricId() == "") {
				resp.setMessage("Bio Metraic not Selected");
				validity = false;
			} else if (a.getDate() == null || a.getDate() == "") {
				resp.setMessage("Date is required");
				validity = false;
			}

		}
		if (validity)
			try {
				String values = GenerateDailyExcelAttendanceParam
						.getDailyAttendanceUpdateParam(hrmsEmployeeDependentModel);
				System.out.println(values);
				em.createNamedStoredProcedureQuery("dailyExcelUpload").setParameter("actionType", "updateAttData")
						.setParameter("actionValue", values).execute();

			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					if (err[0].matches("1062")) {
						resp.setMessage("Dependent Already Added.");
					} else {
						resp.setMessage(err[1]);
					}
					resp.setCode(err[0]);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: saveAllAttendanceData ends");

		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsDailyAttendanceExcelModel>>> getDailyUpdatedData(String date) {
		logger.info("Rest Controller : getDailyUpdatedData Starts");
		List<HrmsDailyAttendanceExcelModel> salaryList = new ArrayList<HrmsDailyAttendanceExcelModel>();
		try {
			String values = "SET @p_date = '" + DateFormatter.getStringDate(date) + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("dailyExcelUpload")
					.setParameter("actionType", "getDailyUpdatedData").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					HrmsDailyAttendanceExcelModel employe = new HrmsDailyAttendanceExcelModel(m[0], m[1], m[2], m[3],
							m[4], m[5]);
					if (employe.getBioMetricId() == null) {
						employe.setBioMetricId("--");
					}
					if (employe.getInTime() == null) {
						employe.setInTime("--");
					}

					if (employe.getOutTime() == null) {
						employe.setOutTime("--");
					}
					salaryList.add(employe);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsDailyAttendanceExcelModel>> resp = new JsonResponse<List<HrmsDailyAttendanceExcelModel>>();
		resp.setBody(salaryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsDailyAttendanceExcelModel>>> response = new ResponseEntity<JsonResponse<List<HrmsDailyAttendanceExcelModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getDailyUpdatedData ends");
		return response;
	}
	
}
