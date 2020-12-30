package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;
import java.util.stream.Stream;

import nirmalya.aatithya.restmodule.employee.model.EmployeePayrollMasterModel;

public class GenerateEmployeePayRollParameter {

	public static String getAddPayRollParam(List<EmployeePayrollMasterModel> payrollMaster) {
		String s = "";
		String dtls = "";

		Stream<EmployeePayrollMasterModel> notNullObjs = payrollMaster.stream()
				.filter(obj -> obj.gettNetSalary() != null);

		Double sum = notNullObjs.mapToDouble(EmployeePayrollMasterModel::gettNetSalary).sum();
		s = s + "@p_totalSalaryPaid='" + sum + "',";
		s = s + "@p_createdBy='" + payrollMaster.get(0).gettCreatedBy() + "',";
		s = s + "@p_paidDate='" + DateFormatter.getStringDate(payrollMaster.get(0).getPaymentDate()) + "',";
		for (EmployeePayrollMasterModel m : payrollMaster) {

			dtls = dtls + "(@p_id,\"" + m.gettEmployeeId() + "\",\"" + m.gettEmployeeName() + "\",\"" + m.gettPayGrade()
					+ "\"," + m.gettLeaveDays() + "," + m.getPaidLeave() + "," + m.getLeaveWithOutPay() + ","
					+ m.getTotalAttendance() + "," + m.gettBasicPay() + "," + m.gettDearnessAllowance() + ","
					+ m.gettHouseRentAllowance() + "," + m.gettConveyanceAllowance() + ","
					+ m.gettLeaveTravelAllowance() + "," + m.gettMedicalAllowance() + ","
					+ m.gettEmployeeProvidentFund() + "," + m.gettESICscheme() + "," + m.gettPerquisites() + ","
					+ m.gettEarnings() + "," + m.gettCTC() + "," + m.gettTaxableAmnt() + ",\"" + m.gettCreatedBy()
					+ "\"),";
		}
		dtls = dtls.substring(0, dtls.length() - 1);

		s = s + "@p_subQuery='" + dtls + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("S+++++++++++++++++++++++++++++++++" + s);
		return s;

	}

}
