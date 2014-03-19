package scu.sw.customers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import scu.sw.jdbc.JDBC_Connection;

public class UpdateOneCustomer {
	public void updateCustomer(customersVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// ����id�޸ĵ�sql���
		try {
			// �޸�sql���
			String sql = "update customers set custname=?, address=? ,phone=?, career=? where id = ?";
			conn = JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement(sql);

			// ��ֵ���õ��޸ĵ�sql�����
			pstmt.setString(1, vo.getCustname());
			pstmt.setString(2, vo.getAddress());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getCareer());
			pstmt.setInt(5, vo.getId());
			
			pstmt.executeUpdate();// ִ���޸�sql���
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(null, conn, pstmt);
		}
	}
}
