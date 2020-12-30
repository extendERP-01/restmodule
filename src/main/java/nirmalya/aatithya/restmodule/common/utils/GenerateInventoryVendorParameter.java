/**
 * Parameter Set for Vendor
 */
package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.inventory.model.RestInventoryVendorModel;

/**
 * @author NirmalyaLabs
 *
 */
public class GenerateInventoryVendorParameter {

	/**
	 * search parameter set for inventory ItemCategoryrModel class
	 **/

	public static String getVendorSearchParam(DataTableRequest request) {

		String s = "";

		if (request.getStart() != null) {
			s = s + "@p_start=" + request.getStart() + ",";
		}

		if (request.getLength() != null) {
			s = s + "@p_length=" + request.getLength() + ",";
		}

		if (request.getSearch() != null) {
			s = s + "@p_search='" + request.getSearch() + "',";
		}

		if (request.getParam1() != null) {
			s = s + "@p_param1='" + request.getParam1() + "',";
		}

		if (request.getParam2() != null) {
			s = s + "@p_param2='" + request.getParam2() + "',";
		}

		if (request.getParam3() != null) {
			s = s + "@p_param3='" + request.getParam3() + "',";
		}

		if (request.getParam4() != null) {
			s = s + "@p_param4='" + request.getParam4() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	/**
	 * add parameter set for inventory vendor class
	 *
	 **/
	
	public static String addVendorParam(RestInventoryVendorModel restVendorModel) {

		String s = "";

		if (restVendorModel.getVendor()!= null) {
			s = s + "@p_vendor='" + restVendorModel.getVendor() + "',";
		}
		
		if (restVendorModel.getVendorName() != null || restVendorModel.getVendorName() != "") {
			s = s + "@p_vendorName='" + restVendorModel.getVendorName() + "',";
		}
		if (restVendorModel.getVendorDescription() != null || restVendorModel.getVendorDescription() != "") {
			s = s + "@p_vendorDescription='" + restVendorModel.getVendorDescription() + "',";
		}
		if (restVendorModel.getVendorAddress() != null || restVendorModel.getVendorAddress() != "") {
			s = s + "@p_vendorAddress='" + restVendorModel.getVendorAddress() + "',";
		}
		if (restVendorModel.getVendorAddress2() != null || restVendorModel.getVendorAddress2() != "") {
			s = s + "@p_vendorAddress2='" + restVendorModel.getVendorAddress2() + "',";
		}
		if (restVendorModel.getVendorAddress3() != null || restVendorModel.getVendorAddress3() != "") {
			s = s + "@p_vendorAddress3='" + restVendorModel.getVendorAddress3() + "',";
		}
		if (restVendorModel.getVendorGSTNO() != null || restVendorModel.getVendorGSTNO() != "") {
			s = s + "@p_vendorGSTNO='" + restVendorModel.getVendorGSTNO() + "',";
		}
		if (restVendorModel.getVendorTINNO() != null || restVendorModel.getVendorTINNO() != "") {
			s = s + "@p_vendorTINNO='" + restVendorModel.getVendorTINNO() + "',";
		}
		if (restVendorModel.getVendorBankAc() != null || restVendorModel.getVendorBankAc() != "") {
			s = s + "@p_vendorBankAc='" + restVendorModel.getVendorBankAc() + "',";
		}
		if (restVendorModel.getVendorIFSC() != null || restVendorModel.getVendorIFSC() != "") {
			s = s + "@p_vendorIFSC='" + restVendorModel.getVendorIFSC() + "',";
		}
		if (restVendorModel.getVendorEmail() != null || restVendorModel.getVendorEmail() != "") {
			s = s + "@p_vendorEmail='" + restVendorModel.getVendorEmail() + "',";
		}
		if (restVendorModel.getVendorPhone() != null || restVendorModel.getVendorPhone() != "") {
			s = s + "@p_vendorPhone='" + restVendorModel.getVendorPhone() + "',";
		}
		if (restVendorModel.getVendorMobile() != null || restVendorModel.getVendorMobile() != "") {
			s = s + "@p_vendorMobile='" + restVendorModel.getVendorMobile() + "',";
		}
		if (restVendorModel.getVendorPaymentDays() != null ) {
			s = s + "@p_paymentDays='" + restVendorModel.getVendorPaymentDays() + "',";
		}
		if (restVendorModel.getVendorActive() != null){
			s = s + "@p_vendorActive=" + restVendorModel.getVendorActive() + ",";
		}
		if (restVendorModel.getCauseOfInactive() != null || restVendorModel.getCauseOfInactive() != "") {
			s = s + "@p_causeOfInactive='" + restVendorModel.getCauseOfInactive() + "',";
		}
		if (restVendorModel.getCreatedBy() != null || restVendorModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restVendorModel.getCreatedBy() + "',";
		}
		if (restVendorModel.getVendorCity() != null || restVendorModel.getVendorCity() != "") {
			s = s + "@p_vendorCity='" + restVendorModel.getVendorCity() + "',";
		}
		if (restVendorModel.getVendorCountry() != null || restVendorModel.getVendorCountry() != "") {
			s = s + "@p_vendorCountry='" + restVendorModel.getVendorCountry() + "',";
		}
		if (restVendorModel.getVendorState() != null || restVendorModel.getVendorState() != "") {
			s = s + "@p_vendorState='" + restVendorModel.getVendorState() + "',";
		}
		if (restVendorModel.getVendorZipCode() != null || restVendorModel.getVendorZipCode() != "") {
			s = s + "@p_vendorZipCode='" + restVendorModel.getVendorZipCode() + "',";
		}
		if (restVendorModel.getVendorPAN() != null || restVendorModel.getVendorPAN() != "") {
			s = s + "@p_vendorPAN='" + restVendorModel.getVendorPAN() + "',";
		}
		if (restVendorModel.getVendorContactPerson() != null || restVendorModel.getVendorContactPerson() != "") {
			s = s + "@p_vendorContactPerson='" + restVendorModel.getVendorContactPerson() + "',";
		}
		if (restVendorModel.getVendorServiceTax() != null || restVendorModel.getVendorServiceTax() != "") {
			s = s + "@p_vendorServiceTax='" + restVendorModel.getVendorServiceTax() + "',";
		}
		if (restVendorModel.getVendorVAT() != null && restVendorModel.getVendorVAT() != "") {
			s = s + "@p_vendorVAT='" + restVendorModel.getVendorVAT() + "',";
		}
		
		String s1 = "";
		String[] str = restVendorModel.getItemCategory();
		for(String m : str) {
			s1 = s1 + "(@p_vendor,\""+m+"\",@p_createdBy),";
		}
		
		s1 = s1.substring(0, s1.length() - 1);
		String subQuery = "";
		subQuery = subQuery + "@p_VendorItemSubQuery='" + s1 + "'";
		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s +","+ subQuery+";";
		}
		System.out.println(s);
		return s;

	}

	public static String uploadVendorContract(RestInventoryVendorModel restVendorModel) {
		String s = "";
		
		if (restVendorModel.getVendor()!= null && restVendorModel.getVendor()!="") {
			s = s + "@p_vendor='" + restVendorModel.getVendor() + "',";
		}
		if (restVendorModel.getVendorContract()!= null && restVendorModel.getVendorContract()!= "") {
			s = s + "@p_vendorContract='" + restVendorModel.getVendorContract() + "',";
		}
		if (restVendorModel.getFromDate()!= null && restVendorModel.getFromDate()!= "") {
			s = s + "@p_fromDate='" + DateFormatter.getStringDate(restVendorModel.getFromDate()) + "',";
		}
		if (restVendorModel.getToDate()!= null && restVendorModel.getToDate()!= "") {
			s = s + "@p_toDate='" + DateFormatter.getStringDate(restVendorModel.getToDate()) + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s +";";
		}
		System.out.println(s);
		return s;
	}

	public static String blacklistVendor(RestInventoryVendorModel restVendorModel) {
		String s = "";
		
		if (restVendorModel.getVendor()!= null && restVendorModel.getVendor()!="") {
			s = s + "@p_vendor='" + restVendorModel.getVendor() + "',";
		}
		if (restVendorModel.getCauseOfInactive()!= null && restVendorModel.getCauseOfInactive()!= "") {
			s = s + "@p_blacklistComment='" + restVendorModel.getCauseOfInactive() + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s +";";
		}
		System.out.println(s);
		return s;
	}
	
	public static String submitVendorRate(RestInventoryVendorModel restVendorModel) {
		String s = "";
		
		if (restVendorModel.getVendor()!= null && restVendorModel.getVendor()!="") {
			s = s + "@p_vendor='" + restVendorModel.getVendor() + "',";
		}
		if (restVendorModel.getVendorRate()!= null) {
			s = s + "@p_vendorRate=" + restVendorModel.getVendorRate() + ",";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);
			
			s = "SET " + s +";";
		}
		System.out.println(s);
		return s;
	}

}
