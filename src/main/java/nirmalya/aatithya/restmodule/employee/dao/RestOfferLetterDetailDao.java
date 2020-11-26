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

import nirmalya.aatithya.restmodule.common.utils.GenerateOfferLetterDetailsParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.EmployeeOfferLetterSalaryDetailsModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeSalaryStructureModel;
import nirmalya.aatithya.restmodule.employee.model.RestOfferLetterDetailModel; 

@Repository
public class RestOfferLetterDetailDao {
	Logger logger = LoggerFactory.getLogger(RestOfferLetterDetailDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * DAO Function to view Nationality in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getNationality() {
		logger.info("Method : getNationality starts");
		List<DropDownModel> nationalityList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("offerLetterRoutines")
					.setParameter("actionType", "getNationality").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				nationalityList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getNationality ends");
		return nationalityList;
	}

	/*
	 * DAO Function to view Pay Grade in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPayGradeList() {
		logger.info("Method : getPayGradeList starts");
		List<DropDownModel> payGradeList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("offerLetterRoutines")
					.setParameter("actionType", "getPayGrade").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				payGradeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getPayGradeList ends");
		return payGradeList;
	}

	/*
	 * DAO Function to view Gender List in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmployeeGenderList() {
		logger.info("Method : getEmployeeGenderList starts");
		List<DropDownModel> genderList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("offerLetterRoutines")
					.setParameter("actionType", "getGenderList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				genderList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getEmployeeGenderList ends");

		return genderList;
	}

	/*
	 * DAO Function to view Gender List in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmployeeMaritalList() {
		logger.info("Method : getEmployeeMaritalList starts");
		List<DropDownModel> maritalList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("offerLetterRoutines")
					.setParameter("actionType", "getMaritalList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				maritalList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getEmployeeMaritalList ends");

		return maritalList;
	}

	/*
	 * DAO Function to view Job Title List in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getJobTitle() {
		logger.info("Method : getJobTitle starts");
		List<DropDownModel> jobTitleList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("offerLetterRoutines")
					.setParameter("actionType", "jobTitleList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				jobTitleList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getJobTitle ends");
		return jobTitleList;
	}

	/*
	 * DAO Function to view Country List in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCountryList() {
		logger.info("Method : getCountryList starts");
		List<DropDownModel> countryList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("offerLetterRoutines")
					.setParameter("actionType", "countryList").setParameter("actionValue", "").getResultList();

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
	 * DAO Function to view particular State name in dropDown
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateList(String id) {

		logger.info("Method : getStateList starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_tCountry='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("offerLetterRoutines")
					.setParameter("actionType", "getStateList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getStateList ends");
		return response;
	}

	/**
	 * DAO Function to view particular District name in dropDown
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDistrictList(String id) {

		logger.info("Method : getDistrictList starts");
		List<DropDownModel> distList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_tState='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("offerLetterRoutines")
					.setParameter("actionType", "getDistList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				distList.add(dropDownModel);
			}

			resp.setBody(distList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getDistrictList ends");
		return response;
	}

	/**
	 * DAO Function to get Task Type in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestOfferLetterDetailModel>>> getSalaryComponentAjax(String id) {
		logger.info("Method : getSalaryComponentAjax starts");
		List<RestOfferLetterDetailModel> salaryComponent = new ArrayList<RestOfferLetterDetailModel>();
		JsonResponse<List<RestOfferLetterDetailModel>> resp = new JsonResponse<List<RestOfferLetterDetailModel>>();

		String value = "SET @p_tPayGrade='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("offerLetterRoutines")
					.setParameter("actionType", "salaryComponent").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				RestOfferLetterDetailModel dropDownModel = new RestOfferLetterDetailModel(null, null, null, null, null,
						null, null, null, null, null, null, m[0], null, null, null, null, null, null, null, null, m[1],
						null, m[2], m[3], null, null, m[4], null, null, null);
				salaryComponent.add(dropDownModel);
			}

			resp.setBody(salaryComponent);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestOfferLetterDetailModel>>> response = new ResponseEntity<JsonResponse<List<RestOfferLetterDetailModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSalaryComponentAjax ends");
		System.out.println(response);
		return response;
	}

	/**
	 * DAO Function to Add KRAMeasure details
	 */
	public ResponseEntity<JsonResponse<Object>> addOfferLetterDetailsPost(
			List<RestOfferLetterDetailModel> offerLetterDtls) {
		logger.info("Method : addOfferLetterDetailsPost starts");

		@SuppressWarnings("unused")
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (RestOfferLetterDetailModel l : offerLetterDtls) {
			if (l.gettEmpFName() == null || l.gettEmpFName() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter First Name");
				break;

			} /*
				 * else if (l.gettEmpMName() == null || l.gettEmpMName() == "") { validation =
				 * false; resp.setCode("Field Validation Error");
				 * resp.setMessage("Please Enter Middle Name"); break;
				 * 
				 * }
				 */ else if (l.gettEmpLName() == null || l.gettEmpLName() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Last Name");
				break;
			} else if (l.gettEmpDOB() == null || l.gettEmpDOB() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter DOB");
				break;
			} else if (l.gettNationality() == null || l.gettNationality() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Nationality");
				break;
			} else if (l.gettMobileNo() == null || l.gettMobileNo() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Mobile. No.");

			} else if (l.gettEmpGender() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Gender");
				break;
			} else if (l.gettEmpMarritalStatus() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Marital Status");
				break;
			} else if (l.gettJobTitle() == null || l.gettJobTitle() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Job Title");
				break;
			} else if (l.gettPayGrade() == null || l.gettPayGrade() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select  PayGrade");
				break;
			} else if (l.gettCountry() == null || l.gettCountry() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select  Country");
				break;
			} else if (l.gettState() == null || l.gettState() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select State");
				break;
			} else if (l.gettDistrict() == null || l.gettDistrict() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select District");
				break;
			} else if (l.gettPinCode() == null || l.gettPinCode() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Pin Code");
				break;
			} else if (l.gettAddress() == null || l.gettAddress() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Address");
				break;
			} else if (l.gettEmailId() == null || l.gettEmailId() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Email");
				break;
			} else if (l.gettEmpDOJ() == null || l.gettEmpDOJ() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter DOJ");
				break;
			} else if (l.gettAnnualCTC() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Annual CTC");
				break;

			}

		}

		if (validation) {

			try {
				String value = GenerateOfferLetterDetailsParameter.addLetterDetailParam(offerLetterDtls);

				if (offerLetterDtls.get(0).gettOfferLetterId() != null
						&& offerLetterDtls.get(0).gettOfferLetterId() != "") {

					em.createNamedStoredProcedureQuery("offerLetterRoutines")
							.setParameter("actionType", "modifyLetterDtls").setParameter("actionValue", value)
							.execute();
				} else {

					em.createNamedStoredProcedureQuery("offerLetterRoutines")
							.setParameter("actionType", "addLetterDtls").setParameter("actionValue", value).execute();
				}
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
		logger.info("Method : addOfferLetterDetailsPost ends");
		return response;
	}

	/*
	 * for all Offer Letter Details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestOfferLetterDetailModel>>> viewOfferLetterDetails(
			DataTableRequest request) {

		logger.info("Method in Dao: viewOfferLetterDetails starts");

		List<RestOfferLetterDetailModel> offerLetterDtlsList = new ArrayList<RestOfferLetterDetailModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("offerLetterRoutines")
					.setParameter("actionType", "viewLetterDetails").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					RestOfferLetterDetailModel offerLetterDtls = new RestOfferLetterDetailModel(m[0], m[1], null, null,
							null, null, m[2], null, m[3], null, m[4], m[5], null, null, null, null, null, null, null,
							null, null, null, null, null, null, null, null, null, null, null);
					offerLetterDtlsList.add(offerLetterDtls);

				}

				if (x.get(0).length > 6) {
					BigInteger t = (BigInteger) x.get(0)[6];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestOfferLetterDetailModel>> resp = new JsonResponse<List<RestOfferLetterDetailModel>>();
		resp.setBody(offerLetterDtlsList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestOfferLetterDetailModel>>> response = new ResponseEntity<JsonResponse<List<RestOfferLetterDetailModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: viewOfferLetterDetails ends");

		return response;
	}

	/*
	 * 
	 * Dao function for edit Grade Salary Master details
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestOfferLetterDetailModel> editOfferLetterDtls(String id, String grade) {
		logger.info("Method : editGradeSalaryMaster starts");

		List<RestOfferLetterDetailModel> offerLetterDtlsList = new ArrayList<RestOfferLetterDetailModel>();

		String value = "SET @P_letterId='" + id + "',@p_grade='" + grade + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("offerLetterRoutines")
					.setParameter("actionType", "editLetterDtls").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object dob = null;
				Object joinDate = null;
				if (m[4] != null) {
					dob = DateFormatter.returnStringDate(m[4]);
				}
				if (m[18] != null) {
					joinDate = DateFormatter.returnStringDate(m[18]);
				}
				RestOfferLetterDetailModel dropDownModel = new RestOfferLetterDetailModel(m[0], m[1], m[2], m[3], dob,
						m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], joinDate,
						m[19], m[20], m[21], m[22], m[23], m[24], null, null, null, null, null);

				offerLetterDtlsList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editGradeSalaryMaster ends");

		return offerLetterDtlsList;
	}

	/**
	 * DAO Function to get Task Type in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDistListForEdit(String tState) {
		logger.info("Method : getDistListForEdit starts");
		List<DropDownModel> getDistList = new ArrayList<DropDownModel>();
		String value = "SET @p_tState='" + tState + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("offerLetterRoutines")
					.setParameter("actionType", "getDistList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getDistList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDistListForEdit ends");

		return getDistList;

	}

	/**
	 * DAO Function to get Task Type in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStateListForEdit(String tCountry) {
		logger.info("Method : getStateListForEdit starts");
		List<DropDownModel> getStateList = new ArrayList<DropDownModel>();
		String value = "SET @p_tCountry='" + tCountry + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("offerLetterRoutines")
					.setParameter("actionType", "getStateList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getStateList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getStateListForEdit ends");

		return getStateList;

	}

	/*
	 * offer letter details modal view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestOfferLetterDetailModel>>> offerLetterDetailsModal(String id) {

		logger.info("Method : offerLetterDetailsModal starts");

		List<RestOfferLetterDetailModel> form = new ArrayList<RestOfferLetterDetailModel>();
		JsonResponse<List<RestOfferLetterDetailModel>> resp = new JsonResponse<List<RestOfferLetterDetailModel>>();
		try {

			String value = "SET @P_letterId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("offerLetterRoutines")
					.setParameter("actionType", "letterDetailsModel").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object dob = null;
				Object joinDate = null;
				if (m[2] != null) {
					dob = DateFormatter.returnStringDate(m[2]);
				}
				if (m[7] != null) {
					joinDate = DateFormatter.returnStringDate(m[7]);
				}
				RestOfferLetterDetailModel offerLetterDtls = new RestOfferLetterDetailModel(m[0], m[1], null, null, dob,
						null, m[3], null, null, null, m[4], m[5], null, null, null, null, null, m[6], joinDate, m[8],
						null, m[9], m[10], m[11], m[12], null, null, null, null, null);

				form.add(offerLetterDtls);
			}
			resp.setBody(form);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestOfferLetterDetailModel>>> response = new ResponseEntity<JsonResponse<List<RestOfferLetterDetailModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : offerLetterDetailsModal ends");

		return response;
	}

	/*
	 * for delete particular offer letter details
	 */
	public ResponseEntity<JsonResponse<Object>> deleteLetterDetailsById(String id, String createdBy) {

		logger.info("Method in Dao: deleteLetterDetailsById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @P_letterId='" + id + "',@P_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("offerLetterRoutines").setParameter("actionType", "deleteDetails")
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

		logger.info("Method in Dao: deleteLetterDetailsById ends");

		return response;
	}

	/*
	 * for Offer Letter Details PDF
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestOfferLetterDetailModel>>> viewOfferLetterDetailsPDF(String id) {

		logger.info("Method : viewOfferLetterDetailsPDF starts");

		List<RestOfferLetterDetailModel> form = new ArrayList<RestOfferLetterDetailModel>();
		JsonResponse<List<RestOfferLetterDetailModel>> resp = new JsonResponse<List<RestOfferLetterDetailModel>>();

		try {

			String value = "SET @P_letterId ='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("offerLetterRoutines")
					.setParameter("actionType", "letterDetailsModel").setParameter("actionValue", value)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object dob = null;
					Object joinDate = null;
					if (m[2] != null) {
						dob = DateFormatter.returnStringDate(m[2]);
					}
					if (m[7] != null) {
						joinDate = DateFormatter.returnStringDate(m[7]);
					}
					RestOfferLetterDetailModel properties = new RestOfferLetterDetailModel(m[0], m[1], null, null, dob,
							null, m[3], null, null, null, m[4], m[5], null, null, null, null, null, m[6], joinDate,
							m[8], null, m[9], m[10], m[11], m[12], null, null, null, null, null);

					form.add(properties);

				}
			}

			resp.setBody(form);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestOfferLetterDetailModel>>> response = new ResponseEntity<JsonResponse<List<RestOfferLetterDetailModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : viewOfferLetterDetailsPDF ends");
		return response;
	}

	/*
	 * Add Employee Deatils to employee tbl
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<EmployeeOfferLetterSalaryDetailsModel>>> getEmployeeDetails(String id) {

		logger.info("Method : getEmployeeDetails starts");

		List<EmployeeOfferLetterSalaryDetailsModel> employeeComponentDetails = new ArrayList<EmployeeOfferLetterSalaryDetailsModel>();
		JsonResponse<List<EmployeeOfferLetterSalaryDetailsModel>> resp = new JsonResponse<List<EmployeeOfferLetterSalaryDetailsModel>>();

		try {

			String value = "SET @P_letterId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("offerLetterRoutines")
					.setParameter("actionType", "getEmployeeDetails").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object dob = null;

				if (m[9] != null) {
					dob = DateFormatter.returnStringDate(m[9]);
				}
				Object doj = null;

				if (m[20] != null) {
					doj = DateFormatter.returnStringDate(m[20]);
				}
				EmployeeOfferLetterSalaryDetailsModel EmployeeOfferLetterSalaryDetailsModel = new EmployeeOfferLetterSalaryDetailsModel(
						null, m[0], m[1], null, m[2], null, null, null, null, null, null, null, null, null, null, null,
						m[3], m[4], m[5], m[6], m[7], m[8], dob, m[10], m[11], m[12], null, null, null, null, null,
						null, null, m[13], null, m[14], null, m[15], m[16], m[17], null, m[18], null, null, m[19], doj,
						null, null, null, null, null, null, null, null, null);

				employeeComponentDetails.add(EmployeeOfferLetterSalaryDetailsModel);

			}
			resp.setBody(employeeComponentDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<EmployeeOfferLetterSalaryDetailsModel>>> response = new ResponseEntity<JsonResponse<List<EmployeeOfferLetterSalaryDetailsModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getEmployeeDetails ends");

		return response;
	}

	/**
	 * DAO Function to view particular Designation in dropDown
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDesignationList(String id) {

		logger.info("Method : getDesignationList starts");
		List<DropDownModel> designList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_deptId='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("offerLetterRoutines")
					.setParameter("actionType", "getDesignationList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				designList.add(dropDownModel);
			}

			resp.setBody(designList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getDesignationList ends");
		return response;
	}

	/*
	 * for First Stage Approval - Submit
	 */
	@SuppressWarnings("unused")
	public ResponseEntity<JsonResponse<Object>> employeeDetailsFormSubmit(
			List<EmployeeOfferLetterSalaryDetailsModel> employeeComponentDetails) {
		logger.info("Method : employeeDetailsFormSubmit starts");

		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validation) {

			try {

				String value = GenerateOfferLetterDetailsParameter.addEmployeeDetailsParam(employeeComponentDetails);

				em.createNamedStoredProcedureQuery("offerLetterRoutines")
						.setParameter("actionType", "employeeDetailsAdd").setParameter("actionValue", value).execute();

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
		logger.info("Method : employeeDetailsFormSubmit ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestOfferLetterDetailModel>>> viewOfferLetter() {

		logger.info("Method : viewOfferLetter starts");

		List<RestOfferLetterDetailModel> resource = new ArrayList<RestOfferLetterDetailModel>();
		Integer total = 0;
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("offerLetterRoutines")
					.setParameter("actionType", "viewOfferLetter").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				Object sDate = null;
				if (m[3] != null) {
					sDate = DateFormatter.returnStringDate(m[3]);
				}

				RestOfferLetterDetailModel RestOfferLetterDetailModel = new RestOfferLetterDetailModel(m[0], m[1], m[2],
						null, sDate, null, m[4], null, null, null, m[5], m[6], null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null);
				resource.add(RestOfferLetterDetailModel);

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

		JsonResponse<List<RestOfferLetterDetailModel>> resp = new JsonResponse<List<RestOfferLetterDetailModel>>();
		resp.setBody(resource);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestOfferLetterDetailModel>>> response = new ResponseEntity<JsonResponse<List<RestOfferLetterDetailModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : viewOfferLetter ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestOfferLetterDetailModel>> generateAppointmentLetter(String id) {

		logger.info("Method : generateAppointmentLetter starts");

		List<RestOfferLetterDetailModel> resource = new ArrayList<RestOfferLetterDetailModel>();
		List<HrmsEmployeeSalaryStructureModel> salary = new ArrayList<HrmsEmployeeSalaryStructureModel>();

		String value = "SET @p_id='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("offerLetterRoutines")
					.setParameter("actionType", "generateAppointment").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				Object sDate = null;
				if (m[4] != null) {
					sDate = DateFormatter.returnStringDate(m[4]);
				}
				Object jDate = null;
				if (m[12] != null) {
					jDate = DateFormatter.returnStringDate(m[12]);
				}

				RestOfferLetterDetailModel RestOfferLetterDetailModel = new RestOfferLetterDetailModel(m[0], m[1], m[2],
						m[3], sDate, m[5], m[6], null, m[7], m[8], m[9], m[10], null, null, null, null, null, m[11],
						jDate, m[13], null, null, null, null, null, null, null, m[14], m[15], null);
				resource.add(RestOfferLetterDetailModel);
				try {
					List<Object[]> x1 = em.createNamedStoredProcedureQuery("offerLetterRoutines")
							.setParameter("actionType", "getSalary").setParameter("actionValue", value).getResultList();

					for (Object[] m1 : x1) {

						HrmsEmployeeSalaryStructureModel salaryDetails = new HrmsEmployeeSalaryStructureModel(null,
								null, m1[0], m1[1].toString(), m1[2], m1[3], null, m1[4]);
						salary.add(salaryDetails);

					}
					resource.get(0).setSalaryComponentList(salary);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			System.out.println(salary);

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<RestOfferLetterDetailModel> resp = new JsonResponse<RestOfferLetterDetailModel>();
		resp.setBody(resource.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestOfferLetterDetailModel>> response = new ResponseEntity<JsonResponse<RestOfferLetterDetailModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : generateAppointmentLetter ends");
		System.out.println(response);
		return response;
	}

}
