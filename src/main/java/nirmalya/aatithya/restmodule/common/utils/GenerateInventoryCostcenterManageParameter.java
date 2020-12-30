package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.inventory.model.InventoryManageCostcenterModel;

public class GenerateInventoryCostcenterManageParameter {
	/*
	 * Generate PArameter for Amenity Item
	 */

	public static String getAddManageCostCenter(InventoryManageCostcenterModel inventoryManageCostcenterModel) {

		String s = "";
		String acn = "";
	  

		String costCenter = inventoryManageCostcenterModel.getCostCenterName();
		
		String description = inventoryManageCostcenterModel.getDescription();
		String createdBy = inventoryManageCostcenterModel.getCreatedBy();
		
		s = s + "@P_CostCenter_name='" + costCenter + "',";
		s = s + "@P_CostCenter_description='" + description + "',";
		s = s + "@P_createdBy='" + createdBy + "',";
		
		if(inventoryManageCostcenterModel.getCostcenterId() !=null || inventoryManageCostcenterModel.getCostcenterId() !="")
		{
			s = s + "@P_CostCenterid='" + inventoryManageCostcenterModel.getCostcenterId() +"',"; 
			
			
		}
		
		String[] categoryList = inventoryManageCostcenterModel.getPropertyCategoryName().split(",");
		for (int i = 0; i < categoryList.length; i++) {
			acn = acn + "(@P_CostCenter_id,\"" +categoryList[i]+"\",\""+ createdBy +"\"),";
		}
				
		if (acn != "") {
			acn = acn.substring(0, acn.length() - 1);
			acn = acn+"";
		}
		s = s + "@P_subQuery='"+acn+"'," ;
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
	

}
