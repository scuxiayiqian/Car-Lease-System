package scu.sw.customers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import scu.sw.jdbc.JDBC_Connection;

/*
 * �������֤�Ų��ҿͻ�id
 */
public class SearchCustomer {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public int searchCustomer(String identity) {
		conn = JDBC_Connection.getConnection();
		int curid = -1;
		try {
			pstmt = conn
					.prepareStatement("select * from customers where identity = ?");
			pstmt.setString(1, identity);// ��������id
			rs = pstmt.executeQuery();

			if (rs.next()) {
				curid = rs.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("��ѯ�ͻ����֤ �쳣��");
			e.printStackTrace();
		}
		return curid;
	}
}
