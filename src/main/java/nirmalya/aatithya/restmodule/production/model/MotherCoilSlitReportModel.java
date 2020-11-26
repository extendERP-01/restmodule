package nirmalya.aatithya.restmodule.production.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MotherCoilSlitReportModel {
	private String motherCoilBatch;
	private String grn;
	private String itemCateGory;
	private String itemSubCateGory;
	private String item;
	private String batchCode;
	public MotherCoilSlitReportModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MotherCoilSlitReportModel(Object motherCoilBatch, Object grn, Object itemCateGory,Object itemSubCateGory,			
			Object item, Object batchCode) {
		super();
		this.motherCoilBatch = (String) motherCoilBatch;
		this.grn = (String) grn;
		this.itemCateGory = (String) itemCateGory;
		this.itemSubCateGory = (String) itemSubCateGory;
		this.item = (String) item;
		this.batchCode = (String) batchCode;
	
		
	}
	public String getMotherCoilBatch() {
		return motherCoilBatch;
	}
	public void setMotherCoilBatch(String motherCoilBatch) {
		this.motherCoilBatch = motherCoilBatch;
	}
	public String getGrn() {
		return grn;
	}
	public void setGrn(String grn) {
		this.grn = grn;
	}
	public String getItemCateGory() {
		return itemCateGory;
	}
	public void setItemCateGory(String itemCateGory) {
		this.itemCateGory = itemCateGory;
	}
	public String getItemSubCateGory() {
		return itemSubCateGory;
	}
	public void setItemSubCateGory(String itemSubCateGory) {
		this.itemSubCateGory = itemSubCateGory;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getBatchCode() {
		return batchCode;
	}
	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
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
