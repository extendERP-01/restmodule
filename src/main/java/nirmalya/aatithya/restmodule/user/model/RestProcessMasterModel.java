/*
 * Defines user process master model
 *
 */
package nirmalya.aatithya.restmodule.user.model;

/*
 * @author Nirmalya Labs
 *
 */
public class RestProcessMasterModel {

	private String tProcess;
	private String tProcessName;
	private String tProcessDescription;
	private Boolean tProcessStatus;
	private String tProcessCreatedBy;

	public RestProcessMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestProcessMasterModel(Object tProcess, Object tProcessName, Object tProcessDescription,
			Object tProcessStatus, Object tProcessCreatedBy) {
		super();

		try {
			this.tProcess = (String) tProcess;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tProcessName = (String) tProcessName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tProcessDescription = (String) tProcessDescription;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tProcessStatus = (Boolean) tProcessStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.tProcessCreatedBy = (String) tProcessCreatedBy;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String gettProcess() {
		return tProcess;
	}

	public void settProcess(String tProcess) {
		this.tProcess = tProcess;
	}

	public String gettProcessName() {
		return tProcessName;
	}

	public void settProcessName(String tProcessName) {
		this.tProcessName = tProcessName;
	}

	public String gettProcessDescription() {
		return tProcessDescription;
	}

	public void settProcessDescription(String tProcessDescription) {
		this.tProcessDescription = tProcessDescription;
	}

	public Boolean gettProcessStatus() {
		return tProcessStatus;
	}

	public void settProcessStatus(Boolean tProcessStatus) {
		this.tProcessStatus = tProcessStatus;
	}

	public String gettProcessCreatedBy() {
		return tProcessCreatedBy;
	}

	public void settProcessCreatedBy(String tProcessCreatedBy) {
		this.tProcessCreatedBy = tProcessCreatedBy;
	}

}
