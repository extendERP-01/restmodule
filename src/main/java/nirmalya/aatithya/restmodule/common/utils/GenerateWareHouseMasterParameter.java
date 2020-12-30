package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.ZoneMasterModel;
import nirmalya.aatithya.restmodule.master.model.ZoneRackModel;

public class GenerateWareHouseMasterParameter {
	public static String saveZoneMaster(ZoneMasterModel zoneMasterModel) {

		String s = "";

		if (zoneMasterModel.getZoneId() != null && zoneMasterModel.getZoneId() != "") {
			s = s + "@p_zoneId='" + zoneMasterModel.getZoneId() + "',";
		}
		if (zoneMasterModel.getWarehouseId() != null && zoneMasterModel.getWarehouseId() != "") {
			s = s + "@p_warehouseId='" + zoneMasterModel.getWarehouseId() + "',";
		}
		if (zoneMasterModel.getZoneName() != null && zoneMasterModel.getZoneName() != "") {
			s = s + "@p_zoneName='" + zoneMasterModel.getZoneName() + "',";
		}
		if (zoneMasterModel.getZoneCode() != null && zoneMasterModel.getZoneCode() != "") {
			s = s + "@p_zoneCode='" + zoneMasterModel.getZoneCode() + "',";
		}
		if (zoneMasterModel.getZoneSlNo() != null) {
			s = s + "@p_slNo=" + zoneMasterModel.getZoneSlNo() + ",";
		}
		if (zoneMasterModel.getCreatedBy() != null && zoneMasterModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + zoneMasterModel.getCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

	public static String saveRackMaster(ZoneRackModel zoneRackModel) {

		String s = "";

		if (zoneRackModel.getRackId() != null && zoneRackModel.getRackId() != "") {
			s = s + "@p_rackId='" + zoneRackModel.getRackId() + "',";
		}
		if (zoneRackModel.getWarehouseId() != null && zoneRackModel.getWarehouseId() != "") {
			s = s + "@p_warehouseId='" + zoneRackModel.getWarehouseId() + "',";
		}
		if (zoneRackModel.getZoneId() != null && zoneRackModel.getZoneId() != "") {
			s = s + "@p_zoneId='" + zoneRackModel.getZoneId() + "',";
		}
		if (zoneRackModel.getRackName() != null && zoneRackModel.getRackName() != "") {
			s = s + "@p_rackName='" + zoneRackModel.getRackName() + "',";
		}
		if (zoneRackModel.getRackSlNo() != null) {
			s = s + "@p_rackslNo=" + zoneRackModel.getRackSlNo() + ",";
		}
		if (zoneRackModel.getCreatedBy() != null && zoneRackModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + zoneRackModel.getCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

}
