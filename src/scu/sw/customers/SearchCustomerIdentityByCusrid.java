package scu.sw.customers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import scu.sw.jdbc.JDBC_Connection;

public class SearchCustomerIdentityByCusrid {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public String searchCustomerIdentityByCusrid(int cusrid) {
		conn = JDBC_Connection.getConnection();
		String identity = null;
		try {
			pstmt = conn
					.prepareStatement("select * from customers where id = ?");
			pstmt.setInt(1, cusrid);// 设置条件id
			rs = pstmt.executeQuery();

			if (rs.next()) {
				identity = rs.getString("identity");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查询客户身份证 异常！");
			e.printStackTrace();
		}
		return identity;
	}
}
