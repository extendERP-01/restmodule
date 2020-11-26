package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.recruitment.model.JobTitleRestModel;

public class GenerateJobParameter {

	public static String getAddjobParam(JobTitleRestModel job) {

		String s = "";

		if (job.getJobId() != null && job.getJobId() != "") {
			s = s + "@p_jobId='" + job.getJobId() + "',";
		}

		if (job.getjObtitle() != null && job.getjObtitle() != "") {
			s = s + "@p_jObtitle='" + job.getjObtitle() + "',";
		}

		if (job.getDepartment() != null && job.getDepartment() != "") {
			s = s + "@p_Department='" + job.getDepartment() + "',";
		}
		if (job.getIntPragraph() != null && job.getIntPragraph() != " ") {
			s = s + "@p_IntPragraph='" + job.getIntPragraph() + "',";
		}
		if (job.getResponsibility() != null && job.getResponsibility() != " ") {
			s = s + "@p_Responsibility='" + job.getResponsibility() + "',";
		}
		if (job.getJobType() != null && job.getJobType() != "") {
			s = s + "@p_JobType='" + job.getJobType() + "',";
		}
		if (job.getWorkHourBenifit() != null && job.getWorkHourBenifit() != "") {
			s = s + "@p_WorkHourBenifit='" + job.getWorkHourBenifit() + "',";
		}
		if (job.getSkill() != null && job.getSkill() != "") {
			s = s + "@p_Skill='" + job.getSkill() + "',";
		}
		if (job.getEducation() != null && job.getEducation() != "") {
			s = s + "@p_Education='" + job.getEducation() + "',";
		}

		if (job.getCreatedBy() != null && job.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + job.getCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String getSearchParam(JobTitleRestModel job) {
		String s = "";
		if (job.getjObtitle() != null && job.getjObtitle() != "") {
			s = s + "@p_jObtitle='" + job.getjObtitle() + "',";
		}
		if (job.getJobType() != null && job.getJobType() != "") {
			s = s + "@p_JobType='" + job.getJobType() + "',";
		}
		return s;
	}
}
