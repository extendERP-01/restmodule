package nirmalya.aatithya.restmodule.asset.model;

import java.util.ArrayList;
import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;

public class AssetPolicyMaster {

	private Integer policyId;
	private String itemId;
	private String itemName;
	private String serviceName;
	private String freqId;
	private String freqName;
	private String taskPerform;
	private Double kmHr;
	private List<DropDownModel> option = new ArrayList<DropDownModel>();
	private String createdBy;
	private String action;
	private String serviceType;
	private String serviceTypeId;

	public AssetPolicyMaster(Object policyId, Object itemId, Object itemName, Object serviceName, Object freqId,
			Object freqName, Object taskPerform, Object kmHr, Object serviceType, Object serviceTypeId) {
		super();
		this.policyId = (Integer) policyId;
		this.itemId = (String) itemId;
		this.itemName = (String) itemName;
		this.serviceName = (String) serviceName;
		this.freqId = (String) freqId;
		this.freqName = (String) freqName;
		this.taskPerform = (String) taskPerform;
		this.kmHr = (Double) kmHr;
		this.serviceType = (String) serviceType;
		this.serviceTypeId = (String) serviceTypeId;
	}

	public Integer getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getFreqId() {
		return freqId;
	}

	public void setFreqId(String freqId) {
		this.freqId = freqId;
	}

	public String getFreqName() {
		return freqName;
	}

	public void setFreqName(String freqName) {
		this.freqName = freqName;
	}

	public String getTaskPerform() {
		return taskPerform;
	}

	public void setTaskPerform(String taskPerform) {
		this.taskPerform = taskPerform;
	}

	public List<DropDownModel> getOption() {
		return option;
	}

	public void setOption(List<DropDownModel> option) {
		this.option = option;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Double getKmHr() {
		return kmHr;
	}

	public void setKmHr(Double kmHr) {
		this.kmHr = kmHr;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceTypeId() {
		return serviceTypeId;
	}

	public void setServiceTypeId(String serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

}
