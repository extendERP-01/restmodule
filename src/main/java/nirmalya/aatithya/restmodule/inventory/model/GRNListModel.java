package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GRNListModel {

	private String item;

	private Double qty;

	private Double price;

	private Double gst;

	private Double amount;

	private String vendorId;

	private String vendor;

	private String pOrder;

	private String invNo;

	private String invDate;

	private String payDueDate;

	private Double totalCGST;

	private Double grandTotal;

	private String createdBy;

	private List<String> grnList;

	private String storeId;
	
	private Boolean gstType;
	
	private Double cessAmount;
	
	private Double itemCess;
	
	private Double totalIGST;

	public GRNListModel() {
		super();
	}

	@SuppressWarnings("unchecked")
	public GRNListModel(Object item, Object qty, Object price, Object gst, Object amount, Object vendorId,
			Object vendor, Object pOrder, Object invNo, Object invDate, Object payDueDate, Object totalCGST,
			Object grandTotal, Object createdBy, Object grnList, Object storeId, Object gstType, Object cessAmount,
			Object itemCess, Object totalIGST) {
		super();
		this.item = (String) item;
		this.qty = (Double) qty;
		this.price = (Double) price;
		this.gst = (Double) gst;
		this.amount = (Double) amount;
		this.vendorId = (String) vendorId;
		this.vendor = (String) vendor;
		this.pOrder = (String) pOrder;
		this.invNo = (String) invNo;
		this.invDate = (String) invDate;
		this.payDueDate = (String) payDueDate;
		this.totalCGST = (Double) totalCGST;
		this.grandTotal = (Double) grandTotal;
		this.createdBy = (String) createdBy;
		this.grnList = (List<String>) grnList;
		this.storeId = (String) storeId;
		this.gstType = (Boolean) gstType;
		this.cessAmount = (Double) cessAmount;
		this.itemCess = (Double) itemCess;
		this.totalIGST = (Double) totalIGST;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getGst() {
		return gst;
	}

	public void setGst(Double gst) {
		this.gst = gst;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getpOrder() {
		return pOrder;
	}

	public void setpOrder(String pOrder) {
		this.pOrder = pOrder;
	}

	public String getInvNo() {
		return invNo;
	}

	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public String getInvDate() {
		return invDate;
	}

	public void setInvDate(String invDate) {
		this.invDate = invDate;
	}

	public String getPayDueDate() {
		return payDueDate;
	}

	public void setPayDueDate(String payDueDate) {
		this.payDueDate = payDueDate;
	}

	public Double getTotalCGST() {
		return totalCGST;
	}

	public void setTotalCGST(Double totalCGST) {
		this.totalCGST = totalCGST;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public List<String> getGrnList() {
		return grnList;
	}

	public void setGrnList(List<String> grnList) {
		this.grnList = grnList;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public Boolean getGstType() {
		return gstType;
	}

	public void setGstType(Boolean gstType) {
		this.gstType = gstType;
	}

	public Double getCessAmount() {
		return cessAmount;
	}

	public void setCessAmount(Double cessAmount) {
		this.cessAmount = cessAmount;
	}

	public Double getItemCess() {
		return itemCess;
	}

	public void setItemCess(Double itemCess) {
		this.itemCess = itemCess;
	}

	public Double getTotalIGST() {
		return totalIGST;
	}

	public void setTotalIGST(Double totalIGST) {
		this.totalIGST = totalIGST;
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
