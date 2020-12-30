/*
 * Doa for property assigned asset
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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GeneratePropertyAssignAssetParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

import nirmalya.aatithya.restmodule.property.model.PropertyAssignAssetModel;

@Repository
public class PropertyAssetAssignDao {
	Logger logger = LoggerFactory.getLogger(PropertyAssetAssignDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	/*
	 * Drop down for asset for fixed assets
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAssetLists(String item) {

		logger.info("Method in Dao : getAssetList starts");

		List<DropDownModel> assetList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_item='" + item + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("AmenityItem")
					.setParameter("actionType", "getAssetList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				assetList.add(dropDownModel);

			}

			resp.setBody(assetList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method in Dao: getAssetList ends");
		return response;
	}

	
	/*
	 * Drop down for asset for fixed assets
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAssetListAll(String item) {

		logger.info("Method in Dao : getAssetList starts");

		List<DropDownModel> assetList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_item='" + item + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("AmenityItem")
					.setParameter("actionType", "getAssetListAll").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				assetList.add(dropDownModel);

			}

			resp.setBody(assetList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method in Dao: getAssetList ends");
		return response;
	}


	/*
	 * Drop down for amenity for fixed assets
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAmenity(String proId) {

		logger.info("Method in Dao : getAmenity starts");

		List<DropDownModel> amenityList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_property='" + proId + "';";
			System.out.println("value: "+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("AssignAsset")
					.setParameter("actionType", "getAmenityFixed").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				amenityList.add(dropDownModel);

			}

			resp.setBody(amenityList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method in Dao: getAmenity ends");
		return response;
	}

	/*
	 * Drop down for get ItemCategory By Amenity for fixed assets
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemCategoryByAmenity(String amenity) {

		logger.info("Method in Dao : getItemCategoryByAmenity starts");

		List<DropDownModel> ItemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_amenity='" + amenity + "';";

			
			List<Object[]> x = em.createNamedStoredProcedureQuery("AssignAsset")
					.setParameter("actionType", "getItemByAmenity").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				ItemList.add(dropDownModel);

			}

			resp.setBody(ItemList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method in Dao: getItemCategoryByAmenity ends");
		return response;
	}
	
	
	
	/*
	 * Drop down for item name for fixed assets
	 */

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getItemCAtegoryListFixed() {

		logger.info("Method in Dao: getAmenityList starts");

		List<DropDownModel> categoryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("AmenityItem")
					.setParameter("actionType", "getItemCategoryFixed").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				categoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getAmenityList ends");

		return categoryList;
	}

	
	/*
	 * Drop down for get ItemCategory By Amenity for fixed assets
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSubCategoryItem(String itmCat) {

		logger.info("Method in Dao : getItemCategoryByAmenity starts");

		List<DropDownModel> assetList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_ItemCategory='" + itmCat + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("AssignAsset")
					.setParameter("actionType", "getSubCategory").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				assetList.add(dropDownModel);

			}

			resp.setBody(assetList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method in Dao: getItemCategoryByAmenity ends");
		return response;
	}
	

	/*
	 * Drop down for  Amenity Item for fixed asset
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemListFixed(String ItemSubCat) {
		  logger.info("Method : getItemList starts");

		List<DropDownModel> ItemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_ItemSubCat='" + ItemSubCat + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("AssignAsset")
					.setParameter("actionType", "getItemNameListFixed").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				ItemNameList.add(dropDownModel);
			}

			resp.setBody(ItemNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		  logger.info("Method : getItemList ends");
		return response;
	}

	
	
	
	/*
	 * for add Assign Asset
	 */
	public ResponseEntity<JsonResponse<Object>> addAssignAsset(PropertyAssignAssetModel propertyAssignAssetModel) {

		logger.info("Method in Dao:Add  Assign Assets starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (propertyAssignAssetModel.getPropertyCategory() == null
				|| propertyAssignAssetModel.getPropertyCategory() == "") {
			resp.setMessage("Property category Not Selected");
			validity = false;
		} else if (propertyAssignAssetModel.getProperty() == null || propertyAssignAssetModel.getProperty() == "") {
			resp.setMessage("Property Type Not Selected");
			validity = false;
		}
		else if (propertyAssignAssetModel.getAmenity() == null || propertyAssignAssetModel.getAmenity() == "") {
			resp.setMessage("Amenity Not Selected ");
			validity = false;
		}else if (propertyAssignAssetModel.getItem() == null || propertyAssignAssetModel.getItem() == "") {
			resp.setMessage("Item not slected");
			validity = false;
		} else if (propertyAssignAssetModel.getItemSubCategory() == null) {
			resp.setMessage("Item SubCategory  not selected");
			validity = false;
		} else if (propertyAssignAssetModel.getAssetsList() == null) {
			resp.setMessage("Asset list  not selected");
			validity = false;
		} else if (propertyAssignAssetModel.getItemCategory() == null
				|| propertyAssignAssetModel.getItemCategory() == " ") {
			resp.setMessage("Asset list  not selected");
			validity = false;
		}

		if (validity)
			try {

				String values = GeneratePropertyAssignAssetParameter.getAddAssignAssetParam(propertyAssignAssetModel);
				System.out.println(values);
				em.createNamedStoredProcedureQuery("AssignAsset").setParameter("actionType", "addAssignAsset")
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

		logger.info("Method in Dao: add Assign Assets ends");

		return response;
	}

	/*
	 * for all Asset Assigned
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PropertyAssignAssetModel>>> getAllAssignedAsset(DataTableRequest request) {

		logger.info("Method in Dao: get all Details starts");

		List<PropertyAssignAssetModel> amenityItemList = new ArrayList<PropertyAssignAssetModel>();

		String param3 = request.getParam3();
		String param4 = request.getParam4();
		if (param3 != null && param3 != "") {
			String frmDate = DateFormatter.getStringDate(param3);
			
			request.setParam3(frmDate);
		} else {
			request.setParam3("");
		}
		if (param4 != null && param4 != "") {
			String tDate = DateFormatter.getStringDate(param4);

			request.setParam4(tDate);
		} else {
			request.setParam4("");
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("AssignAsset")
					.setParameter("actionType", "viewAllAssignedAsset").setParameter("actionValue", values)
					.getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					PropertyAssignAssetModel amenityItem = new PropertyAssignAssetModel(m[0], m[1], m[2], m[3], m[4],
							m[5], m[6], m[7], m[8], m[9],m[10],null);
					amenityItemList.add(amenityItem);

				}

				if (x.get(0).length > 11) {
					BigInteger t = (BigInteger) x.get(0)[11];

					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<PropertyAssignAssetModel>> resp = new JsonResponse<List<PropertyAssignAssetModel>>();
		resp.setBody(amenityItemList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<PropertyAssignAssetModel>>> response = new ResponseEntity<JsonResponse<List<PropertyAssignAssetModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: get all Details ends");

		return response;
	}

	
	
	/*
	 * for all Asset Assigned
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PropertyAssignAssetModel>>> getAllAssignedAssetPdf(DataTableRequest request){

		logger.info("Method in Dao: get all Details starts");

		List<PropertyAssignAssetModel> amenityItemList = new ArrayList<PropertyAssignAssetModel>();
		JsonResponse<List<PropertyAssignAssetModel>> resp = new JsonResponse<List<PropertyAssignAssetModel>>();

		String param3 = request.getParam3();
		String param4 = request.getParam4();
		if (param3 != null && param3 != "") {
			String frmDate = DateFormatter.getStringDate(param3);
			if (frmDate == null) {
				frmDate = "";
			}
			request.setParam3(frmDate);
		} else {
			request.setParam3("");
		}
		if (param4 != null && param4 != "") {
			String tDate = DateFormatter.getStringDate(param4);
			if (tDate == null) {
				tDate = "";
			}

			request.setParam4(tDate);
		} else {
			request.setParam4("");
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("AssignAsset")
					.setParameter("actionType", "viewAllAssetPdf").setParameter("actionValue", values)
					.getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					PropertyAssignAssetModel assetAssign = new PropertyAssignAssetModel(m[0], m[1], m[2], m[3], m[4],
							m[5], m[6], m[7], m[8], m[9],m[10],null);
					amenityItemList.add(assetAssign);

				}

				if (x.get(0).length > 11) {
					BigInteger t = (BigInteger) x.get(0)[11];

					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			resp.setMessage("No record Found");
		}

		
		resp.setBody(amenityItemList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<PropertyAssignAssetModel>>> response = new ResponseEntity<JsonResponse<List<PropertyAssignAssetModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: get all Details ends");

		return response;
	}

	
	/*
	 * for modal view of assign asset
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<PropertyAssignAssetModel>> getAssignedAssetById(String id, String an) {

		logger.info("Method in Dao: getAssignedAssetById Starts");

		List<PropertyAssignAssetModel> assignAssetList = new ArrayList<PropertyAssignAssetModel>();

		try {

			String value = "SET @p_property='" + id + "',@p_assetCode='" + an + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("AssignAsset")
					.setParameter("actionType", "viewEditAssignAsset").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				PropertyAssignAssetModel assignAsset = new PropertyAssignAssetModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9],m[10],null);
				assignAssetList.add(assignAsset);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<PropertyAssignAssetModel> resp = new JsonResponse<PropertyAssignAssetModel>();
		resp.setBody(assignAssetList.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<PropertyAssignAssetModel>> response = new ResponseEntity<JsonResponse<PropertyAssignAssetModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getAssignedAssetById ends");

		return response;
	}

	/*
	 * for delete Assigned Asset
	 */
	public ResponseEntity<JsonResponse<Object>> deleteAssignedAsset(String id, String ac,String createdBy) {

		logger.info("Method : delete Assigned Asset ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_property='" + id + "',@p_assetCode='" + ac +"',@p_createdBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("AssignAsset").setParameter("actionType", "deleteAssignedAsset")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();

			String[] err = serverDao.errorProcedureCall(e);
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : delete Assigned Aset ends");

		return response;
	}

}
