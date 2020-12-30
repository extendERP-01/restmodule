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
import nirmalya.aatithya.restmodule.common.utils.GenerateGatePassEntryParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.gatepass.model.GatePassEntryModel;
import nirmalya.aatithya.restmodule.gatepass.model.GatePassItemModel;
import nirmalya.aatithya.restmodule.sales.model.QuotationMasterModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class GatePassEntryDao {

	Logger logger = LoggerFactory.getLogger(GatePassEntryDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStoreForGatePassEntryDao(String id) {
		logger.info("Method : getStoreForGatePassEntryDao starts");

		List<DropDownModel> store = new ArrayList<DropDownModel>();

		try {
			String values = "SET @p_Userid='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePassEntryRoutines")
					.setParameter("actionType", "getStore").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				store.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getStoreForGatePassEntryDao ends");
		return store;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCustomerForGatePassEntryDao(String id) {
		logger.info("Method : getCustomerForGatePassEntryDao Dao starts");

		List<DropDownModel> vendorList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_searchValue='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePassEntryRoutines")
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

		logger.info("Method : getCustomerForGatePassEntryDao Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPOAutoSearchForGatePassEntryDao(String id ,String store) {
		logger.info("Method : getPOAutoSearchForGatePassEntryDao Dao starts");

		List<DropDownModel> poList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_searchValue='" + id + "',@p_storeId='"+ store + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePassEntryRoutines")
					.setParameter("actionType", "getPOrderList").setParameter("actionValue", value).getResultList();

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

		logger.info("Method : getPOAutoSearchForGatePassEntryDao Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemForGatePassEntryDao(DropDownModel id) {
		logger.info("Method : getItemForGatePassEntryDao Dao starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			if (id.getKey() != "" && id.getKey() != null) {
				String value = "SET @p_searchValue='" + id.getName() + "', @p_purchaseOrder='" + id.getKey() + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("gatePassEntryRoutines")
						.setParameter("actionType", "getItemPO").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					itemList.add(dropDownModel);
				}
			} else {
				String value = "SET @p_searchValue='" + id.getName() + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("gatePassEntryRoutines")
						.setParameter("actionType", "getItem").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					itemList.add(dropDownModel);
				}
			}

			resp.setBody(itemList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemForGatePassEntryDao Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<GatePassItemModel>>> getServeTypeForGatePassEntryDao(String id) {
		logger.info("Method : getServeTypeForGatePassEntryDao Dao starts");

		List<GatePassItemModel> serveType = new ArrayList<GatePassItemModel>();
		JsonResponse<List<GatePassItemModel>> resp = new JsonResponse<List<GatePassItemModel>>();

		try {
			String value = "SET @p_item='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePassEntryRoutines")
					.setParameter("actionType", "getServeType").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				GatePassItemModel dropDownModel = new GatePassItemModel(null, null, m[0], m[1], m[2], m[3], null, null,
						null);
				serveType.add(dropDownModel);
			}

			resp.setBody(serveType);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<GatePassItemModel>>> response = new ResponseEntity<JsonResponse<List<GatePassItemModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getServeTypeForGatePassEntryDao Dao ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> newGatePassEntrySaveDao(List<GatePassEntryModel> gatePass) {
		logger.info("Method : newGatePassEntrySaveDao starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (GatePassEntryModel l : gatePass) {

			if (l.getEntryDate() == null || l.getEntryDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Entry Date Required");
				break;
			} else if (l.getEntryTime() == null || l.getEntryTime() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Entry Time Required");
				break;
			} else if (l.getStore() == null || l.getStore() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Store Name Required");
				break;
			} else if (l.getItemCode() == null || l.getItemCode() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Item Name Required");
				break;
			} else if (l.getClientNetQty() == null) {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Client Net Quantity Required");
				break;
			} else if (l.getActualNetQty() == null) {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Actual Net Quantity Required");
				break;
			}
		}
		if (Boolean.TRUE.equals(validity)) {
			try {
				String values = GenerateGatePassEntryParameter.newGatePassEntry(gatePass);

				if (gatePass.get(0).getGatePass() != null && gatePass.get(0).getGatePass() != "") {
					em.createNamedStoredProcedureQuery("gatePassEntryRoutines")
							.setParameter("actionType", "modifyGatePass").setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("gatePassEntryRoutines")
							.setParameter("actionType", "addGatePassEntry").setParameter("actionValue", values)
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
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : newGatePassEntrySaveDao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<GatePassEntryModel>>> getGatePassEntryDetailsDao(DataTableRequest request) {
		logger.info("Method : getGatePassEntryDetailsDao starts");

		List<GatePassEntryModel> gatePass = new ArrayList<GatePassEntryModel>();
		if (request.getParam4() != null && request.getParam4() != "") {
			String param4 = DateFormatter.getStringDate(request.getParam4());
			request.setParam4(param4);
		}
		if (request.getParam5() != null && request.getParam5() != "") {
			String param5 = DateFormatter.getStringDate(request.getParam5());
			request.setParam5(param5);
		}
		String values = GenerateParameter.getSearchParam(request);
		System.out.println("value = " + values);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePassEntryRoutines")
					.setParameter("actionType", "getGatePass").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				Object entryDate = null;
				Object entryTime = null;
				Object exitTime = null;
				if (m[2] != null) {
					entryDate = DateFormatter.returnStringDate(m[2]);
				}
				if (m[3] != null) {
					entryTime = DateFormatter.returnStringTime(m[3]);
				}
				if (m[15] != null) {
					exitTime = DateFormatter.returnStringTime(m[15]);
				}

				GatePassEntryModel gp = new GatePassEntryModel(m[0], m[1], entryDate, entryTime, m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], exitTime, null, null, null, null, null, null,
						null, null, null, null, null, null, m[16], null, null, null);
				gatePass.add(gp);
			}
			if (!x.isEmpty()) {
				if(x.get(0).length > 17) {
					BigInteger t = (BigInteger) x.get(0)[17];

					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<GatePassEntryModel>> resp = new JsonResponse<List<GatePassEntryModel>>();
		resp.setBody(gatePass);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<GatePassEntryModel>>> response = new ResponseEntity<JsonResponse<List<GatePassEntryModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getGatePassEntryDetailsDao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<GatePassItemModel> editGatePassEntryPODtlsDao(String id) {
		logger.info("Method : editGatePassEntryPODtlsDao starts");

		List<GatePassItemModel> item = new ArrayList<GatePassItemModel>();

		try {
			String value = "SET @p_purchaseOrder='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePassEntryRoutines")
					.setParameter("actionType", "getItemDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				GatePassItemModel gatePassItemModel = new GatePassItemModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8]);
				item.add(gatePassItemModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editGatePassEntryPODtlsDao ends");
		return item;
	}

	@SuppressWarnings("unchecked")
	public List<GatePassEntryModel> editGatePassEntryDao(String id) {
		logger.info("Method : editGatePassEntryDao starts");

		List<GatePassEntryModel> gatePass = new ArrayList<GatePassEntryModel>();
		String value = "SET @p_gatePassId='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePassEntryRoutines")
					.setParameter("actionType", "editGatePass").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object entryDate = null;
				Object entryTime = null;
				Object exitTime = null;
				if (m[2] != null) {
					entryDate = DateFormatter.returnStringDate(m[2]);
				}
				if (m[3] != null) {
					entryTime = DateFormatter.returnStringTime(m[3]);
				}
				if (m[15] != null) {
					exitTime = DateFormatter.returnStringTime(m[15]);
				}
				GatePassEntryModel gp = new GatePassEntryModel(m[0], m[1], entryDate, entryTime, m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], exitTime, m[16], m[17], m[18], m[19], m[20],
						m[21], m[22], m[23], m[24], m[25], m[26], m[27], null, m[28], m[29], m[30]);
				gatePass.add(gp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editGatePassEntryDao ends");
		System.out.println("gatePass data are " + gatePass);
		return gatePass;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<GatePassEntryModel>>> getGatePassEntryByIdDao(String id) {
		logger.info("Method : getGatePassEntryByIdDao starts");

		List<GatePassEntryModel> gatePass = new ArrayList<GatePassEntryModel>();
		JsonResponse<List<GatePassEntryModel>> resp = new JsonResponse<List<GatePassEntryModel>>();
		try {

			String value = "SET @p_gatePassId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePassEntryRoutines")
					.setParameter("actionType", "modalGatePass").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object entryDate = null;
				Object entryTime = null;
				Object exitTime = null;
				if (m[2] != null) {
					entryDate = DateFormatter.returnStringDate(m[2]);
				}
				if (m[3] != null) {
					entryTime = DateFormatter.returnStringTime(m[3]);
				}
				if (m[15] != null) {
					exitTime = DateFormatter.returnStringTime(m[15]);
				}
				GatePassEntryModel gp = new GatePassEntryModel(m[0], m[1], entryDate, entryTime, m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], exitTime, m[16], m[17], m[18], m[19], m[20],
						m[21], m[22], m[23], m[24], m[25], m[26], m[27], null, m[28], m[29], m[30]);
				gatePass.add(gp);
			} 

			resp.setBody(gatePass);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<GatePassEntryModel>>> response = new ResponseEntity<JsonResponse<List<GatePassEntryModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getGatePassEntryByIdDao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<GatePassItemModel>>> getItemDetailsByPOrder(String id) {
		logger.info("Method : getItemDetailsByPOrder Dao starts");

		List<GatePassItemModel> item = new ArrayList<GatePassItemModel>();
		JsonResponse<List<GatePassItemModel>> resp = new JsonResponse<List<GatePassItemModel>>();

		try {
			String value = "SET @p_purchaseOrder='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePassEntryRoutines")
					.setParameter("actionType", "getItemDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				GatePassItemModel dropDownModel = new GatePassItemModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8]);
				item.add(dropDownModel);
			}

			resp.setBody(item);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<GatePassItemModel>>> response = new ResponseEntity<JsonResponse<List<GatePassItemModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemDetailsByPOrder Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getHotelLogo(String logoType) {
		logger.info("Method : getHotelLogo starts");

		List<DropDownModel> logoList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_logoType='" + logoType + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("logoImageRoutines")
					.setParameter("actionType", "getHotelLogo").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				logoList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getHotelLogo ends");
		return logoList;
	}
	
	/**
	 * DAO - Get Hotel List
	 * 
	 * @param id
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<QuotationMasterModel> restGetStoreDetails(String id) {
		logger.info("Method : restGetStoreDetails starts");

		List<QuotationMasterModel> hotelList = new ArrayList<QuotationMasterModel>();
		String value = "SET @p_storeId='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePassEntryRoutines")
					.setParameter("actionType", "getStoreDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				QuotationMasterModel dropDownModel = new QuotationMasterModel(null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, m[0], m[1], m[2], m[3], m[4], null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null,null);
				hotelList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : restGetStoreDetails ends");

		return hotelList;
	}
	

}
