package scu.sw.car;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowOneCarServlet extends HttpServlet {
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

		String idstring = new String(request.getParameter("id").getBytes(
				"ISO-8859-1"), "gb2312");
		if (idstring.isEmpty()) {
			System.out.println("空的！");
		}

		int id = Integer.parseInt(idstring);

		ShowOneCar showOneCar = new ShowOneCar();
		CarsVo carVo = showOneCar.showOneCar(id);

		request.setAttribute("vo", carVo);
		request.getRequestDispatcher("showOneCar.jsp").forward(request,
				response);// 转发到showOneRentRecord.jsp页面

		out.flush();
		out.close();
	}
}
