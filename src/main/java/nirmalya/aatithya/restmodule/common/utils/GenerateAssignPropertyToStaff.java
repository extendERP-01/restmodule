package nirmalya.aatithya.restmodule.common.utils;


import nirmalya.aatithya.restmodule.property.model.PropertyAssignPropertyToStaffModel;


public class GenerateAssignPropertyToStaff {

	
	/**
	 * returns parameter set for assign property to staffs
	 **/
	
	
	public static String getAssignPropertyParam(PropertyAssignPropertyToStaffModel propertyAssignPropertyToStaffModel) {

		String s = "";
		if (propertyAssignPropertyToStaffModel.getCostCenter() != null && propertyAssignPropertyToStaffModel.getCostCenter() != "") {

			String costCenter = propertyAssignPropertyToStaffModel.getCostCenter();
			String userRole = propertyAssignPropertyToStaffModel.getUserRole();
			String user = propertyAssignPropertyToStaffModel.getUser();
			Boolean status = propertyAssignPropertyToStaffModel.getSatffActive();
			String createdBy = propertyAssignPropertyToStaffModel.getCreatedBy();

			String ac = "";
			String acn = "";

			String[] acList = propertyAssignPropertyToStaffModel.getPropertyListNames().split(",");
			acn = acn + "(";
			for (int i = 0; i < acList.length; i++) {
				ac = ac + "(\"" + costCenter + "\",\"" + userRole + "\",\"" + user + "\",\"" + acList[i] + "\"," + status +",\""+createdBy+ "\"),";
				//acn = acn + "\"" + acList[i] + "\",";
			}
			ac = ac.substring(0, ac.length() - 1);

			s = s + "@p_assignvalues='" + ac + "',";

			acn = acn.substring(0, acn.length() - 1);

			acn = acn + ")";

			//s = s + "@p_assetCodesId='" + acn + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
	
}
