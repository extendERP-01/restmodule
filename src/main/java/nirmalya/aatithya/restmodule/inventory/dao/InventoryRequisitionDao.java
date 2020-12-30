package nirmalya.aatithya.restmodule.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.ActivitylogModel;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.inventory.model.InventoryRequisitionModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class InventoryRequisitionDao {

	Logger logger = LoggerFactory.getLogger(InventoryRequisitionDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager entityManager;

	/**
	 * DAO Function to view particular getRequisitionType in dropDown for
	 * ItemRequisition
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getRequisitionType() {
		logger.info("Method : getRequisitionType starts");
		List<DropDownModel> getRequisitionTypeList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "getRequisitionTypeList").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getRequisitionTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getRequisitionType ends");
		return getRequisitionTypeList;
	}

	/**
	 * DAO Function to view particular getRequisitionType in dropDown for
	 * ItemRequisition
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getRequisitionPriority() {
		logger.info("Method : getRequisitionPriority starts");
		List<DropDownModel> getRequisitionTypeList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "getRequisitionPriority").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getRequisitionTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getRequisitionPriority ends");
		return getRequisitionTypeList;
	}

	/**
	 * DAO Function to view particular getRequisitionType in dropDown for
	 * ItemRequisition
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryRequisitionModel> getRequisitionItemList() {
		logger.info("Method : getRequisitionItemList starts");
		List<InventoryRequisitionModel> getRequisitionTypeList = new ArrayList<InventoryRequisitionModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "getRequisitionItemList").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				Object oa = null;
				if (m[8] != null) {
					oa = DateFormatter.returnStringDate(m[8]);
				}
				InventoryRequisitionModel dropDownModel = new InventoryRequisitionModel(m[0], m[1], m[2], m[3], m[4],
						null, m[5], m[6], m[7], null, null, m[9]);
				getRequisitionTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getRequisitionItemList ends");
		return getRequisitionTypeList;
	}
	/**
	 * DAO Function to view particular getRequisitionType in dropDown for
	 * ItemRequisition
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<ActivitylogModel> getActivityLog(String id) {
		logger.info("Method : getActivityLog starts");
		List<ActivitylogModel> activitylogModelList = new ArrayList<ActivitylogModel>();
		try {
			String value = "SET @p_id='" + id + "'";
			System.out.println("value " + value);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "getActivityLog").setParameter("actionValue", value)
					.getResultList();
			
			for (Object[] m : x) {
				Object oa = null;
				if (m[6] != null) {
					oa = DateFormatter.returnStringDate(m[8]);
				}
				ActivitylogModel activitylogModel = new ActivitylogModel(m[0], m[1], m[2], m[3], m[4],
						m[5], oa);
				activitylogModelList.add(activitylogModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getActivityLog ends");
		return activitylogModelList;
	}
}
