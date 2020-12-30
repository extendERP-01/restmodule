package nirmalya.aatithya.restmodule.common;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.employee.model.LoginDataModel;

@Repository
public class AuthenticationVerifyForMobileApi {
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	 
	@Autowired
	EnvironmentVaribles env;
	
	/*
	 * for validation of authKey 
	 */

	public boolean authentication(String authKey, String loginId) {
		List<LoginDataModel> employementListValid = new ArrayList<LoginDataModel>();
		String value = "SET @p_authNo='" + authKey + "';";

		try {

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("loginRestApi")
					.setParameter("actionType", "authVerification").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					LoginDataModel employement = new LoginDataModel(m[0], m[1], null, null);
					employementListValid.add(employement);

				}
				if (employementListValid.get(0).getUserId().equals(loginId)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
	
}
