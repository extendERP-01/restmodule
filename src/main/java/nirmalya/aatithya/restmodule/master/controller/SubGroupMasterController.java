package nirmalya.aatithya.restmodule.master.controller;

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
import nirmalya.aatithya.restmodule.master.dao.SubGroupMasterDao;
import nirmalya.aatithya.restmodule.master.model.SubGroupMasterModel;


@RestController
@RequestMapping("master/")
public class SubGroupMasterController {

	@Autowired
	SubGroupMasterDao subGroupNameMasterDao;
	Logger logger = LoggerFactory.getLogger(SubGroupMasterController.class);

	/*
	 * for All Add group type Master
	 */
	@RequestMapping(value = "restAddSubGroupType", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddSubGroupType(@RequestBody SubGroupMasterModel emailMaster) {
		logger.info("Method : restAddSubGroupType starts");

		logger.info("Method : restAddSubGroupType ends");

		return subGroupNameMasterDao.restAddSubGroupType(emailMaster);
	}
	/**
	 * returns Group list for drop down model
	 *
	 */
	@RequestMapping(value = "/get-group-list-Name", method = { RequestMethod.GET })
	public List<DropDownModel> getGroupTypelistName() {
		logger.info("Method : getGroupTypelistName starts");

		logger.info("Method : getGroupTypelistName end");
		return subGroupNameMasterDao.getGroupTypelistName();
	}
	/*
	 * for All view sub Group  Master
	 */
	@RequestMapping(value = "/getSubGroupType", method = { RequestMethod.POST })

	public ResponseEntity<JsonResponse<List<SubGroupMasterModel>>> getSubGroupType(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getSubGroupType starts");
		logger.info("Method : getSubGroupType ends");
		return subGroupNameMasterDao.getSubGroupType(request);
	}
	/*
	 * for All delete sub group Master
	 */
	@RequestMapping(value = "/deleteSubGroupTypeById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteSubGroupTypeById(@RequestParam String id,
			@RequestParam String createdBy) {

		logger.info("Method : deleteSubGroupTypeById starts");

		logger.info("Method : deleteSubGroupTypeById ends");

		return subGroupNameMasterDao.deleteSubGroupTypeById(id, createdBy);
	}
	/*
	 * for All edit Sub group Master
	 */
	@RequestMapping(value = "/getSupGroupTypeById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<SubGroupMasterModel>>getSupGroupTypeById(@RequestParam String id) {
		logger.info("Method : getSupGroupTypeById starts");

		logger.info("Method : getSupGroupTypeById ends");
		return subGroupNameMasterDao.getSupGroupTypeById(id);
	}
	/*
	 * for All model view Sub group Master
	 */
	@RequestMapping(value = "/viewSubGroupTypeById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<SubGroupMasterModel>> viewSubGroupTypeById(@RequestParam String id) {
		logger.info("Method : viewSubGroupTypeById starts");

		logger.info("Method : viewSubGroupTypeById ends");
		return subGroupNameMasterDao.viewSubGroupTypeById(id);
	}
}


