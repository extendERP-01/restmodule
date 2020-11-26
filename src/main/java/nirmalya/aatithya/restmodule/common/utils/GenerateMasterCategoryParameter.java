/**
 * 
 */
package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestCategoryModel;

/**
 * @author NirmalyaLabs
 *
 */
public class GenerateMasterCategoryParameter {
	/**
	 * returns parameter set for inventory MasterCountryModel class
	 **/

	public static String addCategoryParam(RestCategoryModel restCategoryModel) {

		String s ="";
		
		if (restCategoryModel.getCategory() != null || restCategoryModel.getCategory() != "") {
			s = s + "@p_category='" + restCategoryModel.getCategory() + "',";
		}
		
		if (restCategoryModel.getCategoryName() != null || restCategoryModel.getCategoryName() != "") {
			s = s + "@p_categoryName='" + restCategoryModel.getCategoryName()+ "',";
		}
		if (restCategoryModel.getDescription()!= null || restCategoryModel.getDescription() != "") {
			s = s + "@p_description='" + restCategoryModel.getDescription()+ "',";
		}
		if (restCategoryModel.getCreatedBy() != null || restCategoryModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restCategoryModel.getCreatedBy()+ "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}
}
