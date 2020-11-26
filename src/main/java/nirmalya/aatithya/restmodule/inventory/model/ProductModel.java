package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductModel {

	private String productId;
	private String product;
	private String productName;
	private String itemId;
	private String itemName;
	private Double qty;
	private String createdBy;
	private int slNo;
	private double qtyPerBatch;

	public ProductModel() {
		super();

	}

	public ProductModel(Object productId, Object product, Object productName, Object itemId, Object itemName,
			Object qty ,Object qtyPerBatch) {
		super();
		this.productId = (String) productId;
		this.product = (String) product;
		this.productName = (String) productName;
		this.itemId = (String) itemId;
		this.itemName = (String) itemName;
		this.qty = (Double) qty;
		this.qtyPerBatch = (Double) qtyPerBatch;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getSlNo() {
		return slNo;
	}

	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}

	public double getQtyPerBatch() {
		return qtyPerBatch;
	}

	public void setQtyPerBatch(double qtyPerBatch) {
		this.qtyPerBatch = qtyPerBatch;
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
