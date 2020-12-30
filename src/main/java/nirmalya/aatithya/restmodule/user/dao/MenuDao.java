/**
 * Repository for user menu related call
**/
package nirmalya.aatithya.restmodule.user.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.AllocateItemsToRackModel;
import nirmalya.aatithya.restmodule.sales.model.UserRolesAndModuleIdModel;
import nirmalya.aatithya.restmodule.user.model.Menu;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class MenuDao {

	Logger logger = LoggerFactory.getLogger(UserDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<Menu>>> getUserMenu(List<String> role) {
		logger.info("Method : getUserMenu starts");

		JsonResponse<List<Menu>> jsonResponse = new JsonResponse<List<Menu>>();
		jsonResponse.setCode("");
		jsonResponse.setMessage("");

		List<Menu> mList = new ArrayList<Menu>();

		try {

			String value = "";

			for (String s : role) {
				value = value + "'" + s + "',";
			}

			if (value.length() > 0) {
				value = value.substring(0, value.length() - 1);

				List<Object[]> x = em.createNamedStoredProcedureQuery("userRoutines")
						.setParameter("actionType", "getUserMenu").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {

					Menu menu = new Menu(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7] ,m[8]);
					mList.add(menu);
				}

				jsonResponse.setBody(mList);

			} else {
				logger.warn("Method : getUserMenu : No role assigned to user.");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<List<Menu>>> response = new ResponseEntity<JsonResponse<List<Menu>>>(jsonResponse,
				HttpStatus.OK);
		logger.info("Method : getUserMenu ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<Menu>>> getFunctionList(UserRolesAndModuleIdModel userModel) {
		logger.info("Method : getFunctionList starts");

		JsonResponse<List<Menu>> jsonResponse = new JsonResponse<List<Menu>>();
		jsonResponse.setCode("");
		jsonResponse.setMessage("");

		List<Menu> mList = new ArrayList<Menu>();

		try {

			String value = "";
			String values = "";
		 
			
			for (String m : userModel.getUserRoleList()) {
				value = value +"\"" +  m  + "\",";
			}
			

			if (value.length() > 0) {
				value = value.substring(0, value.length() - 1);
				values = "SET @p_moduleId='" + userModel.getModuleId() + "',@p_userRoles='" + value + "';";
				System.out.println("values " + values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("userRoutines")
						.setParameter("actionType", "getFunctionList").setParameter("actionValue", values).getResultList();

				for (Object[] m : x) {

					Menu menu = new Menu(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7] ,null);
					mList.add(menu);
				}
System.out.println(mList);
				jsonResponse.setBody(mList);

			} else {
				logger.warn("Method : getUserMenu : No role assigned to user.");
			}
			jsonResponse.setBody(mList);

		} catch (Exception e) {
			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<List<Menu>>> response = new ResponseEntity<JsonResponse<List<Menu>>>(jsonResponse,
				HttpStatus.OK);
		logger.info("Method : getFunctionList ends");

		return response;
	}

}
