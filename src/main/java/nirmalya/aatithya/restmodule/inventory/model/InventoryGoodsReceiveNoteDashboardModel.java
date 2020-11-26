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
public class InventoryGoodsReceiveNoteDashboardModel {

	private Integer todayGoodsReceiveNote;

	private Integer totalGoodsReceiveNote;

	private Integer todayGrnPrice;

	private Integer totalGrnPrice;

	/**
	 * CONSTRUCTOR SUPERCLASS
	 */

	public InventoryGoodsReceiveNoteDashboardModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * CONSTRUCTOR CALL
	 */

	public InventoryGoodsReceiveNoteDashboardModel(Object todayGoodsReceiveNote, Object totalGoodsReceiveNote, Object todayGrnPrice, Object totalGrnPrice) {
		super();

		try {
			this.todayGoodsReceiveNote = (Integer) todayGoodsReceiveNote;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.totalGoodsReceiveNote = (Integer) totalGoodsReceiveNote;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.todayGrnPrice = (Integer) todayGrnPrice;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.totalGrnPrice = (Integer) totalGrnPrice;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * GETTER SETTER
	 */


	public Integer getTodayGoodsReceiveNote() {
		return todayGoodsReceiveNote;
	}

	public void setTodayGoodsReceiveNote(Integer todayGoodsReceiveNote) {
		this.todayGoodsReceiveNote = todayGoodsReceiveNote;
	}

	public Integer getTotalGoodsReceiveNote() {
		return totalGoodsReceiveNote;
	}

	public void setTotalGoodsReceiveNote(Integer totalGoodsReceiveNote) {
		this.totalGoodsReceiveNote = totalGoodsReceiveNote;
	}

	public Integer getTodayGrnPrice() {
		return todayGrnPrice;
	}

	public void setTodayGrnPrice(Integer todayGrnPrice) {
		this.todayGrnPrice = todayGrnPrice;
	}

	public Integer getTotalGrnPrice() {
		return totalGrnPrice;
	}

	public void setTotalGrnPrice(Integer totalGrnPrice) {
		this.totalGrnPrice = totalGrnPrice;
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
