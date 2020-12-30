package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AccountCashBookModel {
	private String cdate;
	private String cvoucherNO;
	private String cdesc;
	private double camount;
	private String ddate;
	private String dvoucherNO;
	private String ddesc;
	private double damount;
	public AccountCashBookModel(Object cdate, Object cvoucherNO, Object cdesc, Object camount, Object ddate,
			Object dvoucherNO, Object ddesc, Object damount) {
		super();
		this.cdate = (String) cdate;
		this.cvoucherNO = (String) cvoucherNO;
		this.cdesc = (String) cdesc;
		this.camount = (double) camount;
		this.ddate = (String) ddate;
		this.dvoucherNO = (String) dvoucherNO;
		this.ddesc = (String) ddesc;
		this.damount = (double) damount;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getCvoucherNO() {
		return cvoucherNO;
	}
	public void setCvoucherNO(String cvoucherNO) {
		this.cvoucherNO = cvoucherNO;
	}
	public String getCdesc() {
		return cdesc;
	}
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}
	public double getCamount() {
		return camount;
	}
	public void setCamount(double camount) {
		this.camount = camount;
	}
	public String getDdate() {
		return ddate;
	}
	public void setDdate(String ddate) {
		this.ddate = ddate;
	}
	public String getDvoucherNO() {
		return dvoucherNO;
	}
	public void setDvoucherNO(String dvoucherNO) {
		this.dvoucherNO = dvoucherNO;
	}
	public String getDdesc() {
		return ddesc;
	}
	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
	}
	public double getDamount() {
		return damount;
	}
	public void setDamount(double damount) {
		this.damount = damount;
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
