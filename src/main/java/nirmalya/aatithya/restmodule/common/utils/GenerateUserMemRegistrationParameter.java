
package nirmalya.aatithya.restmodule.common.utils;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import nirmalya.aatithya.restmodule.user.model.UserMembershipRegistrationModel; 

public class GenerateUserMemRegistrationParameter {

	
	//  @Autowired  PasswordEncoder passwordEncoder;
	
	
	public static String getAddUserMemParam(List<UserMembershipRegistrationModel> table) { 
		
		
		
		
		String Id="";
		String firstName_m = "";
		String lastName_m = "";
		String mobile_no_m = "";
		String email_m = "";
		String password_m = "";
		String pin_m = "";
		String country_m = "";
		String state_m = "";
		String district_m = "";
		String zip_m = "";
		String address_m = "";
		String member_type_m = "";
		String relation_m = "";
		Double registration_m = null;
		Double monthly_fee_m = null;
		String joiningdate_m = null;
		String dateofbirth_m = null;
		String payment_mode_m = "";
		Boolean status_m = null;
		String imei_m = "";
		String s = "";
		String dependents = ""; 
		String first_ = ""; 
		String userType = "";
		String createdBy="";
		
		
		Id			=table.get(0).getMemId(); 
		 
		firstName_m			=table.get(0).getFirst_name_m();
		lastName_m			=table.get(0).getLast_name_m(); 
		mobile_no_m			=table.get(0).getMobile_no_m(); 
		email_m			    =table.get(0).getEmail_m();  
		password_m			=table.get(0).getPassword_m();   
		pin_m			    =table.get(0).getPin_m(); 
		country_m			=table.get(0).getCountry_m();  
		state_m			    =table.get(0).getState_m();   
		district_m			=table.get(0).getDistrict_m(); 
		zip_m				=table.get(0).getZip_m();  
		address_m			=table.get(0).getAddress_m(); 
		member_type_m	    =table.get(0).getMember_type_m(); 
		relation_m			=table.get(0).getRelation_m();  
		registration_m		=table.get(0).getRegistration_m(); 
		monthly_fee_m		=table.get(0).getMonthly_fee_m(); 
		joiningdate_m		=DateFormatter.getStringDate(table.get(0).getJoiningdate_m());
		dateofbirth_m		=DateFormatter.getStringDate(table.get(0).getDateofbirth_m());
		payment_mode_m		=table.get(0).getPayment_mode_m();
		status_m			=table.get(0).getStatus_m();
		createdBy			=table.get(0).getCreatedBy();
		imei_m			    =table.get(0).getImei_m(); 
		userType			=table.get(0).getUserType(); 
		first_		        =table.get(0).getFirst_();


		
		System.out.println("date of birth of main form in generate param ----------------------------: "+dateofbirth_m);
		
			 
			s = s + "@p_usermemId='"+ Id +"',";
			s = s + "@p_firstName_m='"+ firstName_m +"',";
			s = s + "@p_lastName_m='"+  lastName_m +"',";
			s = s + "@p_mobile_no_m='"+ mobile_no_m +"',";
			s = s + "@p_email_m='"+ email_m +"',";
			s = s + "@p_password_m='"+ password_m +"',";
			s = s + "@p_pin_m='"+ pin_m +"',";
			s = s + "@p_country_m='"+ country_m +"',";
			s = s + "@p_state_m='"+ state_m +"',";
			s = s + "@p_district_m='"+ district_m +"',";
			s = s + "@p_zip_m='"+ zip_m +"',";
			s = s + "@p_address_m='"+ address_m +"',";
			s = s + "@p_member_type_m='"+ member_type_m +"',";
			s = s + "@p_relation_m='"+ relation_m +"',";
			s = s + "@p_registration_m='"+ registration_m +"',";
			s = s + "@p_monthly_fee_m='"+ monthly_fee_m +"',";
			s = s + "@p_joiningdate_m='"+ joiningdate_m +"',";
			s = s + "@p_payment_mode_m='"+ payment_mode_m +"',";
			s = s + "@p_member_type_m='"+ member_type_m +"',";
			s = s + "@p_status_m="+ status_m +",";
			s = s + "@p_imei_m='"+ imei_m +"',";
			s = s + "@p_user_type_m='"+ userType +"',";
			s = s + "@p_dateofbirth_m='"+ dateofbirth_m +"',";
			s = s + "@p_createdBy='"+ createdBy +"',";
			
			
	   
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		
		System.out.println("data in generate parameter"+ s);
		return s;
	}
	
	public static String getAddUserMemDependent(List<UserMembershipRegistrationModel> table,String depId) { 
		 
		  String first_ = table.get(0).getFirst_();
			
		  String dependents="";
		  String s="";
		  
		if(first_ !="") {
			  
				Integer j=1;
				for(UserMembershipRegistrationModel i : table) {
					String statusd=i.getStatus_();
					statusd=statusd.replace("'", "''");
					String depIddep=depId+"_"+j;
					  
					dependents 	= dependents +"(\""+depIddep+"\",\""+depId+"\",\""+i.getFirst_()+"\",\""+i.getLast_()+"\",\""+i.getMobile_()+"\",\""+i.getEmail_()+"\",\""+i.getPassword_()+"\",\""+i.getPin_()+"\",\""+i.getAddress_m()+"\",\""+i.getCountry_m()+"\",\""+i.getState_m()+"\",\""+i.getDistrict_m()+"\",\""+i.getZip_m()+"\","+statusd+",\""+i.getUserType()+"\",\""+i.getRelation_()+"\",\""+DateFormatter.getStringDate(i.getDateofbirth_())+"\",\""+i.getInsertOrder()+"\"),";
					j=j+1;
				}
				
				dependents =dependents.substring(0,dependents.length()-1);
				
				s=s +"@p_childSubquery='"  + dependents +"',";
		 
		  }else {
			  
			  s=s +"@p_childSubquery='"  + dependents +"',";
			  
		  }
		 
	
	
	   
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		
		System.out.println("data in generate parameter for dependent -----------------"+ s);
		return s;
	}

public static String getSearchParam(DataTableRequest request) 
{	 

	String s = "";
	
	if(request.getStart() != null) {
		s = s + "@p_start=" + request.getStart() + ",";
	}
	
	if(request.getLength() != null ) {
		s = s + "@p_length=" + request.getLength() + ",";
	}
	
	if(request.getSearch() != null ) {
		s = s + "@p_search='" + request.getSearch() + "',";
	}
	
	if(request.getParam1() != null ) {
		s = s + "@p_param1='" + request.getParam1() + "',";
	}
	
	if(request.getParam2() != null ) {
		s = s + "@p_param2='" + request.getParam2() + "',";
	}
	
	if(request.getParam3() != null ) {
		s = s + "@p_param3='" + request.getParam3() + "',";
	}
	
	if(request.getParam4() != null ) {
		s = s + "@p_param4='" + request.getParam4() + "',";
	}
	
	if(s != "") {
		s = s.substring(0, s.length()-1);
		
		s = "SET " + s + ";" ;
	}
	
	System.out.println("param  : " + s );
	
	return s;
	}

}
