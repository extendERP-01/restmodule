package nirmalya.aatithya.restmodule.master.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateUserSacCodeParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.UserSacCodeModel;

/**
 * @author USER
 *
 */
@Repository
public class UserSacCodeDao {

	Logger logger = (Logger) LoggerFactory.getLogger(UserSacCodeDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to Add/edit SacMaster in User
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> addSacMaster(UserSacCodeModel restSacCodeModel) {

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (restSacCodeModel.getSacCodeName() == null || restSacCodeModel.getSacCodeName() == "") {
			resp.setMessage("SacCode  Name required");
			validity = false;
		} else if (restSacCodeModel.getSacService() == null || restSacCodeModel.getSacService() == "") {
			resp.setMessage("SacCode Service required");
			validity = false;
		} else if (restSacCodeModel.getSacActive() == null) {
			resp.setMessage("Status required");
			validity = false;
		} else if (restSacCodeModel.getSacGST() == null) {
			resp.setMessage("GST required");
			validity = false;
		} else if (restSacCodeModel.getSacDescription() == null || restSacCodeModel.getSacDescription() == "") {
			resp.setMessage("SacDescription required");
			validity = false;
		} else if (restSacCodeModel.getSacEffDate() == null || restSacCodeModel.getSacEffDate() == "") {
			resp.setMessage("EffectiveDate required");
			validity = false;
		}
		if (validity)
			try {
				String values = GenerateUserSacCodeParameter.addSacParam(restSacCodeModel);

				if (restSacCodeModel.getSacId() != null && restSacCodeModel.getSacId() != "") {
					em.createNamedStoredProcedureQuery("sacCodeRoutines").setParameter("actionType", "modifySacMaster")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("sacCodeRoutines").setParameter("actionType", "addSacMaster")
							.setParameter("actionValue", values).execute();
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

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<UserSacCodeModel>>> getAllSacMaster(DataTableRequest request) {
		logger.info("Method : getAllSacMaster starts");

		List<UserSacCodeModel> restSacCodeModel = new ArrayList<UserSacCodeModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("sacCodeRoutines")
					.setParameter("actionType", "viewSacMaster").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object date = null;
				date = DateFormatter.returnStringDate(m[5]);

				UserSacCodeModel itmCat = new UserSacCodeModel(m[0], m[1], m[2], m[3], m[4], date, m[6], m[7], m[8],null);
				restSacCodeModel.add(itmCat);
			}
			if(x.size()>0) {
				if (x.get(0).length > 9) {
					BigInteger t = (BigInteger) x.get(0)[9];
	
					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<UserSacCodeModel>> resp = new JsonResponse<List<UserSacCodeModel>>();
		resp.setBody(restSacCodeModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<UserSacCodeModel>>> response = new ResponseEntity<JsonResponse<List<UserSacCodeModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAllSacMaster ends");
		return response;

	}

	public ResponseEntity<JsonResponse<Object>> deleteSacMaster(String id) {

		logger.info("Method : deleteSacMaster starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_sacId='" + id + "';";
			em.createNamedStoredProcedureQuery("sacCodeRoutines").setParameter("actionType", "deleteSacMaster")
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

		logger.info("Method : deleteSacMaster ends");
		return response;
	}

	public ResponseEntity<JsonResponse<UserSacCodeModel>> getSacMaster(String id) {
		logger.info("Method : editSacMaster starts");

		List<UserSacCodeModel> form = new ArrayList<UserSacCodeModel>();
		try {
			String value = "SET @p_sacId='" + id + "';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("sacCodeRoutines")
					.setParameter("actionType", "editSacMaster").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				Object date = null;
				date = DateFormatter.returnStringDate(m[5]);

				UserSacCodeModel restSacCodeModel = new UserSacCodeModel(m[0], m[1], m[2], m[3], m[4], date, m[6], m[7],
						m[8],m[9]);
				form.add(restSacCodeModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<UserSacCodeModel> resp = new JsonResponse<UserSacCodeModel>();
		resp.setBody(form.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<UserSacCodeModel>> response = new ResponseEntity<JsonResponse<UserSacCodeModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		// System.out.println(response);

		logger.info("Method : editSacMaster ends");
		return response;
	}


		/*
		 * DAO Function to view dropDown for Service Name
		 *
		 */
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getServiceNameList() {
			logger.info("Method : getServiceNameList starts");
			List<DropDownModel> serviceList = new ArrayList<DropDownModel>();
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("sacCodeRoutines")
						.setParameter("actionType", "serviceList").setParameter("actionValue", "").getResultList();
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					serviceList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("serviceList : "+serviceList);
			logger.info("Method : getServiceNameList ends");
			return serviceList;
		}

}
