package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.inventory.model.RestStoreMasterModel;

public class GenerateStoreMasterParameter {

	public static String addBannerParam(RestStoreMasterModel storeMaster) {
		
		String sqlParam = null;
		
		if (storeMaster.gettStoreName()!= null) {
			sqlParam = "@p_tStoreName='" + storeMaster.gettStoreName() + "',";
		}
		if (storeMaster.gettStoreDescription() != null) {
			sqlParam = sqlParam + "@p_tStoreDescription='" + storeMaster.gettStoreDescription() + "',";
		}
		if (storeMaster.gettStoreActive() != null) {
			sqlParam = sqlParam + "@p_tStoreActive=" + storeMaster.gettStoreActive() + ",";
		}
		if (storeMaster.gettAddress()!= null) {
			sqlParam = sqlParam + "@p_tAddress='" + storeMaster.gettAddress() + "',";
		}
		if (storeMaster.gettCity()!= null) {
			sqlParam = sqlParam + "@p_tCity='" + storeMaster.gettCity() + "',";
		}
		if (storeMaster.gettDistrict()!= null) {
			sqlParam = sqlParam + "@p_tDistrict='" + storeMaster.gettDistrict() + "',";
		}
		if (storeMaster.gettState()!= null) {
			sqlParam = sqlParam + "@p_tState='" + storeMaster.gettState() + "',";
		}
		if (storeMaster.gettCountry()!= null) {
			sqlParam = sqlParam + "@p_tCountry='" + storeMaster.gettCountry() + "',";
		}
		if (storeMaster.gettPinCode()!= null) {
			sqlParam = sqlParam + "@p_tPinCode='" + storeMaster.gettPinCode() + "',";
		}
		if (storeMaster.gettPhoneNo()!= null) {
			sqlParam = sqlParam + "@p_tPhoneNo='" + storeMaster.gettPhoneNo() + "',";
		}
		if (storeMaster.gettGSTNo()!= null) {
			sqlParam = sqlParam + "@p_tGSTNo='" + storeMaster.gettGSTNo() + "',";
		}
		if (storeMaster.gettEmailId()!= null) {
			sqlParam = sqlParam + "@p_tEmailId='" + storeMaster.gettEmailId() + "',";
		}
		if (storeMaster.gettTinNo()!= null) {
			sqlParam = sqlParam + "@p_tTinNo='" + storeMaster.gettTinNo() + "',";
		}
		if (storeMaster.gettStoreLogo()!= null) {
			sqlParam = sqlParam + "@p_tStoreLogo='" + storeMaster.gettStoreLogo() + "',";
		}
		if (storeMaster.getCreatedBy()!= null) {
			sqlParam = sqlParam + "@p_createdBy='" + storeMaster.getCreatedBy() + "',";
		}
		if (storeMaster.gettStore()!= null) {
			sqlParam = sqlParam + "@p_tStore='" + storeMaster.gettStore() + "',";
		}
	
		if (sqlParam != "") {
			sqlParam = sqlParam.substring(0, sqlParam.length() - 1);

			sqlParam = "SET " + sqlParam + ";";
		}
		System.out.println("sqlParam"+sqlParam);
		return sqlParam;

	}


}
