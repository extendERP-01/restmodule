package nirmalya.aatithya.restmodule.user.model;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Nirmalya Labs
 *
 */
public class User {

	private String user;
	private String userName;
	private String userPassword;
	private String userMobile;
	private String userEmail;
	private String userParent;
	private String userAddress;
	private String userState;
	private String userCountry;
	private String userDist;
	private String userPin;
	private Boolean userStatus;
	private Date userCreatedOn;
	private Date userUpdatedOn;
	
	
	private List<String> roles;
	private String roleDashboard;
	private String userType;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public User(Object user, Object userName, Object userPassword, Object userMobile, Object userEmail,
			Object userParent, Object userAddress, Object userState, Object userCountry, Object userDist,
			Object userPin, Object userStatus, Object userCreatedOn, Object userUpdatedOn, List<String> roles,Object roleDashboard,
			Object userType) {
		super();
		this.user = (String)user;
		this.userName = (String)userName;
		this.userPassword = (String)userPassword;
		this.userMobile = (String)userMobile;
		this.userEmail = (String)userEmail;
		this.userParent = (String)userParent;
		this.userAddress = (String)userAddress;
		this.userState = (String)userState;
		this.userCountry = (String)userCountry;
		this.userDist = (String)userDist;
		this.userPin = (String)userPin;
		this.userStatus = (Boolean)userStatus;
		this.userCreatedOn = (Date)userCreatedOn;
		this.userUpdatedOn = (Date)userUpdatedOn;
		this.roles = roles;
		this.roleDashboard = (String)roleDashboard;
		this.userType = (String)userType;
	}

	


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getUserMobile() {
		return userMobile;
	}


	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUserParent() {
		return userParent;
	}


	public void setUserParent(String userParent) {
		this.userParent = userParent;
	}


	public String getUserAddress() {
		return userAddress;
	}


	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}


	public String getUserState() {
		return userState;
	}


	public void setUserState(String userState) {
		this.userState = userState;
	}


	public String getUserCountry() {
		return userCountry;
	}


	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}


	public String getUserDist() {
		return userDist;
	}


	public void setUserDist(String userDist) {
		this.userDist = userDist;
	}


	public String getUserPin() {
		return userPin;
	}


	public void setUserPin(String userPin) {
		this.userPin = userPin;
	}


	public Boolean getUserStatus() {
		return userStatus;
	}


	public void setUserStatus(Boolean userStatus) {
		this.userStatus = userStatus;
	}


	public Date getUserCreatedOn() {
		return userCreatedOn;
	}


	public void setUserCreatedOn(Date userCreatedOn) {
		this.userCreatedOn = userCreatedOn;
	}


	public Date getUserUpdatedOn() {
		return userUpdatedOn;
	}


	public void setUserUpdatedOn(Date userUpdatedOn) {
		this.userUpdatedOn = userUpdatedOn;
	}


	public List<String> getRoles() {
		return roles;
	}


	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	public String getRoleDashboard() {
		return roleDashboard;
	}

	public void setRoleDashboard(String roleDashboard) {
		this.roleDashboard = roleDashboard;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	/**
	 * Overrides toString method for converting class to string and back 
	**/
	@Override
	public String toString() {
		ObjectMapper  mapperObj=new ObjectMapper();
		String jsonStr;
		try{
			jsonStr=mapperObj.writeValueAsString(this);
		}catch(IOException ex){
			
			jsonStr=ex.toString();
		}
		return jsonStr;
	}
	
}
