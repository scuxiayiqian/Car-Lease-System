package scu.sw.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import scu.sw.jdbc.JDBC_Connection;

/*
 * 新建renttable记录
 */
public class RentCar {
	public void rentCar(RentTablesVo rentableVo) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			// 调用JDBC_Connection类的getConnection方法连接数据库
			conn = JDBC_Connection.getConnection();
			// 添加数据的sql语句
			String sql = "insert into renttable(tableid,imprest,shouldpayprice,price,begindate,shouldretumdata,rentflag,cusrid,carsid,userid) values(?,?,?,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, rentableVo.getTableid());
			pstm.setDouble(2, rentableVo.getImprest());
			pstm.setDouble(3, rentableVo.getShouldpayprice());
			pstm.setDouble(4, rentableVo.getPrice());
			pstm.setDate(5, rentableVo.getBegindate());
			pstm.setDate(6, rentableVo.getShouldretumdate());
			pstm.setInt(7, rentableVo.getRentflag());
			pstm.setInt(8, rentableVo.getCusrid());
			pstm.setInt(9, rentableVo.getCarsid());
			pstm.setInt(10, rentableVo.getUserid());
			
			pstm.executeUpdate();// 提交pstm对象
			System.out.println("添加rent_table成功！");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(rs, conn, pstm);
		}
	}
}
