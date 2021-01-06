package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.ProductMasterModel;

public class GenerateProductMasterParameter {

	public static String saveProduct(ProductMasterModel product) {
		
		String s = "";
		String img = "";
		
		if(product.getProductId()!=null && product.getProductId()!="") {
			s = s + "@p_productId='" + product.getProductId() + "',";
		}
		if(product.getProductName()!=null && product.getProductName()!="") {
			s = s + "@p_productName='" + product.getProductName() + "',";
		}
		if(product.getBrand()!=null && product.getBrand()!="") {
			s = s + "@p_brand='" + product.getBrand() + "',";
		}
		if(product.getMode()!=null && product.getMode()!="") {
			s = s + "@p_mode='" + product.getMode() + "',";
		}
		if(product.getHsnCode()!=null && product.getHsnCode()!="") {
			s = s + "@p_hsnCode='" + product.getHsnCode() + "',";
		}
		if(product.getSicCode()!=null && product.getSicCode()!="") {
			s = s + "@p_sicCode='" + product.getSicCode() + "',";
		}
		if(product.getProductCategory()!=null && product.getProductCategory()!="") {
			s = s + "@p_productCat='" + product.getProductCategory() + "',";
		}
		if(product.getProductCategoryText()!=null && product.getProductCategoryText()!="") {
			s = s + "@p_productCatText='" + product.getProductCategoryText() + "',";
		}
		if(product.getCreatedBy()!=null && product.getCreatedBy()!="") {
			s = s + "@p_createdBy='" + product.getCreatedBy() + "',";
		}
		if(product.getProductStatus()!=null && product.getProductStatus()!="") {
			s = s + "@p_isProdActive='" + product.getProductStatus() + "',";
		} else {
			s = s + "@p_isProdActive='" + 0 + "',";
		}
		
		if(product.getImgName().size() > 0) {
			for(String m : product.getImgName()) {
				img = img + "(@p_productId,\"" + m + "\"),";
			}
			
			img = img.substring(0, img.length() - 1);
		}
		s = s + "@p_productImg='" + img + "';";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		
		return s;
	}

}
