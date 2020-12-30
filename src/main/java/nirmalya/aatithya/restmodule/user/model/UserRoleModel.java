/**
 * Defines User Role table entity
 *
 */

package nirmalya.aatithya.restmodule.user.model;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * @author Nirmalya Labs
 *
 */
public class UserRoleModel {
	
	private String userRoleId;//primary key
	
	private String userRoleName;
	
//	private Byte userType;
	
	private String userCostCenter;
	
	private Boolean userRoleStatus;
	
	private String userDescription;
	
	private String userParentUserRole;
	
	private Boolean userParentRoleStatus;
	
    private Date districtCreatedOn;
	
	private Date districtUpdatedOn;
	
	private String moduleId;
	
	private String functionId;

	private String activityId;
	
	private String createdBy;
	
	

	public UserRoleModel() {
		super();
	}
	
//	public UserRoleModel(Object userRoleId,  Object userRoleName, Object userType, Object userCostCenter, 
//			Object userDescription, Object userParentUserRole, Object userRoleStatus) {
	public UserRoleModel(Object userRoleId,  Object userRoleName, Object userCostCenter, 
			Object userDescription, Object userParentUserRole, Object userRoleStatus) {
		super();
		try {
			this.userRoleId = (String) userRoleId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.userRoleName = (String) userRoleName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * try { this.userType = (Byte) userType; } catch (Exception e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		try {
			this.userCostCenter = (String) userCostCenter;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.userDescription = (String) userDescription;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.userParentUserRole = (String) userParentUserRole;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.userRoleStatus = (Boolean) userRoleStatus;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 

	}
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
	public String getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

//	public Byte getUserType() {
//		return userType;
//	}
//
//	public void setUserType(Byte userType) {
//		this.userType = userType;
//	}

	public String getUserCostCenter() {
		return userCostCenter;
	}

	public void setUserCostCenter(String userCostCenter) {
		this.userCostCenter = userCostCenter;
	}

	public Boolean getUserRoleStatus() {
		return userRoleStatus;
	}

	public void setUserRoleStatus(Boolean userRoleStatus) {
		this.userRoleStatus = userRoleStatus;
	}

	public String getUserDescription() {
		return userDescription;
	}

	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}

	public String getUserParentUserRole() {
		return userParentUserRole;
	}

	public void setUserParentUserRole(String userParentUserRole) {
		this.userParentUserRole = userParentUserRole;
	}

	public Boolean getUserParentRoleStatus() {
		return userParentRoleStatus;
	}

	public void setUserParentRoleStatus(Boolean userParentRoleStatus) {
		this.userParentRoleStatus = userParentRoleStatus;
	}

	public Date getDistrictCreatedOn() {
		return districtCreatedOn;
	}

	public void setDistrictCreatedOn(Date districtCreatedOn) {
		this.districtCreatedOn = districtCreatedOn;
	}

	public Date getDistrictUpdatedOn() {
		return districtUpdatedOn;
	}

	public void setDistrictUpdatedOn(Date districtUpdatedOn) {
		this.districtUpdatedOn = districtUpdatedOn;
	}
	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
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
