/**
 * Process master dao
 *
 */

package nirmalya.aatithya.restmodule.user.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateProcessMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.user.model.RestProcessMasterModel;

/*
 * @author NirmalyaLabs
 *
 */

@Repository
public class RestProcessMasterDao {

	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;

	Logger logger = LoggerFactory.getLogger(RestProcessMasterDao.class);

	/*
	 * DAO Function to Add/edit New Process
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addProcess(RestProcessMasterModel processMaster) {
		logger.info("Method : addProcess starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (processMaster.gettProcessName() == null || processMaster.gettProcessName() == "") {
			resp.setMessage("Processs Name required");
			validity = false;
		} else if (processMaster.gettProcessDescription() == null || processMaster.gettProcessDescription() == "") {
			resp.setMessage("Description required");
			validity = false;
		} else if (processMaster.gettProcessStatus() == null) {
			resp.setMessage("Status required");
			validity = false;
		} else if (processMaster.gettProcessCreatedBy() == null || processMaster.gettProcessCreatedBy() == "") {
			resp.setMessage(" required fld");
			validity = false;
		}

		if (validity) {
			try {
				String values = GenerateProcessMasterParameter.addProcessParam(processMaster);

				if (processMaster.gettProcess() == null || processMaster.gettProcess() == "") {
					em.createNamedStoredProcedureQuery("processRoutines").setParameter("actionType", "addNewProcess")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("processRoutines").setParameter("actionType", "editProcess")
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
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addProcess ends");
		return response;
	}

	/*
	 * DAO Function to View all Process
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestProcessMasterModel>>> getAllProcess(DataTableRequest request) {
		logger.info("Method : getAllProcess starts");
		List<RestProcessMasterModel> form = new ArrayList<RestProcessMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("processRoutines")
					.setParameter("actionType", "viewAllProcess").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				RestProcessMasterModel properties = new RestProcessMasterModel(m[0], m[1], m[2], m[3], null);
				form.add(properties);
			}

			if (x.get(0).length > 5) {
				BigInteger t = (BigInteger) x.get(0)[5];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		JsonResponse<List<RestProcessMasterModel>> resp = new JsonResponse<List<RestProcessMasterModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<RestProcessMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestProcessMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllProcess ends");
		return response;
	}

	/*
	 * DAO Function to view particular Process in model
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestProcessMasterModel>> viewProcess(String id) {
		logger.info("Method : viewProcess starts");
		List<RestProcessMasterModel> form = new ArrayList<RestProcessMasterModel>();

		try {
			String values = "SET @p_processId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("processRoutines")
					.setParameter("actionType", "viewProcess").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				RestProcessMasterModel processMaster = new RestProcessMasterModel(m[0], m[1], m[2], m[3], null);
				form.add(processMaster);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<RestProcessMasterModel> processMaster = new JsonResponse<RestProcessMasterModel>();
		processMaster.setBody(form.get(0));

		ResponseEntity<JsonResponse<RestProcessMasterModel>> response = new ResponseEntity<JsonResponse<RestProcessMasterModel>>(
				processMaster, HttpStatus.CREATED);
		logger.info("Method : viewProcess ends");
		return response;
	}

	/*
	 * DAO Function to delete particular Process in model
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> deleteProcess(String id, String createdBy) {
		logger.info("Method : deleteProcess starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_processId='" + id + "',@p_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("processRoutines").setParameter("actionType", "deleteProcess")
					.setParameter("actionValue", value).execute();

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

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : deleteProcess end");
		return response;
	}

	/**
	 * DAO Function to view dropDown for Process List
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> restGetProcess() {
		logger.info("Method : restGetProcess starts");
		List<DropDownModel> processList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("processRoutines")
					.setParameter("actionType", "restGetProcess").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				processList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : restGetProcess ends");
		return processList;
	}

}
