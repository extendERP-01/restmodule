/**
 * 
 */
package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.account.model.AccountBankAccountModel;

/**
 * @author USER
 *
 */
public class GenerateAccountBankAccountParameter {
	
	public static String getAddBankAccountParam(AccountBankAccountModel form) {

		String s = "";

		

		if (form.getBank() != null && form.getBank() != "") {
			s = s + "@p_bank='" + form.getBank() + "',";
		}
		
		if (form.getBranch() != null) {
			s = s + "@p_branch='" + form.getBranch() + "',";
		}


		if (form.getAccountNumber() != null && form.getAccountNumber() != "") {
			s = s + "@p_accountNumber='" + form.getAccountNumber() + "',";
		}

		if (form.getAccountHolder() != null && form.getAccountHolder() != "") {
			s = s + "@p_accountHolder='" + form.getAccountHolder() + "',";
		}

		if (form.getAccountType() != null && form.getAccountType() != "") {
			s = s + "@p_accountType='" + form.getAccountType() + "',";
		}

		

		s = s + "@p_createdBy='" + form.getCreatedBy() + "',";

		s = s + "@p_accountActive=" + form.getAccountActive() + ",";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}

}
