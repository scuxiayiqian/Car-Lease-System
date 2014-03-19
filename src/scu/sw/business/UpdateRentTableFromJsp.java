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
			// ����JDBC_Connection���getConnection�����������ݿ�
			conn = JDBC_Connection.getConnection();
			// ������ݵ�sql���
			String sql = "update renttable set price=?, begindate=? ,shouldretumdata=? where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setDouble(1, price);
			pstm.setDate(2, begindate);
			pstm.setDate(3, shouldretumdate);
			pstm.setInt(4, id);

			pstm.executeUpdate();// �ύpstm����
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(rs, conn, pstm);
		}
	}
}
