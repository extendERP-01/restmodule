package nirmalya.aatithya.restmodule.recruitment.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;

import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GeneratetrainningPlanningParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.recruitment.model.AddTrainingPlanningRestModel;

@SuppressWarnings("unchecked")
@Repository
public class AddTrainingDao {

	Logger logger = LoggerFactory.getLogger(AddTrainingDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	public List<DropDownModel> dropDowntranningType() {
		logger.info("Method : dropDowntranningType Dao starts");

		List<DropDownModel> tranningTypeList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("addTrainingRoutines")
					.setParameter("actionType", "dropDowntranningType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				tranningTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : tranningTypeList Dao ends");

		return tranningTypeList;
	}

	// for add
	public ResponseEntity<JsonResponse<Object>> restTrainingplanning(
			List<AddTrainingPlanningRestModel> TrainingPlanning) {

		logger.info("Method in Dao: restTrainingplanning starts");

		Boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String id = TrainingPlanning.get(0).getTrainningId();

		for (AddTrainingPlanningRestModel a : TrainingPlanning) {

			if (a.getTranningName() == null || a.getTranningName() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select TranningName.");
				break;
			} else if (a.getTranningType() == null || a.getTranningType() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter TranningType.");
				break;
			} else if (a.getStartDate() == null || a.getStartDate() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter StartDate.");
				break;
			} else if (a.getEndDate() == null || a.getEndDate() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter To EndDate.");
				break;
			} /*
				 * else if (a.getStatus() !=true || a.getStatus() !=false) { validation = false;
				 * resp.setCode("Field Validation Error");
				 * resp.setMessage("Please Select Status."); break;
				 * 
				 * }
				 */
		}

		if (validation)
			try {
				String values = GeneratetrainningPlanningParameter.getAddtrainningplanningParam(TrainingPlanning);

				if (id != null && id != "") {

					em.createNamedStoredProcedureQuery("addTrainingRoutines")
							.setParameter("actionType", "modifyTrainning").setParameter("actionValue", values)
							.execute();
				} else {

					em.createNamedStoredProcedureQuery("addTrainingRoutines")
							.setParameter("actionType", "addtrainningplanning").setParameter("actionValue", values)
							.execute();

				}
			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					if (err[0].matches("1062")) {
						resp.setMessage("trainning Already Added.");
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

		logger.info("Method in Dao: restTrainingplanning ends");

		return response;
	}

	/*
	 * for all assignSkill details view
	 */
	public ResponseEntity<JsonResponse<List<AddTrainingPlanningRestModel>>> gettrainningplanning(
			DataTableRequest request) {

		logger.info("Method in Dao: getTrainingPlanning starts");

		List<AddTrainingPlanningRestModel> trainingplanning = new ArrayList<AddTrainingPlanningRestModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("addTrainingRoutines")
					.setParameter("actionType", "getaddTrainingRoutines").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object sDate = null;
					if (m[3] != null) {
						sDate = DateFormatter.returnStringDate(m[3]);
					}

					Object sDate2 = null;
					if (m[4] != null) {
						sDate2 = DateFormatter.returnStringDate(m[4]);
					}

					AddTrainingPlanningRestModel shift = new AddTrainingPlanningRestModel(m[0], null, m[1], m[2], sDate,
							sDate2, m[5], null);
					trainingplanning.add(shift);

				}

				if (x.get(0).length > 6) {
					BigInteger t = (BigInteger) x.get(0)[6];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<AddTrainingPlanningRestModel>> resp = new JsonResponse<List<AddTrainingPlanningRestModel>>();
		resp.setBody(trainingplanning);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AddTrainingPlanningRestModel>>> response = new ResponseEntity<JsonResponse<List<AddTrainingPlanningRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getTrainingPlanning ends");
		return response;
	}

	// Delete
	public ResponseEntity<JsonResponse<Object>> deletetrainningbyId(String id, String createdBy) {
		logger.info("Method : deletetrainningbyId starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_trainningId='" + id + "',@p_CreatedBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("addTrainingRoutines").setParameter("actionType", "deleteplanning")
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

		logger.info("Method : deletetrainningbyId ends");
		return response;

	}

	/*
	 * for modal view and edit also
	 */
	public ResponseEntity<JsonResponse<List<AddTrainingPlanningRestModel>>> geteditplanning(String id) {

		logger.info("Method : geteditplanning starts");

		List<AddTrainingPlanningRestModel> planning = new ArrayList<AddTrainingPlanningRestModel>();
		JsonResponse<List<AddTrainingPlanningRestModel>> resp = new JsonResponse<List<AddTrainingPlanningRestModel>>();

		try {

			String value = "SET @p_editId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("addTrainingRoutines")
					.setParameter("actionType", "getedit").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				Object sDate = null;
				if (m[3] != null) {
					sDate = DateFormatter.returnStringDate(m[3]);
				}

				Object sDate2 = null;
				if (m[4] != null) {
					sDate2 = DateFormatter.returnStringDate(m[4]);
				}

				AddTrainingPlanningRestModel AddTrainingPlanningRestModel = new AddTrainingPlanningRestModel(m[0], "a",
						m[1], m[2], sDate, sDate2, m[5], m[6]);

				planning.add(AddTrainingPlanningRestModel);

			}
			resp.setBody(planning);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<AddTrainingPlanningRestModel>>> response = new ResponseEntity<JsonResponse<List<AddTrainingPlanningRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : geteditplanning ends");

		return response;
	}

}
