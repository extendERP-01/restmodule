package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.reimbursement.model.HrmsTravelingRequisituionModel;

public class GenerateTravelingRequisitionParam {

	public static String getAddtravelingReqParam(HrmsTravelingRequisituionModel travelingReq) {
		String s = "";

		if (travelingReq.getReqId() != null) {
			s = s + "@P_reqId='" + travelingReq.getReqId() + "',";
		}
		if (travelingReq.getPlaceName() != null && travelingReq.getPlaceName() != "") {
			s = s + "@p_travelingPlaceName='" + travelingReq.getPlaceName() + "',";
		}

		if (travelingReq.getPurpose() != null && travelingReq.getPurpose() != "") {
			s = s + "@p_travelingPerpose='" + travelingReq.getPurpose() + "',";
		}
		if (travelingReq.getCreatedBy() != null && travelingReq.getCreatedBy() != " ") {
			s = s + "@p_createdBy='" + travelingReq.getCreatedBy() + "',";
		}
		if (travelingReq.getCompanyId() != null && travelingReq.getCompanyId() != "") {
			s = s + "@p_companyId='" + travelingReq.getCompanyId() + "',";
		}
		if (travelingReq.getAdvanceNeed() == true || travelingReq.getAdvanceNeed() == false) {
			s = s + "@p_advanceNeeded=" + travelingReq.getAdvanceNeed() + ",";
		}
		if (travelingReq.getAdvanceNeed() == true) {
			if (travelingReq.getAdvanceAmount() != null) {
				s = s + "@p_advanceAmount='" + travelingReq.getAdvanceAmount() + "',";
			}
		} else {
			if (travelingReq.getAdvanceAmount() != null) {
				s = s + "@p_advanceAmount=NULL,";
			}
		}
		if (travelingReq.getFromDate() != null && travelingReq.getFromDate() != "") {
			s = s + "@p_fromDate='" + DateFormatter.getStringDate(travelingReq.getFromDate()) + "',";
		}
		if (travelingReq.getToDate() != null && travelingReq.getToDate() != "") {
			s = s + "@p_toDate='" + DateFormatter.getStringDate(travelingReq.getToDate()) + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}
}
