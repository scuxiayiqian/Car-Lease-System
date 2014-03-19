package scu.sw.car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import scu.sw.jdbc.JDBC_Connection;

public class UpdateCarIsRenting {
	public void updateCarIsRenting(CarsVo carsVo){
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			//调用JDBC_Connection类的getConnection方法连接数据库
			conn = JDBC_Connection.getConnection();
			//添加数据的sql语句
			String sql = 
				"update cars set isrenting=? where id=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, carsVo.getIsrenting());
			pstm.setInt(2, carsVo.getId());
			
			pstm.executeUpdate();//提交pstm对象
			System.out.println("修改汽车出租状态 成功！");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(rs, conn, pstm);
		}
	}
}
