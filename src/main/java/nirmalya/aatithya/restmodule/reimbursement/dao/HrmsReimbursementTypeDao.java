package nirmalya.aatithya.restmodule.reimbursement.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateReimbursementTypePArameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.reimbursement.model.HrmsReimbursementTypeModel;

@Repository
public class HrmsReimbursementTypeDao {

	Logger logger = LoggerFactory.getLogger(HrmsReimbursementTypeDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for all reimbursementType details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsReimbursementTypeModel>>> getreimbursementTypeDetails(
			DataTableRequest request) {

		logger.info("Method in Dao: getreimbursementTypeDetails starts");

		List<HrmsReimbursementTypeModel> employementList = new ArrayList<HrmsReimbursementTypeModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementTypeMaster")
					.setParameter("actionType", "viewreimTypeList").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					HrmsReimbursementTypeModel employement = new HrmsReimbursementTypeModel(m[0], m[1], m[2], m[3]);
					employementList.add(employement);

				}

				if (x.get(0).length > 4) {
					BigInteger t = (BigInteger) x.get(0)[4];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsReimbursementTypeModel>> resp = new JsonResponse<List<HrmsReimbursementTypeModel>>();
		resp.setBody(employementList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsReimbursementTypeModel>>> response = new ResponseEntity<JsonResponse<List<HrmsReimbursementTypeModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getreimbursementTypeDetails ends");

		return response;
	}

	/*
	 * for add new reimbursementType
	 */
	public ResponseEntity<JsonResponse<Object>> addreimbursementType(HrmsReimbursementTypeModel reimbursementType) {

		logger.info("Method in Dao: addreimbursementType starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (reimbursementType.getReimbursementTypeName() == null
				|| reimbursementType.getReimbursementTypeName() == "") {
			resp.setMessage("reimbursementType Name required");
			validity = false;
		} else if (reimbursementType.getReimbursementTypeDesc() == null
				|| reimbursementType.getReimbursementTypeDesc() == "") {
			resp.setMessage("reimbursementType description required");
			validity = false;
		} else if (reimbursementType.getReimbursementTypeStatus() == null) {
			resp.setMessage("reimbursementType active required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateReimbursementTypePArameter.getAddReimbursementTypeParam(reimbursementType);
				if (reimbursementType.getReimbursementTypeId() != "") {
					em.createNamedStoredProcedureQuery("reimbursementTypeMaster")
							.setParameter("actionType", "modifyreimType").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("reimbursementTypeMaster")
							.setParameter("actionType", "addreimType").setParameter("actionValue", values)
							.execute();
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

		logger.info("Method in Dao: addreimbursementType ends");

		return response;
	}

	/*
	 * for edit reimbursementType
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<HrmsReimbursementTypeModel>> getreimbursementTypeById(String id) {

		logger.info("Method in Dao: getreimbursementTypeById ends");

		List<HrmsReimbursementTypeModel> preimbursementType = new ArrayList<HrmsReimbursementTypeModel>();

		try {

			String value = "SET @P_rembId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementTypeMaster")
					.setParameter("actionType", "viewEditreimType").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				HrmsReimbursementTypeModel reimbursementType = new HrmsReimbursementTypeModel(m[0], m[1], m[2], m[3]);

				preimbursementType.add(reimbursementType);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<HrmsReimbursementTypeModel> resp = new JsonResponse<HrmsReimbursementTypeModel>();
		resp.setBody(preimbursementType.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<HrmsReimbursementTypeModel>> response = new ResponseEntity<JsonResponse<HrmsReimbursementTypeModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getreimbursementTypeById ends");

		return response;
	}

	/*
	 * for delete reimbursementType
	 */
	public ResponseEntity<JsonResponse<Object>> deletereimbursementTypeById(String id, String createdBy) {

		logger.info("Method in Dao: deletereimbursementTypeById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @P_rembId='" + id + "',@P_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("reimbursementTypeMaster")
					.setParameter("actionType", "deletereimType").setParameter("actionValue", value).execute();

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

		logger.info("Method in Dao: deletereimbursementTypeById ends");

		return response;
	}

}
