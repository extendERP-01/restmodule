/**Defines SQL SET Parameters */
package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.property.model.PropertyAssetCodeModel;

/**
 * @author Nirmalya Labs
 *
 */
public class GenerateAssetCodeParameter {

	/**
	 * returns parameter set for property assetcode class
	 **/

	public static String getAddAssetCodeParam(PropertyAssetCodeModel form) {
		String s = "";

		if (form.getAssetCodeId() != null && form.getAssetCodeId() != "") {
			s = s + "@p_assetCodeId='" + form.getAssetCodeId() + "',";
		}

		if (form.getAssetCodeName() != null && form.getAssetCodeName() != "") {
			s = s + "@p_assetCodeName='" + form.getAssetCodeName() + "',";
		}

		if (form.getItemId() != null && form.getItemId() != "") {
			s = s + "@p_item='" + form.getItemId() + "',";
		}
		
		if (form.getCategoryId() != null && form.getCategoryId() != "") {
			s = s + "@p_category='" + form.getCategoryId() + "',";
		}
		
		if (form.getStore() != null && form.getStore() != "") {
			s = s + "@p_store='" + form.getStore() + "',";
		}
		
		if (form.gettSerialNo() != null && form.gettSerialNo() != "") {
			s = s + "@p_serial='" + form.gettSerialNo() + "',";
		}
		if (form.getDop() != null) {

			String tDate = DateFormatter.getStringDate(form.getDop());

			s = s + "@p_dop='" + tDate + "',";
		}

		if (form.getGrrnty() != null && form.getGrrnty() != "") {
			s = s + "@p_grrnty='" + form.getGrrnty() + "',";
		}

		if (form.getBrndNm() != null && form.getBrndNm() != "") {
			s = s + "@p_brndNm='" + form.getBrndNm() + "',";
		}

		if (form.getCustEmail() != null && form.getCustEmail() != "") {
			s = s + "@p_custEmail='" + form.getCustEmail() + "',";
		}

		if (form.getCustPhone() != null && form.getCustPhone() != "") {
			s = s + "@p_custPhone='" + form.getCustPhone() + "',";
		}

		if (form.getDescription() != null && form.getDescription() != "") {
			s = s + "@p_description='" + form.getDescription() + "',";
		}
		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";
		}
		if (form.getModel() != null && form.getModel() != "") {
			s = s + "@p_model='" + form.getModel() + "',";
		}
		if (form.getChassisNo() != null && form.getChassisNo() != "") {
			s = s + "@p_chassis='" + form.getChassisNo() + "',";
		}
		if (form.getEngineNo() != null && form.getEngineNo() != "") {
			s = s + "@p_engine='" + form.getEngineNo() + "',";
		}
		if (form.getWorkingStatus() != null) {
			s = s + "@p_workingStatus=" + form.getWorkingStatus() + ",";
		}

		if (form.getAssetactive() != null) {
			s = s + "@p_assetactive=" + form.getAssetactive() + ",";
		}
		
		if (form.getBarcode() != null && form.getBarcode() != "") {
			s = s + "@p_itemBarcode='" + form.getBarcode() + "',";
		}
		if (form.getGrn() != null && form.getGrn() != "") {
			s = s + "@p_itemGRN='" + form.getGrn() + "',";
		}
		if (form.getClassId()!= null && form.getClassId() != "") {
			s = s + "@p_classification='" + form.getClassId() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}
}