package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.VendorLocationMasterModel;
import nirmalya.aatithya.restmodule.master.model.VendorMasterModel;

public class GenerateVendorMasterParameter {

	public static String saveVendorMaster(VendorMasterModel vendorMasterModel) {

		String s = "";

		if (vendorMasterModel.getVendorId() != null && vendorMasterModel.getVendorId() != "") {
			s = s + "@p_vendorId='" + vendorMasterModel.getVendorId() + "',";
		}
		if (vendorMasterModel.getCode() != null && vendorMasterModel.getCode() != "") {
			s = s + "@p_codeId='" + vendorMasterModel.getCode() + "',";
		}
		if (vendorMasterModel.getVendorName() != null && vendorMasterModel.getVendorName() != "") {
			s = s + "@p_vendorName='" + vendorMasterModel.getVendorName() + "',";
		}
		if (vendorMasterModel.getCategory() != null && vendorMasterModel.getCategory() != "") {
			s = s + "@p_category='" + vendorMasterModel.getCategory() + "',";
		}
		if (vendorMasterModel.getVendorStatus() != null && vendorMasterModel.getVendorStatus() != "") {
			s = s + "@p_isActive='" + vendorMasterModel.getVendorStatus() + "',";
		} else {
			s = s + "@p_isActive='" + 0 + "',";
		}
		if (vendorMasterModel.getCategoryType() != null && vendorMasterModel.getCategoryType() != "") {
			s = s + "@p_categoryType='" + vendorMasterModel.getCategoryType() + "',";
		}
		if (vendorMasterModel.getFileVendor() != null && vendorMasterModel.getFileVendor() != "") {
			s = s + "@p_fileVendor='" + vendorMasterModel.getFileVendor() + "',";
		}
		if (vendorMasterModel.getComapanyOverview() != null && vendorMasterModel.getComapanyOverview() != "") {
			s = s + "@p_companyOverView='" + vendorMasterModel.getComapanyOverview() + "',";
		}
		if (vendorMasterModel.getCreatedBy() != null && vendorMasterModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + vendorMasterModel.getCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}


		return s;
	}
	
	public static String saveVendorLocationMaster(VendorLocationMasterModel vendorLocationMasterModel) {

		String s = "";

		if (vendorLocationMasterModel.getVendorLocationId() != null && vendorLocationMasterModel.getVendorLocationId() != "") {
			s = s + "@p_vendorLocId='" + vendorLocationMasterModel.getVendorLocationId() + "',";
		}
		if (vendorLocationMasterModel.getVendorId() != null && vendorLocationMasterModel.getVendorId() != "") {
			s = s + "@p_vendorId='" + vendorLocationMasterModel.getVendorId() + "',";
		}
		if (vendorLocationMasterModel.getVendorLocationName() != null && vendorLocationMasterModel.getVendorLocationName() != "") {
			s = s + "@p_vendorLocationName='" + vendorLocationMasterModel.getVendorLocationName() + "',";
		}
		if (vendorLocationMasterModel.getVendorLocationType() != null && vendorLocationMasterModel.getVendorLocationType() != "") {
			s = s + "@p_vendorLocType='" + vendorLocationMasterModel.getVendorLocationType() + "',";
		}
	
		if (vendorLocationMasterModel.getVendorBillingStatus() != null && vendorLocationMasterModel.getVendorBillingStatus() != "") {
			s = s + "@p_billingStatus='" + vendorLocationMasterModel.getVendorBillingStatus() + "',";
		} else {
			s = s + "@p_billingStatus='" + 0 + "',";
		}
		if (vendorLocationMasterModel.getVendorPrimaryStatus() != null && vendorLocationMasterModel.getVendorPrimaryStatus() != "") {
			s = s + "@p_primaryStatus='" + vendorLocationMasterModel.getVendorPrimaryStatus() + "',";
		} else {
			s = s + "@p_primaryStatus='" + 0 + "',";
		}
		if (vendorLocationMasterModel.getVendorLocAddress() != null && vendorLocationMasterModel.getVendorLocAddress() != "") {
			s = s + "@p_locAddress='" + vendorLocationMasterModel.getVendorLocAddress() + "',";
		}
		if (vendorLocationMasterModel.getVendorCountry() != null && vendorLocationMasterModel.getVendorCountry() != "") {
			s = s + "@p_vendorCountry='" + vendorLocationMasterModel.getVendorCountry() + "',";
		}
		if (vendorLocationMasterModel.getVendorState() != null && vendorLocationMasterModel.getVendorState() != "") {
			s = s + "@p_vendorState='" + vendorLocationMasterModel.getVendorState() + "',";
		}
		if (vendorLocationMasterModel.getVendorCity()!= null && vendorLocationMasterModel.getVendorCity() != "") {
			s = s + "@p_vendorCity='" + vendorLocationMasterModel.getVendorCity() + "',";
		}
		if (vendorLocationMasterModel.getCreatedBy() != null && vendorLocationMasterModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + vendorLocationMasterModel.getCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}


		return s;
	}
}
