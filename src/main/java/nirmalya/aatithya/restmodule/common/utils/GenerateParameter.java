/**Defines SQL SET Parameters */
package nirmalya.aatithya.restmodule.common.utils;
import java.util.Random;

/**
 * @author NirmalyaLabs
 *
 */
public class GenerateParameter {

	/**
	 * returns parameter set for error class
	 **/
	public static String getSqlErrorParam(Integer code, String state, String message, String type) {

		String parameterString = "SET ";
		message = message.replace("'", "");
		String[] x = message.split(";");
		parameterString = parameterString + "@p_code='" + code + "',";
		parameterString = parameterString + "@p_state='" + state + "',";
		parameterString = parameterString + "@p_message='" + x[0] + "',";
		parameterString = parameterString + "@p_dbName='" + type + "';";

		return parameterString;
	}

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
		
		if (request.getParam5() != null) {
			s = s + "@p_param5='" + request.getParam5() + "',";
		}
		if (request.getParam6() != null) {
			s = s + "@p_param6='" + request.getParam6() + "',";
		}
		if (request.getParam7() != null) {
			s = s + "@p_param7='" + request.getParam7() + "',";
		}
		if (request.getParam8() != null) {
			s = s + "@p_param8='" + request.getParam8() + "',";
		}
		
		if (request.getUserId() != null) {
			s = s + "@p_userid='" + request.getUserId() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("param  : " + s);

		return s;
	}

}
