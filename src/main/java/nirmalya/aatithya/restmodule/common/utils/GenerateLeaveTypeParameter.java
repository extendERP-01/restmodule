
/**Defines SQL SET Parameters for district */
package nirmalya.aatithya.restmodule.common.utils; 
import nirmalya.aatithya.restmodule.leave.model.RestLeaveTypeModel; 

/**
 * 
* @author Nirmalya Labs
*
*/
public class GenerateLeaveTypeParameter {
public static String getAddLeaveTypeParam(RestLeaveTypeModel table) {
		
		String s = "";
		
		if(table.getlTypeId()!=null && table.getlTypeId()!=" "){
			s = s + "@p_Id='" + table.getlTypeId() + "',";
		}
		if(table.getlTypeName()!=null && table.getlTypeName()!=" "){
			s = s + "@p_lTypeName='" + table.getlTypeName() + "',";
		}
		if(table.getlTypePeriod()!=null){
			s = s + "@p_lPeriod='" + table.getlTypePeriod() + "',";
		}
		
		if(table.getIsadminAssign()!=null){
			s = s + "@p_adminAssign=" + table.getIsadminAssign() + ",";
			
		}
		if(table.getIsEmpApply()!=null){
			s = s + "@p_empApply=" + table.getIsEmpApply() + ","; 
		}
		
		if(table.getIsEmpAlyMoreThanALeave()!=null){
			s = s + "@p_empApplyMore=" + table.getIsEmpAlyMoreThanALeave() + ","; 
		}

		if(table.getlAccrueEnb()!=null){
			s = s + "@p_accuEnb=" + table.getlAccrueEnb() + ","; 
		}
		
		if(table.getlCarriedFwd()!=null){
			s = s + "@p_carriedfwd=" + table.getlCarriedFwd() + ","; 
		}
		
		if(table.getlCarriedFwdPercnt()!=null){
			s = s + "@p_carriedfwdPercent='" + table.getlCarriedFwdPercnt() + "',"; 
		}
		
		if(table.getMaxCaryFwdAmt()!=null){
			s = s + "@p_maxCarryAmt='" + table.getMaxCaryFwdAmt() + "',"; 
		}
		
		if(table.getCarryFwdPeriod()!=null){
			s = s + "@p_carryPeriod='" + table.getCarryFwdPeriod() + "',"; 
		}
		
		if(table.getProperLeaveJDate()!=null){
			s = s + "@p_proDate=" + table.getProperLeaveJDate() + ","; 
		}
		
		 
		if(table.getSentEmailNotify()!=null){
			s = s + "@p_emailSent=" + table.getSentEmailNotify() + ","; 
		}
		s = s + "@p_createdBy='" + table.getCreatedBy() + "',";
		 
		if(table.getlTypeStatus()==true || table.getlTypeStatus()==false)
		{
			s = s + "@p_Status=" + table.getlTypeStatus() + ",";
		}
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		
		System.out.println("Data in generated parameter"+s);
		
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
