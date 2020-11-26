package nirmalya.aatithya.restmodule.planning.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateGradeRevisionParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.HrmsEmployeeDao;
import nirmalya.aatithya.restmodule.planning.model.EmployeeSalaryIncementModel;
import nirmalya.aatithya.restmodule.planning.model.HrmsGraderevisionModel;

@Repository
public class HrmsGradeRevisionDao {
	Logger logger = LoggerFactory.getLogger(HrmsEmployeeDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * Drop down for employee list
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmployeeList(String deptId, String fromDate,
			String toDate) {

		logger.info("Method : getEmployeeList starts");

		List<DropDownModel> UserRoleList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_deptId='" + deptId + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate)
					+ "',@p_toDate='" + DateFormatter.getStringDate(toDate) + "';";

			System.out.println("value " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("gradeRevisionRoutines")
					.setParameter("actionType", "getEmployeeList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				UserRoleList.add(dropDownModel);
			}

			resp.setBody(UserRoleList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getEmployeeList ends");
		return response;
	}

	/*
	 * Drop down for employee list
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsGraderevisionModel>>> getEmployeeDetails(String deptId, String empId,
			String fromDate, String toDate) {

		logger.info("Method : getEmployeeDetails starts");

		List<HrmsGraderevisionModel> UserRoleList = new ArrayList<HrmsGraderevisionModel>();
		JsonResponse<List<HrmsGraderevisionModel>> resp = new JsonResponse<List<HrmsGraderevisionModel>>();

		try {
			String value = "SET @p_deptId='" + deptId + "',@p_empId='" + empId + "',@p_fromDate='"
					+ DateFormatter.getStringDate(fromDate) + "',@p_toDate='" + DateFormatter.getStringDate(toDate)
					+ "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("gradeRevisionRoutines")
					.setParameter("actionType", "getEmployeeDetails").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				HrmsGraderevisionModel dropDownModel = new HrmsGraderevisionModel(null, null, null, null, null, m[0],
						m[1], m[2], m[3], null, null, null, null, null, null);
				UserRoleList.add(dropDownModel);
			}

			resp.setBody(UserRoleList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<HrmsGraderevisionModel>>> response = new ResponseEntity<JsonResponse<List<HrmsGraderevisionModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getEmployeeDetails ends");
		return response;
	}

	/*
	 * for add production Mix
	 */
	public ResponseEntity<JsonResponse<Object>> saveGradeRevisionData(
			List<HrmsGraderevisionModel> HrmsGraderevisionModelList) {

		logger.info("Method in Dao: saveGradeRevisionData starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		List<EmployeeSalaryIncementModel> list = new ArrayList<EmployeeSalaryIncementModel>();
		for (HrmsGraderevisionModel a : HrmsGraderevisionModelList) {
			if (a.getEmployeeId() == null || a.getEmployeeId().isEmpty()) {
				resp.setMessage("Employee is required");
				validity = false;
			}

		}
		if (Boolean.TRUE.equals(validity))
			try {
				String values = GenerateGradeRevisionParam.addGradeRevisionParam(HrmsGraderevisionModelList);
				System.out.println("values " + values);
				@SuppressWarnings("unchecked")
				List<Object[]> x = em.createNamedStoredProcedureQuery("gradeRevisionRoutines")
						.setParameter("actionType", "saveGradeRevision").setParameter("actionValue", values)
						.getResultList();

				for (Object[] m : x) {
					EmployeeSalaryIncementModel dropDownModel = new EmployeeSalaryIncementModel(m[0], m[1], m[2], m[3],
							m[4], m[5], m[6], m[7], m[8], m[9]);
					dropDownModel.setEffectiveDate(HrmsGraderevisionModelList.get(0).getEffectiveDate());
					list.add(dropDownModel);
				}

				resp.setBody(list);

			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);

					resp.setCode(err[0]);

				} catch (Exception e1) {
					resp.setMessage(e.getMessage());
				}
			}
		System.out.println("resp" + resp);
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: saveGradeRevisionData ends");

		return response;
	}

	/*
	 * for add production Mix
	 */
	public ResponseEntity<JsonResponse<Object>> saveIncrementData(List<EmployeeSalaryIncementModel> incrementList) {

		logger.info("Method in Dao: saveIncrementData starts");
		System.out.println("incrementList" + incrementList);
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		for (EmployeeSalaryIncementModel a : incrementList) {
			if (a.getEmpId() == null || a.getEmpId().isEmpty()) {
				resp.setMessage("Employee is required");
				validity = false;
			}

		}
		if (Boolean.TRUE.equals(validity))
			try {
				String values = GenerateGradeRevisionParam.addIncrementParam(incrementList);
				 System.out.println("values" + values);
				em.createNamedStoredProcedureQuery("gradeRevisionRoutines")
						.setParameter("actionType", "saveIncrementData").setParameter("actionValue", values).execute();
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

		logger.info("Method in Dao: saveIncrementData ends");

		return response;
	}

}
