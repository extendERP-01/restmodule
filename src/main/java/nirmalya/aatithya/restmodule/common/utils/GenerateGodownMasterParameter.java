package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestGodownMasterModel;

public class GenerateGodownMasterParameter {

	public static String addGodownParam(RestGodownMasterModel godownMaster) {
		String sqlParam = null;
		if (godownMaster.gettGodownName()!= null) {
			sqlParam = "@p_tGodownName='" + godownMaster.gettGodownName() + "',";
		}
		if (godownMaster.gettGodownDescription() != null) {
			sqlParam = sqlParam + "@p_tGodownDescription='" + godownMaster.gettGodownDescription() + "',";
		}
		if (godownMaster.gettGodownActive() != null) {
			sqlParam = sqlParam + "@p_tGodownActive=" + godownMaster.gettGodownActive() + ",";
		}
		
		if (godownMaster.gettAddress()!= null) {
			sqlParam = sqlParam + "@p_tAddress='" + godownMaster.gettAddress() + "',";
		}
		
		if (godownMaster.gettCity()!= null) {
			sqlParam = sqlParam + "@p_tCity='" + godownMaster.gettCity() + "',";
		}
		if (godownMaster.gettDistrict()!= null) {
			sqlParam = sqlParam + "@p_tDistrict='" + godownMaster.gettDistrict() + "',";
		}
		if (godownMaster.gettState()!= null) {
			sqlParam = sqlParam + "@p_tState='" + godownMaster.gettState() + "',";
		}
		if (godownMaster.gettCountry()!= null) {
			sqlParam = sqlParam + "@p_tCountry='" + godownMaster.gettCountry() + "',";
		}
		if (godownMaster.gettPinCode()!= null) {
			sqlParam = sqlParam + "@p_tPinCode='" + godownMaster.gettPinCode() + "',";
		}
		if (godownMaster.gettPhoneNo()!= null) {
			sqlParam = sqlParam + "@p_tPhoneNo='" + godownMaster.gettPhoneNo() + "',";
		}
		if (godownMaster.gettGSTNo()!= null) {
			sqlParam = sqlParam + "@p_tGSTNo='" + godownMaster.gettGSTNo() + "',";
		}
		if (godownMaster.gettEmailId()!= null) {
			sqlParam = sqlParam + "@p_tEmailId='" + godownMaster.gettEmailId() + "',";
		}
		if (godownMaster.gettTinNo()!= null) {
			sqlParam = sqlParam + "@p_tTinNo='" + godownMaster.gettTinNo() + "',";
		}
		if (godownMaster.gettGodownLogo()!= null) {
			sqlParam = sqlParam + "@p_tGodownLogo='" + godownMaster.gettGodownLogo() + "',";
		}
		if (godownMaster.getCreatedBy()!= null) {
			sqlParam = sqlParam + "@p_createdBy='" + godownMaster.getCreatedBy() + "',";
		}
		if (godownMaster.gettGodown()!= null) {
			sqlParam = sqlParam + "@p_tGodown='" + godownMaster.gettGodown() + "',";
		}
	
		

		if (sqlParam != "") {
			sqlParam = sqlParam.substring(0, sqlParam.length() - 1);

			sqlParam = "SET " + sqlParam + ";";
		}
		System.out.println("sqlParam"+sqlParam);
		return sqlParam;

	}


}
