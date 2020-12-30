package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.user.model.RestProcessMasterModel;

/*
 * @author NirmalyaLabs
 *
 */
public class GenerateProcessMasterParameter {

	// Add Process Param
	public static String addProcessParam(RestProcessMasterModel processMaster) {
		String sqlParam = null;
		if (processMaster.gettProcessName() != null) {
			sqlParam = "@p_processName='" + processMaster.gettProcessName() + "',";
		}
		if (processMaster.gettProcessDescription() != null) {
			sqlParam = sqlParam + "@p_description='" + processMaster.gettProcessDescription() + "',";
		}
		if (processMaster.gettProcessStatus() != null) {

			sqlParam = sqlParam + "@p_active=" + processMaster.gettProcessStatus() + ",";
		}
		if (processMaster.gettProcessCreatedBy() != null) {
			sqlParam = sqlParam + "@p_createdBy='" + processMaster.gettProcessCreatedBy() + "',";
		}
		if (processMaster.gettProcess() != null) {
			sqlParam = sqlParam + "@p_processId='" + processMaster.gettProcess() + "',";
		}

		if (sqlParam != "") {
			sqlParam = sqlParam.substring(0, sqlParam.length() - 1);

			sqlParam = "SET " + sqlParam + ";";
		}

		return sqlParam;

	}
}
