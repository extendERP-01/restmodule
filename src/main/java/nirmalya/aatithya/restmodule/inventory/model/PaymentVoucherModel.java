package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PaymentVoucherModel {

	private String vendorId;
	private String vendorName;
	private String fromDate;
	private String toDate;
	private String poNumber;
	private String grnNo;
	private String invNo;
	private Double subTotal;
	private Double discount;
	private Double total;
	private String paidFrom;
	private String paymentMode;
	private Double sgst;
	private Double cgst;
	private Double igst;
	private Boolean taxType;
	private Double tdsRate;
	private Double tdsAmount;
	private String goodsReturnNote;
	private Double returnQuanity;
	private Double returnPrice;
	private String resturnDesc;
	private Double returnCgst;
	private Double returnSgst;
	private Double returnIgst;
	private Double returnDiscount;
	private Double returnTotal;
	private String bankName;
	private String branchName;
	private String accNo;
	private String chequeNo;
	private String transNo;
	private String transactionDate;
	private String createdBy;
	private String refno;
	private String paymentVoucher;
	private String verndorAddrs;
	private String venderGstNo;
	private String vendorMobile;
	private String vendorEmail;
	private String hotelName;
	private String hotelAddr;
	private String hotelEmail;
	private String hotelMob;
	private String gstNo;
	private Double grnSubtotal;
	private Double grnTotal;
	private Double taxRate;
	private String scheduleDate;
	private String dueDate;
	private Boolean aproveStaus;
	private Boolean activeStatus;
	private Double outstandingAmount;
	private Boolean paymentType;
	private Double partialAmt;
	private Boolean paymentStatus;
	private Double cessAmt;

	public PaymentVoucherModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentVoucherModel(Object vendorId, Object poNumber, Object grnNo, Object invNo, Object subTotal,
			Object discount, Object total, Object sgst, Object cgst, Object igst, Object taxType, Object tdsRate,
			Object tdsAmount, Object goodsReturnNote, Object returnQuanity, Object returnPrice, Object resturnDesc,
			Object returnCgst, Object returnSgst, Object returnIgst, Object returnDiscount, Object returnTotal,
			Object transactionDate, Object vendorName, Object refno, Object bankName, Object branchName, Object accNo,
			Object chequeNo, Object transNo, Object paymentVoucher, Object verndorAddrs, Object venderGstNo,
			Object vendorMobile, Object vendorEmail, Object hotelName, Object hotelAddr, Object hotelEmail,
			Object hotelMob, Object gstNo, Object grnSubtotal, Object grnTotal, Object taxRate, Object scheduleDate,
			Object dueDate, Object aproveStaus, Object activeStatus, Object paymentMode, Object outstandingAmount,
			Object paymentType, Object paymentStatus, Object cessAmt) {
		super();
		try {
			this.vendorId = (String) vendorId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.poNumber = (String) poNumber;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.grnNo = (String) grnNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.invNo = (String) invNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.subTotal = (Double) subTotal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.discount = (Double) discount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.total = (Double) total;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.sgst = (Double) sgst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.cgst = (Double) cgst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.igst = (Double) igst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.taxType = (Boolean) taxType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tdsRate = (Double) tdsRate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tdsAmount = (Double) tdsAmount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.goodsReturnNote = (String) goodsReturnNote;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.returnQuanity = (Double) returnQuanity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.returnPrice = (Double) returnPrice;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.resturnDesc = (String) resturnDesc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.returnCgst = (Double) returnCgst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.returnSgst = (Double) returnSgst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.returnIgst = (Double) returnIgst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.returnDiscount = (Double) returnDiscount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.returnTotal = (Double) returnTotal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.transactionDate = (String) transactionDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.vendorName = (String) vendorName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.refno = (String) refno;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.bankName = (String) bankName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.branchName = (String) branchName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.accNo = (String) accNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.chequeNo = (String) chequeNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.transNo = (String) transNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.paymentVoucher = (String) paymentVoucher;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.verndorAddrs = (String) verndorAddrs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.venderGstNo = (String) venderGstNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.vendorMobile = (String) vendorMobile;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.vendorEmail = (String) vendorEmail;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.hotelName = (String) hotelName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.hotelAddr = (String) hotelAddr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.hotelEmail = (String) hotelEmail;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.hotelMob = (String) hotelMob;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.gstNo = (String) gstNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.grnSubtotal = (Double) grnSubtotal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.grnTotal = (Double) grnTotal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.taxRate = (Double) taxRate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.scheduleDate = (String) scheduleDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.dueDate = (String) dueDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.aproveStaus = (Boolean) aproveStaus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.activeStatus = (Boolean) activeStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.paymentMode = (String) paymentMode;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.outstandingAmount = (Double) outstandingAmount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.paymentType = (Boolean) paymentType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.paymentStatus = (Boolean) paymentStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.cessAmt = (Double) cessAmt;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Double getSgst() {
		return sgst;
	}

	public void setSgst(Double sgst) {
		this.sgst = sgst;
	}

	public Double getCgst() {
		return cgst;
	}

	public void setCgst(Double cgst) {
		this.cgst = cgst;
	}

	public Double getIgst() {
		return igst;
	}

	public void setIgst(Double igst) {
		this.igst = igst;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public String getGrnNo() {
		return grnNo;
	}

	public void setGrnNo(String grnNo) {
		this.grnNo = grnNo;
	}

	public String getInvNo() {
		return invNo;
	}

	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getPaidFrom() {
		return paidFrom;
	}

	public void setPaidFrom(String paidFrom) {
		this.paidFrom = paidFrom;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Double getTdsRate() {
		return tdsRate;
	}

	public Boolean getTaxType() {
		return taxType;
	}

	public void setTaxType(Boolean taxType) {
		this.taxType = taxType;
	}

	public void setTdsRate(Double tdsRate) {
		this.tdsRate = tdsRate;
	}

	public Double getTdsAmount() {
		return tdsAmount;
	}

	public void setTdsAmount(Double tdsAmount) {
		this.tdsAmount = tdsAmount;
	}

	public String getGoodsReturnNote() {
		return goodsReturnNote;
	}

	public void setGoodsReturnNote(String goodsReturnNote) {
		this.goodsReturnNote = goodsReturnNote;
	}

	public Double getReturnQuanity() {
		return returnQuanity;
	}

	public void setReturnQuanity(Double returnQuanity) {
		this.returnQuanity = returnQuanity;
	}

	public Double getReturnPrice() {
		return returnPrice;
	}

	public void setReturnPrice(Double returnPrice) {
		this.returnPrice = returnPrice;
	}

	public String getResturnDesc() {
		return resturnDesc;
	}

	public void setResturnDesc(String resturnDesc) {
		this.resturnDesc = resturnDesc;
	}

	public Double getReturnCgst() {
		return returnCgst;
	}

	public void setReturnCgst(Double returnCgst) {
		this.returnCgst = returnCgst;
	}

	public Double getReturnSgst() {
		return returnSgst;
	}

	public void setReturnSgst(Double returnSgst) {
		this.returnSgst = returnSgst;
	}

	public Double getReturnIgst() {
		return returnIgst;
	}

	public void setReturnIgst(Double returnIgst) {
		this.returnIgst = returnIgst;
	}

	public Double getReturnDiscount() {
		return returnDiscount;
	}

	public void setReturnDiscount(Double returnDiscount) {
		this.returnDiscount = returnDiscount;
	}

	public Double getReturnTotal() {
		return returnTotal;
	}

	public void setReturnTotal(Double returnTotal) {
		this.returnTotal = returnTotal;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getTransNo() {
		return transNo;
	}

	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getRefno() {
		return refno;
	}

	public void setRefno(String refno) {
		this.refno = refno;
	}

	public String getPaymentVoucher() {
		return paymentVoucher;
	}

	public void setPaymentVoucher(String paymentVoucher) {
		this.paymentVoucher = paymentVoucher;
	}

	public String getVerndorAddrs() {
		return verndorAddrs;
	}

	public void setVerndorAddrs(String verndorAddrs) {
		this.verndorAddrs = verndorAddrs;
	}

	public String getVenderGstNo() {
		return venderGstNo;
	}

	public void setVenderGstNo(String venderGstNo) {
		this.venderGstNo = venderGstNo;
	}

	public String getVendorMobile() {
		return vendorMobile;
	}

	public void setVendorMobile(String vendorMobile) {
		this.vendorMobile = vendorMobile;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelAddr() {
		return hotelAddr;
	}

	public void setHotelAddr(String hotelAddr) {
		this.hotelAddr = hotelAddr;
	}

	public String getHotelEmail() {
		return hotelEmail;
	}

	public void setHotelEmail(String hotelEmail) {
		this.hotelEmail = hotelEmail;
	}

	public String getHotelMob() {
		return hotelMob;
	}

	public void setHotelMob(String hotelMob) {
		this.hotelMob = hotelMob;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public Double getGrnSubtotal() {
		return grnSubtotal;
	}

	public void setGrnSubtotal(Double grnSubtotal) {
		this.grnSubtotal = grnSubtotal;
	}

	public Double getGrnTotal() {
		return grnTotal;
	}

	public void setGrnTotal(Double grnTotal) {
		this.grnTotal = grnTotal;
	}

	public Double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public Boolean getAproveStaus() {
		return aproveStaus;
	}

	public void setAproveStaus(Boolean aproveStaus) {
		this.aproveStaus = aproveStaus;
	}

	public Boolean getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Double getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(Double outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public Boolean getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Boolean paymentType) {
		this.paymentType = paymentType;
	}

	public Double getPartialAmt() {
		return partialAmt;
	}

	public void setPartialAmt(Double partialAmt) {
		this.partialAmt = partialAmt;
	}

	public Boolean getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Double getCessAmt() {
		return cessAmt;
	}

	public void setCessAmt(Double cessAmt) {
		this.cessAmt = cessAmt;
	}

	@Override
	public String toString() {
		ObjectMapper mapperObj = new ObjectMapper();
		String jsonStr;
		try {
			jsonStr = mapperObj.writeValueAsString(this);
		} catch (IOException ex) {

			jsonStr = ex.toString();
		}
		return jsonStr;
	}

}
