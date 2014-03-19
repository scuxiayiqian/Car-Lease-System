package scu.sw.customers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import scu.sw.jdbc.JDBC_Connection;

public class ShowOneCustomer {
	public customersVo showOneCustomer(int id) {
		customersVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = JDBC_Connection.getConnection();
			
			// 修改sql语句
			String sql = "select * from customers where id = ?";	
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);		
			rs = pstmt.executeQuery();// 将编号为id的出租单设为已归还
			
			if(rs.next()) {
				vo = new customersVo();
				
				vo.setId(rs.getInt("id"));
				vo.setIdentity(rs.getString("identity"));
				vo.setSex(rs.getInt("sex"));
				vo.setCustname(rs.getString("custname"));
				vo.setAddress(rs.getString("address"));
				vo.setPhone(rs.getString("phone"));
				vo.setCareer(rs.getString("career"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(null, conn, pstmt);
		}
		return vo;
	}
}
