package nirmalya.aatithya.restmodule.user.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateUserMemRegistrationParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.ServerValidation;
import nirmalya.aatithya.restmodule.user.model.UserMemberDataRegistrationModel;
import nirmalya.aatithya.restmodule.user.model.UserMemberDepCountModel;
import nirmalya.aatithya.restmodule.user.model.UserMembershipRegistrationModel; 

@Repository
public class UserMemRegistrationDao {

	Logger logger = LoggerFactory.getLogger(UserMemRegistrationDao.class);
	@Autowired
	ServerDao serverDao;
	
	@Autowired
	EntityManager em;

	/*
	 * 
	 * 
	 * Add Member Registration
	 * 
	 * 
	 */
	public ResponseEntity<JsonResponse<Object>> AddMemberReg(List<UserMembershipRegistrationModel> table) {

		logger.info("Method : AddMemberReg starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String userMemId = "";
		for (UserMembershipRegistrationModel m : table) {
			if (m.getFirst_name_m() == null || m.getFirst_name_m() == "") {
				  validity = false;
				  resp.setCode("*First Name Required ");
				  resp.setMessage("Please Enter First Name.");
				  break;
			  }else if(m.getLast_name_m() == null || m.getLast_name_m() == "") {
				  validity = false; 
				  resp.setCode("*Last Name required");
				  resp.setMessage("Please Enter Last Name.");
				  break;
			  }else if(m.getMobile_no_m() == null || m.getMobile_no_m() == "") {
				  validity = false; 
				  resp.setCode("*Mobile Number required");
				  resp.setMessage("Please Enter Mobile No.");
				  break;
			  }else if(m.getEmail_m() == null || m.getEmail_m() == "") {
				  validity = false; 
				  resp.setCode("*Email required"); 
				  resp.setMessage("Please Enter Email.");
				  break;
			  }else if(m.getPassword_m() == null || m.getPassword_m() == "") {
				  validity = false; 
				  resp.setCode("*Password required");
				  resp.setMessage("Please Enter Password.");
				  break;
			  }else if(m.getPin_m() == null || m.getPin_m() == "") {
				  validity = false; 
				  resp.setCode("*Pin required"); 
				  resp.setMessage("Please Enter Pin.");
				  break;  
			  }else if(m.getCountry_m() == null || m.getCountry_m() == "") {
				  validity = false; 
				  resp.setCode("*Select Country"); 
				  resp.setMessage("Please Select Country.");
				  break; 
			  }else if(m.getState_m() == null || m.getState_m() == "") {
				  validity = false;
				  resp.setCode("*Select State");
				  resp.setMessage("Please Select State.");
				  break;
			  }else if(m.getDistrict_m() == null || m.getDistrict_m() == "") {
				  validity = false;
				  resp.setCode("*Select District");
				  resp.setMessage("Please Select District.");
				  break;
			  }else if (m.getZip_m()== null || m.getZip_m() == "") {
				  validity =false; 
				  resp.setCode("*Zip required"); 
				  resp.setMessage("Please Enter Zip.");
				 
			  }else if (m.getAddress_m() == null || m.getAddress_m() == "") {
				  validity =false; 
				  resp.setCode("*Address required"); 
				  resp.setMessage("Please Enter Address.");
				  break; 
				  
			  }else if(m.getMember_type_m() == null || m.getMember_type_m() == "") {
				  validity =false; 
				  resp.setMessage("*Select Member Type");
				  break; 
			  }else if(m.getRegistration_m() == null ) {
				  validity =false; 
				  resp.setCode("*Registration fee Required"); 
				  resp.setMessage("Please Enter Registration fee.");
				  break; 
			  }else if(m.getMonthly_fee_m() == null ) { 
				  validity =false; 
				  resp.setCode("*Monthly fee Required");
				  resp.setMessage("Please Enter Monthly fee.");
				  break; 
			  }else if (m.getJoiningdate_m() == null || m.getJoiningdate_m() == "") {
				  validity =false; 
				  resp.setCode("*Select Joining Date");
				  resp.setMessage("Please Select Joining date.");
				  break;
			   
			  }else if(m.getPayment_mode_m() == null || m.getPayment_mode_m() == "") {
				  validity =false; 
				  resp.setCode("*Select Payment Mode"); 
				  resp.setMessage("Please Select Payment Mode.");
				  break; 
			  }else if(m.getStatus_m() == null ) {
				  validity =false; 
				  resp.setCode("*Select Status");
				  resp.setMessage("Please Select Status.");
				  break;
			  }else if(m.getUserType() == null ) {
				  validity =false; 
				  resp.setCode("*Select User Type");
				  resp.setMessage("Please Select User Type.");
				  break;
			  }
			   
		}
		if (validity)
			try {
				 Object ReturnvalId="";
				 String values = GenerateUserMemRegistrationParameter.getAddUserMemParam(table);
				for (UserMembershipRegistrationModel i : table) {
					userMemId = i.getMemId();
					 
				}
				if (userMemId != null && userMemId != "") {
					em.createNamedStoredProcedureQuery("userMemRegRoutines")
					.setParameter("actionType", "modifyMemReg")
					.setParameter("actionValue", values)
					.execute();
				} else {
					ReturnvalId = em.createNamedStoredProcedureQuery("userMemRegRoutines")
					.setParameter("actionType", "addMemReg")
					.setParameter("actionValue", values)
					.getSingleResult();
				
					String total = (String) ReturnvalId;
				 	if(total != null) {
						String valuesdep = GenerateUserMemRegistrationParameter.getAddUserMemDependent(table,total);
						 em.createNamedStoredProcedureQuery("userMemRegRoutines")
							.setParameter("actionType", "addMemRegDependent")
							.setParameter("actionValue", valuesdep)
							.execute();
					}
					
				}

			} catch (Exception e) {
				e.printStackTrace();
				try {
					String[] err =serverDao.errorProcedureCall(e);
						//	ServerValidation.geterror(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : AddMemberReg ends");

		return response;
	}
	
	
	
	/*
	 * 
	 * 
	 * Update EDIT  Member Registration
	 * 
	 * 
	 */
	public ResponseEntity<JsonResponse<Object>> restUpdateMemberReg(List<UserMembershipRegistrationModel> table) {

		logger.info("Method : restUpdateMemberReg starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String userMemId = "";
		for (UserMembershipRegistrationModel m : table) {
			if (m.getFirst_name_m() == null || m.getFirst_name_m() == "") {
				  validity = false;
				  resp.setCode("*First Name Required ");
				  resp.setMessage("Please Enter First Name.");
				  break;
			  }else if(m.getLast_name_m() == null || m.getLast_name_m() == "") {
				  validity = false; 
				  resp.setCode("*Last Name required");
				  resp.setMessage("Please Enter Last Name.");
				  break;
			  }else if(m.getMobile_no_m() == null || m.getMobile_no_m() == "") {
				  validity = false; 
				  resp.setCode("*Mobile Number required");
				  resp.setMessage("Please Enter Mobile No.");
				  break;
			  }else if(m.getEmail_m() == null || m.getEmail_m() == "") {
				  validity = false; 
				  resp.setCode("*Email required"); 
				  resp.setMessage("Please Enter Email.");
				  break;
			  }else if(m.getPassword_m() == null || m.getPassword_m() == "") {
				  validity = false; 
				  resp.setCode("*Password required");
				  resp.setMessage("Please Enter Password.");
				  break;
			  }else if(m.getPin_m() == null || m.getPin_m() == "") {
				  validity = false; 
				  resp.setCode("*Pin required"); 
				  resp.setMessage("Please Enter Pin.");
				  break;  
			  }else if(m.getCountry_m() == null || m.getCountry_m() == "") {
				  validity = false; 
				  resp.setCode("*Select Country"); 
				  resp.setMessage("Please Select Country.");
				  break; 
			  }else if(m.getState_m() == null || m.getState_m() == "") {
				  validity = false;
				  resp.setCode("*Select State");
				  resp.setMessage("Please Select State.");
				  break;
			  }else if(m.getDistrict_m() == null || m.getDistrict_m() == "") {
				  validity = false;
				  resp.setCode("*Select District");
				  resp.setMessage("Please Select District.");
				  break;
			  }else if (m.getZip_m()== null || m.getZip_m() == "") {
				  validity =false; 
				  resp.setCode("*Zip required"); 
				  resp.setMessage("Please Enter Zip.");
				 
			  }else if (m.getAddress_m() == null || m.getAddress_m() == "") {
				  validity =false; 
				  resp.setCode("*Address required"); 
				  resp.setMessage("Please Enter Address.");
				  break; 
				  
			  }else if(m.getMember_type_m() == null || m.getMember_type_m() == "") {
				  validity =false; 
				  resp.setMessage("*Select Member Type");
				  break; 
			  }else if(m.getRegistration_m() == null ) {
				  validity =false; 
				  resp.setCode("*Registration fee Required"); 
				  resp.setMessage("Please Enter Registration fee.");
				  break; 
			  }else if(m.getMonthly_fee_m() == null ) { 
				  validity =false; 
				  resp.setCode("*Monthly fee Required");
				  resp.setMessage("Please Enter Monthly fee.");
				  break; 
			  }else if (m.getJoiningdate_m() == null || m.getJoiningdate_m() == "") {
				  validity =false; 
				  resp.setCode("*Select Joining Date");
				  resp.setMessage("Please Select Joining date.");
				  break;
			   
			  }else if(m.getPayment_mode_m() == null || m.getPayment_mode_m() == "") {
				  validity =false; 
				  resp.setCode("*Select Payment Mode"); 
				  resp.setMessage("Please Select Payment Mode.");
				  break; 
			  }else if(m.getStatus_m() == null ) {
				  validity =false; 
				  resp.setCode("*Select Status");
				  resp.setMessage("Please Select Status.");
				  break;
			  }else if(m.getUserType() == null ) {
				  validity =false; 
				  resp.setCode("*Select User Type");
				  resp.setMessage("Please Select User Type.");
				  break;
			  }
			
			   
		}

		if (validity)
			try {
				Object ReturnvalIdMod ="";
				String values = GenerateUserMemRegistrationParameter.getAddUserMemParam(table);
				for (UserMembershipRegistrationModel i : table) {
					userMemId = i.getMemId();
				 
				}
				
				if (userMemId != null && userMemId != "") {
					ReturnvalIdMod = em.createNamedStoredProcedureQuery("userMemRegRoutines")
							.setParameter("actionType", "modifyMemReg")
							.setParameter("actionValue", values)
							.getSingleResult();
					String total = (String) ReturnvalIdMod;
					if(total != null) {
						String valuesdep = GenerateUserMemRegistrationParameter.getAddUserMemDependent(table,total);
						 em.createNamedStoredProcedureQuery("userMemRegRoutines")
							.setParameter("actionType", "updateMemRegDependent")
							.setParameter("actionValue", valuesdep)
							.execute();
					}
				}  

			} catch (Exception e) {
				e.printStackTrace();
				try {
					String[] err =serverDao.errorProcedureCall(e);
				 	resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : restUpdateMemberReg ends");

		return response;
	}

	/*
	 * DAO Function to View all Member Registration data
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<UserMembershipRegistrationModel>>> getMemberRegDetails(
			DataTableRequest request) {

		logger.info("Method : getMemberRegDetails starts");

		List<UserMembershipRegistrationModel> meal = new ArrayList<UserMembershipRegistrationModel>();
	 	String values = GenerateUserMemRegistrationParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("userMemRegRoutines")
					.setParameter("actionType", "viewMemRegData").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				Object joiningdate=null;
				joiningdate =DateFormatter.returnStringDate(m[7]);
				UserMembershipRegistrationModel user = new UserMembershipRegistrationModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6],joiningdate, m[8], m[9]);
				meal.add(user);
			}

			if (x.get(0).length > 10) {
				BigInteger t = (BigInteger) x.get(0)[10];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<UserMembershipRegistrationModel>> resp = new JsonResponse<List<UserMembershipRegistrationModel>>();
		resp.setBody(meal);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<UserMembershipRegistrationModel>>> response = new ResponseEntity<JsonResponse<List<UserMembershipRegistrationModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getMemberRegDetails ends");

		return response;
	}

	/*
	 * DAO Function to delete particular row from Membership Registration
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteMembershipRegById(String id,String deletedBy) {
		logger.info("Method : DAO deleteMembershipRegById starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		
	
		try {
 	
			String value="";
			
		    value = value +  "@p_memId="+ id +",";
		    value = value + "@p_deleatedBy='"+ deletedBy +"',";
		    
		    if(value != "") {
		    	value= value.substring(0, value.length()-1);
				
		    	value = "SET " + value + ";" ;
			}
		  
			 System.out.println("value delete is------------: " + value ); 


			em.createNamedStoredProcedureQuery("userMemRegRoutines").setParameter("actionType", "deleteMember")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();

			String[] err = ServerValidation.geterror(e);

			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : DAO deleteMembershipRegById ends");
		return response;
	}

	/**
	 * DAO Function to view Membership in model
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<UserMembershipRegistrationModel>>> getMembershipRegistrationModel(
			String id) {

		logger.info("Method : getMembershipRegistrationModel starts");
	 	List<UserMembershipRegistrationModel> mt = new ArrayList<UserMembershipRegistrationModel>();
		JsonResponse<List<UserMembershipRegistrationModel>> resp = new JsonResponse<List<UserMembershipRegistrationModel>>();

		try {

			String value = "SET @p_memId='" + id + "';";
			 List<Object[]> x = em.createNamedStoredProcedureQuery("userMemRegRoutines")
					.setParameter("actionType", "ModelView").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				UserMembershipRegistrationModel memReg = new UserMembershipRegistrationModel(m[0], m[1], m[2], m[3],
						m[4], m[5], m[6], m[7], m[8], m[9]);

				mt.add(memReg);
			}
			resp.setBody(mt);
		} catch (Exception e) {
			e.printStackTrace();
		}

		

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<UserMembershipRegistrationModel>>> response = new ResponseEntity<JsonResponse<List<UserMembershipRegistrationModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getMembershipRegistrationModel ends");
	 	return response;

	}

	/**
	 * DAO Function to Edit Membership
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<UserMemberDataRegistrationModel>>> getMembershipRegistrationEdit(String id,
			String action) {

		logger.info("Method : getMembershipRegistrationEdit starts");

		List<UserMemberDataRegistrationModel> mt = new ArrayList<UserMemberDataRegistrationModel>();

		JsonResponse<List<UserMemberDataRegistrationModel>> resp = new JsonResponse<List<UserMemberDataRegistrationModel>>();

		try {

			String value = "SET @p_memId='" + id + "';";

		 
			List<Object[]> x = em.createNamedStoredProcedureQuery("userMemRegRoutines")
					.setParameter("actionType", action).setParameter("actionValue", value).getResultList();
			Integer count = 0;

			for (Object[] m : x) {
				UserMemberDataRegistrationModel table = new UserMemberDataRegistrationModel(m[0], m[1], m[2], m[3],
						m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17],
						m[18], m[19],m[20],m[21],m[22],m[23]);
				 count++;
				mt.add(table);
			}
			 
			resp.setBody(mt);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<UserMemberDataRegistrationModel>>> response = new ResponseEntity<JsonResponse<List<UserMemberDataRegistrationModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getMembershipRegistrationEdit ends");

		System.out.println("RESPONSE FOR EDIT MEMBER REGISTRATION :-------------" + response);

		return response;
	}

	/**
	 * DAO Function to Edit Membership for dependent
	 *
	 */

	  @SuppressWarnings("unchecked") public ResponseEntity<JsonResponse<List<UserMemberDataRegistrationModel>>> getMemberRegistEditdep(String id,String action) {
	  
	  logger.info("Method : getMemberRegistEditdep starts");
	 
	  List<UserMemberDataRegistrationModel> mt = new ArrayList<UserMemberDataRegistrationModel>();
	  
	  JsonResponse<List<UserMemberDataRegistrationModel>> resp = new
	  JsonResponse<List<UserMemberDataRegistrationModel>>();
	 
	  try {
	  
	  String value = "SET @p_memId='" + id + "';";
	  List<Object[]> x = em.createNamedStoredProcedureQuery("userMemRegRoutines").setParameter("actionType", action).setParameter("actionValue", value).getResultList();
	  Integer count=0;
	 
	  for (Object[] m : x) { 
		  UserMemberDataRegistrationModel table = new
	  UserMemberDataRegistrationModel(m[0], m[1], m[2], m[3], m[4], m[5],
	  m[6],m[7],m[8],m[9],m[10],m[11],m[12],m[13],m[14],m[15],m[16],m[17],m[18],
	  m[19],m[20],m[21],m[22],m[23]); 
		   
	  count++;
	  mt.add(table);
	  }
	 
	  resp.setBody(mt); } catch (Exception e) { e.printStackTrace(); }
	  
	  HttpHeaders responseHeaders = new HttpHeaders();
	  responseHeaders.set("MyResponseHeader", "MyValue");
	  
	  ResponseEntity<JsonResponse<List<UserMemberDataRegistrationModel>>> response = new ResponseEntity<JsonResponse<List<UserMemberDataRegistrationModel>>>(resp, HttpStatus.CREATED);
	  
	  logger.info("Method : getMemberRegistEditdep ends");
	   
	  return response; }
	 

	 

	/*
	 * 
	 * 
	 * get member drop down data
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getMemberData(String getMemberData) {

		logger.info("Method : DAO getMemberData starts");

		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_membertype=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("userMemRegRoutines")
					.setParameter("actionType", getMemberData).setParameter("actionValue", value).getResultList();

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

		logger.info("Method : DAO getMemberData ends");
		return response;
	}
	
	
	/*
	 * 
	 * 
	 * get relation drop down data
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRelationData(String getRelationData) {

		logger.info("Method : DAO getRelationData starts");

		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_relation=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("userMemRegRoutines")
					.setParameter("actionType", getRelationData).setParameter("actionValue", value).getResultList();

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

		logger.info("Method : DAO getRelationData ends");
		return response;
	}
	
	
	
	/*
	 * 
	 * 
	 * get relation self only drop down data
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRelationSelfData(String getRelationSelfData) {

		logger.info("Method : DAO getRelationSelfData starts");

		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_relation=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("userMemRegRoutines")
					.setParameter("actionType", getRelationSelfData).setParameter("actionValue", value).getResultList();

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

		logger.info("Method : DAO getRelationSelfData ends");
		return response;
	}
	
	
	/*
	 * 
	 * 
	 * get UTypeData drop down data
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getUTypeData(String getUTypeData) {

		logger.info("Method : DAO getUTypeData starts");

		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_relation=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("userMemRegRoutines")
					.setParameter("actionType", getUTypeData).setParameter("actionValue", value).getResultList();

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

		logger.info("Method : DAO getUTypeData ends");
		return response;
	}
	/*
	 * 
	 * 
	 * get getDistrict drop down data
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDisData(String getDisData) {

		logger.info("Method : DAO getDisData starts");

		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_relation=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("userMemRegRoutines")
					.setParameter("actionType", getDisData).setParameter("actionValue", value).getResultList();

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

		logger.info("Method : DAO getDisData ends");
		return response;
	}
	/*
	 * 
	 * 
	 * get getPaymentModeData drop down data
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPaymentModeData(String getPaymentModeData) {

		logger.info("Method : DAO getPaymentModeData starts");

		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_paymentmode=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("userMemRegRoutines")
					.setParameter("actionType", getPaymentModeData).setParameter("actionValue", value).getResultList();

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

		logger.info("Method : DAO getPaymentModeData ends");
		return response;
	}
	
	/*
	 * 
	 * 
	 * get state drop down data
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateData(String getStateData) {

		logger.info("Method : DAO getStateData starts");

		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_state=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("userMemRegRoutines")
					.setParameter("actionType", getStateData).setParameter("actionValue", value).getResultList();

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

		logger.info("Method : DAO getStateData ends");
		return response;
	}
	
	/**
	 * DAO Function to view particular districtName in dropDown
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDistrictName(String id) {
		logger.info("Method : getDistrictName starts");
		List<DropDownModel> DistrictList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_stateid=" + id + ";";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("userMemRegRoutines")
					.setParameter("actionType", "getDistrictName").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				DistrictList.add(dropDownModel);
			}

			resp.setBody(DistrictList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getDistrictName ends");
		return response;
	}
	
	
	/**
	 * DAO Function to view particular districtName in dropDown
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<UserMemberDepCountModel>>> getTotalDepAdd(String id) {
		logger.info("Method : getTotalDepAdd starts");
		List<UserMemberDepCountModel> depaddlist = new ArrayList<UserMemberDepCountModel>();
		JsonResponse<List<UserMemberDepCountModel>> resp = new JsonResponse<List<UserMemberDepCountModel>>();
		String value = "SET @p_memtypeid=" + id + ";";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("userMemRegRoutines")
					.setParameter("actionType", "getTotalDep").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				UserMemberDepCountModel UserMemberDepCountModel = new UserMemberDepCountModel(m[0], m[1],m[2]);
				depaddlist.add(UserMemberDepCountModel);
			}

			resp.setBody(depaddlist);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<UserMemberDepCountModel>>> response = new ResponseEntity<JsonResponse<List<UserMemberDepCountModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getTotalDepAdd ends");
		return response;
	}
	
}
