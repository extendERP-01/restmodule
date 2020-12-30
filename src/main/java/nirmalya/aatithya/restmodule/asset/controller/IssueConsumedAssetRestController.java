package nirmalya.aatithya.restmodule.asset.controller;

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

import nirmalya.aatithya.restmodule.asset.dao.IssueConsumedAssetDao;
import nirmalya.aatithya.restmodule.asset.model.IssueConsumedItemModel;
import nirmalya.aatithya.restmodule.asset.model.ItemAssetModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "asset/")
public class IssueConsumedAssetRestController {

	Logger logger = LoggerFactory.getLogger(IssueConsumedAssetRestController.class);
	
	@Autowired
	IssueConsumedAssetDao issueConsumedAssetDao;
	
	@RequestMapping(value = "/getConsumeItemForIssue", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getConsumeItemForIssue(@RequestParam String id) {
		logger.info("Method : getConsumeItemForIssue starts");

		logger.info("Method : getConsumeItemForIssue ends");
		return issueConsumedAssetDao.getConsumeItemForIssue(id);
	}
	
	@RequestMapping(value = "/getJobCardForIssue", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getJobCardForIssue(@RequestParam String id, @RequestParam String jobCard) {
		logger.info("Method : getJobCardForIssue starts");
		
		logger.info("Method : getJobCardForIssue ends");
		return issueConsumedAssetDao.getJobCardForIssue(id,jobCard);
	}
	
	@RequestMapping(value = "/getConsumeItemDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ItemAssetModel>>> getConsumeItemDetails(@RequestParam String id) {
		logger.info("Method : getConsumeItemDetails starts");
		
		logger.info("Method : getConsumeItemDetails ends");
		return issueConsumedAssetDao.getConsumeItemDetails(id);
	}
	
	@RequestMapping(value="issueItemToVehicle" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> issueItemToVehicle(@RequestBody  List<IssueConsumedItemModel> issuedItem) {
		logger.info("Method : issueItemToVehicle for rest controller starts");
		
		logger.info("Method : issueItemToVehicle for rest controller ends");
		return issueConsumedAssetDao.issueItemToVehicle(issuedItem);
	}
	
	@RequestMapping(value = "/getIssuedConsumedItem", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<IssueConsumedItemModel>>> getIssuedConsumedItem(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getIssuedConsumedItem starts");

		logger.info("Method : getIssuedConsumedItem ends");
		return issueConsumedAssetDao.getIssuedConsumedItem(request);
	}
	
	@RequestMapping(value = "/editIssuedConsumedItem", method = { RequestMethod.GET })
	public List<IssueConsumedItemModel> editIssuedConsumedItem(@RequestParam("id")String id, @RequestParam("vehicleAsset") String vehicleAsset) {
		logger.info("Method : editIssuedConsumedItem for rest controller starts");
		
		logger.info("Method : editIssuedConsumedItem for rest controller ends");
		return issueConsumedAssetDao.editIssuedConsumedItem(id,vehicleAsset);
	}
}
