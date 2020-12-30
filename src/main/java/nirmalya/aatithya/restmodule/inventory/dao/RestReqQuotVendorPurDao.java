package nirmalya.aatithya.restmodule.inventory.dao;

import javax.persistence.EntityManager;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
 

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
import nirmalya.aatithya.restmodule.common.utils.GenerateReqQuotParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;  
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryRFQVendorDetailModel;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryReqDetailsModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class RestReqQuotVendorPurDao {
	Logger logger = LoggerFactory.getLogger(RestReqQuotVendorPurDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	EntityManager em;
	

	/*
	 * DAO Function to View all Request Quotation
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryReqDetailsModel>>> getReqQuotData(
			DataTableRequest request) {
		logger.info("Method : getReqQuotData details starts");
		List<RestInventoryReqDetailsModel> meal = new ArrayList<RestInventoryReqDetailsModel>();
		//System.out.println("value"+request.getParam1());
		String values = GenerateReqQuotParameter.getSearchParam(request);
		Integer total = 0;
		//System.out.println("param is Doa -----"+request.getParam1());
		try {
			 
			List<Object[]> x = em.createNamedStoredProcedureQuery("reqSelectRFQRoutines")
					.setParameter("actionType", "viewReqQuotationDtls")
					.setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				Object  validityDate = null; 
				if (m[2] != null) {
					validityDate = DateFormatter.returnStringDate(m[2]);

				}
				 
				RestInventoryReqDetailsModel user = new RestInventoryReqDetailsModel(m[0], m[1], validityDate,m[3], m[4],m[5],m[6],m[7],m[8],null,null);
				meal.add(user);
			}
			if (x.get(0).length > 9) {
				BigInteger t = (BigInteger) x.get(0)[9];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestInventoryReqDetailsModel>> resp = new JsonResponse<List<RestInventoryReqDetailsModel>>();
		resp.setBody(meal);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestInventoryReqDetailsModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryReqDetailsModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getReqQuotData ends");
		//System.out.println("Response in Request Quotation dao View==============="+response);
		return response;
	}
	
	
	
	
	
	/*
	 * DAO Function to View all Request Quotation For Selection
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryRFQVendorDetailModel>>> getRFQDataVendorSelect(
			DataTableRequest request) {
		logger.info("Method : getRFQDataVendorSelect details starts");
		List<RestInventoryRFQVendorDetailModel> meal = new ArrayList<RestInventoryRFQVendorDetailModel>();
		//System.out.println("value"+request.getParam1());
		String values = GenerateReqQuotParameter.getSearchParam(request);
		Integer total = 0;
		//System.out.println("param is Doa -----"+request.getParam1());
		try {
			 
			List<Object[]> x = em.createNamedStoredProcedureQuery("reqSelectRFQRoutines")
					.setParameter("actionType", "viewRFQSelectDtls")
					.setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				 
				 
				RestInventoryRFQVendorDetailModel user = new RestInventoryRFQVendorDetailModel(m[0],m[1],m[2],null,null,null,null,null,null,null,null,null,null,null,null,null,m[3],m[4],m[5],null,null,null);
				meal.add(user);
			}
			if (x.get(0).length > 6) {
				BigInteger t = (BigInteger) x.get(0)[6];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestInventoryRFQVendorDetailModel>> resp = new JsonResponse<List<RestInventoryRFQVendorDetailModel>>();
		resp.setBody(meal);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestInventoryRFQVendorDetailModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryRFQVendorDetailModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getRFQDataVendorSelect ends");
		//System.out.println("Response in Request Quotation dao View==============="+response);
		return response;
	}
	
	
	
	
	
	

/**
	 * CHANGE STATUS RESTAURANT FOOD ORDER BY ID
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> approveQuotStatus(String id, String rfqId,
			Byte approveStatus) {
		logger.info("Method : RESTMODULE   approveQuotStatus starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			Object ReturnvalId="";
			String value = "SET @p_QuotId='" + id + "',@p_rfqId='" + rfqId + "',@p_approveStatus=" + approveStatus + ";";
			System.out.println("value------------------------ ---------------"+value);
			ReturnvalId =em.createNamedStoredProcedureQuery("reqSelectRFQRoutines")
					.setParameter("actionType", "approveVendQuot")
					.setParameter("actionValue", value)
					.getSingleResult(); 
			 String total = (String) ReturnvalId;
			 	String FailString="Fail"; 
			 	if(total.equalsIgnoreCase(FailString)) {
			 		try {
			 			//mandatory condition for always getting catch block 
			 			 int[] myNumbers = {1, 2, 3};
			 		     System.out.println(myNumbers[10]);
				 	}catch (Exception e) {
				 		String[] err = serverDao.errorProcedureCall(e);
						resp.setCode(err[0]);
						resp.setMessage(err[1]); 
				 	}
			 	} 
		} catch (Exception e) {
			e.printStackTrace(); 
			String[] err = serverDao.errorProcedureCall(e);
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		} 
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED); 
		logger.info("Method : RESTMODULE  approveQuotStatus ends");
		return response;
	}
	
	
	
	
	/**
	 * DAO Function to view Quotation in model
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryRFQVendorDetailModel>>> getQuotationModel(
			String id) {

		logger.info("Method : getQuotationModel starts");
	 	List<RestInventoryRFQVendorDetailModel> mt = new ArrayList<RestInventoryRFQVendorDetailModel>();
		JsonResponse<List<RestInventoryRFQVendorDetailModel>> resp = new JsonResponse<List<RestInventoryRFQVendorDetailModel>>();

		try {

			String value = "SET @p_QuotId='" + id + "';";
			 List<Object[]> x = em.createNamedStoredProcedureQuery("reqSelectRFQRoutines")
					.setParameter("actionType", "ModelView").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestInventoryRFQVendorDetailModel Quotdaya = new RestInventoryRFQVendorDetailModel(m[0], m[1], m[2],m[3], m[4],m[5],m[6],m[7],m[8],m[9],m[10],m[11],m[12],m[13],m[14],m[15],m[16],null,null,null,null,null);

				mt.add(Quotdaya);
			}
			resp.setBody(mt);
		} catch (Exception e) {
			e.printStackTrace();
		}

		

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestInventoryRFQVendorDetailModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryRFQVendorDetailModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		//System.out.println("response for quotation ------------------------"+response);
		logger.info("Method : getQuotationModel ends");
	 	return response;

	}
	
	

}
