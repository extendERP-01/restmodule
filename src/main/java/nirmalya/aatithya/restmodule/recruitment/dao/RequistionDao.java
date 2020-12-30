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
import nirmalya.aatithya.restmodule.recruitment.model.AddRecruitentModel;
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
	public List<DropDownModel> jobTypeList() {
		logger.info("Method : jobTypeList Dao starts");

		List<DropDownModel> jobList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("requistionRoutines")
					.setParameter("actionType", "jobType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				jobList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : jobTypeList Dao ends");

		return jobList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> jobLocationList() {
		logger.info("Method : jobLocationList Dao starts");

		List<DropDownModel> jobLocationList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("requistionRoutines")
					.setParameter("actionType", "jobLocation").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				jobLocationList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : jobLocationList Dao ends");

		return jobLocationList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> DepartmentList() {
		logger.info("Method : DepartmentList Dao starts");

		List<DropDownModel> DepartmentList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("requistionRoutines")
					.setParameter("actionType", "department").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				DepartmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : DepartmentList Dao ends");

		return DepartmentList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> managerList() {
		logger.info("Method : managerList Dao starts");

		List<DropDownModel> managerList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("requistionRoutines")
					.setParameter("actionType", "employeeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				managerList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : managerList Dao ends");

		return managerList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> bandList() {
		logger.info("Method : bandList Dao starts");

		List<DropDownModel> bandList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("requistionRoutines")
					.setParameter("actionType", "bandList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				bandList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : bandList Dao ends");

		return bandList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> educationList() {
		logger.info("Method : educationList Dao starts");

		List<DropDownModel> educationList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("requistionRoutines")
					.setParameter("actionType", "educationList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				educationList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : educationList Dao ends");

		return educationList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> workHourList() {
		logger.info("Method : workHourList Dao starts");

		List<DropDownModel> workHourList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("requistionRoutines")
					.setParameter("actionType", "workHourList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				workHourList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : workHourList Dao ends");

		return workHourList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> benefitsList() {
		logger.info("Method : benefitsList Dao starts");

		List<DropDownModel> benefitsList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("requistionRoutines")
					.setParameter("actionType", "benefitsList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				benefitsList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : benefitsList Dao ends");

		return benefitsList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> aboutCompany() {
		logger.info("Method : aboutCompany Dao starts");

		List<DropDownModel> aboutCompany = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("requistionRoutines")
					.setParameter("actionType", "aboutCompany").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				aboutCompany.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : aboutCompany Dao ends");

		return aboutCompany;
	}
	
	public ResponseEntity<JsonResponse<Object>> addRequisition(AddRecruitentModel req) {
		logger.info("Method : addRequisition starts");
		Boolean validity = true;

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if(req.getJobTitle() == null || req.getJobTitle() == "") {
			resp.setBody("Please Enter Job Title");
			validity = false;
		} else if(req.getJobType() == null || req.getJobType() == "") {
			resp.setBody("Please Enter Job Type");
			validity = false;
		}
		
		if (validity)
			try {
				String values = GenerateReqParameter.getAddreqParam(req);
				System.out.println(values);

				if (req.getRequisitionId() != null && req.getRequisitionId() != "") {
					System.out.println("print in modify block");
					em.createNamedStoredProcedureQuery("requistionRoutines").setParameter("actionType", "modifyreq")
					.setParameter("actionValue", values).execute();
				} else {
					
					em.createNamedStoredProcedureQuery("requistionRoutines").setParameter("actionType", "addreq")
					.setParameter("actionValue", values).execute();
					System.out.println("print in addreq block");
					
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

		logger.info("Method : addRequisition ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AddRecruitentModel>>> viewRequistion() {
			logger.info("Method : getRequistionview starts");

			List<AddRecruitentModel> viewreq = new ArrayList<AddRecruitentModel>();

			try {

				List<Object[]> x = em.createNamedStoredProcedureQuery("requistionRoutines")
						.setParameter("actionType", "viewRequ").setParameter("actionValue", "").getResultList();
				System.out.println(x);
				for (Object[] m : x) {
					Object sDate = null;
					if (m[7] != null) {
						sDate = DateFormatter.returnStringDate(m[7]);
					}
					Object Date = null;
					if (m[8] != null) {
						Date = DateFormatter.returnStringDate(m[8]);
					}

					AddRecruitentModel reqModel = new AddRecruitentModel(m[0],null,m[1],null,null,null,m[2],null,m[3],m[4],m[5],null,m[6],sDate,
							null,null,null,null,null,null,Date,m[9],null);
					viewreq.add(reqModel);
				}


			} catch (Exception e) {
				e.printStackTrace();
			}
			JsonResponse<List<AddRecruitentModel>> resp = new JsonResponse<List<AddRecruitentModel>>();
			resp.setBody(viewreq);

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");
			ResponseEntity<JsonResponse<List<AddRecruitentModel>>> response = new ResponseEntity<JsonResponse<List<AddRecruitentModel>>>(
					resp, responseHeaders, HttpStatus.CREATED);
			System.out.println("###########" + response);
			logger.info("Method :  getRequistionview ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteRequistionById(String id) {
		logger.info("Method : deleteRequistionById starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET  @p_requistionId='(" + id + ")'";
			System.out.println("DELETE "+value);

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
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AddRecruitentModel>>> editRequisition(String id) {
		logger.info("Method : editRequisition starts");
		
	
		List<AddRecruitentModel> req = new ArrayList<AddRecruitentModel>();
		JsonResponse<List<AddRecruitentModel>> resp = new JsonResponse<List<AddRecruitentModel>>();

		try {

			String value = "SET @p_requisitionId='" + id +"';";
			System.out.println(value);
		
			List<Object[]> x = em.createNamedStoredProcedureQuery("requistionRoutines")
					.setParameter("actionType", "editReq")
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				
				Object sDate = null;
				if (m[12] != null) {
				sDate = DateFormatter.returnStringDate(m[12]);
				}
			
				Object sDate2 = null;
				if (m[19] != null) {
				sDate2 = DateFormatter.returnStringDate(m[19]);
				}
				
				AddRecruitentModel reqEdit = new AddRecruitentModel(m[0],null,m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10],m[11],sDate
						,m[13],m[14],m[15],m[16],m[17],m[18],sDate2,m[20],m[21]);
				req.add(reqEdit);
				
			}
			
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<AddRecruitentModel>>> response = new ResponseEntity<JsonResponse<List<AddRecruitentModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : editRequisition ends");
		System.out.println(response);
		return response;
	}
	
	/*
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<DropDownModel>> getJobTitleForJobTitl(String id)
	 * {
	 * 
	 * logger.info("Method : jobtitle starts");
	 * 
	 * DropDownModel jobtitle = new DropDownModel(); JsonResponse<DropDownModel>
	 * resp = new JsonResponse<DropDownModel>(); String value =
	 * "SET @p_requistionId='" + id + "';"; try { List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("requistionRoutines")
	 * .setParameter("actionType", "jobTitle").setParameter("actionValue",
	 * value).getResultList(); for (Object[] m : x) { jobtitle = new
	 * DropDownModel(m[0], m[1]); //jobtitle.add(dropDownModel); }
	 * 
	 * resp.setBody(jobtitle);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * ResponseEntity<JsonResponse<DropDownModel>> response = new
	 * ResponseEntity<JsonResponse<DropDownModel>>( resp, HttpStatus.CREATED);
	 * 
	 * logger.info("Method : getjobtitle ends"); return response; }
	 * 
	 * @SuppressWarnings("unchecked") public List<DropDownModel>
	 * getDepartmentForDepa() { logger.info("Method : getDepartmentForDepa starts");
	 * List<DropDownModel> departmentList = new ArrayList<DropDownModel>();
	 * 
	 * try { List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("requistionRoutines")
	 * .setParameter("actionType", "getdepartment").setParameter("actionValue",
	 * "").getResultList();
	 * 
	 * for (Object[] m : x) { DropDownModel dropDownModel = new DropDownModel(m[0],
	 * m[1]); departmentList.add(dropDownModel); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * logger.info("Method : getDepartmentForDepa end"); return departmentList; }
	 * 
	 * @SuppressWarnings("unchecked") public List<DropDownModel>
	 * getHiringManagerForMang() {
	 * logger.info("Method : getHiringManagerForMang starts"); List<DropDownModel>
	 * hiringmanagerList = new ArrayList<DropDownModel>();
	 * 
	 * try { List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("requistionRoutines")
	 * .setParameter("actionType", "gethiringmanager").setParameter("actionValue",
	 * "").getResultList();
	 * 
	 * for (Object[] m : x) { DropDownModel dropDownModel = new DropDownModel(m[0],
	 * m[1]); hiringmanagerList.add(dropDownModel); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * logger.info("Method : getHiringManagerForMang end"); return
	 * hiringmanagerList; }
	 * 
	 *//**
		 * DAO - Add Requistion
		 *
		 *//*
			 * public ResponseEntity<JsonResponse<Object>>
			 * restAddRequistion(RequistionRestModel req) {
			 * logger.info("Method : restAddRequistion starts"); Boolean validity = true;
			 * 
			 * JsonResponse<Object> resp = new JsonResponse<Object>(); resp.setMessage("");
			 * resp.setCode("");
			 * 
			 * if (req.getBudget() == null) { resp.setMessage("Budget"); validity = false;
			 * 
			 * }
			 * 
			 * if (validity) try { String values = GenerateReqParameter.getAddreqParam(req);
			 * 
			 * if (req.getRequistionId() != null && req.getRequistionId() != "") {
			 * em.createNamedStoredProcedureQuery("requistionRoutines").setParameter(
			 * "actionType", "modifyreq") .setParameter("actionValue", values).execute(); }
			 * else {
			 * 
			 * em.createNamedStoredProcedureQuery("requistionRoutines").setParameter(
			 * "actionType", "addreq") .setParameter("actionValue", values).execute();
			 * 
			 * } } catch
			 * 
			 * (Exception e) { try { String[] err = serverDao.errorProcedureCall(e);
			 * resp.setCode(err[0]); resp.setMessage(err[1]);
			 * 
			 * } catch (Exception e1) { e1.printStackTrace(); }
			 * 
			 * }
			 * 
			 * ResponseEntity<JsonResponse<Object>> response = new
			 * ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);
			 * 
			 * logger.info("Method : restAddRequistion ends"); return response; }
			 * 
			 * // view requition dao
			 * 
			 * @SuppressWarnings("unchecked") public
			 * ResponseEntity<JsonResponse<List<RequistionRestModel>>>
			 * viewRequistion(DataTableRequest request) {
			 * logger.info("Method : getRequistionview starts");
			 * 
			 * List<RequistionRestModel> viewreq = new ArrayList<RequistionRestModel>();
			 * String values = GenerateParameter.getSearchParam(request); Integer total = 0;
			 * 
			 * try {
			 * 
			 * List<Object[]> x = em.createNamedStoredProcedureQuery("requistionRoutines")
			 * .setParameter("actionType", "viewRequ").setParameter("actionValue",
			 * values).getResultList();
			 * 
			 * for (Object[] m : x) { Object sDate = null; if (m[4] != null) { sDate =
			 * DateFormatter.returnStringDate(m[4]); }
			 * 
			 * RequistionRestModel reqModel = new RequistionRestModel(m[0], m[1], m[2],
			 * m[3], sDate, m[5], m[6], null); viewreq.add(reqModel); }
			 * 
			 * if (x.size() > 0) {
			 * 
			 * if (x.get(0).length > 7) { BigInteger t = (BigInteger) x.get(0)[7];
			 * 
			 * total = Integer.parseInt((t.toString())); }
			 * 
			 * }
			 * 
			 * } catch (Exception e) { e.printStackTrace(); }
			 * JsonResponse<List<RequistionRestModel>> resp = new
			 * JsonResponse<List<RequistionRestModel>>(); resp.setBody(viewreq);
			 * resp.setTotal(total);
			 * 
			 * HttpHeaders responseHeaders = new HttpHeaders();
			 * responseHeaders.set("MyResponseHeader", "MyValue");
			 * ResponseEntity<JsonResponse<List<RequistionRestModel>>> response = new
			 * ResponseEntity<JsonResponse<List<RequistionRestModel>>>( resp,
			 * responseHeaders, HttpStatus.CREATED);
			 * logger.info("Method :  getRequistionview ends"); return response; }
			 * 
			 * // Edit view Structure dao
			 * 
			 * @SuppressWarnings("unchecked") public
			 * ResponseEntity<JsonResponse<RequistionRestModel>>
			 * restAddRequistionbyId(String id) {
			 * logger.info("Method : editRequistion starts");
			 * 
			 * List<RequistionRestModel> respEdit = new ArrayList<RequistionRestModel>();
			 * JsonResponse<RequistionRestModel> resp = new
			 * JsonResponse<RequistionRestModel>();
			 * 
			 * try {
			 * 
			 * String value = "SET @p_requistionId='" + id + "';"; List<Object[]> x =
			 * em.createNamedStoredProcedureQuery("requistionRoutines")
			 * .setParameter("actionType", "viewEditrequ").setParameter("actionValue",
			 * value).getResultList();
			 * 
			 * for (Object[] m : x) { Object sDate = null; if (m[4] != null) { sDate =
			 * DateFormatter.returnStringDate(m[4]); }
			 * 
			 * RequistionRestModel struct = new RequistionRestModel(m[0], m[1], m[2], m[3],
			 * sDate, m[5], m[6], null); respEdit.add(struct); }
			 * 
			 * resp.setBody(respEdit.get(0)); } catch (Exception e) { e.printStackTrace(); }
			 * 
			 * HttpHeaders responseHeaders = new HttpHeaders();
			 * responseHeaders.set("MyResponseHeader", "MyValue");
			 * 
			 * ResponseEntity<JsonResponse<RequistionRestModel>> response = new
			 * ResponseEntity<JsonResponse<RequistionRestModel>>( resp, responseHeaders,
			 * HttpStatus.CREATED); logger.info("Method : editRequistion ends"); return
			 * response; }
			 * 
			 * // Delete Structure public ResponseEntity<JsonResponse<Object>>
			 * deleteRequistionById(String id, String createdBy) {
			 * logger.info("Method : deleteRequistionById starts");
			 * 
			 * JsonResponse<Object> resp = new JsonResponse<Object>(); resp.setMessage("");
			 * resp.setCode("");
			 * 
			 * try { String value = "SET  @p_requistionId='" + id + "',@p_createdBy='" +
			 * createdBy + "';";
			 * 
			 * em.createNamedStoredProcedureQuery("requistionRoutines").setParameter(
			 * "actionType", "deleterequition") .setParameter("actionValue",
			 * value).execute();
			 * 
			 * } catch (Exception e) { e.printStackTrace(); String[] err =
			 * serverDao.errorProcedureCall(e); resp.setCode(err[0]);
			 * resp.setMessage(err[1]); }
			 * 
			 * HttpHeaders responseHeaders = new HttpHeaders();
			 * responseHeaders.set("MyResponseHeader", "MyValue");
			 * ResponseEntity<JsonResponse<Object>> response = new
			 * ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
			 * HttpStatus.CREATED);
			 * 
			 * logger.info("Method : deleteRequistionById ends"); return response; }
			 * 
			 * // modal
			 * 
			 * @SuppressWarnings("unchecked") public
			 * ResponseEntity<JsonResponse<List<RequistionRestModel>>> getrequiByIdl(String
			 * id) {
			 * 
			 * logger.info("Method : getmodalview starts");
			 * 
			 * List<RequistionRestModel> assignEduLis = new
			 * ArrayList<RequistionRestModel>(); JsonResponse<List<RequistionRestModel>>
			 * resp = new JsonResponse<List<RequistionRestModel>>();
			 * 
			 * try {
			 * 
			 * String value = "SET @p_requistionId='" + id + "';"; List<Object[]> x =
			 * em.createNamedStoredProcedureQuery("requistionRoutines")
			 * .setParameter("actionType", "getmodalview").setParameter("actionValue",
			 * value).getResultList();
			 * 
			 * for (Object[] m : x) { Object Date = null; if (m[4] != null) { Date =
			 * DateFormatter.returnStringDate(m[4]); } RequistionRestModel
			 * HrmsEmployeeCertificationMode = new RequistionRestModel(m[0], m[1], m[2],
			 * m[3], Date, m[5], null, null);
			 * 
			 * assignEduLis.add(HrmsEmployeeCertificationMode);
			 * 
			 * }
			 * 
			 * resp.setBody(assignEduLis); } catch (Exception e) { e.printStackTrace(); }
			 * 
			 * HttpHeaders responseHeaders = new HttpHeaders();
			 * responseHeaders.set("MyResponseHeader", "MyValue");
			 * 
			 * ResponseEntity<JsonResponse<List<RequistionRestModel>>> response = new
			 * ResponseEntity<JsonResponse<List<RequistionRestModel>>>( resp,
			 * responseHeaders, HttpStatus.CREATED);
			 * 
			 * logger.info("Method : getmodalview ends");
			 * 
			 * return response; }
			 */

}
