package scu.sw.checktable;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scu.sw.business.UpdateRentTableFromJsp;

public class AddCheckRecordFromJspServlet extends HttpServlet {
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

		System.out.println("我是AddCheckRecordFromJspServlet");
		response.setContentType("text/html; charset=gb2312");
		request.setCharacterEncoding("gb2312");
		PrintWriter out = response.getWriter();

		Date checkdate = Date.valueOf(request.getParameter("checkdate"));
		String problem = request.getParameter("problem");
		double paying = Double.parseDouble(request.getParameter("paying"));
		int checkuserid = Integer.parseInt(request.getParameter("checkuserid"));
		int rentid = Integer.parseInt(request.getParameter("rentid"));
		String checkid = checkdate + "_" + rentid + "_" + checkuserid;

		AddCheckRecordFromJsp add = new AddCheckRecordFromJsp();
		CheckTableVo tablevo = new CheckTableVo();
		tablevo.setCheckdate(checkdate);
		tablevo.setProblem(problem);
		tablevo.setPaying(paying);
		tablevo.setCheckuserid(checkuserid);
		tablevo.setRentid(rentid);
		tablevo.setCheckid(checkid);
		
		add.addCheckRecord(tablevo);

		request.getRequestDispatcher("addCheckRecordSuccess.jsp").forward(request,
				response);// 转发到showOneRentRecord.jsp页面

		out.flush();
		out.close();
	}
}
