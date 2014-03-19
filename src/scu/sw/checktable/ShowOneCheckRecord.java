package scu.sw.checktable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import scu.sw.jdbc.JDBC_Connection;

public class ShowOneCheckRecord {
	public CheckTableVo showOneCheckRecord(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CheckTableVo tablevo = new CheckTableVo();
		try {
			conn = JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement("select * from checktable where id=?");
			pstmt.setInt(1, id);// 设置条件id
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// 把各属性放入CarsVo对象中
				tablevo.setId(rs.getInt("id"));
				tablevo.setCheckid(rs.getString("checkid"));
				tablevo.setCheckdate(rs.getDate("checkdate"));
				tablevo.setProblem(rs.getString("problem"));
				tablevo.setPaying(rs.getDouble("paying"));
				tablevo.setCheckuserid(rs.getInt("checkuserid"));
				tablevo.setRentid(rs.getInt("rentid"));
				tablevo.setField(rs.getString("field"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(rs, conn, pstmt);// 关闭连接
		}
		return tablevo;
	}
}
