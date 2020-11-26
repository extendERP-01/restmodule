/**
 * Defines work holiday master model
 *
 */
package nirmalya.aatithya.restmodule.attendance.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Nirmalya Labs
 *
 */
public class RestHolidayMasterModel {
	private String tHoliday;
	private String tHolidayName;
	private String tHolidayFromDate;
	private String tHolidayToDate;
	private String tHolidayStatus;
	private String tCompanyId;
	private String tHolidayCreatedBy;
	private String tHolidayCreatedOn;

	public RestHolidayMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestHolidayMasterModel(Object tHoliday, Object tHolidayName, Object tHolidayFromDate, Object tHolidayToDate,
			Object tHolidayStatus, Object tCompanyId, Object tHolidayCreatedBy, Object tHolidayCreatedOn) {
		super();

		try {
			this.tHoliday = (String) tHoliday;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tHolidayName = (String) tHolidayName;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.tHolidayFromDate = (String) tHolidayFromDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tHolidayToDate = (String) tHolidayToDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tHolidayStatus = (String) tHolidayStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tCompanyId = (String) tCompanyId;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.tHolidayCreatedBy = (String) tHolidayCreatedBy;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.tHolidayCreatedOn = (String) tHolidayCreatedOn;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String gettHoliday() {
		return tHoliday;
	}

	public void settHoliday(String tHoliday) {
		this.tHoliday = tHoliday;
	}

	public String gettHolidayName() {
		return tHolidayName;
	}

	public void settHolidayName(String tHolidayName) {
		this.tHolidayName = tHolidayName;
	}

	public String gettHolidayFromDate() {
		return tHolidayFromDate;
	}

	public void settHolidayFromDate(String tHolidayFromDate) {
		this.tHolidayFromDate = tHolidayFromDate;
	}

	public String gettHolidayToDate() {
		return tHolidayToDate;
	}

	public void settHolidayToDate(String tHolidayToDate) {
		this.tHolidayToDate = tHolidayToDate;
	}

	public String gettHolidayStatus() {
		return tHolidayStatus;
	}

	public void settHolidayStatus(String tHolidayStatus) {
		this.tHolidayStatus = tHolidayStatus;
	}

	public String gettCompanyId() {
		return tCompanyId;
	}

	public void settCompanyId(String tCompanyId) {
		this.tCompanyId = tCompanyId;
	}

	public String gettHolidayCreatedBy() {
		return tHolidayCreatedBy;
	}

	public void settHolidayCreatedBy(String tHolidayCreatedBy) {
		this.tHolidayCreatedBy = tHolidayCreatedBy;
	}

	public String gettHolidayCreatedOn() {
		return tHolidayCreatedOn;
	}

	public void settHolidayCreatedOn(String tHolidayCreatedOn) {
		this.tHolidayCreatedOn = tHolidayCreatedOn;
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
