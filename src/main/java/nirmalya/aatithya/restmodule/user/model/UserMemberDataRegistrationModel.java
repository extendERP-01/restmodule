package nirmalya.aatithya.restmodule.user.model;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserMemberDataRegistrationModel {

	private String memId;
	
	private String depId;

	private String userType; 

	private String first_name_m;
	
	private String last_name_m;
	
	private String mobile_no_m;
	
	private String email_m;
	
	private String password_m;
	
	private String pin_m;
	
	private String country_m;
	
	private String state_m;
	
	private String district_m;
	
	private String zip_m;
	
	private String address_m;
	
	private String member_type_m;
	
	private String relation_m;
	
	private Double registration_m;
	
	private Double monthly_fee_m;
	
	private Date joiningdate_m;
	
//	private Date dateofbirth_m;
	
	private Date dateofbirth;

	private String payment_mode_m;
	
	private Boolean status_m;
	
	private String imei_m;
	
	private String first_;
	
	private String last_;
	
	private String mobile_;
	
	private String email_;
	
	private String password_;
	
	private String pin_;
	
	private String relation_;
	
	private String status_;
	
	private String imei_;
	
	private Integer totaldep;
	
	private Integer agelimit;
	
	

	public UserMemberDataRegistrationModel() {
		super();
	}
	
	public UserMemberDataRegistrationModel(Object memId, Object depId,  Object first_name_m, Object last_name_m,
			Object mobile_no_m,Object email_m,Object password_m,Object pin_m, Object country_m,
			Object state_m,Object district_m,Object zip_m,Object address_m,Object member_type_m,
			Object relation_m, Object registration_m,Object monthly_fee_m,Object joiningdate_m, 
			Object payment_mode_m,Object dateofbirth,Object status_m ,Object totaldep,Object agelimit,Object userType) {
		super();
		try {
			this.memId = (String) memId;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		
		try {
			this.depId = (String) depId;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		try {
			this.first_name_m = (String) first_name_m;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		
		try {
			this.last_name_m = (String) last_name_m;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		
		try {
			this.mobile_no_m = (String) mobile_no_m;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		
		try {
			this.email_m = (String) email_m;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		
		try {
			this.password_m = (String) password_m;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		
		try {
			this.pin_m = (String) pin_m;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		try {
			this.country_m = (String) country_m;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}

		try {
			this.state_m = (String) state_m;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		

		try {
			this.district_m = (String) district_m;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		
		
		try {
			this.zip_m = (String) zip_m;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		
		

		try {
			this.address_m = (String) address_m;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		
		
		
		try {
			this.member_type_m = (String) member_type_m;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		
		

		try {
			this.relation_m = (String) relation_m;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		
		
		
		
		try {
			this.registration_m = (Double) registration_m;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		
		try {
			this.monthly_fee_m = (Double) monthly_fee_m;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		
		try {
			this.joiningdate_m = (Date) joiningdate_m;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		

		try {
			this.payment_mode_m = (String) payment_mode_m;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		

		try {
			this.dateofbirth = (Date) dateofbirth;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}

		try {
			this.status_m = (Boolean) status_m;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		
		try {
			this.totaldep = (Integer) totaldep;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		
		try {
			this.agelimit = (Integer) agelimit;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		
		try {
			this.userType = (String) userType;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		
	


	}
	
	
	
	
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	
	public Integer getAgelimit() {
		return agelimit;
	}
	
	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}




	public void setAgelimit(Integer agelimit) {
		this.agelimit = agelimit;
	}

	public Integer getTotaldep() {
		return totaldep;
	}

	public void setTotaldep(Integer totaldep) {
		this.totaldep = totaldep;
	}

	public String getMemId() {
		return memId;
	}


	public void setMemId(String memId) {
		this.memId = memId;
	}
	 
	
	public String getFirst_name_m() {
		return first_name_m;
	}

	public void setFirst_name_m(String first_name_m) {
		this.first_name_m = first_name_m;
	}

	public String getLast_name_m() {
		return last_name_m;
	}

	public void setLast_name_m(String last_name_m) {
		this.last_name_m = last_name_m;
	}

	public String getMobile_no_m() {
		return mobile_no_m;
	}

	public void setMobile_no_m(String mobile_no_m) {
		this.mobile_no_m = mobile_no_m;
	}

	public String getEmail_m() {
		return email_m;
	}

	public void setEmail_m(String email_m) {
		this.email_m = email_m;
	}

	public String getPassword_m() {
		return password_m;
	}

	public void setPassword_m(String password_m) {
		this.password_m = password_m;
	}

	public String getPin_m() {
		return pin_m;
	}

	public void setPin_m(String pin_m) {
		this.pin_m = pin_m;
	}

	public String getCountry_m() {
		return country_m;
	}

	public void setCountry_m(String country_m) {
		this.country_m = country_m;
	}

	public String getState_m() {
		return state_m;
	}

	public void setState_m(String state_m) {
		this.state_m = state_m;
	}

	public String getDistrict_m() {
		return district_m;
	}

	public void setDistrict_m(String district_m) {
		this.district_m = district_m;
	}

	public String getZip_m() {
		return zip_m;
	}

	public void setZip_m(String zip_m) {
		this.zip_m = zip_m;
	}

	public String getAddress_m() {
		return address_m;
	}

	public void setAddress_m(String address_m) {
		this.address_m = address_m;
	}

	public String getMember_type_m() {
		return member_type_m;
	}

	public void setMember_type_m(String member_type_m) {
		this.member_type_m = member_type_m;
	}

	public String getRelation_m() {
		return relation_m;
	}

	public void setRelation_m(String relation_m) {
		this.relation_m = relation_m;
	}

	public Double getRegistration_m() {
		return registration_m;
	}

	public void setRegistration_m(Double registration_m) {
		this.registration_m = registration_m;
	}

	public Double getMonthly_fee_m() {
		return monthly_fee_m;
	}

	public void setMonthly_fee_m(Double monthly_fee_m) {
		this.monthly_fee_m = monthly_fee_m;
	}

	public Date getJoiningdate_m() {
		return joiningdate_m;
	}

	public void setJoiningdate_m(Date joiningdate_m) {
		this.joiningdate_m = joiningdate_m;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getPayment_mode_m() {
		return payment_mode_m;
	}

	public void setPayment_mode_m(String payment_mode_m) {
		this.payment_mode_m = payment_mode_m;
	}

	public Boolean getStatus_m() {
		return status_m;
	}

	public void setStatus_m(Boolean status_m) {
		this.status_m = status_m;
	}

	public String getImei_m() {
		return imei_m;
	}

	public void setImei_m(String imei_m) {
		this.imei_m = imei_m;
	}

	public String getFirst_() {
		return first_;
	}

	public void setFirst_(String first_) {
		this.first_ = first_;
	}

	public String getLast_() {
		return last_;
	}

	public void setLast_(String last_) {
		this.last_ = last_;
	}

	public String getMobile_() {
		return mobile_;
	}

	public void setMobile_(String mobile_) {
		this.mobile_ = mobile_;
	}

	public String getEmail_() {
		return email_;
	}

	public void setEmail_(String email_) {
		this.email_ = email_;
	}

	public String getPassword_() {
		return password_;
	}

	public void setPassword_(String password_) {
		this.password_ = password_;
	}

	public String getPin_() {
		return pin_;
	}

	public void setPin_(String pin_) {
		this.pin_ = pin_;
	}

	public String getRelation_() {
		return relation_;
	}

	public void setRelation_(String relation_) {
		this.relation_ = relation_;
	}

	public String getStatus_() {
		return status_;
	}

	public void setStatus_(String status_) {
		this.status_ = status_;
	}

	public String getImei_() {
		return imei_;
	}

	public void setImei_(String imei_) {
		this.imei_ = imei_;
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
