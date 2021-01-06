package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.GenerateProductCategoryParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.ProductCategoryModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class ProductCategoryDao {

	Logger logger = LoggerFactory.getLogger(ProductCategoryDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ProductCategoryModel>> saveProductCategory(ProductCategoryModel category) {
		logger.info("Method : saveProductCategory starts");

		Boolean validity = true;
		JsonResponse<ProductCategoryModel> resp = new JsonResponse<ProductCategoryModel>();
		resp.setMessage("");
		resp.setCode("");

		List<ProductCategoryModel> newLoc = new ArrayList<ProductCategoryModel>();

		if (category.getCategoryName() == null || category.getCategoryName() == "") {
			resp.setMessage("Category Name Required");
			validity = false;
		} else if (category.getCategoryDesc() == null || category.getCategoryDesc() == "") {
			resp.setMessage("Category Description Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateProductCategoryParameter.saveProductCategory(category);

				if (category.getCategoryId() != null && category.getCategoryId() != "") {
					
					List<Object[]> x = em.createNamedStoredProcedureQuery("productCategoryRoutines")
							.setParameter("actionType", "modifyCategory").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						ProductCategoryModel item = new ProductCategoryModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], null, null);
						newLoc.add(item);
					}
				} else {

					List<Object[]> x = em.createNamedStoredProcedureQuery("productCategoryRoutines")
							.setParameter("actionType", "addCategory").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						ProductCategoryModel item = new ProductCategoryModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], null, null);
						newLoc.add(item);
					}

				}

				resp.setBody(newLoc.get(0));
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

		ResponseEntity<JsonResponse<ProductCategoryModel>> response = new ResponseEntity<JsonResponse<ProductCategoryModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveProductCategory ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ProductCategoryModel>> saveProductSubCategory(ProductCategoryModel category) {
		logger.info("Method : saveProductSubCategory starts");
		
		Boolean validity = true;
		JsonResponse<ProductCategoryModel> resp = new JsonResponse<ProductCategoryModel>();
		resp.setMessage("");
		resp.setCode("");
		
		List<ProductCategoryModel> newLoc = new ArrayList<ProductCategoryModel>();
		
		if (category.getCategoryName() == null || category.getCategoryName() == "") {
			resp.setMessage("Category Name Required");
			validity = false;
		} else if (category.getCategoryDesc() == null || category.getCategoryDesc() == "") {
			resp.setMessage("Category Description Required");
			validity = false;
		}
		
		if (validity)
			try {
				String values = GenerateProductCategoryParameter.saveProductCategory(category);
				
				if (category.getCategoryId() != null && category.getCategoryId() != "") {
					
					List<Object[]> x = em.createNamedStoredProcedureQuery("productCategoryRoutines")
							.setParameter("actionType", "modifyCategory").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						
						ProductCategoryModel item = new ProductCategoryModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], null, null);
						newLoc.add(item);
					}
				} else {
					
					List<Object[]> x = em.createNamedStoredProcedureQuery("productCategoryRoutines")
							.setParameter("actionType", "addSubCategory").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						
						ProductCategoryModel item = new ProductCategoryModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], null, null);
						newLoc.add(item);
					}
					
				}
				
				resp.setBody(newLoc.get(0));
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
		
		ResponseEntity<JsonResponse<ProductCategoryModel>> response = new ResponseEntity<JsonResponse<ProductCategoryModel>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : saveProductSubCategory ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductCategoryModel>>> getAllProductCategoryList() {
		logger.info("Method : getAllProductCategoryList starts");
		
		JsonResponse<List<ProductCategoryModel>> resp = new JsonResponse<List<ProductCategoryModel>>();
		List<ProductCategoryModel> newLoc = new ArrayList<ProductCategoryModel>();
		
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("productCategoryRoutines")
					.setParameter("actionType", "getPCategoryList").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {

				ProductCategoryModel item = new ProductCategoryModel(m[0], m[1], null, null, m[2], null, m[3], m[4], m[5]);
				newLoc.add(item);
			}

			resp.setBody(newLoc);
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
		
		ResponseEntity<JsonResponse<List<ProductCategoryModel>>> response = new ResponseEntity<JsonResponse<List<ProductCategoryModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getAllProductCategoryList ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductCategoryModel>>> getProductCategoryListById(String id) {
		logger.info("Method : getProductCategoryListById starts");
		
		JsonResponse<List<ProductCategoryModel>> resp = new JsonResponse<List<ProductCategoryModel>>();
		List<ProductCategoryModel> newLoc = new ArrayList<ProductCategoryModel>();
		
		try {
			String value = "SET @P_ParentID='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("productCategoryRoutines")
					.setParameter("actionType", "getPCategoryListById").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				ProductCategoryModel item = new ProductCategoryModel(m[0], m[1], null, null, m[2], null, m[3], m[4], m[5]);
				newLoc.add(item);
			}

			resp.setBody(newLoc);
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
		
		ResponseEntity<JsonResponse<List<ProductCategoryModel>>> response = new ResponseEntity<JsonResponse<List<ProductCategoryModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getProductCategoryListById ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ProductCategoryModel>> getProductCategoryById(String id) {
		logger.info("Method : getProductCategoryById starts");
		
		JsonResponse<ProductCategoryModel> resp = new JsonResponse<ProductCategoryModel>();
		List<ProductCategoryModel> newLoc = new ArrayList<ProductCategoryModel>();
		
		try {
			String value = "SET @P_PCategory='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("productCategoryRoutines")
					.setParameter("actionType", "getPCategoryById").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				
				ProductCategoryModel item = new ProductCategoryModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], null);
				newLoc.add(item);
			}
			
			resp.setBody(newLoc.get(0));
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
		
		ResponseEntity<JsonResponse<ProductCategoryModel>> response = new ResponseEntity<JsonResponse<ProductCategoryModel>>(
				resp, HttpStatus.CREATED);
		System.out.println(response);
		logger.info("Method : getProductCategoryById ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteCategory(String id, String createdBy) {
		logger.info("Method : deleteCategory starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @P_PCat='" + id + "', @P_ModifiedBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("productCategoryRoutines").setParameter("actionType", "deleteCategory")
					.setParameter("actionValue", value).execute();
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
		logger.info("Method : deleteCategory ends");
		return response;
	}
}
