/**
 * rest model for payment mode master
 * */
package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PaymentModeMasterModel {
private String paymentMode;
private String paytModName;
private String paytModDescription;
private Boolean payModActive;
private String payModCreatedBy;

public PaymentModeMasterModel() {
	super();
	// TODO Auto-generated constructor stub
	
}
public PaymentModeMasterModel(Object paymentMode, Object paytModName, Object paytModDescription, Object payModActive) {
	super();
	try {
		this.paymentMode = (String) paymentMode;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
		this.paytModName = (String) paytModName;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
		this.paytModDescription = (String) paytModDescription;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
		this.payModActive = (Boolean) payModActive;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public String getPaymentMode() {
	return paymentMode;
}
public void setPaymentMode(String paymentMode) {
	this.paymentMode = paymentMode;
}

public String getPaytModName() {
	return paytModName;
}
public void setPaytModName(String paytModName) {
	this.paytModName = paytModName;
}
public String getPaytModDescription() {
	return paytModDescription;
}
public void setPaytModDescription(String paytModDescription) {
	this.paytModDescription = paytModDescription;
}
public Boolean getPayModActive() {
	return payModActive;
}
public void setPayModActive(Boolean payModActive) {
	this.payModActive = payModActive;
}
public String getPayModCreatedBy() {
	return payModCreatedBy;
}
public void setPayModCreatedBy(String payModCreatedBy) {
	this.payModCreatedBy = payModCreatedBy;
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
