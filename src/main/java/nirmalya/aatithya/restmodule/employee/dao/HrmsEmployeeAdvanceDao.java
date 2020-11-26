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
import nirmalya.aatithya.restmodule.common.utils.GenerateEmployeeAdvanceParam;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.HrmsAdvancePaymentModel;

@Repository
public class HrmsEmployeeAdvanceDao {
	Logger logger = LoggerFactory.getLogger(HrmsEmployeeAdvanceDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for all advance details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsAdvancePaymentModel>>> getadvanceDetails(DataTableRequest request) {

		logger.info("Method in Dao: getadvanceDetails starts");

		List<HrmsAdvancePaymentModel> employementList = new ArrayList<HrmsAdvancePaymentModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("leave_routines")
					.setParameter("actionType", "viewAdvanceList").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[1] != null) {
						date = DateFormatter.returnStringDate(m[1]);
					}
					HrmsAdvancePaymentModel qualif = new HrmsAdvancePaymentModel(m[0], date, m[2], m[3], m[4], m[5],
							m[6], m[7]);
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

		JsonResponse<List<HrmsAdvancePaymentModel>> resp = new JsonResponse<List<HrmsAdvancePaymentModel>>();
		resp.setBody(employementList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsAdvancePaymentModel>>> response = new ResponseEntity<JsonResponse<List<HrmsAdvancePaymentModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getadvanceDetails ends");

		return response;
	}

	/*
	 * for add new advance
	 */
	public ResponseEntity<JsonResponse<Object>> addadvance(HrmsAdvancePaymentModel advance) {

		logger.info("Method in Dao: addadvance starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (advance.getEmployee() == null || advance.getEmployee() == "") {
			resp.setMessage("Employee Name required");
			validity = false;
		} else if (advance.getDate() == null || advance.getDate() == "") {
			resp.setMessage("Date Name required");
			validity = false;
		} else if (advance.getAmount() == null) {
			resp.setMessage("Amount Required");
			validity = false;
		} else if (advance.getPaymentMadeBy() == null || advance.getPaymentMadeBy() == "") {
			resp.setMessage("Payment Mode Required");
			validity = false;
		} else if (advance.getPaymentMode() == null || advance.getPaymentMode() == "") {
			resp.setMessage("Payment Mode Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateEmployeeAdvanceParam.getAddadvanceParam(advance);
				if (advance.getAdvPayId() != "" && advance.getAdvPayId() != null) {
					em.createNamedStoredProcedureQuery("leave_routines").setParameter("actionType", "modifyAdvance")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("leave_routines").setParameter("actionType", "addAdvance")
							.setParameter("actionValue", values).execute();
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

		logger.info("Method in Dao: addadvance ends");

		return response;
	}

	/*
	 * for edit advance
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<HrmsAdvancePaymentModel>> getadvanceById(String id, String action) {

		logger.info("Method in Dao: getadvanceById ends");

		List<HrmsAdvancePaymentModel> padvance = new ArrayList<HrmsAdvancePaymentModel>();

		try {

			String value = "SET @P_empId='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("leave_routines").setParameter("actionType", action)
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object date = null;
				if (m[1] != null) {
					date = DateFormatter.returnStringDate(m[1]);
				}
				HrmsAdvancePaymentModel advance = new HrmsAdvancePaymentModel(m[0], date, m[2], m[3], m[4], m[5], m[6],
						m[7]);

				padvance.add(advance);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<HrmsAdvancePaymentModel> resp = new JsonResponse<HrmsAdvancePaymentModel>();
		resp.setBody(padvance.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<HrmsAdvancePaymentModel>> response = new ResponseEntity<JsonResponse<HrmsAdvancePaymentModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getadvanceById ends");
		System.out.println(response);
		return response;
	}

}
