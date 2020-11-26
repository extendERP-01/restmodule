package nirmalya.aatithya.restmodule.master.dao;

import java.math.BigInteger;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.ServerValidation;
import nirmalya.aatithya.restmodule.master.model.RestFunctionMasterModel;

@Repository
public class RestFunctionMasterDao {

	@Autowired
	private EntityManager em;

	Logger logger = LoggerFactory.getLogger(RestFunctionMasterDao.class);

	/**
	 * DAO Function to View all function
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestFunctionMasterModel>>> getAllFunction(DataTableRequest request) {
		logger.info("Method : getAllFunction starts");
		List<RestFunctionMasterModel> form = new ArrayList<RestFunctionMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("functionRoutines")
					.setParameter("actionType", "viewAllFunction").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				RestFunctionMasterModel properties = new RestFunctionMasterModel(m[0], m[1], m[2], null, m[4],m[5]);
				form.add(properties);
			}

			if (x.get(0).length > 6) {
				BigInteger t = (BigInteger) x.get(0)[6 ];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		JsonResponse<List<RestFunctionMasterModel>> resp = new JsonResponse<List<RestFunctionMasterModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<RestFunctionMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestFunctionMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllFunction ends");
		return response;
	}

	/**
	 * DAO Function to view particular Module in model
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestFunctionMasterModel>> viewFunction(String id) {
		logger.info("Method : viewFunction starts");
		List<RestFunctionMasterModel> form = new ArrayList<RestFunctionMasterModel>();

		try {
			String values = "SET @p_tFunction='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("functionRoutines")
					.setParameter("actionType", "viewFunction").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				RestFunctionMasterModel functionMaster = new RestFunctionMasterModel(m[0], m[1], m[2], m[3], m[4],null);
				form.add(functionMaster);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<RestFunctionMasterModel> functionMaster = new JsonResponse<RestFunctionMasterModel>();
		functionMaster.setBody(form.get(0));

		ResponseEntity<JsonResponse<RestFunctionMasterModel>> response = new ResponseEntity<JsonResponse<RestFunctionMasterModel>>(
				functionMaster, HttpStatus.CREATED);
		logger.info("Method : viewFunction ends");
		return response;
	}

	
	/*
	 * upload the function image...
	 */
	public ResponseEntity<JsonResponse<Object>> getUploadFunctionImage(String id,String fileName) {
		logger.info("Method : getUploadFunctionImage starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = "SET @p_id='" + id +"', @p_imageName='"+ fileName +"';";
			System.out.println(values);
			 em.createNamedStoredProcedureQuery("functionRoutines")
					.setParameter("actionType", "uploadImage").setParameter("actionValue", values).getResultList();

			

		} catch (Exception e) {
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

	logger.info("Method : getUploadFunctionImage  ends");
	return response;
	}
	
	
}
