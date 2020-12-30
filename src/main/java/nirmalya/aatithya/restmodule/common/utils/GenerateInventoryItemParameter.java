/**
 * Parameter set for Item In Inventory
 */
package nirmalya.aatithya.restmodule.common.utils;
 
import java.util.List;

import nirmalya.aatithya.restmodule.inventory.model.RestInventoryItemModel;

/**
 * @author NirmalyaLabs
 *
 */
public class GenerateInventoryItemParameter {

	/**
	 * add parameter set for inventory item class
	 *
	 **/
	public static String addItemParam(List<RestInventoryItemModel> restItemModel) {
		String s = "";

		if (restItemModel.get(0).getItem() != null) {
			s = s + "@p_item='" + restItemModel.get(0).getItem() + "',";
		}
		if (restItemModel.get(0).gettAccountGroupType() != null || restItemModel.get(0).gettAccountGroupType() != "") {
			s = s + "@p_accGrpType='" + restItemModel.get(0).gettAccountGroupType() + "',";
		}
		if (restItemModel.get(0).gettPurchaseSubGroup() != null || restItemModel.get(0).gettPurchaseSubGroup() != "") {
			s = s + "@p_purchaseSubGroup='" + restItemModel.get(0).gettPurchaseSubGroup() + "',";
		}
		if (restItemModel.get(0).getTsalesSubGroup() != null || restItemModel.get(0).getTsalesSubGroup() != "") {
			s = s + "@p_salesSubGroup='" + restItemModel.get(0).getTsalesSubGroup() + "',";
		}
		if (restItemModel.get(0).getItemCategory() != null || restItemModel.get(0).getItemCategory() != "") {
			s = s + "@p_itemCategory='" + restItemModel.get(0).getItemCategory() + "',";
		}
		if (restItemModel.get(0).getItemSubCategory() != null || restItemModel.get(0).getItemSubCategory() != "") {
			s = s + "@p_itemSubCategory='" + restItemModel.get(0).getItemSubCategory() + "',";
		}
		if (restItemModel.get(0).getServeType() != null || restItemModel.get(0).getServeType() != "") {
			s = s + "@p_itemServeType='" + restItemModel.get(0).getServeType() + "',";
		}
		if (restItemModel.get(0).getItemName() != null || restItemModel.get(0).getItemName() != "") {
			s = s + "@p_itemName='" + restItemModel.get(0).getItemName() + "',";
		}
		if (restItemModel.get(0).getItemMinStock() != null) {
			s = s + "@p_itemMinStock=" + restItemModel.get(0).getItemMinStock() + ",";
		}
		if (restItemModel.get(0).getItemMaxStock() != null) {
			s = s + "@p_itemMaxStock=" + restItemModel.get(0).getItemMaxStock() + ",";
		}
		if (restItemModel.get(0).getServiceType() != null || restItemModel.get(0).getServiceType() != "") {
			s = s + "@p_serviceType='" + restItemModel.get(0).getServiceType() + "',";
		}
		if (restItemModel.get(0).getSacCode() != null || restItemModel.get(0).getSacCode() != "") {
			s = s + "@p_sacCode='" + restItemModel.get(0).getSacCode() + "',";
		}

		if (restItemModel.get(0).getItemActive() != null) {
			s = s + "@p_itemActive=" + restItemModel.get(0).getItemActive() + ",";
		}
		if (restItemModel.get(0).getCreatedBy() != null || restItemModel.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restItemModel.get(0).getCreatedBy() + "',";
		}
		 
		if (restItemModel.get(0).getProductionTypeId() != null || restItemModel.get(0).getProductionTypeId() != "") {
			s = s + "@p_itemProdctnType='" + restItemModel.get(0).getProductionTypeId() + "',";
		}
		if (restItemModel.get(0).getItemImg() != null || restItemModel.get(0).getItemImg() != "") {
			s = s + "@p_itemImg='" + restItemModel.get(0).getItemImg() + "',";
		}
		 
		if (restItemModel.get(0).getPrice() != null  ) {
			s = s + "@p_price='" + restItemModel.get(0).getPrice() + "',";
		}
		
		if (restItemModel.get(0).getSalesPrice() != null  ) {
			s = s + "@p_salesPrice='" + restItemModel.get(0).getSalesPrice() + "',";
		}
		
		if (restItemModel.get(0).getHsnCode() != null || restItemModel.get(0).getHsnCode() != "") {
			s = s + "@p_itemHSNCode='" + restItemModel.get(0).getHsnCode() + "',";
		}
		if (restItemModel.get(0).getPurchaseTAX() != null) {
			s = s + "@p_itemPurchaseTAX=" + restItemModel.get(0).getPurchaseTAX() + ",";
		}
		if (restItemModel.get(0).getPurchaseCess() != null) {
			s = s + "@p_itemPurchaseCess=" + restItemModel.get(0).getPurchaseCess() + ",";
		}
		if (restItemModel.get(0).getSaleTAX() != null) {
			s = s + "@p_itemSaleTAX=" + restItemModel.get(0).getSaleTAX() + ",";
		}
		if (restItemModel.get(0).getSaleCess() != null) {
			s = s + "@p_itemSaleCess=" + restItemModel.get(0).getSaleCess() + ",";
		}
		
		/*
		 * String qtys = ""; for (RestInventoryItemModel a :restItemModel) { qtys = qtys
		 * + "(@p_item,\"" + a.getItemQty() + "\",\"" + a.getPrice() + "\"),"; } qtys =
		 * qtys.substring(0, qtys.length() - 1); s = s + "@p_qtys='" + qtys + "',";
		 */
		
		
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
        System.out.println(s);
		return s;

	}

	/**
	 * search parameter set for inventory Item
	 **/

	public static String getItemSearchParam(DataTableRequest request) {

		String s = "";

		if (request.getStart() != null) {
			s = s + "@p_start=" + request.getStart() + ",";
		}

		if (request.getLength() != null) {
			s = s + "@p_length=" + request.getLength() + ",";
		}

		if (request.getSearch() != null) {
			s = s + "@p_search='" + request.getSearch() + "',";
		}

		if (request.getParam1() != null) {
			s = s + "@p_param1='" + request.getParam1() + "',";
		}

		if (request.getParam2() != null) {
			s = s + "@p_param2='" + request.getParam2() + "',";
		}

		if (request.getParam3() != null) {
			s = s + "@p_param3='" + request.getParam3() + "',";
		}

		if (request.getParam4() != null) {
			s = s + "@p_param4='" + request.getParam4() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

}
