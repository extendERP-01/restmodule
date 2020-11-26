/**
 * Defines work week master model
 *
 */
package nirmalya.aatithya.restmodule.attendance.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Nirmalya Labs
 *
 */
public class RestWorkWeekMasterModel {

	private String tWorkDay;
	private String tWorkDayName;
	private String tWorkDayStatus;
	private String tCompanyId;
	private String tWorkDayCreatedBy;
	private String tWorkDayCreatedOn;

	public RestWorkWeekMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestWorkWeekMasterModel(Object tWorkDay, Object tWorkDayName, Object tWorkDayStatus, Object tCompanyId,
			Object tWorkDayCreatedBy, Object tWorkDayCreatedOn) {
		super();
		try {
			this.tWorkDay = (String) tWorkDay;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.tWorkDayName = (String) tWorkDayName;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.tWorkDayStatus = (String) tWorkDayStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tCompanyId = (String) tCompanyId;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.tWorkDayCreatedBy = (String) tWorkDayCreatedBy;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.tWorkDayCreatedOn = (String) tWorkDayCreatedOn;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String gettWorkDay() {
		return tWorkDay;
	}

	public void settWorkDay(String tWorkDay) {
		this.tWorkDay = tWorkDay;
	}

	public String gettWorkDayName() {
		return tWorkDayName;
	}

	public void settWorkDayName(String tWorkDayName) {
		this.tWorkDayName = tWorkDayName;
	}

	public String gettWorkDayStatus() {
		return tWorkDayStatus;
	}

	public void settWorkDayStatus(String tWorkDayStatus) {
		this.tWorkDayStatus = tWorkDayStatus;
	}

	public String gettCompanyId() {
		return tCompanyId;
	}

	public void settCompanyId(String tCompanyId) {
		this.tCompanyId = tCompanyId;
	}

	public String gettWorkDayCreatedBy() {
		return tWorkDayCreatedBy;
	}

	public void settWorkDayCreatedBy(String tWorkDayCreatedBy) {
		this.tWorkDayCreatedBy = tWorkDayCreatedBy;
	}

	public String gettWorkDayCreatedOn() {
		return tWorkDayCreatedOn;
	}

	public void settWorkDayCreatedOn(String tWorkDayCreatedOn) {
		this.tWorkDayCreatedOn = tWorkDayCreatedOn;
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
