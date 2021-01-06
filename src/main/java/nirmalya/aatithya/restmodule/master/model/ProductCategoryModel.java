package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductCategoryModel {

	private String categoryId;
	private String categoryName;
	private String categoryDesc;
	private String categoryStatus;
	private String parentId;
	private String createdBy;
	private String catLevel;
	private String parentName;
	private BigInteger nodeCount;
	
	public ProductCategoryModel() {
		super();
	}

	public ProductCategoryModel(Object categoryId, Object categoryName, Object categoryDesc, Object categoryStatus,
			Object parentId, Object createdBy, Object catLevel, Object parentName, Object nodeCount) {
		super();
		this.categoryId = (String) categoryId;
		this.categoryName = (String) categoryName;
		this.categoryDesc = (String) categoryDesc;
		this.categoryStatus = (String) categoryStatus;
		this.parentId = (String) parentId;
		this.createdBy = (String) createdBy;
		this.catLevel = (String) catLevel;
		this.parentName = (String) parentName;
		this.nodeCount = (BigInteger) nodeCount;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	public String getCategoryStatus() {
		return categoryStatus;
	}

	public void setCategoryStatus(String categoryStatus) {
		this.categoryStatus = categoryStatus;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getCatLevel() {
		return catLevel;
	}

	public void setCatLevel(String catLevel) {
		this.catLevel = catLevel;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public BigInteger getNodeCount() {
		return nodeCount;
	}

	public void setNodeCount(BigInteger nodeCount) {
		this.nodeCount = nodeCount;
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
