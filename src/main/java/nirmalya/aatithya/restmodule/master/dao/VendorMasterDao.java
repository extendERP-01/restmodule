package nirmalya.aatithya.restmodule.master.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateLocationMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateVendorMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.controller.VendorMasterRestController;
import nirmalya.aatithya.restmodule.master.model.LocationMasterModel;
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
	
}
