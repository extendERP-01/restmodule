
/**Defines SQL SET Parameters for Leave period */
package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.leave.model.RestLeaveApplyModel;
import nirmalya.aatithya.restmodule.leave.model.RestLeaveEmpEntitleModel;

/**
 * @author Nirmalya Labs
 *
 */
public class GenerateLeaveApplyParameter {
	public static String getApplyLeaveParam(List<RestLeaveApplyModel> table) {

		String s = "";

		String qItem = "";

		if (table.get(0).getApplyId() != null && table.get(0).getApplyId() != "") {
			s = s + "@p_leavId='" + table.get(0).getApplyId() + "',";
		}
		s = s + "@p_empId='" + table.get(0).getEmpName() + "',";
		s = s + "@p_lapplyDate='" + DateFormatter.getStringDate(table.get(0).getlApplyDate()) + "',";
		s = s + "@p_createdBy='" + table.get(0).getCreatedBy() + "',";
		for (RestLeaveApplyModel m : table) {
			qItem = qItem + "(@p_leavId,\"" + m.getLtypeName() + "\",\""
					+ DateFormatter.getStringDate(m.getlApplyStartDate()) + "\",\""
					+ DateFormatter.getStringDate(m.getlApplyEndDate()) + "\",\"" + m.getlReason() + "\","
					+ m.getTotalLeave() + ",\"" + m.getCreatedBy() + "\"),";
		}

		qItem = qItem.substring(0, qItem.length() - 1);

		s = s + "@p_subQuery='" + qItem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		// System.out.println(s);

		return s;
	}

	/*
	 * Function to send two param for property type2
	 *
	 */
	public static String getsendParam(List<RestLeaveEmpEntitleModel> table) {
		String param1 = "";
		String param2 = "";
		String s = "";

		for (RestLeaveEmpEntitleModel i : table) {
			param1 = i.getLeaveTypeName();
			param2 = i.getEmpl();
			
			//System.out.println("@@@@"+param1);
			//System.out.println("####"+param2);
			
		}
		
		s = s + "@p_param1='" + param1 + "',";
		s = s + "@p_param2='" + param2 + "',";
		
		//System.out.println("$$$$"+s);

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		// System.out.println("data in generate parameter for Leave
		// list--------------------------" + s);
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

		System.out.println("param  : " + s);

		return s;
	}

}
