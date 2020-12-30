package nirmalya.aatithya.restmodule.sales.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SalesOrdeReportModel {

	private String salesOrder;
	
	private String sOrderDate;
	
	private Boolean salesOrderActive;
	
	private String rcvDate;
	
	private String rcvTime;
	
	private String customer;

	public SalesOrdeReportModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SalesOrdeReportModel(Object salesOrder, Object sOrderDate, Object salesOrderActive, Object rcvDate,
			Object rcvTime, Object customer) {
		super();
		this.salesOrder = (String) salesOrder;
		this.sOrderDate = (String) sOrderDate;
		this.salesOrderActive = (Boolean) salesOrderActive;
		this.rcvDate = (String) rcvDate;
		this.rcvTime = (String) rcvTime;
		this.customer = (String) customer;
	}

	public String getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(String salesOrder) {
		this.salesOrder = salesOrder;
	}

	public String getsOrderDate() {
		return sOrderDate;
	}

	public void setsOrderDate(String sOrderDate) {
		this.sOrderDate = sOrderDate;
	}

	public Boolean getSalesOrderActive() {
		return salesOrderActive;
	}

	public void setSalesOrderActive(Boolean salesOrderActive) {
		this.salesOrderActive = salesOrderActive;
	}

	public String getRcvDate() {
		return rcvDate;
	}

	public void setRcvDate(String rcvDate) {
		this.rcvDate = rcvDate;
	}

	public String getRcvTime() {
		return rcvTime;
	}

	public void setRcvTime(String rcvTime) {
		this.rcvTime = rcvTime;
	}
	
	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
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
