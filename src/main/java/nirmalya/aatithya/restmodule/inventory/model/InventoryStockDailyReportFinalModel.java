package nirmalya.aatithya.restmodule.inventory.model;

import java.util.List;

public class InventoryStockDailyReportFinalModel {
	private List<String> dates;
	private List<InventoryStockDailyReportModel> dataList;

	public InventoryStockDailyReportFinalModel() {
		super();

	}

	public List<InventoryStockDailyReportModel> getDataList() {
		return dataList;
	}

	public void setDataList(List<InventoryStockDailyReportModel> dataList) {
		this.dataList = dataList;
	}

	public List<String> getDates() {
		return dates;
	}

	public void setDates(List<String> dates) {
		this.dates = dates;
	}

}
