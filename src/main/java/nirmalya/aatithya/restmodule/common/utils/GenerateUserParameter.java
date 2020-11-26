package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.user.model.User;
import nirmalya.aatithya.restmodule.user.model.UserModel; 

/**
 * @author Nirmalya Labs
 *
 */
public class GenerateUserParameter {

	/**
	 * returns parameter set for DataTableRequest class
	 **/
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

		//System.out.println("param  : " + s);

		return s;
	}

	/**
	 * Returns parameterized values for User Class
	 */
	public static String getUserParam(User user) {

		String parameterString = "";

		if (user.getUser() != null) {
			parameterString = parameterString + "@p_user='" + user.getUser() + "',";
		}

		if (user.getUserName() != null) {
			parameterString = parameterString + "@p_userName='" + user.getUserName() + "',";
		}

		if (user.getUserPassword() != null) {
			parameterString = parameterString + "@p_userPassword='" + user.getUserPassword() + "',";
		}

		if (user.getUserMobile() != null) {
			parameterString = parameterString + "@p_userMobile='" + user.getUserMobile() + "',";
		}

		if (user.getUserEmail() != null) {
			parameterString = parameterString + "@p_userEmail='" + user.getUserEmail() + "',";
		}

		if (user.getUserParent() != null) {
			parameterString = parameterString + "@p_userParent='" + user.getUserParent() + "',";
		}

		if (user.getUserAddress() != null) {
			parameterString = parameterString + "@p_userAddress='" + user.getUserAddress() + "',";
		}

		if (user.getUserState() != null) {
			parameterString = parameterString + "@p_userState='" + user.getUserState() + "',";
		}

		if (user.getUserCountry() != null) {
			parameterString = parameterString + "@p_userCountry='" + user.getUserCountry() + "',";
		}

		if (user.getUserDist() != null) {
			parameterString = parameterString + "@p_userDist='" + user.getUserDist() + "',";
		}

		if (user.getUserPin() != null) {
			parameterString = parameterString + "@p_userPin='" + user.getUserPin() + "',";
		}

		if (user.getUserStatus() != null) {
			parameterString = parameterString + "@p_userStatus=" + user.getUserStatus() + ",";
		}
		//parameterString = parameterString + "@p_createdBy='" + user.getCreatedBy() + "',";

		if (parameterString != "") {
			parameterString = parameterString.substring(0, parameterString.length() - 1);

			parameterString = "SET " + parameterString + ";";
		}

		return parameterString;
	}

	/**
	 * Returns parameterized values for User View
	 */
 
	/**
	 * ADD USER MANAGEMENT
	 */
	public static String getAddUserParam(UserModel form) {

		String s = "";

		if (form.getUser() != null && form.getUser() != "") {
			s = s + "@p_user='" + form.getUser() + "',";
		}

		if (form.getUserName() != null && form.getUserName() != "") {
			s = s + "@p_userName='" + form.getUserName() + "',";
		}
		
		if (form.getUserLname() != null && form.getUserLname() != "") {
			s = s + "@p_userLastName='" + form.getUserLname() + "',";
		}

		if (form.getUserType() != null && form.getUserType() != "") {
			s = s + "@p_userType='" + form.getUserType() + "',";
		}

		if (form.getUserPassword() != null && form.getUserPassword() != "") {
			s = s + "@p_userPassword='" + form.getUserPassword() + "',";
		}

		if (form.getUserPINno() != null && form.getUserPINno() != "") {
			s = s + "@p_userPINno='" + form.getUserPINno() + "',";
		}

		if (form.getUserMobile() != null && form.getUserMobile() != "") {
			s = s + "@p_userMobile='" + form.getUserMobile() + "',";
		}

		if (form.getUserEmail() != null && form.getUserEmail() != "") {
			s = s + "@p_userEmail='" + form.getUserEmail() + "',";
		}

		if (form.getUserIMEI() != null && form.getUserIMEI() != "") {
			s = s + "@p_userIMEI='" + form.getUserIMEI() + "',";
		}

		if (form.getUserAddress() != null && form.getUserAddress() != "") {
			s = s + "@p_userAddress='" + form.getUserAddress() + "',";
		}

		if (form.getUserState() != null && form.getUserState() != "") {
			s = s + "@p_userState='" + form.getUserState() + "',";
		}

		if (form.getUserCountry() != null && form.getUserCountry() != "") {
			s = s + "@p_userCountry='" + form.getUserCountry() + "',";
		}

		if (form.getUserDist() != null && form.getUserDist() != "") {
			s = s + "@p_userDist='" + form.getUserDist() + "',";
		}

		if (form.getUserPin() != null && form.getUserPin() != "") {
			s = s + "@p_userPin='" + form.getUserPin() + "',";
		}
		
		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";
		}

		if (form.getUserRole() != null && form.getUserRole() != "") {

			// s = s + "@p_userRole='" + form.getUserRole() + "',";

			String am = "";

			String[] amList = form.getUserRole().split(",");

			for (int i = 0; i < amList.length; i++) {

				am = am + "(@PrtId,\"" + amList[i] + "\"),";
			}

			am = am.substring(0, am.length() - 1);

			s = s + "@p_userRole='" + am + "',";
		}

		s = s + "@p_userStatus=" + form.getUserStatus() + ",";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		 System.out.println("S in generate parameter-----------------"+s);
		return s;
	}

}
