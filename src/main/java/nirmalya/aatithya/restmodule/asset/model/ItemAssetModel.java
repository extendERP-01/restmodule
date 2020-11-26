package nirmalya.aatithya.restmodule.asset.model;

public class ItemAssetModel {

	private String assetId;
	
	private String serialNo;
	
	private String category;

	public ItemAssetModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemAssetModel(Object assetId, Object serialNo, Object category) {
		super();
		this.assetId = (String) assetId;
		this.serialNo = (String) serialNo;
		this.category = (String) category;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
