package nirmalya.aatithya.restmodule.sales.model;

import java.util.List;

public class SaleOrderAdvancePayDtlsParentModel {

	private List<QuotationMasterModel> quotationMasterModelList;

	private List<SaleOrderAdvancePaymentModel> saleOrderAdvancePaymentModelList;

	public SaleOrderAdvancePayDtlsParentModel() {
		super(); 
	}

	public SaleOrderAdvancePayDtlsParentModel(List<QuotationMasterModel> quotationMasterModelList,
			List<SaleOrderAdvancePaymentModel> saleOrderAdvancePaymentModelList) {
		super();
		this.quotationMasterModelList = quotationMasterModelList;
		this.saleOrderAdvancePaymentModelList = saleOrderAdvancePaymentModelList;
	}

	public List<QuotationMasterModel> getQuotationMasterModelList() {
		return quotationMasterModelList;
	}

	public void setQuotationMasterModelList(List<QuotationMasterModel> quotationMasterModelList) {
		this.quotationMasterModelList = quotationMasterModelList;
	}

	public List<SaleOrderAdvancePaymentModel> getSaleOrderAdvancePaymentModelList() {
		return saleOrderAdvancePaymentModelList;
	}

	public void setSaleOrderAdvancePaymentModelList(
			List<SaleOrderAdvancePaymentModel> saleOrderAdvancePaymentModelList) {
		this.saleOrderAdvancePaymentModelList = saleOrderAdvancePaymentModelList;
	}

}
