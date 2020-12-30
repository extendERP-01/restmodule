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
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateTrainingCreationParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.recruitment.model.TrainingCreationRestModel;

@SuppressWarnings("unchecked")
@Repository
public class TrainingCreationDao {

	Logger logger = LoggerFactory.getLogger(JobTitleDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/**
	 * DAO - Add/Modify training creation
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addTrainingDetailsPost(TrainingCreationRestModel training) {
		logger.info("Method : addjobMaster starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (training.getTrainingName() == null || training.getTrainingName() == "") {
			resp.setMessage("Training Name Required");
			validity = false;
		} else if (training.getTrainingType() == null || training.getTrainingType() == "") {
			resp.setMessage("Training Type Required");
			validity = false;
		} else if (training.getTrainingCriteria() == null || training.getTrainingCriteria() == "") {
			resp.setMessage("training criteria Required");
			validity = false;
		} else if (training.getTrainingDesc() == null || training.getTrainingDesc() == "") {
			resp.setMessage("training description Required");
			validity = false;
		}
		if (validity)
			try {

				String values = GenerateTrainingCreationParameter.getAddTrainingParam(training);

				if (training.getTrainingId() != null && training.getTrainingId() != "") {

					em.createNamedStoredProcedureQuery("trainingCreation").setParameter("actionType", "modifyTraining")
							.setParameter("actionValue", values).execute();
				} else {

					em.createNamedStoredProcedureQuery("trainingCreation")
							.setParameter("actionType", "addTrainingLeave").setParameter("actionValue", values)
							.execute();

				}
			} catch (Exception e) {
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

		logger.info("Method : addjobMaster ends");
		return response;
	}

	/**
	 * for all Training details view
	 */
	public ResponseEntity<JsonResponse<List<TrainingCreationRestModel>>> getTrainingDetails(DataTableRequest training) {

		logger.info("Method in Dao: getTrainingDetails starts");

		List<TrainingCreationRestModel> jobList = new ArrayList<TrainingCreationRestModel>();
		String values = GenerateParameter.getSearchParam(training);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("trainingCreation")
					.setParameter("actionType", "viewTrainingDetails").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					TrainingCreationRestModel training1 = new TrainingCreationRestModel(m[0], m[1], m[2], m[3], m[4],
							m[5]);
					jobList.add(training1);

				}

				if (x.get(0).length > 6) {
					BigInteger t = (BigInteger) x.get(0)[6];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<TrainingCreationRestModel>> resp = new JsonResponse<List<TrainingCreationRestModel>>();
		resp.setBody(jobList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<TrainingCreationRestModel>>> response = new ResponseEntity<JsonResponse<List<TrainingCreationRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getTrainingDetails ends");

		return response;
	}

	/**
	 * DAO - Delete Training
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteTrainingDetail(String id, String createdBy) {
		logger.info("Method : deleteTrainingDetail starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_trainingId='" + id + "',@p_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("trainingCreation").setParameter("actionType", "deleteTrainingDetail")
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

		logger.info("Method : deleteTrainingDetail ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> restAddRequistion(TrainingCreationRestModel mixDesignModel) {

		return null;
	}

	/**
	 * DAO Function to view Job in Model
	 *
	 */
	public ResponseEntity<JsonResponse<TrainingCreationRestModel>> getTrainingModel(String id) {
		logger.info("Method : getTrainingModel starts");
		List<TrainingCreationRestModel> form = new ArrayList<TrainingCreationRestModel>();
		try {
			String value = "SET @p_trainingId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("trainingCreation")
					.setParameter("actionType", "viewModalTraining").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				TrainingCreationRestModel restJobModel = new TrainingCreationRestModel(null, m[0], m[1], m[2], m[3],
						null);
				form.add(restJobModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<TrainingCreationRestModel> resp = new JsonResponse<TrainingCreationRestModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<TrainingCreationRestModel>> response = new ResponseEntity<JsonResponse<TrainingCreationRestModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getTrainingModel ends");

		return response;

	}

	/*
	 * for edit training details
	 */
	public ResponseEntity<JsonResponse<TrainingCreationRestModel>> getTrainingDetailsEdit(String id) {

		logger.info("Method in Dao: getTrainingDetailsEdit ends");

		List<TrainingCreationRestModel> trainingFormList = new ArrayList<TrainingCreationRestModel>();

		try {

			String value = "SET @p_trainingId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("trainingCreation")
					.setParameter("actionType", "viewEditTraining").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				TrainingCreationRestModel TrainingForm = new TrainingCreationRestModel(m[0], m[1], m[2], m[3], m[4],
						null);

				trainingFormList.add(TrainingForm);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<TrainingCreationRestModel> resp = new JsonResponse<TrainingCreationRestModel>();
		resp.setBody(trainingFormList.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<TrainingCreationRestModel>> response = new ResponseEntity<JsonResponse<TrainingCreationRestModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getTrainingDetailsEdit ends");

		return response;
	}

}
