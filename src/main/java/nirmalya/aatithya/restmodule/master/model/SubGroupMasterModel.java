package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SubGroupMasterModel {
	private String subGroupId;
	private String subGroupName;
	private String groupName;
	private String groupNameDesc;
	private String createdBy;
	public SubGroupMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SubGroupMasterModel(Object subGroupId, Object subGroupName, Object groupName,
			Object groupNameDesc) {
		super();
		
		try {
			this.subGroupId = (String) subGroupId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.subGroupName = (String) subGroupName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.groupName = (String) groupName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.groupNameDesc = (String) groupNameDesc;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getSubGroupId() {
		return subGroupId;
	}
	public void setSubGroupId(String subGroupId) {
		this.subGroupId = subGroupId;
	}
	public String getSubGroupName() {
		return subGroupName;
	}
	public void setSubGroupName(String subGroupName) {
		this.subGroupName = subGroupName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupNameDesc() {
		return groupNameDesc;
	}
	public void setGroupNameDesc(String groupNameDesc) {
		this.groupNameDesc = groupNameDesc;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@Override
	public String toString() {
		ObjectMapper  mapperObj=new ObjectMapper();
		String jsonStr;
		try{
			jsonStr=mapperObj.writeValueAsString(this);
		}catch(IOException ex){
			
			jsonStr=ex.toString();
		}
		return jsonStr;
	}
}