package nirmalya.aatithya.restmodule.employee.dao;

import java.math.BigDecimal;
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
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateSalaryApprovalParam;
import nirmalya.aatithya.restmodule.common.utils.HrmsGenerateSalaryParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.EmployeeFoodTrackingRestModel;
import nirmalya.aatithya.restmodule.employee.model.EmployeeIncomeTaxDetails;
import nirmalya.aatithya.restmodule.employee.model.HrmsAdvancePaymentModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsAttendanceApprovalModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeBonousModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsEpfExcelModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsEsicExcelModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsExtraSalaryModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsLeaveApprovalRestModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsSalaryApproveCountModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsSalaryModel;

@Repository
public class HrmsEmployeeSalaryDao {

	Logger logger = LoggerFactory.getLogger(HrmsEmployeeSalaryDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	public final String PROCEDURE_NAME = "salary_routines";
	public final String ACTION_TYPE = "actionType";
	public final String ACTION_VALUE = "actionValue";

	/**
	 * for all employee details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>> getSalaryDetaiils(DataTableRequest request) {

		logger.info("Method in Dao: getemployeeDetails starts");

		List<HrmsEmployeeModel> employeList = new ArrayList<HrmsEmployeeModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "viewemployeeList").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[6] != null) {
						date = DateFormatter.returnStringDateYear(m[6]);
					}
					HrmsEmployeeModel employe = new HrmsEmployeeModel(m[0], m[1], m[2], m[3], null, null, null, m[4],
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, m[5],
							m[5], null, null, null, null, null, date, m[7], m[8], null, null, null, null, null, null,
							m[9], null, null, null, null, null, null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
							null, null);
					employeList.add(employe);

				}

				if (x.get(0).length > 10) {
					BigInteger t = (BigInteger) x.get(0)[10];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsEmployeeModel>> resp = new JsonResponse<List<HrmsEmployeeModel>>();
		resp.setBody(employeList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getemployeeDetails ends");

		return response;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public ResponseEntity<JsonResponse<List<HrmsSalaryModel>>> getEmployeeSalaryList(String fromDate, String toDate,
			String status) {
		logger.info("Rest Controller : getEmployeeDetailsForFoodTracking Starts");
		List<HrmsSalaryModel> salaryList = new ArrayList<HrmsSalaryModel>();
		try {
			String values = "SET @p_formDate = '" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "';";
			String actionType = "";
			if (status == null || status == "" || status.contentEquals("0")) {
				actionType = "getSalaryDetails";
			} else {
				actionType = "getSalaryApvDetails";
			}
			System.out.println("actionType " + actionType + " status " + status);
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, actionType)
					.setParameter(ACTION_VALUE, values).getResultList();
			if (!x.isEmpty()) {
				if (actionType.contentEquals("getSalaryDetails")) {
					for (Object[] m : x) {
						double grossSal = 0.00;
						double attRatio = 0.00;
						HrmsSalaryModel employe = new HrmsSalaryModel(null, m[0], m[1], null, null, m[2], m[3], m[4],
								m[5], m[14], null, m[6], m[7], m[8], m[9], m[10], m[11], null, m[12], null, null, null,
								null, null, null, m[13], null, m[15]);

						if (employe.getEmpWorkDays().intValue() != 0) {
							attRatio = employe.getEmpWorkDays().intValue() / employe.getWorkingDays();

							employe.setFoodAvail(employe.getWorkingDays() * 2);
							employe.setLeavDays(employe.getWorkingDays() - employe.getEmpWorkDays().doubleValue());

							employe.setPaidDays(employe.getEmpWorkDays().doubleValue());

							employe.setMonthlyGross(
									(double) Math.round(employe.getBasic() + employe.getHra() + employe.getOther()));

							employe.setBasic((double) Math.round((employe.getBasic() * attRatio)));
							employe.setHra((double) Math.round((employe.getHra() * attRatio)));
							employe.setOther((double) Math.round((employe.getOther() * attRatio)));

							employe.setEmpEpf((double) Math.round(((employe.getBasic() * 12) / 100)));
							employe.setEmployerEpf((double) Math.round((employe.getBasic() * 12) / 100));
							employe.setEmpEsic((double) Math.round((employe.getBasic() * 0.75) / 100));
							employe.setEmployerEsic((double) Math.round((employe.getBasic() * 3.25) / 100));

							if (employe.getFoodConsumed() == null) {
								employe.setFoodConsumed(0.00);
							}

							if (employe.getIncomeTax() == null) {
								employe.setIncomeTax(0.00);
							}
							if (employe.getExtraWorkDays() == null) {
								employe.setExtraWorkDays(0.00);
							}
							if (employe.getTotalTripAmount() == null) {
								employe.setTotalTripAmount(0.00);
							}
							if (employe.getFoodAllowAmount() == null) {
								employe.setFoodAllowAmount(0.00);
								employe.setFoodAmount(0.00);

							} else if (employe.getFoodAllowAmount() == 0) {
								employe.setFoodAllowAmount(0.00);
								employe.setFoodAmount(0.00);
							} else {
								employe.setFoodAmount(
										(double) Math.round(((employe.getFoodAvail() - employe.getFoodConsumed())
												* (employe.getFoodAvail() / employe.getFoodAllowAmount()))));
							}

							if (employe.getFoodAmount().isNaN() || employe.getFoodAmount().isInfinite()) {
								employe.setFoodAmount(0.00);
							}

							employe.setExtraSalary(
									(double) Math.round(((employe.getBasic() + employe.getHra() + employe.getOther())
											/ employe.getTotalDays().intValue() * employe.getExtraWorkDays())));
							if (employe.getExtraSalary().isNaN() || employe.getExtraSalary().isInfinite()) {
								employe.setExtraSalary(0.00);
							}
							grossSal = employe.getBasic() + employe.getHra() + employe.getOther()
									+ employe.getFoodAmount() + employe.getTotalTripAmount() + employe.getExtraSalary();
							employe.setTotalGrossSalary(grossSal);
							employe.setNetSalary((double) Math.round((grossSal - employe.getEmpEpf()
									- employe.getEmpEsic() - employe.getIncomeTax() - employe.getAdvanceAmount())));

						} else {
							employe.setBasic(0.00);
							employe.setOther(0.00);
							employe.setHra(0.00);
							employe.setEmpEpf(0.00);
							employe.setEmployerEpf(0.00);
							employe.setEmpEsic(0.00);
							employe.setEmployerEsic(0.00);
							if (employe.getFoodConsumed() == null) {
								employe.setFoodConsumed(0.00);
							}
							if (employe.getFoodAllowAmount() == null) {
								employe.setFoodAllowAmount(0.00);
							}
							if (employe.getIncomeTax() == null) {
								employe.setIncomeTax(0.00);
							}
							if (employe.getExtraWorkDays() == null) {
								employe.setExtraWorkDays(0.00);
							}
							if (employe.getTotalTripAmount() == null) {
								employe.setTotalTripAmount(0.00);
							}
							employe.setFoodAvail(0.00);
							employe.setLeavDays(employe.getWorkingDays() - employe.getEmpWorkDays().doubleValue());
							employe.setPaidDays(employe.getEmpWorkDays().doubleValue());
							employe.setFoodAmount(0.00);
							employe.setExtraSalary(0.00);
							employe.setTotalGrossSalary(0.00);
							employe.setNetSalary(0.00);
							employe.setMonthlyGross(0.00);
							employe.setPaidDays(0.00);
						}

						salaryList.add(employe);

					}
				} else {
					for (Object[] m : x) {
						Object fromDate1 = null;
						Object toDate1 = null;
						if (m[2] != null) {
							fromDate1 = DateFormatter.returnStringDate(m[2]);
						}
						if (m[3] != null) {
							toDate1 = DateFormatter.returnStringDate(m[3]);
						}
						HrmsSalaryModel employe = new HrmsSalaryModel(null, m[0], m[1], fromDate1, toDate1, null, m[4],
								m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17],
								m[18], m[19], m[20], m[21], m[22], m[23], m[24], m[25], m[26]);
						salaryList.add(employe);
					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsSalaryModel>> resp = new JsonResponse<List<HrmsSalaryModel>>();
		resp.setBody(salaryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsSalaryModel>>> response = new ResponseEntity<JsonResponse<List<HrmsSalaryModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getemployeeDetails ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsSalaryModel>>> searchByEmp(String fromDate, String toDate,
			String employeeName) {
		logger.info("Rest Controller : getEmployeeDetailsForFoodTracking Starts");
		List<HrmsSalaryModel> salaryList = new ArrayList<HrmsSalaryModel>();
		try {
			String values = "SET @p_formDate = '" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "',@p_searchParam='" + employeeName + "';";
			System.out.println("values " + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "searchByEmp").setParameter(ACTION_VALUE, values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					double grossSal = 0.00;
					double attRatio = 0.00;
					HrmsSalaryModel employe = new HrmsSalaryModel(null, m[0], m[1], null, null, m[2], m[3], m[4], m[5],
							m[13], null, m[6], m[7], m[8], m[9], m[10], null, m[11], null, null, null, null, null, null,
							null, m[12], null, m[14]);
					if (employe.getEmpWorkDays().intValue() != 0) {
						attRatio = employe.getEmpWorkDays().intValue() / employe.getWorkingDays();

						employe.setFoodAvail(employe.getWorkingDays() * 2);
						employe.setLeavDays(employe.getWorkingDays() - employe.getEmpWorkDays().doubleValue());
						employe.setPaidDays(employe.getEmpWorkDays().doubleValue());
						/*
						 * if (employe.getEmpWorkDays().doubleValue() - employe.getWorkingDays() > 0) {
						 * employe.setExtraWorkDays(employe.getEmpWorkDays().doubleValue() -
						 * employe.getWorkingDays()); } else { employe.setExtraWorkDays(0.00); }
						 */

						employe.setMonthlyGross(
								(double) Math.round(employe.getBasic() + employe.getHra() + employe.getOther()));

						employe.setBasic((double) Math.round((employe.getBasic() * attRatio)));
						employe.setHra((double) Math.round((employe.getHra() * attRatio)));
						employe.setOther((double) Math.round((employe.getOther() * attRatio)));

						employe.setEmpEpf((double) Math.round(((employe.getBasic() * 12) / 100)));
						employe.setEmployerEpf((double) Math.round((employe.getBasic() * 12) / 100));
						employe.setEmpEsic((double) Math.round((employe.getBasic() * 0.75) / 100));
						employe.setEmployerEsic((double) Math.round((employe.getBasic() * 3.25) / 100));

						if (employe.getFoodConsumed() == null) {
							employe.setFoodConsumed(0.00);
						}

						if (employe.getIncomeTax() == null) {
							employe.setIncomeTax(0.00);
						}
						if (employe.getExtraWorkDays() == null) {
							employe.setExtraWorkDays(0.00);
						}
						if (employe.getTotalTripAmount() == null) {
							employe.setTotalTripAmount(0.00);
						}
						if (employe.getFoodAllowAmount() == null) {
							employe.setFoodAllowAmount(0.00);
							employe.setFoodAmount(0.00);

						} else if (employe.getFoodAllowAmount() == 0) {
							employe.setFoodAllowAmount(0.00);
							employe.setFoodAmount(0.00);
						} else {
							System.out.println("work days " + employe.getFoodAvail() + "food consume "
									+ employe.getFoodConsumed() + "food consume =" + employe.getFoodAllowAmount());
							employe.setFoodAmount(
									(double) Math.round(((employe.getFoodAvail() - employe.getFoodConsumed())
											* (employe.getFoodAvail() / employe.getFoodAllowAmount()))));
						}

						if (employe.getFoodAmount().isNaN() || employe.getFoodAmount().isInfinite()) {
							employe.setFoodAmount(0.00);
						}

						employe.setExtraSalary(
								(double) Math.round(((employe.getBasic() + employe.getHra() + employe.getOther())
										/ employe.getTotalDays().intValue() * employe.getExtraWorkDays())));
						if (employe.getExtraSalary().isNaN() || employe.getExtraSalary().isInfinite()) {
							employe.setExtraSalary(0.00);
						}
						grossSal = employe.getBasic() + employe.getHra() + employe.getOther() + employe.getFoodAmount()
								+ employe.getTotalTripAmount() + employe.getExtraSalary();
						employe.setTotalGrossSalary(grossSal);

						employe.setNetSalary((double) Math.round((grossSal - employe.getEmpEpf() - employe.getEmpEsic()
								- employe.getIncomeTax() - employe.getAdvanceAmount())));

					} else {
						employe.setBasic(0.00);
						employe.setOther(0.00);
						employe.setHra(0.00);
						employe.setEmpEpf(0.00);
						employe.setEmployerEpf(0.00);
						employe.setEmpEsic(0.00);
						employe.setEmployerEsic(0.00);
						if (employe.getFoodConsumed() == null) {
							employe.setFoodConsumed(0.00);
						}
						if (employe.getFoodAllowAmount() == null) {
							employe.setFoodAllowAmount(0.00);
						}
						if (employe.getIncomeTax() == null) {
							employe.setIncomeTax(0.00);
						}
						if (employe.getExtraWorkDays() == null) {
							employe.setExtraWorkDays(0.00);
						}
						if (employe.getTotalTripAmount() == null) {
							employe.setTotalTripAmount(0.00);
						}
						employe.setFoodAvail(0.00);
						employe.setLeavDays(employe.getWorkingDays() - employe.getEmpWorkDays().doubleValue());
						employe.setPaidDays(employe.getEmpWorkDays().doubleValue());
						employe.setFoodAmount(0.00);
						employe.setExtraSalary(0.00);
						employe.setTotalGrossSalary(0.00);
						employe.setNetSalary(0.00);
						employe.setMonthlyGross(0.00);
						employe.setPaidDays(0.00);
					}

					salaryList.add(employe);

				}
				System.out.println("data " + salaryList.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsSalaryModel>> resp = new JsonResponse<List<HrmsSalaryModel>>();
		resp.setBody(salaryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsSalaryModel>>> response = new ResponseEntity<JsonResponse<List<HrmsSalaryModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getemployeeDetails ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> saveSalaryData(List<HrmsSalaryModel> testData) {
		logger.info("Method : saveSalaryData starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (HrmsSalaryModel l : testData) {

			if (l.getEmployeeId() == null || l.getEmployeeId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Employee Required");
				break;
			} else if (l.getFromDate() == null || l.getFromDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("From Date Required");
				break;
			} else if (l.getToDate() == null || l.getToDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("To Date Required");
				break;
			}
		}
		if (validity) {
			try {
				String values = HrmsGenerateSalaryParam.saveSalaryDetails(testData);
				System.out.println("values " + values);
//				if (flakiness.get(0).getConformityId() != null && flakiness.get(0).getConformityId() != "") {

//					em.createNamedStoredProcedureQuery("compresiveRoutines").setParameter("actionType", "modifyData")
//							.setParameter("actionValue", values).execute();
//				} else {

				em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, "saveSalaryData")
						.setParameter(ACTION_VALUE, values).execute();
//				}
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

		logger.info("Method : saveSalaryData ends");
		return response;
	}

	/*
	 * get trip details for pay role approval
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEmployeeBonousModel>>> getTripData(String fromDate, String toDate,
			String status) {
		logger.info("Rest Controller : getTripData Starts");
		List<HrmsEmployeeBonousModel> salaryList = new ArrayList<HrmsEmployeeBonousModel>();
		try {
			String actionType = "";
			String values = "SET @p_formDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "';";
			if (status.equals("0") || status == "" || status == null) {
				actionType = "getTripData";
			} else {
				actionType = "getApvTripData";
			}
			System.out.println("actionType " + actionType);
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, actionType)
					.setParameter(ACTION_VALUE, values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Double valD = 0.00;
					BigInteger att = new BigInteger("0");
					BigInteger totalTrip = new BigInteger("0");

					BigDecimal b = (BigDecimal) m[2];
					if (b != null) {
						att = b.toBigInteger();
					}

					if (actionType.contentEquals("getTripData")) {
						BigDecimal c = (BigDecimal) m[3];
						if (c != null) {
							totalTrip = c.toBigInteger();
						}

						BigInteger val = (BigInteger) m[4];
						if (val != null) {
							valD = val.doubleValue();
						}
					} else {
						valD = (Double) m[4];

						Double sas = (Double) m[3];
						totalTrip = BigDecimal.valueOf(sas).toBigInteger();
					}
					HrmsEmployeeBonousModel hrmsEmployeeBonousModel = new HrmsEmployeeBonousModel(null, null, null,
							m[0], m[1], att, totalTrip, null, valD);

					salaryList.add(hrmsEmployeeBonousModel);

				}
				System.out.println("salaryList = " + salaryList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsEmployeeBonousModel>> resp = new JsonResponse<List<HrmsEmployeeBonousModel>>();
		resp.setBody(salaryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsEmployeeBonousModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEmployeeBonousModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getTripData ends");
		return response;
	}

	/*
	 * get trip details for pay role approval
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<EmployeeFoodTrackingRestModel>>> getFoodData(String fromDate, String toDate,
			String empId, String status) {
		logger.info("Rest Controller : getFoodData Starts");
		List<EmployeeFoodTrackingRestModel> foodList = new ArrayList<EmployeeFoodTrackingRestModel>();
		try {
			String actionType = "";
			String values = "SET @p_formDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "';";
			if (status.equals("0") || status == "" || status == null) {
				actionType = "getFoodData";
			} else {
				actionType = "getApvFoodData";
			}
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, actionType)
					.setParameter(ACTION_VALUE, values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Integer intDayMeal = 0;
					Integer intNightMeal = 0;
					if (actionType.contentEquals("getFoodData")) {
						BigDecimal dayMeal = (BigDecimal) m[2];
						intDayMeal = dayMeal.intValue();

						BigDecimal nightMeal = (BigDecimal) m[3];
						intNightMeal = nightMeal.intValue();
					} else {
						Double asas = (Double) m[2];
						intDayMeal = asas.intValue();

						Double q = (Double) m[3];
						intNightMeal = q.intValue();
					}

					EmployeeFoodTrackingRestModel hrmsEmployeeBonousModel = new EmployeeFoodTrackingRestModel(m[0],
							m[1], null, intDayMeal, intNightMeal, null, null);
					hrmsEmployeeBonousModel.setTotalMeal(
							hrmsEmployeeBonousModel.getDayMeal() + hrmsEmployeeBonousModel.getNightMeal());
					foodList.add(hrmsEmployeeBonousModel);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<EmployeeFoodTrackingRestModel>> resp = new JsonResponse<List<EmployeeFoodTrackingRestModel>>();
		resp.setBody(foodList);
		System.out.println("salaryList = " + foodList);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<EmployeeFoodTrackingRestModel>>> response = new ResponseEntity<JsonResponse<List<EmployeeFoodTrackingRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getFoodData ends");
		return response;
	}

	/*
	 * get extra days details for pay role approval
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsExtraSalaryModel>>> getExtraSalary(String fromDate, String toDate,
			String empId, String status) {
		logger.info("dao : getExtraSalary Starts");
		List<HrmsExtraSalaryModel> foodList = new ArrayList<HrmsExtraSalaryModel>();
		try {
			String actionType = "";
			String values = "SET @p_formDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "';";
			if (status.equals("0") || status == "" || status == null) {
				actionType = "getExtraSalary";
			} else {
				actionType = "getExtraApvSalary";
			}
			System.out.println(actionType + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, actionType)
					.setParameter(ACTION_VALUE, values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					double extraDays = 0.00;
					Double workDay = 0.0;
					if (actionType.contentEquals("getExtraSalary")) {
						BigInteger workkDays = (BigInteger) m[3];
						workDay = workkDays.doubleValue();
						HrmsExtraSalaryModel hrmsEmployeeBonousModel = new HrmsExtraSalaryModel(m[0], m[1], m[2],
								workDay, null);
						extraDays = hrmsEmployeeBonousModel.getWorkDay().doubleValue()
								- hrmsEmployeeBonousModel.getWorkingDay().doubleValue();
						if (extraDays > 0) {
							hrmsEmployeeBonousModel.setExtraDay(extraDays);
						} else {
							hrmsEmployeeBonousModel.setExtraDay(0.00);
						}

						foodList.add(hrmsEmployeeBonousModel);

					} else {
						workDay = (Double) m[3];
						HrmsExtraSalaryModel hrmsEmployeeBonousModel = new HrmsExtraSalaryModel(m[0], m[1], m[2],
								workDay, m[4]);
						foodList.add(hrmsEmployeeBonousModel);

					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsExtraSalaryModel>> resp = new JsonResponse<List<HrmsExtraSalaryModel>>();
		resp.setBody(foodList);
		System.out.println("salaryList = " + foodList);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsExtraSalaryModel>>> response = new ResponseEntity<JsonResponse<List<HrmsExtraSalaryModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getExtraSalary ends");
		return response;
	}

	/*
	 * get attendance for pay role approval
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsAttendanceApprovalModel>>> getAttendanceDetails(String fromDate,
			String toDate, String empId, String status) {
		logger.info("Rest Controller : getAttendanceDetails Starts");
		List<HrmsAttendanceApprovalModel> foodList = new ArrayList<HrmsAttendanceApprovalModel>();
		try {
			String actionType = "";
			String values = "SET @p_formDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "';";
			System.out.println("values " + values);
			if (status.equals("0") || status == "" || status == null) {
				actionType = "getAttendanceDetails";
			} else {
				actionType = "getAttApvDetails";
			}
			System.out.println("actionType " + actionType + " " + status);
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, actionType)
					.setParameter(ACTION_VALUE, values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					Double workDay = 0.0;
					if (actionType.contentEquals("getAttendanceDetails")) {
						BigInteger workkDays = (BigInteger) m[3];
						workDay = workkDays.doubleValue();
					} else {
						workDay = (Double) m[3];
					}
					HrmsAttendanceApprovalModel hrmsEmployeeBonousModel = new HrmsAttendanceApprovalModel(m[0], m[1],
							null, null, m[2], workDay);

					foodList.add(hrmsEmployeeBonousModel);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsAttendanceApprovalModel>> resp = new JsonResponse<List<HrmsAttendanceApprovalModel>>();
		resp.setBody(foodList);
		System.out.println("attendance data  = " + foodList);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsAttendanceApprovalModel>>> response = new ResponseEntity<JsonResponse<List<HrmsAttendanceApprovalModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getAttendanceDetails ends");
		return response;
	}

	/*
	 * get count details approval
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsSalaryApproveCountModel>>> getCountDetails(String fromDate,
			String toDate) {
		logger.info("Rest Controller : getCountDetails Starts");
		List<HrmsSalaryApproveCountModel> foodList = new ArrayList<HrmsSalaryApproveCountModel>();
		try {
			String values = "SET @p_formDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter(ACTION_TYPE, "getCountDetails").setParameter(ACTION_VALUE, values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					HrmsSalaryApproveCountModel hrmsEmployeeBonousModel = new HrmsSalaryApproveCountModel(m[0], m[1],
							m[2], m[3], m[4], m[5], m[6], m[7]);

					foodList.add(hrmsEmployeeBonousModel);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsSalaryApproveCountModel>> resp = new JsonResponse<List<HrmsSalaryApproveCountModel>>();
		resp.setBody(foodList);
		System.out.println("salaryList = " + foodList);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsSalaryApproveCountModel>>> response = new ResponseEntity<JsonResponse<List<HrmsSalaryApproveCountModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getAttendanceDetails ends");
		return response;
	}

	/*
	 * get advance payment for pay role approval
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsAdvancePaymentModel>>> getAdvanceDetails(String fromDate, String toDate,
			String empId, String status) {
		logger.info("Rest Controller : getAdvanceDetails Starts");
		List<HrmsAdvancePaymentModel> foodList = new ArrayList<HrmsAdvancePaymentModel>();
		try {
			System.out.println(" status " + status);
			String actionType = "";
			String values = "SET @p_formDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "';";
			if (status.equals("0") || status == "" || status == null) {
				actionType = "getAdvanceDetails";
			} else {
				actionType = "getAdvApvDetails";
			}
			System.out.println("actionType " + actionType + " status " + status);
			System.out.println("values " + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, actionType)
					.setParameter(ACTION_VALUE, values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					HrmsAdvancePaymentModel hrmsEmployeeBonousModel = new HrmsAdvancePaymentModel(m[0], m[1], m[2]);

					foodList.add(hrmsEmployeeBonousModel);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsAdvancePaymentModel>> resp = new JsonResponse<List<HrmsAdvancePaymentModel>>();
		resp.setBody(foodList);
		System.out.println("salaryList = " + foodList);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsAdvancePaymentModel>>> response = new ResponseEntity<JsonResponse<List<HrmsAdvancePaymentModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getAdvanceDetails ends");
		return response;
	}

	/*
	 * get income tax for pay role approval
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<EmployeeIncomeTaxDetails>>> getIncomeTaxDetails(String fromDate,
			String toDate, String empId, String status) {
		logger.info("Rest Controller : getIncomeTaxDetails Starts");
		List<EmployeeIncomeTaxDetails> foodList = new ArrayList<EmployeeIncomeTaxDetails>();
		try {
			String actionType = "";
			String values = "SET @p_formDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "';";
			if (status.equals("0") || status == "" || status == null) {
				actionType = "getIncomeTaxDetails";
			} else {
				actionType = "getITApvDetails";
			}
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, actionType)
					.setParameter(ACTION_VALUE, values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					EmployeeIncomeTaxDetails hrmsEmployeeBonousModel = new EmployeeIncomeTaxDetails(null, m[0], m[1],
							null, null, m[2], null);

					foodList.add(hrmsEmployeeBonousModel);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<EmployeeIncomeTaxDetails>> resp = new JsonResponse<List<EmployeeIncomeTaxDetails>>();
		resp.setBody(foodList);
		System.out.println("salaryList = " + foodList);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<EmployeeIncomeTaxDetails>>> response = new ResponseEntity<JsonResponse<List<EmployeeIncomeTaxDetails>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getIncomeTaxDetails ends");
		return response;
	}

	/*
	 * save advance payment details
	 */
	public ResponseEntity<JsonResponse<Object>> saveAdvanceData(
			List<HrmsAdvancePaymentModel> hrmsAdvancePaymentModelList) {
		logger.info("Method : saveAdvanceData starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (HrmsAdvancePaymentModel l : hrmsAdvancePaymentModelList) {

			if (l.getEmployee() == null || l.getEmployee() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Employee Required");
				break;
			} else if (l.getFromDate() == null || l.getFromDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("From Date Required");
				break;
			} else if (l.getToDate() == null || l.getToDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("To Date Required");
				break;
			}
		}
		if (validity) {
			try {
				String values = GenerateSalaryApprovalParam.saveAdvancePaymentParam(hrmsAdvancePaymentModelList);

				em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, "saveAdvanceData")
						.setParameter(ACTION_VALUE, values).execute();

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

		logger.info("Method : saveAdvanceData ends");
		return response;
	}

	/*
	 * save advance payment details
	 */
	public ResponseEntity<JsonResponse<Object>> saveIncomeTaxData(
			List<EmployeeIncomeTaxDetails> hrmsAdvancePaymentModelList) {
		logger.info("Method : saveIncomeTaxData starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (EmployeeIncomeTaxDetails l : hrmsAdvancePaymentModelList) {

			if (l.getEmployeeId() == null || l.getEmployeeId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Employee Required");
				break;
			} else if (l.getFromDate() == null || l.getFromDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("From Date Required");
				break;
			} else if (l.getToDate() == null || l.getToDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("To Date Required");
				break;
			}
		}
		if (validity) {
			try {
				String values = GenerateSalaryApprovalParam.saveIncomeTaxParam(hrmsAdvancePaymentModelList);

				em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, "saveIncomeTaxData")
						.setParameter(ACTION_VALUE, values).execute();

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

		logger.info("Method : saveIncomeTaxData ends");
		return response;
	}

	/*
	 * save trip bonus details
	 */
	public ResponseEntity<JsonResponse<Object>> saveTripData(
			List<HrmsEmployeeBonousModel> hrmsEmployeeBonousModelList) {
		logger.info("Method : saveTripData starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (HrmsEmployeeBonousModel l : hrmsEmployeeBonousModelList) {

			if (l.getEmployeeId() == null || l.getEmployeeId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Employee Required");
				break;
			} else if (l.getFromDate() == null || l.getFromDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("From Date Required");
				break;
			} else if (l.getToDate() == null || l.getToDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("To Date Required");
				break;
			}
		}
		if (validity) {
			try {
				String values = GenerateSalaryApprovalParam.saveTripPaymentParam(hrmsEmployeeBonousModelList);

				em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, "saveTripData")
						.setParameter(ACTION_VALUE, values).execute();

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

		logger.info("Method : saveTripData ends");
		return response;
	}

	/*
	 * save trip bonus details
	 */
	public ResponseEntity<JsonResponse<Object>> saveFoodData(
			List<EmployeeFoodTrackingRestModel> employeeFoodTrackingRestModelList) {
		logger.info("Method : saveFoodData starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (EmployeeFoodTrackingRestModel l : employeeFoodTrackingRestModelList) {

			if (l.getEmployeeId() == null || l.getEmployeeId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Employee Required");
				break;
			} else if (l.getFromDate() == null || l.getFromDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("From Date Required");
				break;
			} else if (l.getToDate() == null || l.getToDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("To Date Required");
				break;
			}
		}
		if (validity) {
			try {
				String values = GenerateSalaryApprovalParam.saveFoodParam(employeeFoodTrackingRestModelList);

				em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, "saveFoodData")
						.setParameter(ACTION_VALUE, values).execute();

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

		logger.info("Method : saveFoodData ends");
		return response;
	}

	/*
	 * save extra salary details
	 */
	public ResponseEntity<JsonResponse<Object>> saveExtraSalaryData(
			List<HrmsExtraSalaryModel> hrmsExtraSalaryModelList) {
		logger.info("Method : saveExtraSalaryData starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (HrmsExtraSalaryModel l : hrmsExtraSalaryModelList) {

			if (l.getEmployeeId() == null || l.getEmployeeId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Employee Required");
				break;
			} else if (l.getFromDate() == null || l.getFromDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("From Date Required");
				break;
			} else if (l.getToDate() == null || l.getToDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("To Date Required");
				break;
			}
		}
		if (validity) {
			try {
				String values = GenerateSalaryApprovalParam.saveExtraSalaryParam(hrmsExtraSalaryModelList);

				em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, "saveExtraSalaryData")
						.setParameter(ACTION_VALUE, values).execute();

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

		logger.info("Method : saveExtraSalaryData ends");
		return response;
	}

	/*
	 * save extra salary details
	 */
	public ResponseEntity<JsonResponse<Object>> saveAttendanceData(
			List<HrmsAttendanceApprovalModel> hrmsAttendanceApprovalModelList) {
		logger.info("Method : saveExtraSalaryData starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (HrmsAttendanceApprovalModel l : hrmsAttendanceApprovalModelList) {

			if (l.getEmployeeId() == null || l.getEmployeeId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Employee Required");
				break;
			} else if (l.getFromDate() == null || l.getFromDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("From Date Required");
				break;
			} else if (l.getToDate() == null || l.getToDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("To Date Required");
				break;
			}
		}
		if (validity) {
			try {
				String values = GenerateSalaryApprovalParam.saveAttendanceParam(hrmsAttendanceApprovalModelList);

				em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, "saveAttendanceData")
						.setParameter(ACTION_VALUE, values).execute();

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

		logger.info("Method : saveExtraSalaryData ends");
		return response;
	}

	/*
	 * save extra salary details
	 */
	public ResponseEntity<JsonResponse<Object>> saveLeaveData(
			List<HrmsLeaveApprovalRestModel> hrmsLeaveApprovalRestModel) {
		logger.info("Method : saveExtraSalaryData starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (HrmsLeaveApprovalRestModel l : hrmsLeaveApprovalRestModel) {

			if (l.getEmployeeId() == null || l.getEmployeeId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Employee Required");
				break;
			} else if (l.getFromDate() == null || l.getFromDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("From Date Required");
				break;
			} else if (l.getToDate() == null || l.getToDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("To Date Required");
				break;
			}
		}
		if (validity) {
			try {
				String values = GenerateSalaryApprovalParam.saveLeaveParam(hrmsLeaveApprovalRestModel);

				em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, "saveLeaveData")
						.setParameter(ACTION_VALUE, values).execute();

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

		logger.info("Method : saveExtraSalaryData ends");
		return response;
	}

	/*
	 * get data for excel details of advance payment
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsAdvancePaymentModel>>> getAdvancePaymentDetailsExcel(
			DataTableRequest request) {

		logger.info("Method in Dao: getAdvancePaymentDetailsExcel starts");

		List<HrmsAdvancePaymentModel> DeliveryChalanPlantDensityModelList = new ArrayList<HrmsAdvancePaymentModel>();
		String param2 = request.getParam2();
		String param3 = request.getParam3();
		if (param2 != null && param2 != "") {
			String frmDate = DateFormatter.getStringDate(param2);
			request.setParam2(frmDate);
		}
		if (param3 != null && param3 != "") {
			String tDate = DateFormatter.getStringDate(param3);
			request.setParam3(tDate);
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter("actionType", "advanceApprovalExcel").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					/*
					 * Object date = null; if (m[4] != null) { date =
					 * DateFormatter.returnStringDate(m[4]); }
					 */

					HrmsAdvancePaymentModel deliveryChalanReprtModel = new HrmsAdvancePaymentModel(m[0], m[1], m[2],
							m[3], m[4], m, m, m);
					DeliveryChalanPlantDensityModelList.add(deliveryChalanReprtModel);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsAdvancePaymentModel>> resp = new JsonResponse<List<HrmsAdvancePaymentModel>>();
		resp.setBody(DeliveryChalanPlantDensityModelList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsAdvancePaymentModel>>> response = new ResponseEntity<JsonResponse<List<HrmsAdvancePaymentModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getAdvancePaymentDetailsExcel ends");
		System.out.println("@@" + response);
		return response;
	}

	// PDF and Excel Creation Dao
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEmployeeBonousModel>>> getTripExcelReports(DataTableRequest request) {

		logger.info("Method in Dao: getTripExcelReports starts");

		List<HrmsEmployeeBonousModel> DeliveryChalanPlantDensityModelList = new ArrayList<HrmsEmployeeBonousModel>();
		String param2 = request.getParam2();
		String param3 = request.getParam3();
		if (param2 != null && param2 != "") {
			String frmDate = DateFormatter.getStringDate(param2);
			request.setParam2(frmDate);
		}
		if (param3 != null && param3 != "") {
			String tDate = DateFormatter.getStringDate(param3);
			request.setParam3(tDate);
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter("actionType", "tripreportExcel").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object fromDate = null;
					if (m[0] != null) {
						fromDate = DateFormatter.returnStringDate(m[0]);
					}
					Object toDate = null;
					if (m[1] != null) {
						toDate = DateFormatter.returnStringDate(m[1]);
					}

					Double val = (Double) m[4];
					BigInteger k = BigDecimal.valueOf(val).toBigInteger();
					HrmsEmployeeBonousModel deliveryChalanReprtModel = new HrmsEmployeeBonousModel(null, fromDate,
							toDate, m[2], m[3], null, k, null, m[5]);
					DeliveryChalanPlantDensityModelList.add(deliveryChalanReprtModel);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsEmployeeBonousModel>> resp = new JsonResponse<List<HrmsEmployeeBonousModel>>();
		resp.setBody(DeliveryChalanPlantDensityModelList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsEmployeeBonousModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEmployeeBonousModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getTripExcelReports ends");

		return response;
	}

	// PDF and Excel Creation Dao
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsAttendanceApprovalModel>>> generateAttendanceExcel(
			DataTableRequest request) {

		logger.info("Method in Dao: generateAttendanceExcel starts");

		List<HrmsAttendanceApprovalModel> DeliveryChalanPlantDensityModelList = new ArrayList<HrmsAttendanceApprovalModel>();
		String param2 = request.getParam2();
		String param3 = request.getParam3();
		if (param2 != null && param2 != "") {
			String frmDate = DateFormatter.getStringDate(param2);
			request.setParam2(frmDate);
		}
		if (param3 != null && param3 != "") {
			String tDate = DateFormatter.getStringDate(param3);
			request.setParam3(tDate);
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter("actionType", "generateAttExcel").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object fromDate = null;
					if (m[2] != null) {
						fromDate = DateFormatter.returnStringDate(m[2]);
					}
					Object toDate = null;
					if (m[3] != null) {
						toDate = DateFormatter.returnStringDate(m[3]);
					}
					HrmsAttendanceApprovalModel deliveryChalanReprtModel = new HrmsAttendanceApprovalModel(m[0], m[1],
							fromDate, toDate, m[4], m[5]);
					DeliveryChalanPlantDensityModelList.add(deliveryChalanReprtModel);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsAttendanceApprovalModel>> resp = new JsonResponse<List<HrmsAttendanceApprovalModel>>();
		resp.setBody(DeliveryChalanPlantDensityModelList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsAttendanceApprovalModel>>> response = new ResponseEntity<JsonResponse<List<HrmsAttendanceApprovalModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: generateAttendanceExcel ends");

		return response;
	}

	// PDF and Excel Creation Dao
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsLeaveApprovalRestModel>>> generateLeaveExcel(DataTableRequest request) {

		logger.info("Method in Dao: generateLeaveExcel starts");

		List<HrmsLeaveApprovalRestModel> DeliveryChalanPlantDensityModelList = new ArrayList<HrmsLeaveApprovalRestModel>();
		String param2 = request.getParam2();
		String param3 = request.getParam3();
		if (param2 != null && param2 != "") {
			String frmDate = DateFormatter.getStringDate(param2);
			request.setParam2(frmDate);
		}
		if (param3 != null && param3 != "") {
			String tDate = DateFormatter.getStringDate(param3);
			request.setParam3(tDate);
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter("actionType", "generateLivExcel").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object fromDate = null;
					if (m[2] != null) {
						fromDate = DateFormatter.returnStringDate(m[2]);
					}
					Object toDate = null;
					if (m[3] != null) {
						toDate = DateFormatter.returnStringDate(m[3]);
					}
					HrmsLeaveApprovalRestModel deliveryChalanReprtModel = new HrmsLeaveApprovalRestModel(m[0], m[1],
							fromDate, toDate, m[4], m[5], m[6]);
					DeliveryChalanPlantDensityModelList.add(deliveryChalanReprtModel);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsLeaveApprovalRestModel>> resp = new JsonResponse<List<HrmsLeaveApprovalRestModel>>();
		resp.setBody(DeliveryChalanPlantDensityModelList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsLeaveApprovalRestModel>>> response = new ResponseEntity<JsonResponse<List<HrmsLeaveApprovalRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: generateLeaveExcel ends");

		return response;
	}

	// PDF and Excel Creation Dao
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<EmployeeFoodTrackingRestModel>>> getFoodDetailsExcel(
			DataTableRequest request) {

		logger.info("Method in Dao: getFoodDetailsExcel starts");

		List<EmployeeFoodTrackingRestModel> DeliveryChalanPlantDensityModelList = new ArrayList<EmployeeFoodTrackingRestModel>();
		String param2 = request.getParam2();
		String param3 = request.getParam3();
		if (param2 != null && param2 != "") {
			String frmDate = DateFormatter.getStringDate(param2);
			request.setParam2(frmDate);
		}
		if (param3 != null && param3 != "") {
			String tDate = DateFormatter.getStringDate(param3);
			request.setParam3(tDate);
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter("actionType", "getFoodDetailsExcel").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Double dayMeal = (Double) m[2];
					Integer day = dayMeal.intValue();
					Double nightMeal = (Double) m[3];
					Integer night = nightMeal.intValue();
					EmployeeFoodTrackingRestModel food = new EmployeeFoodTrackingRestModel(m[0], m[1], null, day, night,
							null, null);
					food.setTotalMeal(food.getDayMeal() + food.getNightMeal());
					food.setFromDate(param2);
					food.setToDate(param3);
					DeliveryChalanPlantDensityModelList.add(food);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<EmployeeFoodTrackingRestModel>> resp = new JsonResponse<List<EmployeeFoodTrackingRestModel>>();
		resp.setBody(DeliveryChalanPlantDensityModelList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<EmployeeFoodTrackingRestModel>>> response = new ResponseEntity<JsonResponse<List<EmployeeFoodTrackingRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getFoodDetailsExcel ends");

		return response;
	}

	// PDF and Excel Creation Dao
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsExtraSalaryModel>>> getExtraSalDetailsExcel(DataTableRequest request) {

		logger.info("Method in Dao: getExtraSalDetailsExcel starts");

		List<HrmsExtraSalaryModel> DeliveryChalanPlantDensityModelList = new ArrayList<HrmsExtraSalaryModel>();
		String param2 = request.getParam2();
		String param3 = request.getParam3();
		if (param2 != null && param2 != "") {
			String frmDate = DateFormatter.getStringDate(param2);
			request.setParam2(frmDate);
		}
		if (param3 != null && param3 != "") {
			String tDate = DateFormatter.getStringDate(param3);
			request.setParam3(tDate);
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter("actionType", "getExtraSalExcel").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					HrmsExtraSalaryModel salary = new HrmsExtraSalaryModel(m[0], m[1], m[2], m[3], m[4]);
					salary.setFromDate(param2);
					salary.setToDate(param3);
					DeliveryChalanPlantDensityModelList.add(salary);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsExtraSalaryModel>> resp = new JsonResponse<List<HrmsExtraSalaryModel>>();
		resp.setBody(DeliveryChalanPlantDensityModelList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsExtraSalaryModel>>> response = new ResponseEntity<JsonResponse<List<HrmsExtraSalaryModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getExtraSalDetailsExcel ends");

		return response;
	}

	// generate income tax excel report
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<EmployeeIncomeTaxDetails>>> getIncomeTaxDetailsExcel(
			DataTableRequest request) {

		logger.info("Method in Dao: getIncomeTaxDetailsExcel starts");

		List<EmployeeIncomeTaxDetails> DeliveryChalanPlantDensityModelList = new ArrayList<EmployeeIncomeTaxDetails>();
		String param2 = request.getParam2();
		String param3 = request.getParam3();
		if (param2 != null && param2 != "") {
			String frmDate = DateFormatter.getStringDate(param2);
			request.setParam2(frmDate);
		}
		if (param3 != null && param3 != "") {
			String tDate = DateFormatter.getStringDate(param3);
			request.setParam3(tDate);
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter("actionType", "getITDetails").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					EmployeeIncomeTaxDetails incomeTax = new EmployeeIncomeTaxDetails(null, m[0], m[1], null, null,
							m[2], null);
					incomeTax.setFromDate(param2);
					incomeTax.setToDate(param3);
					DeliveryChalanPlantDensityModelList.add(incomeTax);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<EmployeeIncomeTaxDetails>> resp = new JsonResponse<List<EmployeeIncomeTaxDetails>>();
		resp.setBody(DeliveryChalanPlantDensityModelList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<EmployeeIncomeTaxDetails>>> response = new ResponseEntity<JsonResponse<List<EmployeeIncomeTaxDetails>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getIncomeTaxDetailsExcel ends");

		return response;
	}

	// generate epf excel report
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEpfExcelModel>>> generateEpfExcelReport(DataTableRequest request) {

		logger.info("Method in Dao: generateEpfExcelReport starts");

		List<HrmsEpfExcelModel> hrmsEpfExcelModelList = new ArrayList<HrmsEpfExcelModel>();
		String param2 = request.getParam2();
		String param3 = request.getParam3();
		if (param2 != null && param2 != "") {
			String frmDate = DateFormatter.getStringDate(param2);
			request.setParam2(frmDate);
		}
		if (param3 != null && param3 != "") {
			String tDate = DateFormatter.getStringDate(param3);
			request.setParam3(tDate);
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter("actionType", "generateEpfReport").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					HrmsEpfExcelModel incomeTax = new HrmsEpfExcelModel(m[0], m[1], m[2], m[3], m[4], m[5]);
					incomeTax.setFromDate(param2);
					incomeTax.setToDate(param3);
					hrmsEpfExcelModelList.add(incomeTax);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsEpfExcelModel>> resp = new JsonResponse<List<HrmsEpfExcelModel>>();
		resp.setBody(hrmsEpfExcelModelList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsEpfExcelModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEpfExcelModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: generateEpfExcelReport ends");

		return response;
	}

	// generate esic excel report
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsEsicExcelModel>>> generateEsicExcelReport(DataTableRequest request) {

		logger.info("Method in Dao: generateEsicExcelReport starts");

		List<HrmsEsicExcelModel> hrmsEpfExcelModelList = new ArrayList<HrmsEsicExcelModel>();
		String param2 = request.getParam2();
		String param3 = request.getParam3();
		if (param2 != null && param2 != "") {
			String frmDate = DateFormatter.getStringDate(param2);
			request.setParam2(frmDate);
		}
		if (param3 != null && param3 != "") {
			String tDate = DateFormatter.getStringDate(param3);
			request.setParam3(tDate);
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter("actionType", "generateEsicReport").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					HrmsEsicExcelModel incomeTax = new HrmsEsicExcelModel(m[0], m[1], m[2], m[3], m[4], m[5]);
					incomeTax.setFromDate(param2);
					incomeTax.setToDate(param3);
					hrmsEpfExcelModelList.add(incomeTax);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsEsicExcelModel>> resp = new JsonResponse<List<HrmsEsicExcelModel>>();
		resp.setBody(hrmsEpfExcelModelList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsEsicExcelModel>>> response = new ResponseEntity<JsonResponse<List<HrmsEsicExcelModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: generateEsicExcelReport ends");

		return response;
	}

// get data for total salary
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsSalaryModel>>> getFinalSalaryExcel(DataTableRequest request) {

		logger.info("Method in Dao: getFinalSalaryExcel starts");

		List<HrmsSalaryModel> salaryList = new ArrayList<HrmsSalaryModel>();
		String param2 = request.getParam2();
		String param3 = request.getParam3();
		if (param2 != null && param2 != "") {
			String frmDate = DateFormatter.getStringDate(param2);
			request.setParam2(frmDate);
		}
		if (param3 != null && param3 != "") {
			String tDate = DateFormatter.getStringDate(param3);
			request.setParam3(tDate);
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME)
					.setParameter("actionType", "getFinalSalaryExcel").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object fromDate1 = null;
					Object toDate1 = null;
					if (m[2] != null) {
						fromDate1 = DateFormatter.returnStringDate(m[2]);
					}
					if (m[3] != null) {
						toDate1 = DateFormatter.returnStringDate(m[3]);
					}
					HrmsSalaryModel employe = new HrmsSalaryModel(null, m[0], m[1], fromDate1, toDate1, null, m[4],
							m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18],
							m[19], m[20], m[21], m[22], m[23], m[24], m[25], m[26]);
					salaryList.add(employe);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsSalaryModel>> resp = new JsonResponse<List<HrmsSalaryModel>>();
		resp.setBody(salaryList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsSalaryModel>>> response = new ResponseEntity<JsonResponse<List<HrmsSalaryModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getFinalSalaryExcel ends");
		System.out.println("@@" + response);
		return response;
	}

	/*
	 * get Leave for pay role approval
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsLeaveApprovalRestModel>>> getLeaveDetails(String fromDate,
			String toDate, String empId, String status) {
		logger.info("Rest Controller : getLeaveDetails Starts");
		List<HrmsLeaveApprovalRestModel> foodList = new ArrayList<HrmsLeaveApprovalRestModel>();
		try {
			String actionType = "";
			String values = "SET @p_formDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "';";
			System.out.println("values " + values);
			if (status.equals("0") || status == "" || status == null) {
				actionType = "getLeaveDetails";
			} else {
				actionType = "getLivApvDetails";
			}
			System.out.println("actionType " + actionType + " " + status);
			List<Object[]> x = em.createNamedStoredProcedureQuery(PROCEDURE_NAME).setParameter(ACTION_TYPE, actionType)
					.setParameter(ACTION_VALUE, values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {

					Double paidleave = 0.0;
					if (actionType.contentEquals("getLeaveDetails")) {
						BigInteger paiddLeave = (BigInteger) m[3];
						paidleave = paiddLeave.doubleValue();
					} else {
						paidleave = (Double) m[3];
					}

					Double unpaidleave = 0.0;
					if (actionType.contentEquals("getLeaveDetails")) {
						BigInteger unpaiddLeave = (BigInteger) m[4];
						unpaidleave = unpaiddLeave.doubleValue();
					} else {
						unpaidleave = (Double) m[4];
					}

					HrmsLeaveApprovalRestModel hrmsEmployeeBonousModel = new HrmsLeaveApprovalRestModel(m[0], m[1],
							null, null, m[2], paidleave, unpaidleave);

					foodList.add(hrmsEmployeeBonousModel);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsLeaveApprovalRestModel>> resp = new JsonResponse<List<HrmsLeaveApprovalRestModel>>();
		resp.setBody(foodList);
		System.out.println("attendance data  = " + foodList);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsLeaveApprovalRestModel>>> response = new ResponseEntity<JsonResponse<List<HrmsLeaveApprovalRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method in Dao: getLeaveDetails ends");
		return response;
	}

}
