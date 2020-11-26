package nirmalya.aatithya.restmodule.common.utils;


import nirmalya.aatithya.restmodule.master.model.SubGroupMasterModel;

public class GenerateSubGroupNameParametr {
	public static String getAddSubGroup(SubGroupMasterModel ticket) {

		String s = "";
		
		if(ticket.getSubGroupId()!=null && ticket.getSubGroupId()!=" ")
		{
			s = s + "@p_SubGroupId='" + ticket.getSubGroupId() + "',";
		}
		if(ticket.getSubGroupName()!=null && ticket.getSubGroupName()!=" ")
		{
			s = s + "@p_SubGroupName='" + ticket.getSubGroupName() + "',";
		}
		
		if(ticket.getGroupName()!=null && ticket.getGroupName()!=" ")
		{
			s = s + "@p_GroupName='" + ticket.getGroupName() + "',";
		}
		if(ticket.getGroupNameDesc()!=null && ticket.getGroupNameDesc()!=" ")
		{
			s = s + "@p_GroupNameDesc='" + ticket.getGroupNameDesc() + "',";
		}
		if(ticket.getCreatedBy() !=null)
		{
			s = s + "@P_createdBy='"+ticket.getCreatedBy()+"',";
		}
		
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		return s;
		
}
}


