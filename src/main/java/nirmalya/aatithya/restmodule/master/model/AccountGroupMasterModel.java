package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AccountGroupMasterModel {
private String accGroup;
private String accGroupName;
private String accGroupCode;
private String accGrupDescription;
private Boolean accGrupActive;
private String accGrupCreatedBy;
public AccountGroupMasterModel() {
	super();
	// TODO Auto-generated constructor stub
}
public AccountGroupMasterModel(Object accGroup, Object accGroupName, Object accGroupCode, Object accGrupDescription, Object accGrupActive ) {
	super();
	try {
		this.accGroup = (String) accGroup;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
		this.accGroupName = (String) accGroupName;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
		this.accGroupCode = (String) accGroupCode;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
		this.accGrupDescription = (String) accGrupDescription;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		this.accGrupActive = (Boolean) accGrupActive;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public String getAccGroup() {
	return accGroup;
}
public void setAccGroup(String accGroup) {
	this.accGroup = accGroup;
}
public String getAccGroupName() {
	return accGroupName;
}
public void setAccGroupName(String accGroupName) {
	this.accGroupName = accGroupName;
}
public String getAccGroupCode() {
	return accGroupCode;
}
public void setAccGroupCode(String accGroupCode) {
	this.accGroupCode = accGroupCode;
}
public String getAccGrupDescription() {
	return accGrupDescription;
}
public void setAccGrupDescription(String accGrupDescription) {
	this.accGrupDescription = accGrupDescription;
}

public Boolean getAccGrupActive() {
	return accGrupActive;
}
public void setAccGrupActive(Boolean accGrupActive) {
	this.accGrupActive = accGrupActive;
}
public String getAccGrupCreatedBy() {
	return accGrupCreatedBy;
}
public void setAccGrupCreatedBy(String accGrupCreatedBy) {
	this.accGrupCreatedBy = accGrupCreatedBy;
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
