package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.inventory.model.RestSubInventoryMasterModel;

public class GenerateSubInventoryParameter {

	public static String addSubInventory(RestSubInventoryMasterModel subInventory) {
		
		String s = "";
		
		if(subInventory.getSubInventoryId()!=null && subInventory.getSubInventoryId()!="") {
			s = s + "@p_subInv='" + subInventory.getSubInventoryId() + "',";
		}
		if(subInventory.getSubInventoryName()!=null && subInventory.getSubInventoryName()!="") {
			s = s + "@p_subInvName='" + subInventory.getSubInventoryName() + "',";
		}
		if(subInventory.getStore()!=null && subInventory.getStore()!="") {
			s = s + "@p_subInvStore='" + subInventory.getStore() + "',";
		}
		if(subInventory.getSubInvDesc()!=null && subInventory.getSubInvDesc()!="") {
			s = s + "@p_subInvDesc='" + subInventory.getSubInvDesc() + "',";
		}
		if(subInventory.getSubInvActive()!=null && subInventory.getSubInvActive()!="") {
			s = s + "@p_subInvActive='" + subInventory.getSubInvActive() + "',";
		}
		if(subInventory.getCreatedBy()!=null && subInventory.getCreatedBy()!="") {
			s = s + "@p_createdBy='" + subInventory.getCreatedBy() + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);
			s = "SET " + s + ";";
		}
		
		System.out.println(s);
		
		return s;
	}

}
