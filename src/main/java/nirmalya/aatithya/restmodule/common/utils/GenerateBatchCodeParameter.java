package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.inventory.model.BatchCodeModel;

public class GenerateBatchCodeParameter {

	public static String newBatchCode(List<BatchCodeModel> batchCode) {
		String s = "";
		String batch = "";

		if (batchCode.get(0).getBatchId() != "" && batchCode.get(0).getBatchId() != null) {
			s = s + "@p_batch='" + batchCode.get(0).getBatchId() + "',";
		}
		if (batchCode.get(0).getGrnId() != "" && batchCode.get(0).getBatchId() != null) {
			s = s + "@p_grn='" + batchCode.get(0).getGrnId() + "',";
		}

		for (BatchCodeModel m : batchCode) {
			batch = batch + "(@p_batch,\"" + m.getGrnId() + "\",\"" + m.getGradeId() + "\",\"" + m.getThicknessId()
					+ "\",\"" + m.getPipeSizeId() + "\",\"" + m.getBatchCode() + "\",\"" + m.getCreatedBy() + "\"),";
		}

		batch = batch.substring(0, batch.length() - 1);

		s = s + "@p_batchSubQuery='" + batch + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

	public static String newBatchCodeSingle(BatchCodeModel batchCode) {
		String s = "";

		if (batchCode.getBatchId() != "" && batchCode.getBatchId() != null) {
			s = s + "@p_batch='" + batchCode.getBatchId() + "',";
		}
		if (batchCode.getGrnId() != "" && batchCode.getBatchId() != null) {
			s = s + "@p_grn='" + batchCode.getGrnId() + "',";
		}

		if (batchCode.getGradeId() != "" && batchCode.getGradeId() != null) {
			s = s + "@p_gradeId='" + batchCode.getGradeId() + "',";
		}

		if (batchCode.getThicknessId() != "" && batchCode.getThicknessId() != null) {
			s = s + "@p_thickness='" + batchCode.getThicknessId() + "',";
		}

		if (batchCode.getPipeSizeId() != "" && batchCode.getPipeSizeId() != null) {
			s = s + "@p_pipeSize='" + batchCode.getPipeSizeId() + "',";
		}

		if (batchCode.getBatchCode() != "" && batchCode.getBatchCode() != null) {
			s = s + "@p_batchCode='" + batchCode.getBatchCode() + "',";
		}

		if (batchCode.getCreatedBy() != "" && batchCode.getCreatedBy() != null) {
			s = s + "@p_createdBy='" + batchCode.getCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

}
