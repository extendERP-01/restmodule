//package nirmalya.aatithya.restmodule.common.utils;
//
//import nirmalya.aatithya.restmodule.frontdesk.model.PropertyTransactionModel;
//
///**
// * @author Nirmalya Labs
// *
// */
//public class GeneratePropertyTransactionParameter {
//	
//
//	/**
//	 * returns parameter set for
//	 **/
//	public static String getAddPropertyTransaction(PropertyTransactionModel propertyTransactionModel) {
//
//		String sqlParam = "";
//
//		if (propertyTransactionModel.getPropertyTransaction() != null
//				&& propertyTransactionModel.getPropertyTransaction() != "") {
//			sqlParam = sqlParam + "@p_propertyTransaction='" + propertyTransactionModel.getPropertyTransaction() + "',";
//		}
//
//		if (propertyTransactionModel.getPropertyCategory() != null
//				&& propertyTransactionModel.getPropertyCategory() != "") {
//			sqlParam = sqlParam + "@p_propertyCategory='" + propertyTransactionModel.getPropertyCategory() + "',";
//		}
//		if (propertyTransactionModel.getPropertyCategoryName() != null
//				&& propertyTransactionModel.getPropertyCategoryName() != "") {
//			sqlParam = sqlParam + "@p_propertyCategoryName='" + propertyTransactionModel.getPropertyBooking() + "',";
//		}
//
//		if (propertyTransactionModel.getPropertyBooking() != null
//				&& propertyTransactionModel.getPropertyBooking() != "") {
//			sqlParam = sqlParam + "@p_propertyBooking='" + propertyTransactionModel.getPropertyBooking() + "',";
//		}
//
//		if (propertyTransactionModel.getpTransDescription() != null
//				&& propertyTransactionModel.getpTransDescription() != "") {
//			sqlParam = sqlParam + "@p_pTransDescription='" + propertyTransactionModel.getpTransDescription() + "',";
//		}
//
//		if (propertyTransactionModel.getpTransPaymentFor() != null
//				&& propertyTransactionModel.getpTransPaymentFor() != "") {
//			sqlParam = sqlParam + "@p_pTransPaymentFor='" + propertyTransactionModel.getpTransPaymentFor() + "',";
//		}
//
//		if (propertyTransactionModel.getpTransReferenceNo() != null
//				&& propertyTransactionModel.getpTransReferenceNo() != "") {
//			sqlParam = sqlParam + "@p_pTransReferenceNo='" + propertyTransactionModel.getpTransReferenceNo() + "',";
//		}
//
//		if (propertyTransactionModel.getpTransAmount() != null) {
//			sqlParam = sqlParam + "@p_pTransAmount=" + propertyTransactionModel.getpTransAmount() + ",";
//		}
//		if (propertyTransactionModel.getpTransActive() != null) {
//			sqlParam = sqlParam + "@p_pTransActive=" + propertyTransactionModel.getpTransActive() + ",";
//		}
//		if (propertyTransactionModel.getpTransCreatedBy() != null
//				&& propertyTransactionModel.getpTransCreatedBy() != "") {
//			sqlParam = sqlParam + "@p_pTransCreatedBy='" + propertyTransactionModel.getpTransCreatedBy() + "',";
//		}
//
//		if (sqlParam != "") {
//			sqlParam = sqlParam.substring(0, sqlParam.length() - 1);
//
//			sqlParam = "SET " + sqlParam + ";";
//		}
//		return sqlParam;
//	}
//
//}
