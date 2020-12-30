/**
 * Repository for error handling related call
**/
package nirmalya.aatithya.restmodule.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class ServerDao {

	Logger logger = LoggerFactory.getLogger(ServerDao.class);

	@Autowired
	EntityManager em;

	public Object callProcedure(String values) {

		Object handle = null;

		try {
			handle = em.createNamedStoredProcedureQuery("errorHandling").setParameter("actionType", "entry")
					.setParameter("actionValue", values).getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return handle;
	}

	/**
	 * call to get error / save error if not in database
	 *
	 */
	@SuppressWarnings("unchecked")
	public String[] errorProcedureCall(Throwable error) {
		logger.info("Method : errorProcedureCall");

		String[] res = { "", "" };

		List<ErrorHandling> errorHandling = new ArrayList<ErrorHandling>();

		try {

			Throwable xx = error;

			while (xx.getCause() != null) {
				xx = xx.getCause();
			}

			if (xx instanceof SQLException) {

				Integer code = ((SQLException) xx).getErrorCode();
				String message = ((SQLException) xx).getMessage();

				String values = GenerateParameter.getSqlErrorParam(Integer.parseInt(message), "", "", "MYSQL");

				try {

					errorHandling = em.createNamedStoredProcedureQuery("errorHandling")
							.setParameter("actionType", "dbServer").setParameter("actionValue", values).getResultList();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (errorHandling.size() > 0) {

					String h = errorHandling.get(0).getNlErrorMessage();
					h = h.replace("_UNIQUE", "");
					h = h.replace("key", "");

					res[1] = h;
					res[0] = errorHandling.get(0).getNlErrorCode();

				} else {
					message = message.replace("_UNIQUE", "");
					message = message.replace("key", "");
					res[1] = code.toString();
					res[0] = code.toString();
				}

			} else {
				String message = xx.getMessage();

				String values = GenerateParameter.getSqlErrorParam(0, "", message, "JAVA");

				errorHandling = em.createNamedStoredProcedureQuery("errorHandling")
						.setParameter("actionType", "javaServer").setParameter("actionValue", values).getResultList();

				res[1] = message;

			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		logger.error("Code : {}", res[0]);
		logger.error("Message : {}", res[1]);

		return res;
	}

}
