package nirmalya.aatithya.restmodule.sales.model;

public class CustomerGSTDataModel {
	
	private String key;
	private String name;
	private Boolean gstType;
	public CustomerGSTDataModel() {
		super();
	}
	public CustomerGSTDataModel(Object key, Object name, Object gstType) {
		super();
		this.key = (String) key;
		this.name = (String) name;
		this.gstType = (Boolean) gstType;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getGstType() {
		return gstType;
	}
	public void setGstType(Boolean gstType) {
		this.gstType = gstType;
	}

}
