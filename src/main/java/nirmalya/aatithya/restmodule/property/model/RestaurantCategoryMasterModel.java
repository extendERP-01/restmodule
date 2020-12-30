/**
 * Defines restaurant category entity
 *
 */
package nirmalya.aatithya.restmodule.property.model;

import java.util.Date;

/**
 * @author Nirmalya Labs
 *
 */
public class RestaurantCategoryMasterModel {

	private String tMenuItemCategory; //primary key
	
	private String tMICatName;
	
	private String tMICatDescription;
	
	private Boolean tMICatActive;
	
	private Date tMICatCreatedOn;
	
	private Date tMICatUpdatedOn;
	
	public RestaurantCategoryMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public RestaurantCategoryMasterModel(Object tMenuItemCategory, Object tMICatName, Object tMICatDescription, Object tMICatActive,
			Object tMICatCreatedOn, Object tMICatUpdatedOn) {
		super();
		try {
			this.tMenuItemCategory = (String) tMenuItemCategory;
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			this.tMICatName = (String) tMICatName;
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			this.tMICatDescription =(String) tMICatDescription;
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			this.tMICatActive = (Boolean) tMICatActive;
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			this.tMICatCreatedOn = (Date) tMICatCreatedOn;
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			this.tMICatUpdatedOn = (Date) tMICatUpdatedOn;
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}



	public String gettMenuItemCategory() {
		return tMenuItemCategory;
	}



	public void settMenuItemCategory(String tMenuItemCategory) {
		this.tMenuItemCategory = tMenuItemCategory;
	}



	public String gettMICatName() {
		return tMICatName;
	}



	public void settMICatName(String tMICatName) {
		this.tMICatName = tMICatName;
	}



	public String gettMICatDescription() {
		return tMICatDescription;
	}



	public void settMICatDescription(String tMICatDescription) {
		this.tMICatDescription = tMICatDescription;
	}



	public Boolean gettMICatActive() {
		return tMICatActive;
	}



	public void settMICatActive(Boolean tMICatActive) {
		this.tMICatActive = tMICatActive;
	}



	public Date gettMICatCreatedOn() {
		return tMICatCreatedOn;
	}



	public void settMICatCreatedOn(Date tMICatCreatedOn) {
		this.tMICatCreatedOn = tMICatCreatedOn;
	}



	public Date gettMICatUpdatedOn() {
		return tMICatUpdatedOn;
	}



	public void settMICatUpdatedOn(Date tMICatUpdatedOn) {
		this.tMICatUpdatedOn = tMICatUpdatedOn;
	}
	
	
}
