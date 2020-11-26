package nirmalya.aatithya.restmodule.planning.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateWorkSheetParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.HrmsEmployeeDao;
import nirmalya.aatithya.restmodule.planning.model.HrmsWorksheetPlanningModel;

@Repository
public class HrmsWorkSheetPlanningDao {
	Logger logger = LoggerFactory.getLogger(HrmsEmployeeDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * Drop down for employee list
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsWorksheetPlanningModel>>> getEmployeeDetails(String deptId) {

		logger.info("Method : getEmployeeDetails starts");

		List<HrmsWorksheetPlanningModel> UserRoleList = new ArrayList<HrmsWorksheetPlanningModel>();
		JsonResponse<List<HrmsWorksheetPlanningModel>> resp = new JsonResponse<List<HrmsWorksheetPlanningModel>>();

		try {
			String value = "SET @p_deptId='" + deptId + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("workSheetPlanningRoutines")
					.setParameter("actionType", "getEmployeeDetails").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				HrmsWorksheetPlanningModel dropDownModel = new HrmsWorksheetPlanningModel(null, null, null, null, null,
						null, null, null, null, null, null, m[0], m[1], m[2], null, null, m[3], null);
				UserRoleList.add(dropDownModel);
			}

			resp.setBody(UserRoleList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<HrmsWorksheetPlanningModel>>> response = new ResponseEntity<JsonResponse<List<HrmsWorksheetPlanningModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getEmployeeDetails ends");
		return response;
	}

	/*
	 * for add production Mix
	 */
	public ResponseEntity<JsonResponse<Object>> saveWorkSheetData(
			List<HrmsWorksheetPlanningModel> hrmsWorksheetPlanningModelList) {

		logger.info("Method in Dao: saveWorkSheetData starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		for (HrmsWorksheetPlanningModel a : hrmsWorksheetPlanningModelList) {
			if (a.getEmployeeId() == null || a.getEmployeeId().isEmpty()) {
				resp.setMessage("Employee is required");
				validity = false;
			}
			if (a.getDepartmentId() == null || a.getDepartmentId().isEmpty()) {
				resp.setMessage("Department is required");
				validity = false;
			}
			if (a.getIncrement() == null) {
				resp.setMessage("Incement is required");
				validity = false;
			}
			if (a.getFromDate() == null || a.getFromDate().isEmpty()) {
				resp.setMessage("From Date is required");
				validity = false;
			}
			if (a.getToDate() == null || a.getToDate().isEmpty()) {
				resp.setMessage("To Date is required");
				validity = false;
			}

		}
		if (Boolean.TRUE.equals(validity))
			try {
				String values = GenerateWorkSheetParameter.saveWorkSheetParam(hrmsWorksheetPlanningModelList);
				System.out.println("values" + values);
				if (hrmsWorksheetPlanningModelList.get(0).getWorkForcePlanId() != null
						&& hrmsWorksheetPlanningModelList.get(0).getWorkForcePlanId() != "") {
					em.createNamedStoredProcedureQuery("workSheetPlanningRoutines")
							.setParameter("actionType", "modifyWorkSheetData").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("workSheetPlanningRoutines")
							.setParameter("actionType", "saveWorkSheetData").setParameter("actionValue", values)
							.execute();
				}

			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);

					resp.setCode(err[0]);

				} catch (Exception e1) {
					resp.setMessage(e.getMessage());
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: saveWorkSheetData ends");

		return response;
	}

	/*
	 * for all Grade Salary Master details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsWorksheetPlanningModel>>> getWorkPlanningDetails(
			DataTableRequest request) {

		logger.info("Method in Dao: getWorkPlanningDetails starts");

		List<HrmsWorksheetPlanningModel> measureDetails = new ArrayList<HrmsWorksheetPlanningModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("workSheetPlanningRoutines")
					.setParameter("actionType", "viewDetails").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object startDate = null;
					Object endDate = null;
					if (m[1] != null) {
						startDate = DateFormatter.returnStringDate(m[1]);
					}
					if (m[2] != null) {
						endDate = DateFormatter.returnStringDate(m[2]);
					}
					HrmsWorksheetPlanningModel measure = new HrmsWorksheetPlanningModel(m[0], startDate, endDate, m[3],
							m[4], null, null, m[5], m[6], m[7], m[8], null, null, null, null, null, null, null);
					measureDetails.add(measure);

				}

				if (x.get(0).length > 9) {
					BigInteger t = (BigInteger) x.get(0)[9];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsWorksheetPlanningModel>> resp = new JsonResponse<List<HrmsWorksheetPlanningModel>>();
		resp.setBody(measureDetails);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsWorksheetPlanningModel>>> response = new ResponseEntity<JsonResponse<List<HrmsWorksheetPlanningModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getWorkPlanningDetails ends");

		return response;
	}

	/**
	 * DAO - Get Grade Salary Master details For Modal
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsWorksheetPlanningModel>>> modalGradeSalaryMaster(String id) {

		logger.info("Method in Dao: modalGradeSalaryMaster ends");

		List<HrmsWorksheetPlanningModel> goalMasterList = new ArrayList<HrmsWorksheetPlanningModel>();

		try {

			String value = "SET @p_planId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("workSheetPlanningRoutines")
					.setParameter("actionType", "modalDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object startDate = null;
				Object endDate = null;
				if (m[1] != null) {
					startDate = DateFormatter.returnStringDate(m[1]);
				}
				if (m[2] != null) {
					endDate = DateFormatter.returnStringDate(m[2]);
				}
				HrmsWorksheetPlanningModel gradeSalaryMaster = new HrmsWorksheetPlanningModel(m[0], startDate, endDate,
						m[3], m[4], null, null, m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15]);

				goalMasterList.add(gradeSalaryMaster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsWorksheetPlanningModel>> resp = new JsonResponse<List<HrmsWorksheetPlanningModel>>();
		resp.setBody(goalMasterList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<HrmsWorksheetPlanningModel>>> response = new ResponseEntity<JsonResponse<List<HrmsWorksheetPlanningModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: modalGradeSalaryMaster ends");

		return response;
	}

}
