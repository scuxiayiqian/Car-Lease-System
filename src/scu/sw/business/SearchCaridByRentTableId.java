package scu.sw.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import scu.sw.jdbc.JDBC_Connection;

public class SearchCaridByRentTableId {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public int searchCaridByRentId(int id){
		conn = JDBC_Connection.getConnection();
		int carid = -1;
		try {
			pstmt = conn.prepareStatement("select * from renttable where id = ?");
			pstmt.setInt(1, id);//…Ë÷√Ãıº˛id
			rs =pstmt.executeQuery();
			
			if(rs.next()) {
				carid = rs.getInt("carsid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, pstmt);
		}
		return carid;
	}
}
