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

import nirmalya.aatithya.restmodule.account.model.FinancialModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.GenerateFinanceYearParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class FinancialDao {
	
	Logger logger = LoggerFactory.getLogger(FinancialDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	EntityManager em;
	public ResponseEntity<JsonResponse<Object>> addFiancialYear(FinancialModel form) {
		logger.info("Method : addFiancialYear starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (form.getFinancialYear() == null || form.getFinancialYear() == "") {
			resp.setMessage("Year  required");
			validity = false;
		}else if (form.getFinancialFromDate() == null || form.getFinancialFromDate() == "") {
			resp.setMessage("  Finance From  required");
			validity = false;
		}else if (form.getFinancialTodate() == null || form.getFinancialTodate() == "") {
			resp.setMessage("  Finance To  required");
			validity = false;
		} else if (form.getCreatedBy() == null || form.getCreatedBy() == "") {
			
			validity = false;
		} else if (form.getFinancialStatus()== null) {
			resp.setMessage("Status required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateFinanceYearParameter.getAddFinancialYearParam(form);
			
				if (form.getFinancialYearId() != null && form.getFinancialYearId() != "") {
					em.createNamedStoredProcedureQuery("financeRoutines")
							.setParameter("actionType", "modifyFinance")
							.setParameter("actionValue", values).execute();
				} else {

					em.createNamedStoredProcedureQuery("financeRoutines")
					.setParameter("actionType", "addFinance")
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

		logger.info("Method : addAcademicYear end");
		return response;
	}
	
	
	public ResponseEntity<JsonResponse<List<FinancialModel>>> getAllFinance(DataTableRequest request) {
		logger.info("Method : getAllFinance starts");
		List<FinancialModel> form = new ArrayList<FinancialModel>();

		String values = GenerateParameter.getSearchParam(request);
	
		Integer total = 0;
		try {

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("financeRoutines")
					.setParameter("actionType", "viewAllFinance").setParameter("actionValue", values).getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object fromDate = null;
					Object toDate = null;
					if (m[2] != null) {
						fromDate = DateFormatter.returnStringDate(m[2]);
					}
					if (m[3] != null) {
						toDate = DateFormatter.returnStringDate(m[3]);
					}
					FinancialModel financialModel = new FinancialModel(m[0], m[1], fromDate,toDate,m[4]);
					form.add(financialModel);
				}

				if (x.get(0).length > 5) {
					BigInteger t = (BigInteger) x.get(0)[5];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonResponse<List<FinancialModel>> resp = new JsonResponse<List<FinancialModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<FinancialModel>>> response = new ResponseEntity<JsonResponse<List<FinancialModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getAllFinance end");
		
		return response;
		
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<FinancialModel>> getFinanceYearById(String id, String action) {
		logger.info("Method : getFinanceYearById starts");

		List<FinancialModel> form = new ArrayList<FinancialModel>();

		try {
			String value = "SET @p_financialId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("financeRoutines").setParameter("actionType", action)
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object fromDate = null;
				Object toDate = null;
				if (m[2] != null) {
					fromDate = DateFormatter.returnStringDate(m[2]);
				}
				if (m[3] != null) {
					toDate = DateFormatter.returnStringDate(m[3]);
				}
				FinancialModel financialModel = new FinancialModel(m[0], m[1], fromDate,toDate,m[4]);
				form.add(financialModel);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<FinancialModel> resp = new JsonResponse<FinancialModel>();
		resp.setBody(form.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<FinancialModel>> response = new ResponseEntity<JsonResponse<FinancialModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getFinanceYearById end");
		return response;

	}
}
