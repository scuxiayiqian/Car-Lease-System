package scu.sw.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateOneUserFromJspServlet extends HttpServlet {
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

		System.out.println("我是UpdateRentTableFromJspServlet");
		response.setContentType("text/html; charset=gb2312");
		request.setCharacterEncoding("gb2312");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));
		String fullname = new String(request.getParameter("fullname"));
		String position = new String(request.getParameter("position"));
		String phone = new String(request.getParameter("phone"));
		String address = new String(request.getParameter("address"));
		String identity = new String(request.getParameter("identity"));
		String username = new String(request.getParameter("username"));
		
		UsersVo uservo = new UsersVo();
		uservo.setId(id);
		uservo.setFullname(fullname);
		uservo.setPosition(position);
		uservo.setPhone(phone);
		uservo.setAddress(address);
		uservo.setIdentity(identity);
		uservo.setUsername(username);
		
		UpdateOneUser updateuser = new UpdateOneUser();
		updateuser.updateUser(uservo);

		request.getRequestDispatcher("updateUserSuccess.jsp").forward(request,
				response);// 转发到showOneRentRecord.jsp页面

		out.flush();
		out.close();
	}
}
