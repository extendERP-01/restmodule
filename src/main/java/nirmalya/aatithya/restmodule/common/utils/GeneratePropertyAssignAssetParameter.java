package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import nirmalya.aatithya.restmodule.property.model.PropertyAssignAssetModel;

public class GeneratePropertyAssignAssetParameter {

	/*
	 * Generate PArameter for Amenity Item
	 */

	public static String getAddAssignAssetParam(PropertyAssignAssetModel propertyAssignAssetModel) {

		String s = "";
		if (propertyAssignAssetModel.getAssetsName() != null && propertyAssignAssetModel.getAssetsName() != "") {

			String propertyCategory = propertyAssignAssetModel.getPropertyCategory();
			String propertyId = propertyAssignAssetModel.getProperty();
			String itemCategory = propertyAssignAssetModel.getItemCategory();
			String itemSubCategory = propertyAssignAssetModel.getItemSubCategory();
			String item = propertyAssignAssetModel.getItem();
			String amenity = propertyAssignAssetModel.getAmenity();
			String createdBy = propertyAssignAssetModel.getCreatedBy();
			Float pAssignQty  = propertyAssignAssetModel.getpAsstQty();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String currentDate = dateFormat.format(date);

			String ac = "";
			String acn = "";

			String[] acList = propertyAssignAssetModel.getAssetsName().split(",");
			acn = acn + "(";
			for (int i = 0; i < acList.length; i++) {
				ac = ac + "(\"" + propertyCategory + "\",\"" + propertyId + "\",\"" + amenity + "\",\"" + itemCategory
						+ "\",\"" + itemSubCategory + "\",\"" + item + "\",\"" + acList[i] + "\",\"" + currentDate +"\",\""+ pAssignQty +"\",\"" + createdBy
						+ "\"),";
				acn = acn + "\"" + acList[i] + "\",";
			}
			ac = ac.substring(0, ac.length() - 1);

			s = s + "@p_assetCodes='" + ac + "',";

			acn = acn.substring(0, acn.length() - 1);

			acn = acn + ")";

			s = s + "@p_assetCodesId='" + acn + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		
		return s;
	}
}
