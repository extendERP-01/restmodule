/**
 * 
 */
package nirmalya.aatithya.restmodule.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.InventoryIssueNoteDashboardModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class InventoryIssueNoteDashboardDao {

	Logger logger = LoggerFactory.getLogger(InventoryIssueNoteDashboardDao.class);
	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	/**
	 * TODAY ISSUE NOTE
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryIssueNoteDashboardModel>> todayIssueNote() {
		logger.info("Method : InventoryIssueNoteDashboardDao todayIssueNote starts");

		List<InventoryIssueNoteDashboardModel> frondeskData = new ArrayList<InventoryIssueNoteDashboardModel>();
		JsonResponse<InventoryIssueNoteDashboardModel> resp = new JsonResponse<InventoryIssueNoteDashboardModel>();

		try {
			// String value = "SET @p_totalOrder=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("InventoryDashboardRoutines")
					.setParameter("actionType", "getTodayIssueNote").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				InventoryIssueNoteDashboardModel table = new InventoryIssueNoteDashboardModel(m[0], null, null, null);
				frondeskData.add(table);
			}

			resp.setBody(frondeskData.get(0));
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<InventoryIssueNoteDashboardModel>> response = new ResponseEntity<JsonResponse<InventoryIssueNoteDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : InventoryIssueNoteDashboardDao todayIssueNote ends");
		System.out.println("RECCOUNT" + response);
		return response;
	}

	/**
	 * TOTAL ISSUE NOTE
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryIssueNoteDashboardModel>> totalIssueNote() {
		logger.info("Method : InventoryIssueNoteDashboardDao totalIssueNote starts");

		List<InventoryIssueNoteDashboardModel> frondeskData = new ArrayList<InventoryIssueNoteDashboardModel>();
		JsonResponse<InventoryIssueNoteDashboardModel> resp = new JsonResponse<InventoryIssueNoteDashboardModel>();

		try {
			// String value = "SET @p_totalBilling=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("InventoryDashboardRoutines")
					.setParameter("actionType", "getTotalIssueNote").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				InventoryIssueNoteDashboardModel table = new InventoryIssueNoteDashboardModel(m[0], null, null, null);
				frondeskData.add(table);
			}

			resp.setBody(frondeskData.get(0));
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<InventoryIssueNoteDashboardModel>> response = new ResponseEntity<JsonResponse<InventoryIssueNoteDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : InventoryIssueNoteDashboardDao totalIssueNote ends");
		// System.out.println("RECCOUNT"+response);
		return response;
	}

	/**
	 * TOTAL OPEN REQUISTION
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryIssueNoteDashboardModel>> totalOpenRequistion() {
		logger.info("Method : InventoryIssueNoteDashboardDao totalOpenRequistion starts");

		List<InventoryIssueNoteDashboardModel> frondeskData = new ArrayList<InventoryIssueNoteDashboardModel>();
		JsonResponse<InventoryIssueNoteDashboardModel> resp = new JsonResponse<InventoryIssueNoteDashboardModel>();

		try {
			// String value = "SET @p_totalDelivered=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("InventoryDashboardRoutines")
					.setParameter("actionType", "getTotalOpenRequistion").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				InventoryIssueNoteDashboardModel table = new InventoryIssueNoteDashboardModel(m[0], null, null, null);
				frondeskData.add(table);
			}

			resp.setBody(frondeskData.get(0));
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<InventoryIssueNoteDashboardModel>> response = new ResponseEntity<JsonResponse<InventoryIssueNoteDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : InventoryIssueNoteDashboardDao totalOpenRequistion ends");
		// System.out.println("RECCOUNT"+response);
		return response;
	}

	/**
	 * TODAY CLOSED REQUISTION
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryIssueNoteDashboardModel>> todayClosedRequistion() {
		logger.info("Method : InventoryIssueNoteDashboardDao todayClosedRequistion starts");

		List<InventoryIssueNoteDashboardModel> frondeskData = new ArrayList<InventoryIssueNoteDashboardModel>();
		JsonResponse<InventoryIssueNoteDashboardModel> resp = new JsonResponse<InventoryIssueNoteDashboardModel>();

		try {
			// String value = "SET @p_totalPending=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("InventoryDashboardRoutines")
					.setParameter("actionType", "getTodayClosedRequistion").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				InventoryIssueNoteDashboardModel table = new InventoryIssueNoteDashboardModel(m[0], null, null, null);
				frondeskData.add(table);
			}

			resp.setBody(frondeskData.get(0));
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<InventoryIssueNoteDashboardModel>> response = new ResponseEntity<JsonResponse<InventoryIssueNoteDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : InventoryIssueNoteDashboardDao todayClosedRequistion ends");
		// System.out.println("RECCOUNT"+response);
		return response;
	}

	

}
