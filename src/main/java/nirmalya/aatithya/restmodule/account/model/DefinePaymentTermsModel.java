package nirmalya.aatithya.restmodule.account.model;

public class DefinePaymentTermsModel {

	private String termId;
	private String termsComment;
	private String createdBy;

	
	public DefinePaymentTermsModel(Object termId, Object termsComment, Object createdBy) {
		super();
		this.termId = (String) termId;
		this.termsComment = (String) termsComment;
		this.createdBy = (String) createdBy;
	}
	public String getTermId() {
		return termId;
	}
	public void setTermId(String termId) {
		this.termId = termId;
	}
	public String getTermsComment() {
		return termsComment;
	}
	public void setTermsComment(String termsComment) {
		this.termsComment = termsComment;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
}
