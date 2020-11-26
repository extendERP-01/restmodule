/**
 * 
 */
package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.inventory.model.RestInventoryRequisitionIssueNoteModel;

/**
 * @author NirmalyaLabs
 *
 */
public class GenerateInventoryRequisitionIssueNoteParameter {

	/**
	 * add parameter set for inventory PurchaseOrder class
	 *
	 **/
	public static String getIssueNoteDtlParam(
			List<RestInventoryRequisitionIssueNoteModel> restInventoryRequisitionIssueNoteModel) {
		System.out.println(restInventoryRequisitionIssueNoteModel);
		String update = "";
		String s = "";
		String litem = "";
		String reqstnIssueNote = "";
		String itemRequisition = "";
		String tStore = "";
		String tGodown = "";
		String Description = "";
		Boolean status = null;
		String createdBy = "";
		for (RestInventoryRequisitionIssueNoteModel m : restInventoryRequisitionIssueNoteModel) {
			reqstnIssueNote = m.getReqstnIssueNote();
			itemRequisition = m.getItemRequisition();
			tStore = m.gettStore();
			tGodown = m.gettGodown();
			Description = m.getiNoteDescription();
			status = m.getpINoteActive();
			createdBy = m.getCreatedBy();
		}
		s = s + "@p_reqstnIssueNote='" + reqstnIssueNote + "',";
		s = s + "@p_itemRequisition='" + itemRequisition + "',";
		s = s + "@p_store='" + tStore + "',";
		s = s + "@p_godown='" + tGodown + "',";
		s = s + "@p_description='" + Description + "',";
		s = s + "@p_status=" + status + ",";
		s = s + "@p_createdBy='" + createdBy + "',";
		update = update + "(";
		for (RestInventoryRequisitionIssueNoteModel m : restInventoryRequisitionIssueNoteModel) {
			
			
				litem = litem + "(@p_childIssue,\"" + m.getItemCategory() + "\",\"" + m.getItemSubCategory() + "\",\"" + m.getItem() + "\"," + m.getiNoteQty() + "),";
				
		

		}
		update = update.substring(0, update.length() - 1);
		update = update + ")";

		litem = litem.substring(0, litem.length() - 1);

		s = s + "@p_litemSubQuery='" + litem + "',";
		s = s + "@p_updateSubQuery='" + update + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}
}
