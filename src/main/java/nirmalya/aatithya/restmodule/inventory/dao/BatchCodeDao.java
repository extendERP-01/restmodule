package nirmalya.aatithya.restmodule.inventory.dao;

import java.math.BigDecimal;
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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateBatchCodeParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.BatchCodeModel;

@Repository
public class BatchCodeDao {

	Logger logger = LoggerFactory.getLogger(BatchCodeDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getGRNForBatchCodeDao(String id) {
		logger.info("Method : getGRNForBatchCodeDao Dao starts");

		List<DropDownModel> poList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_searchValue='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("batchCodeRoutines")
					.setParameter("actionType", "getGRN").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				poList.add(dropDownModel);
			}

			resp.setBody(poList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getGRNForBatchCodeDao Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<BatchCodeModel>>> getGRNDetailsForBatchCodeDao(String id) {
		logger.info("Method : getGRNDetailsForBatchCodeDao Dao starts");

		List<BatchCodeModel> poList = new ArrayList<BatchCodeModel>();
		JsonResponse<List<BatchCodeModel>> resp = new JsonResponse<List<BatchCodeModel>>();

		try {
			String value = "SET @p_searchValue='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("batchCodeRoutines")
					.setParameter("actionType", "getGRNDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				BatchCodeModel dropDownModel = new BatchCodeModel(null, null, null, m[0], m[1], m[2], m[3], m[4], m[5],
						null, null, m[6]);
				poList.add(dropDownModel);
			}

			resp.setBody(poList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<BatchCodeModel>>> response = new ResponseEntity<JsonResponse<List<BatchCodeModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getGRNDetailsForBatchCodeDao Dao ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> newBatchCodeSaveDao(List<BatchCodeModel> batchCode) {
		logger.info("Method : newBatchCodeSaveDao starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (BatchCodeModel l : batchCode) {

			if (l.getGrnId() == null || l.getGrnId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("GRN Required");
				break;
			} else if (l.getBatchCode() == null || l.getBatchCode() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Batch Code Required");
				break;
			}
		}
		if (validity) {
			try {
				Boolean isSuccess = null;
				String values = "SET @p_grn='" + batchCode.get(0).getGrnId() + "';";
				isSuccess = em.createNamedStoredProcedureQuery("batchCodeRoutines")
						.setParameter("actionType", "deleteforEdit").setParameter("actionValue", values).execute();

				for (BatchCodeModel a : batchCode) {
					String value = GenerateBatchCodeParameter.newBatchCodeSingle(a);
					if (a.getBatchId() != null && a.getBatchId() != "") {

						em.createNamedStoredProcedureQuery("batchCodeRoutines")
								.setParameter("actionType", "modifyBatchCode").setParameter("actionValue", value)
								.execute();

					} else {
						em.createNamedStoredProcedureQuery("batchCodeRoutines")
								.setParameter("actionType", "addBatchCode").setParameter("actionValue", value)
								.execute();
					}

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
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : newBatchCodeSaveDao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<BatchCodeModel>>> getBatchCodeDetailsDao(DataTableRequest request) {
		logger.info("Method : getBatchCodeDetailsDao starts");

		List<BatchCodeModel> batchCode = new ArrayList<BatchCodeModel>();
		if (request.getParam4() != null && request.getParam4() != "") {
			String param4 = DateFormatter.getStringDate(request.getParam4());
			request.setParam4(param4);
		}
		if (request.getParam5() != null && request.getParam5() != "") {
			String param5 = DateFormatter.getStringDate(request.getParam5());
			request.setParam5(param5);
		}

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("batchCodeRoutines")
					.setParameter("actionType", "getBatchCode").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				BatchCodeModel gp = new BatchCodeModel(m[0], m[1], null, null, null, null, null, null, null, null, m[2],
						null);
				batchCode.add(gp);
			}
			if (x.size() > 0) {
				if (x.get(0).length > 3) {
					BigDecimal t = (BigDecimal) x.get(0)[3];
					total = t.intValue();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<BatchCodeModel>> resp = new JsonResponse<List<BatchCodeModel>>();
		resp.setBody(batchCode);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<BatchCodeModel>>> response = new ResponseEntity<JsonResponse<List<BatchCodeModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getBatchCodeDetailsDao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<BatchCodeModel>>> getBatchCodeByIdDao(String id) {
		logger.info("Method : getBatchCodeByIdDao starts");

		List<BatchCodeModel> batchCode = new ArrayList<BatchCodeModel>();
		JsonResponse<List<BatchCodeModel>> resp = new JsonResponse<List<BatchCodeModel>>();
		try {

			String value = "SET @p_batch='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("batchCodeRoutines")
					.setParameter("actionType", "modalBatchCode").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				BatchCodeModel gp = new BatchCodeModel(m[0], m[1], null, m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9],
						null);
				batchCode.add(gp);
			}

			resp.setBody(batchCode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<BatchCodeModel>>> response = new ResponseEntity<JsonResponse<List<BatchCodeModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getBatchCodeByIdDao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<BatchCodeModel> editBatchCodeDao(String id) {
		logger.info("Method : editBatchCodeDao starts");

		List<BatchCodeModel> batchCode = new ArrayList<BatchCodeModel>();
		String value = "SET @p_batch='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("batchCodeRoutines")
					.setParameter("actionType", "modalBatchCode").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				BatchCodeModel gp = new BatchCodeModel(m[0], m[1], null, m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9],
						null);
				batchCode.add(gp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editBatchCodeDao ends");
		return batchCode;
	}
}
