package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeAddressRestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeRestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeWorkdetailsRestModel;

public class GenerateemployeemasterParameter {

	public static String getAddempParam(ManageEmployeeRestModel employee) {

		String s = "";

		if (employee.getEmployeeId() != null && employee.getEmployeeId() != "") {
			s = s + "@p_empId='" + employee.getEmployeeId() + "',";
		}
		if (employee.getFileEmployeeimg() != null && employee.getFileEmployeeimg() != "") {
			s = s + "@p_empimg='" + employee.getFileEmployeeimg() + "',";
		}
		if (employee.getFirstName() != null && employee.getFirstName() != "") {
			s = s + "@p_firstName='" + employee.getFirstName() + "',";
		}
		if (employee.getLastName() != null && employee.getLastName() != "") {
			s = s + "@p_LastName='" + employee.getLastName() + "',";
		}
		if (employee.getGender() != null && employee.getGender() != "") {
			s = s + "@p_gender='" + employee.getGender() + "',";

			if (employee.getDob() != null && employee.getDob() != "") {
				s = s + "@p_dob='" + employee.getDob() + "',";
			}
			if (employee.getBloodGroup() != null && employee.getBloodGroup() != "") {
				s = s + "@p_bloodgroup='" + employee.getBloodGroup() + "',";
			}
			if (employee.getMaritalStatus() != null && employee.getMaritalStatus() != "") {
				s = s + "@p_maratial='" + employee.getMaritalStatus() + "',";
			}
			if (employee.getNationality() != null && employee.getNationality() != "") {
				s = s + "@p_nationality='" + employee.getNationality() + "',";
			}
			if (employee.getFatherName() != null && employee.getFatherName() != "") {
				s = s + "@p_fathername='" + employee.getFatherName() + "',";
			}
			if (employee.getMotherName() != null && employee.getMotherName() != "") {
				s = s + "@p_mothername='" + employee.getMotherName() + "',";
			}
			if (employee.getMobileNo() != null && employee.getMobileNo() != "") {
				s = s + "@p_mobileNo='" + employee.getMobileNo() + "',";
			}
			if (employee.getPersonalMail() != null && employee.getPersonalMail() != "") {
				s = s + "@p_personalmail='" + employee.getPersonalMail() + "',";

			}

			if (employee.getWorkMail() != null && employee.getWorkMail() != "") {
				s = s + "@p_workmail='" + employee.getWorkMail() + "',";
			}
			if (employee.getCreatedBy() != null && employee.getCreatedBy() != "") {
				s = s + "@p_createdby='" + employee.getCreatedBy() + "',";
			}

			
			 //address
			  
			 
			 
			
			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}

		}
		return s;
	}
	
	public static String saveempadd(ManageEmployeeAddressRestModel manageEmployeeAddressRestModel) {

		String s = "";

		if (manageEmployeeAddressRestModel.getAddressId() != null && manageEmployeeAddressRestModel.getAddressId() != "") {
			s = s + "@p_getAddressId='" + manageEmployeeAddressRestModel.getAddressId() + "',";
		}
		if (manageEmployeeAddressRestModel.getEmployeeId() != null && manageEmployeeAddressRestModel.getEmployeeId() != "") {
			s = s + "@p_empId='" + manageEmployeeAddressRestModel.getEmployeeId() + "',";
		}
		if (manageEmployeeAddressRestModel.getType() != null && manageEmployeeAddressRestModel.getType() != "") {
			s = s + "@p_getType='" + manageEmployeeAddressRestModel.getType() + "',";
		}
		if (manageEmployeeAddressRestModel.getAddress() != null && manageEmployeeAddressRestModel.getAddress() != "") {
			s = s + "@p_Address='" + manageEmployeeAddressRestModel.getAddress() + "',";
		}
	
		
		
		if (manageEmployeeAddressRestModel.getCity() != null && manageEmployeeAddressRestModel.getCity() != "") {
			s = s + "@p_City='" + manageEmployeeAddressRestModel.getCity() + "',";
		}
		if (manageEmployeeAddressRestModel.getState() != null && manageEmployeeAddressRestModel.getState() != "") {
			s = s + "@p_State='" + manageEmployeeAddressRestModel.getState() + "',";
		}
		if (manageEmployeeAddressRestModel.getCountry() != null && manageEmployeeAddressRestModel.getCountry() != "") {
			s = s + "@p_Country='" + manageEmployeeAddressRestModel.getCountry() + "',";
		}
		if (manageEmployeeAddressRestModel.getZipCode()!= null && manageEmployeeAddressRestModel.getZipCode() != "") {
			s = s + "@p_ZipCode='" + manageEmployeeAddressRestModel.getZipCode() + "',";
		}
		
		
		
		if (manageEmployeeAddressRestModel.getStatus() != null && manageEmployeeAddressRestModel.getStatus() != "") {
			s = s + "@p_pStatus='" + manageEmployeeAddressRestModel.getStatus() + "',";
			}
		if (manageEmployeeAddressRestModel.getCreatedBy() != null && manageEmployeeAddressRestModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + manageEmployeeAddressRestModel.getCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}


		return s;
	}

	
public static String saveempworkdetails(ManageEmployeeWorkdetailsRestModel manageEmployeeWorkdetailsRestModel) {

	String s = "";

	if (manageEmployeeWorkdetailsRestModel.getEmployeeworkId() != null && manageEmployeeWorkdetailsRestModel.getEmployeeworkId() != "") {
		s = s + "@p_getEmployeeworkId='" + manageEmployeeWorkdetailsRestModel.getEmployeeworkId() + "',";
	}
	if (manageEmployeeWorkdetailsRestModel.getEmployeeId() != null && manageEmployeeWorkdetailsRestModel.getEmployeeId() != "") {
		s = s + "@p_empId='" + manageEmployeeWorkdetailsRestModel.getEmployeeId() + "',";
	}
	if (manageEmployeeWorkdetailsRestModel.getStartDate() != null && manageEmployeeWorkdetailsRestModel.getStartDate() != "") {
		s = s + "@p_gtartDate='" + manageEmployeeWorkdetailsRestModel.getStartDate() + "',";
	}
	if (manageEmployeeWorkdetailsRestModel.getEndDate() != null && manageEmployeeWorkdetailsRestModel.getEndDate() != "") {
		s = s + "@p_AEndDates='" + manageEmployeeWorkdetailsRestModel.getEndDate() + "',";
	}

	
	
	
	if (manageEmployeeWorkdetailsRestModel.getJobType() != null && manageEmployeeWorkdetailsRestModel.getJobType() != "") {
		s = s + "@p_JobTypee='" + manageEmployeeWorkdetailsRestModel.getJobType() + "',";
	}
	if (manageEmployeeWorkdetailsRestModel.getJobTitle() != null && manageEmployeeWorkdetailsRestModel.getJobTitle() != "") {
		s = s + "@p_JobTitle='" + manageEmployeeWorkdetailsRestModel.getJobTitle() + "',";
	}
	if (manageEmployeeWorkdetailsRestModel.getDepartment() != null && manageEmployeeWorkdetailsRestModel.getDepartment() != "") {
		s = s + "@p_Department='" + manageEmployeeWorkdetailsRestModel.getDepartment() + "',";
	}
	if (manageEmployeeWorkdetailsRestModel.getEmploymentStatus() != null && manageEmployeeWorkdetailsRestModel.getEmploymentStatus() != "") {
		s = s + "@p_EmploymentStatu='" + manageEmployeeWorkdetailsRestModel.getEmploymentStatus() + "',";
	}
	if (manageEmployeeWorkdetailsRestModel.getDegination()!= null && manageEmployeeWorkdetailsRestModel.getDegination() != "") {
		s = s + "@p_Deginatio='" + manageEmployeeWorkdetailsRestModel.getDegination() + "',";
	}
	
	
	
	if (manageEmployeeWorkdetailsRestModel.getBand() != null && manageEmployeeWorkdetailsRestModel.getBand() != "") {
		s = s + "@p_Band='" + manageEmployeeWorkdetailsRestModel.getBand() + "',";
		}
	if (manageEmployeeWorkdetailsRestModel.getManager() != null && manageEmployeeWorkdetailsRestModel.getManager() != "") {
		s = s + "@p_Manager='" + manageEmployeeWorkdetailsRestModel.getManager() + "',";
		}
	if (manageEmployeeWorkdetailsRestModel.getAnnualCTC() != null && manageEmployeeWorkdetailsRestModel.getAnnualCTC() != "") {
		s = s + "@p_AnnualCTC='" + manageEmployeeWorkdetailsRestModel.getAnnualCTC() + "',";
		}
	if (manageEmployeeWorkdetailsRestModel.getCreatedBy() != null && manageEmployeeWorkdetailsRestModel.getCreatedBy() != "") {
		s = s + "@p_createdBy='" + manageEmployeeWorkdetailsRestModel.getCreatedBy() + "',";
	}

	if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
	}


	return s;
}
}
