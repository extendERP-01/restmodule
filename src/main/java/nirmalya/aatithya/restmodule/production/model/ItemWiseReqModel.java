package nirmalya.aatithya.restmodule.production.model;

public class ItemWiseReqModel {

	private String storeName;
	private String itemName;
	private String date;
	private Double storePatia;
	private Double storeSnagar;
	private Double storeBudharaja;
	private Double storeGoleBazar;
	private Double storeCityCenter;
	private Double storeAngul;
	private Double storeCuttack;
	private Double storeBargarh;
	private Double storeBeheramal;
	private Double storeSarabahal;

	public ItemWiseReqModel() {
		super();
	}

	public ItemWiseReqModel(  Object itemName, Object date, Object storePatia, Object storeSnagar,
			Object storeBudharaja, Object storeGoleBazar, Object storeCityCenter, Object storeAngul,
			Object storeCuttack, Object storeBargarh, Object storeBeheramal, Object storeSarabahal ,Object storeName) {
		super(); 
		this.itemName = (String) itemName;
		this.date = (String) date;
		this.storePatia = (Double) storePatia;
		this.storeSnagar = (Double) storeSnagar;
		this.storeBudharaja = (Double) storeBudharaja;
		this.storeGoleBazar = (Double) storeGoleBazar;
		this.storeCityCenter = (Double) storeCityCenter;
		this.storeAngul = (Double) storeAngul;
		this.storeCuttack = (Double) storeCuttack;
		this.storeBargarh = (Double) storeBargarh;
		this.storeBeheramal = (Double) storeBeheramal;
		this.storeSarabahal = (Double) storeSarabahal;
		this.storeName = (String) storeName;
	}

	public String getStoreName() {
		return storeName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getStorePatia() {
		return storePatia;
	}

	public void setStorePatia(Double storePatia) {
		this.storePatia = storePatia;
	}

	public Double getStoreSnagar() {
		return storeSnagar;
	}

	public void setStoreSnagar(Double storeSnagar) {
		this.storeSnagar = storeSnagar;
	}

	public Double getStoreBudharaja() {
		return storeBudharaja;
	}

	public void setStoreBudharaja(Double storeBudharaja) {
		this.storeBudharaja = storeBudharaja;
	}

	public Double getStoreGoleBazar() {
		return storeGoleBazar;
	}

	public void setStoreGoleBazar(Double storeGoleBazar) {
		this.storeGoleBazar = storeGoleBazar;
	}

	public Double getStoreCityCenter() {
		return storeCityCenter;
	}

	public void setStoreCityCenter(Double storeCityCenter) {
		this.storeCityCenter = storeCityCenter;
	}

	public Double getStoreAngul() {
		return storeAngul;
	}

	public void setStoreAngul(Double storeAngul) {
		this.storeAngul = storeAngul;
	}

	public Double getStoreCuttack() {
		return storeCuttack;
	}

	public void setStoreCuttack(Double storeCuttack) {
		this.storeCuttack = storeCuttack;
	}

	public Double getStoreBargarh() {
		return storeBargarh;
	}

	public void setStoreBargarh(Double storeBargarh) {
		this.storeBargarh = storeBargarh;
	}

	public Double getStoreBeheramal() {
		return storeBeheramal;
	}

	public void setStoreBeheramal(Double storeBeheramal) {
		this.storeBeheramal = storeBeheramal;
	}

	public Double getStoreSarabahal() {
		return storeSarabahal;
	}

	public void setStoreSarabahal(Double storeSarabahal) {
		this.storeSarabahal = storeSarabahal;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
 
}
