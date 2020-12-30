package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.recruitment.model.TrainingCreationRestModel;

public class GenerateTrainingCreationParameter {
	public static String getAddTrainingParam(TrainingCreationRestModel training) {

		String s = "";

		if (training.getTrainingId() != null && training.getTrainingId() != "") {
			s = s + "@p_trainingId='" + training.getTrainingId() + "',";
		}
		if (training.getTrainingName() != null && training.getTrainingName() != "") {
			s = s + "@p_trainingName='" + training.getTrainingName() + "',";
		}
		if (training.getTrainingType() != null && training.getTrainingType() != "") {
			s = s + "@p_trainingType='" + training.getTrainingType() + "',";
		}
		if (training.getTrainingCriteria() != null && training.getTrainingCriteria() != "") {
			s = s + "@p_trainingCriteria='" + training.getTrainingCriteria() + "',";
		}
		if (training.getTrainingDesc() != null && training.getTrainingDesc() != "") {
			s = s + "@p_trainingDesc='" + training.getTrainingDesc() + "',";
		}
		if (training.getCreatedBy() != null && training.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + training.getCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

}
