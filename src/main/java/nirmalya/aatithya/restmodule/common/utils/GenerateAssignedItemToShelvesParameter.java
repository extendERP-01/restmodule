package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.inventory.model.RackShelvesRestModel;

public class GenerateAssignedItemToShelvesParameter {

	public static String assignItem(List<RackShelvesRestModel> assigneItem) {
		
		String s = "";
		String item = "";
		
		if(assigneItem.get(0).getRackId()!=null && assigneItem.get(0).getRackId()!="") {
			s = s + "@p_rackId='" + assigneItem.get(0).getRackId() + "',";
		}
		if(assigneItem.get(0).getStore()!=null && assigneItem.get(0).getStore()!="") {
			s = s + "@p_rackStore='" + assigneItem.get(0).getStore() + "',";
		}
		if(assigneItem.get(0).getSubInventory()!=null && assigneItem.get(0).getSubInventory()!="") {
			s = s + "@p_rackSubInv='" + assigneItem.get(0).getSubInventory() + "',";
		}
		if(assigneItem.get(0).getWarehouse()!=null && assigneItem.get(0).getWarehouse()!="") {
			s = s + "@p_rackWarehouse='" + assigneItem.get(0).getWarehouse() + "',";
		}
		if(assigneItem.get(0).getRackName()!=null && assigneItem.get(0).getRackName()!="") {
			s = s + "@p_rackName='" + assigneItem.get(0).getRackName() + "',";
		}
		if(assigneItem.get(0).getCreatedBy()!=null && assigneItem.get(0).getCreatedBy()!="") {
			s = s + "@p_createdBy='" + assigneItem.get(0).getCreatedBy() + "',";
		}
		if(assigneItem.get(0).getShelvesCapacity()!=null) {
			s = s + "@p_shelvesCapacity=" + assigneItem.get(0).getShelvesCapacity() + ",";
		}
		
		for(RackShelvesRestModel m : assigneItem) {
			item = item + "(\"" + m.getStore() + "\",\"" + m.getSubInventory() + "\",\"" + m.getWarehouse() + 
					"\",@p_rackId,\"" + m.getShelf() + "\",\"" + m.getItemId() + "\"," + m.getItemCapacity() + ",\"" + m.getSlNo() + "\"),";
		}
		
		item = item.substring(0, item.length() - 1);
		
		s = s + "@p_assignedItemSubQuery='" + item + "',";
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);
			s = "SET " + s + ";";
		}
		
		System.out.println(s);
		
		return s;
	}

}
