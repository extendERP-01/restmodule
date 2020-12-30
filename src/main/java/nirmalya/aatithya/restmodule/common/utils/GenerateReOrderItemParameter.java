package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.inventory.model.ReOrderItemRestModel;

public class GenerateReOrderItemParameter {

	public static String reOrderItemParam(ReOrderItemRestModel restItemModel) {
		String s = "";
		String litem = "";
		
		if(restItemModel.getVendor()!=null && restItemModel.getVendor()!="") {
			s = s + "@p_vendor='" + restItemModel.getVendor() + "',";
		}
		if(restItemModel.getCreatedBy()!=null && restItemModel.getCreatedBy()!="") {
			s = s + "@p_created_by='" + restItemModel.getCreatedBy() + "',";
		}
		
		if(restItemModel.getItemCategory()!=null && restItemModel.getItemCategory()!="") {
			s = s + "@p_itemCategory='" + restItemModel.getItemCategory() + "',";
		}
		if(restItemModel.getSubCategory()!=null && restItemModel.getSubCategory()!="") {
			s = s + "@p_subCategory='" + restItemModel.getSubCategory() + "',";
		}
		if(restItemModel.getItemId()!=null && restItemModel.getItemId()!="") {
			s = s + "@p_item='" + restItemModel.getItemId() + "',";
		}
		if(restItemModel.getMinQty()!=null && restItemModel.getPrice()!=null) {
			s = s + "@p_orderQty=" + restItemModel.getMinQty() + ",";
			s = s + "@p_orderPrice=" + restItemModel.getPrice() + ",";
			s = s + "@p_totalAmt=" + (restItemModel.getMinQty() * restItemModel.getPrice()) + ",";
		}
		
//		for (ReOrderItemRestModel m : restItemModel) {
//
//			litem = litem + "(@p_childPurchaseOrder,\"" + m.getItemCategory() + "\",\"" + m.getSubCategory()
//					+ "\",\"" + m.getItemId() + "\",\"" + m.getMinQty() + "\",\"" + m.getPrice() + "\",\"" + m.getPrice()*m.getMinQty() + "\"),";
//
//		}

//		litem = litem.substring(0, litem.length() - 1);
//		s = s + "@p_litemSubQuery='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		
		System.out.println(s);
		
		return s;
	}

}
