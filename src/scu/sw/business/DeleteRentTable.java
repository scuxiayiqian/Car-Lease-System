package scu.sw.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import scu.sw.jdbc.JDBC_Connection;

public class DeleteRentTable {
	public void deleteOneRentRecordById(int id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			conn = JDBC_Connection.getConnection();		
			String sql = "delete from renttable where id =?";
			pstm = conn.prepareStatement(sql);			
			pstm.setInt(1,id);	
			pstm.executeUpdate();// �ύpstm����
			
			System.out.println("ɾ��idΪ" + id + "��rent��¼�ɹ���");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(rs, conn, pstm);
		}
	}
}
