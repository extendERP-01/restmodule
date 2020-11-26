/**
 * 
 */
package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.account.model.AccountBankModel;

/**
 * @author Nirmalya Labs
 *
 */
public class GenerateAccountBankParameter {
	
	public static String getAddBankParam(AccountBankModel form) {

		String s = "";

		if (form.getBank() != null) {
			s = s + "@p_bank='" + form.getBank() + "',";
		}

		if (form.getBankName() != null && form.getBankName() != "") {
			s = s + "@p_bankName='" + form.getBankName() + "',";
		}

		if (form.getBankDescription() != null && form.getBankDescription() != "") {
			s = s + "@p_bankDescription='" + form.getBankDescription() + "',";
		}
		
		s = s + "@p_createdBy='" + form.getCreatedBy() + "',";

		s = s + "@p_bankActive=" + form.getBankActive() + ",";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}

}
