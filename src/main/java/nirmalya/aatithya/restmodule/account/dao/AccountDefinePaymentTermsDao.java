package nirmalya.aatithya.restmodule.account.dao;

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

import nirmalya.aatithya.restmodule.account.model.DefinePaymentTermsModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class AccountDefinePaymentTermsDao {

	Logger logger = LoggerFactory.getLogger(AccountDefinePaymentTermsDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	public ResponseEntity<JsonResponse<Object>> addTerms(DefinePaymentTermsModel job) {
		logger.info("Method : addjobMaster starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (job.getTermsComment() == null || job.getTermsComment() == "") {
			resp.setMessage("Terms Required");
			validity = false;
		}
		String values = "SET @p_comment='" + job.getTermsComment() + "', @p_createdBy='" + job.getCreatedBy() + "';";

		
		try {
			if (validity) {
					em.createNamedStoredProcedureQuery("paymentTerms").setParameter("actionType", "addTerms")
							.setParameter("actionValue", values).execute();
			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		System.out.println("respnse" + response);
		logger.info("Method : addjobMaster ends");
		System.out.println("@@@"+response);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DefinePaymentTermsModel>> getDetailsEdit() {

		logger.info("Method in Dao: getDetailsEdit ends");

		List<DefinePaymentTermsModel> jobFormList = new ArrayList<DefinePaymentTermsModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("paymentTerms")
					.setParameter("actionType", "viewEdit").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				

				DefinePaymentTermsModel jobForm = new DefinePaymentTermsModel( m[0],m[1],m[2]);

				jobFormList.add(jobForm);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<DefinePaymentTermsModel> resp = new JsonResponse<DefinePaymentTermsModel>();
		if(jobFormList.size() > 0) {
			resp.setBody(jobFormList.get(0));
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<DefinePaymentTermsModel>> response = new ResponseEntity<JsonResponse<DefinePaymentTermsModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getDetailsEdit ends");
		System.out.println("response=="+resp);
		return response;
	}
	
}
