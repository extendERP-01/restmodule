package nirmalya.aatithya.restmodule.property.model;

public class AssetItemModel {

	private String key;
	private String name;
	private String category;
	public AssetItemModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AssetItemModel(Object key, Object name, Object category) {
		super();
		this.key = (String) key;
		this.name = (String) name;
		this.category = (String) category;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
