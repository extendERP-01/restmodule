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
import nirmalya.aatithya.restmodule.common.utils.GenerateAssignPropertyToStaff;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.model.PropertyAssignPropertyToStaffModel;

@Repository
public class PropertyAssignPropertyToSatffDao {
	
	
	Logger logger = LoggerFactory.getLogger(PropertyAssignPropertyToSatffDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	
	
	/*
	 * get cost center
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCostCenterList() {
		logger.info("Method : getCostCenterList starts");

		List<DropDownModel> costcenter = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetToStaffRoutines")
					.setParameter("actionType", "getCostNameList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				costcenter.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCostCenterList ends");

		return costcenter;
	}
	/*
	 * Drop down for user role from cost center
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getUserRole(String costCenter) {
		
		logger.info("Method : getUserRole starts");

		List<DropDownModel> UserRoleList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_costCenter='" + costCenter + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("assignPropertyToStaffRoutines")
					.setParameter("actionType", "getUserRole").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				UserRoleList.add(dropDownModel);
			}

			resp.setBody(UserRoleList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		 logger.info("Method : getUserRole ends");
		return response;
	}
	
	/*
	 * Drop down for user list by user role
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getUserList(String userRole) {
		
		logger.info("Method : getUserList starts");

		List<DropDownModel> userList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_userRole='" + userRole + "';";
			System.out.println("value: "+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignPropertyToStaffRoutines")
					.setParameter("actionType", "getUserList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				userList.add(dropDownModel);
			}
			resp.setBody(userList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		 logger.info("Method : getUserList ends");
		return response;
	}
	
	/*
	 * Drop down for property list by Cost center
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPropertyList(String costCenter) {
		
		logger.info("Method : getPropertyList starts");

		List<DropDownModel> amenityNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_costCenter='" + costCenter + "';";
			System.out.println("value: "+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignPropertyToStaffRoutines")
					.setParameter("actionType", "getPropertyList").setParameter("actionValue", value).getResultList();

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

		System.out.println("response: "+response);
		logger.info("Method : getPropertyList ends");
		return response;
	}
	
	/*
	 * add property to staff
	 */
	
	public ResponseEntity<JsonResponse<Object>> restAssignPropertyToStaff(PropertyAssignPropertyToStaffModel propertyAssignPropertyToStaffModel) {
		logger.info("Method : restAssignPropertyToStaff starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (propertyAssignPropertyToStaffModel.getCostCenter() == null || propertyAssignPropertyToStaffModel.getCostCenter() == "") {
			resp.setMessage("Cost center  Name Not Selected");
			validity = false;
		} else if (propertyAssignPropertyToStaffModel.getUserRole() == null || propertyAssignPropertyToStaffModel.getUserRole() == "") {
			resp.setMessage("User Role Not selected");
			validity = false;
		} else if (propertyAssignPropertyToStaffModel.getUser() == null || propertyAssignPropertyToStaffModel.getUser() == "") {
			resp.setMessage("User Not Select");
			validity = false;
		}
		else if (propertyAssignPropertyToStaffModel.getSatffActive() == null) {
			resp.setMessage("Status  Not Select");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateAssignPropertyToStaff.getAssignPropertyParam(propertyAssignPropertyToStaffModel);

				em.createNamedStoredProcedureQuery("assignPropertyToStaffRoutines")
				.setParameter("actionType", "addAssignProperty")
				.setParameter("actionValue", values).execute();
				
			

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

		logger.info("Method : restAssignPropertyToStaff ends");
		return response;
	}

	
	/*
	 * for all assigned property to staff
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PropertyAssignPropertyToStaffModel>>> getAllAssignedProperty(DataTableRequest request) {

		logger.info("Method in Dao: getAllAssignedProperty starts");
		
		

		List<PropertyAssignPropertyToStaffModel> assignPropertyToStaffList = new ArrayList<PropertyAssignPropertyToStaffModel>();
		
		
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignPropertyToStaffRoutines")
					.setParameter("actionType", "allAssignedProperty").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					PropertyAssignPropertyToStaffModel assignPropertyToStaff = new PropertyAssignPropertyToStaffModel(m[0], m[1], m[2], m[3], m[4], m[5] , m[6],m[7] ,m[8],null);
					assignPropertyToStaffList.add(assignPropertyToStaff);

				}

				if (x.get(0).length > 9) {
					BigInteger t = (BigInteger) x.get(0)[9];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<PropertyAssignPropertyToStaffModel>> resp = new JsonResponse<List<PropertyAssignPropertyToStaffModel>>();
		resp.setBody(assignPropertyToStaffList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<PropertyAssignPropertyToStaffModel>>> response = new ResponseEntity<JsonResponse<List<PropertyAssignPropertyToStaffModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getAllAssignedProperty ends");

		return response;
	}

	
	/*
	 * for edit assigned property by id
	 */
	
	@SuppressWarnings("unchecked")
	public List<PropertyAssignPropertyToStaffModel> getAssignedPropertyById(String id, String ur ,String ui) {
		logger.info("Method in Dao: getAssignedPropertyById Starts");

		List<PropertyAssignPropertyToStaffModel>AssignPropertyToStaffList = new ArrayList<PropertyAssignPropertyToStaffModel>();
		try {

			String value = "SET @p_costCenterId='" + id + "',@p_userRoleId='" + ur +"',@p_userId='"+ui+ "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignPropertyToStaffRoutines")
					.setParameter("actionType", "assignedPropertyById").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				PropertyAssignPropertyToStaffModel assignPropertyToStaff = new PropertyAssignPropertyToStaffModel(m[0], m[1],
						m[2], m[3], m[4], m[5], m[6], m[7], m[8],null);
				AssignPropertyToStaffList.add(assignPropertyToStaff);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method in Dao: getAssignedPropertyById ends");
		return AssignPropertyToStaffList;
	}
	
	
	/*
	 * for modal view of assigned property to staff
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<PropertyAssignPropertyToStaffModel>> getAssignedPropertyByIdModal(String id,
			String ur ,String ui,String pi) {

		logger.info("Method in Dao: get Assignment of property to staff Modal Starts");

		List<PropertyAssignPropertyToStaffModel> AssignPropertyToStaffList = new ArrayList<PropertyAssignPropertyToStaffModel>();

		try {

			String value = "SET @p_costCenterId='" + id + "',@p_userRoleId='" + ur +"',@p_userId='"+ui+"',@p_propertyId='"+pi+ "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignPropertyToStaffRoutines")
					.setParameter("actionType", "assignedPropertyById").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				PropertyAssignPropertyToStaffModel assignPropertyToStaff = new PropertyAssignPropertyToStaffModel(m[0], m[1],
						m[2], m[3], m[4], m[5], m[6], m[7], m[8],null);
				AssignPropertyToStaffList.add(assignPropertyToStaff);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<PropertyAssignPropertyToStaffModel> resp = new JsonResponse<PropertyAssignPropertyToStaffModel>();
		resp.setBody(AssignPropertyToStaffList.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<PropertyAssignPropertyToStaffModel>> response = new ResponseEntity<JsonResponse<PropertyAssignPropertyToStaffModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: get Assignment of property to staff Modal ends");

		return response;
	}
	/*
	 * change status
	 */
	public ResponseEntity<JsonResponse<Object>> changePropertyStatusById(String id, String ur, String userid,
			String propertyId, Boolean status , String createdBy) {
		logger.info("Method : DAO changePropertyStatusById starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		
		try {
			String value = "SET @p_costCenter='" + id + "',@p_userRole='" + ur + "',@p_userId='" + userid + "',@p_propertyId='" + propertyId  +"',@p_createdBy='" + createdBy  + "',@p_active=" + status +  ";";
			
			em.createNamedStoredProcedureQuery("assignPropertyToStaffRoutines")
				.setParameter("actionType", "changePropertyStatus")
				.setParameter("actionValue", value)
				.execute();	
		} catch (Exception e) {
			e.printStackTrace();
			String[] err = serverDao.errorProcedureCall(e);
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}
		
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,responseHeaders,HttpStatus.CREATED);
		
		logger.info("Method : DAO changePropertyStatusById ends");
		return response;
	}
	

	/**
	 * DAO - Get Hotel Logo
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getHotelLogoAssignedProperty(String logoType) {
		logger.info("Method : getHotelLogoAssignedProperty  starts");

		List<DropDownModel> logoList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_logoType='" + logoType + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("logoImageRoutines")
					.setParameter("actionType", "getHotelLogo").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				logoList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getHotelLogoAssignedProperty ends");

		return logoList;
	}
}
