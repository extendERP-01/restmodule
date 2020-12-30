/*
 * generate param for assignment of seating plan
 */

package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import nirmalya.aatithya.restmodule.property.model.PropertyAssignmentOfSeatingPlanModel;

public class GenerateAssignmentOfSeatingPlanParameter {

	/*
	 * Generate PArameter for Amenity Item
	 */

	public static String getAddAssignmentSeatingParam(
			List<PropertyAssignmentOfSeatingPlanModel> propertyAssignmentOfSeatingPlan) {

		String s = "";

		String asp = "";

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		String pid = "";
		String spId = "";
		String uid = "";

		for (PropertyAssignmentOfSeatingPlanModel a : propertyAssignmentOfSeatingPlan) {

			String[] userTypeList = a.getUserType().split(",");
			String[] priceList = a.getpSplanPrice().split(",");

			
			for (int i = 0; i < userTypeList.length; i++) {
				asp = asp + "(\"" + a.getPropertyType() + "\",\"" + a.getSeatingPlan() + "\",\"" + userTypeList[i]
						+ "\",\"" + a.getpSplanCapacity() +"\",\"" +a.getsPlanImage() +"\",\""+ Float.parseFloat(priceList[i]) + "\"," + a.getpSplanActive()
						+ ",\"" + currentDate +"\",\"" + a.getCreatedBy() + "\"),";
				pid=a.getPropertyType();
				spId = a.getSeatingPlan();
				uid = userTypeList[0];
			}
		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_assignSp='" + asp + "',";
		s = s + "@p_propertyTypeId='" + pid + "',";
		s = s + "@p_seatingPlan='" + spId + "',";
		s = s + "@p_userType='" + uid + "',";
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}
}
