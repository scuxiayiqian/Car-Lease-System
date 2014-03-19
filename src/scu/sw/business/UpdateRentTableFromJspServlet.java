package scu.sw.business;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class UpdateRentTableFromJspServlet extends HttpServlet {
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

		System.out.println("我是UpdateRentTableFromJspServlet");
		response.setContentType("text/html; charset=gb2312");
		request.setCharacterEncoding("gb2312");
		PrintWriter out = response.getWriter();
		
		String idstring = null;
		idstring = new String(request.getParameter("price"));
		if(idstring.isEmpty()) {
			System.out.println("空的！");
		}
		else {
			System.out.println(idstring);
		}
		
		idstring = request.getParameter("begindate");
		if(idstring.isEmpty()) {
			System.out.println("空的！");
		}
		else {
			System.out.println(idstring);
		}
		
		idstring = request.getParameter("shouldretumdate");
		if(idstring.isEmpty()) {
			System.out.println("空的！");
		}
		else {
			System.out.println(idstring);
		}	
		
		idstring = request.getParameter("id");
		if(idstring.isEmpty()) {
			System.out.println("空的！");
		}
		else {
			System.out.println(idstring);
		}	
		
		int id = Integer.parseInt(request.getParameter("id"));
		double price = Double.parseDouble(request.getParameter("price"));
		Date begindate = Date.valueOf(request.getParameter("begindate"));
		Date shouldretumdate = Date.valueOf(request.getParameter("shouldretumdate"));

		UpdateRentTableFromJsp updateRentTable = new UpdateRentTableFromJsp();
		updateRentTable.updateRentTableFromJsp(id, price, begindate, shouldretumdate);

		request.getRequestDispatcher("updateSuccess.jsp").forward(
				request, response);// 转发到showOneRentRecord.jsp页面

		out.flush();
		out.close();
	}
}
