package nirmalya.aatithya.restmodule.asset.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.asset.model.AssetPolicyMaster;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAssetPolicyMasterParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.HrmsEmployeEducationDao;

@Repository
public class AssetPolicyMasterDao {
	Logger logger = LoggerFactory.getLogger(HrmsEmployeEducationDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getFreqList() {

		logger.info("Method : getFreqList starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPolicy")
					.setParameter("actionType", "getFreqList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getFreqList ends");

		return employmentList;
	}

	/*
	 * Drop down for job type list
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemDetailsAutoSearch(String vechileNo) {

		logger.info("Method : getItemDetailsAutoSearch starts");

		List<DropDownModel> saleOrderList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_itemSearch='" + vechileNo + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPolicy")
					.setParameter("actionType", "getItemDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel salesOrder = new DropDownModel(m[0], m[1]);
				saleOrderList.add(salesOrder);
			}
			resp.setBody(saleOrderList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getItemDetailsAutoSearch ends");
		return response;
	}

	/*
	 * Drop down for job type list
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getOptionValue() {

		logger.info("Method : getOptionValue starts");

		List<DropDownModel> saleOrderList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPolicy")
					.setParameter("actionType", "getFreqList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel salesOrder = new DropDownModel(m[0], m[1]);
				saleOrderList.add(salesOrder);
			}
			resp.setBody(saleOrderList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getItemDetailsAutoSearch ends");
		return response;
	}

	/*
	 * for add other service price
	 */
	public ResponseEntity<JsonResponse<Object>> restAddPolicy(List<AssetPolicyMaster> assetPolicyMaster) {

		logger.info("Method in Dao: restAddPolicy starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		// Integer id = assetPolicyMaster.get(0).getPolicyId();

		for (AssetPolicyMaster a : assetPolicyMaster) {
			if (a.getItemId() == null || a.getItemId() == "") {
				resp.setMessage("Item Name not Selected");
				validity = false;
			} else if (a.getFreqId() == null || a.getFreqId() == "") {
				resp.setMessage(" Frequency id not Selected");
				validity = false;
			} else if (a.getServiceName() == null) {
				resp.setMessage("Service Can not b left blank");
				validity = false;
			} else if (a.getTaskPerform() == null) {
				resp.setMessage("Task performed.");
				validity = false;
			}

		}
		if (validity)
			try {
				String values = GenerateAssetPolicyMasterParam.getAddPolicyParam(assetPolicyMaster);

				em.createNamedStoredProcedureQuery("assetPolicy").setParameter("actionType", "addAssetPolicy")
						.setParameter("actionValue", values).execute();

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

		logger.info("Method in Dao: restAddPolicy ends");

		return response;
	}

	/*
	 * Drop down for trip details
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AssetPolicyMaster>>> getServiceDetails(String itemId) {

		logger.info("Method : getServiceDetails starts");

		List<AssetPolicyMaster> saleOrderList = new ArrayList<AssetPolicyMaster>();
		JsonResponse<List<AssetPolicyMaster>> resp = new JsonResponse<List<AssetPolicyMaster>>();

		try {
			String value = "SET @p_itemId='" + itemId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPolicy")
					.setParameter("actionType", "getServiceDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				AssetPolicyMaster saleOder = new AssetPolicyMaster(m[0], m[1], m[2], m[3], m[4], m[5], m[6]);
				saleOrderList.add(saleOder);
			}

			resp.setBody(saleOrderList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPolicy")
					.setParameter("actionType", "getFreqList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		saleOrderList.get(0).setOption(employmentList);
		ResponseEntity<JsonResponse<List<AssetPolicyMaster>>> response = new ResponseEntity<JsonResponse<List<AssetPolicyMaster>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getServiceDetails ends");
		return response;
	}

}
