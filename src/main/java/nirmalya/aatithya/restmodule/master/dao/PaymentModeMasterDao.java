package nirmalya.aatithya.restmodule.master.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GeneratePaymentModeMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.PaymentModeMasterModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class PaymentModeMasterDao {
	Logger logger = LoggerFactory.getLogger(PaymentModeMasterDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	/**
	 * DAO Function to add payment mode and edit
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addPaymentMode(PaymentModeMasterModel form) {
		logger.info("Method : addPaymentMode starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (form.getPaytModName() == null || form.getPaytModName() == "") {
			resp.setMessage("Payment Name required");

			validity = false;
		} else if (form.getPaytModDescription() == null || form.getPaytModDescription() == "") {
			resp.setMessage("description required");
			validity = false;
		} else if (form.getPayModCreatedBy() == null || form.getPayModCreatedBy() == "") {
			//resp.setMessage("description required");
			validity = false;
		} else if (form.getPayModActive() == null) {
			resp.setMessage("status required");
			validity = false;
		}

		if (validity)
			try {
				String values = GeneratePaymentModeMasterParameter.getAddPaymentParam(form);
				//System.out.println("+++++++++++++" + values);
				if (form.getPaymentMode() != null && form.getPaymentMode() != "") {
					em.createNamedStoredProcedureQuery("paymentModeRoutines")
							.setParameter("actionType", "modifyPayment").setParameter("actionValue", values).execute();
				} else {

					em.createNamedStoredProcedureQuery("paymentModeRoutines").setParameter("actionType", "addPayment")
							.setParameter("actionValue", values).execute();
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
				try {
					String[] err = serverDao.errorProcedureCall(e);

					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addPayment end");
		return response;
	}
	/**
	 * DAO Function to view payment mode
	 *
	 */
	public ResponseEntity<JsonResponse<List<PaymentModeMasterModel>>> getAllPayment(DataTableRequest request) {
		logger.info("Method : getAllPayment starts");
		List<PaymentModeMasterModel> form = new ArrayList<PaymentModeMasterModel>();

		String values = GenerateParameter.getSearchParam(request);
		//System.out.println("values are"+values);
		Integer total = 0;
		try {

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentModeRoutines")
					.setParameter("actionType", "viewAllPayment").setParameter("actionValue", values).getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					PaymentModeMasterModel payment = new PaymentModeMasterModel(m[0], m[1], m[2], m[3]);
					form.add(payment);
				}

				if (x.get(0).length > 4) {
					BigInteger t = (BigInteger) x.get(0)[4];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonResponse<List<PaymentModeMasterModel>> resp = new JsonResponse<List<PaymentModeMasterModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<PaymentModeMasterModel>>> response = new ResponseEntity<JsonResponse<List<PaymentModeMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getAllPayment end");
		//System.out.println("response in dao"+response);
		return response;
		
	}
	/**
	 * DAO Function to edit payment
	 *
	 *//*
	public ResponseEntity<JsonResponse<PaymentModeMasterModel>> getPaymentById(String id) {
		logger.info("Method : getPaymentById starts");

		List<PaymentModeMasterModel> form = new ArrayList<PaymentModeMasterModel>();

		try {
			String value = "SET @p_paymentId='" + id + "';";

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentModeRoutines")
					.setParameter("actionType", "editPayment").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				PaymentModeMasterModel payment = new PaymentModeMasterModel(m[0], m[1], m[2], m[3]);
				form.add(payment);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<PaymentModeMasterModel> resp = new JsonResponse<PaymentModeMasterModel>();
		resp.setBody(form.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<PaymentModeMasterModel>> response = new ResponseEntity<JsonResponse<PaymentModeMasterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getFloorById end");
		return response;

	}*/
	/**
	 * DAO Function for edit payment mode
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<PaymentModeMasterModel>> getPaymentById(String id, String action) {
		logger.info("Method : getPaymentById starts");

		List<PaymentModeMasterModel> form = new ArrayList<PaymentModeMasterModel>();

		try {
			String value = "SET @p_paymentId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentModeRoutines").setParameter("actionType", action)
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				PaymentModeMasterModel payment = new PaymentModeMasterModel(m[0], m[1], m[2], m[3]);
				form.add(payment);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<PaymentModeMasterModel> resp = new JsonResponse<PaymentModeMasterModel>();
		resp.setBody(form.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<PaymentModeMasterModel>> response = new ResponseEntity<JsonResponse<PaymentModeMasterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getPaymentById end");
		return response;

	}
	/**
	 * DAO Function to delete property reservation
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deletePaymentById(String id,String createdBy) {
		logger.info("Method : deletePayment starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_paymentId='" + id + "',@p_paymentCreatedBy='" + createdBy +"';";

			em.createNamedStoredProcedureQuery("paymentModeRoutines")
			.setParameter("actionType", "deletePayment")
			.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			String[] err = serverDao.errorProcedureCall(e);

			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : deletePayment dao end");
		return response;
	}
}
