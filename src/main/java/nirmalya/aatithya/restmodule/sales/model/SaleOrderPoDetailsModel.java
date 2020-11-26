package nirmalya.aatithya.restmodule.sales.model;

import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SaleOrderPoDetailsModel {

	private String poId;
	private String customerId;
	private String customerName;
	private String tin;
	private String rmcGrade;
	private String rmcGradeId;
	private String pumpService;
	private String pumpServiceId;
	private BigInteger noOfTrips;
	private Double noOfRmcGrade;
	private Double availCement;

	public SaleOrderPoDetailsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SaleOrderPoDetailsModel(Object poId, Object customerId, Object customerName, Object tin, Object rmcGrade,
			Object rmcGradeId, Object pumpService, Object pumpServiceId, Object noOfTrips, Object noOfRmcGrade,
			Object availCement) {
		super();
		this.poId = (String) poId;
		this.customerId = (String) customerId;
		this.customerName = (String) customerName;
		this.tin = (String) tin;
		this.rmcGrade = (String) rmcGrade;
		this.rmcGradeId = (String) rmcGradeId;
		this.pumpService = (String) pumpService;
		this.pumpServiceId = (String) pumpServiceId;
		this.noOfTrips = (BigInteger) noOfTrips;
		this.noOfRmcGrade = (Double) noOfRmcGrade;
		this.availCement = (Double) availCement;
	}

	public String getPoId() {
		return poId;
	}

	public void setPoId(String poId) {
		this.poId = poId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getTin() {
		return tin;
	}

	public void setTin(String tin) {
		this.tin = tin;
	}

	public String getRmcGrade() {
		return rmcGrade;
	}

	public void setRmcGrade(String rmcGrade) {
		this.rmcGrade = rmcGrade;
	}

	public String getPumpService() {
		return pumpService;
	}

	public void setPumpService(String pumpService) {
		this.pumpService = pumpService;
	}

	public String getRmcGradeId() {
		return rmcGradeId;
	}

	public void setRmcGradeId(String rmcGradeId) {
		this.rmcGradeId = rmcGradeId;
	}

	public String getPumpServiceId() {
		return pumpServiceId;
	}

	public void setPumpServiceId(String pumpServiceId) {
		this.pumpServiceId = pumpServiceId;
	}

	public BigInteger getNoOfTrips() {
		return noOfTrips;
	}

	public void setNoOfTrips(BigInteger noOfTrips) {
		this.noOfTrips = noOfTrips;
	}

	public Double getNoOfRmcGrade() {
		return noOfRmcGrade;
	}

	public void setNoOfRmcGrade(Double noOfRmcGrade) {
		this.noOfRmcGrade = noOfRmcGrade;
	}

	public Double getAvailCement() {
		return availCement;
	}

	public void setAvailCement(Double availCement) {
		this.availCement = availCement;
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
