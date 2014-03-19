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
			pstm.executeUpdate();// 提交pstm对象
			
			System.out.println("删除id为" + id + "的rent记录成功！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(rs, conn, pstm);
		}
	}
}
