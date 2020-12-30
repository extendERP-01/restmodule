package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class InventoryGrnDetailsModel {

	private String purchaseOrder;
	private String grnInvoice;
	private String invNo;
	private Double discount;
	private Double total;
	private Double tdsAmount;
	private String dueDate;

	public InventoryGrnDetailsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventoryGrnDetailsModel(Object purchaseOrder, Object grnInvoice, Object invNo, Object discount,
			Object total, Object tdsAmount, Object dueDate) {
		super();
		try {
			this.purchaseOrder = (String) purchaseOrder;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.grnInvoice = (String) grnInvoice;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.invNo = (String) invNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.discount = (Double) discount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.total = (Double) total;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tdsAmount = (Double) tdsAmount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.dueDate = (String) dueDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(String purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public String getGrnInvoice() {
		return grnInvoice;
	}

	public void setGrnInvoice(String grnInvoice) {
		this.grnInvoice = grnInvoice;
	}

	public String getInvNo() {
		return invNo;
	}

	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getTdsAmount() {
		return tdsAmount;
	}

	public void setTdsAmount(Double tdsAmount) {
		this.tdsAmount = tdsAmount;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		ObjectMapper mapperObj = new ObjectMapper();
		String jsonStr;
		try {
			jsonStr = mapperObj.writeValueAsString(this);
		} catch (IOException ex) {

			jsonStr = ex.toString();
		}
		return jsonStr;
	}
}
