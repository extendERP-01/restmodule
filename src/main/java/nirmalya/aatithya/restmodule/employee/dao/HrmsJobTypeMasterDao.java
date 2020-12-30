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
import nirmalya.aatithya.restmodule.common.utils.GenerateJobTypeMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.HrmsJobTypeMasterModel;

@Repository
public class HrmsJobTypeMasterDao {
	Logger logger = LoggerFactory.getLogger(HrmsJobTypeMasterDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for all jobType details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsJobTypeMasterModel>>> getjobTypeDetails(DataTableRequest request) {

		logger.info("Method in Dao: getjobTypeDetails starts");

		List<HrmsJobTypeMasterModel> employementList = new ArrayList<HrmsJobTypeMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("JobTypeMaster")
					.setParameter("actionType", "viewjobTypeList").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					HrmsJobTypeMasterModel employement = new HrmsJobTypeMasterModel(m[0], m[1], m[2], m[3]);
					employementList.add(employement);

				}

				if (x.get(0).length >4) {
					BigInteger t = (BigInteger) x.get(0)[4];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsJobTypeMasterModel>> resp = new JsonResponse<List<HrmsJobTypeMasterModel>>();
		resp.setBody(employementList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsJobTypeMasterModel>>> response = new ResponseEntity<JsonResponse<List<HrmsJobTypeMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getjobTypeDetails ends");

		return response;
	}

	/*
	 * for add new jobType
	 */
	public ResponseEntity<JsonResponse<Object>> addjobType(HrmsJobTypeMasterModel jobType) {

		logger.info("Method in Dao: addjobType starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (jobType.getJobTypeName() == null || jobType.getJobTypeName() == "") {
			resp.setMessage("jobType Name required");
			validity = false;
		} else if (jobType.getJobTypeDesc() == null || jobType.getJobTypeDesc() == "") {
			resp.setMessage("jobType description required");
			validity = false;
		} else if (jobType.getJobTypeStatus() == null) {
			resp.setMessage("jobType active required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateJobTypeMasterParameter.getAddJobTypeParam(jobType);
				if (jobType.getJobTypeId() != "") {
					em.createNamedStoredProcedureQuery("JobTypeMaster").setParameter("actionType", "modifyjobType")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("JobTypeMaster").setParameter("actionType", "addjobType")
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

		logger.info("Method in Dao: addjobType ends");

		return response;
	}

	/*
	 * for edit jobType
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<HrmsJobTypeMasterModel>>getjobTypeById(String id) {

		logger.info("Method in Dao: getjobTypeById ends");

		List<HrmsJobTypeMasterModel> pjobType = new ArrayList<HrmsJobTypeMasterModel>();

		try {

			String value = "SET @P_JobId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("JobTypeMaster")
					.setParameter("actionType", "viewEditjobType").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				HrmsJobTypeMasterModel jobType = new HrmsJobTypeMasterModel(m[0], m[1], m[2], m[3]);

				pjobType.add(jobType);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<HrmsJobTypeMasterModel> resp = new JsonResponse<HrmsJobTypeMasterModel>();
		resp.setBody(pjobType.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<HrmsJobTypeMasterModel>> response = new ResponseEntity<JsonResponse<HrmsJobTypeMasterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getjobTypeById ends");

		return response;
	}

	/*
	 * for delete jobType
	 */
	public ResponseEntity<JsonResponse<Object>>deletejobTypeById(String id, String createdBy) {

		logger.info("Method in Dao: deletejobTypeById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @P_JobId='" + id + "',@P_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("JobTypeMaster").setParameter("actionType", "deletejobType")
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

		logger.info("Method in Dao: deletejobTypeById ends");

		return response;
	}

}

