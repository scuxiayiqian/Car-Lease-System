package scu.sw.car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import scu.sw.jdbc.JDBC_Connection;

public class SearchRentPriceAndDeposit {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public List<Double> searchRentPriceAndDeposit(int id){	
		conn = JDBC_Connection.getConnection();
		List<Double> list = new ArrayList<Double>();
		
		try {
			pstmt = conn.prepareStatement("select * from cars where id = ?");
			pstmt.setInt(1, id);//…Ë÷√Ãıº˛id
			rs =pstmt.executeQuery();
			
			if(rs.next()) {
				list.add(rs.getDouble("rentprice"));
				list.add(rs.getDouble("deposit"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
