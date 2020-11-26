/**
 * Defines State table entity
 *
 */

package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * @author Nirmalya Labs
 *
 */
public class UserStateModel {
	private String stateId;
	
	private String stateName;
	
	private Boolean stateStatus;
	
	private Date stateCreatedOn;
	
	private Date stateUpdatedOn;
	
    private String createdBy;
    
    private String countryName;
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	
	public UserStateModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserStateModel(Object stateId, Object stateName,  Object stateStatus,
			Object stateCreatedOn, Object countryName) {
		super();
		try {
			this.stateId = (String) stateId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.stateName = (String) stateName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		try {
			this.stateStatus = (Boolean) stateStatus;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.stateCreatedOn = (Date) stateCreatedOn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.countryName = (String) countryName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Boolean getStateStatus() {
		return stateStatus;
	}

	public void setStateStatus(Boolean stateStatus) {
		this.stateStatus = stateStatus;
	}

	public Date getStateCreatedOn() {
		return stateCreatedOn;
	}

	public void setStateCreatedOn(Date stateCreatedOn) {
		this.stateCreatedOn = stateCreatedOn;
	}

	public Date getStateUpdatedOn() {
		return stateUpdatedOn;
	}

	public void setStateUpdatedOn(Date stateUpdatedOn) {
		this.stateUpdatedOn = stateUpdatedOn;
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
