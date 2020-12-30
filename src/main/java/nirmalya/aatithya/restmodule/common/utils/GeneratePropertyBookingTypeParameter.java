//package nirmalya.aatithya.restmodule.common.utils;
//
//import nirmalya.aatithya.restmodule.frontdesk.model.RestPropBookingTypeModel;
//
//public class GeneratePropertyBookingTypeParameter {
//
//
//		// Add Process 
//	public static String addPropBookTypeParam(RestPropBookingTypeModel propBook) {
//				String sqlParam = null;
//				if (propBook.gettPtyBkTypName() != null) {
//					sqlParam = "@p_bookTypeName='" + propBook.gettPtyBkTypName() + "',";
//				}
//				if (propBook.gettPtyBkTypDescription() != null) {
//					sqlParam = sqlParam + "@p_description='" + propBook.gettPtyBkTypDescription() + "',";
//				}
//				if (propBook.gettPtyBkTypStatus() != null) {
//
//					sqlParam = sqlParam + "@p_active=" + propBook.gettPtyBkTypStatus() + ",";
//				}
//				if (propBook.gettPtyBkTypCreatedBy()!= null) {
//					sqlParam = sqlParam + "@p_createdBy='" + propBook.gettPtyBkTypCreatedBy() + "',";
//				}
//				if (propBook.gettPropertyBookType() != null) {
//					sqlParam = sqlParam + "@p_bookTypeId='" + propBook.gettPropertyBookType() + "',";
//				}
//
//				if (sqlParam != "") {
//					sqlParam = sqlParam.substring(0, sqlParam.length() - 1);
//
//					sqlParam = "SET " + sqlParam + ";";
//				}
//
//				return sqlParam;
//
//			}
//	}
//
//			
