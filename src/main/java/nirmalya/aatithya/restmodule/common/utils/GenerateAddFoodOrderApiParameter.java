/*
 * package nirmalya.aatithya.restmodule.common.utils;
 * 
 * import java.util.List;
 * 
 * import nirmalya.aatithya.restmodule.restaurant.model.FoodOrderModel; import
 * nirmalya.aatithya.restmodule.restaurant.model.ItemMenu;
 * 
 * public class GenerateAddFoodOrderApiParameter {
 * 
 * public static String getAddfoodOrderModelParam(FoodOrderModel foodOrderModel)
 * {
 * 
 * String s = "";
 * 
 * if (foodOrderModel.getOrdertype() != null && foodOrderModel.getOrdertype() !=
 * "") { s = s + "@P_orderType='" + foodOrderModel.getOrdertype() + "',"; } if
 * (foodOrderModel.getRestName() != null && foodOrderModel.getRestName() != "")
 * { s = s + "@p_rstId='" + foodOrderModel.getRestName() + "',"; }
 * 
 * if (foodOrderModel.getBookingFor() != null && foodOrderModel.getBookingFor()
 * != "") { s = s + "@p_bookingFor='" + foodOrderModel.getBookingFor() + "',"; }
 * if (foodOrderModel.getBookingForm() != null &&
 * foodOrderModel.getBookingForm() != "") { s = s + "@p_bookingFrom='" +
 * foodOrderModel.getBookingForm() + "',"; } if
 * (foodOrderModel.getTableServiceName() != null &&
 * foodOrderModel.getTableServiceName() != " ") { s = s + "@p_tableId='" +
 * foodOrderModel.getTableServiceName() + "',"; } if (foodOrderModel.getDesc()
 * != null && foodOrderModel.getDesc() != "") { s = s + "@p_desc='" +
 * foodOrderModel.getDesc() + "',"; } String itemparam = ""; List<ItemMenu>
 * items = foodOrderModel.getItemMenu();
 * 
 * for (ItemMenu m : items) { double price = m.getQuantity() * m.getPrice();
 * itemparam = itemparam + "(@P_foId,\"" + m.getItemMealTypeId() + "\",\"" +
 * m.getItemCategoryId() + "\",\"" + m.getItemId() + "\",\"" + price + "\",\"" +
 * m.getQuantity() + "\",\"" + m.getPreferenceId() + "\"),"; } itemparam =
 * itemparam.substring(0, itemparam.length() - 1); s = s + "@p_itemParam='" +
 * itemparam + "',";
 * 
 * if (s != "") { s = s.substring(0, s.length() - 1);
 * 
 * s = "SET " + s + ";"; } return s; }
 * 
 * public static String getAddfoodOrderModelEditParam(FoodOrderModel
 * foodOrderModel) {
 * 
 * String s = "";
 * 
 * String itemparam = ""; List<ItemMenu> items = foodOrderModel.getItemMenu();
 * 
 * for (ItemMenu m : items) { double price = m.getQuantity() * m.getPrice();
 * itemparam = itemparam + "(\"" + foodOrderModel.getOrderId() + "\",\"" +
 * m.getItemMealTypeId() + "\",\"" + m.getItemCategoryId() + "\",\"" +
 * m.getItemId() + "\",\"" + price + "\",\"" + m.getQuantity() + "\",\"" +
 * m.getPreferenceId() + "\"),"; } itemparam = itemparam.substring(0,
 * itemparam.length() - 1); s = s + "@p_itemParam='" + itemparam + "',";
 * 
 * if (s != "") { s = s.substring(0, s.length() - 1);
 * 
 * s = "SET " + s + ";"; } return s; }
 * 
 * }
 */