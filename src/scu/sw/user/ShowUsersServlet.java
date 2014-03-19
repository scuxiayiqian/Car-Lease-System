package scu.sw.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowUsersServlet extends HttpServlet {

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
		ShowUsers showUsers = new ShowUsers();
		List<UsersVo> list = new ArrayList<UsersVo>();
		
		list = showUsers.showAllUsers();//���ò�ѯ����
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("showUsers.jsp").forward(request, response);
		
		System.out.println("��ѯ�������û���Ϣ��ת����showUsers.jspҳ��");
		out.flush();
		out.close();
	}
}
