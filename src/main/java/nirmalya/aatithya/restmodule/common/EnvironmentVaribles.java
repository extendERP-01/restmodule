package nirmalya.aatithya.restmodule.common;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Nirmalya Labs
 *
 */
public class EnvironmentVaribles {

	@Value("${service.url.mobileView}")
	private String mobileView;


	@Value("${service.url.uploadEmployee}")
	private String fileUploadEmployee;
	
	public EnvironmentVaribles() {
		super();
		// TODO Auto-generated constructor stub
	}

	 

	public String getMobileView() {
		return mobileView;
	}

	public String getFileUploadEmployee() {
		return fileUploadEmployee;
	}
	
	 
}
