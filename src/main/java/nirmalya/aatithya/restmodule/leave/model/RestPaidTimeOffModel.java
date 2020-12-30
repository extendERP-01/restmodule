package nirmalya.aatithya.restmodule.leave.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestPaidTimeOffModel {

	private String paidId;// primary key

	private String leaveType;

	private String empl;

	private String leavePeriod;

	private Double leavePeriodAmt;

	private String note;

	private String createdOn;

	private String updateOn;

	private String createdBy;

	public RestPaidTimeOffModel() {
		super();
	}

	public RestPaidTimeOffModel(Object paidId, Object leaveType, Object empl, Object leavePeriod, Object leavePeriodAmt,
			Object note) {
		super();
		try {
			this.paidId = (String) paidId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.leaveType = (String) leaveType;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.empl = (String) empl;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.leavePeriod = (String) leavePeriod;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.leavePeriodAmt = (Double) leavePeriodAmt;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.note = (String) note;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getPaidId() {
		return paidId;
	}

	public void setPaidId(String paidId) {
		this.paidId = paidId;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getEmpl() {
		return empl;
	}

	public void setEmpl(String empl) {
		this.empl = empl;
	}

	public String getLeavePeriod() {
		return leavePeriod;
	}

	public void setLeavePeriod(String leavePeriod) {
		this.leavePeriod = leavePeriod;
	}

	public Double getLeavePeriodAmt() {
		return leavePeriodAmt;
	}

	public void setLeavePeriodAmt(Double leavePeriodAmt) {
		this.leavePeriodAmt = leavePeriodAmt;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdateOn() {
		return updateOn;
	}

	public void setUpdateOn(String updateOn) {
		this.updateOn = updateOn;
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
