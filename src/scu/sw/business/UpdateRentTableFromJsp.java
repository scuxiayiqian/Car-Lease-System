package scu.sw.business;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import scu.sw.customers.customersVo;
import scu.sw.jdbc.JDBC_Connection;

public class UpdateRentTableFromJsp {
	public void updateRentTableFromJsp(int id, double price, Date begindate,
			Date shouldretumdate) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			// 调用JDBC_Connection类的getConnection方法连接数据库
			conn = JDBC_Connection.getConnection();
			// 添加数据的sql语句
			String sql = "update renttable set price=?, begindate=? ,shouldretumdata=? where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setDouble(1, price);
			pstm.setDate(2, begindate);
			pstm.setDate(3, shouldretumdate);
			pstm.setInt(4, id);

			pstm.executeUpdate();// 提交pstm对象
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(rs, conn, pstm);
		}
	}
}
