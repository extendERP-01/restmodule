package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductMasterModel {

	private String productId;
	private String productName;
	private String brand;
	private String mode;
	private String hsnCode;
	private String sicCode;
	private String productStatus;
	private String productCategory;
	private String createdBy;
	private String productCategoryText;
	private List<String> imgList;
	private List<String> imgName = new ArrayList<String>();
	
	public ProductMasterModel() {
		super();
	}

	public ProductMasterModel(Object productId, Object productName, Object brand, Object mode, Object hsnCode,
			Object sicCode, Object productStatus, Object productCategory, Object createdBy, Object productCategoryText) {
		super();
		this.productId = (String) productId;
		this.productName = (String) productName;
		this.brand = (String) brand;
		this.mode = (String) mode;
		this.hsnCode = (String) hsnCode;
		this.sicCode = (String) sicCode;
		this.productStatus = (String) productStatus;
		this.productCategory = (String) productCategory;
		this.createdBy = (String) createdBy;
		this.productCategoryText = (String) productCategoryText;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getSicCode() {
		return sicCode;
	}

	public void setSicCode(String sicCode) {
		this.sicCode = sicCode;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getProductCategoryText() {
		return productCategoryText;
	}

	public void setProductCategoryText(String productCategoryText) {
		this.productCategoryText = productCategoryText;
	}

	public List<String> getImgList() {
		return imgList;
	}

	public void setImgList(List<String> imgList) {
		this.imgList = imgList;
	}

	public List<String> getImgName() {
		return imgName;
	}

	public void setImgName(List<String> imgName) {
		this.imgName = imgName;
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
