package scu.sw.checktable;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCheckRecordServlet extends HttpServlet {
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

		// 得到要归还的车的renttable的id
		// int id = Integer.parseInt(request.getParameter("id"));

		String idstring = new String(request.getParameter("id").getBytes(
				"ISO-8859-1"), "gb2312");
		if (idstring.isEmpty()) {
			System.out.println("空的！");
		}
		int id = Integer.parseInt(idstring);
		System.out.println("AddCheckRecordServlet得到出租单编号：" + id);
		
		SimpleDateFormat returndate = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilrerumdate = null;
		try {
			utilrerumdate= returndate.parse(returndate.format(new java.util.Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date today = new Date(utilrerumdate.getTime());
		
		request.setAttribute("rentid", id);
		request.setAttribute("today", today);
		request.getRequestDispatcher("addCheckRecord.jsp")
				.forward(request, response);// 转发到页面

		out.flush();
		out.close();
	}
}
