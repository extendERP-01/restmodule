package nirmalya.aatithya.restmodule.user.dao;

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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.MapModel;
import nirmalya.aatithya.restmodule.common.utils.MapModel1;
import nirmalya.aatithya.restmodule.user.model.RestSuperAdminDashboardModel;

@Repository
public class RestSuperAdminDashboardDao {
	Logger logger = LoggerFactory.getLogger(RestSuperAdminDashboardDao.class);
	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	/**
	 * SPA TOTAL INVOICE
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestSuperAdminDashboardModel>> spaTotalInvoice() {
		logger.info("Method : RestSuperAdminDashboardDao spaTotalInvoice starts");

		List<RestSuperAdminDashboardModel> spaInvoice = new ArrayList<RestSuperAdminDashboardModel>();
		JsonResponse<RestSuperAdminDashboardModel> resp = new JsonResponse<RestSuperAdminDashboardModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("userDashboardRoutines")
					.setParameter("actionType", "getTotalSpaInvoice").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				RestSuperAdminDashboardModel table = new RestSuperAdminDashboardModel(m[0], null, null, null, null,
						null, null);
				spaInvoice.add(table);
			}

			resp.setBody(spaInvoice.get(0));
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

		ResponseEntity<JsonResponse<RestSuperAdminDashboardModel>> response = new ResponseEntity<JsonResponse<RestSuperAdminDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : RestSuperAdminDashboardDao spaTotalInvoice ends");

		return response;
	}

	/**
	 * GYM TOTAL INVOICE
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestSuperAdminDashboardModel>> gymTotalInvoice() {
		logger.info("Method : RestSuperAdminDashboardDao gymTotalInvoice starts");

		List<RestSuperAdminDashboardModel> gymInvoice = new ArrayList<RestSuperAdminDashboardModel>();
		JsonResponse<RestSuperAdminDashboardModel> resp = new JsonResponse<RestSuperAdminDashboardModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("userDashboardRoutines")
					.setParameter("actionType", "getTotalGymInvoice").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				RestSuperAdminDashboardModel table = new RestSuperAdminDashboardModel(null, m[0], null, null, null,
						null, null);
				gymInvoice.add(table);
			}

			resp.setBody(gymInvoice.get(0));
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

		ResponseEntity<JsonResponse<RestSuperAdminDashboardModel>> response = new ResponseEntity<JsonResponse<RestSuperAdminDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : RestSuperAdminDashboardDao gymTotalInvoice ends");

		return response;
	}

	/**
	 * BEAUTY PARLOUR TOTAL INVOICE
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestSuperAdminDashboardModel>> beautyTotalInvoice() {
		logger.info("Method : RestSuperAdminDashboardDao beautyTotalInvoice starts");

		List<RestSuperAdminDashboardModel> gymInvoice = new ArrayList<RestSuperAdminDashboardModel>();
		JsonResponse<RestSuperAdminDashboardModel> resp = new JsonResponse<RestSuperAdminDashboardModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("userDashboardRoutines")
					.setParameter("actionType", "getTotalBeautyInvoice").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				RestSuperAdminDashboardModel table = new RestSuperAdminDashboardModel(null, null, m[0], null, null,
						null, null);
				gymInvoice.add(table);
			}

			resp.setBody(gymInvoice.get(0));
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

		ResponseEntity<JsonResponse<RestSuperAdminDashboardModel>> response = new ResponseEntity<JsonResponse<RestSuperAdminDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : RestSuperAdminDashboardDao beautyTotalInvoice ends");

		return response;
	}

	/**
	 * BEAUTY PARLOUR TOTAL INVOICE
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestSuperAdminDashboardModel>> laundryTotalInvoice() {
		logger.info("Method : RestSuperAdminDashboardDao laundryTotalInvoice starts");

		List<RestSuperAdminDashboardModel> laundryInvoice = new ArrayList<RestSuperAdminDashboardModel>();
		JsonResponse<RestSuperAdminDashboardModel> resp = new JsonResponse<RestSuperAdminDashboardModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("userDashboardRoutines")
					.setParameter("actionType", "getTotalLaundryInvoice").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				RestSuperAdminDashboardModel table = new RestSuperAdminDashboardModel(null, null, null, m[0], null,
						null, null);
				laundryInvoice.add(table);
			}

			resp.setBody(laundryInvoice.get(0));
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

		ResponseEntity<JsonResponse<RestSuperAdminDashboardModel>> response = new ResponseEntity<JsonResponse<RestSuperAdminDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : RestSuperAdminDashboardDao laundryTotalInvoice ends");

		return response;
	}

	/**
	 * NIGHT CLUB TOTAL INVOICE
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestSuperAdminDashboardModel>> nightClubTotalInvoice() {
		logger.info("Method : RestSuperAdminDashboardDao nightClubTotalInvoice starts");

		List<RestSuperAdminDashboardModel> nightClubInvoice = new ArrayList<RestSuperAdminDashboardModel>();
		JsonResponse<RestSuperAdminDashboardModel> resp = new JsonResponse<RestSuperAdminDashboardModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("userDashboardRoutines")
					.setParameter("actionType", "getTotalClubInvoice").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				RestSuperAdminDashboardModel table = new RestSuperAdminDashboardModel(null, null, null, null, m[0],
						null, null);
				nightClubInvoice.add(table);
			}

			resp.setBody(nightClubInvoice.get(0));
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

		ResponseEntity<JsonResponse<RestSuperAdminDashboardModel>> response = new ResponseEntity<JsonResponse<RestSuperAdminDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : RestSuperAdminDashboardDao nightClubTotalInvoice ends");

		return response;
	}

	/**
	 * RESTAURANT TOTAL INVOICE
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestSuperAdminDashboardModel>> restaurantTotalInvoice() {
		logger.info("Method : RestSuperAdminDashboardDao restaurantTotalInvoice starts");

		List<RestSuperAdminDashboardModel> restaurantInvoice = new ArrayList<RestSuperAdminDashboardModel>();
		JsonResponse<RestSuperAdminDashboardModel> resp = new JsonResponse<RestSuperAdminDashboardModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("userDashboardRoutines")
					.setParameter("actionType", "getTotalRestaurantInvoice").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				RestSuperAdminDashboardModel table = new RestSuperAdminDashboardModel(null, null, null, null, null,
						m[0], null);
				restaurantInvoice.add(table);
			}

			resp.setBody(restaurantInvoice.get(0));
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

		ResponseEntity<JsonResponse<RestSuperAdminDashboardModel>> response = new ResponseEntity<JsonResponse<RestSuperAdminDashboardModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : RestSuperAdminDashboardDao restaurantTotalInvoice ends");

		return response;
	}
	/*
	 * 
	 * OCCUPANCY REPORT GRAPH
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<MapModel>>> viewOccupancyReport() {
		logger.info("Method : viewOccupancyReportGraph starts");
		List<MapModel> mm = new ArrayList<MapModel>();
		JsonResponse<List<MapModel>> resp = new JsonResponse<List<MapModel>>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("userDashboardRoutines")
					.setParameter("actionType", "getOccupancyReport").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				BigInteger t = (BigInteger) m[0];
				Integer total = Integer.parseInt(t.toString());
				MapModel m2 = new MapModel();
				m2.setY(total);
				m2.setName(m[1].toString());
				mm.add(m2);
			}
			resp.setBody(mm);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<MapModel>>> response = new ResponseEntity<JsonResponse<List<MapModel>>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : viewOccupancyReportGraph ends");

		return response;
	}

	/*
	 * 
	 * REVENUE REPORT GRAPH
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<MapModel1>>> viewRevenueReportGraph() {
		logger.info("Method : viewRevenueReportGraph starts");
		List<MapModel1> mm = new ArrayList<MapModel1>();
		JsonResponse<List<MapModel1>> resp = new JsonResponse<List<MapModel1>>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("userDashboardRoutines")
					.setParameter("actionType", "getRevenueReport").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				Double t = (Double) m[0];
				Double total = Double.parseDouble(t.toString());
				MapModel1 m2 = new MapModel1();
				m2.setY(total);
				m2.setName(m[1].toString());
				mm.add(m2);
			}
			resp.setBody(mm);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<MapModel1>>> response = new ResponseEntity<JsonResponse<List<MapModel1>>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : viewRevenueReportGraph ends");

		return response;
	}


}
