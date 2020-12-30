package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.account.model.FinancialModel;

public class GenerateFinanceYearParameter {
	public static String getAddFinancialYearParam(FinancialModel form) {
		String s = "";

		if (form.getFinancialYearId() != null && form.getFinancialYearId() != "") {
			s = s + "@p_financialId='" + form.getFinancialYearId() + "',";
		}
		if (form.getFinancialYear() != null && form.getFinancialYear() != "") {
			s = s + "@p_financialYear='" + form.getFinancialYear() + "',";
		}
		if (form.getFinancialFromDate() != null && form.getFinancialFromDate() != "") {
			String date = DateFormatter.getStringDate(form.getFinancialFromDate());
			s = s + "@p_fromdate='" + date + "',";
		}
		if (form.getFinancialTodate() != null && form.getFinancialTodate() != "") {
			String todate = DateFormatter.getStringDate(form.getFinancialTodate());
			s = s + "@p_todate='" + todate + "',";
		}

		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";

		}

		if (form.getFinancialStatus() != null) {
			s = s + "@p_financialStatus=" + form.getFinancialStatus() + ",";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
			System.out.println(s);
		}

		return s;

	}
}
