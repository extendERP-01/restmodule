package nirmalya.aatithya.restmodule.common.utils;

import java.util.ArrayList;
import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.HrmsAppraisalFormModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeAppraisalFormListModel;

public class GenerateAppraisalApprovalParameter {

	public static String appraisalApprovalParam(List<HrmsAppraisalFormModel> managerAppraisalForm) {
		String s = "";
		String litem = "";
		String deleteChairStaff = "";
		for (HrmsAppraisalFormModel m : managerAppraisalForm) {
			String newdate1 = DateFormatter.getStringDate(m.gettAppraisalFromDate());
			m.settAppraisalFromDate(newdate1);
			String newdate2 = DateFormatter.getStringDate(m.gettAppraisalToDate());
			m.settAppraisalToDate(newdate2);
			String newdate3 = DateFormatter.getStringDate(m.gettAppraisalDueDate());
			m.settAppraisalDueDate(newdate3);
			deleteChairStaff = deleteChairStaff + "(\"" + m.gettEmployeeId() + "\",\"" + m.gettEmployeeDept() + "\",\""
					+ m.gettEmployeeJobTitle() + "\",\"" + m.gettAppraisalFromDate() + "\",\"" + m.gettAppraisalToDate()
					+ "\",\"" + m.gettAppraisalDueDate()+ "\"),";
			litem = litem + "(\"" + m.gettEmployeeId() + "\",\"" + m.gettEmployeeDept() + "\",\""
					+ m.gettEmployeeJobTitle() + "\",\"" + m.gettAppraisalFromDate() + "\",\"" + m.gettAppraisalToDate()
					+ "\",\"" + m.gettAppraisalDueDate()+ "\",\"" + m.gettGoal() + "\",\"" + m.gettKRAMeasure() + "\",\"" + m.gettTarget() + "\",\""
					+ m.gettSelfRate() + "\",\"" + m.gettFirstStageRating() + "\",\"" + m.gettCreatedBy() + "\",\""
					+ m.gettCompanyId() + "\",\"" + m.gettStageNo() + "\",\"" + m.gettStage1Comment() + "\"),";
		}
		litem = litem.substring(0, litem.length() - 1);
		deleteChairStaff = deleteChairStaff.substring(0, deleteChairStaff.length() - 1);

		s = s + "@p_deleteSubQuery='" + "(" + deleteChairStaff + ")" + "',";
		s = s + "@p_appId='" + managerAppraisalForm.get(0).gettAppraisalSetupId()+ "',";
		s = s + "@p_litem='" + litem + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("s +++" + deleteChairStaff);
		return s;
	}

	/****************************************************************************************************************************************************************/

	public static String appraisalAdminApprovalParam(List<HrmsAppraisalFormModel> adminAppraisalForm) {
		String s = "";
		String litem = "";

		String deleteChairStaff = "";
		for (HrmsAppraisalFormModel m : adminAppraisalForm) {
			String newdate1 = DateFormatter.getStringDate(m.gettAppraisalFromDate());
			m.settAppraisalFromDate(newdate1);
			String newdate2 = DateFormatter.getStringDate(m.gettAppraisalToDate());
			m.settAppraisalToDate(newdate2);
			String newdate3 = DateFormatter.getStringDate(m.gettAppraisalDueDate());
			m.settAppraisalDueDate(newdate3);
			m.settAppraisalStatus(false);
			deleteChairStaff = deleteChairStaff + "(\"" + m.gettEmployeeId() + "\",\"" + m.gettEmployeeDept() + "\",\""
					+ m.gettEmployeeJobTitle() + "\",\"" + m.gettAppraisalFromDate() + "\",\"" + m.gettAppraisalToDate()
					+ "\",\"" + m.gettAppraisalDueDate()+ "\"),";
			litem = litem + "(\"" + m.gettEmployeeId() + "\",\"" + m.gettEmployeeDept() + "\",\""
					+ m.gettEmployeeJobTitle() + "\",\"" + m.gettAppraisalFromDate() + "\",\"" + m.gettAppraisalToDate()
					+ "\",\"" + m.gettAppraisalDueDate()+ "\",\"" + m.gettGoal() + "\",\"" + m.gettKRAMeasure() + "\",\"" + m.gettTarget() + "\",\""
					+ m.gettSelfRate() + "\",\"" + m.gettFirstStageRating() + "\",\"" + m.gettSecondStageRating()
					+ "\"," + m.gettAppraisalStatus()+ ",\"" + m.gettCreatedBy() + "\",\"" + m.gettCompanyId() + "\",\"" + m.gettStageNo() + "\",\""
					+ m.gettStage1Comment() + "\",\"" + m.gettStage2Comment() + "\",\"" + m.gettFinalComment() + "\"),";
		}
		litem = litem.substring(0, litem.length() - 1);
		deleteChairStaff = deleteChairStaff.substring(0, deleteChairStaff.length() - 1);

		s = s + "@p_deleteSubQuery='" + "(" + deleteChairStaff + ")" + "',";
		//s = s + "@p_cmnt='" + adminAppraisalForm.get(0).getCommonComment() + "',";
		s = s + "@p_litem='" + litem + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("s +++" + deleteChairStaff);
		return s;
	}

	

	/****************************************************************************************************************************************************************/

	public static String appraisalCommonParam(List<HrmsAppraisalFormModel> commonAppraisalForm) {
		String s = "";
		if(commonAppraisalForm.get(0).gettAppraisalSetupId()!=null)
		{
			s = s + "@p_appId='" + commonAppraisalForm.get(0).gettAppraisalSetupId() + "',";
		}
		if(commonAppraisalForm.get(0).getCommonComment()!=null && commonAppraisalForm.get(0).getCommonComment()!=" ")
		{
			s = s + "@p_cmnt='" + commonAppraisalForm.get(0).getCommonComment() + "',";
		}
		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("s +++" + s);
		return s;
	}
}