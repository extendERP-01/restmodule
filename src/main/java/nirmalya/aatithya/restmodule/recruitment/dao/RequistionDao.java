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
import nirmalya.aatithya.restmodule.common.utils.GenerateReqParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse; 
import nirmalya.aatithya.restmodule.recruitment.model.RequistionRestModel; 
 
@Repository
public class RequistionDao {
	Logger logger = LoggerFactory.getLogger(RequistionDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// private Object value;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getjobCodeList() {
		logger.info("Method : getJobCode Dao starts");

		List<DropDownModel> jobList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("requistionRoutines")
					.setParameter("actionType", "jobCode").setParameter("actionValue", "").getResultList();

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
	public ResponseEntity<JsonResponse<DropDownModel>> getJobTitleForJobTitl(String id) {

		logger.info("Method : jobtitle starts");

		DropDownModel jobtitle = new DropDownModel();
		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		String value = "SET @p_requistionId='" + id + "';"; 
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("requistionRoutines")
					.setParameter("actionType", "jobTitle").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) { 
				jobtitle = new DropDownModel(m[0], m[1]);
				//jobtitle.add(dropDownModel);
			}

			resp.setBody(jobtitle);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<DropDownModel>> response = new ResponseEntity<JsonResponse<DropDownModel>>(
				resp, HttpStatus.CREATED);
 
		logger.info("Method : getjobtitle ends");
		return response;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepartmentForDepa() {
		logger.info("Method : getDepartmentForDepa starts");
		List<DropDownModel> departmentList = new ArrayList<DropDownModel>();
        
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("requistionRoutines")
					.setParameter("actionType", "getdepartment").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				departmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDepartmentForDepa end");
		return departmentList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getHiringManagerForMang() {
		logger.info("Method : getHiringManagerForMang starts");
		List<DropDownModel> hiringmanagerList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("requistionRoutines")
					.setParameter("actionType", "gethiringmanager").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				hiringmanagerList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getHiringManagerForMang end");
		return hiringmanagerList;
	}

	/**
	 * DAO - Add Requistion
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> restAddRequistion(RequistionRestModel req) {
		logger.info("Method : restAddRequistion starts");
		Boolean validity = true;

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (req.getBudget() == null) {
			resp.setMessage("Budget");
			validity = false;

		}

		if (validity)
			try {
				String values = GenerateReqParameter.getAddreqParam(req);

				if (req.getRequistionId() != null && req.getRequistionId() != "") { 
					em.createNamedStoredProcedureQuery("requistionRoutines").setParameter("actionType", "modifyreq")
					.setParameter("actionValue", values).execute();
				} else {
					
					em.createNamedStoredProcedureQuery("requistionRoutines").setParameter("actionType", "addreq")
					.setParameter("actionValue", values).execute(); 
					
				}
			} catch

			(Exception e) {
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

		logger.info("Method : restAddRequistion ends");
		return response;
	}

	// view requition dao
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RequistionRestModel>>> viewRequistion(DataTableRequest request) {
		logger.info("Method : getRequistionview starts");

		List<RequistionRestModel> viewreq = new ArrayList<RequistionRestModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("requistionRoutines")
					.setParameter("actionType", "viewRequ").setParameter("actionValue", values).getResultList();
		 
			for (Object[] m : x) {
				Object sDate = null;
				if (m[4] != null) {
					sDate = DateFormatter.returnStringDate(m[4]);
				}

				RequistionRestModel reqModel = new RequistionRestModel(m[0], m[1], m[2], m[3], sDate, m[5], m[6], null);
				viewreq.add(reqModel);
			}

			if (x.size() > 0) {

				if (x.get(0).length > 7) {
					BigInteger t = (BigInteger) x.get(0)[7];

					total = Integer.parseInt((t.toString()));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		JsonResponse<List<RequistionRestModel>> resp = new JsonResponse<List<RequistionRestModel>>();
		resp.setBody(viewreq);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RequistionRestModel>>> response = new ResponseEntity<JsonResponse<List<RequistionRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED); 
		logger.info("Method :  getRequistionview ends");
		return response;
	}

	// Edit view Structure dao

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RequistionRestModel>> restAddRequistionbyId(String id) {
		logger.info("Method : editRequistion starts");

		List<RequistionRestModel> respEdit = new ArrayList<RequistionRestModel>();
		JsonResponse<RequistionRestModel> resp = new JsonResponse<RequistionRestModel>();

		try {

			String value = "SET @p_requistionId='" + id + "';"; 
			List<Object[]> x = em.createNamedStoredProcedureQuery("requistionRoutines")
					.setParameter("actionType", "viewEditrequ").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object sDate = null;
				if (m[4] != null) {
					sDate = DateFormatter.returnStringDate(m[4]);
				}

				RequistionRestModel struct = new RequistionRestModel(m[0], m[1], m[2], m[3], sDate, m[5], m[6], null);
				respEdit.add(struct);
			}

			resp.setBody(respEdit.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<RequistionRestModel>> response = new ResponseEntity<JsonResponse<RequistionRestModel>>(
				resp, responseHeaders, HttpStatus.CREATED); 
		logger.info("Method : editRequistion ends");
		return response;
	}

	// Delete Structure
	public ResponseEntity<JsonResponse<Object>> deleteRequistionById(String id, String createdBy) {
		logger.info("Method : deleteRequistionById starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET  @p_requistionId='" + id + "',@p_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("requistionRoutines").setParameter("actionType", "deleterequition")
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

		logger.info("Method : deleteRequistionById ends");
		return response;
	}

	// modal

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RequistionRestModel>>> getrequiByIdl(String id) {

		logger.info("Method : getmodalview starts");

		List<RequistionRestModel> assignEduLis = new ArrayList<RequistionRestModel>();
		JsonResponse<List<RequistionRestModel>> resp = new JsonResponse<List<RequistionRestModel>>();

		try {

			String value = "SET @p_requistionId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("requistionRoutines")
					.setParameter("actionType", "getmodalview").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object Date = null;
				if (m[4] != null) {
					Date = DateFormatter.returnStringDate(m[4]);
				}
				RequistionRestModel HrmsEmployeeCertificationMode = new RequistionRestModel(m[0], m[1], m[2], m[3],
						Date, m[5], null, null);

				assignEduLis.add(HrmsEmployeeCertificationMode);

			}

			resp.setBody(assignEduLis);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RequistionRestModel>>> response = new ResponseEntity<JsonResponse<List<RequistionRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getmodalview ends");

		return response;
	}

}
