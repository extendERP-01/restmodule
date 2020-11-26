/**
 * 
 */
package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.inventory.model.RestInventoryStockTransferModel;

/**
 * @author USER
 *
 */
public class GenerateInventoryStockTransferParameter {

	/**
	 * add parameter set for inventory Stock Transfer
	 *
	 **/
	public static String addStockTransfer(List<RestInventoryStockTransferModel> restInventoryStockTransferModel) {

		String s = "";
		String stock = "";
		String transferId = "";
		String fromStore = "";
		String toStore = "";
		String serialNo = "";
		String transferNo = "";
		String transferDate = "";
		Boolean status = null;
		String createdBy = "";
		String description = "";
		Double subTotal = 0.0;
		for (RestInventoryStockTransferModel m : restInventoryStockTransferModel) {
			transferId = m.gettStockTransferId();
			fromStore = m.gettFromStore();
			toStore = m.gettToStore();
			status = m.gettTransferStatus();
			createdBy = m.getCreatedBy();
			serialNo = m.gettSerialNo();
			transferNo = m.gettTransferNo();
			transferDate = DateFormatter.getStringDate(m.gettTransferDate());
			description = m.gettDescription();
			subTotal = m.getSubTotal();
			serialNo = m.gettSerialNo();
		}
		s = s + "@p_transferId='" + transferId + "',";
		s = s + "@p_fromStore='" + fromStore + "',";
		s = s + "@p_toStore='" + toStore + "',";
		s = s + "@p_status=" + status + ",";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_transferNo='" + transferNo + "',";
		s = s + "@p_date='" + transferDate + "',";
		s = s + "@p_desc='" + description + "',";
		s = s + "@p_subTotal='" + subTotal + "',";
		s = s + "@p_serialNo='" + serialNo + "',";
		for (RestInventoryStockTransferModel m : restInventoryStockTransferModel) {

			stock = stock + "(@p_transferId,\"" + m.gettItem() + "\",\"" + m.gettItemDescription() + "\",\""
					+ m.gettItemUnit() + "\"," + m.gettItemQuantity() + "," + m.getTaxRate() + "," + m.getPrice() + ","
					+ m.getTotal() + ",\"" + m.getCreatedBy() + "\"),";
		}
		stock = stock.substring(0, stock.length() - 1);

		s = s + "@p_stockSubQuery='" + stock + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}
}
