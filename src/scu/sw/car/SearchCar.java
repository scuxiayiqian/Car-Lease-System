package scu.sw.car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import scu.sw.jdbc.JDBC_Connection;

public class SearchCar {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int searchCar(int id){
		conn = JDBC_Connection.getConnection();
		int carid = -1;
		
		try {
			pstmt = conn.prepareStatement("select * from cars where id = ?");
			pstmt.setInt(1, id);//设置条件id
			rs =pstmt.executeQuery();
			
			if(rs.next()){
				carid = rs.getInt("id");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查询客户身份证 异常！");
			e.printStackTrace();
		}	
		return carid;
	}
	
	public int searchIsRenting(int id){
		conn = JDBC_Connection.getConnection();
		int isrenting = -1;
		
		try {
			pstmt = conn.prepareStatement("select * from cars where id = ?");
			pstmt.setInt(1, id);//设置条件id
			rs =pstmt.executeQuery();
			
			if(rs.next()){
				isrenting = rs.getInt("isrenting");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查询客户身份证 异常！");
			e.printStackTrace();
		}	
		return isrenting;
	}
}