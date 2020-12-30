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
import nirmalya.aatithya.restmodule.common.utils.GenerateReqQuotParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;  
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryReqDetailsModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository

public class RestReqQuotDetailsDao {
	
	Logger logger = LoggerFactory.getLogger(RestReqQuotDetailsDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	EntityManager em;
	
	/*
	 * DAO Function to ADD/Edit Request Quotation
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addReqQuotation(RestInventoryReqDetailsModel table) {
    
		logger.info("Method : addReqQuotation starts");
		
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		
		/* System.out.println("Data: " + meal); */
		
		if (table.getRfqName() == null || table.getRfqName() == "") {
			resp.setMessage("*Request Quotation  Name Required");
			validity = false;
		} else if (table.getRfqValidDate() == null || table.getRfqValidDate() == "") {
			resp.setMessage("*Validity Date required");
			validity = false;
	 
		}  else if (table.getRfqBackground() == null || table.getRfqBackground() == "") {
			resp.setMessage("*Background is required");
			validity = false;
	 
		}  else if (table.getRfqDetails() == null || table.getRfqDetails() == "") {
			resp.setMessage("*RFQ Details is required");
			validity = false;
	 
		}

		if (validity)
			try {
				
				String values = GenerateReqQuotParameter.getAddReqQuotParam(table);

				if (table.getReqQuotId() != null && table.getReqQuotId() != "") {
					//System.out.println("update required");
					em.createNamedStoredProcedureQuery("requestQuotRoutines")
					.setParameter("actionType", "modifyReqQuot")
					.setParameter("actionValue", values)
					.execute();
					resp.setCode("Data Saved Successfully");
				} else {
					em.createNamedStoredProcedureQuery("requestQuotRoutines")
					.setParameter("actionType", "addReqQuot")
					.setParameter("actionValue", values)
					.execute();
					resp.setCode("Data Saved Successfully");
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
		
		logger.info("Method : addReqQuotation ends");
		
		return response;
	}
	
	
	
	/*
	 * DAO Function to View all Request Quotation
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryReqDetailsModel>>> getReqQuotData(
			DataTableRequest request) {
		logger.info("Method : getReqQuotData details starts");
		List<RestInventoryReqDetailsModel> meal = new ArrayList<RestInventoryReqDetailsModel>();
		//System.out.println("value"+request.getParam1());
		String values = GenerateReqQuotParameter.getSearchParam(request);
		Integer total = 0;
		//System.out.println("param is Doa -----"+request.getParam1());
		try {
			 
			List<Object[]> x = em.createNamedStoredProcedureQuery("requestQuotRoutines")
					.setParameter("actionType", "viewRFQ")
					.setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				Object  validityDate = null; 
				if (m[2] != null) {
					validityDate = DateFormatter.returnStringDate(m[2]);

				}
				
				Object  createdDate = null; 
				if (m[7] != null) {
					createdDate = DateFormatter.returnStringDate(m[7]);

				}
				 
				RestInventoryReqDetailsModel user = new RestInventoryReqDetailsModel(m[0], m[1], validityDate,m[3], m[4],m[5],m[6],null,m[9],createdDate,m[8]);
				meal.add(user);
			}
			if (x.get(0).length > 10) {
				BigInteger t = (BigInteger) x.get(0)[10];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestInventoryReqDetailsModel>> resp = new JsonResponse<List<RestInventoryReqDetailsModel>>();
		resp.setBody(meal);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestInventoryReqDetailsModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryReqDetailsModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getReqQuotData ends");
		//System.out.println("Response in Request Quotation dao View==============="+response);
		return response;
	}
	
	
	
	
	/*
	 * DAO Function to View all Request Quotation for Approve RFQ
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryReqDetailsModel>>> getRFQApproveData(
			DataTableRequest request) {
		logger.info("Method : getRFQApproveData details starts");
		List<RestInventoryReqDetailsModel> meal = new ArrayList<RestInventoryReqDetailsModel>();
		//System.out.println("value"+request.getParam1());
		String values = GenerateReqQuotParameter.getSearchParam(request);
		Integer total = 0;
		//System.out.println("param is Doa -----"+request.getParam1());
		try {
			 
			List<Object[]> x = em.createNamedStoredProcedureQuery("requestQuotRoutines")
					.setParameter("actionType", "viewRFQApprove")
					.setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				Object  validityDate = null; 
				if (m[2] != null) {
					validityDate = DateFormatter.returnStringDate(m[2]);
				}
				
				Object  createdDate = null; 
				if (m[7] != null) {
					createdDate = DateFormatter.returnStringDate(m[7]);

				}
				 
				RestInventoryReqDetailsModel user = new RestInventoryReqDetailsModel(m[0], m[1], validityDate,m[3], m[4],m[5],m[6],null,null,createdDate,m[8]);
				meal.add(user);
			}
			if (x.get(0).length > 9) {
				BigInteger t = (BigInteger) x.get(0)[9];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestInventoryReqDetailsModel>> resp = new JsonResponse<List<RestInventoryReqDetailsModel>>();
		resp.setBody(meal);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestInventoryReqDetailsModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryReqDetailsModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getRFQApproveData ends");
		//System.out.println("Response in Request Quotation dao View==============="+response);
		return response;
	}
	


/**
	 * CHANGE Approve Status for RFQ
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> approveRFQStatus(String checkedRFQId) {
		logger.info("Method : RESTMODULE   approveRFQStatus starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			Object ReturnvalId="";
			String checklist = checkedRFQId;
			String[] checkedRFQList = checklist.split(",");
			
			String ckeckedRFQ = "";
			for (int i=0; i<checkedRFQList.length; i++) 
			{ 
				
				ckeckedRFQ =ckeckedRFQ+"\""+ checkedRFQList[i]+"\",";
				
			}
			//System.out.println("ckeckedRFQ-----------------------------------------"+ckeckedRFQ);
			
			ckeckedRFQ = ckeckedRFQ.substring(0, ckeckedRFQ.length() - 1);
			String list="";
			
			list = ckeckedRFQ;
			
			//System.out.println("GENERATED LIST FOR POSTATUS IN ADD PURCHASE ORDER======"+list);
			String s = "";
			s = s + "@p_checkedRFQ='" + list + "',";
			s = s.substring(0, s.length()-2);
			String value ="SET " + s + "';" ;
			//String value = "SET @p_QuotId='" + id + "',@p_rfqId='" + rfqId + "',@p_approveStatus=" + approveStatus + ";";
		//	System.out.println("value------------------------ ---------------"+value);
			ReturnvalId =em.createNamedStoredProcedureQuery("requestQuotRoutines")
					.setParameter("actionType", "approveRFQIds")
					.setParameter("actionValue", value)
					.getSingleResult(); 
			 String total = (String) ReturnvalId;
			 	String FailString="Fail"; 
			 	if(total.equalsIgnoreCase(FailString)) {
			 		try {
			 			//mandatory condition for always getting catch block 
			 			 int[] myNumbers = {1, 2, 3};
			 		     System.out.println(myNumbers[10]);
				 	}catch (Exception e) {
				 		String[] err = serverDao.errorProcedureCall(e);
						resp.setCode(err[0]);
						resp.setMessage(err[1]); 
				 	}
			 	} 
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
		logger.info("Method : RESTMODULE  approveRFQStatus ends");
		return response;
	}
	
	
	/*
	 * DAO Function to View all Request Quotation Staff
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryReqDetailsModel>>> getReqQuotDataStaff(
			DataTableRequest request) {
		logger.info("Method : getReqQuotDataStaff details starts");
		List<RestInventoryReqDetailsModel> meal = new ArrayList<RestInventoryReqDetailsModel>();
		//System.out.println("value"+request.getParam1());
		String values = GenerateReqQuotParameter.getSearchParam(request);
		Integer total = 0;
		//System.out.println("param is Doa -----"+request.getParam1());
		try {
			 
			List<Object[]> x = em.createNamedStoredProcedureQuery("requestQuotRoutines")
					.setParameter("actionType", "viewRFQStaff")
					.setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				Object  validityDate = null; 
				if (m[2] != null) {
					validityDate = DateFormatter.returnStringDate(m[2]);

				}
				
				Object  createdDate = null; 
				if (m[7] != null) {
					createdDate = DateFormatter.returnStringDate(m[7]);

				}
				 
				RestInventoryReqDetailsModel user = new RestInventoryReqDetailsModel(m[0], m[1], validityDate,m[3], m[4],m[5],m[6],null,null,createdDate,null);
				meal.add(user);
			}
			if (x.get(0).length > 8) {
				BigInteger t = (BigInteger) x.get(0)[8];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestInventoryReqDetailsModel>> resp = new JsonResponse<List<RestInventoryReqDetailsModel>>();
		resp.setBody(meal);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestInventoryReqDetailsModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryReqDetailsModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getReqQuotDataStaff ends");
		//System.out.println("Response in Request Quotation dao View==============="+response);
		return response;
	}
	
	

	/*
	 * DAO Function to get RFQ Data by Id
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestInventoryReqDetailsModel>> getRFQdById(String id,String action) {
		
		logger.info("Method : getRFQdById starts");
		
		List<RestInventoryReqDetailsModel> mt = new ArrayList<RestInventoryReqDetailsModel>();
		JsonResponse<RestInventoryReqDetailsModel> resp = new JsonResponse<RestInventoryReqDetailsModel>();

		try {

			String value = "SET @p_RFQId='" + id + "';";

		  //  System.out.println("value for pop up in dao set id is for rfQ------------ : " + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("requestQuotRoutines")
					.setParameter("actionType", action)
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object validDate = null; 
				if (m[2] != null) {
					validDate = DateFormatter.returnStringDate(m[2]);

				}
				 
				
				RestInventoryReqDetailsModel table = new RestInventoryReqDetailsModel(m[0], m[1], validDate,m[3], m[4],m[5],m[6],null,null,null,m[7]);
				 
				mt.add(table);
			}
			 //System.out.println("data printed"+mt); 
			resp.setBody(mt.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<RestInventoryReqDetailsModel>> response = new ResponseEntity<JsonResponse<RestInventoryReqDetailsModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : getRFQdById ends");

		System.out.println("response during get model------"+response);
		return response;
		 
	}
	
	
	/*
	 * DAO Function to get getVendorsList
	 *
	 */
 	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorsList(String getVendorsList) {
		
		logger.info("Method : DAO getStatusType starts");
		
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		
		try {
			String value = "SET @p_vendor=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("requestQuotRoutines")
					.setParameter("actionType", getVendorsList)
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
		
		logger.info("Method : DAO getVendorsList ends");	
		return response;
	}
 	
 	
 	
	/*
	 * DAO Function to get CATEGORY LIST
	 *
	 */
 	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCatList(String getCatList) {
		
		logger.info("Method : DAO getCatList starts");
		
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		
		try {
			String value = "SET @p_cat=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("requestQuotRoutines")
					.setParameter("actionType", getCatList)
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
		
		logger.info("Method : DAO getCatList ends");	
		return response;
	}
 	 


/**
	 * LIST VENDOR
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVenListbyCat(String id) {
		logger.info("Method : getVenListbyCat Dao starts");

		List<DropDownModel> guestList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_catid=" + id + ";"; 
			System.out.println("value at procedure call for vendor list--------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("requestQuotRoutines")
					.setParameter("actionType", "getVenListbyCat").setParameter("actionValue", value)
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

		logger.info("Method : getVenListbyCat Dao ends");
		System.out.println("response vendor time--------------"+response);
		return response;
	}
	
	/*
	 * DAO Function to get get RFQList
	 *
	 */
 	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRFQNameList(String getRFQNameList) {
		
		logger.info("Method : DAO getRFQNameList starts");
		
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		
		try {
			String value = "SET @p_vendor=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("requestQuotRoutines")
					.setParameter("actionType", getRFQNameList)
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
		
		logger.info("Method : DAO getRFQNameList ends");	
		return response;
	}
 	

 	/**
	 * ADD Vendors
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> restAddVendors(RestInventoryReqDetailsModel form) {
		logger.info("Method : RESTMODULE UserDao restAddVendors starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");


		if (validity)
			try {
				String values = GenerateReqQuotParameter.getAddVendors(form);

					em.createNamedStoredProcedureQuery("requestQuotRoutines").setParameter("actionType", "saveAddVendors")
							.setParameter("actionValue", values).execute();
				 

			} catch (Exception e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
				try {
					//String[] err = ServerValidation.geterror(e);
					String[] err = serverDao.errorProcedureCall(e);

					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : RESTMODULE UserDao addUserDataList end");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorListForAsign(String id) {
		logger.info("Method : DAO getVendorListForAsign starts");
		
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		
		try {
			String value = "SET @P_ItemCategory='" + id + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("requestQuotRoutines")
					.setParameter("actionType", "getVendorAssignList")
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModelConstructor = new DropDownModel(m[0], m[1]);
				dropDownModel.add(dropDownModelConstructor);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setBody(dropDownModel);

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : DAO getVendorListForAsign ends");	
		return response;
	}



}
