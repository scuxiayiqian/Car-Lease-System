package scu.sw.business;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scu.sw.car.CarsVo;
import scu.sw.car.UpdateCarIsRenting;
import scu.sw.customers.SearchCustomerIdByRentTalesId;
import scu.sw.customers.SearchCustomerIdentityByCusrid;

public class ReturnCarServlet extends HttpServlet {
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
		
		System.out.println("到ReturnCarServlet啦~");
		
	//  得到要归还的车的renttable的id
	//	int id = Integer.parseInt(request.getParameter("id"));
		
		String idstring = new String(request.getParameter("id")
				.getBytes("ISO-8859-1"), "gb2312");	
		if(idstring.isEmpty()) {
			System.out.println("空的！");
		}
		int id = Integer.parseInt(idstring);
		
		System.out.println("ReturnCarServlet得到出租单编号：" + id);

		//将renttable的rentflag设为0
		RentTablesVo renttable = new RentTablesVo();
		renttable.setId(id);
		renttable.setRentflag(0);
		ReturnCar returncar = new ReturnCar();
		returncar.updateRenttable(renttable);

		//将car的isrenting设为0
		SearchCaridByRentTableId searchCarIdByRentId = new SearchCaridByRentTableId();
		int carsid = searchCarIdByRentId.searchCaridByRentId(id);
		UpdateCarIsRenting updateIsRenting = new UpdateCarIsRenting();
		CarsVo carvo = new CarsVo();
		carvo.setIsrenting(0);
		carvo.setId(carsid);
		updateIsRenting.updateCarIsRenting(carvo);

		//根据此次的renttable的id查找客户号
		SearchCustomerIdByRentTalesId searchCustomerIdByRentTalesId = new SearchCustomerIdByRentTalesId();
		int cusrid = searchCustomerIdByRentTalesId.searchCustomerIdByRentTalesId(id);
		
		//查询该客户是否还有其他没还的车
		List<RentTablesVo> anyOtherRentRecord = null;
		SearchIsThereMoreRentRecordOfACustomer ismore = new SearchIsThereMoreRentRecordOfACustomer();
		anyOtherRentRecord = ismore.searchIsThereMoreRentRecordOfACustomer(cusrid);
		if(anyOtherRentRecord.isEmpty()) {
			request.setAttribute("cusrid", cusrid);
			request.getRequestDispatcher("noMoreRentRecords.jsp").forward(request,
					response);// 转发到页面
			
			out.flush();
			out.close();
			return;
		}
		else {
			SearchCustomerIdentityByCusrid s = new SearchCustomerIdentityByCusrid();
			String identity = s.searchCustomerIdentityByCusrid(cusrid);
			request.setAttribute("identity", identity);
			request.setAttribute("rentlist", anyOtherRentRecord);
			request.getRequestDispatcher("ShowRemainRecordOfOntCustomer.jsp").forward(request,
					response);// 转发到页面
		}
		
		out.flush();
		out.close();
	}
}
