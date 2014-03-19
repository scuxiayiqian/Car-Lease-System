package scu.sw.business;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteRentTableFromJspServlet extends HttpServlet {
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

		String idstring = new String(request.getParameter("id").getBytes(
				"ISO-8859-1"), "gb2312");
		if (idstring.isEmpty()) {
			System.out.println("�գ�");
		}
		int id = Integer.parseInt(idstring);

		DeleteRentTable deleteRentTable = new DeleteRentTable();
		deleteRentTable.deleteOneRentRecordById(id);

		request.getRequestDispatcher("deleteOneRentRecordByIdSuccess.jsp").forward(request,
				response);// ת����showOneRentRecord.jspҳ��

		out.flush();
		out.close();
	}
}
