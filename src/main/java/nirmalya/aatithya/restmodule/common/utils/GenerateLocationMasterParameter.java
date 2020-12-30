package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.master.model.LocationMasterModel;
import nirmalya.aatithya.restmodule.master.model.LocationRoomModel;
import nirmalya.aatithya.restmodule.master.model.LocationSectionModel;

public class GenerateLocationMasterParameter {

	public static String saveLocation(LocationMasterModel location) {
		
		String s = "";
		
		if(location.getLocationId()!=null && location.getLocationId()!="") {
			s = s + "@p_locationId='" + location.getLocationId() + "',";
		}
		if(location.getFloorId()!=null && location.getFloorId()!="") {
			s = s + "@p_floorId='" + location.getFloorId() + "',";
		}
		if(location.getLocationName()!=null && location.getLocationName()!="") {
			s = s + "@p_locationName='" + location.getLocationName() + "',";
		}
		if(location.getLocationCode()!=null && location.getLocationCode()!="") {
			s = s + "@p_locationCode='" + location.getLocationCode() + "',";
		}
		if(location.getLocVirtual()!=null && location.getLocVirtual()!="") {
			s = s + "@p_isVirtual='" + location.getLocVirtual() + "',";
		} else {
			s = s + "@p_isVirtual='" + 0 + "',";
		}
		if(location.getLocationType()!=null && location.getLocationType()!="") {
			s = s + "@p_locType='" + location.getLocationType() + "',";
		}
		if(location.getLocCountry()!=null && location.getLocCountry()!="") {
			s = s + "@p_locCountry='" + location.getLocCountry() + "',";
		}
		if(location.getLocState()!=null && location.getLocState()!="") {
			s = s + "@p_locState='" + location.getLocState() + "',";
		}
		if(location.getLocCity()!=null && location.getLocCity()!="") {
			s = s + "@p_locCity='" + location.getLocCity() + "',";
		}
		if(location.getLocStreet()!=null && location.getLocStreet()!="") {
			s = s + "@p_locStreet='" + location.getLocStreet() + "',";
		}
		if(location.getFileLocation()!=null && location.getFileLocation()!="") {
			s = s + "@p_fileLocation='" + location.getFileLocation() + "',";
		}
		if(location.getCreatedBy()!=null && location.getCreatedBy()!="") {
			s = s + "@p_createdBy='" + location.getCreatedBy() + "',";
		}
		if(location.getLocStatus()!=null && location.getLocStatus()!="") {
			s = s + "@p_isActive='" + location.getLocStatus() + "',";
		} else {
			s = s + "@p_isActive='" + 0 + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		
		return s;
	}

	public static String saveSection(LocationSectionModel location) {

		String s = "";
		
		if(location.getLocationId()!=null && location.getLocationId()!="") {
			s = s + "@p_locationId='" + location.getLocationId() + "',";
		}
		if(location.getFloorId()!=null && location.getFloorId()!="") {
			s = s + "@p_floorId='" + location.getFloorId() + "',";
		}
		if(location.getSectionId()!=null && location.getSectionId()!="") {
			s = s + "@p_sectionId='" + location.getSectionId() + "',";
		}
		if(location.getSectionCode()!=null && location.getSectionCode()!="") {
			s = s + "@p_sectionCode='" + location.getSectionCode() + "',";
		}
		if(location.getSectionName()!=null && location.getSectionName()!="") {
			s = s + "@p_sectionName='" + location.getSectionName() + "',";
		}
		if(location.getCreatedBy()!=null && location.getCreatedBy()!="") {
			s = s + "@p_createdBy='" + location.getCreatedBy() + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		
		return s;
	}

	public static String saveRoom(LocationRoomModel location) {
		
		String s = "";
		
		if(location.getSectionId()!=null && location.getSectionId()!="") {
			s = s + "@p_sectionId='" + location.getSectionId() + "',";
		}
		if(location.getRoomId()!=null && location.getRoomId()!="") {
			s = s + "@p_roomId='" + location.getRoomId() + "',";
		}
		if(location.getRoomCode()!=null && location.getRoomCode()!="") {
			s = s + "@p_roomCode='" + location.getRoomCode() + "',";
		}
		if(location.getRoomName()!=null && location.getRoomName()!="") {
			s = s + "@p_roomName='" + location.getRoomName() + "',";
		}
		if(location.getRoomType()!=null && location.getRoomType()!="") {
			s = s + "@p_roomType='" + location.getRoomType() + "',";
		}
		if(location.getCreatedBy()!=null && location.getCreatedBy()!="") {
			s = s + "@p_createdBy='" + location.getCreatedBy() + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		
		return s;
		
	}

	public static String getSectionIdList(List<String> id) {

		String s = "";
		String section = "";
		
		if(id.size() > 0) {
			for(String m : id) {
				section = section + "\"" + m + "\",";
			}
			
			section = section.substring(0, section.length() - 1);
		}
		
		s = "(" + section + ")";
		
		s = "SET @p_sectionListSubQuery='" + s + "';";
		
		System.out.println(s);
		
		return s;
	}

	public static String getLocationIdList(List<DropDownModel> id) {
		
		String s = "";
		String a = "";
		String section = "";
		
		if(id.get(0).getName()!=null && id.get(0).getName()!="") {
			s = s + "@P_ModifiedBy='" + id.get(0).getName() + "',";
		}
		
		if(id.size() > 0) {
			for(DropDownModel m : id) {
				section = section + "\"" + m.getKey() + "\",";
			}
			
			section = section.substring(0, section.length() - 1);
		} else {
			s = s.substring(0, s.length() - 1);
		}
		
		a = "(" + section + ")";
		
		s = s + "@p_locationListSubQuery='" + a + "';";
		
		s = "SET " + s ;
		
		System.out.println(s);
		
		return s;
	}

}
