package nirmalya.aatithya.restmodule.inventory.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateMultipleGRNParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.GRNListModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class MultipleInvoiceDao {

	Logger logger = LoggerFactory.getLogger(MultipleInvoiceDao.class);
	
	@Autowired
	ServerDao serverDao;
	
	@Autowired
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorSearchListForGRN(String id) {
		logger.info("Method : getVendorSearchListForGRN Dao starts");

		List<DropDownModel> poList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_searchValue='" + id + "';";
			System.out.println("dearch value " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("multipleGRNRoutines")
					.setParameter("actionType", "getVendor").setParameter("actionValue", value).getResultList();

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

		logger.info("Method : getVendorSearchListForGRN Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPOAutoSearchListForGRN(String id, String value) {
		logger.info("Method : getPOAutoSearchListForGRN Dao starts");

		List<DropDownModel> poList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String values = "SET @p_searchValue='" + value + "', @p_id='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("multipleGRNRoutines")
					.setParameter("actionType", "getPO").setParameter("actionValue", values).getResultList();

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

		logger.info("Method : getPOAutoSearchListForGRN Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getGRNListByVendor(String id) {
		logger.info("Method : getGRNListByVendor Dao starts");

		List<DropDownModel> poList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_searchValue='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("multipleGRNRoutines")
					.setParameter("actionType", "getGRNList").setParameter("actionValue", value).getResultList();

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
		System.out.println(response);
		logger.info("Method : getGRNListByVendor Dao ends");
		return response;
	}

//	@SuppressWarnings("unchecked")
//	public List<GRNListModel> grnReturnData(DropDownModel id) {
//		logger.info("Method : grnReturnData starts");
//
//		List<GRNListModel> store = new ArrayList<GRNListModel>();
//		String value = "SET @p_id='" + id + "';";
//		System.out.println(value);
//		try {
//			List<Object[]> x = em.createNamedStoredProcedureQuery("multipleGRNRoutines")
//					.setParameter("actionType", "GRNReturnDetails").setParameter("actionValue", value).getResultList();
//
//			for (Object[] m : x) {
//				GRNListModel dropDownModel = new GRNListModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], null,
//						null, null, null, null, null, null ,null);
//				store.add(dropDownModel);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		logger.info("Method : grnReturnData ends");
//		return store;
//	}

//	@SuppressWarnings("unchecked")
//	public List<GRNListModel> getGRNReturnListDetails(String id) {
//		logger.info("Method : getGRNReturnListDetails starts");
//
//		List<GRNListModel> store = new ArrayList<GRNListModel>();
//		String value = "SET @p_id='" + id + "';";
//		try {
//			List<Object[]> x = em.createNamedStoredProcedureQuery("multipleGRNRoutines")
//					.setParameter("actionType", "GRNReturnDetails").setParameter("actionValue", value).getResultList();
//
//			for (Object[] m : x) {
//				GRNListModel dropDownModel = new GRNListModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], null,
//						null, null, null, null, null, null ,null);
//				store.add(dropDownModel);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		logger.info("Method : getGRNReturnListDetails ends");
//		return store;
//	}

	public ResponseEntity<JsonResponse<Object>> addMultipleGRN(GRNListModel grn) {
		logger.info("Method : addMultipleGRN starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (grn.getInvDate() == null || grn.getInvDate() == "") {
			validity = false;
			resp.setCode("Field Validation Error");
			resp.setMessage("Invoice Date Required");
		} else if (grn.getInvNo() == null || grn.getInvNo() == "") {
			validity = false;
			resp.setCode("Field Validation Error");
			resp.setMessage("Invoice Number Required");
		}

		if (validity) {
			try {
				String values = GenerateMultipleGRNParameter.addInvoice(grn);

				em.createNamedStoredProcedureQuery("multipleGRNRoutines").setParameter("actionType", "addMultInv")
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
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addMultipleGRN ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<GRNListModel>>> getGRNListDetails(List<DropDownModel> id) {
		logger.info("Method : getGRNListDetails starts");

		List<GRNListModel> store = new ArrayList<GRNListModel>();

		String s = "SET @p_id='(";
		String a = "";
		for (DropDownModel m : id) {
			a = a + "\"" + m.getKey() + "\",";
		}
		if (a != "") {
			a = a.substring(0, a.length() - 1);
		}
		s = s + a + ")';";
		System.out.println(s);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("multipleGRNRoutines")
					.setParameter("actionType", "GRNDetails").setParameter("actionValue", s).getResultList();

			for (Object[] m : x) {
				GRNListModel dropDownModel = new GRNListModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], null,
						null, null, null, null, null, null ,null,m[8],m[9],m[10],null);
				store.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<GRNListModel>> resp = new JsonResponse<List<GRNListModel>>();
		resp.setBody(store);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<GRNListModel>>> response = new ResponseEntity<JsonResponse<List<GRNListModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		System.out.println(response);

		logger.info("Method : getGRNListDetails ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<GRNListModel>>> grnReturnData(List<DropDownModel> id) {
		logger.info("Method : grnReturnData starts");
		
		List<GRNListModel> store = new ArrayList<GRNListModel>();
		
		String s = "SET @p_id='(";
		String a = "";
		for (DropDownModel m : id) {
			a = a + "\"" + m.getKey() + "\",";
		}
		if (a != "") {
			a = a.substring(0, a.length() - 1);
		}
		s = s + a + ")';";
		System.out.println(s);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("multipleGRNRoutines")
					.setParameter("actionType", "GRNReturnDetails").setParameter("actionValue", s).getResultList();
			
			for (Object[] m : x) {
				GRNListModel dropDownModel = new GRNListModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], null,
						null, null, null, null, null, null ,null,null,m[8],m[9],null);
				store.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonResponse<List<GRNListModel>> resp = new JsonResponse<List<GRNListModel>>();
		resp.setBody(store);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<GRNListModel>>> response = new ResponseEntity<JsonResponse<List<GRNListModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		System.out.println(response);
		
		logger.info("Method : grnReturnData ends");
		return response;
	}
}
