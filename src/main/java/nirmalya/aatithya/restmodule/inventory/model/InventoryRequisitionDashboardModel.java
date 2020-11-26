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
public class InventoryRequisitionDashboardModel {

	private Integer todayRequisition;

	private Integer pastDueRequisition;

	private Integer todayClosedRequisition;

	private Integer totalClosedRequisition;

	/**
	 * CONSTRUCTOR SUPERCLASS
	 */

	public InventoryRequisitionDashboardModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * CONSTRUCTOR CALL
	 */

	public InventoryRequisitionDashboardModel(Object todayRequisition, Object pastDueRequisition,
			Object todayClosedRequisition, Object totalClosedRequisition) {
		super();

		try {
			this.todayRequisition = (Integer) todayRequisition;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.pastDueRequisition = (Integer) pastDueRequisition;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.todayClosedRequisition = (Integer) todayClosedRequisition;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.totalClosedRequisition = (Integer) totalClosedRequisition;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * GETTER SETTER
	 */

	public Integer getTodayRequisition() {
		return todayRequisition;
	}

	public void setTodayRequisition(Integer todayRequisition) {
		this.todayRequisition = todayRequisition;
	}

	public Integer getPastDueRequisition() {
		return pastDueRequisition;
	}

	public void setPastDueRequisition(Integer pastDueRequisition) {
		this.pastDueRequisition = pastDueRequisition;
	}

	public Integer getTodayClosedRequisition() {
		return todayClosedRequisition;
	}

	public void setTodayClosedRequisition(Integer todayClosedRequisition) {
		this.todayClosedRequisition = todayClosedRequisition;
	}

	public Integer getTotalClosedRequisition() {
		return totalClosedRequisition;
	}

	public void setTotalClosedRequisition(Integer totalClosedRequisition) {
		this.totalClosedRequisition = totalClosedRequisition;
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
