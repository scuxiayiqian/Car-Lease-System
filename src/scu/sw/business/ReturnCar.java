package scu.sw.business;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import scu.sw.jdbc.JDBC_Connection;

public class ReturnCar {
	public void updateRenttable(RentTablesVo rentVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// ����id�޸ĵ�sql���

		try {
			SimpleDateFormat returndate = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date utilrerumdate = null;
			try {
				utilrerumdate= returndate.parse(returndate.format(new java.util.Date()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Date rerumdate = new Date(utilrerumdate.getTime());
			
			// �޸�sql���
			String sql = "update renttable set rentflag=?, rerumdate=? where id = ?";
			conn = JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement(sql);
			// ��ֵ���õ��޸ĵ�sql�����
			pstmt.setInt(1, rentVo.getRentflag());
			pstmt.setDate(2, rerumdate);
			pstmt.setInt(3, rentVo.getId());
			
			pstmt.executeUpdate();// �����Ϊid�ĳ��ⵥ��Ϊ�ѹ黹
			System.out.println("�����ⵥ���" + rentVo.getId() + "�黹�ɹ���");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(null, conn, pstmt);
		}
	}
}
