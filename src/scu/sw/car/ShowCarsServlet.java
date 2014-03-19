package scu.sw.car;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowCarsServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=gb2312");
		PrintWriter out = response.getWriter();
		this.doPost(request, response);//����doPost����
		out.flush();
		out.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=gb2312");
		request.setCharacterEncoding("gb2312");
		PrintWriter out = response.getWriter();
		ShowCars showCars = new ShowCars();
		List<CarsVo> list = new ArrayList<CarsVo>();

		list = showCars.showAllCars();//���ò�ѯ����
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("showCars.jsp").forward(request, response);//ת����ҳ��
		
		System.out.println("��ѯ������������Ϣ��ת����showCars.jspҳ��");
		out.flush();
		out.close();
	}

}
