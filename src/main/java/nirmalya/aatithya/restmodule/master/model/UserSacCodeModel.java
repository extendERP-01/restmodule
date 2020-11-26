package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author USER
 *
 */
public class UserSacCodeModel {

	private String sacId;
	private String sacCodeName;
	private String sacService;
	private Double sacGST;
	private String sacDescription;
	private String sacEffDate;
	private Boolean sacActive;
	private Date sacCreatedOn;
	private Date sacUpdatedOn;
	private String sacServiceName;

	public UserSacCodeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserSacCodeModel(Object sacId, Object sacCodeName, Object sacService, Object sacGST, Object sacDescription,
			Object sacEffDate, Object sacActive, Object sacCreatedOn, Object sacUpdatedOn, Object sacServiceName) {
		super();
		this.sacId = (String) sacId;
		this.sacCodeName = (String) sacCodeName;
		this.sacService = (String) sacService;
		this.sacGST = (Double) sacGST;
		this.sacDescription = (String) sacDescription;
		this.sacEffDate = (String) sacEffDate;
		this.sacActive = (Boolean) sacActive;
		this.sacCreatedOn = (Date) sacCreatedOn;
		this.sacUpdatedOn = (Date) sacUpdatedOn;
		this.sacServiceName = (String) sacServiceName;
	}

	public String getSacId() {
		return sacId;
	}

	public void setSacId(String sacId) {
		this.sacId = sacId;
	}

	public String getSacCodeName() {
		return sacCodeName;
	}

	public void setSacCodeName(String sacCodeName) {
		this.sacCodeName = sacCodeName;
	}

	public String getSacService() {
		return sacService;
	}

	public void setSacService(String sacService) {
		this.sacService = sacService;
	}

	public Double getSacGST() {
		return sacGST;
	}

	public void setSacGST(Double sacGST) {
		this.sacGST = sacGST;
	}

	public String getSacDescription() {
		return sacDescription;
	}

	public void setSacDescription(String sacDescription) {
		this.sacDescription = sacDescription;
	}

	public String getSacEffDate() {
		return sacEffDate;
	}

	public void setSacEffDate(String sacEffDate) {
		this.sacEffDate = sacEffDate;
	}

	public Boolean getSacActive() {
		return sacActive;
	}

	public void setSacActive(Boolean sacActive) {
		this.sacActive = sacActive;
	}

	public Date getSacCreatedOn() {
		return sacCreatedOn;
	}

	public void setSacCreatedOn(Date sacCreatedOn) {
		this.sacCreatedOn = sacCreatedOn;
	}

	public Date getSacUpdatedOn() {
		return sacUpdatedOn;
	}

	public void setSacUpdatedOn(Date sacUpdatedOn) {
		this.sacUpdatedOn = sacUpdatedOn;
	}

	public String getSacServiceName() {
		return sacServiceName;
	}

	public void setSacServiceName(String sacServiceName) {
		this.sacServiceName = sacServiceName;
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
