package scu.sw.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import scu.sw.jdbc.JDBC_Connection;

public class ShowOneUser {
	public UsersVo showOneUser(int id) {
		UsersVo uservo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = JDBC_Connection.getConnection();
			
			// 修改sql语句
			String sql = "select * from users where id = ?";	
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);		
			rs = pstmt.executeQuery();// 将编号为id的出租单设为已归还
			
			if(rs.next()) {
				uservo = new UsersVo();
				
				uservo.setId(rs.getInt("id"));
				uservo.setFullname(rs.getString("fullname"));
				uservo.setPosition(rs.getString("position"));
				uservo.setPhone(rs.getString("phone"));
				uservo.setAddress(rs.getString("address"));
				uservo.setSex(rs.getInt("sex"));
				
				uservo.setIdentity(rs.getString("identity"));
				uservo.setUsername(rs.getString("username"));
				uservo.setUserlevel(rs.getString("userlevel"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(null, conn, pstmt);
		}
		return uservo;
	}
}
