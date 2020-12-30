package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsEmployeeAppraisalFormListModel {
	private String goal;
	private String kraMeasure;
	private Double target;
	private Double selfMarked;
	private String goalName;
	
	public HrmsEmployeeAppraisalFormListModel(Object goal, Object kraMeasure, Object target, Object selfMarked,
			Object goalName) {
		super();
		try{
			this.goal = (String) goal;
		}catch(Exception e) {
			e.printStackTrace();
		}
		try{
			this.kraMeasure = (String) kraMeasure;
		}catch(Exception e) {
			e.printStackTrace();
		}
		try{
			this.target = (Double) target;
		}catch(Exception e) {
			e.printStackTrace();
		}
		try{
			this.selfMarked = (Double) selfMarked;
		}catch(Exception e) {
			e.printStackTrace();
		}
		try{
			this.goalName = (String)goalName;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public HrmsEmployeeAppraisalFormListModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getKraMeasure() {
		return kraMeasure;
	}

	public void setKraMeasure(String kraMeasure) {
		this.kraMeasure = kraMeasure;
	}

	public Double getTarget() {
		return target;
	}

	public void setTarget(Double target) {
		this.target = target;
	}

	public Double getSelfMarked() {
		return selfMarked;
	}

	public void setSelfMarked(Double selfMarked) {
		this.selfMarked = selfMarked;
	}

	public String getGoalName() {
		return goalName;
	}

	public void setGoalName(String goalName) {
		this.goalName = goalName;
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
