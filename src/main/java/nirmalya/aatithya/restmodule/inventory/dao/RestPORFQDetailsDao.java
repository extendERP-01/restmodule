package nirmalya.aatithya.restmodule.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateInvPORFQDtls;
import nirmalya.aatithya.restmodule.common.utils.GenerateInventVendRFQDtls;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryPORFQVendorDetailModel;
 	
	/**
	 * @author Nirmalya Labs
	 *
	 */
	@Repository

	public class RestPORFQDetailsDao {
		
		Logger logger = LoggerFactory.getLogger(RestPORFQDetailsDao.class);
		@Autowired
		ServerDao serverDao;
		@Autowired
		EntityManager em;
		
		
		


		@SuppressWarnings("unchecked")
		public List<RestInventoryPORFQVendorDetailModel> getPORFQById(String id) {
			logger.info("Method : getPORFQById starts");
			
			List<RestInventoryPORFQVendorDetailModel> quotation = new ArrayList<RestInventoryPORFQVendorDetailModel>();
			String value = "SET @p_RFQId='" + id + "';"; 
			
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("invPORFQDtlsRoutines")
						.setParameter("actionType", "viewEditPORFQVDtls")
						.setParameter("actionValue", value)
						.getResultList();
				
				for(Object[] m : x) {
					Object  quotValidity = null; 
					if (m[19] != null) {
						quotValidity = DateFormatter.returnStringDate(m[19]);
					}
					 
					RestInventoryPORFQVendorDetailModel dropDownModel = new RestInventoryPORFQVendorDetailModel(m[0], m[1], m[2],m[3], m[4],m[5],m[6],m[7],m[8],m[9],m[10],m[11],m[12],m[13],m[14],m[15],m[16],null,m[17],m[18],quotValidity,m[20],m[21],m[22]);
					quotation.add(dropDownModel);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			logger.info("Method : getPORFQById ends");
			System.out.println("response get during edit rfw vendor------"+quotation);
			return quotation;
		}

		
		
		
		

/**
	 * DAO Function to Add Vendor Detls RFQ
	 *
	 */
	@SuppressWarnings("unused")
	public ResponseEntity<JsonResponse<Object>> addPurOrRFQDtls(
			List<RestInventoryPORFQVendorDetailModel> RestInventoryPORFQVendorDetailModel) {
		logger.info("Method : addPurOrRFQDtls starts");
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
				String value = GenerateInvPORFQDtls.getRFQPODtlParam(RestInventoryPORFQVendorDetailModel);
				//String value="";
				System.out.println("value---------------------------------"+value);
				if (RestInventoryPORFQVendorDetailModel.get(0).getVenQuotId() != null) {
					//System.out.println("I m in EDit section----------------------------");
					em.createNamedStoredProcedureQuery("invPORFQDtlsRoutines")
							.setParameter("actionType", "modifyPORFQ").setParameter("actionValue", value)
							.execute();
				} 
				
				/*else {
					//System.out.println("I m in add section----------------------------");
					em.createNamedStoredProcedureQuery("invRFQDtlsRoutines")
							.setParameter("actionType", "addVenDtlsRFQ").setParameter("actionValue", value)
							.execute();
				}*/
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
		logger.info("Method : addPurOrRFQDtls Order ends");
		return response;
	}
}
