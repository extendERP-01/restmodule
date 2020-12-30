package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.recruitment.model.AddTrainingPlanningRestModel;

public class GeneratetrainningPlanningParameter {
	public static String getAddtrainningplanningParam(List<AddTrainingPlanningRestModel> AddTrainingPlanningRestModel) {

		String s = "";

		String asp = "";
		String pid = "";

		for (AddTrainingPlanningRestModel a : AddTrainingPlanningRestModel) {

			asp = asp + "(@p_trainningId,\"" + a.getTranningName() + "\",\"" + a.getTranningType() + "\",\""
					+ DateFormatter.getStringDate(a.getStartDate()) + "\",\""
					+ DateFormatter.getStringDate(a.getEndDate()) + "\"," + a.getStatus() + ",\"" + a.getCreatedBy()
					+ "\"),";
			pid = a.getTrainningId();

		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_addtrainingId='" + asp + "',";

		s = s + "@p_trainningId='" + pid + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}

}
