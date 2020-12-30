package nirmalya.aatithya.restmodule.inventory.model;

public class InventoryGetDailyDataModel {

	private String itemName;
	private String dates;
	private Double value;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public InventoryGetDailyDataModel(Object itemName, Object dates, Object value) {
		super();
		this.itemName = (String) itemName;
		this.dates = (String) dates;
		this.value = (Double) value;
	}

	public InventoryGetDailyDataModel() {
		super();

	}

}
