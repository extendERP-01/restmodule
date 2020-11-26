/**
 * 
 */
package nirmalya.aatithya.restmodule.user.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Nirmalya Labs
 *
 */
public class UserModel {

	private String user;
	private String userName;
	private String userType;
	private String userPassword;
	private String userPINno;
	private String userMobile;
	private String userEmail;
	private String userIMEI;
	private String userAddress;
	private String userState;
	private String userCountry;
	private String userDist;
	private String userPin;
	private Boolean userStatus;
	private String statusName;
	private String action;

	private String userRole;
	private String userRoleName;

	private String userStateName;
	private String userDistName;
	private String userLname;
	private String fullName;
	private String createdBy;

	/**
	 * 
	 */
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * CONSTRUCTOR CALL
	 *
	 */
	public UserModel(Object user, Object userName, Object userMobile, Object userEmail, Object userState,
			Object userCountry, Object userDist, Object userPin, Object userStatus, Object userType,
			Object userPassword, Object userAddress, Object userRole, Object userStateName, Object userDistName,
			Object userRoleName, Object userIMEI, Object userPINno, Object userLname, Object fullName) {
		super();

		try {
			this.user = (String) user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.userName = (String) userName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.userType = (String) userType;
		} catch (Exception e) { //
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.userPassword = (String) userPassword;
		} catch (Exception e) { //
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.userMobile = (String) userMobile;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.userEmail = (String) userEmail;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.userAddress = (String) userAddress;
		} catch (Exception e) { //
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.userState = (String) userState;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.userCountry = (String) userCountry;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.userDist = (String) userDist;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.userPin = (String) userPin;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.userStatus = (Boolean) userStatus;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.userRole = (String) userRole;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.userRoleName = (String) userRoleName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.userStateName = (String) userStateName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.userDistName = (String) userDistName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.userIMEI = (String) userIMEI;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.userPINno = (String) userPINno;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.userLname = (String) userLname;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.fullName = (String) fullName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * GETTER & SETTER
	 *
	 */

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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPINno() {
		return userPINno;
	}

	public void setUserPINno(String userPINno) {
		this.userPINno = userPINno;
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

	public String getUserIMEI() {
		return userIMEI;
	}

	public void setUserIMEI(String userIMEI) {
		this.userIMEI = userIMEI;
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

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getUserRole() {
		return userRole;
	}

	public String getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	public String getUserStateName() {
		return userStateName;
	}

	public void setUserStateName(String userStateName) {
		this.userStateName = userStateName;
	}

	public String getUserDistName() {
		return userDistName;
	}

	public void setUserDistName(String userDistName) {
		this.userDistName = userDistName;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserLname() {
		return userLname;
	}

	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
