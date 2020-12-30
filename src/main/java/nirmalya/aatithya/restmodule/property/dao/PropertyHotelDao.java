/**
 * Defines property hotel DAO
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
import nirmalya.aatithya.restmodule.common.utils.GenerateHotelParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.ServerValidation;
import nirmalya.aatithya.restmodule.property.controller.PropertyFloorRestController;
import nirmalya.aatithya.restmodule.property.model.PropertyFloorModel;
import nirmalya.aatithya.restmodule.property.model.PropertyHotelModel;

/**
 * @author Nirmalya Labs
 *
 */

@Repository
public class PropertyHotelDao {
	Logger logger = LoggerFactory.getLogger(PropertyHotelDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	EntityManager em;

	/**
	 * DAO Function to add property hotel and edit
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> addHotel(PropertyHotelModel form) {
		logger.info("Method : addHotel starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (form.getHotelName() == null || form.getHotelName() == "") {
			resp.setMessage("hotel Name required");

			validity = false;

		} else if (form.getHotelAdress() == null || form.getHotelAdress() == "") {
			resp.setMessage("hotel adress required");
			validity = false;

		} else if (form.getState() == null || form.getState() == "") {
			resp.setMessage("state required");
			validity = false;

		} else if (form.getHotelPin() == null || form.getHotelPin() == "") {
			resp.setMessage("pin required");
			validity = false;

		} else if (form.getHotelCity() == null || form.getHotelCity() == "") {
			resp.setMessage("city required");
			validity = false;
		} else if (form.getHotelPhone() == null || form.getHotelPhone() == "") {
			resp.setMessage("phone no required");
			validity = false;

		} else if (form.getHotelWebsite() == null || form.getHotelWebsite() == "") {
			resp.setMessage("website required");
			validity = false;

		} else if (form.getHotelRegdNo() == null || form.getHotelRegdNo() == "") {
			resp.setMessage("regdno required");
			validity = false;

		} else if (form.getHotelCountry() == null || form.getHotelCountry() == "") {
			resp.setMessage("country required");
			validity = false;

		} else if (form.getDistrict() == null || form.getDistrict() == "") {
			resp.setMessage("deistrict required");
			validity = false;

		} else if (form.getHotelEmail() == null || form.getHotelEmail() == "") {
			resp.setMessage("email required");
			validity = false;

		} else if (form.getHotelTin() == null || form.getHotelTin() == "") {
			resp.setMessage("TIN required");
			validity = false;
			
		} else if (form.getHotelLogo() == null || form.getHotelLogo() == "") {
			resp.setMessage("Logo required");
			validity = false;
			
		} else if (form.getHotelCreatedBy() == null || form.getHotelCreatedBy() == "") {
			//resp.setMessage("Logo required");
			validity = false;	

		} else if (form.getHotelStatus() == null) {
			resp.setMessage("status required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateHotelParameter.getAddHotelParam(form);

				if (form.getHotelId() != null && form.getHotelId() != "") {
					em.createNamedStoredProcedureQuery("hotelRoutines").setParameter("actionType", "modifyHotel")
							.setParameter("actionValue", values).execute();
				} else {

					em.createNamedStoredProcedureQuery("hotelRoutines").setParameter("actionType", "addHotel")
							.setParameter("actionValue", values).execute();
				}
				resp.setCode("Data Saved Successfully");
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
		logger.info("Method : addHotel end");
		return response;
	}

	/**
	 * DAO Function for drop down models state name
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStatename() {
		logger.info("Method : getStatename starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hoteldropdownRoutines")
					.setParameter("actionType", "getState").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getStatename end");
		return stateList;
	}

	/*
	 * drop down for district name
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getdistName(String state) {
		logger.info("Method : getStatename starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		String value = "SET @p_state='" + state + "';";
		System.out.println(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hoteldropdownRoutines")
					.setParameter("actionType", "getDistNameId").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(stateList);
		logger.info("Method : getStatename end");
		return stateList;
	}

	/*
	 * Drop down for district list by state name
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDistname(String state) {

		logger.info("Method : getPropertTypeName starts");

		List<DropDownModel> amenityNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_state='" + state + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hoteldropdownRoutines")
					.setParameter("actionType", "getDistrict").setParameter("actionValue", value).getResultList();

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

	/**
	 * DAO Function to view property hotel
	 *
	 */
	public ResponseEntity<JsonResponse<List<PropertyHotelModel>>> getAllHotel(DataTableRequest request) {
		logger.info("Method : getAllHotel starts");
		List<PropertyHotelModel> form = new ArrayList<PropertyHotelModel>();

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("hotelRoutines")
					.setParameter("actionType", "viewAllHotel").setParameter("actionValue", values).getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					PropertyHotelModel hotel = new PropertyHotelModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
							m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15],m[16],m[17]);
					form.add(hotel);
				}

				if (x.get(0).length > 18) {
					BigInteger t = (BigInteger) x.get(0)[18];

					total = Integer.parseInt((t.toString()));
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<PropertyHotelModel>> resp = new JsonResponse<List<PropertyHotelModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<PropertyHotelModel>>> response = new ResponseEntity<JsonResponse<List<PropertyHotelModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getAllHotel end");
		return response;
	}

	/**
	 * DAO Function to delete property hotel
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteHotel(String id,String createdBy) {
		logger.info("Method : deleteHotel starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_hotelId='" + id + "',@p_createdBy='" + createdBy +"';";

			em.createNamedStoredProcedureQuery("hotelRoutines").setParameter("actionType", "deleteHotel")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			String[] err = ServerValidation.geterror(e);

			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : deleteHotel end");
		return response;
	}

	/**
	 * DAO Function for edit property hotel
	 *
	 */
	public ResponseEntity<JsonResponse<PropertyHotelModel>> getHotelById(String id, String action) {
		logger.info("Method : getHotelById starts");

		List<PropertyHotelModel> form = new ArrayList<PropertyHotelModel>();

		try {
			String value = "SET @p_hotelId='" + id + "';";

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("hotelRoutines").setParameter("actionType", action)
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				PropertyHotelModel hotel = new PropertyHotelModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8],
						m[9], m[10], m[11], m[12], m[13], m[14], m[15],m[16],m[17]);
				form.add(hotel);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<PropertyHotelModel> resp = new JsonResponse<PropertyHotelModel>();
		resp.setBody(form.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<PropertyHotelModel>> response = new ResponseEntity<JsonResponse<PropertyHotelModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getHotelById end");
		return response;

	}
}
