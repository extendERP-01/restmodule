package nirmalya.aatithya.restmodule.leave.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestLeaveEmpEntitleModel {

	private String empl;

	private String leaveTypeName;

	private String leavePeriodName;

	private Double totalLeaveDays;

	private Double totalPending;

	private Double totalApproved;

	private Double totalRejected;

	private Double totalCancelled;

	private String totalApplicableLeaves;

	private boolean canApplyMoreLeave;

	public RestLeaveEmpEntitleModel() {
		super();
	}

	public RestLeaveEmpEntitleModel(Object empl, Object leaveTypeName, Object leavePeriodName, Object totalLeaveDays,
			Object totalPending, Object totalApproved, Object totalRejected, Object totalCancelled,
			Object totalApplicableLeaves, Object canApplyMoreLeave) {
		super();
		try {
			this.empl = (String) empl;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.leaveTypeName = (String) leaveTypeName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.leavePeriodName = (String) leavePeriodName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.totalLeaveDays = (Double) totalLeaveDays;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.totalPending = (Double) totalPending;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.totalApproved = (Double) totalApproved;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.totalRejected = (Double) totalRejected;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.totalCancelled = (Double) totalCancelled;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.totalApplicableLeaves = (String) totalApplicableLeaves;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.canApplyMoreLeave = (boolean) canApplyMoreLeave;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getEmpl() {
		return empl;
	}

	public void setEmpl(String empl) {
		this.empl = empl;
	}

	public String getLeaveTypeName() {
		return leaveTypeName;
	}

	public void setLeaveTypeName(String leaveTypeName) {
		this.leaveTypeName = leaveTypeName;
	}

	public String getLeavePeriodName() {
		return leavePeriodName;
	}

	public void setLeavePeriodName(String leavePeriodName) {
		this.leavePeriodName = leavePeriodName;
	}

	public Double getTotalLeaveDays() {
		return totalLeaveDays;
	}

	public void setTotalLeaveDays(Double totalLeaveDays) {
		this.totalLeaveDays = totalLeaveDays;
	}

	public Double getTotalPending() {
		return totalPending;
	}

	public void setTotalPending(Double totalPending) {
		this.totalPending = totalPending;
	}

	public Double getTotalApproved() {
		return totalApproved;
	}

	public void setTotalApproved(Double totalApproved) {
		this.totalApproved = totalApproved;
	}

	public Double getTotalRejected() {
		return totalRejected;
	}

	public void setTotalRejected(Double totalRejected) {
		this.totalRejected = totalRejected;
	}

	public Double getTotalCancelled() {
		return totalCancelled;
	}

	public void setTotalCancelled(Double totalCancelled) {
		this.totalCancelled = totalCancelled;
	}

	public String getTotalApplicableLeaves() {
		return totalApplicableLeaves;
	}

	public void setTotalApplicableLeaves(String totalApplicableLeaves) {
		this.totalApplicableLeaves = totalApplicableLeaves;
	}

	public boolean isCanApplyMoreLeave() {
		return canApplyMoreLeave;
	}

	public void setCanApplyMoreLeave(boolean canApplyMoreLeave) {
		this.canApplyMoreLeave = canApplyMoreLeave;
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
