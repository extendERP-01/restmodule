package nirmalya.aatithya.restmodule.inventory.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import ch.qos.logback.classic.Logger;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateReOrderItemParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.AssignedItemModel;
import nirmalya.aatithya.restmodule.inventory.model.ReOrderItemRestModel;

@Repository
public class ReOrderDao {

	Logger logger = (Logger) LoggerFactory.getLogger(ReOrderDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public List<ReOrderItemRestModel> getBelowMinQtyItem(String id) {
		logger.info("Method : getBelowMinQtyItem starts");
		
		List<ReOrderItemRestModel> itemList = new ArrayList<ReOrderItemRestModel>();
		
		try {
			String value = "SET @P_UserID = '" + id + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("reOrderItemRoutines")
					.setParameter("actionType", "getMinQtyBelowItem")
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				ReOrderItemRestModel dropDownModel = new ReOrderItemRestModel(m[0], m[1], m[2], m[3], m[4], m[5], null, null, null);
				itemList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getBelowMinQtyItem ends");
		return itemList;
	}
	
	@SuppressWarnings("unchecked")
	public List<AssignedItemModel> getItemWiseVendor(String id) {
		logger.info("Method : getItemWiseVendor starts");
		
		List<AssignedItemModel> vendorList = new ArrayList<AssignedItemModel>();
		
		try {
			String value = "SET @P_ItemID = '" + id + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("reOrderItemRoutines")
					.setParameter("actionType", "getItemWiseVendor")
					.setParameter("actionValue", value)
					.getResultList();
			
			for (Object[] m : x) {
				AssignedItemModel dropDownModel = new AssignedItemModel(m[0], m[1], m[2]);
				vendorList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getItemWiseVendor ends");
		return vendorList;
	}
	
	public ResponseEntity<JsonResponse<Object>> submitVendorForPO(List<ReOrderItemRestModel> restItemModel) {
		logger.info("Method : submitVendorForPO starts");
		
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		
		if (validity)
			try {
				for(int i = 0; i < restItemModel.size(); i++) {
					String values = GenerateReOrderItemParameter.reOrderItemParam(restItemModel.get(i));
					em.createNamedStoredProcedureQuery("reOrderItemRoutines")
							.setParameter("actionType", "savePOVendorWise").setParameter("actionValue", values).execute();
				}
				
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
		
		logger.info("Method : submitVendorForPO ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ReOrderItemRestModel>>> getAllVendorsFromReOrder(
			DataTableRequest request) {
		logger.info("Method : getAllVendorsFromReOrder starts");

		List<ReOrderItemRestModel> invGoodsReceiveModel = new ArrayList<ReOrderItemRestModel>();
		
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("reOrderItemRoutines")
					.setParameter("actionType", "ViewPO").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					
					if(m[3]!=null) {
						date = DateFormatter.returnStringDate(m[3]);
					}
					ReOrderItemRestModel itmCat = new ReOrderItemRestModel(null,m[0],null,m[1],null,null,m[2],date,m[4]);
					invGoodsReceiveModel.add(itmCat);
				}
				if (x.get(0).length > 5) {
					BigInteger t = (BigInteger) x.get(0)[5];
					total = Integer.parseInt((t.toString()));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ReOrderItemRestModel>> resp = new JsonResponse<List<ReOrderItemRestModel>>();
		
		resp.setBody(invGoodsReceiveModel);
		resp.setTotal(total);
		
		ResponseEntity<JsonResponse<List<ReOrderItemRestModel>>> response = new ResponseEntity<JsonResponse<List<ReOrderItemRestModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getAllVendorsFromReOrder ends");
		return response;
	}
}
