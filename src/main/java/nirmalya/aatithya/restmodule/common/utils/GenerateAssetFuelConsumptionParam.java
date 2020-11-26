package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.asset.model.AssetFuelConsumptionModel;

public class GenerateAssetFuelConsumptionParam {
	public static String getAddFuelConsumption(AssetFuelConsumptionModel assetFuelConsumptionModel) {

		String s = "";

		if (assetFuelConsumptionModel.getCouponDate() != null && assetFuelConsumptionModel.getCouponDate() != "") {
			s = s + "@p_couponDate='" + DateFormatter.getStringDate(assetFuelConsumptionModel.getCouponDate()) + "',";
		}
		if (assetFuelConsumptionModel.getConsumptionId() != null
				&& assetFuelConsumptionModel.getConsumptionId() != "") {
			s = s + "@p_consumptionId='" + assetFuelConsumptionModel.getConsumptionId() + "',";
		}
		if (assetFuelConsumptionModel.getBranch() != null && assetFuelConsumptionModel.getBranch() != "") {
			s = s + "@p_branch='" + assetFuelConsumptionModel.getBranch() + "',";
		}
		if (assetFuelConsumptionModel.getFuel() != null && assetFuelConsumptionModel.getFuel() != " ") {
			s = s + "@p_fuel='" + assetFuelConsumptionModel.getFuel() + "',";
		}
		if (assetFuelConsumptionModel.getQuantity() != null) {
			s = s + "@p_quantity= " + assetFuelConsumptionModel.getQuantity() + " ,";
		}
		if (assetFuelConsumptionModel.getFuelSlipNumber() != null
				&& assetFuelConsumptionModel.getFuelSlipNumber() != " ") {
			s = s + "@p_fuleSlipNo='" + assetFuelConsumptionModel.getFuelSlipNumber() + "',";
		}
		if (assetFuelConsumptionModel.getTotalAmount() != null) {
			s = s + "@p_totalAmount='" + assetFuelConsumptionModel.getTotalAmount() + "',";
		}
		if (assetFuelConsumptionModel.getVechileNo() != null && assetFuelConsumptionModel.getVechileNo() != "") {
			s = s + "@p_vechileNo='" + assetFuelConsumptionModel.getVechileNo() + "',";
		}
		if (assetFuelConsumptionModel.getDriverId() != null && assetFuelConsumptionModel.getDriverId() != "") {
			s = s + "@p_driverId='" + assetFuelConsumptionModel.getDriverId() + "',";
		}
		if (assetFuelConsumptionModel.getHelper() != null && assetFuelConsumptionModel.getHelper() != "") {
			s = s + "@p_helper='" + assetFuelConsumptionModel.getHelper() + "',";
		}
		if (assetFuelConsumptionModel.getVehicleWt() != null) {
			s = s + "@p_vehicleWt=" + assetFuelConsumptionModel.getVehicleWt() + ",";
		}

		if (assetFuelConsumptionModel.getTime() != null) {
			s = s + "@p_time='" + assetFuelConsumptionModel.getTime() + "',";
		}
		if (assetFuelConsumptionModel.getRunningKm() != null) {
			s = s + "@p_runningKm= " + assetFuelConsumptionModel.getRunningKm() + " ,";
		}
		if (assetFuelConsumptionModel.getFrontHrMeter() != null) {
			s = s + "@p_frontHrMeter= " + assetFuelConsumptionModel.getFrontHrMeter() + " ,";
		}
		if (assetFuelConsumptionModel.getBackHrMeter() != null) {
			s = s + "@p_backHrMeter= " + assetFuelConsumptionModel.getBackHrMeter() + " ,";
		}
		if (assetFuelConsumptionModel.getCreatedBy() != null && assetFuelConsumptionModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + assetFuelConsumptionModel.getCreatedBy() + "',";
		}
		if (assetFuelConsumptionModel.getIsTankFuel() != null) {
			s = s + "@p_istankFull=" + assetFuelConsumptionModel.getIsTankFuel() + ",";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
}
