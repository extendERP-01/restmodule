package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.master.dao.ProductMasterDao;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "master/")
public class ProductMasterRestController {

	Logger logger = LoggerFactory.getLogger(ProductMasterRestController.class);

	@Autowired
	ProductMasterDao productMasterDao;
	
	@RequestMapping(value = "getBrandListForProduct", method = { RequestMethod.GET })
	public List<DropDownModel> getBrandListForProduct() {
		logger.info("Method : getBrandListForProduct starts");
		
		logger.info("Method : getBrandListForProduct ends");
		return productMasterDao.getBrandListForProduct();
	}
	
	@RequestMapping(value = "getModeListForProduct", method = { RequestMethod.GET })
	public List<DropDownModel> getModeListForProduct() {
		logger.info("Method : getModeListForProduct starts");
		
		logger.info("Method : getModeListForProduct ends");
		return productMasterDao.getModeListForProduct();
	}
	
	@RequestMapping(value = "getHSNCodeListForProduct", method = { RequestMethod.GET })
	public List<DropDownModel> getHSNCodeListForProduct() {
		logger.info("Method : getHSNCodeListForProduct starts");
		
		logger.info("Method : getHSNCodeListForProduct ends");
		return productMasterDao.getHSNCodeListForProduct();
	}
}
