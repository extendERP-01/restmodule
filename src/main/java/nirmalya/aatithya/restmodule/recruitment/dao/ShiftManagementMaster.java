package nirmalya.aatithya.restmodule.recruitment.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateShifParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse; 
import nirmalya.aatithya.restmodule.recruitment.model.ShiftMasterRestModel;

@SuppressWarnings("unchecked")
@Repository
public class ShiftManagementMaster {
	Logger logger = LoggerFactory.getLogger(ShiftManagementMaster.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// private Object value; 
	public List<DropDownModel> dropDownshift() {
		logger.info("Method : getShift Dao starts");

		List<DropDownModel> shiftList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("rshiftRoutines")
					.setParameter("actionType", "getshift").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				shiftList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getShift Dao ends");

		return shiftList;
	}

	/**
	 * DAO - add Shift
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> restAddShift(ShiftMasterRestModel sif) {
		logger.info("Method : restAddShift starts");
		Boolean validity = true;

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (sif.getShiftName() == null || sif.getShiftName() == "") {
			resp.setMessage("Shift Name can't be Empty");
			validity = false;
		}
		if (sif.getFromTime() == null || sif.getFromTime() == "") {
			resp.setMessage("Shift Fromtime can't be Empty");
			validity = false;
		}
		if (sif.getToTime() == null || sif.getToTime() == "") {
			resp.setMessage("Shift Totime can't be left empty");
			validity = false;
		}
		/*
		 * if(sif.getCreatedBy() == null || sif.getCreatedBy() == "") {
		 * resp.setMessage("  can't be left empty"); validity = false; }
		 */
		if (validity)
			try {
				String values = GenerateShifParameter.getsifParam(sif);

				if (sif.getShiftId() != null && sif.getShiftId() != "") {
					em.createNamedStoredProcedureQuery("rshiftRoutines").setParameter("actionType", "modifyshif")
							.setParameter("actionValue", values).execute();
				} else {

					em.createNamedStoredProcedureQuery("rshiftRoutines").setParameter("actionType", "addshif")
							.setParameter("actionValue", values).execute();

				}
			} catch

			(Exception e) {
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

		logger.info("Method : restAddShift ends");
		return response;
	}

	// view Structure dao 
	public ResponseEntity<JsonResponse<List<ShiftMasterRestModel>>> viewshift(DataTableRequest sif) {
		logger.info("Method : getshiftdao starts");

		List<ShiftMasterRestModel> shift = new ArrayList<ShiftMasterRestModel>();
		String values = GenerateParameter.getSearchParam(sif);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("rshiftRoutines")
					.setParameter("actionType", "viewShift").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				ShiftMasterRestModel shiftModel = new ShiftMasterRestModel(m[0], m[1], m[2], m[3], m[4]);
				shift.add(shiftModel);
			}

			if (x.size() > 0) {

				if (x.get(0).length > 5) {
					BigInteger t = (BigInteger) x.get(0)[5];

					total = Integer.parseInt((t.toString()));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ShiftMasterRestModel>> resp = new JsonResponse<List<ShiftMasterRestModel>>();
		resp.setBody(shift);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ShiftMasterRestModel>>> response = new ResponseEntity<JsonResponse<List<ShiftMasterRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getshiftdao ends");
		return response;
	}
	// Edit view Structure

	public ResponseEntity<JsonResponse<ShiftMasterRestModel>> resteditShifbyId(String id) {
		logger.info("Method : editShift Dao starts");

		List<ShiftMasterRestModel> shifEdit = new ArrayList<ShiftMasterRestModel>();
		JsonResponse<ShiftMasterRestModel> resp = new JsonResponse<ShiftMasterRestModel>();

		try {

			String value = "SET @p_shiftId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("rshiftRoutines")
					.setParameter("actionType", "viewEditshif").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				ShiftMasterRestModel shiftModel = new ShiftMasterRestModel(m[0], m[1], m[2], m[3], m[4]);
				shifEdit.add(shiftModel);
			}

			resp.setBody(shifEdit.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<ShiftMasterRestModel>> response = new ResponseEntity<JsonResponse<ShiftMasterRestModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : editshift Dao ends");
		return response;
	}

	// for deleting of shift
	public ResponseEntity<JsonResponse<Object>> deleteShiftbyId(String id, String createdBy) {
		logger.info("Method : deleteShiftbyId starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET  @p_shiftId='" + id + "',@p_CreatedBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("rshiftRoutines").setParameter("actionType", "deleteshif")
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

		logger.info("Method : deleteShiftbyId ends");
		return response;

	}
 /*
  * for view in model
  */
	public ResponseEntity<JsonResponse<List<ShiftMasterRestModel>>> getshiftmodalByIdmodal(String id) {

		logger.info("Method : getmodalview starts");

		List<ShiftMasterRestModel> shiftmodal = new ArrayList<ShiftMasterRestModel>();
		JsonResponse<List<ShiftMasterRestModel>> resp = new JsonResponse<List<ShiftMasterRestModel>>();

		try {

			String value = "SET @p_shiftId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("rshiftRoutines")
					.setParameter("actionType", "shiftmodalview").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				ShiftMasterRestModel shiftmodel = new ShiftMasterRestModel(m[0], m[1], m[2], m[3], m[4]);

				shiftmodal.add(shiftmodel);

			}

			resp.setBody(shiftmodal);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<ShiftMasterRestModel>>> response = new ResponseEntity<JsonResponse<List<ShiftMasterRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getmodalview ends");

		return response;
	}

}
