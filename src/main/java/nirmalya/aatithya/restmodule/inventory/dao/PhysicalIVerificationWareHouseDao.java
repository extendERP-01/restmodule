package nirmalya.aatithya.restmodule.inventory.dao;

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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateExitInitiateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GeneratePhysicalVerficationParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.ExitInitiateModel;
import nirmalya.aatithya.restmodule.inventory.model.PhysicalVarificationWareHouseModel;
import nirmalya.aatithya.restmodule.inventory.model.PhysicalVerificationBarCodeModel;


@Repository
public class PhysicalIVerificationWareHouseDao {
	Logger logger = LoggerFactory.getLogger(PhysicalIVerificationWareHouseDao.class);
	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSubInventory(String id) {

		logger.info("Method : getSubInventory starts");
		List<DropDownModel> subInventoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_storeId='" + id + "';";
		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("physicalVerification")
					.setParameter("actionType", "getSubInventoryList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				subInventoryList.add(dropDownModel);
			}

			resp.setBody(subInventoryList);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSubInventory ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getWareHouse(String id) {

		logger.info("Method : getWareHouse starts");
		List<DropDownModel> wareHouseList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_subInventoryId='" + id + "';";
		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("physicalVerification")
					.setParameter("actionType", "getWareHouseList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				wareHouseList.add(dropDownModel);
			}

			resp.setBody(wareHouseList);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getWareHouse ends");
		return response;
	}
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRackFromWareHouse(String id) {

		logger.info("Method : getRackFromWareHouse starts");
		List<DropDownModel> rackList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_wareHouseId='" + id + "';";
		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("physicalVerification")
					.setParameter("actionType", "getRackList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				rackList.add(dropDownModel);
			}

			resp.setBody(rackList);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getRackFromWareHouse ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getstoreList() {
		logger.info("Method : getstoreList starts");
		List<DropDownModel> storeList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("physicalVerification")
					.setParameter("actionType", "storeName").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				storeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getstoreList ends");
		return storeList;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PhysicalVarificationWareHouseModel>>> getItemFromRack(String id) {

		logger.info("Method : getItemFromRack starts");
		List<PhysicalVarificationWareHouseModel> itemList = new ArrayList<PhysicalVarificationWareHouseModel>();
		JsonResponse<List<PhysicalVarificationWareHouseModel>> resp = new JsonResponse<List<PhysicalVarificationWareHouseModel>>();
		
		String value = "SET @p_rackId='" + id + "';";
		System.out.println(value);
		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("physicalVerification")
					.setParameter("actionType", "getRackItemList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				PhysicalVarificationWareHouseModel physicalVarificationWareHouseModel = new PhysicalVarificationWareHouseModel(null, null,null, null, null, m[0], m[1], m[2], null,null,null,null,null);
				itemList.add(physicalVarificationWareHouseModel);
			}
			for(PhysicalVarificationWareHouseModel barDeatil : itemList) {
				List<PhysicalVerificationBarCodeModel> barcodeDeatilModel = new ArrayList<PhysicalVerificationBarCodeModel>();
				String item = "SET @p_item='"+barDeatil.getItem()+"';";
			
				List<Object[]> y = em.createNamedStoredProcedureQuery("physicalVerification")
						.setParameter("actionType", "getPhysicalBarCode").setParameter("actionValue", item).getResultList();
				for (Object[] m : y) {				
					
					PhysicalVerificationBarCodeModel physicalVerificationBarCodeModel = new PhysicalVerificationBarCodeModel(m[0],m[1]);
					barcodeDeatilModel.add(physicalVerificationBarCodeModel);
				
					
				}
				barDeatil.setPhysicalVerificationBarCodeModel(barcodeDeatilModel);
			}
			resp.setBody(itemList);

			System.out.println(itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<PhysicalVarificationWareHouseModel>>> response = new ResponseEntity<JsonResponse<List<PhysicalVarificationWareHouseModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemFromRack ends");
		return response;
	}
	@SuppressWarnings("unused")
	public ResponseEntity<JsonResponse<Object>> restAddPhysicalVerification(List<PhysicalVarificationWareHouseModel> physicalVarificationWareHouseModel){
		logger.info("Method : restAddPhysicalVerification starts");
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (PhysicalVarificationWareHouseModel l : physicalVarificationWareHouseModel) {
			if (l.getStoreId() == null || l.getStoreId() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select store");
				break;

		
			} else if (l.getSubInventoryId()== null || l.getSubInventoryId() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter SubInventory.");
				break;
			} else if (l.getWareHouse() == null || l.getWareHouse() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Emp warehouse.");
				break;

			} else if (l.getRack() == null || l.getRack() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Rack.");
				break;
		
	}
		}
			if (validation) {
				try {
					String value = GeneratePhysicalVerficationParameter
							.getPhyscialVerification(physicalVarificationWareHouseModel);
						
						em.createNamedStoredProcedureQuery("physicalVerification")
								.setParameter("actionType", "addPhysVer").setParameter("actionValue", value)
								.execute();


					 resp.setCode("Data Saved Successfully");
				} catch (Exception e) {
					try {
						String[] err = serverDao.errorProcedureCall(e);
						resp.setCode(err[0]);
						resp.setMessage(err[1]);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					e.printStackTrace();
				}
			}
		
			ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
					HttpStatus.CREATED);
			logger.info("Method : restAddPhysicalVerification ends");
			System.out.println(response);
			return response;
	}
	
	public ResponseEntity<JsonResponse<List<PhysicalVarificationWareHouseModel>>> getAllPhysicalVerification(DataTableRequest request) {
		logger.info("Method : getAllPhysicalVerification starts");
		List<PhysicalVarificationWareHouseModel> form = new ArrayList<PhysicalVarificationWareHouseModel>();
		if (request.getParam5() != "" && request.getParam5() != null) {
			String param5 = request.getParam5();
			String data = DateFormatter.getStringDate(param5);
			request.setParam5(data);
		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("physicalVerification")
					.setParameter("actionType", "getAllPhysVer").setParameter("actionValue", values)
					.getResultList();
			
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object date = null;
					if (m[4] != null) {
						date = DateFormatter.returnStringDateYear(m[4]);
					}
					PhysicalVarificationWareHouseModel physicalVarificationWareHouseModel = new PhysicalVarificationWareHouseModel(m[0],m[1],m[2],m[3],date,m[5],m[6],m[7],null,null,null,m[8],m[9]);

					form.add(physicalVarificationWareHouseModel);
				}
				System.out.println(form);
				if (x.get(0).length > 10) {
					BigInteger t = (BigInteger) x.get(0)[10];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonResponse<List<PhysicalVarificationWareHouseModel>> resp = new JsonResponse<List<PhysicalVarificationWareHouseModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<PhysicalVarificationWareHouseModel>>> response = new ResponseEntity<JsonResponse<List<PhysicalVarificationWareHouseModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getAllPhysicalVerification end");
		return response;
	}
}
