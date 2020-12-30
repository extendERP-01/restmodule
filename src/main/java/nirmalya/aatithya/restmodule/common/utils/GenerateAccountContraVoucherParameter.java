package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.account.model.ContraVoucherModel;

public class GenerateAccountContraVoucherParameter {

	public static String getAddContraVoucherParam(ContraVoucherModel contraVoucher) {
		
		String s = "";
		
		s = s + "@p_contraVoucherId='" + contraVoucher.getContraVoucherId() + "',";
		s = s + "@p_contraVoucherType='" + contraVoucher.getContraVoucherType() + "',";
		s = s + "@p_costCenter='" + contraVoucher.getCostCenter() + "',";
		s = s + "@p_cvDescription='" + contraVoucher.getCvDescription() + "',";
		String cvDate = DateFormatter.getStringDate(contraVoucher.getCvDate());
		s = s + "@p_cvDate='" + cvDate + "',";
		s = s + "@p_cvAmount=" + contraVoucher.getCvAmount() + ",";
		s = s + "@p_fromBank='" + contraVoucher.getFromBank() + "',";
		s = s + "@p_fromBranch='" + contraVoucher.getFromBranch() + "',";
		s = s + "@p_fromAccount='" + contraVoucher.getFromAccount() + "',";
		s = s + "@p_fromCash='" + contraVoucher.getFromCash() + "',";
		s = s + "@p_toBank='" + contraVoucher.getToBank() + "',";
		s = s + "@p_toBranch='" + contraVoucher.getToBranch() + "',";
		s = s + "@p_toAccount='" + contraVoucher.getToAccount() + "',";
		s = s + "@p_toCash='" + contraVoucher.getToCash() + "',";
		s = s + "@p_createdBy='" + contraVoucher.getCreatedBy() + "',";
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		
		return s;
	}

}
