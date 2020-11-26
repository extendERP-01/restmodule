package nirmalya.aatithya.restmodule.attendance.dao;

import java.math.BigInteger;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.attendance.model.RestAttendenceDetailsModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAttendenceParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestAttendenceDetailsDao {
	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;

	Logger logger = LoggerFactory.getLogger(RestAttendenceDetailsDao.class);

	/*
	 * DAO Function to Add/edit PunchIn Attendence
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> addAttendencePunchIn(RestAttendenceDetailsModel attendenceDetails) {

		logger.info("Method : addAttendencePunchIn ends");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (attendenceDetails.gettEmployee() == null || attendenceDetails.gettEmployee() == "") {
			resp.setMessage("empId required");
			validity = false;
		} else if (attendenceDetails.gettAttndncDate() == null || attendenceDetails.gettAttndncDate() == "") {
			resp.setMessage(" Date required");
			validity = false;
		} else if (attendenceDetails.gettAttndncPunchIn() == null || attendenceDetails.gettAttndncPunchIn() == "") {
			resp.setMessage("PunchIn Time required");
			validity = false;
		} else if (attendenceDetails.gettAttndncPunchInLoc() == null) {
			resp.setMessage("PunchIn Location required");
			validity = false;
		} else if (attendenceDetails.gettAttndncPunchInNote() == null
				|| attendenceDetails.gettAttndncPunchInNote() == "") {
			resp.setMessage("PunchIn Note required");
			validity = false;

		} else if (attendenceDetails.gettAttndncCreatedBy() == null || attendenceDetails.gettAttndncCreatedBy() == "") {

			validity = true;
		}

		if (validity)
			try {

				String values = GenerateAttendenceParameter.addAttendenceParam(attendenceDetails);

				em.createNamedStoredProcedureQuery("attendenceRoutines").setParameter("actionType", "addattendence")
						.setParameter("actionValue", values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addAttendencePunchIn ends");

		return response;
	}

	/*
	 * DAO Function to get punchIn time
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDetails(String empId, String date) {
		logger.info("Method : getDetails starts");
		List<DropDownModel> details = new ArrayList<DropDownModel>();
		//String date1 = DateFormatter.getStringDate(date);
		try {
			String values = "SET @p_empId='" + empId + "',@p_date='" + date + "';";
			System.out.println(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("attendenceRoutines")
					.setParameter("actionType", "getDetails").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				Object tAttndncPunchIn = null;
				if (m[1] != null) {
					tAttndncPunchIn = DateFormatter.returnStringDateTime(m[1]);

				}
				DropDownModel properties = new DropDownModel(null, tAttndncPunchIn);
				details.add(properties);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDetails ends");
		System.out.println("@@@@"+details);

		return details;
	}

	/*
	 * DAO Function to Add/edit Punch Out Details
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> addAttendencePunchOut(RestAttendenceDetailsModel attendenceDetails) {

		logger.info("Method : addAttendencePunchOut ends");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (attendenceDetails.gettEmployee() == null || attendenceDetails.gettEmployee() == "") {
			resp.setMessage("empId required");
			validity = false;
		} else if (attendenceDetails.gettAttndncDate() == null || attendenceDetails.gettAttndncDate() == "") {
			resp.setMessage(" Date required");
			validity = false;
		} else if (attendenceDetails.gettAttndncPunchOut() == null || attendenceDetails.gettAttndncPunchOut() == "") {
			resp.setMessage("PunchOut Time required");
			validity = false;
		} else if (attendenceDetails.gettAttndncPunchOut_Loc() == null) {
			resp.setMessage("PunchOut Location required");
			validity = false;
		} else if (attendenceDetails.gettAttndncPunchOutNote() == null
				|| attendenceDetails.gettAttndncPunchOutNote() == "") {
			resp.setMessage("PunchOut Note required");
			validity = false;
		} else if (attendenceDetails.gettAttndncCreatedBy() == null || attendenceDetails.gettAttndncCreatedBy() == "") {

			validity = true;
		}

		if (validity)
			try {

				String values = GenerateAttendenceParameter.addAttendenceParam(attendenceDetails);

				em.createNamedStoredProcedureQuery("attendenceRoutines").setParameter("actionType", "modifyAttendence")
						.setParameter("actionValue", values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addAttendencePunchOut ends");

		return response;
	}

	/*
	 * DAO Function to View all attendence details
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAttendenceDetailsModel>>> getAllAttendence(DataTableRequest request) {
		logger.info("Method : getAllAttendence starts");
		if (request.getParam1() != "") {
			String param1 = request.getParam1();
			String data = DateFormatter.getStringDate(param1);
			request.setParam1(data);
			
		}
		List<RestAttendenceDetailsModel> form = new ArrayList<RestAttendenceDetailsModel>();
		String values = GenerateParameter.getSearchParam(request);

		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("attendenceRoutines")
					.setParameter("actionType", "getAllAttendence").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				Object tAttndncDate = null;
				if (m[1] != null) {
					tAttndncDate = DateFormatter.returnStringDate(m[1]);
				}

				Object tAttndncPunchIn = null;
				if (m[2] != null) {
					tAttndncPunchIn = DateFormatter.returnStringDateTime(m[2]);
				}
				Object tAttndncPunchOut = null;
				if (m[5] != null) {
					tAttndncPunchOut = DateFormatter.returnStringDateTime(m[5]);
				}
				RestAttendenceDetailsModel properties = new RestAttendenceDetailsModel(m[0], tAttndncDate,
						tAttndncPunchIn, m[3], m[4], tAttndncPunchOut, m[6], m[7], null, null);
				form.add(properties);
			}

			if (x.get(0).length > 8) {
				BigInteger t = (BigInteger) x.get(0)[8];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		JsonResponse<List<RestAttendenceDetailsModel>> resp = new JsonResponse<List<RestAttendenceDetailsModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<RestAttendenceDetailsModel>>> response = new ResponseEntity<JsonResponse<List<RestAttendenceDetailsModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllAttendence ends");

		return response;
	}

}