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
import nirmalya.aatithya.restmodule.inventory.model.InventoryRequisitionDashboardModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class InventoryRequisitionDashboardDao {

	Logger logger = LoggerFactory.getLogger(InventoryRequisitionDashboardDao.class);
	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	/**
	 * Today Requisition
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryRequisitionDashboardModel>> todayRequisition() {
		logger.info("Method : InventoryRequisitionDashboardDao todayRequisition starts");

		List<InventoryRequisitionDashboardModel> frondeskData = new ArrayList<InventoryRequisitionDashboardModel>();
		JsonResponse<InventoryRequisitionDashboardModel> resp = new JsonResponse<InventoryRequisitionDashboardModel>();

		try {
			// String value = "SET @p_totalOrder=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("InventoryDashboardRoutines")
					.setParameter("actionType", "getTodayRequisitionCount").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				InventoryRequisitionDashboardModel table = new InventoryRequisitionDashboardModel(m[0], null, null, null);
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

		ResponseEntity<JsonResponse<InventoryRequisitionDashboardModel>> response = new ResponseEntity<JsonResponse<InventoryRequisitionDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : InventoryRequisitionDashboardDao todayRequisition ends");
		System.out.println("RECCOUNT" + response);
		return response;
	}

	/**
	 * Past Due Requisition
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryRequisitionDashboardModel>> pastDueRequisition() {
		logger.info("Method : InventoryRequisitionDashboardDao pastDueRequisition starts");

		List<InventoryRequisitionDashboardModel> frondeskData = new ArrayList<InventoryRequisitionDashboardModel>();
		JsonResponse<InventoryRequisitionDashboardModel> resp = new JsonResponse<InventoryRequisitionDashboardModel>();

		try {
			// String value = "SET @p_totalBilling=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("InventoryDashboardRoutines")
					.setParameter("actionType", "getPastDueRequisitionCount").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				InventoryRequisitionDashboardModel table = new InventoryRequisitionDashboardModel(m[0], null, null, null);
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

		ResponseEntity<JsonResponse<InventoryRequisitionDashboardModel>> response = new ResponseEntity<JsonResponse<InventoryRequisitionDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : InventoryRequisitionDashboardDao pastDueRequisition ends");
		// System.out.println("RECCOUNT"+response);
		return response;
	}

	/**
	 * Today Closed Requisition
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryRequisitionDashboardModel>> todayClosedRequisition() {
		logger.info("Method : InventoryRequisitionDashboardDao todayClosedRequisition starts");

		List<InventoryRequisitionDashboardModel> frondeskData = new ArrayList<InventoryRequisitionDashboardModel>();
		JsonResponse<InventoryRequisitionDashboardModel> resp = new JsonResponse<InventoryRequisitionDashboardModel>();

		try {
			// String value = "SET @p_totalDelivered=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("InventoryDashboardRoutines")
					.setParameter("actionType", "getTodayClosedRequisitionCount").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				InventoryRequisitionDashboardModel table = new InventoryRequisitionDashboardModel(m[0], null, null, null);
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

		ResponseEntity<JsonResponse<InventoryRequisitionDashboardModel>> response = new ResponseEntity<JsonResponse<InventoryRequisitionDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : InventoryRequisitionDashboardDao todayClosedRequisition ends");
		// System.out.println("RECCOUNT"+response);
		return response;
	}

	/**
	 * Total Closed Requisition
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryRequisitionDashboardModel>> totalClosedRequisition() {
		logger.info("Method : InventoryRequisitionDashboardDao totalClosedRequisition starts");

		List<InventoryRequisitionDashboardModel> frondeskData = new ArrayList<InventoryRequisitionDashboardModel>();
		JsonResponse<InventoryRequisitionDashboardModel> resp = new JsonResponse<InventoryRequisitionDashboardModel>();

		try {
			// String value = "SET @p_totalPending=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("InventoryDashboardRoutines")
					.setParameter("actionType", "getTotalClosedRequisitionCount").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				InventoryRequisitionDashboardModel table = new InventoryRequisitionDashboardModel(m[0], null, null, null);
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

		ResponseEntity<JsonResponse<InventoryRequisitionDashboardModel>> response = new ResponseEntity<JsonResponse<InventoryRequisitionDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : InventoryRequisitionDashboardDao totalClosedRequisition ends");
		// System.out.println("RECCOUNT"+response);
		return response;
	}

}
