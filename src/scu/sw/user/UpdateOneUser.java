package scu.sw.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import scu.sw.jdbc.JDBC_Connection;
import scu.sw.user.UsersVo;

public class UpdateOneUser {
	public void updateUser(UsersVo usersVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// ����id�޸ĵ�sql���
		try {
			// �޸�sql���
			String sql = "update users set username=?, identity=? ,fullname=?, address=?, phone=?, position=? where id = ?";
			conn = JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement(sql);

			// ��ֵ���õ��޸ĵ�sql�����
			pstmt.setString(1, usersVo.getUsername());
			pstmt.setString(2, usersVo.getIdentity());
			pstmt.setString(3, usersVo.getFullname());
			pstmt.setString(4, usersVo.getAddress());
			pstmt.setString(5, usersVo.getPhone());
			pstmt.setString(6, usersVo.getPosition());
			pstmt.setInt(7, usersVo.getId());
			
			pstmt.executeUpdate();// ִ���޸�sql���
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(null, conn, pstmt);
		}
	}
}
