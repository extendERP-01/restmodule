/**
 * 
 */
package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author NirmalyaLabs
 *
 */
public class RestMasterCountryModel {
	
	private String countryId;
	private String countryName; 
	private String countryCode;
	private Boolean countryActive; 
	private String countryCreatedBy; 
	private String countryUpdatedOn;
	
	public RestMasterCountryModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RestMasterCountryModel( Object countryId,Object countryName, Object countryCode, Object countryActive,
			Object countryCreatedBy, Object countryUpdatedOn) {
		super();

		try{
			this.countryId = (String) countryId;	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			this.countryName = (String) countryName;	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			this.countryCode = (String) countryCode;	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			this.countryActive = (Boolean) countryActive;	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			this.countryCreatedBy = (String) countryCreatedBy;	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			this.countryUpdatedOn = (String) countryUpdatedOn;
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}

		
	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}



	public String getCountryName() {
		return countryName;
	}
	
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public Boolean getCountryActive() {
		return countryActive;
	}
	
	public void setCountryActive(Boolean countryActive) {
		this.countryActive = countryActive;
	}
	
	public String getCountryCreatedBy() {
		return countryCreatedBy;
	}
	
	public void setCountryCreatedBy(String countryCreatedBy) {
		this.countryCreatedBy = countryCreatedBy;
	}
	
	public String getCountryUpdatedOn() {
		return countryUpdatedOn;
	}
	
	public void setCountryUpdatedOn(String countryUpdatedOn) {
		this.countryUpdatedOn = countryUpdatedOn;
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
