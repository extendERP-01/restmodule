package nirmalya.aatithya.restmodule.production.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductionRawMaterialDetailsModel {

	private String batchCode;
	private String rawItemId;
	private String rawItemName;
	private Double quantity;

	public ProductionRawMaterialDetailsModel() {
		super();
	}

	public String getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}

	public String getRawItemId() {
		return rawItemId;
	}

	public void setRawItemId(String rawItemId) {
		this.rawItemId = rawItemId;
	}

	public String getRawItemName() {
		return rawItemName;
	}

	public void setRawItemName(String rawItemName) {
		this.rawItemName = rawItemName;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
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
