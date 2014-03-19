package scu.sw.checktable;

import java.sql.Date;

public class CheckTableVo {
	int id;
	String checkid;
	Date checkdate;
	String field;  // Ù–‘
	String problem;
	double paying;
	int checkuserid;
	int rentid;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCheckid() {
		return checkid;
	}
	public void setCheckid(String checkid) {
		this.checkid = checkid;
	}
	public Date getCheckdate() {
		return checkdate;
	}
	public void setCheckdate(Date checkdate) {
		this.checkdate = checkdate;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public double getPaying() {
		return paying;
	}
	public void setPaying(double paying) {
		this.paying = paying;
	}
	public int getCheckuserid() {
		return checkuserid;
	}
	public void setCheckuserid(int checkuserid) {
		this.checkuserid = checkuserid;
	}
	public int getRentid() {
		return rentid;
	}
	public void setRentid(int rentid) {
		this.rentid = rentid;
	}
	
	
}
