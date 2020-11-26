package nirmalya.aatithya.restmodule.production.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateMotherCoilParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.production.model.MotherCoilSlitReportModel;
import nirmalya.aatithya.restmodule.production.model.RestMotherCoilModel;

@Repository
public class RestMotherCoilDao {

	Logger logger = LoggerFactory.getLogger(RestMotherCoilDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/**
	 * for grade list
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getGradeList() {
		logger.info("Method : RESTMODULE MotherCoilGradeDao getGradeList starts");

		List<DropDownModel> MotherCoilList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("motherCoilRoutines")
					.setParameter("actionType", "mcoilGradeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				MotherCoilList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : RESTMODULE MotherCoilGradeDao getGradeList ends");
		return MotherCoilList;
	}

	/*
	 * for add mother Coil
	 */
	public ResponseEntity<JsonResponse<Object>> addMotherCoil(List<RestMotherCoilModel> motherCoil) {

		logger.info("Method in Dao: addMotherCoil starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		for (RestMotherCoilModel a : motherCoil) {
			if (a.gettMotherCoilBatch() == null || a.gettMotherCoilBatch() == "") {
				resp.setMessage("Mother Coil Batch is required");
				validity = false;
			}

		}
		if (validity)
			try {
				String values = GenerateMotherCoilParameter.addMotherCoilParam(motherCoil);

				if (motherCoil.get(0).getEditId() != null && motherCoil.get(0).getEditId() != "") {

					em.createNamedStoredProcedureQuery("motherCoilRoutines")
							.setParameter("actionType", "modifyMotherCoil").setParameter("actionValue", values)
							.execute();
				} else {

					em.createNamedStoredProcedureQuery("motherCoilRoutines").setParameter("actionType", "addMotherCoil")
							.setParameter("actionValue", values).execute();
				}

			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					if (err[0].matches("1062")) {
						resp.setMessage("Coil Already Added.");
					} else {
						resp.setMessage(err[1]);
					}
					resp.setCode(err[0]);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: addMotherCoil ends");

		return response;
	}

	/*
	 * for all Mother Coil view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestMotherCoilModel>>> viewMotherCoil(DataTableRequest request) {
		// TODO Auto-generated method stub

		logger.info("Method in Dao: viewMotherCoil starts");

		List<RestMotherCoilModel> getMCoil = new ArrayList<RestMotherCoilModel>();
		try {
			if (!request.getParam3().isEmpty())
				request.setParam3(DateFormatter.getStringDate(request.getParam3()));

			if (!request.getParam4().isEmpty())
				request.setParam4(DateFormatter.getStringDate(request.getParam4()));
		} catch (Exception e) {
			logger.error("Can not Convert Date");
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("motherCoilRoutines")
					.setParameter("actionType", "viewMotherCoil").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					RestMotherCoilModel motherCoil = new RestMotherCoilModel(m[0], m[1], m[2], m[3], m[4],
							DateFormatter.returnStringDate(m[5]), DateFormatter.returnStringDate(m[6]), null, null,
							null, null, null, m[7], m[8], m[9], m[10], m[11], null);

					getMCoil.add(motherCoil);

				}

				if (x.get(0).length > 12) {
					BigInteger t = (BigInteger) x.get(0)[12];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestMotherCoilModel>> resp = new JsonResponse<List<RestMotherCoilModel>>();
		resp.setBody(getMCoil);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestMotherCoilModel>>> response = new ResponseEntity<JsonResponse<List<RestMotherCoilModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: viewMotherCoil ends");

		return response;
	}

	/*
	 * for modal view mother coil model
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestMotherCoilModel>>> viewMotherCoilId(String mBatchId, String mThickId,
			String slitBatchId) {

		logger.info("Method : viewMotherCoilByIdModal starts");

		List<RestMotherCoilModel> mCoilList = new ArrayList<RestMotherCoilModel>();
		JsonResponse<List<RestMotherCoilModel>> resp = new JsonResponse<List<RestMotherCoilModel>>();

		try {

			String value = "SET @p_mBatchId='" + mBatchId + "',@p_mThickId='" + mThickId + "',@p_slitBatchId='"
					+ slitBatchId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("motherCoilRoutines")
					.setParameter("actionType", "viewMotherCoilById").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				RestMotherCoilModel motherCoilModel = new RestMotherCoilModel(m[0], m[1], m[2], m[3], m[4],
						DateFormatter.returnStringDate(m[5]), DateFormatter.returnStringDate(m[6]), m[7], m[8], m[9],
						null, null, m[10], null, m[11], m[12], m[13], null);

				mCoilList.add(motherCoilModel);

			}
			resp.setBody(mCoilList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestMotherCoilModel>>> response = new ResponseEntity<JsonResponse<List<RestMotherCoilModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewMotherCoilByIdModal ends");

		return response;
	}

	/*
	 * 
	 * Dao get data to edit mother coil
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestMotherCoilModel> editMotherCoil(String mBatchId, String mThickId, String slitBatchId) {
		logger.info("Method : editMotherCoil starts");
		List<RestMotherCoilModel> mCoilList = new ArrayList<RestMotherCoilModel>();

		String value = "SET @p_mBatchId='" + mBatchId + "',@p_mThickId='" + mThickId + "',@p_slitBatchId='"
				+ slitBatchId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("motherCoilRoutines")
					.setParameter("actionType", "editMotherCoil").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestMotherCoilModel dropDownModel = new RestMotherCoilModel(m[0], m[1], m[2], m[3], m[4],
						DateFormatter.returnStringDate(m[5]), DateFormatter.returnStringDate(m[6]), m[7], m[8], m[9],
						null, null, m[10], m[11], m[12], m[13], m[14], m[15]);

				mCoilList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editMotherCoil ends");

		return mCoilList;
	}

	/**
	 * get data thickness
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getThickListById(String proCatId) {
		logger.info("Method : AccountBankBranchDao getThickListById starts");

		List<DropDownModel> thickList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_stateId='" + proCatId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("motherCoilRoutines")
					.setParameter("actionType", "getThicknessListData").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				thickList.add(dropDownModel);
			}

			resp.setBody(thickList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : AccountBankBranchDao getThickListById ends");
		return response;
	}

	/*
	 * DAO Function to get slit width from thickness
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSlitWidthByThickness(String id, String thickness) {
		logger.info("Method : getSlitWidthByThickness starts");
		List<DropDownModel> propNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_grade='" + id + "',@P_thickness='" + thickness + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("motherCoilRoutines")
					.setParameter("actionType", "getSlitWidth").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				propNameList.add(dropDownModel);
			}

			resp.setBody(propNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSlitWidthByThickness ends");
		return response;
	}

	/*
	 * DAO Function to get pile size from slit width
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPipeSizeBySlitWidth(String id, String thickness,
			String slitWidth) {
		logger.info("Method : getPipeSizeBySlitWidth starts");
		List<DropDownModel> propNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_grade='" + id + "',@P_thickness='" + thickness + "',@P_slitWidth='" + slitWidth + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("motherCoilRoutines")
					.setParameter("actionType", "getPipeSize").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				propNameList.add(dropDownModel);
			}

			resp.setBody(propNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getPipeSizeBySlitWidth ends");
		return response;
	}

	/**
	 * get thickness for edit
	 * 
	 * @param grade
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getthicknessEdit(String grade) {
		logger.info("Method : RESTMODULE getthicknessEdit starts");

		List<DropDownModel> MotherCoilList = new ArrayList<DropDownModel>();
		String value = "SET @p_catId='" + grade + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("motherCoilRoutines")
					.setParameter("actionType", "getThicknessByGrade").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				MotherCoilList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : RESTMODULE getthicknessEdit");

		return MotherCoilList;
	}

	/**
	 * get slit width for edit
	 * 
	 * @param grade
	 * @param thickness
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSlitWidthEdit(String grade, String thickness) {
		logger.info("Method : RESTMODULE MotherCoilGradeDao getSlitWidthEdit starts");

		List<DropDownModel> MotherCoilList = new ArrayList<DropDownModel>();
		String value = "SET @p_grade='" + grade + "',@P_thickness='" + thickness + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("motherCoilRoutines")
					.setParameter("actionType", "getSlitWidth").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				MotherCoilList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : RESTMODULE MotherCoilGradeDao getSlitWidthEdit ends");

		return MotherCoilList;
	}

	/**
	 * get pipe size for edit
	 * 
	 * @param grade
	 * @param thickness
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPipeSizeit(String grade, String thickness) {
		logger.info("Method : RESTMODULE MotherCoilGradeDao getPipeSizeit starts");

		List<DropDownModel> MotherCoilList = new ArrayList<DropDownModel>();
		String value = "SET @p_grade='" + grade + "',@P_thickness='" + thickness + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("motherCoilRoutines")
					.setParameter("actionType", "getPipeSizeitEdit").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				MotherCoilList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : RESTMODULE MotherCoilGradeDao getPipeSizeit ends");

		return MotherCoilList;
	}

	/*
	 * for all payment voucher getAllMotherCoilSlit report
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestMotherCoilModel>>> getAllMotherCoilSlit(DataTableRequest request) {

		logger.info("Method in Dao: getMotherCoilSlit report starts");

		List<RestMotherCoilModel> mCoilList = new ArrayList<RestMotherCoilModel>();
		String param3 = request.getParam3();
		String param4 = request.getParam4();
		if (param3 != null && param3 != "") {
			request.setParam3(DateFormatter.getStringDate(param3));
		}
		if (param4 != null && param4 != "") {
			request.setParam4(DateFormatter.getStringDate(param4));
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("motherCoilRoutines")
					.setParameter("actionType", "mothercoilReport").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					RestMotherCoilModel dropDownModel = new RestMotherCoilModel(m[0], m[1], m[2], m[3], m[4],
							DateFormatter.returnStringDate(m[5]), DateFormatter.returnStringDate(m[6]), m[7], m[8],
							m[9], null, null, m[10], m[11], m[12], m[13], m[14], null);

					mCoilList.add(dropDownModel);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestMotherCoilModel>> resp = new JsonResponse<List<RestMotherCoilModel>>();
		resp.setBody(mCoilList);
		resp.setTotal(total);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestMotherCoilModel>>> response = new ResponseEntity<JsonResponse<List<RestMotherCoilModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getMotherCoilSlit reports ends");

		return response;
	}

	/**
	 * DAO - Get Hotel Logo
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getHotelLogoForVoucher(String logoType) {
		logger.info("Method : getHotelLogoForVoucher starts");

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

		logger.info("Method : getHotelLogoForVoucher ends");

		return logoList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<MotherCoilSlitReportModel>>> getMotherCoilBatchReport(
			DataTableRequest request) {
		// TODO Auto-generated method stub

		logger.info("Method in Dao: viewMotherCoil starts");

		List<MotherCoilSlitReportModel> getMCoil = new ArrayList<MotherCoilSlitReportModel>();
		Integer total = 0;
		String param1 = request.getParam1();
		String param2 = request.getParam2();
		if (param1 != null && param1 != "") {
			String frmDate = DateFormatter.getStringDate(param1);
			request.setParam1(frmDate);
		}
		if (param2 != null && param2 != "") {
			String tDate = DateFormatter.getStringDate(param2);
			request.setParam2(tDate);
		}
		String values = GenerateParameter.getSearchParam(request);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("motherCoilRoutines")
					.setParameter("actionType", "motherCoilBatchRpt").setParameter("actionValue", values)
					.getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					MotherCoilSlitReportModel motherCoil = new MotherCoilSlitReportModel(m[0], m[1], m[2], m[3], m[4],
							m[5]);

					getMCoil.add(motherCoil);

				}

				if (x.get(0).length > 6) {
					BigInteger t = (BigInteger) x.get(0)[6];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<MotherCoilSlitReportModel>> resp = new JsonResponse<List<MotherCoilSlitReportModel>>();
		resp.setBody(getMCoil);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<MotherCoilSlitReportModel>>> response = new ResponseEntity<JsonResponse<List<MotherCoilSlitReportModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: viewMotherCoil ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<MotherCoilSlitReportModel>>> getMotherCoilBatchReportPDF(
			DataTableRequest request) {
		// TODO Auto-generated method stub

		logger.info("Method in Dao: viewMotherCoil starts");

		List<MotherCoilSlitReportModel> getMCoil = new ArrayList<MotherCoilSlitReportModel>();
		Integer total = 0;
		String param1 = request.getParam1();
		String param2 = request.getParam2();
		if (param1 != null && param1 != "") {
			String frmDate = DateFormatter.getStringDate(param1);
			request.setParam1(frmDate);
		}
		if (param2 != null && param2 != "") {
			String tDate = DateFormatter.getStringDate(param2);
			request.setParam2(tDate);
		}
		String values = GenerateParameter.getSearchParam(request);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("motherCoilRoutines")
					.setParameter("actionType", "mCoilBtchRptPDF").setParameter("actionValue", values).getResultList();

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					MotherCoilSlitReportModel motherCoil = new MotherCoilSlitReportModel(m[0], m[1], m[2], m[3], m[4],
							m[5]);

					getMCoil.add(motherCoil);

				}

				if (x.get(0).length > 6) {
					BigInteger t = (BigInteger) x.get(0)[6];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<MotherCoilSlitReportModel>> resp = new JsonResponse<List<MotherCoilSlitReportModel>>();
		resp.setBody(getMCoil);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<MotherCoilSlitReportModel>>> response = new ResponseEntity<JsonResponse<List<MotherCoilSlitReportModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: viewMotherCoil ends");

		return response;
	}

	public List<DropDownModel> getMotherCoilBatch() {
		logger.info("Method in Dao: getMotherCoilBatch ends");
		List<DropDownModel> MotherCoilList = new ArrayList<DropDownModel>();
		try {
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("motherCoilRoutines")
					.setParameter("actionType", "mcoilBatchList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				MotherCoilList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method in Dao: getMotherCoilBatch ends");

		return MotherCoilList;
	}

	public ResponseEntity<JsonResponse<List<DropDownModel>>> getThicknessByGrade(String id) {
		logger.info("Method : getPipeSizeBySlitWidth starts");
		List<DropDownModel> propNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_catId='" + id + "';";
		try {
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("motherCoilRoutines")
					.setParameter("actionType", "getThicknessByGrade").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				propNameList.add(dropDownModel);
			}

			resp.setBody(propNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getPipeSizeBySlitWidth ends");
		return response;
	}

	public List<DropDownModel> getMotherCoilBatchEdit() {
		logger.info("Method in Dao: getMotherCoilBatch ends");
		List<DropDownModel> MotherCoilList = new ArrayList<DropDownModel>();
		try {
			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("motherCoilRoutines")
					.setParameter("actionType", "mcoilBatchEdit").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				MotherCoilList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method in Dao: getMotherCoilBatch ends");

		return MotherCoilList;
	}

	/*
	 * for get Details by batch code
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestMotherCoilModel>>> getDetailsByBatchCode(String id) {
		logger.info("Method : getDetailsByBatchCode starts");
		List<RestMotherCoilModel> propNameList = new ArrayList<RestMotherCoilModel>();
		JsonResponse<List<RestMotherCoilModel>> resp = new JsonResponse<List<RestMotherCoilModel>>();
		String value = "SET @p_grade='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("motherCoilRoutines")
					.setParameter("actionType", "getDetailsByBC").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				RestMotherCoilModel motherCoil = new RestMotherCoilModel(null, m[0], m[1], m[2], null, null, null, null,
						null, null, null, null, null, null, m[3], m[4], null, null);
				propNameList.add(motherCoil);
			}

			resp.setBody(propNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestMotherCoilModel>>> response = new ResponseEntity<JsonResponse<List<RestMotherCoilModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getDetailsByBatchCode ends");
		return response;
	}

}
