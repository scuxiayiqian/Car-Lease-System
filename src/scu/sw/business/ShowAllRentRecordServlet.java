package scu.sw.business;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ShowAllRentRecordServlet extends HttpServlet {
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
		
		ShowAllRentRecord showAllRentRecord = new ShowAllRentRecord();
		List<RentTablesVo> rentRecord = showAllRentRecord.showAllRentRecord();

		request.setAttribute("rentRecord", rentRecord);
		request.getRequestDispatcher("showAllRentRecord.jsp").forward(request,
				response);// ת����ҳ��

		System.out.println("������rentflag == 1�ĳ������Ϣת����showAllRentRecord.jsp���棡");
		out.flush();
		out.close();
	}
}
