package nirmalya.aatithya.restmodule.user.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateMembershipMstrParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.ServerValidation;
import nirmalya.aatithya.restmodule.user.model.RestUserMembershipMstrModel;

@Repository
public class RestUserMemberMstrDao {

	Logger logger = LoggerFactory.getLogger(RestUserMemberMstrDao.class);
	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/*
	 * DAO Function to get Compare Property category drop down data
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getValidityName(String getValidityName) {

		logger.info("Method : DAO getValidityName starts");

		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_validityName=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("memberMstrRoutines")
					.setParameter("actionType", getValidityName).setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModelConstructor = new DropDownModel(m[0], m[1]);
				dropDownModel.add(dropDownModelConstructor);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setBody(dropDownModel);

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : DAO getValidityName ends");
		return response;
	}

	/*
	 * DAO Function to ADD/Edit membership mstr
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> addmemberMstr(RestUserMembershipMstrModel table) {

		logger.info("Method : addmemberMstr starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		/* System.out.println("Data: " + meal); */

		if (table.getMemName() == null || table.getMemName() == "") {
			resp.setMessage("*Membership Type name required");
			validity = false;
		} else if (table.getMemMonthlyFee() == null) {
			resp.setMessage("*Monthly Fee required");
			validity = false;

		} else if (table.getMemRegistrationFee() == null) {
			resp.setMessage("*Registration Fee required");
			validity = false;

		} else if (table.getMemValidity() == null) {
			resp.setMessage("*Choose Validity required");
			validity = false;

		} else if (table.gettDependentsLimit() == null) {
			resp.setMessage("*Member EffDateFrom required");
			validity = false;

		} else if (table.gettChildrenAgeLimit() == null) {
			resp.setMessage("*Child Age required");
			validity = false;

		}

		else if (table.gettEffectiveFromDate() == null) {
			resp.setMessage("*DependentNo required");
			validity = false;

		} else if (table.getMemStatus() == null) {
			resp.setMessage("*Membership status required");
			validity = false;
		} else if (table.getMemDescription() == null || table.getMemDescription() == "") {
			resp.setMessage("*Description required");
			validity = false;
		} else if (table.gettCMemberTypCreatedBy() == null || table.gettCMemberTypCreatedBy() == "") {
			resp.setMessage("*fld required");
			validity = false;
		}

		if (validity)
			try {

				String values = GenerateMembershipMstrParameter.getAddMembershipMstrParam(table);

				if (table.getMemId() != null && table.getMemId() != "") {

					em.createNamedStoredProcedureQuery("memberMstrRoutines")
							.setParameter("actionType", "mdfyMemshipMstr").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("memberMstrRoutines")
							.setParameter("actionType", "addMemshipMstr").setParameter("actionValue", values).execute();
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

		logger.info("Method : addmemberMstr ends");

		return response;
	}

	/*
	 * DAO Function to View all Membership Mstr data
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestUserMembershipMstrModel>>> getMembershipMstrDetails(
			DataTableRequest request) {

		logger.info("Method : getMembershipMstr details starts");

		List<RestUserMembershipMstrModel> meal = new ArrayList<RestUserMembershipMstrModel>();
		String values = GenerateMembershipMstrParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("memberMstrRoutines")
					.setParameter("actionType", "viewMemberDtls").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object tEffectiveFromDate = null;
				if (m[7] != null) {
					tEffectiveFromDate = DateFormatter.returnStringDate(m[7]);

				}
				RestUserMembershipMstrModel user = new RestUserMembershipMstrModel(m[0], m[1], m[2], m[3], null,m[4], m[5],m[6],tEffectiveFromDate, m[8], m[9]);
				meal.add(user);
			}

			if (x.get(0).length > 10) {
				BigInteger t = (BigInteger) x.get(0)[10];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestUserMembershipMstrModel>> resp = new JsonResponse<List<RestUserMembershipMstrModel>>();
		resp.setBody(meal);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestUserMembershipMstrModel>>> response = new ResponseEntity<JsonResponse<List<RestUserMembershipMstrModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getMembershipMstr details ends");

		return response;
	}

	/*
	 * DAO Function to get MembershipMstrModel data by Id
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestUserMembershipMstrModel>> getMemberMstrById(String id, String action) {

		logger.info("Method : getMemberMstrById starts");

		List<RestUserMembershipMstrModel> mt = new ArrayList<RestUserMembershipMstrModel>();
		JsonResponse<RestUserMembershipMstrModel> resp = new JsonResponse<RestUserMembershipMstrModel>();

		try {

			String value = "SET @p_memId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("memberMstrRoutines")
					.setParameter("actionType", action).setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object tEffectiveFromDate = null;
				if (m[8] != null) {
					tEffectiveFromDate = DateFormatter.returnStringDate(m[8]);

				}
				RestUserMembershipMstrModel table = new RestUserMembershipMstrModel(m[0], m[1], m[2], m[3],m[4], m[5],m[6],m[7],tEffectiveFromDate, m[9],m[10]);
				mt.add(table);
			}

			resp.setBody(mt.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<RestUserMembershipMstrModel>> response = new ResponseEntity<JsonResponse<RestUserMembershipMstrModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getMemberMstrById ends");
		return response;
	}

	/*
	 * DAO Function to delete particular row from Membership
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> deleteMmbrspById(String id, String createdBy) {
		logger.info("Method : DAO deleteMsterShipById starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_memId=" + id + ",@p_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("memberMstrRoutines").setParameter("actionType", "deleteMembrMstr")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();

			String[] err = ServerValidation.geterror(e);

			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : DAO deleteMsterShipById ends");
		return response;
	}

	
		/**
		 * DAO Function to view dropDown for Member Type
		 *
		 */
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getMemberType() {

			logger.info("Method : getMemberType starts");
			List<DropDownModel> memberList = new ArrayList<DropDownModel>();
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("memberMstrRoutines")
						.setParameter("actionType", "getMemberType").setParameter("actionValue", "").getResultList();
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					memberList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : getMemberType ends");
			return memberList;
		}


}
