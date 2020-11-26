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

import nirmalya.aatithya.restmodule.attendance.model.RestWorkWeekMasterModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateWorkWeekMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestWorkWeekMasterDao {
	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;

	Logger logger = LoggerFactory.getLogger(RestWorkWeekMasterDao.class);

	/*
	 * DAO Function to Add/edit Work Week Days
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> restAddWorkWeek(RestWorkWeekMasterModel workWeekMaster) {
		logger.info("Method : restAddWorkWeek ends");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (workWeekMaster.gettWorkDayName() == null || workWeekMaster.gettWorkDayName() == "") {
			resp.setMessage("Day Name required");
			validity = false;
		} else if (workWeekMaster.gettWorkDayStatus() == null || workWeekMaster.gettWorkDayStatus() == "") {
			resp.setMessage("Working Status required");
			validity = false;
		} else if (workWeekMaster.gettCompanyId() == null || workWeekMaster.gettCompanyId() == "") {

			validity = true;
		} else if (workWeekMaster.gettWorkDayCreatedBy() == null || workWeekMaster.gettWorkDayCreatedBy() == "") {

			validity = true;
		}

		if (validity) {
			try {
				String values = GenerateWorkWeekMasterParameter.addWorkWeekParam(workWeekMaster);

				if (workWeekMaster.gettWorkDay() == null || workWeekMaster.gettWorkDay() == "") {
					em.createNamedStoredProcedureQuery("workWeekMasterRoutines")
							.setParameter("actionType", "addWorkWeekDay").setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("workWeekMasterRoutines")
							.setParameter("actionType", "modifyWorkWeekDay").setParameter("actionValue", values)
							.execute();
				}
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
		logger.info("Method : restAddWorkWeek ends");
		return response;
	}

	/*
	 * DAO Function to view week day name in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDayName() {
		logger.info("Method : getDayName starts");
		List<DropDownModel> dayName = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("workWeekMasterRoutines")
					.setParameter("actionType", "getDayName").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				dayName.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDayName ends");
		return dayName;
	}

	/*
	 * DAO Function to view working status in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getWorkingStatus() {
		logger.info("Method : getWorkingStatus starts");
		List<DropDownModel> workingStatus = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("workWeekMasterRoutines")
					.setParameter("actionType", "getWorkingStatus").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				workingStatus.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getWorkingStatus ends");
		return workingStatus;
	}

	/*
	 * DAO Function to View all week days
	 *
	 */
	@SuppressWarnings("unchecked")

	public ResponseEntity<JsonResponse<List<RestWorkWeekMasterModel>>> getAllWorkWeek(DataTableRequest request) {
		logger.info("Method : getAllWorkWeek starts");
		List<RestWorkWeekMasterModel> form = new ArrayList<RestWorkWeekMasterModel>();
		String values = GenerateParameter.getSearchParam(request);

		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("workWeekMasterRoutines")
					.setParameter("actionType", "getAllWorkWeek").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					RestWorkWeekMasterModel properties = new RestWorkWeekMasterModel(m[0], m[1], m[2], null, null,
							null);
					form.add(properties);
				}

				if (x.get(0).length > 3) {
					BigInteger t = (BigInteger) x.get(0)[3];

					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		JsonResponse<List<RestWorkWeekMasterModel>> resp = new JsonResponse<List<RestWorkWeekMasterModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<RestWorkWeekMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestWorkWeekMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllWorkWeek ends");

		return response;
	}

	/*
	 * DAO Function to view particular work week details to edit/view
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestWorkWeekMasterModel>> editWorkWeek(String id) {
		logger.info("Method : editWorkWeek starts");
		List<RestWorkWeekMasterModel> form = new ArrayList<RestWorkWeekMasterModel>();

		try {
			String values = "SET @p_workId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("workWeekMasterRoutines")
					.setParameter("actionType", "editWorkWeek").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				RestWorkWeekMasterModel properties = new RestWorkWeekMasterModel(m[0], m[1], m[2], null, null, null);
				form.add(properties);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<RestWorkWeekMasterModel> workWeekMaster = new JsonResponse<RestWorkWeekMasterModel>();
		workWeekMaster.setBody(form.get(0));

		ResponseEntity<JsonResponse<RestWorkWeekMasterModel>> response = new ResponseEntity<JsonResponse<RestWorkWeekMasterModel>>(
				workWeekMaster, HttpStatus.CREATED);
		logger.info("Method : editWorkWeek ends");
		return response;
	}

}
