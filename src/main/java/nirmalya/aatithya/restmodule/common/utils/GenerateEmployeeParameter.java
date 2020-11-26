package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeDocumentsModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeGroupInsuranceModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeSalaryStructureModel;

public class GenerateEmployeeParameter {

	public static String getAddEmploymentParam(HrmsEmployeeModel employee) {

		String s = "";
		String salary = "";
		String document = "";
		String groupIns = "";
		System.out.println("This meyhod called");
		try {
			String dob = null;
			String joindate = null;
			String confirmdate = null;
			String terminationDate = null;
			try {
				dob = DateFormatter.getStringDate(employee.getEmployeeDob());
				joindate = DateFormatter.getStringDate(employee.getEmployeeJoinDate());
				if (employee.getEmployeeConfirmDate() != null) {
					confirmdate = DateFormatter.getStringDate(employee.getEmployeeConfirmDate());
				}
				if (employee.getEmployeeTerminateDate() != null)
					terminationDate = DateFormatter.getStringDate(employee.getEmployeeTerminateDate());
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			if (employee.getEmployeeNo() != null) {
				s = s + "@P_empId='" + employee.getEmployeeNo() + "',";
			}
			if (employee.getEmployeeFname() != null && employee.getEmployeeFname() != "") {
				s = s + "@p_empFName='" + employee.getEmployeeFname() + "',";
			}
			if (employee.getEmployeeMname() != null) {
				s = s + "@p_empMName='" + employee.getEmployeeMname() + "',";
			}
			if (employee.getEmployeeLname() != null && employee.getEmployeeLname() != "") {
				s = s + "@p_empLName='" + employee.getEmployeeLname() + "',";
			}
			if (employee.getEmployeeNationality() != null && employee.getEmployeeNationality() != "") {
				s = s + "@p_empNationality='" + employee.getEmployeeNationality() + "',";
			}
			if (employee.getEmployeeDob() != null && employee.getEmployeeDob() != "") {
				s = s + "@p_empDob='" + dob + "',";
			}
			if (employee.getEmployeeGender() != null && employee.getEmployeeGender() != "") {
				s = s + "@p_empGen='" + employee.getEmployeeGender() + "',";
			}
			if (employee.getEmployeeImage() != null) {
				s = s + "@p_empImage='" + employee.getEmployeeImage() + "',";
			}
			if (employee.getEmployeeMarital() != null && employee.getEmployeeMarital() != "") {
				s = s + "@p_empMarital='" + employee.getEmployeeMarital() + "',";
			}
			if (employee.getEmployeeEsicNo() != null && employee.getEmployeeEsicNo() != "") {
				s = s + "@p_empEsic='" + employee.getEmployeeEsicNo() + "',";
			}
			if (employee.getEmployeePassword() != null && employee.getEmployeePassword() != "") {
				s = s + "@p_empIPassword='" + employee.getEmployeePassword() + "',";
			}
			if (employee.getEmployeepPin() != null) {
				s = s + "@p_emppPin='" + employee.getEmployeepPin() + "',";
			}
			if (employee.getEmployeeAdhar() != null) {
				s = s + "@p_empAdhar='" + employee.getEmployeeAdhar() + "',";
			}
			if (employee.getEmployeeOtherId() != null) {
				s = s + "@p_empOtherId='" + employee.getEmployeeOtherId() + "',";
			}
			if (employee.getEmployeeDl() != null) {
				s = s + "@p_empDl='" + employee.getEmployeeDl() + "',";
			}
			if (employee.getEmployeeEmployment() != null && employee.getEmployeeEmployment() != "") {
				s = s + "@p_empEmployment='" + employee.getEmployeeEmployment() + "',";
			}

			if (employee.getEmployeePayGrade() != null && employee.getEmployeePayGrade() != "") {
				s = s + "@p_empPaygrade='" + employee.getEmployeePayGrade() + "',";
			}
			if (employee.getEmployeeWorkStationId() != null) {
				s = s + "@p_empWorkstation='" + employee.getEmployeeWorkStationId() + "',";
			}
			if (employee.getEmployeeAddress() != null && employee.getEmployeeAddress() != "") {
				s = s + "@p_empAddress='" + employee.getEmployeeAddress() + "',";
			}
			if (employee.getEmployeeCity() != null) {
				s = s + "@p_empCity='" + employee.getEmployeeCity() + "',";
			}
			if (employee.getEmployeeCountry() != null && employee.getEmployeeCountry() != "") {
				s = s + "@p_empCountry='" + employee.getEmployeeCountry() + "',";
			}
			if (employee.getEmployeePin() != null && employee.getEmployeePin() != "") {
				s = s + "@p_empPin='" + employee.getEmployeePin() + "',";
			}
			if (employee.getEmployeeHomePhoneNo() != null) {
				s = s + "@p_empHphone='" + employee.getEmployeeHomePhoneNo() + "',";
			}
			if (employee.getEmployeeMobilePhoneNo() != null) {
				s = s + "@p_empMphone='" + employee.getEmployeeMobilePhoneNo() + "',";
				s = s + "@p_whatsAppNo='" + employee.getEmployeeMobilePhoneNo() + "',";
			}
			if (employee.getEmployeeWorkPhoneNo() != null) {
				s = s + "@p_empWphone='" + employee.getEmployeeWorkPhoneNo() + "',";
			}
			if (employee.getEmployeeWorkEmail() != null) {
				s = s + "@p_empWemail='" + employee.getEmployeeWorkEmail() + "',";
			}
			if (employee.getEmployeePersonalEmail() != null) {
				s = s + "@p_empPemail='" + employee.getEmployeePersonalEmail() + "',";
			}

			if (employee.getEmployeeJoinDate() != null) {
				s = s + "@p_empJoindate='" + joindate + "',";
			}
			if (employee.getEmployeeConfirmDate() != null) {
				s = s + "@p_empConfmdate='" + confirmdate + "',";
			}
			if (employee.getEmployeeTerminateDate() != null && employee.getEmployeeTerminateDate() != "") {

				s = s + "@p_empTermdate='" + terminationDate + "',";
			}
			if (employee.getEmployeeDepartment() != null && employee.getEmployeeDepartment() != "") {
				s = s + "@p_empDeprt='" + employee.getEmployeeDepartment() + "',";
			}
			if (employee.getEmployeeSupervisor() != null && employee.getEmployeeSupervisor() != "") {
				s = s + "@p_empSupervisor='" + employee.getEmployeeSupervisor() + "',";
			}
			if (employee.getEmployeeIndSupervisor() != null && employee.getEmployeeIndSupervisor() != "") {
				s = s + "@p_empIndSupervisor='" + employee.getEmployeeIndSupervisor() + "',";
			}
			if (employee.getEmployeeFirstApp() != null && employee.getEmployeeFirstApp() != "") {
				s = s + "@p_emp1stApp='" + employee.getEmployeeFirstApp() + "',";
			}
			if (employee.getEmployeeSecApp() != null && employee.getEmployeeSecApp() != "") {
				s = s + "@p_emp2ndApp='" + employee.getEmployeeSecApp() + "',";
			}
			if (employee.getEmployeeThirdApp() != null && employee.getEmployeeThirdApp() != "") {
				s = s + "@p_emp3rdApp='" + employee.getEmployeeThirdApp() + "',";
			}
			if (employee.getEmployeeNotes() != null) {
				s = s + "@p_empNotes='" + employee.getEmployeeNotes() + "',";
			}
			if (employee.getCreatedBy() != null && employee.getCreatedBy() != "") {
				s = s + "@p_createdBy='" + employee.getCreatedBy() + "',";
			}
			if (employee.getCompanyId() != null && employee.getCompanyId() != "") {
				s = s + "@p_companyId='" + employee.getCompanyId() + "',";
			}
			if (employee.getEmployeeJobTitle() != null && employee.getEmployeeJobTitle() != "") {
				s = s + "@p_empJobtitle='" + employee.getEmpDesignation() + "',";
			}
			if (employee.getEmployeeState() != null && employee.getEmployeeState() != "") {
				s = s + "@p_empState='" + employee.getEmployeeState() + "',";
			}
			if (employee.getHaveEpfNo() != null) {
				s = s + "@p_haveEpf=" + employee.getHaveEpfNo() + ",";
			}
			if (employee.getHaveEsicNo() != null) {
				s = s + "@p_haveEsic=" + employee.getHaveEsicNo() + ",";
			}
			if (employee.getFoodAllowStatus() != null) {
				s = s + "@p_foodAllow=" + employee.getFoodAllowStatus() + ",";
			}
			if (employee.getEpfNo() != null && employee.getEpfNo() != "") {
				s = s + "@p_epf='" + employee.getEpfNo() + "',";
			}
			if (employee.getEsicNo() != null && employee.getEsicNo() != "") {
				s = s + "@p_esic='" + employee.getEsicNo() + "',";
			}
			if (employee.getBankName() != null && employee.getBankName() != "") {
				s = s + "@p_bankName='" + employee.getBankName() + "',";
			}
			if (employee.getBankAcNo() != null && employee.getBankAcNo() != "") {
				s = s + "@p_bankAcNo='" + employee.getBankAcNo() + "',";
			}
			if (employee.getBankIfscCode() != null && employee.getBankIfscCode() != "") {
				s = s + "@p_ifscNo='" + employee.getBankIfscCode() + "',";
			}
			if (employee.getEsicNo() != null && employee.getEsicNo() != "") {
				s = s + "@p_esic='" + employee.getEsicNo() + "',";
			}
			if (employee.getHealthInsuFromDate() != null && employee.getHealthInsuFromDate() != "") {
				s = s + "@p_healthIncFromDate='" + DateFormatter.getStringDate(employee.getHealthInsuFromDate()) + "',";
			}
			if (employee.getHealthInsuToDate() != null && employee.getHealthInsuToDate() != "") {
				s = s + "@p_healthIncToDate='" + DateFormatter.getStringDate(employee.getHealthInsuToDate()) + "',";
			}
			if (employee.getGroupInsuFromDate() != null && employee.getGroupInsuFromDate() != "") {
				s = s + "@p_grouIncpFromDate='" + DateFormatter.getStringDate(employee.getGroupInsuFromDate()) + "',";
			}
			if (employee.getGroupInsuToDate() != null && employee.getGroupInsuToDate() != "") {
				s = s + "@p_groupIncToDate='" + DateFormatter.getStringDate(employee.getGroupInsuToDate()) + "',";
			}
			if (employee.getBioMetricId() != null && employee.getBioMetricId() != "") {
				s = s + "@p_bioMetricId='" + employee.getEsicNo() + "',";
			}
			if (employee.getBloodGroup() != null && employee.getBloodGroup() != "") {
				s = s + "@p_bloodGroup='" + employee.getBloodGroup() + "',";
			}
			if (employee.getNomineeName() != null && employee.getNomineeName() != "") {
				s = s + "@p_nomineeName='" + employee.getNomineeName() + "',";
			}
			if (employee.getNomineeRel() != null && employee.getNomineeRel() != "") {
				s = s + "@p_nomineeRel='" + employee.getNomineeRel() + "',";
			}
			if (employee.getHaveGroupInsu() != null) {
				s = s + "@p_haveGroupIns=" + employee.getHaveGroupInsu() + ",";
			}
			if (employee.getHaveHealthInsu() != null) {
				s = s + "@p_healthIns=" + employee.getHaveHealthInsu() + ",";
			}

			if (employee.getSalaryStructureList().size() > 0) {
				if (employee.getSalaryStructureList().get(0).getAnnualCtc() != null) {
					s = s + "@p_annualCtc=" + employee.getSalaryStructureList().get(0).getAnnualCtc() + ",";
				}
			}

			if (employee.getEmployeeAddress1() != null && employee.getEmployeeAddress1() != "") {
				s = s + "@p_empAddr1='" + employee.getEmployeeAddress1() + "',";
			}
			if (employee.getEmployeeCity1() != null && employee.getEmployeeCity1() != "") {
				s = s + "@p_empCity1='" + employee.getEmployeeCity1() + "',";
			}
			if (employee.getEmployeeCountry1() != null && employee.getEmployeeCountry1() != "") {
				s = s + "@p_empCountry1='" + employee.getEmployeeCountry1() + "',";
			}
			if (employee.getEmployeeState1() != null && employee.getEmployeeState1() != "") {
				s = s + "@p_empState1='" + employee.getEmployeeState1() + "',";
			}
			if (employee.getEmployeePin1() != null && employee.getEmployeePin1() != "") {
				s = s + "@p_empPin1='" + employee.getEmployeePin1() + "',";
			}
			if (employee.getEmpleave() != null) {
				s = s + "@p_empleave=" + employee.getEmpleave() + ",";
			}
			if (employee.getAddStatus() != null) {
				s = s + "@p_addStatus=" + employee.getAddStatus() + ",";
			}

			if (employee.getUserId() != null && employee.getUserId() != "") {
				s = s + "@p_userId='" + employee.getUserId() + "',";
			}
			if (employee.getWhatsappNo() != null && employee.getWhatsappNo() != "") {
				s = s + "@p_whatsAppNo='" + employee.getWhatsappNo() + "',";
			}
			if (employee.getFatherFName() != null && employee.getFatherFName() != "") {
				s = s + "@p_fatherFName='" + employee.getFatherFName() + "',";
			}
			if (employee.getFatherLName() != null && employee.getFatherLName() != "") {
				s = s + "@p_fatherLName='" + employee.getFatherLName() + "',";
			}
			if (employee.getMotherLName() != null && employee.getMotherLName() != "") {
				s = s + "@p_motherFName='" + employee.getMotherLName() + "',";
			}
			if (employee.getMotherLName() != null && employee.getMotherLName() != "") {
				s = s + "@p_motherLName='" + employee.getMotherLName() + "',";
			}
			if (employee.getFatherDob() != null && employee.getFatherDob() != "") {
				s = s + "@p_fatherDob='" + DateFormatter.getStringDate(employee.getFatherDob()) + "',";
			}
			if (employee.getMotherDob() != null && employee.getMotherDob() != "") {
				s = s + "@p_motherDob='" + DateFormatter.getStringDate(employee.getMotherDob()) + "',";
			}

			if (employee.getDistPresentId() != null && employee.getDistPresentId() != "") {
				s = s + "@p_presentDist='" + employee.getDistPresentId() + "',";
			}

			if (employee.getDistPermanentId() != null && employee.getDistPermanentId() != "") {
				s = s + "@p_permanentDist='" + employee.getDistPermanentId() + "',";
			}

			String[] roleList = employee.getEmployeeJobTitle().split(",");
			String roles = "";
			for (int i = 0; i < roleList.length; i++) {
				roles = roles + "(@P_empId,\"" + roleList[i] + "\"),";
			}
			roles = roles.substring(0, roles.length() - 1);
			s = s + "@p_userRoles='" + roles + "',";

			String[] storeList = employee.getEmployeeBranch().split(",");
			String stores = "";
			for (int i = 0; i < storeList.length; i++) {
				stores = stores + "(@P_empId,\"" + storeList[i] + "\"),";
			}
			stores = stores.substring(0, stores.length() - 1);
			s = s + "@p_userBranches='" + stores + "',";
			if (employee.getSalaryStructureList().size() > 0) {
				for (HrmsEmployeeSalaryStructureModel a : employee.getSalaryStructureList()) {
					salary = salary + "(@P_empId,\"" + a.getAnnualCtc() + "\",\"" + a.getSalaryComponent() + "\",\""
							+ a.getCaltype() + "\",\"" + a.getAnnualAmount() + "\",\"" + a.getMonthlyAmount() + "\",\""
							+ a.getVariableAmount() + "\"),";
				}
				salary = salary.substring(0, salary.length() - 1);
				s = s + "@p_employeeSalary='" + salary + "',";
			}

			for (HrmsEmployeeDocumentsModel a : employee.getDocumentList()) {
				document = document + "(@P_empId,\"" + a.getDocumentType() + "\",\"" + a.getFileName() + "\"),";
			}
			if (!document.isEmpty()) {
				document = document.substring(0, document.length() - 1);
				s = s + "@p_employeeDocuments='" + document + "',";
			}

			for (HrmsEmployeeGroupInsuranceModel a : employee.getGroupInsurance()) {
				groupIns = groupIns + "(@P_empId,\"" + a.getfName() + "\",\"" + a.getmName() + "\",\"" + a.getlName()
						+ "\",\"" + a.getRelationship() + "\",\"" + DateFormatter.getStringDate(a.getDob()) + "\",\""
						+ employee.getCreatedBy() + "\"),";
			}
			if (!groupIns.isEmpty()) {
				groupIns = groupIns.substring(0, groupIns.length() - 1);
				s = s + "@p_employeeGroupIns='" + groupIns + "',";
			}
			if (s != "") {
				s = s.substring(0, s.length() - 1);
				s = "SET " + s + ";";
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return s;
	}

	public static String updateSalaryComponent(List<HrmsEmployeeSalaryStructureModel> salaryDetailsList) {

		String s = "";
		String salary = "";

		for (HrmsEmployeeSalaryStructureModel a : salaryDetailsList) {
			salary = salary + "(\"" + a.getEmployeeId() + "\",\"" + a.getSalaryComponent() + "\",\"" + a.getAnnualCtc()
					+ "\",\"" + a.getCaltype() + "\",\"" + a.getAnnualAmount() + "\",\"" + a.getMonthlyAmount()
					+ "\",\"" + a.getVariableAmount() + "\",\"" + DateFormatter.getStringDate(a.getEffectiveDate())
					+ "\"),";
		}

		if (salaryDetailsList.get(0).getEmployeeId() != null) {
			s = s + "@P_empId='" + salaryDetailsList.get(0).getEmployeeId() + "',";
		}
		if (salaryDetailsList.get(0).getJobTitleId() != null && salaryDetailsList.get(0).getJobTitleId() != "") {
			s = s + "@P_jobTitle='" + salaryDetailsList.get(0).getJobTitleId() + "',";
		}
		if (salaryDetailsList.get(0).getPayGradeId() != null && salaryDetailsList.get(0).getPayGradeId() != "") {
			s = s + "@P_payGrade='" + salaryDetailsList.get(0).getPayGradeId() + "',";
		}

		salary = salary.substring(0, salary.length() - 1);
		s = s + "@p_employeeSalary ='" + salary + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

}
