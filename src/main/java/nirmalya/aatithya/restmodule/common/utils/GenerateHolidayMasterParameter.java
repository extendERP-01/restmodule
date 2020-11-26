package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.attendance.model.RestHolidayMasterModel;

public class GenerateHolidayMasterParameter {

	// HOLIDAY LIST PARAM
		public static String addHolidayParam(RestHolidayMasterModel holidayListMaster) {
			String sqlParam = null;
			if (holidayListMaster.gettHolidayName() != null) {
				sqlParam = "@p_holidayName='" + holidayListMaster.gettHolidayName() + "',";
			}
			if (holidayListMaster.gettHolidayFromDate() != null) {
				sqlParam = sqlParam + "@p_holidayFDate='" + holidayListMaster.gettHolidayFromDate() + "',";
			}
			if (holidayListMaster.gettHolidayToDate() != null) {
				sqlParam = sqlParam + "@p_holidayTDate='" + holidayListMaster.gettHolidayToDate() + "',";
			}
			if (holidayListMaster.gettHolidayStatus() != null) {
				sqlParam = sqlParam + "@p_holidayStatus='" + holidayListMaster.gettHolidayStatus() + "',";
			}
			if (holidayListMaster.gettCompanyId() != null) {
				sqlParam = sqlParam + "@p_tCompanyId='" + holidayListMaster.gettCompanyId() + "',";
			}
			
			if (holidayListMaster.gettHolidayCreatedBy() != null) {
				sqlParam = sqlParam + "@p_createdBy='" + holidayListMaster.gettHolidayCreatedBy() + "',";
			}
			
		
			if (holidayListMaster.gettHoliday() != null) {
				sqlParam = sqlParam + "@p_holidayId='" + holidayListMaster.gettHoliday() + "',";
			}

			if (sqlParam != "") {
				sqlParam = sqlParam.substring(0, sqlParam.length() - 1);

				sqlParam = "SET " + sqlParam + ";";
			}

			return sqlParam;

		}

	}