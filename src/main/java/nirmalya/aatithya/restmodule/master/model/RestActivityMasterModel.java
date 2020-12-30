package nirmalya.aatithya.restmodule.master.model;

/**
 * @author Nirmalya Labs
 *
 */
public class RestActivityMasterModel {

	private String tActivity;
	private String tModule;
	private String tFunction;
	private String tActvtyName;
	private String tActvtyDescription;
	private Boolean tActvtyStatus;
	private String tActvtyCreatedBy;

	public RestActivityMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestActivityMasterModel(Object tActivity, Object tModule, Object tFunction, Object tActvtyName,
			Object tActvtyDescription, Object tActvtyStatus,Object tActvtyCreatedBy) {
		super();

		try {
			this.tActivity = (String) tActivity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tModule = (String) tModule;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tFunction = (String) tFunction;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tActvtyName = (String) tActvtyName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tActvtyDescription = (String) tActvtyDescription;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tActvtyStatus = (Boolean) tActvtyStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tActvtyCreatedBy = (String) tActvtyCreatedBy;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String gettActivity() {
		return tActivity;
	}

	public void settActivity(String tActivity) {
		this.tActivity = tActivity;
	}

	public String gettModule() {
		return tModule;
	}

	public void settModule(String tModule) {
		this.tModule = tModule;
	}

	public String gettFunction() {
		return tFunction;
	}

	public void settFunction(String tFunction) {
		this.tFunction = tFunction;
	}

	public String gettActvtyName() {
		return tActvtyName;
	}

	public void settActvtyName(String tActvtyName) {
		this.tActvtyName = tActvtyName;
	}

	public String gettActvtyDescription() {
		return tActvtyDescription;
	}

	public void settActvtyDescription(String tActvtyDescription) {
		this.tActvtyDescription = tActvtyDescription;
	}

	public Boolean gettActvtyStatus() {
		return tActvtyStatus;
	}

	public void settActvtyStatus(Boolean tActvtyStatus) {
		this.tActvtyStatus = tActvtyStatus;
	}

	public String gettActvtyCreatedBy() {
		return tActvtyCreatedBy;
	}

	public void settActvtyCreatedBy(String tActvtyCreatedBy) {
		this.tActvtyCreatedBy = tActvtyCreatedBy;
	}
	

}
