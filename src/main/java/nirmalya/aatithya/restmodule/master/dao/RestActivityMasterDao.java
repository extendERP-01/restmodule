package nirmalya.aatithya.restmodule.master.dao;

import java.math.BigInteger;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestActivityMasterModel;

@Repository
public class RestActivityMasterDao {

	@Autowired
	private EntityManager em;

	Logger logger = LoggerFactory.getLogger(RestFunctionMasterDao.class);

	/**
	 * DAO Function to View all function
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestActivityMasterModel>>> getAllActivity(DataTableRequest request) {
		logger.info("Method : getAllActivity starts");
		List<RestActivityMasterModel> form = new ArrayList<RestActivityMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("activityRoutines")
					.setParameter("actionType", "viewAllActivity").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				RestActivityMasterModel properties = new RestActivityMasterModel(m[0], m[1], m[2], m[3], null, m[5],m[6]);
				form.add(properties);
			}

			if (x.get(0).length > 7) {
				BigInteger t = (BigInteger) x.get(0)[7];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		JsonResponse<List<RestActivityMasterModel>> resp = new JsonResponse<List<RestActivityMasterModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<RestActivityMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestActivityMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllActivity ends");
		return response;
	}

	
	/**
	 * DAO Function to view particular Module in model
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestActivityMasterModel>> viewActivity(String id) {
		logger.info("Method : viewActivity starts");
		List<RestActivityMasterModel> form = new ArrayList<RestActivityMasterModel>();

		try {
			String values = "SET @p_tActivity='" + id + "';";
		
			List<Object[]> x = em.createNamedStoredProcedureQuery("activityRoutines")
					.setParameter("actionType", "viewActivity").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				RestActivityMasterModel activityMaster = new RestActivityMasterModel(m[0], m[1], m[2], m[3], m[4],
						m[5],m[6]);
				form.add(activityMaster);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<RestActivityMasterModel> activityMaster = new JsonResponse<RestActivityMasterModel>();
		activityMaster.setBody(form.get(0));

		ResponseEntity<JsonResponse<RestActivityMasterModel>> response = new ResponseEntity<JsonResponse<RestActivityMasterModel>>(
				activityMaster, HttpStatus.CREATED);
		logger.info("Method : viewActivity ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> changeActivityStatus(String id) {
		logger.info("Method : changeActivityStatus starts");
		
		try {
			
			String values = "SET @p_tActivity='" + id + "';";
			em.createNamedStoredProcedureQuery("activityRoutines")
				.setParameter("actionType", "changeStatus")
				.setParameter("actionValue", values)
				.execute();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonResponse<Object> activityMaster = new JsonResponse<Object>();
		
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(
				activityMaster, HttpStatus.CREATED);
		logger.info("Method : changeActivityStatus ends");
		return response;
	}

}
