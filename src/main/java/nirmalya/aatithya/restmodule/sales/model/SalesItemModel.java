package nirmalya.aatithya.restmodule.sales.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SalesItemModel {
	
	private String serveTypeId;
	
	private String serveType;
	
	private Double itemGST;

	private Double itemPrice;
	
	private Double itemCess;
	
	public SalesItemModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SalesItemModel(Object serveTypeId, Object serveType, Object itemGST ,Object itemPrice, Object itemCess) {
		super();
		this.serveTypeId = (String) serveTypeId;
		this.serveType = (String) serveType;
		this.itemGST = (Double) itemGST;
		this.itemPrice = (Double) itemPrice;
		this.itemCess = (Double) itemCess;
	}

	public String getServeTypeId() {
		return serveTypeId;
	}

	public void setServeTypeId(String serveTypeId) {
		this.serveTypeId = serveTypeId;
	}

	public String getServeType() {
		return serveType;
	}

	public void setServeType(String serveType) {
		this.serveType = serveType;
	}

	public Double getItemGST() {
		return itemGST;
	}

	public void setItemGST(Double itemGST) {
		this.itemGST = itemGST;
	}
	
	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Double getItemCess() {
		return itemCess;
	}

	public void setItemCess(Double itemCess) {
		this.itemCess = itemCess;
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
