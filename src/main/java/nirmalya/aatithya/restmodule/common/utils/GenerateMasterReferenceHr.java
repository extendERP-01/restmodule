package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestHrMasterModel;

public class GenerateMasterReferenceHr {
	
	public static String addJobTypeParam(RestHrMasterModel restHrMasterModel) {

	String s ="";
	
	if (restHrMasterModel.getJobTypeId() != null || restHrMasterModel.getJobTypeId() != "") {
		s = s + "@p_jobTypeId='" + restHrMasterModel.getJobTypeId() + "',";
	}
	if (restHrMasterModel.getJobTypeName() != null || restHrMasterModel.getJobTypeName() != "") {
		s = s + "@p_jobTypeName='" + restHrMasterModel.getJobTypeName() + "',";
	}
	if (restHrMasterModel.getJobTypeOrder() != null || restHrMasterModel.getJobTypeOrder() != "") {
		s = s + "@p_jobTypeOrder='" + restHrMasterModel.getJobTypeOrder() + "',";
	}
	if (restHrMasterModel.getJobTypeStatus() != null || restHrMasterModel.getJobTypeStatus() != "") {
		s = s + "@p_jobTypeStatus='" + restHrMasterModel.getJobTypeStatus() + "',";
	}
	if (restHrMasterModel.getCreatedBy() != null || restHrMasterModel.getCreatedBy() != "") {
		s = s + "@p_jobTypeCreatedBy='" + restHrMasterModel.getCreatedBy() + "',";
	}
	
	if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
	}
	System.out.println(s);
	return s;

}


}
