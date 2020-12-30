/**
 * Dao for Sitting plan
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
import nirmalya.aatithya.restmodule.common.utils.GenerateSeatingPlanParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.model.PropertySeattingPlanModel;

/**
 * @author Nirmalya labs
 *
 */

@Repository
public class PropertySeatingPlanDao {
	Logger logger = LoggerFactory.getLogger(PropertySeatingPlanDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	/*
	 * for all theme details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PropertySeattingPlanModel>>> getSittingDetails(DataTableRequest request) {

		logger.info("Method : getSittingDetails starts");

		List<PropertySeattingPlanModel> seattingPlanList = new ArrayList<PropertySeattingPlanModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("SittingPlan")
					.setParameter("actionType", "viewAllSitting").setParameter("actionValue", values).getResultList();

			if(!x.isEmpty())
			{
			for (Object[] m : x) {
				PropertySeattingPlanModel seattingPlan = new PropertySeattingPlanModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6]);
				seattingPlanList.add(seattingPlan);

			}

			if (x.get(0).length > 7) {
				BigInteger t = (BigInteger) x.get(0)[7];

				total = Integer.parseInt((t.toString()));
			}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<PropertySeattingPlanModel>> resp = new JsonResponse<List<PropertySeattingPlanModel>>();
		resp.setBody(seattingPlanList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<PropertySeattingPlanModel>>> response = new ResponseEntity<JsonResponse<List<PropertySeattingPlanModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getSittingDetails ends");

		return response;
	}
/*
 *  for add a new sitting plan
 */
	public ResponseEntity<JsonResponse<Object>> addSitting(PropertySeattingPlanModel seattingPlan) {

		logger.info("Method : addSitting starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (seattingPlan.getPlanName() == null || seattingPlan.getPlanName() == "") {
			resp.setMessage("Sittig Name required");
			validity = false;
		} else if (seattingPlan.getPlanDescription() == null || seattingPlan.getPlanDescription() == "") {
			resp.setMessage("Sitting Description required");
			validity = false;
		} else if (seattingPlan.getPropertyCategory() == null || seattingPlan.getPropertyCategory() == "") {
			resp.setMessage("Sitting Category required");
			validity = false;
		}
		else if (seattingPlan.getPlanActive() == null) {
			resp.setMessage("Sitting active required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateSeatingPlanParameter.getAddSeatingPlan(seattingPlan);
				
				if (seattingPlan.getSeatingPlan() != "" && seattingPlan.getSeatingPlan() != null) {
					em.createNamedStoredProcedureQuery("SittingPlan").setParameter("actionType", "editSitting")
							.setParameter("actionValue", values).execute();

				} else {
					em.createNamedStoredProcedureQuery("SittingPlan").setParameter("actionType", "addSitting")
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

		logger.info("Method : addSitting ends");

		return response;
	}

	/*
	 * for edit seating
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<PropertySeattingPlanModel>> getSittingById(String id) {

		logger.info("Method in Dao: getSittingById starts");

		List<PropertySeattingPlanModel> SeattingPlanList = new ArrayList<PropertySeattingPlanModel>();

		try {

			String value = "SET @p_sittingPlan='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("SittingPlan")
					.setParameter("actionType", "viewSitting").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				PropertySeattingPlanModel SeattingPlan = new PropertySeattingPlanModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6]);
				SeattingPlanList.add(SeattingPlan);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<PropertySeattingPlanModel> resp = new JsonResponse<PropertySeattingPlanModel>();
		resp.setBody(SeattingPlanList.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<PropertySeattingPlanModel>> response = new ResponseEntity<JsonResponse<PropertySeattingPlanModel>>(resp,
				responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getSittingById ends");

		return response;
	}

	/*
	 * for delete Setting
	 */
	public ResponseEntity<JsonResponse<Object>> deleteSittingById(String id,String createdBy) {

		logger.info("Method : deleteSittingById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_sittingPlan='" + id +"', @p_createdBy='"+createdBy+ "';";
			em.createNamedStoredProcedureQuery("SittingPlan").setParameter("actionType", "deleteSitting")
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

		logger.info("Method : deleteSittingById ends");

		return response;
	}

}
