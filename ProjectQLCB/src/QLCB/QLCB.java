package QLCB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QLCB implements ICanBo {

	public Connection conn;
	
	@Override
	public void getCon() throws SQLException {
		// TODO Auto-generated method stub
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlcb","root","24032002");
		System.out.println("ok");
	}

	@Override
	public int insertCB(CanBo a) throws SQLException {
		String query = "insert into tbCanBo values("+ a.getSoTK()+",'"+a.getHoTen()+"','"+a.getGT()+"','"+a.getDiaChi()+"',"+a.getLuong() +")";
		System.out.println(query);
		Statement stm = conn.prepareStatement(query);
		int rowaffect = stm.executeUpdate(query);
		
		// TODO Auto-generated method stub
		return rowaffect;
	}
	public ResultSet getData() throws SQLException {
		String query="select *from tbCanBo";
		Statement stm = conn.prepareStatement(query);
		ResultSet data = stm.executeQuery(query);
		return data;
		
	}

}
