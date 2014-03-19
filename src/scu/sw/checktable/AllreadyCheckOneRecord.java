package scu.sw.checktable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import scu.sw.jdbc.JDBC_Connection;

public class AllreadyCheckOneRecord {
	public void allreadyCheckOneRecord(int id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			conn = JDBC_Connection.getConnection();
			// 添加数据的sql语句
			String sql = "update checktable set field=? where id=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "已修复");
			pstm.setInt(2, id);
			pstm.executeUpdate();// 提交pstm对象
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(rs, conn, pstm);// 关闭连接
		}
	}
}
