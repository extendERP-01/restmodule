/**


 */
package nirmalya.aatithya.restmodule.property.controller;

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
import nirmalya.aatithya.restmodule.property.dao.PropertyHotelDao;
import nirmalya.aatithya.restmodule.property.model.PropertyFloorModel;
import nirmalya.aatithya.restmodule.property.model.PropertyHotelModel;

/**
 * @author Nirmalya Labs
 *
 */

@RestController
@RequestMapping("property")
public class PropertyHotelRestController {
	Logger logger = LoggerFactory.getLogger(PropertyHotelRestController.class);
	@Autowired
	PropertyHotelDao hotelDao;

	/**
	 * returns state name for drop down model
	 *
	 */
	@RequestMapping(value = "/getStateName", method = { RequestMethod.GET })
	public List<DropDownModel> getStatename() {
		logger.info("Method : getStatename starts");

		logger.info("Method : getStatename end");
		return hotelDao.getStatename();
	}
	/**
	 * returns state name for drop down model
	 *
	 */
	@RequestMapping(value = "/getdistName", method = { RequestMethod.GET })
	public List<DropDownModel> getdistName(@RequestParam String state) {
		logger.info("Method : getStatename starts");

		logger.info("Method : getStatename end");
		return hotelDao.getdistName(state);
	}
	

	/**
	 * returns district name for drop down model
	 *
	 */
	@RequestMapping(value = "/getDistName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPropertyTypeName(@RequestParam String state) {
		logger.info("Method in rest: getDistname starts");

		logger.info("Method in rest: getDist name ends");
		
		return hotelDao.getDistname(state);
	}


	/**
	 * returns add property hotel
	 *
	 */

	@RequestMapping(value = "/addHotel", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addHotel(@RequestBody PropertyHotelModel form) {
		logger.info("Method : addHotel starts");

		logger.info("Method : addHotel end");

		return hotelDao.addHotel(form);

	}

	/**
	 * returns get all property hotels
	 *
	 */
	@RequestMapping(value = "/getAllHotel", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<PropertyHotelModel>>> getAllHotel(@RequestBody DataTableRequest request) {
		logger.info("Method : getAllHotel starts");

		logger.info("Method : getAllHotel end");

		return hotelDao.getAllHotel(request);
	}

	/**
	 * returns delete property hotel
	 *
	 */
	@RequestMapping(value = "/deleteHotelById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteHotel(@RequestParam String id,@RequestParam String createdBy) {
		logger.info("Method : deleteHotel starts");

		logger.info("Method : deleteHotel end");

		return hotelDao.deleteHotel(id,createdBy);
	}

	/**
	 * returns edit property hotel
	 *
	 */
	@RequestMapping(value = "/getHotelById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<PropertyHotelModel>> getHotelById(@RequestParam String id,
			@RequestParam("Action") String action) {
		logger.info("Method : getHotelById starts");

		logger.info("Method : getHotelById end");

		return hotelDao.getHotelById(id, action);
	}

}
