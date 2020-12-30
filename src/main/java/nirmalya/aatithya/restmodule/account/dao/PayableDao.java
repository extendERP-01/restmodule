package nirmalya.aatithya.restmodule.account.dao;

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

import nirmalya.aatithya.restmodule.account.model.DataModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.model.SalesInvoiceModel;

@Repository
public class PayableDao {

	Logger logger = LoggerFactory.getLogger(PayableDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DataModel>>> getVendorBills(DataTableRequest request) {
		logger.info("Method : getVendorBills starts");
		
		String param3 = request.getParam3();
		String param2 = request.getParam2();
		if (param2 != null && param2 != "") {
			String frmDate = DateFormatter.getStringDate(param2);
			request.setParam2(frmDate);
		}
		if (param3 != null && param3 != "") {
			String tDate = DateFormatter.getStringDate(param3);
			request.setParam3(tDate);
		}
		
		List<DataModel> sales = new ArrayList<DataModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		
		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("payableRoutines")
					.setParameter("actionType", "getVendorBills").setParameter("actionValue", values).getResultList();
			
			for (Object[] m : x) {
				DataModel salesInv = new DataModel(m[0], m[1], null, null, null, m[2]);
				sales.add(salesInv);
			}
			if (x.size() > 0) {
				if (x.get(0).length > 3) {
					BigInteger t = (BigInteger) x.get(0)[3];
					total = Integer.parseInt((t.toString()));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonResponse<List<DataModel>> resp = new JsonResponse<List<DataModel>>();
		resp.setBody(sales);
		resp.setTotal(total);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<DataModel>>> response = new ResponseEntity<JsonResponse<List<DataModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getVendorBills ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DataModel>>> getOtherBills(DataTableRequest request) {
		logger.info("Method : getOtherBills starts");
		
		String param3 = request.getParam3();
		String param2 = request.getParam2();
		if (param2 != null && param2 != "") {
			String frmDate = DateFormatter.getStringDate(param2);
			request.setParam2(frmDate);
		}
		if (param3 != null && param3 != "") {
			String tDate = DateFormatter.getStringDate(param3);
			request.setParam3(tDate);
		}
		
		List<DataModel> sales = new ArrayList<DataModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		
		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("payableRoutines")
					.setParameter("actionType", "getOtherBills").setParameter("actionValue", values).getResultList();
			
			for (Object[] m : x) {
				DataModel salesInv = new DataModel(m[0], m[1], null, null, null, m[2]);
				sales.add(salesInv);
			}
			if (x.size() > 0) {
				if (x.get(0).length > 3) {
					BigInteger t = (BigInteger) x.get(0)[3];
					total = Integer.parseInt((t.toString()));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonResponse<List<DataModel>> resp = new JsonResponse<List<DataModel>>();
		resp.setBody(sales);
		resp.setTotal(total);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<DataModel>>> response = new ResponseEntity<JsonResponse<List<DataModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getOtherBills ends");
		return response;
	}
}
