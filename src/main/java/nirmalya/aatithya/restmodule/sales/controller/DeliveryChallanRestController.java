package nirmalya.aatithya.restmodule.sales.controller;

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
import nirmalya.aatithya.restmodule.sales.dao.DeliveryChallanDao;
import nirmalya.aatithya.restmodule.sales.model.DeliveryChalanModel;
import nirmalya.aatithya.restmodule.sales.model.DeliveryChallanInvoiceModel;
import nirmalya.aatithya.restmodule.sales.model.SaleOrderPoDetailsModel;

@RestController
@RequestMapping("sales/")
public class DeliveryChallanRestController {

	@Autowired
	DeliveryChallanDao deliveryChallanDao;

	Logger logger = LoggerFactory.getLogger(DeliveryChallanRestController.class);

	/*
	 * for drop down for sales order
	 */
	@RequestMapping(value = "getSaleOrder", method = { RequestMethod.GET })
	public List<DropDownModel> getSaleOrder() {
		logger.info("Method in rest: getSaleOrder starts");

		logger.info("Method in rest: getSaleOrder starts");

		return deliveryChallanDao.getSaleOrder();
	}

	/*
	 * for drop down for cement brands
	 */
	@RequestMapping(value = "getCementList", method = { RequestMethod.GET })
	public List<DropDownModel> getCementList() {
		logger.info("Method in rest: getCementList starts");

		logger.info("Method in rest: getCementList starts");

		return deliveryChallanDao.getCementList();
	}

	/*
	 * for drop down for po details
	 */
	@RequestMapping(value = "/getPoDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SaleOrderPoDetailsModel>>> getPoDetails(@RequestParam String soId) {
		logger.info("Method in rest: getPoDetails starts");

		logger.info("Method in rest: getPoDetails ends");
		return deliveryChallanDao.getPoDetails(soId);
	}

	/*
	 * for drop down for po details
	 */
	@RequestMapping(value = "/driverDetailsVechileOnchange", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> driverDetailsVechileOnchange(@RequestParam String vechileNo) {
		logger.info("Method in rest: driverDetailsVechileOnchange starts");

		logger.info("Method in rest: driverDetailsVechileOnchange ends");
		return deliveryChallanDao.driverDetailsVechileOnchange(vechileNo);
	}
	
	/*
	 * for drop down for trip details by sale order and rmcgrade
	 */
	@RequestMapping(value = "/getTripDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SaleOrderPoDetailsModel>>> getTripDetails(@RequestParam String rmcGrade ,@RequestParam String saleOrder) {
		logger.info("Method in rest: getTripDetails starts");

		logger.info("Method in rest: getTripDetails ends");
		return deliveryChallanDao.getTripDetails(rmcGrade ,saleOrder);
	}
	
	/*
	 * for drop down for cement stock details by cement brand
	 */
	@RequestMapping(value = "/getCementDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SaleOrderPoDetailsModel>>> getCementDetails(@RequestParam String customer ,@RequestParam String cementBrand) {
		logger.info("Method in rest: getTripDetails starts");

		logger.info("Method in rest: getTripDetails ends");
		return deliveryChallanDao.getCementDetails(customer ,cementBrand);
	}
	

	/*
	 * for drop down for driver list auto search
	 */
	@RequestMapping(value = "/getDriverDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SaleOrderPoDetailsModel>>> getDriverDetails(@RequestParam String id) {
		logger.info("Method in rest: getDriverDetails starts");

		logger.info("Method in rest: getDriverDetails ends");
		return deliveryChallanDao.getDriverDetails(id);
	}
	
	/*
	 * for drop down for pump list
	 */
	@RequestMapping(value = "getpumpList", method = { RequestMethod.GET })
	public List<DropDownModel> getpumpList() {
		logger.info("Method in rest: getpumpList starts");

		logger.info("Method in rest: getpumpList starts");

		return deliveryChallanDao.getpumpList();
	}

	/*
	 * for drop down for plant list
	 */
	@RequestMapping(value = "getPlantList", method = { RequestMethod.GET })
	public List<DropDownModel> getPlantList() {
		logger.info("Method in rest: getPlantList starts");

		logger.info("Method in rest: getPlantList starts");

		return deliveryChallanDao.getPlantList();
	}

	/*
	 * for drop down for vechile list
	 */
	@RequestMapping(value = "getVeichelList", method = { RequestMethod.GET })
	public List<DropDownModel> getVeichelList() {
		logger.info("Method in rest: getVeichelList starts");

		logger.info("Method in rest: getVeichelList starts");

		return deliveryChallanDao.getVeichelList();
	}

	/*
	 * for drop down for rmc grade list
	 */
	@RequestMapping(value = "getpRmcGradeList", method = { RequestMethod.GET })
	public List<DropDownModel> getpRmcGradeList() {
		logger.info("Method in rest: getpRmcGradeList starts");

		logger.info("Method in rest: getpRmcGradeList starts");

		return deliveryChallanDao.getpRmcGradeList();
	}

	/*
	 * for Add DeliveryChallan
	 */
	@RequestMapping(value = "restAddDeliveryChallan", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddDeliveryChallanMaster(
			@RequestBody DeliveryChalanModel deliveryChalanModel) {
		logger.info("Method : restAddDeliveryChallanMaster starts");

		logger.info("Method : restAddDeliveryChallanMaster ends");

		return deliveryChallanDao.restAddDeliveryChallanMaster(deliveryChalanModel);
	}

	/*
	 * for view all DeliveryChallan
	 */
	@RequestMapping(value = "getAllDeliveryChallan", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<DeliveryChalanModel>>> getAllDeliveryChallans(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllDeliveryChallans starts");

		logger.info("Method : getAllDeliveryChallans ends");

		return deliveryChallanDao.getAllDeliveryChallans(request);
	}


	/*
	 * for DeliveryChallan Edit
	 */
	@RequestMapping(value = "getdeliveryChalanById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<DeliveryChalanModel>> getDeliveryChallanMasterById(@RequestParam String id) {
		logger.info("Method : getdeliveryChalanById starts");

		logger.info("Method : getdeliveryChalanById ends");

		return deliveryChallanDao.getDeliveryChallanById(id);
	}

	/*
	 * for DeliveryChallan Delete
	 */
	@RequestMapping(value = "deleteDeliveryChalanModelById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteDeliveryChalanModelById(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deleteDeliveryChalanModelById starts");

		logger.info("Method : deleteDeliveryChalanModelById ends");

		return deliveryChallanDao.deleteDeliveryChalanModelById(id, createdBy);
	}

	/*
	 * for assignSkill Edit
	 */
	@RequestMapping(value = "getdeliveryChalanModalById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<DeliveryChalanModel>> getdeliveryChalanModalById(@RequestParam String id) {
		logger.info("Method : getdeliveryChalanModalById starts");

		logger.info("Method : getdeliveryChalanModalById ends");

		return deliveryChallanDao.getdeliveryChalanModalById(id);
	}

	/*
	 * for assignSkill Edit
	 */
	@RequestMapping(value = "getdeliveryChalanModalByIdPdf", method = { RequestMethod.GET })
	public ResponseEntity<DeliveryChalanModel> getdeliveryChalanModalByIdPdf(@RequestParam String id) {
		logger.info("Method : getdeliveryChalanModalByIdPdf starts");

		logger.info("Method : getdeliveryChalanModalByIdPdf ends");

		return deliveryChallanDao.getdeliveryChalanModalByIdPdf(id);
	}

	/*
	 * for invoice delivery challan
	 */
	@RequestMapping(value = "/getInvoiceData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DeliveryChallanInvoiceModel>>> getInvoiceData(
			@RequestParam("id") String id) {
		logger.info("Method : getInvoiceData for rest controller starts");

		logger.info("Method : getInvoiceData for rest controller ends");
		return deliveryChallanDao.getInvoiceData(id);
	}

	/*
	 * get discount
	 */

	@RequestMapping(value = "addInvoiceDiscount", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> addInvoiceDiscount(@RequestParam String id,
			@RequestParam String discount, @RequestParam Boolean taxType, @RequestParam String taxRate) {
		logger.info("Method : addInvoiceDiscount starts");

		logger.info("Method : addInvoiceDiscount ends");

		return deliveryChallanDao.addInvoiceDiscount(id, discount, taxType, taxRate);
	}

	/*
	 * for invoice delivery challan print preview
	 */
	@RequestMapping(value = "/getInvoiceDataPreview", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DeliveryChallanInvoiceModel>>> getInvoiceDataPreview(
			@RequestParam("id") String id) {
		logger.info("Method : getInvoiceDataPreview for rest controller starts");

		logger.info("Method : getInvoiceDataPreview for rest controller ends");
		return deliveryChallanDao.getInvoiceDataPreview(id);
	}

}
