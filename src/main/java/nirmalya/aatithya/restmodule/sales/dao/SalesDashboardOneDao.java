/**
 * 
 */
package nirmalya.aatithya.restmodule.sales.dao;

 
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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse; 
import nirmalya.aatithya.restmodule.sales.model.RestSalesDashboardoneModel;

/**
 * @author ashis
 *
 */
@Repository
public class SalesDashboardOneDao {

Logger logger = LoggerFactory.getLogger(QuotationMasterDao.class);
	
	@Autowired
	ServerDao serverDao;
	
	@Autowired
	EntityManager em;

	/**
	 * DAO - Get box count sale dashboard
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestSalesDashboardoneModel>> getBoxCountForSales() {
		logger.info("Method : SalesDashboardDao getBoxCountForSales starts");
		JsonResponse<RestSalesDashboardoneModel> resp = new JsonResponse<RestSalesDashboardoneModel>();
		List<RestSalesDashboardoneModel> form = new ArrayList<RestSalesDashboardoneModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDashboardoneRoutiness")
							.setParameter("actionType", "salesDashboardCounts")
							.setParameter("actionValue", "")
							.getResultList();		
			for (Object[] m : x) {
				RestSalesDashboardoneModel accountGroup = new RestSalesDashboardoneModel(m[0], m[1], m[2], m[3],m[4],m[5],null);
				form.add(accountGroup);
			}
			resp.setBody(form.get(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestSalesDashboardoneModel>> response = new ResponseEntity<JsonResponse<RestSalesDashboardoneModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : SalesDashboardDao getBoxCountForSales end");
		System.out.println("response in dao"+response);
		return response;
	}
	
	
	/**
	 * DAO - Get top sale inv items
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSalesDashboardoneModel>>> getTopItems() {
		logger.info("Method : SalesDashboardDao getBoxCountForSales starts");
		JsonResponse<List<RestSalesDashboardoneModel>> resp = new JsonResponse<List<RestSalesDashboardoneModel>>();
		List<RestSalesDashboardoneModel> form = new ArrayList<RestSalesDashboardoneModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDashboardoneRoutiness")
							.setParameter("actionType", "saleInvTopItems")
							.setParameter("actionValue", "")
							.getResultList();		
			for (Object[] m : x) {
				RestSalesDashboardoneModel accountGroup = new RestSalesDashboardoneModel(null, null, null, null,null,m[1],m[0]);
				form.add(accountGroup);
			}
			resp.setBody(form);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestSalesDashboardoneModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesDashboardoneModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : SalesDashboardDao getBoxCountForSales end");
		System.out.println("response in dao"+response);
		return response;
	}
	/**
	 * DAO - Get top sale invoices
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSalesDashboardoneModel>>> getTopSaleInv() {
		logger.info("Method : SalesDashboardDao getBoxCountForSales starts");
		JsonResponse<List<RestSalesDashboardoneModel>> resp = new JsonResponse<List<RestSalesDashboardoneModel>>();
		List<RestSalesDashboardoneModel> form = new ArrayList<RestSalesDashboardoneModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDashboardoneRoutiness")
					.setParameter("actionType", "topSaleInvoices")
					.setParameter("actionValue", "")
					.getResultList();		
			for (Object[] m : x) {
				RestSalesDashboardoneModel accountGroup = new RestSalesDashboardoneModel(null, null, null, null,null,m[1],m[0]);
				form.add(accountGroup);
			}
			resp.setBody(form);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestSalesDashboardoneModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesDashboardoneModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : SalesDashboardDao getBoxCountForSales end");
		System.out.println("response in dao 138 :"+response);
		return response;
	}
}
