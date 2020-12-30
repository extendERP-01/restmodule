package nirmalya.aatithya.restmodule.sales.model;

import java.util.List;
 
import nirmalya.aatithya.restmodule.sales.model.FoodOrderPaymentDetails;

public class SaleOrderPaymentPdfModel {

	
	private List<SalesInvoiceModel> salesInvoiceModelList;
	private List<FoodOrderPaymentDetails> foodOrderPaymentDetailsList;
	
	
	public SaleOrderPaymentPdfModel() {
		 
	}
 
	public List<SalesInvoiceModel> getSalesInvoiceModelList() {
		return salesInvoiceModelList;
	}
	public void setSalesInvoiceModelList(List<SalesInvoiceModel> salesInvoiceModelList) {
		this.salesInvoiceModelList = salesInvoiceModelList;
	}
	public List<FoodOrderPaymentDetails> getFoodOrderPaymentDetailsList() {
		return foodOrderPaymentDetailsList;
	}
	public void setFoodOrderPaymentDetailsList(List<FoodOrderPaymentDetails> foodOrderPaymentDetailsList) {
		this.foodOrderPaymentDetailsList = foodOrderPaymentDetailsList;
	}
	
}
