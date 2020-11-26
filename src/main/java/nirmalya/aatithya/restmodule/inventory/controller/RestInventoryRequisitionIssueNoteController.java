/*
 * 
 * Class Define Rest Issue Note Entity
 * 
 */
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
import nirmalya.aatithya.restmodule.inventory.dao.InventoryRequisitionIssueNoteDao;
import nirmalya.aatithya.restmodule.inventory.model.RequisitionDetailsModel;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryRequisitionIssueNoteModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "inventory" })
public class RestInventoryRequisitionIssueNoteController {
	Logger logger = LoggerFactory.getLogger(RestInventoryRequisitionIssueNoteController.class);
	@Autowired
	InventoryRequisitionIssueNoteDao inventoryRequisitionIssueNoteDao;
	
	
	
	/*
	 * 
	 * Get mapping for get Store
	 * 
	 * 
	 */

	@RequestMapping(value = "/get-godown", method = { RequestMethod.GET })
	public List<DropDownModel> getGodown() {
		logger.info("Method : getGodown starts");
		logger.info("Method : getGodown endss");
		return inventoryRequisitionIssueNoteDao.getGodown();
	}
	
	
	/*
	 * 
	 * Get mapping for get Requisition Number For search
	 * 
	 * 
	 */
	@RequestMapping(value = "/getReqNoAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>>getRequisitionNumberForSearch(@RequestParam String id) {
		logger.info("Method : getRequisitionNumberForSearch starts");
		logger.info("Method : getRequisitionNumberForSearch endss");
		return inventoryRequisitionIssueNoteDao.getRequisitionNumberForSearch(id);
	}
	
	@RequestMapping(value = "/getRequisitionDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RequisitionDetailsModel>>> getRequisitionDetails(@RequestParam String id) {
		logger.info("Method : getRequisitionDetails starts");
		
		logger.info("Method : getRequisitionDetails endss");
		return inventoryRequisitionIssueNoteDao.getRequisitionDetails(id);
	}
	
	/*
	 * 
	 * Get mapping for get Requisition Number For search
	 * 
	 * 
	 */
	@RequestMapping(value = "/generateIssueNoAutoSearchPdf", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>>getIssueNumberForSearch(@RequestParam String id) {
		logger.info("Method : getIssueNumberForSearch starts");
		logger.info("Method : getIssueNumberForSearch endss");
		return inventoryRequisitionIssueNoteDao.generateIssueNoForScrhPdf(id);
	}
	/*
	 * 
	 * Get mapping for get ItemSubCategory for Issue Note
	 * 
	 * 
	 */

	@RequestMapping(value = "get-issueitemCategory", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getIssueItemCategory(@RequestParam String id) {
		logger.info("Method : getIssueItemCategory starts");
		logger.info("Method : getIssueItemCategory endss");
		return inventoryRequisitionIssueNoteDao.getIssueItemCategory(id);
	}
	/*
	 * 
	 * Get mapping for get ItemSubCategory for Issue Note
	 * 
	 * 
	 */

	@RequestMapping(value = "get-issueitemSubCategory", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getIssueItemSubCategory(@RequestParam String id,@RequestParam String reqNo) {
		logger.info("Method : getIssueItemSubCategory starts");
		logger.info("Method : getIssueItemSubCategory endss");
		return inventoryRequisitionIssueNoteDao.getIssueItemSubCategory(id,reqNo);
	}
	/*
	 * 
	 * Get Mapping for get item Name
	 * 
	 */
	@RequestMapping(value = "get-issueitemName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getIssueItemName(@RequestParam String id,@RequestParam String reqNo) {
		logger.info("Method : getIssueItemName starts");
		logger.info("Method : getIssueItemName endss");
		return inventoryRequisitionIssueNoteDao.getIssueItemName(id,reqNo);
	}
	/*
	 * 
	 * PostMapping for add Issue Note
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-addIssue-note", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addIssueNote(@RequestBody List<RestInventoryRequisitionIssueNoteModel> restInventoryRequisitionIssueNoteModel) {
		logger.info("Method : addIssueNote starts");
		logger.info("Method : addIssueNote ends");
		return inventoryRequisitionIssueNoteDao.addIssueNote(restInventoryRequisitionIssueNoteModel);
	}
	/*
	 * 
	 * method for Auto  Search of Requisition Number  
	 */
	@RequestMapping(value = "/getIssueListByAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>>getRequisitionNumberAutocompleteList(@RequestParam String id, @RequestParam String userId) {
		logger.info("Method : getRequisitionNumberAutocompleteList starts");

		logger.info("Method : getRequisitionNumberAutocompleteList ends");
		return inventoryRequisitionIssueNoteDao.getRequisitionNumberAutocompleteList(id,userId);
	}
	/*
	 * 
	 * method for Auto  Search of Requisition Number   for generate pdf report
	 */
	@RequestMapping(value = "/generateReqNoAutoSearchPdf", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>>generatereqNoForPdf(@RequestParam String id) {
		logger.info("Method : generatereqNoForPdf starts");

		logger.info("Method :generatereqNoForPdf ends");
		return inventoryRequisitionIssueNoteDao.generatereqNoForPdf(id);
	}
	/*
	 * 
	 * method for Auto  Search of Issue Number   for pdf report
	 */
	@RequestMapping(value = "/generateIssueNoForPdf", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>>generateIssueNoForPdf(@RequestParam String id) {
		logger.info("Method : generateIssueNoForPdf starts");

		logger.info("Method :generateIssueNoForPdf ends");
		return inventoryRequisitionIssueNoteDao.generateIssueNoForPdf(id);
	}
	/*
	 * 
	 * PostMapping for get All Issue Note
	 * 
	 * 
	 */
	@RequestMapping(value = "get-all-issue-note", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>> getAllIssueNote(
			@RequestBody DataTableRequest request) {
		logger.info("Method :  getAllIssueNote starts");
		logger.info("Method :  getAllIssueNote endss");
		return inventoryRequisitionIssueNoteDao.getAllIssueNote(request);
	}
	/*
	 * 
	 * GetMapping for get All Requisition
	 * 
	 * 
	 */
	@RequestMapping(value = "get-all-requisition-details", method = { RequestMethod.GET})
		public ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>> getAllReqDetails(@RequestParam String id) {
		logger.info("Method :  getAllReqDetails starts");
		logger.info("Method :  getAllReqDetails endss");
		return inventoryRequisitionIssueNoteDao.getAllReqDetails(id);
	}

	/*
	 * 
	 * GetMapping for get All Requisition
	 * 
	 * 
	 */
	@RequestMapping(value = "requisition-details", method = { RequestMethod.GET })
	public List<RestInventoryRequisitionIssueNoteModel> listrequisitionDetails(@RequestParam String id) {
		logger.info("Method : listrequisitionDetails starts");
		logger.info("Method : listrequisitionDetails endss");
		return inventoryRequisitionIssueNoteDao.listrequisitionDetails(id);
	}
	/*
	 * 
	 * GetMapping for get Available Quantity
	 * 
	 * 
	 */
	@RequestMapping(value = "get-barcode-details", method = { RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getBarCode(@RequestParam String id) {
		logger.info("Method :  getBarCode starts");
		logger.info("Method :  getBarCode endss");
		return inventoryRequisitionIssueNoteDao.getBarCode(id);
	}
	
	/*
	 * get barcode details
	 */
	@RequestMapping(value = "get-issueAvailableQuantity", method = { RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAvailableQuantity(@RequestParam String id) {
		logger.info("Method :  getAvailableQuantity starts");
		logger.info("Method :  getAvailableQuantity endss");
		return inventoryRequisitionIssueNoteDao.getAvailableQuantity(id);
	}
	
	/*
	 * 
	 * GetMapping for get Issued Quantity
	 * 
	 * 
	 */
	@RequestMapping(value = "get-issuedQuantity", method = { RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getIssuedQuantity(@RequestParam String id,@RequestParam String requistionNo) {
		logger.info("Method :  getIssuedQuantity starts");
		logger.info("Method :  getIssuedQuantity endss");
		return inventoryRequisitionIssueNoteDao.getIssuedQuantity(id,requistionNo);
	}
	
	/*
	 * 
	 * Get mapping for get one Issue Note for model view
	 * 
	 * 
	 */
	@RequestMapping(value = "get-issueNote-byId", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>> getIssueNoteForModel(
			@RequestParam String id) {
		logger.info("Method : getIssueNoteForModel starts");
		logger.info("Method : getIssueNoteForModel endss");
		return inventoryRequisitionIssueNoteDao.getIssueNoteForModel(id);
	}
	
	@RequestMapping(value = "changeRequestedItemStatus", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> changeRequestedItemStatus(
			@RequestParam String id) {
		logger.info("Method : changeRequestedItemStatus starts");
		logger.info("Method : changeRequestedItemStatus endss");
		return inventoryRequisitionIssueNoteDao.changeRequestedItemStatus(id);
	}

	/*
	 * 
	 * Get mapping for get one Issue Note for individual PDF view
	 * 
	 * 
	 */
	@RequestMapping(value = "get-issueNote-pdf", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>> getIssueNoteForPdf(
			@RequestParam String id) {
		logger.info("Method : getIssueNoteForPdf starts");
		logger.info("Method : getIssueNoteForPdf endss");
		return inventoryRequisitionIssueNoteDao.getIssueNoteForPdf(id);
	}
	/*
	 * 
	 * GetMapping for delete Issue Note
	 * 
	 * 
	 */
	@RequestMapping(value = "delete-issue-note", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteIssueNote(@RequestParam String id,@RequestParam String createdBy) {
		logger.info("Method : deleteIssueNote starts");
		logger.info("Method : deleteIssueNote endss");
		return inventoryRequisitionIssueNoteDao.deleteIssueNote(id,createdBy);
	}

	/*
	 * 
	 * Get mapping for edit Issue Note
	 * 
	 * 
	 */
	
	@RequestMapping(value = "edit-issue-note-byId", method = { RequestMethod.GET })
	public List<RestInventoryRequisitionIssueNoteModel> editIssueNoteById(@RequestParam("id")String id) {
		logger.info("Method : editIssueNoteById starts");
		logger.info("Method : editIssueNoteById endss");
		return inventoryRequisitionIssueNoteDao.editIssueNoteById(id);
	}
	/*
	 * 
	 * Get mapping for get ItemCategory for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "get-edit-issue-Category", method = { RequestMethod.GET })
	public List<DropDownModel> editIssueItemCategory(@RequestParam String id) {
		logger.info("Method : editIssueItemCategory starts");
		logger.info("Method : editIssueItemCategory endss");
		return inventoryRequisitionIssueNoteDao.editIssueItemCategory(id);
	}

	/*
	 * 
	 * Get mapping for get ItemSubCategory for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "get-edit-issue-SubCategory", method = { RequestMethod.GET })
	public List<DropDownModel> editIssueItemSubCategory(@RequestParam String id,@RequestParam String requistionNo) {
		logger.info("Method : getIssueItemSubCategory starts");
		logger.info("Method : getIssueItemSubCategory endss");
		return inventoryRequisitionIssueNoteDao.editIssueItemSubCategory(id,requistionNo);
	}

	/*
	 * 
	 * Get mapping for get ItemName for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "get-edit-issue-itemName", method = { RequestMethod.GET })
	public List<DropDownModel> editIssueItemName(@RequestParam String id,@RequestParam String requistionNo) {
		logger.info("Method : editIssueItemName starts");
		logger.info("Method : editIssueItemName endss");
		return inventoryRequisitionIssueNoteDao.editIssueItemName(id,requistionNo);
	}
	/*
	 * 
	 * Get mapping for get Available Quantity for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "get-edit-issue-availableQuantity", method = { RequestMethod.GET })
	public List<DropDownModel> editIssueAvailableQuantity(@RequestParam String id,String issueNo) {
		logger.info("Method : editIssueAvailableQuantity starts");
		logger.info("Method : editIssueAvailableQuantity endss");
		return inventoryRequisitionIssueNoteDao.editIssueAvailableQuantity(id,issueNo);
	}
	
	
	/*
	 * 
	 * Get mapping for get selected batch code  for edit
	 * 
	 * 
	 */
//	@RequestMapping(value = "get-edit-issue-getSelected-batchCode", method = { RequestMethod.GET })
//	public List<DropDownModel> editBatchCode(@RequestParam String id,String issueNo) {
//		logger.info("Method : editBatchCode starts");
//		logger.info("Method : editBatchCode endss");
//		return inventoryRequisitionIssueNoteDao.editBatchCode(id,issueNo);
//	}
	 
	
	/*
	 * 
	 * Get mapping for get selected batch code  for edit
	 * 
	 * 
	 */
//	@RequestMapping(value = "get-edit-issue-getAvail-batchCode", method = { RequestMethod.GET })
//	public List<DropDownModel> editAvailBatchCode(@RequestParam String id ) {
//		logger.info("Method : editAvailBatchCode starts");
//		logger.info("Method : editAvailBatchCode endss");
//		return inventoryRequisitionIssueNoteDao.editAvailBatchCode(id );
//	}
	
	/*
	 * 
	 * Get mapping for get Issued Quantity for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "get-edit-issued-quantity", method = { RequestMethod.GET })
	public List<DropDownModel> editIssuedQuantity(@RequestParam String id,@RequestParam String requistionNo) {
		logger.info("Method : editIssuedQuantity starts");
		logger.info("Method : editIssuedQuantity endss");
		return inventoryRequisitionIssueNoteDao.editIssuedQuantity(id,requistionNo);
	}


	/*
	 * 
	 * PostMapping for get All Issue Note PDF
	 * 
	 * 
	 */
	@RequestMapping(value = "get-all-issue-note-Pdf", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>> getAllIssueNotePdf(
			@RequestBody DataTableRequest request) {
		logger.info("Method :  getAllIssueNotePdf starts");
		logger.info("Method :  getAllIssueNotePdf endss");
		return inventoryRequisitionIssueNoteDao.getAllIssueNotePdf(request);
	}
	/*
	 * 
	 * PostMapping for get All Issue Note Report
	 * 
	 * 
	 */
	@RequestMapping(value = "get-all-issue-note-Report", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>> getAllIssueNoteReport(
			@RequestBody DataTableRequest request) {
		logger.info("Method :  getAllIssueNoteReport starts");
		logger.info("Method :  getAllIssueNoteReport endss");
		return inventoryRequisitionIssueNoteDao.getAllIssueNoteReport(request);
	}

	/* returns all Issue Note Excel
	 *
	 */
	@RequestMapping(value="get-all-issue-note-excel" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>> getAllIssueNoteDownload(@RequestBody DataTableRequest request) {
		return inventoryRequisitionIssueNoteDao.getAllIssueNoteDownload(request);
	}
	
	/*
	 * Get mapping for get Item Name
	 */

	@RequestMapping(value = "/getItemListByAutoSearchWithItemReq", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestInventoryRequisitionIssueNoteModel>>> getItemListByAutoSearchWithItemReq(@RequestParam String id , @RequestParam String reqId) {
		logger.info("Method : getItemListByAutoSearchWithItemReq starts");

		logger.info("Method : getItemListByAutoSearchWithItemReq endss");
		return inventoryRequisitionIssueNoteDao.getItemListByAutoSearchWithItemReq(id ,reqId);
	}
	
	/*
	 * 
	 * method for Auto  Search of Store
	 */
	@RequestMapping(value = "/getStoreAutoCompleteList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStoreAutoCompleteList(@RequestParam String id) {
	logger.info("Method : getStoreAutoCompleteList starts");

	logger.info("Method : getStoreAutoCompleteList ends");
	return inventoryRequisitionIssueNoteDao.getStoreAutoCompleteList(id);
	
	}
	
	
}