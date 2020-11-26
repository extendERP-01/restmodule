//package nirmalya.aatithya.restmodule.employee.dao;
//
//import java.security.SecureRandom;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//import javax.persistence.EntityManager;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Repository;
//
//import nirmalya.aatithya.restmodule.common.AuthenticationVerifyForMobileApi;
//import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
//import nirmalya.aatithya.restmodule.common.ServerDao;
//import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
//import nirmalya.aatithya.restmodule.employee.model.LoginDataModel;
//import nirmalya.aatithya.restmodule.employee.model.RestaurantDataModel;
//import nirmalya.aatithya.restmodule.employee.model.UserLoginApiModel;
//import nirmalya.aatithya.restmodule.kitchen.model.KitchenAssignStaffApiModel;
//
//@Repository
//public class UserLoginApiRestDao {
//	Logger logger = LoggerFactory.getLogger(UserLoginApiRestDao.class);
//
//	@Autowired
//	EntityManager em;
//	@Autowired
//	ServerDao serverDao;
//
//	@Autowired
//	PasswordEncoder passwordEncoder;
//
//	@Autowired
//	EnvironmentVaribles env;
//
//	@Autowired
//	AuthenticationVerifyForMobileApi verify;
//
//	/*
//	 * for validate mobile no
//	 */
//	public ResponseEntity<JsonResponse<Object>> verifyMobile(LoginDataModel loginDataModel) {
//
//		logger.info("Method in Dao: verifyMobile starts");
//		List<LoginDataModel> employementList = new ArrayList<LoginDataModel>();
//
//		Random random1 = new Random();
//		int otp = random1.nextInt(10000);
//		String value = "SET @p_mobNo='" + loginDataModel.getMobileNo() + "',@p_imie='" + loginDataModel.getImieNo()
//				+ "',@p_otp='" + otp + "';"; 
//		try {
//
//			@SuppressWarnings("unchecked")
//			List<Object[]> x = em.createNamedStoredProcedureQuery("loginRestApi")
//					.setParameter("actionType", "verifyMobile").setParameter("actionValue", value).getResultList();
//			if (!x.isEmpty()) {
//				for (Object[] m : x) {
//
//					LoginDataModel employement = new LoginDataModel(m[0], null, null, m[1]);
//					employementList.add(employement);
//
//				}
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		JsonResponse<Object> resp = new JsonResponse<Object>();
//		if (!employementList.isEmpty()) {
//
//			employementList.get(0).setPinAvailable(" ");
//			employementList.get(0).setMobileNo(employementList.get(0).getUserId());
//			employementList.get(0).setUserId("");
//			employementList.get(0).setOtp(otp);
//			employementList.get(0).setPin("");
//
//			resp.setBody(employementList.get(0));
//			resp.setCode("success");
//			resp.setMessage("Mobile number verify successfully");
//		} else {
//			resp.setCode("failed");
//			resp.setMessage("Mobile number invalid");
//			resp.setBody(new LoginDataModel());
//		}
//
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("MyResponseHeader", "MyValue");
//		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
//				HttpStatus.CREATED);
//
//		logger.info("Method in Dao: verifyMobile ends");
//
//		return response;
//	}
//
//	/*
//	 * for validate opt
//	 */
//	public ResponseEntity<JsonResponse<Object>> verifyOtp(LoginDataModel loginDataModel) {
//
//		logger.info("Method in Dao: verifyOtp starts");
//		List<LoginDataModel> employementList = new ArrayList<LoginDataModel>();
//		JsonResponse<Object> resp = new JsonResponse<Object>();
//		String value = "SET @p_mobNo='" + loginDataModel.getMobileNo() + "',@p_otp='" + loginDataModel.getOtp() + "';";
//
//		try {
//
//			@SuppressWarnings("unchecked")
//			List<Object[]> x = em.createNamedStoredProcedureQuery("loginRestApi")
//					.setParameter("actionType", "verifyOtp").setParameter("actionValue", value).getResultList();
//			if (!x.isEmpty()) {
//				for (Object[] m : x) {
//
//					LoginDataModel employement = new LoginDataModel(m[0], null, null, null);
//					employementList.add(employement);
//
//				}
//
//			} else {
//				resp.setCode("failed");
//				resp.setMessage("Invalid User Id.");
//				resp.setBody(new LoginDataModel());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		if (!employementList.isEmpty()) {
//			if (!employementList.get(0).getUserId().isEmpty()) {
//				resp.setBody(employementList.get(0));
//				resp.setCode("success");
//				resp.setMessage("Mobile number verify successfully");
//			} else {
//				resp.setCode("failed");
//				resp.setMessage("Invalid Otp.");
//				resp.setBody(new LoginDataModel());
//			}
//
//		} else {
//			resp.setCode("failed");
//			resp.setMessage("Invalid User Id.");
//			resp.setBody(new LoginDataModel());
//		}
//
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("MyResponseHeader", "MyValue");
//		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
//				HttpStatus.CREATED);
//
//		logger.info("Method in Dao: verifyOtp ends");
//
//		return response;
//	}
//
//	/*
//	 * for login through pin
//	 */
//	public ResponseEntity<JsonResponse<Object>> logIn(LoginDataModel loginDataModel) {
//
//		logger.info("Method in Dao: for  log in starts");
//		List<UserLoginApiModel> userLoginApiModelList = new ArrayList<UserLoginApiModel>();
//		JsonResponse<Object> resp = new JsonResponse<Object>();
//
//		SecureRandom random = new SecureRandom();
//		byte bytes[] = new byte[20];
//		random.nextBytes(bytes);
//		String authKeys = bytes.toString();
//
//		String userPin = loginDataModel.getPin();
//
//		String value = "SET @p_userId='" + loginDataModel.getUserId() + "',@p_pin='" + loginDataModel.getPin()
//				+ "',@p_authNo='" + authKeys + "',@p_imieNo='" + loginDataModel.getImieNo() + "';";
//		Object pin = null;
//		try {
//			@SuppressWarnings("unchecked")
//			List<Object[]> x = em.createNamedStoredProcedureQuery("loginRestApi").setParameter("actionType", "login")
//					.setParameter("actionValue", value).getResultList();
//
//			if (!x.isEmpty()) {
//				for (Object[] m : x) {
//
//					UserLoginApiModel loginData = new UserLoginApiModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
//							m[8], m[9], m[10]);
//					String image = loginData.getUserImage();
//					loginData.setUserImage(env.getMobileView() + image);
//					userLoginApiModelList.add(loginData);
//					pin = m[6];
//				}
//				if (!userLoginApiModelList.isEmpty()) {
//					int validId = userLoginApiModelList.get(0).getValidImie().intValue();
//					if (validId == 1) {
//						boolean data = passwordEncoder.matches(userPin, pin.toString());
//						if (data) {
//							userLoginApiModelList.get(0).setPin("");
//							resp.setBody(userLoginApiModelList.get(0));
//							resp.setCode("success");
//							resp.setMessage("Login successfully");
//						} else {
//							resp.setCode("Failed");
//							resp.setMessage("Incorrect Pin");
//							resp.setBody(new UserLoginApiModel());
//						}
//					} else {
//						resp.setCode("Failed");
//						resp.setMessage("Incorrect Imie No");
//						resp.setBody(new UserLoginApiModel());
//					}
//
//				} else {
//					resp.setCode("failed");
//					resp.setMessage("Invalid User Id");
//					resp.setBody(new UserLoginApiModel());
//				}
//
//			} else {
//				resp.setCode("failed");
//				resp.setMessage("Invalid User Id");
//				resp.setBody(new UserLoginApiModel());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("MyResponseHeader", "MyValue");
//		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
//				HttpStatus.CREATED);
//
//		logger.info("Method in Dao: for  log in ends");
//
//		return response;
//	}
//
//	/*
//	 * for restaurant list from employee id
//	 */
//	public ResponseEntity<JsonResponse<Object>> getRestaurant(String empId, String authKey, String loginId) {
//
//		logger.info("Method in Dao: getRestaurant starts");
//		List<RestaurantDataModel> restaurantDataModelList = new ArrayList<RestaurantDataModel>();
//
//		JsonResponse<Object> resp = new JsonResponse<Object>();
//
//		if (verify.authentication(authKey, loginId)) {
//			String value = "SET @p_empId='" + empId + "';";
//			@SuppressWarnings("unchecked")
//			List<Object[]> x = em.createNamedStoredProcedureQuery("loginRestApi")
//					.setParameter("actionType", "getRestaurant").setParameter("actionValue", value).getResultList();
//
//			if (!x.isEmpty()) {
//				for (Object[] m : x) {
//
//					RestaurantDataModel loginData = new RestaurantDataModel(m[0], m[1]);
//
//					restaurantDataModelList.add(loginData);
//
//				}
//			}
//
//			resp.setBody(restaurantDataModelList);
//			resp.setCode("success");
//		} else {
//			resp.setCode("Failed");
//			resp.setMessage("Authentication Faied");
//			resp.setBody(new RestaurantDataModel());
//		}
//
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("MyResponseHeader", "MyValue");
//		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
//				HttpStatus.CREATED);
//
//		logger.info("Method in Dao: getRestaurant ends");
//
//		return response;
//	}
//
//	/**
//	 * DAO - log out
//	 *
//	 */
//	public ResponseEntity<JsonResponse<Object>> logOut(String userId, String authKey, String loginId) {
//		logger.info("Method : logOut starts");
//
//		JsonResponse<Object> resp = new JsonResponse<Object>();
//
//		if (verify.authentication(authKey, loginId)) {
//			try {
//				String value = "SET @p_userId='" + userId + "';";
//				em.createNamedStoredProcedureQuery("loginRestApi").setParameter("actionType", "logOut")
//						.setParameter("actionValue", value).execute();
//
//				resp.setCode("success");
//			} catch (Exception e) {
//				try {
//					String[] err = serverDao.errorProcedureCall(e);
//					resp.setCode(err[0]);
//					resp.setMessage(err[1]);
//				} catch (Exception e1) {
//					e1.printStackTrace();
//				}
//				e.printStackTrace();
//				resp.setCode("failed");
//			}
//		} else {
//			resp.setBody(new ArrayList<KitchenAssignStaffApiModel>());
//			resp.setMessage("Authentication Failed.");
//			resp.setCode("Failed");
//		}
//
//		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
//				HttpStatus.CREATED);
//		logger.info("Method : logOut ends");
//
//		return response;
//	}
//
//}
