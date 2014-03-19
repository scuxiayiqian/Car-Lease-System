package scu.sw.car;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCarServlet extends HttpServlet {

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
		CarsVo carsVo = new CarsVo();
		String carnumber= request.getParameter("carnumber");//车号
		String cartype=request.getParameter("cartype");//型号
		String color=request.getParameter("color");//颜色
		double price=Double.parseDouble(request.getParameter("price"));//价值
		double rentprice=Double.parseDouble(request.getParameter("rentprice"));//租金
		double deposit=Double.parseDouble(request.getParameter("deposit"));//押金
		int isrenting=Integer.parseInt(request.getParameter("isrenting"));//租用情况
		String description=request.getParameter("description");//简介
		
		carsVo.setCarnumber(carnumber);
		carsVo.setCartype(cartype);
		carsVo.setColor(color);
		carsVo.setPrice(price);
		carsVo.setRentprice(rentprice);
		carsVo.setDeposit(deposit);
		carsVo.setIsrenting(isrenting);
		carsVo.setDescription(description);
		
		AddCar addCar = new AddCar();
		addCar.addCar(carsVo);//调用添加方法
		response.sendRedirect("ShowCarsServlet");//重定向到查询Servlet
		out.flush();
		out.close();
	}

}
