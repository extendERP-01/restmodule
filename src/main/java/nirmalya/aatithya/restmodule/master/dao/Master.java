package nirmalya.aatithya.restmodule.master.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateRelationParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
//import nirmalya.aatithya.restmodule.common.utils.ServerValidation; 
import nirmalya.aatithya.restmodule.master.model.RelationModel;
import nirmalya.aatithya.restmodule.user.dao.UserTypeDao;

/**
 * @author Nirmalya Labs
 *
 */

@Repository
public class Master {
	Logger logger = LoggerFactory.getLogger(UserTypeDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	/**
	 * DAO Function to add payment mode and edit
	 *
	 */ 
	public ResponseEntity<JsonResponse<Object>> addRelation(RelationModel form) {
		logger.info("Method : addRelation starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (form.getRltnName() == null || form.getRltnName() == "") {
			resp.setMessage("Relation Name required");

			validity = false;
		} else if (form.getRltnDescription() == null || form.getRltnDescription() == "") {
			resp.setMessage("description required");
			validity = false;
		} else if (form.getRltnCreatedBy() == null || form.getRltnCreatedBy() == "") {
			//resp.setMessage("description required");
			validity = false;
		} else if (form.getRltnActive() == null) {
			resp.setMessage("status required");
			validity = false;
		} else if (form.getIsEditable() == null) {
			resp.setMessage("IsEditable required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateRelationParameter.getAddRelationParam(form);
				//System.out.println("+++++++++++++" + values);
				if (form.getRelationId() != null && form.getRelationId() != "") {
					em.createNamedStoredProcedureQuery("relationRoutines")
							.setParameter("actionType", "modifyRltn").setParameter("actionValue", values).execute();
				} else {

					em.createNamedStoredProcedureQuery("relationRoutines").setParameter("actionType", "addRelation")
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

		logger.info("Method : addPayment end");
		return response;
	}
	/**
	 * DAO Function to view payment mode
	 *
	 */
	public ResponseEntity<JsonResponse<List<RelationModel>>> getAllRelation(DataTableRequest request) {
		logger.info("Method : getAllRelation starts");
		List<RelationModel> form = new ArrayList<RelationModel>();

		String values = GenerateParameter.getSearchParam(request);
		//System.out.println("values are"+values);
		Integer total = 0;
		try {

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("relationRoutines")
					.setParameter("actionType", "viewAllRelation").setParameter("actionValue", values).getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					RelationModel relation = new RelationModel(m[0], m[1], m[2], m[3],m[4]);
					form.add(relation);
				}

				if (x.get(0).length > 5) {
					BigInteger t = (BigInteger) x.get(0)[5];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonResponse<List<RelationModel>> resp = new JsonResponse<List<RelationModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RelationModel>>> response = new ResponseEntity<JsonResponse<List<RelationModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getAllPayment end");
		//System.out.println("response in dao"+response);
		return response;
		
	}
	/**
	 * DAO Function for edit payment mode
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RelationModel>> geRelationById(String id, String action) {
		logger.info("Method : geRelationById starts");

		List<RelationModel> form = new ArrayList<RelationModel>();

		try {
			String value = "SET @p_relationId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("relationRoutines").setParameter("actionType", action)
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RelationModel relation = new RelationModel(m[0], m[1], m[2], m[3],m[4]);
				form.add(relation);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<RelationModel> resp = new JsonResponse<RelationModel>();
		resp.setBody(form.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<RelationModel>> response = new ResponseEntity<JsonResponse<RelationModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getPaymentById end");
		return response;

	}
	/**
	 * DAO Function to delete property reservation
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteRltnById(String id,String createdBy) {
		logger.info("Method : deleteRltnById starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_relationId='" + id + "',@p_rltnCreatedBy='" + createdBy +"';";

			em.createNamedStoredProcedureQuery("relationRoutines")
			.setParameter("actionType", "deleteRelation")
			.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			String[] err = serverDao.errorProcedureCall(e);

			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : deleteRltnById dao end");
		return response;
	}
}
