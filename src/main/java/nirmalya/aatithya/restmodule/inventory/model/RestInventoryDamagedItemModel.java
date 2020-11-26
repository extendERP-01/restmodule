package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;


import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author NirmalyaLabs
 *
 */
public class RestInventoryDamagedItemModel {
	private Integer tDamagedItemId;
	private String tItem;
	private String tItemSlNo;
	private String tDamagedDesc;
	private Boolean tStatus;
	private Double tItemReSaleValue;
	private String tVendor;
	private String tCreatedBy;

	public RestInventoryDamagedItemModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestInventoryDamagedItemModel(Object tDamagedItemId, Object tItem, Object tItemSlNo, Object tDamagedDesc,
			Object tStatus, Object tItemReSaleValue, Object tVendor, Object tCreatedBy) {
		super();
		this.tDamagedItemId = (Integer) tDamagedItemId;
		this.tItem = (String) tItem;
		this.tItemSlNo = (String) tItemSlNo;
		this.tDamagedDesc = (String) tDamagedDesc;
		this.tStatus = (Boolean) tStatus;
		this.tItemReSaleValue = (Double) tItemReSaleValue;
		this.tVendor = (String) tVendor;
		this.tCreatedBy = (String) tCreatedBy;
	}

	public Integer gettDamagedItemId() {
		return tDamagedItemId;
	}

	public void settDamagedItemId(Integer tDamagedItemId) {
		this.tDamagedItemId = tDamagedItemId;
	}

	public String gettItem() {
		return tItem;
	}

	public void settItem(String tItem) {
		this.tItem = tItem;
	}

	public String gettItemSlNo() {
		return tItemSlNo;
	}

	public void settItemSlNo(String tItemSlNo) {
		this.tItemSlNo = tItemSlNo;
	}

	public String gettDamagedDesc() {
		return tDamagedDesc;
	}

	public void settDamagedDesc(String tDamagedDesc) {
		this.tDamagedDesc = tDamagedDesc;
	}

	public Boolean gettStatus() {
		return tStatus;
	}

	public void settStatus(Boolean tStatus) {
		this.tStatus = tStatus;
	}

	public Double gettItemReSaleValue() {
		return tItemReSaleValue;
	}

	public void settItemReSaleValue(Double tItemReSaleValue) {
		this.tItemReSaleValue = tItemReSaleValue;
	}

	public String gettVendor() {
		return tVendor;
	}

	public void settVendor(String tVendor) {
		this.tVendor = tVendor;
	}

	public String gettCreatedBy() {
		return tCreatedBy;
	}

	public void settCreatedBy(String tCreatedBy) {
		this.tCreatedBy = tCreatedBy;
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
