/**
 * 
 */
package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Nirmalya Labs
 *
 */
public class InventoryIssueNoteDashboardModel {

	private Integer todayIssueNote;

	private Integer totalIssueNote;

	private Integer totalOpenRequistion;

	private Integer todayClosedRequistion;

	/**
	 * CONSTRUCTOR SUPERCLASS
	 */

	public InventoryIssueNoteDashboardModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * CONSTRUCTOR CALL
	 */

	public InventoryIssueNoteDashboardModel(Object todayIssueNote, Object totalIssueNote, Object totalOpenRequistion,
			Object todayClosedRequistion) {
		super();

		try {
			this.todayIssueNote = (Integer) todayIssueNote;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.totalIssueNote = (Integer) totalIssueNote;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.totalOpenRequistion = (Integer) totalOpenRequistion;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.todayClosedRequistion = (Integer) todayClosedRequistion;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * GETTER SETTER
	 */

	public Integer getTodayIssueNote() {
		return todayIssueNote;
	}

	public void setTodayIssueNote(Integer todayIssueNote) {
		this.todayIssueNote = todayIssueNote;
	}

	public Integer getTotalIssueNote() {
		return totalIssueNote;
	}

	public void setTotalIssueNote(Integer totalIssueNote) {
		this.totalIssueNote = totalIssueNote;
	}

	public Integer getTotalOpenRequistion() {
		return totalOpenRequistion;
	}

	public void setTotalOpenRequistion(Integer totalOpenRequistion) {
		this.totalOpenRequistion = totalOpenRequistion;
	}

	public Integer getTodayClosedRequistion() {
		return todayClosedRequistion;
	}

	public void setTodayClosedRequistion(Integer todayClosedRequistion) {
		this.todayClosedRequistion = todayClosedRequistion;
	}

	@Override
	public String toString() {
		ObjectMapper mapperObj = new ObjectMapper();
		String jsonStr;
		try {
			jsonStr = mapperObj.writeValueAsString(this);
		} catch (IOException ex) {

			jsonStr = ex.toString();
		}
		return jsonStr;
	}

}
