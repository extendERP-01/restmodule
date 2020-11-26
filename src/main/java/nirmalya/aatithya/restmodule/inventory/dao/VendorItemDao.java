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
import nirmalya.aatithya.restmodule.common.utils.GenerateAsgnItemToVendorParams;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.VendorItemModel;

@Repository
public class VendorItemDao {

	Logger logger = LoggerFactory.getLogger(VendorItemDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * assign item to vendor
	 */
	public ResponseEntity<JsonResponse<Object>> addVenderItem(List<VendorItemModel> viModel) {
		logger.info("Method:add-item to vendor started..");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String values = GenerateAsgnItemToVendorParams.getVendorItemParams(viModel);
			em.createNamedStoredProcedureQuery("vendor_Item_asgn_Rutines").setParameter("actionType", "assignItem")
					.setParameter("actionValue", values).execute();
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
	 * get all Vendor items dao
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<VendorItemModel>>> getVendorItemDatails(String vendorId) {
		logger.info("Method: get-item details dao started..");

		JsonResponse<List<VendorItemModel>> resp = new JsonResponse<List<VendorItemModel>>();
		List<VendorItemModel> list = new ArrayList<VendorItemModel>();
		int total = 0;
		try {
			String values = "SET  @p_Vid='" + vendorId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("vendor_Item_asgn_Rutines")
					.setParameter("actionType", "getAssignedItems1").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				VendorItemModel vm = new VendorItemModel(m[0], m[1], m[2], m[3]);
				list.add(vm);
			}
			if (x.size() > 0) {
				if (x.get(0).length > 7) {
					BigInteger in = (BigInteger) x.get(0)[5];
					total = Integer.parseInt(in.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(list);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<VendorItemModel>>> response = new ResponseEntity<JsonResponse<List<VendorItemModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method: get-item details dao  end..");
		return response;
	}

	/*
	 * Unassign Vendor items dao
	 */
	public ResponseEntity<JsonResponse<Object>> unassignItem(String id, String name) {

		logger.info("Method: unassignItem dao started..");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String createdBy = "";
		try {

			String value = "SET @p_vid='" + id + "',@p_createdBy='" + createdBy + "',@p_Iname='" + name + "';";

			em.createNamedStoredProcedureQuery("vendor_Item_asgn_Rutines").setParameter("actionType", "unassignItem")
					.setParameter("actionValue", value).execute();
			resp.setMessage("success");
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

		logger.info("Method: unassignItem dao ended..");
		return response;
	}

	/*
	 * Update Vendor items dao
	 */
	public ResponseEntity<JsonResponse<Object>> updateVenderItem(VendorItemModel viModel) {

		logger.info("Method:update item dao started..");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String values = "SET @P_vendor='" + viModel.getVendorName() + "',@p_Iname='" + viModel.getItemName()
					+ "',@P_price='" + viModel.getItemPrice() + "';";
			em.createNamedStoredProcedureQuery("vendor_Item_asgn_Rutines").setParameter("actionType", "updateItem")
					.setParameter("actionValue", values).execute();
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

	@SuppressWarnings({ "unchecked" })
	public JsonResponse<List<DropDownModel>> getItemAutoCmplt(String key, String vid) {

		logger.info("Method: get-item-Auto complete dao started..");

		List<DropDownModel> items = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			String values = "SET  @p_serachValue='" + key + "'" + ",@p_venderId='" + vid + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("vendor_Item_asgn_Rutines")
					.setParameter("actionType", "getItemAutoCmplt").setParameter("actionValue", values).getResultList();

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
	public JsonResponse<List<DropDownModel>> getVendorCmplt(String key) {

		logger.info("Method: get-Vendor-Auto complete dao started..");

		List<DropDownModel> items = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			String values = "SET  @p_serachValue='" + key + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("vendor_Item_asgn_Rutines")
					.setParameter("actionType", "getVendorAutoCmplt").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel d = new DropDownModel(m[0], m[1]);
				items.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.setBody(items);
		logger.info("Method: get-Vendor-Auto complete dao  end..");
		return resp;
	}
}
