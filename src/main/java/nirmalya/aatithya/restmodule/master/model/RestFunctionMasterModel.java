package nirmalya.aatithya.restmodule.master.model;

public class RestFunctionMasterModel {

	private String tFunction;
	private String tModule;
	private String tFunctnName;
	private String tFunctnDescription;
	private Boolean tFunctnStatus;
	private String tFunctnCreatedBy;
	private String tFunctionLogo;

	public RestFunctionMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestFunctionMasterModel(Object tFunction, Object tModule, Object tFunctnName, Object tFunctnDescription,
			Object tFunctnStatus,Object tFunctionLogo) {
		super();

		try {
			this.tFunction = (String) tFunction;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tModule = (String) tModule;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tFunctnName = (String) tFunctnName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tFunctnDescription = (String) tFunctnDescription;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tFunctnStatus = (Boolean) tFunctnStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tFunctionLogo = (String) tFunctionLogo;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String gettFunction() {
		return tFunction;
	}

	public void settFunction(String tFunction) {
		this.tFunction = tFunction;
	}

	public String gettModule() {
		return tModule;
	}

	public void settModule(String tModule) {
		this.tModule = tModule;
	}

	public String gettFunctnName() {
		return tFunctnName;
	}

	public void settFunctnName(String tFunctnName) {
		this.tFunctnName = tFunctnName;
	}

	public String gettFunctnDescription() {
		return tFunctnDescription;
	}

	public void settFunctnDescription(String tFunctnDescription) {
		this.tFunctnDescription = tFunctnDescription;
	}

	public Boolean gettFunctnStatus() {
		return tFunctnStatus;
	}

	public void settFunctnStatus(Boolean tFunctnStatus) {
		this.tFunctnStatus = tFunctnStatus;
	}

	public String gettFunctnCreatedBy() {
		return tFunctnCreatedBy;
	}

	public void settFunctnCreatedBy(String tFunctnCreatedBy) {
		this.tFunctnCreatedBy = tFunctnCreatedBy;
	}

	public String gettFunctionLogo() {
		return tFunctionLogo;
	}

	public void settFunctionLogo(String tFunctionLogo) {
		this.tFunctionLogo = tFunctionLogo;
	}
	

}
