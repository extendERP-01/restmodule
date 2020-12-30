package nirmalya.aatithya.restmodule.production.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateAssignSlitParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.production.model.AssignSlitPipeSizeModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class AssignSlitPipeSizeDao {

	Logger logger = LoggerFactory.getLogger(AssignSlitPipeSizeDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSlitWithForAssignmentDao() {
		logger.info("Method : getSlitWithForAssignmentDao starts");

		List<DropDownModel> slitWidth = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignSlitWidth")
					.setParameter("actionType", "getSlitWidth").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				slitWidth.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getSlitWithForAssignmentDao ends");
		return slitWidth;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getGradeDao(String id) {
		logger.info("Method : getGradeDao Dao starts");

		List<DropDownModel> grade = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_searchValue='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("assignSlitWidth")
					.setParameter("actionType", "getGrade").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				grade.add(dropDownModel);
			}
			resp.setBody(grade);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getGradeDao Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getThicknessDao(DropDownModel id) {
		logger.info("Method : getThicknessDao Dao starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_searchValue='" + id.getName() + "', @p_catgeory='" + id.getKey() + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignSlitWidth")
					.setParameter("actionType", "getThickness").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemList.add(dropDownModel);
			}

			resp.setBody(itemList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getThicknessDao Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPipeSizeDao(DropDownModel id) {
		logger.info("Method : getPipeSizeDao Dao starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_searchValue='" + id.getName() + "', @p_subcatgeory='" + id.getKey() + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("assignSlitWidth")
					.setParameter("actionType", "getPipeSize").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemList.add(dropDownModel);
			}

			resp.setBody(itemList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getPipeSizeDao Dao ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> saveAssignedSlitPipeSizeDao(List<AssignSlitPipeSizeModel> assignment) {
		logger.info("Method : saveAssignedSlitPipeSizeDao starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (AssignSlitPipeSizeModel l : assignment) {

			if (l.getGradeId() == null || l.getGradeId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Grade Required");
				break;
			} else if (l.getThicknessId() == null || l.getThicknessId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Thickness Required");
				break;
			} else if (l.getPipeSizeId() == null || l.getPipeSizeId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Pipe Size Required");
				break;
			} else if (l.getSlitWidth() == null) {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Slit Width Required");
				break;
			}
		}
		if (validity) {
			try {
				String values = GenerateAssignSlitParameter.assignSlitParam(assignment);
				em.createNamedStoredProcedureQuery("assignSlitWidth").setParameter("actionType", "assignSlitPipe")
						.setParameter("actionValue", values).execute();
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

		logger.info("Method : saveAssignedSlitPipeSizeDao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AssignSlitPipeSizeModel>>> getAssignedSlitPipeSizeDetails(
			DataTableRequest request) {
		logger.info("Method : getAssignedSlitPipeSizeDetails starts");

		List<AssignSlitPipeSizeModel> assignment = new ArrayList<AssignSlitPipeSizeModel>();

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("assignSlitWidth")
					.setParameter("actionType", "getAssignedDtls").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				AssignSlitPipeSizeModel dd = new AssignSlitPipeSizeModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8]);
				assignment.add(dd);
			}
			if (x.size() > 0) {
				if (x.get(0).length > 9) {
					BigInteger t = (BigInteger) x.get(0)[9];
					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<AssignSlitPipeSizeModel>> resp = new JsonResponse<List<AssignSlitPipeSizeModel>>();
		resp.setBody(assignment);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<AssignSlitPipeSizeModel>>> response = new ResponseEntity<JsonResponse<List<AssignSlitPipeSizeModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getAssignedSlitPipeSizeDetails ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteAssignedSlitPipeDao(AssignSlitPipeSizeModel id) {
		logger.info("Method : deleteAssignedSlitPipeDao Dao starts");

		List<AssignSlitPipeSizeModel> itemList = new ArrayList<AssignSlitPipeSizeModel>();

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_grade='" + id.getGrade() + "', @p_thickness='" + id.getThickness()
					+ "', @p_pipeSize='" + id.getPipeSize() + "', @p_slitWidth= " + id.getSlitWidth() + ";";

			em.createNamedStoredProcedureQuery("assignSlitWidth").setParameter("actionType", "deleteAssignedSlit")
					.setParameter("actionValue", value).execute();

			resp.setBody(itemList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : deleteAssignedSlitPipeDao Dao ends");
		return response;
	}
}
