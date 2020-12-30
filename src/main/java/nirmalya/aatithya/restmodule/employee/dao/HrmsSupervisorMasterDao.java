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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateSupervisorMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.HrmsSupervisorMasterModel;



@Repository
public class HrmsSupervisorMasterDao {
	Logger logger = LoggerFactory.getLogger(HrmsSupervisorMasterDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for all supervisor details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsSupervisorMasterModel>>> getsupervisorDetails(DataTableRequest request) {

		logger.info("Method in Dao: getsupervisorDetails starts");

		List<HrmsSupervisorMasterModel> employementList = new ArrayList<HrmsSupervisorMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("supervisorMaster")
					.setParameter("actionType", "viewsupervisorList").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					HrmsSupervisorMasterModel employement = new HrmsSupervisorMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6]);
					employementList.add(employement);

				}

				if (x.get(0).length >7) {
					BigInteger t = (BigInteger) x.get(0)[7];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsSupervisorMasterModel>> resp = new JsonResponse<List<HrmsSupervisorMasterModel>>();
		resp.setBody(employementList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsSupervisorMasterModel>>> response = new ResponseEntity<JsonResponse<List<HrmsSupervisorMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getsupervisorDetails ends");

		return response;
	}

	/*
	 * for add new supervisor
	 */
	public ResponseEntity<JsonResponse<Object>> addsupervisor(HrmsSupervisorMasterModel supervisor) {

		logger.info("Method in Dao: addsupervisor starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (supervisor.getEmpid() == null || supervisor.getEmpid() == "") {
			resp.setMessage("Employee Name required");
			validity = false;
		}else if (supervisor.getDeptId() == null || supervisor.getDeptId() == "") {
			resp.setMessage("Depatrment Name required");
			validity = false;
		} else if (supervisor.getDesc() == null || supervisor.getDesc() == "") {
			resp.setMessage("supervisor description required");
			validity = false;
		} else if (supervisor.getStatus() == null) {
			resp.setMessage("supervisor Status required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateSupervisorMasterParameter.getAddsupervisorParam(supervisor);
				if (supervisor.getSpId() != "") {
					em.createNamedStoredProcedureQuery("supervisorMaster").setParameter("actionType", "modifysupervisor")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("supervisorMaster").setParameter("actionType", "addsupervisor")
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

		logger.info("Method in Dao: addsupervisor ends");

		return response;
	}

	/*
	 * for edit supervisor
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<HrmsSupervisorMasterModel>>getsupervisorById(String id) {

		logger.info("Method in Dao: getsupervisorById ends");

		List<HrmsSupervisorMasterModel> psupervisor = new ArrayList<HrmsSupervisorMasterModel>();

		try {

			String value = "SET @P_spId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("supervisorMaster")
					.setParameter("actionType", "viewEditsupervisor").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				HrmsSupervisorMasterModel supervisor = new HrmsSupervisorMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6]);

				psupervisor.add(supervisor);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<HrmsSupervisorMasterModel> resp = new JsonResponse<HrmsSupervisorMasterModel>();
		resp.setBody(psupervisor.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<HrmsSupervisorMasterModel>> response = new ResponseEntity<JsonResponse<HrmsSupervisorMasterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getsupervisorById ends");

		return response;
	}

	/*
	 * for delete supervisor
	 */
	public ResponseEntity<JsonResponse<Object>>deletesupervisorById(String id, String createdBy) {

		logger.info("Method in Dao: deletesupervisorById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @P_spId='" + id + "',@P_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("supervisorMaster").setParameter("actionType", "deletesupervisor")
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

		logger.info("Method in Dao: deletesupervisorById ends");

		return response;
	}
	/*
	 * get all po list by auto search
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmployeeByAutosearch(String id) {
		logger.info("Method : getEmployeeByAutosearch Dao starts");

		List<DropDownModel> guestList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_emp='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("supervisorMaster")
					.setParameter("actionType", "getEmpByAutosearch").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				guestList.add(dropDownModel);
			}

			resp.setBody(guestList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getEmployeeByAutosearch Dao ends");
		return response;
	}
	/**
	 * for language list
	 */
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getDeptList() {

			logger.info("Method : getDeptList starts");

			List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("supervisorMaster")
						.setParameter("actionType", "getDeptList").setParameter("actionValue", "").getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					employmentList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.info("Method : getDeptList ends");

			return employmentList;
		}

}


