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
import nirmalya.aatithya.restmodule.common.utils.GenerateEmployeeParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeDocumentsModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeGroupInsuranceModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeSalaryStructureModel;
import nirmalya.aatithya.restmodule.employee.model.RestIncomeTaxModel;

@Repository
public class HrmsEmployeeDao {

	Logger logger = LoggerFactory.getLogger(HrmsEmployeeDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for employment list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmploymentList() {

		logger.info("Method : getEmploymentList starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getEmploymentList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getEmploymentList ends");

		return employmentList;
	}

	/**
	 * for department list
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepartmentList() {

		logger.info("Method : getDepartmentList starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getDepartmentList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDepartmentList ends");

		return employmentList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getBranchList() {
		logger.info("Method : getBranchList starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getBranchList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getBranchList ends");
		return employmentList;
	}

	/**
	 * for department list
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getGenderList() {

		logger.info("Method : getGenderList starts");

		List<DropDownModel> genderList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getGenderList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				genderList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getGenderList ends");

		return genderList;
	}

	/**
	 * for department list
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCountryList() {

		logger.info("Method : getCountryList starts");

		List<DropDownModel> countryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getCountryList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryList ends");

		return countryList;
	}

	/**
	 * for blood gruop list
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getBloodGroupList() {

		logger.info("Method : getBloodGroupList starts");

		List<DropDownModel> countryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getBloodGroupList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getBloodGroupList ends");

		return countryList;
	}

	/**
	 * for blood gruop list
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDocumentTypeList() {

		logger.info("Method : getDocumentTypeList starts");

		List<DropDownModel> documentTypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getDocumentTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				documentTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDocumentTypeList ends");

		return documentTypeList;
	}

	/**
	 * for department list
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getMaritalList() {

		logger.info("Method : getMaritalList starts");

		List<DropDownModel> maritalList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getMaritalList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				maritalList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getMaritalList ends");

		return maritalList;
	}

	/**
	 * for department list
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPayGradeList() {

		logger.info("Method : getPayGradeList starts");

		List<DropDownModel> payGaradeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getPayGradeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				payGaradeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPayGradeList ends");

		return payGaradeList;
	}

	/**
	 * 
	 * @return job title list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getJobTitleList() {

		logger.info("Method : getJobTitleList starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getJobTitleList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getJobTitleList ends");

		return employmentList;
	}

	/**
	 * 
	 * @return designation list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDesingnationList() {

		logger.info("Method : getDesingnationList starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getDesingnationList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDesingnationList ends");

		return employmentList;
	}

	/**
	 * 
	 * @return nationality list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getNationalityList() {

		logger.info("Method : getNationalityList starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getNationalityList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getNationalityList ends");

		return employmentList;
	}

	/**
	 * 
	 * @return nationality list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSupervisor() {

		logger.info("Method : getSupervisor starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getSupervisor").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getSupervisor ends");

		return employmentList;
	}

	/**
	 * 
	 * @return getSupervisorByDept list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSupervisorByDept(String id) {

		logger.info("Method : getSupervisorByDept starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();
		String value = "SET @P_deptId='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getJobTypeOnChange").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getSupervisorByDept ends");

		return employmentList;
	}

	/**
	 * for all employee details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>> getemployeeDetails(DataTableRequest request) {

		logger.info("Method in Dao: getemployeeDetails starts");

		List<HrmsEmployeeModel> employeList = new ArrayList<HrmsEmployeeModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "viewemployeeList").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[6] != null) {
						date = DateFormatter.returnStringDateYear(m[6]);
					}
					HrmsEmployeeModel employe = new HrmsEmployeeModel(m[0], m[1], m[2], m[3], null, null, null, m[4],
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, m[5],
							m[5], null, null, null, null, null, date, m[7], m[8], null, null, null, null, null, null,
							m[9], null, null, null, null, null, null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
							null, null);
					employeList.add(employe);

				}

				if (x.get(0).length > 10) {
					BigInteger t = (BigInteger) x.get(0)[10];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsEmployeeModel>> resp = new JsonResponse<List<HrmsEmployeeModel>>();
		resp.setBody(employeList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getemployeeDetails ends");

		return response;
	}

	/**
	 * for add new employee
	 */
	public ResponseEntity<JsonResponse<Object>> addemployee(HrmsEmployeeModel employee) {

		logger.info("Method in Dao: addemployee starts"); 
		List<HrmsEmployeeModel> employeList = new ArrayList<HrmsEmployeeModel>();
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (employee.getEmployeeFname() == null || employee.getEmployeeFname() == "") {
			resp.setMessage("Employee  First Name required");
			validity = false;
		} else if (employee.getEmployeeFname() == null || employee.getEmployeeFname() == "") {
			resp.setMessage("Employee Last Name required");
			validity = false;
		} else if (employee.getEmployeeDepartment() == null || employee.getEmployeeDepartment() == "") {
			resp.setMessage("Employee Department required");
			validity = false;
		} else if (employee.getEmployeeEmployment() == null || employee.getEmployeeEmployment() == "") {
			resp.setMessage("Employee Employment required");
			validity = false;
		} else if (employee.getEmployeeJobTitle() == null || employee.getEmployeeJobTitle() == "") {
			resp.setMessage("Employee Job title required");
			validity = false;
		} else if (employee.getEmployeeMobilePhoneNo() == null || employee.getEmployeeMobilePhoneNo() == "") {
			resp.setMessage("Employee Mobile No required");
			validity = false;
		}
		for (HrmsEmployeeDocumentsModel doc : employee.getDocumentList()) {
			if (doc.getDocumentType() == null || doc.getDocumentType() == "") {
				resp.setMessage("Document Type required");
				validity = false;
			}
			if (doc.getFileName() == null || doc.getFileName() == "") {
				resp.setMessage("Image Required required");
				validity = false;
			}

		}

		for (HrmsEmployeeSalaryStructureModel sal : employee.getSalaryStructureList()) {
			if (sal.getAnnualCtc() == null) {
				resp.setMessage("Annual CTC required");
				validity = false;
			}

		}

		validity = true;
		if (validity) {
			try {

				String values = "";
				try {
					values = GenerateEmployeeParameter.getAddEmploymentParam(employee); 
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (employee.getEmployeeNo() == "" || employee.getEmployeeNo() == null) {

					@SuppressWarnings("unchecked")
					List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
							.setParameter("actionType", "addemployee").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						HrmsEmployeeModel employe = new HrmsEmployeeModel(m[0], m[1], null, null, null, null, null,
								null, null, null, m[2], null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, m[3], m[3], null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null);
						employeList.add(employe);

					}

				} else {

					em.createNamedStoredProcedureQuery("Employee").setParameter("actionType", "modifyemployee")
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

		resp.setBody(employeList);
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: addemployee ends");

		return response;
	}

	/*
	 * for edit employee
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<HrmsEmployeeModel>> getemployeeById(String id) {

		logger.info("Method in Dao: getemployeeById ends");

		List<HrmsEmployeeModel> pemployee = new ArrayList<HrmsEmployeeModel>();
		List<HrmsEmployeeSalaryStructureModel> salaryStructureList = new ArrayList<HrmsEmployeeSalaryStructureModel>();
		List<HrmsEmployeeDocumentsModel> documentList = new ArrayList<HrmsEmployeeDocumentsModel>();
		List<HrmsEmployeeGroupInsuranceModel> groupInsList = new ArrayList<HrmsEmployeeGroupInsuranceModel>();

		try {

			String value = "SET @P_empId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "viewEditemployee").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object dob = null;
				Object joinDate = null;
				Object cnfrmDate = null;
				Object termDate = null;
				Object healthinsStartDate = null;
				Object healthinsEndDate = null;

				Object groupinsStartDate = null;
				Object groupinsEndDate = null;
				Object fatherDob = null;
				Object motherDob = null;

				if (m[5] != null) {
					dob = DateFormatter.returnStringDate(m[5]);
				}
				if (m[27] != null) {
					joinDate = DateFormatter.returnStringDate(m[27]);
				}
				if (m[28] != null) {
					cnfrmDate = DateFormatter.returnStringDate(m[28]);
				}
				if (m[29] != null && m[29] != "") {
					termDate = DateFormatter.returnStringDate(m[29]);
				}
				if (m[56] != null) {
					groupinsStartDate = DateFormatter.returnStringDate(m[56]);
				}
				if (m[57] != null) {
					groupinsEndDate = DateFormatter.returnStringDate(m[57]);
				}

				if (m[59] != null) {
					healthinsStartDate = DateFormatter.returnStringDate(m[59]);
				}
				if (m[60] != null) {
					healthinsEndDate = DateFormatter.returnStringDate(m[60]);
				}
				if (m[76] != null) {
					fatherDob = DateFormatter.returnStringDate(m[76]);
				}
				if (m[79] != null) {
					motherDob = DateFormatter.returnStringDate(m[79]);
				}
				HrmsEmployeeModel employee = new HrmsEmployeeModel(m[0], m[1], m[2], m[3], m[4], dob, m[6], m[7], m[8],
						m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21], m[22],
						m[23], m[24], m[25], m[26], joinDate, cnfrmDate, termDate, m[30], m[31], m[32], m[33], m[34],
						m[35], m[36], m[37], m[38], m[39], m[40], m[41], m[42], m[43], m[44], m[45], m[46], m[47],
						m[48], m[49], m[50], m[51], m[52], m[53], m[54], m[55], groupinsStartDate, groupinsEndDate,
						m[58], healthinsStartDate, healthinsEndDate, m[61], m[62], m[63], m[64], m[65], m[66], m[67],
						m[68], m[69], m[70], m[71], m[72], m[73], m[74], m[75], fatherDob, m[77], m[78], motherDob,
						m[80], m[81], m[82], m[83], m[84]);

				// for get salary component details for edit
				try {

					List<Object[]> salaryList = em.createNamedStoredProcedureQuery("Employee")
							.setParameter("actionType", "getSalaryDtlsEdit").setParameter("actionValue", value)
							.getResultList();

					for (Object[] m2 : salaryList) {
						HrmsEmployeeSalaryStructureModel salaryStructure = new HrmsEmployeeSalaryStructureModel(m2[0],
								m2[1], m2[2], m2[3].toString(), m2[4], m2[5], m2[6], m2[7]);
						salaryStructureList.add(salaryStructure);
					}
				} catch (Exception e) {
					logger.error(e.getMessage());
					e.printStackTrace();
				}
				// for get document list for edit
				try {
					List<Object[]> x3 = em.createNamedStoredProcedureQuery("Employee")
							.setParameter("actionType", "getDocumentsForEdit").setParameter("actionValue", value)
							.getResultList();

					for (Object[] m3 : x3) {
						HrmsEmployeeDocumentsModel document = new HrmsEmployeeDocumentsModel(m3[0], m3[1], m3[2],
								m3[3]);
						documentList.add(document);
					}
				} catch (Exception e) {
					logger.error(e.getMessage());
				}

				// for get group ins list for edit
				try {

					List<Object[]> x4 = em.createNamedStoredProcedureQuery("Employee")
							.setParameter("actionType", "getGroupInsForEdit").setParameter("actionValue", value)
							.getResultList();

					for (Object[] m4 : x4) {
						Object dobs = null;
						if (m4[5] != null) {
							dobs = DateFormatter.returnStringDate(m4[5]);
						}
						HrmsEmployeeGroupInsuranceModel groupIns = new HrmsEmployeeGroupInsuranceModel(m4[0], m4[1],
								m4[2], m4[3], m4[4], dobs);
						groupInsList.add(groupIns);
					}
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
				employee.setSalaryStructureList(salaryStructureList);
				employee.setDocumentList(documentList);
				employee.setGroupInsurance(groupInsList);
				pemployee.add(employee);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<HrmsEmployeeModel> resp = new JsonResponse<HrmsEmployeeModel>();
		resp.setBody(pemployee.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<HrmsEmployeeModel>> response = new ResponseEntity<JsonResponse<HrmsEmployeeModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getemployeeById ends");

		return response;
	}

	/*
	 * for delete employee
	 */
	public ResponseEntity<JsonResponse<Object>> deleteemployeeById(String id, String createdBy) {

		logger.info("Method in Dao: deleteemployeeById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @P_empId='" + id + "',@P_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("Employee").setParameter("actionType", "deleteemployee")
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

		logger.info("Method in Dao: deleteemployeeById ends");

		return response;
	}

	/**
	 * DAO - Get Employee Details For View
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>> getEmployeeByIdForView(String id) {

		logger.info("Method in Dao: getEmployeeByIdForView ends");

		List<HrmsEmployeeModel> pemployee = new ArrayList<HrmsEmployeeModel>();

		try {

			String value = "SET @P_empId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "viewEditemployee").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object dob = null;
				Object joinDate = null;
				Object cnfrmDate = null;
				Object termDate = null;

				Object healthinsStartDate = null;
				Object healthinsEndDate = null;

				Object groupinsStartDate = null;
				Object groupinsEndDate = null;
				Object fatherDob = null;
				Object motherDob = null;

				if (m[5] != null) {
					dob = DateFormatter.returnStringDate(m[5]);
				}
				if (m[27] != null) {
					joinDate = DateFormatter.returnStringDate(m[27]);
				}
				if (m[28] != null) {
					cnfrmDate = DateFormatter.returnStringDate(m[28]);
				}
				if (m[29] != null) {
					termDate = DateFormatter.returnStringDate(m[29]);
				}
				if (m[56] != null) {
					groupinsStartDate = DateFormatter.returnStringDate(m[56]);
				}
				if (m[57] != null) {
					groupinsEndDate = DateFormatter.returnStringDate(m[57]);
				}

				if (m[59] != null) {
					healthinsStartDate = DateFormatter.returnStringDate(m[59]);
				}
				if (m[60] != null) {
					healthinsEndDate = DateFormatter.returnStringDate(m[60]);
				}
				if (m[76] != null) {
					fatherDob = DateFormatter.returnStringDate(m[76]);
				}
				if (m[79] != null) {
					motherDob = DateFormatter.returnStringDate(m[79]);
				}
				HrmsEmployeeModel employee = new HrmsEmployeeModel(m[0], m[1], m[2], m[3], m[4], dob, m[6], m[7], m[8],
						m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21], m[22],
						m[23], m[24], m[25], m[26], joinDate, cnfrmDate, termDate, m[30], m[31], m[32], m[33], m[34],
						m[35], m[36], m[37], m[38], m[39], m[40], m[41], m[42], m[43], m[44], m[45], m[46], m[47],
						m[48], m[49], m[50], m[51], m[52], m[53], m[54], m[55], groupinsStartDate, groupinsEndDate,
						m[58], healthinsStartDate, healthinsEndDate, m[61], m[62], m[63], m[64], m[65], m[66], m[67],
						m[68], m[69], m[70], m[71], m[72], m[73], m[74], m[75], fatherDob, m[77], m[78], motherDob,
						m[80], m[81], m[82], m[83], m[84]);

				pemployee.add(employee);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsEmployeeModel>> resp = new JsonResponse<List<HrmsEmployeeModel>>();
		resp.setBody(pemployee);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getEmployeeByIdForView ends"); 
		return response;
	}

	/**
	 * DAO - Get Employee Details For View
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>> getEmployeeByIdForModalView(String id) {

		logger.info("Method in Dao: getEmployeeByIdForModalView ends");

		List<HrmsEmployeeModel> pemployee = new ArrayList<HrmsEmployeeModel>();
		List<HrmsEmployeeSalaryStructureModel> salaryStructureList = new ArrayList<HrmsEmployeeSalaryStructureModel>();
		List<HrmsEmployeeDocumentsModel> documentList = new ArrayList<HrmsEmployeeDocumentsModel>();
		List<HrmsEmployeeGroupInsuranceModel> groupInsList = new ArrayList<HrmsEmployeeGroupInsuranceModel>();
		try {

			String value = "SET @P_empId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "viewModalEmployee").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object dob = null;
				Object joinDate = null;
				Object cnfrmDate = null;
				Object termDate = null;

				Object healthinsStartDate = null;
				Object healthinsEndDate = null;

				Object groupinsStartDate = null;
				Object groupinsEndDate = null;
				Object fatherDob = null;
				Object motherDob = null;

				if (m[5] != null) {
					dob = DateFormatter.returnStringDate(m[5]);
				}
				if (m[27] != null) {
					joinDate = DateFormatter.returnStringDate(m[27]);
				}
				if (m[28] != null) {
					cnfrmDate = DateFormatter.returnStringDate(m[28]);
				}
				if (m[29] != null) {
					termDate = DateFormatter.returnStringDate(m[29]);
				}
				if (m[56] != null) {
					groupinsStartDate = DateFormatter.returnStringDate(m[56]);
				}
				if (m[57] != null) {
					groupinsEndDate = DateFormatter.returnStringDate(m[57]);
				}

				if (m[59] != null) {
					healthinsStartDate = DateFormatter.returnStringDate(m[59]);
				}
				if (m[60] != null) {
					healthinsEndDate = DateFormatter.returnStringDate(m[60]);
				}
				if (m[76] != null) {
					fatherDob = DateFormatter.returnStringDate(m[76]);
				}
				if (m[79] != null) {
					motherDob = DateFormatter.returnStringDate(m[79]);
				}
				HrmsEmployeeModel employee = new HrmsEmployeeModel(m[0], m[1], m[2], m[3], m[4], dob, m[6], m[7], m[8],
						m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21], m[22],
						m[23], m[24], m[25], m[26], joinDate, cnfrmDate, termDate, m[30], m[31], m[32], m[33], m[34],
						m[35], m[36], m[37], m[38], m[39], m[40], m[41], m[42], m[43], m[44], m[45], m[46], m[47],
						m[48], m[49], m[50], m[51], m[52], m[53], m[54], m[55], groupinsStartDate, groupinsEndDate,
						m[58], healthinsStartDate, healthinsEndDate, m[61], m[62], m[63], m[64], m[65], m[66], m[67],
						m[68], m[69], m[70], m[71], m[72], m[73], m[74], m[75], fatherDob, m[77], m[78], motherDob,
						m[80], m[81], m[82], m[83], m[84]);
 
				// for get salary component details for edit
				try {

					List<Object[]> salaryList = em.createNamedStoredProcedureQuery("Employee")
							.setParameter("actionType", "getSalaryDtlsEdit").setParameter("actionValue", value)
							.getResultList();

					for (Object[] m2 : salaryList) {
						HrmsEmployeeSalaryStructureModel salaryStructure = new HrmsEmployeeSalaryStructureModel(m2[0],
								m2[1], m2[2], m2[3].toString(), m2[4], m2[5], m2[6], m2[7]);

						salaryStructureList.add(salaryStructure);
					}
				} catch (Exception e) {
					logger.error(e.getMessage());
					e.printStackTrace();
				}
				// for get document list for edit
				try {
					List<Object[]> x3 = em.createNamedStoredProcedureQuery("Employee")
							.setParameter("actionType", "getDocumentsForEdit").setParameter("actionValue", value)
							.getResultList();

					for (Object[] m3 : x3) {
						HrmsEmployeeDocumentsModel document = new HrmsEmployeeDocumentsModel(m3[0], m3[1], m3[2],
								m3[3]);
						documentList.add(document);
					}
				} catch (Exception e) {
					logger.error(e.getMessage());
				}

				// for get group ins list for edit
				try {

					List<Object[]> x4 = em.createNamedStoredProcedureQuery("Employee")
							.setParameter("actionType", "getGroupInsForEdit").setParameter("actionValue", value)
							.getResultList();

					for (Object[] m4 : x4) {
						Object dobs = null;
						if (m4[5] != null) {
							dobs = DateFormatter.returnStringDate(m4[5]);
						}
						HrmsEmployeeGroupInsuranceModel groupIns = new HrmsEmployeeGroupInsuranceModel(m4[0], m4[1],
								m4[2], m4[3], m4[4], dobs);
						groupInsList.add(groupIns);
					}
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
				
				employee.setSalaryStructureList(salaryStructureList);
				employee.setDocumentList(documentList);
				employee.setGroupInsurance(groupInsList);
				pemployee.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsEmployeeModel>> resp = new JsonResponse<List<HrmsEmployeeModel>>();
		resp.setBody(pemployee);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>>(
				resp, responseHeaders, HttpStatus.CREATED); 
		logger.info("Method in Dao: getEmployeeByIdForModalView ends");
		return response;
	}

	/*
	 * Drop down for job type list
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getJobTypeOnChange(String deptId) {

		logger.info("Method : getJobTypeOnChange starts");

		List<DropDownModel> UserRoleList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_deptId='" + deptId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getJobTypeOnChange").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				UserRoleList.add(dropDownModel);
			}

			resp.setBody(UserRoleList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getJobTypeOnChange ends");
		return response;
	}

	/*
	 * Drop down for state Change list
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateChange(String countryId) {

		logger.info("Method : getStateChange starts");

		List<DropDownModel> UserRoleList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_countryId='" + countryId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getStateChange").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				UserRoleList.add(dropDownModel);
			}

			resp.setBody(UserRoleList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getStateChange ends");
		return response;
	}

	/*
	 * Drop down for Dist Change list
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDistChange(String countryId) {

		logger.info("Method : getDistChange starts");

		List<DropDownModel> UserRoleList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_stateId='" + countryId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getDistChange").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				UserRoleList.add(dropDownModel);
			}

			resp.setBody(UserRoleList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getDistChange ends");
		return response;
	}

	/**
	 * DAO - Change The Status Of Employee
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> changeStatusById(String id, Boolean status, String createdBy) {
		logger.info("Method in Dao: changeStatusById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_empId='" + id + "',@p_status=" + status + ",@P_createdBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("Employee").setParameter("actionType", "changeStatus")
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

		logger.info("Method in Dao: changeStatusById ends");

		return response;
	}

	/**
	 * 
	 * @return state list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStateforEdit(String id) {

		logger.info("Method : getStateforEdit starts");

		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_countryId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getStateChange").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getStateforEdit ends");

		return stateList;
	}
	
	
	/**
	 * 
	 * @return state list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDistforEdit(String id) {

		logger.info("Method : getDistforEdit starts");

		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_stateId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getDistChange").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDistforEdit ends");

		return stateList;
	}
	

	/*
	 * First Stage Approval
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEmployeeSalaryStructureModel>>> getEmployeeSalaryDetails(String id) {

		logger.info("Method : getEmployeeSalaryDetails starts");

		List<HrmsEmployeeSalaryStructureModel> salaryDetails = new ArrayList<HrmsEmployeeSalaryStructureModel>();
		JsonResponse<List<HrmsEmployeeSalaryStructureModel>> resp = new JsonResponse<List<HrmsEmployeeSalaryStructureModel>>();

		try {

			String value = "SET @P_empId='" + id + "' ;";

			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getSalaryDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object efDate = null;
				if (m[2] != null) {
					efDate = DateFormatter.returnStringDate(m[8]);
				}

				HrmsEmployeeSalaryStructureModel hrmsEmployeeSalaryStructureModel = new HrmsEmployeeSalaryStructureModel(
						m[0], m[1], m[2], m[3].toString(), m[4], m[5], m[6], m[7], efDate, m[9], m[10], m[11], m[12],
						m[13], m[14]);

				salaryDetails.add(hrmsEmployeeSalaryStructureModel);

			}
			resp.setBody(salaryDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<HrmsEmployeeSalaryStructureModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEmployeeSalaryStructureModel>>>(
				resp, responseHeaders, HttpStatus.CREATED); 
		logger.info("Method : getEmployeeSalaryDetails ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> changePassword(String id, String password) {
		logger.info("Method : changePassword starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = "SET @p_user='" + id + "', @p_pass='" + password + "';";

			em.createNamedStoredProcedureQuery("Employee").setParameter("actionType", "changePassword")
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
		logger.info("Method : changePassword ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addTerminationDateDao(String id, String date) {
		logger.info("Method : addTerminationDateDao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = "SET @p_user='" + id + "', @p_date='" + DateFormatter.getStringDate(date) + "';";
			em.createNamedStoredProcedureQuery("Employee").setParameter("actionType", "addTerminationDate")
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
		logger.info("Method : addTerminationDateDao ends");
		return response;
	}

	/*
	 * for getIncomeTaxList
	 */
	@SuppressWarnings("unchecked")
	public List<RestIncomeTaxModel> getIncomeTaxList() {

		logger.info("Method : getIncomeTaxList starts");

		List<RestIncomeTaxModel> incomeTaxList = new ArrayList<RestIncomeTaxModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getIncomeTaxList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				RestIncomeTaxModel incomeTaxModel = new RestIncomeTaxModel(m[0], m[1], m[2], m[3], m[4]);
				incomeTaxList.add(incomeTaxModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getIncomeTaxList ends");

		return incomeTaxList;
	}

	/**
	 * DAO Function to Add Professional Tax details
	 */
	public ResponseEntity<JsonResponse<Object>> updateSalaryComponents(
			List<HrmsEmployeeSalaryStructureModel> salaryDetails) {
		logger.info("Method : updateSalaryComponents starts");
		@SuppressWarnings("unused")
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = GenerateEmployeeParameter.updateSalaryComponent(salaryDetails);

			em.createNamedStoredProcedureQuery("Employee").setParameter("actionType", "updateSalComp")
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : updateSalaryComponents ends");
		return response;
	}
}
