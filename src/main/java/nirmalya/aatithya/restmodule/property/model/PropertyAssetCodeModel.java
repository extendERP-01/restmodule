/**
 * rest model for property asset code
 */
package nirmalya.aatithya.restmodule.property.model;

import java.io.IOException;


import com.fasterxml.jackson.databind.ObjectMapper;

public class PropertyAssetCodeModel {
	private String assetCodeId;
	private String assetCodeName;
	private String item;
	private String dop;
	private String grrnty;
	private String brndNm;
	private String custEmail;
	private String custPhone;
	private String description;
	private Boolean workingStatus;
	private Boolean assetactive;
	private String createdBy;
	private String tSerialNo;
	private String store;
	private String model;
	private String chassisNo;
	private String engineNo;
	private String categoryId;
	private String category;
	private String itemId;
	private String barcode;
	private String grn;
	private String className;
	private String classId;
	
	public PropertyAssetCodeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertyAssetCodeModel(Object assetCodeId, Object assetCodeName, Object item, Object dop, Object grrnty,
			Object brndNm, Object custEmail, Object custPhone, Object description, Object workingStatus,
			Object assetactive,Object tSerialNo, Object store, Object model, Object chassisNo, Object engineNo,
			Object categoryId, Object category, Object itemId, Object barcode, Object grn,
			Object className, Object classId) {
		super();
		try {
			this.tSerialNo = (String) tSerialNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.assetCodeId = (String) assetCodeId;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.assetCodeName = (String) assetCodeName;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.item = (String) item;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.dop = (String) dop;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.grrnty = (String) grrnty;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.brndNm = (String) brndNm;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.custEmail = (String) custEmail;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.custPhone = (String) custPhone;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.description = (String) description;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.workingStatus = (Boolean) workingStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.assetactive = (Boolean) assetactive;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.store = (String) store;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.model = (String) model;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.chassisNo = (String) chassisNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.engineNo = (String) engineNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.categoryId = (String) categoryId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.category = (String) category;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemId = (String) itemId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.barcode = (String) barcode;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.grn = (String) grn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.className = (String) className;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.classId = (String) classId;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getAssetCodeId() {
		return assetCodeId;
	}

	public void setAssetCodeId(String assetCodeId) {
		this.assetCodeId = assetCodeId;
	}

	public String getAssetCodeName() {
		return assetCodeName;
	}

	public void setAssetCodeName(String assetCodeName) {
		this.assetCodeName = assetCodeName;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getDop() {
		return dop;
	}

	public void setDop(String dop) {
		this.dop = dop;
	}

	public String getGrrnty() {
		return grrnty;
	}

	public void setGrrnty(String grrnty) {
		this.grrnty = grrnty;
	}

	public String getBrndNm() {
		return brndNm;
	}

	public void setBrndNm(String brndNm) {
		this.brndNm = brndNm;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getWorkingStatus() {
		return workingStatus;
	}

	public void setWorkingStatus(Boolean workingStatus) {
		this.workingStatus = workingStatus;
	}

	public Boolean getAssetactive() {
		return assetactive;
	}

	public void setAssetactive(Boolean assetactive) {
		this.assetactive = assetactive;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String gettSerialNo() {
		return tSerialNo;
	}

	public void settSerialNo(String tSerialNo) {
		this.tSerialNo = tSerialNo;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getChassisNo() {
		return chassisNo;
	}

	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getGrn() {
		return grn;
	}

	public void setGrn(String grn) {
		this.grn = grn;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	@Override
	public String toString() {
		ObjectMapper mapperObj = new ObjectMapper();
		String jsonStr;
		try {
			jsonStr = mapperObj.writeValueAsString(this);
		} catch (IOException ex) {

			jsonStr = ex.toString();
		}
		return jsonStr;

	}
}