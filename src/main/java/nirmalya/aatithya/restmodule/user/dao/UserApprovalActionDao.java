package nirmalya.aatithya.restmodule.user.dao;

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

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.GenerateUserApprovalParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.ServerValidation;
import nirmalya.aatithya.restmodule.user.model.UserApprovalActionModel;

@Repository
public class UserApprovalActionDao {

	Logger logger = LoggerFactory.getLogger(UserApprovalActionDao.class);

	@Autowired
	EntityManager em;

	/*
	 * for all approval details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<UserApprovalActionModel>>> getAllApprovals(DataTableRequest request) {

		logger.info("Method in Dao: getapprovalDetails starts");

		List<UserApprovalActionModel> approvalList = new ArrayList<UserApprovalActionModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("ApprovalAction")
					.setParameter("actionType", "viewApproval").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					UserApprovalActionModel approval = new UserApprovalActionModel(m[0], m[1], m[2], m[3], m[4]);
					approvalList.add(approval);

				}

				if (x.get(0).length > 5) {
					BigInteger t = (BigInteger) x.get(0)[5];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<UserApprovalActionModel>> resp = new JsonResponse<List<UserApprovalActionModel>>();
		resp.setBody(approvalList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<UserApprovalActionModel>>> response = new ResponseEntity<JsonResponse<List<UserApprovalActionModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getapprovalDetails ends");

		return response;
	}

	/*
	 * for add new approval
	 */
	public ResponseEntity<JsonResponse<Object>> addApproval(UserApprovalActionModel approval) {

		logger.info("Method in Dao: addapproval starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (approval.getActName() == null || approval.getActName() == "") {
			resp.setMessage("approval Name required");
			validity = false;
		} else if (approval.getButtonClass() == null || approval.getButtonClass() == "") {
			resp.setMessage("Buttom class  required");
			validity = false;
		} else if (approval.getDescription() == null || approval.getDescription() == "") {
			resp.setMessage("approval description required");
			validity = false;
		} else if (approval.getActStatus() == null) {
			resp.setMessage("approval active required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateUserApprovalParameter.getAddaprovalParam(approval);
				if (approval.getApprovalId() != "" && approval.getApprovalId() != null) {
					em.createNamedStoredProcedureQuery("ApprovalAction").setParameter("actionType", "modifyApproval")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("ApprovalAction").setParameter("actionType", "addApproval")
							.setParameter("actionValue", values).execute();
				}
			} catch (Exception e) {
				e.printStackTrace();
				try {
					String[] err = ServerValidation.geterror(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: addapproval ends");

		return response;
	}

	/*
	 * for edit approval
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<UserApprovalActionModel>> getApprovalById(String id) {

		logger.info("Method in Dao: getapprovalById ends");

		List<UserApprovalActionModel> papproval = new ArrayList<UserApprovalActionModel>();

		try {

			String value = "SET @p_approvalId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("ApprovalAction")
					.setParameter("actionType", "viewEditApproval").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				UserApprovalActionModel approval = new UserApprovalActionModel(m[0], m[1], m[2], m[3], m[4]);

				papproval.add(approval);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<UserApprovalActionModel> resp = new JsonResponse<UserApprovalActionModel>();
		resp.setBody(papproval.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<UserApprovalActionModel>> response = new ResponseEntity<JsonResponse<UserApprovalActionModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getapprovalById ends");

		return response;
	}

	/*
	 * for delete approval
	 */
	public ResponseEntity<JsonResponse<Object>> deleteApprovalById(String id, String createdBy) {

		logger.info("Method in Dao: deleteapprovalById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_approvalId='" + id + "',@p_createdBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("ApprovalAction").setParameter("actionType", "deleteApproval")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
			String[] err = ServerValidation.geterror(e);
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in Dao: deleteapprovalById ends");

		return response;
	}

}
