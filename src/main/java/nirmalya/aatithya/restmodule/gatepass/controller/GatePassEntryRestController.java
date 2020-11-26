package nirmalya.aatithya.restmodule.gatepass.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.gatepass.dao.GatePassEntryDao;
import nirmalya.aatithya.restmodule.gatepass.model.GatePassEntryModel;
import nirmalya.aatithya.restmodule.gatepass.model.GatePassItemModel;
import nirmalya.aatithya.restmodule.sales.model.QuotationMasterModel;

/**
 * @author Nirmalya Labs
 */
@RestController
@RequestMapping(value = "gatepass/")
public class GatePassEntryRestController {

	Logger logger = LoggerFactory.getLogger(GatePassEntryRestController.class);

	@Autowired
	GatePassEntryDao gatePassEntryDao;

	@RequestMapping(value = "getStoreForGatePassEntry", method = { RequestMethod.GET })
	public List<DropDownModel> restGetStoreForGatePassEntry(@RequestParam String id) {
		logger.info("Method : restGetStoreForGatePassEntry starts");

		logger.info("Method : restGetStoreForGatePassEntry ends");
		return gatePassEntryDao.getStoreForGatePassEntryDao(id);
	}

	@GetMapping(value = "/getPOAutoSearchForGatePassEntry" )
	public ResponseEntity<JsonResponse<List<DropDownModel>>> restGetPOAutoSearchForGatePassEntry(
			@RequestParam String id ,@RequestParam String store) {
		logger.info("Method : restGetPOAutoSearchForGatePassEntry starts");

		logger.info("Method : restGetPOAutoSearchForGatePassEntry ends");
		return gatePassEntryDao.getPOAutoSearchForGatePassEntryDao(id ,store);
	}

	@RequestMapping(value = "/getCustomerForGatePassEntry", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> restGetCustomerForGatePassEntry(@RequestParam String id) {
		logger.info("Method : restGetCustomerForGatePassEntry starts");

		logger.info("Method : restGetCustomerForGatePassEntry ends");
		return gatePassEntryDao.getCustomerForGatePassEntryDao(id);
	}

	@RequestMapping(value = "/getItemForGatePassEntry", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> restGetItemForGatePassEntry(
			@RequestBody DropDownModel id) {
		logger.info("Method : restGetItemForGatePassEntry starts");

		logger.info("Method : restGetItemForGatePassEntry ends");
		return gatePassEntryDao.getItemForGatePassEntryDao(id);
	}

	@RequestMapping(value = "/getServeTypeForGatePassEntry", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<GatePassItemModel>>> restGetServeTypeForGatePassEntry(
			@RequestParam String id) {
		logger.info("Method : restGetServeTypeForGatePassEntry starts");

		logger.info("Method : restGetServeTypeForGatePassEntry ends");
		return gatePassEntryDao.getServeTypeForGatePassEntryDao(id);
	}

	@RequestMapping(value = "newGatePassEntrySave", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restNewGatePassEntrySave(
			@RequestBody List<GatePassEntryModel> gatePass) {
		logger.info("Method : restNewGatePassEntrySave for rest controller starts");

		logger.info("Method : restNewGatePassEntrySave for rest controller ends");
		return gatePassEntryDao.newGatePassEntrySaveDao(gatePass);
	}

	@RequestMapping(value = "/getGatePassEntryDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<GatePassEntryModel>>> restGetGatePassEntryDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : restGetGatePassEntryDetails starts");

		logger.info("Method : restGetGatePassEntryDetails ends");
		return gatePassEntryDao.getGatePassEntryDetailsDao(request);
	}

	@RequestMapping(value = "/editGatePassEntry", method = { RequestMethod.GET })
	public List<GatePassEntryModel> restEditGatePassEntry(@RequestParam("id") String id) {
		logger.info("Method : restEditGatePassEntry for rest controller starts");

		logger.info("Method : restEditGatePassEntry for rest controller ends");
		return gatePassEntryDao.editGatePassEntryDao(id);
	}

	@RequestMapping(value = "editGatePassEntryPODtls", method = { RequestMethod.GET })
	public List<GatePassItemModel> restEditGatePassEntryPODtls(@RequestParam String id) {
		logger.info("Method : restEditGatePassEntryPODtls starts");

		logger.info("Method : restEditGatePassEntryPODtls ends");
		return gatePassEntryDao.editGatePassEntryPODtlsDao(id);
	}

	@RequestMapping(value = "/getGatePassEntryById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<GatePassEntryModel>>> restGetGatePassEntryById(
			@RequestParam("id") String id) {
		logger.info("Method : restGetGatePassEntryById starts");

		logger.info("Method : restGetGatePassEntryById ends");
		return gatePassEntryDao.getGatePassEntryByIdDao(id);
	}

	@RequestMapping(value = "/getItemDetailsByPOrder", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<GatePassItemModel>>> getItemDetailsByPOrder(@RequestParam String id) {
		logger.info("Method : getItemDetailsByPOrder starts");

		logger.info("Method : getItemDetailsByPOrder ends");
		return gatePassEntryDao.getItemDetailsByPOrder(id);
	}

	@RequestMapping(value = "restLogoImage-GatePass", method = { RequestMethod.GET })
	public List<DropDownModel> restGetLogoImage(@RequestParam("logoType") String logoType) {
		logger.info("Method : restGetLogoImage starts");

		logger.info("Method : restGetLogoImage ends");
		return gatePassEntryDao.getHotelLogo(logoType);
	}
	
	/**
	 * REST CONTROLLER - Get Hotel List
	 *
	 */
	@GetMapping(value = "restGetStoreDetails" )
	public List<QuotationMasterModel> restGetStoreDetails(@RequestParam("id") String id) {
		logger.info("Method : restGetStoreDetails starts");

		logger.info("Method : restGetStoreDetails ends");
		return gatePassEntryDao.restGetStoreDetails(id);
	}
}
