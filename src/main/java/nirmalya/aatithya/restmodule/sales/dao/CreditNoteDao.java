package nirmalya.aatithya.restmodule.sales.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.model.CreditNoteModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class CreditNoteDao {

	@Autowired
	ServerDao serverDao;
	
	@Autowired
	EntityManager em;
	
	Logger logger = LoggerFactory.getLogger(CreditNoteDao.class);
	
	/**
	 * DAO - Get Credit Note
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<CreditNoteModel>>> getCreditNoteDetails(DataTableRequest request) {
		logger.info("Method : getCreditNoteDetails starts");
		
		List<CreditNoteModel> creditNote = new ArrayList<CreditNoteModel>();
		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("creditNoteRoutines")
					.setParameter("actionType", "getCreditNote")
					.setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				Object crDate = null;
				if(m[6]!=null) {
					crDate = DateFormatter.returnStringDate(m[6]);
				}
				CreditNoteModel credit = new CreditNoteModel(m[0],m[1],m[2],m[3],m[4],m[5],null,crDate,m[7]);
				creditNote.add(credit);
			}
			if(x.size()>0) {
				if (x.get(0).length > 8) {
					BigInteger t = (BigInteger) x.get(0)[8];
	
					total = Integer.parseInt((t.toString()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<CreditNoteModel>> resp = new JsonResponse<List<CreditNoteModel>>();
		resp.setBody(creditNote);
		resp.setTotal(total);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<CreditNoteModel>>> response = new ResponseEntity<JsonResponse<List<CreditNoteModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getCreditNoteDetails ends");
		
		return response;
	}
	
	/**
	 * DAO - Get Credit Note For Modal
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<CreditNoteModel>>> getCreditNoteById(String id) {
		logger.info("Method : getCreditNoteById starts");
		
		List<CreditNoteModel> creditNote = new ArrayList<CreditNoteModel>();
		JsonResponse<List<CreditNoteModel>> resp = new JsonResponse<List<CreditNoteModel>>();
		try {

			String value = "SET @p_creditNote='" + id + "';"; 
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("creditNoteRoutines")
					.setParameter("actionType", "ModalCreditNote")
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object crDate = null;
				if(m[7]!=null) {
					crDate = DateFormatter.returnStringDate(m[7]);
				}
				
				CreditNoteModel credit = new CreditNoteModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],crDate,m[8]);
				creditNote.add(credit);
			}
			
			resp.setBody(creditNote);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<CreditNoteModel>>> response = new ResponseEntity<JsonResponse<List<CreditNoteModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : getCreditNoteById ends");
		
		return response;
	}
	
	/**
	 * DAO - Get Credit Note List By AutoSearch
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCreditNoteAutoSearchDao(String id) {
		logger.info("Method : getCreditNoteAutoSearchDao Dao starts");

		List<DropDownModel> creditNote = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_serachValue='" + id + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("creditNoteRoutines")
					.setParameter("actionType", "getCreditNoteList")
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				creditNote.add(dropDownModel);
			}

			resp.setBody(creditNote);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getCreditNoteAutoSearchDao Dao ends");
		return response;
	}
	
	/**
	 * DAO - Get Sale Invoice Return List By AutoSearch
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSaleInvReturnAutoSearchDao(String id) {
		logger.info("Method : getSaleInvReturnAutoSearchDao Dao starts");

		List<DropDownModel> saleInvReturn = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_serachValue='" + id + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("creditNoteRoutines")
					.setParameter("actionType", "getSaleInvReturn")
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				saleInvReturn.add(dropDownModel);
			}

			resp.setBody(saleInvReturn);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getSaleInvReturnAutoSearchDao Dao ends");
		return response;
	}
}
