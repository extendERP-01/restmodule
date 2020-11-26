/**
 * 
 */
package nirmalya.aatithya.restmodule.inventory.dao;

import java.math.BigInteger;
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
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryDebitNoteModel;

/**
 * @author USER
 *
 */
@Repository
public class RestInventoryDebitNoteDao {
	Logger logger=LoggerFactory.getLogger(RestInventoryDebitNoteDao.class);
	@Autowired
	private EntityManager entityManager;
	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to View all itemCategories in dropDown
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestInventoryDebitNoteModel>>> getAllDebitNote(DataTableRequest request) {
		logger.info("Method : getAllDebitNote Dao starts");
		List<RestInventoryDebitNoteModel> itemCategoryModel = new ArrayList<RestInventoryDebitNoteModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("debitNoteRoutines")
					.setParameter("actionType", "viewDebitNode").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				Object date1 = null;
				date1 = DateFormatter.returnStringDate(m[11]);	
				Object date2 = null;
				date2 = DateFormatter.returnStringDate(m[8]);	
				RestInventoryDebitNoteModel itmCat = new RestInventoryDebitNoteModel(m[0], m[1], m[2], m[3],m[4], m[5], m[6], m[7], date2, m[9],m[10], date1,m[12]);
				itemCategoryModel.add(itmCat);
			}

			if (x.get(0).length > 13) {
				BigInteger t = (BigInteger) x.get(0)[13];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestInventoryDebitNoteModel>> resp = new JsonResponse<List<RestInventoryDebitNoteModel>>();
		resp.setBody(itemCategoryModel);
		resp.setTotal(total);
		ResponseEntity<JsonResponse<List<RestInventoryDebitNoteModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryDebitNoteModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllDebitNote Dao ends");

		return response;
	}

}
