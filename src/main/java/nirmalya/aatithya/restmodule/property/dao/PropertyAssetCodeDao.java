/**
 * Defines property assetcode DAO
 *
 */
package nirmalya.aatithya.restmodule.property.dao;

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

import nirmalya.aatithya.restmodule.asset.model.AssetModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAssetCodeParameter;

import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.model.AssetItemModel;
import nirmalya.aatithya.restmodule.property.model.PropertyAssetCodeModel;


/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class PropertyAssetCodeDao {
	Logger logger = LoggerFactory.getLogger(PropertyAssetCodeDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to add property assetcode and edit
	 *
	 */
	
	public ResponseEntity<JsonResponse<Object>> addAssetCode(PropertyAssetCodeModel form) {
		logger.info("Method : addAssetCode starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (form.getItem() == null || form.getItem() == "") {
			resp.setMessage("Item Name required");

			validity = false;

		}
		else if (form.gettSerialNo() == null || form.gettSerialNo() == "") {
			resp.setMessage("Serial No. required");

			validity = false;

		}else if (form.getAssetCodeName() == null || form.getAssetCodeName() == "") {
			resp.setMessage("asset code name required");
			validity = false;

		} else if (form.getGrrnty() == null || form.getGrrnty() == "") {
			resp.setMessage("garrenty period required");
			validity = false;

		} else if (form.getDop() == null || form.getDop() == "") {
			resp.setMessage("date of purchase required");
			validity = false;

		} else if (form.getBrndNm() == null || form.getBrndNm() == "") {
			resp.setMessage("brand name required");
			validity = false;

		} else if (form.getStore() == null || form.getStore() == "") {
			resp.setMessage("Store required");
			validity = false;

		} else if (form.getWorkingStatus() == null) {
			resp.setMessage("Working status required");
			validity = false;

		} else if (form.getAssetactive() == null) {
			resp.setMessage("status required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateAssetCodeParameter.getAddAssetCodeParam(form);

				if (form.getAssetCodeId() != null && form.getAssetCodeId() != "") {
					em.createNamedStoredProcedureQuery("assetCode").setParameter("actionType", "modifyAssetCode")
							.setParameter("actionValue", values).execute();
				} else {

					em.createNamedStoredProcedureQuery("assetCode").setParameter("actionType", "addAssetCode")
							.setParameter("actionValue", values).execute();
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
				try {
					String[] err = serverDao.errorProcedureCall(e);

					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addAssetCode end");
		return response;
	}

	/**
	 * DAO Function for drop down models
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<AssetItemModel> getItemName() {
		logger.info("Method : getItemname starts");
		List<AssetItemModel> itemList = new ArrayList<AssetItemModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetCode")
					.setParameter("actionType", "getItemName").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				AssetItemModel dropDownModel = new AssetItemModel(m[0], m[1], m[2]);
				itemList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getItemName end");
		return itemList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStoreForAsset() {
		logger.info("Method : getStoreForAsset starts");
		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetCode")
					.setParameter("actionType", "getStore").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getStoreForAsset end");
		return itemList;
	}

	/**
	 * DAO Function to view property asset code
	 *
	 */
	public ResponseEntity<JsonResponse<List<PropertyAssetCodeModel>>> getAllAssetCode(DataTableRequest request) {
		logger.info("Method : getAllAssetCode starts");
		List<PropertyAssetCodeModel> form = new ArrayList<PropertyAssetCodeModel>();

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetCode")
					.setParameter("actionType", "viewAllAssetCode").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				Object dop = null;

				if (m[9] != null) {
					dop = DateFormatter.returnStringDate(m[3]);
				}
				PropertyAssetCodeModel assetCode = new PropertyAssetCodeModel(m[0], m[1], m[2], dop, m[4], m[5], m[6],
						m[7], m[8], m[9], m[10],m[11],m[12],null,null,null,null,null,null,null,null,null,null);

				form.add(assetCode);
			}

			if (x.get(0).length > 13) {
				BigInteger t = (BigInteger) x.get(0)[13];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonResponse<List<PropertyAssetCodeModel>> resp = new JsonResponse<List<PropertyAssetCodeModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<PropertyAssetCodeModel>>> response = new ResponseEntity<JsonResponse<List<PropertyAssetCodeModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getAllAssetCode end");
		return response;
	}

	/**
	 * DAO Function to delete property asset code
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteAssetCode(String id, String createdBy) {
		logger.info("Method : deleteAssetCode starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_assetCodeId='" + id + "',@p_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("assetCode").setParameter("actionType", "deleteAssetCode")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			String[] err = serverDao.errorProcedureCall(e);

			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : deleteAssetCode end");
		return response;
	}

	/**
	 * DAO Function for edit property asset code
	 *
	 */
	public ResponseEntity<JsonResponse<PropertyAssetCodeModel>> getAssetCodeById(String id, String action) {
		logger.info("Method : getAssetCodeById starts");

		List<PropertyAssetCodeModel> form = new ArrayList<PropertyAssetCodeModel>();

		try {
			String value = "SET @p_assetCodeId='" + id + "';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetCode").setParameter("actionType", action)
					.setParameter("actionValue", value).getResultList();

			Object dop = null;

			for (Object[] m : x) {
				if (m[9] != null) {
					dop = DateFormatter.returnStringDate(m[3]);
				}
				PropertyAssetCodeModel assetCode = new PropertyAssetCodeModel(m[0], m[1], m[2], dop, m[4], m[5], m[6],
						m[7], m[8], m[9], m[10],m[11],m[12],m[13],m[14],m[15],m[16],m[17],m[18],m[19],m[20],m[21],m[22]);

				form.add(assetCode);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<PropertyAssetCodeModel> resp = new JsonResponse<PropertyAssetCodeModel>();
		resp.setBody(form.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<PropertyAssetCodeModel>> response = new ResponseEntity<JsonResponse<PropertyAssetCodeModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getAssetCodeById end");
		return response;

	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemCategoryForAsset(String id) {
		logger.info("Method : getItemCategoryForAsset Dao starts");
		
		List<DropDownModel> poList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		
		try {
			String value = "SET @p_searchValue='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetCode")
					.setParameter("actionType", "getItemCategory")
					.setParameter("actionValue", value)
					.getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				poList.add(dropDownModel);
			}

			resp.setBody(poList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getItemCategoryForAsset Dao ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemBarcodeForAsset(String id) {
		logger.info("Method : getItemBarcodeForAsset Dao starts");
		
		List<DropDownModel> poList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		
		try {
			String value = "SET @p_searchValue='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetCode")
					.setParameter("actionType", "getItemBarcode")
					.setParameter("actionValue", value)
					.getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				poList.add(dropDownModel);
			}
			
			resp.setBody(poList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getItemBarcodeForAsset Dao ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AssetModel>>> getItemForAsset(String id, String cat) {
		logger.info("Method : getItemForAsset Dao starts");
		
		List<AssetModel> poList = new ArrayList<AssetModel>();
		JsonResponse<List<AssetModel>> resp = new JsonResponse<List<AssetModel>>();
		
		try {
			String value = "SET @p_searchValue='" + id + "', @p_category='" + cat + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetCode")
					.setParameter("actionType", "getItemForAsset")
					.setParameter("actionValue", value)
					.getResultList();
			
			for (Object[] m : x) {
				AssetModel dropDownModel = new AssetModel(m[0], m[1], m[2]);
				poList.add(dropDownModel);
			}
			
			resp.setBody(poList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<List<AssetModel>>> response = new ResponseEntity<JsonResponse<List<AssetModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getItemForAsset Dao ends");
		return response;
	}

}
