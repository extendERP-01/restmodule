package nirmalya.aatithya.restmodule.employee.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateLocationMasterParameter;
import nirmalya.aatithya.restmodule.master.dao.LocationMasterDao;


/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class ManageEmployeeDao {
	
	
	Logger logger = LoggerFactory.getLogger(ManageEmployeeDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCountryList() {
		logger.info("Method : getCountryListemployee starts");

		List<DropDownModel> CountryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getCountryList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				CountryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryListForemployee ends");
		return CountryList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getstateList1() {
		logger.info("Method : getstateListemployee starts");

		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getstateList1").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getstateListForemployee ends");
		return stateList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getcityList1() {
		logger.info("Method : getcityListemployee starts");

		List<DropDownModel> cityList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getcityList1").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				cityList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryListForemployee ends");
		return cityList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getgenderList1() {
		logger.info("Method : genderTypeList starts");

		List<DropDownModel> genderTypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getgenderList1").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				genderTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryListForemployee ends");
		return genderTypeList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getnationalityList1() {
		logger.info("Method : getnationalityList1 starts");

		List<DropDownModel> nationalityList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "nationalityList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				nationalityList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryListForemployee ends");
		return nationalityList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getbloodgroupList1() {
		logger.info("Method : getnationalityList1 starts");

		List<DropDownModel> bloodgroupList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getbloodgroupList1").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				bloodgroupList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryListForemployee ends");
		return bloodgroupList;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getmaritalstatusList1() {
		logger.info("Method : getmaritalstatusList1 starts");

		List<DropDownModel> maritalstatusList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "maritalstatusList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				maritalstatusList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryListForemployee ends");
		return maritalstatusList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getdocumenttypeList1() {
		logger.info("Method : documenttypeList starts");

		List<DropDownModel> documenttypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "documenttypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				documenttypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : documenttypeList ends");
		return documenttypeList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getJobType1() {
		logger.info("Method : getJobType1 starts");

		List<DropDownModel> jobtypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "jobtypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				jobtypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getJobType1 ends");
		return jobtypeList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepartmentList1() {
		logger.info("Method : getDepartmentList1 starts");

		List<DropDownModel> DepartmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "DepartmentList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				DepartmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDepartmentList1 ends");
		return DepartmentList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getemploymentstatusList1() {
		logger.info("Method : getemploymentstatusList1 starts");

		List<DropDownModel> employmentstatusList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getemploymentstatusList1").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentstatusList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getemploymentstatusList1 ends");
		return employmentstatusList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getJobType2() {
		logger.info("Method : getJobType2 starts");

		List<DropDownModel> jobtypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "jobtypeList2").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				jobtypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : jobtypeList2 ends");
		return jobtypeList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getBenefits() {
		logger.info("Method : getBenefits starts");

		List<DropDownModel> benefitsList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "benefitsList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				benefitsList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : benefitsList ends");
		return benefitsList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getBankNameList() {
		logger.info("Method : getBankNameList starts");

		List<DropDownModel> getBankNameList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getBankNameList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getBankNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : benefitsList ends");
		return getBankNameList;
	}
}
