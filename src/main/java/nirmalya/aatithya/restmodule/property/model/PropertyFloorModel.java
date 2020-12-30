/*
 *  model for property floor in rest
 */

package nirmalya.aatithya.restmodule.property.model;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PropertyFloorModel {
	private String floorId;
	private String floorName;
	private String floorDesc;
	private Boolean floorActive;
	private String pFloorCreatedBy;

	public PropertyFloorModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertyFloorModel(Object floorId, Object floorName, Object floorDesc, Object floorActive) {
		super();

		try {
			this.floorId = (String) floorId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.floorName = (String) floorName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.floorDesc = (String) floorDesc;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.floorActive = (Boolean) floorActive;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public String getFloorDesc() {
		return floorDesc;
	}

	public void setFloorDesc(String floorDesc) {
		this.floorDesc = floorDesc;
	}

	public Boolean getFloorActive() {
		return floorActive;
	}

	public void setFloorActive(Boolean floorActive) {
		this.floorActive = floorActive;
	}

	public String getpFloorCreatedBy() {
		return pFloorCreatedBy;
	}

	public void setpFloorCreatedBy(String pFloorCreatedBy) {
		this.pFloorCreatedBy = pFloorCreatedBy;
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
