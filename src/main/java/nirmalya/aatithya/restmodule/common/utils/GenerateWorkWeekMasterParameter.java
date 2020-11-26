package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.attendance.model.RestWorkWeekMasterModel;

public class GenerateWorkWeekMasterParameter {


	// HouseKeeping Task
	public static String addWorkWeekParam(RestWorkWeekMasterModel workWeekMaster) {
		String sqlParam = null;
		if (workWeekMaster.gettWorkDayName() != null) {
			sqlParam = "@p_dayName='" + workWeekMaster.gettWorkDayName() + "',";
		}
		if (workWeekMaster.gettWorkDayStatus() != null) {
			sqlParam = sqlParam + "@p_workingStatus='" + workWeekMaster.gettWorkDayStatus() + "',";
		}
		
		if (workWeekMaster.gettWorkDayCreatedBy() != null) {
			sqlParam = sqlParam + "@p_createdBy='" + workWeekMaster.gettWorkDayCreatedBy() + "',";
		}
		
	
		if (workWeekMaster.gettWorkDay() != null) {
			sqlParam = sqlParam + "@p_dayId='" + workWeekMaster.gettWorkDay() + "',";
		}

		if (sqlParam != "") {
			sqlParam = sqlParam.substring(0, sqlParam.length() - 1);

			sqlParam = "SET " + sqlParam + ";";
		}

		return sqlParam;

	}

}