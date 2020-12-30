package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.inventory.model.PhysicalVarificationWareHouseModel;



public class GeneratePhysicalVerficationParameter {
	public static String getPhyscialVerification(List<PhysicalVarificationWareHouseModel> physicalVarificationWareHouseModel) {
		String s = "";
		String litem = "";
		
		String deleteDetermination= "";
		

		for (PhysicalVarificationWareHouseModel m : physicalVarificationWareHouseModel) {
			
			//deleteDetermination = deleteDetermination + "(\""+ m.getIntiateId()+"\"),";
			litem = litem + "(\"" + m.getStoreId() + "\",\"" + m.getSubInventoryId()  + "\",\"" + m.getWareHouse() + "\",\"" + m.getRack() + "\",\"" + DateFormatter.getStringDate(m.getDate()) + "\",\""+ m.getItem() + "\",\""+ m.getDescription() + "\",\"" + m.getBarcode() + "\","+m.getPvStatus()+ ",\"" + m.getCreatedBy() + "\"),";

		}
		//deleteDetermination = deleteDetermination.substring(0, deleteDetermination.length() - 1);
		litem = litem.substring(0, litem.length() - 1);
		//s = s + "@p_deleteDetermination='" + "(" + deleteDetermination + ")" + "',";
		s = s + "@p_litemSubQuery='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);
			
			s = "SET " + s + ";";
		}
		System.out.println("s"+s);
		return s;
	}
}
