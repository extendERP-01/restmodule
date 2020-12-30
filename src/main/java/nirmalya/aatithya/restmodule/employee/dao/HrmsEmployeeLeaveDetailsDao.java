package nirmalya.aatithya.restmodule.employee.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateEmployeeLeaveParam;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeLeaveModel;
@Repository
public class HrmsEmployeeLeaveDetailsDao {

	Logger logger = LoggerFactory.getLogger(HrmsEmployeeLeaveDetailsDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for all advance details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEmployeeLeaveModel>>> getLeaveDetails(DataTableRequest request) {

		logger.info("Method in Dao: getLeaveDetails starts");

		List<HrmsEmployeeLeaveModel> employementList = new ArrayList<HrmsEmployeeLeaveModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("advancePaymentMasterRoutines")
					.setParameter("actionType", "viewAdvanceList").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if(m[1]!= null) {
						date = DateFormatter.returnStringDate(m[1]);
					} 
					HrmsEmployeeLeaveModel qualif = new HrmsEmployeeLeaveModel(m[0], date, m[2], m[3], m[4], m[5],
							m[6]);
					employementList.add(qualif);

				}

				if (x.get(0).length > 9) {
					BigInteger t = (BigInteger) x.get(0)[9];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsEmployeeLeaveModel>> resp = new JsonResponse<List<HrmsEmployeeLeaveModel>>();
		resp.setBody(employementList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsEmployeeLeaveModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEmployeeLeaveModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getLeaveDetails ends");

		return response;
	}

	/*
	 * for add new advance
	 */
	public ResponseEntity<JsonResponse<Object>> addLeaveDetails(HrmsEmployeeLeaveModel advance) {

		logger.info("Method in Dao: addLeaveDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (advance.getEmployeeId() == null || advance.getEmployeeId() == "") {
			resp.setMessage("Employee  required");
			validity = false;
		} else if (advance.getFromDate() == null || advance.getFromDate() == "") {
			resp.setMessage("From Date Name required");
			validity = false;
		} else if (advance.getToDate() == null || advance.getToDate() == "") {
			resp.setMessage("To Date Required");
			validity = false;
		} else if (advance.getLeaveDays() == null || advance.getLeaveDays() == "") {
			resp.setMessage("Leave Days Required");
			validity = false;
		}
		else if (advance.getLeaveGrantBy() == null || advance.getLeaveGrantBy() == "") {
			resp.setMessage("Leave Grant By Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateEmployeeLeaveParam.getAddLeaveParam(advance);
				if (advance.getLeaveId() != "" && advance.getLeaveId() != null) {
					em.createNamedStoredProcedureQuery("advancePaymentMasterRoutines")
							.setParameter("actionType", "modifyAdvance").setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("advancePaymentMasterRoutines")
							.setParameter("actionType", "addLeaveDetails").setParameter("actionValue", values).execute();
				}
			} catch (Exception e) {

				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					if (err[1].contentEquals("Duplicate entry 'x' for  'PRIMARY'")) {
						resp.setMessage("Employee advance Contact Already Exsited.");
					} else {
						resp.setMessage(err[1]);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: addLeaveDetails ends");

		return response;
	}

	/*
	 * for edit advance
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<HrmsEmployeeLeaveModel>> getLeaveDetailsById(String id ,String action) {

		logger.info("Method in Dao: getLeaveDetailsById ends");

		List<HrmsEmployeeLeaveModel> padvance = new ArrayList<HrmsEmployeeLeaveModel>();

		try {

			String value = "SET @P_empId='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("advancePaymentMasterRoutines")
					.setParameter("actionType", action).setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object date = null;
				if(m[1]!= null) {
					date = DateFormatter.returnStringDate(m[1]);
				} 
				HrmsEmployeeLeaveModel advance = new HrmsEmployeeLeaveModel(m[0], date, m[2], m[3], m[4], m[5], m[6]);

				padvance.add(advance);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<HrmsEmployeeLeaveModel> resp = new JsonResponse<HrmsEmployeeLeaveModel>();
		resp.setBody(padvance.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<HrmsEmployeeLeaveModel>> response = new ResponseEntity<JsonResponse<HrmsEmployeeLeaveModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getLeaveDetailsById ends");
		System.out.println(response);
		return response;
	}

}
