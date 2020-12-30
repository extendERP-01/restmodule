/**
 * Dao For AssignConsumedItems
 */
package nirmalya.aatithya.restmodule.property.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import ch.qos.logback.classic.Logger;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GeneratePropertyAssignConsumedItemParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.model.PropertyAssignConsumedItemModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class PropertyAssignedConsumedItemDao {

	Logger logger = (Logger) LoggerFactory.getLogger(PropertyAssignedConsumedItemDao.class);
	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getItemCategory() {
		logger.info("Method : getItemCategory starts");
		List<DropDownModel> itemCategoryList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignedConsumeItemsRoutines")
					.setParameter("actionType", "getItemCategoryList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemCategoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getItemCategory ends");
		return itemCategoryList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemSubCategory(String id) {
		logger.info("Method : getItemSubCategory starts");
		List<DropDownModel> itemSubCategoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_itemCategory='" + id + "';";
		// System.out.println("value is ="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignedConsumeItemsRoutines")
					.setParameter("actionType", "getItemSubCatList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemSubCategoryList.add(dropDownModel);
			}

			resp.setBody(itemSubCategoryList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemSubCategory ends");
		// System.out.println("response"+response);
		return response;
	}

	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemName(String id) {
		logger.info("Method : getItemName starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_itemSubCategory='" + id + "';";
		System.out.println(value);
		try {
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignedConsumeItemsRoutines")
					.setParameter("actionType", "getItemNameList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
			}

			resp.setBody(itemNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemName ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPropertyCategory() {
		logger.info("Method : getPropertyName starts");

		List<DropDownModel> propertyCategoryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignedConsumeItemsRoutines")
					.setParameter("actionType", "propertyCategory").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				propertyCategoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPropertyName ends");

		return propertyCategoryList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPropertyName(String id) {
		logger.info("Method : getPropertyName starts");
		List<DropDownModel> propertyNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_propertyCategory='" + id + "';";
		// System.out.println(value);
		try {
			// @SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignedConsumeItemsRoutines")
					.setParameter("actionType", "propertyName").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				propertyNameList.add(dropDownModel);
			}
			// System.out.println("propertyNameList="+propertyNameList);
			resp.setBody(propertyNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getPropertyName ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addAssignConsumed(
			PropertyAssignConsumedItemModel propertyAssignConsumedItemModel) {
		logger.info("Method : addAssignConsumed starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println(propertyAssignConsumedItemModel);
		resp.setMessage("");
		resp.setCode("");

		if (propertyAssignConsumedItemModel.getPropertyCategory() == null
				|| propertyAssignConsumedItemModel.getPropertyCategory() == "") {
			resp.setMessage("PropertyCategory required");
			validity = false;
		} else if (propertyAssignConsumedItemModel.getPropertyNameId() == null
				|| propertyAssignConsumedItemModel.getPropertyNameId() == "") {
			System.out.println(propertyAssignConsumedItemModel.getPropertyNameId());
			resp.setMessage("PropertyName required");
			validity = false;
		} else if (propertyAssignConsumedItemModel.getAmenity() == null
				|| propertyAssignConsumedItemModel.getAmenity() == "") {
			System.out.println(propertyAssignConsumedItemModel.getAmenity());
			resp.setMessage("AmenityName required");
			validity = false;
		} else if (propertyAssignConsumedItemModel.getItemCategory() == null
				|| propertyAssignConsumedItemModel.getItemCategory() == "") {
			resp.setMessage("ItemCategory required");
			validity = false;
		} else if (propertyAssignConsumedItemModel.getItemSubCategory() == null
				|| propertyAssignConsumedItemModel.getItemSubCategory() == "") {
			resp.setMessage("ItemCategory required");
			validity = false;
		} else if (propertyAssignConsumedItemModel.getItemNameId() == null
				|| propertyAssignConsumedItemModel.getItemNameId() == "") {
			resp.setMessage("ItemName required");
			validity = false;
		}

		else if (propertyAssignConsumedItemModel.getAssignQuantity() == null) {
			resp.setMessage("AssignQuantity Required ");
			validity = false;
		} else if (propertyAssignConsumedItemModel.getAssignActive() == null) {
			resp.setMessage("Status Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GeneratePropertyAssignConsumedItemParameter
						.addAssignConsume(propertyAssignConsumedItemModel);
				System.out.println(propertyAssignConsumedItemModel);
				em.createNamedStoredProcedureQuery("assignedConsumeItemsRoutines")
						.setParameter("actionType", "addAssignConsume").setParameter("actionValue", values).execute();

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
		logger.info("Method : addAssignConsumed ends");
		// System.out.println("addgoodsreturn"+response);
		return response;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PropertyAssignConsumedItemModel>>> getAllAssignConsumed(
			DataTableRequest request) {
		logger.info("Method : getAllAssignConsumed starts");

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

		List<PropertyAssignConsumedItemModel> propertyAssignConsumedItemModel = new ArrayList<PropertyAssignConsumedItemModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("assignedConsumeItemsRoutines")
					.setParameter("actionType", "viewAssign").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				Object createdOnDate = DateFormatter.returnStringDate(m[10]);
				PropertyAssignConsumedItemModel itmCat = new PropertyAssignConsumedItemModel(m[0], m[1], m[2], m[3],
						m[4], m[5], m[6], m[7], m[8], m[9], null,createdOnDate);
				propertyAssignConsumedItemModel.add(itmCat);
			}
			if (x.get(0).length > 11) {
				BigInteger t = (BigInteger) x.get(0)[11];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<PropertyAssignConsumedItemModel>> resp = new JsonResponse<List<PropertyAssignConsumedItemModel>>();
		resp.setBody(propertyAssignConsumedItemModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<PropertyAssignConsumedItemModel>>> response = new ResponseEntity<JsonResponse<List<PropertyAssignConsumedItemModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAllAssignConsumed ends");
		//System.out.println("response=="+response);
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteAssignConsumedItem(String id, String ac, String createdBy) {
		logger.info("Method Dao: deleteAssignConsumedItem starts");
		//System.out.println("id=" + id + " ac=" + ac);
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_propertyNameId='" + id + "',@p_itemNameId='" + ac + "',@p_createdBy='" + createdBy
					+ "';";
			System.out.println("value=" + value);
			em.createNamedStoredProcedureQuery("assignedConsumeItemsRoutines")
					.setParameter("actionType", "deleteConsume").setParameter("actionValue", value).execute();

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

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method Dao: deleteAssignConsumedItem ends");
		System.out.println("response in delete dao " + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<PropertyAssignConsumedItemModel>> modalViewAssignConsume(String id, String an) {
		logger.info("Method in Dao: modalViewAssignConsume Starts");

		List<PropertyAssignConsumedItemModel> propertyAssignConsumedItemModel = new ArrayList<PropertyAssignConsumedItemModel>();

		try {

			String value = "SET @p_propertyNameId='" + id + "',@p_itemNameId='" + an + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("assignedConsumeItemsRoutines")
					.setParameter("actionType", "modalViewConsume").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				PropertyAssignConsumedItemModel consumeItem = new PropertyAssignConsumedItemModel(m[0], m[1], m[2],
						m[3], m[4], m[5], m[6], m[7], m[8], m[9], null,null);
				propertyAssignConsumedItemModel.add(consumeItem);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<PropertyAssignConsumedItemModel> resp = new JsonResponse<PropertyAssignConsumedItemModel>();
		resp.setBody(propertyAssignConsumedItemModel.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<PropertyAssignConsumedItemModel>> response = new ResponseEntity<JsonResponse<PropertyAssignConsumedItemModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: modalViewAssignConsume ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getProperty() {
		logger.info("Method : getProperty starts");
		List<DropDownModel> propertyName = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignedConsumeItemsRoutines")
					.setParameter("actionType", "property").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				propertyName.add(dropDownModel);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getProperty ends");
		return propertyName;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getItem() {
		logger.info("Method : getItem starts");
		List<DropDownModel> item = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignedConsumeItemsRoutines")
					.setParameter("actionType", "item").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				item.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getItem ends");
		return item;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PropertyAssignConsumedItemModel>>> getAssignConsumedPdf(
			DataTableRequest request) {
		logger.info("Method : getAssignConsumedPdf starts");
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

		List<PropertyAssignConsumedItemModel> propertyAssignConsumedItemModel = new ArrayList<PropertyAssignConsumedItemModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> y = em.createNamedStoredProcedureQuery("assignedConsumeItemsRoutines")
					.setParameter("actionType", "viewPdf").setParameter("actionValue", values).getResultList();

			for (Object[] m : y) {
				PropertyAssignConsumedItemModel itmCat = new PropertyAssignConsumedItemModel(m[0], m[1], m[2], m[3],
						m[4], m[5], m[6], m[7], m[8], m[9], null,null);
				propertyAssignConsumedItemModel.add(itmCat);
			}
			if (y.get(0).length > 10) {
				BigInteger t = (BigInteger) y.get(0)[10];
				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<PropertyAssignConsumedItemModel>> resp = new JsonResponse<List<PropertyAssignConsumedItemModel>>();
		resp.setBody(propertyAssignConsumedItemModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<PropertyAssignConsumedItemModel>>> response = new ResponseEntity<JsonResponse<List<PropertyAssignConsumedItemModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAssignConsumedPdf ends");
		return response;
	}

	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAmenityName(String id) {
		logger.info("Method : getAmenityName starts");
		List<DropDownModel> amenityNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_propertyNameId='" + id + "';";
		try {
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignedConsumeItemsRoutines")
					.setParameter("actionType", "getAmenity").setParameter("actionValue", value).getResultList();
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
		logger.info("Method : getAmenityName ends");
		return response;
	}

	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemCategoryName(String id) {
		logger.info("Method : getItemCategoryName starts");
		List<DropDownModel> itemCategoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_amenity='" + id + "';";
		try {
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignedConsumeItemsRoutines")
					.setParameter("actionType", "getItemByAmenity").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemCategoryList.add(dropDownModel);
			}

			resp.setBody(itemCategoryList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemCategoryName ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PropertyAssignConsumedItemModel>>> getAssignConsumedReport(
			DataTableRequest request) {
		logger.info("Method : getAssignConsumedReport starts");
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

		List<PropertyAssignConsumedItemModel> propertyAssignConsumedItemModel = new ArrayList<PropertyAssignConsumedItemModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> y = em.createNamedStoredProcedureQuery("assignedConsumeItemsRoutines")
					.setParameter("actionType", "viewPdf").setParameter("actionValue", values).getResultList();

			for (Object[] m : y) {
				PropertyAssignConsumedItemModel itmCat = new PropertyAssignConsumedItemModel(m[0], m[1], m[2], m[3],
						m[4], m[5], m[6], m[7], m[8], m[9], null,null);
				propertyAssignConsumedItemModel.add(itmCat);
			}
			if (y.get(0).length > 10) {
				BigInteger t = (BigInteger) y.get(0)[10];
				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<PropertyAssignConsumedItemModel>> resp = new JsonResponse<List<PropertyAssignConsumedItemModel>>();
		resp.setBody(propertyAssignConsumedItemModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<PropertyAssignConsumedItemModel>>> response = new ResponseEntity<JsonResponse<List<PropertyAssignConsumedItemModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAssignConsumedReport ends");
		return response;
	}

}
