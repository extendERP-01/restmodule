package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * @author NirmalyaLabs
 *
 *
 */
public class RestInventoryStockReportModel {
	private String costCenter;
	private String item;
	private String itemSubCat;
	private Double reqQuantity;
	private Double recvQuantity;
	private Double issueQuantity;
	private String store;
	private String godown;
	
	
	public RestInventoryStockReportModel(Object costCenter, Object item, Object itemSubCat, Object reqQuantity,
			Object recvQuantity, Object issueQuantity, Object store, Object godown) {
		super();
		this.costCenter = (String)costCenter;
		this.item =(String) item;
		this.itemSubCat = (String)itemSubCat;
		this.reqQuantity = (Double)reqQuantity;
		this.recvQuantity = (Double)recvQuantity;
		this.issueQuantity = (Double)issueQuantity;
		this.store = (String)store;
		this.godown = (String)godown;
	}


	public String getCostCenter() {
		return costCenter;
	}


	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public String getItemSubCat() {
		return itemSubCat;
	}


	public void setItemSubCat(String itemSubCat) {
		this.itemSubCat = itemSubCat;
	}


	public Double getReqQuantity() {
		return reqQuantity;
	}


	public void setReqQuantity(Double reqQuantity) {
		this.reqQuantity = reqQuantity;
	}


	public Double getRecvQuantity() {
		return recvQuantity;
	}


	public void setRecvQuantity(Double recvQuantity) {
		this.recvQuantity = recvQuantity;
	}


	public Double getIssueQuantity() {
		return issueQuantity;
	}


	public void setIssueQuantity(Double issueQuantity) {
		this.issueQuantity = issueQuantity;
	}


	

	public String getStore() {
		return store;
	}


	public void setStore(String store) {
		this.store = store;
	}


	public String getGodown() {
		return godown;
	}


	public void setGodown(String godown) {
		this.godown = godown;
	}


	public RestInventoryStockReportModel() {
		super();
		// TODO Auto-generated constructor stub
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
