package nirmalya.aatithya.restmodule.sales.model;

public class SalesPaymentModel {

	private Double grandTotal;
	
	private String payMode;
	
	private String payRefNo;
	
	private String createdDate;

	public SalesPaymentModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SalesPaymentModel(Object grandTotal, Object payMode, Object payRefNo, Object createdDate) {
		super();
		try {
			this.grandTotal = (Double) grandTotal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.payMode = (String) payMode;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.payRefNo = (String) payRefNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.createdDate = (String) createdDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public String getPayRefNo() {
		return payRefNo;
	}

	public void setPayRefNo(String payRefNo) {
		this.payRefNo = payRefNo;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
}
