package nirmalya.aatithya.restmodule.leave.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestLeaveApplyAdminModel {
	
	private String applyId;//primary key
	
	private String ltypeName; 
	
	private String empName; 
	
	private Double totalLeave; 

	private String lApplyStartDate;
	
	private String lApplyEndDate;
	
	private String lReason;
	
	private String lApplyStatus;
	
	private String lApplyShowActive;
	
	private String createdBy;

	public RestLeaveApplyAdminModel() {
		super();
	}
	
	public RestLeaveApplyAdminModel(Object applyId,Object empName,  Object ltypeName, 
			Object lApplyStartDate, Object lApplyEndDate, Object lApplyStatus) {
		super();
		try {
			this.applyId = (String) applyId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.empName = (String) empName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.ltypeName = (String) ltypeName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.empName = (String) empName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.totalLeave = (Double) totalLeave;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.lApplyStartDate = (String) lApplyStartDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.lApplyEndDate = (String) lApplyEndDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.lReason = (String) lReason;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.lApplyStatus = (String) lApplyStatus;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	public String getLtypeName() {
		return ltypeName;
	}

	public void setLtypeName(String ltypeName) {
		this.ltypeName = ltypeName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getTotalLeave() {
		return totalLeave;
	}

	public void setTotalLeave(Double totalLeave) {
		this.totalLeave = totalLeave;
	}

	public String getlApplyStartDate() {
		return lApplyStartDate;
	}

	public void setlApplyStartDate(String lApplyStartDate) {
		this.lApplyStartDate = lApplyStartDate;
	}

	public String getlApplyEndDate() {
		return lApplyEndDate;
	}

	public void setlApplyEndDate(String lApplyEndDate) {
		this.lApplyEndDate = lApplyEndDate;
	}

	public String getlReason() {
		return lReason;
	}

	public void setlReason(String lReason) {
		this.lReason = lReason;
	}

	public String getlApplyStatus() {
		return lApplyStatus;
	}

	public void setlApplyStatus(String lApplyStatus) {
		this.lApplyStatus = lApplyStatus;
	}

	public String getlApplyShowActive() {
		return lApplyShowActive;
	}

	public void setlApplyShowActive(String lApplyShowActive) {
		this.lApplyShowActive = lApplyShowActive;
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
