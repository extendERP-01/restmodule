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
import nirmalya.aatithya.restmodule.account.model.TdsMasterModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.GenerateFinanceYearParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateTdsMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class TdsMasterDao {

	Logger logger = LoggerFactory.getLogger(TdsMasterDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	EntityManager em;
	public ResponseEntity<JsonResponse<Object>> addTdsMaster(TdsMasterModel form) {
		logger.info("Method : addTdsMaster starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (form.getTdsType() == null || form.getTdsType() == "") {
			resp.setMessage("Tds Type  required");
			validity = false;
		}else if (form.getTdsRate() == null) {
			resp.setMessage("Tds Rate  required");
			validity = false;
		
		} else if (form.getTdsStatus()== null) {
			resp.setMessage("Status required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateTdsMasterParameter.getAddTdsParam(form);
			
				if (form.getTdsId() != null && form.getTdsId() != "") {
					em.createNamedStoredProcedureQuery("tdsRoutines")
							.setParameter("actionType", "modifyTds")
							.setParameter("actionValue", values).execute();
				} else {

					em.createNamedStoredProcedureQuery("tdsRoutines")
					.setParameter("actionType", "addTds")
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

		logger.info("Method : addTdsMaster end");
		return response;
	}
	
	public ResponseEntity<JsonResponse<List<TdsMasterModel>>> getAllTdsMaster(DataTableRequest request) {
		logger.info("Method : getAllTdsMaster starts");
		List<TdsMasterModel> form = new ArrayList<TdsMasterModel>();

		String values = GenerateParameter.getSearchParam(request);
	
		Integer total = 0;
		try {

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("tdsRoutines")
					.setParameter("actionType", "viewAllTds").setParameter("actionValue", values).getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					
					TdsMasterModel TdsMasterModel = new TdsMasterModel(m[0], m[1],m[2],m[3]);
					form.add(TdsMasterModel);
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
		JsonResponse<List<TdsMasterModel>> resp = new JsonResponse<List<TdsMasterModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<TdsMasterModel>>> response = new ResponseEntity<JsonResponse<List<TdsMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getAllTdsMaster end");
		
		return response;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<TdsMasterModel>> getTdsById(String id, String action) {
		logger.info("Method : getTdsById starts");

		List<TdsMasterModel> form = new ArrayList<TdsMasterModel>();

		try {
			String value = "SET @p_tdsId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("tdsRoutines").setParameter("actionType", action)
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				TdsMasterModel tdsMasterModel = new TdsMasterModel(m[0], m[1], m[2],m[3]);
				form.add(tdsMasterModel);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<TdsMasterModel> resp = new JsonResponse<TdsMasterModel>();
		resp.setBody(form.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<TdsMasterModel>> response = new ResponseEntity<JsonResponse<TdsMasterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getTdsById end");
		return response;

	}
}
