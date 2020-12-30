/**Defines SQL SET Parameters */
package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.property.model.PropertyFloorModel;

/**
 * @author Nirmalya Labs
 *
 */
public class GenerateFloorParameter {
	/**
	 * returns parameter set for property floor class
	 **/

	public static String getAddFloorParam(PropertyFloorModel form) {
		String s = "";

		if (form.getFloorId() != null && form.getFloorId() != "") {
			s = s + "@p_floorId='" + form.getFloorId() + "',";
		}

		if (form.getFloorName() != null && form.getFloorName() != "") {
			s = s + "@p_floorName='" + form.getFloorName() + "',";
		}
		if (form.getpFloorCreatedBy() != null && form.getpFloorCreatedBy() != "") {
			s = s + "@p_pFloorCreatedBy='" + form.getpFloorCreatedBy() + "',";
		}

		if (form.getFloorDesc() != null && form.getFloorDesc() != "") {
			s = s + "@p_floorDesc='" + form.getFloorDesc() + "',";
		}

		if (form.getFloorActive() != null) {
			s = s + "@p_floorActive=" + form.getFloorActive() + ",";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

}
