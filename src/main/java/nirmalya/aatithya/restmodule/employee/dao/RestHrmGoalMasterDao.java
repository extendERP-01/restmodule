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
import nirmalya.aatithya.restmodule.common.utils.GenerateGoalMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.RestHrmGoalMasterModel;

@Repository
public class RestHrmGoalMasterDao {
	Logger logger = LoggerFactory.getLogger(RestHrmGoalMasterDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for add new goal
	 */
	public ResponseEntity<JsonResponse<Object>> adddepartment(RestHrmGoalMasterModel goalMaster) {

		logger.info("Method in Dao: adddepartment starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (goalMaster.gettGoalName() == null || goalMaster.gettGoalName() == "") {
			resp.setMessage("department Name required");
			validity = false;
		} else if (goalMaster.gettGoalDesc() == null || goalMaster.gettGoalDesc() == "") {
			resp.setMessage("department description required");
			validity = false;
		} else if (goalMaster.gettGoalStatus() == null) {
			resp.setMessage("department active required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateGoalMasterParameter.getAddGoalMasterParam(goalMaster);

				if (goalMaster.gettGoalId() != "") {

					em.createNamedStoredProcedureQuery("GoalMaster").setParameter("actionType", "modifyGoal")
							.setParameter("actionValue", values).execute();
				} else {

					em.createNamedStoredProcedureQuery("GoalMaster").setParameter("actionType", "addGoal")
							.setParameter("actionValue", values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: adddepartment ends");

		return response;
	}

	/*
	 * for all Goal Master view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrmGoalMasterModel>>> getGoalDetails(DataTableRequest request) {

		logger.info("Method in Dao: getdepartmentDetails starts");

		List<RestHrmGoalMasterModel> goalMasterList = new ArrayList<RestHrmGoalMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("GoalMaster")
					.setParameter("actionType", "viewGoalMasterList").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					RestHrmGoalMasterModel goalMaster = new RestHrmGoalMasterModel(m[0], m[1], m[2], m[3]);
					goalMasterList.add(goalMaster);

				}

				if (x.get(0).length > 4) {
					BigInteger t = (BigInteger) x.get(0)[4];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrmGoalMasterModel>> resp = new JsonResponse<List<RestHrmGoalMasterModel>>();
		resp.setBody(goalMasterList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestHrmGoalMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestHrmGoalMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getdepartmentDetails ends");

		return response;
	}

	/*
	 * for edit goal master
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestHrmGoalMasterModel>> getGoalMasterById(String id) {

		logger.info("Method in Dao: getGoalMasterById ends");

		List<RestHrmGoalMasterModel> goalMasterList = new ArrayList<RestHrmGoalMasterModel>();

		try {

			String value = "SET @P_goalId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("GoalMaster")
					.setParameter("actionType", "viewEditGoal").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestHrmGoalMasterModel goalMaster = new RestHrmGoalMasterModel(m[0], m[1], m[2], m[3]);

				goalMasterList.add(goalMaster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<RestHrmGoalMasterModel> resp = new JsonResponse<RestHrmGoalMasterModel>();
		resp.setBody(goalMasterList.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<RestHrmGoalMasterModel>> response = new ResponseEntity<JsonResponse<RestHrmGoalMasterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getGoalMasterById ends");

		return response;
	}

	/*
	 * for delete goal
	 */
	public ResponseEntity<JsonResponse<Object>> deleteGoalMasterById(String id, String createdBy) {

		logger.info("Method in Dao: deleteGoalMasterById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @P_goalId='" + id + "',@P_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("GoalMaster").setParameter("actionType", "deleteGoal")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
			String[] err = serverDao.errorProcedureCall(e);
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in Dao: deleteGoalMasterById ends");

		return response;
	}

}
