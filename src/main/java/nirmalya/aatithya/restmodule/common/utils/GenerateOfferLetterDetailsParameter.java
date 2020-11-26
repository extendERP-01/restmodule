package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.EmployeeOfferLetterSalaryDetailsModel;

import nirmalya.aatithya.restmodule.employee.model.RestOfferLetterDetailModel;

public class GenerateOfferLetterDetailsParameter {

	public static String addLetterDetailParam(List<RestOfferLetterDetailModel> offerLetterDtls) {
		String s = "";
		String litem = "";
		String id = "";
		String firstName = "";
		String middleName = "";
		String lastname = "";
		String dob = "";
		String nationality = "";
		String mobile = "";
		String image = "";
		String gnder = "";
		String maritalStatus = "";
		String jobTitle = "";
		String payGrade = "";
		String country = "";
		String state = "";
		String district = "";
		String pinCode = "";
		String address = "";
		String email = "";
		String doj = "";
		Double annualCTC = 0.0;

		String createdBy = "";

		for (RestOfferLetterDetailModel m : offerLetterDtls) {
			id = m.gettOfferLetterId();
			firstName = m.gettEmpFName();
			middleName = m.gettEmpMName();
			lastname = m.gettEmpLName();
			dob = DateFormatter.getStringDate(m.gettEmpDOB());
			nationality = m.gettNationality();
			mobile = m.gettMobileNo();
			image = m.gettEmpImage();
			gnder = m.gettEmpGender();
			maritalStatus = m.gettEmpMarritalStatus();
			jobTitle = m.gettJobTitle();
			payGrade = m.gettPayGrade();
			country = m.gettCountry();
			state = m.gettState();
			district = m.gettDistrict();
			pinCode = m.gettPinCode();
			address = m.gettAddress();
			email = m.gettEmailId();
			doj = DateFormatter.getStringDate(m.gettEmpDOJ());
			annualCTC = m.gettAnnualCTC();
			// component = m.gettComponentId();
			createdBy = m.gettCreatedBy();
		}
		s = s + "@p_id='" + id + "',";
		s = s + "@p_fName='" + firstName + "',";
		s = s + "@p_mName='" + middleName + "',";
		s = s + "@p_lName='" + lastname + "',";
		s = s + "@p_dob='" + dob + "',";
		s = s + "@P_nationality='" + nationality + "',";
		s = s + "@p_mobile='" + mobile + "',";
		s = s + "@p_image='" + image + "',";
		s = s + "@P_gndr='" + gnder + "',";
		s = s + "@P_marritalStatus='" + maritalStatus + "',";
		s = s + "@P_jobTitle='" + jobTitle + "',";
		s = s + "@P_payGrade='" + payGrade + "',";
		s = s + "@P_country='" + country + "',";
		s = s + "@P_state='" + state + "',";
		s = s + "@P_dist='" + district + "',";
		s = s + "@P_pin='" + pinCode + "',";
		s = s + "@P_address='" + address + "',";
		s = s + "@P_email='" + email + "',";
		s = s + "@P_doj='" + doj + "',";
		s = s + "@P_ctc=" + annualCTC + ",";
		// s = s + "@P_component='" + component + "',";
		s = s + "@P_createdBy='" + createdBy + "',";

		for (RestOfferLetterDetailModel m : offerLetterDtls) {

			litem = litem + "(@p_id,\"" + m.gettComponentId() + "\",\"" + m.getCalculationType() + "\",\""
					+ m.getMonthlyAmnt() + "\",\"" + m.gettAnnualAmount() + "\",@P_createdBy),";

		}

		litem = litem.substring(0, litem.length() - 1);

		s = s + "@p_childSubQuery='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	/***
	 * 
	 * 
	 * 
	 * 
	 **/
	public static String addEmployeeDetailsParam(List<EmployeeOfferLetterSalaryDetailsModel> employeeComponentDetails) {
		String dob = null;
		String joindate = null;
		String confirmdate = null;
		String terminationDate = null;
		String effectiveDate = null;
		Double basicPay = 0.0;
		Double dearness = 0.0;
		Double houseRent = 0.0;
		Double conveyance = 0.0;
		Double leave = 0.0;
		Double medical = 0.0;
		Double epf = 0.0;
		Double esic = 0.0;
		Double perquisites = 0.0;

		try {
			dob = DateFormatter.getStringDate(employeeComponentDetails.get(0).getEmployeeDob());
			joindate = DateFormatter.getStringDate(employeeComponentDetails.get(0).getEmployeeJoinDate());
			confirmdate = DateFormatter.getStringDate(employeeComponentDetails.get(0).getEmployeeConfirmDate());
			effectiveDate = DateFormatter.getStringDate(employeeComponentDetails.get(0).gettEffectiveDate());

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		String s = "";

		if (employeeComponentDetails.get(0).gettEmployeeId() != null) {
			s = s + "@P_empId='" + employeeComponentDetails.get(0).gettEmployeeId() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeFname() != null
				&& employeeComponentDetails.get(0).getEmployeeFname() != "") {
			s = s + "@p_empFName='" + employeeComponentDetails.get(0).getEmployeeFname() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeMname() != null) {
			s = s + "@p_empMName='" + employeeComponentDetails.get(0).getEmployeeMname() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeLname() != null
				&& employeeComponentDetails.get(0).getEmployeeLname() != "") {
			s = s + "@p_empLName='" + employeeComponentDetails.get(0).getEmployeeLname() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeNationality() != null
				&& employeeComponentDetails.get(0).getEmployeeNationality() != "") {
			s = s + "@p_empNationality='" + employeeComponentDetails.get(0).getEmployeeNationality() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeDob() != null
				&& employeeComponentDetails.get(0).getEmployeeDob() != "") {
			s = s + "@p_empDob='" + dob + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeGender() != null
				&& employeeComponentDetails.get(0).getEmployeeGender() != "") {
			s = s + "@p_empGen='" + employeeComponentDetails.get(0).getEmployeeGender() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeImage() != null) {
			s = s + "@p_empImage='" + employeeComponentDetails.get(0).getEmployeeImage() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeMarital() != null
				&& employeeComponentDetails.get(0).getEmployeeMarital() != "") {
			s = s + "@p_empMarital='" + employeeComponentDetails.get(0).getEmployeeMarital() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeEsicNo() != null
				&& employeeComponentDetails.get(0).getEmployeeEsicNo() != "") {
			s = s + "@p_empEsic='" + employeeComponentDetails.get(0).getEmployeeEsicNo() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeePassword() != null
				&& employeeComponentDetails.get(0).getEmployeePassword() != "") {
			s = s + "@p_empIPassword='" + employeeComponentDetails.get(0).getEmployeePassword() + "',";
		}
		if (employeeComponentDetails.get(0).getPassPin() != null) {
			s = s + "@p_emppPin='" + employeeComponentDetails.get(0).getPassPin() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeAdhar() != null) {
			s = s + "@p_empAdhar='" + employeeComponentDetails.get(0).getEmployeeAdhar() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeOtherId() != null) {
			s = s + "@p_empOtherId='" + employeeComponentDetails.get(0).getEmployeeOtherId() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeDl() != null) {
			s = s + "@p_empDl='" + employeeComponentDetails.get(0).getEmployeeDl() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeEmployment() != null
				&& employeeComponentDetails.get(0).getEmployeeEmployment() != "") {
			s = s + "@p_empEmployment='" + employeeComponentDetails.get(0).getEmployeeEmployment() + "',";
		}

		if (employeeComponentDetails.get(0).getEmployeePayGrade() != null
				&& employeeComponentDetails.get(0).getEmployeePayGrade() != "") {
			s = s + "@p_empPaygrade='" + employeeComponentDetails.get(0).getEmployeePayGrade() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeWorkStationId() != null) {
			s = s + "@p_empWorkstation='" + employeeComponentDetails.get(0).getEmployeeWorkStationId() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeAddress() != null
				&& employeeComponentDetails.get(0).getEmployeeAddress() != "") {
			s = s + "@p_empAddress='" + employeeComponentDetails.get(0).getEmployeeAddress() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeCity() != null) {
			s = s + "@p_empCity='" + employeeComponentDetails.get(0).getEmployeeCity() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeCountry() != null
				&& employeeComponentDetails.get(0).getEmployeeCountry() != "") {
			s = s + "@p_empCountry='" + employeeComponentDetails.get(0).getEmployeeCountry() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeePin() != null
				&& employeeComponentDetails.get(0).getEmployeePin() != "") {
			s = s + "@p_empPin='" + employeeComponentDetails.get(0).getEmployeePin() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeHomePhoneNo() != null) {
			s = s + "@p_empHphone='" + employeeComponentDetails.get(0).getEmployeeHomePhoneNo() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeMobilePhoneNo() != null) {
			s = s + "@p_empMphone='" + employeeComponentDetails.get(0).getEmployeeMobilePhoneNo() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeWorkPhoneNo() != null) {
			s = s + "@p_empWphone='" + employeeComponentDetails.get(0).getEmployeeWorkPhoneNo() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeWorkEmail() != null) {
			s = s + "@p_empWemail='" + employeeComponentDetails.get(0).getEmployeeWorkEmail() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeePersonalEmail() != null) {
			s = s + "@p_empPemail='" + employeeComponentDetails.get(0).getEmployeePersonalEmail() + "',";
		}

		if (employeeComponentDetails.get(0).getEmployeeJoinDate() != null) {
			s = s + "@p_empJoindate='" + joindate + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeConfirmDate() != null) {
			s = s + "@p_empConfmdate='" + confirmdate + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeTerminateDate() != null
				&& employeeComponentDetails.get(0).getEmployeeTerminateDate() != "") {

			s = s + "@p_empTermdate='" + terminationDate + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeDepartment() != null
				&& employeeComponentDetails.get(0).getEmployeeDepartment() != "") {
			s = s + "@p_empDeprt='" + employeeComponentDetails.get(0).getEmployeeDepartment() + "',";
		}

		if (employeeComponentDetails.get(0).getCreatedBy() != null
				&& employeeComponentDetails.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + employeeComponentDetails.get(0).getCreatedBy() + "',";
		}
		if (employeeComponentDetails.get(0).getCompanyId() != null
				&& employeeComponentDetails.get(0).getCompanyId() != "") {
			s = s + "@p_companyId='" + employeeComponentDetails.get(0).getCompanyId() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeJobTitle() != null
				&& employeeComponentDetails.get(0).getEmployeeJobTitle() != "") {
			s = s + "@p_empJobtitle='" + employeeComponentDetails.get(0).getEmpDesignation() + "',";
		}
		if (employeeComponentDetails.get(0).getEmployeeState() != null
				&& employeeComponentDetails.get(0).getEmployeeState() != "") {
			s = s + "@p_empState='" + employeeComponentDetails.get(0).getEmployeeState() + "',";
		}
		if (employeeComponentDetails.get(0).gettAnnualCTC() != null) {
			s = s + "@p_empCTC='" + employeeComponentDetails.get(0).gettAnnualCTC() + "',";
		}
		if (employeeComponentDetails.get(0).gettEffectiveDate() != null) {
			s = s + "@p_effectiveDate='" + effectiveDate + "',";
		}

		for (EmployeeOfferLetterSalaryDetailsModel a : employeeComponentDetails) {
			if (a.gettBasicPay() == null) {
				a.settBasicPay(0.0);
			}
			if (a.gettDearnessAllowance() == null) {
				a.settDearnessAllowance(0.0);
			}
			if (a.gettHouseRentAllowance() == null) {
				a.settHouseRentAllowance(0.0);
			}
			if (a.gettConveyanceAllowance() == null) {
				a.settConveyanceAllowance(0.0);
			}
			if (a.gettLeaveTravelAllowance() == null) {
				a.settLeaveTravelAllowance(0.0);
			}
			if (a.gettMedicalAllowance() == null) {
				a.settMedicalAllowance(0.0);
			}
			if (a.gettEmployeeProvidentFund() == null) {
				a.settEmployeeProvidentFund(0.0);
			}
			if (a.gettESICscheme() == null) {
				a.settESICscheme(0.0);
			}
			if (a.gettPerquisites() == null) {
				a.settPerquisites(0.0);
			}
			if (a.gettBasicPay() != null) {
				basicPay = basicPay + a.gettBasicPay();

			}
			if (a.gettDearnessAllowance() != null) {
				dearness = dearness + a.gettDearnessAllowance();

			}
			if (a.gettHouseRentAllowance() != null) {
				houseRent = houseRent + a.gettHouseRentAllowance();

			}
			if (a.gettConveyanceAllowance() != null) {
				conveyance = conveyance + a.gettConveyanceAllowance();

			}
			if (a.gettLeaveTravelAllowance() != null) {
				leave = leave + a.gettLeaveTravelAllowance();

			}
			if (a.gettMedicalAllowance() != null) {
				medical = medical + a.gettMedicalAllowance();

			}
			if (a.gettEmployeeProvidentFund() != null) {
				epf = epf + a.gettEmployeeProvidentFund();

			}
			if (a.gettESICscheme() != null) {
				esic = esic + a.gettESICscheme();

			}
			if (a.gettPerquisites() != null) {
				perquisites = perquisites + a.gettPerquisites();

			}
		}

		s = s + "@p_basic='" + basicPay + "',";
		s = s + "@p_dearance='" + dearness + "',";
		s = s + "@p_houseRent='" + houseRent + "',";
		s = s + "@p_conveyance='" + conveyance + "',";
		s = s + "@p_leave='" + leave + "',";
		s = s + "@p_medical='" + medical + "',";
		s = s + "@p_epf='" + epf + "',";
		s = s + "@p_esic='" + esic + "',";
		s = s + "@p_perquisites='" + perquisites + "',";

		String[] roleList = employeeComponentDetails.get(0).getEmployeeJobTitle().split(",");
		String roles = "";
		for (int i = 0; i < roleList.length; i++) {
			roles = roles + "(@P_empId,\"" + roleList[i] + "\"),";
		}
		roles = roles.substring(0, roles.length() - 1);
		s = s + "@p_userRoles='" + roles + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + s);
		return s;
	}
}
