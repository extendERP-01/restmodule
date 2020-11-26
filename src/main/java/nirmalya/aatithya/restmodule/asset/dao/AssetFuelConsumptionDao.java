package nirmalya.aatithya.restmodule.asset.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.asset.model.AssetFuelConsumptionModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAssetFuelConsumptionParam;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse; 

@Repository
public class AssetFuelConsumptionDao {
	Logger logger = LoggerFactory.getLogger(AssetFuelConsumptionDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * drop down for fuel list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getFuel() {
		logger.info("Method in Dao: getFuel  starts");
		List<DropDownModel> fuelList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
					.setParameter("actionType", "getFuel").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				fuelList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getFuel ends");

		return fuelList;
	}

	/*
	 * drop down for vehicle List
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getVeichelList() {
		logger.info("Method in Dao: getVeichelList  starts");
		List<DropDownModel> vechileList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
					.setParameter("actionType", "getVeichelList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				vechileList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getVeichelList ends");

		return vechileList;
	}

	/*
	 * Drop down for job type list
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> driverDetailsVechileOnchange(String vechileNo) {

		logger.info("Method : driverDetailsVechileOnchange starts");

		List<DropDownModel> saleOrderList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_vechileNo='" + vechileNo + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
					.setParameter("actionType", "getVechileChange").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel salesOrder = new DropDownModel(m[0], m[1]);
				saleOrderList.add(salesOrder);
			}
			resp.setBody(saleOrderList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : driverDetailsVechileOnchange ends");
		return response;
	}

	/*
	 * Drop down for po details
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDriverDetailsAutoSearch(String soId) {

		logger.info("Method : getDriverDetailsAutoSearch starts");

		List<DropDownModel> saleOrderList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_searchValue='" + soId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
					.setParameter("actionType", "getDriverDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				saleOrderList.add(dropDownModel);
			}

			resp.setBody(saleOrderList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getDriverDetailsAutoSearch ends");
		return response;
	}

	/*
	 * for add new DeliveryChallan
	 */
	public ResponseEntity<JsonResponse<Object>> restAddFuelConsumption(
			AssetFuelConsumptionModel assetFuelConsumptionModel) {

		logger.info("Method in Dao: restAddFuelConsumption starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (assetFuelConsumptionModel.getBranch() == null || assetFuelConsumptionModel.getBranch() == "") {
			resp.setMessage("Branch Name required");
			validity = false;
		} else if (assetFuelConsumptionModel.getVechileNo() == null || assetFuelConsumptionModel.getVechileNo() == "") {
			resp.setMessage("Vechile  Number required");
			validity = false;
		} else if (assetFuelConsumptionModel.getDriverId() == null || assetFuelConsumptionModel.getDriverId() == "") {
			resp.setMessage("Driver Name required");
			validity = false;
		} else if (assetFuelConsumptionModel.getFuel() == null || assetFuelConsumptionModel.getFuel() == "") {
			resp.setMessage("Fuel Name required");
			validity = false;
		} else if (assetFuelConsumptionModel.getCouponDate() == null
				|| assetFuelConsumptionModel.getCouponDate() == "") {
			resp.setMessage("Coupon Date required");
			validity = false;
		} else if (assetFuelConsumptionModel.getFuelSlipNumber() == null
				|| assetFuelConsumptionModel.getFuelSlipNumber() == "") {
			resp.setMessage("Fuel Slip Number Required.");
			validity = false;
		} else if (assetFuelConsumptionModel.getVehicleWt() == null) {
			resp.setMessage("Vechile Weight  required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateAssetFuelConsumptionParam.getAddFuelConsumption(assetFuelConsumptionModel);

				if (assetFuelConsumptionModel.getConsumptionId() != ""
						&& assetFuelConsumptionModel.getConsumptionId() != null) {
					em.createNamedStoredProcedureQuery("fuelConsumption")
							.setParameter("actionType", "modifyFuelConsumption").setParameter("actionValue", values)
							.execute();

				} else {
					em.createNamedStoredProcedureQuery("fuelConsumption")
							.setParameter("actionType", "addFuelConsumption").setParameter("actionValue", values)
							.execute();

				}
			} catch (Exception e) {
				e.printStackTrace();
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: restAddFuelConsumption ends");

		return response;
	}

	/*
	 * for all getAllFuelConsumption
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>> getAllFuelConsumption(
			DataTableRequest request) {

		logger.info("Method in Dao: getAllFuelConsumption starts");

		List<AssetFuelConsumptionModel> AssetFuelConsumptionModelList = new ArrayList<AssetFuelConsumptionModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
					.setParameter("actionType", "getAllFuelConsumption").setParameter("actionValue", values)
					.getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object entrydate = DateFormatter.returnStringDate(m[5]);
                     Object time = DateFormatter.returnStringTime(m[11]);
					AssetFuelConsumptionModel assetFuelConsumptionModel = new AssetFuelConsumptionModel(m[0], m[1],
							m[2], m[3], m[4], entrydate, m[6], m[7], m[8], m[9], m[10], time, m[12], m[13], m[14],
							m[15], m[16]);
					AssetFuelConsumptionModelList.add(assetFuelConsumptionModel);

				}

				if (x.get(0).length > 17) {
					BigInteger t = (BigInteger) x.get(0)[17];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<AssetFuelConsumptionModel>> resp = new JsonResponse<List<AssetFuelConsumptionModel>>();
		resp.setBody(AssetFuelConsumptionModelList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>> response = new ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getAllFuelConsumption ends");

		return response;
	}

	/*
	 * for get fuel consumption by id
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<AssetFuelConsumptionModel>> getFuelConsumptionId(String id) {

		logger.info("Method in Dao: getFuelConsumptionId ends");

		List<AssetFuelConsumptionModel> assetFuelConsumptionModelList = new ArrayList<AssetFuelConsumptionModel>();

		try {

			String value = "SET @p_consumptionId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
					.setParameter("actionType", "editFuelConsume").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object entrydate = DateFormatter.returnStringDate(m[5]);
				Object time = DateFormatter.returnStringTime(m[11]);
				AssetFuelConsumptionModel assetFuelConsumptionModel = new AssetFuelConsumptionModel(m[0], m[1], m[2],
						m[3], m[4], entrydate, m[6], m[7], m[8], m[9], m[10], time, m[12], m[13], m[14], m[15], m[16]);

				assetFuelConsumptionModelList.add(assetFuelConsumptionModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<AssetFuelConsumptionModel> resp = new JsonResponse<AssetFuelConsumptionModel>();
		resp.setBody(assetFuelConsumptionModelList.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<AssetFuelConsumptionModel>> response = new ResponseEntity<JsonResponse<AssetFuelConsumptionModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getFuelConsumptionId ends");

		return response;
	}

	/*
	 * for modal view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<AssetFuelConsumptionModel>> getfuelConsumptionModalById(String id) {

		logger.info("Method : getfuelConsumptionModalById starts");

		List<AssetFuelConsumptionModel> AssetFuelConsumptionModelList = new ArrayList<AssetFuelConsumptionModel>();
		JsonResponse<AssetFuelConsumptionModel> resp = new JsonResponse<AssetFuelConsumptionModel>();

		try {

			String value = "SET @p_consumptionId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("fuelConsumption")
					.setParameter("actionType", "modalFuelConsumption").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				Object entrydate = DateFormatter.returnStringDate(m[5]);
				Object time = DateFormatter.returnStringTime(m[11]);
				AssetFuelConsumptionModel assetFuelConsumptionModel = new AssetFuelConsumptionModel(m[0], m[1], m[2],
						m[3], m[4], entrydate, m[6], m[7], m[8], m[9], m[10], time, m[12], m[13], m[14], m[15], m[16]);

				AssetFuelConsumptionModelList.add(assetFuelConsumptionModel);

			}

			resp.setBody(AssetFuelConsumptionModelList.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<AssetFuelConsumptionModel>> response = new ResponseEntity<JsonResponse<AssetFuelConsumptionModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getfuelConsumptionModalById ends");

		return response;
	}

	/*
	 * for delete DeliveryChallan
	 */
	public ResponseEntity<JsonResponse<Object>> deleteAssetFuelConsumptionModelById(String id, String createdBy) {

		logger.info("Method in Dao: deleteAssetFuelConsumptionModelById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_consumptionId='" + id + "',@P_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("fuelConsumption").setParameter("actionType", "deleteFuelConsumption")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
			String[] err = serverDao.errorProcedureCall(e);
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method in Dao: deleteAssetFuelConsumptionModelById ends");

		return response;
	}

}
