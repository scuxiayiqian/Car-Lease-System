package scu.sw.car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import scu.sw.jdbc.JDBC_Connection;

public class UpdateOneCar {
	public void updateOneCar(CarsVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 根据id修改的sql语句
		try {
			// 修改sql语句
			String sql = "update cars set carnumber=?, cartype=?, price=?, rentprice=?, deposit=?, description=? where id = ?";
			conn = JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement(sql);

			// 把值设置到修改的sql语句中
			pstmt.setString(1, vo.getCarnumber());
			pstmt.setString(2, vo.getCartype());
			pstmt.setDouble(3, vo.getPrice());
			pstmt.setDouble(4, vo.getRentprice());
			pstmt.setDouble(5, vo.getDeposit());
			pstmt.setString(6, vo.getDescription());
			pstmt.setInt(7, vo.getId());

			pstmt.executeUpdate();// 执行修改sql语句
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(null, conn, pstmt);
		}
	}
}
