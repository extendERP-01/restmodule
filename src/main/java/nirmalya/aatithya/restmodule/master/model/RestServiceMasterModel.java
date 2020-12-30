package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author NirmalyaLabs
 *
 */
public class RestServiceMasterModel {
	private String tServiceId;
	private String tServiceName;
	private String tServiceDesc;
	private Boolean tServiceStatus;
	private String tCreatedBy;

	public RestServiceMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestServiceMasterModel(Object tServiceId, Object tServiceName, Object tServiceDesc, Object tServiceStatus,
			Object tCreatedBy) {
		super();
		this.tServiceId = (String) tServiceId;
		this.tServiceName = (String) tServiceName;
		this.tServiceDesc = (String) tServiceDesc;
		this.tServiceStatus = (Boolean) tServiceStatus;
		this.tCreatedBy = (String) tCreatedBy;
	}

	public String gettServiceId() {
		return tServiceId;
	}

	public void settServiceId(String tServiceId) {
		this.tServiceId = tServiceId;
	}

	public String gettServiceName() {
		return tServiceName;
	}

	public void settServiceName(String tServiceName) {
		this.tServiceName = tServiceName;
	}

	public String gettServiceDesc() {
		return tServiceDesc;
	}

	public void settServiceDesc(String tServiceDesc) {
		this.tServiceDesc = tServiceDesc;
	}

	public Boolean gettServiceStatus() {
		return tServiceStatus;
	}

	public void settServiceStatus(Boolean tServiceStatus) {
		this.tServiceStatus = tServiceStatus;
	}

	public String gettCreatedBy() {
		return tCreatedBy;
	}

	public void settCreatedBy(String tCreatedBy) {
		this.tCreatedBy = tCreatedBy;
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
