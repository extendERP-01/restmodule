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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;

import nirmalya.aatithya.restmodule.common.utils.GenerateExitManagementParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.ExitManagementModel;


/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class ExitManagementDao {
	Logger logger = LoggerFactory.getLogger(ExitManagementDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	public ResponseEntity<JsonResponse<Object>> restAddExitManagement(ExitManagementModel exitManagement) {

		logger.info("Method in Dao: restAddExitManagement starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (exitManagement.getEmpId() == null || exitManagement.getEmpId() == "") {
			resp.setMessage("Employee Name required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateExitManagementParameter.getAddExitManagementParam(exitManagement);
				if (exitManagement.getExitManagementId() != "") {
					em.createNamedStoredProcedureQuery("exitmanagement").setParameter("actionType", "modifyExit")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("exitmanagement").setParameter("actionType", "addExitMngmnt")
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

		logger.info("Method in Dao: restAddExitManagement ends");

		
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmpNameDegination(String id) {

		logger.info("Method : getEmpNameDegination starts");
		List<DropDownModel> designationList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_empId='" + id + "';";
		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "getDeginationList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				designationList.add(dropDownModel);
			}

			resp.setBody(designationList);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getEmpNameDegination ends");
		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ExitManagementModel>>> viewExitManagementDtls(
			DataTableRequest request) {

		logger.info("Method in Dao: viewExitManagementDtls starts");

		List<ExitManagementModel> exitDtlsList = new ArrayList<ExitManagementModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "viewExitDetails").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object reldate = null;
					Object resdate = null;
					if (m[7] != null) {
						reldate = DateFormatter.returnStringDate(m[7]);
					}
					if (m[8] != null) {
						resdate = DateFormatter.returnStringDate(m[8]);
					}
					ExitManagementModel exitManagementModel = new ExitManagementModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], reldate, resdate,m[9],m[10],null,m[11],m[12],m[13]);
					exitDtlsList.add(exitManagementModel);

				}

				if (x.get(0).length > 14) {
					BigInteger t = (BigInteger) x.get(0)[14];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ExitManagementModel>> resp = new JsonResponse<List<ExitManagementModel>>();
		resp.setBody(exitDtlsList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ExitManagementModel>>> response = new ResponseEntity<JsonResponse<List<ExitManagementModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: viewExitManagementDtls ends");

		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ExitManagementModel>> getExitById(String id) {

		logger.info("Method in Dao: getExitById ends");

		List<ExitManagementModel> exitDetailsList = new ArrayList<ExitManagementModel>();

		try {

			String value = "SET @P_exitId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "editExitManagment").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object reldate = null;
				Object resdate = null;
				if (m[7] != null) {
					reldate = DateFormatter.returnStringDate(m[7]);
				}
				if (m[8] != null) {
					resdate = DateFormatter.returnStringDate(m[8]);
				}
				ExitManagementModel esitDtls = new ExitManagementModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], reldate, resdate,m[9],m[10],m[11],null,null,null);

				exitDetailsList.add(esitDtls);
			}
			System.out.println(exitDetailsList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<ExitManagementModel> resp = new JsonResponse<ExitManagementModel>();
		resp.setBody(exitDetailsList.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<ExitManagementModel>> response = new ResponseEntity<JsonResponse<ExitManagementModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getExitById ends");

		return response;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmpDesignationEdit(String id) {

		logger.info("Method : getEmpDesignationEdit starts");

		List<DropDownModel> designationList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_empId='" + id + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "getEmpDesEdit").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				designationList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getEmpDesignationEdit ends");

		return designationList;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteExitManagementById(String id, String createdBy) {

		logger.info("Method in Dao: deleteExitManagementById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @P_exitId='" + id + "',@P_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("exitmanagement").setParameter("actionType", "deleteExit")
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

		logger.info("Method in Dao: deleteExitManagementById ends");

		return response;
	}
}
