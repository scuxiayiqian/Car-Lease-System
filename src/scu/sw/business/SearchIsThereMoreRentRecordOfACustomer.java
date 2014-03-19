package scu.sw.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import scu.sw.jdbc.JDBC_Connection;

public class SearchIsThereMoreRentRecordOfACustomer {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public List<RentTablesVo> searchIsThereMoreRentRecordOfACustomer(int cusrid){
		conn = JDBC_Connection.getConnection();
		RentTablesVo tablevo = null;
		List<RentTablesVo> list = new ArrayList<RentTablesVo>();
		try {
			pstmt = conn.prepareStatement("select * from renttable where cusrid=? and rentflag=?");
			pstmt.setInt(1, cusrid);//…Ë÷√Ãıº˛id
			pstmt.setInt(2, 1);
			rs =pstmt.executeQuery();
			
			while(rs.next()) {
				tablevo = new RentTablesVo();
				tablevo.setId(rs.getInt("id"));
				tablevo.setTableid(rs.getString("tableid"));
				tablevo.setShouldpayprice(rs.getDouble("shouldpayprice"));
				tablevo.setPrice(rs.getDouble("price"));
				tablevo.setShouldretumdate(rs.getDate("shouldretumdata"));
				tablevo.setCusrid(rs.getInt("cusrid"));
				tablevo.setCarsid(rs.getInt("carsid"));
				tablevo.setUserid(rs.getInt("userid"));
				
				list.add(tablevo);
				tablevo = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, pstmt);
		}
		return list;
	}
}
