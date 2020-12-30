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
import nirmalya.aatithya.restmodule.common.utils.GenerateAsgnItemToCustomerParams;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.CustomerItemModel;
import nirmalya.aatithya.restmodule.inventory.model.CustomerModel;
import nirmalya.aatithya.restmodule.inventory.model.ItemModel;

@Repository
public class CustomerItemAssgnDao {

	Logger logger = LoggerFactory.getLogger(CustomerItemAssgnDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	private static final String PROCEDURE_NAME = "Customer_Item_Rutines";
	private static final String ACTION_TYPE = "actionType";
	private static final String ACTION_VALUE = "actionValue";

	/*
	 * assign item to customer dao
	 */
	public ResponseEntity<JsonResponse<Object>> saveCustomerItem(List<CustomerItemModel> ciModel) {
		logger.info("Method:add-item to vendor started..");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String values = GenerateAsgnItemToCustomerParams.getCustomerItemParams(ciModel);
			em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_VALUE, "assignItem")
					.setParameter(ACTION_TYPE, values).execute();
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

		logger.info("Method: add-item to vendor end..");

		return response;

	}

	/*
	 * get all customer item dao
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<CustomerItemModel>>> getCustomerItemDatails(String customerId) {
		logger.info("Method: get-item details dao started..");

		JsonResponse<List<CustomerItemModel>> resp = new JsonResponse<List<CustomerItemModel>>();
		List<CustomerItemModel> list = new ArrayList<CustomerItemModel>();
		int total = 0;
		try {
			String values = "SET  @p_cid='" + customerId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "getAssignedItems").setParameter(ACTION_VALUE, values).getResultList();

			for (Object[] m : x) {
				CustomerItemModel vm = new CustomerItemModel(m[0], m[1], m[2], m[3], m[4]);
				list.add(vm);
			}
			if (!x.isEmpty() && x.get(0).length > 5) {

				BigInteger in = (BigInteger) x.get(0)[5];
				total = Integer.parseInt(in.toString());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(list);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<CustomerItemModel>>> response = new ResponseEntity<JsonResponse<List<CustomerItemModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method: get-item details dao  end..");
		return response;
	}

	/*
	 * get item for auto complete dao
	 */
	@SuppressWarnings({ "unchecked" })
	public ResponseEntity<JsonResponse<List<ItemModel>>> getItemAutoCmplt(String key, String customerId) {

		logger.info("Method: get-item-Auto complete dao started..");

		List<ItemModel> items = new ArrayList<ItemModel>();
		JsonResponse<List<ItemModel>> res = new JsonResponse<List<ItemModel>>();
		try {
			String values = "SET @p_serachValue='" + key + "',@p_venderId='" + customerId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "getItemAutoCmplt").setParameter(ACTION_VALUE, values).getResultList();
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

	public ResponseEntity<JsonResponse<Object>> deleteItem(String cid, String itemId) {
		logger.info("Method: delete-item  dao started..");

		JsonResponse<Object> res = new JsonResponse<Object>();
		try {
			String values = "SET  @p_cid='" + cid + "',@p_Iid='" + itemId + "';";
			em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, "unassignItem")
					.setParameter(ACTION_VALUE, values).execute();
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
	 * update customer item dao
	 */
	public ResponseEntity<JsonResponse<Object>> updateCustomerItem(CustomerItemModel ciModel) {
		logger.info("Method:update item dao started..");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String values = "SET @P_customer='" + ciModel.getCustomerName() + "',@p_Iname='" + ciModel.getItemId()
					+ "',@P_price='" + ciModel.getItemSpecialPrice() + "';";
			em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, "updateItem")
					.setParameter(ACTION_VALUE, values).execute();
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

	/*
	 * get Customer Name AutoComplete
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<CustomerModel>>> getCustomerAutoCmplt(String key) {
		logger.info("Method: get-customer-Auto complete dao started..");

		List<CustomerModel> items = new ArrayList<CustomerModel>();
		JsonResponse<List<CustomerModel>> res = new JsonResponse<List<CustomerModel>>();
		try {
			String values = "SET @p_serachValue='" + key + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "getCustomerAutoCmplt").setParameter(ACTION_VALUE, values)
					.getResultList();
			res.setMessage("Success");
			for (Object[] m : x) {
				CustomerModel cModel = new CustomerModel(m[0], m[1]);
				items.add(cModel);
			}
			res.setBody(items);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<CustomerModel>>> response = new ResponseEntity<JsonResponse<List<CustomerModel>>>(
				res, HttpStatus.CREATED);
		logger.info("Method: get-customer-Auto complete dao  end..");
		return response;
	}

	/*
	 * get Customer Name AutoComplete
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCategoryAutoCmplt(String key) {
		logger.info("Method: getCategoryAutoCmplt started..");

		List<DropDownModel> items = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> res = new JsonResponse<List<DropDownModel>>();
		try {
			String values = "SET @p_serachValue='" + key + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "getCategoryAutoCmplt").setParameter(ACTION_VALUE, values)
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
		logger.info("Method: getCategoryAutoCmplt dao  end..");
		return response;
	}

}
