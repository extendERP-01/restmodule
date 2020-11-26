package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.recruitment.model.RequistionRestModel;

public class GenerateReqParameter {
	public static String getAddreqParam(RequistionRestModel form) {
		String s = "";

		if (form.getRequistionId() != null && form.getRequistionId() != "") {
			s = s + "@p_requistionId='" + form.getRequistionId() + "',";
		}
		
		  if (form.getJobCode() != null && form.getJobCode() != "") { s = s +
		  "@p_jobcode='" + form.getJobCode() + "',"; }
		 
		if (form.getJobTitle() != null && form.getJobTitle() != "") {
			s = s + "@p_jobtitle='" + form.getJobTitle() + "',";
		}


		if (form.getDepartment() != null && form.getDepartment() != "") {
			s = s + "@p_department='" + form.getDepartment() + "',";
		}

		if (form.getHiringManager() != null && form.getHiringManager() != "") {
			s = s + "@p_hiringmanager='" + form.getHiringManager() + "',";
		}

		if (form.getOnboardBy() != null && form.getOnboardBy() != "") {
			s = s + "@p_onboard='" + DateFormatter.getStringDate(form.getOnboardBy()) + "',";
		}

		if (form.getBudget() != null) {
			s = s + "@p_budget='" + form.getBudget() + "',";
		}

		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_CreatedBy='" + form.getCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}
}


