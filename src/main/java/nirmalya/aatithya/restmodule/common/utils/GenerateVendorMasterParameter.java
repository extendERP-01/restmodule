package nirmalya.aatithya.restmodule.common.utils;

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
}
