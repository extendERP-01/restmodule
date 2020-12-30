package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.production.model.ProductionGocoolPacakgeingModel;
import nirmalya.aatithya.restmodule.production.model.ProductionPipePackagingModel;

public class GenerateProductionPackagingParam {

	public static String addPackageingParam(List<ProductionPipePackagingModel> packageDetails) {

		String s = "";
		double totalBundle = 0;
		double totalQty = 0;
		double totalWt = 0;
		String asp = "";

		for (ProductionPipePackagingModel a : packageDetails) {

			asp = asp + "(\"" + a.gettMotherCoilBatch() + "\",\"" + a.gettMotherCoilThickness() + "\",\""
					+ a.gettPipeSlitBatch() + "\",\"" + a.gettPipeSlitWidth() + "\",\"" + a.gettPipeSize() + "\",\""
					+ a.getNoOfBundles() + "\",\"" + a.getPackagingQty() + "\",\"" + a.getPackagingWt() + "\",\""
					+ a.getSlitSubGroup() + "\",\"" + a.gettPipeCreatedBy() + "\",\"" + a.getBarcodeImageName()
					+ "\",\"" + a.getBarcodeImageNumber() + "\"),";
			totalBundle = totalBundle + 1;
			totalQty = totalQty + a.getPackagingQty();
			totalWt = totalWt + a.getPackagingWt();

		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_addPacakge='" + asp + "',";
		s = s + "@p_motherCoilBatch='" + packageDetails.get(0).gettMotherCoilBatch() + "',";
		s = s + "@p_motherCoilThickness='" + packageDetails.get(0).gettMotherCoilThickness() + "',";
		s = s + "@p_tPipeSlitWidth='" + packageDetails.get(0).gettPipeSlitWidth() + "',";
		s = s + "@p_tPipeSize='" + packageDetails.get(0).gettPipeSize() + "',";
		s = s + "@p_slitBatch='" + packageDetails.get(0).gettPipeSlitBatch() + "',";
		s = s + "@p_startDate='" + DateFormatter.getStringDate(packageDetails.get(0).getPackagingStartDate()) + "',";
		s = s + "@p_endDate='" + DateFormatter.getStringDate(packageDetails.get(0).getPackagingEndDate()) + "',";
		s = s + "@p_totalBondle='" + totalBundle + "',";
		s = s + "@p_totalQty='" + totalQty + "',";
		s = s + "@p_totalWt='" + totalWt + "',";
		s = s + "@p_createdBy='" + packageDetails.get(0).gettPipeCreatedBy() + "',";
		s = s + "@p_subGroup='" + packageDetails.get(0).getSlitSubGroup() + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}

	public static String addGocoolPackageingParam(List<ProductionGocoolPacakgeingModel> packageDetails) {

		String s = "";
		double totalBundle = 0;
		double totalQty = 0;
		double totalWt = 0;
		String asp = "";

		for (ProductionGocoolPacakgeingModel a : packageDetails) {

			asp = asp + "(\"" + a.getProdId() + "\",\"" + a.getNoOfBundles() + "\",\"" + a.getPackagingQty() + "\",\""
					+ a.getPackagingWt() + "\",\"" + a.getBarcodeImageName() + "\",\"" + a.getBarcodeImageNumber()
					+ "\"),";
			totalBundle = totalBundle + 1;
			totalQty = totalQty + a.getPackagingQty();
			totalWt = totalWt + a.getPackagingWt();

		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_addPacakge='" + asp + "',";
		s = s + "@p_prodId='" + packageDetails.get(0).getProdId() + "',";
		s = s + "@p_startDate='" + DateFormatter.getStringDate(packageDetails.get(0).getPackageingStartDate()) + "',";
		s = s + "@p_endDate='" + DateFormatter.getStringDate(packageDetails.get(0).getPackageingEndtDate()) + "',";
		s = s + "@p_totalBondle='" + totalBundle + "',";
		s = s + "@p_totalQty='" + totalQty + "',";
		s = s + "@p_totalWt='" + totalWt + "',";
		s = s + "@p_createdBy='" + packageDetails.get(0).getCreatedBy() + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}

}
