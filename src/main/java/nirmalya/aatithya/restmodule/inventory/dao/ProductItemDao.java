package nirmalya.aatithya.restmodule.inventory.dao;

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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateProductItemAsgnParams;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.ProductModel;

@Repository
public class ProductItemDao {

	Logger logger = LoggerFactory.getLogger(ProductItemDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	private static final String PROCEDURE_NAME = "ProductItemRutines";
	private static final String ACTION_TYPE = "actionType";
	private static final String ACTION_VALUE = "actionValue";

	/*
	 * assign item to vendor
	 */
	public ResponseEntity<JsonResponse<Object>> addProductItem(List<ProductModel> pModel) {
		logger.info("Method:add-product started..");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String values = GenerateProductItemAsgnParams.getProductItemParams(pModel);
			if (pModel.get(0).getProductId() == null || pModel.get(0).getProductId() == "") {
				em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, "assignProduct")
						.setParameter(ACTION_VALUE, values).execute();
			} else {
				em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, "updateProduct")
						.setParameter(ACTION_VALUE, values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method: add-product end..");

		return response;

	}

	/*
	 * get all Vendor items dao
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductModel>>> getProductItemDatails(DataTableRequest request) {
		logger.info("Method: get-Product-item details dao started..");

		JsonResponse<List<ProductModel>> resp = new JsonResponse<List<ProductModel>>();
		List<ProductModel> list = new ArrayList<ProductModel>();
		String params = GenerateParameter.getSearchParam(request);
		int total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "getAllProducts").setParameter(ACTION_VALUE, params).getResultList();

			int slno = 1;
			for (Object[] m : x) {
				ProductModel vm = new ProductModel(m[0], m[1], m[2], m[3], m[4], m[5] ,m[6]);
				vm.setSlNo(slno);
				list.add(vm);
				slno++;
			}
			if (x.size() > 0) {
				if (x.get(0).length > 7) {
					BigInteger in = (BigInteger) x.get(0)[7];
					total = Integer.parseInt(in.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(list);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<ProductModel>>> response = new ResponseEntity<JsonResponse<List<ProductModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method: get-Product-item details dao  end..");
		return response;
	}

	/*
	 * delete product dao
	 */
	public ResponseEntity<JsonResponse<Object>> deleteProduct(String id) {

		logger.info("Method: delete product dao started..");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_pid='" + id + "';";

			em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, "deleteProduct")
					.setParameter(ACTION_VALUE, value).execute();

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

		logger.info("Method: delete product dao ended..");
		return response;
	}

	/*
	 * Update Product dao
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductModel>>> updateProduct(String id) {

		logger.info("Method:update item dao started..");

		JsonResponse<List<ProductModel>> resp = new JsonResponse<List<ProductModel>>();
		List<ProductModel> productList = new ArrayList<ProductModel>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String values = "SET @P_pid='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "getProductByID").setParameter(ACTION_VALUE, values).getResultList();

			for (Object[] m : x) {
				ProductModel pmodel = new ProductModel(m[0], m[1], m[2], m[3], m[4], m[5] ,m[6]);
				productList.add(pmodel);
			} 
			resp.setBody(productList);
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

		ResponseEntity<JsonResponse<List<ProductModel>>> response = new ResponseEntity<JsonResponse<List<ProductModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method: update item dao end..");

		return response;

	}

	@SuppressWarnings({ "unchecked" })
	public JsonResponse<List<DropDownModel>> getItemAutoCmplt(String key, String vid) {

		logger.info("Method: get-item-Auto complete dao started..");

		List<DropDownModel> items = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			String values = "SET  @p_serachValue='" + key + "'" + ",@p_venderId='" + vid + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "getItemAutoCmplt").setParameter(ACTION_VALUE, values).getResultList();
 
			for (Object[] m : x) {
				DropDownModel d = new DropDownModel(m[0], m[1]);
				items.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(items);
		logger.info("Method: get-item-Auto complete dao  end..");
		return resp;
	}

	@SuppressWarnings({ "unchecked" })
	public JsonResponse<List<DropDownModel>> getItemAutoCmplt(String key) {

		logger.info("Method:getItemAutoCmplt dao started..");

		List<DropDownModel> items = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			String values = "SET  @p_serachValue='" + key + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "getProductAutoCmplt").setParameter(ACTION_VALUE, values)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel d = new DropDownModel(m[0], m[1]);
				items.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.setBody(items);
		logger.info("Method: getItemAutoCmplt dao  end..");
		return resp;
	}
}
