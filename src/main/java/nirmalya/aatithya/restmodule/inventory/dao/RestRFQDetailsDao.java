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
import nirmalya.aatithya.restmodule.common.utils.DataSetForPropType1;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateCompareParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateInventVendRFQDtls; 
import nirmalya.aatithya.restmodule.common.utils.GenerateReqQuotParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryRFQVendorDetailModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository

public class RestRFQDetailsDao {
	
	Logger logger = LoggerFactory.getLogger(RestReqQuotDetailsDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	EntityManager em;
	
	
	/**
	 * AUTO COMPLETE RFQ NO
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRFQAutoSearch(String id) {
		logger.info("Method : getRFQAutoSearch Dao starts");

		List<DropDownModel> guestList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_rfq='" + id + "';"; 
			List<Object[]> x = em.createNamedStoredProcedureQuery("invRFQDtlsRoutines")
					.setParameter("actionType", "getRFQAutoSearch").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				guestList.add(dropDownModel);
			}

			resp.setBody(guestList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getRFQAutoSearch Dao ends");
		return response;
	}

	
	
	
	/*
	 * DAO Function to get RFQ NAME
	 *
	 */
 	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRFQNameListd(String getRFQNameListd) {
		
		logger.info("Method : DAO getStatusType starts");
		
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		
		try {
			String value = "SET @p_vendor=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("invRFQDtlsRoutines")
					.setParameter("actionType", getRFQNameListd)
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModelConstructor = new DropDownModel(m[0], m[1]);
				dropDownModel.add(dropDownModelConstructor);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setBody(dropDownModel);

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : DAO getRFQNameListd ends");	
		return response;
	}
	
	
	/**
	 * AUTO COMPLETE ITEM NAME
	 *
	 */

/*	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRFQItemList(String id) {
		logger.info("Method : getRFQItemList Dao starts");

		List<DropDownModel> guestList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_rfqitm='" + id + "';"; 
			List<Object[]> x = em.createNamedStoredProcedureQuery("invRFQDtlsRoutines")
					.setParameter("actionType", "getRFQItemList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				guestList.add(dropDownModel);
			}

			resp.setBody(guestList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getRFQItemList Dao ends");
		return response;
	}*/
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DataSetForPropType1>>> getRFQItemList(List<DataSetForPropType1> table) {
		logger.info("Method :  RESTMODULE DAO  getRFQItemList starts");

		List<DataSetForPropType1> List1 = new ArrayList<DataSetForPropType1>();
		JsonResponse<List<DataSetForPropType1>> resp = new JsonResponse<List<DataSetForPropType1>>();

		try {
			String values = GenerateCompareParameter.getsendParam(table);
			List<Object[]> x = em.createNamedStoredProcedureQuery("invRFQDtlsRoutines")
					.setParameter("actionType", "getRFQItemList")
					.setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				DataSetForPropType1 DataSetForPropType1 = new DataSetForPropType1(m[0], m[1]);
				List1.add(DataSetForPropType1);
			}

			resp.setBody(List1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DataSetForPropType1>>> response = new ResponseEntity<JsonResponse<List<DataSetForPropType1>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : RESTMODULE getRFQItemList ends");
		return response;
	}
	
	/**
	 * AUTO COMPLETE VENDOR
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRFQVenListbyRfq(String id) {
		logger.info("Method : getRFQVenListbyRfq Dao starts");

		List<DropDownModel> guestList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_rfqid=" + id + ";"; 
		//	System.out.println("value at procedure call--------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("invRFQDtlsRoutines")
					.setParameter("actionType", "getRFQVenList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				guestList.add(dropDownModel);
			}

			resp.setBody(guestList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getRFQVenListbyRfq Dao ends");
	//	System.out.println("response vendor time--------------"+response);
		return response;
	}
	
	
	/**
	 * DAO Function to Add Vendor Detls RFQ
	 *
	 */
	@SuppressWarnings("unused")
	public ResponseEntity<JsonResponse<Object>> addVenRFQDtls(
			List<RestInventoryRFQVendorDetailModel> RestInventoryRFQVendorDetailModel) {
		logger.info("Method : addVenRFQDtls starts");
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		/*for (RestInventoryPurchaseOrderModel l : restInventoryPurchaseOrderModel) {
			if (l.getVendor() == null || l.getVendor() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Vendor Name.");
				break;
			} else if (l.getpODescription() == null || l.getpODescription() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Description.");
				break;
			}  else if (l.getpOStatus() == null){ validation = false;
				  resp.setCode("Field Validation Error");
				  resp.setMessage("Please Select Status.");
				  break;
		    } else if (l.getItemCategory() == null || l.getItemCategory() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Item Category.");
				break;
			} else if (l.getItemSubCategory() == null || l.getItemSubCategory() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Sub Category.");
				break;
			} else if (l.getItemName() == null || l.getItemName() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please select item name.");
				break;
			} else if (l.getpOQty() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("please Enter Quantity.");
				break;
			}
		}*/

		if (validation) {

			try {
				String value = GenerateInventVendRFQDtls.getRFQVendorDtlParam(RestInventoryRFQVendorDetailModel);
				//String value="";
			//	System.out.println("value---------------------------------"+value);
				if (RestInventoryRFQVendorDetailModel.get(0).getVenQuotId() != null) {
					//System.out.println("I m in EDit section----------------------------");
					em.createNamedStoredProcedureQuery("invRFQDtlsRoutines")
							.setParameter("actionType", "modifyVendorRFQ").setParameter("actionValue", value)
							.execute();
				} else {
					//System.out.println("I m in add section----------------------------");
					em.createNamedStoredProcedureQuery("invRFQDtlsRoutines")
							.setParameter("actionType", "addVenDtlsRFQ").setParameter("actionValue", value)
							.execute();
				}
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
		logger.info("Method : addVenRFQDtls Order ends");
		return response;
	}
	
	 


	/*
	 * DAO Function to View all Request Quotation
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryRFQVendorDetailModel>>> getRFQVenData(
			DataTableRequest request) {
		logger.info("Method : getReqQuotData details starts");
		List<RestInventoryRFQVendorDetailModel> meal = new ArrayList<RestInventoryRFQVendorDetailModel>();
		//System.out.println("value"+request.getParam1());
		String values = GenerateReqQuotParameter.getSearchParam(request);
		Integer total = 0;
		//System.out.println("param is Doa -----"+request.getParam1());
		try {
			 
			List<Object[]> x = em.createNamedStoredProcedureQuery("invRFQDtlsRoutines")
					.setParameter("actionType", "getRFQVenData")
					.setParameter("actionValue", values).getResultList();
			for (Object[] m : x) { 
				 
				RestInventoryRFQVendorDetailModel user = new RestInventoryRFQVendorDetailModel(m[0], m[1], m[2],null, null,null,null,null,null,null,null,null,null,null,null,null,null,null,m[4],null,null,m[3]);
				meal.add(user);
			}
			if (x.get(0).length > 4) {
				BigInteger t = (BigInteger) x.get(0)[4];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestInventoryRFQVendorDetailModel>> resp = new JsonResponse<List<RestInventoryRFQVendorDetailModel>>();
		resp.setBody(meal);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestInventoryRFQVendorDetailModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryRFQVendorDetailModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getRFQVenData ends");
	//	System.out.println("Response in Request Quotation VENDOR RFQ dao View==============="+response);
		return response;
	}
	  

	/**
	 * DAO - Get Vendor DropDown List
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> restGetVendor() {
		logger.info("Method : restGetVendor starts");
		
		List<DropDownModel> vendorL = new ArrayList<DropDownModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("invRFQDtlsRoutines")
					.setParameter("actionType", "getEditVendList")
					.setParameter("actionValue", "")
					.getResultList();
			
			for(Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0],m[1]);
				vendorL.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : restGetVendor ends");
			
		return vendorL;
	}
	
	/*
	 * DAO Function to get RFQ Data by Id
	 *
	 */
/*	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestInventoryRFQVendorDetailModel>> getRFQVDById(String id,String action) {
		
		logger.info("Method : getRFQdById starts");
		
		List<RestInventoryRFQVendorDetailModel> mt = new ArrayList<RestInventoryRFQVendorDetailModel>();
		JsonResponse<RestInventoryRFQVendorDetailModel> resp = new JsonResponse<RestInventoryRFQVendorDetailModel>();

		try {

			String value = "SET @p_RFQId='" + id + "';";

		    System.out.println("value for pop up in dao set id is for rfQ------------ : " + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("invRFQDtlsRoutines")
					.setParameter("actionType", action)
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) { 
				RestInventoryRFQVendorDetailModel table = new RestInventoryRFQVendorDetailModel(m[0], m[1], m[2],m[3], m[4],m[5],m[6],m[7],m[8],m[9],m[10],m[11],m[12],null,m[13],m[14],m[15]);
				 
				mt.add(table);
			}
			 //System.out.println("data printed"+mt); 
			resp.setBody(mt.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<RestInventoryRFQVendorDetailModel>> response = new ResponseEntity<JsonResponse<RestInventoryRFQVendorDetailModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : getRFQdById ends");

		System.out.println("response get during edit rfw vendor------"+response);
		return response;
		 
	}*/
	
	
	@SuppressWarnings("unchecked")
	public List<RestInventoryRFQVendorDetailModel> getRFQVDById(String id) {
		logger.info("Method : getRFQVDById starts");
		
		List<RestInventoryRFQVendorDetailModel> quotation = new ArrayList<RestInventoryRFQVendorDetailModel>();
		String value = "SET @p_RFQId='" + id + "';"; 
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("invRFQDtlsRoutines")
					.setParameter("actionType", "viewEditRFQVDtls")
					.setParameter("actionValue", value)
					.getResultList();
			
			for(Object[] m : x) {
			 
				Object  quotValidity = null; 
				if (m[18] != null) {
					quotValidity = DateFormatter.returnStringDate(m[18]);
				}
				 
				RestInventoryRFQVendorDetailModel dropDownModel = new RestInventoryRFQVendorDetailModel(m[0], m[1], m[2],m[3], m[4],m[5],m[6],m[7],m[8],m[9],m[10],m[11],m[12],m[13],m[14],m[15],m[16],null,null,m[17],quotValidity,null);
				quotation.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getRFQVDById ends");
	//	System.out.println("response get during edit rfw vendor------"+quotation);
		return quotation;
	}

	
	/**
	 * DAO Function to view Membership in model
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryRFQVendorDetailModel>>> getVendRFQModel(
			String id) {

		logger.info("Method : getVendRFQModel starts");
	 	List<RestInventoryRFQVendorDetailModel> mt = new ArrayList<RestInventoryRFQVendorDetailModel>();
		JsonResponse<List<RestInventoryRFQVendorDetailModel>> resp = new JsonResponse<List<RestInventoryRFQVendorDetailModel>>();

		try {

			String value = "SET @p_RFQId='" + id + "';";
			 List<Object[]> x = em.createNamedStoredProcedureQuery("invRFQDtlsRoutines")
					.setParameter("actionType", "ModelView").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestInventoryRFQVendorDetailModel memReg = new RestInventoryRFQVendorDetailModel(m[0], m[1], m[2],m[3], m[4],m[5],m[6],m[7],m[8],m[9],m[10],m[11],m[12],m[13],m[14],m[15],m[16],null,null,null,null,null);

				mt.add(memReg);
			}
			resp.setBody(mt);
		} catch (Exception e) {
			e.printStackTrace();
		} 

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestInventoryRFQVendorDetailModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryRFQVendorDetailModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getVendRFQModel ends");
	 	return response; 
	}
}
