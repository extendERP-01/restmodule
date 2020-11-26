/**
 * 
 */
package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.account.model.AccountBankBranchModel;

/**
 * @author Nirmalya Labs
 *
 */
public class GenerateAccountBankBranchParameter {

	public static String getAddBankBranchParam(AccountBankBranchModel form) {

		String s = "";

		if (form.getBranch() != null) {
			s = s + "@p_branch='" + form.getBranch() + "',";
		}

		if (form.getBank() != null && form.getBank() != "") {
			s = s + "@p_bank='" + form.getBank() + "',";
		}

		if (form.getBranchName() != null && form.getBranchName() != "") {
			s = s + "@p_branchName='" + form.getBranchName() + "',";
		}

		if (form.getIfscCode() != null && form.getIfscCode() != "") {
			s = s + "@p_ifsc='" + form.getIfscCode() + "',";
		}

		if (form.getContactNumber() != null && form.getContactNumber() != "") {
			s = s + "@p_contactNumber='" + form.getContactNumber() + "',";
		}

		if (form.getEmail() != null && form.getEmail() != "") {
			s = s + "@p_email='" + form.getEmail() + "',";
		}

		if (form.getAddress() != null && form.getAddress() != "") {
			s = s + "@p_address='" + form.getAddress() + "',";
		}

		if (form.getCity() != null && form.getCity() != "") {
			s = s + "@p_city='" + form.getCity() + "',";
		}

		if (form.getDistrict() != null && form.getDistrict() != "") {
			s = s + "@p_district='" + form.getDistrict() + "',";
		}

		if (form.getState() != null && form.getState() != "") {
			s = s + "@p_state='" + form.getState() + "',";
		}

		if (form.getBranchCountry() != null && form.getBranchCountry() != "") {
			s = s + "@p_country='" + form.getBranchCountry() + "',";
		}

		s = s + "@p_createdBy='" + form.getCreatedBy() + "',";

		s = s + "@p_branchActive=" + form.getBranchActive() + ",";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}

}
