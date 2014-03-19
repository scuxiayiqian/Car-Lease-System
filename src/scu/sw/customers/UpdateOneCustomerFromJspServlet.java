package scu.sw.customers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateOneCustomerFromJspServlet extends HttpServlet {
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

		System.out.println("Œ“ «UpdateOneCustomerFromJspServlet");
		response.setContentType("text/html; charset=gb2312");
		request.setCharacterEncoding("gb2312");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String custname = new String(request.getParameter("custname"));
		String address = new String(request.getParameter("address"));
		String phone = new String(request.getParameter("phone"));
		String career = new String(request.getParameter("career"));

		customersVo vo = new customersVo();
		
		vo.setId(id);
		vo.setCustname(custname);
		vo.setAddress(address);
		vo.setPhone(phone);
		vo.setCareer(career);

		UpdateOneCustomer updateOneCustomer = new UpdateOneCustomer();
		updateOneCustomer.updateCustomer(vo);

		request.getRequestDispatcher("updateCustomerSuccess.jsp").forward(request,
				response);
		
		out.flush();
		out.close();
	}
}
