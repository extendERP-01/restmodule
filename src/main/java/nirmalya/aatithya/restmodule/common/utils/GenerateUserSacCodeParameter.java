package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.UserSacCodeModel;

public class GenerateUserSacCodeParameter {

	
	public static String addSacParam(UserSacCodeModel restSacMasterModel) {
		/**
		 * returns parameter set for inventory SacCodeModel class
		 **/
		
		 String s = "";
			
			if(restSacMasterModel.getSacId()!= null ) {
				s = s + "@p_sacId='" + restSacMasterModel.getSacId()+ "',";
			}
			
			if(restSacMasterModel.getSacCodeName()!=null && restSacMasterModel.getSacCodeName()!=" " ) {
				s = s + "@p_sacCodeName='" + restSacMasterModel.getSacCodeName() + "',";
			}
			
			if(restSacMasterModel.getSacService()!=null && restSacMasterModel.getSacService()!=" " ) {
				s = s + "@p_sacService='" + restSacMasterModel.getSacService() + "',";
			}
			
			if(restSacMasterModel.getSacActive()==true || restSacMasterModel.getSacActive()==false)
			{		
				s = s + "@p_sacActive=" + restSacMasterModel.getSacActive() + ",";	
			}
			
			if(restSacMasterModel.getSacGST() != null) {
				s = s + "@p_sacGST= '" + restSacMasterModel.getSacGST()+ "',";
			}
			
			if(restSacMasterModel.getSacDescription() != null || restSacMasterModel.getSacDescription() !=" ") {
				s = s + "@p_sacDescription= '" + restSacMasterModel.getSacDescription()+ "',";
			}
			
			if(restSacMasterModel.getSacEffDate() != null) {
				String tDate= DateFormatter.getStringDate(restSacMasterModel.getSacEffDate());  
				
				s = s+"@p_sacEffDate='"+tDate+"',";
			}
			
			/*if(form.getStatus() == false && form.getStatus() == true) {
				s = s + "@p_address='" + form.getStatus() + "',";
			}*/
			
			//System.out.println("in addddddddd");
			
			if(s != "") {
				s = s.substring(0, s.length()-1);
				
				s = "SET " + s + ";" ;
			}
			
			
			
			System.out.println("param  : " + s );
			
			return s;
	}
	
}

