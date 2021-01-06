package nirmalya.aatithya.restmodule.master.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateLocationMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateVendorMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.controller.VendorMasterRestController;
import nirmalya.aatithya.restmodule.master.model.LocationMasterModel;
import nirmalya.aatithya.restmodule.master.model.VendorLocationMasterModel;
import nirmalya.aatithya.restmodule.master.model.VendorMasterModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class VendorMasterDao {
	Logger logger = LoggerFactory.getLogger(VendorMasterDao.class);
	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<VendorMasterModel>> saveVendorMaster(VendorMasterModel vendorMasterModel) {
		logger.info("Method : saveVendorMaster starts");

		Boolean validity = true;
		JsonResponse<VendorMasterModel> resp = new JsonResponse<VendorMasterModel>();
		resp.setMessage("");
		resp.setCode("");

		List<VendorMasterModel> newVendor = new ArrayList<VendorMasterModel>();

		if (vendorMasterModel.getCode() == null || vendorMasterModel.getCode() == "") {
			resp.setMessage("Code Required");
			validity = false;
		} else if (vendorMasterModel.getVendorName() == null || vendorMasterModel.getVendorName() == "") {
			resp.setMessage("Vendor Name Required");
			validity = false;
		} else if (vendorMasterModel.getCategory() == null || vendorMasterModel.getCategory() == "") {
			resp.setMessage("Category Required");
			validity = false;
		} else if (vendorMasterModel.getCategoryType() == null || vendorMasterModel.getCategoryType() == "") {
			resp.setMessage("Category Type Required");
			validity = false;
		} else if (vendorMasterModel.getComapanyOverview() == null || vendorMasterModel.getComapanyOverview() == "") {
			resp.setMessage("Companny Overview Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateVendorMasterParameter.saveVendorMaster(vendorMasterModel);
				
				if (vendorMasterModel.getVendorId()!= null && vendorMasterModel.getVendorId() != "") {
//					em.createNamedStoredProcedureQuery("locationMasterRoutines")
//							.setParameter("actionType", "modifyLocation").setParameter("actionValue", values).execute();
				
					List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
							.setParameter("actionType", "addVendor").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						Object createDate = null;

						if (m[7] != null) {
							createDate = DateFormatter.returnStringDate(m[7]);
						}

						VendorMasterModel vendorMasterModelData = new VendorMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
								createDate, m[8], m[9]);
						newVendor.add(vendorMasterModelData);
					}
				} else {

					List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
							.setParameter("actionType", "addVendor").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						Object createDate = null;

						if (m[7] != null) {
							createDate = DateFormatter.returnStringDate(m[7]);
						}

						VendorMasterModel vendorMasterModelData = new VendorMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
								createDate, m[8], m[9]);
						newVendor.add(vendorMasterModelData);
					}
				}

				resp.setBody(newVendor.get(0));
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

		ResponseEntity<JsonResponse<VendorMasterModel>> response = new ResponseEntity<JsonResponse<VendorMasterModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveVendorMaster ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCategoryList() {
		logger.info("Method : getCategoryList starts");

		List<DropDownModel> categoryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
					.setParameter("actionType", "getCategoryList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				categoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCategoryList ends");
		return categoryList;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<VendorLocationMasterModel>> saveVendorLocationMaster(VendorLocationMasterModel vendorLocationMasterModel) {
		logger.info("Method : saveVendorMaster starts");

		Boolean validity = true;
		JsonResponse<VendorLocationMasterModel> resp = new JsonResponse<VendorLocationMasterModel>();
		resp.setMessage("");
		resp.setCode("");

		List<VendorLocationMasterModel> newVendor = new ArrayList<VendorLocationMasterModel>();

		if (vendorLocationMasterModel.getVendorLocationName() == null || vendorLocationMasterModel.getVendorLocationName() == "") {
			resp.setMessage("Location Name Required");
			validity = false;
		} else if (vendorLocationMasterModel.getVendorLocationType() == null || vendorLocationMasterModel.getVendorLocationType() == "") {
			resp.setMessage("Vendor Location Type Required");
			validity = false;
		
		} else if (vendorLocationMasterModel.getVendorLocAddress() == null || vendorLocationMasterModel.getVendorLocAddress() == "") {
			resp.setMessage("Vendor Location Address Required");
			validity = false;
		
		} else if (vendorLocationMasterModel.getVendorCountry()== null || vendorLocationMasterModel.getVendorCountry() == "") {
			resp.setMessage("Vendor Location Country Required");
			validity = false;
		
		} else if (vendorLocationMasterModel.getVendorState()== null || vendorLocationMasterModel.getVendorState() == "") {
			resp.setMessage("Vendor Location State Required");
			validity = false;
		} else if (vendorLocationMasterModel.getVendorCity()== null || vendorLocationMasterModel.getVendorCity() == "") {
			resp.setMessage("Location City Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateVendorMasterParameter.saveVendorLocationMaster(vendorLocationMasterModel);
				System.out.println(values);
				if (vendorLocationMasterModel.getVendorLocationId()!= null && vendorLocationMasterModel.getVendorLocationId() != "") {
				List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
							.setParameter("actionType", "modifyVendorLocation").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						Object sDate = null;
						if (m[11] != null) {
							sDate = DateFormatter.returnStringDate(m[11]);
						}
						
							VendorLocationMasterModel vendorLocation = new VendorLocationMasterModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10],sDate);
							newVendor.add(vendorLocation);
						}
				} else {
					
					List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
							.setParameter("actionType", "addVendorLocation").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						Object sDate = null;
							if (m[11] != null) {
								sDate = DateFormatter.returnStringDate(m[11]);
							}
							
							VendorLocationMasterModel vendorLocation = new VendorLocationMasterModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10],sDate);
							newVendor.add(vendorLocation);
						}
				}

				resp.setBody(newVendor.get(0));
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

		ResponseEntity<JsonResponse<VendorLocationMasterModel>> response = new ResponseEntity<JsonResponse<VendorLocationMasterModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveVendorLocationMaster ends");
		return response;
	}
	

	public ResponseEntity<JsonResponse<List<VendorLocationMasterModel>>> getVendorLocationview(String id) {
		logger.info("Method : getRequistionview starts");

		List<VendorLocationMasterModel> viewVendorLocation = new ArrayList<VendorLocationMasterModel>();

		try {
			String value = "SET @p_vendorId='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
					.setParameter("actionType", "viewVendorLocation").setParameter("actionValue", value).getResultList();
			System.out.println(x);
			for (Object[] m : x) {
				Object sDate = null;
				if (m[11] != null) {
					sDate = DateFormatter.returnStringDate(m[11]);
				}

				VendorLocationMasterModel vendorLocation = new VendorLocationMasterModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10],sDate);
				viewVendorLocation.add(vendorLocation);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<VendorLocationMasterModel>> resp = new JsonResponse<List<VendorLocationMasterModel>>();
		resp.setBody(viewVendorLocation);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<VendorLocationMasterModel>>> response = new ResponseEntity<JsonResponse<List<VendorLocationMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getRequistionview ends");
		return response;
	}
	

	public ResponseEntity<JsonResponse<List<VendorMasterModel>>> getVendorList() {
		logger.info("Method : getVendorList starts");

		List<VendorMasterModel> viewVendor = new ArrayList<VendorMasterModel>();

		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
					.setParameter("actionType", "viewVendor").setParameter("actionValue", "").getResultList();
			System.out.println(x);
			for (Object[] m : x) {
			/*	Object sDate = null;
				if (m[7] != null) {
					sDate = DateFormatter.returnStringDate(m[7]);
				}
				Object Date = null;
				if (m[8] != null) {
					Date = DateFormatter.returnStringDate(m[8]);
				}*/

				VendorMasterModel vendorMasterModel = new VendorMasterModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9]);
				viewVendor.add(vendorMasterModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<VendorMasterModel>> resp = new JsonResponse<List<VendorMasterModel>>();
		resp.setBody(viewVendor);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<VendorMasterModel>>> response = new ResponseEntity<JsonResponse<List<VendorMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getVendorList ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<VendorLocationMasterModel>> editVendorLoactionById(String id) {
		logger.info("Method : editVendorLoactionById starts");

		JsonResponse<VendorLocationMasterModel> resp = new JsonResponse<VendorLocationMasterModel>();
		List<VendorLocationMasterModel> newVendor = new ArrayList<VendorLocationMasterModel>();

		try {

			String value = "SET @P_vendorId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
					.setParameter("actionType", "editVendorLocation").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object sDate = null;
				if (m[11] != null) {
					sDate = DateFormatter.returnStringDate(m[11]);
				}

				VendorLocationMasterModel vendorLocation = new VendorLocationMasterModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10],sDate);
				newVendor.add(vendorLocation);
			}
			
			resp.setBody(newVendor.get(0));
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

		ResponseEntity<JsonResponse<VendorLocationMasterModel>> response = new ResponseEntity<JsonResponse<VendorLocationMasterModel>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : editVendorLoactionById ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteVendorLocation(String id, String createdBy) {
		logger.info("Method : deleteVendorLocation starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				
				
				String value = "SET @P_ModifiedBy='" + createdBy + "', @P_VendorId='(" + id + ")';";
				System.out.println("delete value"+value);
				em.createNamedStoredProcedureQuery("vendorMasterRoutines").setParameter("actionType", "deleteVendorLoc")
						.setParameter("actionValue", value).execute();

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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteVendorLocation ends");
		return response;
	}
	
}
