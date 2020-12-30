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
import nirmalya.aatithya.restmodule.inventory.model.InventoryPurchaseOrderDashboardModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class InventoryPurchaseOrderDashboardDao {

	Logger logger = LoggerFactory.getLogger(InventoryPurchaseOrderDashboardDao.class);
	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	/**
	 * TODAY OPEN PURCHASE ORDER
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryPurchaseOrderDashboardModel>> todayOpenPurchaseOrder() {
		logger.info("Method : InventoryPurchaseOrderDashboardDao todayOpenPurchaseOrder starts");

		List<InventoryPurchaseOrderDashboardModel> frondeskData = new ArrayList<InventoryPurchaseOrderDashboardModel>();
		JsonResponse<InventoryPurchaseOrderDashboardModel> resp = new JsonResponse<InventoryPurchaseOrderDashboardModel>();

		try {
			// String value = "SET @p_totalOrder=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("InventoryDashboardRoutines")
					.setParameter("actionType", "getTodayOpenPurchaseOrder").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				InventoryPurchaseOrderDashboardModel table = new InventoryPurchaseOrderDashboardModel(m[0], null, null, null);
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

		ResponseEntity<JsonResponse<InventoryPurchaseOrderDashboardModel>> response = new ResponseEntity<JsonResponse<InventoryPurchaseOrderDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : InventoryPurchaseOrderDashboardDao todayOpenPurchaseOrder ends");
		System.out.println("RECCOUNT" + response);
		return response;
	}

	/**
	 * TOTAL OPEN PURCHASE ORDER
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryPurchaseOrderDashboardModel>> totalOpenPurchaseOrder() {
		logger.info("Method : InventoryPurchaseOrderDashboardDao totalOpenPurchaseOrder starts");

		List<InventoryPurchaseOrderDashboardModel> frondeskData = new ArrayList<InventoryPurchaseOrderDashboardModel>();
		JsonResponse<InventoryPurchaseOrderDashboardModel> resp = new JsonResponse<InventoryPurchaseOrderDashboardModel>();

		try {
			// String value = "SET @p_totalBilling=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("InventoryDashboardRoutines")
					.setParameter("actionType", "getTotalOpenPurchaseOrder").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				InventoryPurchaseOrderDashboardModel table = new InventoryPurchaseOrderDashboardModel(m[0], null, null, null);
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

		ResponseEntity<JsonResponse<InventoryPurchaseOrderDashboardModel>> response = new ResponseEntity<JsonResponse<InventoryPurchaseOrderDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : InventoryPurchaseOrderDashboardDao totalOpenPurchaseOrder ends");
		// System.out.println("RECCOUNT"+response);
		return response;
	}

	/**
	 * TODAY CLOSED PURCHASE ORDER
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryPurchaseOrderDashboardModel>> todayClosedPurchaseOrder() {
		logger.info("Method : InventoryPurchaseOrderDashboardDao todayClosedPurchaseOrder starts");

		List<InventoryPurchaseOrderDashboardModel> frondeskData = new ArrayList<InventoryPurchaseOrderDashboardModel>();
		JsonResponse<InventoryPurchaseOrderDashboardModel> resp = new JsonResponse<InventoryPurchaseOrderDashboardModel>();

		try {
			// String value = "SET @p_totalDelivered=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("InventoryDashboardRoutines")
					.setParameter("actionType", "getTodayClosedPurchaseOrder").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				InventoryPurchaseOrderDashboardModel table = new InventoryPurchaseOrderDashboardModel(m[0], null, null, null);
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

		ResponseEntity<JsonResponse<InventoryPurchaseOrderDashboardModel>> response = new ResponseEntity<JsonResponse<InventoryPurchaseOrderDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : InventoryPurchaseOrderDashboardDao todayClosedPurchaseOrder ends");
		// System.out.println("RECCOUNT"+response);
		return response;
	}

	/**
	 * TOTAL CLOSED PURCHASE ORDER
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryPurchaseOrderDashboardModel>> totalClosedPurchaseOrder() {
		logger.info("Method : InventoryPurchaseOrderDashboardDao totalClosedPurchaseOrder starts");

		List<InventoryPurchaseOrderDashboardModel> frondeskData = new ArrayList<InventoryPurchaseOrderDashboardModel>();
		JsonResponse<InventoryPurchaseOrderDashboardModel> resp = new JsonResponse<InventoryPurchaseOrderDashboardModel>();

		try {
			// String value = "SET @p_totalPending=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("InventoryDashboardRoutines")
					.setParameter("actionType", "getTotalClosedPurchaseOrder").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				InventoryPurchaseOrderDashboardModel table = new InventoryPurchaseOrderDashboardModel(m[0], null, null, null);
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

		ResponseEntity<JsonResponse<InventoryPurchaseOrderDashboardModel>> response = new ResponseEntity<JsonResponse<InventoryPurchaseOrderDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : InventoryPurchaseOrderDashboardDao totalClosedPurchaseOrder ends");
		// System.out.println("RECCOUNT"+response);
		return response;
	}

}
