package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.user.model.RestUserMembershipMstrModel;

public class GenerateMembershipMstrParameter {

	/**
	 * @author Nirmalya Labs
	 *
	 */
	public static String getAddMembershipMstrParam(RestUserMembershipMstrModel table) {

		String s = "";

		if (table.getMemId() != null && table.getMemId() != " ") {
			s = s + "@p_memId='" + table.getMemId() + "',";
		}
		if (table.getMemName() != null && table.getMemName() != " ") {
			s = s + "@p_memName='" + table.getMemName() + "',";
		}
		if (table.getMemMonthlyFee() != null) {
			s = s + "@p_monthlyFee=" + table.getMemMonthlyFee() + ",";
		}

		if (table.getMemRegistrationFee() != null) {
			s = s + "@p_registrationFee=" + table.getMemRegistrationFee() + ",";
		}

		if (table.getMemValidity() != null && table.getMemValidity() != "") {
			s = s + "@p_validity='" + table.getMemValidity() + "',";
		}

		if (table.gettDependentsLimit() != null) {
			s = s + "@p_dependentNo=" + table.gettDependentsLimit() + ",";
		}

		if (table.gettChildrenAgeLimit() != null) {
			s = s + "@p_childAge=" + table.gettChildrenAgeLimit() + ",";
		}

		if (table.gettEffectiveFromDate() != null) {
			String date = DateFormatter.getStringDate(table.gettEffectiveFromDate());
			s = s + "@p_effDate='" + date + "',";
		}

		if (table.getMemStatus() == true || table.getMemStatus() == false) {
			s = s + "@p_status=" + table.getMemStatus() + ",";
		}

		if (table.getMemDescription() != null || table.getMemDescription() != "") {
			s = s + "@p_description='" + table.getMemDescription() + "',";
		}
		
		if (table.gettCMemberTypCreatedBy() != null || table.gettCMemberTypCreatedBy() != "") {
			s = s + "@p_createdBy='" + table.gettCMemberTypCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";

		}
		System.out.println("Set Data in GENERATE PARAMETER" + s);

		return s;
	}

	public static String getSearchParam(DataTableRequest request) {

		String s = "";

		if (request.getStart() != null) {
			s = s + "@p_start=" + request.getStart() + ",";
		}

		if (request.getLength() != null) {
			s = s + "@p_length=" + request.getLength() + ",";
		}

		if (request.getSearch() != null) {
			s = s + "@p_search='" + request.getSearch() + "',";
		}

		if (request.getParam1() != null) {
			s = s + "@p_param1='" + request.getParam1() + "',";
		}

		if (request.getParam2() != null) {
			s = s + "@p_param2='" + request.getParam2() + "',";
		}

		if (request.getParam3() != null) {
			s = s + "@p_param3='" + request.getParam3() + "',";
		}

		if (request.getParam4() != null) {
			s = s + "@p_param4='" + request.getParam4() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("param  : " + s);

		return s;
	}

}
