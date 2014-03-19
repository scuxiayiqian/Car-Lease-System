package scu.sw.customers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import scu.sw.jdbc.JDBC_Connection;

public class SearchCustomerIdByRentTalesId {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public int searchCustomerIdByRentTalesId(int rentid) {
		conn = JDBC_Connection.getConnection();
		int cusrid = -1;
		try {
			pstmt = conn
					.prepareStatement("select * from renttable where id = ?");
			pstmt.setInt(1, rentid);// 设置条件id
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cusrid = rs.getInt("cusrid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查询客户身份证 异常！");
			e.printStackTrace();
		}
		return cusrid;
	}
}
