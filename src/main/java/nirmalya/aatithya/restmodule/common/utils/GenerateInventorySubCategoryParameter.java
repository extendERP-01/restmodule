/**
 * 
 */
package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.inventory.model.InventoryItemSubCategoryModel;

/**
 * @author USER
 *
 */
public class GenerateInventorySubCategoryParameter 
{

	public static String getAddItemSubCategory(InventoryItemSubCategoryModel itemSubCategoryModel) 
	{
		/**
		 * returns parameter set for inventory ItemSubCategoryModel class
		 **/
		
		 String s = "";
			
			if(itemSubCategoryModel.getItmSubCategoryId()!= null ) {
				s = s + "@p_itmSubCategoryId='" + itemSubCategoryModel.getItmSubCategoryId()+ "',";
			}
			
			if(itemSubCategoryModel.getItmSubCategoryName()!=null && itemSubCategoryModel.getItmSubCategoryName()!=" " ) {
				s = s + "@p_itmSubCategoryName='" + itemSubCategoryModel.getItmSubCategoryName() + "',";
			}
			
			if(itemSubCategoryModel.getItmCategory()!=null && itemSubCategoryModel.getItmCategory()!=" " ) {
				s = s + "@p_itmCategory='" + itemSubCategoryModel.getItmCategory() + "',";
			}
			
			if(itemSubCategoryModel.getItmSubActive()==true || itemSubCategoryModel.getItmSubActive()==false)
			{		
				s = s + "@p_itmSubActive=" + itemSubCategoryModel.getItmSubActive() + ",";	
			}
			
			if(itemSubCategoryModel.getItmSubDescription() != null || itemSubCategoryModel.getItmSubDescription() !="") {
				s = s + "@p_itmSubDescription= '" + itemSubCategoryModel.getItmSubDescription()+ " ',";
			}
			
			if(itemSubCategoryModel.getCreatedBy()!=null && itemSubCategoryModel.getCreatedBy()!=" " ) {
				s = s + "@p_createdBy='" + itemSubCategoryModel.getCreatedBy() + "',";
			}
			
			if(s != "") {
				s = s.substring(0, s.length()-1);
				
				s = "SET " + s + ";" ;
			}
			
			
			
			System.out.println("param  : " + s );
			
			return s;
	}
	
}
