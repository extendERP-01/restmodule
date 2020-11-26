package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.RestKRAMeasureDetailsModel;

public class GenerateKRAMeasureDetailsParameter {

	public static String addKraMrasureParam(List<RestKRAMeasureDetailsModel> measureDetails) {
		String s = "";
		String litem = "";
		String deleteChairStaff = "";
			for(RestKRAMeasureDetailsModel m: measureDetails){
				
				deleteChairStaff = deleteChairStaff + "(\""+m.getkDepartment()+"\",\""+m.getkJobTitle()+"\"),";		
				litem = litem + "(\""+m.getkDepartment()+"\",\""+m.getkJobTitle()+"\",\""+m.getkGoal()+"\",\""+m.getkMeasure()+"\",\""+m.getkTarget()+"\",\""+m.getkCompanyId()+"\",\""+m.getkCreatedBy()+"\"),";
			}
				litem = litem.substring(0, litem.length() - 1);
				deleteChairStaff = deleteChairStaff.substring(0, deleteChairStaff.length() - 1);		
				
				s = s + "@p_deleteSubQuery='"+ "("+ deleteChairStaff +")"+ "',";
				s = s + "@p_litem='" + litem + "',";
				if(s != "") {
					s = s.substring(0, s.length()-1);
					
					s = "SET " + s + ";" ;
				}
				System.out.println("PRAM IN GENERATE pARAM"+ deleteChairStaff);
				return s;
			}
			
		}

				