package nirmalya.aatithya.restmodule.common.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import nirmalya.aatithya.restmodule.attendance.model.RestAttendenceDetailsModel;

public class GenerateAttendenceParameter {
	public static String addAttendenceParam(RestAttendenceDetailsModel attendenceDetails) {
		String sqlParam = null;

		/*
		 * if (attendenceDetails.gettAttndncDate() != null) { sqlParam = "@p_atnDate='"
		 * + DateFormatter.getStringDate(attendenceDetails.gettAttndncDate()) + "',"; }
		 */
		System.out.println("###"+LocalDate.now());
		
		if (attendenceDetails.gettAttndncDate() != null) {
			sqlParam = "@p_atnDate='" + LocalDate.now() + "',";
		}
		if (attendenceDetails.gettAttndncPunchIn() != null) {
			sqlParam = sqlParam + "@p_atnPunchIn='" + DateFormatter.getStringDateTime(attendenceDetails.gettAttndncPunchIn()) + "',";
		}
		if (attendenceDetails.gettAttndncPunchInLoc() != null) {
			sqlParam = sqlParam + "@p_atnPunchInLoc='" + attendenceDetails.gettAttndncPunchInLoc() + "',";
		}
		if (attendenceDetails.gettAttndncPunchInNote() != null) {

			sqlParam = sqlParam + "@p_atnPunchInNote='" + attendenceDetails.gettAttndncPunchInNote() + "',";
		}
		/*
		 * if (attendenceDetails.gettAttndncPunchOut() != null) { sqlParam = sqlParam +
		 * "@p_atnPunchOut='" +
		 * DateFormatter.getStringDateTime(attendenceDetails.gettAttndncPunchOut() )+
		 * "',"; }
		 */
		if (attendenceDetails.gettAttndncPunchOut() != null) {
			sqlParam = sqlParam + "@p_atnPunchOut='" + LocalDate.now() + "',";
		}
		if (attendenceDetails.gettAttndncPunchOutNote() != null) {
			sqlParam = sqlParam + "@p_atnPunchOutNote='" + attendenceDetails.gettAttndncPunchOutNote() + "',";
		}
		if (attendenceDetails.gettAttndncPunchOut_Loc() != null) {
			sqlParam = sqlParam + "@p_atnPunchOutLoc='" + attendenceDetails.gettAttndncPunchOut_Loc() + "',";
		}
		if (attendenceDetails.gettAttndncCreatedOn() != null) {
			sqlParam = sqlParam + "@p_createdOn='" + attendenceDetails.gettAttndncCreatedOn() + "',";
		}
		if (attendenceDetails.gettAttndncCreatedBy() != null) {
			sqlParam = sqlParam + "@p_createdby='" + attendenceDetails.gettAttndncCreatedBy() + "',";
		}

		if (attendenceDetails.gettEmployee() != null) {
			sqlParam = sqlParam + "@p_empId='" + attendenceDetails.gettEmployee() + "',";
		}

		if (sqlParam != "") {
			sqlParam = sqlParam.substring(0, sqlParam.length() - 1);

			sqlParam = "SET " + sqlParam + ";";
		}

		return sqlParam;

	}

}
