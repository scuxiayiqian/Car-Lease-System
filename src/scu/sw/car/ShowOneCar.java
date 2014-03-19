package scu.sw.car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import scu.sw.jdbc.JDBC_Connection;

public class ShowOneCar {
	
	public CarsVo showOneCar(int id) {
		CarsVo carsVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = JDBC_Connection.getConnection();

			// 修改sql语句
			String sql = "select * from cars where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();// 将编号为id的出租单设为已归还

			if (rs.next()) {
				carsVo = new CarsVo();

				carsVo.setId(rs.getInt("id"));
				carsVo.setCarnumber(rs.getString("carnumber"));
				carsVo.setCartype(rs.getString("cartype"));
				carsVo.setColor(rs.getString("color"));
				carsVo.setPrice(rs.getDouble("price"));
				carsVo.setRentprice(rs.getDouble("rentprice"));
				carsVo.setDeposit(rs.getDouble("deposit"));
				carsVo.setIsrenting(rs.getInt("isrenting"));
				carsVo.setDescription(rs.getString("description"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(null, conn, pstmt);
		}
		return carsVo;
	}
}
