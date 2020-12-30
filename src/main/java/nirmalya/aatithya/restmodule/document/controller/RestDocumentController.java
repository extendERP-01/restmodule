package nirmalya.aatithya.restmodule.document.controller;

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
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.document.dao.RestDocumentDao;
import nirmalya.aatithya.restmodule.document.model.RestApprovalHoistoryModel;
import nirmalya.aatithya.restmodule.document.model.RestDocumentModel;


/**
 * @author NirmalyaLabs
 *
 */

@RestController
@RequestMapping(value = {"document"})
public class RestDocumentController {
	Logger logger=LoggerFactory.getLogger(RestDocumentController.class);

	@Autowired
	RestDocumentDao restDocumentDao;
	@Autowired
	ServerDao serverDao;
	/*
	 * 
	 * get mapping for add get category
	 * 
	 * 
	 */
	@RequestMapping(value = "get-category", method = { RequestMethod.GET })
	public List<DropDownModel> getCategory() {
		logger.info("Method : getCategory starts");
		logger.info("Method : getCategory endss");
		return restDocumentDao.getCategory();
	}
	/*
	 * 
	 * get mapping for add get files
	 * 
	 * 
	 */
	@RequestMapping(value = "get-files", method = { RequestMethod.GET })
	public List<DropDownModel> getFiles(@RequestParam String id) {
		logger.info("Method : getFiles starts");
		logger.info("Method : getFiles endss");
		return restDocumentDao.getFiles(id);
	}
	/*
	 * 
	 * post mapping for add rest document
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-addnew-document", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddDocument(@RequestBody RestDocumentModel restDocumentModel) {
		logger.info("Method : restAddDocument starts");
		logger.info("Method : restAddDocument endss");
		return restDocumentDao.addDocument(restDocumentModel);
	}
	/*
	 * 
	 * post Mapping for listing Document
	 * 
	 * 
	 */
	@RequestMapping(value = "get-all-document", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestDocumentModel>>> getAllDocument(@RequestBody DataTableRequest request) {
		logger.info("Method : getAllDocument starts");
		logger.info("Method : getAllDocument ends");
		return restDocumentDao.getAllDocument(request);
	}
	/*
	 * 
	 * post Mapping for listing Document for Approval
	 * 
	 * 
	 */
	@RequestMapping(value = "get-all-document-approve", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestDocumentModel>>> getAllDocumentApprove(
			@RequestBody DataTableRequest request) {
		logger.info("Method :  getAllDocumentApprove starts");
		logger.info("Method :  getAllDocumentApprove endss");
		return restDocumentDao.getAllDocumentApprove(request);
	}
	
	/**
	 * returns particular Document to view/edit
	 *
	 */
	@RequestMapping(value = "get-document-byId", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestDocumentModel>> getDocumentById(@RequestParam String id) {
		logger.info("Method : getDocumentById starts");
		logger.info("Method : getDocumentById endss");
		return restDocumentDao.getDocumentById(id);
	}
	/**
	 * returns particular Document to view/edit
	 *
	 */
	@RequestMapping(value = "get-documentHistory-byId", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestApprovalHoistoryModel>>> getDocumentHistoryById(@RequestParam String id) {
		logger.info("Method : getDocumentHistoryById starts");
		logger.info("Method : getDocumentHistoryById endss");
		return restDocumentDao.getDocumentHistoryById(id);
	}
	/*
	 * 
	 * GetMapping for delete Document
	 * 
	 * 
	 */
	@RequestMapping(value = "delete-document", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteDocument(@RequestParam String id,@RequestParam String createdBy) {
		logger.info("Method : deleteDocument starts");
		logger.info("Method : deleteDocument ends");
		return restDocumentDao.deleteDocument(id,createdBy);
	}
	/*
	 * 
	 * GetMapping for save-document-approval-action
	 * 
	 * 
	 */
	@RequestMapping(value = "save-document-approval-action", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> saveDocumentApprovalAction(@RequestParam String id,@RequestParam String createdBy) {
		logger.info("Method : saveDocumentApprovalAction starts");
		logger.info("Method : saveDocumentApprovalAction endss");
		return restDocumentDao.saveDocumentApprovalAction(id,createdBy);
	}
	/*
	 * 
	 * GetMapping for save-requisition-reject-action
	 * 
	 * 
	 */
	@RequestMapping(value = "save-document-reject-action", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveDocumentRejectAction(@RequestBody RestDocumentModel reqobject) {
		logger.info("Method : saveDocumentRejectAction starts");
		logger.info("Method : saveDocumentRejectAction endss");
		return restDocumentDao.saveDocumentRejectAction(reqobject);
	}
}
