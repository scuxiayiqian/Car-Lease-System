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
		String carnumber= request.getParameter("carnumber");//����
		String cartype=request.getParameter("cartype");//�ͺ�
		String color=request.getParameter("color");//��ɫ
		double price=Double.parseDouble(request.getParameter("price"));//��ֵ
		double rentprice=Double.parseDouble(request.getParameter("rentprice"));//���
		double deposit=Double.parseDouble(request.getParameter("deposit"));//Ѻ��
		int isrenting=Integer.parseInt(request.getParameter("isrenting"));//�������
		String description=request.getParameter("description");//���
		
		carsVo.setCarnumber(carnumber);
		carsVo.setCartype(cartype);
		carsVo.setColor(color);
		carsVo.setPrice(price);
		carsVo.setRentprice(rentprice);
		carsVo.setDeposit(deposit);
		carsVo.setIsrenting(isrenting);
		carsVo.setDescription(description);
		
		AddCar addCar = new AddCar();
		addCar.addCar(carsVo);//������ӷ���
		response.sendRedirect("ShowCarsServlet");//�ض��򵽲�ѯServlet
		out.flush();
		out.close();
	}

}
