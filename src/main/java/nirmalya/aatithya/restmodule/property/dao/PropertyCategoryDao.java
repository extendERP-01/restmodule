/**
 * Defines Property category DAO
 *
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

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GeneratePropertyCategoryParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.ServerValidation;
import nirmalya.aatithya.restmodule.property.model.PropertyCategoryModel;

/**
 * @author Nirmalya Labs
 *
 */

@Repository
public class PropertyCategoryDao {
	Logger logger = LoggerFactory.getLogger(PropertyCategoryDao.class);
	@Autowired
	EntityManager em;

	/**
	 * DAO Function to add property category and edit
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addproperty(PropertyCategoryModel form) {
		logger.info("Method : addproperty starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (form.getCategoryName() == null || form.getCategoryName() == "") {
			resp.setMessage("category Name required");

			validity = false;
		} else if (form.getCategoryDescription() == null || form.getCategoryDescription() == "") {
			resp.setMessage("description required");
			validity = false;
		} else if (form.getCategoryActive() == null) {
			resp.setMessage("status required");
			validity = false;
		}

		if (validity)
			try {
				String values = GeneratePropertyCategoryParameter.getAddPropertyCategoryParam(form);

				if (form.getPropertyCatId() != null && form.getPropertyCatId() != "") {
					em.createNamedStoredProcedureQuery("propertyCategory").setParameter("actionType", "modifyCategory")
							.setParameter("actionValue", values).execute();
				} else {

					em.createNamedStoredProcedureQuery("propertyCategory")
							.setParameter("actionType", "addPropertyCategory").setParameter("actionValue", values)
							.execute();
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
				try {
					String[] err = ServerValidation.geterror(e);

					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addproperty end");
		return response;
	}

	/**
	 * DAO Function to view property category
	 *
	 */
	public ResponseEntity<JsonResponse<List<PropertyCategoryModel>>> getAllCategory(DataTableRequest request) {
		logger.info("Method : getAllCategory starts");
		List<PropertyCategoryModel> form = new ArrayList<PropertyCategoryModel>();

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("propertyCategory")
					.setParameter("actionType", "viewAllcategory").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				PropertyCategoryModel category = new PropertyCategoryModel(m[0], m[1], m[2], m[3]);
				form.add(category);
			}

			if (x.get(0).length > 4) {
				BigInteger t = (BigInteger) x.get(0)[4];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonResponse<List<PropertyCategoryModel>> resp = new JsonResponse<List<PropertyCategoryModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<PropertyCategoryModel>>> response = new ResponseEntity<JsonResponse<List<PropertyCategoryModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getAllCategory end");
		return response;
	}

	/**
	 * DAO Function to delete property category
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteCategory(String id) {
		logger.info("Method : deleteCategory starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_propertyCatId='" + id + "';";
			em.createNamedStoredProcedureQuery("propertyCategory").setParameter("actionType", "deleteCategory")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			String[] err = ServerValidation.geterror(e);

			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		;
		logger.info("Method : deleteCategory end");
		return response;
	}

	/**
	 * DAO Function to edit category
	 *
	 */
	public ResponseEntity<JsonResponse<PropertyCategoryModel>> getCategoryById(String id) {
		logger.info("Method : getCategoryById starts");

		List<PropertyCategoryModel> form = new ArrayList<PropertyCategoryModel>();

		try {
			String value = "SET @p_propertyCatId='" + id + "';";

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("propertyCategory")
					.setParameter("actionType", "editCategory").setParameter("actionValue", value).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					PropertyCategoryModel category = new PropertyCategoryModel(m[0], m[1], m[2], m[3]);
					form.add(category);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<PropertyCategoryModel> resp = new JsonResponse<PropertyCategoryModel>();
		resp.setBody(form.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<PropertyCategoryModel>> response = new ResponseEntity<JsonResponse<PropertyCategoryModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getCategoryById end");
		return response;

	}
}
