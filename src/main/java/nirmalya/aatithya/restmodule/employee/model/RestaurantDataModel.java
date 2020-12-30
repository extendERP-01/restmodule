package nirmalya.aatithya.restmodule.employee.model;

public class RestaurantDataModel {
	private String resId;
	private String resName;

	public RestaurantDataModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestaurantDataModel(Object resId, Object resName) {
		super();
		this.resId = (String) resId;
		this.resName = (String) resName;

	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

}
