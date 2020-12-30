package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.sales.model.QuotationMasterModel;

public class GenerateSaleAdvanceAmountParam {

	public static String getAdvanceParam(QuotationMasterModel quotationMasterModel) {
		String s = "";

		double totalAdv = 0;
		double firstPayMode = 0;
		double secondPayMode = 0;
		if (quotationMasterModel.getQuotationId() != null && quotationMasterModel.getQuotationId() != "") {
			s = s + "@p_quotationId='" + quotationMasterModel.getQuotationId() + "',";
		}

		if (quotationMasterModel.getpOrderImage() != null && quotationMasterModel.getpOrderImage() != "") {
			s = s + "@p_imageName='" + quotationMasterModel.getpOrderImage() + "',";
		}

		if (quotationMasterModel.getFirstPayMode() != null && quotationMasterModel.getFirstPayMode() != "") {
			s = s + "@p_firstPayMode='" + quotationMasterModel.getFirstPayMode() + "',";
		}
		if (quotationMasterModel.getFirstPayAmount() != null) {
			s = s + "@p_firstPayAmount='" + quotationMasterModel.getFirstPayAmount() + "',";
			firstPayMode = quotationMasterModel.getFirstPayAmount();
		} 

		if (quotationMasterModel.getPayMode() != null && quotationMasterModel.getPayMode() != "") {
			s = s + "@p_secondPayMode='" + quotationMasterModel.getPayMode() + "',";
		}
		if (quotationMasterModel.getSecondPayAmount() != null) {
			s = s + "@p_secondPayAmount='" + quotationMasterModel.getSecondPayAmount() + "',";
			secondPayMode = quotationMasterModel.getSecondPayAmount();
		}
		if (quotationMasterModel.getTransId() != null && quotationMasterModel.getTransId() != "") {
			s = s + "@p_transId='" + quotationMasterModel.getTransId() + "',";
		}
		if (quotationMasterModel.getPosNumber() != null && quotationMasterModel.getPosNumber() != "") {
			s = s + "@p_posNumber='" + quotationMasterModel.getPosNumber() + "',";
		}
		if (quotationMasterModel.getCheckId() != null && quotationMasterModel.getCheckId() != "") {
			s = s + "@p_checkId='" + quotationMasterModel.getCheckId() + "',";
		}
		
		totalAdv = secondPayMode +  firstPayMode;
		s = s + "@p_advAmt='" + totalAdv + "',";

		if (quotationMasterModel.getCreatedBy() != null && quotationMasterModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + quotationMasterModel.getCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}
}
