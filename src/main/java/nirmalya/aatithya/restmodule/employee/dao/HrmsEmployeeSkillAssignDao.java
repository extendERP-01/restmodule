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
import nirmalya.aatithya.restmodule.common.utils.GenerateEmployeeSkillAssignParam;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeSkillAssignModel;

@Repository
public class HrmsEmployeeSkillAssignDao {
	Logger logger = LoggerFactory.getLogger(HrmsEmployeeSkillAssignDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for all assignSkill details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEmployeeSkillAssignModel>>> getassignSkillDetails(DataTableRequest request) {

		logger.info("Method in Dao: getassignSkillDetails starts");

		List<HrmsEmployeeSkillAssignModel> employementList = new ArrayList<HrmsEmployeeSkillAssignModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeSkillAssign")
					.setParameter("actionType", "viewAssignSkillList").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					HrmsEmployeeSkillAssignModel employement = new HrmsEmployeeSkillAssignModel(m[0], m[1], m[2], m[3], m[4]);
					employementList.add(employement);

				}

				if (x.get(0).length >5) {
					BigInteger t = (BigInteger) x.get(0)[5];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsEmployeeSkillAssignModel>> resp = new JsonResponse<List<HrmsEmployeeSkillAssignModel>>();
		resp.setBody(employementList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsEmployeeSkillAssignModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEmployeeSkillAssignModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getassignSkillDetails ends");

		return response;
	}

	/*
	 * for add new assignSkill
	 */
	public ResponseEntity<JsonResponse<Object>> addassignSkill(HrmsEmployeeSkillAssignModel assignSkill) {

		logger.info("Method in Dao: addassignSkill starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (assignSkill.getEmployeeId() == null || assignSkill.getEmployeeId() == "") {
			resp.setMessage("Employee Name required");
			validity = false;
		} else if (assignSkill.getEmployeeSkillDesc()== null || assignSkill.getEmployeeId() == "") {
			resp.setMessage("Skill description required");
			validity = false;
		} else if (assignSkill.getSkillId() == null) {
			resp.setMessage("Skill active required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateEmployeeSkillAssignParam.getAddEmployeeSkillParam(assignSkill);
				System.out.println(values);
				if (assignSkill.getEditId() =="" || assignSkill.getEditId() ==null) {
			
					em.createNamedStoredProcedureQuery("EmployeeSkillAssign").setParameter("actionType", "addassignSkill")
							.setParameter("actionValue", values).execute();
					
				} else {
			
					em.createNamedStoredProcedureQuery("EmployeeSkillAssign").setParameter("actionType", "modifyassignSkill")
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

		logger.info("Method in Dao: addassignSkill ends");

		return response;
	}

	/*
	 * for edit assignSkill
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<HrmsEmployeeSkillAssignModel>>getassignSkillById(String id ) {

		logger.info("Method in Dao: getassignSkillById ends");

		List<HrmsEmployeeSkillAssignModel> passignSkill = new ArrayList<HrmsEmployeeSkillAssignModel>();

		try {

			String value = "SET @P_empId='" + id +"';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeSkillAssign")
					.setParameter("actionType", "viewEditassignSkill").setParameter("actionValue", value).getResultList();
           String  ms  = "";
           String skillNames = "";
			for (Object[] m : x) {
				HrmsEmployeeSkillAssignModel assignSkill = new HrmsEmployeeSkillAssignModel(m[0], m[1], m[2], m[3],m[4]);
				ms = ms + m[3] +",";
				skillNames = skillNames + m[1]+" ,";
				passignSkill.add(assignSkill);
				
			}
			ms = ms.substring(0, ms.length() - 1);
			skillNames = skillNames.substring(0, skillNames.length() - 1);
			passignSkill.get(0).setSkillId(ms);
			passignSkill.get(0).setEmployeeSkill(skillNames);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<HrmsEmployeeSkillAssignModel> resp = new JsonResponse<HrmsEmployeeSkillAssignModel>();
		resp.setBody(passignSkill.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<HrmsEmployeeSkillAssignModel>> response = new ResponseEntity<JsonResponse<HrmsEmployeeSkillAssignModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getassignSkillById ends");
System.out.println(resp);
		return response;
	}

	/*
	 * for delete assignSkill
	 */
	public ResponseEntity<JsonResponse<Object>>deleteassignSkillById(String id,String skillId, String createdBy) {

		logger.info("Method in Dao: deleteassignSkillById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @P_employeId='" + id +"',@P_skillId='"+skillId+ "',@P_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("EmployeeSkillAssign").setParameter("actionType", "deleteassignSkill")
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

		logger.info("Method in Dao: deleteassignSkillById ends");

		return response;
	}
	/**
	 * for department list
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSkillList() {
		
		logger.info("Method : getSkillList starts");
		
		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeSkillAssign")
					.setParameter("actionType", "getSkillList")
					.setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getSkillList ends");
		
		return employmentList;
	}
	/**
	 * for Employee list
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmployeeList() {
		
		logger.info("Method : getEmployeeList starts");
		
		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeSkillAssign")
					.setParameter("actionType", "getEmployeeList")
					.setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getEmployeeList ends");
		
		return employmentList;
	}

}

