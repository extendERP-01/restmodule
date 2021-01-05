package nirmalya.aatithya.restmodule.employee.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.ManageEmployeeDao;
import nirmalya.aatithya.restmodule.master.controller.LocationMasterRestController;
import nirmalya.aatithya.restmodule.master.dao.LocationMasterDao;



/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping("employee/")
public class ManageEmployeeRestController {
	
	Logger logger = LoggerFactory.getLogger(ManageEmployeeRestController.class);

	@Autowired
	ManageEmployeeDao manageemployeeDao;
	
	
	@RequestMapping(value = "getCountryList", method = { RequestMethod.GET })
	public List<DropDownModel> getCountryList() {
		logger.info("Method : getCountryList starts");
		
		logger.info("Method : getCountryList ends");
		return manageemployeeDao.getCountryList();
		
		
	}
	@RequestMapping(value = "getstateList1", method = { RequestMethod.GET })
	public List<DropDownModel> getstateList1() {
		logger.info("Method : getStateList starts");
		
		logger.info("Method : getstateList ends");
		return manageemployeeDao.getstateList1();
	}
	@RequestMapping(value = "getcityList1", method = { RequestMethod.GET })
	public List<DropDownModel> getcityList1() {
		logger.info("Method : getcityList starts");
		
		logger.info("Method : getcityList ends");
		return manageemployeeDao.getcityList1();
	}
	
	@RequestMapping(value = "getgenderList1", method = { RequestMethod.GET })
	public List<DropDownModel> getgenderList1() {
		logger.info("Method : getgenderList1 starts");
		
		logger.info("Method : getgenderList1 ends");
		return manageemployeeDao.getgenderList1();
	}
	@RequestMapping(value = "getnationalityList1", method = { RequestMethod.GET })
	public List<DropDownModel> getnationalityList1() {
		logger.info("Method : getnationalityList1 starts");
		
		logger.info("Method : getnationalityList1 ends");
		return manageemployeeDao.getnationalityList1();
	}
	@RequestMapping(value = "getbloodgroupList1", method = { RequestMethod.GET })
	public List<DropDownModel> getbloodgroupList1() {
		logger.info("Method : getbloodgroupList1 starts");
		
		logger.info("Method : getbloodgroupList1 ends");
		return manageemployeeDao.getbloodgroupList1();
	}
	@RequestMapping(value = "getmaritalstatusList1", method = { RequestMethod.GET })
	public List<DropDownModel> getmaritalstatusList1() {
		logger.info("Method : getmaritalstatusList1 starts");
		
		logger.info("Method : getmaritalstatusList1 ends");
		return manageemployeeDao.getmaritalstatusList1();
	}
	
	@RequestMapping(value = "getdocumenttypeList1", method = { RequestMethod.GET })
	public List<DropDownModel> getdocumenttypeList1() {
		logger.info("Method : getdocumenttypeList1 starts");
		
		logger.info("Method : getdocumenttypeList1 ends");
		return manageemployeeDao.getdocumenttypeList1();
	}
	@RequestMapping(value = "getJobType1", method = { RequestMethod.GET })
	public List<DropDownModel> getJobType1() {
		logger.info("Method : getJobType1 starts");
		
		logger.info("Method : getJobType1 ends");
		return manageemployeeDao.getJobType1();
	}
	@RequestMapping(value = "getDepartmentList1", method = { RequestMethod.GET })
	public List<DropDownModel> getDepartmentList1() {
		logger.info("Method : getDepartmentList1 starts");
		
		logger.info("Method : getDepartmentList1 ends");
		return manageemployeeDao.getDepartmentList1();
	}
	
	@RequestMapping(value = "getemploymentstatusList1", method = { RequestMethod.GET })
	public List<DropDownModel> getemploymentstatusList1() {
		logger.info("Method : getemploymentstatusList1 starts");
		
		logger.info("Method : getemploymentstatusList1 ends");
		return manageemployeeDao.getemploymentstatusList1();
	}
	@RequestMapping(value = "getJobType2", method = { RequestMethod.GET })
	public List<DropDownModel> getJobType2() {
		logger.info("Method : getJobType2 starts");
		
		logger.info("Method : getJobType2 ends");
		return manageemployeeDao.getJobType2();
	}
	@RequestMapping(value = "getBenefits", method = { RequestMethod.GET })
	public List<DropDownModel> getBenefits() {
		logger.info("Method : getBenefits starts");
		
		logger.info("Method : getBenefits ends");
		return manageemployeeDao.getBenefits();
	}
	@RequestMapping(value = "getBankNameList", method = { RequestMethod.GET })
	public List<DropDownModel> getBankNameList() {
		logger.info("Method : getBankNameList starts");
		
		logger.info("Method : getBankNameList ends");
		return manageemployeeDao.getBankNameList();
	}
	
}
