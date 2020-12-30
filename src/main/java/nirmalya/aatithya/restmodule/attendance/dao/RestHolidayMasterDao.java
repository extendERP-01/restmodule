package nirmalya.aatithya.restmodule.attendance.dao;

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

import nirmalya.aatithya.restmodule.attendance.model.RestHolidayMasterModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateHolidayMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestHolidayMasterDao {

	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;

	Logger logger = LoggerFactory.getLogger(RestHolidayMasterDao.class);

	/*
	 * DAO Function to view holiday status in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getHolidayStatus() {
		logger.info("Method : getWorkingStatus starts");
		List<DropDownModel> holidayStatus = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("holidayMasterRoutines")
					.setParameter("actionType", "getHolidayStatus").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				holidayStatus.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getWorkingStatus ends");
		return holidayStatus;
	}

	/*
	 * DAO Function to Add/edit holidays
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> restAddHoliday(RestHolidayMasterModel holidayListMaster) {
		logger.info("Method : restAddWorkWeek ends");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (holidayListMaster.gettHolidayName() == null || holidayListMaster.gettHolidayName() == "") {
			resp.setMessage("Holiday Name required");
			validity = false;
		} else if (holidayListMaster.gettHolidayFromDate() == null || holidayListMaster.gettHolidayFromDate() == "") {
			resp.setMessage("Holiday From Date required");
			validity = false;
		} else if (holidayListMaster.gettHolidayToDate() == null || holidayListMaster.gettHolidayToDate() == "") {
			resp.setMessage("Holiday To Date required");
			validity = false;
		} else if (holidayListMaster.gettHolidayStatus() == null || holidayListMaster.gettHolidayStatus() == "") {
			resp.setMessage("Holiday Status required");
			validity = false;
		} else if (holidayListMaster.gettCompanyId() == null || holidayListMaster.gettCompanyId() == "") {

			validity = true;
		} else if (holidayListMaster.gettHolidayCreatedBy() == null || holidayListMaster.gettHolidayCreatedBy() == "") {

			validity = true;
		}

		if (validity) {
			try {
				String values = GenerateHolidayMasterParameter.addHolidayParam(holidayListMaster);

				if (holidayListMaster.gettHoliday() == null || holidayListMaster.gettHoliday() == "") {
					em.createNamedStoredProcedureQuery("holidayMasterRoutines").setParameter("actionType", "addHoliday")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("holidayMasterRoutines")
							.setParameter("actionType", "modifyHoliday").setParameter("actionValue", values).execute();
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
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : restAddWorkWeek ends");
		return response;
	}

	/*
	 * DAO Function to View all function
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHolidayMasterModel>>> getAllHoliday(DataTableRequest request) {
		logger.info("Method : getAllWorkWeek starts");
		List<RestHolidayMasterModel> form = new ArrayList<RestHolidayMasterModel>();
		String values = GenerateParameter.getSearchParam(request);

		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("holidayMasterRoutines")
					.setParameter("actionType", "getAllHoliday").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					RestHolidayMasterModel properties = new RestHolidayMasterModel(m[0], m[1], m[2], m[3], m[4], null,
							null, null);
					form.add(properties);
				}

				if (x.get(0).length > 5) {
					BigInteger t = (BigInteger) x.get(0)[5];

					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		JsonResponse<List<RestHolidayMasterModel>> resp = new JsonResponse<List<RestHolidayMasterModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<RestHolidayMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestHolidayMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllWorkWeek ends");
		System.out.println("response" + response);
		return response;
	}

	/*
	 * DAO Function to view particular Holiday details to edit/view
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestHolidayMasterModel>> editHoliday(String id) {
		logger.info("Method : editHoliday starts");
		List<RestHolidayMasterModel> form = new ArrayList<RestHolidayMasterModel>();

		try {
			String values = "SET @p_holidayId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("holidayMasterRoutines")
					.setParameter("actionType", "editHoliday").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				RestHolidayMasterModel properties = new RestHolidayMasterModel(m[0], m[1], m[2], m[3], m[4], null, null,
						null);
				form.add(properties);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<RestHolidayMasterModel> holidayListMaster = new JsonResponse<RestHolidayMasterModel>();
		holidayListMaster.setBody(form.get(0));

		ResponseEntity<JsonResponse<RestHolidayMasterModel>> response = new ResponseEntity<JsonResponse<RestHolidayMasterModel>>(
				holidayListMaster, HttpStatus.CREATED);
		logger.info("Method : editHoliday ends");
		return response;
	}

	/*
	 * DAO Function to delete particular Holiday
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> deleteHoliday(String id, String createdBy) {
		logger.info("Method : deleteHoliday starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_holidayId='" + id + "',@p_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("holidayMasterRoutines").setParameter("actionType", "deleteHoliday")
					.setParameter("actionValue", value).execute();

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

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : deleteHoliday end");
		return response;
	}

}
