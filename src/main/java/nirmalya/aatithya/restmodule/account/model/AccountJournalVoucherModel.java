/**
 * 
 */
package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author NirmalyaLabs
 *
 */
public class AccountJournalVoucherModel {
	private String journalVoucher;
	private String costCenter;
	private String description;
	private String fromAccountSubGroup;
	private String fromName;
	private Double fromAmount;
	private String toAccountSubGroup;
	private String toName;
	private Double toAmount;
	private Double totalAmount;
	private Boolean active;
	private String createdOn;
	private String createdBy;
	private Boolean transactionType;
	private Integer currentStageNo;
	private Integer approverStageNo;
	private Integer currentLevelNo;
	private Integer approverLevelNo;
	private Byte approveStatus;
	public AccountJournalVoucherModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountJournalVoucherModel(Object journalVoucher, Object costCenter, Object description,
			Object fromAccountSubGroup, Object fromName, Object fromAmount, Object toAccountSubGroup, Object toName,
			Object toAmount, Object totalAmount, Object active, Object createdOn, Object createdBy,Object transactionType,
			Object currentStageNo,Object approverStageNo,Object currentLevelNo,Object approverLevelNo,Object approveStatus ) {
		super();
		this.journalVoucher =(String) journalVoucher;
		this.costCenter = (String) costCenter;
		this.description =(String)  description;
		this.fromAccountSubGroup =(String)  fromAccountSubGroup;
		this.fromName =(String)  fromName;
		this.fromAmount =  (Double)fromAmount;
		this.toAccountSubGroup = (String) toAccountSubGroup;
		this.toName = (String) toName;
		this.toAmount = (Double) toAmount;
		this.totalAmount = (Double)totalAmount;
		this.active =(Boolean) active;
		this.createdOn = (String) createdOn;
		this.createdBy =(String)  createdBy;
		this.transactionType =(Boolean)  transactionType;
		this.currentStageNo =(Integer)  currentStageNo;
		this.approverStageNo =(Integer)  approverStageNo;
		this.currentLevelNo =(Integer)  currentLevelNo;
		this.approverLevelNo =(Integer)  approverLevelNo;	
		this.approveStatus =(Byte)  approveStatus;
	}

	public String getCostCenter() {
		return costCenter;
	}
	public String getDescription() {
		return description;
	}
	public String getFromAccountSubGroup() {
		return fromAccountSubGroup;
	}
	public String getFromName() {
		return fromName;
	}
	public Double getFromAmount() {
		return fromAmount;
	}
	public String getToAccountSubGroup() {
		return toAccountSubGroup;
	}
	public String getToName() {
		return toName;
	}
	public Double getToAmount() {
		return toAmount;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public Boolean getActive() {
		return active;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	
	public Integer getCurrentStageNo() {
		return currentStageNo;
	}
	public void setCurrentStageNo(Integer currentStageNo) {
		this.currentStageNo = currentStageNo;
	}
	public Integer getApproverStageNo() {
		return approverStageNo;
	}
	public void setApproverStageNo(Integer approverStageNo) {
		this.approverStageNo = approverStageNo;
	}
	public Integer getCurrentLevelNo() {
		return currentLevelNo;
	}
	public void setCurrentLevelNo(Integer currentLevelNo) {
		this.currentLevelNo = currentLevelNo;
	}
	public Integer getApproverLevelNo() {
		return approverLevelNo;
	}
	public void setApproverLevelNo(Integer approverLevelNo) {
		this.approverLevelNo = approverLevelNo;
	}
	public Byte getApproveStatus() {
		return approveStatus;
	}
	public void setApproveStatus(Byte approveStatus) {
		this.approveStatus = approveStatus;
	}
	public String getJournalVoucher() {
		return journalVoucher;
	}
	public void setJournalVoucher(String journalVoucher) {
		this.journalVoucher = journalVoucher;
	}
	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setFromAccountSubGroup(String fromAccountSubGroup) {
		this.fromAccountSubGroup = fromAccountSubGroup;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public void setFromAmount(Double fromAmount) {
		this.fromAmount = fromAmount;
	}
	public void setToAccountSubGroup(String toAccountSubGroup) {
		this.toAccountSubGroup = toAccountSubGroup;
	}
	public void setToName(String toName) {
		this.toName = toName;
	}
	public void setToAmount(Double toAmount) {
		this.toAmount = toAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Boolean getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(Boolean transactionType) {
		this.transactionType = transactionType;
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
