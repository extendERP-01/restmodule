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
		String moduleId = "";
		String componentId = "";
		String subCmponentId = "";
		String description = "";
		String expectedDate = "";
		String requisitionType = "";
		String status = null;
		String createdBy = "";
		for (InventoryRequisitionModel m : restItemRequisitonModel) {
			itemRequisition = m.getReqId();
			moduleId = m.getModuleId();
			componentId = m.getComponentId();
			subCmponentId = m.getSubComponentId();
			description = m.getDesc();
			expectedDate = DateFormatter.getStringDate(m.getReceiveDate());
			requisitionType = m.getReqType();
			status = m.getHoldStatus();
			createdBy = m.getCreatedBy();
		}
		s = s + "@p_itemRequisition='" + itemRequisition + "',";

		s = s + "@p_iRDescription='" + description + "',";
		s = s + "@p_receiveDate='" + expectedDate + "',";
		s = s + "@p_iRPrior='" + restItemRequisitonModel.get(0).getReqPrior() + "',";
		s = s + "@p_iRType='" + requisitionType + "',";
		s = s + "@p_status=" + status + ",";
		s = s + "@p_moduleId='" + moduleId + "',";
		s = s + "@p_componentId='" + componentId + "',";
		s = s + "@p_subCmponentId='" + subCmponentId + "',";
		s = s + "@p_createdBy='" + createdBy + "',";

		for (InventoryRequisitionModel m : restItemRequisitonModel) {

			litem = litem + "(@p_itemRequisition,\"" + m.getItemId() + "\",\"" + m.getSku() + "\",\""
					+ m.getCostCenterId() + "\",\"" + m.getLocationId() + "\",\"" + m.getQty() + "\",\"" + m.getUomId()
					+ "\",\"" + m.getLastPurchaseTotalPrice() + "\",\"" + m.getLastPurchaseUnitPrice() + "\",\""
					+ m.getEstimatedTotalPrice() + "\",\"" + m.getEstimatedPrice() + "\",\"" + m.getCreatedBy()
					+ "\"),";

		}
		litem = litem.substring(0, litem.length() - 1);

		s = s + "@p_litemSubQuery='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String getDeleteApproveParam(InventoryRequisitionModel restItemRequisitonModel) {
		String[] userIds = restItemRequisitonModel.getReqId().split(",");
		String s = "";
		String litem = "";
		String act = "";
		for (String a : userIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")"; 
		s = s + "@p_reqIds='" + litem + "',";

		for (String a : userIds) {

			act = act + "(\"" + restItemRequisitonModel.getModuleId() + "\",\"" + restItemRequisitonModel.getComponentId()
					+ "\",\"" + restItemRequisitonModel.getSubComponentId() + "\",\"" + a + "\",\""
					+ "Delete Requisition" + "\",\"" + restItemRequisitonModel.getCreatedBy() + "\"),";

		}
		act = act.substring(0, act.length() - 1);

		s = s + "@p_actSubQuery='" + act + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}
}
