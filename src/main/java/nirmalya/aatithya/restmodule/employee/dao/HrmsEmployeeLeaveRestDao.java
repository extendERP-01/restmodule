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
import nirmalya.aatithya.restmodule.common.utils.GenerateEmployeeleaveParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeLeaveUpdateRestModel;

@Repository
public class HrmsEmployeeLeaveRestDao {

	Logger logger = LoggerFactory.getLogger(HrmsEmployeeLeaveRestDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * DAO Function for Auto Complete for Item
	 * 
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmpIdAutoSearchList(String id) {

		logger.info("Method : getEmpIdAutoSearchList Dao starts");

		List<DropDownModel> form = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			String value = "SET @p_temp='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeLeaveRoutine")
					.setParameter("actionType", "getEmpAutoSearch").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel ItemAutoComplete = new DropDownModel(m[0], m[1]);

				form.add(ItemAutoComplete);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resp.setBody(form);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getEmpIdAutoSearchList Dao ends");

		return response;
	}

	/*
	 *
	 * DAO Function to view all list
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<HrmsEmployeeLeaveUpdateRestModel>> getEmployeeDtls(String id) {
		logger.info("Method : getAllList starts");
		List<HrmsEmployeeLeaveUpdateRestModel> form = new ArrayList<HrmsEmployeeLeaveUpdateRestModel>();
		try {
			String value = "SET @p_EmployeeId='" + id + "';";
			System.out.println("##" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeLeaveRoutine")
					.setParameter("actionType", "viewEmployeeDtls").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				HrmsEmployeeLeaveUpdateRestModel restItemModel = new HrmsEmployeeLeaveUpdateRestModel(null, m[0], m[1], null, m[2],
						null, null,null);
				form.add(restItemModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<HrmsEmployeeLeaveUpdateRestModel> resp = new JsonResponse<HrmsEmployeeLeaveUpdateRestModel>();
		resp.setBody(form.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<HrmsEmployeeLeaveUpdateRestModel>> response = new ResponseEntity<JsonResponse<HrmsEmployeeLeaveUpdateRestModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getAllList ends");
		System.out.println("####" + response);
		return response;
	}

	/*
	 * for add
	 */
	public ResponseEntity<JsonResponse<Object>> restUpdateEmployeeLeave(
			List<HrmsEmployeeLeaveUpdateRestModel> hrmsEmployeeLeaveRestModel) {

		logger.info("Method in Dao:restAddEmployeeEdu starts");
		System.out.println("@@@@@" + hrmsEmployeeLeaveRestModel);
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		for (HrmsEmployeeLeaveUpdateRestModel a : hrmsEmployeeLeaveRestModel) {
			if (a.getEmpId() == null || a.getEmpId() == "") {
				resp.setMessage("Employee Id not Selected");
				validity = false;
			} else if (a.getDate() == null) {
				resp.setMessage("Start Date Is not selected");
				validity = false;
			} else if (a.getAvlLeave() == null) {
				resp.setMessage("Available Leave Is not selected");
				validity = false;
			}

		}
		if (validity)
			try {
				String values = GenerateEmployeeleaveParameter.getupdateEmployeeLeave(hrmsEmployeeLeaveRestModel);

				if (hrmsEmployeeLeaveRestModel.get(0).getEmpLeaveId() != null)
				// && hrmsEmployeeLeaveRestModel.get(0).getEmpLeaveId() != "")
				{

					em.createNamedStoredProcedureQuery("employeeLeaveRoutine")
							.setParameter("actionType", "modifyEmployeeLeave").setParameter("actionValue", values)
							.execute();
					System.out.println("@@@@@" + values);
				} else {

					em.createNamedStoredProcedureQuery("employeeLeaveRoutine")
							.setParameter("actionType", "addEmployeeLeave").setParameter("actionValue", values)
							.execute();
					System.out.println("@@@@@" + values);

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

		logger.info("Method in Dao:restAddEmployeeEdu ends");

		return response;
	}

	/*
	 * for all assignLeave details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEmployeeLeaveUpdateRestModel>>> getAssignLeaveDetails(
			DataTableRequest request) {

		logger.info("Method in Dao: getAssignLeaveDetails starts");
		
		String param1 = request.getParam1();
		String param2 = request.getParam2();

		if (param1 != null && param1 != "") {
			String frmDate = DateFormatter.getStringDate(param1);
			request.setParam1(frmDate);
		} else {
			request.setParam1("");
		}
		if (param2 != null && param2 != "") {
			String tDate = DateFormatter.getStringDate(param2);
			request.setParam2(tDate);
		} else {
			request.setParam2("");
		}
		

		List<HrmsEmployeeLeaveUpdateRestModel> employementList = new ArrayList<HrmsEmployeeLeaveUpdateRestModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeLeaveRoutine")
					.setParameter("actionType", "getAssignLeaveDetails").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					Object Date = null;
					if (m[2] != null) {
						Date = DateFormatter.returnStringDate(m[2]);

					}
					HrmsEmployeeLeaveUpdateRestModel employement = new HrmsEmployeeLeaveUpdateRestModel(null, m[0], m[1], Date,
							m[3], null, null,null);
					employementList.add(employement);
				}

				if (x.get(0).length > 4) {
					BigInteger t = (BigInteger) x.get(0)[4];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsEmployeeLeaveUpdateRestModel>> resp = new JsonResponse<List<HrmsEmployeeLeaveUpdateRestModel>>();
		resp.setBody(employementList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsEmployeeLeaveUpdateRestModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEmployeeLeaveUpdateRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getAssignLeaveDetails ends");

		return response;
	}

	/*
	 * for delete
	 */
	public ResponseEntity<JsonResponse<Object>> deleteLeaveById(String id, String lid, String createdBy) {

		logger.info("Method in Dao: deleteLeaveById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_empId='" + id + "',@p_date='" + DateFormatter.getStringDate(lid) + "',@p_createdBy='"
					+ createdBy + "';";

			System.out.println("###" + value);

			em.createNamedStoredProcedureQuery("employeeLeaveRoutine").setParameter("actionType", "deleteLeave")
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

		logger.info("Method in Dao: deleteLeaveById ends");

		return response;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public ResponseEntity<JsonResponse<Object>> updateLeaveDate(HrmsEmployeeLeaveUpdateRestModel hrmsEmployeeLeaveRestModel) {
		logger.info("Method : updateLeaveDate starts");

		/*
		 * List<HrmsEmployeeLeaveUpdateRestModel> vendorList = new
		 * ArrayList<HrmsEmployeeLeaveUpdateRestModel>(); List<DropDownModel> dropDownModel =
		 * new ArrayList<DropDownModel>();
		 */
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validation) {

			try {
				String value = "SET @p_empId='" + hrmsEmployeeLeaveRestModel.getEmpId() + "', @p_prevDate='"
						+ DateFormatter.getStringDate(hrmsEmployeeLeaveRestModel.getPrevDate()) + "', @p_newdate='"
						+ DateFormatter.getStringDate(hrmsEmployeeLeaveRestModel.getDate()) + "', @p_createdBy='"
						+ hrmsEmployeeLeaveRestModel.getCreatedBy() + "';";
				System.out.println(value);

				em.createNamedStoredProcedureQuery("employeeLeaveRoutine").setParameter("actionType", "updateleaveDate")
						.setParameter("actionValue", value).execute();

			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage("Sucsess");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method :  updateLeaveDate Order ends");
		System.out.println(response);
		return response;
	}

}
