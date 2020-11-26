package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestServiceMasterModel;

public class GenerateServiceMasterParameter {
	// SERVICE MASTER PARAM
	public static String addServiceParam(RestServiceMasterModel serviceMaster) {
		String sqlParam = null;
		if (serviceMaster.gettServiceName() != null) {
			sqlParam = "@p_serviceName='" + serviceMaster.gettServiceName() + "',";
		}
		if (serviceMaster.gettServiceDesc() != null) {
			sqlParam = sqlParam + "@p_serviceDesc='" + serviceMaster.gettServiceDesc() + "',";
		}

		if (serviceMaster.gettServiceStatus() != null) {
			sqlParam = sqlParam + "@p_serviceStatus=" + serviceMaster.gettServiceStatus() + ",";
		}

		if (serviceMaster.gettCreatedBy() != null) {
			sqlParam = sqlParam + "@p_createdBy='" + serviceMaster.gettCreatedBy() + "',";
		}

		if (serviceMaster.gettServiceId() != null) {
			sqlParam = sqlParam + "@p_serviceId='" + serviceMaster.gettServiceId() + "',";
		}

		if (sqlParam != "") {
			sqlParam = sqlParam.substring(0, sqlParam.length() - 1);

			sqlParam = "SET " + sqlParam + ";";
		}

		return sqlParam;

	}
}
