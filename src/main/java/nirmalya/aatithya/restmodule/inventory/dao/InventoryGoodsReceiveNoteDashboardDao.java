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
import nirmalya.aatithya.restmodule.inventory.model.InventoryGoodsReceiveNoteDashboardModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class InventoryGoodsReceiveNoteDashboardDao {

	Logger logger = LoggerFactory.getLogger(InventoryGoodsReceiveNoteDashboardDao.class);
	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	/**
	 * TODAY INVENTORY GOODS RECEIVE NOTE
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryGoodsReceiveNoteDashboardModel>> todayGoodsReceiveNote() {
		logger.info("Method : InventoryGoodsReceiveNoteDashboardDao todayGoodsReceiveNote starts");

		List<InventoryGoodsReceiveNoteDashboardModel> frondeskData = new ArrayList<InventoryGoodsReceiveNoteDashboardModel>();
		JsonResponse<InventoryGoodsReceiveNoteDashboardModel> resp = new JsonResponse<InventoryGoodsReceiveNoteDashboardModel>();

		try {
			// String value = "SET @p_totalOrder=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("InventoryDashboardRoutines")
					.setParameter("actionType", "getTodayGoodsReceiveNoteCount").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				InventoryGoodsReceiveNoteDashboardModel table = new InventoryGoodsReceiveNoteDashboardModel(m[0], null, null, null);
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

		ResponseEntity<JsonResponse<InventoryGoodsReceiveNoteDashboardModel>> response = new ResponseEntity<JsonResponse<InventoryGoodsReceiveNoteDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : InventoryGoodsReceiveNoteDashboardDao todayGoodsReceiveNote ends");
		System.out.println("RECCOUNT" + response);
		return response;
	}

	/**
	 * TOTAL INVENTORY GOODS RECEIVE NOTE
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryGoodsReceiveNoteDashboardModel>> totalGoodsReceiveNote() {
		logger.info("Method : InventoryGoodsReceiveNoteDashboardDao totalGoodsReceiveNote starts");

		List<InventoryGoodsReceiveNoteDashboardModel> frondeskData = new ArrayList<InventoryGoodsReceiveNoteDashboardModel>();
		JsonResponse<InventoryGoodsReceiveNoteDashboardModel> resp = new JsonResponse<InventoryGoodsReceiveNoteDashboardModel>();

		try {
			// String value = "SET @p_totalBilling=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("InventoryDashboardRoutines")
					.setParameter("actionType", "getTotalGoodsReceiveNoteCount").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				InventoryGoodsReceiveNoteDashboardModel table = new InventoryGoodsReceiveNoteDashboardModel(m[0], null, null, null);
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

		ResponseEntity<JsonResponse<InventoryGoodsReceiveNoteDashboardModel>> response = new ResponseEntity<JsonResponse<InventoryGoodsReceiveNoteDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : InventoryGoodsReceiveNoteDashboardDao totalGoodsReceiveNote ends");
		// System.out.println("RECCOUNT"+response);
		return response;
	}

	/**
	 * TODAY INVENTORY GRN PRICE
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryGoodsReceiveNoteDashboardModel>> todayGrnPrice() {
		logger.info("Method : InventoryGoodsReceiveNoteDashboardDao todayGrnPrice starts");

		List<InventoryGoodsReceiveNoteDashboardModel> frondeskData = new ArrayList<InventoryGoodsReceiveNoteDashboardModel>();
		JsonResponse<InventoryGoodsReceiveNoteDashboardModel> resp = new JsonResponse<InventoryGoodsReceiveNoteDashboardModel>();

		try {
			// String value = "SET @p_totalDelivered=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("InventoryDashboardRoutines")
					.setParameter("actionType", "getTodayGrnPriceCount").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				InventoryGoodsReceiveNoteDashboardModel table = new InventoryGoodsReceiveNoteDashboardModel(m[0], null, null, null);
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

		ResponseEntity<JsonResponse<InventoryGoodsReceiveNoteDashboardModel>> response = new ResponseEntity<JsonResponse<InventoryGoodsReceiveNoteDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : InventoryGoodsReceiveNoteDashboardDao todayGrnPrice ends");
		// System.out.println("RECCOUNT"+response);
		return response;
	}

	/**
	 * TOTAL INVENTORY GRN PRICE
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryGoodsReceiveNoteDashboardModel>> totalGrnPrice() {
		logger.info("Method : InventoryGoodsReceiveNoteDashboardDao totalGrnPrice starts");

		List<InventoryGoodsReceiveNoteDashboardModel> frondeskData = new ArrayList<InventoryGoodsReceiveNoteDashboardModel>();
		JsonResponse<InventoryGoodsReceiveNoteDashboardModel> resp = new JsonResponse<InventoryGoodsReceiveNoteDashboardModel>();

		try {
			// String value = "SET @p_totalPending=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("InventoryDashboardRoutines")
					.setParameter("actionType", "getTotalGrnPriceCount").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				InventoryGoodsReceiveNoteDashboardModel table = new InventoryGoodsReceiveNoteDashboardModel(m[0], null, null, null);
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

		ResponseEntity<JsonResponse<InventoryGoodsReceiveNoteDashboardModel>> response = new ResponseEntity<JsonResponse<InventoryGoodsReceiveNoteDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : InventoryGoodsReceiveNoteDashboardDao totalGrnPrice ends");
		// System.out.println("RECCOUNT"+response);
		return response;
	}

}
