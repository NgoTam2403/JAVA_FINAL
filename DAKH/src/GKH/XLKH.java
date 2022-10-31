package GKH;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class XLKH implements IKhachhang{
	
	Connection conn=null;
	@Override
	public void getCon() throws SQLException {
		// TODO Auto-generated method stub
		  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dlkh", "root", "24032002");
		  if(conn!=null) {
			  System.out.println("ket noi ok");
		  }
		
	}
	 public ResultSet getData() throws SQLException {
		 String query="select *from tbKhachhang";
		 PreparedStatement stm = conn.prepareStatement(query);
		 
		return stm.executeQuery(query);//tra ve
		
	 }
	 public ResultSet getDiaChi() throws SQLException{
		 String query ="select distinct Diachi  from tbKhachhang";
		 PreparedStatement stm = conn.prepareStatement(query);
		return stm.executeQuery(query);
 
	 }
	 

	 
	@Override
	public int delKH(String DiaChi, String GioiTinh) throws SQLException {
		String query="delete from tbKhachhang where DiaChi ='"+DiaChi +"' and GT='"+GioiTinh+"'";
		System.out.println(query);
		PreparedStatement stm =conn.prepareStatement(query);
		int rowaffect = stm.executeUpdate(query);
		// TODO Auto-generated method stub
		return rowaffect;
	} 
	
	
}
