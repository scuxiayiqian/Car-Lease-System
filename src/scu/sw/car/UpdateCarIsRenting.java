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
			//����JDBC_Connection���getConnection�����������ݿ�
			conn = JDBC_Connection.getConnection();
			//������ݵ�sql���
			String sql = 
				"update cars set isrenting=? where id=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, carsVo.getIsrenting());
			pstm.setInt(2, carsVo.getId());
			
			pstm.executeUpdate();//�ύpstm����
			System.out.println("�޸���������״̬ �ɹ���");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(rs, conn, pstm);
		}
	}
}
