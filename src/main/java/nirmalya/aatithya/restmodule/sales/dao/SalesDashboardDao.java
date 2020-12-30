package nirmalya.aatithya.restmodule.sales.dao;

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
import nirmalya.aatithya.restmodule.common.utils.MapModel1;
import nirmalya.aatithya.restmodule.sales.model.SalesDashboardModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class SalesDashboardDao {

	Logger logger = LoggerFactory.getLogger(SalesDashboardDao.class);
	
	@Autowired
	ServerDao serverDao;
	
	@Autowired
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<SalesDashboardModel> salesDashboardDataDao() {
		logger.info("Method : salesDashboardDataDao starts");
		List<SalesDashboardModel> dataList = new ArrayList<SalesDashboardModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDashboardoneRoutiness")
					.setParameter("actionType", "dashboardData").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				SalesDashboardModel prop = new SalesDashboardModel(m[0], m[1], m[2], m[3]);
				dataList.add(prop);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : salesDashboardDataDao ends");

		return dataList;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<MapModel1>>> dbSalesReportDao() {
		logger.info("Method : dbSalesReportDao starts");
		
		List<MapModel1> mm = new ArrayList<MapModel1>();
		JsonResponse<List<MapModel1>> resp = new JsonResponse<List<MapModel1>>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDashboardoneRoutiness")
					.setParameter("actionType", "dbSalesReport").setParameter("actionValue", "").getResultList();
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
		
		logger.info("Method : dbSalesReportDao ends"); 
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<MapModel1>>> dbOrderReportDao() {
		logger.info("Method : dbOrderReportDao starts");
		
		List<MapModel1> mm = new ArrayList<MapModel1>();
		JsonResponse<List<MapModel1>> resp = new JsonResponse<List<MapModel1>>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDashboardoneRoutiness")
					.setParameter("actionType", "dbOrderReport").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				Double total = Double.parseDouble(m[0].toString());
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
		
		logger.info("Method : dbOrderReportDao ends");
		return response;
	}
}
