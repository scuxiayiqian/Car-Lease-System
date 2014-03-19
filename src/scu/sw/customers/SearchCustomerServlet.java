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
		
		//获得页面传递过来的数据
		String identity = request.getParameter("number").toString();//身份证
		int carid = Integer.parseInt(request.getParameter("carid")); //车号
		
		System.out.println("身份证::::" + identity);
		System.out.println("车号::::" + carid);
		
		SearchCustomer searchCustomers = new SearchCustomer();
		SearchCar searchCar = new SearchCar();
		
		int cusrid = searchCustomers.searchCustomer(identity);
		int id = searchCar.searchCar(carid);
		
		System.out.println("cusrid结果返回值" + cusrid);
		System.out.println("id结果返回值" + id);
		
		if((cusrid == -1)&&(id != -1)) {
			System.out.println("客户不存在！");
			request.setAttribute("identity", identity);
			request.getRequestDispatcher("notExistedCustomer.jsp").forward(request, response);
			
			out.flush();
			out.close();	
			return;
		}
		
		else if((id == -1)&&(cusrid != -1)) {
			System.out.println("车号不存在！");
			request.setAttribute("id", carid);
			request.getRequestDispatcher("notExistedCar.jsp").forward(request, response);
			
			out.flush();
			out.close();	
			return;
		}
		
		else if((cusrid == -1)&&(id == -1)) {
			System.out.println("客户和车号都不存在！");
			request.setAttribute("identity", identity);
			request.setAttribute("id", carid);
			request.getRequestDispatcher("notExistedCustomerAndCar.jsp").forward(request, response);
			
			out.flush();
			out.close();	
			return;
		}
		
		else {
			System.out.println("找到客户和车！将客户id传给汽车入库登记界面！");
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
