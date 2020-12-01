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
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateShiftScheduleParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.recruitment.model.ShiftSchedulingModel;

@Repository
public class ShiftSchedulingDao {

	Logger logger = LoggerFactory.getLogger(ShiftSchedulingDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/**
	 * for ScheduleList
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSchedule() {

		logger.info("Method : getScheduleList starts");

		List<DropDownModel> scheduleList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("shiftScheduleRoutines")
					.setParameter("actionType", "getScheduleList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				scheduleList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getScheduleList ends");
		return scheduleList;
	}

	/**
	 * for section list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSection() {

		logger.info("Method : getSection starts");

		List<DropDownModel> sectionList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("shiftScheduleRoutines")
					.setParameter("actionType", "getSectionList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				sectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getSection ends");

		return sectionList;
	}

	/**
	 * for department list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepartment() {

		logger.info("Method : getDepartment starts");

		List<DropDownModel> departmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("shiftScheduleRoutines")
					.setParameter("actionType", "getDepartmentList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				departmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDepartment ends");

		return departmentList;
	}

	/**
	 * for shift list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getShift() {

		logger.info("Method : getShift starts");

		List<DropDownModel> shiftList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("shiftScheduleRoutines")
					.setParameter("actionType", "getShiftList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				shiftList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getShift ends");

		return shiftList;
	}

	/**
	 * for employee list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmployee() {

		logger.info("Method : getEmployee starts");

		List<DropDownModel> employeeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("shiftScheduleRoutines")
					.setParameter("actionType", "getEmployeeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employeeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getEmployee ends");

		return employeeList;
	}

	/*
	 * * for add services
	 */
	public ResponseEntity<JsonResponse<Object>> restAddSchedule(List<ShiftSchedulingModel> shiftSchedulingModel) {

		logger.info("Method in Dao: restAddScheduling starts");

		Boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String id = shiftSchedulingModel.get(0).getEditId();

		for (ShiftSchedulingModel a : shiftSchedulingModel) {

			if (a.getFromDate() == null || a.getFromDate() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select From Date.");
				break;
			} else if (a.gettSchedule() == null || a.gettSchedule() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Schedule Name.");
				break;
			} else if (a.gettSection() == null || a.gettSection() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Section.");
				break;
			} else if (a.getToDate() == null || a.getToDate() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter To Date.");
				break;
			} else if (a.gettDepartment() == null || a.gettDepartment() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Department Type.");
				break;
			} else if (a.gettShift() == null || a.gettShift() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Shift");
				break;
			} else if (a.gettEmp() == null || a.gettEmp() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Employee");
				break;
			} else if (a.gettRemark() == null || a.gettRemark() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Remark");
				break;
			}
		}

		if (validation)
			try {
				String values = GenerateShiftScheduleParameter.getAddShiftScheduleParam(shiftSchedulingModel);
				System.out.println(values);
				if (id != null && id != "") {
System.out.println(id);
					em.createNamedStoredProcedureQuery("shiftScheduleRoutines")
							.setParameter("actionType", "modifyScheduleType").setParameter("actionValue", values)
							.execute();
				} else {

					em.createNamedStoredProcedureQuery("shiftScheduleRoutines")
							.setParameter("actionType", "addScheduleType").setParameter("actionValue", values)
							.execute();

				}
			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					if (err[0].matches("1062")) {
						resp.setMessage("Department Already Added.");
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

		logger.info("Method in Dao: restAddScheduling ends");

		return response;
	}

	/*
	 * for all assignSkill details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ShiftSchedulingModel>>> getAssignShiftedDetails(
			DataTableRequest tableRequest) {

		logger.info("Method in Dao: getAssignShiftedDetails starts");

		List<ShiftSchedulingModel> shiftList = new ArrayList<ShiftSchedulingModel>();
		String values = GenerateParameter.getSearchParam(tableRequest);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("shiftScheduleRoutines")
					.setParameter("actionType", "getShiftDepnd").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object sDate = null;
					if (m[0] != null) {
						sDate = DateFormatter.returnStringDate(m[0]);
					}

					Object sDate2 = null;
					if (m[5] != null) {
						sDate2 = DateFormatter.returnStringDate(m[5]);
					}

					ShiftSchedulingModel shift = new ShiftSchedulingModel(sDate, m[1], m[2], m[3], m[4], sDate2, m[6],
							m[7],null,m[8],m[9],m[10],m[11],null, null, null,m[12]);
					shiftList.add(shift);

				}

				if (x.get(0).length > 13) {
					BigInteger t = (BigInteger) x.get(0)[13];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(total);

		JsonResponse<List<ShiftSchedulingModel>> resp = new JsonResponse<List<ShiftSchedulingModel>>();
		resp.setBody(shiftList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ShiftSchedulingModel>>> response = new ResponseEntity<JsonResponse<List<ShiftSchedulingModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getAssignShiftedDetails ends");

		return response;
	}

	
	/*
	 * for modal view and edit also
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ShiftSchedulingModel>>> getShiftListById(String id) {

		logger.info("Method : getEditShift starts");

		List<ShiftSchedulingModel> shiftList = new ArrayList<ShiftSchedulingModel>();
		JsonResponse<List<ShiftSchedulingModel>> resp = new JsonResponse<List<ShiftSchedulingModel>>();

		try {

			String value = "SET @p_shiftIdId='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("shiftScheduleRoutines")
					.setParameter("actionType", "getShiftDepndById").setParameter("actionValue", value).getResultList();
System.out.println(x);
			for (Object[] m : x) {
				
				Object sDate = null;
				if (m[0] != null) {
					sDate = DateFormatter.returnStringDate(m[0]);
				}

				Object sDate2 = null;
				if (m[5] != null) {
					sDate2 = DateFormatter.returnStringDate(m[5]);
				}
				
				
				ShiftSchedulingModel ShiftSchedulingModel = new ShiftSchedulingModel(sDate, m[1], m[2], m[3], m[4], sDate2, m[6],
						m[7],"a",m[8],m[9],m[10],m[11],m[12],null,m[13],m[14]);

				shiftList.add(ShiftSchedulingModel);

			}
			resp.setBody(shiftList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<ShiftSchedulingModel>>> response = new ResponseEntity<JsonResponse<List<ShiftSchedulingModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
System.out.println(response);
		logger.info("Method : getEditShift ends");

		return response;
	}
	

}


