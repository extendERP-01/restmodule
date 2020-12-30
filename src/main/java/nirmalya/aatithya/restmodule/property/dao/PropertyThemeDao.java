/*
 * Dao for theme
 */

package nirmalya.aatithya.restmodule.property.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GeneratePropertyThameParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.model.PropertyThemeModel;

/*
 * @author Nirmalya Labs
 */

@Repository
public class PropertyThemeDao {

	Logger logger = LoggerFactory.getLogger(PropertyThemeDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for all theme details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PropertyThemeModel>>> getThemeDetails(DataTableRequest request) {

		logger.info("Method in Dao: getThemeDetails starts");

		List<PropertyThemeModel> theme = new ArrayList<PropertyThemeModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("propertyTheme")
					.setParameter("actionType", "viewTheme").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					PropertyThemeModel thame = new PropertyThemeModel(m[0], m[1], m[2], m[3], m[4], m[5]);
					theme.add(thame);

				}

				if (x.get(0).length > 6) {
					BigInteger t = (BigInteger) x.get(0)[6];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<PropertyThemeModel>> resp = new JsonResponse<List<PropertyThemeModel>>();
		resp.setBody(theme);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<PropertyThemeModel>>> response = new ResponseEntity<JsonResponse<List<PropertyThemeModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getThemeDetails ends");

		return response;
	}

	/*
	 * for add new theme
	 */
	public ResponseEntity<JsonResponse<Object>> addTheme(PropertyThemeModel theme) {

		logger.info("Method in Dao: addTheme starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (theme.getThmName() == null || theme.getThmName() == "") {
			resp.setMessage("Theme Name required");
			validity = false;
		} else if (theme.getPropertyCategory() == null || theme.getPropertyCategory() == "") {
			resp.setMessage("Theme category required");
			validity = false;
		} else if (theme.getThmDescription() == null || theme.getThmDescription() == "") {
			resp.setMessage("Theme description required");
			validity = false;
		} else if (theme.getThmActive() == null) {
			resp.setMessage("Theme active required");
			validity = false;
		}

		if (validity)
			try {
				String values = GeneratePropertyThameParameter.getAddThemeParam(theme);
				if (theme.getTheme() != "") {
					em.createNamedStoredProcedureQuery("propertyTheme").setParameter("actionType", "modifyTheme")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("propertyTheme").setParameter("actionType", "addTheme")
							.setParameter("actionValue", values).execute();
				}
			} catch (Exception e) {
				e.printStackTrace();
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: addTheme ends");

		return response;
	}

	/*
	 * for edit theme
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<PropertyThemeModel>> getThemeById(String id) {

		logger.info("Method in Dao: getThemeById ends");

		List<PropertyThemeModel> pTheme = new ArrayList<PropertyThemeModel>();

		try {

			String value = "SET @p_themeId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("propertyTheme")
					.setParameter("actionType", "viewEditTheme").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				PropertyThemeModel theme = new PropertyThemeModel(m[0], m[1], m[2], m[3], m[4], m[5]);

				pTheme.add(theme);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<PropertyThemeModel> resp = new JsonResponse<PropertyThemeModel>();
		resp.setBody(pTheme.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<PropertyThemeModel>> response = new ResponseEntity<JsonResponse<PropertyThemeModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getThemeById ends");

		return response;
	}

	/*
	 * for delete theme
	 */
	public ResponseEntity<JsonResponse<Object>> deleteThemeById(String id, String createdBy) {

		logger.info("Method in Dao: deleteThemeById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_themeId='" + id + "',@P_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("propertyTheme").setParameter("actionType", "deleteTheme")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
			String[] err = serverDao.errorProcedureCall(e);
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in Dao: deleteThemeById ends");

		return response;
	}

}
