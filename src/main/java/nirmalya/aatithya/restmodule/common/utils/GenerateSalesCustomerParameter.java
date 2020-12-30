/**
 * 
 */
package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.sales.model.RestSalesCustomerModel;

/**
 * @author NirmalyaLabs
 *
 */
public class GenerateSalesCustomerParameter {

	/**
	 * returns parameter set for Sales SalesCustomerModel class
	 **/

	public static String addCustomerParam(RestSalesCustomerModel salesCustomerModel) {

		String s ="";
		
		if (salesCustomerModel.getCustomerId() != null || salesCustomerModel.getCustomerId() != "") {
			s = s + "@p_salesCustId='" + salesCustomerModel.getCustomerId() + "',";
		}
		
		if (salesCustomerModel.getCustomerName() != null || salesCustomerModel.getCustomerName() != "") {
			s = s + "@p_salesCustName='" + salesCustomerModel.getCustomerName() + "',";
		}
		
		if (salesCustomerModel.getCustomerEmail() != null || salesCustomerModel.getCustomerEmail() != "") {
			s = s + "@p_salesCustEmail='" + salesCustomerModel.getCustomerEmail() + "',";
		}

		if (salesCustomerModel.getCustomerPhone() != null || salesCustomerModel.getCustomerPhone() != "") {
			s = s + "@p_salesCustPhone='" + salesCustomerModel.getCustomerPhone() + "',";
		}
		
		if (salesCustomerModel.getCustomerAddress() != null || salesCustomerModel.getCustomerAddress() != "") {
			s = s + "@p_salesCustAddress='" + salesCustomerModel.getCustomerAddress() + "',";
		}
		if (salesCustomerModel.getCustomerAddress2() != null || salesCustomerModel.getCustomerAddress2() != "") {
			s = s + "@p_salesCustAddress2='" + salesCustomerModel.getCustomerAddress2() + "',";
		}
		if (salesCustomerModel.getCustomerAddress3() != null || salesCustomerModel.getCustomerAddress3() != "") {
			s = s + "@p_salesCustAddress3='" + salesCustomerModel.getCustomerAddress3() + "',";
		}
		
		if (salesCustomerModel.getCustomerCity() != null || salesCustomerModel.getCustomerCity() != "") {
			s = s + "@p_salesCustCity='"+ salesCustomerModel.getCustomerCity() + "',";
		}
		
		if (salesCustomerModel.getCustomerDistrict() != null || salesCustomerModel.getCustomerDistrict() != "") {
			s = s + "@p_salesCustDistrict='" + salesCustomerModel.getCustomerDistrict() + "',";
		}
		
		if (salesCustomerModel.getCustomerState() != null || salesCustomerModel.getCustomerState() != "") {
			s = s + "@p_salesCustState='" + salesCustomerModel.getCustomerState() + "',";
		}
		
		if (salesCustomerModel.getCustomerCountry() != null || salesCustomerModel.getCustomerCountry() != "") {
			s = s + "@p_salesCustCountry='" + salesCustomerModel.getCustomerCountry() + "',";
		}
		
		if (salesCustomerModel.getCustomerZipCode() != null || salesCustomerModel.getCustomerZipCode() != "") {
			s = s + "@p_salesCustZipCode='" + salesCustomerModel.getCustomerZipCode() + "',";
		}
		if (salesCustomerModel.getCustomerGSTNo() != null || salesCustomerModel.getCustomerGSTNo() != "") {
			s = s + "@p_salesCustGSTNo='" + salesCustomerModel.getCustomerGSTNo() + "',";
		}
		
		if (salesCustomerModel.getCustomerContactPerson() != null || salesCustomerModel.getCustomerContactPerson() != "") {
			s = s + "@p_salesCustContactPerson='" + salesCustomerModel.getCustomerContactPerson() + "',";
		}
		
		if (salesCustomerModel.getCustomerPAN() != null || salesCustomerModel.getCustomerPAN() != "") {
			s = s + "@p_salesCustPAN='" + salesCustomerModel.getCustomerPAN() + "',";
		}
		
		if (salesCustomerModel.getCustomerActive() != null) {
			s = s + "@p_salesCustActive= " + salesCustomerModel.getCustomerActive()+ ",";
		}
		if (salesCustomerModel.getCustomerCreatedBy() != null || salesCustomerModel.getCustomerCreatedBy() != "") {
			s = s + "@p_salesCustCreatedBy='" + salesCustomerModel.getCustomerCreatedBy() + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
}

