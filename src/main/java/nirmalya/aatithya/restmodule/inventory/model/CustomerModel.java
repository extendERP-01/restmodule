package nirmalya.aatithya.restmodule.inventory.model;

public class CustomerModel {
	
	private String customerName;
	private String customerId;
	
	
	
	public CustomerModel(Object m, Object m2) {
		super();
		
		this.customerId = (String) m2;
		this.customerName = (String) m ;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "CustomerModel [customerName=" + customerName + ", customerId=" + customerId + "]";
	}
	
}
