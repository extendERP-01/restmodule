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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryStockReportModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class RestInventoryStockReportDao {
	Logger logger = LoggerFactory.getLogger(RestInventoryStockReportDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager entityManager;
	
	
		/*
		 * 
		 * DAO Function to view  Store Name List in dropDown for Report
		 *
		 */
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getStoreListReport() {
			logger.info("Method : getStoreListReport starts");
			List<DropDownModel> storeName = new ArrayList<DropDownModel>();
			try {
				List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryStockReportRoutines")
						.setParameter("actionType", "storeName").setParameter("actionValue", "").getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					storeName.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : getStoreListReport ends");
			return storeName;
		}


			/*
			 * 
			 * DAO Function to view  Godown Name List in dropDown for Report
			 *
			 */
			@SuppressWarnings("unchecked")
			public List<DropDownModel> getGodownListReport() {
				logger.info("Method : getGodownListReport starts");
				List<DropDownModel> godownName = new ArrayList<DropDownModel>();
				try {
					List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryStockReportRoutines")
							.setParameter("actionType", "godownName").setParameter("actionValue", "").getResultList();

					for (Object[] m : x) {
						DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
						godownName.add(dropDownModel);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				logger.info("Method : getGodownListReport ends");
				return godownName;
			}


				/*
				 * 
				 * DAO Function to view  Item Name List in dropDown for Report
				 *
				 */
				@SuppressWarnings("unchecked")
				public List<DropDownModel> getItemListReport() {
					logger.info("Method : getItemListReport starts");
					List<DropDownModel> itemName = new ArrayList<DropDownModel>();
					try {
						List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryStockReportRoutines")
								.setParameter("actionType", "itemName").setParameter("actionValue", "").getResultList();

						for (Object[] m : x) {
							DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
							itemName.add(dropDownModel);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
					logger.info("Method : getItemListReport ends");
					return itemName;
				}


			
					/*
					 * DAO Function to Stock Report Preview
					 *
					 */
					@SuppressWarnings("unchecked")

					public ResponseEntity<JsonResponse<List<RestInventoryStockReportModel>>> getInventoryStockPreview(
							DataTableRequest request) {
						logger.info("Method : getInventoryStockPreview starts");

						
						List<RestInventoryStockReportModel> form = new ArrayList<RestInventoryStockReportModel>();
						String values = GenerateParameter.getSearchParam(request);
						System.out.println("values"+values);
						Integer total = 0;

						try {

							List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryStockReportRoutines")
									.setParameter("actionType", "getCCPreview").setParameter("actionValue", values).getResultList();
							if (!x.isEmpty()) {
							for (Object[] m : x) {

								

								RestInventoryStockReportModel properties = new RestInventoryStockReportModel(m[0],m[1], m[2],m[3], m[4], m[5],m[6],null);
								form.add(properties);
							}
						
							if (x.get(0).length > 7) {
								BigInteger t = (BigInteger) x.get(0)[7];

								total = Integer.parseInt((t.toString()));
							}
							}
						} catch (Exception e) {

							e.printStackTrace();
						}

						JsonResponse<List<RestInventoryStockReportModel>> resp = new JsonResponse<List<RestInventoryStockReportModel>>();
						resp.setBody(form);
						resp.setTotal(total);

						ResponseEntity<JsonResponse<List<RestInventoryStockReportModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryStockReportModel>>>(
								resp, HttpStatus.CREATED);
						logger.info("Method : getInventoryStockPreview ends");
				System.out.println("response"+response);
						return response;
					}


					
						/*
						 * DAO Function to View all Inventory Stock Reports in PDF
						 *
						 */
						@SuppressWarnings("unchecked")

						public ResponseEntity<JsonResponse<List<RestInventoryStockReportModel>>> getInventoryStockReportPdf(
								DataTableRequest request) {
							logger.info("Method : getInventoryStockReportPdf starts");
							
							List<RestInventoryStockReportModel> form = new ArrayList<RestInventoryStockReportModel>();
							String values = GenerateParameter.getSearchParam(request);

							try {

								List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryStockReportRoutines")
										.setParameter("actionType", "getStockPdf").setParameter("actionValue", values)
										.getResultList();

								for (Object[] m : x) {

									

									RestInventoryStockReportModel properties = new RestInventoryStockReportModel(m[0],m[1], m[2],m[3], m[4], m[5],m[6],null);
									form.add(properties);
								}

							} catch (Exception e) {

								e.printStackTrace();
							}

							JsonResponse<List<RestInventoryStockReportModel>> resp = new JsonResponse<List<RestInventoryStockReportModel>>();
							resp.setBody(form);

							ResponseEntity<JsonResponse<List<RestInventoryStockReportModel>>> response = new ResponseEntity<JsonResponse<List<RestInventoryStockReportModel>>>(
									resp, HttpStatus.CREATED);
							logger.info("Method : getInventoryStockReportPdf ends");

							return response;
						}

}
