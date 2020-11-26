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
import nirmalya.aatithya.restmodule.inventory.model.InventoryGoodsReturnNoteDashboardModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class InventoryGoodsReturnNoteDashboardDao {

	Logger logger = LoggerFactory.getLogger(InventoryGoodsReturnNoteDashboardDao.class);
	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	/**
	 * INVENTORY TODAY GOODS RETURN NOTE
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryGoodsReturnNoteDashboardModel>> todayGoodsReturnNote() {
		logger.info("Method : InventoryGoodsReturnNoteDashboardDao todayGoodsReturnNote starts");

		List<InventoryGoodsReturnNoteDashboardModel> frondeskData = new ArrayList<InventoryGoodsReturnNoteDashboardModel>();
		JsonResponse<InventoryGoodsReturnNoteDashboardModel> resp = new JsonResponse<InventoryGoodsReturnNoteDashboardModel>();

		try {
			// String value = "SET @p_totalOrder=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("InventoryDashboardRoutines")
					.setParameter("actionType", "getTodayGoodsReturnNote").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				InventoryGoodsReturnNoteDashboardModel table = new InventoryGoodsReturnNoteDashboardModel(m[0], null,
						null, null);
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

		ResponseEntity<JsonResponse<InventoryGoodsReturnNoteDashboardModel>> response = new ResponseEntity<JsonResponse<InventoryGoodsReturnNoteDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : InventoryGoodsReturnNoteDashboardDao todayGoodsReturnNote ends");
		System.out.println("RECCOUNT" + response);
		return response;
	}

	/**
	 * INVENTORY TOTAL GOODS RETURN NOTE
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryGoodsReturnNoteDashboardModel>> totalGoodsReturnNote() {
		logger.info("Method : InventoryGoodsReturnNoteDashboardDao totalGoodsReturnNote starts");

		List<InventoryGoodsReturnNoteDashboardModel> frondeskData = new ArrayList<InventoryGoodsReturnNoteDashboardModel>();
		JsonResponse<InventoryGoodsReturnNoteDashboardModel> resp = new JsonResponse<InventoryGoodsReturnNoteDashboardModel>();

		try {
			// String value = "SET @p_totalBilling=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("InventoryDashboardRoutines")
					.setParameter("actionType", "getTotalGoodsReturnNote").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				InventoryGoodsReturnNoteDashboardModel table = new InventoryGoodsReturnNoteDashboardModel(m[0], null,
						null, null);
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

		ResponseEntity<JsonResponse<InventoryGoodsReturnNoteDashboardModel>> response = new ResponseEntity<JsonResponse<InventoryGoodsReturnNoteDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : InventoryGoodsReturnNoteDashboardDao totalGoodsReturnNote ends");
		// System.out.println("RECCOUNT"+response);
		return response;
	}

	/**
	 * INVENTORY TODAY GOODS RETURN NOTE PRICE
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryGoodsReturnNoteDashboardModel>> todayGoodsReturnNotePrice() {
		logger.info("Method : InventoryGoodsReturnNoteDashboardDao todayGoodsReturnNotePrice starts");

		List<InventoryGoodsReturnNoteDashboardModel> frondeskData = new ArrayList<InventoryGoodsReturnNoteDashboardModel>();
		JsonResponse<InventoryGoodsReturnNoteDashboardModel> resp = new JsonResponse<InventoryGoodsReturnNoteDashboardModel>();

		try {
			// String value = "SET @p_totalDelivered=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("InventoryDashboardRoutines")
					.setParameter("actionType", "getTodayGoodsReturnNotePrice").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				InventoryGoodsReturnNoteDashboardModel table = new InventoryGoodsReturnNoteDashboardModel(m[0], null,
						null, null);
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

		ResponseEntity<JsonResponse<InventoryGoodsReturnNoteDashboardModel>> response = new ResponseEntity<JsonResponse<InventoryGoodsReturnNoteDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : InventoryGoodsReturnNoteDashboardDao todayGoodsReturnNotePrice ends");
		// System.out.println("RECCOUNT"+response);
		return response;
	}

	/**
	 * INVENTORY TOTAL GOODS RETURN NOTE PRICE
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryGoodsReturnNoteDashboardModel>> totalGoodsReturnNotePrice() {
		logger.info("Method : InventoryGoodsReturnNoteDashboardDao totalGoodsReturnNotePrice starts");

		List<InventoryGoodsReturnNoteDashboardModel> frondeskData = new ArrayList<InventoryGoodsReturnNoteDashboardModel>();
		JsonResponse<InventoryGoodsReturnNoteDashboardModel> resp = new JsonResponse<InventoryGoodsReturnNoteDashboardModel>();

		try {
			// String value = "SET @p_totalPending=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("InventoryDashboardRoutines")
					.setParameter("actionType", "getTotalGoodsReturnNotePrice").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				InventoryGoodsReturnNoteDashboardModel table = new InventoryGoodsReturnNoteDashboardModel(m[0], null,
						null, null);
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

		ResponseEntity<JsonResponse<InventoryGoodsReturnNoteDashboardModel>> response = new ResponseEntity<JsonResponse<InventoryGoodsReturnNoteDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : InventoryGoodsReturnNoteDashboardDao totalGoodsReturnNotePrice ends");
		// System.out.println("RECCOUNT"+response);
		return response;
	}

}
