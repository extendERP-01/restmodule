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
import nirmalya.aatithya.restmodule.common.utils.GenerateDepartmentMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.HrmsDepartmentMasterModel;


@Repository
public class HrmsDepartmentMasterDao {

	Logger logger = LoggerFactory.getLogger(HrmsDepartmentMasterDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for all department details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsDepartmentMasterModel>>> getdepartmentDetails(DataTableRequest request) {

		logger.info("Method in Dao: getdepartmentDetails starts");

		List<HrmsDepartmentMasterModel> employementList = new ArrayList<HrmsDepartmentMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("departmentMaster")
					.setParameter("actionType", "viewdepartmentList").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					HrmsDepartmentMasterModel employement = new HrmsDepartmentMasterModel(m[0], m[1], m[2], m[3]);
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

		JsonResponse<List<HrmsDepartmentMasterModel>> resp = new JsonResponse<List<HrmsDepartmentMasterModel>>();
		resp.setBody(employementList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsDepartmentMasterModel>>> response = new ResponseEntity<JsonResponse<List<HrmsDepartmentMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getdepartmentDetails ends");

		return response;
	}

	/*
	 * for add new department
	 */
	public ResponseEntity<JsonResponse<Object>> adddepartment(HrmsDepartmentMasterModel department) {

		logger.info("Method in Dao: adddepartment starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (department.getDepartmentName() == null || department.getDepartmentName() == "") {
			resp.setMessage("department Name required");
			validity = false;
		} else if (department.getDepartmentDesc() == null || department.getDepartmentDesc() == "") {
			resp.setMessage("department description required");
			validity = false;
		} else if (department.getDepartmentStatus() == null) {
			resp.setMessage("department active required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateDepartmentMasterParameter.getAddDepartmentParam(department);
				if (department.getDepartmentId() != "") {
					em.createNamedStoredProcedureQuery("departmentMaster").setParameter("actionType", "modifydepartment")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("departmentMaster").setParameter("actionType", "addDepartment")
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

		logger.info("Method in Dao: adddepartment ends");

		return response;
	}

	/*
	 * for edit department
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<HrmsDepartmentMasterModel>>getdepartmentById(String id) {

		logger.info("Method in Dao: getdepartmentById ends");

		List<HrmsDepartmentMasterModel> pdepartment = new ArrayList<HrmsDepartmentMasterModel>();

		try {

			String value = "SET @P_deptId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("departmentMaster")
					.setParameter("actionType", "viewEditdepartment").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				HrmsDepartmentMasterModel department = new HrmsDepartmentMasterModel(m[0], m[1], m[2], m[3]);

				pdepartment.add(department);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<HrmsDepartmentMasterModel> resp = new JsonResponse<HrmsDepartmentMasterModel>();
		resp.setBody(pdepartment.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<HrmsDepartmentMasterModel>> response = new ResponseEntity<JsonResponse<HrmsDepartmentMasterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getdepartmentById ends");

		return response;
	}

	/*
	 * for delete department
	 */
	public ResponseEntity<JsonResponse<Object>>deletedepartmentById(String id, String createdBy) {

		logger.info("Method in Dao: deletedepartmentById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @P_deptId='" + id + "',@P_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("departmentMaster").setParameter("actionType", "deletedepartment")
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

		logger.info("Method in Dao: deletedepartmentById ends");

		return response;
	}

}

