package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.reimbursement.model.HrmsReimbursementModel;

public class GenerateReimbursementParameter {
	public static String getAddReimbursementParam(List<HrmsReimbursementModel> hrmsReimbursementModel) {

		String s = "";
		String dtls = "";

		for (HrmsReimbursementModel a : hrmsReimbursementModel) {

			if (a.getEmpId() != null && a.getEmpId() != "") {
				s = s + "@p_empId='" + a.getEmpId();
			}
			if (a.getReqId() != null && a.getReqId() != "") {
				s = s + "',@p_reqId='" + a.getReqId();
			}
			if (a.getPlaceName() != null && a.getPlaceName() != "") {
				s = s + "',@p_placeName='" + a.getPlaceName();
			}
			if (a.getPurpose() != null && a.getPurpose() != "") {
				s = s + "',@p_purpose='" + a.getPurpose();
			}
			if (a.getAdvanceAmount() != null) {
				s = s + "',@p_advanceAmount='" + a.getAdvanceAmount();
			}
			if (a.getFromDate() != null) {

				s = s + "',@p_fromDate='" + DateFormatter.getStringDate(a.getFromDate());
			}
			if (a.getToDate() != null) {

				s = s + "',@p_toDate='" + DateFormatter.getStringDate(a.getToDate());
			}
			if (a.getRembId()!= null && a.getRembId()!= "") {

				s = s + "',@p_reimbId='" + a.getRembId() ;
			}
			if (a.getCreatedBy() != null) {

				s = s + "',@p_createdBy='" + a.getCreatedBy() + "',";
			}
			
			if (a.getReimbType()!= null && a.getReimbType()!= "") {

				s = s + "@p_reimbType='" + a.getReimbType()+ "',";
			}
			
		}
		for (HrmsReimbursementModel m : hrmsReimbursementModel) {
			dtls = dtls + "(@p_reimbId,\"" + m.getRembType() + "\",\""+ m.getPolicyId() + "\",\"" + DateFormatter.getStringDate(m.getRembDate())
					+ "\",\"" + m.getRembDesc() + "\"," + m.getRembAmount() + ",\"" + m.getFileName() + "\",\""
					+ m.getRembRefNo() + "\",\"" + m.getCreatedBy() + "\"),";
		}
		dtls = dtls.substring(0, dtls.length() - 1);

		s = s + "@p_dtlsSubQuery='" + dtls + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}
}
