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
import nirmalya.aatithya.restmodule.common.utils.GenerateAssignmentOfSeatingPlanParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.model.PropertyAssignmentOfSeatingPlanModel;

@Repository
public class PropertyAssignmentOfSeatingPlanDao {

	Logger logger = LoggerFactory.getLogger(PropertyAssignmentOfSeatingPlanDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	
	/*
	 * for property type id drop down list
	 */

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPropertyId() {
		List<DropDownModel> propertyNameList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("AssignmentOfSeatingPlan")
					.setParameter("actionType", "getPropertyId")
					.setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				propertyNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return propertyNameList;
	}

	

	/*
	 * Drop down for setting plan 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAssignmentOfSeatingPlan(String proCatId) {

		logger.info("Method : getSeatingPlanNames starts");

		List<DropDownModel> setaingPlanList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_propertyCategory='" + proCatId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("AssignmentOfSeatingPlan")
					.setParameter("actionType", "getSeatingPlanNames").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				setaingPlanList.add(dropDownModel);
			}

			resp.setBody(setaingPlanList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getSeatingPlanNames ends");
		return response;
	}

	/*
	 * drop down for sitting Name List
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSeatingPlanName() {

		logger.info("Method in Dao: getSeatingPlanName starts");

		List<DropDownModel> planNameList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("AssignmentOfSeatingPlan")
					.setParameter("actionType", "getSeatingPlanNames").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				planNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getSeatingPlanName ends");

		return planNameList;
	}

	/*
	 * drop down for Item Name List
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getUserType() {

		logger.info("Method in Dao: getUserType starts");

		List<DropDownModel> userTypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("AssignmentOfSeatingPlan")
					.setParameter("actionType", "getUserTypes").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				userTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getUserType ends");

		return userTypeList;
	}

	/*
	 * for view all assignments of seating plan
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PropertyAssignmentOfSeatingPlanModel>>> getAllAssignmentOfSeating(
			DataTableRequest request) {

		logger.info("Method in Dao: get all seating plan  Details starts");

		List<PropertyAssignmentOfSeatingPlanModel> assignmentList = new ArrayList<PropertyAssignmentOfSeatingPlanModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("AssignmentOfSeatingPlan")
					.setParameter("actionType", "viewAllAssignment").setParameter("actionValue", values)
					.getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {

					PropertyAssignmentOfSeatingPlanModel setaingPlan = new PropertyAssignmentOfSeatingPlanModel(m[0],
							m[1], m[2], m[3], m[4].toString(), m[5], m[6], m[7], m[8], m[9], m[10], null,null);
					assignmentList.add(setaingPlan);

				}

				if (x.get(0).length > 11) {
					BigInteger t = (BigInteger) x.get(0)[11];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<PropertyAssignmentOfSeatingPlanModel>> resp = new JsonResponse<List<PropertyAssignmentOfSeatingPlanModel>>();
		resp.setBody(assignmentList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<PropertyAssignmentOfSeatingPlanModel>>> response = new ResponseEntity<JsonResponse<List<PropertyAssignmentOfSeatingPlanModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: get all seating plan Details ends");

		return response;
	}

	/*
	 * for view all assignments of seating plan in pdf
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PropertyAssignmentOfSeatingPlanModel>>> getAllAssignmentSeatingPlanPdf(
			DataTableRequest request) {

		logger.info("Method in Dao: get all seating plan  Details starts");

		List<PropertyAssignmentOfSeatingPlanModel> assignmentList = new ArrayList<PropertyAssignmentOfSeatingPlanModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
              
			List<Object[]> x = em.createNamedStoredProcedureQuery("AssignmentOfSeatingPlan")
					.setParameter("actionType", "viewAllAssignmentPdf").setParameter("actionValue", values)
					.getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					PropertyAssignmentOfSeatingPlanModel setaingPlanList = new PropertyAssignmentOfSeatingPlanModel(m[0],
							m[1], m[2], m[3], m[4].toString(), m[5], m[6], m[7], m[8], m[9], m[10], null,null);
					assignmentList.add(setaingPlanList);

				}

				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<PropertyAssignmentOfSeatingPlanModel>> resp = new JsonResponse<List<PropertyAssignmentOfSeatingPlanModel>>();
		resp.setBody(assignmentList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<PropertyAssignmentOfSeatingPlanModel>>> response = new ResponseEntity<JsonResponse<List<PropertyAssignmentOfSeatingPlanModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: get all seating plan Details ends");

		return response;
	}

	/*
	 * for modal view and edit also
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PropertyAssignmentOfSeatingPlanModel>>> getAssignmentByIdModal(String id,
			String sp, String ut) {

		logger.info("Method : getAssignmentByIdModal starts");

		List<PropertyAssignmentOfSeatingPlanModel> mt = new ArrayList<PropertyAssignmentOfSeatingPlanModel>();
		JsonResponse<List<PropertyAssignmentOfSeatingPlanModel>> resp = new JsonResponse<List<PropertyAssignmentOfSeatingPlanModel>>();

		try {

			String value = "SET @p_propertyType='" + id + "',@p_seatingPlan='" + sp + "',@p_userType='" + ut + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("AssignmentOfSeatingPlan")
					.setParameter("actionType", "viewByModal").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				PropertyAssignmentOfSeatingPlanModel laundryItem = new PropertyAssignmentOfSeatingPlanModel(m[0], m[1],
						m[2], m[3], m[4].toString(), m[5], m[6], m[7], m[8], m[9], m[10], null,m[11]);

				mt.add(laundryItem);

			}
			resp.setBody(mt);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<PropertyAssignmentOfSeatingPlanModel>>> response = new ResponseEntity<JsonResponse<List<PropertyAssignmentOfSeatingPlanModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : getAssignmentByIdModal ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public List<PropertyAssignmentOfSeatingPlanModel> getAssignmentById(String id, String sp, String ut) {
		logger.info("Method in Dao: getAssignmentById Starts");

		List<PropertyAssignmentOfSeatingPlanModel> amenityItemList = new ArrayList<PropertyAssignmentOfSeatingPlanModel>();
		try {

			String value = "SET @p_propertyType='" + id + "',@p_seatingPlan='" + sp + "',@p_userType='" + ut + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("AssignmentOfSeatingPlan")
					.setParameter("actionType", "viewByModal").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				PropertyAssignmentOfSeatingPlanModel laundryItem = new PropertyAssignmentOfSeatingPlanModel(m[0], m[1],
						m[2], m[3], m[4].toString(), m[5], m[6], m[7], m[8], m[9], m[10], null,m[11]);

				amenityItemList.add(laundryItem);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method in Dao: getAssignmentById ends");
		
		return amenityItemList;
	}
/*
 * Add assignment of sitting plan
 */
	public ResponseEntity<JsonResponse<Object>> addAssignmentOfSeatingPlan(
			List<PropertyAssignmentOfSeatingPlanModel> propertyAssignmentOfSeatingPlan) {

		logger.info("Method in Dao:Add  assignment of seating plan starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String id = propertyAssignmentOfSeatingPlan.get(0).getId();

		for (PropertyAssignmentOfSeatingPlanModel a : propertyAssignmentOfSeatingPlan) {
			if (a.getPropertyType() == null || a.getPropertyType() == "") {
				resp.setMessage("Property Type Not Selected");
				validity = false;
			} else if (a.getSeatingPlan() == null || a.getSeatingPlan() == "") {
				resp.setMessage(" Seating Plan  Not Selected");
				validity = false;
			} else if (a.getpSplanCapacity() == null) {
				resp.setMessage("Seating capacity not Selected");
				validity = false;
			}
			else if (a.getsPlanImage() == null) {
				resp.setMessage("Seating Image is  not Selected");
				validity = false;
			} else if (a.getpSplanPrice() == null) {
				resp.setMessage("Seating price required");
				validity = false;
			} else if (a.getpSplanActive() == null) {
				resp.setMessage("Seating status Required");
				validity = false;
			}

		}
		if (validity)
			try {
				String values = GenerateAssignmentOfSeatingPlanParameter
						.getAddAssignmentSeatingParam(propertyAssignmentOfSeatingPlan);

				if (id != null && id != "") {
					em.createNamedStoredProcedureQuery("AssignmentOfSeatingPlan")
							.setParameter("actionType", "modifyAOSPlan").setParameter("actionValue", values).execute();
					
				} else {
					em.createNamedStoredProcedureQuery("AssignmentOfSeatingPlan")
							.setParameter("actionType", "addAOSPlan").setParameter("actionValue", values).execute();
					

				}

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

		logger.info("Method in Dao: Add  assignment of seating plan ends");

		return response;
	}
/*
 * get property type by category
 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPropertyIdEdit(String proCat) {

		logger.info("Method in Dao: getUserType starts");

		List<DropDownModel> propertyTypeList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_propertyCategory='" + proCat + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("AmenityItem")
					.setParameter("actionType", "getPropertType").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				propertyTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getUserType ends");

		return propertyTypeList;
	}

}
