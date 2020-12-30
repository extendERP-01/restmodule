package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BatchModel {

	private String packetId;
	private String po;
	private String itemId;
	private String batchNo;
	private Double qty;
	private String mulSlNo;
	private String grn;
	private String createdBy;
	
	public BatchModel() {
		super();
	}

	public BatchModel(Object packetId, Object po, Object itemId, Object batchNo, Object qty, Object mulSlNo,
			Object grn, Object createdBy) {
		super();
		this.packetId = (String) packetId;
		this.po = (String) po;
		this.itemId = (String) itemId;
		this.batchNo = (String) batchNo;
		this.qty = (Double) qty;
		this.mulSlNo = (String) mulSlNo;
		this.grn = (String) grn;
		this.createdBy = (String) createdBy;
	}

	public String getPacketId() {
		return packetId;
	}

	public void setPacketId(String packetId) {
		this.packetId = packetId;
	}

	public String getPo() {
		return po;
	}

	public void setPo(String po) {
		this.po = po;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public String getMulSlNo() {
		return mulSlNo;
	}

	public void setMulSlNo(String mulSlNo) {
		this.mulSlNo = mulSlNo;
	}

	public String getGrn() {
		return grn;
	}

	public void setGrn(String grn) {
		this.grn = grn;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
