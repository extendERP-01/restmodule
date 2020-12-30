package nirmalya.aatithya.restmodule.asset.dao;

import java.math.BigDecimal;
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

import nirmalya.aatithya.restmodule.asset.model.IssueConsumedItemModel;
import nirmalya.aatithya.restmodule.asset.model.ItemAssetModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateIssueItemVehicleParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class IssueConsumedAssetDao {

	Logger logger = LoggerFactory.getLogger(IssueConsumedAssetDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getConsumeItemForIssue(String id) {
		logger.info("Method : getConsumeItemForIssue Dao starts");

		List<DropDownModel> item = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_searchValue='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("issueItemRoutines")
					.setParameter("actionType", "getConsumedItem").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				item.add(dropDownModel);
			}

			resp.setBody(item);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getConsumeItemForIssue Dao ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getJobCardForIssue(String id,String jobCard) {
		logger.info("Method : getJobCardForIssue Dao starts");
		
		List<DropDownModel> item = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		
		try {
			String value = "SET @p_searchValue='" + jobCard + "', @p_vehicle='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("issueItemRoutines")
					.setParameter("actionType", "getJobCard").setParameter("actionValue", value).getResultList();
			
			for (Object[] m : x) {
				Object date = null;
				if(m[1]!=null) {
					date = DateFormatter.returnStringDate(m[1]);
				}
				DropDownModel dropDownModel = new DropDownModel(m[0], date);
				item.add(dropDownModel);
			}
			
			resp.setBody(item);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getJobCardForIssue Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ItemAssetModel>>> getConsumeItemDetails(String id) {
		logger.info("Method : getConsumeItemDetails Dao starts");

		List<ItemAssetModel> item = new ArrayList<ItemAssetModel>();
		JsonResponse<List<ItemAssetModel>> resp = new JsonResponse<List<ItemAssetModel>>();

		try {
			String value = "SET @p_searchValue='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("issueItemRoutines")
					.setParameter("actionType", "getItemDtls").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				ItemAssetModel dropDownModel = new ItemAssetModel(m[0], m[1], m[2]);
				item.add(dropDownModel);
			}

			resp.setBody(item);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<ItemAssetModel>>> response = new ResponseEntity<JsonResponse<List<ItemAssetModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getConsumeItemDetails Dao ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> issueItemToVehicle(List<IssueConsumedItemModel> assignedAsset) {
		logger.info("Method : issueItemToVehicle starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (IssueConsumedItemModel l : assignedAsset) {

			if (l.getStore() == null || l.getStore() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Store Required");
				break;
			} else if (l.getVehicleNo() == null || l.getVehicleNo() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Vehicle Number Required");
				break;
			} else if (l.getVehicleAssetId() == null || l.getVehicleAssetId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Vehicle Asset ID Required");
				break;
			} else if (l.getItemId() == null || l.getItemId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Item Required");
				break;
			} else if (l.getIssueQty() == null) {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Issue Quantity Required");
				break;
			}
		}
		if (validity) {
			try {
				String values = GenerateIssueItemVehicleParameter.issueItemToVehicle(assignedAsset);
				if (assignedAsset.get(0).getIsEdit() != null && assignedAsset.get(0).getIsEdit() != "") {
					em.createNamedStoredProcedureQuery("issueItemRoutines").setParameter("actionType", "modifyIssuedItem")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("issueItemRoutines").setParameter("actionType", "issueItem")
							.setParameter("actionValue", values).execute();
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
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : issueItemToVehicle ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<IssueConsumedItemModel>>> getIssuedConsumedItem(DataTableRequest request) {
		logger.info("Method : getIssuedConsumedItem starts");

		List<IssueConsumedItemModel> assignedAsset = new ArrayList<IssueConsumedItemModel>();
//		if(request.getParam4()!=null && request.getParam4()!="") {
//			String param4 = DateFormatter.getStringDate(request.getParam4());
//			request.setParam4(param4);
//		}
//		if(request.getParam5()!=null && request.getParam5()!="") {
//			String param5 = DateFormatter.getStringDate(request.getParam5());
//			request.setParam5(param5);
//		}
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("issueItemRoutines")
					.setParameter("actionType", "getIssuedConsumedItem").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				Object date = null;
				if (m[4] != null) {
					date = DateFormatter.returnStringDate(m[4]);
				}

				IssueConsumedItemModel gp = new IssueConsumedItemModel(m[0], m[1], m[2], m[3], null, null, null, null,
						null, null, date, null, null,null,m[5],null);
				assignedAsset.add(gp);
			}
			if (x.size() > 0) {
				if (x.get(0).length > 6) {
					BigDecimal t = (BigDecimal) x.get(0)[6];
					total = t.intValue();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<IssueConsumedItemModel>> resp = new JsonResponse<List<IssueConsumedItemModel>>();
		resp.setBody(assignedAsset);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<IssueConsumedItemModel>>> response = new ResponseEntity<JsonResponse<List<IssueConsumedItemModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getIssuedConsumedItem ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<IssueConsumedItemModel> editIssuedConsumedItem(String id, String vehicleAsset) {
		logger.info("Method : editIssuedConsumedItem starts");

		List<IssueConsumedItemModel> assignedAsset = new ArrayList<IssueConsumedItemModel>();
		String value = "SET @p_createdDate='" + DateFormatter.getStringDate(id) + "', @p_vehicleAsset='" + vehicleAsset
				+ "';";
		System.out.println(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("issueItemRoutines")
					.setParameter("actionType", "EditConsumedItem").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object assignDate = null;
				Object jobCardDate = null;
				if (m[10] != null) {
					assignDate = DateFormatter.returnStringDate(m[10]);
				}
				if (m[14] != null) {
					jobCardDate = DateFormatter.returnStringDate(m[14]);
				}
				IssueConsumedItemModel gp = new IssueConsumedItemModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], assignDate, m[11], "2",m[12].toString(),m[13],jobCardDate);
				assignedAsset.add(gp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(assignedAsset);
		logger.info("Method : editIssuedConsumedItem ends");
		return assignedAsset;
	}
}
