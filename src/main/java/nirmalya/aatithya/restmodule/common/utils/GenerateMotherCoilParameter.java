package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.production.model.RestMotherCoilModel;

public class GenerateMotherCoilParameter {

	public static String addMotherCoilParam(List<RestMotherCoilModel> motherCoil) {

		String s = "";

		String asp = "";

		for (RestMotherCoilModel a : motherCoil) {

			asp = asp + "(\"" + a.gettMotherCoilBatch() + "\",\"" + a.gettMotherCoilThickness() + "\",\""
					+ a.gettMotherCoilGrade() + "\",\"" + a.gettPipeSlitBatch() + "\",\"" + DateFormatter.getStringDate(a.gettPipeSlitStartDate())
					+ "\",\"" + DateFormatter.getStringDate(a.gettPipeSlitEndDate()) + "\",\""
					+ a.gettPipeSlitWidth() + "\"," + a.gettPipeSlitQty() + ",\""
					+ a.gettPipeSize() + "\",\"" + a.getSlitSubGroup() + "\",\"" + a.gettPipeCreatedBy() + "\"),";

		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_assignDepnd='" + asp + "',";
		s = s + "@p_motherCoilBatch='" + motherCoil.get(0).gettMotherCoilBatch() + "',";
		s = s + "@p_motherCoilThickness='" + motherCoil.get(0).gettMotherCoilThickness() + "',";
		s = s + "@p_slitBatch='" + motherCoil.get(0).gettPipeSlitBatch() + "',";
		s = s + "@p_scrapWt='" + motherCoil.get(0).gettPipeScrapWeight() + "',";
		s = s + "@p_createdBy='" + motherCoil.get(0).gettPipeCreatedBy() + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

}
