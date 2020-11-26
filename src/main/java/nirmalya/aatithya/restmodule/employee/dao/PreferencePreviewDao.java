package nirmalya.aatithya.restmodule.employee.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;

@Repository
public class PreferencePreviewDao {
	Logger logger = LoggerFactory.getLogger(PreferencePreviewDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/**
	 * for Performance level list
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPerfLevelList() {

		logger.info("Method : getPerfLevelList starts");

		List<DropDownModel> levelList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("OrganizationRoutine")
					.setParameter("actionType", "getPerfLevelList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				levelList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPerfLevelList ends");

		return levelList;
	}

}
