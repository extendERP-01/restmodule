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
import nirmalya.aatithya.restmodule.common.utils.GenerateAmenityParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.model.AmenityForm;

@Repository
public class PropertyAmenityDao {

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	Logger logger = LoggerFactory.getLogger(PropertyAmenityDao.class);
	/*
	 * for property category
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPropertyName() {
		
		logger.info("Method : getPropertyCatogory starts");
		
		List<DropDownModel> propertyNameList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("getPropertyName")
					.setParameter("actionType", "getPropertyCatogory")
					.setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				propertyNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPropertyCatogory ends");
		System.out.println("propertyNameList: "+propertyNameList);
		return propertyNameList;
	}
/*
 * add amenity
 */
	public ResponseEntity<JsonResponse<Object>> addAmenity(AmenityForm addAmenity) {

		logger.info("Method : addAmenity starts");
		
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (addAmenity.getAmntsName() == null || addAmenity.getAmntsName() == "") {
			resp.setMessage("Amenity Name Required");
			validity = false;
		} else if (addAmenity.getPropertyCategoryId() == null || addAmenity.getPropertyCategoryId() == "") {
			resp.setMessage("Property Name Required");
			validity = false;
		} else if (addAmenity.getAmntsActive() == null) {
			resp.setMessage("Status Required");
			validity = false;
		} else if (addAmenity.getAmntsDescription() == null || addAmenity.getAmntsDescription() == "") {
			resp.setMessage("Desctiption Required");
			validity = false;
		}
		 else if (addAmenity.getCreatedBy() == null || addAmenity.getCreatedBy()== "") {
				resp.setMessage("Created By Required");
				validity = false;
		}

		if (validity)
			try {
				String values = GenerateAmenityParameter.getAmenityParam(addAmenity);

				if (addAmenity.getAmenitiesId()==null || addAmenity.getAmenitiesId()=="") {
					
					em.createNamedStoredProcedureQuery("add_Amenity").setParameter("actionType", "addAmenity")
							.setParameter("actionValue", values).execute();
				} else {
			
					em.createNamedStoredProcedureQuery("add_Amenity").setParameter("actionType", "editAmenity")
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
		
		logger.info("Method : addAmenity ends");
		
		return response;
	}
/*
 *  for view of all amenity
 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AmenityForm>>> getAllAmenityList(DataTableRequest request) {

		logger.info("Method : getAllAmenityList starts");
		
		List<AmenityForm> amenity = new ArrayList<AmenityForm>();

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("add_Amenity")
					.setParameter("actionType", "viewAllAmenity").setParameter("actionValue", values).getResultList();
			
			for (Object[] m : x) {
				AmenityForm act = new AmenityForm(m[0], m[1], m[2], m[3], m[4], m[5]);
				amenity.add(act);
			}

			

			if (x.get(0).length > 6) {
				BigInteger t = (BigInteger) x.get(0)[6];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<AmenityForm>> resp = new JsonResponse<List<AmenityForm>>();
		resp.setBody(amenity);
		resp.setTotal(total);

		

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AmenityForm>>> response = new ResponseEntity<JsonResponse<List<AmenityForm>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getAllAmenityList ends");
		
		return response;
	}
/*
 * get amenity by id
 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<AmenityForm>> getAmenitytById(String id) {

		logger.info("Method : getAmenitytById starts");
		
		List<AmenityForm> amenityById = new ArrayList<AmenityForm>();

		try {

			String value = "SET @Amenities='" + id + "';";

			
			List<Object[]> x = em.createNamedStoredProcedureQuery("add_Amenity")
					.setParameter("actionType", "viewAmenity").setParameter("actionValue", value).getResultList();
		
			for (Object[] m : x) {
				AmenityForm user = new AmenityForm(m[0], m[1], m[2], m[3], m[4], m[5]);
				amenityById.add(user);
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		JsonResponse<AmenityForm> resp = new JsonResponse<AmenityForm>();
		resp.setBody(amenityById.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<AmenityForm>> response = new ResponseEntity<JsonResponse<AmenityForm>>(resp,
				responseHeaders, HttpStatus.CREATED);
	
		logger.info("Method : getAmenitytById ends");
		
		return response;
	}
/*
 * delete amenity
 */
	public ResponseEntity<JsonResponse<Object>> deleteAmenityById(String id , String createdBy) {

		logger.info("Method : deleteAmenityById starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @Amenities='" + id +"',@createdBy='"+createdBy+ "';";
			em.createNamedStoredProcedureQuery("add_Amenity").setParameter("actionType", "deleteAmenity")
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
		
		logger.info("Method : deleteAmenityById ends");
		return response;
	}
}
