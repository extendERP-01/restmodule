package nirmalya.aatithya.restmodule.master.model;
/**
 * @author Nirmalya Labs
 *
 */
public class RelationModel {
private String relationId;
private String rltnName;
private String rltnDescription;
private Boolean rltnActive;
private String rltnCreatedBy;
private Boolean isEditable;
public RelationModel(Object relationId, Object rltnName, Object rltnDescription,Object isEditable, Object rltnActive) {
	super();
	// TODO Auto-generated constructor stub
	try {
		this.relationId = (String) relationId;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
		this.rltnName = (String) rltnName;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
		this.rltnDescription = (String) rltnDescription;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		this.isEditable = (Boolean) isEditable;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
		this.rltnActive = (Boolean) rltnActive;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public String getRelationId() {
	return relationId;
}
public void setRelationId(String relationId) {
	this.relationId = relationId;
}
public String getRltnName() {
	return rltnName;
}
public void setRltnName(String rltnName) {
	this.rltnName = rltnName;
}
public String getRltnDescription() {
	return rltnDescription;
}
public void setRltnDescription(String rltnDescription) {
	this.rltnDescription = rltnDescription;
}
public Boolean getRltnActive() {
	return rltnActive;
}
public void setRltnActive(Boolean rltnActive) {
	this.rltnActive = rltnActive;
}
public String getRltnCreatedBy() {
	return rltnCreatedBy;
}
public void setRltnCreatedBy(String rltnCreatedBy) {
	this.rltnCreatedBy = rltnCreatedBy;
}

public Boolean getIsEditable() {
	return isEditable;
}

public void setIsEditable(Boolean isEditable) {
	this.isEditable = isEditable;
}

}
