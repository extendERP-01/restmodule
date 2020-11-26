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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GeneratePolicyMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.reimbursement.model.HrmsPolicyMasterModel;

@Repository
public class HrmsPolicyMasterDao {
	Logger logger = LoggerFactory.getLogger(HrmsPolicyMasterDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for all policyType details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsPolicyMasterModel>>> getpolicyTypeDetails(DataTableRequest request) {

		logger.info("Method in Dao: getpolicyTypeDetails starts");

		List<HrmsPolicyMasterModel> employementList = new ArrayList<HrmsPolicyMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("policyTypeMaster")
					.setParameter("actionType", "viewPolicyList").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					HrmsPolicyMasterModel employement = new HrmsPolicyMasterModel(m[0], m[1], m[2], m[3], m[4], m[5],
							m[6], m[7], m[8],m[9],m[10]);
					employementList.add(employement);

				}

				if (x.get(0).length > 11) {
					BigInteger t = (BigInteger) x.get(0)[11];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsPolicyMasterModel>> resp = new JsonResponse<List<HrmsPolicyMasterModel>>();
		resp.setBody(employementList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsPolicyMasterModel>>> response = new ResponseEntity<JsonResponse<List<HrmsPolicyMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getpolicyTypeDetails ends");

		return response;
	}

	/*
	 * for add new policyType
	 */
	public ResponseEntity<JsonResponse<Object>> addpolicyType(HrmsPolicyMasterModel policyType) {

		logger.info("Method in Dao: addpolicyType starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (policyType.getReimType() == null || policyType.getReimType() == "") {
			resp.setMessage("policyType Name required");
			validity = false;
		} else if (policyType.getDesc() == null || policyType.getDesc() == "") {
			resp.setMessage("Policy description required");
			validity = false;
		} else if (policyType.getStatus() == null) {
			resp.setMessage("Policy Status required");
			validity = false;
		} else if (policyType.getPolicyName() == null || policyType.getPolicyName() == "") {
			resp.setMessage("Policy Name required");
			validity = false;
		} else if (policyType.getTimePeriod() == null || policyType.getTimePeriod() == "") {
			resp.setMessage("Time Period required");
			validity = false;
		}

		if (validity)
			try {
				String values = GeneratePolicyMasterParameter.getAddPolicyTypeParam(policyType);
				System.out.println(values);
				if (policyType.getPolicyId() != "") {
					em.createNamedStoredProcedureQuery("policyTypeMaster").setParameter("actionType", "modifyPolicy")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("policyTypeMaster").setParameter("actionType", "addPolicyType")
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

		logger.info("Method in Dao: addpolicyType ends");

		return response;
	}

	/*
	 * for edit policyType
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<HrmsPolicyMasterModel>> getpolicyTypeById(String id) {

		logger.info("Method in Dao: getpolicyTypeById ends");

		List<HrmsPolicyMasterModel> ppolicyType = new ArrayList<HrmsPolicyMasterModel>();

		try {

			String value = "SET @P_policyId='" + id + "';";
System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("policyTypeMaster")
					.setParameter("actionType", "viewEditPolicyType").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				HrmsPolicyMasterModel policyType = new HrmsPolicyMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8],m[9],m[10]);

				ppolicyType.add(policyType);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<HrmsPolicyMasterModel> resp = new JsonResponse<HrmsPolicyMasterModel>();
		resp.setBody(ppolicyType.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<HrmsPolicyMasterModel>> response = new ResponseEntity<JsonResponse<HrmsPolicyMasterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getpolicyTypeById ends");

		return response;
	}

	/*
	 * for delete policyType
	 */
	public ResponseEntity<JsonResponse<Object>> deletepolicyTypeById(String id, String createdBy) {

		logger.info("Method in Dao: deletepolicyTypeById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @P_policyId='" + id + "',@P_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("policyTypeMaster").setParameter("actionType", "deletePolicy")
					.setParameter("actionValue", value).execute();

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

		logger.info("Method in Dao: deletepolicyTypeById ends");

		return response;
	}

	/**
	 * for reimbursement type list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getReimbTypeListForPolicy() {

		logger.info("Method : getReimbTypeListForPolicy starts");

		List<DropDownModel> reqisitionList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("policyTypeMaster")
					.setParameter("actionType", "getReimbForPolicy").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				reqisitionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getReimbTypeListForPolicy ends");

		return reqisitionList;
	}

	/**
	 * for time period list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getTimePeriod() {

		logger.info("Method : getTimePeriod starts");

		List<DropDownModel> reqisitionList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("policyTypeMaster")
					.setParameter("actionType", "getTimePeriod").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				reqisitionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTimePeriod ends");

		return reqisitionList;
	}
	/**
	 * for time period list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getUserRole() {

		logger.info("Method : getUserRole starts");

		List<DropDownModel> reqisitionList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("policyTypeMaster")
					.setParameter("actionType", "getUserRole").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				reqisitionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getUserRole ends");

		return reqisitionList;
	}

}
