package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PhysicalVerificationBarCodeModel {
	private Integer barcodeId;
	private String barcodeNo;

	public PhysicalVerificationBarCodeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings("unchecked")
	public PhysicalVerificationBarCodeModel(Object barcodeId, Object barcodeNo) {
		super();
		this.barcodeId = (Integer) barcodeId;
		this.barcodeNo = (String) barcodeNo;
		
	}
	public Integer getBarcodeId() {
		return barcodeId;
	}

	public void setBarcodeId(Integer barcodeId) {
		this.barcodeId = barcodeId;
	}

	public String getBarcodeNo() {
		return barcodeNo;
	}

	public void setBarcodeNo(String barcodeNo) {
		this.barcodeNo = barcodeNo;
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
