/**
 * Repository for user handling related call
**/
package nirmalya.aatithya.restmodule.user.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.GenerateUserParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.user.model.User;


/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class UserLoginDao {
	
	Logger logger = LoggerFactory.getLogger(UserLoginDao.class);

	@Autowired
	EntityManager em;
	
	@Autowired
	ServerDao serverDao;
	
	
	/**
	 * function to return user by name 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<User>> getUserByUsername(String username) {
		logger.info("Method : getUserByUsername starts");
		
		JsonResponse<User> jsonResponse = new JsonResponse<User>();
		jsonResponse.setCode("");
		jsonResponse.setMessage("");
		
		List<User> userArray = new ArrayList<User>();
		List<String> userRole = new ArrayList<String>();
		
		try {
			
			String value = "SET @p_userName='"+username +"';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("userRoutines")
				.setParameter("actionType", "getByName")
				.setParameter("actionValue", value)
				.getResultList();
			
			
			for(Object[] m :x) {
				String role = (String)m[6];
				
				if(role != null && role.length() >0 ){
					String[] roles = role.split(",");
					userRole = Arrays.asList(roles);
				}
				
				User user = new User(m[0],m[1],m[2],m[3],m[4],null,null,null,null,null,null,m[5],null,null,userRole,m[7],m[8]);
				userArray.add(user);
			}
			
			if(userArray.size() >0) {
				jsonResponse.setBody(userArray.get(0));
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
		ResponseEntity<JsonResponse<User>> response = new ResponseEntity<JsonResponse<User>>(jsonResponse,HttpStatus.OK);
		logger.info("Method : getUserByUsername ends");
		
		return response;
		
	}
	
	/**
	 * function to register user 
	 *
	 */
	public ResponseEntity<JsonResponse<String>> registerUser(User user) {
		logger.info("Method : registerUser starts");
		
		JsonResponse<String> jsonResponse = new JsonResponse<String>();
		jsonResponse.setCode("");
		jsonResponse.setMessage("");
		
		
		try {
			String value = GenerateUserParameter.getUserParam(user);
			
			em.createNamedStoredProcedureQuery("userRoutines")
				.setParameter("actionType", "getByName")
				.setParameter("actionValue", value)
				.execute();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				String[] err = serverDao.errorProcedureCall(e);
				
				jsonResponse.setCode(err[0]);
				jsonResponse.setMessage(err[1]);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			
		
		ResponseEntity<JsonResponse<String>> response = new ResponseEntity<JsonResponse<String>>(jsonResponse,HttpStatus.OK);
		logger.info("Method : registerUser ends");
		
		return response;
		
	}
	
}
