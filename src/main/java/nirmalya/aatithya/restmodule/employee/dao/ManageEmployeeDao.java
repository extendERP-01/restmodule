package nirmalya.aatithya.restmodule.employee.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateemployeemasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeAddressRestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeRestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeWorkdetailsRestModel;


/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class ManageEmployeeDao {
	
	
	Logger logger = LoggerFactory.getLogger(ManageEmployeeDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCountryList() {
		logger.info("Method : getCountryListemployee starts");

		List<DropDownModel> CountryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getCountryList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				CountryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryListForemployee ends");
		return CountryList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getstateList1() {
		logger.info("Method : getstateListemployee starts");

		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getstateList1").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getstateListForemployee ends");
		return stateList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getcityList1() {
		logger.info("Method : getcityListemployee starts");

		List<DropDownModel> cityList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getcityList1").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				cityList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryListForemployee ends");
		return cityList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getgenderList1() {
		logger.info("Method : genderTypeList starts");

		List<DropDownModel> genderTypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getgenderList1").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				genderTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryListForemployee ends");
		return genderTypeList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getnationalityList1() {
		logger.info("Method : getnationalityList1 starts");

		List<DropDownModel> nationalityList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "nationalityList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				nationalityList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryListForemployee ends");
		return nationalityList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getbloodgroupList1() {
		logger.info("Method : getnationalityList1 starts");

		List<DropDownModel> bloodgroupList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getbloodgroupList1").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				bloodgroupList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryListForemployee ends");
		return bloodgroupList;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getmaritalstatusList1() {
		logger.info("Method : getmaritalstatusList1 starts");

		List<DropDownModel> maritalstatusList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "maritalstatusList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				maritalstatusList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryListForemployee ends");
		return maritalstatusList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getdocumenttypeList1() {
		logger.info("Method : documenttypeList starts");

		List<DropDownModel> documenttypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "documenttypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				documenttypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : documenttypeList ends");
		return documenttypeList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getJobType1() {
		logger.info("Method : getJobType1 starts");

		List<DropDownModel> jobtypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "jobtypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				jobtypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getJobType1 ends");
		return jobtypeList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepartmentList1() {
		logger.info("Method : getDepartmentList1 starts");

		List<DropDownModel> DepartmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "DepartmentList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				DepartmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDepartmentList1 ends");
		return DepartmentList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getemploymentstatusList1() {
		logger.info("Method : getemploymentstatusList1 starts");

		List<DropDownModel> employmentstatusList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getemploymentstatusList1").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentstatusList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getemploymentstatusList1 ends");
		return employmentstatusList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getJobType2() {
		logger.info("Method : getJobType2 starts");

		List<DropDownModel> jobtypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "jobtypeList2").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				jobtypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : jobtypeList2 ends");
		return jobtypeList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getBenefits() {
		logger.info("Method : getBenefits starts");

		List<DropDownModel> benefitsList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "benefitsList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				benefitsList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : benefitsList ends");
		return benefitsList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getBankNameList() {
		logger.info("Method : getBankNameList starts");

		List<DropDownModel> getBankNameList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getBankNameList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getBankNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : benefitsList ends");
		return getBankNameList;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ManageEmployeeRestModel>> saveemployeeMaster(ManageEmployeeRestModel employee) {
		logger.info("Method : saveemployeeMaster starts");

		Boolean validity = true;
		JsonResponse<ManageEmployeeRestModel> resp = new JsonResponse<ManageEmployeeRestModel>();
		resp.setMessage("");
		resp.setCode("");
		List<ManageEmployeeRestModel> newemp = new ArrayList<ManageEmployeeRestModel>();

		if (employee.getFirstName() == null || employee.getFirstName() == "") {
			resp.setMessage("First Name Required");
			validity = false;
		} else if (employee.getLastName() == null || employee.getLastName() == "") {
			resp.setMessage("LastName Required");
			validity = false;
		} else if (employee.getGender() == null || employee.getGender() == "") {
			resp.setMessage("Gender Required");
			validity = false;
		} else if (employee.getDob() == null || employee.getDob() == "") {
			resp.setMessage("Dob Required");
			validity = false;
		} else if (employee.getBloodGroup() == null || employee.getBloodGroup() == "") {
			resp.setMessage("BloodGroup Required");
			validity = false;
		} else if (employee.getMaritalStatus() == null || employee.getMaritalStatus() == "") {
			resp.setMessage("maritalStatus Required");
			validity = false;
		} else if (employee.getNationality() == null || employee.getNationality() == "") {
			resp.setMessage("nationality Required");
			validity = false;
		
	} else if (employee.getFatherName() == null || employee.getFatherName() == "") {
		resp.setMessage("fatherName Required");
		validity = false;
	}else if (employee.getMotherName() == null || employee.getMotherName() == "") {
		resp.setMessage("motherName Required");
		validity = false;
	}else if (employee.getMobileNo() == null || employee.getMobileNo() == "") {
		resp.setMessage("mobileNo Required");
		validity = false;
	}else if (employee.getPersonalMail() == null || employee.getPersonalMail() == "") {
		resp.setMessage("personalMail Required");
		validity = false;
	}else if (employee.getWorkMail() == null || employee.getWorkMail() == "") {
		resp.setMessage("workMail Required");
		validity = false;
	}

		if (validity)
			try {
				String values = GenerateemployeemasterParameter.getAddempParam(employee);
				System.out.println(values);

				if (employee.getEmployeeId() != null && employee.getEmployeeId() != "") {
					List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
							.setParameter("actionType", "modifyemp").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						ManageEmployeeRestModel item = new ManageEmployeeRestModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10],m[11],m[12],m[13],m[14]);
						newemp.add(item);
					}
				} else {

					List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
							.setParameter("actionType", "addemp").setParameter("actionValue", values).getResultList();
					for (Object[] m : x) {

						ManageEmployeeRestModel item = new ManageEmployeeRestModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10],m[11],m[12],m[13],m[14]);
						newemp.add(item);
					}

				}

				resp.setBody(newemp.get(0));
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

		ResponseEntity<JsonResponse<ManageEmployeeRestModel>> response = new ResponseEntity<JsonResponse<ManageEmployeeRestModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveEmpMaster ends");
		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ManageEmployeeAddressRestModel>> saveemployeeaddress(ManageEmployeeAddressRestModel manageEmployeeAddressRestModel) {
		logger.info("Method : saveemployeeaddress starts");

		Boolean validity = true;
		JsonResponse<ManageEmployeeAddressRestModel> resp = new JsonResponse<ManageEmployeeAddressRestModel>();
		resp.setMessage("");
		resp.setCode("");

		List<ManageEmployeeAddressRestModel> employeeaddess = new ArrayList<ManageEmployeeAddressRestModel>();
System.out.println("manageEmployeeAddressRestModel " + manageEmployeeAddressRestModel);




 if (manageEmployeeAddressRestModel.getType() == null || manageEmployeeAddressRestModel.getType() == "") {
			resp.setMessage("Type Name Required");
			validity = false;
		} else if (manageEmployeeAddressRestModel.getAddress() == null || manageEmployeeAddressRestModel.getAddress() == "") {
			resp.setMessage("Address");
			validity = false;
		
		} else if (manageEmployeeAddressRestModel.getCity() == null || manageEmployeeAddressRestModel.getCity() == "") {
			resp.setMessage("City Required");
			validity = false;
		
		} else if (manageEmployeeAddressRestModel.getState()== null || manageEmployeeAddressRestModel.getState() == "") {
			resp.setMessage("State Required");
			validity = false;
		
		} else if (manageEmployeeAddressRestModel.getCountry()== null || manageEmployeeAddressRestModel.getCountry() == "") {
			resp.setMessage("Country Required");
			validity = false;
		} else if (manageEmployeeAddressRestModel.getZipCode()== null || manageEmployeeAddressRestModel.getZipCode() == "") {
			resp.setMessage("ZipCode Required");
			validity = false;
		}
		else if (manageEmployeeAddressRestModel.getStatus()== null || manageEmployeeAddressRestModel.getStatus() == "") {
			resp.setMessage("Status Required");
			validity = false;
		}
System.out.println("validity " +validity);
		if (validity)
			try {
				String values = GenerateemployeemasterParameter.saveempadd(manageEmployeeAddressRestModel);
				System.out.println("values " + values);
				if (manageEmployeeAddressRestModel.getAddressId() != null && manageEmployeeAddressRestModel.getAddressId() != "") {
//					em.createNamedStoredProcedureQuery("locationMasterRoutines")
//							.setParameter("actionType", "modifyLocation").setParameter("actionValue", values).execute();
				
					List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
							.setParameter("actionType", "modifyempadd").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {


						ManageEmployeeAddressRestModel employeeadd = new ManageEmployeeAddressRestModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9]);
							employeeaddess.add(employeeadd);
						}
				} else {

					List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
							.setParameter("actionType", "addempaddress").setParameter("actionValue", values).getResultList();
					for (Object[] m : x) {

						ManageEmployeeAddressRestModel employeeadd = new ManageEmployeeAddressRestModel(null,null,m[0],m[1],m[2],m[3],m[4],m[5],m[6],null);
						employeeaddess.add(employeeadd);
						}
				}

				resp.setBody(employeeaddess.get(0));
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

		ResponseEntity<JsonResponse<ManageEmployeeAddressRestModel>> response = new ResponseEntity<JsonResponse<ManageEmployeeAddressRestModel>>(
				resp, HttpStatus.CREATED);
 System.out.println(response);
		logger.info("Method : saveVendorLocationMaster ends");
		return response;
	}
	


	public ResponseEntity<JsonResponse<List<ManageEmployeeAddressRestModel>>> viewEmployeeadd() {
		logger.info("Method : getRequistionview starts");

		List<ManageEmployeeAddressRestModel> viewEmployeeadd = new ArrayList<ManageEmployeeAddressRestModel>();

		try {

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "viewEmployeeadd").setParameter("actionValue", "").getResultList();
			System.out.println(x);
			for (Object[] m : x) {
			/*	Object sDate = null;
				if (m[7] != null) {
					sDate = DateFormatter.returnStringDate(m[7]);
				}
				Object Date = null;
				if (m[8] != null) {
					Date = DateFormatter.returnStringDate(m[8]);
				}*/

				ManageEmployeeAddressRestModel vendorLocation = new ManageEmployeeAddressRestModel(null,null,m[0],m[1],m[2],m[3],m[4],m[5],m[6],null);
				viewEmployeeadd.add(vendorLocation);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<ManageEmployeeAddressRestModel>> resp = new JsonResponse<List<ManageEmployeeAddressRestModel>>();
		resp.setBody(viewEmployeeadd);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ManageEmployeeAddressRestModel>>> response = new ResponseEntity<JsonResponse<List<ManageEmployeeAddressRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getRequistionview ends");
		System.out.println(response);
		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ManageEmployeeWorkdetailsRestModel>> saveemployeeworkdetails(ManageEmployeeWorkdetailsRestModel manageEmployeeWorkdetailsRestModel) {
		logger.info("Method : saveemployeeworkdetails starts");

		Boolean validity = true;
		JsonResponse<ManageEmployeeWorkdetailsRestModel> resp = new JsonResponse<ManageEmployeeWorkdetailsRestModel>();
		resp.setMessage("");
		resp.setCode("");

		List<ManageEmployeeWorkdetailsRestModel> saveemployeeworkdetails = new ArrayList<ManageEmployeeWorkdetailsRestModel>();




 if (manageEmployeeWorkdetailsRestModel.getStartDate() == null || manageEmployeeWorkdetailsRestModel.getStartDate() == "") {
			resp.setMessage("StartDate Required");
			validity = false;
		} else if (manageEmployeeWorkdetailsRestModel.getEndDate() == null || manageEmployeeWorkdetailsRestModel.getEndDate() == "") {
			resp.setMessage("EndDate");
			validity = false;
		
		} else if (manageEmployeeWorkdetailsRestModel.getJobTitle() == null || manageEmployeeWorkdetailsRestModel.getJobTitle() == "") {
			resp.setMessage("JobTitle Required");
			validity = false;
		
		} else if (manageEmployeeWorkdetailsRestModel.getDepartment()== null || manageEmployeeWorkdetailsRestModel.getDepartment() == "") {
			resp.setMessage("getDepartment Required");
			validity = false;
		
		} else if (manageEmployeeWorkdetailsRestModel.getEmploymentStatus()== null || manageEmployeeWorkdetailsRestModel.getEmploymentStatus() == "") {
			resp.setMessage("EmploymentStatus Required");
			validity = false;
		} else if (manageEmployeeWorkdetailsRestModel.getDegination()== null || manageEmployeeWorkdetailsRestModel.getDegination() == "") {
			resp.setMessage("getEmploymentStatus Required");
			validity = false;
		}
		else if (manageEmployeeWorkdetailsRestModel.getBand()== null || manageEmployeeWorkdetailsRestModel.getBand() == "") {
			resp.setMessage("getBand Required");
			validity = false;
		}
		else if (manageEmployeeWorkdetailsRestModel.getManager()== null || manageEmployeeWorkdetailsRestModel.getManager() == "") {
			resp.setMessage("getManager Required");
			validity = false;
		}
		else if (manageEmployeeWorkdetailsRestModel.getAnnualCTC()== null || manageEmployeeWorkdetailsRestModel.getAnnualCTC() == "") {
			resp.setMessage("getAnnualCTC Required");
			validity = false;
		}
System.out.println("validity " +validity);
		if (validity)
			try {
				String values = GenerateemployeemasterParameter.saveempworkdetails(manageEmployeeWorkdetailsRestModel);
				System.out.println("values " + values);
				if (manageEmployeeWorkdetailsRestModel.getEmployeeworkId() != null && manageEmployeeWorkdetailsRestModel.getEmployeeworkId() != "") {
//					em.createNamedStoredProcedureQuery("locationMasterRoutines")
//							.setParameter("actionType", "modifyLocation").setParameter("actionValue", values).execute();
				
					List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
							.setParameter("actionType", "modifyempworkdetails").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {


						ManageEmployeeWorkdetailsRestModel saveemployeeworkdetailssss = new ManageEmployeeWorkdetailsRestModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10], m[11], m[12]);
						saveemployeeworkdetails.add(saveemployeeworkdetailssss);
						}
				} else {

					List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
							.setParameter("actionType", "addempworkdetails").setParameter("actionValue", values).getResultList();
					for (Object[] m : x) {

						ManageEmployeeWorkdetailsRestModel saveemployeeworkdetailssss = new ManageEmployeeWorkdetailsRestModel(m[0] ,null,m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10], m[11]);
						saveemployeeworkdetails.add(saveemployeeworkdetailssss);
						}
				}

				resp.setBody(saveemployeeworkdetails.get(0));
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

		ResponseEntity<JsonResponse<ManageEmployeeWorkdetailsRestModel>> response = new ResponseEntity<JsonResponse<ManageEmployeeWorkdetailsRestModel>>(
				resp, HttpStatus.CREATED);
 System.out.println(response);
		logger.info("Method : saveVendorLocationMaster ends");
		return response;
	}
	public ResponseEntity<JsonResponse<List<ManageEmployeeWorkdetailsRestModel>>> viewEmployeework() {
		logger.info("Method : getworkkkk starts");

		List<ManageEmployeeWorkdetailsRestModel> viewEmployeework = new ArrayList<ManageEmployeeWorkdetailsRestModel>();

		try {

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "viewEmployework").setParameter("actionValue", "").getResultList();
			System.out.println(x);
			for (Object[] m : x) {
			/*	Object sDate = null;
				if (m[7] != null) {
					sDate = DateFormatter.returnStringDate(m[7]);
				}
				Object Date = null;
				if (m[8] != null) {
					Date = DateFormatter.returnStringDate(m[8]);
				}*/

				ManageEmployeeWorkdetailsRestModel viewEmployee = new ManageEmployeeWorkdetailsRestModel(null,null,m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],null);
				viewEmployeework.add(viewEmployee);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<ManageEmployeeWorkdetailsRestModel>> resp = new JsonResponse<List<ManageEmployeeWorkdetailsRestModel>>();
		resp.setBody(viewEmployeework);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ManageEmployeeWorkdetailsRestModel>>> response = new ResponseEntity<JsonResponse<List<ManageEmployeeWorkdetailsRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getworkkkk ends");
		System.out.println(response);
		return response;
	}
	public ResponseEntity<JsonResponse<Object>> deleteaddressempById(String id) {
		logger.info("Method : deleteaddressempById starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET  @p_getAddressId='(" + id + ")'";
			System.out.println("DELETE "+value);

			em.createNamedStoredProcedureQuery("employeeMasterRoutines").setParameter("actionType", "deleteaddressempById")
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
	
}