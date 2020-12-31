package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.inventory.model.InventoryRequisitionModel;

public class GenerateRequisitionParam {

	/**
	 * add parameter set for inventory itemRequisition class
	 *
	 **/
	public static String getItemRequisitionDtlParam(List<InventoryRequisitionModel> restItemRequisitonModel) {
		String s = "";
		String litem = "";
		String itemRequisition = "";
		String costCenter = "";
		String tStore = "";
		String description = "";
		String expectedDate = "";
		String requisitionType = "";
		String status = null;
		String createdBy = "";
		for (InventoryRequisitionModel m : restItemRequisitonModel) {
			itemRequisition = m.getReqId();
			costCenter = m.getCostCenter();
			tStore = m.getLocation();
			description = m.getDesc();
			expectedDate = DateFormatter.getStringDate(m.getReceiveDate());
			requisitionType = m.getReqType();
			status = m.getHoldStatus();
			createdBy = m.getCreatedBy();
		}
		s = s + "@p_itemRequisition='" + itemRequisition + "',";
		s = s + "@p_costCenter='" + costCenter + "',";
		s = s + "@p_store='" + tStore + "',";
		s = s + "@p_iRDescription='" + description + "',";
		s = s + "@p_iRExpectedDate='" + expectedDate + "',";
		s = s + "@p_iRPrior='" + restItemRequisitonModel.get(0).getReqPrior() + "',";
		s = s + "@p_iRType='" + requisitionType + "',";
		s = s + "@p_status=" + status + ",";
		s = s + "@p_createdBy='" + createdBy + "',";

		for (InventoryRequisitionModel m : restItemRequisitonModel) {

			litem = litem + "(@p_childItemRequisition,\"" + m.getItemId() + "\",\"" + m.getSku() + "\",\""
					+ m.getCostCenter() + "\",\"" + m.getLocation() + "\",\"" + m.getQty() + "\",\"" + m.getLastPoDate()
					+ "\",\"" + m.getLastPurchaseUnitPrice() + "\",\"" + m.getEstimatedPrice() + "\"),";

		}
		litem = litem.substring(0, litem.length() - 1);

		s = s + "@p_litemSubQuery='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}
}
