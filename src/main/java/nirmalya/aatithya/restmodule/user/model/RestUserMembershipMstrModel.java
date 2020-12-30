package nirmalya.aatithya.restmodule.user.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author nirmalya Labs
 *
 */
public class RestUserMembershipMstrModel {

	private String memId;
	private String memName;
	private Float memMonthlyFee;
	private Float memRegistrationFee;
	private String memDescription;
	private String memValidity;
	private Integer tDependentsLimit;
	private Integer tChildrenAgeLimit;
	private String tEffectiveFromDate;
	private Boolean memStatus;
	private String tCMemberTypCreatedBy;

	public RestUserMembershipMstrModel(Object memId, Object memName, Object memMonthlyFee, Object memRegistrationFee,
			Object memDescription, Object memValidity, Object tDependentsLimit, Object tChildrenAgeLimit,
			Object tEffectiveFromDate, Object memStatus, Object tCMemberTypCreatedBy) {
		super();
		try {
			this.memId = (String) memId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.memName = (String) memName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.memMonthlyFee = (Float) memMonthlyFee;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.memRegistrationFee = (Float) memRegistrationFee;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.memDescription = (String) memDescription;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.memValidity = (String) memValidity;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.tDependentsLimit = (Integer) tDependentsLimit;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.tChildrenAgeLimit = (Integer) tChildrenAgeLimit;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.tEffectiveFromDate = (String) tEffectiveFromDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.memStatus = (Boolean) memStatus;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.tCMemberTypCreatedBy = (String) tCMemberTypCreatedBy;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public RestUserMembershipMstrModel() {
		super();
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public Float getMemMonthlyFee() {
		return memMonthlyFee;
	}

	public void setMemMonthlyFee(Float memMonthlyFee) {
		this.memMonthlyFee = memMonthlyFee;
	}

	public Float getMemRegistrationFee() {
		return memRegistrationFee;
	}

	public void setMemRegistrationFee(Float memRegistrationFee) {
		this.memRegistrationFee = memRegistrationFee;
	}

	public String getMemDescription() {
		return memDescription;
	}

	public void setMemDescription(String memDescription) {
		this.memDescription = memDescription;
	}

	public String getMemValidity() {
		return memValidity;
	}

	public void setMemValidity(String memValidity) {
		this.memValidity = memValidity;
	}

	public Integer gettDependentsLimit() {
		return tDependentsLimit;
	}

	public void settDependentsLimit(Integer tDependentsLimit) {
		this.tDependentsLimit = tDependentsLimit;
	}

	public Integer gettChildrenAgeLimit() {
		return tChildrenAgeLimit;
	}

	public void settChildrenAgeLimit(Integer tChildrenAgeLimit) {
		this.tChildrenAgeLimit = tChildrenAgeLimit;
	}

	public String gettEffectiveFromDate() {
		return tEffectiveFromDate;
	}

	public void settEffectiveFromDate(String tEffectiveFromDate) {
		this.tEffectiveFromDate = tEffectiveFromDate;
	}

	public Boolean getMemStatus() {
		return memStatus;
	}

	public void setMemStatus(Boolean memStatus) {
		this.memStatus = memStatus;
	}

	public String gettCMemberTypCreatedBy() {
		return tCMemberTypCreatedBy;
	}

	public void settCMemberTypCreatedBy(String tCMemberTypCreatedBy) {
		this.tCMemberTypCreatedBy = tCMemberTypCreatedBy;
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
