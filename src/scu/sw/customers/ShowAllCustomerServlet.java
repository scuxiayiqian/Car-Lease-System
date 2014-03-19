package scu.sw.customers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowAllCustomerServlet extends HttpServlet {

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
		List<customersVo> list = new ArrayList<customersVo>();
		ShowAllCustomer allCustomer = new ShowAllCustomer();
		
		list = allCustomer.showAllCustomers();//调用查询方法
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("showCustomer.jsp").forward(request, response);
		
		System.out.println("查询到所有客户信息并转发给showUsers.jsp页面");
		out.flush();
		out.close();
	}


}
