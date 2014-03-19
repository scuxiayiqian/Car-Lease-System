package scu.sw.car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import scu.sw.jdbc.JDBC_Connection;

public class ShowCars {
	public List<CarsVo> showAllCars(){//分页查询方法
		ResultSet rs = null;
		PreparedStatement pstmt =null;
		Connection conn = null;
		List<CarsVo> list = new ArrayList<CarsVo>();
		try {
			conn = JDBC_Connection.getConnection();
			String sql = "select * from cars order by id desc";//分页查询的SQL语句，每页显示5条记录
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				CarsVo carsVo = new CarsVo();
				//	把各属性放入CarsVo对象中
				carsVo.setId(rs.getInt("id"));
				carsVo.setCarnumber(rs.getString("carnumber"));
				carsVo.setCartype(rs.getString("cartype"));
				carsVo.setColor(rs.getString("color"));
				carsVo.setPrice(rs.getDouble("price"));
				carsVo.setRentprice(rs.getDouble("rentprice"));
				carsVo.setDeposit(rs.getDouble("deposit"));
				carsVo.setIsrenting(rs.getInt("isrenting"));
				carsVo.setDescription(rs.getString("description"));
				
				list.add(carsVo);//把CarsVo对象放入集合中
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, pstmt);
		}
		return list;
	}

	public List<CarsVo> showCars(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<CarsVo> list = new ArrayList<CarsVo>();
		try {
			String sql = "select * from cars";//查询全部SQL语句
			conn = JDBC_Connection.getConnection();//连接数据库
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				CarsVo carsVo = new CarsVo();
				//把各属性放入CarsVo对象中
				carsVo.setId(rs.getInt("id"));
				carsVo.setCarnumber(rs.getString("carnumber"));
				carsVo.setCartype(rs.getString("cartype"));
				carsVo.setColor(rs.getString("color"));
				carsVo.setPrice(rs.getDouble("price"));
				carsVo.setRentprice(rs.getDouble("rentprice"));
				carsVo.setDeposit(rs.getDouble("deposit"));
				carsVo.setIsrenting(rs.getInt("isrenting"));
				carsVo.setDescription(rs.getString("description"));
				
				list.add(carsVo);//把CarsVo对象放入集合中
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, stmt);//关闭连接
		}
		return list;
	}
	/*
	public int maxpage(){//获取最大页数查询方法
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int count =0;//声明一个count变量，用于存储记录数
		int maxpage = 0;//声明一个maxpage变量，原来表示最大页数
		try {
			conn  = JDBC_Connection.getConnection();
			stmt = conn.createStatement();
			String sql ="select count(*) from cars";//查询总记录数的SQL语句
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(1);//如果结果集存在，记录数初始化值为1
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, stmt);
		}
		maxpage = (count+4)/5;//最大页数等于总记录条数加上4，再除以5
		return maxpage;
	}
	*/
}
