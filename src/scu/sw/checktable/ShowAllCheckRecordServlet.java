package scu.sw.checktable;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scu.sw.car.CarsVo;
import scu.sw.car.ShowCars;

public class ShowAllCheckRecordServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=gb2312");
		PrintWriter out = response.getWriter();
		this.doPost(request, response);// ����doPost����
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=gb2312");
		request.setCharacterEncoding("gb2312");
		PrintWriter out = response.getWriter();
		
		ShowAllCheckRecord showAllCheckRecord = new ShowAllCheckRecord();
		List<CheckTableVo> list = showAllCheckRecord.showAllCheckRecord();
	
		request.setAttribute("allCheckRecord", list);
		request.getRequestDispatcher("checkTableManagement.jsp").forward(request, response);// ת����ҳ��

		System.out.println("��ѯ�����м�鵥��Ϣ��ת����checkTableManagement.jspҳ��");
		out.flush();
		out.close();
	}
}