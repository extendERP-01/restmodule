package nirmalya.aatithya.restmodule.employee.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateSkillMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.HrmsSkillMasterModel;
@Repository
public class HrmsSkillMasterDao {
	Logger logger = LoggerFactory.getLogger(HrmsSkillMasterDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for all skill details view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HrmsSkillMasterModel>>> getskillDetails(DataTableRequest request) {

		logger.info("Method in Dao: getskillDetails starts");

		List<HrmsSkillMasterModel> employementList = new ArrayList<HrmsSkillMasterModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("skillMaster")
					.setParameter("actionType", "viewskillList").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					HrmsSkillMasterModel employement = new HrmsSkillMasterModel(m[0], m[1], m[2], m[3]);
					employementList.add(employement);

				}

				if (x.get(0).length >4) {
					BigInteger t = (BigInteger) x.get(0)[4];

					total = Integer.parseInt((t.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HrmsSkillMasterModel>> resp = new JsonResponse<List<HrmsSkillMasterModel>>();
		resp.setBody(employementList);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HrmsSkillMasterModel>>> response = new ResponseEntity<JsonResponse<List<HrmsSkillMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getskillDetails ends");

		return response;
	}

	/*
	 * for add new skill
	 */
	public ResponseEntity<JsonResponse<Object>> addskill(HrmsSkillMasterModel skill) {

		logger.info("Method in Dao: addskill starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (skill.getSkillName() == null || skill.getSkillName() == "") {
			resp.setMessage("skill Name required");
			validity = false;
		} else if (skill.getSkillDesc() == null || skill.getSkillDesc() == "") {
			resp.setMessage("skill description required");
			validity = false;
		} else if (skill.getSkillStatus() == null) {
			resp.setMessage("skill active required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateSkillMasterParameter.getAddSkillParam(skill);
				if (skill.getSkillId() != "") {
					em.createNamedStoredProcedureQuery("skillMaster").setParameter("actionType", "modifyskill")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("skillMaster").setParameter("actionType", "addskill")
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

		logger.info("Method in Dao: addskill ends");

		return response;
	}

	/*
	 * for edit skill
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<HrmsSkillMasterModel>>getskillById(String id) {

		logger.info("Method in Dao: getskillById ends");

		List<HrmsSkillMasterModel> pskill = new ArrayList<HrmsSkillMasterModel>();

		try {

			String value = "SET @P_skillId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("skillMaster")
					.setParameter("actionType", "viewEditskill").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				HrmsSkillMasterModel skill = new HrmsSkillMasterModel(m[0], m[1], m[2], m[3]);

				pskill.add(skill);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<HrmsSkillMasterModel> resp = new JsonResponse<HrmsSkillMasterModel>();
		resp.setBody(pskill.get(0));

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<HrmsSkillMasterModel>> response = new ResponseEntity<JsonResponse<HrmsSkillMasterModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method in Dao: getskillById ends");

		return response;
	}

	/*
	 * for delete skill
	 */
	public ResponseEntity<JsonResponse<Object>>deleteskillById(String id, String createdBy) {

		logger.info("Method in Dao: deleteskillById ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @P_skillId='" + id + "',@P_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("skillMaster").setParameter("actionType", "deleteskill")
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

		logger.info("Method in Dao: deleteskillById ends");

		return response;
	}

}
