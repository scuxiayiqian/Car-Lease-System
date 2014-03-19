package scu.sw.customers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import scu.sw.jdbc.JDBC_Connection;

public class UpdateOneCustomer {
	public void updateCustomer(customersVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 根据id修改的sql语句
		try {
			// 修改sql语句
			String sql = "update customers set custname=?, address=? ,phone=?, career=? where id = ?";
			conn = JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement(sql);

			// 把值设置到修改的sql语句中
			pstmt.setString(1, vo.getCustname());
			pstmt.setString(2, vo.getAddress());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getCareer());
			pstmt.setInt(5, vo.getId());
			
			pstmt.executeUpdate();// 执行修改sql语句
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(null, conn, pstmt);
		}
	}
}
