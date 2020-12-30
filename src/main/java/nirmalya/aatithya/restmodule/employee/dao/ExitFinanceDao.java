package nirmalya.aatithya.restmodule.employee.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateExitFinanceParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateExitManagementParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.ExitFinancialSettelmentModel;
import nirmalya.aatithya.restmodule.employee.model.ExitManagementModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class ExitFinanceDao {
	Logger logger = LoggerFactory.getLogger(ExitFinanceDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	public ResponseEntity<JsonResponse<Object>> restAddExitFinance(ExitFinancialSettelmentModel exitFinance) {

		logger.info("Method in Dao: restAddExitFinance starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (exitFinance.getEmployeeId() == null || exitFinance.getEmployeeId() == "") {
			resp.setMessage("Employee Name required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateExitFinanceParameter.getAddExitFinanceParam(exitFinance);
				if (exitFinance.getFinanceId() != "" && exitFinance.getFinanceId() != null) {
					em.createNamedStoredProcedureQuery("exitFinance").setParameter("actionType", "modifyFinance")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("exitFinance").setParameter("actionType", "addExitFinance")
							.setParameter("actionValue", values).execute();
				}
			} catch (Exception e) {
				e.printStackTrace();
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

		logger.info("Method in Dao: restAddExitFinance ends");

		
		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ExitFinancialSettelmentModel>>> viewExitFinanceDtls(
			DataTableRequest request) {

		logger.info("Method in Dao: viewExitFinanceDtls starts");

		List<ExitFinancialSettelmentModel> exitFinanceDtlsList = new ArrayList<ExitFinancialSettelmentModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("exitFinance")
					.setParameter("actionType", "viewExitFinance").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					
					ExitFinancialSettelmentModel exitFinancialSettelmentModel = new ExitFinancialSettelmentModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8],m[9], m[10],m[11]);
					exitFinanceDtlsList.add(exitFinancialSettelmentModel);

				}

				if (x.get(0).length > 12) {
					BigInteger t = (BigInteger) x.get(0)[12];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ExitFinancialSettelmentModel>> resp = new JsonResponse<List<ExitFinancialSettelmentModel>>();
		resp.setBody(exitFinanceDtlsList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ExitFinancialSettelmentModel>>> response = new ResponseEntity<JsonResponse<List<ExitFinancialSettelmentModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: viewExitFinanceDtls ends");

		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ExitFinancialSettelmentModel>> getExitFinanceById(String id) {

		logger.info("Method in Dao: getExitFinanceById ends");

		List<ExitFinancialSettelmentModel> exitFinancialList = new ArrayList<ExitFinancialSettelmentModel>();

		try {

			String value = "SET @P_financeId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("exitFinance")
					.setParameter("actionType", "editExitFinance").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				ExitFinancialSettelmentModel exitFinance = new ExitFinancialSettelmentModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8],m[9], m[10],m[11]);

				exitFinancialList.add(exitFinance);
			}
			System.out.println(exitFinancialList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<ExitFinancialSettelmentModel> resp = new JsonResponse<ExitFinancialSettelmentModel>();
		resp.setBody(exitFinancialList.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<ExitFinancialSettelmentModel>> response = new ResponseEntity<JsonResponse<ExitFinancialSettelmentModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getExitById ends");

		return response;
	}
}
