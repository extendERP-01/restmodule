/**
 * Defines UserCompare DAO
 *
 */
package nirmalya.aatithya.restmodule.property.dao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import nirmalya.aatithya.restmodule.common.utils.DataSetForPropType1;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateCompareParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class PropertyCompareDao {
	
	Logger logger = LoggerFactory.getLogger(PropertyCompareDao.class);
	@Autowired
	EntityManager em;
	
	/*
	 * DAO Function to get Compare Property category drop down data
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPropCatgName(String getPropCatgName) {
		
		logger.info("Method : DAO getPropCatgName starts");
		
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		
		try {
			String value = "SET @p_PropCatName=" + 0 + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("comparePropertyRoutines")
					.setParameter("actionType", getPropCatgName)
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModelConstructor = new DropDownModel(m[0], m[1]);
				dropDownModel.add(dropDownModelConstructor);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		resp.setBody(dropDownModel);

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : DAO getPropCatgName ends");	
		return response;
	}
	/*############################### END #################################*/

	
	
	
	/**
	 * ONCHANGE PROPERTY TYPE
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPropertyTypeListById(String proType) {
		logger.info("Method : RESTMODULE   getPropertyTypeListById starts");

		List<DropDownModel> propertyTypeList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_propertyType='" + proType + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("comparePropertyRoutines")
					.setParameter("actionType", "getPropTypeName")
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				propertyTypeList.add(dropDownModel);
			}

			resp.setBody(propertyTypeList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : RESTMODULE getPropertyTypeListById ends");
		return response;
	}
	
	/*######################################## END #################################################*/
	
	/**
	 * ONCHANGE PROPERTY TYPE FOR ATTRIBUTE
	 *
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAttributeList(String proType) {
		logger.info("Method : RESTMODULE   getAttributeList starts");

		List<DropDownModel> attributeList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_propertyCat='" + proType + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("comparePropertyRoutines")
					.setParameter("actionType", "getAttributeName")
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				attributeList.add(dropDownModel);
			}

			resp.setBody(attributeList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : RESTMODULE getAttributeName ends");
		return response;
	}
	
	/*######################################## END #################################################*/
	
	/**
	 * ONCHANGE PROPERTY TYPE1 
	 *
	 */


	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DataSetForPropType1>>> getPropertyType11(List<DataSetForPropType1> table) {
		logger.info("Method :  RESTMODULE DAO  getPropertyType11 starts");

		List<DataSetForPropType1> List1 = new ArrayList<DataSetForPropType1>();
		JsonResponse<List<DataSetForPropType1>> resp = new JsonResponse<List<DataSetForPropType1>>();

		try {
			String values = GenerateCompareParameter.getsendParam(table);
			List<Object[]> x = em.createNamedStoredProcedureQuery("comparePropertyRoutines")
					.setParameter("actionType", "getAvailabeDetails1")
					.setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				DataSetForPropType1 DataSetForPropType1 = new DataSetForPropType1(m[0], m[1]);
				List1.add(DataSetForPropType1);
			}

			resp.setBody(List1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DataSetForPropType1>>> response = new ResponseEntity<JsonResponse<List<DataSetForPropType1>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : RESTMODULE getPropertyType11List ends");
		return response;
	}
	
	/*######################################## END #################################################*/
	
	/**
	 * ONCHANGE PROPERTY TYPE2 
	 *
	 */


	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DataSetForPropType1>>> getPropertyType22(List<DataSetForPropType1> table) {
		logger.info("Method :  RESTMODULE DAO  getPropertyType22 starts");

		List<DataSetForPropType1> List1 = new ArrayList<DataSetForPropType1>();
		JsonResponse<List<DataSetForPropType1>> resp = new JsonResponse<List<DataSetForPropType1>>();

		try {
			String values = GenerateCompareParameter.getsendParam2(table);
			List<Object[]> x = em.createNamedStoredProcedureQuery("comparePropertyRoutines")
					.setParameter("actionType", "getAvailabeDetails2")
					.setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				DataSetForPropType1 DataSetForPropType1 = new DataSetForPropType1(m[0], m[1]);
				List1.add(DataSetForPropType1);
			}

			resp.setBody(List1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DataSetForPropType1>>> response = new ResponseEntity<JsonResponse<List<DataSetForPropType1>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : RESTMODULE getPropertyType22List ends");
		return response;
	}
	
	/*######################################## END #################################################*/
}
