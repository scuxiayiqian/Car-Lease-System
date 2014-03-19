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
	public List<CarsVo> showAllCars(){//��ҳ��ѯ����
		ResultSet rs = null;
		PreparedStatement pstmt =null;
		Connection conn = null;
		List<CarsVo> list = new ArrayList<CarsVo>();
		try {
			conn = JDBC_Connection.getConnection();
			String sql = "select * from cars order by id desc";//��ҳ��ѯ��SQL��䣬ÿҳ��ʾ5����¼
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				CarsVo carsVo = new CarsVo();
				//	�Ѹ����Է���CarsVo������
				carsVo.setId(rs.getInt("id"));
				carsVo.setCarnumber(rs.getString("carnumber"));
				carsVo.setCartype(rs.getString("cartype"));
				carsVo.setColor(rs.getString("color"));
				carsVo.setPrice(rs.getDouble("price"));
				carsVo.setRentprice(rs.getDouble("rentprice"));
				carsVo.setDeposit(rs.getDouble("deposit"));
				carsVo.setIsrenting(rs.getInt("isrenting"));
				carsVo.setDescription(rs.getString("description"));
				
				list.add(carsVo);//��CarsVo������뼯����
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
			String sql = "select * from cars";//��ѯȫ��SQL���
			conn = JDBC_Connection.getConnection();//�������ݿ�
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				CarsVo carsVo = new CarsVo();
				//�Ѹ����Է���CarsVo������
				carsVo.setId(rs.getInt("id"));
				carsVo.setCarnumber(rs.getString("carnumber"));
				carsVo.setCartype(rs.getString("cartype"));
				carsVo.setColor(rs.getString("color"));
				carsVo.setPrice(rs.getDouble("price"));
				carsVo.setRentprice(rs.getDouble("rentprice"));
				carsVo.setDeposit(rs.getDouble("deposit"));
				carsVo.setIsrenting(rs.getInt("isrenting"));
				carsVo.setDescription(rs.getString("description"));
				
				list.add(carsVo);//��CarsVo������뼯����
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, stmt);//�ر�����
		}
		return list;
	}
	/*
	public int maxpage(){//��ȡ���ҳ����ѯ����
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int count =0;//����һ��count���������ڴ洢��¼��
		int maxpage = 0;//����һ��maxpage������ԭ����ʾ���ҳ��
		try {
			conn  = JDBC_Connection.getConnection();
			stmt = conn.createStatement();
			String sql ="select count(*) from cars";//��ѯ�ܼ�¼����SQL���
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(1);//�����������ڣ���¼����ʼ��ֵΪ1
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, stmt);
		}
		maxpage = (count+4)/5;//���ҳ�������ܼ�¼��������4���ٳ���5
		return maxpage;
	}
	*/
}
