/**Defines SQL SET Parameters for district */
package nirmalya.aatithya.restmodule.common.utils; 
import nirmalya.aatithya.restmodule.leave.model.RestLeaveRuleModel; 

/**
 * 
* @author Nirmalya Labs
*
*/
public class GenerateLeaveRuleParameter {
public static String getAddLeaveRuleParam(RestLeaveRuleModel table) {
		
		String s = "";
		
		if(table.getRuleId()!=null && table.getRuleId()!=" "){
			s = s + "@p_Id='" + table.getRuleId() + "',";
		}
		if(table.getLeaveType()!=null && table.getLeaveType()!=" "){
			s = s + "@p_leavetype='" + table.getLeaveType() + "',";
		}
		if(table.getJobTitle()!=null && table.getJobTitle()!=" "){
			s = s + "@p_jobtitle='" + table.getJobTitle() + "',";
		}
		if(table.getEmplmntStatus()!=null && table.getEmplmntStatus()!=" "){
			s = s + "@p_EmplmtStatus='" + table.getEmplmntStatus() + "',";
		}
		if(table.getEmpl()!=null && table.getEmpl()!=" "){
			s = s + "@p_empl='" + table.getEmpl() + "',";
		}
		if(table.getDepartment()!=null && table.getDepartment()!=" "){
			s = s + "@p_department='" + table.getDepartment() + "',";
		}
		if(table.getLeavePeriod()!=null && table.getLeavePeriod()!=" "){
			s = s + "@p_leavePeriod='" + table.getLeavePeriod() + "',";
		}
		if(table.getLeavePerPeriod()!=null){
			s = s + "@p_leavePerPeriod='" + table.getLeavePerPeriod() + "',";
		}
		
		Double leavePerPeriod=table.getLeavePerPeriod();
		Double leavePerMonth=leavePerPeriod/12;
		s = s + "@p_leavePerMonth='" + leavePerMonth + "',";
		
		if(table.getIsadminAssign()!=null){
			s = s + "@p_adminAssign=" + table.getIsadminAssign() + ",";
			
		}
		if(table.getIsEmpApply()!=null){
			s = s + "@p_empApply=" + table.getIsEmpApply() + ","; 
		}
		
		if(table.getIsEmpAlyMoreThanALeave()!=null){
			s = s + "@p_empApplyMore=" + table.getIsEmpAlyMoreThanALeave() + ","; 
		}

		if(table.getIsAccrueEnb()!=null){
			s = s + "@p_accuEnb=" + table.getIsAccrueEnb() + ","; 
		}
		
		if(table.getIsCarriedFwd()!=null){
			s = s + "@p_carriedfwd=" + table.getIsCarriedFwd() + ","; 
		}
		
		if(table.getCarriedFwdPercnt()!=null){
			s = s + "@p_carriedfwdPercent='" + table.getCarriedFwdPercnt() + "',"; 
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
		
		 
		 
		s = s + "@p_createdBy='" + table.getCreatedBy() + "',";
		 
		 
		
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

