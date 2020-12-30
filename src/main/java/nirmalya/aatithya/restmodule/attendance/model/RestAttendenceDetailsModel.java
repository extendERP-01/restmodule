/**
 * Defines attendence details model in rest
 * 
 * 
 */
package nirmalya.aatithya.restmodule.attendance.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Nirmalya Labs
 *
 */
public class RestAttendenceDetailsModel {

	
	
	private String tEmployee;
	private String tAttndncDate;
	private String tAttndncPunchIn;
	private Integer tAttndncPunchInLoc;
	private String tAttndncPunchInNote;
	private String tAttndncPunchOut;
	private String tAttndncPunchOutNote;
	private Integer tAttndncPunchOut_Loc;
	private String tAttndncCreatedOn;
	private String tAttndncCreatedBy;
	
	
	public RestAttendenceDetailsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RestAttendenceDetailsModel(Object tEmployee, Object tAttndncDate, Object tAttndncPunchIn, Object tAttndncPunchInLoc,
			Object tAttndncPunchInNote, Object tAttndncPunchOut, Object tAttndncPunchOutNote, Object tAttndncPunchOut_Loc, 
			Object tAttndncCreatedOn, Object tAttndncCreatedBy) {
		super();
		try {
			this.tEmployee = (String) tEmployee;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tAttndncDate = (String) tAttndncDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tAttndncPunchIn = (String) tAttndncPunchIn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tAttndncPunchInLoc = (Integer) tAttndncPunchInLoc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tAttndncPunchInNote = (String) tAttndncPunchInNote;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			this.tAttndncPunchOut = (String) tAttndncPunchOut;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tAttndncPunchOutNote = (String) tAttndncPunchOutNote;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tAttndncPunchOut_Loc = (Integer) tAttndncPunchOut_Loc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tAttndncCreatedOn = (String) tAttndncCreatedOn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tAttndncCreatedBy = (String) tAttndncCreatedBy;
		} catch (Exception e) {
			e.printStackTrace();
		}

}

	public String gettEmployee() {
		return tEmployee;
	}

	public void settEmployee(String tEmployee) {
		this.tEmployee = tEmployee;
	}

	public String gettAttndncDate() {
		return tAttndncDate;
	}

	public void settAttndncDate(String tAttndncDate) {
		this.tAttndncDate = tAttndncDate;
	}

	public String gettAttndncPunchIn() {
		return tAttndncPunchIn;
	}

	public void settAttndncPunchIn(String tAttndncPunchIn) {
		this.tAttndncPunchIn = tAttndncPunchIn;
	}

	public Integer gettAttndncPunchInLoc() {
		return tAttndncPunchInLoc;
	}

	public void settAttndncPunchInLoc(Integer tAttndncPunchInLoc) {
		this.tAttndncPunchInLoc = tAttndncPunchInLoc;
	}

	public String gettAttndncPunchInNote() {
		return tAttndncPunchInNote;
	}

	public void settAttndncPunchInNote(String tAttndncPunchInNote) {
		this.tAttndncPunchInNote = tAttndncPunchInNote;
	}

	public String gettAttndncPunchOut() {
		return tAttndncPunchOut;
	}

	public void settAttndncPunchOut(String tAttndncPunchOut) {
		this.tAttndncPunchOut = tAttndncPunchOut;
	}

	public String gettAttndncPunchOutNote() {
		return tAttndncPunchOutNote;
	}

	public void settAttndncPunchOutNote(String tAttndncPunchOutNote) {
		this.tAttndncPunchOutNote = tAttndncPunchOutNote;
	}

	public Integer gettAttndncPunchOut_Loc() {
		return tAttndncPunchOut_Loc;
	}

	public void settAttndncPunchOut_Loc(Integer tAttndncPunchOut_Loc) {
		this.tAttndncPunchOut_Loc = tAttndncPunchOut_Loc;
	}

	public String gettAttndncCreatedOn() {
		return tAttndncCreatedOn;
	}

	public void settAttndncCreatedOn(String tAttndncCreatedOn) {
		this.tAttndncCreatedOn = tAttndncCreatedOn;
	}

	public String gettAttndncCreatedBy() {
		return tAttndncCreatedBy;
	}

	public void settAttndncCreatedBy(String tAttndncCreatedBy) {
		this.tAttndncCreatedBy = tAttndncCreatedBy;
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
