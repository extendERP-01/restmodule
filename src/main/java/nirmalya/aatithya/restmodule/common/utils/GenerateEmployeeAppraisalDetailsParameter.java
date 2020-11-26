package nirmalya.aatithya.restmodule.common.utils;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.RestHrmEmployeeReviewerDetailsModel;

public class GenerateEmployeeAppraisalDetailsParameter {

	public static String addAppraisalDetailsParam(List<RestHrmEmployeeReviewerDetailsModel> reviewerAssign) {

		String s = "";
		String litem = "";
		String subQuery = "";
		String deleteSubQuery = "";

		for (RestHrmEmployeeReviewerDetailsModel m : reviewerAssign) {

			deleteSubQuery = deleteSubQuery + "(\"" + m.gettSetAuthorityNFA() + "\"),";

			litem = litem + "(\"" + m.gettUserRole() + "\",\"" + m.gettEmployee() + "\",\""
					+ m.gettSetAuthorityStageNo() + "\",\"" + m.gettSetAuthorityTAT() + "\",\""
					+ m.gettSetAuthorityCreatedBy() + "\",\"" + m.gettSetAuthorityNFA() + "\",\""
					+ m.gettAppraisalFrequency() + "\",\"" + m.gettAppraisalDueDate() + "\",\"" + m.gettCompanyId()
					+ "\",\"" + m.getFinancialDate() + "\"),";
		}

		int count = 0;
		String fromDate = "";
		int months = 0;
		Calendar calender = Calendar.getInstance();
		for (RestHrmEmployeeReviewerDetailsModel q : reviewerAssign) {
			/*****************************************************************/
			String name = q.gettAppraisalFrequency();
			fromDate = q.getFinancialFromDate();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date date = new Date();
			try {
				date = formatter.parse(fromDate);

			} catch (Exception e) {
				e.printStackTrace();
			}
			calender.setTime(date);

			if (name.contentEquals("dp102")) {

				count = 1;
				months = 12;
			} else if (name.contentEquals("dp103")) {

				count = 2;
				months = 6;
			} else if (name.contentEquals("dp104")) {

				count = 4;
				months = 3;
			} else if (name.contentEquals("dp105")) {

				count = 12;
				months = 1;
			}

		}

		String toDate1 = "";
		for (int i = 0; i < count; i++) {

			calender.add(Calendar.MONTH, months);
			toDate1 = (String) DateFormatter.returnStringDate(calender.getTime());
			subQuery = subQuery + "(\"" + reviewerAssign.get(0).gettSetAuthorityNFA() + "\",\""
					+ DateFormatter.getStringDate(fromDate) + "\",\"" + DateFormatter.getStringDate(toDate1) + "\"),";
			fromDate = toDate1;

		}
		/*****************************************************************/

		litem = litem.substring(0, litem.length() - 1);

		subQuery = subQuery.substring(0, subQuery.length() - 1);

		deleteSubQuery = deleteSubQuery.substring(0, deleteSubQuery.length() - 1);

		s = s + "@p_deleteSubQuery='" + "(" + deleteSubQuery + ")" + "',";
		s = s + "@p_litem='" + litem + "',";
		s = s + "@p_litem1='" + subQuery + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);
			s = "SET " + s + ";";
		}

		return s;
	}

}
