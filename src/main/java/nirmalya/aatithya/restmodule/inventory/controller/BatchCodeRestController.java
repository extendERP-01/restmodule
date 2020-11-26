package nirmalya.aatithya.restmodule.inventory.controller;

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

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.dao.BatchCodeDao;
import nirmalya.aatithya.restmodule.inventory.model.BatchCodeModel;

@RestController
@RequestMapping("inventory/")
public class BatchCodeRestController {

	Logger logger = LoggerFactory.getLogger(BatchCodeRestController.class);
	
	@Autowired
	BatchCodeDao batchCodeDao;
	
	@RequestMapping(value = "/getGRNForBatchCode", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> restGetGRNForBatchCode(@RequestParam String id) {
		logger.info("Method : restGetGRNForBatchCode starts");

		logger.info("Method : restGetGRNForBatchCode ends");
		return batchCodeDao.getGRNForBatchCodeDao(id);
	}
	
	@RequestMapping(value = "/getGRNDetailsForBatchCode", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<BatchCodeModel>>> restGetGRNDetailsForBatchCode(@RequestParam String id) {
		logger.info("Method : restGetGRNDetailsForBatchCode starts");
		
		logger.info("Method : restGetGRNDetailsForBatchCode ends");
		return batchCodeDao.getGRNDetailsForBatchCodeDao(id);
	}
	
	@RequestMapping(value="newBatchCodeSave" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> restNewBatchCodeSave(@RequestBody  List<BatchCodeModel> batchCode) {
		logger.info("Method : restNewBatchCodeSave for rest controller starts");
		
		logger.info("Method : restNewBatchCodeSave for rest controller ends");
		return batchCodeDao.newBatchCodeSaveDao(batchCode);
	}
	
	@RequestMapping(value = "/getBatchCodeDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<BatchCodeModel>>> restGetBatchCodeDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : restGetBatchCodeDetails starts");
		
		logger.info("Method : restGetBatchCodeDetails ends");
		return batchCodeDao.getBatchCodeDetailsDao(request);
	}
	
	@RequestMapping(value = "/getBatchCodeById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<BatchCodeModel>>> restGetBatchCodeById(@RequestParam("id")String id) {
		logger.info("Method : restGetBatchCodeById starts");

		logger.info("Method : restGetBatchCodeById ends");
		return batchCodeDao.getBatchCodeByIdDao(id);
	}
	
	@RequestMapping(value = "/editBatchCode", method = { RequestMethod.GET })
	public List<BatchCodeModel> restEditBatchCode(@RequestParam("id")String id) {
		logger.info("Method : restEditBatchCode for rest controller starts");
		
		logger.info("Method : restEditBatchCode for rest controller ends");
		return batchCodeDao.editBatchCodeDao(id);
	}
}
