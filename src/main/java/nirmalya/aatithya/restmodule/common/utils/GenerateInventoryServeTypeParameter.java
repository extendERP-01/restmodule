/**
 * 
 */
package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.inventory.model.InventoryItemServeTypeModel;

/**
 * @author USER
 *
 */
 public class GenerateInventoryServeTypeParameter 
{
 
	public static String addItemServeParam(InventoryItemServeTypeModel itemServeTypeModel) 
	{
		/**
		 * returns parameter set for inventory ItemServeType class
		 **/

			String s = "";

			if (itemServeTypeModel.getItmServeTypeId() != null) {
				s = s + "@p_itmServeTypeId='" + itemServeTypeModel.getItmServeTypeId() + "',";
			}
			if (itemServeTypeModel.getItmServeTypeName() != null || itemServeTypeModel.getItmServeTypeName() != "") {
				s = s + "@p_itmServeTypeName='" + itemServeTypeModel.getItmServeTypeName() + "',";
			}
			if (itemServeTypeModel.getItmServeTypeDescription() != null || itemServeTypeModel.getItmServeTypeDescription() != "") {
				s = s + "@p_itmServeTypeDescription='" + itemServeTypeModel.getItmServeTypeDescription() + "',";
			}
			if (itemServeTypeModel.getItmServeTypeActive() != null) {
				s = s + "@p_itmServeTypeActive=" + itemServeTypeModel.getItmServeTypeActive() + ",";
			}
			if (itemServeTypeModel.getCreatedBy() != null || itemServeTypeModel.getCreatedBy() != "") {
				s = s + "@p_createdBy='" + itemServeTypeModel.getCreatedBy() + "',";
			}

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
           //System.out.println("S="+s);
			return s;

	}

}
