/**
 * Parameter Set for ItemRequisition Class
 */
package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.inventory.model.RestInventoryItemModel;
import nirmalya.aatithya.restmodule.inventory.model.RestItemRequisitonModel;

/**
 * @author NirmalyaLabs
 *
 */
public class GenerateInventoryItemRequisitionParameter {

	/**
	 * add parameter set for inventory itemRequisition class
	 *
	 **/
	public static String getItemRequisitionDtlParam(List<RestItemRequisitonModel> restItemRequisitonModel) {
		String s = "";
		String litem = "";
		String itemRequisition = "";
		String costCenter = "";
		String tStore = "";
		String Description = "";
		String expectedDate = "";
		String requisitionType = "";
		Boolean status = null;
		String createdBy = "";
		for (RestItemRequisitonModel m : restItemRequisitonModel) {
			itemRequisition = m.getItemRequisition();
			costCenter = m.getCostCenter();
			tStore = m.gettStore();
			Description = m.getiRDescription();
			expectedDate = DateFormatter.getStringDate(m.getiRExpectedDate());
			requisitionType = m.getiRType();
			status = m.getiRStatus();
			createdBy = m.getCreatedBy();
		}
		s = s + "@p_itemRequisition='" + itemRequisition + "',";
		s = s + "@p_costCenter='" + costCenter + "',";
		s = s + "@p_store='" + tStore + "',";
		s = s + "@p_iRDescription='" + Description + "',";
		s = s + "@p_iRExpectedDate='" + expectedDate + "',";
		s = s + "@p_iRType='" + requisitionType + "',";
		s = s + "@p_status=" + status + ",";
		s = s + "@p_createdBy='" + createdBy + "',";

		for (RestItemRequisitonModel m : restItemRequisitonModel) {

			litem = litem + "(@p_childItemRequisition,\"" + m.getDlItemCategory() + "\",\"" + m.getDlItemSubCategory()
					+ "\",\"" + m.getDlItem() + "\"," + m.getDlQty() + "),";

		}
		litem = litem.substring(0, litem.length() - 1);

		s = s + "@p_litemSubQuery='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String addItem(RestInventoryItemModel restItemModel) {
		String s = "";

		if (restItemModel.getItem() != null) {
			s = s + "@p_item='" + restItemModel.getItem() + "',";
		}
		if (restItemModel.gettAccountGroupType() != null || restItemModel.gettAccountGroupType() != "") {
			s = s + "@p_accGrpType='" + restItemModel.gettAccountGroupType() + "',";
		}
		if (restItemModel.gettPurchaseSubGroup() != null || restItemModel.gettPurchaseSubGroup() != "") {
			s = s + "@p_purchaseSubGroup='" + restItemModel.gettPurchaseSubGroup() + "',";
		}
		if (restItemModel.getTsalesSubGroup() != null || restItemModel.getTsalesSubGroup() != "") {
			s = s + "@p_salesSubGroup='" + restItemModel.getTsalesSubGroup() + "',";
		}
		if (restItemModel.getItemCategory() != null || restItemModel.getItemCategory() != "") {
			s = s + "@p_itemCategory='" + restItemModel.getItemCategory() + "',";
		}
		if (restItemModel.getItemSubCategory() != null || restItemModel.getItemSubCategory() != "") {
			s = s + "@p_itemSubCategory='" + restItemModel.getItemSubCategory() + "',";
		}
		if (restItemModel.getServeType() != null || restItemModel.getServeType() != "") {
			s = s + "@p_itemServeType='" + restItemModel.getServeType() + "',";
		}
		if (restItemModel.getItemName() != null || restItemModel.getItemName() != "") {
			s = s + "@p_itemName='" + restItemModel.getItemName() + "',";
		}
		if (restItemModel.getItemMinStock() != null) {
			s = s + "@p_itemMinStock=" + restItemModel.getItemMinStock() + ",";
		}
		if (restItemModel.getItemMaxStock() != null) {
			s = s + "@p_itemMaxStock=" + restItemModel.getItemMaxStock() + ",";
		}
		if (restItemModel.getServiceType() != null || restItemModel.getServiceType() != "") {
			s = s + "@p_serviceType='" + restItemModel.getServiceType() + "',";
		}

		if (restItemModel.getItemActive() != null) {
			s = s + "@p_itemActive=" + restItemModel.getItemActive() + ",";
		}
		if (restItemModel.getCreatedBy() != null || restItemModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restItemModel.getCreatedBy() + "',";
		}
		if (restItemModel.getSacCode() != null || restItemModel.getSacCode() != "") {
			s = s + "@p_sacCode='" + restItemModel.getSacCode() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("generate param+++++++++" + s);
		return s;

	}

}