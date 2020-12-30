package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class InventoryDataForDblValModel {

	private String key;

	private Double minStock;
	private Double totalReq;
	private Double availQnt;
	private String subGruop;
	private String saleSubGruop;

	public InventoryDataForDblValModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventoryDataForDblValModel(Object key, Object minStock, Object totalReq, Object availQnt, Object subGruop,
			Object saleSubGruop) {
		super();
		try {
			this.key = (String) key;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.minStock = (Double) minStock;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.totalReq = (Double) totalReq;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.availQnt = (Double) availQnt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.subGruop = (String) subGruop;
		this.saleSubGruop = (String) saleSubGruop;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Double getMinStock() {
		return minStock;
	}

	public void setMinStock(Double minStock) {
		this.minStock = minStock;
	}

	public Double getTotalReq() {
		return totalReq;
	}

	public void setTotalReq(Double totalReq) {
		this.totalReq = totalReq;
	}

	public Double getAvailQnt() {
		return availQnt;
	}

	public void setAvailQnt(Double availQnt) {
		this.availQnt = availQnt;
	}

	public String getSubGruop() {
		return subGruop;
	}

	public void setSubGruop(String subGruop) {
		this.subGruop = subGruop;
	}

	public String getSaleSubGruop() {
		return saleSubGruop;
	}

	public void setSaleSubGruop(String saleSubGruop) {
		this.saleSubGruop = saleSubGruop;
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
