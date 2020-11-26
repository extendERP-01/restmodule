package nirmalya.aatithya.restmodule.sales.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestsalesDataSetPriceModel {

	private String ptype1;

	private String ptype2;

	private String itemCat;

	private String itemSubCat;

	private String key;

	private String name;

	private Double price;

	private Double quantity;

	private Double gstRate;

	private Boolean taxType;

	private Double deliverdItemNo;

	private Double advAmount;
	 

	public RestsalesDataSetPriceModel() {
		super();
	}

	public RestsalesDataSetPriceModel(Object itemCat , Object itemSubCat, Object key, Object name, Object price, Object quantity, Object gstRate,
			Object taxType, Object deliverdItemNo, Object advAmount) {
		super();
		try {
			this.itemCat = (String) itemCat;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemSubCat = (String) itemSubCat;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.key = (String) key;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.name = (String) name;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.price = (Double) price;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.quantity = (Double) quantity;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.gstRate = (Double) gstRate;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.taxType = (Boolean) taxType;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.deliverdItemNo = (Double) deliverdItemNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.advAmount = (Double) advAmount;
		} catch (Exception e) {
			e.getSuppressed();
		}
	}

	public Double getDeliverdItemNo() {
		return deliverdItemNo;
	}

	public void setDeliverdItemNo(Double deliverdItemNo) {
		this.deliverdItemNo = deliverdItemNo;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getGstRate() {
		return gstRate;
	}

	public void setGstRate(Double gstRate) {
		this.gstRate = gstRate;
	}

	public Boolean getTaxType() {
		return taxType;
	}

	public void setTaxType(Boolean taxType) {
		this.taxType = taxType;
	}

	public String getPtype1() {
		return ptype1;
	}

	public void setPtype1(String ptype1) {
		this.ptype1 = ptype1;
	}

	public String getPtype2() {
		return ptype2;
	}

	public void setPtype2(String ptype2) {
		this.ptype2 = ptype2;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getItemCat() {
		return itemCat;
	}

	public String getItemSubCat() {
		return itemSubCat;
	}

	public void setItemCat(String itemCat) {
		this.itemCat = itemCat;
	}

	public void setItemSubCat(String itemSubCat) {
		this.itemSubCat = itemSubCat;
	}

	public Double getAdvAmount() {
		return advAmount;
	}

	public void setAdvAmount(Double advAmount) {
		this.advAmount = advAmount;
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
