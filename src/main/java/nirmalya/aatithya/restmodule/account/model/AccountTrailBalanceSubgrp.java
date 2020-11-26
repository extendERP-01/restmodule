package nirmalya.aatithya.restmodule.account.model;

public class AccountTrailBalanceSubgrp {

	private String ledgerId;
	private String costCenter;
	private String accountHeadId;
	private Double debitBal;
	private Double creditVal;
	private Double remainingBal;
	private Double totalDebit;
	private Double totalCredit;
	private String desc;
	private String itemName;
	private String itemId;
	private String grnNumber;
	private String grnId;
	
	public AccountTrailBalanceSubgrp(Object ledgerId,Object costCenter, Object accountHeadId, Object debitBal, Object creditVal,
			Object remainingBal, Object totalDebit, Object totalCredit, Object desc, Object itemName, Object itemId,
			Object grnNumber, Object grnId) {
		super();
		try{
			this.costCenter = (String) costCenter;
		}catch(Exception e) {
			e.printStackTrace();
		}
		try{
			this.accountHeadId = (String) accountHeadId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		try{
			this.debitBal = (Double) debitBal;
		}catch(Exception e) {
			e.printStackTrace();
		}
		try{
			this.creditVal = (Double) creditVal;
		}catch(Exception e) {
			e.printStackTrace();
		}
		try{
			this.remainingBal = (Double) remainingBal;
		}catch(Exception e) {
			e.printStackTrace();
		}
		try{
			this.totalDebit = (Double) totalDebit;
		}catch(Exception e) {
			e.printStackTrace();
		}
		try{
			this.totalCredit = (Double) totalCredit;
		}catch(Exception e) {
			e.printStackTrace();
		}
		try{
			this.desc = (String) desc;
		}catch(Exception e) {
			e.printStackTrace();
		}
		try{
			this.itemName = (String) itemName;
		}catch(Exception e) {
			e.printStackTrace();
		}
		try{
			this.itemId = (String) itemId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		try{
			this.grnNumber = (String) grnNumber;
		}catch(Exception e) {
			e.printStackTrace();
		}
		try{
			this.grnId = (String) grnId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		try{
			this.ledgerId = (String) ledgerId;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public AccountTrailBalanceSubgrp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCostCenter() {
		return costCenter;
	}
	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}
	public String getAccountHeadId() {
		return accountHeadId;
	}
	public void setAccountHeadId(String accountHeadId) {
		this.accountHeadId = accountHeadId;
	}
	public Double getDebitBal() {
		return debitBal;
	}
	public void setDebitBal(Double debitBal) {
		this.debitBal = debitBal;
	}
	public Double getCreditVal() {
		return creditVal;
	}
	public void setCreditVal(Double creditVal) {
		this.creditVal = creditVal;
	}
	public Double getRemainingBal() {
		return remainingBal;
	}
	public void setRemainingBal(Double remainingBal) {
		this.remainingBal = remainingBal;
	}
	public Double getTotalDebit() {
		return totalDebit;
	}
	public void setTotalDebit(Double totalDebit) {
		this.totalDebit = totalDebit;
	}
	public Double getTotalCredit() {
		return totalCredit;
	}
	public void setTotalCredit(Double totalCredit) {
		this.totalCredit = totalCredit;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getGrnNumber() {
		return grnNumber;
	}
	public void setGrnNumber(String grnNumber) {
		this.grnNumber = grnNumber;
	}
	public String getGrnId() {
		return grnId;
	}
	public void setGrnId(String grnId) {
		this.grnId = grnId;
	}
	public String getLedgerId() {
		return ledgerId;
	}
	public void setLedgerId(String ledgerId) {
		this.ledgerId = ledgerId;
	}
	
}
