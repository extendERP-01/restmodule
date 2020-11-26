/**Defines SQL SET Parameters for user role */
package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.user.model.UserRoleModel;

/**
 * @author Nirmalya Labs
 *
 */
public class GenerateUserRoleParameter {

	public static String getAddUserRoleParam(List<UserRoleModel> table) {
		String userRoleId = "";
		String userRoleName = "";
		String userParentUserRole = "";
		String userDescription = "";
		String userCostCenter = "";
		// Byte userType =null;
		Boolean userRoleStatus = null;
		String childItem = "";
		String s = "";
		String createdBy = "";
		for (UserRoleModel i : table) {
			userRoleId = i.getUserRoleId();
			userRoleName = i.getUserRoleName();
			// userType = i.getUserType();
			userParentUserRole = i.getUserParentUserRole();
			userCostCenter = i.getUserCostCenter();
			userDescription = i.getUserDescription();
			userRoleStatus = i.getUserRoleStatus();
			createdBy = i.getCreatedBy();
		}
		s = s + "@p_userroleId='" + userRoleId + "',";
		s = s + "@p_userRoleName='" + userRoleName + "',";
		s = s + "@p_userParentUserRole='" + userParentUserRole + "',";
		s = s + "@p_userCostCenter='" + userCostCenter + "',";
		s = s + "@p_userDescription='" + userDescription + "',";
		s = s + "@p_userRoleStatus=" + userRoleStatus + ",";
		s = s + "@p_createdBy='" + createdBy + "',";

		for (UserRoleModel i : table) {
			childItem = childItem + "(@p_roleMasterId,\"" + i.getModuleId() + "\",\"" + i.getFunctionId() + "\",\""
					+ i.getActivityId() + "\"),";
		}

		childItem = childItem.substring(0, childItem.length() - 1);

		s = s + "@p_childSubquery='" + childItem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String getSearchParam(DataTableRequest request) {

		String s = "";

		if (request.getStart() != null) {
			s = s + "@p_start=" + request.getStart() + ",";
		}

		if (request.getLength() != null) {
			s = s + "@p_length=" + request.getLength() + ",";
		}

		if (request.getSearch() != null) {
			s = s + "@p_search='" + request.getSearch() + "',";
		}

		if (request.getParam1() != null) {
			s = s + "@p_param1='" + request.getParam1() + "',";
		}

		if (request.getParam2() != null) {
			s = s + "@p_param2='" + request.getParam2() + "',";
		}

		if (request.getParam3() != null) {
			s = s + "@p_param3='" + request.getParam3() + "',";
		}

		if (request.getParam4() != null) {
			s = s + "@p_param4='" + request.getParam4() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

}
