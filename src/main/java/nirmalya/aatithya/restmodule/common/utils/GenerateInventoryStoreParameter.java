///**
// * Generator Parameter for Store In inventory
// */
//package nirmalya.aatithya.restmodule.common.utils;
//
//import nirmalya.aatithya.restmodule.inventory.model.RestInventoryStoreMasterModel;
//
///**
// * @author NirmalayaLabs
// *
// */
//public class GenerateInventoryStoreParameter {
//	/**
//	 * add parameter set for inventory Store class
//	 *
//	 **/
//	public static String addStoreParam(RestInventoryStoreMasterModel restInventoryStoreMasterModel) {
//		String s = "";
//
//		if (restInventoryStoreMasterModel.getStore() != null) {
//			s = s + "@p_store='" + restInventoryStoreMasterModel.getStore() + "',";
//		}
//		if (restInventoryStoreMasterModel.getStoreName() != null || restInventoryStoreMasterModel.getStoreName() != "") {
//			s = s + "@p_storeName='" + restInventoryStoreMasterModel.getStoreName() + "',";
//		}
//		if (restInventoryStoreMasterModel.getStoreLocation() != null || restInventoryStoreMasterModel.getStoreLocation() != "") {
//			s = s + "@p_storeLocation='" + restInventoryStoreMasterModel.getStoreLocation() + "',";
//		}
//		if (restInventoryStoreMasterModel.getCostCenter() != null || restInventoryStoreMasterModel.getCostCenter() != "") {
//			s = s + "@p_costCenter='" + restInventoryStoreMasterModel.getCostCenter() + "',";
//		}
//		if (restInventoryStoreMasterModel.getStoreDescription() != null || restInventoryStoreMasterModel.getStoreDescription() != "") {
//			s = s + "@p_storeDescription='" + restInventoryStoreMasterModel.getStoreDescription() + "',";
//		}
//		
//		if (restInventoryStoreMasterModel.getStoreActive() != null) {
//			s = s + "@p_storeActive=" + restInventoryStoreMasterModel.getStoreActive() + ",";
//		}
//		if (restInventoryStoreMasterModel.getStoreCreatedBy() != null || restInventoryStoreMasterModel.getStoreCreatedBy() != "") {
//			s = s + "@p_createdBy='" + restInventoryStoreMasterModel.getStoreCreatedBy() + "',";
//		}
//
//		if (s != "") {
//			s = s.substring(0, s.length() - 1);
//
//			s = "SET " + s + ";";
//		}
//
//		return s;
//
//	}
//
//
//}
