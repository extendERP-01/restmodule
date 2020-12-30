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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateJobParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.recruitment.model.JobTitleRestModel;

@Repository
public class JobTitleDao {
	Logger logger = LoggerFactory.getLogger(JobTitleDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// private Object value;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getjobDepartmentList() {
		logger.info("Method : getJobCode Dao starts");

		List<DropDownModel> jobList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("recruitment")
					.setParameter("actionType", "dropDownDepartment").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				jobList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getJobCode Dao ends");

		return jobList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getjobTypeList() {
		logger.info("Method : getJobCode Dao starts");

		List<DropDownModel> jobList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("recruitment")
					.setParameter("actionType", "dropDownJobType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				jobList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getJobCode Dao ends");

		return jobList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getjobTittleList() {
		logger.info("Method : getJobCode Dao starts");

		List<DropDownModel> jobTittle = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("recruitment")
					.setParameter("actionType", "dropDownJobTittle").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				jobTittle.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getJobCode Dao ends");

		return jobTittle;
	}

	/**
	 * DAO - Add/Modify Job Title
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addJobDetailsPost(JobTitleRestModel job) {
		logger.info("Method : addjobMaster starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (job.getjObtitle() == null || job.getjObtitle() == "") {
			resp.setMessage("Job Title Required");
			validity = false;
		} else if (job.getIntPragraph() == null || job.getIntPragraph() == "") {
			resp.setMessage("introduction Required");
			validity = false;
		} else if (job.getResponsibility() == null || job.getResponsibility() == "") {
			resp.setMessage("Responsibility Required");
			validity = false;
		} else if (job.getWorkHourBenifit() == null || job.getWorkHourBenifit() == "") {
			resp.setMessage("WorkHourBenifit Required");
			validity = false;
		} else if (job.getSkill() == null || job.getSkill() == "") {
			resp.setMessage("Skill Required");
			validity = false;
		} else if (job.getEducation() == null || job.getEducation() == "") {
			resp.setMessage("Education Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateJobParameter.getAddjobParam(job);
				if (job.getJobId() != null && job.getJobId() != "") {
					em.createNamedStoredProcedureQuery("recruitment").setParameter("actionType", "modifyjob")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("recruitment").setParameter("actionType", "addjob")
							.setParameter("actionValue", values).execute();
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
	 * for alljob details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<JobTitleRestModel>>> getJobDetails(DataTableRequest job) {

		logger.info("Method in Dao: getJobDetails starts");

		List<JobTitleRestModel> jobList = new ArrayList<JobTitleRestModel>();
		String values = GenerateParameter.getSearchParam(job);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("recruitment")
					.setParameter("actionType", "viewJobDetails").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					JobTitleRestModel employe = new JobTitleRestModel(m[0], m[1], null, null, null, m[2], null, null,
							null, null);
					jobList.add(employe);

				}

				if (x.get(0).length > 3) {
					BigInteger t = (BigInteger) x.get(0)[3];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<JobTitleRestModel>> resp = new JsonResponse<List<JobTitleRestModel>>();
		resp.setBody(jobList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<JobTitleRestModel>>> response = new ResponseEntity<JsonResponse<List<JobTitleRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getJobDetails ends"); 
		return response;
	}

	/**
	 * DAO Function to delete particular job Details
	 *
	 *//*
		 * 
		 * public ResponseEntity<JsonResponse<Object>> deleteJobDetail(String id, String
		 * createdBy) { logger.info("Method : deletePatientDetails starts");
		 * JsonResponse<Object> resp = new JsonResponse<Object>(); resp.setMessage("");
		 * resp.setCode("");
		 * 
		 * try {
		 * 
		 * String value = "SET @p_jobId='" + id + "',@p_createdBy='" + createdBy + "';";
		 * 
		 * em.createNamedStoredProcedureQuery("recruitment").setParameter("actionType",
		 * "deleteJobDetails") .setParameter("actionValue", value).execute();
		 * 
		 * } catch (Exception e) { e.printStackTrace(); try { String[] err =
		 * serverDao.errorProcedureCall(e);
		 * 
		 * resp.setCode(err[0]); resp.setMessage(err[1]); } catch (Exception e1) {
		 * 
		 * e1.printStackTrace(); } } HttpHeaders responseHeaders = new HttpHeaders();
		 * responseHeaders.set("MyResponseHeader", "MyValue");
		 * ResponseEntity<JsonResponse<Object>> response = new
		 * ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
		 * HttpStatus.CREATED);
		 * 
		 * logger.info("Method : deletePatientDetails end"); return response; }
		 */
	/**
	 * DAO - Delete job
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteJobDetail(String id, String createdBy) {
		logger.info("Method : deleteStateById starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_jobId='" + id + "',@p_createdBy='" + createdBy + "';";

 			em.createNamedStoredProcedureQuery("recruitment").setParameter("actionType", "deleteJobDetails")
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

		logger.info("Method : deleteStateById ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> restAddRequistion(JobTitleRestModel mixDesignModel) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * DAO Function to view Job in Model
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<JobTitleRestModel>> getJobTitleModel(String id) {
		logger.info("Method : getJobTitleModel starts");
		List<JobTitleRestModel> form = new ArrayList<JobTitleRestModel>();
		try {
			String value = "SET @p_jobId='" + id + "';"; 
			List<Object[]> x = em.createNamedStoredProcedureQuery("recruitment")
					.setParameter("actionType", "viewModalJob").setParameter("actionValue", value).getResultList();
 

			for (Object[] m : x) {
				JobTitleRestModel restJobModel = new JobTitleRestModel(m[0], m[1], null, null, null, m[2], null, null,
						null, null);
				form.add(restJobModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<JobTitleRestModel> resp = new JsonResponse<JobTitleRestModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<JobTitleRestModel>> response = new ResponseEntity<JsonResponse<JobTitleRestModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getJobTitleModel ends"); 
		return response;

	}

	/*
	 * for edit job details
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<JobTitleRestModel>> getJobDetailsEdit(String id) {

		logger.info("Method in Dao: getemployeeById ends");

		List<JobTitleRestModel> jobFormList = new ArrayList<JobTitleRestModel>();

		try {

			String value = "SET @p_jobId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("recruitment")
					.setParameter("actionType", "viewEditJob").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				JobTitleRestModel jobForm = new JobTitleRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8],
						null);

				jobFormList.add(jobForm);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<JobTitleRestModel> resp = new JsonResponse<JobTitleRestModel>();
		resp.setBody(jobFormList.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<JobTitleRestModel>> response = new ResponseEntity<JsonResponse<JobTitleRestModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getemployeeById ends"); 
		return response;
	}

}