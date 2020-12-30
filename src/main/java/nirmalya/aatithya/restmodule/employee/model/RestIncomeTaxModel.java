package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestIncomeTaxModel {
	private String tTaxId;
	private Double tMinValue;
	private Double tMaxValue;
	private Double tTaxRate;
	private Double tTaxableAmount;
	private String tCreatedBy;

	public RestIncomeTaxModel() {
		super();

	}

	public RestIncomeTaxModel(Object tTaxId, Object tMinValue, Object tMaxValue, Object tTaxRate,
			Object tTaxableAmount) {
		super();
		this.tTaxId = (String) tTaxId;
		this.tMinValue = (Double) tMinValue;
		this.tMaxValue = (Double) tMaxValue;
		this.tTaxRate = (Double) tTaxRate;
		this.tTaxableAmount = (Double) tTaxableAmount;
	}

	public String gettTaxId() {
		return tTaxId;
	}

	public void settTaxId(String tTaxId) {
		this.tTaxId = tTaxId;
	}

	public Double gettMinValue() {
		return tMinValue;
	}

	public void settMinValue(Double tMinValue) {
		this.tMinValue = tMinValue;
	}

	public Double gettMaxValue() {
		return tMaxValue;
	}

	public void settMaxValue(Double tMaxValue) {
		this.tMaxValue = tMaxValue;
	}

	public Double gettTaxRate() {
		return tTaxRate;
	}

	public void settTaxRate(Double tTaxRate) {
		this.tTaxRate = tTaxRate;
	}

	public String gettCreatedBy() {
		return tCreatedBy;
	}

	public void settCreatedBy(String tCreatedBy) {
		this.tCreatedBy = tCreatedBy;
	}

	public Double gettTaxableAmount() {
		return tTaxableAmount;
	}

	public void settTaxableAmount(Double tTaxableAmount) {
		this.tTaxableAmount = tTaxableAmount;
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
