package scu.sw.customers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scu.sw.business.RentTablesVo;
import scu.sw.business.SearchRentFlagByCusId;
import scu.sw.customers.SearchCustomer;

public class SearchCustomerIdentityServlet extends HttpServlet {
	
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

		// 获得页面传递过来的数据
		String identity = request.getParameter("number").toString();// 身份证
		System.out.println("身份证::::" + identity);

		/*
		 * 根据客户身份证查询客户id
		 */
		SearchCustomer searchCustomers = new SearchCustomer();
		int cusrid = searchCustomers.searchCustomer(identity);
		
		if ((cusrid == -1)) {
			System.out.println("客户不存在！");
			request.setAttribute("identity", identity);
			request.getRequestDispatcher("notExistedCustomer.jsp").forward(
					request, response);

			out.flush();
			out.close();
			return;
		}
		
		/*
		 * 根据客户id查询用户未归还的车的renttable信息表
		 */
		SearchRentFlagByCusId searchrentflagbycusid = new SearchRentFlagByCusId();
		List<RentTablesVo> rentRecord = searchrentflagbycusid.searchRentFlagByCusId(cusrid);

		if(rentRecord.isEmpty()) {
			System.out.println("客户" + cusrid + "存在，但并未租车");
			request.setAttribute("identity", identity);
			request.getRequestDispatcher("customerNotRentCar.jsp").forward(
					request, response);

			out.flush();
			out.close();
			return;
		}
		
		else {		
			request.setAttribute("identity", identity);
			request.setAttribute("rentlist", rentRecord);
			request.getRequestDispatcher("showRentRecordsOfOneCustomer.jsp").forward(
					request, response);

			System.out.println("查询客户" + identity + "正在租的车成功！");
			out.flush();
			out.close();
			return;

		}
	}
}
