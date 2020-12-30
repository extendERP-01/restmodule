/**
 * Defines property property master DAO
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
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GeneratePropertyMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.model.PropertyMasterModel;

/**
 * @author Nirmalya Labs pvt
 *
 */

@Repository
public class PropertyMasterDao {
	Logger logger = LoggerFactory.getLogger(PropertyMasterDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to add property property master and edit
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> addPropertyMaster(PropertyMasterModel form) {
		logger.info("Method : addPropertyMaster starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (form.getPropertyName() == null || form.getPropertyName() == "") {
			resp.setMessage("property Name required");

			validity = false;

		} else if (form.getPropertyCategory() == null || form.getPropertyCategory() == "") {
			resp.setMessage("property category required");
			validity = false;

		} else if (form.getPropertyCreatedBy() == null || form.getPropertyCreatedBy() == "") {
			// resp.setMessage("property category required");
			validity = false;

		} else if (form.getPropertyType() == null || form.getPropertyType() == "") {
			resp.setMessage("property type required");
			validity = false;

		} else if (form.getPropertyDescription() == null || form.getPropertyDescription() == "") {
			resp.setMessage("property description required");
			validity = false;

		} else if (form.getPropertyFloor() == null || form.getPropertyFloor() == "") {
			resp.setMessage("property floor required");
			validity = false;

		} else if (form.getCleanStatus() == null) {
			resp.setMessage("Clean status required");
			validity = false;
		} else if (form.getPropertyActive() == null) {
			resp.setMessage("status required");
			validity = false;

		}

		if (validity)
			try {
				String values = GeneratePropertyMasterParameter.getAddPropertyMasterParam(form);

				if (form.getPropertyId() != null && form.getPropertyId() != "") {
					em.createNamedStoredProcedureQuery("propertyMaster")
							.setParameter("actionType", "modifyPropertyMaster").setParameter("actionValue", values)
							.execute();
				} else {

					em.createNamedStoredProcedureQuery("propertyMaster").setParameter("actionType", "addPropertyMaster")
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
		logger.info("Method : addPropertyMaster end");
		return response;
	}

	/**
	 * DAO Function for drop down models
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCategoryName() {
		logger.info("Method : getCategoryName starts");
		List<DropDownModel> categoryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("propertyMasterDropDown")
					.setParameter("actionType", "getPropertyCategory").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				categoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getCategoryName end");
		return categoryList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getTypeName() {
		logger.info("Method : getTypeName starts");
		List<DropDownModel> typeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("propertyMasterDropDown")
					.setParameter("actionType", "getPropertyType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				typeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTypeName end");
		return typeList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getFloorName() {
		logger.info("Method : getFloorName starts");
		List<DropDownModel> floorList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("propertyMasterDropDown")
					.setParameter("actionType", "getPropertyFloor").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				floorList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getFloorName end");
		return floorList;
	}

	/**
	 * Drop down for property type
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPropertTypeName(String proCatId) {

		logger.info("Method : getPropertTypeName starts");

		List<DropDownModel> typeList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_propertyCategory='" + proCatId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("propertyMasterDropDown")
					.setParameter("actionType", "getPropertyTypeList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				typeList.add(dropDownModel);

			}

			resp.setBody(typeList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getPropertTypeName ends");
		return response;
	}

	/**
	 * DAO Function to view property master
	 *
	 */
	public ResponseEntity<JsonResponse<List<PropertyMasterModel>>> getAllPropertyMaster(DataTableRequest request) {
		logger.info("Method : getAllPropertyMaster starts");
		List<PropertyMasterModel> form = new ArrayList<PropertyMasterModel>();

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("propertyMaster")
					.setParameter("actionType", "viewAllMaster").setParameter("actionValue", values).getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					PropertyMasterModel propertyMaster = new PropertyMasterModel(m[0], m[1], m[2], m[3], m[4], m[5],
							m[6], m[7], m[8], m[9]);
					form.add(propertyMaster);
				}

				if (x.get(0).length > 10) {
					BigInteger t = (BigInteger) x.get(0)[10];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonResponse<List<PropertyMasterModel>> resp = new JsonResponse<List<PropertyMasterModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<PropertyMasterModel>>> response = new ResponseEntity<JsonResponse<List<PropertyMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getAllPropertyMaster end");
		return response;
	}

	/**
	 * DAO Function to delete property master
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deletePropertyMaster(String id, String createdBy) {
		logger.info("Method : deletePropertyMaster starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_propertyId='" + id + "',@p_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("propertyMaster").setParameter("actionType", "deletePropMstr")
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

		logger.info("Method : deletePropertyMaster end");
		return response;
	}

	/**
	 * DAO Function for edit property master
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<PropertyMasterModel>> getPropertyMasterById(String id, String action) {
		logger.info("Method : getPropertyMasterById starts");

		List<PropertyMasterModel> form = new ArrayList<PropertyMasterModel>();

		try {
			String value = "SET @p_propertyId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("propertyMaster").setParameter("actionType", action)
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				PropertyMasterModel propertyMaster = new PropertyMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9]);
				form.add(propertyMaster);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<PropertyMasterModel> resp = new JsonResponse<PropertyMasterModel>();
		resp.setBody(form.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<PropertyMasterModel>> response = new ResponseEntity<JsonResponse<PropertyMasterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getPropertyMasterById end");
		return response;

	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getTypeNameEdit(String proCatId) {

		List<DropDownModel> typeList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_propertyCategory='" + proCatId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("propertyMasterDropDown")
					.setParameter("actionType", "getPropertyTypeList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				typeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return typeList;
	}
}
