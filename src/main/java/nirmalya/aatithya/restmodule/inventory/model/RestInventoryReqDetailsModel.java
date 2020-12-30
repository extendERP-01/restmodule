package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestInventoryReqDetailsModel {
	
	
	private String reqQuotId;//primary key
	
	private String rfqName; 

	private String rfqValidDate;
	
	private String rfqBackground;
	
    private String rfqCreatedOn;
	
	private String rfqUpdateOn;
	
	private String rfqDetails;
	 
    private String rfqVendor;
    
    private String quotationNo;
    
    private String checkedRFQId;
    
    private String purOrderNo;
    
	private List<String> rfqVendors = new ArrayList<String>();
	
	private Byte approvedStatus;
	
	private String createdBy;
	
	private String itemCategory;
	
	public RestInventoryReqDetailsModel() {
		super();
	}
	
	
	public RestInventoryReqDetailsModel(Object reqQuotId,  Object rfqName,  Object rfqValidDate, 
			Object rfqBackground,  Object rfqVendor,Object rfqDetails,Object approvedStatus,
			Object quotationNo,Object purOrderNo,Object rfqCreatedOn, Object itemCategory) {
		super();
		try {
			this.reqQuotId = (String) reqQuotId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.rfqName = (String) rfqName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.rfqValidDate = (String) rfqValidDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.rfqBackground = (String) rfqBackground;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.rfqVendor = (String) rfqVendor;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.rfqDetails = (String) rfqDetails;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.approvedStatus = (Byte) approvedStatus;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			this.quotationNo = (String) quotationNo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

		try {
			this.purOrderNo = (String) purOrderNo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		try {
			this.rfqCreatedOn = (String) rfqCreatedOn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.itemCategory = (String) itemCategory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public String getPurOrderNo() {
		return purOrderNo;
	}


	public void setPurOrderNo(String purOrderNo) {
		this.purOrderNo = purOrderNo;
	}


	public String getRfqVendor() {
		return rfqVendor;
	}


	public void setRfqVendor(String rfqVendor) {
		this.rfqVendor = rfqVendor;
	}


	public List<String> getRfqVendors() {
		return rfqVendors;
	}


	public void setRfqVendors(List<String> rfqVendors) {
		this.rfqVendors = rfqVendors;
	}

	
	
	public String getCheckedRFQId() {
		return checkedRFQId;
	}


	public void setCheckedRFQId(String checkedRFQId) {
		this.checkedRFQId = checkedRFQId;
	}


	public String getQuotationNo() {
		return quotationNo;
	}


	public void setQuotationNo(String quotationNo) {
		this.quotationNo = quotationNo;
	}


	public Byte getApprovedStatus() {
		return approvedStatus;
	}


	public void setApprovedStatus(Byte approvedStatus) {
		this.approvedStatus = approvedStatus;
	}


	public String getReqQuotId() {
		return reqQuotId;
	}


	public void setReqQuotId(String reqQuotId) {
		this.reqQuotId = reqQuotId;
	}


	public String getRfqName() {
		return rfqName;
	}


	public void setRfqName(String rfqName) {
		this.rfqName = rfqName;
	}


	public String getRfqValidDate() {
		return rfqValidDate;
	}


	public void setRfqValidDate(String rfqValidDate) {
		this.rfqValidDate = rfqValidDate;
	}


	public String getRfqBackground() {
		return rfqBackground;
	}


	public void setRfqBackground(String rfqBackground) {
		this.rfqBackground = rfqBackground;
	}


	public String getRfqCreatedOn() {
		return rfqCreatedOn;
	}


	public void setRfqCreatedOn(String rfqCreatedOn) {
		this.rfqCreatedOn = rfqCreatedOn;
	}


	public String getRfqUpdateOn() {
		return rfqUpdateOn;
	}


	public void setRfqUpdateOn(String rfqUpdateOn) {
		this.rfqUpdateOn = rfqUpdateOn;
	}


	public String getRfqDetails() {
		return rfqDetails;
	}


	public void setRfqDetails(String rfqDetails) {
		this.rfqDetails = rfqDetails;
	}

 


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getItemCategory() {
		return itemCategory;
	}


	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
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
