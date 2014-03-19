package scu.sw.car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import scu.sw.jdbc.JDBC_Connection;

public class AddCar {

	public void addCar(CarsVo carsVo){
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			//����JDBC_Connection���getConnection�����������ݿ�
			conn = JDBC_Connection.getConnection();
			//������ݵ�sql���
			String sql = 
				"insert into cars(carnumber,cartype,color,price,rentprice,deposit,isrenting,description) values(?,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, carsVo.getCarnumber());
			pstm.setString(2, carsVo.getCartype());
			pstm.setString(3, carsVo.getColor());
			pstm.setDouble(4, carsVo.getPrice());
			pstm.setDouble(5, carsVo.getRentprice());
			pstm.setDouble(6, carsVo.getDeposit());
			pstm.setInt(7, carsVo.getIsrenting());
			pstm.setString(8, carsVo.getDescription());
			pstm.executeUpdate();//�ύpstm����
			System.out.println("��ӳɹ�����ӵ��������£�");
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(rs, conn, pstm);
		}
	}

}
