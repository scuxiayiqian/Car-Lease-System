package scu.sw.car;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateOneCarFromJspServlet extends HttpServlet {
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

		System.out.println("我是UpdateOneCarFromJspServlet");
		response.setContentType("text/html; charset=gb2312");
		request.setCharacterEncoding("gb2312");
		PrintWriter out = response.getWriter();

		
		int id = Integer.parseInt(request.getParameter("id"));
		String carnumber = request.getParameter("carnumber");
		String cartype = request.getParameter("cartype");
		double price = Double.parseDouble(request.getParameter("price"));
		double rentprice = Double.parseDouble(request.getParameter("rentprice"));
		double deposit = Double.parseDouble(request.getParameter("deposit"));
		String description = request.getParameter("description");
		
		System.out.println("收到提交的修改汽车表啦~");
		
		CarsVo carVo = new CarsVo();
		
		carVo.setId(id);
		carVo.setCarnumber(carnumber);
		carVo.setCartype(cartype);
		carVo.setPrice(rentprice);
		carVo.setRentprice(rentprice);
		carVo.setDeposit(deposit);
		carVo.setDescription(description);
		
		UpdateOneCar updateOneCar = new UpdateOneCar();
		updateOneCar.updateOneCar(carVo);

		request.getRequestDispatcher("updateCarSuccess.jsp").forward(request,
				response);

		out.flush();
		out.close();
	}
}
