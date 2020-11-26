package nirmalya.aatithya.restmodule.document.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateDocumentParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.ServerValidation;
import nirmalya.aatithya.restmodule.document.model.RestApprovalHoistoryModel;
import nirmalya.aatithya.restmodule.document.model.RestDocumentModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class RestDocumentDao {
	Logger logger = LoggerFactory.getLogger(RestDocumentDao.class);
	@Autowired
	private EntityManager entityManager;
	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to Add/edit Document
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addDocument(RestDocumentModel restDocumentModel) {
		logger.info("Method : add Document Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (restDocumentModel.getCategory() == null || restDocumentModel.getCategory() == "") {
			resp.setMessage("Category Name required");
			validity = false;
		}
		if (restDocumentModel.getReferenceNo() == null || restDocumentModel.getReferenceNo() == "") {
			resp.setMessage("Reference No. required");
			validity = false;
		}
		if (restDocumentModel.getSubject() == null || restDocumentModel.getSubject() == "") {
			resp.setMessage("Subject required");
			validity = false;
		}
		if (restDocumentModel.getCompanyName() == null || restDocumentModel.getCompanyName() == "") {
			resp.setMessage("Company Name required");
			validity = false;
		}
		if (restDocumentModel.getDocumentImage() == null || restDocumentModel.getDocumentImage() == "") {
			resp.setMessage("Image  required");
			validity = false;
		}
		if (restDocumentModel.getKeyword() == null) {
			resp.setMessage("Keyword  required");
			validity = false;
		}
		if (restDocumentModel.getDescription() == null || restDocumentModel.getDescription() == "") {
			resp.setMessage("Description  required");
			validity = false;
		}
		

		if (validity)
			try {
				String values = GenerateDocumentParameter.addDocumentParam(restDocumentModel);
				System.out.println("values: "+values);
				if (restDocumentModel.getDocument() != null && restDocumentModel.getDocument() != "") {
					entityManager.createNamedStoredProcedureQuery("documentRoutines")
							.setParameter("actionType", "modifyDocument").setParameter("actionValue", values).execute();
				} else {
					entityManager.createNamedStoredProcedureQuery("documentRoutines")
							.setParameter("actionType", "addDocument").setParameter("actionValue", values).execute();
				}

			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : add Document Dao ends");
		return response;
	}

	/**
	 * DAO Function to View all Countries in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestDocumentModel>>> getAllDocument(DataTableRequest request) {
		logger.info("Method : getAllDocument Dao starts");
		List<RestDocumentModel> restDocumentModel = new ArrayList<RestDocumentModel>();

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("documentRoutines")
					.setParameter("actionType", "viewAllDocument").setParameter("actionValue", values).getResultList();
			if(!x.isEmpty()) {
				for (Object[] m : x) {
					RestDocumentModel MstrCtr = new RestDocumentModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8],
						null, m[9], null, null, m[10], null, null,m[11],null);
					restDocumentModel.add(MstrCtr);
				}

				if (x.get(0).length > 12) {
					BigInteger t = (BigInteger) x.get(0)[12];
	
					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestDocumentModel>> resp = new JsonResponse<List<RestDocumentModel>>();
		resp.setBody(restDocumentModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestDocumentModel>>> response = new ResponseEntity<JsonResponse<List<RestDocumentModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllDocument Dao ends");
		System.out.println(response);
		return response;
	}

	/**
	 * DAO Function to get All ItemRequisition in inventory to be approve
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestDocumentModel>>> getAllDocumentApprove(DataTableRequest request) {
		logger.info("Method : getAllDocumentApprove starts");

		List<RestDocumentModel> restDocumentModel = new ArrayList<RestDocumentModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("documentRoutines")
					.setParameter("actionType", "viewAllDocumentToApprove").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					m[10] = Integer.valueOf(((BigInteger) m[10]).toString());
					m[12] = Integer.valueOf(((BigInteger) m[12]).toString());

					RestDocumentModel item = new RestDocumentModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8],
							null, null,null, m[9], m[10], m[11], m[12],null,null);
					restDocumentModel.add(item);
				}

				if (x.get(0).length > 13) {
					BigInteger t = (BigInteger) x.get(0)[13];

					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestDocumentModel>> resp = new JsonResponse<List<RestDocumentModel>>();
		resp.setBody(restDocumentModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestDocumentModel>>> response = new ResponseEntity<JsonResponse<List<RestDocumentModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllDocumentApprove ends");
		System.out.println(response);
		return response;
	}

	/**
	 * DAO Function to View all Countries in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCategory() {
		logger.info("Method : getCategory Dao starts");
		List<DropDownModel> catList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("documentRoutines")
					.setParameter("actionType", "getCategory").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				catList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getCategory Dao ends");
		return catList;
	}
	/**
	 * DAO Function to View all Countries in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getFiles(String id) {
		logger.info("Method : getFiles Dao starts");
		List<DropDownModel> catList = new ArrayList<DropDownModel>();
		String value = "SET @p_document='" + id + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("documentRoutines")
					.setParameter("actionType", "getFiles").setParameter("actionValue",value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				catList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getFiles Dao ends");
		System.out.println(catList);
		return catList;
	}

	/**
	 * DAO Function to edit Document
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestDocumentModel>> getDocumentById(String id) {
		logger.info("Method : getDocumentById Dao starts");
		List<RestDocumentModel> form = new ArrayList<RestDocumentModel>();
		try {
			String value = "SET @p_document='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("documentRoutines")
					.setParameter("actionType", "editDocument").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object fromdate=null;
				fromdate=DateFormatter.returnStringDate(m[9]);
				Object todate=null;
				todate=DateFormatter.returnStringDate(m[13]);
				RestDocumentModel restDocumentModel = new RestDocumentModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], fromdate, m[10] ,m[11], null,null, null, null,m[12],todate);
				form.add(restDocumentModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<RestDocumentModel> resp = new JsonResponse<RestDocumentModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestDocumentModel>> response = new ResponseEntity<JsonResponse<RestDocumentModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getDocumentById Dao ends");
		System.out.println(response);
		return response;
	}
	/**
	 * DAO Function to edit Document
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestApprovalHoistoryModel>>> getDocumentHistoryById(String id) {
		logger.info("Method : getDocumentHistoryById Dao starts");
		List<RestApprovalHoistoryModel> form = new ArrayList<RestApprovalHoistoryModel>();
		try {
			String value = "SET @p_document='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("documentRoutines")
					.setParameter("actionType", "documentHistory").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object fromdate=null;
				fromdate=DateFormatter.returnStringDate(m[9]);
				Object todate=null;
				fromdate=DateFormatter.returnStringDate(m[11]);
				RestApprovalHoistoryModel restApprovalHoistoryModel = new RestApprovalHoistoryModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8],fromdate, m[10], todate);
				form.add(restApprovalHoistoryModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestApprovalHoistoryModel>> resp = new JsonResponse<List<RestApprovalHoistoryModel>>();
		resp.setBody(form);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestApprovalHoistoryModel>>> response = new ResponseEntity<JsonResponse<List<RestApprovalHoistoryModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getDocumentHistoryById Dao ends");
		System.out.println(response);
		return response;
	}
	/**
	 * DAO Function to delete document
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteDocument(String id, String createdBy) {
		logger.info("Method : deleteDocument Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_document='" + id + "',@p_createdBy='" + createdBy + "';";
			entityManager.createNamedStoredProcedureQuery("documentRoutines")
					.setParameter("actionType", "deleteDocument").setParameter("actionValue", value).execute();

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
		logger.info("Method : deleteDocument Dao ends");
		return response;
	}

	/**
	 * DAO Function to save Document Approval Action 
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> saveDocumentApprovalAction(String id,String createdBy) {
		logger.info("Method : saveDocumentApprovalAction starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_document='" + id + "',@p_createdBy='"+createdBy+"';";
			entityManager.createNamedStoredProcedureQuery("documentRoutines")
					.setParameter("actionType", "forwardDocument")
					.setParameter("actionValue", value)
					.execute();

		}catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method : saveDocumentApprovalAction ends");
		return response;
	}

	/**
	 * DAO Function to save Document Reject Action 
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> saveDocumentRejectAction(RestDocumentModel reqobject) {
		logger.info("Method : saveDocumentRejectAction starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_document='" + reqobject.getDocument() +"',@p_rejectComment='"+reqobject.getCategory() + "',@p_createdBy='"+reqobject.getCreatedBy()+"';";
			
			String actionType = "";
			if(reqobject.getReferenceNo().equals("1"))
				actionType = "rejectDocument";
			else if(reqobject.getReferenceNo().equals("2"))
				actionType = "returnDocument";
			else
				actionType = "resubmitDocument";
			
			entityManager.createNamedStoredProcedureQuery("documentRoutines")
					.setParameter("actionType", actionType)
					.setParameter("actionValue", value)
					.execute();

		}catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);
		logger.info("Method : saveDocumentRejectAction ends");
		return response;
	}
	
}
