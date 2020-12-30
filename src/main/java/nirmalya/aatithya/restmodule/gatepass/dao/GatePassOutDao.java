package nirmalya.aatithya.restmodule.gatepass.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GatePassOutParam;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.gatepass.model.GatePassOutModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class GatePassOutDao {

	Logger logger = LoggerFactory.getLogger(GatePassOutDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCustomerForGateOutDao(String id) {
		logger.info("Method : getCustomerForGateOutDao Dao starts");

		List<DropDownModel> vendorList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_searchValue='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePassOutRoutines")
					.setParameter("actionType", "getCustomer").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				vendorList.add(dropDownModel);
			}

			resp.setBody(vendorList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getCustomerForGateOutDao Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getChallanForGateOutDao(String id) {
		logger.info("Method : getChallanForGateOutDao Dao starts");

		List<DropDownModel> vendorList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_searchValue='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePassOutRoutines")
					.setParameter("actionType", "getChallan").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				vendorList.add(dropDownModel);
			}

			resp.setBody(vendorList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getChallanForGateOutDao Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<GatePassOutModel>>> getChallanDetailsDao(String id) {
		logger.info("Method : getChallanDetailsDao Dao starts");

		List<GatePassOutModel> vendorList = new ArrayList<GatePassOutModel>();
		JsonResponse<List<GatePassOutModel>> resp = new JsonResponse<List<GatePassOutModel>>();

		try {
			String value = "SET @p_searchValue='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePassOutRoutines")
					.setParameter("actionType", "getChallanDtls").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				GatePassOutModel dropDownModel = new GatePassOutModel(null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], null, null, m[9], null);
				vendorList.add(dropDownModel);
			}

			resp.setBody(vendorList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<GatePassOutModel>>> response = new ResponseEntity<JsonResponse<List<GatePassOutModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getChallanDetailsDao Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCategoryForGateOutDao(String id) {
		logger.info("Method : getCategoryForGateOutDao Dao starts");

		List<DropDownModel> vendorList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_searchValue='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePassOutRoutines")
					.setParameter("actionType", "getItemCategory").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				vendorList.add(dropDownModel);
			}

			resp.setBody(vendorList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getCategoryForGateOutDao Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSubCatForGateOutDao(DropDownModel id) {
		logger.info("Method : getSubCatForGateOutDao Dao starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_searchValue='" + id.getName() + "', @p_catgeory='" + id.getKey() + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePassOutRoutines")
					.setParameter("actionType", "getSubCat").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemList.add(dropDownModel);
			}

			resp.setBody(itemList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSubCatForGateOutDao Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemForGateOutDao(DropDownModel id) {
		logger.info("Method : getItemForGateOutDao Dao starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_searchValue='" + id.getName() + "', @p_subcatgeory='" + id.getKey() + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePassOutRoutines")
					.setParameter("actionType", "getItem").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemList.add(dropDownModel);
			}

			resp.setBody(itemList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemForGateOutDao Dao ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> newGatePassOutDao(List<GatePassOutModel> gatePass) {
		logger.info("Method : newGatePassOutDao starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (GatePassOutModel l : gatePass) {

			if (l.getStore() == null || l.getStore() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Store Name Required");
				break;
			} else if (l.getItemCode() == null || l.getItemCode() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Item Name Required");
				break;
			} else if (l.getActualNetQty() == null) {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Actual Net Quantity Required");
				break;
			}
		}
		if (validity) {
			try {
				String values = GatePassOutParam.addGateOut(gatePass);

				if (gatePass.get(0).getGatePassOut() != null && gatePass.get(0).getGatePassOut() != "") {
					em.createNamedStoredProcedureQuery("gatePassOutRoutines")
							.setParameter("actionType", "modifyGateOut").setParameter("actionValue", values).execute();
				} else {

					em.createNamedStoredProcedureQuery("gatePassOutRoutines").setParameter("actionType", "addGateOut")
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
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : newGatePassOutDao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<GatePassOutModel>>> getGatePassOutDetailsDao(DataTableRequest request) {
		logger.info("Method : getGatePassOutDetailsDao starts");

		List<GatePassOutModel> gatePass = new ArrayList<GatePassOutModel>();
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

			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePassOutRoutines")
					.setParameter("actionType", "getGateOut").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				Object outDate = null;
				Object outTime = null;

				if (m[5] != null) {
					outDate = DateFormatter.returnStringDate(m[5]);
				}
				if (m[6] != null) {
					outTime = DateFormatter.returnStringTime(m[6]);
				}

				GatePassOutModel dd = new GatePassOutModel(m[0], null, m[1], m[2], m[3], m[4], outDate, outTime, m[7],
						m[8], m[9], m[10], null, m[11], m[12], m[13], null, null, null, null, null, null, null, null,
						null, m[14], null, null, m[15]);
				gatePass.add(dd);
			}
			if (x.size() > 0) {
				if (x.get(0).length > 16) {
					BigInteger t = (BigInteger) x.get(0)[16];

					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<GatePassOutModel>> resp = new JsonResponse<List<GatePassOutModel>>();
		resp.setBody(gatePass);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<GatePassOutModel>>> response = new ResponseEntity<JsonResponse<List<GatePassOutModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getGatePassOutDetailsDao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<GatePassOutModel> editGatePassOutDao(String id) {
		logger.info("Method : editGatePassOutDao starts");

		List<GatePassOutModel> gatePass = new ArrayList<GatePassOutModel>();
		String value = "SET @p_gatePassId='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePassOutRoutines")
					.setParameter("actionType", "editGateOut").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object outDate = null;
				Object outTime = null;
				if (m[5] != null) {
					outDate = DateFormatter.returnStringDate(m[5]);
				}
				if (m[6] != null) {
					outTime = DateFormatter.returnStringTime(m[6]);
				}
				GatePassOutModel dd = new GatePassOutModel(m[0], m[1], null, m[2], m[3], m[4], outDate, outTime, m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21],
						m[22], m[23], m[24], null, m[25], m[26]);
				gatePass.add(dd);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editGatePassOutDao ends");
		return gatePass;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<GatePassOutModel>>> modalGatePassOutDao(String id) {
		logger.info("Method : modalGatePassOutDao starts");

		List<GatePassOutModel> gatePass = new ArrayList<GatePassOutModel>();
		JsonResponse<List<GatePassOutModel>> resp = new JsonResponse<List<GatePassOutModel>>();
		try {

			String value = "SET @p_gatePassId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePassOutRoutines")
					.setParameter("actionType", "modalGateOut").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object outDate = null;
				Object outTime = null;
				if (m[5] != null) {
					outDate = DateFormatter.returnStringDate(m[5]);
				}
				if (m[6] != null) {
					outTime = DateFormatter.returnStringTime(m[6]);
				}
				GatePassOutModel dd = new GatePassOutModel(m[0], m[1], null, m[2], m[3], m[4], outDate, outTime, m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21],
						m[22], m[23], m[24], null, m[25], m[26]);
				gatePass.add(dd);
			}

			resp.setBody(gatePass);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<GatePassOutModel>>> response = new ResponseEntity<JsonResponse<List<GatePassOutModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : modalGatePassOutDao ends");
		return response;
	}
}
