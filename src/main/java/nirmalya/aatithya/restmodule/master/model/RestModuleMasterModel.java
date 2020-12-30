package nirmalya.aatithya.restmodule.master.model;

public class RestModuleMasterModel {

	private String tModule;
	private String tModlName;
	private String tModlDescription;
	private Boolean tModlStatus;
	private String tModlCreatedBy;
	private String tModuleLogo;

	public RestModuleMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestModuleMasterModel(Object tModule, Object tModlName, Object tModlDescription, Object tModlStatus,Object tModlCreatedBy ,Object tModuleLogo) {
		super();

		try {
			this.tModule = (String) tModule;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tModlName = (String) tModlName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tModlDescription = (String) tModlDescription;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tModlStatus = (Boolean) tModlStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			this.tModlCreatedBy = (String) tModlCreatedBy;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tModuleLogo = (String) tModuleLogo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public String gettModule() {
		return tModule;
	}

	public void settModule(String tModule) {
		this.tModule = tModule;
	}

	public String gettModlName() {
		return tModlName;
	}

	public void settModlName(String tModlName) {
		this.tModlName = tModlName;
	}

	public String gettModlDescription() {
		return tModlDescription;
	}

	public void settModlDescription(String tModlDescription) {
		this.tModlDescription = tModlDescription;
	}

	public Boolean gettModlStatus() {
		return tModlStatus;
	}

	public void settModlStatus(Boolean tModlStatus) {
		this.tModlStatus = tModlStatus;
	}

	public String gettModlCreatedBy() {
		return tModlCreatedBy;
	}

	public void settModlCreatedBy(String tModlCreatedBy) {
		this.tModlCreatedBy = tModlCreatedBy;
	}

	public String gettModuleLogo() {
		return tModuleLogo;
	}

	public void settModuleLogo(String tModuleLogo) {
		this.tModuleLogo = tModuleLogo;
	}
	
	

}
