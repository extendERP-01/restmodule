package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author NirmalyaLabs
 *
 */
public class RestInventoryStockTransferModel {

	private String tStockTransferId;
	private String tFromStore;
	private String tToStore;
	private String tTransferDate;
	private String tSerialNo;
	private String tTransferNo;
	private String tDescription;
	private Boolean tTransferStatus;
	private String tItem;
	private String tItemDescription;
	private String tItemUnit;
	private Double tItemQuantity;
	private String createdBy;
	private Double taxRate;
	private Double price;
	private Double total;
	private Double subTotal;
	private String item;
	private String desc;
	private String unit;
	public RestInventoryStockTransferModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestInventoryStockTransferModel(Object tStockTransferId, Object tFromStore, Object tToStore,
			Object tTransferDate, Object tSerialNo, Object tTransferNo, Object tDescription, Object tTransferStatus,
			Object tItem, Object tItemDescription, Object tItemUnit, Object tItemQuantity,Object createdBy,Object taxRate,Object price,
			Object total,Object  subTotal,Object item,Object desc,Object unit) {
		super();
		this.tStockTransferId = (String)tStockTransferId;
		this.tFromStore =(String) tFromStore;
		this.tToStore = (String)tToStore;
		this.tTransferDate = (String)tTransferDate;
		this.tSerialNo = (String)tSerialNo;
		this.tTransferNo =(String) tTransferNo;
		this.tDescription = (String)tDescription;
		this.tTransferStatus = (Boolean)tTransferStatus;
		this.tItem =(String) tItem;
		this.tItemDescription =(String)tItemDescription;
		this.tItemUnit = (String)tItemUnit;
		this.tItemQuantity = (Double)tItemQuantity;
		this.createdBy = (String)createdBy;
		this.taxRate = (Double)taxRate;
		this.price = (Double)price;
		this.total = (Double)total;
		this.subTotal = (Double)subTotal;
		this.item = (String)item;
		this.desc = (String)desc;
		this.unit = (String)unit;
	}

	public String gettStockTransferId() {
		return tStockTransferId;
	}

	public void settStockTransferId(String tStockTransferId) {
		this.tStockTransferId = tStockTransferId;
	}

	public String gettFromStore() {
		return tFromStore;
	}

	public void settFromStore(String tFromStore) {
		this.tFromStore = tFromStore;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String gettToStore() {
		return tToStore;
	}

	public String getItem() {
		return item;
	}

	public String getDesc() {
		return desc;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void settToStore(String tToStore) {
		this.tToStore = tToStore;
	}

	public Double getTaxRate() {
		return taxRate;
	}

	public Double getPrice() {
		return price;
	}

	public Double getTotal() {
		return total;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public String gettTransferDate() {
		return tTransferDate;
	}

	public void settTransferDate(String tTransferDate) {
		this.tTransferDate = tTransferDate;
	}

	public String gettSerialNo() {
		return tSerialNo;
	}

	public void settSerialNo(String tSerialNo) {
		this.tSerialNo = tSerialNo;
	}

	public String gettTransferNo() {
		return tTransferNo;
	}

	public void settTransferNo(String tTransferNo) {
		this.tTransferNo = tTransferNo;
	}

	public String gettDescription() {
		return tDescription;
	}

	public void settDescription(String tDescription) {
		this.tDescription = tDescription;
	}

	public Boolean gettTransferStatus() {
		return tTransferStatus;
	}

	public void settTransferStatus(Boolean tTransferStatus) {
		this.tTransferStatus = tTransferStatus;
	}

	public String gettItem() {
		return tItem;
	}

	public void settItem(String tItem) {
		this.tItem = tItem;
	}

	public String gettItemDescription() {
		return tItemDescription;
	}

	public void settItemDescription(String tItemDescription) {
		this.tItemDescription = tItemDescription;
	}

	public String gettItemUnit() {
		return tItemUnit;
	}

	public void settItemUnit(String tItemUnit) {
		this.tItemUnit = tItemUnit;
	}

	public Double gettItemQuantity() {
		return tItemQuantity;
	}

	public void settItemQuantity(Double tItemQuantity) {
		this.tItemQuantity = tItemQuantity;
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
