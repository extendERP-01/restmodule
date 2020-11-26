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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAssignStockPriceParams;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.AssignStockPriceRestModel;
import nirmalya.aatithya.restmodule.inventory.model.ItemModel;

@Repository
public class AssignStockPriceRestDao {

	Logger logger = LoggerFactory.getLogger(AssignStockPriceRestDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * assign item to store dao
	 */
	public ResponseEntity<JsonResponse<Object>> saveStockItem(List<AssignStockPriceRestModel> ciModel) {
		logger.info("Method:saveStockItem started..");
System.out.println(ciModel);
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String values = GenerateAssignStockPriceParams.getAssignStockParams(ciModel);
			em.createNamedStoredProcedureQuery("AssignStockPriceRutines").setParameter("actionType", "assignItem")
					.setParameter("actionValue", values).execute();
			resp.setMessage("Success");
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

		logger.info("Method:saveStockItem end..");

		return response;

	}

	/*
	 * get all store item dao
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AssignStockPriceRestModel>>> getStockItemDatails(String storeId) {
		logger.info("Method: get-item details dao started..");

		JsonResponse<List<AssignStockPriceRestModel>> resp = new JsonResponse<List<AssignStockPriceRestModel>>();
		List<AssignStockPriceRestModel> list = new ArrayList<AssignStockPriceRestModel>();
		int total = 0;
		try {
			String values = "SET  @p_cid='" + storeId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("AssignStockPriceRutines")
					.setParameter("actionType", "getAssignedItems").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				AssignStockPriceRestModel vm = new AssignStockPriceRestModel(null, m[0], m[1], m[2], m[3], m[4], null);
				list.add(vm);
			}
			if (x.size() > 0) {
				if (x.get(0).length > 5) {
					BigInteger in = (BigInteger) x.get(0)[5];
					total = Integer.parseInt(in.toString());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(list);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<AssignStockPriceRestModel>>> response = new ResponseEntity<JsonResponse<List<AssignStockPriceRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method: get-item details dao  end..");
		return response;
	}

	/*
	 * get item for auto complete dao
	 */
	@SuppressWarnings({ "unchecked" })
	public ResponseEntity<JsonResponse<List<ItemModel>>> getItemAutoCmplt(String key, String storeId) {

		logger.info("Method: get-item-Auto complete dao started..");

		List<ItemModel> items = new ArrayList<ItemModel>();
		JsonResponse<List<ItemModel>> res = new JsonResponse<List<ItemModel>>();
		try {
			String values = "SET @p_serachValue='" + key + "',@p_storeId='" + storeId + "';";
System.out.println(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("AssignStockPriceRutines")
					.setParameter("actionType", "getItemAutoCmplt").setParameter("actionValue", values).getResultList();
			res.setMessage("Success");
			for (Object[] m : x) {

				ItemModel iModel = new ItemModel(m[0], m[1], m[2]);
				items.add(iModel);
			}
			res.setBody(items);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<ItemModel>>> response = new ResponseEntity<JsonResponse<List<ItemModel>>>(res,
				HttpStatus.CREATED);
		logger.info("Method: get-item-Auto complete dao  end..");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteItem(String cid, String Iid) {
		logger.info("Method: delete-item  dao started..");

		JsonResponse<Object> res = new JsonResponse<Object>();
		try {
			String values = "SET  @p_cid='" + cid + "',@p_Iid='" + Iid + "';";
			em.createNamedStoredProcedureQuery("AssignStockPriceRutines").setParameter("actionType", "unassignItem")
					.setParameter("actionValue", values).execute();
			res.setMessage("Success");

		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage("Error");
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(res,
				HttpStatus.CREATED);

		logger.info("Method: delete-item  dao ended..");

		return response;
	}

	/*
	 * update store item dao
	 */
	public ResponseEntity<JsonResponse<Object>> updateStockItem(AssignStockPriceRestModel ciModel) {
		logger.info("Method:update item dao started..");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String values = "SET @P_store='" + ciModel.getStoreName() + "',@p_Iname='" + ciModel.getItemId()
					+ "',@P_price='" + ciModel.getItemSpecialPrice() + "';";

			em.createNamedStoredProcedureQuery("AssignStockPriceRutines").setParameter("actionType", "updateItem")
					.setParameter("actionValue", values).execute();
			resp.setMessage("success");
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

		logger.info("Method: update item dao end..");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStoreAutoCmplt(String key) {
		logger.info("Method: get-customer-Auto complete dao started..");

		List<DropDownModel> items = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> res = new JsonResponse<List<DropDownModel>>();
		try {
			String values = "SET @p_serachValue='" + key + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("AssignStockPriceRutines")
					.setParameter("actionType", "getStoreAutoCmplt").setParameter("actionValue", values)
					.getResultList();
			res.setMessage("Success");
			for (Object[] m : x) {
				DropDownModel cModel = new DropDownModel(m[0], m[1]);
				items.add(cModel);
			}
			res.setBody(items);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				res, HttpStatus.CREATED);
		logger.info("Method: get-customer-Auto complete dao  end..");

		return response;
	}

}
