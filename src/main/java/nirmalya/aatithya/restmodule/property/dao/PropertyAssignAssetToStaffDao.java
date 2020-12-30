package nirmalya.aatithya.restmodule.property.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Base64;
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
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GeneratePropertyAssignAssetToStaffParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.model.PropertyAssignAssetToStaffModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class PropertyAssignAssetToStaffDao {

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	Logger logger = LoggerFactory.getLogger(PropertyAssignAssetToStaffDao.class);

	/**
	 * DAO return dropdown value of cost center
	 *
	 */

	/*
	 * drop down for item name
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getItemNameStaff() {
		logger.info("Method in Dao: getItemName for assign to a staff starts");
		List<DropDownModel> ItemCategoryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetToStaffRoutines")
					.setParameter("actionType", "getItemCategoryStaff").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				ItemCategoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getItemName for assign to a staff ends");

		return ItemCategoryList;
	}

	/*
	 * Drop down for Item Category
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCategoryName(String proCategoryId) {
		logger.info("Method in Dao: getCategoryName starts");

		List<DropDownModel> amenityNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_ItemCategory='" + proCategoryId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetToStaffRoutines")
					.setParameter("actionType", "getSubCategoryByCat").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				amenityNameList.add(dropDownModel);
			}

			resp.setBody(amenityNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getCategoryName ends");
		return response;
	}

	/*
	 * Drop down for Amenity Item
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemList(String ItemSubCat) {
		logger.info("Method : getItemList starts");

		List<DropDownModel> amenityNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_ItemSubCat='" + ItemSubCat + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetToStaffRoutines")
					.setParameter("actionType", "getItemNameList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				amenityNameList.add(dropDownModel);
			}

			resp.setBody(amenityNameList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getItemList ends");
		return response;
	}

	/*
	 * get cost center
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCostCenterList() {
		logger.info("Method : getCostCenterList starts");

		List<DropDownModel> costcenter = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetToStaffRoutines")
					.setParameter("actionType", "getCostNameList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				costcenter.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCostCenterList ends");

		return costcenter;
	}

	/**
	 * DAO return dropdown value of user
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStaffList() {
		logger.info("Method : getStaffList starts");

		List<DropDownModel> staff = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetToStaffRoutines")
					.setParameter("actionType", "getStaffList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				staff.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getStaffList ends");

		return staff;
	}

	/**
	 * DAO return dropdown value of user by cost center
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAllUser(String id) {
		logger.info("Method : getAllUser starts");

		List<DropDownModel> user = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_costcenter='" + id + "';";
		System.out.println("value: "+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetToStaffRoutines")
					.setParameter("actionType", "getAllUser").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				user.add(dropDownModel);
			}

			resp.setBody(user);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAllUser ends");
		return response;
	}

	/**
	 * DAO assign new asset to status
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> assignNewAssetToStaff(
			List<PropertyAssignAssetToStaffModel> assignAssetToStaff) {
		logger.info("Method : assignNewAssetToStaff DAO starts");
		System.out.println("object data are " + assignAssetToStaff);
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (PropertyAssignAssetToStaffModel l : assignAssetToStaff) {

			if (l.getCostCenter() == null || l.getCostCenter() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Cost Center.");
				break;
			} else if (l.getStaff() == null || l.getStaff() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Staff.");
				break;
			} else if (l.getCategory() == null || l.getCategory() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Category.");
				break;
			} else if (l.getSubcategory() == null || l.getSubcategory() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Sub Category.");
				break;
			} else if (l.getItem() == null || l.getItem() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Item.");
				break;
			} else if (l.getAsset() == null || l.getAsset() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Asset.");
				break;
			} else if (l.getAssignDate() == null || l.getAssignDate() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Assigned Date.");
				break;
			} else if (l.getActive() == null) {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Status.");
				break;
			}
		}

		if (validation) {
			try {
				String value = GeneratePropertyAssignAssetToStaffParameter.getAssignAssetToStaff(assignAssetToStaff);

				em.createNamedStoredProcedureQuery("assignAssetToStaffRoutines")
						.setParameter("actionType", "assignAssetStf").setParameter("actionValue", value).execute();

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
		logger.info("Method : assignNewAssetToStaff DAO ends");
		return response;
	}

	/**
	 * DAO returns all assigned asset to staff
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PropertyAssignAssetToStaffModel>>> getAllAssignedAssetToStaffDetails(
			DataTableRequest request) {

		logger.info("Method : getAllAssignedAssetToStaffDetails starts");

		List<PropertyAssignAssetToStaffModel> bookTable = new ArrayList<PropertyAssignAssetToStaffModel>();
		String param2 = request.getParam2();
		if (param2 != null && param2 != "") {
			String frmDate = DateFormatter.getStringDate(param2);
			request.setParam2(frmDate);
		}
		String values = GenerateParameter.getSearchParam(request);

		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetToStaffRoutines")
					.setParameter("actionType", "viewAssignedAsset").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object fromDate = null;

				fromDate = DateFormatter.returnStringDate(m[6]);

				PropertyAssignAssetToStaffModel user = new PropertyAssignAssetToStaffModel(m[0], m[1], m[2], m[3], m[4],
						m[5], fromDate, m[7], m[8], m[9], m[10], m[11], m[12], m[13]);
				bookTable.add(user);
			}
			if (x.size() > 0) {
				if (x.get(0).length > 14) {
					BigInteger t = (BigInteger) x.get(0)[14];

					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<PropertyAssignAssetToStaffModel>> resp = new JsonResponse<List<PropertyAssignAssetToStaffModel>>();
		resp.setBody(bookTable);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<PropertyAssignAssetToStaffModel>>> response = new ResponseEntity<JsonResponse<List<PropertyAssignAssetToStaffModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getAllAssignedAssetToStaffDetails ends");

		return response;
	}

	/**
	 * DAO change the status
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> changeAssetStatusById(
			PropertyAssignAssetToStaffModel asignAssetToStaffModel) {

		logger.info("Method : changeAssetStatusById starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		byte[] encodeByte = Base64.getDecoder().decode(asignAssetToStaffModel.getCostCenter().getBytes());
		byte[] encodeByte1 = Base64.getDecoder().decode(asignAssetToStaffModel.getStaff().getBytes());

		byte[] encodeByte4 = Base64.getDecoder().decode(asignAssetToStaffModel.getItem().getBytes());
		byte[] encodeByte5 = Base64.getDecoder().decode(asignAssetToStaffModel.getAsset().getBytes());
		byte[] encodeByte6 = Base64.getDecoder().decode(asignAssetToStaffModel.getAssignDate().getBytes());

		String id = (new String(encodeByte));
		String staff = (new String(encodeByte1));
		String item = (new String(encodeByte4));
		String asset = (new String(encodeByte5));
		String date = (new String(encodeByte6));

		try {
			String value = "SET @p_costcenter='" + id + "',@p_staff='" + staff + "',@p_item='" + item + "',@p_asset='"
					+ asset + "',@p_date='" + date + "',@p_createdBy='" + asignAssetToStaffModel.getCreatedBy()
					+ "',@p_active=" + asignAssetToStaffModel.getActive() + ";";
			System.out.println(value);
			em.createNamedStoredProcedureQuery("assignAssetToStaffRoutines").setParameter("actionType", "changeStatus")
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

		logger.info("Method : DAO changeAssetStatusById ends");
		return response;
	}

	/**
	 * DAO - Get Item List By AutoSearch
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PropertyAssignAssetToStaffModel>>> getItemListByAutoSearch(String id) {
		logger.info("Method : getItemListByAutoSearch Dao starts");

		List<PropertyAssignAssetToStaffModel> itemList = new ArrayList<PropertyAssignAssetToStaffModel>();
		JsonResponse<List<PropertyAssignAssetToStaffModel>> resp = new JsonResponse<List<PropertyAssignAssetToStaffModel>>();

		try {
			String value = "SET @p_searchValue='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetToStaffRoutines")
					.setParameter("actionType", "getItemList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				PropertyAssignAssetToStaffModel dropDownModel = new PropertyAssignAssetToStaffModel(null, null, m[0],
						m[1], m[2], null, null, null, null, null, null, null, m[3], null);
				itemList.add(dropDownModel);
			}

			resp.setBody(itemList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<PropertyAssignAssetToStaffModel>>> response = new ResponseEntity<JsonResponse<List<PropertyAssignAssetToStaffModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getItemListByAutoSearch Dao ends");
		return response;
	}

	/*
	 * Drop down for asset for fixed assets
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAssetLists(String item) {

		logger.info("Method in Dao : getAssetList starts");

		List<DropDownModel> assetList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_item='" + item + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("assignAssetToStaffRoutines")
					.setParameter("actionType", "getAssetListAll").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				assetList.add(dropDownModel);

			}

			resp.setBody(assetList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method in Dao: getAssetList ends");
		return response;
	}

}
