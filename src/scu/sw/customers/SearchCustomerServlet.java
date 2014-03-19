package scu.sw.customers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import scu.sw.car.SearchCar;
import scu.sw.car.SearchRentPriceAndDeposit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchCustomerServlet extends HttpServlet {
	
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
		
		//���ҳ�洫�ݹ���������
		String identity = request.getParameter("number").toString();//���֤
		int carid = Integer.parseInt(request.getParameter("carid")); //����
		
		System.out.println("���֤::::" + identity);
		System.out.println("����::::" + carid);
		
		SearchCustomer searchCustomers = new SearchCustomer();
		SearchCar searchCar = new SearchCar();
		
		int cusrid = searchCustomers.searchCustomer(identity);
		int id = searchCar.searchCar(carid);
		
		System.out.println("cusrid�������ֵ" + cusrid);
		System.out.println("id�������ֵ" + id);
		
		if((cusrid == -1)&&(id != -1)) {
			System.out.println("�ͻ������ڣ�");
			request.setAttribute("identity", identity);
			request.getRequestDispatcher("notExistedCustomer.jsp").forward(request, response);
			
			out.flush();
			out.close();	
			return;
		}
		
		else if((id == -1)&&(cusrid != -1)) {
			System.out.println("���Ų����ڣ�");
			request.setAttribute("id", carid);
			request.getRequestDispatcher("notExistedCar.jsp").forward(request, response);
			
			out.flush();
			out.close();	
			return;
		}
		
		else if((cusrid == -1)&&(id == -1)) {
			System.out.println("�ͻ��ͳ��Ŷ������ڣ�");
			request.setAttribute("identity", identity);
			request.setAttribute("id", carid);
			request.getRequestDispatcher("notExistedCustomerAndCar.jsp").forward(request, response);
			
			out.flush();
			out.close();	
			return;
		}
		
		else {
			System.out.println("�ҵ��ͻ��ͳ������ͻ�id�����������Ǽǽ��棡");
			SearchRentPriceAndDeposit search = new SearchRentPriceAndDeposit();
			int isrenting = searchCar.searchIsRenting(id);
			
			if(isrenting == 1) {
				System.out.println("from searchcustomerservlet: isrenting==1");
				request.setAttribute("id", id);
				request.getRequestDispatcher("carAlreadyRenting.jsp").forward(request, response);
				
				out.flush();
				out.close();	
				return;
			}
			
			else {
				System.out.println("from searchcustomerservlet: isrenting!=1");
				List<Double> list = search.searchRentPriceAndDeposit(id);
				request.setAttribute("cusrid", cusrid);				
				System.out.println(cusrid);
				request.setAttribute("id", id);				
				System.out.println(id);
				
				request.setAttribute("rentprice", list.get(0));
				System.out.println(list.get(0));
				request.setAttribute("deposit", list.get(1));
				System.out.println(list.get(1));
				
				request.getRequestDispatcher("business_carRent.jsp").forward(request, response);
			}		
		}		
		out.flush();
		out.close();		
	}
}
