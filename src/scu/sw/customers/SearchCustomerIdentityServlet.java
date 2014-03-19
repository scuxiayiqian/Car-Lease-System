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

		// ���ҳ�洫�ݹ���������
		String identity = request.getParameter("number").toString();// ���֤
		System.out.println("���֤::::" + identity);

		/*
		 * ���ݿͻ����֤��ѯ�ͻ�id
		 */
		SearchCustomer searchCustomers = new SearchCustomer();
		int cusrid = searchCustomers.searchCustomer(identity);
		
		if ((cusrid == -1)) {
			System.out.println("�ͻ������ڣ�");
			request.setAttribute("identity", identity);
			request.getRequestDispatcher("notExistedCustomer.jsp").forward(
					request, response);

			out.flush();
			out.close();
			return;
		}
		
		/*
		 * ���ݿͻ�id��ѯ�û�δ�黹�ĳ���renttable��Ϣ��
		 */
		SearchRentFlagByCusId searchrentflagbycusid = new SearchRentFlagByCusId();
		List<RentTablesVo> rentRecord = searchrentflagbycusid.searchRentFlagByCusId(cusrid);

		if(rentRecord.isEmpty()) {
			System.out.println("�ͻ�" + cusrid + "���ڣ�����δ�⳵");
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

			System.out.println("��ѯ�ͻ�" + identity + "������ĳ��ɹ���");
			out.flush();
			out.close();
			return;

		}
	}
}
