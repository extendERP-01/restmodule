package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.recruitment.model.ResourceModel;

public class GenerateVendorSourcingParameter {

	public static String addVendor(ResourceModel model) {

		String s = "";
		String qItem = "";

		for (int i = 0; i < model.getVendorList().size(); i++) {
			qItem = qItem + "(\"" + model.getRequisitionId() + "\",\"" + model.getVendorList().get(i) + "\"),";
		}

		qItem = qItem.substring(0, qItem.length() - 1);

		s = s + "@p_qItemSubQuery='" + qItem + "',";
		s = s + "@p_asgnStatus=" + true + ",";
		s = s + "@p_reqId='" + model.getRequisitionId() + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String addShortList(List<ResourceModel> model) {

		String s = "";
		String qItem = "";

		for (ResourceModel m : model) {

			qItem = qItem + "(\"" + m.getRequisitionId() + "\",\"" + m.getVendorId() + "\",\"" + m.getCandidateName()
					+ "\",\"" + DateFormatter.getStringDate(m.getDob()) + "\",\"" + m.getFatherName() + "\",\""
					+ m.getDocument() + "\",\"" + m.getCreatedBy() + "\"),";
		}

		qItem = qItem.substring(0, qItem.length() - 1);

		s = s + "@p_shortList='" + qItem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String addShortListInterview(ResourceModel model) {

		String s = "";
		String qItem = "";

		for (int i = 0; i < model.getVendorList().size(); i++) {
			qItem = qItem + "(\"" + model.getRequisitionId() + "\",\"" + model.getCandidateId() + "\",\""
					+ model.getVendorList().get(i) + "\",\"" + DateFormatter.getStringDate(model.getDob()) + "\",\""
					+ model.getFromTime() + "\",\"" + model.getToTime() + "\",\"" + model.getStatus() + "\",\""
					+ model.getCreatedBy() + "\"),";
		}

		qItem = qItem.substring(0, qItem.length() - 1);

		s = s + "@p_qItemSubQuery='" + qItem + "',";
		s = s + "@p_reqId='" + model.getRequisitionId() + "',";
		s = s + "@p_status='" + model.getStatus() + "',";
		s = s + "@p_candId='" + model.getCandidateId() + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String addFeedback(List<ResourceModel> index) {

		String s = "";
		String qItem = "";

		for (int i = 0; i < index.size(); i++) {
			qItem = qItem + "(\"" + index.get(i).getRequisitionId() + "\",\"" + index.get(i).getCandidateId() + "\",\""
					+ index.get(i).getJobId() + "\",\"" + index.get(i).getSpecificId() + "\",\""
					+ index.get(i).getQuestion() + "\",\"" + index.get(i).getRemark() + "\",\""
					+ index.get(i).getDocument() + "\",\"" + index.get(i).getDob() + "\",\"" + index.get(i).getStatus()
					+ "\",\"" + index.get(0).getCreatedBy() + "\"),";
		}

		qItem = qItem.substring(0, qItem.length() - 1);

		s = s + "@p_addFeedback='" + qItem + "',";
		s = s + "@p_reqId='" + index.get(0).getRequisitionId() + "',";
		s = s + "@p_candId='" + index.get(0).getCandidateId() + "',";
		s = s + "@p_status='" + index.get(0).getStatus() + "',";
		s = s + "@p_empId='" + index.get(0).getCreatedBy() + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

}
