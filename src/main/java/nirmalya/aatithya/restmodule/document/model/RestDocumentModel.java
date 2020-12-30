/**
 * 
 */
package nirmalya.aatithya.restmodule.document.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author NirmalyaLabs
 *
 */
public class RestDocumentModel {
	public RestDocumentModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String document;
	private String category;
	private String referenceNo;
	private String subject;
	private String companyName;
	private String documentImage;
	private String keyword;
	private String description;
	private Integer approvalStatus;
	private String createdOn;
	private String createdBy;
	private String categoryName;
	private Integer currentStageNo;
	private Integer approverStageNo;
	private Integer currentLevelNo;
	private Integer approverLevelNo;
	private String approvalComment;
	private String updatedOn;

	public RestDocumentModel(Object document, Object category, Object referenceNo, Object subject, Object companyName,
			Object documentImage, Object keyword, Object description, Object approvalStatus, Object createdOn,
			Object createdBy, Object categoryName, Object currentStageNo, Object approverStageNo, Object currentLevelNo,
			Object approverLevelNo, Object approvalComment, Object updatedOn) {
		super();
		this.document = (String) document;
		this.category = (String) category;
		this.referenceNo = (String) referenceNo;
		this.subject = (String) subject;
		this.companyName = (String) companyName;
		this.documentImage = (String) documentImage;
		this.keyword = (String) keyword;
		this.description = (String) description;
		this.approvalStatus = (Integer) approvalStatus;
		this.createdOn = (String) createdOn;
		this.createdBy = (String) createdBy;
		this.categoryName = (String) categoryName;
		this.currentStageNo = (Integer) currentStageNo;
		this.approverStageNo = (Integer) approverStageNo;
		this.currentLevelNo = (Integer) currentLevelNo;
		this.approverLevelNo = (Integer) approverLevelNo;
		this.approvalComment = (String) approvalComment;
		this.updatedOn = (String) updatedOn;
	}

	public Integer getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(Integer approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDocumentImage() {
		return documentImage;
	}

	public void setDocumentImage(String documentImage) {
		this.documentImage = documentImage;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getDescription() {
		return description;
	}

	public String getApprovalComment() {
		return approvalComment;
	}

	public void setApprovalComment(String approvalComment) {
		this.approvalComment = approvalComment;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
