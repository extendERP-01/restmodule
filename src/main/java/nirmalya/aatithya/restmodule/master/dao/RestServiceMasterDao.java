package nirmalya.aatithya.restmodule.master.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateServiceMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

import nirmalya.aatithya.restmodule.master.model.RestServiceMasterModel;

@Repository
public class RestServiceMasterDao {
	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;

	Logger logger = LoggerFactory.getLogger(RestServiceMasterDao.class);

	/*
	 * DAO Function to Add/edit New HouseKeeping Task
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> restAddNewService(RestServiceMasterModel serviceMaster) {

		logger.info("Method : restAddNewService starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (serviceMaster.gettServiceName() == null || serviceMaster.gettServiceName() == "") {
			resp.setMessage("Service Name required");
			validity = false;
		} else if (serviceMaster.gettServiceDesc() == null || serviceMaster.gettServiceDesc() == "") {
			resp.setMessage("Description required");
			validity = false;
		} else if (serviceMaster.gettServiceStatus() == null) {
			resp.setMessage("Status required");
			validity = false;
		} else if (serviceMaster.gettCreatedBy() == null || serviceMaster.gettCreatedBy() == "") {
			resp.setMessage(" required");
			validity = false;
		}

		if (validity) {
			try {
				String values = GenerateServiceMasterParameter.addServiceParam(serviceMaster);

				if (serviceMaster.gettServiceId() == null || serviceMaster.gettServiceId() == "") {
					em.createNamedStoredProcedureQuery("serviceRoutines").setParameter("actionType", "addNewService")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("serviceRoutines").setParameter("actionType", "editService")
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
		logger.info("Method : restAddNewService ends");
		return response;
	}

	/**
	 * DAO Function to View all Service
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestServiceMasterModel>>> getAllService(DataTableRequest request) {
		logger.info("Method : getAllService starts");
		List<RestServiceMasterModel> form = new ArrayList<RestServiceMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("serviceRoutines")
					.setParameter("actionType", "viewServices").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				RestServiceMasterModel properties = new RestServiceMasterModel(m[0], m[1], m[2], m[3], null);
				form.add(properties);
			}

			if (x.get(0).length > 4) {
				BigInteger t = (BigInteger) x.get(0)[4];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		JsonResponse<List<RestServiceMasterModel>> resp = new JsonResponse<List<RestServiceMasterModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<RestServiceMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestServiceMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllService ends");

		return response;
	}

	/**
	 * DAO Function to view particular HouseKeeping task to edit/view
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestServiceMasterModel>> viewServiceModal(String id) {
		logger.info("Method : viewServiceModal starts");
		List<RestServiceMasterModel> form = new ArrayList<RestServiceMasterModel>();

		try {
			String values = "SET @p_serviceId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("serviceRoutines")
					.setParameter("actionType", "serviceModel").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					RestServiceMasterModel servicemaster = new RestServiceMasterModel(m[0], m[1], m[2], m[3], null);
					form.add(servicemaster);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<RestServiceMasterModel> servicemaster = new JsonResponse<RestServiceMasterModel>();
		servicemaster.setBody(form.get(0));

		ResponseEntity<JsonResponse<RestServiceMasterModel>> response = new ResponseEntity<JsonResponse<RestServiceMasterModel>>(
				servicemaster, HttpStatus.CREATED);
		logger.info("Method : viewServiceModal ends");
		return response;
	}

	
		/**
		 * DAO Function to delete particular service
		 *
		 */

	public ResponseEntity<JsonResponse<Object>> deleteService(String id, String createdBy) {
			logger.info("Method : deleteService starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			try {

				String value = "SET @p_serviceId='" + id + "',@p_createdBy='" + createdBy +"';";

				em.createNamedStoredProcedureQuery("serviceRoutines")
				.setParameter("actionType", "deleteService")
						.setParameter("actionValue", value).execute();

			}  catch (Exception e) {
				e.printStackTrace();
				try {
					String[] err = serverDao.errorProcedureCall(e);

					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");
			ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
					HttpStatus.CREATED);

			logger.info("Method : deleteService end");
			return response;
		}



}
