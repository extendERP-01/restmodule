package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.recruitment.model.ShiftMasterRestModel;

public class GenerateShifParameter {
	public static String getsifParam(ShiftMasterRestModel form) {
		String s = "";

		/*
		 * if (form.getShiftId() != null && form.getShiftId() != "") { s = s +
		 * "@p_ShiftId='" + form.getShiftId() + "',"; }
		 */
		s = s + "@p_ShiftId='" + form.getShiftId() + "',";

		if (form.getShiftName() != null && form.getShiftName() != "") {
			s = s + "@p_ShiftName='" + form.getShiftName() + "',";
		}

		if (form.getFromTime() != null && form.getFromTime() != "") {
			s = s + "@p_FromTime='" + form.getFromTime() + "',";
		}

		if (form.getToTime() != null && form.getToTime() != "") {
			s = s + "@p_Totime='" + form.getToTime() + "',";
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
