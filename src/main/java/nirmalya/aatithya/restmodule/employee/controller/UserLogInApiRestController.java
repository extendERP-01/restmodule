//package nirmalya.aatithya.restmodule.employee.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
//import nirmalya.aatithya.restmodule.employee.dao.UserLoginApiRestDao;
//import nirmalya.aatithya.restmodule.employee.model.LoginDataModel;
//
//@RestController
//@RequestMapping(value = "api/")
//@Api(value = "For User Login", description = "All the operation in LogIn And LogOut")
//public class UserLogInApiRestController {
//
//	Logger logger = LoggerFactory.getLogger(HrmsEmployeeLanguageRestController.class);
//
//	@Autowired
//	UserLoginApiRestDao userLoginApiRestDao;
//
//	/*
//	 * for verify Mobile Number
//	 */
//	@ApiOperation(value = "For Verify Mobile Number")
//	@RequestMapping(value = "verifyMobile", method = { RequestMethod.POST }, consumes = { "application/*" })
//	public ResponseEntity<JsonResponse<Object>> verifyMobile(LoginDataModel loginDataModel) {
//		logger.info("Method in rest: verifyMobile starts");
//
//		logger.info("Method in rest: verifyMobile ends");
//
//		return userLoginApiRestDao.verifyMobile(loginDataModel);
//	}
//
//	/*
//	 * for verify otp
//	 */
//	@ApiOperation(value = "For verify otp")
//	@RequestMapping(value = "verifyOtp", method = { RequestMethod.POST }, consumes = { "application/*" })
//	public ResponseEntity<JsonResponse<Object>> verifyOtp(LoginDataModel loginDataModel) {
//		logger.info("Method in rest: verifyOtp starts");
//
//		logger.info("Method in rest: verifyOtp ends");
//
//		return userLoginApiRestDao.verifyOtp(loginDataModel);
//	}
//
//	/*
//	 * for verify Mobile Number
//	 */
//	@ApiOperation(value = "For Login ")
//	@RequestMapping(value = "login", method = { RequestMethod.POST }, consumes = { "application/*" })
//	public ResponseEntity<JsonResponse<Object>> logIn(LoginDataModel loginDataModel) {
//		logger.info("Method in rest: logIn starts");
//
//		logger.info("Method in rest: logIn ends");
//
//		return userLoginApiRestDao.logIn(loginDataModel);
//	}
//
//	/*
//	 * for verify Mobile Number
//	 */
//	@ApiOperation(value = "For Restaurants  ")
//	@RequestMapping(value = "getRestaurant", method = { RequestMethod.GET })
//	public ResponseEntity<JsonResponse<Object>> getRestaurant(@RequestHeader(value = "authKey") String authKey,
//			@RequestHeader(value = "loginId") String loginId, @RequestParam String empId) {
//		logger.info("Method in rest: getRestaurant starts"); 
//		logger.info("Method in rest: getRestaurant ends");
//
//		return userLoginApiRestDao.getRestaurant(empId, authKey, loginId);
//	}
//
//	@ApiOperation(value = "For log Out")
//	@RequestMapping(value = "logOut", method = { RequestMethod.GET })
//	public ResponseEntity<JsonResponse<Object>> logOut(@RequestHeader(value = "authKey") String authKey,
//			@RequestHeader(value = "loginId") String loginId, @RequestParam("userId") String userId) {
//		logger.info("Method : logOut for rest controller starts");
//
//		logger.info("Method : logOut for rest controller ends");
//		return userLoginApiRestDao.logOut(userId, authKey, loginId);
//	}
//
//}
