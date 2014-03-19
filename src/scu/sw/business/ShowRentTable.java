package scu.sw.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import scu.sw.jdbc.JDBC_Connection;

public class ShowRentTable {
	public RentTablesVo showRentTable(int rentid) {
		RentTablesVo rentvo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = JDBC_Connection.getConnection();
			
			// 修改sql语句
			String sql = "select * from renttable where id = ?";	
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rentid);		
			rs = pstmt.executeQuery();// 将编号为id的出租单设为已归还
			
			if(rs.next()) {
				rentvo = new RentTablesVo();
				
				rentvo.setId(rs.getInt("id"));
				rentvo.setTableid(rs.getString("tableid"));
				rentvo.setImprest(rs.getDouble("imprest"));
				rentvo.setShouldpayprice(rs.getDouble("shouldpayprice"));
				rentvo.setPrice(rs.getDouble("price"));
				rentvo.setBegindate(rs.getDate("begindate"));
				rentvo.setShouldretumdate(rs.getDate("shouldretumdata"));
				rentvo.setRentflag(rs.getInt("rentflag"));
				rentvo.setCusrid(rs.getInt("cusrid"));
				rentvo.setCarsid(rs.getInt("carsid"));
				rentvo.setUserid(rs.getInt("userid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(null, conn, pstmt);
		}
		return rentvo;
	}
	
}
