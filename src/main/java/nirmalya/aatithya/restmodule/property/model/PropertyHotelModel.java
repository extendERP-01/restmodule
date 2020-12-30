/*
 *  model for  property hotel in rest
 */
package nirmalya.aatithya.restmodule.property.model;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PropertyHotelModel {
	private String hotelId;
	private String hotelName;
	private String hotelAdress;
	private String district;
	private String state;
	private String hotelCountry;
	private String hotelPin;
	private String hotelCity;
	private String hotelPhone;
	private String hotelEmail;
	private String hotelWebsite;
	private String hotelTin;
	private String hotelRegdNo;
	private String hotelLogo;
	private String hotelGrade;
	private Boolean hotelStatus;
	private Date hotelCreatedOn;
	private String hotelCreatedBy;
	private Date hotelUpdatedOn;

	public PropertyHotelModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertyHotelModel(Object hotelId, Object hotelName, Object hotelAdress, Object district, Object state,
			Object hotelCountry, Object hotelPin,Object hotelCity,Object hotelPhone, Object hotelEmail, Object hotelWebsite, Object hotelTin,
			Object hotelRegdNo, Object hotelLogo, Object hotelGrade, Object hotelStatus, Object hotelCreatedOn,
			Object hotelUpdatedOn) {
		super();

		try {
			this.hotelId = (String) hotelId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.hotelName = (String) hotelName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.hotelAdress = (String) hotelAdress;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.district = (String) district;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.state = (String) state;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.hotelCountry = (String) hotelCountry;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.hotelPin = (String) hotelPin;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.hotelCity = (String) hotelCity;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.hotelPhone = (String) hotelPhone;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.hotelEmail = (String) hotelEmail;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.hotelWebsite = (String) hotelWebsite;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.hotelTin = (String) hotelTin;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.hotelRegdNo = (String) hotelRegdNo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.hotelLogo = (String) hotelLogo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.hotelGrade = (String) hotelGrade;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.hotelStatus = (Boolean) hotelStatus;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.hotelCreatedOn = (Date) hotelCreatedOn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.hotelUpdatedOn = (Date) hotelUpdatedOn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelAdress() {
		return hotelAdress;
	}

	public void setHotelAdress(String hotelAdress) {
		this.hotelAdress = hotelAdress;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getHotelCountry() {
		return hotelCountry;
	}

	public void setHotelCountry(String hotelCountry) {
		this.hotelCountry = hotelCountry;
	}

	public String getHotelPin() {
		return hotelPin;
	}

	public void setHotelPin(String hotelPin) {
		this.hotelPin = hotelPin;
	}

	public String getHotelCity() {
		return hotelCity;
	}

	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}

	public String getHotelPhone() {
		return hotelPhone;
	}

	public void setHotelPhone(String hotelPhone) {
		this.hotelPhone = hotelPhone;
	}

	public String getHotelEmail() {
		return hotelEmail;
	}

	public void setHotelEmail(String hotelEmail) {
		this.hotelEmail = hotelEmail;
	}

	public String getHotelWebsite() {
		return hotelWebsite;
	}

	public void setHotelWebsite(String hotelWebsite) {
		this.hotelWebsite = hotelWebsite;
	}

	public String getHotelTin() {
		return hotelTin;
	}

	public void setHotelTin(String hotelTin) {
		this.hotelTin = hotelTin;
	}

	public String getHotelRegdNo() {
		return hotelRegdNo;
	}

	public void setHotelRegdNo(String hotelRegdNo) {
		this.hotelRegdNo = hotelRegdNo;
	}

	public String getHotelLogo() {
		return hotelLogo;
	}

	public void setHotelLogo(String hotelLogo) {
		this.hotelLogo = hotelLogo;
	}

	public String getHotelGrade() {
		return hotelGrade;
	}

	public void setHotelGrade(String hotelGrade) {
		this.hotelGrade = hotelGrade;
	}

	public Boolean getHotelStatus() {
		return hotelStatus;
	}

	public void setHotelStatus(Boolean hotelStatus) {
		this.hotelStatus = hotelStatus;
	}

	public Date getHotelCreatedOn() {
		return hotelCreatedOn;
	}

	public void setHotelCreatedOn(Date hotelCreatedOn) {
		this.hotelCreatedOn = hotelCreatedOn;
	}

	public Date getHotelUpdatedOn() {
		return hotelUpdatedOn;
	}

	public void setHotelUpdatedOn(Date hotelUpdatedOn) {
		this.hotelUpdatedOn = hotelUpdatedOn;
	}

	public String getHotelCreatedBy() {
		return hotelCreatedBy;
	}

	public void setHotelCreatedBy(String hotelCreatedBy) {
		this.hotelCreatedBy = hotelCreatedBy;
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
