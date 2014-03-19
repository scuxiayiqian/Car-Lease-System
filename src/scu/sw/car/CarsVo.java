package scu.sw.car;

public class CarsVo {
	private int id;//编号
	private String carnumber;//车号
	private String cartype;//型号
	private String color;//颜色
	private double price;//价值
	private double rentprice;//租金
	private double deposit;//押金
	private int isrenting;//租用情况
	private String description;//简介
	public String getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setIsrenting(int isrenting) {
		this.isrenting = isrenting;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getRentprice() {
		return rentprice;
	}
	public void setRentprice(double rentprice) {
		this.rentprice = rentprice;
	}
	public int getIsrenting() {
		return isrenting;
	}
	


}
