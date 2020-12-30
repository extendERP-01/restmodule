package nirmalya.aatithya.restmodule.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.employee.dao.PreferencePreviewDao;

@RestController
@RequestMapping("employee/")

public class PreferencePreviewRestController {
	
	Logger logger = LoggerFactory.getLogger(PreferencePreviewRestController.class);

	@Autowired
	PreferencePreviewDao preferencePreviewDao;
	
	/**
	 * 
	 * @return Performance level list
	 */
	@RequestMapping(value = "getPerformancelevel", method = { RequestMethod.GET })
	public List<DropDownModel> getPerfLevelList() {

		logger.info("Method : getPerfLevelList starts");
		logger.info("Method : getPerfLevelList ends");

		return preferencePreviewDao.getPerfLevelList();
	}

}
