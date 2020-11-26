package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.inventory.model.WarehouseMasterRestModel;

public class GenerateWarehouseParameter {

	public static String addWarehouse(WarehouseMasterRestModel warehouse) {
		
		String s = "";
		
		if(warehouse.getWarehouseId()!=null && warehouse.getWarehouseId()!="") {
			s = s + "@p_warehouse='" + warehouse.getWarehouseId() + "',";
		}
		if(warehouse.getWarehouseName()!=null && warehouse.getWarehouseName()!="") {
			s = s + "@p_warehouseName='" + warehouse.getWarehouseName() + "',";
		}
		if(warehouse.getStore()!=null && warehouse.getStore()!="") {
			s = s + "@p_warehouseStore='" + warehouse.getStore() + "',";
		}
		if(warehouse.getSubInventory()!=null && warehouse.getSubInventory()!="") {
			s = s + "@p_warehouseSubInv='" + warehouse.getSubInventory() + "',";
		}
		if(warehouse.getWhDesc()!=null && warehouse.getWhDesc()!="") {
			s = s + "@p_warehouseDesc='" + warehouse.getWhDesc() + "',";
		}
		if(warehouse.getWhActive()!=null && warehouse.getWhActive()!="") {
			s = s + "@p_warehouseStatus='" + warehouse.getWhActive() + "',";
		}
		if(warehouse.getCreatedBy()!=null && warehouse.getCreatedBy()!="") {
			s = s + "@p_warehouseCreatedBy='" + warehouse.getCreatedBy() + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);
			s = "SET " + s + ";";
		}
		
		System.out.println(s);
		
		return s;
	}

}
