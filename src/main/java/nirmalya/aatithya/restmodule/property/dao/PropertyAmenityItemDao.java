/*
 * Dao for Amenity item 
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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAmenityItemParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

import nirmalya.aatithya.restmodule.property.model.PropertyAmenityItemModel;

@Repository
public class PropertyAmenityItemDao {

	Logger logger = LoggerFactory.getLogger(PropertyAmenityItemDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	/*
	 * drop down for property category
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getItemName() {
		logger.info("Method in Dao: getItemName starts");
		List<DropDownModel> ItemCategoryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("AmenityItem")
					.setParameter("actionType", "getItemCategory").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				ItemCategoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getItemName ends");
		
		return ItemCategoryList;
	}
	/*
	 * drop down for propertyType id
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPropertyId() {
		logger.info("Method in Dao: getPropertyId starts");
		
		List<DropDownModel> propertyTypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("AmenityItem")
					.setParameter("actionType", "getPropertyId").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				propertyTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getPropertyId ends");
		
		return propertyTypeList;
	}

	/*
	 * drop down for Amenity List
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAmenityList() {
		
		logger.info("Method in Dao: getAmenityList starts");
		
		List<DropDownModel> AmenityList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("AmenityItem")
					.setParameter("actionType", "getAmenityList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				AmenityList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getAmenityList ends");
		
		return AmenityList;
	}
	
	/*
	 * drop down for  getPropertyNameId used for search in assign asset view page
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPropertyNameId() {
		
		logger.info("Method in Dao: getAmenityList starts");
		
		List<DropDownModel> propertyNameById = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("AmenityItem")
					.setParameter("actionType", "getPropertyNameId").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				propertyNameById.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getAmenityList ends");
		
		return propertyNameById;
	}
	

	/*
	 * drop down for Amenity List
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSubCategory() {
		
		logger.info("Method in Dao: getSubCategory starts");
		
		List<DropDownModel> subCategoryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("AmenityItem")
					.setParameter("actionType", "getSubCategory").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				subCategoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getSubCategory ends");
		
		return subCategoryList;
	}

	/*
	 * drop down for Item Name List
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getItemNameList() {
		
		logger.info("Method in Dao: getItemNameList starts");
		
		List<DropDownModel> ItemNameList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("AmenityItem")
					.setParameter("actionType", "getItemNames").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				ItemNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method in Dao: getItemNameList ends");

		return ItemNameList;
	}

	
	/*
	 * Drop down for property type
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPropertTypeName(String proCatId) {
		
		logger.info("Method : getPropertTypeName starts");

		List<DropDownModel> amenityNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_propertyCategory='" + proCatId + "';";

		
			List<Object[]> x = em.createNamedStoredProcedureQuery("AmenityItem")
					.setParameter("actionType", "getPropertTypeNameId").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				amenityNameList.add(dropDownModel);
			}
			
			resp.setBody(amenityNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		 logger.info("Method : getPropertTypeName ends");
		 System.out.println("res: "+response);
		 return response;
	}

	
	/*
	 * Drop down for property type for id 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPropertType(String proCatId) {
		
		logger.info("Method : getPropertTypeName starts");

		List<DropDownModel> amenityNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_propertyCategory='" + proCatId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("AmenityItem")
					.setParameter("actionType", "getPropertTypeId").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				amenityNameList.add(dropDownModel);
			}

			resp.setBody(amenityNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		 logger.info("Method : getPropertTypeName ends");
		return response;
	}
	
	/*
	 * Drop down for property type
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAmenityName(String proType) {
		  logger.info("Method : getAmenityTypeName starts");

		List<DropDownModel> amenityNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_propertyType='" + proType + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("AmenityItem")
					.setParameter("actionType", "getAmenityName").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				amenityNameList.add(dropDownModel);
			}

			resp.setBody(amenityNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
System.out.println(response);
		  logger.info("Method : getAmenityTypeName ends");
		return response;
	}

	/*
	 * Drop down for Item Category
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCategoryName(String proCategoryId) {
		 logger.info("Method in Dao: getCategoryName starts");

		List<DropDownModel> amenityNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_ItemCategory='" + proCategoryId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("AmenityItem")
					.setParameter("actionType", "getSubCategoryByCat").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				amenityNameList.add(dropDownModel);
			}

			resp.setBody(amenityNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		  logger.info("Method : getCategoryName ends");
		return response;
	}

	/*
	 * Drop down for  Amenity Item 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemList(String ItemSubCat) {
		  logger.info("Method : getItemList starts");

		List<DropDownModel> amenityNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_ItemSubCat='" + ItemSubCat + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("AmenityItem")
					.setParameter("actionType", "getItemNameList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				amenityNameList.add(dropDownModel);
			}

			resp.setBody(amenityNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		  logger.info("Method : getItemList ends");
		return response;
	}

	/*
	 * for add new Amenity Item
	 */
	public ResponseEntity<JsonResponse<Object>> addAmenityItem(PropertyAmenityItemModel amenityItem) {

		logger.info("Method in Dao:Add  Amenity Item starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (amenityItem.getPropertyType() == null || amenityItem.getPropertyType() == "") {
			resp.setMessage("Property Type Not Selected");
			validity = false;
		} else if (amenityItem.getAmenities() == null || amenityItem.getAmenities() == "") {
			resp.setMessage("Aminity Not Selected");
			validity = false;
		} else if (amenityItem.getAmntyItemActive() == null) {
			resp.setMessage("Status not Selected");
			validity = false;
		} else if (amenityItem.getItem() == null || amenityItem.getItem() == "") {
			resp.setMessage("Item Category required");
			validity = false;
		} else if (amenityItem.getAmenityItemQty() == null) {
			resp.setMessage("Quantity Required");
			validity = false;
		}

		if (validity)
			try {
				
				String values = GenerateAmenityItemParameter.getAddAmenityItemParam(amenityItem);
				em.createNamedStoredProcedureQuery("AmenityItem").setParameter("actionType", "addAmenityItem")
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

		logger.info("Method in Dao: add Amenity Item ends");

		return response;
	}

	/*
	 * for all theme details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PropertyAmenityItemModel>>> getAllAmenityItem(DataTableRequest request) {

		logger.info("Method in Dao: get all Details starts");

		List<PropertyAmenityItemModel> amenityItemList = new ArrayList<PropertyAmenityItemModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("AmenityItem")
					.setParameter("actionType", "viewAllAmenityItem").setParameter("actionValue", values)
					.getResultList();

			if(!x.isEmpty()) {
				
			for (Object[] m : x) {
				PropertyAmenityItemModel amenityItem = new PropertyAmenityItemModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], null,null, null,m[8]);
				amenityItemList.add(amenityItem);

			}
			if (x.get(0).length > 9) {
				BigInteger t = (BigInteger) x.get(0)[9];

				total = Integer.parseInt((t.toString()));
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<PropertyAmenityItemModel>> resp = new JsonResponse<List<PropertyAmenityItemModel>>();
		resp.setBody(amenityItemList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<PropertyAmenityItemModel>>> response = new ResponseEntity<JsonResponse<List<PropertyAmenityItemModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: get all Details ends");

		return response;
	}

	/*
	 * for edit Amenity item
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<PropertyAmenityItemModel>> getAmenityItemById(String id,String am,String itm) {

		logger.info("Method in Dao: get Amenity Item ById Starts");
		

		List<PropertyAmenityItemModel> amenityItemList = new ArrayList<PropertyAmenityItemModel>();
  
		try {

			String value = "SET @p_propertyType='" + id +"',@p_amenity='" + am + "',@p_item='" + itm + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("AmenityItem")
					          .setParameter("actionType", "viewEditAmenityItem")
					          .setParameter("actionValue", value)
					          .getResultList();

			for (Object[] m : x) {
				PropertyAmenityItemModel amenityItem = new PropertyAmenityItemModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8],m[9],m[10],m[11]);
				amenityItemList.add(amenityItem);

			}


		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<PropertyAmenityItemModel> resp = new JsonResponse<PropertyAmenityItemModel>();
		resp.setBody(amenityItemList.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<PropertyAmenityItemModel>> response = new ResponseEntity<JsonResponse<PropertyAmenityItemModel>>(resp,
				responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: get Amenity Item ById ends");

		return response;
	}
	/*
	 * for edit Amenity item
	 */
	public ResponseEntity<JsonResponse<Object>> editAmenityItem(PropertyAmenityItemModel amenityItem) {

		logger.info("Method in Dao: idit Amenity Item starts");

		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		
			try {
				String values = GenerateAmenityItemParameter.getAddAmenityItemParam(amenityItem);

				em.createNamedStoredProcedureQuery("AmenityItem").setParameter("actionType", "editAmenityItem")
						.setParameter("actionValue", values).execute();

			} catch (Exception e) {
				e.printStackTrace();
				
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: edit Amenity Item ends");

		return response;
	}
	
}
