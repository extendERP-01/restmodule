/**
 * 
 */
package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.property.model.PropertyAssignConsumedItemModel;

/**
 * @author USER
 *
 */
public class GeneratePropertyAssignConsumedItemParameter 
{

	public static String addAssignConsume(PropertyAssignConsumedItemModel propertyAssignConsumedItemModel)
	{
		String sqlParam = "";

		if (propertyAssignConsumedItemModel.getPropertyCategory() != null && propertyAssignConsumedItemModel.getPropertyCategory() != "") {
			sqlParam = sqlParam + "@p_propertyCategory='" + propertyAssignConsumedItemModel.getPropertyCategory() + "',";
		}

		if (propertyAssignConsumedItemModel.getPropertyNameId() != null && propertyAssignConsumedItemModel.getPropertyNameId() != "") {
			sqlParam = sqlParam + "@p_propertyNameId='" + propertyAssignConsumedItemModel.getPropertyNameId() + "',";
		}
		
		if (propertyAssignConsumedItemModel.getAmenity() != null && propertyAssignConsumedItemModel.getAmenity() != "") {
			sqlParam = sqlParam + "@p_amenity='" + propertyAssignConsumedItemModel.getAmenity() + "',";
		}

		if (propertyAssignConsumedItemModel.getItemCategory() != null && propertyAssignConsumedItemModel.getItemCategory() != "") {
			sqlParam = sqlParam + "@p_itemCategory='" + propertyAssignConsumedItemModel.getItemCategory() + "',";
		}
		if (propertyAssignConsumedItemModel.getItemSubCategory() != null && propertyAssignConsumedItemModel.getItemSubCategory() != "") {
			sqlParam = sqlParam + "@p_itemSubCategory='" + propertyAssignConsumedItemModel.getItemSubCategory() + "',";
		}
		if (propertyAssignConsumedItemModel.getItemNameId() != null && propertyAssignConsumedItemModel.getItemNameId() != "") {
			sqlParam = sqlParam + "@p_itemNameId='" + propertyAssignConsumedItemModel.getItemNameId() + "',";
		}
		if (propertyAssignConsumedItemModel.getAssignQuantity() != null) {
			sqlParam = sqlParam + "@p_assignQuantity='" + propertyAssignConsumedItemModel.getAssignQuantity() + "',";
		}
		
		if (propertyAssignConsumedItemModel.getAssignActive() != null) {
			sqlParam = sqlParam + "@p_assignActive=" + propertyAssignConsumedItemModel.getAssignActive() + ",";
		}
		
		if (propertyAssignConsumedItemModel.getCreatedBy() != null && propertyAssignConsumedItemModel.getCreatedBy() != "") {
			sqlParam = sqlParam + "@p_createdBy='" + propertyAssignConsumedItemModel.getCreatedBy() + "',";
		}
		
		if (sqlParam != "")
		{
			sqlParam = sqlParam.substring(0, sqlParam.length() - 1);

			sqlParam = "SET " + sqlParam + ";";
		}
        System.out.println("sqlParam"+sqlParam);
		return sqlParam;
	}

}
