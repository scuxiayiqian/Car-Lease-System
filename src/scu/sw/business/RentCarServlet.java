package scu.sw.business;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import scu.sw.car.UpdateCarIsRenting;
import scu.sw.car.CarsVo;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RentCarServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=gb2312");
		PrintWriter out = response.getWriter();
		this.doPost(request, response);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=gb2312");
		request.setCharacterEncoding("gb2312");

		PrintWriter out = response.getWriter();
		System.out.println("bbb");
		
		
		int cusrid = Integer.parseInt(request.getParameter("cusrid"));
		
		System.out.println("aaa");
		System.out.println(cusrid);
		
		
		int carsid = Integer.parseInt(request.getParameter("carsid"));
		double imprest = Double.parseDouble(request.getParameter("imprest"));
		double shouldpayprice = Double.parseDouble(request.getParameter("shouldpayprice"));
		double price = Double.parseDouble(request.getParameter("price"));
		Date begindate = Date.valueOf(request.getParameter("begindate"));
		Date shouldretumdate = Date.valueOf(request.getParameter("shouldretumdate"));
		int userid = Integer.parseInt(request.getParameter("number"));
		
		RentTablesVo renttable = new RentTablesVo();
		renttable.setCusrid(cusrid);
		renttable.setCarsid(carsid);
		renttable.setImprest(imprest);
		renttable.setShouldpayprice(shouldpayprice);
		renttable.setPrice(price);
		renttable.setBegindate(begindate);
		renttable.setShouldretumdate(shouldretumdate);
		renttable.setUserid(userid);
		renttable.setRentflag(1);
		
		String cus = String.valueOf(cusrid);
		String car = String.valueOf(carsid);
		String user = String.valueOf(userid);
		String bdate = String.valueOf(begindate);
		String tag = "_";
		renttable.setTableid(cus + tag + car + tag + user + tag + bdate);

		RentCar rentcar = new RentCar();
		rentcar.rentCar(renttable);
		
		UpdateCarIsRenting updateIsRenting = new UpdateCarIsRenting();
		CarsVo carvo = new CarsVo();
		carvo.setIsrenting(1);
		carvo.setId(carsid);
		updateIsRenting.updateCarIsRenting(carvo);
		
		request.setAttribute("rentTableVo", renttable);
		request.getRequestDispatcher("showRentTabeMsg.jsp").forward(request, response);//转发到页面
		
	//	response.sendRedirect("ShowCarsServlet");// 重定向到查询Servlet
		System.out.println("将出租表信息转发至showRentTabeMsg.jsp界面！");
		out.flush();
		out.close();
	}
}
