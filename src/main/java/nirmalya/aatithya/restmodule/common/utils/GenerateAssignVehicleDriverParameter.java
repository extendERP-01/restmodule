package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.asset.model.AssignVehicleToDriverModel;

public class GenerateAssignVehicleDriverParameter {

	public static String assignVehicleToDriver(List<AssignVehicleToDriverModel> assignedDriver) {
		String s = "";
		String driver = "";
		
		for(AssignVehicleToDriverModel m : assignedDriver) {
			driver = driver + "(\""+m.getDriverId()+"\",\""+m.getvAssetId()+"\",\""+m.getVehicleNo()+"\",\""+DateFormatter.getStringDate(m.getAssignDate())+"\",\""+m.getCreatedBy()+"\"),";
		}
		
		driver = driver.substring(0, driver.length() - 1);

		s = s + "@p_driverSubQuery='" + driver + "',";
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		System.out.println(s);
		return s;
	}

}
