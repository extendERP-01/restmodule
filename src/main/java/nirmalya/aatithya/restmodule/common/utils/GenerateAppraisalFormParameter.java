package nirmalya.aatithya.restmodule.common.utils;

import java.util.ArrayList;
import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeAppraisalFormListModel;
import nirmalya.aatithya.restmodule.employee.model.RestHrmsEmployeeAppraisalFormModel;

public class GenerateAppraisalFormParameter {
	public static String submitAppraisalParam(List<RestHrmsEmployeeAppraisalFormModel> appraisalForm) {
		String s = "";
		String litem = "";
		System.out.println("================"+appraisalForm);
		for (RestHrmsEmployeeAppraisalFormModel m : appraisalForm) {
			
			String newdate = DateFormatter.getStringDate(m.getFromDate());
			m.setFromDate(newdate);
			String newdate3 = DateFormatter.getStringDate(m.getEmpDueDate());
			m.setEmpDueDate(newdate3);
			String newdate2 = DateFormatter.getStringDate(m.getToDate());
			m.setToDate(newdate2);

			
			List<HrmsEmployeeAppraisalFormListModel> list = new ArrayList<HrmsEmployeeAppraisalFormListModel>();
			list = m.getAppraisalList();
			
			System.out.println("list"+list);
			for (int i=0;i>list.size();i++)
				System.out.println("arrayList" + list);
			{
				litem = litem + "(\"" + m.getEmpId() + "\",\"" + m.getDept() + "\",\"" + m.getJobTitle() + "\",\""
						+ m.getFromDate() + "\",\"" + m.getToDate() + "\",\"" + m.getEmpDueDate()+ "\",\"" +  m.getAppraisalList().get(0).getGoal()
						+ "\",\"" +  m.getAppraisalList().get(0).getKraMeasure() + "\",\"" + m.getAppraisalList().get(0).getTarget() + "\",\"" +  m.getAppraisalList().get(0).getSelfMarked() + "\",\""
						+ m.gettCreatedBy() + "\",\"" + m.gettCompanyId() + "\"),";
			}
		}
		litem = litem.substring(0, litem.length() - 1);
		s = "@p_appId='" + appraisalForm.get(0).gettAppraisalSetupId()+ "',";
		s = s + "@p_litem='" + litem + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("PRAM IN GENERATE pARAM" + litem);
		System.out.println("222222222" + appraisalForm.get(0).gettAppraisalSetupId());
		return s;
	}

}
