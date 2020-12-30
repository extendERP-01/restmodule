/**
 * Defines property floor DAO
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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.GenerateFloorParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.ServerValidation;
import nirmalya.aatithya.restmodule.property.controller.PropertyFloorRestController;
import nirmalya.aatithya.restmodule.property.model.PropertyFloorModel;

/**
 * @author Nirmalya Labs
 *
 */

@Repository
public class PropertyFloorDao {
	Logger logger = LoggerFactory.getLogger(PropertyFloorRestController.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	/**
	 * DAO Function to add floor and edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> addFloor(PropertyFloorModel form) {
		logger.info("Method : addFloor starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (form.getFloorName() == null || form.getFloorName() == "") {
			resp.setMessage("floor Name required");

			validity = false;
		} else if (form.getFloorDesc() == null || form.getFloorDesc() == "") {
			resp.setMessage("description required");
			validity = false;
		} else if (form.getpFloorCreatedBy() == null || form.getpFloorCreatedBy() == "") {
			//resp.setMessage("description required");
			validity = false;
		} else if (form.getFloorActive() == null) {
			resp.setMessage("status required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateFloorParameter.getAddFloorParam(form);

				if (form.getFloorId() != null && form.getFloorId() != "") {
					em.createNamedStoredProcedureQuery("propertyFloorRoutines")
							.setParameter("actionType", "modifyFloor").setParameter("actionValue", values).execute();
				} else {

					em.createNamedStoredProcedureQuery("propertyFloorRoutines").setParameter("actionType", "addFloor")
							.setParameter("actionValue", values).execute();
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
				try {
					String[] err = serverDao.errorProcedureCall(e);

					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addFloor end");
		return response;
	}

	/**
	 * DAO Function to view floor
	 *
	 */
	public ResponseEntity<JsonResponse<List<PropertyFloorModel>>> getAllFloor(DataTableRequest request) {
		logger.info("Method : getAllFloor starts");
		List<PropertyFloorModel> form = new ArrayList<PropertyFloorModel>();

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("propertyFloorRoutines")
					.setParameter("actionType", "viewAllfloor").setParameter("actionValue", values).getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					PropertyFloorModel floor = new PropertyFloorModel(m[0], m[1], m[2], m[3]);
					form.add(floor);
				}

				if (x.get(0).length > 4) {
					BigInteger t = (BigInteger) x.get(0)[4];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonResponse<List<PropertyFloorModel>> resp = new JsonResponse<List<PropertyFloorModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<PropertyFloorModel>>> response = new ResponseEntity<JsonResponse<List<PropertyFloorModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getAllFloor end");
		return response;
	}

	/**
	 * DAO Function to delete floor
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteFloor(String id,String createdBy) {
		logger.info("Method : deleteFloor starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		System.out.println(id + "dob");
		try {

			String value = "SET @p_floorId='" + id + "',@p_createdBy='" + createdBy +"';";

			em.createNamedStoredProcedureQuery("propertyFloorRoutines").setParameter("actionType", "deleteFloor")
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

		logger.info("Method : deleteFloor end");
		return response;
	}

	/**
	 * DAO Function to edit floor
	 *
	 */
	public ResponseEntity<JsonResponse<PropertyFloorModel>> getFloorById(String id) {
		logger.info("Method : getFloorById starts");

		List<PropertyFloorModel> form = new ArrayList<PropertyFloorModel>();

		try {
			String value = "SET @p_floorId='" + id + "';";

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("propertyFloorRoutines")
					.setParameter("actionType", "editFloor").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				PropertyFloorModel floor = new PropertyFloorModel(m[0], m[1], m[2], m[3]);
				form.add(floor);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<PropertyFloorModel> resp = new JsonResponse<PropertyFloorModel>();
		resp.setBody(form.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<PropertyFloorModel>> response = new ResponseEntity<JsonResponse<PropertyFloorModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getFloorById end");
		return response;

	}

}
