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
		// 根据id修改的sql语句

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
			
			// 修改sql语句
			String sql = "update renttable set rentflag=?, rerumdate=? where id = ?";
			conn = JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement(sql);
			// 把值设置到修改的sql语句中
			pstmt.setInt(1, rentVo.getRentflag());
			pstmt.setDate(2, rerumdate);
			pstmt.setInt(3, rentVo.getId());
			
			pstmt.executeUpdate();// 将编号为id的出租单设为已归还
			System.out.println("入库出租单编号" + rentVo.getId() + "归还成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(null, conn, pstmt);
		}
	}
}
