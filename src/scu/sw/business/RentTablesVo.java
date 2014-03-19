package scu.sw.business;

import java.sql.Date;

public class RentTablesVo {
	int id;
	String tableid;
	double imprest;
	double shouldpayprice;
	double price;
	Date begindate;
	Date shouldretumdate;
	Date rerumdate;
	int rentflag;
	int cusrid;
	int carsid;
	int userid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTableid() {
		return tableid;
	}
	public void setTableid(String tableid) {
		this.tableid = tableid;
	}
	public double getImprest() {
		return imprest;
	}
	public void setImprest(double imprest) {
		this.imprest = imprest;
	}
	public double getShouldpayprice() {
		return shouldpayprice;
	}
	public void setShouldpayprice(double shouldpayprice) {
		this.shouldpayprice = shouldpayprice;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getBegindate() {
		return begindate;
	}
	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}
	public Date getShouldretumdate() {
		return shouldretumdate;
	}
	public void setShouldretumdate(Date shouldretumdate) {
		this.shouldretumdate = shouldretumdate;
	}
	public Date getRerumdate() {
		return rerumdate;
	}
	public void setRerumdate(Date rerumdate) {
		this.rerumdate = rerumdate;
	}
	public int getRentflag() {
		return rentflag;
	}
	public void setRentflag(int rentflag) {
		this.rentflag = rentflag;
	}
	public int getCusrid() {
		return cusrid;
	}
	public void setCusrid(int cusrid) {
		this.cusrid = cusrid;
	}
	public int getCarsid() {
		return carsid;
	}
	public void setCarsid(int carsid) {
		this.carsid = carsid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}	
}
