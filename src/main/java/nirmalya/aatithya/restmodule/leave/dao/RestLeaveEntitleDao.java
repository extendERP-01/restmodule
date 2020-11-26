/**
 * Defines RestLeaveEntitleDao DAO
 *
 */
package nirmalya.aatithya.restmodule.leave.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateLeavePendingParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.leave.model.RestLeaveEmpEntitleModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class RestLeaveEntitleDao {

	Logger logger = LoggerFactory.getLogger(RestLeaveEntitleDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	EntityManager em;

	/*
	 * DAO Function to View all List Entitlement
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestLeaveEmpEntitleModel>>> getLEntitleData(DataTableRequest request) {
		logger.info("Method : getLEntitleData details starts");
		List<RestLeaveEmpEntitleModel> leavelist = new ArrayList<RestLeaveEmpEntitleModel>();
		String values = GenerateLeavePendingParameter.getSearchParam(request);
		Integer total = 0;
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("leaveEntitleRoutines")
					.setParameter("actionType", "viewLeaveEntitle").setParameter("actionValue", values).getResultList();
			if(!x.isEmpty()) {
				for (Object[] m : x) {

					RestLeaveEmpEntitleModel user = new RestLeaveEmpEntitleModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], null , null);
					leavelist.add(user);
				}
				if (x.get(0).length > 8) {
					BigInteger t = (BigInteger) x.get(0)[8];
	
					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestLeaveEmpEntitleModel>> resp = new JsonResponse<List<RestLeaveEmpEntitleModel>>();
		resp.setBody(leavelist);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestLeaveEmpEntitleModel>>> response = new ResponseEntity<JsonResponse<List<RestLeaveEmpEntitleModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getLEntitleData ends");
		return response;
	}
}
