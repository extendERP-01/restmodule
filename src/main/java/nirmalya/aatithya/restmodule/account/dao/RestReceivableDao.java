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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.dao.SalesInvoiceDao;
import nirmalya.aatithya.restmodule.sales.model.SalesInvoiceModel;

@Repository
public class RestReceivableDao {
	
	Logger logger = LoggerFactory.getLogger(RestReceivableDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> getReceivableInvoiceById(String id) {
		logger.info("Method : getReceivableInvoiceById starts");

		List<SalesInvoiceModel> sales = new ArrayList<SalesInvoiceModel>();
		JsonResponse<List<SalesInvoiceModel>> resp = new JsonResponse<List<SalesInvoiceModel>>();
		try {

			String value = "SET @p_invoiceNo='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
					.setParameter("actionType", "ViewSaleInvoice").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object tDate = null;
				Object iDate = null;
				if (m[22] != null) {
					tDate = DateFormatter.returnStringDate(m[22]);
				}
				if (m[24] != null) {

					iDate = DateFormatter.returnStringDate(m[24]);
				}
				SalesInvoiceModel sale = new SalesInvoiceModel(m[0], m[1], null, m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21],
						tDate, m[23], null, null, null, null, null, null, null, null, null, null, null, null, iDate,
						m[25], null, m[26], m[27], m[28], m[29], m[30], m[31], m[32], m[33], null, null, null, null,
						null, m[34],m[35],m[36]);
				sales.add(sale);
			}

			resp.setBody(sales);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> response = new ResponseEntity<JsonResponse<List<SalesInvoiceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getReceivableInvoiceById ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> getReceivableInvoiceDetails(DataTableRequest request) {
		logger.info("Method : getReceivableInvoiceDetails starts");

		List<SalesInvoiceModel> sales = new ArrayList<SalesInvoiceModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
					.setParameter("actionType", "getSaleInvoice").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				SalesInvoiceModel salesInv = new SalesInvoiceModel(m[0], m[1], m[2], m[3], m[4], m[5], null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, m[6], null, null, m[7],
						null, null, null, null, null, null, null, null, null, null, null, null, null, m[8], null, null,
						null, null, null, null, null, m[9], m[10], null, null, null, null, null, m[11],null,null);
				sales.add(salesInv);
			}
			if (x.size() > 0) {
				if (x.get(0).length > 12) {
					BigInteger t = (BigInteger) x.get(0)[12];

					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<SalesInvoiceModel>> resp = new JsonResponse<List<SalesInvoiceModel>>();
		resp.setBody(sales);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> response = new ResponseEntity<JsonResponse<List<SalesInvoiceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getReceivableInvoiceDetails ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> getAccountReceiptVoucher(DataTableRequest request) {
		logger.info("Method : getAccountReceiptVoucher starts");
		
		List<SalesInvoiceModel> sales = new ArrayList<SalesInvoiceModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		
		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceRoutiness")
					.setParameter("actionType", "getPaidSaleInvoice").setParameter("actionValue", values).getResultList();
			
			for (Object[] m : x) {
				SalesInvoiceModel salesInv = new SalesInvoiceModel(m[0], m[1], m[2], m[3], m[4], m[5], null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, m[6], null, null, m[7],
						null, null, null, null, null, null, null, null, null, null, null, null, null, m[8], null, null,
						null, null, null, null, null, m[9], m[10], null, null, null, null, null, m[11],null,null);
				sales.add(salesInv);
			}
			if (x.size() > 0) {
				if (x.get(0).length > 12) {
					BigInteger t = (BigInteger) x.get(0)[12];
					
					total = Integer.parseInt((t.toString()));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonResponse<List<SalesInvoiceModel>> resp = new JsonResponse<List<SalesInvoiceModel>>();
		resp.setBody(sales);
		resp.setTotal(total);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<SalesInvoiceModel>>> response = new ResponseEntity<JsonResponse<List<SalesInvoiceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getAccountReceiptVoucher ends");
		return response;
	}
}
