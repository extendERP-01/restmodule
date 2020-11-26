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
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.GenerateMasterCategoryParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.ServerValidation;
import nirmalya.aatithya.restmodule.master.model.RestCategoryModel;

@Repository
public class RestCategoryDao {
	Logger logger=LoggerFactory.getLogger(RestCategoryDao.class);
	@Autowired
	private EntityManager entityManager;
	@Autowired
	ServerDao serverDao;
	/**
	 * DAO Function to Add/edit Category
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addCategory(RestCategoryModel restCategoryModel) {
		logger.info("Method : addCategory Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		 if (restCategoryModel.getCategoryName() == null || restCategoryModel.getCategoryName() == "") {
			resp.setMessage("Category Name required");
			validity = false;
		} 
		 if (restCategoryModel.getDescription() == null || restCategoryModel.getDescription() == "") {
				resp.setMessage("Description required");
				validity = false;
			} 
		 if (restCategoryModel.getCreatedBy() == null || restCategoryModel.getCreatedBy() == "") {
				resp.setMessage("Created By Name required");
				validity = false;
			} 
		
		if (validity)
			try {
				String values = GenerateMasterCategoryParameter.addCategoryParam(restCategoryModel);

				if (restCategoryModel.getCategory() != null && restCategoryModel.getCategory() != "") {
					entityManager.createNamedStoredProcedureQuery("masterCategoryRoutines")
							.setParameter("actionType", "modifyCategory").setParameter("actionValue", values)
							.execute();
				} else {
					entityManager.createNamedStoredProcedureQuery("masterCategoryRoutines")
							.setParameter("actionType", "addCategory").setParameter("actionValue", values)
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
		logger.info("Method : addCategory Dao ends");
		return response;
	}

	/**
	 * DAO Function to View all Countries in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCategoryModel>>> getAllCategory(DataTableRequest request) {
		logger.info("Method : getAllCategoryList Dao starts");
		List<RestCategoryModel> masterCountryModel = new ArrayList<RestCategoryModel>();

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("masterCategoryRoutines")
					.setParameter("actionType", "viewAllCategory").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {
				Object date=null;
				date=DateFormatter.returnStringDate(m[3]);
				RestCategoryModel MstrCtr = new RestCategoryModel(m[0], m[1],m[2],date, null,m[4]);
				masterCountryModel.add(MstrCtr);
			}

			if (x.get(0).length > 5) {
				BigInteger t = (BigInteger) x.get(0)[5];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestCategoryModel>> resp = new JsonResponse<List<RestCategoryModel>>();
		resp.setBody(masterCountryModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestCategoryModel>>> response = new ResponseEntity<JsonResponse<List<RestCategoryModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllCategoryList Dao ends");
		return response;
	}
	/**
	 * DAO Function to edit category
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestCategoryModel>> getCategoryById(String id) {
		logger.info("Method : getCategoryById Dao starts");
		List<RestCategoryModel> form = new ArrayList<RestCategoryModel>();
		try {
			String value = "SET @p_category='" + id + "';";
			
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("masterCategoryRoutines")
					.setParameter("actionType", "editCategory").setParameter("actionValue", value).getResultList();
		
			for (Object[] m : x) {
				Object date=null;
				date=DateFormatter.returnStringDate(m[3]);
				RestCategoryModel restCategoryModel = new RestCategoryModel(m[0], m[1],m[2],date, null,m[4]);
				form.add(restCategoryModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<RestCategoryModel> resp = new JsonResponse<RestCategoryModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestCategoryModel>> response = new ResponseEntity<JsonResponse<RestCategoryModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getCategoryById Dao ends");
		return response;
	}
	/**
	 * DAO Function to delete country
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteCategory(String id,String createdBy) {
		logger.info("Method : deleteCategory Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_category='" + id + "',@p_createdBy='"+createdBy+"';";
			entityManager.createNamedStoredProcedureQuery("masterCategoryRoutines")
					.setParameter("actionType", "deleteCategory").setParameter("actionValue", value).execute();

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
		logger.info("Method : deleteCategory Dao ends");
		return response;
	}
}
