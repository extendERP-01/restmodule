/**
 * 
 */
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
import nirmalya.aatithya.restmodule.common.utils.GenerateMasterCountryParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.ServerValidation;
import nirmalya.aatithya.restmodule.master.model.RestMasterCountryModel;


/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class MasterCountryDao {
	Logger logger=LoggerFactory.getLogger(MasterCountryDao.class);
	@Autowired
	private EntityManager entityManager;
	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to Add/edit Country
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addCountry(RestMasterCountryModel masterCountryModel) {
		logger.info("Method : addCountry Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		 if (masterCountryModel.getCountryName() == null || masterCountryModel.getCountryName() == "") {
			resp.setMessage("Country Name required");
			validity = false;
		} else if (masterCountryModel.getCountryCode() == null || masterCountryModel.getCountryCode() == "") {
			resp.setMessage("Country Code required");
			validity = false;
		} else if (masterCountryModel.getCountryActive() == null) {
			resp.setMessage("status required");
			validity = false;
		}
		
		if (validity)
			try {
				String values = GenerateMasterCountryParameter.addCountryParam(masterCountryModel);

				if (masterCountryModel.getCountryId() != null && masterCountryModel.getCountryId() != "") {
					entityManager.createNamedStoredProcedureQuery("masterCountryRoutines")
							.setParameter("actionType", "modifyCountry").setParameter("actionValue", values)
							.execute();
				} else {
					entityManager.createNamedStoredProcedureQuery("masterCountryRoutines")
							.setParameter("actionType", "addNewCountry").setParameter("actionValue", values)
							.execute();
				}

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
			

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addCountry Dao ends");
		return response;
	}



	/**
	 * DAO Function to View all Countries in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestMasterCountryModel>>> getAllCountryList(DataTableRequest request) {
		logger.info("Method : getAllCountryList Dao starts");
		List<RestMasterCountryModel> masterCountryModel = new ArrayList<RestMasterCountryModel>();

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("masterCountryRoutines")
					.setParameter("actionType", "viewAllCountry").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {
				RestMasterCountryModel MstrCtr = new RestMasterCountryModel(m[0], m[1], m[2], m[3],null,null);
				masterCountryModel.add(MstrCtr);
			}

			if (x.get(0).length > 4) {
				BigInteger t = (BigInteger) x.get(0)[4];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestMasterCountryModel>> resp = new JsonResponse<List<RestMasterCountryModel>>();
		resp.setBody(masterCountryModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestMasterCountryModel>>> response = new ResponseEntity<JsonResponse<List<RestMasterCountryModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllCountryList Dao ends");
		
		return response;
	}
	
	
	/**
	 * DAO Function to edit Country
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestMasterCountryModel>> getCountryById(String id) {
		logger.info("Method : getCountryById Dao starts");
		List<RestMasterCountryModel> form = new ArrayList<RestMasterCountryModel>();
		try {
			String value = "SET @p_country='" + id + "';";
			
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("masterCountryRoutines")
					.setParameter("actionType", "editCountry").setParameter("actionValue", value).getResultList();
		
			for (Object[] m : x) {
				RestMasterCountryModel restMasterCountryModel = new RestMasterCountryModel(m[0], m[1], m[2], m[3],null, null);
				form.add(restMasterCountryModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<RestMasterCountryModel> resp = new JsonResponse<RestMasterCountryModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestMasterCountryModel>> response = new ResponseEntity<JsonResponse<RestMasterCountryModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getCountryById Dao ends");
		return response;
	}
	/**
	 * DAO Function to delete country
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteCountry(String id,String createdBy) {
		logger.info("Method : deletecountry Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_country='" + id + "',@p_createdBy='"+createdBy+"';";
			entityManager.createNamedStoredProcedureQuery("masterCountryRoutines")
					.setParameter("actionType", "deleteCountry").setParameter("actionValue", value).execute();

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
		logger.info("Method : deleteCountry Dao ends");
		return response;
	}
	
}

