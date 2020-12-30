package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TdsMasterModel {
	private String tdsId;
	private String tdsType;
	private Double tdsRate;
	private Boolean tdsStatus;
	private String createdBy;

	public TdsMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TdsMasterModel(Object tdsId, Object tdsType, Object tdsRate, Object tdsStatus) {
		super();
		try {
			this.tdsId = (String) tdsId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tdsType = (String) tdsType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tdsRate = (Double) tdsRate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tdsStatus = (Boolean) tdsStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getTdsId() {
		return tdsId;
	}

	public void setTdsId(String tdsId) {
		this.tdsId = tdsId;
	}

	public String getTdsType() {
		return tdsType;
	}

	public void setTdsType(String tdsType) {
		this.tdsType = tdsType;
	}

	public Double getTdsRate() {
		return tdsRate;
	}

	public void setTdsRate(Double tdsRate) {
		this.tdsRate = tdsRate;
	}

	public Boolean getTdsStatus() {
		return tdsStatus;
	}

	public void setTdsStatus(Boolean tdsStatus) {
		this.tdsStatus = tdsStatus;
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
