package scu.sw.business;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchReturnWithinOneMonthServlet extends HttpServlet {
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

		SearchReturnWithinOneMonth searchReturnWithinOneMonth = new SearchReturnWithinOneMonth();
		List<RentTablesVo> list = searchReturnWithinOneMonth.searchReturnWithinOneMonth();

		request.setAttribute("rentRecord", list);
		request.getRequestDispatcher("searchReturnWithinOneMonth.jsp").forward(request,
				response);// ת����ҳ��

		System.out.println("�����е���Ӧ������ת����searchReturnWithinOneMonth.jsp���棡");
		out.flush();
		out.close();
	}
}
