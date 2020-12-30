package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.property.model.PropertyAmenityItemModel;

public class GenerateAmenityItemParameter {
	/**
	 * returns parameter set for DataTableRequest class 
	**/


	/*
	 * Generate PArameter for Amenity Item 
	 */
	
	public static String getAddAmenityItemParam(PropertyAmenityItemModel amenityItem) {

		String s = "";
		if(amenityItem.getPropertyCategory()!=null && amenityItem.getPropertyCategory()!=null)
		{
			s = s + "@p_propertyCategory='" + amenityItem.getPropertyCategory()+ "',";
		}
		if(amenityItem.getPropertyType()!=null)
		{
			s = s + "@p_propertyType='" + amenityItem.getPropertyType()+ "',";
		}
		if(amenityItem.getAmenities()!=null &&amenityItem.getAmenities()!=" ")
		{
			s = s + "@p_amenity='" + amenityItem.getAmenities() + "',";
		}
		if(amenityItem.getItemCategory()!=null &&amenityItem.getItemCategory()!=" ")
		{
			s = s + "@p_itemCategory='" + amenityItem.getItemCategory() + "',";
		}
		if(amenityItem.getItemSubCategory()!=null &&amenityItem.getItemSubCategory()!=" ")
		{
			s = s + "@p_itemSubCategory='" + amenityItem.getItemSubCategory() + "',";
		}
		if(amenityItem.getItem()!=null && amenityItem.getItem()!=" ")
		{
			s = s + "@p_item='" + amenityItem.getItem() + "',";
		}
		if(amenityItem.getAmenityItemQty()!=null )
		{
			s = s + "@p_itemQty=" + amenityItem.getAmenityItemQty()+ ",";
		}
		if(amenityItem.getAmntyItemActive()==true || amenityItem.getAmntyItemActive()==false)
		{
			s = s + "@p_itemActive=" + amenityItem.getAmntyItemActive() + ",";
		}
		
		
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		
		
		
	  //System.out.println("param for Item Category add  : " + s );
		
		return s;
	}
}
