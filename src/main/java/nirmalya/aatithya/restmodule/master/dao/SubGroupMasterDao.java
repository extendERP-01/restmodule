package nirmalya.aatithya.restmodule.master.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateSubGroupNameParametr;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.SubGroupMasterModel;


@Repository

public class SubGroupMasterDao {
	Logger logger = LoggerFactory.getLogger(SubGroupMasterDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/*
	 * for add Group Name
	 */

	public ResponseEntity<JsonResponse<Object>> restAddSubGroupType (SubGroupMasterModel GroupMaster) {

		logger.info("Method in Dao: restAddSubGroupType starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (GroupMaster.getSubGroupName() == null || GroupMaster.getSubGroupName() == "") {
			resp.setMessage("SubGroup Name required");
			validity = false;
		} else if (GroupMaster.getGroupName() == null || GroupMaster.getGroupName() == "") {
			resp.setMessage("Group type required");
			validity = false;
		} else if (GroupMaster.getGroupNameDesc() == null || GroupMaster.getGroupNameDesc() == "") {
			resp.setMessage("Group Desc required");
			validity = false;
		} 
			if (validity)
				try {
					String values = GenerateSubGroupNameParametr.getAddSubGroup(GroupMaster);

					if (GroupMaster.getSubGroupId() != "" && GroupMaster.getSubGroupId() != null) {
						em.createNamedStoredProcedureQuery("SubGroupName").setParameter("actionType", "ModifySubGroup")
								.setParameter("actionValue", values).execute();
					} else {
						em.createNamedStoredProcedureQuery("SubGroupName").setParameter("actionType", "addSubGroup")
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
		
			ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
					HttpStatus.CREATED);

			logger.info("Method in Dao: restAddSubGroupType ends");

			return response;
		}
	/**
	 * DAO Function for Group list drop down models
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getGroupTypelistName() {
		logger.info("Method : getGroupTypelistName starts");
		List<DropDownModel> itemlist = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("SubGroupName")
					.setParameter("actionType", "getGrouplistName").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemlist.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getGroupTypelistName end");
		return itemlist;
	}
	/*
	 * for view  sub Grouptype
	 */
	@SuppressWarnings("unchecked")
       public ResponseEntity<JsonResponse<List<SubGroupMasterModel>>> getSubGroupType(DataTableRequest request) {
		logger.info("Method : getSubGroupType starts");
		List<SubGroupMasterModel> form = new ArrayList<SubGroupMasterModel>();

		String values = GenerateParameter.getSearchParam(request);
		
		Integer total = 0;
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("SubGroupName")
					.setParameter("actionType", "viewSubGroup").setParameter("actionValue", values).getResultList();

			
				for (Object[] m : x) {
					SubGroupMasterModel payment = new SubGroupMasterModel(m[0],m[1],m[2],m[3]);
					form.add(payment);
				}
				if (x.size() > 0)
				if (x.get(0).length > 4) {
					BigInteger t = (BigInteger) x.get(0)[4];

					total = Integer.parseInt((t.toString()));
				}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonResponse<List<SubGroupMasterModel>> resp = new JsonResponse<List<SubGroupMasterModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<SubGroupMasterModel>>> response = new ResponseEntity<JsonResponse<List<SubGroupMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getSubGroupType end");
	
		return response;
		
	}
	/*
	 * for delete sub group 
	 */

	public ResponseEntity<JsonResponse<Object>> deleteSubGroupTypeById(String id, String createdBy) {
		logger.info("Method : deleteSubGroupTypeById starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_SubGroupId='" + id + "',@P_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("SubGroupName").setParameter("actionType", "deleteSubGroup")
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

		logger.info("Method : deleteSubGroupTypeById ends");
		return response;
}
	/*
	 * for edit group
	 */

@SuppressWarnings("unchecked")
public ResponseEntity<JsonResponse<SubGroupMasterModel>> getSupGroupTypeById(String id) {

	logger.info("Method : getSupGroupTypeById starts");

	List<SubGroupMasterModel> groupType = new ArrayList<SubGroupMasterModel>();
	JsonResponse<SubGroupMasterModel> resp = new JsonResponse<SubGroupMasterModel>();

	try {

		String value = "SET @p_SubGroupId='" + id + "';";

	
		List<Object[]> x = em.createNamedStoredProcedureQuery("SubGroupName")
				.setParameter("actionType", "viewEditSGroup").setParameter("actionValue", value)
				.getResultList();

		for (Object[] m : x) {
			SubGroupMasterModel group = new SubGroupMasterModel(m[0],m[1],m[2],m[3]);

			groupType.add(group);
		}

		resp.setBody(groupType.get(0));
	} catch (Exception e) {
		e.printStackTrace();
	}

	HttpHeaders responseHeaders = new HttpHeaders();
	responseHeaders.set("MyResponseHeader", "MyValue");

	ResponseEntity<JsonResponse<SubGroupMasterModel>> response = new ResponseEntity<JsonResponse<SubGroupMasterModel>>(
			resp, responseHeaders, HttpStatus.CREATED);

	logger.info("Method : getSupGroupTypeById ends");

	return response;
}
/*
 * for modal view group
 */

@SuppressWarnings("unchecked")
public ResponseEntity<JsonResponse<SubGroupMasterModel>>viewSubGroupTypeById(String id) {

logger.info("Method : viewSubGroupTypeById starts");

List<SubGroupMasterModel> groupType = new ArrayList<SubGroupMasterModel>();
JsonResponse<SubGroupMasterModel> resp = new JsonResponse<SubGroupMasterModel>();

try {

	String value = "SET @p_SubGroupId='" + id + "';";

	

	List<Object[]> x = em.createNamedStoredProcedureQuery("SubGroupName")
			.setParameter("actionType", "SGModalView").setParameter("actionValue", value)
			.getResultList();

	for (Object[] m : x) {
		SubGroupMasterModel group = new SubGroupMasterModel(m[0],m[1],m[2],m[3]);

		groupType.add(group);
	}

	resp.setBody(groupType.get(0));
} catch (Exception e) {
	e.printStackTrace();
}

HttpHeaders responseHeaders = new HttpHeaders();
responseHeaders.set("MyResponseHeader", "MyValue");

ResponseEntity<JsonResponse<SubGroupMasterModel>> response = new ResponseEntity<JsonResponse<SubGroupMasterModel>>(
		resp, responseHeaders, HttpStatus.CREATED);

logger.info("Method : viewSubGroupTypeById ends");

return response;
}
}