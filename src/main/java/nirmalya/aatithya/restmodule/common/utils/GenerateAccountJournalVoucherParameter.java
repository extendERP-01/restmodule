package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryRequisitionIssueNoteModel;

public class GenerateAccountJournalVoucherParameter {

//	public static String getAddJournalVoucher(AccountJournalVoucherModel accountJournalVoucherModel) {
//
//		String s = "";
//		System.out.println(accountJournalVoucherModel.getJournalId());
//		if(accountJournalVoucherModel.getJournalId()!=null )
//		{
//			s = s+ "@p_jornalId='" + accountJournalVoucherModel.getJournalId() + "',";
//		}
//		if(accountJournalVoucherModel.getCostCenter()!=null && accountJournalVoucherModel.getCostCenter()!=" ")
//		{
//			s = s + "@p_costCenter='" + accountJournalVoucherModel.getCostCenter() + "',";
//		}
//		
//		if(accountJournalVoucherModel.getDebitName()!=null && accountJournalVoucherModel.getDebitName()!=" ")
//		{
//			s = s + "@p_debitName='" + accountJournalVoucherModel.getDebitName() + "',";
//		}
//		if(accountJournalVoucherModel.getDebitAccountGroup()!=null && accountJournalVoucherModel.getDebitAccountGroup()!=" ")
//		{
//			s = s + "@p_debitAccountGroup='" + accountJournalVoucherModel.getDebitAccountGroup() + "',";
//		}
//		if(accountJournalVoucherModel.getDebitAccountSubGroup()!=null && accountJournalVoucherModel.getDebitAccountSubGroup()!=" ")
//		{
//			s = s + "@p_debitAccountSubGroup='" + accountJournalVoucherModel.getDebitAccountSubGroup() + "',";
//		}
//		
//		if(accountJournalVoucherModel.getPaidAmount()!=null)
//		{
//			s = s + "@p_paidAmount='" + accountJournalVoucherModel.getPaidAmount() + "',";
//		}
//		if(accountJournalVoucherModel.getCreditName()!=null && accountJournalVoucherModel.getCreditName()!=" ")
//		{
//			s = s + "@p_crediterName='" + accountJournalVoucherModel.getCreditName() + "',";
//		}
//		if(accountJournalVoucherModel.getCreditAccountGroup()!=null && accountJournalVoucherModel.getCreditAccountGroup()!=" ")
//		{
//			s = s + "@p_creditAccountGroup='" + accountJournalVoucherModel.getCreditAccountGroup() + "',";
//		}
//		if(accountJournalVoucherModel.getCreditAccountSubGroup()!=null && accountJournalVoucherModel.getCreditAccountSubGroup()!=" ")
//		{
//			s = s + "@p_CreditAccountSubGroup='" + accountJournalVoucherModel.getCreditAccountSubGroup() + "',";
//		}
//		
//		if (accountJournalVoucherModel.getPaidDesc() != null &&  accountJournalVoucherModel.getPaidDesc()!=" ") {
//			s = s + "@p_description='" + accountJournalVoucherModel.getPaidDesc() + "',";
//		}
//		if (accountJournalVoucherModel.getCreatedBy() != null &&  accountJournalVoucherModel.getCreatedBy()!=" ") {
//			s = s + "@p_createdBy='" + accountJournalVoucherModel.getCreatedBy() + "',";
//		}
//		if(s != "") {
//			s = s.substring(0, s.length()-1);
//			
//			s = "SET " + s + ";" ;
//		}
//		System.out.println(s);
//		return s;
//	}
	public static String saveJournalVoucherParam(List<AccountJournalVoucherModel> journalVoucherModel) {
		System.out.println(journalVoucherModel);
		String s = "";
		String litem = "";
		String journalVoucher = "";
		String costCenter = "";
		String Description = "";
		Double totalAmount = 0.0;
		String createdBy = "";
		for (AccountJournalVoucherModel m : journalVoucherModel) {
			journalVoucher = m.getJournalVoucher();
			costCenter = m.getCostCenter();
			Description = m.getDescription();
			createdBy = m.getCreatedBy();
			totalAmount = m.getTotalAmount();

		}

		s = s + "@p_journalVoucher='" + journalVoucher + "',";
		s = s + "@p_costCenter='" + costCenter + "',";
		s = s + "@p_description='" + Description + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_totalAmount='" + totalAmount + "',";

		for (AccountJournalVoucherModel m : journalVoucherModel) {
			m.setTransactionType(false);
			if (m.getFromAmount() != null && m.getFromName() != null && m.getFromAccountSubGroup() != null) {
				litem = litem + "(@p_journalVoucher,\"" + m.getFromAccountSubGroup() + "\"," + m.getTransactionType()
						+ ",\"" + m.getFromName() + "\"," + m.getFromAmount() + "),";

			}
		}
		for (AccountJournalVoucherModel m : journalVoucherModel) {
			m.setTransactionType(true);
			if (m.getToAmount() != null && m.getToName() != null && m.getToAccountSubGroup() != null) {
				litem = litem + "(@p_journalVoucher,\"" + m.getToAccountSubGroup() + "\"," + m.getTransactionType()
						+ ",\"" + m.getToName() + "\"," + m.getToAmount() + "),";

			}
		}
		litem = litem.substring(0, litem.length() - 1);

		s = s + "@p_jVSubQuery='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}

}
