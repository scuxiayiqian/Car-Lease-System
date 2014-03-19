package scu.sw.checktable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import scu.sw.car.CarsVo;
import scu.sw.jdbc.JDBC_Connection;

public class ShowAllCheckRecord {
	
	public List<CheckTableVo> showAllCheckRecord() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CheckTableVo> list = new ArrayList<CheckTableVo>();
		try {
			conn = JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement("select * from checktable where field=?");
			pstmt.setString(1, "δ�޸�");//��������id
			rs =pstmt.executeQuery();
			
			while (rs.next()) {
				CheckTableVo tablevo = new CheckTableVo();
				// �Ѹ����Է���CarsVo������
				tablevo.setId(rs.getInt("id"));
				tablevo.setCheckid(rs.getString("checkid"));
				tablevo.setCheckdate(rs.getDate("checkdate"));
				tablevo.setProblem(rs.getString("problem"));
				tablevo.setPaying(rs.getDouble("paying"));
				tablevo.setCheckuserid(rs.getInt("checkuserid"));
				tablevo.setRentid(rs.getInt("rentid"));
				
				list.add(tablevo);// ��CarsVo������뼯����
				tablevo = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(rs, conn, pstmt);// �ر�����
		}
		return list;
	}
}
