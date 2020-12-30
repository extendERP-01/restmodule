package nirmalya.aatithya.restmodule.leave.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestLeaveTypeModel {
	
	private String lTypeId;//primary key
	
	private String lTypeName; 
	
	private Double lTypePeriod; 
	
	private Boolean isadminAssign;
	
	private Boolean isEmpApply;
	
	private Boolean isEmpAlyMoreThanALeave;
	
	private Boolean lAccrueEnb;
	
	private Boolean lCarriedFwd;
	
	private Double lCarriedFwdPercnt;
	
	private Double maxCaryFwdAmt; 
	
	private String carryFwdPeriod; 
	
	private Boolean properLeaveJDate;
	
	private Boolean sentEmailNotify;
	 
	private Boolean lTypeStatus;
	
    private String lTypeCreatedOn;
	
	private String lTypeUpdateOn;
	
	private String createdBy; 
	
	public RestLeaveTypeModel() {
		super();
	}
	
	public RestLeaveTypeModel(Object lTypeId,  Object lTypeName, Object lTypePeriod, Object isadminAssign, Object isEmpApply,
			Object isEmpAlyMoreThanALeave,Object lAccrueEnb, Object lCarriedFwd, Object lCarriedFwdPercnt,
			Object maxCaryFwdAmt,Object carryFwdPeriod,Object properLeaveJDate,Object sentEmailNotify,Object lTypeStatus) {
		super();
		try {
			this.lTypeId = (String) lTypeId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.lTypeName = (String) lTypeName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.lTypePeriod = (Double) lTypePeriod;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.isadminAssign = (Boolean) isadminAssign;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.isEmpApply = (Boolean) isEmpApply;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.isEmpApply = (Boolean) isEmpApply;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.isEmpAlyMoreThanALeave = (Boolean) isEmpAlyMoreThanALeave;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.lAccrueEnb = (Boolean) lAccrueEnb;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.lCarriedFwd = (Boolean) lCarriedFwd;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.lCarriedFwdPercnt = (Double) lCarriedFwdPercnt;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.maxCaryFwdAmt = (Double) maxCaryFwdAmt;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.carryFwdPeriod = (String) carryFwdPeriod;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		try {
			this.properLeaveJDate = (Boolean) properLeaveJDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.sentEmailNotify = (Boolean) sentEmailNotify;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.lTypeStatus = (Boolean) lTypeStatus;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public String getlTypeId() {
		return lTypeId;
	}

	public void setlTypeId(String lTypeId) {
		this.lTypeId = lTypeId;
	}

	public String getlTypeName() {
		return lTypeName;
	}

	public void setlTypeName(String lTypeName) {
		this.lTypeName = lTypeName;
	}

	public Double getlTypePeriod() {
		return lTypePeriod;
	}

	public void setlTypePeriod(Double lTypePeriod) {
		this.lTypePeriod = lTypePeriod;
	}

	public Boolean getIsadminAssign() {
		return isadminAssign;
	}

	public void setIsadminAssign(Boolean isadminAssign) {
		this.isadminAssign = isadminAssign;
	}

	public Boolean getIsEmpApply() {
		return isEmpApply;
	}

	public void setIsEmpApply(Boolean isEmpApply) {
		this.isEmpApply = isEmpApply;
	}

	public Boolean getIsEmpAlyMoreThanALeave() {
		return isEmpAlyMoreThanALeave;
	}

	public void setIsEmpAlyMoreThanALeave(Boolean isEmpAlyMoreThanALeave) {
		this.isEmpAlyMoreThanALeave = isEmpAlyMoreThanALeave;
	}

	public Boolean getlAccrueEnb() {
		return lAccrueEnb;
	}

	public void setlAccrueEnb(Boolean lAccrueEnb) {
		this.lAccrueEnb = lAccrueEnb;
	}

	public Boolean getlCarriedFwd() {
		return lCarriedFwd;
	}

	public void setlCarriedFwd(Boolean lCarriedFwd) {
		this.lCarriedFwd = lCarriedFwd;
	}

	public Double getlCarriedFwdPercnt() {
		return lCarriedFwdPercnt;
	}

	public void setlCarriedFwdPercnt(Double lCarriedFwdPercnt) {
		this.lCarriedFwdPercnt = lCarriedFwdPercnt;
	}

	public Double getMaxCaryFwdAmt() {
		return maxCaryFwdAmt;
	}

	public void setMaxCaryFwdAmt(Double maxCaryFwdAmt) {
		this.maxCaryFwdAmt = maxCaryFwdAmt;
	}
	
	public String getCarryFwdPeriod() {
		return carryFwdPeriod;
	}

	public void setCarryFwdPeriod(String carryFwdPeriod) {
		this.carryFwdPeriod = carryFwdPeriod;
	}

	public Boolean getProperLeaveJDate() {
		return properLeaveJDate;
	}

	public void setProperLeaveJDate(Boolean properLeaveJDate) {
		this.properLeaveJDate = properLeaveJDate;
	}

	public Boolean getSentEmailNotify() {
		return sentEmailNotify;
	}

	public void setSentEmailNotify(Boolean sentEmailNotify) {
		this.sentEmailNotify = sentEmailNotify;
	}

	 

	public Boolean getlTypeStatus() {
		return lTypeStatus;
	}

	public void setlTypeStatus(Boolean lTypeStatus) {
		this.lTypeStatus = lTypeStatus;
	}

	public String getlTypeCreatedOn() {
		return lTypeCreatedOn;
	}

	public void setlTypeCreatedOn(String lTypeCreatedOn) {
		this.lTypeCreatedOn = lTypeCreatedOn;
	}

	public String getlTypeUpdateOn() {
		return lTypeUpdateOn;
	}

	public void setlTypeUpdateOn(String lTypeUpdateOn) {
		this.lTypeUpdateOn = lTypeUpdateOn;
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
