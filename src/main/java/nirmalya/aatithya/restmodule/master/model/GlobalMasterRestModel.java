package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GlobalMasterRestModel {
	private String globalId;
	private String countryOrderId;
	private String countryCode;
	private String countryName;
	private String stateName;
	private String stateCode;
	private String stateOrderId;
	private String cityName;
	private String cityCode;
	private String cityOrderId;
	private String countryStatus;
	private String stateStatus;
	private String cityStatus;
	private String createdBy;

	public GlobalMasterRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GlobalMasterRestModel(Object globalId, Object countryOrderId, Object countryCode, Object countryName,
			Object stateName, Object stateCode, Object stateOrderId, Object cityName, Object cityCode, Object cityOrderId,
			Object countryStatus, Object stateStatus, Object cityStatus, Object createdBy) {
		super();
		this.globalId = (String) globalId;
		this.countryOrderId = (String) countryOrderId;
		this.countryCode = (String) countryCode;
		this.countryName = (String) countryName;
		this.stateName = (String) stateName;
		this.stateCode = (String) stateCode;
		this.stateOrderId = (String) stateOrderId;
		this.cityName = (String) cityName;
		this.cityCode = (String) cityCode;
		this.cityOrderId = (String) cityOrderId;
		this.countryStatus = (String) countryStatus;
		this.stateStatus = (String) stateStatus;
		this.cityStatus = (String) cityStatus;
		this.createdBy = (String) createdBy;
	}

	public String getGlobalId() {
		return globalId;
	}

	public void setGlobalId(String globalId) {
		this.globalId = globalId;
	}

	public String getCountryOrderId() {
		return countryOrderId;
	}

	public void setCountryOrderId(String countryOrderId) {
		this.countryOrderId = countryOrderId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateOrderId() {
		return stateOrderId;
	}

	public void setStateOrderId(String stateOrderId) {
		this.stateOrderId = stateOrderId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityOrderId() {
		return cityOrderId;
	}

	public void setCityOrderId(String cityOrderId) {
		this.cityOrderId = cityOrderId;
	}

	public String getCountryStatus() {
		return countryStatus;
	}

	public void setCountryStatus(String countryStatus) {
		this.countryStatus = countryStatus;
	}

	public String getStateStatus() {
		return stateStatus;
	}

	public void setStateStatus(String stateStatus) {
		this.stateStatus = stateStatus;
	}

	public String getCityStatus() {
		return cityStatus;
	}

	public void setCityStatus(String cityStatus) {
		this.cityStatus = cityStatus;
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
