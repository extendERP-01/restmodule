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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateProductMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.ProductMasterModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class ProductMasterDao {

	Logger logger = LoggerFactory.getLogger(ProductMasterDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getBrandListForProduct() {
		logger.info("Method : getBrandListForProduct starts");

		List<DropDownModel> brandList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getBrand").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				brandList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getBrandListForProduct ends");
		return brandList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getModeListForProduct() {
		logger.info("Method : getModeListForProduct starts");
		
		List<DropDownModel> modeList = new ArrayList<DropDownModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getMode").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				modeList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getModeListForProduct ends");
		return modeList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getHSNCodeListForProduct() {
		logger.info("Method : getHSNCodeListForProduct starts");
		
		List<DropDownModel> hsnCodeList = new ArrayList<DropDownModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getHSNCode").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				hsnCodeList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getHSNCodeListForProduct ends");
		return hsnCodeList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getVariationTypeListtForProduct() {
		logger.info("Method : getVariationTypeListtForProduct starts");
		
		List<DropDownModel> hsnCodeList = new ArrayList<DropDownModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getVariationType").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				hsnCodeList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getVariationTypeListtForProduct ends");
		return hsnCodeList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getUOMListForProduct() {
		logger.info("Method : getUOMListForProduct starts");
		
		List<DropDownModel> hsnCodeList = new ArrayList<DropDownModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getUOM").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				hsnCodeList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getUOMListForProduct ends");
		return hsnCodeList;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ProductMasterModel>> saveProductMaster(ProductMasterModel product) {
		logger.info("Method : saveProductMaster starts");

		Boolean validity = true;
		JsonResponse<ProductMasterModel> resp = new JsonResponse<ProductMasterModel>();
		resp.setMessage("");
		resp.setCode("");

		List<ProductMasterModel> newProduct = new ArrayList<ProductMasterModel>();

		if (product.getProductName() == null || product.getProductName() == "") {
			resp.setMessage("Product Name Required");
			validity = false;
		} else if (product.getBrand() == null || product.getBrand() == "") {
			resp.setMessage("Brand Required");
			validity = false;
		} else if (product.getMode() == null || product.getMode() == "") {
			resp.setMessage("Product Mode Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateProductMasterParameter.saveProduct(product);

				if (product.getProductId() != null && product.getProductId() != "") {
					List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
							.setParameter("actionType", "modifyProduct").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						ProductMasterModel item = new ProductMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9]);
						newProduct.add(item);
					}
				} else {

					List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
							.setParameter("actionType", "addProduct").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						ProductMasterModel item = new ProductMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9]);
						newProduct.add(item);
					}

				}

				resp.setBody(newProduct.get(0));
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

		ResponseEntity<JsonResponse<ProductMasterModel>> response = new ResponseEntity<JsonResponse<ProductMasterModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveProductMaster ends");
		return response;
	}
}
