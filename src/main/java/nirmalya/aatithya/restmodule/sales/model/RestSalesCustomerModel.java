/**
 * 
 */
package nirmalya.aatithya.restmodule.sales.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author NirmalyaLabs
 *
 */
public class RestSalesCustomerModel {
	
	private String customerId;
	private String customerName; 
	private String customerEmail;
	private String customerPhone;
	private String customerAddress;
	private String customerCity;
	private String customerDistrict;
	private String customerState;
	private String customerCountry;
	private String customerZipCode;
	private String customerGSTNo;
	private String customerContactPerson;
	private Boolean customerActive; 
	private String customerCreatedBy; 
	private String customerUpdatedOn;
	private String customerAddress2;
	private String customerAddress3;
	private String customerPAN;
	
	public RestSalesCustomerModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestSalesCustomerModel( Object customerId, Object customerName, Object customerEmail, Object customerPhone,
			Object customerAddress, Object customerCity, Object customerDistrict, Object customerState, Object customerCountry, 
			Object customerZipCode, Object customerGSTNo, Object customerContactPerson, Object customerActive, Object customerCreatedBy,
			Object customerUpdatedOn, Object customerAddress2, Object customerAddress3, Object customerPAN) {
		
		
		super();

		try{
			this.customerId = (String) customerId;	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			this.customerName = (String) customerName;	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			this.customerEmail = (String) customerEmail;	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			this.customerPhone = (String) customerPhone;	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			this.customerAddress = (String) customerAddress;	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			this.customerCity = (String) customerCity;	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			this.customerDistrict = (String) customerDistrict;	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			this.customerState = (String) customerState;	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			this.customerCountry = (String) customerCountry;	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			this.customerZipCode = (String) customerZipCode;	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			this.customerGSTNo = (String) customerGSTNo;	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			this.customerContactPerson = (String) customerContactPerson;	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		try{
			this.customerActive = (Boolean) customerActive;	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			this.customerCreatedBy = (String) customerCreatedBy;	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			this.customerUpdatedOn = (String) customerUpdatedOn;
		}catch (Exception e){
			e.printStackTrace();
		}
		try{
			this.customerAddress2 = (String) customerAddress2;
		}catch (Exception e){
			e.printStackTrace();
		}
		try{
			this.customerAddress3 = (String) customerAddress3;
		}catch (Exception e){
			e.printStackTrace();
		}
		try{
			this.customerPAN = (String) customerPAN;
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getCustomerDistrict() {
		return customerDistrict;
	}

	public void setCustomerDistrict(String customerDistrict) {
		this.customerDistrict = customerDistrict;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	public String getCustomerCountry() {
		return customerCountry;
	}

	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}

	public String getCustomerZipCode() {
		return customerZipCode;
	}

	public void setCustomerZipCode(String customerZipCode) {
		this.customerZipCode = customerZipCode;
	}

	public String getCustomerGSTNo() {
		return customerGSTNo;
	}

	public void setCustomerGSTNo(String customerGSTNo) {
		this.customerGSTNo = customerGSTNo;
	}

	public String getCustomerContactPerson() {
		return customerContactPerson;
	}

	public void setCustomerContactPerson(String customerContactPerson) {
		this.customerContactPerson = customerContactPerson;
	}

	public Boolean getCustomerActive() {
		return customerActive;
	}

	public void setCustomerActive(Boolean customerActive) {
		this.customerActive = customerActive;
	}

	public String getCustomerCreatedBy() {
		return customerCreatedBy;
	}

	public void setCustomerCreatedBy(String customerCreatedBy) {
		this.customerCreatedBy = customerCreatedBy;
	}

	public String getCustomerUpdatedOn() {
		return customerUpdatedOn;
	}

	public void setCustomerUpdatedOn(String customerUpdatedOn) {
		this.customerUpdatedOn = customerUpdatedOn;
	}
	
	public String getCustomerAddress2() {
		return customerAddress2;
	}

	public void setCustomerAddress2(String customerAddress2) {
		this.customerAddress2 = customerAddress2;
	}

	public String getCustomerAddress3() {
		return customerAddress3;
	}

	public void setCustomerAddress3(String customerAddress3) {
		this.customerAddress3 = customerAddress3;
	}

	public String getCustomerPAN() {
		return customerPAN;
	}

	public void setCustomerPAN(String customerPAN) {
		this.customerPAN = customerPAN;
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
