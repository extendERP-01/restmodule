package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author NirmalyaLabs
 *
 */
public class RestGodownMasterModel {

	private String tGodown;
	private String tGodownName;
	private String tGodownDescription;
	private Boolean tGodownActive;
	private String tAddress;
	private String tCity;
	private String tDistrict;
	private String tState;
	private String tCountry;
	private String tPinCode;
	private String tPhoneNo;
	private String tGSTNo;
	private String tEmailId;
	private String tTinNo;
	private String tGodownLogo;
	private String createdBy;

	public RestGodownMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestGodownMasterModel(Object tGodown, Object tGodownName, Object tGodownDescription, Object tGodownActive,
			Object tAddress, Object tCity, Object tDistrict, Object tState, Object tCountry, Object tPinCode,
			Object tPhoneNo, Object tGSTNo, Object tEmailId, Object tTinNo, Object tGodownLogo, Object createdBy) {
		super();
		this.tGodown = (String)tGodown;
		this.tGodownName = (String)tGodownName;
		this.tGodownDescription = (String)tGodownDescription;
		this.tGodownActive =(Boolean) tGodownActive;
		this.tAddress = (String)tAddress;
		this.tCity = (String)tCity;
		this.tDistrict = (String)tDistrict;
		this.tState = (String)tState;
		this.tCountry = (String)tCountry;
		this.tPinCode = (String)tPinCode;
		this.tPhoneNo = (String)tPhoneNo;
		this.tGSTNo = (String)tGSTNo;
		this.tEmailId = (String)tEmailId;
		this.tTinNo = (String)tTinNo;
		this.tGodownLogo = (String)tGodownLogo;
		this.createdBy = (String)createdBy;
	}

	public String gettGodown() {
		return tGodown;
	}

	public void settGodown(String tGodown) {
		this.tGodown = tGodown;
	}

	public String gettGodownName() {
		return tGodownName;
	}

	public void settGodownName(String tGodownName) {
		this.tGodownName = tGodownName;
	}

	public String gettGodownDescription() {
		return tGodownDescription;
	}

	public void settGodownDescription(String tGodownDescription) {
		this.tGodownDescription = tGodownDescription;
	}

	public Boolean gettGodownActive() {
		return tGodownActive;
	}

	public void settGodownActive(Boolean tGodownActive) {
		this.tGodownActive = tGodownActive;
	}

	public String gettAddress() {
		return tAddress;
	}

	public void settAddress(String tAddress) {
		this.tAddress = tAddress;
	}

	public String gettCity() {
		return tCity;
	}

	public void settCity(String tCity) {
		this.tCity = tCity;
	}

	public String gettDistrict() {
		return tDistrict;
	}

	public void settDistrict(String tDistrict) {
		this.tDistrict = tDistrict;
	}

	public String gettState() {
		return tState;
	}

	public void settState(String tState) {
		this.tState = tState;
	}

	public String gettCountry() {
		return tCountry;
	}

	public void settCountry(String tCountry) {
		this.tCountry = tCountry;
	}

	public String gettPinCode() {
		return tPinCode;
	}

	public void settPinCode(String tPinCode) {
		this.tPinCode = tPinCode;
	}

	public String gettPhoneNo() {
		return tPhoneNo;
	}

	public void settPhoneNo(String tPhoneNo) {
		this.tPhoneNo = tPhoneNo;
	}

	public String gettGSTNo() {
		return tGSTNo;
	}

	public void settGSTNo(String tGSTNo) {
		this.tGSTNo = tGSTNo;
	}

	public String gettEmailId() {
		return tEmailId;
	}

	public void settEmailId(String tEmailId) {
		this.tEmailId = tEmailId;
	}

	public String gettTinNo() {
		return tTinNo;
	}

	public void settTinNo(String tTinNo) {
		this.tTinNo = tTinNo;
	}

	public String gettGodownLogo() {
		return tGodownLogo;
	}

	public void settGodownLogo(String tGodownLogo) {
		this.tGodownLogo = tGodownLogo;
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
