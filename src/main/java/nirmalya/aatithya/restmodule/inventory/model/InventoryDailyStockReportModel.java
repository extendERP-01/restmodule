package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class InventoryDailyStockReportModel {

	private List<String> dates;
	private String itemName;
	private List<String> values;

	public InventoryDailyStockReportModel() {
		super();
	}

	public InventoryDailyStockReportModel(List<String> dates, String itemName, List<String> values) {
		super();
		this.dates = dates;
		this.itemName = itemName;
		this.values = values;
	}

	public List<String> getDates() {
		return dates;
	}

	public void setDates(List<String> dates) {
		this.dates = dates;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
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
