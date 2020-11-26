package nirmalya.aatithya.restmodule.recruitment.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateVendorSourcingParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.recruitment.model.ResourceModel;

@Repository
public class ResourceDao {

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	Logger logger = LoggerFactory.getLogger(ResourceDao.class);

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ResourceModel>>> getResource() {

		logger.info("Method : getResource starts");

		List<ResourceModel> resource = new ArrayList<ResourceModel>();
		Integer total = 0;

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("resourceRoutines")
					.setParameter("actionType", "viewResource").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				Object sDate = null;
				if (m[8] != null) {
					sDate = DateFormatter.returnStringDate(m[8]);
				}
				ResourceModel resourceModel = new ResourceModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], sDate,
						m[9], null, null, m[10], null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null);
				resource.add(resourceModel);

			}

			if (x.size() > 0) {

				if (x.get(0).length > 11) {
					BigInteger t = (BigInteger) x.get(0)[11];

					total = Integer.parseInt((t.toString()));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ResourceModel>> resp = new JsonResponse<List<ResourceModel>>();
		resp.setBody(resource);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ResourceModel>>> response = new ResponseEntity<JsonResponse<List<ResourceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getResource ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ResourceModel>> getDetails(String id) {
		logger.info("Method : getDetails starts");

		List<ResourceModel> vendorList = new ArrayList<ResourceModel>();
		JsonResponse<ResourceModel> resp = new JsonResponse<ResourceModel>();

		try {

			String value = "SET @p_id='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("resourceRoutines")
					.setParameter("actionType", "getDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object sDate = null;
				if (m[6] != null) {
					sDate = DateFormatter.returnStringDate(m[6]);
				}
				ResourceModel vendor = new ResourceModel(m[0], m[1], m[2], m[3], null, m[4], null, m[5], sDate, m[7],
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null);
				vendorList.add(vendor);
			}
			resp.setBody(vendorList.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<ResourceModel>> response = new ResponseEntity<JsonResponse<ResourceModel>>(resp,
				responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getDetails ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getVendorList() {

		logger.info("Method : getVendorList starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("resourceRoutines")
					.setParameter("actionType", "getVendor").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getVendorList ends");

		return employmentList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getVendorSelected(String id) {

		logger.info("Method : getVendorSelected starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();
		String value = "SET @p_id='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("resourceRoutines")
					.setParameter("actionType", "getVendorSelected").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getVendorSelected ends");

		return employmentList;
	}

	public ResponseEntity<JsonResponse<Object>> setVendor(ResourceModel index) {
		logger.info("Method : setVendor Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");

		try {
			String value = GenerateVendorSourcingParameter.addVendor(index);

			em.createNamedStoredProcedureQuery("resourceRoutines").setParameter("actionType", "setVendor")
					.setParameter("actionValue", value).execute();

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

		logger.info("Method : setVendor Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ResourceModel>>> getShortList() {

		logger.info("Method : getShortList starts");

		List<ResourceModel> resource = new ArrayList<ResourceModel>();
		Integer total = 0;

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("resourceRoutines")
					.setParameter("actionType", "viewShortList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				Object sDate = null;
				if (m[8] != null) {
					sDate = DateFormatter.returnStringDate(m[8]);
				}
				ResourceModel resourceModel = new ResourceModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], sDate,
						m[9], null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null);
				resource.add(resourceModel);

			}

			if (x.size() > 0) {

				if (x.get(0).length > 10) {
					BigInteger t = (BigInteger) x.get(0)[10];

					total = Integer.parseInt((t.toString()));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ResourceModel>> resp = new JsonResponse<List<ResourceModel>>();
		resp.setBody(resource);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ResourceModel>>> response = new ResponseEntity<JsonResponse<List<ResourceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getShortList ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addShortListCandidate(List<ResourceModel> candidate) {
		logger.info("Method : addShortListCandidate starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (ResourceModel l : candidate) {
			if (l.getVendorId() == null || l.getVendorId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Vendor Name Required");
				break;
			} else if (l.getCandidateName() == null || l.getCandidateName() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Candidate Name Required");
				break;
			} else if (l.getFatherName() == null || l.getFatherName() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Father Name Required");
				break;
			} else if (l.getDob() == null || l.getDob() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("DOB Required");
				break;
			}
		}

		if (validity) {
			try {
				String values = GenerateVendorSourcingParameter.addShortList(candidate);

				em.createNamedStoredProcedureQuery("resourceRoutines").setParameter("actionType", "addShortList")
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
		logger.info("Method : addShortListCandidate ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ResourceModel>>> getList() {

		logger.info("Method : getList starts");

		List<ResourceModel> resource = new ArrayList<ResourceModel>();
		Integer total = 0;

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("resourceRoutines")
					.setParameter("actionType", "viewList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				Object sDate = null;
				if (m[7] != null) {
					sDate = DateFormatter.returnStringDate(m[7]);
				}
				ResourceModel resourceModel = new ResourceModel(m[0], m[1], m[2], null, m[3], m[4], null, null, null,
						null, null, null, null, null, m[5], m[6], sDate, null, null, m[8], m[9], null, null, null, null,
						null, null, null, null, null);
				resource.add(resourceModel);

			}

			if (x.size() > 0) {

				if (x.get(0).length > 10) {
					BigInteger t = (BigInteger) x.get(0)[10];

					total = Integer.parseInt((t.toString()));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ResourceModel>> resp = new JsonResponse<List<ResourceModel>>();
		resp.setBody(resource);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ResourceModel>>> response = new ResponseEntity<JsonResponse<List<ResourceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getList ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ResourceModel>>> getEmpList() {

		logger.info("Method : getEmpList starts");

		List<ResourceModel> employmentList = new ArrayList<ResourceModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("resourceRoutines")
					.setParameter("actionType", "getEmployee").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				ResourceModel employee = new ResourceModel(null, m[0], m[1], null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, m[2], m[3], null, null, null, null, null, null, null,
						null, null, null, null);
				employmentList.add(employee);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ResourceModel>> resp = new JsonResponse<List<ResourceModel>>();
		resp.setBody(employmentList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ResourceModel>>> response = new ResponseEntity<JsonResponse<List<ResourceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getEmpList ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addHold(ResourceModel index) {
		logger.info("Method : addHold Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");

		try {
			String value = "SET @p_candId='" + index.getCandidateId() + "', @p_status='" + index.getStatus() + "';";

			em.createNamedStoredProcedureQuery("resourceRoutines").setParameter("actionType", "addHold")
					.setParameter("actionValue", value).execute();

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

		logger.info("Method : addHold Dao ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addShortListInterview(ResourceModel index) {
		logger.info("Method : addShortListInterview Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");

		try {
			String value = GenerateVendorSourcingParameter.addShortListInterview(index);

			em.createNamedStoredProcedureQuery("resourceRoutines").setParameter("actionType", "addInterview")
					.setParameter("actionValue", value).execute();

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

		logger.info("Method : addShortListInterview Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ResourceModel>>> getInterviewerDtls(String id) {

		logger.info("Method : getInterviewerDtls starts");

		List<ResourceModel> employmentList = new ArrayList<ResourceModel>();
		String value = "SET @p_id='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("resourceRoutines")
					.setParameter("actionType", "getInterviewerDtls").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				Object sDate1 = null;
				if (m[0] != null) {
					sDate1 = DateFormatter.returnStringDate(m[0]);
				}

				ResourceModel employee = new ResourceModel(null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, sDate1, m[1], null, null, m[2], m[3], m[4], null, null,
						null, null, null, null, null);
				employmentList.add(employee);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ResourceModel>> resp = new JsonResponse<List<ResourceModel>>();
		resp.setBody(employmentList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ResourceModel>>> response = new ResponseEntity<JsonResponse<List<ResourceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getInterviewerDtls ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getJobTitleList() {

		logger.info("Method : getJobTitleList starts");

		List<DropDownModel> jobTitleList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("resourceRoutines")
					.setParameter("actionType", "getJobTitleList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				jobTitleList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getJobTitleList ends");

		return jobTitleList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ResourceModel>>> getAllDetails(String id) {
		logger.info("Method : getAllDetails starts");

		List<ResourceModel> struct = new ArrayList<ResourceModel>();
		// String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			String value = "SET @p_empId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("resourceRoutines")
					.setParameter("actionType", "viewAllDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object sDate1 = null;
				if (m[5] != null) {
					sDate1 = DateFormatter.returnStringDate(m[5]);
				}
				ResourceModel structModel = new ResourceModel(m[0], m[1], m[2], null, null, null, null, null, null,
						null, null, null, null, null, m[3], m[4], sDate1, null, null, m[6], m[7], m[8], null, null,
						null, null, null, null, null, null);
				struct.add(structModel);
			}

			if (x.size() > 0) {

				if (x.get(0).length > 9) {
					BigInteger t = (BigInteger) x.get(0)[9];

					total = Integer.parseInt((t.toString()));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ResourceModel>> resp = new JsonResponse<List<ResourceModel>>();
		resp.setBody(struct);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ResourceModel>>> response = new ResponseEntity<JsonResponse<List<ResourceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getAllDetails ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ResourceModel>>> editFeedbackDetails(String id, String index) {
		logger.info("Method : editFeedbackDetails starts");

		List<ResourceModel> vendorList = new ArrayList<ResourceModel>();
		JsonResponse<List<ResourceModel>> resp = new JsonResponse<List<ResourceModel>>();

		try {

			String value = "SET @p_id='" + id + "', @p_candId='" + index + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("resourceRoutines")
					.setParameter("actionType", "editFeedbackDetails").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object sDate = null;
				if (m[4] != null) {
					sDate = DateFormatter.returnStringDate(m[4]);
				}
				ResourceModel vendor = new ResourceModel(m[0], m[1], m[2], null, null, null, null, null, null, null,
						null, null, null, null, null, m[3], sDate, m[5], m[6], null, m[7], null, null, null, null, null,
						null, null, null, null);
				vendorList.add(vendor);
			}
			resp.setBody(vendorList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<ResourceModel>>> response = new ResponseEntity<JsonResponse<List<ResourceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : editFeedbackDetails ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSpecificNameList() {

		logger.info("Method : getSpecificNameList starts");

		List<DropDownModel> specificNameList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("resourceRoutines")
					.setParameter("actionType", "getSpecificNameList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				specificNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getSpecificNameList ends");

		return specificNameList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getQuestion(String id) {

		logger.info("Method : getQuestion starts");

		List<DropDownModel> questionList = new ArrayList<DropDownModel>();

		String value = "SET @p_id='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("resourceRoutines")
					.setParameter("actionType", "getQuestion").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				questionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setBody(questionList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getQuestion ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addFeedback(List<ResourceModel> index) {
		logger.info("Method : addFeedback Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");

		String value = GenerateVendorSourcingParameter.addFeedback(index);

		try {
			em.createNamedStoredProcedureQuery("resourceRoutines").setParameter("actionType", "addFeedback")
					.setParameter("actionValue", value).execute();

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

		logger.info("Method : addFeedback Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ResourceModel>>> addOfferLetter() {

		logger.info("Method : addOfferLetter starts");

		List<ResourceModel> resource = new ArrayList<ResourceModel>();
		Integer total = 0;
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("resourceRoutines")
					.setParameter("actionType", "addOfferLetter").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				Object sDate = null;
				if (m[7] != null) {
					sDate = DateFormatter.returnStringDate(m[7]);
				}
				if ((Integer) m[10] == 0) {
					ResourceModel resourceModel = new ResourceModel(m[0], m[1], m[2], null, m[3], m[4], null, null,
							null, null, null, null, null, null, m[5], m[6], sDate, null, null, null, m[8], null, m[9],
							m[10], null, null, null, null, null, null);
					resource.add(resourceModel);
					total = total + 1;
				}

			}

			/*
			 * if(x.size()>0) {
			 * 
			 * if (x.get(0).length >11) { BigInteger t = (BigInteger) x.get(0)[11];
			 * 
			 * total = Integer.parseInt((t.toString())); }
			 * 
			 * }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ResourceModel>> resp = new JsonResponse<List<ResourceModel>>();
		resp.setBody(resource);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ResourceModel>>> response = new ResponseEntity<JsonResponse<List<ResourceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : addOfferLetter ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addFinalStatus(ResourceModel index) {
		logger.info("Method : addFinalStatus Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");

		try {
			String value = "SET @p_candId='" + index.getCandidateId() + "', @p_status='" + index.getStatus() + "';";

			em.createNamedStoredProcedureQuery("resourceRoutines").setParameter("actionType", "addFinalStatus")
					.setParameter("actionValue", value).execute();

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

		logger.info("Method : addFinalStatus Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ResourceModel>>> viewDetails(String reqId, String candId) {

		logger.info("Method : viewDetails starts");

		List<ResourceModel> employmentList = new ArrayList<ResourceModel>();

		try {
			String value = "SET @p_reqId='" + reqId + "',@p_candId='" + candId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("resourceRoutines")
					.setParameter("actionType", "viewDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				ResourceModel employee = new ResourceModel(null, null, m[0], null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, m[1], m[2], m[3], null, null, null, null, null, null,
						null, null, null, null);
				employmentList.add(employee);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ResourceModel>> resp = new JsonResponse<List<ResourceModel>>();
		resp.setBody(employmentList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ResourceModel>>> response = new ResponseEntity<JsonResponse<List<ResourceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewDetails ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ResourceModel>>> getFeedbackDetails(String empId, String candId) {
		logger.info("Method : getFeedbackDetails starts");

		List<ResourceModel> vendorList = new ArrayList<ResourceModel>();
		JsonResponse<List<ResourceModel>> resp = new JsonResponse<List<ResourceModel>>();

		try {

			String value = "SET @p_empId='" + empId + "',@p_candId='" + candId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("resourceRoutines")
					.setParameter("actionType", "getFeedbackDetails").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object sDate = null;
				if (m[4] != null) {
					sDate = DateFormatter.returnStringDate(m[4]);
				}
				ResourceModel vendor = new ResourceModel(m[0], m[1], m[2], null, null, null, null, null, null, null,
						null, null, null, null, null, m[3], sDate, m[5], m[6], m[7], m[8], null, m[9], null, "a", m[10],
						m[11], m[12], m[13], m[14]);
				vendorList.add(vendor);
			}
			resp.setBody(vendorList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<ResourceModel>>> response = new ResponseEntity<JsonResponse<List<ResourceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getFeedbackDetails ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ResourceModel>> generateOfferLetter(String reqId, String candId) {
		logger.info("Method : generateOfferLetter starts");

		JsonResponse<ResourceModel> resp = new JsonResponse<ResourceModel>();

		try {

			String value = "SET @p_reqId='" + reqId + "', @p_candId='" + candId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("resourceRoutines")
					.setParameter("actionType", "generateOfferLetter").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object sDate = null;
				if (m[2] != null) {
					sDate = DateFormatter.returnStringDate(m[2]);
				}

				ResourceModel vendor = new ResourceModel(m[0], null, m[1], null, null, null, null, null, null, null,
						null, null, null, null, null, null, sDate, null, m[3], null, m[4], null, null, null, null, null,
						null, null, null, null);

				resp.setBody(vendor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<ResourceModel>> response = new ResponseEntity<JsonResponse<ResourceModel>>(resp,
				responseHeaders, HttpStatus.CREATED);

		logger.info("Method : generateOfferLetter ends");
		return response;
	}

}
