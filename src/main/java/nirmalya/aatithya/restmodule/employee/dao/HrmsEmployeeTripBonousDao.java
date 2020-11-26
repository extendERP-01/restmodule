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
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateTripBonousParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeBonousModel;

@Repository
public class HrmsEmployeeTripBonousDao {
	Logger logger = LoggerFactory.getLogger(HrmsEmployeeTripBonousDao.class);
	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	private static final String PROCEDURE_NAME = "tripBonousRoutines";
	private static final String ACTION_TYPE = "actionType";
	private static final String ACTION_VALUE = "actionValue";

	/*
	 * for add production Mix
	 */
	public ResponseEntity<JsonResponse<Object>> addTripBonousPost(
			List<HrmsEmployeeBonousModel> HrmsEmployeeBonousModelList) {

		logger.info("Method in Dao: addTripBonousPost starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		for (HrmsEmployeeBonousModel a : HrmsEmployeeBonousModelList) {
			if (a.getEmployeeId() == null || a.getEmployeeId().isEmpty()) {
				resp.setMessage("Employee is required");
				validity = false;
			}

		}
		if (Boolean.TRUE.equals(validity))
			try {
				String values = GenerateTripBonousParameter.addTripBonousParam(HrmsEmployeeBonousModelList);
				System.out.println("values" + values);
				em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, "addTripBonous")
						.setParameter(ACTION_VALUE, values).execute();

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

		logger.info("Method in Dao: addTripBonousPost ends");

		return response;
	}

	/*
	 * for all Mother Coil view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEmployeeBonousModel>>> viewTripBonousMix(DataTableRequest request) {

		logger.info("Method in Dao: viewTripBonousMix starts");

		List<HrmsEmployeeBonousModel> getMCoil = new ArrayList<HrmsEmployeeBonousModel>();
		try {
			if (!request.getParam3().isEmpty())
				request.setParam3(DateFormatter.getStringDate(request.getParam3()));

		} catch (Exception e) {
			logger.error("Can not Convert Date");
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "viewTripBonousDetails").setParameter(ACTION_VALUE, values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object fromDate = null;
					Object toDate = null;
					if (m[0] != null) {
						fromDate = DateFormatter.returnStringDate(m[0]);
					}
					if (m[1] != null) {
						toDate = DateFormatter.returnStringDate(m[1]);
					}
					HrmsEmployeeBonousModel motherCoil = new HrmsEmployeeBonousModel(null, fromDate, toDate, null, null,
							null, null, null, null);

					getMCoil.add(motherCoil);

				}

				if (x.get(0).length > 2) {
					BigInteger t = (BigInteger) x.get(0)[2];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsEmployeeBonousModel>> resp = new JsonResponse<List<HrmsEmployeeBonousModel>>();
		resp.setBody(getMCoil);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsEmployeeBonousModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEmployeeBonousModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: viewTripBonousMix ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEmployeeBonousModel>>> viewProductionDetailsById(String mplanId,
			String mBatchId) {

		logger.info("Method : viewProductionDetailsById starts");

		List<HrmsEmployeeBonousModel> productionList = new ArrayList<HrmsEmployeeBonousModel>();
		JsonResponse<List<HrmsEmployeeBonousModel>> resp = new JsonResponse<List<HrmsEmployeeBonousModel>>();

		try {

			String value = "SET @p_planId='" + mplanId + "',@p_prodId='" + mBatchId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "viewProductionById").setParameter(ACTION_VALUE, value).getResultList();

			for (Object[] m : x) {

				HrmsEmployeeBonousModel HrmsEmployeeBonousModel = new HrmsEmployeeBonousModel(m[0], null, null, m[1],
						m[2], m[3], null, null, null);

				productionList.add(HrmsEmployeeBonousModel);

			}
			resp.setBody(productionList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<HrmsEmployeeBonousModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEmployeeBonousModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewProductionDetailsById ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEmployeeBonousModel>>> getBonousDetails(String toDate,
			String fromDate) {

		logger.info("Method : getBonousDetails starts");

		List<HrmsEmployeeBonousModel> productionList = new ArrayList<HrmsEmployeeBonousModel>();
		JsonResponse<List<HrmsEmployeeBonousModel>> resp = new JsonResponse<List<HrmsEmployeeBonousModel>>();

		try {
			String value = "SET @p_startDate = '" + DateFormatter.getStringDate(fromDate) + "',@p_endDate='"
					+ DateFormatter.getStringDate(toDate) + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "getBonousDetails").setParameter(ACTION_VALUE, value).getResultList();

			for (Object[] m : x) {

				HrmsEmployeeBonousModel hrmsEmployeeBonousModel = new HrmsEmployeeBonousModel(null, null, null, m[0],
						m[1], m[2], m[3], m[4], null);
				double bonus = 0;
				System.out.println("trip  bonus details " + hrmsEmployeeBonousModel.getTotalTrip());
				if (hrmsEmployeeBonousModel.getEmpName() == null) {
					hrmsEmployeeBonousModel.setEmpName("N/A");
				}
				if (hrmsEmployeeBonousModel.getAttendance().intValue() >=25) {
					
					if (hrmsEmployeeBonousModel.getTotalTrip().intValue() < 50) {
						bonus = 0.00;
					}
					if (hrmsEmployeeBonousModel.getTotalTrip().intValue() > 50
							&& hrmsEmployeeBonousModel.getTotalTrip().intValue() < 60) {
						bonus += 25 * (hrmsEmployeeBonousModel.getTotalTrip().intValue() - 50);

					}
					
					if (hrmsEmployeeBonousModel.getTotalTrip().intValue() > 50
							&& hrmsEmployeeBonousModel.getTotalTrip().intValue() > 60) {
						bonus += 25 * 10;

					}
					if (hrmsEmployeeBonousModel.getTotalTrip().intValue() > 60
							&& hrmsEmployeeBonousModel.getTotalTrip().intValue() < 70) {
						bonus += 30 * (hrmsEmployeeBonousModel.getTotalTrip().intValue() - 60);

					}
					if (hrmsEmployeeBonousModel.getTotalTrip().intValue() > 60
							&& hrmsEmployeeBonousModel.getTotalTrip().intValue() > 70) {
						bonus += 30 * 10;

					}
					if (hrmsEmployeeBonousModel.getTotalTrip().intValue() > 70
							&& hrmsEmployeeBonousModel.getTotalTrip().intValue() < 80) {
						bonus += 40 * (hrmsEmployeeBonousModel.getTotalTrip().intValue() - 70);

					}
					if (hrmsEmployeeBonousModel.getTotalTrip().intValue() > 70
							&& hrmsEmployeeBonousModel.getTotalTrip().intValue() > 80) {
						bonus += 40 * 10;

					}
					if (hrmsEmployeeBonousModel.getTotalTrip().intValue() > 80
							&& hrmsEmployeeBonousModel.getTotalTrip().intValue() < 90) {
						bonus += 50 * (hrmsEmployeeBonousModel.getTotalTrip().intValue() - 80);

					}
					if (hrmsEmployeeBonousModel.getTotalTrip().intValue() > 80
							&& hrmsEmployeeBonousModel.getTotalTrip().intValue() > 90) {
						bonus += 50 * 10;

					}
					if (hrmsEmployeeBonousModel.getTotalTrip().intValue() > 90
							&& hrmsEmployeeBonousModel.getTotalTrip().intValue() < 150) {
						bonus += 60 * (hrmsEmployeeBonousModel.getTotalTrip().intValue() - 90);

					}
					if (hrmsEmployeeBonousModel.getTotalTrip().intValue() > 150) {
						bonus += 60 * 10;

					}
					System.out.println(bonus);
					hrmsEmployeeBonousModel.setTotalBonous(bonus);
				} else {
					hrmsEmployeeBonousModel.setTotalBonous(0.00);
				}

				productionList.add(hrmsEmployeeBonousModel);

			}
			resp.setBody(productionList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<HrmsEmployeeBonousModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEmployeeBonousModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getBonousDetails ends");
		System.out.println(response);
		return response;
	}

	/*
	 * for modal view and edit also
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEmployeeBonousModel>>> getTripDetailsById(String id) {

		logger.info("Method : getTripDetailsById starts");

		List<HrmsEmployeeBonousModel> assignEduList = new ArrayList<HrmsEmployeeBonousModel>();
		JsonResponse<List<HrmsEmployeeBonousModel>> resp = new JsonResponse<List<HrmsEmployeeBonousModel>>();

		try {

			String value = "SET @p_fromDate='" + DateFormatter.getStringDate(id) + "';";
			System.out.println("value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter("actionType", "getTripDetailsById").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				Object fromDate = null;
				Object toDate1 = null;
				if (m[0] != null) {
					fromDate = DateFormatter.returnStringDate(m[0]);
				}
				if (m[1] != null) {
					toDate1 = DateFormatter.returnStringDate(m[1]);
				}

				HrmsEmployeeBonousModel HrmsEmployeeBonousModel = new HrmsEmployeeBonousModel(null, fromDate, toDate1,
						m[2], m[3], (BigInteger) m[4], (BigInteger) m[5], m[6], null);

				assignEduList.add(HrmsEmployeeBonousModel);

			}

			resp.setBody(assignEduList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<HrmsEmployeeBonousModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEmployeeBonousModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getTripDetailsById ends");

		return response;
	}
}
