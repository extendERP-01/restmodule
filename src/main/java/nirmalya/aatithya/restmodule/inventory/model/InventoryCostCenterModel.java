/**
 * Define RestCostCenter
 */
package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Nirmalya Labs
 *
 */
public class InventoryCostCenterModel {

	private String costCenterId;
	private String costCenterName;
	private String costCenterDescription;
	private Boolean costCenterActive;
	private Date itmServeTypeCreatedOn;
	private Date itmServeTypeUpdatedOn;

	public InventoryCostCenterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventoryCostCenterModel(Object costCenterId, Object costCenterName, Object costCenterDescription,
			Object costCenterActive, Object itmServeTypeCreatedOn, Object itmServeTypeUpdatedOn) {
		super();
		try {
			this.costCenterId = (String) costCenterId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.costCenterName = (String) costCenterName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.costCenterDescription = (String) costCenterDescription;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.costCenterActive = (Boolean) costCenterActive;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itmServeTypeCreatedOn = (Date) itmServeTypeCreatedOn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itmServeTypeUpdatedOn = (Date) itmServeTypeUpdatedOn;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCostCenterId() {
		return costCenterId;
	}

	public void setCostCenterId(String costCenterId) {
		this.costCenterId = costCenterId;
	}

	public String getCostCenterName() {
		return costCenterName;
	}

	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}

	public String getCostCenterDescription() {
		return costCenterDescription;
	}

	public void setCostCenterDescription(String costCenterDescription) {
		this.costCenterDescription = costCenterDescription;
	}

	public Boolean getCostCenterActive() {
		return costCenterActive;
	}

	public void setCostCenterActive(Boolean costCenterActive) {
		this.costCenterActive = costCenterActive;
	}

	public Date getItmServeTypeCreatedOn() {
		return itmServeTypeCreatedOn;
	}

	public void setItmServeTypeCreatedOn(Date itmServeTypeCreatedOn) {
		this.itmServeTypeCreatedOn = itmServeTypeCreatedOn;
	}

	public Date getItmServeTypeUpdatedOn() {
		return itmServeTypeUpdatedOn;
	}

	public void setItmServeTypeUpdatedOn(Date itmServeTypeUpdatedOn) {
		this.itmServeTypeUpdatedOn = itmServeTypeUpdatedOn;
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
