/**
 * 
 */
package nirmalya.aatithya.restmodule.sales.model;

/**
 * @author ashis
 *
 */
public class RestSalesDashboardoneModel {

	public Integer customerCount;

	public Integer quotationCompleted;

	public Integer saleInvCompleted;

	public Integer quotationPending;

	public Integer saleInvPending;

	public Double totalSale;

	public String itemName;
	
	public RestSalesDashboardoneModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestSalesDashboardoneModel(Object customerCount, Object quotationCompleted, Object saleInvCompleted,
			Object quotationPending, Object saleInvPending, Object totalSale,Object itemName) {
		super();
		try {
			this.customerCount = (Integer) customerCount;
		} catch (Exception E) {
			E.printStackTrace();
		}
		try {
			this.quotationCompleted = (Integer) quotationCompleted;
		} catch (Exception E) {
			E.printStackTrace();
		}
		try {
			this.saleInvCompleted = (Integer) saleInvCompleted;
		} catch (Exception E) {
			E.printStackTrace();
		}
		try {
			this.quotationPending = (Integer) quotationPending;
		} catch (Exception E) {
			E.printStackTrace();
		}
		try {
			this.saleInvPending = (Integer) saleInvPending;
		} catch (Exception E) {
			E.printStackTrace();
		}
		try {
			this.totalSale = (Double) totalSale;
		} catch (Exception E) {
			E.printStackTrace();
		}
		try {
			this.itemName = (String) itemName;
		} catch (Exception E) {
			E.printStackTrace();
		}
	}

	public Integer getCustomerCount() {
		return customerCount;
	}

	public void setCustomerCount(Integer customerCount) {
		this.customerCount = customerCount;
	}

	public Integer getQuotationCompleted() {
		return quotationCompleted;
	}

	public void setQuotationCompleted(Integer quotationCompleted) {
		this.quotationCompleted = quotationCompleted;
	}

	public Integer getSaleInvCompleted() {
		return saleInvCompleted;
	}

	public void setSaleInvCompleted(Integer saleInvCompleted) {
		this.saleInvCompleted = saleInvCompleted;
	}

	public Integer getQuotationPending() {
		return quotationPending;
	}

	public void setQuotationPending(Integer quotationPending) {
		this.quotationPending = quotationPending;
	}

	public Integer getSaleInvPending() {
		return saleInvPending;
	}

	public void setSaleInvPending(Integer saleInvPending) {
		this.saleInvPending = saleInvPending;
	}

	public Double getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(Double totalSale) {
		this.totalSale = totalSale;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	
}
