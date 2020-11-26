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
import nirmalya.aatithya.restmodule.common.utils.GenerateExitInitiateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.ExitInitiateModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class ExitInitateDao {
	Logger logger = LoggerFactory.getLogger(ExitInitateDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ExitInitiateModel>>> getEmpAutoComplete(String id) {
		logger.info("Method : getEmpAutoComplete starts");

		List<ExitInitiateModel> form = new ArrayList<ExitInitiateModel>();
		JsonResponse<List<ExitInitiateModel>> resp = new JsonResponse<List<ExitInitiateModel>>();
		try {
			String value = "SET @p_empId='" + id +"';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("exitInitiate")
					.setParameter("actionType", "getEmpDtls").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				ExitInitiateModel exitInitiateModel = new ExitInitiateModel(null,m[0],m[1],null,m[2],m[3],null,null,null,null,null);

				form.add(exitInitiateModel);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resp.setBody(form);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<ExitInitiateModel>>> response = new ResponseEntity<JsonResponse<List<ExitInitiateModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getEmpAutoComplete Dao ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepartmentList() {
		logger.info("Method : getDepartmentList starts");
		List<DropDownModel> departmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("exitInitiate").setParameter("actionType", "getDepartmentList")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				departmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDepartmentList end");
		return departmentList;
	}
	@SuppressWarnings("unused")
	public ResponseEntity<JsonResponse<Object>> restAddExitInitiate(List<ExitInitiateModel> exitInitiateModel){
		logger.info("Method : restAddExitInitiate starts");
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (ExitInitiateModel l : exitInitiateModel) {
			if (l.getEmpId() == null || l.getEmpId() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select emp id");
				break;

		
			} else if (l.getEmpName()== null || l.getEmpName() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Emp Name.");
				break;
			} else if (l.getEmpDepartment()== null || l.getEmpDepartment() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Emp Department.");
				break;
		
			
		}
		}
			if (validation) {
				try {
					String value = GenerateExitInitiateParameter
							.getExitInitiateParam(exitInitiateModel);
					if (exitInitiateModel.get(0).getIntiateId() != null
							&& exitInitiateModel.get(0).getIntiateId() != "") {
						
						em.createNamedStoredProcedureQuery("exitInitiate")
								.setParameter("actionType", "modifyExitIntitate").setParameter("actionValue", value)
								.execute();

					} else {
						
						em.createNamedStoredProcedureQuery("exitInitiate")
								.setParameter("actionType", "addExitInitate").setParameter("actionValue", value)
								.execute();
						System.out.println("add value"+value);
					}

					 resp.setCode("Data Saved Successfully");
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
			}
		
			ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
					HttpStatus.CREATED);
			logger.info("Method : restAddExitInitiate ends");
			System.out.println(response);
			return response;
	}
	public ResponseEntity<JsonResponse<List<ExitInitiateModel>>> getAllExitIntiate(DataTableRequest request) {
		logger.info("Method : getAllExitIntiate starts");
		List<ExitInitiateModel> form = new ArrayList<ExitInitiateModel>();
	
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("exitInitiate")
					.setParameter("actionType", "getAllExitIntiate").setParameter("actionValue", values)
					.getResultList();
			
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					
					ExitInitiateModel exitInitiateModel = new ExitInitiateModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],null);

					form.add(exitInitiateModel);
				}

				if (x.get(0).length > 10) {
					BigInteger t = (BigInteger) x.get(0)[10];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonResponse<List<ExitInitiateModel>> resp = new JsonResponse<List<ExitInitiateModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ExitInitiateModel>>> response = new ResponseEntity<JsonResponse<List<ExitInitiateModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getAllExitIntiate end");
		return response;
	}
	@SuppressWarnings("unchecked")
	public List<ExitInitiateModel> editExitIntiateById(String id) {
		logger.info("Method : editExitIntiateById Dao starts");

		List<ExitInitiateModel> exitDtls = new ArrayList<ExitInitiateModel>();
		JsonResponse<List<ExitInitiateModel>> resp = new JsonResponse<List<ExitInitiateModel>>();

		try {
			String value = "SET @p_empId='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("exitInitiate")
					.setParameter("actionType", "editExitIntiateById").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				
				ExitInitiateModel exitInitiateModel = new ExitInitiateModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10]);

				exitDtls.add(exitInitiateModel);
			}


			resp.setBody(exitDtls);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editExitIntiateById ends");
		System.out.println("exitDtls"+exitDtls);
		return exitDtls;
	}
}
