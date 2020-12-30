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
import nirmalya.aatithya.restmodule.common.utils.GeneratePropertyParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.model.PropertyTypeForm;

/**
 * @author Nirmalya Labs
 *
 */

@Repository
public class PropertyTypeDao {

	Logger logger = LoggerFactory.getLogger(PropertyTypeDao.class);

	@Autowired
	private EntityManager em;
	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to View all Properties
	 *
	 */

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAmenityTypeNameEdit(String proCatId) {

		List<DropDownModel> amenityNameList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_propertyCategory='" + proCatId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("addPropertyType")
					.setParameter("actionType", "getAmenityType").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				amenityNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return amenityNameList;
	}
/*
 * get amenity type name
 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAmenityTypeName(String proCatId) {
		logger.info("Method : getAmenityTypeName starts");

		List<DropDownModel> amenityNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_propertyCategory='" + proCatId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("addPropertyType")
					.setParameter("actionType", "getAmenityType").setParameter("actionValue", value).getResultList();

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

		logger.info("Method : getAmenityTypeName ends");
		return response;
	}
/*
 * Add property type
 */
	public ResponseEntity<JsonResponse<Object>> addPropertyType(PropertyTypeForm propertyTypeForm) {
		logger.info("Method : addPropertyType starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (propertyTypeForm.getpTypeName() == null || propertyTypeForm.getpTypeName() == "") {
			resp.setMessage("Amenity Name Required");
			validity = false;
		} else if (propertyTypeForm.getPropertyCategory() == null || propertyTypeForm.getPropertyCategory() == "") {
			resp.setMessage("Property Catagory Required");
			validity = false;
		} else if (propertyTypeForm.getpTypeActive() == null) {
			resp.setMessage("Status Required");
			validity = false;
		} else if (propertyTypeForm.getAmenities() == null || propertyTypeForm.getAmenities() == "") {
			resp.setMessage("Amenity  Required");
			validity = false;
		} else if (propertyTypeForm.getpTypeDescription() == null || propertyTypeForm.getpTypeDescription() == "") {
			resp.setMessage("Desctiption Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GeneratePropertyParameter.getPropertyTypeParam(propertyTypeForm);

			if (propertyTypeForm.getPropertyType()!="") {
					
				em.createNamedStoredProcedureQuery("addPropertyType")
				.setParameter("actionType", "editAssignAmenity")
				.setParameter("actionValue", values).execute();
			} else {
				
				em.createNamedStoredProcedureQuery("addPropertyType")
				.setParameter("actionType", "addAssignAmenity")
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

		logger.info("Method : addPropertyType ends");
		return response;
	}
/*
 * for view  all  property type list
 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PropertyTypeForm>>> getAllPropertyTypeList(DataTableRequest request) {
		logger.info("Method : getAllPropertyTypeList starts");

		JsonResponse<List<PropertyTypeForm>> resp = new JsonResponse<List<PropertyTypeForm>>();
		List<PropertyTypeForm> propertType = new ArrayList<PropertyTypeForm>();

		Integer total = 0;

		try {

			String values = GenerateParameter.getSearchParam(request);

			List<Object[]> x = em.createNamedStoredProcedureQuery("addPropertyType")
					.setParameter("actionType", "viewAllPropertyType").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {
				PropertyTypeForm act = new PropertyTypeForm(m[0], m[1], null, m[4], null, null, m[2], m[3]);

				propertType.add(act);
			}
			
			
            if(!x.isEmpty()){
			if (x.get(0).length > 5) {
				BigInteger t = (BigInteger) x.get(0)[5];

				total = Integer.parseInt((t.toString()));
			}
            }

			resp.setBody(propertType);
			resp.setTotal(total);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<PropertyTypeForm>>> response = new ResponseEntity<JsonResponse<List<PropertyTypeForm>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAllPropertyTypeList ends");
		return response;
	}
/*
 *  get property type by id
 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PropertyTypeForm>>> getPropertyTypeById(String id) {
		logger.info("Method : getPropertyTypeById starts");

		JsonResponse<List<PropertyTypeForm>> resp = new JsonResponse<List<PropertyTypeForm>>();
		List<PropertyTypeForm> propertyById = new ArrayList<PropertyTypeForm>();

		try {

			String value = "SET @p_propertyType='" + id + "';";

			
			List<Object[]> x = em.createNamedStoredProcedureQuery("addPropertyType")
					.setParameter("actionType", "viewPropertyType").setParameter("actionValue", value).getResultList();
			
			for (Object[] m : x) {
				PropertyTypeForm user = new PropertyTypeForm(m[0], m[1], null, m[4], null, m[5], m[2], m[3]);

				propertyById.add(user);
			}

			resp.setBody(propertyById);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<PropertyTypeForm>>> response = new ResponseEntity<JsonResponse<List<PropertyTypeForm>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getPropertyTypeById ends");
		return response;
	}

	/*
	 * for edit property type
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<PropertyTypeForm>> getPropertyTypeByIdEdit(String id) {
		logger.info("Method : getPropertyTypeByIdEdit starts");

		JsonResponse<PropertyTypeForm> resp = new JsonResponse<PropertyTypeForm>();
		List<PropertyTypeForm> propertyById = new ArrayList<PropertyTypeForm>();

		try {

			String value = "SET @p_propertyType='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("addPropertyType")
								.setParameter("actionType", "editPropertyType")
								.setParameter("actionValue", value)
								.getResultList();
         
			
			for (Object[] m : x) {
				PropertyTypeForm user = new PropertyTypeForm(m[0], m[1], m[2], null, m[5], null, m[3], m[4]);

				propertyById.add(user);
			}

			resp.setBody(propertyById.get(0));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<PropertyTypeForm>> response = new ResponseEntity<JsonResponse<PropertyTypeForm>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getPropertyTypeByIdEdit end");
		return response;
	}
	
	/*
	 * for delete property type
	 */
	
	public ResponseEntity<JsonResponse<Object>> deletePropertyById(String id,String createdBy) {

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_propertyType='" + id +"',@P_createdBy='"+ createdBy + "';";
			em.createNamedStoredProcedureQuery("addPropertyType")
			.setParameter("actionType", "deletePropertyType")
			.setParameter("actionValue", value)
			.execute();

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
		
		return response;
	}
}
