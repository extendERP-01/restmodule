/**
 * parameter Set for Purchase Order Class
 */
package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.inventory.model.InventorySearchPurchaseOrderModel;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryPurchaseOrderModel;

/**
 * @author NirmalyaLabs
 *
 */
public class GenerateInventoryPurchaseOrderParameter {

	  private GenerateInventoryPurchaseOrderParameter() {
		    throw new IllegalStateException("Utility class");
		  }
	/**
	 * add parameter set for inventory PurchaseOrder class
	 *
	 **/

	@SuppressWarnings("unused")
	public static String getPurchaseOrderDtlParam(
			List<RestInventoryPurchaseOrderModel> restInventoryPurchaseOrderModel) {

		String s = "";
		String litem = "";

		String purchaseOrder = "";
		String vendor = "";
		String description = "";
		Boolean status = null;
		String poStatuscheckList = "";
		String createdBy = "";
		String termsAndConditions = "";
		String porderDate = "";
		String deliveryPeriod = "";
		String store = "";

		for (RestInventoryPurchaseOrderModel m : restInventoryPurchaseOrderModel) {
			purchaseOrder = m.getPurchaseOrder();
			store = m.getStore();
			vendor = m.getVendor();
			description = m.getpODescription();
			status = m.getpOStatus();
			poStatuscheckList = m.getCheckedPoStatus();
			createdBy = m.getCreatedBy();
			termsAndConditions = m.getTermsAndConditions();
			porderDate = DateFormatter.getStringDate(m.getPorderDate());
			deliveryPeriod = DateFormatter.getStringDate(m.getDeliveryPeriod());

		}

		s = s + "@p_purchaseOrder='" + purchaseOrder + "',";
		s = s + "@p_store='" + store + "',";
		s = s + "@p_vendor='" + vendor + "',";
		s = s + "@p_description='" + description + "',";
		s = s + "@p_status=" + status + ",";
		s = s + "@p_created_by='" + createdBy + "',";
		s = s + "@p_termsAndConditions='" + termsAndConditions + "',";
		s = s + "@p_porderDate='" + porderDate + "',";
		s = s + "@p_deliveryPeriod='" + deliveryPeriod + "',";

		for (RestInventoryPurchaseOrderModel m : restInventoryPurchaseOrderModel) {

			litem = litem + "(@p_childPurchaseOrder,\"" + m.getItemCategory() + "\",\"" + m.getItemSubCategory()
					+ "\",\"" + m.getItemName() + "\",\"" + m.getpOQty() + "\",\"" + m.getPrice() + "\",\"" + m.getPrice()*m.getpOQty() + "\"),";

		}

		litem = litem.substring(0, litem.length() - 1);
		s = s + "@p_litemSubQuery='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 2);

			s = "SET " + s + "';";
		}
		System.out.println(s);
		return s;
	}

	/*
	 * Function to send two param for property type2
	 *
	 */
	public static String getsendParam(List<InventorySearchPurchaseOrderModel> table) {
		String requisition_p = "";
		String costcenter_p = "";
		String category_p = "";
		String subcategory_p = "";
		String item_p = "";
		String s = "";

		for (InventorySearchPurchaseOrderModel i : table) {
			requisition_p = i.getRequisition_p();
			costcenter_p = i.getCostcenter_p();
			category_p = i.getCategory_p();
			subcategory_p = i.getSubcategory_p();
			item_p = i.getItem_p();
		}

		s = s + "@p_requisition='" + requisition_p + "',";
		s = s + "@p_costcenter='" + costcenter_p + "',";
		s = s + "@p_category='" + category_p + "',";
		s = s + "@p_subcategory='" + subcategory_p + "',";
		s = s + "@p_item='" + item_p + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + "; ";
		}

		return s;
	}
}
