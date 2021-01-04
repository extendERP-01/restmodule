package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.ProductCategoryModel;

public class GenerateProductCategoryParameter {

	public static String saveProductCategory(ProductCategoryModel category) {
		
		String s = "";
		
		if(category.getCategoryId()!=null && category.getCategoryId()!="") {
			s = s + "@p_categoryId='" + category.getCategoryId() + "',";
		}
		if(category.getCategoryName()!=null && category.getCategoryName()!="") {
			s = s + "@p_categoryName='" + category.getCategoryName() + "',";
		}
		if(category.getCategoryDesc()!=null && category.getCategoryDesc()!="") {
			s = s + "@p_categoryDesc='" + category.getCategoryDesc() + "',";
		}
		if(category.getParentId()!=null && category.getParentId()!="") {
			s = s + "@p_parentId='" + category.getParentId() + "',";
		}
		if(category.getCreatedBy()!=null && category.getCreatedBy()!="") {
			s = s + "@p_createdBy='" + category.getCreatedBy() + "',";
		}
		if(category.getCategoryStatus()!=null && category.getCategoryStatus()!="") {
			s = s + "@p_isActive='" + category.getCategoryStatus() + "',";
		} else {
			s = s + "@p_isActive='" + 0 + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		
		return s;
	}

}
