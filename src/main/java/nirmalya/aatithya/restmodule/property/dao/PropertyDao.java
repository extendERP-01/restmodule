/**
 * Defines Propert DAO
 *
 */
package nirmalya.aatithya.restmodule.property.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.ServerValidation;
import nirmalya.aatithya.restmodule.property.model.PropertyModel;

/**
 * @author Nirmalya Labs
 *
 */

@Repository
public class PropertyDao {
	@Autowired
	private EntityManager em;

	/**
	 * DAO Function to View all Properties
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PropertyModel>>> getAllPropertiesList(DataTableRequest request) {

		List<PropertyModel> form = new ArrayList<PropertyModel>();

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("userRoutines")
					.setParameter("actionType", "viewAllProperties").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				PropertyModel properties = new PropertyModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6]);
				form.add(properties);
			}

			if (x.get(0).length > 7) {
				BigInteger t = (BigInteger) x.get(0)[7];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<PropertyModel>> resp = new JsonResponse<List<PropertyModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<PropertyModel>>> response = new ResponseEntity<JsonResponse<List<PropertyModel>>>(
				resp, HttpStatus.CREATED);

		return response;
	}

	/**
	 * DAO Function to add-new/edit Property
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addProperty(PropertyModel prop) {
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (prop.getpTypeName() == null || prop.getpTypeName() == "") {
			resp.setMessage("property Name required");
			validity = false;
		} else if (prop.getPropertyCategory() == null || prop.getPropertyCategory() == "") {
			resp.setMessage("Password required");
			validity = false;
		} else if (prop.getpTypeActive() == null) {
			resp.setMessage("Email required");
			validity = false;
		} else if (prop.getpTypeDescription() == null || prop.getpTypeDescription() == "") {
			resp.setMessage("Address required");
			validity = false;
		}

		if (validity) {
			try {

				String values = GenerateParameter.addPropertyParam(prop);

				if (prop.getPropertyType() == null) {
					em.createNamedStoredProcedureQuery("userRoutines").setParameter("actionType", "addNewProperty")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("userRoutines").setParameter("actionType", "editThisProperty")
							.setParameter("actionValue", values).execute();
				}
			} catch (Exception e) {
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
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		return response;
	}

	/**
	 * DAO Function to View particular property in modal
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<PropertyModel>> modelForProperty(Integer id) {
		List<PropertyModel> form = new ArrayList<PropertyModel>();

		try {

			String value = "SET @p_propertyType=" + id + ";";

			List<Object[]> x = em.createNamedStoredProcedureQuery("userRoutines")
					.setParameter("actionType", "viewPropertyInModel").setParameter("actionValue", value)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					PropertyModel user = new PropertyModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6]);
					form.add(user);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<PropertyModel> resp = new JsonResponse<PropertyModel>();
		resp.setBody(form.get(0));

		ResponseEntity<JsonResponse<PropertyModel>> response = new ResponseEntity<JsonResponse<PropertyModel>>(resp,
				HttpStatus.CREATED);
		System.out.println("response edit : " + response);
		return response;
	}

	/**
	 * DAO Function to View all property Categories in dropdown
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> propertyCategory() {
		List<DropDownModel> form = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_propertyType=" + 0 + ";";
			List<Object> x = em.createNamedStoredProcedureQuery("userRoutines")
					.setParameter("actionType", "getAllPropCategory").setParameter("actionValue", value)
					.getResultList();

			for (Object m : x) {
				DropDownModel user = new DropDownModel(null, m);
				form.add(user);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setBody(form);

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		return response;
	}
}
