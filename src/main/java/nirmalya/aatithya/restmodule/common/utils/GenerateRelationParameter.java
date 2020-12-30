package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RelationModel;

public class GenerateRelationParameter {

	

	public static String getAddRelationParam(RelationModel form) {
		String s = "";

		if (form.getRelationId() != null && form.getRelationId() != "") {
			s = s + "@p_relationId='" + form.getRelationId() + "',";
		}

		if (form.getRltnName() != null && form.getRltnName() != "") {
			s = s + "@p_relationName='" + form.getRltnName() + "',";
		}
		if (form.getRltnCreatedBy() != null && form.getRltnCreatedBy() != "") {
			s = s + "@p_rltnCreatedBy='" + form.getRltnCreatedBy() + "',";
		}

		if (form.getRltnDescription() != null && form.getRltnDescription() != "") {
			s = s + "@p_rltnDescription='" + form.getRltnDescription() + "',";
		}

		if (form.getRltnActive() != null) {
			s = s + "@p_rltnActive=" + form.getRltnActive() + ",";
		}
		if (form.getIsEditable() != null) {
			s = s + "@p_isEditable=" + form.getIsEditable() + ",";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}


}
