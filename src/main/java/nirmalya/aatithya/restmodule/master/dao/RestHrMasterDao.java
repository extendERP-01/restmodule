package nirmalya.aatithya.restmodule.master.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateMasterReferenceHr;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestHrMasterModel;

@Repository
public class RestHrMasterDao {
	Logger logger = LoggerFactory.getLogger(RestHrMasterDao.class);


	@Autowired
	EntityManager entityManager;
	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to Add jobTypes
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addJobType(RestHrMasterModel restHrMasterModel) {
		logger.info("Method : Rest Add Job Type Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		resp.setMessage("");
		resp.setCode("");

		System.out.println(restHrMasterModel);
		
		
		if (restHrMasterModel.getJobTypeName() == null || restHrMasterModel.getJobTypeName() == "") {
			resp.setMessage("Name required");
			validity = false;
		}
		if (restHrMasterModel.getJobTypeOrder() == null || restHrMasterModel.getJobTypeOrder() == "") {
			resp.setMessage("Order required");
			validity = false;
		}
		if (restHrMasterModel.getJobTypeStatus() == null || restHrMasterModel.getJobTypeStatus() == "") {
			resp.setMessage("Status required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateMasterReferenceHr.addJobTypeParam(restHrMasterModel);

				if (restHrMasterModel.getJobTypeId() != null && restHrMasterModel.getJobTypeId() != "") {
					entityManager.createNamedStoredProcedureQuery("HrReference")
							.setParameter("actionType", "modifyJobType").setParameter("actionValue", values).execute();
				} else {
					entityManager.createNamedStoredProcedureQuery("HrReference")
							.setParameter("actionType", "addJobType").setParameter("actionValue", values).execute();
				}

			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
            
		logger.info("Method : Rest Add Job Type Dao ends");
		System.out.println(response);
		return response;
	}

	/**
	 * DAO Function to View all Jobs
	 *
	 */

	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> getAllJobs() {
		logger.info("Method : getAllJobTypes Dao starts");

		List<RestHrMasterModel> jobList = new ArrayList<RestHrMasterModel>();

		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("HrReference")
					.setParameter("actionType", "viewAllJobTypes").setParameter("actionValue","").getResultList();

			for (Object[] m : x) {

				RestHrMasterModel dropDownModel = new RestHrMasterModel(null, m[0], m[1], m[2], null, null, null, null);
				jobList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrMasterModel>> resp = new JsonResponse<List<RestHrMasterModel>>();
resp.setBody(jobList);
		ResponseEntity<JsonResponse<List<RestHrMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestHrMasterModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAlljobTypes Dao ends");
System.out.println(response);
		return response;
	}
	 
}