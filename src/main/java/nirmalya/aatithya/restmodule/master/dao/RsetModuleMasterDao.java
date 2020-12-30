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
import nirmalya.aatithya.restmodule.master.model.RestModuleMasterModel;

@Repository
public class RsetModuleMasterDao {

	@Autowired
	private EntityManager em;

	Logger logger = LoggerFactory.getLogger(RsetModuleMasterDao.class);

	/**
	 * DAO Function to View all Process
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestModuleMasterModel>>> getAllModule(DataTableRequest request) {
		logger.info("Method : getAllModule starts");
		List<RestModuleMasterModel> form = new ArrayList<RestModuleMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("moduleRoutines")
					.setParameter("actionType", "viewAllModule").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				RestModuleMasterModel properties = new RestModuleMasterModel(m[0], m[1], m[2], m[3],m[4],m[5]);
				form.add(properties);
			}
			if(x.size()>0) {
				if (x.get(0).length > 6) {
					BigInteger t = (BigInteger) x.get(0)[6];
					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		JsonResponse<List<RestModuleMasterModel>> resp = new JsonResponse<List<RestModuleMasterModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<RestModuleMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestModuleMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllModule ends");
		return response;
	}

	/**
	 * DAO Function to view particular Module in model
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestModuleMasterModel>> viewModule(String id) {
		logger.info("Method : viewModule starts");
		List<RestModuleMasterModel> form = new ArrayList<RestModuleMasterModel>();

		try {
			String values = "SET @p_tModule='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("moduleRoutines")
					.setParameter("actionType", "viewModule").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				RestModuleMasterModel moduleMaster = new RestModuleMasterModel(m[0], m[1], m[2], m[3],null,m[5]);
				form.add(moduleMaster);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<RestModuleMasterModel> moduleMaster = new JsonResponse<RestModuleMasterModel>();
		moduleMaster.setBody(form.get(0));

		ResponseEntity<JsonResponse<RestModuleMasterModel>> response = new ResponseEntity<JsonResponse<RestModuleMasterModel>>(
				moduleMaster, HttpStatus.CREATED);
		logger.info("Method : viewModule ends");
		return response;
	}
	
	/**
	 * DAO Function to upload module image
	 *
	 */
	
	public ResponseEntity<JsonResponse<Object>> getEditImage(String id,String fileName) {
		logger.info("Method : getEditImage starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = "SET @p_id='" + id +"', @p_imageName='"+ fileName +"';";
			System.out.println(values);
			 em.createNamedStoredProcedureQuery("moduleRoutines")
					.setParameter("actionType", "editImage").setParameter("actionValue", values).getResultList();

			

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

	logger.info("Method : getEditImage ends");
	return response;
	}
	

}
