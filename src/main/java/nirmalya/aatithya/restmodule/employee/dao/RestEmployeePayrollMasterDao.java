package nirmalya.aatithya.restmodule.employee.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
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
import nirmalya.aatithya.restmodule.common.utils.GenerateEmployeePayRollParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.EmployeePayrollMasterModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeSalaryComponentsModel;

@Repository
public class RestEmployeePayrollMasterDao {

	Logger logger = LoggerFactory.getLogger(RestEmployeePayrollMasterDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> validateDate(String param1) {
		System.out.println("param1" + param1);
		logger.info("Method in Dao: validateDate starts");
		String value = "SET @p_param1 = '" + param1 + "';";
		System.out.println("data" + value);

		List<DropDownModel> employeList = new ArrayList<DropDownModel>();

		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeePayRoll")
					.setParameter("actionType", "validateDate").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					DropDownModel employe = new DropDownModel(m[0], m[1].toString());
					employeList.add(employe);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setBody(employeList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: validateDate ends");
		System.out.println("response" + response);
		return response;
	}

	/*
	 * 
	 * 
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<EmployeePayrollMasterModel>>> getEmployeePayRollDetails(String param1) {
		System.out.println("param1" + param1);
		logger.info("Method in Dao: getEmployeePayRollDetails starts");
		String value = DateFormatter.getMonthYear(param1);
		System.out.println("data" + value);

		List<EmployeePayrollMasterModel> employeList = new ArrayList<EmployeePayrollMasterModel>();

		Integer total = 0;
		System.out.println("generate param are " + value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeePayRoll")
					.setParameter("actionType", "pRollDtls").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					BigDecimal b = new BigDecimal(new Double(m[3].toString()), MathContext.DECIMAL64);
					BigDecimal b1 = new BigDecimal(new Double(m[16].toString()), MathContext.DECIMAL64);
					EmployeePayrollMasterModel employe = new EmployeePayrollMasterModel(null, m[0], m[1], null, null,
							m[2], b, m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], null, null, null, null, null,
							null, m[12], m[13], m[14], m[15], b1, m[17], null, null, null, null, null, null, m[18],
							m[19], m[20]);
					employeList.add(employe);
					try {
						List<HrmsEmployeeSalaryComponentsModel> HrmsEmployeeSalaryComponentsModelList = new ArrayList<HrmsEmployeeSalaryComponentsModel>();
						String values = "SET @p_gradeId = '" + employe.gettPayGrade() + "';";
						System.out.println(values);
						List<Object[]> x1 = em.createNamedStoredProcedureQuery("EmployeePayRoll")
								.setParameter("actionType", "getsalaryComponents").setParameter("actionValue", values)
								.getResultList();
						if (!x1.isEmpty()) {
							for (Object[] m1 : x1) {

								HrmsEmployeeSalaryComponentsModel components = new HrmsEmployeeSalaryComponentsModel(
										m1[0], m1[1], m1[2], m1[3], null, null);
								HrmsEmployeeSalaryComponentsModelList.add(components);

							}
							employe.setSalaryComponentsDetails(HrmsEmployeeSalaryComponentsModelList);
						}
					} catch (Exception e) {
						employe.setSalaryComponentsDetails(new ArrayList<HrmsEmployeeSalaryComponentsModel>());
					}

				}

				if (x.get(0).length > 20) {
					BigInteger t = (BigInteger) x.get(0)[20];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<EmployeePayrollMasterModel>> resp = new JsonResponse<List<EmployeePayrollMasterModel>>();
		resp.setBody(employeList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<EmployeePayrollMasterModel>>> response = new ResponseEntity<JsonResponse<List<EmployeePayrollMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getEmployeePayRollDetails ends");
		System.out.println("response" + response);
		return response;
	}

	/*
	 * offer letter details modal view
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	public ResponseEntity<JsonResponse<List<EmployeePayrollMasterModel>>> employeePayrollDetailsModal(String id) {

		logger.info("Method : employeePayrollDetailsModal starts");

		List<EmployeePayrollMasterModel> form = new ArrayList<EmployeePayrollMasterModel>();
		JsonResponse<List<EmployeePayrollMasterModel>> resp = new JsonResponse<List<EmployeePayrollMasterModel>>();
		try {

			String value = "SET @P_empId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeePayRoll")
					.setParameter("actionType", "empDetailsModel").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				BigInteger lastDay = (BigInteger) m[13];
				Integer a = null;
				if (m[13] != null) {
					a = lastDay.intValue();
				}
				/*
				 * Object dob = null; Object joinDate = null; if (m[2] != null) { dob =
				 * DateFormatter.returnStringDate(m[2]); } if (m[7] != null) { joinDate =
				 * DateFormatter.returnStringDate(m[7]); }
				 */
				EmployeePayrollMasterModel payrollMaster = new EmployeePayrollMasterModel(null, m[0], m[1], null, null,
						m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], null, null, null, null, m[12], a,
						m[14], m[15], m[16], m[17], m[18], m[19], null, null, null, null, null, null, null, null, null);

				form.add(payrollMaster);
			}
			resp.setBody(form);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<EmployeePayrollMasterModel>>> response = new ResponseEntity<JsonResponse<List<EmployeePayrollMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : employeePayrollDetailsModal ends");

		return response;
	}

	/*
	 * for add new goal
	 */
	public ResponseEntity<JsonResponse<Object>> restAddEmployeePayRoll(List<EmployeePayrollMasterModel> payrollMaster) {

		logger.info("Method in Dao: restAddEmployeePayRoll starts");
		System.out.println("payrollMaster" + payrollMaster);
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String values = GenerateEmployeePayRollParameter.getAddPayRollParam(payrollMaster);

				em.createNamedStoredProcedureQuery("EmployeePayRoll").setParameter("actionType", "addPRollDtls")
						.setParameter("actionValue", values).execute();

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

		logger.info("Method in Dao: restAddEmployeePayRoll ends");

		return response;
	}

	/*
	 * for all Goal Master view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<EmployeePayrollMasterModel>>> getPayrollDetails(DataTableRequest request) {

		logger.info("Method in Dao: getPayrollDetails starts");

		List<EmployeePayrollMasterModel> payrollMasterList = new ArrayList<EmployeePayrollMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeePayRoll")
					.setParameter("actionType", "viewPayRollList").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[1] != null) {
						try {
							date = DateFormatter.returnStringDate(m[1]);
						} catch (Exception e) {
							date = "--";
						}

					}
					EmployeePayrollMasterModel payrollMaster = new EmployeePayrollMasterModel(m[0], date, m[2], m[3],
							m[4], null, null, null, null, null);
					payrollMasterList.add(payrollMaster);

				}

				if (x.get(0).length > 5) {
					BigInteger t = (BigInteger) x.get(0)[5];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<EmployeePayrollMasterModel>> resp = new JsonResponse<List<EmployeePayrollMasterModel>>();
		resp.setBody(payrollMasterList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<EmployeePayrollMasterModel>>> response = new ResponseEntity<JsonResponse<List<EmployeePayrollMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getPayrollDetails ends");

		return response;
	}

	/**
	 * DAO Function to get All ItemRequisition in inventory to be approve
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<EmployeePayrollMasterModel>>> getAllPayrollApprove(
			DataTableRequest request) {
		logger.info("Method : getAllRequisitionsApprove starts");

		List<EmployeePayrollMasterModel> payrollMaster = new ArrayList<EmployeePayrollMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		System.out.println("values" + values);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeePayRoll")
					.setParameter("actionType", "viewAllPayrollToApprove").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					try {
						date = DateFormatter.returnStringDate(m[1]);
					} catch (Exception e) {
						date = "--";
					}
					m[6] = Integer.valueOf(((BigInteger) m[6]).toString());
					m[8] = Integer.valueOf(((BigInteger) m[8]).toString());
					EmployeePayrollMasterModel item = new EmployeePayrollMasterModel(m[0], date, m[2], m[3], m[4], m[5],
							m[6], m[7], m[8], m[9]);
					payrollMaster.add(item);
				}

				if (x.get(0).length > 10) {
					BigInteger t = (BigInteger) x.get(0)[10];

					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<EmployeePayrollMasterModel>> resp = new JsonResponse<List<EmployeePayrollMasterModel>>();
		resp.setBody(payrollMaster);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<EmployeePayrollMasterModel>>> response = new ResponseEntity<JsonResponse<List<EmployeePayrollMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllRequisitionsApprove ends");
		return response;
	}

	/**
	 * DAO Function to save Payroll Approval Action
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> savePayrollApprovalAction(String id, String createdBy) {
		logger.info("Method : savePayrollApprovalAction starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_id='" + id + "',@p_createdBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("EmployeePayRoll").setParameter("actionType", "forwardPayroll")
					.setParameter("actionValue", value).execute();

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
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method : savePayrollApprovalAction ends");
		return response;
	}

	/**
	 * DAO Function to save Requisition Reject Action
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> savePayrollRejectAction(EmployeePayrollMasterModel reqobject) {
		logger.info("Method : savePayrollRejectAction starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_id='" + reqobject.gettId() + "',@p_rejectComment='" + reqobject.gettPayGrade()
					+ "',@p_createdBy='" + reqobject.gettEmployeeName() + "';";

			String actionType = "";
			if (reqobject.gettCity().equals("1"))
				actionType = "rejectRequisition";
			else if (reqobject.gettCity().equals("2"))
				actionType = "returnRequisition";
			else
				actionType = "resubmitRequisition";

			System.out.println("Type==" + reqobject.gettCity());
			System.out.println("actionType==" + actionType);
			System.out.println("value==" + value);

			em.createNamedStoredProcedureQuery("EmployeePayRoll").setParameter("actionType", actionType)
					.setParameter("actionValue", value).execute();

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
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method : savePayrollRejectAction ends");
		return response;
	}

	/*
	 * DAO Function to view one task assigned in PDF
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<EmployeePayrollMasterModel>> getOneEmpPayrollForPDF(String id) {
		logger.info("Method : getOneEmpPayrollForPDF starts");
		List<EmployeePayrollMasterModel> form = new ArrayList<EmployeePayrollMasterModel>();
		try {
			String value = "SET @P_empId='" + id + "';";
			System.out.println("value++++++++++" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeePayRoll")
					.setParameter("actionType", "pRollDtlsPDF").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				BigInteger lastDay = (BigInteger) m[13];
				Integer a = null;
				if (m[13] != null) {
					a = lastDay.intValue();
				}
				EmployeePayrollMasterModel oneEmpPDF = new EmployeePayrollMasterModel(null, m[0], m[1], null, null,
						m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], null, null, null, null, m[12], a,
						m[14], m[15], m[16], m[17], m[18], m[19], null, null, null, null, null, null, null, null, null);
				form.add(oneEmpPDF);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<EmployeePayrollMasterModel> resp = new JsonResponse<EmployeePayrollMasterModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<EmployeePayrollMasterModel>> response = new ResponseEntity<JsonResponse<EmployeePayrollMasterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getOneEmpPayrollForPDF ends");
		System.out.println("response++++++++++" + response);
		return response;
	}

	/**
	 * DAO Function to edit ItemRequisition
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<EmployeePayrollMasterModel>>> getPayrollById(String id) {

		logger.info("Method : employeePayrollDetailsModal starts");

		List<EmployeePayrollMasterModel> form = new ArrayList<EmployeePayrollMasterModel>();
		JsonResponse<List<EmployeePayrollMasterModel>> resp = new JsonResponse<List<EmployeePayrollMasterModel>>();
		try {

			String value = "SET @P_empId='" + id + "';";
			System.out.println("value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeePayRoll")
					.setParameter("actionType", "empDetailsModel").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				BigInteger lastDay = (BigInteger) m[13];
				Integer a = null;
				if (m[13] != null) {
					a = lastDay.intValue();
				}
				/*
				 * Object dob = null; Object joinDate = null; if (m[2] != null) { dob =
				 * DateFormatter.returnStringDate(m[2]); } if (m[7] != null) { joinDate =
				 * DateFormatter.returnStringDate(m[7]); }
				 */
				EmployeePayrollMasterModel payrollMaster = new EmployeePayrollMasterModel(null, m[0], m[1], null, null,
						m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], null, null, null, null, m[12], a,
						m[14], m[15], m[16], m[17], m[18], m[19], null, null, null, null, null, null, null, null, null);

				form.add(payrollMaster);
			}
			resp.setBody(form);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<EmployeePayrollMasterModel>>> response = new ResponseEntity<JsonResponse<List<EmployeePayrollMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : employeePayrollDetailsModal ends");

		return response;
	}

}
