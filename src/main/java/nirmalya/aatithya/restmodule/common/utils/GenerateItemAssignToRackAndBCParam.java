package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.inventory.model.AllocateItemsToRackModel;

public class GenerateItemAssignToRackAndBCParam {

	public static String getSaveParam(List<AllocateItemsToRackModel> batch) {
		String s = "";
		String litem = "";
		
		System.out.println("batch " + batch);

		for (AllocateItemsToRackModel m : batch) {
			litem = litem + "(\"" + m.getPoNo() + "\",\"" + m.getGrn() + "\",\"" + m.getItemId() + "\","
					+ m.getQuantity() + ",\"" + m.getStoreId() + "\",\"" + m.getSubInventoryId() + "\",\""
					+ m.getWareHouseId() + "\",\"" + m.getRackId() + "\",\"" + m.getShelfName() + "\","
					+ m.getInspQuantity() + ",\"" + m.getCratedBy() + "\"),";
		}
		litem = litem.substring(0, litem.length() - 1);
		s = s + "@p_allocateSubQuery='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

	public static String getSaveBarcodeParam(List<AllocateItemsToRackModel> batch) {
		String s = "";
		String litem = "";

		for (AllocateItemsToRackModel m : batch) {
			litem = litem + "(@p_barcodeId,\"" + m.getPoNo() + "\",\"" + m.getGrn() + "\",\"" + m.getItemId() + "\",\""
					+ m.getStoreId() + "\",\"" + m.getSubInventoryId() + "\",\"" + m.getWareHouseId() + "\",\""
					+ m.getRackId() + "\",\"" + m.getShelfName() + "\",\""+ m.getBarcodeNo() +  "\",\""
					+ m.getBarCodeImageName() + "\",\"" + m.getCratedBy() + "\"),";
		}
		litem = litem.substring(0, litem.length() - 1);
		s = s + "@p_barcodeSubQuery='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

	
	
	public static String getBarcodeParam(List<AllocateItemsToRackModel> batch) {
		String s = "";
		String litem = "";

		if(batch.get(0).getPoNo()!=null)
		{
			s = s + "@p_poNo='" + batch.get(0).getPoNo() + "',";
		}
		if(batch.get(0).getGrn()!=null)
		{
			s = s + "@p_grnNo='" + batch.get(0).getGrn() + "',";
		}
		if(batch.get(0).getSubInventoryId()!=null)
		{
			s = s + "@p_subInvId='" + batch.get(0).getSubInventoryId() + "',";
		}
		if(batch.get(0).getStoreId()!=null)
		{
			s = s + "@p_storeId='" + batch.get(0).getStoreId() + "',";
		}
		if(batch.get(0).getWareHouseId()!=null)
		{
			s = s + "@p_whId='" + batch.get(0).getWareHouseId() + "',";
		}
		if(batch.get(0).getItemId()!=null)
		{
			s = s + "@p_itemId='" + batch.get(0).getItemId() + "',";
		}
		if(batch.get(0).getRackId()!=null)
		{
			s = s + "@p_rackId='" + batch.get(0).getRackId() + "',";
		}
		for (AllocateItemsToRackModel m : batch) {
			litem = litem +"\"" +  m.getShelfName() + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		s = s + "@p_barcodeSubQuery='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}
	
}
