package scu.sw.checktable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import scu.sw.jdbc.JDBC_Connection;

public class AddCheckRecordFromJsp {
	public void addCheckRecord(CheckTableVo checkTableVo) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			// ����JDBC_Connection���getConnection�����������ݿ�
			conn = JDBC_Connection.getConnection();
			// ������ݵ�sql���
			String sql = "insert into checktable(checkid,checkdate,problem,paying,checkuserid,rentid,field) values(?,?,?,?,?,?,?)";
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, checkTableVo.getCheckid());
			pstm.setDate(2, checkTableVo.getCheckdate());
			pstm.setString(3, checkTableVo.getProblem());
			pstm.setDouble(4, checkTableVo.getPaying());
			pstm.setInt(5, checkTableVo.getCheckuserid());
			pstm.setInt(6, checkTableVo.getRentid());
			pstm.setString(7, "δ�޸�");
			
			pstm.executeUpdate();// �ύpstm����
			System.out.println("��ӳɹ�");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(rs, conn, pstm);
		}
	}
}
