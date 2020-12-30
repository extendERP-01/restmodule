package nirmalya.aatithya.restmodule.property.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PropertyAssignPropertyToStaffModel {

	private String costCenter;
	private String userRole;
	private String user;
	private List<String> propertyList = new ArrayList<String>();
	private String propertyListNames;
	private Boolean satffActive;
	private String editId;
	private String delete;
	private String costCenterId;
	private String userRoleId;
	private String userId;
	private String propertyNameId;
	private String createdBy;

	public PropertyAssignPropertyToStaffModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertyAssignPropertyToStaffModel(Object costCenter, Object userRole, Object user, Object propertyListNames,
			Object satffActive, Object costCenterId, Object userRoleId, Object userId, Object propertyNameId,
			Object createdBy) {
		super();
		try {
			this.costCenter = (String) costCenter;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.userRole = (String) userRole;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.user = (String) user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.propertyListNames = (String) propertyListNames;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.satffActive = (Boolean) satffActive;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.costCenterId = (String) costCenterId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.userRoleId = (String) userRoleId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.userId = (String) userId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.propertyNameId = (String) propertyNameId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.createdBy = (String) createdBy;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List<String> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(List<String> propertyList) {
		this.propertyList = propertyList;
	}

	public String getPropertyListNames() {
		return propertyListNames;
	}

	public void setPropertyListNames(String propertyListNames) {
		this.propertyListNames = propertyListNames;
	}

	public Boolean getSatffActive() {
		return satffActive;
	}

	public void setSatffActive(Boolean satffActive) {
		this.satffActive = satffActive;
	}

	public String getEditId() {
		return editId;
	}

	public void setEditId(String editId) {
		this.editId = editId;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public String getCostCenterId() {
		return costCenterId;
	}

	public void setCostCenterId(String costCenterId) {
		this.costCenterId = costCenterId;
	}

	public String getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPropertyNameId() {
		return propertyNameId;
	}

	public void setPropertyNameId(String propertyNameId) {
		this.propertyNameId = propertyNameId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
